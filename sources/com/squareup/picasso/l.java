package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

public final class l implements d {

    /* renamed from: a  reason: collision with root package name */
    public final LruCache<String, b> f30058a;

    public class a extends LruCache<String, b> {
        public a(int i11) {
            super(i11);
        }

        /* renamed from: a */
        public int sizeOf(String str, b bVar) {
            return bVar.f30061b;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f30060a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30061b;

        public b(Bitmap bitmap, int i11) {
            this.f30060a = bitmap;
            this.f30061b = i11;
        }
    }

    public l(Context context) {
        this(y.b(context));
    }

    public int a() {
        return this.f30058a.maxSize();
    }

    public void b(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int i11 = y.i(bitmap);
        if (i11 > a()) {
            this.f30058a.remove(str);
        } else {
            this.f30058a.put(str, new b(bitmap, i11));
        }
    }

    public Bitmap get(String str) {
        b bVar = this.f30058a.get(str);
        if (bVar != null) {
            return bVar.f30060a;
        }
        return null;
    }

    public int size() {
        return this.f30058a.size();
    }

    public l(int i11) {
        this.f30058a = new a(i11);
    }
}
