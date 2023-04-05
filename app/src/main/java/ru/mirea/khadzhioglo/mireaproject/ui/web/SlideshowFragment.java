package ru.mirea.khadzhioglo.mireaproject.ui.web;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.khadzhioglo.mireaproject.R;
import ru.mirea.khadzhioglo.mireaproject.databinding.FragmentWebBinding;

public class SlideshowFragment extends Fragment {

    private FragmentWebBinding binding;
    public WebView webView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_web, container, false);
        webView = (WebView)v.findViewById(R.id.web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/");

        binding = FragmentWebBinding.inflate(inflater, container, false);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


//    SlideshowViewModel slideshowViewModel =
//            new ViewModelProvider(this).get(SlideshowViewModel.class);
//
//        binding = FragmentWebBinding.inflate(inflater, container, false);
//                View root = binding.getRoot();
//
//final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;