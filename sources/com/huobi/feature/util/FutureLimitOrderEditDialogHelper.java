package com.huobi.feature.util;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Keep;
import cn.r;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import dj.v;
import i6.m;
import java.math.BigDecimal;
import java.util.Locale;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import qk.n;
import qk.o;
import qk.p;
import ts.q;

public class FutureLimitOrderEditDialogHelper {

    /* renamed from: a  reason: collision with root package name */
    public final f f45080a;

    /* renamed from: b  reason: collision with root package name */
    public final e f45081b;

    /* renamed from: c  reason: collision with root package name */
    public final c f45082c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f45083d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f45084e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45085f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f45086g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45087h;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            FutureLimitOrderEditDialogHelper.this.f45081b.e(FutureLimitOrderEditDialogHelper.this.f45084e, editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            FutureLimitOrderEditDialogHelper.this.f45081b.b(FutureLimitOrderEditDialogHelper.this.f45086g, editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void dismiss();

        <T extends View> T findViewById(int i11);

        Context getContext();

        void setCancelable(boolean z11);
    }

    public interface e extends d {
        TradeType D0();

        void b(EditText editText, Editable editable);

        void c(String str, String str2);

        BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2);

        void e(EditText editText, Editable editable);

        String f();

        void g(String str, String str2);
    }

    public static class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final c f45105b;

        public g(c cVar) {
            this.f45105b = cVar;
        }

        public void run() {
            c cVar = this.f45105b;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    public FutureLimitOrderEditDialogHelper(e eVar, f fVar, c cVar) {
        this.f45081b = eVar;
        this.f45080a = fVar;
        this.f45082c = cVar;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(View view) {
        h();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(String str, View view) {
        String obj = this.f45084e.getText().toString();
        if (TextUtils.isEmpty(obj) || Double.parseDouble(obj) == 0.0d) {
            HuobiToastUtil.g(R.string.staring_remind_please_input_price);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String obj2 = this.f45086g.getText().toString();
        if (TextUtils.isEmpty(obj2) || Double.parseDouble(obj2) == 0.0d) {
            HuobiToastUtil.g(R.string.points_buy_confirm_error_number_hint);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        BigDecimal d11 = this.f45081b.d(m.a(obj2), m.a(obj));
        if (d11.compareTo(BigDecimal.ONE) < 0) {
            this.f45081b.c(str, obj);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.f45081b.g(obj, d11.toPlainString());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void o(View view, View view2, boolean z11) {
        view.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_bg : R.drawable.custom_edittext_normal_bg);
    }

    public static /* synthetic */ void p(View view, View view2, boolean z11) {
        view.setBackgroundResource(z11 ? R.drawable.custom_edittext_blue_focused_bg : R.drawable.custom_edittext_normal_bg);
    }

    public static void q(Activity activity, c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        new v(activity, f.b(str, str2, str3, str4, str5, str6, str7, str8), cVar).show();
    }

    public static void r(Activity activity, c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        f c11 = f.c(str, str2, str3, str4, str5, str6, str7, str8, str9);
        if (str10 != null && !str10.isEmpty()) {
            c11.t(str10);
        }
        new r(activity, c11, cVar).show();
    }

    public static void s(Activity activity, c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        new q(activity, f.d(str, str2, str3, str4, str5, str6, str7, str8), cVar).show();
    }

    public final void h() {
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        e eVar = this.f45081b;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    public int i() {
        return R.layout.dialog_contract_limit_order_edit;
    }

    public Runnable j() {
        return new g(this.f45082c);
    }

    public final void k() {
        String str;
        String s11 = this.f45080a.s();
        TradeType D0 = this.f45081b.D0();
        String i11 = StringUtils.i(this.f45080a.r());
        if (a7.e.G(D0)) {
            str = "usdt".toUpperCase(Locale.US);
        } else if (a7.e.E(D0)) {
            str = s11;
        } else {
            str = this.f45081b.getContext().getString(R.string.contract_market_vol_sheet);
        }
        this.f45083d.setText(this.f45081b.f());
        this.f45084e.setText(this.f45080a.j());
        this.f45086g.setText(this.f45080a.k());
        this.f45085f.setText(i11);
        this.f45087h.setText(str);
        this.f45081b.findViewById(R.id.dialog_cancel_iv).setOnClickListener(new n(this));
        this.f45081b.findViewById(R.id.dialog_position_trade_tv).setOnClickListener(new o(this, s11));
    }

    public void l() {
        EventBus.d().p(this);
        this.f45081b.setCancelable(true);
        this.f45083d = (TextView) this.f45081b.findViewById(R.id.tv_contract_name);
        this.f45084e = (EditText) this.f45081b.findViewById(R.id.input_price_et);
        this.f45085f = (TextView) this.f45081b.findViewById(R.id.tv_price_unit_type);
        this.f45086g = (EditText) this.f45081b.findViewById(R.id.input_volume_et);
        this.f45087h = (TextView) this.f45081b.findViewById(R.id.tv_volume_unit_type);
        View findViewById = this.f45081b.findViewById(R.id.ll_price);
        View findViewById2 = this.f45081b.findViewById(R.id.ll_volume);
        this.f45084e.setOnFocusChangeListener(new p(findViewById));
        this.f45084e.addTextChangedListener(new a());
        this.f45086g.setOnFocusChangeListener(new qk.q(findViewById2));
        this.f45086g.addTextChangedListener(new b());
        k();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        h();
    }

    public void t(EditText editText, String str) {
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public String f45090a;

        /* renamed from: b  reason: collision with root package name */
        public String f45091b;

        /* renamed from: c  reason: collision with root package name */
        public String f45092c;

        /* renamed from: d  reason: collision with root package name */
        public String f45093d;

        /* renamed from: e  reason: collision with root package name */
        public String f45094e;

        /* renamed from: f  reason: collision with root package name */
        public String f45095f;

        /* renamed from: g  reason: collision with root package name */
        public String f45096g;

        /* renamed from: h  reason: collision with root package name */
        public String f45097h;

        /* renamed from: i  reason: collision with root package name */
        public String f45098i;

        /* renamed from: j  reason: collision with root package name */
        public String f45099j;

        /* renamed from: k  reason: collision with root package name */
        public String f45100k;

        /* renamed from: l  reason: collision with root package name */
        public String f45101l;

        /* renamed from: m  reason: collision with root package name */
        public String f45102m;

        /* renamed from: n  reason: collision with root package name */
        public String f45103n;

        /* renamed from: o  reason: collision with root package name */
        public String f45104o;

        public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, LinearSwapContractInfo linearSwapContractInfo) {
            this.f45090a = str;
            this.f45091b = str2;
            this.f45092c = str3;
            this.f45093d = str4;
            this.f45094e = str5;
            this.f45095f = str6;
            this.f45096g = str7;
            this.f45097h = str8;
            this.f45099j = str9;
            this.f45100k = linearSwapContractInfo.getSymbol();
            this.f45102m = linearSwapContractInfo.getContractShortType();
            this.f45103n = linearSwapContractInfo.getContractType();
            this.f45104o = linearSwapContractInfo.getContractFace();
            this.f45101l = str4.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
        }

        public static f b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            return new f(str, str2, str3, str4, str5, str6, str7, str8, ContractCurrencyUtils.h(str4));
        }

        public static f c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            return new f(str, str2, str3, str4, str5, str6, str7, str8, str9, LinearSwapCurrencyInfoController.l().m(str4));
        }

        public static f d(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            return new f(str, str2, str3, str4, str5, str6, str7, str8, SwapCurrencyInfoController.k().q(str4));
        }

        public boolean a(Object obj) {
            return obj instanceof f;
        }

        public String e() {
            return this.f45093d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (!fVar.a(this)) {
                return false;
            }
            String o11 = o();
            String o12 = fVar.o();
            if (o11 != null ? !o11.equals(o12) : o12 != null) {
                return false;
            }
            String j11 = j();
            String j12 = fVar.j();
            if (j11 != null ? !j11.equals(j12) : j12 != null) {
                return false;
            }
            String k11 = k();
            String k12 = fVar.k();
            if (k11 != null ? !k11.equals(k12) : k12 != null) {
                return false;
            }
            String e11 = e();
            String e12 = fVar.e();
            if (e11 != null ? !e11.equals(e12) : e12 != null) {
                return false;
            }
            String p11 = p();
            String p12 = fVar.p();
            if (p11 != null ? !p11.equals(p12) : p12 != null) {
                return false;
            }
            String n11 = n();
            String n12 = fVar.n();
            if (n11 != null ? !n11.equals(n12) : n12 != null) {
                return false;
            }
            String i11 = i();
            String i12 = fVar.i();
            if (i11 != null ? !i11.equals(i12) : i12 != null) {
                return false;
            }
            String l11 = l();
            String l12 = fVar.l();
            if (l11 != null ? !l11.equals(l12) : l12 != null) {
                return false;
            }
            String q11 = q();
            String q12 = fVar.q();
            if (q11 != null ? !q11.equals(q12) : q12 != null) {
                return false;
            }
            String m11 = m();
            String m12 = fVar.m();
            if (m11 != null ? !m11.equals(m12) : m12 != null) {
                return false;
            }
            String s11 = s();
            String s12 = fVar.s();
            if (s11 != null ? !s11.equals(s12) : s12 != null) {
                return false;
            }
            String r11 = r();
            String r12 = fVar.r();
            if (r11 != null ? !r11.equals(r12) : r12 != null) {
                return false;
            }
            String g11 = g();
            String g12 = fVar.g();
            if (g11 != null ? !g11.equals(g12) : g12 != null) {
                return false;
            }
            String h11 = h();
            String h12 = fVar.h();
            if (h11 != null ? !h11.equals(h12) : h12 != null) {
                return false;
            }
            String f11 = f();
            String f12 = fVar.f();
            return f11 != null ? f11.equals(f12) : f12 == null;
        }

        public String f() {
            return this.f45104o;
        }

        public String g() {
            return this.f45102m;
        }

        public String h() {
            return this.f45103n;
        }

        public int hashCode() {
            String o11 = o();
            int i11 = 43;
            int hashCode = o11 == null ? 43 : o11.hashCode();
            String j11 = j();
            int hashCode2 = ((hashCode + 59) * 59) + (j11 == null ? 43 : j11.hashCode());
            String k11 = k();
            int hashCode3 = (hashCode2 * 59) + (k11 == null ? 43 : k11.hashCode());
            String e11 = e();
            int hashCode4 = (hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode());
            String p11 = p();
            int hashCode5 = (hashCode4 * 59) + (p11 == null ? 43 : p11.hashCode());
            String n11 = n();
            int hashCode6 = (hashCode5 * 59) + (n11 == null ? 43 : n11.hashCode());
            String i12 = i();
            int hashCode7 = (hashCode6 * 59) + (i12 == null ? 43 : i12.hashCode());
            String l11 = l();
            int hashCode8 = (hashCode7 * 59) + (l11 == null ? 43 : l11.hashCode());
            String q11 = q();
            int hashCode9 = (hashCode8 * 59) + (q11 == null ? 43 : q11.hashCode());
            String m11 = m();
            int hashCode10 = (hashCode9 * 59) + (m11 == null ? 43 : m11.hashCode());
            String s11 = s();
            int hashCode11 = (hashCode10 * 59) + (s11 == null ? 43 : s11.hashCode());
            String r11 = r();
            int hashCode12 = (hashCode11 * 59) + (r11 == null ? 43 : r11.hashCode());
            String g11 = g();
            int hashCode13 = (hashCode12 * 59) + (g11 == null ? 43 : g11.hashCode());
            String h11 = h();
            int hashCode14 = (hashCode13 * 59) + (h11 == null ? 43 : h11.hashCode());
            String f11 = f();
            int i13 = hashCode14 * 59;
            if (f11 != null) {
                i11 = f11.hashCode();
            }
            return i13 + i11;
        }

        public String i() {
            return this.f45096g;
        }

        public String j() {
            return this.f45091b;
        }

        public String k() {
            return this.f45092c;
        }

        public String l() {
            return this.f45097h;
        }

        public String m() {
            return this.f45099j;
        }

        public String n() {
            return this.f45095f;
        }

        public String o() {
            return this.f45090a;
        }

        public String p() {
            return this.f45094e;
        }

        public String q() {
            return this.f45098i;
        }

        public String r() {
            return this.f45101l;
        }

        public String s() {
            return this.f45100k;
        }

        public void t(String str) {
            this.f45098i = str;
        }

        public String toString() {
            return "FutureLimitOrderEditDialogHelper.ShowBean(orderId=" + o() + ", entrustPrice=" + j() + ", entrustVolume=" + k() + ", contractCode=" + e() + ", orderPriceType=" + p() + ", offset=" + n() + ", direction=" + i() + ", leverRate=" + l() + ", positionSide=" + q() + ", marginMode=" + m() + ", symbol=" + s() + ", quoteCurrency=" + r() + ", contractShortType=" + g() + ", contractType=" + h() + ", contractFace=" + f() + ")";
        }

        public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, SwapCurrencyInfo swapCurrencyInfo) {
            this.f45090a = str;
            this.f45091b = str2;
            this.f45092c = str3;
            this.f45093d = str4;
            this.f45094e = str5;
            this.f45095f = str6;
            this.f45096g = str7;
            this.f45097h = str8;
            this.f45100k = swapCurrencyInfo.getSymbol();
            this.f45102m = swapCurrencyInfo.getContractShortType();
            this.f45103n = swapCurrencyInfo.getContractType();
            this.f45104o = swapCurrencyInfo.getContractFace();
            this.f45101l = str4.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
        }

        public f(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ContractCurrencyInfo contractCurrencyInfo) {
            this.f45090a = str;
            this.f45091b = str2;
            this.f45092c = str3;
            this.f45093d = str4;
            this.f45094e = str5;
            this.f45095f = str6;
            this.f45096g = str7;
            this.f45097h = str8;
            this.f45100k = contractCurrencyInfo.getSymbol();
            this.f45102m = contractCurrencyInfo.getContractShortType();
            this.f45103n = contractCurrencyInfo.getContractType();
            this.f45104o = contractCurrencyInfo.getContractFace();
            this.f45101l = "usd".toUpperCase(Locale.US);
        }
    }
}
