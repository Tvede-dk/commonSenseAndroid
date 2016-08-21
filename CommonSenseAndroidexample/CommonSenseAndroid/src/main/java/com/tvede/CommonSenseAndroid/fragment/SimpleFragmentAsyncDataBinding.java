package com.tvede.CommonSenseAndroid.fragment;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by kasper on 21-08-2016.
 */

public abstract class SimpleFragmentAsyncDataBinding<T extends ViewDataBinding, D> extends SimpleFragmentDataBinding<T> {


    public abstract boolean validateData(@NonNull D data);

    public abstract void onReloadViewFromData(@NonNull D data);

    public abstract void onNullData();

    public void handleData(@Nullable D data) {
        if (data == null) {
            onNullData();
        } else {

        }
    }
}
