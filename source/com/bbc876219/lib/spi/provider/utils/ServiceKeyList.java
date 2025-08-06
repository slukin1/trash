package com.bbc876219.lib.spi.provider.utils;

import androidx.annotation.Keep;
import com.bbc876219.lib.spi.provider.a;
import com.bbc876219.lib.zlog.Log;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Keep
public class ServiceKeyList {
    private static final String TAG = "ServiceKeyList";
    private static HashMap<String, List<a.C0696a>> serviceclasseshooklist = new HashMap<>();
    private static HashMap<Class<?>, List<a.C0696a>> serviceclasseslist = new HashMap<>();
    public int size = 30;

    public ServiceKeyList(int i11) {
        this.size = i11;
        if (serviceclasseslist == null) {
            serviceclasseslist = Maps.newHashMapWithExpectedSize(i11);
        }
        if (serviceclasseshooklist == null) {
            serviceclasseshooklist = Maps.newHashMapWithExpectedSize(100);
        }
    }

    public <T> boolean containsKey(Class<T> cls) {
        return serviceclasseslist.containsKey(cls);
    }

    public <T> List<a.C0696a> get(Class<T> cls) {
        return serviceclasseslist.get(cls);
    }

    public <T> void put(Class<T> cls, a.C0696a aVar) {
        if (serviceclasseslist.containsKey(cls)) {
            List list = serviceclasseslist.get(cls);
            if (!list.contains(aVar)) {
                list.add(aVar);
                serviceclasseslist.put(cls, list);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        serviceclasseslist.put(cls, arrayList);
    }

    public int size() {
        return serviceclasseslist.size() + serviceclasseshooklist.size();
    }

    public String toString() {
        return "ServiceKeyList{}" + serviceclasseslist;
    }

    public <T> boolean containsKey(String str) {
        Log.b(TAG, "containsKey() called with: key = [" + str + "]");
        return serviceclasseshooklist.containsKey(str);
    }

    public <T> List<a.C0696a> get(String str) {
        Log.b(TAG, "get() called with: key = [" + str + "]");
        return serviceclasseshooklist.get(str);
    }

    public <T> void put(String str, a.C0696a aVar) {
        if (serviceclasseshooklist.containsKey(str)) {
            List list = serviceclasseshooklist.get(str);
            if (!list.contains(aVar)) {
                list.add(aVar);
                serviceclasseshooklist.put(str, list);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        serviceclasseshooklist.put(str, arrayList);
    }
}
