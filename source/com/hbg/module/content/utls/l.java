package com.hbg.module.content.utls;

import android.content.Context;
import android.util.Log;
import com.google.gson.Gson;
import com.hbg.module.content.R$string;
import com.hbg.module.content.ui.activity.live.edgeengine.LiveLoading;
import com.hbg.module.content.ui.activity.live.edgeengine.LiveToastError;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.r;

public final class l {

    /* renamed from: c  reason: collision with root package name */
    public static final a f18918c = new a((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static WeakReference<l> f18919d;

    /* renamed from: a  reason: collision with root package name */
    public rj.b f18920a;

    /* renamed from: b  reason: collision with root package name */
    public b f18921b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final WeakReference<l> a() {
            return l.f18919d;
        }

        public final void b(WeakReference<l> weakReference) {
            l.f18919d = weakReference;
        }
    }

    public interface b {
        void a(boolean z11);

        void b(boolean z11);

        void c(String str);

        void d(boolean z11);
    }

    public l(Context context) {
        rj.b bVar = new rj.b(context, context.getString(R$string.live_edge_engine_module));
        this.f18920a = bVar;
        bVar.t("hbToastError", LiveToastError.class);
        rj.b bVar2 = this.f18920a;
        if (bVar2 != null) {
            bVar2.t("hbShowLoading", LiveLoading.class);
        }
        rj.b bVar3 = this.f18920a;
        if (bVar3 != null) {
            bVar3.H();
        }
        rj.b bVar4 = this.f18920a;
        if (bVar4 != null) {
            bVar4.u("redPacketQueue.currentPacket", new h(this));
        }
        rj.b bVar5 = this.f18920a;
        if (bVar5 != null) {
            bVar5.u("redPacket.closeView", new k(this));
        }
        rj.b bVar6 = this.f18920a;
        if (bVar6 != null) {
            bVar6.u("redPacketGrap.closeView", new j(this));
        }
        rj.b bVar7 = this.f18920a;
        if (bVar7 != null) {
            bVar7.u("redPacketGrap.openView", new i(this));
        }
    }

    public static final void e(l lVar, Object obj) {
        Log.d("redPacketQueue.currentPacket", "redPacketQueue.currentPacket -- listen");
        if (lVar.f18921b != null) {
            Log.d("redPacketQueue.currentPacket", "redPacketQueue.currentPacket:--" + new Gson().toJson(obj));
            lVar.f18921b.c(new Gson().toJson(obj));
        }
    }

    public static final void f(l lVar, Object obj) {
        b bVar = lVar.f18921b;
        if (bVar != null) {
            bVar.d(((Boolean) obj).booleanValue());
        }
    }

    public static final void g(l lVar, Object obj) {
        b bVar = lVar.f18921b;
        if (bVar != null) {
            bVar.a(((Boolean) obj).booleanValue());
        }
    }

    public static final void h(l lVar, Object obj) {
        b bVar = lVar.f18921b;
        if (bVar != null) {
            bVar.b(((Boolean) obj).booleanValue());
        }
    }

    public final rj.b k() {
        return this.f18920a;
    }

    public final void l() {
        rj.b bVar = this.f18920a;
        if (bVar != null) {
            bVar.I("redPacketQueue.clearData()");
        }
        rj.b bVar2 = this.f18920a;
        if (bVar2 != null) {
            bVar2.B();
        }
    }

    public final void m(b bVar) {
        this.f18921b = bVar;
    }
}
