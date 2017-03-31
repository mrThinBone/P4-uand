package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ViewGroup mProgressView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mProgressView = (ViewGroup) root.findViewById(R.id.progress_view);

        return root;
    }

    void showLoadingProgress() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    void dismissLoadingProgress() {
        mProgressView.setVisibility(View.GONE);
    }
}
