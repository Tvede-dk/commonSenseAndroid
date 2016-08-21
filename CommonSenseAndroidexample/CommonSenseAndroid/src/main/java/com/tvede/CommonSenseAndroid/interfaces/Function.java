package com.tvede.CommonSenseAndroid.interfaces;

import android.support.annotation.NonNull;

/**
 * Created by kasper on 21-08-2016.
 */

public interface Function<In, Out> {
    @NonNull
    Out perform(@NonNull In input);
}
