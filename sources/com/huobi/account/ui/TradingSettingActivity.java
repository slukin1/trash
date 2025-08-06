package com.huobi.account.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.Keep;
import bj.p0;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.pro.core.bean.SpotTimeSharingGlobalConfig;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.activity.ApiManagerActivity;
import com.huobi.app.AbstractCommonListActivity;
import com.huobi.kyc.util.KycProxy;
import com.huobi.litere.helper.LiteReHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.otc.ui.OtcTradeSettingActivity;
import com.huobi.otc.utils.OtcPayMethodUtil;
import com.huobi.utils.k0;
import com.huobi.webview2.ui.ContractWebActivity;
import hr.b;
import hr.c;
import hr.d;
import hr.j;
import java.util.HashMap;
import java.util.List;
import jp.l;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qk.u0;
import qk.v0;
import qt.v;
import rx.Observable;
import rx.Subscription;
import tg.r;

public class TradingSettingActivity extends AbstractCommonListActivity {

    /* renamed from: q  reason: collision with root package name */
    public static Context f41582q;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41583g = false;

    /* renamed from: h  reason: collision with root package name */
    public Subscription f41584h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41585i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41586j;

    /* renamed from: k  reason: collision with root package name */
    public c.a f41587k = new b();

    /* renamed from: l  reason: collision with root package name */
    public b.a f41588l = new c();

    /* renamed from: m  reason: collision with root package name */
    public d.a f41589m = new d();

    /* renamed from: n  reason: collision with root package name */
    public d.a f41590n = new e();

    /* renamed from: o  reason: collision with root package name */
    public d.a f41591o = new f();

    /* renamed from: p  reason: collision with root package name */
    public d.a f41592p = new g();

    public class a extends EasySubscriber<SpotTimeSharingGlobalConfig> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(SpotTimeSharingGlobalConfig spotTimeSharingGlobalConfig) {
            super.onNext(spotTimeSharingGlobalConfig);
            v0.b().d(spotTimeSharingGlobalConfig);
            v0.b().e(true);
            TradingSettingActivity.this.Dh();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }
    }

    public class b implements c.a {
        public b() {
        }

        public String D(int i11) {
            if (i11 == 6) {
                boolean z11 = !p0.h();
                if (!z11) {
                    return TradingSettingActivity.this.getString(R.string.contract_setting_panel_same);
                }
                if (z11) {
                    return TradingSettingActivity.this.getString(R.string.contract_setting_panel_split);
                }
            }
            return "";
        }

        public void E(int i11, int i12) {
            if (i11 == 6) {
                p0.o(i12 == 0 ? 1 : 0);
                gs.g.i("Trading_Derivatives_Dashboard_Me_click", (HashMap) null);
            }
        }

        public boolean F() {
            return false;
        }

        public String a(int i11) {
            return TradingSettingActivity.this.getString(R.string.n_contract_side_mode_setting_currency_standard_transaction_panel);
        }

        public void b(int i11) {
        }
    }

    public class c implements b.a {
        public c() {
        }

        public String a(int i11) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 == 5) {
                            return TradingSettingActivity.this.getString(R.string.n_setting_contract_order_reverse_confirm);
                        }
                        if (i11 == 7) {
                            return TradingSettingActivity.this.getString(R.string.n_setting_market_closing_confirm);
                        }
                        if (i11 == 22) {
                            return TradingSettingActivity.this.getString(R.string.n_exchange_spot_order_confirmation);
                        }
                        if (i11 == 23) {
                            return TradingSettingActivity.this.getString(R.string.n_spot_margin_loan_order_confirmation);
                        }
                        switch (i11) {
                            case 10:
                                break;
                            case 11:
                                return TradingSettingActivity.this.getString(R.string.n_spot_trade_setting_market_confirm);
                            case 12:
                                return TradingSettingActivity.this.getString(R.string.n_spot_trade_setting_tpsl_confirm);
                            case 13:
                                break;
                            case 14:
                                break;
                            default:
                                return null;
                        }
                    }
                    return TradingSettingActivity.this.getString(R.string.n_setting_timing_order_confirm);
                }
                return TradingSettingActivity.this.getString(R.string.contract_setting_plan_order_confirmation);
            }
            return TradingSettingActivity.this.getString(R.string.contract_setting_limit_order_confirmation);
        }

        public void b(int i11) {
        }

        public int c(int i11) {
            return 0;
        }

        public void d(int i11, boolean z11) {
            if (i11 == 2) {
                p0.j(z11 ? 1 : 0);
                TradingSettingActivity.this.Fh(3);
                gs.g.i("Trading_Derivatives_Limit_Me_click", (HashMap) null);
            } else if (i11 == 3) {
                p0.l(z11);
                TradingSettingActivity.this.Fh(4);
                gs.g.i("Trading_Derivatives_Trigger_Me_click", (HashMap) null);
            } else if (i11 == 4) {
                p0.p(z11);
                TradingSettingActivity.this.Fh(5);
                gs.g.i("Trading_Derivatives_Time_Me_click", (HashMap) null);
            } else if (i11 == 5) {
                p0.n(z11);
                TradingSettingActivity.this.Fh(6);
            } else if (i11 == 7) {
                p0.i(z11);
                TradingSettingActivity.this.Fh(8);
            } else if (i11 == 22) {
                ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_CONFIRM_DIALOG", !z11);
            } else if (i11 != 23) {
                switch (i11) {
                    case 10:
                        u0.f("config_app_spot_limit_confirm_key", z11);
                        return;
                    case 11:
                        u0.f("config_app_spot_market_confirm_key", z11);
                        return;
                    case 12:
                        u0.f("config_app_spot_tp_sl_confirm_key", z11);
                        return;
                    case 13:
                        u0.f("config_app_spot_plan_confirm_key", z11);
                        return;
                    case 14:
                        u0.f("config_app_spot_time_confirm_key", z11);
                        return;
                    default:
                        return;
                }
            } else {
                ConfigPreferences.n("_READEDNOTICE_", "REMINDER_ORDER_SPOT_LOAN_CONFIRM_DIALOG", !z11);
            }
        }

        public boolean s(int i11) {
            if (i11 == 2) {
                return p0.b();
            }
            if (i11 == 3) {
                return p0.c();
            }
            if (i11 == 4) {
                return p0.d();
            }
            if (i11 == 5) {
                return p0.f();
            }
            if (i11 == 7) {
                return p0.a();
            }
            if (i11 == 22) {
                return v.h();
            }
            if (i11 == 23) {
                return v.i();
            }
            switch (i11) {
                case 10:
                    return u0.e("config_app_spot_limit_confirm_key");
                case 11:
                    return u0.e("config_app_spot_market_confirm_key");
                case 12:
                    return u0.e("config_app_spot_tp_sl_confirm_key");
                case 13:
                    return u0.e("config_app_spot_plan_confirm_key");
                case 14:
                    return u0.e("config_app_spot_time_confirm_key");
                default:
                    return false;
            }
        }
    }

    public class d implements d.a {
        public d() {
        }

        public String D(int i11) {
            return null;
        }

        public boolean E8(int i11, View view) {
            return true;
        }

        public String a(int i11) {
            return TradingSettingActivity.this.getString(R.string.n_contract_message_email_setting);
        }

        public void onItemClick(int i11) {
            if (!r.x().F0()) {
                rn.c.i().d(TradingSettingActivity.this, new JumpTarget((Intent) null, (Intent) null));
                boolean unused = TradingSettingActivity.this.f41583g = true;
                return;
            }
            gs.g.i("Trading_Derivatives_Notification_Me_click", (HashMap) null);
            ContractWebActivity.mi(TradingSettingActivity.this, "/contract_message_settings");
        }

        public boolean v8(int i11) {
            return false;
        }
    }

    public class e implements d.a {
        public e() {
        }

        public String D(int i11) {
            return "";
        }

        public boolean E8(int i11, View view) {
            return true;
        }

        public String a(int i11) {
            return i11 != 21 ? "" : TradingSettingActivity.this.getString(R.string.n_setting_config_api_manager);
        }

        public void onItemClick(int i11) {
            Class<ApiManagerActivity> cls = ApiManagerActivity.class;
            if (i11 == 21) {
                if (r.x().F0()) {
                    TradingSettingActivity.this.startActivity(new Intent(TradingSettingActivity.this, cls));
                } else {
                    rn.c.i().d(TradingSettingActivity.this, new JumpTarget(new Intent(TradingSettingActivity.this, cls), (Intent) null));
                }
                gs.g.i("Common_API_Me_click", (HashMap) null);
            }
        }

        public boolean v8(int i11) {
            return false;
        }
    }

    public class f implements d.a {
        public f() {
        }

        public String D(int i11) {
            return null;
        }

        public boolean E8(int i11, View view) {
            return true;
        }

        public String a(int i11) {
            return TradingSettingActivity.this.getString(R.string.n_account_item_pay_method_manager);
        }

        public void onItemClick(int i11) {
            TradingSettingActivity.this.Zh();
            gs.g.i("Trading_P2P_Payment_Me_click", (HashMap) null);
        }

        public boolean v8(int i11) {
            return false;
        }
    }

    public class g implements d.a {
        public g() {
        }

        public String D(int i11) {
            if (TradingSettingActivity.this.f41585i) {
                return TradingSettingActivity.this.getString(R.string.security_update_otc_trade_pwd);
            }
            return TradingSettingActivity.this.getString(R.string.security_update_otc_trade_pwd_empty);
        }

        public boolean E8(int i11, View view) {
            return true;
        }

        public String a(int i11) {
            return TradingSettingActivity.this.getString(R.string.n_setting_otc_money_password);
        }

        public void onItemClick(int i11) {
            if (TradingSettingActivity.this.f41585i) {
                TradingSettingActivity.this.startActivity(new Intent(TradingSettingActivity.this, UpdateOtcTradePwdActivity.class));
            } else if (TradingSettingActivity.this.f41586j) {
                nb.c.j(TradingSettingActivity.this, false);
            } else {
                TradingSettingActivity.this.startActivity(new Intent(TradingSettingActivity.this, OtcTradeSettingActivity.class));
            }
            gs.g.i("Trading_P2P_Password_Me_click", (HashMap) null);
        }

        public boolean v8(int i11) {
            return false;
        }
    }

    public class h extends BaseSubscriber<UserVO> {
        public h() {
        }

        /* renamed from: a */
        public void onNext(UserVO userVO) {
            super.onNext(userVO);
            TradingSettingActivity.this.ai(userVO);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Vh(UserVO userVO) {
        if (!userVO.isVerifyWayHaveSet()) {
            OtcModuleConfig.b().H(this);
        } else if (KycProxy.l().p() == 2) {
            OtcPayMethodUtil.e(this);
        } else {
            OtcPayMethodUtil.f(this);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wh(UserVO userVO) {
        if (userVO.isVerifyWayHaveSet()) {
            OtcPayMethodUtil.e(this);
        } else {
            OtcModuleConfig.b().H(this);
        }
    }

    public static void Xh(Context context) {
        if (context != null) {
            f41582q = context;
            context.startActivity(new Intent(context, TradingSettingActivity.class));
        }
    }

    public void Bh() {
    }

    public void Ch() {
    }

    public String Qg() {
        return "";
    }

    public final void Th() {
        Subscription subscription = this.f41584h;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.f41584h.unsubscribe();
        }
    }

    public void Uh() {
        l.q(false).compose(RxJavaHelper.t(getUI())).onErrorResumeNext(Observable.just(null)).subscribe(new h());
    }

    public final void Yh() {
        x8.a.a().getTimeSharingGlobalConfigInfo().b().retry(3).compose(RxJavaHelper.t(getUI())).subscribe(new a());
    }

    public void Zh() {
        if (r.x().F0()) {
            Th();
            if (r.x().U()) {
                this.f41584h = OtcPayMethodUtil.c(false, getUI()).subscribe(q6.d.c(getUI(), new a6(this)));
            } else {
                this.f41584h = OtcPayMethodUtil.d(false, getUI()).subscribe(q6.d.c(getUI(), new z5(this)));
            }
        } else {
            rn.c.i().d(this, new JumpTarget(k0.h(this), k0.h(this)));
        }
    }

    public void afterInit() {
        if (r.x().F0()) {
            Yh();
        }
        EventBus.d().p(this);
        super.afterInit();
    }

    public final void ai(UserVO userVO) {
        boolean z11 = true;
        this.f41585i = userVO != null && userVO.isIsTradeBind();
        if (userVO == null || !userVO.isVerifyWayHaveSet()) {
            z11 = false;
        }
        this.f41586j = z11;
        Eh();
    }

    public void finish() {
        super.finish();
        EventBus.d().r(this);
    }

    public String oh() {
        return getString(R.string.n_cloud_wallet_otc_trade_setting_title);
    }

    public void onRestart() {
        super.onRestart();
        Dh();
        if (this.f41583g && r.x().F0() && !r.x().X()) {
            ContractWebActivity.mi(this, "/contract_message_settings");
        }
        this.f41583g = false;
    }

    public void onStart() {
        super.onStart();
        Uh();
        gs.g.i("Trade_Me_view", (HashMap) null);
    }

    @k20.h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(this, new JumpTarget(new Intent(f41582q, TradingSettingActivity.class), (Intent) null));
        finish();
    }

    public List<s9.a> qh(List<s9.a> list) {
        list.add(new j(true, getString(R.string.n_spot_trade_setting_title)));
        list.add(new hr.b(10, this.f41588l, false));
        list.add(new hr.b(11, this.f41588l, false));
        list.add(new hr.b(12, this.f41588l, false));
        list.add(new hr.b(13, this.f41588l, false));
        if (v0.b().c(true)) {
            list.add(new hr.b(14, this.f41588l, false));
        }
        list.add(new j(true, getString(R.string.n_contract_trade_popwindow_item_unit_setting)));
        list.add(new hr.b(2, this.f41588l, false));
        list.add(new hr.b(3, this.f41588l, false));
        list.add(new hr.b(4, this.f41588l, false));
        list.add(new hr.b(5, this.f41588l, false));
        list.add(new hr.b(7, this.f41588l, false));
        if (!r.x().F0() || !r.x().X()) {
            list.add(new hr.d(0, this.f41589m, false));
        }
        list.add(new hr.c(6, this.f41587k, false));
        if (!r.x().F0() || !r.x().X()) {
            list.add(new j(true, getString(R.string.n_setting_otc_set)));
            list.add(new hr.d(0, this.f41591o, false));
            list.add(new hr.d(0, this.f41592p, false));
        }
        if (!LiteReHelper.a().b() && !r.x().X()) {
            list.add(new j(true, getString(R.string.security_other_setting)));
            list.add(new hr.d(21, this.f41590n, false));
        }
        return list;
    }

    public boolean th() {
        return false;
    }

    public boolean uh() {
        return false;
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }
}
