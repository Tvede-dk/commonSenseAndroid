package com.tvede.CommonSenseAndroid.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kasper on 21-08-2016.
 */

public class NonNullHashMap<K, V> extends HashMap<K, V> {

    public NonNullHashMap(Map<? extends K, ? extends V> m) {
        super(m);
    }

    public NonNullHashMap() {
    }

    public NonNullHashMap(int initialCapacity) {
        super(initialCapacity);
    }

    public NonNullHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }
}
