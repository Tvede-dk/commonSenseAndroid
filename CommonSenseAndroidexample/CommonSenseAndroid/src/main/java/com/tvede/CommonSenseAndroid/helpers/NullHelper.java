package com.tvede.CommonSenseAndroid.helpers;

import android.support.annotation.Nullable;

/**
 * Created by kasper on 21-08-2016.
 */

public class NullHelper {
    public static boolean isAnyNull(@Nullable Object o1){
        return o1 == null ;
    }
    public static boolean isAnyNull(@Nullable Object o1,@Nullable Object o2){
        return o1 == null || o2 == null;
    }
}
