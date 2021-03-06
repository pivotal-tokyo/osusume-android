package io.pivotal.beach.osusume.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import io.pivotal.beach.osusume.android.OsusumeApplication;
import io.pivotal.beach.osusume.android.api.OsusumeApiClient;

public class ApiFragment extends Fragment {
    @Inject
    protected OsusumeApiClient osusumeApiClient;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        ((OsusumeApplication) getActivity().getApplication()).getAppComponent().inject(this);
    }
}