package com.huobi.otcoption.util;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.v;
import com.hbg.lib.network.hbg.otcoptions.PreVisibleBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.login.bean.JumpTarget;
import com.huobi.otcoption.ui.OtcOptionsIndexActivity;
import pro.huobi.R;
import rn.c;
import rx.Subscription;
import tg.r;
import u6.g;

public class OtcOptionsEntryHelper {

    /* renamed from: e  reason: collision with root package name */
    public static OtcOptionsEntryHelper f80225e;

    /* renamed from: a  reason: collision with root package name */
    public int f80226a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f80227b = "";

    /* renamed from: c  reason: collision with root package name */
    public b f80228c;

    /* renamed from: d  reason: collision with root package name */
    public Subscription f80229d;

    public class a extends EasySubscriber<PreVisibleBean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f80230b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ BaseActivity f80231c;

        public a(boolean z11, BaseActivity baseActivity) {
            this.f80230b = z11;
            this.f80231c = baseActivity;
        }

        /* renamed from: a */
        public void onNext(PreVisibleBean preVisibleBean) {
            BaseActivity baseActivity;
            BaseActivity baseActivity2;
            super.onNext(preVisibleBean);
            if (this.f80230b && (baseActivity2 = this.f80231c) != null) {
                baseActivity2.dismissProgressDialog();
            }
            Subscription unused = OtcOptionsEntryHelper.this.f80229d = null;
            if (preVisibleBean != null) {
                if (preVisibleBean.isVisible()) {
                    int unused2 = OtcOptionsEntryHelper.this.f80226a = 3;
                    if (this.f80230b && (baseActivity = this.f80231c) != null) {
                        OtcOptionsIndexActivity.Qi("", "", baseActivity);
                    }
                } else {
                    int unused3 = OtcOptionsEntryHelper.this.f80226a = 2;
                    String unused4 = OtcOptionsEntryHelper.this.f80227b = preVisibleBean.getErrMsg();
                    if (this.f80230b) {
                        HuobiToastUtil.m(OtcOptionsEntryHelper.this.f80227b);
                    }
                }
                OtcOptionsEntryHelper.this.m();
            }
        }

        public void onError2(Throwable th2) {
            BaseActivity baseActivity;
            super.onError2(th2);
            if (this.f80230b && (baseActivity = this.f80231c) != null) {
                baseActivity.dismissProgressDialog();
            }
            Subscription unused = OtcOptionsEntryHelper.this.f80229d = null;
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            BaseActivity baseActivity;
            if (this.f80230b && (baseActivity = this.f80231c) != null) {
                baseActivity.dismissProgressDialog();
                super.onFailed(aPIStatusErrorException);
            }
            Subscription unused = OtcOptionsEntryHelper.this.f80229d = null;
        }
    }

    public interface b {
        void a();

        void b();
    }

    public static OtcOptionsEntryHelper g() {
        if (f80225e == null) {
            f80225e = new OtcOptionsEntryHelper();
        }
        return f80225e;
    }

    public void f() {
        Subscription subscription = this.f80229d;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f80229d = null;
        }
        this.f80226a = 0;
        i();
    }

    public void h(Activity activity, Intent intent, String str, String str2) {
        if (!r.x().F0()) {
            c.i().d(activity, new JumpTarget(intent, intent));
        } else if (r.x().X()) {
            HuobiToastUtil.j(R.string.n_otc_options_child_account_not_supported);
        } else {
            int i11 = this.f80226a;
            if (i11 == 3) {
                OtcOptionsIndexActivity.Qi(str2, str, activity);
            } else if (i11 == 2) {
                if (!TextUtils.isEmpty(this.f80227b)) {
                    HuobiToastUtil.m(this.f80227b);
                }
            } else if (activity instanceof BaseActivity) {
                p((BaseActivity) activity);
            } else {
                p((BaseActivity) null);
            }
        }
    }

    public final void i() {
        b bVar = this.f80228c;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void j() {
        b bVar = this.f80228c;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void k() {
        this.f80226a = 0;
        i();
        o();
    }

    public void l() {
        this.f80226a = 0;
        o();
    }

    public final void m() {
        if (!r.x().F0() || r.x().X()) {
            i();
        } else if (this.f80226a == 3) {
            j();
        } else {
            i();
        }
    }

    public final void n(BaseActivity baseActivity, boolean z11) {
        Subscription subscription = this.f80229d;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f80229d = null;
            if (baseActivity != null) {
                baseActivity.dismissProgressDialog();
            }
        }
        if (!r.x().F0() || r.x().X()) {
            i();
            return;
        }
        if (z11 && baseActivity != null) {
            baseActivity.showProgressDialog();
        }
        this.f80229d = v.e().f().compose(RxJavaHelper.t((g) null)).subscribe(new a(z11, baseActivity));
    }

    public void o() {
        n((BaseActivity) null, false);
    }

    public final void p(BaseActivity baseActivity) {
        n(baseActivity, true);
    }
}
