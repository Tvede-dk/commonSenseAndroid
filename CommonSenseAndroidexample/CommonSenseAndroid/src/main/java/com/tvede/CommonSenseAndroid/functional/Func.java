package com.tvede.CommonSenseAndroid.functional;

import android.support.annotation.NonNull;

import com.tvede.CommonSenseAndroid.datastructures.NonNullArrayList;
import com.tvede.CommonSenseAndroid.interfaces.Action;
import com.tvede.CommonSenseAndroid.interfaces.Function;
import com.tvede.CommonSenseAndroid.interfaces.Function2;

import java.util.Collection;

/**
 * Created by kasper on 21-08-2016.
 */

public class Func {

    /**
     * @param collection
     * @param action
     * @param <E>
     */
    public static <E> void flatForeach(@NonNull Collection<E> collection, @NonNull Action<E> action) {
        for (E e : collection) {
            if (e != null) {
                action.perform(e);
            }
        }
    }

    @NonNull
    public static <E, R> R flatAggregate(@NonNull Collection<E> collection, @NonNull Function<E, R> action, @NonNull Function2<R, R, R> aggregator, @NonNull R defaultValue) {
        R result = defaultValue;
        for (E e : collection) {
            if (e != null) {
                R newR = action.perform(e);
                result = aggregator.perform(result, newR);
            }
        }
        return result;
    }

    /**
     * @param collection
     * @param mapper
     * @param <E>
     * @param <R>
     */
    @NonNull
    public static <E, R> NonNullArrayList<R> flatMap(@NonNull Collection<E> collection, @NonNull Function<E, R> mapper) {
        final NonNullArrayList<R> result = new NonNullArrayList<>(collection.size());
        flatForeach(collection, x -> result.add(mapper.perform(x)));
        return result;
    }

}
