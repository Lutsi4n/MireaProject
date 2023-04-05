package ru.mirea.khadzhioglo.mireaproject.ui.data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.mirea.khadzhioglo.mireaproject.R;
import ru.mirea.khadzhioglo.mireaproject.databinding.FragmentDatafragmentBinding;

public class GalleryFragment extends Fragment {

    private FragmentDatafragmentBinding binding;
    private Button btndota;
    private TextView tvember;
    private TextView tvwr;
    private TextView tvwk;
    private TextView tvweaver;
    private TextView tvstorm;
    private TextView tvbane;
    private TextView tvmorph;
    private TextView tvursa;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_datafragment, container, false);

        btndota = (Button)v.findViewById(R.id.btndota);
        tvember = (TextView)v.findViewById(R.id.tvember);
        tvmorph = (TextView)v.findViewById(R.id.tvmorph);
        tvursa = (TextView)v.findViewById(R.id.tvursa);
        tvbane = (TextView)v.findViewById(R.id.tvbane);
        tvwk = (TextView)v.findViewById(R.id.tvwk);
        tvwr = (TextView)v.findViewById(R.id.tvwr);
        tvweaver = (TextView)v.findViewById(R.id.tvweaver);
        tvstorm = (TextView)v.findViewById(R.id.tvstorm);

        binding = FragmentDatafragmentBinding.inflate(getLayoutInflater());

        View.OnClickListener onClickfuit = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvember.setText("EMBER SPIRIT");
                tvmorph.setText("MORPHLING");
                tvweaver.setText("WEAWER");
                tvwk.setText("WRAITH KING");
                tvwr.setText("WIND RANGER");
                tvbane.setText("BANE");
                tvstorm.setText("STORM SPIRIT");
                tvursa.setText("URSA");
            }
        };
        btndota.setOnClickListener(onClickfuit);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}




//    GalleryViewModel galleryViewModel =
//            new ViewModelProvider(this).get(GalleryViewModel.class);
//
//        binding = FragmentDatafragmentBinding.inflate(inflater, container, false);
//                View root = binding.getRoot();
//
//final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;