package com.huobi.edgeengine.ability;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.util.IdentifierUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rj.b;

public class r extends V8Function {
    public r(V8 v82, WeakReference<b> weakReference) {
        super(v82, new q(weakReference));
    }

    public static String f(String str) {
        return str.replaceAll("%(\\d+)s", "%$1\\$s");
    }

    public static Object[] g(V8Array v8Array) {
        return j(v8Array, 1).toArray();
    }

    public static List<Object> j(V8Array v8Array, int i11) {
        if (v8Array.length() < i11 + 1) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (i11 < v8Array.length()) {
            Object obj = v8Array.get(i11);
            if (obj instanceof V8Array) {
                arrayList.addAll(j((V8Array) obj, 0));
            } else {
                arrayList.add(obj);
            }
            i11++;
        }
        return arrayList;
    }

    public static String k(String str, Context context) {
        int a11 = IdentifierUtil.a(context, str, "string");
        if (a11 == 0) {
            return "";
        }
        return context.getString(a11);
    }

    public static /* synthetic */ Object l(WeakReference weakReference, V8Object v8Object, V8Array v8Array) {
        if (v8Array == null || v8Array.length() < 1 || weakReference.get() == null) {
            return null;
        }
        try {
            String string = v8Array.getString(0);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            Object[] g11 = g(v8Array);
            String k11 = k(string, ((b) weakReference.get()).d());
            if (TextUtils.isEmpty(k11)) {
                return null;
            }
            if (g11.length == 0) {
                return k11;
            }
            return String.format(f(k11), g11);
        } catch (Exception e11) {
            Log.d("EdgeEngine", "I18nInternal: " + e11.getMessage());
            e11.printStackTrace();
            return null;
        }
    }
}
