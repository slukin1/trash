package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;

public class ObjectIdMapper {
    private SparseArray<Object> mIdToObjectMap = new SparseArray<>();
    private int mNextId = 1;
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    public final Object mSync = new Object();

    public void clear() {
        SparseArray<Object> sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray<>();
        }
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            onUnmapped(sparseArray.valueAt(i11), sparseArray.keyAt(i11));
        }
    }

    public boolean containsId(int i11) {
        boolean z11;
        synchronized (this.mSync) {
            z11 = this.mIdToObjectMap.get(i11) != null;
        }
        return z11;
    }

    public boolean containsObject(Object obj) {
        boolean containsKey;
        synchronized (this.mSync) {
            containsKey = this.mObjectToIdMap.containsKey(obj);
        }
        return containsKey;
    }

    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    public Object getObjectForId(int i11) {
        Object obj;
        synchronized (this.mSync) {
            obj = this.mIdToObjectMap.get(i11);
        }
        return obj;
    }

    public void onMapped(Object obj, int i11) {
    }

    public void onUnmapped(Object obj, int i11) {
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            Integer num = this.mObjectToIdMap.get(obj);
            if (num != null) {
                int intValue = num.intValue();
                return intValue;
            }
            int i11 = this.mNextId;
            this.mNextId = i11 + 1;
            Integer valueOf = Integer.valueOf(i11);
            this.mObjectToIdMap.put(obj, valueOf);
            this.mIdToObjectMap.put(valueOf.intValue(), obj);
            onMapped(obj, valueOf.intValue());
            return valueOf.intValue();
        }
    }

    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            Integer remove = this.mObjectToIdMap.remove(obj);
            if (remove == null) {
                return null;
            }
            this.mIdToObjectMap.remove(remove.intValue());
            onUnmapped(obj, remove.intValue());
            return remove;
        }
    }

    public Object removeObjectById(int i11) {
        synchronized (this.mSync) {
            Object obj = this.mIdToObjectMap.get(i11);
            if (obj == null) {
                return null;
            }
            this.mIdToObjectMap.remove(i11);
            this.mObjectToIdMap.remove(obj);
            onUnmapped(obj, i11);
            return obj;
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }
}
