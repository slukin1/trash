package com.tencent.qcloud.tuikit.tuicallengine.i;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallObserver;
import com.tencent.qcloud.tuikit.tuicallengine.e.m;
import com.tencent.qcloud.tuikit.tuicallengine.e.o;
import com.tencent.qcloud.tuikit.tuicallengine.f.b;
import com.tencent.qcloud.tuikit.tuicallengine.f.j;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f48469a;

    /* renamed from: b  reason: collision with root package name */
    public j f48470b;

    /* renamed from: c  reason: collision with root package name */
    public com.tencent.qcloud.tuikit.tuicallengine.f.a f48471c = new com.tencent.qcloud.tuikit.tuicallengine.f.a();

    /* renamed from: d  reason: collision with root package name */
    public com.tencent.qcloud.tuikit.tuicallengine.g.a f48472d;

    /* renamed from: e  reason: collision with root package name */
    public C0604a f48473e;

    /* renamed from: f  reason: collision with root package name */
    public TUICommonDefine.Callback f48474f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48475g;

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.i.a$a  reason: collision with other inner class name */
    public interface C0604a {
    }

    public a(Context context) {
        this.f48469a = context;
        this.f48472d = new com.tencent.qcloud.tuikit.tuicallengine.g.a();
    }

    public void a() {
        com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48471c;
        if (aVar != null) {
            aVar.f48381k.f48391e.set(Long.valueOf(o.b()));
            this.f48471c.f48385o.set(a.C0607a.Normal);
            this.f48471c.f48386p.set(m.CallEnd);
            if (this.f48470b != null) {
                long longValue = this.f48471c.f48381k.f48390d.get().longValue();
                int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
                long j11 = 0;
                if (longValue != 0) {
                    j11 = (o.b() - this.f48471c.f48381k.f48390d.get().longValue()) / 1000;
                }
                j jVar = this.f48470b;
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48471c;
                TUICommonDefine.RoomId roomId = aVar2.f48371a;
                TUICallDefine.MediaType mediaType = aVar2.f48384n.get();
                TUICallDefine.Role role = this.f48471c.f48375e;
                jVar.getClass();
                TUILog.i("CallingObserverManager", "onCallEnd, roomId: " + roomId + " , callMediaType: " + mediaType + " , totalTime: " + j11);
                for (WeakReference next : jVar.f48412a) {
                    if (next != null) {
                        b bVar = r5;
                        b bVar2 = new b(jVar, (TUICallObserver) next.get(), roomId, mediaType, role, j11);
                        jVar.f48413b.post(bVar);
                    }
                }
            }
        }
    }

    public abstract void a(long j11);

    public abstract void a(TUICommonDefine.Callback callback);

    public void a(TUICallDefine.MediaType mediaType) {
    }

    public abstract void a(String str, int i11);

    public abstract void a(String str, String str2, SignalingData signalingData);

    public abstract void a(String str, String str2, String str3, List<String> list, SignalingData signalingData);

    public abstract void a(String str, List<String> list);

    public void a(String str, boolean z11) {
    }

    public void a(List<String> list, TUICallDefine.CallParams callParams, TUICommonDefine.ValueCallback valueCallback) {
    }

    public abstract void b(TUICommonDefine.Callback callback);

    public void b(String str) {
        j jVar = this.f48470b;
        if (jVar != null) {
            jVar.a(str);
        }
    }

    public abstract void b(String str, String str2, SignalingData signalingData);

    public abstract void b(String str, String str2, String str3, List<String> list, SignalingData signalingData);

    public void b(String str, boolean z11) {
    }

    public abstract void c(TUICommonDefine.Callback callback);

    public abstract void c(String str);

    public abstract void c(String str, String str2, SignalingData signalingData);

    public abstract void d(TUICommonDefine.Callback callback);

    public abstract void e(TUICommonDefine.Callback callback);

    public boolean a(String str) {
        return !this.f48471c.f48378h && !TextUtils.isEmpty(str) && str.equals(V2TIMManager.getInstance().getLoginUser());
    }

    public void a(TUICallDefine.Status status) {
        if (this.f48475g) {
            o.a(status, (TUICommonDefine.Callback) null);
        }
    }
}
