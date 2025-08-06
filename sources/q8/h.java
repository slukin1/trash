package q8;

import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;

public final class h {

    /* renamed from: b  reason: collision with root package name */
    public static volatile h f70148b;

    /* renamed from: a  reason: collision with root package name */
    public OptionUserInfo f70149a;

    public static h d() {
        if (f70148b == null) {
            synchronized (h.class) {
                if (f70148b == null) {
                    f70148b = new h();
                }
            }
        }
        return f70148b;
    }

    public static /* synthetic */ OptionUserInfo f(OptionUserInfo optionUserInfo, ContractUserInfoActive contractUserInfoActive) {
        optionUserInfo.setActiveState(contractUserInfoActive.getOption().getActive());
        optionUserInfo.setIsAgree(contractUserInfoActive.getAgree());
        optionUserInfo.setIsAgreeV2(contractUserInfoActive.getAgreeV2());
        return optionUserInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(OptionUserInfo optionUserInfo) {
        this.f70149a = optionUserInfo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001d, code lost:
        r3 = r2.f70149a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.Observable<com.hbg.lib.network.option.core.bean.OptionUserInfo> e(boolean r3) {
        /*
            r2 = this;
            p8.b r0 = p8.a.a()
            d9.a r0 = r0.getUserInfo()
            rx.Observable r0 = r0.b()
            q8.g r1 = q8.g.f53310b
            rx.Observable r0 = r0.flatMap(r1)
            q8.e r1 = new q8.e
            r1.<init>(r2)
            rx.Observable r0 = r0.doOnNext(r1)
            if (r3 == 0) goto L_0x0026
            com.hbg.lib.network.option.core.bean.OptionUserInfo r3 = r2.f70149a
            if (r3 == 0) goto L_0x0026
            rx.Observable r3 = rx.Observable.just(r3)
            return r3
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.h.e(boolean):rx.Observable");
    }
}
