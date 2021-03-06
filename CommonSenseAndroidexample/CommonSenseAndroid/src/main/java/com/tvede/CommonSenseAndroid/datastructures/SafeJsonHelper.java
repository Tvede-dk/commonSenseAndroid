package com.tvede.CommonSenseAndroid.datastructures;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.tvede.CommonSenseAndroid.interfaces.Action;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Map;

/**
 * Created by kasper on 21-08-2016.
 */

public class SafeJsonHelper extends JSONObject {


    //<editor-fold desc="error handling">
    @Nullable
    private Action<JSONException> onError;

    @Nullable
    public Action<JSONException> getOnError() {
        return onError;
    }

    public void setOnError(@NonNull Action<JSONException> onError) {
        this.onError = onError;
    }

    public void removeOnErrorHandler() {
        this.onError = null;
    }


    private void handleError(@NonNull JSONException e) {
        if (onError != null) {
            onError.perform(e);
        }
    }


    //</editor-fold>

    //<editor-fold desc="Constructors">
    public SafeJsonHelper() {
        super();
    }

    public SafeJsonHelper(@NonNull Map copyFrom) {
        super(copyFrom);
    }

    public SafeJsonHelper(@NonNull JSONTokener readFrom) throws JSONException {
        super(readFrom);
    }

    public SafeJsonHelper(@NonNull String json) throws JSONException {
        super(json);
    }

    public SafeJsonHelper(@NonNull JSONObject copyFrom, String[] names) throws JSONException {
        super(copyFrom, names);
    }
    //</editor-fold>

    @Override
    public JSONObject put(@NonNull String name, boolean value) {
        try {
            super.put(name, value);
        } catch (JSONException e) {
            handleError(e);
        }
        return this;
    }

    @Override
    public JSONObject put(@NonNull String name, double value) {
        try {
            super.put(name, value);
        } catch (JSONException e) {
            handleError(e);
        }
        return this;
    }

    @Override
    public JSONObject put(@NonNull String name, int value) {
        try {
            super.put(name, value);
        } catch (JSONException e) {
            handleError(e);
        }
        return this;
    }

    @Override
    public JSONObject put(@NonNull String name, long value) {
        try {
            super.put(name, value);
        } catch (JSONException e) {
            handleError(e);
        }
        return this;
    }

    @Override
    public JSONObject put(@NonNull String name, @Nullable Object value) {
        if (value == null) {
            return this;
        }
        try {
            super.put(name, value);
        } catch (JSONException e) {
            handleError(e);
        }
        return this;
    }

    @Override
    public JSONObject putOpt(@NonNull String name, @Nullable Object value) {
        if (value == null) {
            return this;
        }
        try {
            super.putOpt(name, value);
        } catch (JSONException e) {
            handleError(e);
        }
        return this;
    }
}
