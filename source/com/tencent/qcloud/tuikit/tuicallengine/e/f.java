package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;

public class f implements Observer<a.C0607a> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48334a;

    public f(b bVar) {
        this.f48334a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48334a.f48321a, "profile_call_status").a("result", ((a.C0607a) obj).toString().toLowerCase());
        b.a(this.f48334a);
    }
}
