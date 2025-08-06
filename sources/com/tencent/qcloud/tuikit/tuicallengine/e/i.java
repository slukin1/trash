package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class i implements Observer<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48337a;

    public i(b bVar) {
        this.f48337a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48337a.f48321a, "profile_call_status_detail").a("send_signaling", b.a(this.f48337a, ((Long) obj).longValue()));
        b.a(this.f48337a);
    }
}
