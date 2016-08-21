package com.tvede.CommonSenseAndroid.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kasper on 21-08-2016.
 */

public class SimpleActivity extends AppCompatActivity {

    private boolean isUiAccessible = false;

    @MainThread
    @Nullable
    public <T extends View> T getViewById(@IdRes int toFind, @NonNull Class<T> expectedType) {
        View view = findViewById(toFind);
        if (view != null && view.getClass().isAssignableFrom(expectedType)) {
            //noinspection unchecked
            return (T) view;
        }
        return null;
    }

    @MainThread
    @Nullable
    public <T extends View> T getViewById(@IdRes int toFind) {
        View view = findViewById(toFind);
        if (view != null) {
            //noinspection unchecked
            return (T) view;
        }
        return null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        isUiAccessible = false;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isUiAccessible = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isUiAccessible = true;
    }

    /**
     * @return true if manipulationg the ui should be fine (no bad state / exceptions should be thrown).
     */
    @MainThread
    public boolean isUiAccessible() {
        return isUiAccessible;
    }
}
