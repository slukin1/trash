package com.huobi.finance.viewhandler;

import al.l;
import al.p;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import bl.a0;
import bl.v;
import bl.x;
import bl.y;
import bl.z;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.w;
import com.hbg.lib.network.hbg.core.bean.MiningItem;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.share.AssetShareHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import java.util.List;
import java.util.Locale;
import s9.d;
import uh.b;
import v9.c;
import vk.e;

public class AssetPositionEarnItemViewHandler implements d<e> {

    public class a implements AssetShareHelper.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f67588a;

        public a(String str) {
            this.f67588a = str;
        }

        public int a() {
            return 0;
        }

        public int b() {
            String str = this.f67588a;
            if (str == null || Double.valueOf(str).doubleValue() == 0.0d) {
                return R$drawable.share_asset_position_cow_2;
            }
            if (Double.valueOf(this.f67588a).doubleValue() > 0.0d) {
                return R$drawable.share_asset_position_cow_1;
            }
            return R$drawable.share_asset_position_cow_3;
        }

        public int c() {
            String str = this.f67588a;
            if (str == null || Double.valueOf(str).doubleValue() == 0.0d) {
                return R$string.n_asset_share_total_same;
            }
            if (Double.valueOf(this.f67588a).doubleValue() > 0.0d) {
                return R$string.n_asset_share_total_great;
            }
            return R$string.n_asset_share_total_less;
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(boolean z11, StringBuilder sb2, View view) {
        if (!z11) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        b.b(view, sb2.toString(), PixelUtils.a(316.0f));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(Context context, MotionLayout motionLayout, int i11, e eVar, String str, View view) {
        AssetModuleConfig.a().w0(context, "financial/earn/h5?utm_source=totalassets_deatil_buy");
        motionLayout.u0();
        l.f().c(i11, eVar.i());
        gi.a.r(eVar.i(), "subscribe", str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(MotionLayout motionLayout, int i11, e eVar, String str, View view) {
        motionLayout.u0();
        l.f().c(i11, eVar.i());
        gi.a.r(eVar.i(), "redeem", str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(MiningItem miningItem, MotionLayout motionLayout, int i11, e eVar, String str, View view) {
        AssetModuleConfig.a().W(view.getContext(), miningItem.getOrderId());
        motionLayout.u0();
        l.f().c(i11, eVar.i());
        gi.a.r(eVar.i(), "details", str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n(MotionLayout motionLayout, int i11, e eVar, Context context, View view) {
        motionLayout.u0();
        l.f().c(i11, eVar.i());
        p(context, eVar);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(MotionLayout motionLayout, int i11, e eVar, String str, View view) {
        if (motionLayout.getProgress() == 1.0f) {
            motionLayout.u0();
            l.f().c(i11, eVar.i());
        } else if (motionLayout.getProgress() == 0.0f) {
            motionLayout.s0();
            l.f().k(i11, eVar.i());
        }
        gi.a.q(eVar.i(), FirebaseAnalytics.Param.CURRENCY, str);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R$layout.item_asset_position_earn_content;
    }

    /* renamed from: h */
    public void handleView(c cVar, int i11, e eVar, ViewGroup viewGroup) {
        boolean z11;
        String str;
        View view;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        boolean z12;
        boolean z13;
        TextView textView5;
        c cVar2 = cVar;
        int i12 = i11;
        e eVar2 = eVar;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        View b11 = e11.b(R$id.constraintLayout);
        MiningItem j11 = eVar.j();
        String currency = j11.getCurrency();
        TextView textView6 = (TextView) e11.b(R$id.level_coin_symbol);
        TextView textView7 = (TextView) e11.b(R$id.level_position_type);
        TextView textView8 = (TextView) e11.b(R$id.level_contract_bond);
        TextView textView9 = (TextView) e11.b(R$id.level_contract_profit);
        View view2 = b11;
        ((TextView) e11.b(R$id.level_contract_bond_number)).setVisibility(8);
        TextView textView10 = (TextView) e11.b(R$id.asset_p_contract_available);
        MotionLayout motionLayout = (MotionLayout) cVar2.itemView.findViewById(R$id.position_earn_root);
        View b12 = e11.b(R$id.line);
        TextView textView11 = (TextView) e11.b(R$id.asset_p_contract_price);
        TextView textView12 = (TextView) e11.b(R$id.tv_coupon_plus);
        TextView textView13 = (TextView) e11.b(R$id.asset_p_contract_price_content);
        TextView textView14 = (TextView) e11.b(R$id.asset_p_contract_available_content);
        TextView textView15 = (TextView) e11.b(R$id.asset_p_contract_cost_content);
        TextView textView16 = (TextView) e11.b(R$id.level_average_price);
        View b13 = e11.b(R$id.separator_line_view_6_6);
        TextView textView17 = (TextView) e11.b(R$id.level_contract_position);
        TextView textView18 = (TextView) e11.b(R$id.asset_p_contract_margin);
        TextView textView19 = (TextView) e11.b(R$id.asset_p_contract_timer);
        TextView textView20 = (TextView) e11.b(R$id.asset_p_contract_margin_content);
        TextView textView21 = (TextView) e11.b(R$id.asset_p_contract_pl_content);
        View b14 = e11.b(R$id.asset_p_contract_deposit);
        View b15 = e11.b(R$id.asset_p_contract_withdraw);
        TextView textView22 = (TextView) e11.b(R$id.level_contract_profit_number);
        View b16 = e11.b(R$id.asset_p_contract_details);
        View b17 = e11.b(R$id.asset_p_contract_share);
        boolean z14 = j11.getProjectType() == 0;
        ViewUtil.m(textView11, !z14);
        ViewUtil.m(textView13, !z14);
        ViewUtil.m(textView15, !z14);
        ViewUtil.n(b13, !z14);
        b15.setVisibility(8);
        String upperCase = LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        textView10.setText(context.getString(R$string.n_asset_position_year_profit_duration));
        textView11.setText(context.getString(R$string.n_asset_position_confirm_number, new Object[]{upperCase}));
        textView6.setText(currency);
        boolean z15 = j11.getCouponStatus() == 1;
        ViewUtil.m(textView8, false);
        if (j11.getProjectType() == 0) {
            textView7.setText(context.getString(R$string.n_asset_ybb_text));
            textView18.setText(context.getString(R$string.n_asset_position_add_total_number, new Object[]{upperCase}));
            if (eVar.d()) {
                textView9.setText(LegalCurrencyConfigUtil.E(currency, j11.getYesterdayIncome()));
                textView9.setText(String.format("+%s", new Object[]{textView9.getText()}));
                textView3 = textView22;
                p.f(textView3, j11.getYesterdayIncome(), currency);
                textView3.setText(String.format("+%s", new Object[]{textView3.getText()}));
                textView19.setText(context.getString(R$string.n_index_earn_flexible));
                textView = textView20;
                textView.setText(LegalCurrencyConfigUtil.E(currency, j11.getTotalIncomeAmount()));
                textView5 = textView21;
                textView5.setText(p.h(j11.getTotalIncomeAmount()));
            } else {
                textView = textView20;
                textView5 = textView21;
                textView3 = textView22;
                textView9.setText("*****");
                textView3.setText("*****");
            }
            textView9.setTextColor(context.getResources().getColor(w.h()));
            textView3.setTextColor(context.getResources().getColor(w.h()));
            z11 = z15;
            str = "+%s";
            view = b15;
            textView2 = textView5;
        } else {
            TextView textView23 = textView19;
            textView = textView20;
            textView3 = textView22;
            str = "+%s";
            view = b15;
            textView2 = textView21;
            textView7.setText(context.getString(R$string.n_mining_asset_fixed));
            z11 = z15;
            textView18.setText(context.getString(R$string.n_asset_position_estimated_gross_revenue_number, new Object[]{upperCase}));
            if (eVar.d()) {
                textView9.setText(eVar.k());
                textView3.setText(p.j(eVar.l(), eVar.j().getCurrency()));
                textView13.setText(eVar.g());
                textView15.setText(p.j(eVar.h(), eVar.j().getCurrency()));
                if (j11.getTerm() == 0) {
                    textView23.setText("--");
                } else {
                    String string = context.getString(R$string.n_c2c_lend_days);
                    textView23.setText(String.format(string, new Object[]{j11.getTerm() + ""}));
                }
                textView.setText(LegalCurrencyConfigUtil.E(currency, j11.getProIncomeAmount()));
                textView2.setText(p.h(j11.getProIncomeAmount()));
            } else {
                textView9.setText("*****");
                textView13.setText("*****");
                textView15.setText("*****");
            }
            textView9.setTextColor(context.getResources().getColor(w.e()));
            textView3.setTextColor(context.getResources().getColor(w.e()));
        }
        if (eVar.d()) {
            textView17.setText(LegalCurrencyConfigUtil.E(currency, j11.getMiningAmount()));
            p.f(textView16, j11.getMiningAmount(), currency);
            textView14.setText(m.Q(j11.getMiningYearRate(), 2, 1));
            if (z11) {
                textView4 = textView12;
                textView4.setVisibility(0);
                textView4.setText(String.format(str, new Object[]{m.Q(j11.getCouponRate(), 2, 1)}));
            } else {
                textView4 = textView12;
                textView4.setVisibility(8);
            }
        } else {
            textView4 = textView12;
            textView17.setText("*****");
            textView16.setText("*****");
            textView3.setText("*****");
            textView14.setText("*****");
            textView4.setText("*****");
            textView.setText("*****");
            textView2.setText("*****");
            textView.setText("*****");
            textView4.setVisibility(8);
        }
        StringBuilder sb2 = new StringBuilder();
        Boolean isCouponFullAmount = j11.getIsCouponFullAmount();
        if (isCouponFullAmount != null && !isCouponFullAmount.booleanValue()) {
            int i13 = R$string.n_balance_earn_extra_interest_part;
            sb2.append(context.getString(i13, new Object[]{p.j(j11.getCouponMaxAmount(), j11.getCurrency()) + " " + k.C().z(currency)}));
        }
        Boolean isCouponFullTime = j11.getIsCouponFullTime();
        if (isCouponFullTime == null || isCouponFullTime.booleanValue()) {
            z13 = true;
            z12 = false;
        } else {
            z13 = true;
            z12 = false;
            String string2 = context.getString(R$string.n_balance_earn_extra_interest_day, new Object[]{j11.getCouponValidDaysCount()});
            if (sb2.length() > 0) {
                sb2.append("\n");
            }
            sb2.append(string2);
        }
        boolean z16 = sb2.length() > 0 ? z13 : z12;
        ViewUtil.m(b12, z16);
        textView4.setOnClickListener(new a0(z16, sb2));
        int i14 = i11;
        e eVar3 = eVar;
        String str2 = currency;
        b14.setOnClickListener(new v(context, motionLayout, i14, eVar3, str2));
        int i15 = i11;
        e eVar4 = eVar;
        MotionLayout motionLayout2 = motionLayout;
        view.setOnClickListener(new x(motionLayout2, i15, eVar4, currency));
        MotionLayout motionLayout3 = motionLayout2;
        b16.setOnClickListener(new y(j11, motionLayout3, i14, eVar3, str2));
        b17.setOnClickListener(new z(this, motionLayout3, i14, eVar3, context));
        if (l.f().h(i15, eVar.i())) {
            motionLayout2.setProgress(1.0f);
        } else {
            motionLayout2.setProgress(0.0f);
        }
        view2.setOnClickListener(new bl.w(motionLayout2, i15, eVar4, currency));
    }

    /* renamed from: i */
    public void a(c cVar, int i11, e eVar, ViewGroup viewGroup, List<Object> list) {
        if (list != null && !list.isEmpty()) {
            MotionLayout motionLayout = (MotionLayout) cVar.itemView.findViewById(R$id.position_earn_root);
            if (list.get(0).equals("collapse")) {
                motionLayout.u0();
            } else {
                motionLayout.s0();
            }
        }
    }

    public final void p(Context context, e eVar) {
        String str = "0";
        if (!(eVar.j() == null || eVar.j().getMiningYearRate() == null)) {
            str = eVar.j().getMiningYearRate();
        }
        View loadView = AssetShareHelper.loadView(context, str, new a(str));
        ((TextView) loadView.findViewById(R$id.tv_hield_currency)).setText(context.getString(R$string.n_mining_year_profit));
        loadView.findViewById(R$id.layout_title).setVisibility(0);
        ((TextView) loadView.findViewById(R$id.tv_title)).setTextColor(context.getResources().getColor(R$color.white));
        ViewGroup viewGroup = (ViewGroup) loadView.findViewById(R$id.layout_position);
        viewGroup.setVisibility(0);
        LayoutInflater.from(context).inflate(R$layout.layout_asset_position_contract, viewGroup, true);
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.iv_icon);
        imageView.setVisibility(0);
        f6.c.a().l(context, p.k(eVar.j().getCurrency()), imageView, p.m());
        TextView textView = (TextView) viewGroup.findViewById(R$id.tv_symbol);
        textView.setTextSize(0, context.getResources().getDimension(R$dimen.dimen_14));
        textView.setText(eVar.j().getCurrency().toUpperCase());
        TextView textView2 = (TextView) viewGroup.findViewById(R$id.tv_lever_rate);
        textView2.setVisibility(0);
        textView2.setTextColor(context.getResources().getColor(R$color.color_E9EAED));
        if (eVar.j().getProjectType() == 0) {
            textView2.setText(context.getString(R$string.n_asset_ybb_text));
        } else {
            textView2.setText(context.getString(R$string.n_mining_asset_fixed));
        }
        String upperCase = BaseModuleConfig.a().M().toUpperCase();
        ((TextView) viewGroup.findViewById(R$id.tv_price_title)).setText(context.getString(R$string.contarct_share_position_cur_price) + "(" + upperCase.toUpperCase() + ")");
        ((TextView) viewGroup.findViewById(R$id.tv_price)).setText(LegalCurrencyConfigUtil.F(eVar.j().getCurrency(), upperCase, "1"));
        AssetShareHelper.share(context, loadView);
    }
}
