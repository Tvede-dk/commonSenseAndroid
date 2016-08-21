package com.tvede.CommonSenseAndroid.interfaces;

import android.support.annotation.NonNull;

/**
 * Created by kasper on 21-08-2016.
 */

public interface Function2<In, In2,  Out> {
    @NonNull
    Out perform(@NonNull In input1,@NonNull In2 input2);
}
