package ru.mirea.khadzhioglo.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.mirea.khadzhioglo.musicplayer.databinding.FragmentMusicBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Music#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Music extends Fragment {


    private FragmentMusicBinding binding;

    private boolean play = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Music() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Music.
     */
    // TODO: Rename and change types and number of parameters
    public static Music newInstance(String param1, String param2) {
        Music fragment = new Music();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMusicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (play == false) {
                    play = true;
                    binding.imageView.setImageResource(R.drawable._6cc95e3e957cb78a2a1ba70db277536_1000x1000x1);
                    binding.song.setText("LetMeDownSlowly");
                    binding.btnPlay.setImageResource(com.google.android.material.R.drawable.btn_radio_off_mtrl);
                    Intent serviceIntent = new Intent(getActivity(), PlayerService.class);
                    ContextCompat.startForegroundService(getActivity(), serviceIntent);
                }
                else {
                    binding.imageView.setImageResource(R.color.black);
                    binding.song.setText("Song");
                    getActivity().stopService(new Intent(getActivity(), PlayerService.class));
                    binding.btnPlay.setImageResource(com.google.android.material.R.drawable.btn_radio_on_mtrl);
                    play = false;
                }
            }
        });

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return root;
    }
}