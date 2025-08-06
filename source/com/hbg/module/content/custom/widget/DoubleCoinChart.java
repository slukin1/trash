package com.hbg.module.content.custom.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.h;
import com.blankj.utilcode.util.v;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$color;
import com.hbg.module.content.R$id;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.R$raw;
import com.hbg.module.content.R$string;
import com.huobi.edgeengine.template.widget.Widget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;
import rj.n;

public final class DoubleCoinChart extends Widget {
    public static final a D0 = new a((r) null);
    public Integer A0;
    public String B0;
    public String C0;

    /* renamed from: h0  reason: collision with root package name */
    public RadioGroup f18155h0;

    /* renamed from: i0  reason: collision with root package name */
    public RadioButton f18156i0;

    /* renamed from: j0  reason: collision with root package name */
    public RadioButton f18157j0;

    /* renamed from: k0  reason: collision with root package name */
    public RadioButton f18158k0;

    /* renamed from: l0  reason: collision with root package name */
    public TextView f18159l0;

    /* renamed from: m0  reason: collision with root package name */
    public TextView f18160m0;

    /* renamed from: n0  reason: collision with root package name */
    public SafeLottieView f18161n0;

    /* renamed from: o0  reason: collision with root package name */
    public View f18162o0;

    /* renamed from: p0  reason: collision with root package name */
    public View f18163p0;

    /* renamed from: q0  reason: collision with root package name */
    public RelativeLayout f18164q0;

    /* renamed from: r0  reason: collision with root package name */
    public TextView f18165r0;

    /* renamed from: s0  reason: collision with root package name */
    public TextView f18166s0;

    /* renamed from: t0  reason: collision with root package name */
    public TextView f18167t0;

    /* renamed from: u0  reason: collision with root package name */
    public String f18168u0 = "";

    /* renamed from: v0  reason: collision with root package name */
    public String f18169v0;

    /* renamed from: w0  reason: collision with root package name */
    public String f18170w0;

    /* renamed from: x0  reason: collision with root package name */
    public String f18171x0;

    /* renamed from: y0  reason: collision with root package name */
    public String f18172y0;

    /* renamed from: z0  reason: collision with root package name */
    public String f18173z0;

    public static final class ChartBaseData implements Serializable {
        private final String baseCoin;
        private final String hookPrice;
        private final String productTypeId;
        private final String quoteCoin;

        public ChartBaseData(String str, String str2, String str3, String str4) {
            this.productTypeId = str;
            this.baseCoin = str2;
            this.quoteCoin = str3;
            this.hookPrice = str4;
        }

        public static /* synthetic */ ChartBaseData copy$default(ChartBaseData chartBaseData, String str, String str2, String str3, String str4, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = chartBaseData.productTypeId;
            }
            if ((i11 & 2) != 0) {
                str2 = chartBaseData.baseCoin;
            }
            if ((i11 & 4) != 0) {
                str3 = chartBaseData.quoteCoin;
            }
            if ((i11 & 8) != 0) {
                str4 = chartBaseData.hookPrice;
            }
            return chartBaseData.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.productTypeId;
        }

        public final String component2() {
            return this.baseCoin;
        }

        public final String component3() {
            return this.quoteCoin;
        }

        public final String component4() {
            return this.hookPrice;
        }

        public final ChartBaseData copy(String str, String str2, String str3, String str4) {
            return new ChartBaseData(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChartBaseData)) {
                return false;
            }
            ChartBaseData chartBaseData = (ChartBaseData) obj;
            return x.b(this.productTypeId, chartBaseData.productTypeId) && x.b(this.baseCoin, chartBaseData.baseCoin) && x.b(this.quoteCoin, chartBaseData.quoteCoin) && x.b(this.hookPrice, chartBaseData.hookPrice);
        }

        public final String getBaseCoin() {
            return this.baseCoin;
        }

        public final String getHookPrice() {
            return this.hookPrice;
        }

        public final String getProductTypeId() {
            return this.productTypeId;
        }

        public final String getQuoteCoin() {
            return this.quoteCoin;
        }

        public int hashCode() {
            String str = this.productTypeId;
            int i11 = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.baseCoin;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.quoteCoin;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.hookPrice;
            if (str4 != null) {
                i11 = str4.hashCode();
            }
            return hashCode3 + i11;
        }

        public String toString() {
            return "ChartBaseData(productTypeId=" + this.productTypeId + ", baseCoin=" + this.baseCoin + ", quoteCoin=" + this.quoteCoin + ", hookPrice=" + this.hookPrice + ')';
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    @SensorsDataInstrumented
    public static final void d0(DoubleCoinChart doubleCoinChart, RadioGroup radioGroup, int i11) {
        doubleCoinChart.j0();
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    public static final void g0(DoubleCoinChart doubleCoinChart, Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            doubleCoinChart.f18173z0 = jSONObject.getString("hookPrice");
            doubleCoinChart.A0 = Integer.valueOf(jSONObject.getInt("productTypeId"));
            String string = jSONObject.getString("baseCoin");
            Locale locale = Locale.ROOT;
            doubleCoinChart.B0 = string.toUpperCase(locale);
            doubleCoinChart.C0 = jSONObject.getString("quoteCoin").toUpperCase(locale);
            doubleCoinChart.c0(context);
            doubleCoinChart.k0(context);
            doubleCoinChart.j0();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void h0(DoubleCoinChart doubleCoinChart, Context context, String str) {
        RadioGroup radioGroup;
        try {
            if (TextUtils.isEmpty(str) && doubleCoinChart.f0() == 3 && (radioGroup = doubleCoinChart.f18155h0) != null) {
                radioGroup.check(R$id.rb_1);
            }
            doubleCoinChart.f18171x0 = str;
            doubleCoinChart.c0(context);
            doubleCoinChart.k0(context);
            doubleCoinChart.j0();
            doubleCoinChart.l0(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void i0(DoubleCoinChart doubleCoinChart, Context context, String str) {
        try {
            doubleCoinChart.f18169v0 = str;
            doubleCoinChart.l0(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        String str = null;
        this.f18168u0 = map != null ? map.get("chartBaseData") : null;
        this.f18172y0 = map != null ? map.get("withDrawPrice") : null;
        if (map != null) {
            str = map.get(FirebaseAnalytics.Param.QUANTITY);
        }
        this.f18170w0 = str;
    }

    @SuppressLint({"SetTextI18n"})
    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        w(context, this.f18168u0, new c(this, context), nVar);
        w(context, this.f18172y0, new b(this, context), nVar);
        w(context, this.f18170w0, new d(this, context), nVar);
        return Q;
    }

    public final void b0(int i11) {
        SafeLottieView safeLottieView = this.f18161n0;
        if (safeLottieView != null) {
            safeLottieView.setTranslationY((((float) i11) * 1.0f) + ((float) v.a(40.0f)));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void c0(Context context) {
        ViewGroup.LayoutParams layoutParams = null;
        String string = context != null ? context.getString(R$string.n_double_coin_and) : null;
        if (TextUtils.isEmpty(this.f18171x0)) {
            RadioButton radioButton = this.f18157j0;
            if (radioButton != null) {
                layoutParams = radioButton.getLayoutParams();
            }
            ((LinearLayout.LayoutParams) layoutParams).weight = 1.0f;
            RadioButton radioButton2 = this.f18158k0;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
            }
        } else {
            RadioButton radioButton3 = this.f18157j0;
            if (radioButton3 != null) {
                layoutParams = radioButton3.getLayoutParams();
            }
            ((LinearLayout.LayoutParams) layoutParams).weight = 2.0f;
            RadioButton radioButton4 = this.f18158k0;
            if (radioButton4 != null) {
                radioButton4.setVisibility(0);
            }
        }
        Integer num = this.A0;
        if (num != null && num.intValue() == 5) {
            if (TextUtils.isEmpty(this.f18171x0)) {
                RadioButton radioButton5 = this.f18156i0;
                if (radioButton5 != null) {
                    radioButton5.setText(8804 + this.f18173z0);
                }
                RadioButton radioButton6 = this.f18157j0;
                if (radioButton6 != null) {
                    radioButton6.setText('>' + this.f18173z0);
                    return;
                }
                return;
            }
            RadioButton radioButton7 = this.f18156i0;
            if (radioButton7 != null) {
                radioButton7.setText('>' + this.f18173z0);
            }
            RadioButton radioButton8 = this.f18157j0;
            if (radioButton8 != null) {
                radioButton8.setText(8805 + this.f18171x0 + string + '<' + this.f18173z0);
            }
            RadioButton radioButton9 = this.f18158k0;
            if (radioButton9 != null) {
                radioButton9.setText(8804 + this.f18171x0);
            }
        } else if (TextUtils.isEmpty(this.f18171x0)) {
            RadioButton radioButton10 = this.f18156i0;
            if (radioButton10 != null) {
                radioButton10.setText(8805 + this.f18173z0);
            }
            RadioButton radioButton11 = this.f18157j0;
            if (radioButton11 != null) {
                radioButton11.setText('<' + this.f18173z0);
            }
        } else {
            RadioButton radioButton12 = this.f18156i0;
            if (radioButton12 != null) {
                radioButton12.setText('<' + this.f18173z0);
            }
            RadioButton radioButton13 = this.f18157j0;
            if (radioButton13 != null) {
                radioButton13.setText(8805 + this.f18173z0 + string + '<' + this.f18171x0);
            }
            RadioButton radioButton14 = this.f18158k0;
            if (radioButton14 != null) {
                radioButton14.setText(8805 + this.f18171x0);
            }
        }
    }

    public final String e0(String str) {
        return m.a(str).setScale(8, RoundingMode.DOWN).stripTrailingZeros().toPlainString();
    }

    public final int f0() {
        RadioGroup radioGroup = this.f18155h0;
        Integer valueOf = radioGroup != null ? Integer.valueOf(radioGroup.getCheckedRadioButtonId()) : null;
        int i11 = R$id.rb_1;
        if (valueOf != null && valueOf.intValue() == i11) {
            return 1;
        }
        int i12 = R$id.rb_2;
        if (valueOf != null && valueOf.intValue() == i12) {
            return 2;
        }
        int i13 = R$id.rb_3;
        if (valueOf != null && valueOf.intValue() == i13) {
            return 3;
        }
        return 1;
    }

    @SuppressLint({"SetTextI18n"})
    public final void j0() {
        Integer num = this.A0;
        if (num != null && num.intValue() == 5) {
            int f02 = f0();
            if (f02 == 1) {
                if (TextUtils.isEmpty(this.f18171x0)) {
                    b0(v.a(-25.0f));
                    SafeLottieView safeLottieView = this.f18161n0;
                    if (safeLottieView != null) {
                        safeLottieView.setAnimation(R$raw.buy_success);
                    }
                } else {
                    b0(v.a(-45.0f));
                    SafeLottieView safeLottieView2 = this.f18161n0;
                    if (safeLottieView2 != null) {
                        safeLottieView2.setAnimation(R$raw.buy_error);
                    }
                }
                SafeLottieView safeLottieView3 = this.f18161n0;
                if (safeLottieView3 != null) {
                    safeLottieView3.playAnimation();
                }
            } else if (f02 == 2) {
                if (TextUtils.isEmpty(this.f18171x0)) {
                    b0(v.a(-45.0f));
                    SafeLottieView safeLottieView4 = this.f18161n0;
                    if (safeLottieView4 != null) {
                        safeLottieView4.setAnimation(R$raw.buy_error);
                    }
                } else {
                    b0(v.a(-25.0f));
                    SafeLottieView safeLottieView5 = this.f18161n0;
                    if (safeLottieView5 != null) {
                        safeLottieView5.setAnimation(R$raw.buy_success);
                    }
                }
                SafeLottieView safeLottieView6 = this.f18161n0;
                if (safeLottieView6 != null) {
                    safeLottieView6.playAnimation();
                }
            } else if (f02 == 3) {
                b0(0);
                SafeLottieView safeLottieView7 = this.f18161n0;
                if (safeLottieView7 != null) {
                    safeLottieView7.setAnimation(R$raw.with_draw_buy_error);
                }
                SafeLottieView safeLottieView8 = this.f18161n0;
                if (safeLottieView8 != null) {
                    safeLottieView8.playAnimation();
                }
            }
        } else {
            int f03 = f0();
            if (f03 == 1) {
                if (TextUtils.isEmpty(this.f18171x0)) {
                    b0(v.a(-20.0f));
                    SafeLottieView safeLottieView9 = this.f18161n0;
                    if (safeLottieView9 != null) {
                        safeLottieView9.setAnimation(R$raw.sell_success);
                    }
                } else {
                    b0(v.a(35.0f));
                    SafeLottieView safeLottieView10 = this.f18161n0;
                    if (safeLottieView10 != null) {
                        safeLottieView10.setAnimation(R$raw.sell_error);
                    }
                }
                SafeLottieView safeLottieView11 = this.f18161n0;
                if (safeLottieView11 != null) {
                    safeLottieView11.playAnimation();
                }
            } else if (f03 == 2) {
                if (TextUtils.isEmpty(this.f18171x0)) {
                    b0(v.a(5.0f));
                    SafeLottieView safeLottieView12 = this.f18161n0;
                    if (safeLottieView12 != null) {
                        safeLottieView12.setAnimation(R$raw.sell_error);
                    }
                } else {
                    b0(v.a(20.0f));
                    SafeLottieView safeLottieView13 = this.f18161n0;
                    if (safeLottieView13 != null) {
                        safeLottieView13.setAnimation(R$raw.sell_success);
                    }
                }
                SafeLottieView safeLottieView14 = this.f18161n0;
                if (safeLottieView14 != null) {
                    safeLottieView14.playAnimation();
                }
            } else if (f03 == 3) {
                b0(0);
                SafeLottieView safeLottieView15 = this.f18161n0;
                if (safeLottieView15 != null) {
                    safeLottieView15.setAnimation(R$raw.with_draw_sell_error);
                }
                SafeLottieView safeLottieView16 = this.f18161n0;
                if (safeLottieView16 != null) {
                    safeLottieView16.playAnimation();
                }
            }
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void k0(Context context) {
        String string;
        String str;
        String string2;
        String string3;
        String str2;
        String string4;
        Integer num = this.A0;
        String str3 = null;
        if (num != null && num.intValue() == 5) {
            TextView textView = this.f18159l0;
            if (textView != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(context != null ? context.getString(R$string.n_double_coin_earn_target_price) : null);
                sb2.append(' ');
                sb2.append(this.f18173z0);
                textView.setText(sb2.toString());
            }
            TextView textView2 = this.f18165r0;
            if (textView2 != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(context != null ? context.getString(R$string.n_double_coin_return_money_price) : null);
                sb3.append(" --");
                sb3.append(this.C0);
                textView2.setText(sb3.toString());
            }
            TextView textView3 = this.f18165r0;
            if (textView3 != null) {
                textView3.setTextColor(h.a(R$color.KBaseRiskTextColorMid));
            }
            View view = this.f18162o0;
            if (view != null) {
                view.setBackgroundResource(R$color.KBaseRiskTextColorMid);
            }
            View view2 = this.f18163p0;
            if (view2 != null) {
                view2.setBackgroundResource(R$color.kColorPriceGreen);
            }
            if (!TextUtils.isEmpty(this.f18171x0)) {
                RelativeLayout relativeLayout = this.f18164q0;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                TextView textView4 = this.f18160m0;
                if (textView4 != null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(context != null ? context.getString(R$string.n_double_coin_with_draw_price) : null);
                    sb4.append(' ');
                    sb4.append(this.f18171x0);
                    textView4.setText(sb4.toString());
                }
                TextView textView5 = this.f18166s0;
                if (textView5 != null) {
                    if (context == null || (string4 = context.getString(R$string.n_double_coin_low_buy_success)) == null) {
                        str2 = null;
                    } else {
                        str2 = String.format(string4, Arrays.copyOf(new Object[]{"--" + this.B0}, 1));
                    }
                    textView5.setText(str2);
                }
                TextView textView6 = this.f18166s0;
                if (textView6 != null) {
                    textView6.setTextColor(h.a(R$color.kColorPriceGreen));
                }
                TextView textView7 = this.f18167t0;
                if (textView7 != null) {
                    StringBuilder sb5 = new StringBuilder();
                    if (context != null) {
                        str3 = context.getString(R$string.n_double_coin_return_money_price);
                    }
                    sb5.append(str3);
                    sb5.append(" --");
                    sb5.append(this.C0);
                    textView7.setText(sb5.toString());
                }
                TextView textView8 = this.f18167t0;
                if (textView8 != null) {
                    textView8.setTextColor(h.a(R$color.KBaseRiskTextColorMid));
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout2 = this.f18164q0;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            TextView textView9 = this.f18167t0;
            if (textView9 != null) {
                if (!(context == null || (string3 = context.getString(R$string.n_double_coin_low_buy_success)) == null)) {
                    str3 = String.format(string3, Arrays.copyOf(new Object[]{"--" + this.B0}, 1));
                }
                textView9.setText(str3);
            }
            TextView textView10 = this.f18167t0;
            if (textView10 != null) {
                textView10.setTextColor(h.a(R$color.kColorPriceGreen));
            }
        } else if (!TextUtils.isEmpty(this.f18171x0)) {
            RelativeLayout relativeLayout3 = this.f18164q0;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            }
            TextView textView11 = this.f18160m0;
            if (textView11 != null) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(context != null ? context.getString(R$string.n_double_coin_earn_target_price) : null);
                sb6.append(' ');
                sb6.append(this.f18173z0);
                textView11.setText(sb6.toString());
            }
            TextView textView12 = this.f18165r0;
            if (textView12 != null) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(context != null ? context.getString(R$string.n_double_coin_return_money_price) : null);
                sb7.append(" --");
                sb7.append(this.B0);
                textView12.setText(sb7.toString());
            }
            TextView textView13 = this.f18165r0;
            if (textView13 != null) {
                textView13.setTextColor(h.a(R$color.KBaseRiskTextColorMid));
            }
            TextView textView14 = this.f18159l0;
            if (textView14 != null) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(context != null ? context.getString(R$string.n_double_coin_with_draw_price) : null);
                sb8.append(' ');
                sb8.append(this.f18171x0);
                textView14.setText(sb8.toString());
            }
            TextView textView15 = this.f18166s0;
            if (textView15 != null) {
                if (context == null || (string2 = context.getString(R$string.n_double_coin_high_sell_success)) == null) {
                    str = null;
                } else {
                    str = String.format(string2, Arrays.copyOf(new Object[]{"--" + this.C0}, 1));
                }
                textView15.setText(str);
            }
            TextView textView16 = this.f18166s0;
            if (textView16 != null) {
                textView16.setTextColor(h.a(R$color.kColorPriceGreen));
            }
            TextView textView17 = this.f18167t0;
            if (textView17 != null) {
                StringBuilder sb9 = new StringBuilder();
                if (context != null) {
                    str3 = context.getString(R$string.n_double_coin_return_money_price);
                }
                sb9.append(str3);
                sb9.append(" --");
                sb9.append(this.B0);
                textView17.setText(sb9.toString());
            }
            TextView textView18 = this.f18167t0;
            if (textView18 != null) {
                textView18.setTextColor(h.a(R$color.KBaseRiskTextColorMid));
            }
            View view3 = this.f18162o0;
            if (view3 != null) {
                view3.setBackgroundResource(R$color.KBaseRiskTextColorMid);
            }
            View view4 = this.f18163p0;
            if (view4 != null) {
                view4.setBackgroundResource(R$color.kColorPriceGreen);
            }
        } else {
            RelativeLayout relativeLayout4 = this.f18164q0;
            if (relativeLayout4 != null) {
                relativeLayout4.setVisibility(8);
            }
            TextView textView19 = this.f18159l0;
            if (textView19 != null) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(context != null ? context.getString(R$string.n_double_coin_earn_target_price) : null);
                sb10.append(' ');
                sb10.append(this.f18173z0);
                textView19.setText(sb10.toString());
            }
            TextView textView20 = this.f18167t0;
            if (textView20 != null) {
                StringBuilder sb11 = new StringBuilder();
                sb11.append(context != null ? context.getString(R$string.n_double_coin_return_money_price) : null);
                sb11.append(" --");
                sb11.append(this.B0);
                textView20.setText(sb11.toString());
            }
            TextView textView21 = this.f18167t0;
            if (textView21 != null) {
                textView21.setTextColor(h.a(R$color.KBaseRiskTextColorMid));
            }
            TextView textView22 = this.f18165r0;
            if (textView22 != null) {
                if (!(context == null || (string = context.getString(R$string.n_double_coin_high_sell_success)) == null)) {
                    str3 = String.format(string, Arrays.copyOf(new Object[]{"--" + this.C0}, 1));
                }
                textView22.setText(str3);
            }
            TextView textView23 = this.f18165r0;
            if (textView23 != null) {
                textView23.setTextColor(h.a(R$color.kColorPriceGreen));
            }
            View view5 = this.f18162o0;
            if (view5 != null) {
                view5.setBackgroundResource(R$color.kColorPriceGreen);
            }
            View view6 = this.f18163p0;
            if (view6 != null) {
                view6.setBackgroundResource(R$color.KBaseRiskTextColorMid);
            }
        }
    }

    public final void l0(Context context) {
        String str;
        String string;
        String string2;
        String str2 = this.f18169v0;
        if (str2 == null) {
            str2 = "0";
        }
        String e02 = e0(str2);
        String e03 = e0(m.a(e02).divide(m.a(this.f18173z0), 18, RoundingMode.DOWN).toPlainString());
        String str3 = null;
        if (context == null || (string2 = context.getString(R$string.n_double_coin_low_buy_success)) == null) {
            str = null;
        } else {
            str = String.format(string2, Arrays.copyOf(new Object[]{e03 + ' ' + this.B0}, 1));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context != null ? context.getString(R$string.n_double_coin_return_money_price) : null);
        sb2.append(10);
        sb2.append(e02);
        sb2.append(' ');
        sb2.append(this.C0);
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(context != null ? context.getString(R$string.n_double_coin_return_money_price) : null);
        sb4.append(10);
        sb4.append(e02);
        sb4.append(' ');
        sb4.append(this.B0);
        String sb5 = sb4.toString();
        String plainString = m.a(m.a(e02).multiply(m.a(this.f18173z0)).toPlainString().toString()).stripTrailingZeros().toPlainString();
        if (!(context == null || (string = context.getString(R$string.n_double_coin_high_sell_success)) == null)) {
            str3 = String.format(string, Arrays.copyOf(new Object[]{plainString + ' ' + this.C0}, 1));
        }
        Integer num = this.A0;
        if (num != null && num.intValue() == 5) {
            if (!TextUtils.isEmpty(this.f18171x0)) {
                TextView textView = this.f18165r0;
                if (textView != null) {
                    textView.setText(sb3);
                }
                TextView textView2 = this.f18166s0;
                if (textView2 != null) {
                    textView2.setText(str);
                }
                TextView textView3 = this.f18167t0;
                if (textView3 != null) {
                    textView3.setText(sb3);
                    return;
                }
                return;
            }
            TextView textView4 = this.f18165r0;
            if (textView4 != null) {
                textView4.setText(sb3);
            }
            TextView textView5 = this.f18167t0;
            if (textView5 != null) {
                textView5.setText(str);
            }
        } else if (!TextUtils.isEmpty(this.f18171x0)) {
            TextView textView6 = this.f18165r0;
            if (textView6 != null) {
                textView6.setText(sb5);
            }
            TextView textView7 = this.f18166s0;
            if (textView7 != null) {
                textView7.setText(str3);
            }
            TextView textView8 = this.f18167t0;
            if (textView8 != null) {
                textView8.setText(sb5);
            }
        } else {
            TextView textView9 = this.f18167t0;
            if (textView9 != null) {
                textView9.setText(sb5);
            }
            TextView textView10 = this.f18165r0;
            if (textView10 != null) {
                textView10.setText(str3);
            }
        }
    }

    public View q(Context context) {
        View inflate = View.inflate(context, R$layout.view_double_coin_chart, (ViewGroup) null);
        this.f18155h0 = (RadioGroup) inflate.findViewById(R$id.rb_tab);
        this.f18156i0 = (RadioButton) inflate.findViewById(R$id.rb_1);
        this.f18157j0 = (RadioButton) inflate.findViewById(R$id.rb_2);
        this.f18158k0 = (RadioButton) inflate.findViewById(R$id.rb_3);
        this.f18159l0 = (TextView) inflate.findViewById(R$id.tv_lev1_price);
        this.f18160m0 = (TextView) inflate.findViewById(R$id.tv_lev2_price);
        this.f18161n0 = (SafeLottieView) inflate.findViewById(R$id.slv);
        this.f18162o0 = inflate.findViewById(R$id.v_ver_line_2);
        this.f18163p0 = inflate.findViewById(R$id.v_ver_line_4);
        this.f18164q0 = (RelativeLayout) inflate.findViewById(R$id.rl_with_draw_price);
        this.f18165r0 = (TextView) inflate.findViewById(R$id.tv_result_1);
        this.f18166s0 = (TextView) inflate.findViewById(R$id.tv_result_2);
        this.f18167t0 = (TextView) inflate.findViewById(R$id.tv_result_3);
        ((TextView) inflate.findViewById(R$id.tv_current_str)).setText(com.blankj.utilcode.util.x.b(R$string.n_double_coin_current_time));
        RadioGroup radioGroup = this.f18155h0;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new a(this));
        }
        return inflate;
    }
}
