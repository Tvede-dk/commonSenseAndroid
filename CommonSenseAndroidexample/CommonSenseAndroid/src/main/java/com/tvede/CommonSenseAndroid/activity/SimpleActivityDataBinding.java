package com.tvede.CommonSenseAndroid.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;

/**
 * Created by kasper on 21-08-2016.
 */

public abstract class SimpleActivityDataBinding<T extends ViewDataBinding> extends SimpleActivity {

    @LayoutRes
    public abstract int getLayout();

    /**
     * iff the binding could not be valid, after creation, this is called as a hook point for the main application to provide a fallback.
     * iff logging is configured, then it will be logged in details about this invalid state.
     */
    public abstract void onInitializationFailed();

    @Nullable
    private T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayout());
        if (binding != null) {
            onActivityReady(binding);
        } else {
            onInitializationFailed();
        }
    }

    @MainThread
    protected abstract void onActivityReady(T dataBinding);

    @Nullable
    @MainThread
    public T getBinding() {
        return binding;
    }
}
