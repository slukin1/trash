package q8;

import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OptionUserInfo f53309b;

    public /* synthetic */ f(OptionUserInfo optionUserInfo) {
        this.f53309b = optionUserInfo;
    }

    public final Object call(Object obj) {
        return h.f(this.f53309b, (ContractUserInfoActive) obj);
    }
}
