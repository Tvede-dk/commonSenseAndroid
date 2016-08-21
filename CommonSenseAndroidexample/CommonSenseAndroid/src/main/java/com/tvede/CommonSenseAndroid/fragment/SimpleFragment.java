package com.tvede.CommonSenseAndroid.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by kasper on 21-08-2016.
 */

public class SimpleFragment extends Fragment {

    public boolean isUiAccessible() {
        return isAdded() && getContext() != null;
    }
}
