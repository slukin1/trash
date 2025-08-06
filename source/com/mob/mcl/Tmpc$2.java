package com.mob.mcl;

import android.os.Bundle;
import com.mob.apc.a;
import com.mob.mcl.b.b;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.utils.HashonHelper;

public class Tmpc$2 implements HttpResponseCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f27395a;

    public Tmpc$2(a aVar) {
        this.f27395a = aVar;
    }

    public void onResponse(HttpConnection httpConnection) throws Throwable {
        if (httpConnection instanceof b) {
            Bundle bundle = new Bundle();
            new HashonHelper();
            bundle.putString("data", HashonHelper.fromHashMap(((b) httpConnection).a()));
            this.f27395a.f26851e = bundle;
        }
    }
}
