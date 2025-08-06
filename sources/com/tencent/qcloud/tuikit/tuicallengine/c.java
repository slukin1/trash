package com.tencent.qcloud.tuikit.tuicallengine;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.e.b;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import java.util.List;

public class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f48311a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f48312b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f48313c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f48314d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f48315e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SignalingData f48316f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ a f48317g;

    public class a implements TUICommonDefine.ValueCallback {
        public a() {
        }

        public void onError(int i11, String str) {
            TUILog.e("TUICallEngine", "handleNewInvitationSignaling, errCode: " + i11 + " , errMsg: " + str);
            a aVar = c.this.f48317g;
            a aVar2 = a.f48173a;
            aVar.c();
        }

        public void onSuccess(Object obj) {
            TUILog.i("TUICallEngine", "checkUserStatus, status: " + obj);
            if (TUICallDefine.Status.Accept != ((TUICallDefine.Status) obj)) {
                a aVar = c.this.f48317g;
                b bVar = aVar.f48177e;
                if (bVar != null) {
                    bVar.a(aVar.f48179g);
                }
                a.a(c.this.f48317g, TUICallDefine.Status.Waiting);
                c cVar = c.this;
                com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = cVar.f48317g.f48176d;
                if (aVar2 != null) {
                    aVar2.b(cVar.f48312b, cVar.f48313c, cVar.f48314d, cVar.f48315e, cVar.f48316f);
                    return;
                }
                return;
            }
            a aVar3 = c.this.f48317g;
            a aVar4 = a.f48173a;
            aVar3.c();
        }
    }

    public c(a aVar, long j11, String str, String str2, String str3, List list, SignalingData signalingData) {
        this.f48317g = aVar;
        this.f48311a = j11;
        this.f48312b = str;
        this.f48313c = str2;
        this.f48314d = str3;
        this.f48315e = list;
        this.f48316f = signalingData;
    }

    public void run() {
        if (System.currentTimeMillis() - this.f48311a >= 100) {
            a.f48174b.removeCallbacks(this);
            a.a(this.f48317g, (TUICommonDefine.ValueCallback) new a());
        } else if (a.b(this.f48317g)) {
            a.f48174b.postDelayed(this, 10);
        } else {
            TUILog.w("TUICallEngine", "this invitation is invalid");
            a.f48174b.removeCallbacks(this);
            this.f48317g.c();
        }
    }
}
