package od;

import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.module.huobi.im.imsignal.IMSdk;
import ve.a;

public final /* synthetic */ class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f58813a;

    public /* synthetic */ d(String str) {
        this.f58813a = str;
    }

    public final void a(UserOtherInfoData userOtherInfoData) {
        IMSdk.b.b(this.f58813a, userOtherInfoData);
    }
}
