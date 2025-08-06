package com.hbg.module.option.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionPositionInfo;
import com.hbg.module.option.R$color;
import com.hbg.module.option.R$id;
import com.hbg.module.option.R$layout;
import com.hbg.module.option.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import s9.c;
import tf.d;
import tf.f;
import tf.g;

public class OptionPositionOrderItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void i(sf.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().b(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void j(sf.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().a(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(sf.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().e(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(sf.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().d(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(sf.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().c(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final SpannableStringBuilder g(Context context, String str, String str2) {
        BigDecimal a11 = m.a(str);
        String q11 = m.q(a11.multiply(m.f68179a), FuturePrecisionUtil.q(str2));
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("+" + q11 + "%");
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            return spannableStringBuilder;
        } else if (a11.compareTo(BigDecimal.ZERO) < 0) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(q11 + "%");
            if (w.l()) {
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder2.length(), 33);
                return spannableStringBuilder2;
            }
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder2.length(), 33);
            return spannableStringBuilder2;
        } else {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(q11 + "%");
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_default_text_color)), 0, spannableStringBuilder3.length(), 33);
            return spannableStringBuilder3;
        }
    }

    public int getResId() {
        return R$layout.layout_option_position_order_list_item;
    }

    /* renamed from: h */
    public void handleView(v9.c cVar, int i11, sf.c cVar2, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        sf.c cVar3 = cVar2;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        Resources resources = context.getResources();
        OptionPositionInfo e12 = cVar2.e();
        if (cVar2.d() != null) {
            str = StringUtils.i(cVar2.d().getQuoteCurrency());
        } else {
            str = "";
        }
        TextView textView = (TextView) e11.b(R$id.contract_position_amount_label_tv);
        TextView textView2 = (TextView) e11.b(R$id.contract_position_amount_value_tv);
        String str4 = "";
        TextView textView3 = (TextView) e11.b(R$id.contract_position_available_label_tv);
        TextView textView4 = (TextView) e11.b(R$id.contract_position_available_value_tv);
        TextView textView5 = (TextView) e11.b(R$id.contract_position_profit_unreal_value_tv);
        TextView textView6 = (TextView) e11.b(R$id.contract_position_cost_hold_label_tv);
        TextView textView7 = (TextView) e11.b(R$id.contract_position_margin_value_tv);
        TextView textView8 = (TextView) e11.b(R$id.contract_position_close_tv);
        View b11 = e11.b(R$id.contract_position_close_quick);
        ImageButton imageButton = (ImageButton) e11.b(R$id.contract_position_share_tv);
        TextView textView9 = (TextView) e11.b(R$id.contract_position_current_price_value_tv);
        TextView textView10 = (TextView) e11.b(R$id.contract_position_profit_unreal_label_tv);
        View b12 = e11.b(R$id.status_button_contract_item_stop_profit);
        TextView textView11 = (TextView) e11.b(R$id.contract_position_open_value_tv);
        TextView textView12 = (TextView) e11.b(R$id.contract_position_cost_hold_value_tv);
        ((TextView) e11.b(R$id.contract_position_label_tv)).setText(e.A(e12.getSymbol(), e12.getOptionCode(), context, context.getResources().getColor(R$color.baseColorPrimaryText), e12.getDirection()));
        ((TextView) e11.b(R$id.contract_position_profit_rate_tv)).setText(g(context, e12.getProfitRate(), e12.getSymbol()));
        ((TextView) e11.b(R$id.contract_position_open_label_tv)).setText(resources.getString(R$string.n_contract_avg_open_price) + "(" + str + ")");
        ((TextView) e11.b(R$id.contract_position_current_price_label_tv)).setText(resources.getString(R$string.n_option_market_value) + "(" + str + ")");
        int s11 = FuturePrecisionUtil.s(e12.getContractCode(), (String) null, e12.getOptionCode());
        int y11 = FuturePrecisionUtil.y(e12.getContractCode(), (String) null, e12.getOptionCode());
        TradeType tradeType = TradeType.OPTION;
        if (e.E(tradeType)) {
            textView.setText(String.format(context.getString(R$string.contarct_position_volume_label), new Object[]{e12.getSymbol()}));
            textView3.setText(String.format(context.getString(R$string.contarct_position_available_label), new Object[]{e12.getSymbol()}));
            if (m.a(e12.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                textView2.setText(m.m("0", s11));
                str2 = m.m("0", s11);
            } else {
                String contractFace = cVar2.d() != null ? cVar2.d().getContractFace() : str4;
                textView2.setText(m.m(FutureUnitUtil.a(e12.getVolume(), e12.getLastPrice(), contractFace, tradeType), s11));
                str2 = m.m(FutureUnitUtil.a(e12.getAvailable(), e12.getLastPrice(), contractFace, tradeType), s11);
            }
        } else {
            String string = context.getString(R$string.contarct_position_volume_label);
            int i12 = R$string.contract_market_vol_sheet;
            textView.setText(String.format(string, new Object[]{context.getString(i12)}));
            textView3.setText(String.format(context.getString(R$string.contarct_position_available_label), new Object[]{context.getString(i12)}));
            textView2.setText(m.m(e12.getVolume(), FuturePrecisionUtil.B()));
            str2 = m.m(e12.getAvailable(), FuturePrecisionUtil.B());
        }
        textView4.setText("≤ " + str2);
        textView12.setText(m.m(e12.getIndexPrice(), FuturePrecisionUtil.j(e12.getSymbol())));
        textView11.setText(m.m(e12.getCostOpen(), y11));
        textView10.setText(String.format(context.getString(R$string.contarct_position_profit_unreal_label), new Object[]{str}));
        textView6.setText(String.format(context.getString(R$string.n_option_index_price_unit), new Object[]{str}));
        textView5.setText(m.m(e12.getProfitUnreal(), FuturePrecisionUtil.o(str)));
        textView9.setText(m.u(e12.getPositionValue(), y11));
        int o11 = FuturePrecisionUtil.o(str);
        int w11 = FuturePrecisionUtil.w(e12.getContractCode(), (String) null, e12.getOptionCode());
        if (e12.isDuo()) {
            str3 = "--";
        } else if (e12.isRiseType()) {
            str3 = m.m(e12.getPositionMargin(), w11) + " " + e12.getMarginCurrency();
        } else {
            str3 = m.m(e12.getPositionMargin(), o11) + " " + e12.getMarginCurrency();
        }
        textView7.setText(str3);
        sf.c cVar4 = cVar2;
        textView8.setOnClickListener(new tf.e(cVar4));
        b11.setOnClickListener(new g(cVar4));
        imageButton.setOnClickListener(new f(cVar4));
        b12.setOnClickListener(new d(cVar4));
        cVar.itemView.setOnClickListener(new tf.c(cVar4));
    }
}
