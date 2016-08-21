package com.tvede.CommonSenseAndroid.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kasper on 21-08-2016.
 */

public abstract class SimpleFragmentDataBinding<T extends ViewDataBinding> extends SimpleFragment {

    @Nullable
    private T binding;

    @LayoutRes
    public abstract int getLayout();

    @Nullable
    public T getBinding() {
        return binding;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        return binding != null ? binding.getRoot() : null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (binding != null) {
            onFragmentReady(binding);
        } else {
            onInitializationFailed();
        }
    }

    protected abstract void onInitializationFailed();

    protected abstract void onFragmentReady(@NonNull T binding);
}
