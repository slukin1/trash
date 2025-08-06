package m9;

import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
import com.huobi.contract.entity.ContractUserInfoActive;
import rx.Observable;

public final class z {

    /* renamed from: b  reason: collision with root package name */
    public static volatile z f70919b;

    /* renamed from: a  reason: collision with root package name */
    public SwapUserInfo.UserBean f70920a;

    public class a extends RequestCallback1<SwapUserInfo.UserBean> {

        /* renamed from: m9.z$a$a  reason: collision with other inner class name */
        public class C0780a extends RequestCallback1<ContractUserInfoActive> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwapUserInfo.UserBean f70921a;

            public C0780a(SwapUserInfo.UserBean userBean) {
                this.f70921a = userBean;
            }

            /* renamed from: a */
            public void onRequestSuccess(ContractUserInfoActive contractUserInfoActive) {
                this.f70921a.setActiveState(contractUserInfoActive.getSwap().getActive());
                this.f70921a.setIsAgree(contractUserInfoActive.getAgree());
                this.f70921a.setIsAgreeV2(contractUserInfoActive.getAgreeV2());
                this.f70921a.setKycState(contractUserInfoActive.getKycState());
                this.f70921a.setKycCountry(contractUserInfoActive.getKycCountry());
                z.f().q(this.f70921a);
            }
        }

        /* renamed from: a */
        public void onRequestSuccess(SwapUserInfo.UserBean userBean) {
            q7.a.a().fetchUserInfoActive().d(new C0780a(userBean));
        }
    }

    public static z f() {
        if (f70919b == null) {
            synchronized (z.class) {
                if (f70919b == null) {
                    f70919b = new z();
                }
            }
        }
        return f70919b;
    }

    public static /* synthetic */ SwapUserInfo.UserBean l(SwapUserInfo.UserBean userBean, ContractUserInfoActive contractUserInfoActive) {
        userBean.setActiveState(contractUserInfoActive.getSwap().getActive());
        userBean.setIsAgree(contractUserInfoActive.getAgree());
        userBean.setIsAgreeV2(contractUserInfoActive.getAgreeV2());
        userBean.setKycState(contractUserInfoActive.getKycState());
        userBean.setKycCountry(contractUserInfoActive.getKycCountry());
        return userBean;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(SwapUserInfo.UserBean userBean) {
        this.f70920a = userBean;
    }

    public static /* synthetic */ Boolean o(SwapUserInfo.UserBean userBean) {
        return Boolean.valueOf(userBean != null);
    }

    public static void p() {
        l9.a.a().getUserInfo().d(new a());
    }

    public void e() {
        this.f70920a = null;
    }

    public Observable<SwapUserInfo.UserBean> g(boolean z11) {
        Observable<R> doOnNext = l9.a.a().getUserInfo().b().flatMap(y.f58142b).doOnNext(new v(this));
        return z11 ? Observable.concat(Observable.just(this.f70920a), doOnNext).takeFirst(x.f58141b) : doOnNext;
    }

    public SwapUserInfo.UserBean h() {
        return this.f70920a;
    }

    public boolean i() {
        SwapUserInfo.UserBean userBean = this.f70920a;
        return userBean != null && userBean.getIsAgree() == 1;
    }

    public boolean j() {
        SwapUserInfo.UserBean userBean = this.f70920a;
        return userBean != null && userBean.offSite;
    }

    public boolean k() {
        SwapUserInfo.UserBean userBean = this.f70920a;
        return userBean != null && userBean.getActiveState() == 1;
    }

    public void q(SwapUserInfo.UserBean userBean) {
        this.f70920a = userBean;
    }
}
