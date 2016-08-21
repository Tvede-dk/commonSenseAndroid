package com.tvede.CommonSenseAndroid.datastructures;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.tvede.CommonSenseAndroid.functional.Func;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kasper on 21-08-2016.
 */

public class NonNullArrayList<T> extends ArrayList<T> {

    public NonNullArrayList() {
    }

    public NonNullArrayList(@NonNull Collection<? extends T> c) {
        super(c.size());
        addAll(c);
    }

    public NonNullArrayList(int size) {
        super(size);
    }

    @Override
    public boolean contains(@Nullable Object o) {
        if (o == null) {
            return false;
        }
        return super.contains(o);
    }

    @Override
    public int indexOf(@Nullable Object o) {
        if (o == null) {
            return -1;
        }
        return super.indexOf(o);
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        if (o == null) {
            return -1;
        }
        return super.lastIndexOf(o);
    }

    @Override
    @NonNull
    public Object[] toArray() {
        return super.toArray();
    }

    @Override
    @NonNull
    public <T1> T1[] toArray(@Nullable T1[] a) {
        //noinspection SuspiciousToArrayCall
        return super.toArray(a);
    }

    @Nullable
    @Override
    public T set(int index, @Nullable T element) {
        if (element == null) {
            return null;
        }
        return super.set(index, element);
    }

    @Override
    public boolean add(@Nullable T t) {
        if (t == null) {
            return false;
        }
        return super.add(t);
    }

    @Override
    public void add(int index, @Nullable T element) {
        if (element == null) {
            return;
        }
        super.add(index, element);
    }

    @Override
    @NonNull
    public T remove(int index) {
        //noinspection ConstantConditions
        return super.remove(index);
    }

    public boolean removeObject(@Nullable T o) {
        if (o == null) {
            return false;
        }
        return super.remove(o);
    }

    @Override
    public boolean remove(@Nullable Object o) {
        if (o == null) {
            return false;
        }
        return super.remove(o);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends T> c) {
        boolean res = false;
        for (T t : c) {
            if (t != null) {
                res |= super.add(t);
            }
        }
        return res;
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends T> c) {
        final AtomicInteger counter = new AtomicInteger(index);
        Func.flatForeach(c, x -> add(counter.getAndIncrement(), x));
        return true;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> c) {
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> c) {
        return super.retainAll(c);
    }

    @NonNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @NonNull
    public NonNullArrayList<T> subListSafe(int fromIndex, int toIndex) {
        return new NonNullArrayList<>(super.subList(fromIndex, toIndex));
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> c) {
        return super.containsAll(c);
    }

    @Override
    @NonNull
    public T get(int index) {
        //noinspection ConstantConditions
        return super.get(index);
    }
}
