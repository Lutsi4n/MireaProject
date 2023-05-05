package ru.mirea.khadzhioglo.mireaproject.ui.files;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import java.io.IOException;
import java.security.GeneralSecurityException;

import ru.mirea.khadzhioglo.mireaproject.R;
import ru.mirea.khadzhioglo.mireaproject.databinding.FragmentFilesBinding;
import ru.mirea.khadzhioglo.mireaproject.ui.home.HomeViewModel;

public class FilesFragment extends Fragment {

    private FragmentFilesBinding binding;
    private EditText text;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentFilesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnfloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySimpleDialog();
            }
        });

        return root;
    }

    private void mySimpleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Закодировать это??");
        builder.setPositiveButton("YES!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences secureSharedPreferences;
                KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
                try {
                    String mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);
                    secureSharedPreferences = EncryptedSharedPreferences.create(
                            "secret_shared_prefs",
                            mainKeyAlias,
                            getActivity().getBaseContext(),
                            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                    );
                    secureSharedPreferences.edit().putString("secure", binding.getText.getText().toString());
                } catch (GeneralSecurityException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

