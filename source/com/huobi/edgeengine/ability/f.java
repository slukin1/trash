package com.huobi.edgeengine.ability;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.util.IdentifierUtil;
import java.lang.ref.WeakReference;
import rj.b;

public class f extends V8Function {
    public f(V8 v82, WeakReference<b> weakReference) {
        super(v82, new e(weakReference));
    }

    public static String f(Context context, String str) {
        int a11 = IdentifierUtil.a(context, str, "color");
        return "#" + Integer.toHexString(ContextCompat.getColor(context, a11));
    }

    public static /* synthetic */ Object g(WeakReference weakReference, V8Object v8Object, V8Array v8Array) {
        if (v8Array == null || v8Array.length() == 1 || !(v8Array.get(0) instanceof String) || weakReference.get() == null) {
            return "";
        }
        return f(((b) weakReference.get()).d(), v8Array.getString(0));
    }
}
