package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class a implements Observer<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48320a;

    public a(b bVar) {
        this.f48320a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48320a.f48321a, "profile_call_status_detail").a("call_end", b.a(this.f48320a, ((Long) obj).longValue()));
        b.a(this.f48320a);
    }
}
