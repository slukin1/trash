package org.aspectj.lang.reflect;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class AjTypeSystem {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class, WeakReference<Object>> f58974a = Collections.synchronizedMap(new WeakHashMap());
}
