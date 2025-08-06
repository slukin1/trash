package com.tencent.qcloud.tuikit.tuicallengine.e;

import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.Observer;

public class h implements Observer<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f48336a;

    public h(b bVar) {
        this.f48336a = bVar;
    }

    public void onChanged(Object obj) {
        p a11 = p.a(this.f48336a.f48321a, "profile_call_status_detail");
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (!TextUtils.isEmpty("ability_bit")) {
            a11.f48370c.edit().putBoolean("ability_bit", booleanValue).commit();
        }
    }
}
