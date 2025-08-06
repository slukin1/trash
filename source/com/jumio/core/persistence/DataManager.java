package com.jumio.core.persistence;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import jumio.core.y1;
import jumio.core.z1;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

public final class DataManager implements Serializable {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<String, Serializable> f39469a = new ConcurrentHashMap<>();

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public static String a(Class cls) throws RuntimeException {
        PersistWith persistWith = (PersistWith) cls.getAnnotation(PersistWith.class);
        if (persistWith != null) {
            return persistWith.value();
        }
        String name = cls.getName();
        throw new RuntimeException("Class " + name + " must be annotated with PersistWith!");
    }

    public final synchronized <T extends Serializable> T get(Class<T> cls) {
        T t11;
        try {
            t11 = (Serializable) this.f39469a.get(a(cls));
            if (t11 == null) {
                T newInstance = cls.newInstance();
                put(cls, (Serializable) newInstance);
                t11 = (Serializable) newInstance;
            }
        } catch (Exception e11) {
            d0 d0Var = d0.f56774a;
            Log.w("DataAccess", String.format(Locale.ENGLISH, "Error loading %s", Arrays.copyOf(new Object[]{cls.getName()}, 1)), (Throwable) e11);
            t11 = (Serializable) cls.newInstance();
            put(cls, t11);
        }
        return t11;
    }

    public final synchronized <T extends Serializable> boolean has(Class<T> cls) {
        boolean z11;
        z11 = false;
        try {
            z11 = this.f39469a.containsKey(a(cls));
        } catch (Exception e11) {
            d0 d0Var = d0.f56774a;
            Log.w("DataAccess", String.format(Locale.ENGLISH, "Error looking for %s", Arrays.copyOf(new Object[]{cls.getName()}, 1)), (Throwable) e11);
        }
        return z11;
    }

    public final synchronized void persist(y1 y1Var) {
        y1Var.a(this.f39469a);
    }

    public final synchronized <T extends Serializable> void put(Class<T> cls, T t11) {
        try {
            this.f39469a.put(a(cls), t11);
        } catch (RuntimeException e11) {
            d0 d0Var = d0.f56774a;
            Log.w("DataAccess", String.format(Locale.ENGLISH, "Error persisting %s", Arrays.copyOf(new Object[]{cls.getName()}, 1)), (Throwable) e11);
        }
        return;
    }

    public final synchronized void remove(Class<?>... clsArr) {
        for (Class<?> a11 : clsArr) {
            this.f39469a.remove(a(a11));
        }
    }

    public final synchronized void removeAll() {
        this.f39469a.clear();
    }

    public final synchronized void restore(z1 z1Var) {
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) z1Var.a();
        if (concurrentHashMap != null) {
            this.f39469a.putAll(concurrentHashMap);
        }
    }
}
