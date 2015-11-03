package com.example.FlyingDog.ui.fragments;

import android.app.Activity;
import com.example.FlyingDog.network.RequestManager;
import com.tiksem.media.data.Audio;
import com.utils.framework.collections.NavigationList;
import com.utilsframework.android.fragments.Fragments;

import java.util.List;

/**
 * Created by stykhonenko on 03.11.15.
 */
public class SongsOfTagFragment extends SongsOfFragment {
    private static final String TAG = "TAG";

    private String tag;

    public static SongsOfTagFragment create(String tag) {
        return Fragments.createFragmentWith1Arg(new SongsOfTagFragment(), TAG, tag);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        tag = getArguments().getString(TAG);
    }

    @Override
    protected List<Audio> getLocalSongs() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected NavigationList<Audio> getAudiosFromInternet(String filter, RequestManager requestManager) {
        return requestManager.getSongsByTag(tag);
    }

    @Override
    protected boolean alwaysUseNavigationList() {
        return true;
    }
}
