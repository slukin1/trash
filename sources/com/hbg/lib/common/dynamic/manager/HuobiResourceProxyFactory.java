package com.hbg.lib.common.dynamic.manager;

import android.content.Context;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public class HuobiResourceProxyFactory implements LayoutInflater.Factory2 {

    /* renamed from: f  reason: collision with root package name */
    public static final Map<String, Constructor<? extends View>> f67451f = new ArrayMap();

    /* renamed from: g  reason: collision with root package name */
    public static final Class<?>[] f67452g = {Context.class, AttributeSet.class};

    /* renamed from: b  reason: collision with root package name */
    public final String[] f67453b = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: c  reason: collision with root package name */
    public TextRepairAttribute f67454c = new TextRepairAttribute();

    /* renamed from: d  reason: collision with root package name */
    public ImageSrcAttribute f67455d = new ImageSrcAttribute();

    /* renamed from: e  reason: collision with root package name */
    public ColorSrcAttribute f67456e = new ColorSrcAttribute();

    public final View a(String str, Context context, AttributeSet attributeSet) {
        try {
            return (View) c(context, str).newInstance(new Object[]{context, attributeSet});
        } catch (Throwable unused) {
            return null;
        }
    }

    public final View b(String str, Context context, AttributeSet attributeSet) {
        View view = null;
        if (-1 != str.indexOf(46)) {
            return null;
        }
        for (int i11 = 0; i11 < this.f67453b.length; i11++) {
            view = a(this.f67453b[i11] + str, context, attributeSet);
            if (view != null) {
                break;
            }
        }
        return view;
    }

    public final Constructor<? extends View> c(Context context, String str) {
        Map<String, Constructor<? extends View>> map = f67451f;
        Constructor<? extends U> constructor = map.get(str);
        if (constructor != null) {
            return constructor;
        }
        try {
            constructor = context.getClassLoader().loadClass(str).asSubclass(View.class).getConstructor(f67452g);
            map.put(str, constructor);
            return constructor;
        } catch (Throwable unused) {
            return constructor;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View b11 = b(str, context, attributeSet);
        if (b11 == null) {
            b11 = a(str, context, attributeSet);
        }
        if (b11 != null) {
            this.f67454c.a(b11, attributeSet);
        }
        if (b11 != null) {
            try {
                this.f67455d.a(b11, attributeSet);
            } catch (Exception e11) {
                Log.e("HuobiResourceProxyFacto", "onCreateView() called with: parent = [" + view + "], name = [" + str + "], context = [" + context + "], attrs = [" + attributeSet + "]:", e11);
            }
        }
        if (b11 != null) {
            try {
                this.f67456e.a(b11, attributeSet);
            } catch (Exception e12) {
                Log.e("HuobiResourceProxyFacto", "onCreateView() called with: parent = [" + view + "], name = [" + str + "], context = [" + context + "], attrs = [" + attributeSet + "]:", e12);
            }
        }
        return b11;
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return null;
    }
}
