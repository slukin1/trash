package tn;

import com.huobi.login.usercenter.data.source.bean.CountryListData;
import com.huobi.login.v2.ui.UserRegisterActivityV2;
import rx.functions.Action1;

public final /* synthetic */ class v1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserRegisterActivityV2 f37319b;

    public /* synthetic */ v1(UserRegisterActivityV2 userRegisterActivityV2) {
        this.f37319b = userRegisterActivityV2;
    }

    public final void call(Object obj) {
        this.f37319b.di((CountryListData) obj);
    }
}
