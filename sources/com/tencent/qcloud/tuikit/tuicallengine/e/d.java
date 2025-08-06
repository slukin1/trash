package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class d implements Observer<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48332a;

    public d(b bVar) {
        this.f48332a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48332a.f48321a, "profile_call_base").a("initial_invite_id", (String) obj);
    }
}
