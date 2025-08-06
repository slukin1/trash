package bj;

import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractDataSource;
import com.huobi.login.usercenter.data.source.bean.LoginInfoData;
import rx.functions.Func1;

public final /* synthetic */ class p implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f12475b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LoginInfoData f12476c;

    public /* synthetic */ p(String[] strArr, LoginInfoData loginInfoData) {
        this.f12475b = strArr;
        this.f12476c = loginInfoData;
    }

    public final Object call(Object obj) {
        return ContractDataSource.h(this.f12475b, this.f12476c, (ContractUserInfo) obj);
    }
}
