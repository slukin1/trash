package com.tencent.qcloud.tuikit.tuicallengine.f;

import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.e.m;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public TUICommonDefine.RoomId f48371a = new TUICommonDefine.RoomId();

    /* renamed from: b  reason: collision with root package name */
    public String f48372b;

    /* renamed from: c  reason: collision with root package name */
    public String f48373c;

    /* renamed from: d  reason: collision with root package name */
    public List<String> f48374d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public TUICallDefine.Role f48375e = TUICallDefine.Role.None;

    /* renamed from: f  reason: collision with root package name */
    public TUICallDefine.Status f48376f = TUICallDefine.Status.None;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48377g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48378h;

    /* renamed from: i  reason: collision with root package name */
    public SignalingData f48379i;

    /* renamed from: j  reason: collision with root package name */
    public TUICallDefine.CallParams f48380j = new TUICallDefine.CallParams();

    /* renamed from: k  reason: collision with root package name */
    public C0602a f48381k = new C0602a(this);

    /* renamed from: l  reason: collision with root package name */
    public LiveData<String> f48382l = new LiveData<>();

    /* renamed from: m  reason: collision with root package name */
    public LiveData<String> f48383m = new LiveData<>();

    /* renamed from: n  reason: collision with root package name */
    public LiveData<TUICallDefine.MediaType> f48384n = new LiveData<>(TUICallDefine.MediaType.Unknown);

    /* renamed from: o  reason: collision with root package name */
    public LiveData<a.C0607a> f48385o = new LiveData<>(a.C0607a.Unknown);

    /* renamed from: p  reason: collision with root package name */
    public LiveData<m> f48386p = new LiveData<>();

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.f.a$a  reason: collision with other inner class name */
    public class C0602a {

        /* renamed from: a  reason: collision with root package name */
        public LiveData<Boolean> f48387a = new LiveData<>(Boolean.FALSE);

        /* renamed from: b  reason: collision with root package name */
        public LiveData<Long> f48388b;

        /* renamed from: c  reason: collision with root package name */
        public LiveData<Long> f48389c;

        /* renamed from: d  reason: collision with root package name */
        public LiveData<Long> f48390d;

        /* renamed from: e  reason: collision with root package name */
        public LiveData<Long> f48391e;

        public C0602a(a aVar) {
            int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            this.f48388b = new LiveData<>(0L);
            this.f48389c = new LiveData<>(0L);
            this.f48390d = new LiveData<>(0L);
            this.f48391e = new LiveData<>(0L);
        }
    }

    public void a() {
        this.f48371a = new TUICommonDefine.RoomId();
        this.f48372b = "";
        this.f48373c = "";
        this.f48374d = new ArrayList();
        this.f48375e = TUICallDefine.Role.None;
        this.f48376f = TUICallDefine.Status.None;
        this.f48377g = false;
        this.f48378h = false;
        this.f48379i = new SignalingData();
        this.f48380j = null;
        C0602a aVar = this.f48381k;
        aVar.f48387a.removeAll();
        aVar.f48388b.removeAll();
        aVar.f48389c.removeAll();
        aVar.f48390d.removeAll();
        aVar.f48391e.removeAll();
        aVar.f48387a.set(Boolean.FALSE);
        aVar.f48388b.set(0L);
        aVar.f48389c.set(0L);
        aVar.f48390d.set(0L);
        aVar.f48391e.set(0L);
        this.f48382l.removeAll();
        this.f48383m.removeAll();
        this.f48384n.removeAll();
        this.f48385o.removeAll();
        this.f48386p.removeAll();
        this.f48382l.set("");
        this.f48383m.set("");
        this.f48384n.set(TUICallDefine.MediaType.Unknown);
        this.f48385o.set(a.C0607a.Unknown);
    }

    public String toString() {
        return "CallState{callId='" + String.valueOf(this.f48382l.get()) + ", initialCallId='" + String.valueOf(this.f48383m.get()) + ", roomId=" + this.f48371a + ", groupId=" + this.f48372b + ", callRole=" + this.f48375e + ", mediaType=" + String.valueOf(this.f48384n.get()) + ", callStatus=" + this.f48376f + ", inviter=" + this.f48373c + ", isInRoom=" + this.f48377g + ", inviteeList=" + this.f48374d + ", handleInDevice=" + this.f48378h + '}';
    }
}
