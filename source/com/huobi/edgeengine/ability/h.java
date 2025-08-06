package com.huobi.edgeengine.ability;

import android.util.Log;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public final /* synthetic */ class h implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ h f43922a = new h();

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return Log.e("V8.Console", v8Array.toString());
    }
}
