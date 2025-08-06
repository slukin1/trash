package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class c implements Observer<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48331a;

    public c(b bVar) {
        this.f48331a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48331a.f48321a, "profile_call_base").a("invite_id", (String) obj);
        b.a(this.f48331a);
    }
}
