package com.huobi.otc.helper;

import al.w;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.internal.LinkedTreeMap;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCRouteChannelData;
import com.hbg.lib.network.newkyc.bean.AuthUserLevelInfo;
import com.hbg.lib.network.otc.core.bean.AgencyKycUserBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.finance.bean.FiatDWEntrance;
import com.huobi.finance.ui.DepositFiatFromCoinActivity;
import com.huobi.finance.ui.KycConditionAuthDialog;
import com.huobi.finance.ui.WithdrawFiatFromCoinActivity;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jp.a0;
import jp.b0;
import jp.c0;
import jp.d0;
import jp.e0;
import jp.l;
import jp.v;
import jp.x;
import jp.y;
import jp.z;
import pro.huobi.R;

public class OtcFaitDWJumpHelper {

    /* renamed from: g  reason: collision with root package name */
    public static int f78855g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static int f78856h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final FragmentActivity f78857a;

    /* renamed from: b  reason: collision with root package name */
    public final u6.g f78858b;

    /* renamed from: c  reason: collision with root package name */
    public String f78859c;

    /* renamed from: d  reason: collision with root package name */
    public final List<String> f78860d = Arrays.asList(new String[]{"GBP", "USD", "USD01"});

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f78861e = Arrays.asList(new String[]{"USD", "USD01"});

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f78862f = Arrays.asList(new String[]{""});

    public static class DWCheckData {

        /* renamed from: a  reason: collision with root package name */
        public Boolean f78863a;

        /* renamed from: b  reason: collision with root package name */
        public AuthUserLevelInfo f78864b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f78865c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f78866d;

        public AuthUserLevelInfo e() {
            return this.f78864b;
        }

        public Boolean f() {
            return this.f78863a;
        }

        public void g(AuthUserLevelInfo authUserLevelInfo) {
            this.f78864b = authUserLevelInfo;
        }

        public void h(Boolean bool) {
            this.f78863a = bool;
        }
    }

    public class a extends k {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f78867c;

        public a(int i11) {
            this.f78867c = i11;
        }

        public void e(String str, DWCheckData dWCheckData) {
            OtcFaitDWJumpHelper.this.x(this.f78867c == OtcFaitDWJumpHelper.f78855g, this, dWCheckData);
        }
    }

    public class b extends k {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f78869c;

        public b(int i11) {
            this.f78869c = i11;
        }

        public void e(String str, DWCheckData dWCheckData) {
            OtcFaitDWJumpHelper.this.y(str, this, this.f78869c, dWCheckData);
        }
    }

    public class c extends k {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f78871c;

        public c(int i11) {
            this.f78871c = i11;
        }

        public void e(String str, DWCheckData dWCheckData) {
            if (dWCheckData == null || !dWCheckData.f78866d) {
                OtcFaitDWJumpHelper.this.v(str, this, dWCheckData, this.f78871c);
            } else {
                d(str, dWCheckData);
            }
        }
    }

    public class d extends k {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f78873c;

        public d(int i11) {
            this.f78873c = i11;
        }

        public void e(String str, DWCheckData dWCheckData) {
            if (dWCheckData == null || !dWCheckData.f78866d) {
                OtcFaitDWJumpHelper.this.w(str, this, dWCheckData, this.f78873c);
            } else {
                d(str, dWCheckData);
            }
        }
    }

    public class e extends k {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f78875c;

        public e(int i11) {
            this.f78875c = i11;
        }

        public void e(String str, DWCheckData dWCheckData) {
            OtcFaitDWJumpHelper.this.u(str, this, dWCheckData, this.f78875c);
        }
    }

    public class f extends k {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f78877c;

        public f(int i11) {
            this.f78877c = i11;
        }

        public void e(String str, DWCheckData dWCheckData) {
            if (this.f78877c != OtcFaitDWJumpHelper.f78856h || !OtcFaitDWJumpHelper.this.f78862f.contains(str.toUpperCase())) {
                if (dWCheckData == null) {
                    dWCheckData = new DWCheckData();
                }
                d(str, dWCheckData);
                return;
            }
            HuobiToastUtil.j(R.string.n_otc_withdraw_usd_unsupport_tip);
            b();
        }
    }

    public class g extends q6.a<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DWCheckData f78879a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f78880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f78881c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(u6.g gVar, DWCheckData dWCheckData, k kVar, String str) {
            super(gVar);
            this.f78879a = dWCheckData;
            this.f78880b = kVar;
            this.f78881c = str;
        }

        public void onRequestFailure(Throwable th2) {
            boolean unused = this.f78879a.f78866d = false;
            this.f78880b.d(this.f78881c, this.f78879a);
        }

        public void onRequestSuccess(Object obj) {
            boolean z11 = false;
            if (obj instanceof LinkedTreeMap) {
                LinkedTreeMap linkedTreeMap = (LinkedTreeMap) obj;
                if (linkedTreeMap.containsKey("validLargeTradeUser")) {
                    z11 = ((Boolean) linkedTreeMap.get("validLargeTradeUser")).booleanValue();
                }
                boolean unused = this.f78879a.f78866d = z11;
                this.f78880b.d(this.f78881c, this.f78879a);
                return;
            }
            boolean unused2 = this.f78879a.f78866d = false;
            this.f78880b.d(this.f78881c, this.f78879a);
        }
    }

    public class h extends q6.a<AuthUserLevelInfo> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f78883a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f78884b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DWCheckData f78885c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f78886d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(u6.g gVar, String str, k kVar, DWCheckData dWCheckData, int i11) {
            super(gVar);
            this.f78883a = str;
            this.f78884b = kVar;
            this.f78885c = dWCheckData;
            this.f78886d = i11;
        }

        /* renamed from: a */
        public void onRequestSuccess(AuthUserLevelInfo authUserLevelInfo) {
            if (authUserLevelInfo.getAuthType() == null || authUserLevelInfo.getAuthType().intValue() != 1) {
                if (!OtcFaitDWJumpHelper.this.f78860d.contains(this.f78883a.toUpperCase()) || authUserLevelInfo.isL4Complete()) {
                    this.f78884b.d(this.f78883a, this.f78885c);
                } else if (this.f78886d == OtcFaitDWJumpHelper.f78856h) {
                    this.f78885c.g(authUserLevelInfo);
                    boolean unused = this.f78885c.f78865c = true;
                    this.f78884b.d(this.f78883a, this.f78885c);
                } else {
                    OtcFaitDWJumpHelper.this.O(true, this.f78885c.f78866d, authUserLevelInfo.getAuthState().intValue(), this.f78886d);
                    this.f78884b.b();
                }
            } else if (!OtcFaitDWJumpHelper.this.f78861e.contains(this.f78883a.toUpperCase())) {
                HuobiToastUtil.j(R.string.n_balance_agency_fait_unsupport);
                this.f78884b.b();
            } else {
                this.f78885c.h(Boolean.TRUE);
                this.f78884b.d(this.f78883a, this.f78885c);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.j(R.string.network_busy);
            this.f78884b.b();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (aPIStatusErrorException != null) {
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            }
            this.f78884b.b();
        }
    }

    public class i extends q6.a<AgencyKycUserBean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f78888a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f78889b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(u6.g gVar, int i11, k kVar) {
            super(gVar);
            this.f78888a = i11;
            this.f78889b = kVar;
        }

        /* renamed from: a */
        public void onRequestSuccess(AgencyKycUserBean agencyKycUserBean) {
            String string;
            int i11 = 0;
            if (agencyKycUserBean.isLevelEnough()) {
                String p11 = l.p();
                if (!TextUtils.isEmpty(p11) && !p11.startsWith("http")) {
                    p11 = DomainTool.DOMAIN_PREFIX + p11;
                }
                if (this.f78888a == OtcFaitDWJumpHelper.f78855g) {
                    HBBaseWebActivity.showWebView(OtcFaitDWJumpHelper.this.f78857a, p11 + "fiat/h5/vip-deposit?type=agency", "", "", false);
                } else {
                    HBBaseWebActivity.showWebView(OtcFaitDWJumpHelper.this.f78857a, p11 + "fiat/h5/vip-withdraw?type=agency", "", "", false);
                }
                this.f78889b.b();
                return;
            }
            if (agencyKycUserBean.getUbaState() == 1) {
                string = OtcFaitDWJumpHelper.this.f78857a.getString(R.string.n_otc_fiat_deposit_organ_authing_tip);
            } else {
                if (!TextUtils.isEmpty(agencyKycUserBean.getAgencyKycUrl())) {
                    i11 = 2;
                }
                string = OtcFaitDWJumpHelper.this.f78857a.getString(R.string.n_otc_fiat_deposit_organ_less_level_tip);
            }
            OtcFaitDWJumpHelper.this.N(agencyKycUserBean.getUbaState(), i11, this.f78888a, string, agencyKycUserBean.getAgencyKycUrl());
            this.f78889b.b();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.j(R.string.network_busy);
            this.f78889b.b();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (aPIStatusErrorException != null) {
                HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
            }
            this.f78889b.b();
        }
    }

    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public View.OnClickListener f78891a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f78892b;

        /* renamed from: c  reason: collision with root package name */
        public String f78893c;

        /* renamed from: d  reason: collision with root package name */
        public k f78894d;

        /* renamed from: e  reason: collision with root package name */
        public k f78895e;

        public j(String str) {
            this.f78893c = str;
        }

        public j a(k kVar) {
            if (kVar != null) {
                kVar.f(this.f78892b);
                if (this.f78894d == null) {
                    this.f78894d = kVar;
                    this.f78895e = kVar;
                } else {
                    k unused = this.f78895e.f78896a = kVar;
                    this.f78895e = kVar;
                }
            }
            return this;
        }

        public j b(View.OnClickListener onClickListener) {
            this.f78892b = onClickListener;
            return this;
        }

        public j c(View.OnClickListener onClickListener) {
            this.f78891a = onClickListener;
            return this;
        }

        public void d() {
            View.OnClickListener onClickListener = this.f78891a;
            if (onClickListener != null) {
                onClickListener.onClick((View) null);
            }
            if (TextUtils.isEmpty(this.f78893c)) {
                View.OnClickListener onClickListener2 = this.f78892b;
                if (onClickListener2 != null) {
                    onClickListener2.onClick((View) null);
                    return;
                }
                return;
            }
            this.f78894d.e(this.f78893c, (DWCheckData) null);
        }

        public j e() {
            this.f78894d = null;
            this.f78895e = null;
            return this;
        }
    }

    public static abstract class k {

        /* renamed from: a  reason: collision with root package name */
        public k f78896a;

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f78897b;

        public void b() {
            this.f78897b.onClick((View) null);
        }

        public final boolean c() {
            return this.f78896a != null;
        }

        public void d(String str, DWCheckData dWCheckData) {
            if (c()) {
                this.f78896a.e(str, dWCheckData);
            } else {
                b();
            }
        }

        public abstract void e(String str, DWCheckData dWCheckData);

        public void f(View.OnClickListener onClickListener) {
            this.f78897b = onClickListener;
        }
    }

    public OtcFaitDWJumpHelper(FragmentActivity fragmentActivity, u6.g gVar, String str) {
        this.f78857a = fragmentActivity;
        this.f78858b = gVar;
        this.f78859c = str;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void D(View view) {
        u6.g gVar = this.f78858b;
        if (gVar != null) {
            gVar.showProgressDialog();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void E(View view) {
        u6.g gVar = this.f78858b;
        if (gVar != null) {
            gVar.dismissProgressDialog();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F(boolean z11, k kVar, DWCheckData dWCheckData, List list) {
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15 = false;
        if (list == null || list.isEmpty()) {
            z12 = false;
            z14 = false;
            z13 = false;
        } else {
            Iterator it2 = list.iterator();
            int i11 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    z14 = false;
                    break;
                }
                CurrencyFromCCRouteChannelData currencyFromCCRouteChannelData = (CurrencyFromCCRouteChannelData) it2.next();
                if ((z11 && currencyFromCCRouteChannelData.isDepositEnable()) || (!z11 && currencyFromCCRouteChannelData.isWithdrawEnable())) {
                    if (currencyFromCCRouteChannelData.isAndroidSupport()) {
                        z14 = true;
                        break;
                    } else if (currencyFromCCRouteChannelData.isWebSupport()) {
                        i11++;
                    }
                }
            }
            if (z11) {
                Iterator it3 = list.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z12 = false;
                        z13 = false;
                        break;
                    }
                    CurrencyFromCCRouteChannelData currencyFromCCRouteChannelData2 = (CurrencyFromCCRouteChannelData) it3.next();
                    if (currencyFromCCRouteChannelData2.isDepositEnable() && currencyFromCCRouteChannelData2.isAndroidSupport() && currencyFromCCRouteChannelData2.isLargeTradePay()) {
                        z12 = false;
                        z13 = true;
                        break;
                    }
                }
            } else {
                Iterator it4 = list.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        z12 = false;
                        break;
                    }
                    CurrencyFromCCRouteChannelData currencyFromCCRouteChannelData3 = (CurrencyFromCCRouteChannelData) it4.next();
                    if (currencyFromCCRouteChannelData3.isWithdrawEnable() && currencyFromCCRouteChannelData3.isAndroidSupport() && currencyFromCCRouteChannelData3.isLargeTradePay()) {
                        z12 = true;
                        break;
                    }
                }
                z13 = false;
            }
            if (!z14 && i11 > 0) {
                z14 = true;
            }
        }
        if (!z14) {
            P(z11);
        } else if (z14) {
            com.hbg.lib.widgets.dialog.b.a(this.f78857a);
            HashMap hashMap = new HashMap();
            hashMap.put("fiat_name", this.f78859c);
            if (z11) {
                uf.c.b().j("show_pc_guide", hashMap);
            } else {
                uf.c.b().k("show_pc_guide", hashMap);
            }
        } else if (z11) {
            if ((this.f78859c.toLowerCase().equals("usd") || this.f78859c.toLowerCase().equals("usd01")) && !z13) {
                z15 = true;
            }
            DepositFiatFromCoinActivity.nj(this.f78857a, this.f78859c, z15 ? FiatDWEntrance.extra : FiatDWEntrance.normal);
        } else {
            if ((this.f78859c.toLowerCase().equals("usd") || this.f78859c.toLowerCase().equals("usd01")) && !z12) {
                z15 = true;
            }
            WithdrawFiatFromCoinActivity.nj(this.f78857a, this.f78859c, z15 ? FiatDWEntrance.extra : FiatDWEntrance.normal);
        }
        kVar.d(this.f78859c, dWCheckData);
    }

    public static /* synthetic */ void G(k kVar, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        kVar.b();
    }

    public static /* synthetic */ void H(k kVar, Throwable th2) {
        HuobiToastUtil.j(R.string.network_busy);
        kVar.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(DWCheckData dWCheckData, int i11, k kVar, String str, Boolean bool) {
        boolean z11 = (dWCheckData == null || !dWCheckData.f78865c || dWCheckData.e() == null) ? false : true;
        if (!bool.booleanValue() || z11) {
            O(bool.booleanValue(), dWCheckData.f78866d, z11 ? dWCheckData.e().getAuthState().intValue() : 2, i11);
            kVar.b();
            return;
        }
        kVar.d(str, dWCheckData);
    }

    public static /* synthetic */ void J(k kVar, APIStatusErrorException aPIStatusErrorException) {
        if (aPIStatusErrorException != null) {
            HuobiToastUtil.m(aPIStatusErrorException.getErrMsg());
        }
        kVar.b();
    }

    public static /* synthetic */ void K(k kVar, Throwable th2) {
        HuobiToastUtil.j(R.string.network_busy);
        kVar.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(String str, int i11, int i12) {
        if (!TextUtils.isEmpty(str)) {
            HBBaseWebActivity.showWebView(this.f78857a, str, "", "", false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(int i11, int i12, int i13) {
        if (i12 == 0 || i12 == 3) {
            OtcModuleConfig.b().L();
            HashMap hashMap = new HashMap();
            hashMap.put("app_id", w.h(this.f78859c));
            hashMap.put("fiat_name", this.f78859c);
            if (i11 == 0) {
                uf.c.b().j("click_kyc", hashMap);
            } else {
                uf.c.b().k("click_kyc", hashMap);
            }
        } else if (i13 != 2) {
            this.f78857a.startActivity(new Intent(this.f78857a, SecuritySetActivity.class));
            HashMap hashMap2 = new HashMap();
            hashMap2.put("fiat_name", this.f78859c);
            if (i11 == 0) {
                uf.c.b().j("click_2factor", hashMap2);
            } else {
                uf.c.b().k("click_2factor", hashMap2);
            }
        }
    }

    public final String A() {
        if (TextUtils.isEmpty(this.f78859c)) {
            return "";
        }
        if ("usd01".equalsIgnoreCase(this.f78859c)) {
            return "usd".toUpperCase(Locale.US);
        }
        return this.f78859c.toUpperCase(Locale.US);
    }

    public final boolean B() {
        return va.b.o().v(this.f78859c);
    }

    public final boolean C() {
        return va.b.o().w(this.f78859c);
    }

    public void N(int i11, int i12, int i13, String str, String str2) {
        String str3;
        KycConditionAuthDialog kycConditionAuthDialog = new KycConditionAuthDialog();
        kycConditionAuthDialog.i(str);
        int i14 = 1;
        kycConditionAuthDialog.j(true);
        if (i11 == 2) {
            i14 = 2;
        } else if (i11 != 1) {
            i14 = i11 == 3 ? 3 : 0;
        }
        kycConditionAuthDialog.g(i14);
        kycConditionAuthDialog.h(0);
        kycConditionAuthDialog.l(false);
        if (TextUtils.isEmpty(str2)) {
            str3 = this.f78857a.getString(R.string.lite_trade_i_know);
        } else if (i12 == 2) {
            str3 = i14 == 3 ? this.f78857a.getString(R.string.n_fiat_recertification) : this.f78857a.getString(R.string.n_otc_go_verification);
        } else {
            str3 = "";
        }
        kycConditionAuthDialog.e(str3);
        kycConditionAuthDialog.f(new y(this, str2));
        kycConditionAuthDialog.k(i13);
        kycConditionAuthDialog.n(this.f78857a, false);
        HashMap hashMap = new HashMap();
        hashMap.put("fiat_name", this.f78859c);
        if (i13 == 0) {
            uf.c.b().j("show_kyc_and_2factor_view", hashMap);
        } else {
            uf.c.b().k("show_kyc_and_2factor_view", hashMap);
        }
    }

    public void O(boolean z11, boolean z12, int i11, int i12) {
        String str;
        KycConditionAuthDialog kycConditionAuthDialog = new KycConditionAuthDialog();
        int i13 = 0;
        int i14 = i11 == 2 ? 2 : i11 == 1 ? 1 : i11 == 3 ? 3 : 0;
        boolean z13 = !z12;
        if (!B() && !C()) {
            z13 = false;
        }
        if (this.f78859c.toUpperCase().equals("EUR")) {
            z13 = false;
        }
        kycConditionAuthDialog.l(z13);
        kycConditionAuthDialog.g(i14);
        if (i12 == 1) {
            if (z11) {
                i13 = 2;
            }
            kycConditionAuthDialog.h(i13);
        } else {
            kycConditionAuthDialog.h(2);
        }
        kycConditionAuthDialog.k(i12);
        if (i14 == 0 || i14 == 3) {
            if (i14 == 3) {
                str = this.f78857a.getString(R.string.n_fiat_recertification);
            } else {
                str = this.f78857a.getString(R.string.n_otc_go_verification);
            }
        } else if (i12 != 1 || z11) {
            str = this.f78857a.getString(R.string.allow_access_dialog_positive_btn);
        } else {
            str = this.f78857a.getString(R.string.staring_remind_to_open);
        }
        kycConditionAuthDialog.e(str);
        kycConditionAuthDialog.f(new x(this, i12));
        kycConditionAuthDialog.k(i12);
        kycConditionAuthDialog.m(this.f78857a);
        HashMap hashMap = new HashMap();
        hashMap.put("fiat_name", this.f78859c);
        if (i12 == 0) {
            uf.c.b().j("show_kyc_and_2factor_view", hashMap);
        } else {
            uf.c.b().k("show_kyc_and_2factor_view", hashMap);
        }
    }

    public void P(boolean z11) {
        String format = String.format(this.f78857a.getResources().getString(z11 ? R.string.n_fiat_suspend_recharge_with_currency : R.string.n_fiat_suspend_withdraw_with_currency), new Object[]{A()});
        DialogUtils.b.d dVar = new DialogUtils.b.d(this.f78857a);
        dVar.c1(format);
        dVar.i1(1).M0(Integer.valueOf(R.drawable.balance_forbiden_whitdraw_content)).F0(8388611).q0(false).P0(this.f78857a.getString(R.string.allow_access_dialog_positive_btn)).Q0(ad.b.f3517a).j0().show(this.f78857a.getSupportFragmentManager(), "");
        HashMap hashMap = new HashMap();
        hashMap.put("fiat_name", this.f78859c);
        if (z11) {
            uf.c.b().j("show_suspension_guide", hashMap);
        } else {
            uf.c.b().k("show_suspension_guide", hashMap);
        }
    }

    public void t(int i11, String str) {
        this.f78859c = str;
        new j(str).e().c(new v(this)).b(new jp.w(this)).a(new f(i11)).a(new e(i11)).a(new d(i11)).a(new c(i11)).a(new b(i11)).a(new a(i11)).d();
    }

    public final void u(String str, k kVar, DWCheckData dWCheckData, int i11) {
        v7.b.a().requestBulkUserInfo().d(new g(this.f78858b, dWCheckData, kVar, str));
    }

    public final void v(String str, k kVar, DWCheckData dWCheckData, int i11) {
        if (dWCheckData == null || dWCheckData.f() == null || !dWCheckData.f().booleanValue()) {
            kVar.d(str, dWCheckData);
        } else {
            s8.a.a().getAgencyKycUser().d(new i(this.f78858b, i11, kVar));
        }
    }

    public final void w(String str, k kVar, DWCheckData dWCheckData, int i11) {
        n8.a.a().getAuthUserLevel().d(new h(this.f78858b, str, kVar, dWCheckData, i11));
    }

    public final void x(boolean z11, k kVar, DWCheckData dWCheckData) {
        v7.b.a().x(w.g(), z(), z11 ? "deposit" : "withdraw", w.f()).b().compose(RxJavaHelper.t(this.f78858b)).subscribe(EasySubscriber.create(new e0(this, z11, kVar, dWCheckData), new a0(kVar), new b0(kVar)));
    }

    public final void y(String str, k kVar, int i11, DWCheckData dWCheckData) {
        if (i11 == f78856h) {
            w.e().compose(RxJavaHelper.t(this.f78858b)).compose(RxJavaHelper.t(this.f78858b)).subscribe(EasySubscriber.create(new d0(this, dWCheckData, i11, kVar, str), new z(kVar), new c0(kVar)));
        } else {
            kVar.d(str, dWCheckData);
        }
    }

    public final String z() {
        if ("usd".equalsIgnoreCase(this.f78859c)) {
            return "USD01";
        }
        return this.f78859c;
    }

    public OtcFaitDWJumpHelper(FragmentActivity fragmentActivity, String str) {
        this.f78857a = fragmentActivity;
        this.f78858b = null;
        this.f78859c = str;
    }
}
