package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class k implements Observer<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48339a;

    public k(b bVar) {
        this.f48339a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48339a.f48321a, "profile_call_status_detail").a("call_accept", b.a(this.f48339a, ((Long) obj).longValue()));
    }
}
