package com.huobi.contract.helper;

import android.app.Activity;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import bj.p0;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.libkt.base.ui.BaseActivity;
import com.huobi.contract.entity.ContractPriceProtectionInfo;
import com.huobi.contract.entity.ContractTriggerProtectInfo;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import pro.huobi.R;
import tg.r;
import u6.g;

public class ContractPriceProtectionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f43111a = new HashMap();

    public class a extends EasySubscriber<Void> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f43112b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f43113c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c6.a f43114d;

        public a(Activity activity, boolean z11, c6.a aVar) {
            this.f43112b = activity;
            this.f43113c = z11;
            this.f43114d = aVar;
        }

        /* renamed from: a */
        public void onNext(Void voidR) {
            super.onNext(voidR);
            p0.m(this.f43113c);
        }

        public void onAfter() {
            super.onAfter();
            Activity activity = this.f43112b;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).Df();
            } else if (activity instanceof com.hbg.lib.core.ui.BaseActivity) {
                ((com.hbg.lib.core.ui.BaseActivity) activity).dismissProgressDialog();
            }
            c6.a aVar = this.f43114d;
            if (aVar != null) {
                aVar.a();
            }
        }

        public void onStart() {
            super.onStart();
            Activity activity = this.f43112b;
            if (activity instanceof BaseActivity) {
                ((BaseActivity) activity).sh();
            } else if (activity instanceof com.hbg.lib.core.ui.BaseActivity) {
                ((com.hbg.lib.core.ui.BaseActivity) activity).showProgressDialog();
            }
        }
    }

    public class b extends EasySubscriber<ContractPriceProtectionInfo> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c6.a f43115b;

        public b(c6.a aVar) {
            this.f43115b = aVar;
        }

        /* renamed from: a */
        public void onNext(ContractPriceProtectionInfo contractPriceProtectionInfo) {
            super.onNext(contractPriceProtectionInfo);
            p0.m(contractPriceProtectionInfo.isSwitchOn());
        }

        public void onAfter() {
            super.onAfter();
            c6.a aVar = this.f43115b;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public class c extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f43116b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43117c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43118d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43119e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ TradeType f43120f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ HBDialogFragment f43121g;

        public c(FragmentActivity fragmentActivity, String str, String str2, String str3, TradeType tradeType, HBDialogFragment hBDialogFragment) {
            this.f43116b = fragmentActivity;
            this.f43117c = str;
            this.f43118d = str2;
            this.f43119e = str3;
            this.f43120f = tradeType;
            this.f43121g = hBDialogFragment;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            ContractWebActivity.Uh(this.f43116b, this.f43117c, this.f43118d, this.f43119e, this.f43120f);
            this.f43121g.dismiss();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(ContextCompat.getColor(this.f43116b, R.color.kColorMajorTheme100));
            textPaint.setUnderlineText(false);
        }
    }

    public class d extends BaseSubscriber<ContractTriggerProtectInfo> {
        /* renamed from: a */
        public void onNext(ContractTriggerProtectInfo contractTriggerProtectInfo) {
            super.onNext(contractTriggerProtectInfo);
            ContractPriceProtectionHelper.e(contractTriggerProtectInfo);
        }
    }

    public class e extends BaseSubscriber<ContractTriggerProtectInfo> {
        /* renamed from: a */
        public void onNext(ContractTriggerProtectInfo contractTriggerProtectInfo) {
            super.onNext(contractTriggerProtectInfo);
            ContractPriceProtectionHelper.e(contractTriggerProtectInfo);
        }
    }

    public class f extends BaseSubscriber<ContractTriggerProtectInfo> {
        /* renamed from: a */
        public void onNext(ContractTriggerProtectInfo contractTriggerProtectInfo) {
            super.onNext(contractTriggerProtectInfo);
            ContractPriceProtectionHelper.e(contractTriggerProtectInfo);
        }
    }

    public static void b(c6.a aVar) {
        if (r.x().F0()) {
            q7.a.a().getContractPriceProtection().b().compose(RxJavaHelper.t((g) null)).subscribe(new b(aVar));
        }
    }

    public static String c(String str) {
        return f43111a.get(str);
    }

    public static void d(boolean z11, c6.a aVar) {
        q7.a.a().D(z11 ? 1 : 0).b().compose(RxJavaHelper.t((g) null)).subscribe(new a(oa.a.g().b(), z11, aVar));
    }

    public static void e(ContractTriggerProtectInfo contractTriggerProtectInfo) {
        if (contractTriggerProtectInfo != null && contractTriggerProtectInfo.getTriggerProtect() != null) {
            f43111a.put(contractTriggerProtectInfo.getContractCode(), m.M(contractTriggerProtectInfo.getTriggerProtect().doubleValue(), 2));
        }
    }

    public static void f(FragmentActivity fragmentActivity, TradeType tradeType, String str, String str2, String str3) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        String string = fragmentActivity.getString(R.string.n_contract_essence);
        String format = String.format(Locale.US, fragmentActivity.getString(R.string.n_contract_price_spread_protection_desc_1), new Object[]{string});
        SpannableString spannableString = new SpannableString(format + "\n\n" + fragmentActivity.getString(R.string.n_contract_price_spread_protection_desc_2));
        int indexOf = format.indexOf(string);
        int length = string.length() + indexOf;
        int i11 = (length < 0 || length > format.length()) ? 0 : length;
        int i12 = (indexOf < 0 || indexOf > i11) ? 0 : indexOf;
        HBDialogFragment k02 = new DialogUtils.b.d(fragmentActivity).c1(fragmentActivity.getString(R.string.n_contract_price_spread_protection)).C0(spannableString).R0((String) null).T0(true).q0(false).P0(fragmentActivity.getString(R.string.n_known)).Q0(o0.f12469a).k0();
        spannableString.setSpan(new c(fragmentActivity, str, str2, str3, tradeType, k02), i12, i11, 34);
        k02.show(fragmentActivity.getSupportFragmentManager(), "showPriceProtectionDialog");
    }

    public static void g(TradeType tradeType, String str) {
        if (tradeType == TradeType.LINEAR_SWAP) {
            h8.a.a().triggerProtect(str).b().compose(RxJavaHelper.t((g) null)).subscribe(new d());
        } else if (tradeType == TradeType.SWAP) {
            l9.a.a().triggerProtect(str).b().compose(RxJavaHelper.t((g) null)).subscribe(new e());
        } else if (tradeType == TradeType.CONTRACT) {
            ContractOrderHelper.l(str).compose(RxJavaHelper.t((g) null)).subscribe(new f());
        }
    }
}
