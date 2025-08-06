package com.hbg.module.libkt.utils;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import b2.a;
import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import ue.b;

public final class CommonWidgetHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final CommonWidgetHelper f24861a = new CommonWidgetHelper();

    /* renamed from: b  reason: collision with root package name */
    public static HbgBaseProvider f24862b;

    public final boolean a(Activity activity) {
        HbgBaseProvider hbgBaseProvider = (HbgBaseProvider) a.d().a("/provider/content").navigation();
        f24862b = hbgBaseProvider;
        if (hbgBaseProvider != null) {
            return hbgBaseProvider.j(activity);
        }
        return false;
    }

    public final void b(int i11, String str, String str2, int i12, b<CommonPkData> bVar) {
        RequestExtKt.d(v7.b.a().Z(i11, str, str2, i12), new CommonWidgetHelper$pkVote$1(bVar), new CommonWidgetHelper$pkVote$2(bVar), (MutableLiveData) null, 4, (Object) null);
    }
}
