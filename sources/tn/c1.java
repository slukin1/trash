package tn;

import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import rx.functions.Action1;

public final /* synthetic */ class c1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV2 f37254b;

    public /* synthetic */ c1(UserLoginActivityV2 userLoginActivityV2) {
        this.f37254b = userLoginActivityV2;
    }

    public final void call(Object obj) {
        this.f37254b.pj((CountryListData) obj);
    }
}
