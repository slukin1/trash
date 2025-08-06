package com.tencent.qcloud.tuikit.tuicallengine.e;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class e implements Observer<TUICallDefine.MediaType> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48333a;

    public e(b bVar) {
        this.f48333a = bVar;
    }

    public void onChanged(Object obj) {
        p.a(this.f48333a.f48321a, "profile_call_base").a(MessengerShareContentUtility.MEDIA_TYPE, ((TUICallDefine.MediaType) obj).toString().toLowerCase());
        b.a(this.f48333a);
    }
}
