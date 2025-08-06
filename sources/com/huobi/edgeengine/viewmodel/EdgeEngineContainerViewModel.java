package com.huobi.edgeengine.viewmodel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.j;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.Arrays;
import kotlin.jvm.internal.d0;
import rj.b;
import sd.a;

public class EdgeEngineContainerViewModel extends ViewModel implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public b f44365b;

    /* renamed from: c  reason: collision with root package name */
    public String f44366c;

    /* renamed from: d  reason: collision with root package name */
    public String f44367d = "EdgeEngineContainer";

    /* renamed from: e  reason: collision with root package name */
    public String f44368e = "";

    public final void h(String str) {
        b h02 = h0();
        h02.I(i0() + '.' + str + "()");
    }

    public final b h0() {
        b bVar = this.f44365b;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }

    public final String i0() {
        String str = this.f44366c;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final String j0() {
        return this.f44367d;
    }

    public final View k0(String str, String str2) {
        if (!a.c(str2)) {
            b h02 = h0();
            d0 d0Var = d0.f56774a;
            h02.I(String.format("%s.start()", Arrays.copyOf(new Object[]{str2}, 1)));
        }
        return h0().D(str, h0().d());
    }

    public final Widget l0(Context context, String str, String str2) {
        if (!a.c(str2)) {
            b h02 = h0();
            d0 d0Var = d0.f56774a;
            h02.I(String.format("%s.start()", Arrays.copyOf(new Object[]{str2}, 1)));
        }
        return h0().G(str, context, false, h0().m());
    }

    public final View m0(Module module, ViewGroup viewGroup) {
        if (!a.c(module.getModuleName())) {
            b h02 = h0();
            d0 d0Var = d0.f56774a;
            h02.I(String.format("%s.start()", Arrays.copyOf(new Object[]{module.getModuleName()}, 1)));
        }
        View D = h0().D(module.getXml(), h0().d());
        if (viewGroup != null) {
            viewGroup.addView(D);
        }
        return D;
    }

    public final Widget n0(Module module, ViewGroup viewGroup) {
        if (!a.c(module.getModuleName())) {
            b h02 = h0();
            d0 d0Var = d0.f56774a;
            h02.I(String.format("%s.start()", Arrays.copyOf(new Object[]{module.getModuleName()}, 1)));
        }
        Widget G = h0().G(module.getXml(), viewGroup != null ? viewGroup.getContext() : null, false, h0().m());
        View P = G.P(h0().d());
        if (viewGroup != null) {
            viewGroup.addView(P);
        }
        return G;
    }

    public final void o0(String str) {
        ek.b.f47515a.c(str);
    }

    public void onCreate(LifecycleOwner lifecycleOwner) {
        j.a(this, lifecycleOwner);
        o0(i0() + " ------> onCreate");
        b h02 = h0();
        h02.I(i0() + ".onCreate('" + this.f44368e + "')");
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        j.b(this, lifecycleOwner);
        o0(i0() + " ------> onDestroy");
        ek.b.f47515a.e(this.f44367d);
        b h02 = h0();
        h02.I(i0() + ".onDestroy()");
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        j.c(this, lifecycleOwner);
        o0(i0() + " ------> onPause");
        b h02 = h0();
        h02.I(i0() + ".onPause()");
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        j.d(this, lifecycleOwner);
        o0(i0() + " ------> onResume");
        b h02 = h0();
        h02.I(i0() + ".onResume()");
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        j.e(this, lifecycleOwner);
        o0(i0() + " ------> onStart");
        b h02 = h0();
        h02.I(i0() + ".onStart()");
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        j.f(this, lifecycleOwner);
        o0(i0() + " ------> onStop");
        b h02 = h0();
        h02.I(i0() + ".onStop()");
    }

    public final TraceMap.a p0(String str, vj.a aVar) {
        return h0().u(str, aVar);
    }

    public final void q0(b bVar) {
        u0(bVar);
    }

    public final void r0(String str) {
        v0(str);
    }

    public final void s0(String str) {
        this.f44368e = str;
    }

    public final void t0(String str) {
        this.f44367d = str;
    }

    public final void u0(b bVar) {
        this.f44365b = bVar;
    }

    public final void v0(String str) {
        this.f44366c = str;
    }
}
