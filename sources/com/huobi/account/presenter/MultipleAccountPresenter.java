package com.huobi.account.presenter;

import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.MultipleAccountData;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.usercenter.data.source.bean.UserInfoData;
import com.huobi.utils.i0;
import com.huobi.utils.k0;
import i6.d;
import i6.k;
import pro.huobi.R;
import rn.c;
import sn.l;
import tg.r;
import u6.g;
import ug.v;

public class MultipleAccountPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f41028a;

    public class a extends EasySubscriber<UserInfoData> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MultipleAccountData f41029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f41030c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f41031d;

        public a(MultipleAccountData multipleAccountData, int i11, String str) {
            this.f41029b = multipleAccountData;
            this.f41030c = i11;
            this.f41031d = str;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Object obj) {
            Intent a11 = k0.a(MultipleAccountPresenter.this.getActivity());
            a11.setFlags(268468224);
            MultipleAccountPresenter.this.getActivity().startActivity(a11);
        }

        /* renamed from: c */
        public void onNext(UserInfoData userInfoData) {
            super.onNext(userInfoData);
            r.x().g0();
            ConfigPreferences.m("user_config", "config_email", ConfigPreferences.d("user_config", userInfoData.i() + "config_new_email"));
            i0.a(MultipleAccountPresenter.this.getActivity(), "NO_PASSWORD");
            l.h(MultipleAccountPresenter.this.getActivity(), false, new v(this));
            if (MultipleAccountPresenter.this.getUI() != null) {
                ((b) MultipleAccountPresenter.this.getUI()).U4(this.f41029b);
                ((b) MultipleAccountPresenter.this.getUI()).Z4(this.f41030c, 0);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            r.x().l0(this.f41031d);
            r.x().x0(com.hbg.lib.core.util.a.a(ConfigPreferences.e("user_config", this.f41031d + "_" + "config_tua", "")));
            r.x().e0();
            if (MultipleAccountPresenter.this.getUI() != null) {
                k.g("LOGIN", "changeAccountLogin has error", th2);
                ((b) MultipleAccountPresenter.this.getUI()).Z4(this.f41030c, 2);
                ((b) MultipleAccountPresenter.this.getUI()).dismissProgressDialog();
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (aPIStatusErrorException.getErrCode().equals("token_failure") || "512".equals(aPIStatusErrorException.getErrCode())) {
                r.x().l0(this.f41031d);
                r.x().x0(com.hbg.lib.core.util.a.a(ConfigPreferences.e("user_config", this.f41031d + "_" + "config_tua", "")));
                r.x().e0();
                d.b("changeAccountFail");
                if (MultipleAccountPresenter.this.getUI() != null) {
                    ((b) MultipleAccountPresenter.this.getUI()).dismissProgressDialog();
                    MultipleAccountPresenter.this.V();
                } else {
                    return;
                }
            }
            if (MultipleAccountPresenter.this.getUI() != null) {
                ((b) MultipleAccountPresenter.this.getUI()).Z4(this.f41030c, 2);
                ((b) MultipleAccountPresenter.this.getUI()).dismissProgressDialog();
            }
        }
    }

    public interface b extends g {
        void U4(MultipleAccountData multipleAccountData);

        void Z4(int i11, int i12);
    }

    public final void V() {
        Intent k11 = c.i().k(getActivity(), true, this.f41028a);
        k11.putExtra("login_name", this.f41028a);
        k11.putExtra("login_multiple_account", true);
        c.i().c(k11, new JumpTarget((Intent) null, (Intent) null));
        getActivity().startActivity(k11);
    }

    public void W(MultipleAccountData multipleAccountData, int i11) {
        this.f41028a = ConfigPreferences.d("user_config", multipleAccountData.getUid() + "config_new_email");
        if (TextUtils.equals(com.hbg.lib.core.util.a.a(ConfigPreferences.e("user_config", multipleAccountData.getUid() + "_" + "config_tua", "")), r.x().I())) {
            ((b) getUI()).dismissProgressDialog();
            ((b) getUI()).Z4(i11, 2);
            HuobiToastUtil.l(BaseApplication.b(), getString(R.string.n_login_switch_fail));
            V();
            return;
        }
        String s11 = r.x().s();
        r.x().l0(multipleAccountData.getUid());
        r.x().e0();
        r.x().P(false, getString(R.string.n_login_switch_fail)).compose(RxJavaHelper.t((g) getUI())).subscribe(new a(multipleAccountData, i11, s11));
    }

    /* renamed from: X */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
