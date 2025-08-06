package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mx.a;

public abstract class BaseMemoryCache implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Reference<Bitmap>> f28287a = Collections.synchronizedMap(new HashMap());

    public boolean a(String str, Bitmap bitmap) {
        this.f28287a.put(str, b(bitmap));
        return true;
    }

    public abstract Reference<Bitmap> b(Bitmap bitmap);

    public Bitmap get(String str) {
        Reference reference = this.f28287a.get(str);
        if (reference != null) {
            return (Bitmap) reference.get();
        }
        return null;
    }

    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this.f28287a) {
            hashSet = new HashSet(this.f28287a.keySet());
        }
        return hashSet;
    }

    public Bitmap remove(String str) {
        Reference remove = this.f28287a.remove(str);
        if (remove == null) {
            return null;
        }
        return (Bitmap) remove.get();
    }
}
