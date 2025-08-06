package i8;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.huobi.contract.entity.ContractUserInfoActive;
import rx.Observable;

public final class s {

    /* renamed from: b  reason: collision with root package name */
    public static volatile s f70368b;

    /* renamed from: a  reason: collision with root package name */
    public LinearSwapUserInfo f70369a;

    public class a extends RequestCallback1<LinearSwapUserInfo> {

        /* renamed from: i8.s$a$a  reason: collision with other inner class name */
        public class C0769a extends RequestCallback1<ContractUserInfoActive> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LinearSwapUserInfo f70370a;

            public C0769a(LinearSwapUserInfo linearSwapUserInfo) {
                this.f70370a = linearSwapUserInfo;
            }

            /* renamed from: a */
            public void onRequestSuccess(ContractUserInfoActive contractUserInfoActive) {
                this.f70370a.setActiveState(contractUserInfoActive.getLinearSwap().getActive());
                this.f70370a.setIsAgree(contractUserInfoActive.getAgree());
                this.f70370a.setIsAgreeV2(contractUserInfoActive.getAgreeV2());
                this.f70370a.setKycCountry(contractUserInfoActive.getKycCountry());
                this.f70370a.setKycState(contractUserInfoActive.getKycState());
                boolean z11 = true;
                if (this.f70370a.getAssetsMode() != 1) {
                    z11 = false;
                }
                SPUtil.s(z11);
                s.d().m(this.f70370a);
            }
        }

        /* renamed from: a */
        public void onRequestSuccess(LinearSwapUserInfo linearSwapUserInfo) {
            q7.a.a().fetchUserInfoActive().d(new C0769a(linearSwapUserInfo));
        }
    }

    public static s d() {
        if (f70368b == null) {
            synchronized (s.class) {
                if (f70368b == null) {
                    f70368b = new s();
                }
            }
        }
        return f70368b;
    }

    public static /* synthetic */ LinearSwapUserInfo i(LinearSwapUserInfo linearSwapUserInfo, ContractUserInfoActive contractUserInfoActive) {
        linearSwapUserInfo.setActiveState(contractUserInfoActive.getLinearSwap().getActive());
        linearSwapUserInfo.setIsAgree(contractUserInfoActive.getAgree());
        linearSwapUserInfo.setIsAgreeV2(contractUserInfoActive.getAgreeV2());
        linearSwapUserInfo.setKycCountry(contractUserInfoActive.getKycCountry());
        linearSwapUserInfo.setKycState(contractUserInfoActive.getKycState());
        return linearSwapUserInfo;
    }

    public static /* synthetic */ Observable j(LinearSwapUserInfo linearSwapUserInfo) {
        boolean z11 = true;
        if (linearSwapUserInfo.getAssetsMode() != 1) {
            z11 = false;
        }
        SPUtil.s(z11);
        return q7.a.a().fetchUserInfoActive().b().map(new q(linearSwapUserInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(LinearSwapUserInfo linearSwapUserInfo) {
        this.f70369a = linearSwapUserInfo;
    }

    public static void l() {
        h8.a.a().getUserInfo().d(new a());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001d, code lost:
        r3 = r2.f70369a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.Observable<com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo> e(boolean r3) {
        /*
            r2 = this;
            h8.b r0 = h8.a.a()
            d9.a r0 = r0.getUserInfo()
            rx.Observable r0 = r0.b()
            i8.r r1 = i8.r.f55030b
            rx.Observable r0 = r0.flatMap(r1)
            i8.p r1 = new i8.p
            r1.<init>(r2)
            rx.Observable r0 = r0.doOnNext(r1)
            if (r3 == 0) goto L_0x0026
            com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo r3 = r2.f70369a
            if (r3 == 0) goto L_0x0026
            rx.Observable r3 = rx.Observable.just(r3)
            return r3
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.s.e(boolean):rx.Observable");
    }

    public LinearSwapUserInfo f() {
        return this.f70369a;
    }

    public boolean g() {
        LinearSwapUserInfo linearSwapUserInfo = this.f70369a;
        return linearSwapUserInfo != null && linearSwapUserInfo.offSite;
    }

    public boolean h() {
        LinearSwapUserInfo linearSwapUserInfo = this.f70369a;
        if (linearSwapUserInfo == null || linearSwapUserInfo.getActiveState() != 1) {
            return false;
        }
        return true;
    }

    public void m(LinearSwapUserInfo linearSwapUserInfo) {
        this.f70369a = linearSwapUserInfo;
    }
}
