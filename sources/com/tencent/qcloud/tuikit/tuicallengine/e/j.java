package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class j implements Observer<Long> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48338a;

    public j(b bVar) {
        this.f48338a = bVar;
    }

    public void onChanged(Object obj) {
        Long l11 = (Long) obj;
        b.a(this.f48338a);
    }
}
