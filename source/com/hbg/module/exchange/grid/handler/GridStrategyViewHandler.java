package com.hbg.module.exchange.grid.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.exchange.R$color;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$string;
import com.hbg.module.exchange.grid.bean.GridStrategyItem;
import com.hbg.module.exchange.grid.ui.GridStrategyStopDialogFragment;
import com.huobi.utils.u0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import d7.k;
import i6.m;
import i6.r;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import oa.a;
import s9.c;
import vc.b;

public class GridStrategyViewHandler implements c, View.OnClickListener {
    public static /* synthetic */ void e(Context context, HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(context, b.a().m(), "", "", false);
        hBDialogFragment.dismiss();
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, GridStrategyItem gridStrategyItem, ViewGroup viewGroup) {
        TextView textView;
        View view;
        TextView textView2;
        ImageButton imageButton;
        char c11;
        GridStrategyItem gridStrategyItem2 = gridStrategyItem;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        GridStrategy d11 = gridStrategyItem.d();
        StringUtils.i(d11.getQuoteCurrency());
        String z11 = k.C().z(d11.getQuoteCurrency());
        d11.getBaseCurrency();
        String symbol = d11.getSymbol();
        int status = d11.getStatus();
        TextView textView3 = (TextView) e11.b(R$id.grid_strategy_profit_label_tv);
        TextView textView4 = (TextView) e11.b(R$id.grid_strategy_profit_value_tv);
        TextView textView5 = (TextView) e11.b(R$id.grid_strategy_grid_revenue_label_tv);
        TextView textView6 = (TextView) e11.b(R$id.grid_strategy_annualized_yield_label_tv);
        TextView textView7 = (TextView) e11.b(R$id.grid_strategy_floating_income_value_tv);
        TextView textView8 = (TextView) e11.b(R$id.grid_strategy_floating_income_label_tv);
        ImageButton imageButton2 = (ImageButton) e11.b(R$id.grid_strategy_share_tv);
        TextView textView9 = (TextView) e11.b(R$id.grid_strategy_annualized_yield_value_tv);
        TextView textView10 = (TextView) e11.b(R$id.grid_lowest_price_label_tv);
        TextView textView11 = (TextView) e11.b(R$id.grid_lowest_price_value_tv);
        TextView textView12 = (TextView) e11.b(R$id.grid_strategy_highest_price_label_tv);
        TextView textView13 = (TextView) e11.b(R$id.grid_strategy_highest_price_value_tv);
        TextView textView14 = (TextView) e11.b(R$id.grid_strategy_number_value_tv);
        TextView textView15 = (TextView) e11.b(R$id.grid_strategy_status_tv);
        View b11 = e11.b(R$id.grid_strategy_stop_ll);
        TextView textView16 = (TextView) e11.b(R$id.gird_strategy_detail_btn);
        ((TextView) e11.b(R$id.grid_strategy_symbol_tv)).setText(a1.v().W(d11.getSymbol()));
        Locale locale = Locale.ENGLISH;
        String string = context.getString(R$string.n_grid_strategy_name);
        TextView textView17 = (TextView) e11.b(R$id.grid_strategy_grid_revenue_value_tv);
        ((TextView) e11.b(R$id.grid_strategy_name_tv)).setText(String.format(locale, string, new Object[]{d11.getName()}));
        ((TextView) e11.b(R$id.grid_strategy_time_tv)).setText(String.format(locale, context.getString(R$string.n_grid_strategy_create_time), new Object[]{DateTimeUtils.g(d11.getCreateAt())}));
        ((TextView) e11.b(R$id.grid_strategy_investment_label_tv)).setText(String.format(locale, context.getString(R$string.n_grid_strategy_investment), new Object[]{z11}));
        ((TextView) e11.b(R$id.grid_strategy_investment_value_tv)).setText(m.u(d11.getInvestAmount(), PrecisionUtil.C(symbol)));
        textView3.setText(String.format(locale, context.getString(R$string.n_grid_strategy_profit), new Object[]{z11}));
        if (status == 1) {
            textView4.setText("--");
            textView7.setText("--");
            textView17.setText("--");
            textView9.setText("--");
            textView14.setText("--");
            TextView textView18 = textView15;
            textView18.setVisibility(0);
            textView18.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.bot_order_icon_open, 0, 0, 0);
            textView18.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
            textView18.setText(R$string.n_grid_strategy_starting);
            View view2 = b11;
            view2.setVisibility(8);
            TextView textView19 = textView16;
            textView19.setVisibility(8);
            ImageButton imageButton3 = imageButton2;
            imageButton3.setVisibility(4);
            view = view2;
            imageButton = imageButton3;
            c11 = 0;
            textView = textView3;
            textView2 = textView19;
        } else {
            imageButton = imageButton2;
            TextView textView20 = textView15;
            view = b11;
            TextView textView21 = textView16;
            String totalProfit = d11.getTotalProfit();
            textView = textView3;
            int i12 = R$color.baseColorPrimaryText;
            textView4.setText(u0.a(totalProfit, context, i12));
            textView7.setText(u0.a(d11.getFloatProfitAmount(), context, i12));
            textView17.setText(u0.a(d11.getGridProfitAmount(), context, i12));
            textView9.setText(u0.b(m.u(m.a(d11.getTotalYieldRate()).multiply(m.f68179a).toPlainString(), 2), context, i12));
            textView14.setText(String.valueOf(d11.getTradeNum()));
            if (status == 3) {
                c11 = 0;
                textView20.setVisibility(0);
                textView20.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.bot_order_icon_stopping, 0, 0, 0);
                textView20.setTextColor(ContextCompat.getColor(context, R$color.baseColorShadeButtonRedStart));
                textView20.setText(R$string.n_grid_strategy_stopping);
                view.setVisibility(8);
                textView2 = textView21;
                textView2.setVisibility(8);
                imageButton.setVisibility(4);
            } else {
                textView2 = textView21;
                c11 = 0;
                textView20.setVisibility(8);
                view.setVisibility(0);
                textView2.setVisibility(0);
                imageButton.setVisibility(0);
            }
        }
        String string2 = context.getString(R$string.n_grid_strategy_floating_income);
        Object[] objArr = new Object[1];
        objArr[c11] = z11;
        textView8.setText(String.format(locale, string2, objArr));
        String string3 = context.getString(R$string.n_grid_strategy_grid_revenue);
        Object[] objArr2 = new Object[1];
        objArr2[c11] = z11;
        textView5.setText(String.format(locale, string3, objArr2));
        String string4 = context.getString(R$string.n_grid_strategy_lowest_price);
        Object[] objArr3 = new Object[1];
        objArr3[c11] = z11;
        textView10.setText(String.format(locale, string4, objArr3));
        textView11.setText(m.u(d11.getMinPrice(), PrecisionUtil.e(symbol)));
        String string5 = context.getString(R$string.n_grid_strategy_highest_price);
        Object[] objArr4 = new Object[1];
        objArr4[c11] = z11;
        textView12.setText(String.format(locale, string5, objArr4));
        textView13.setText(m.u(d11.getMaxPrice(), PrecisionUtil.e(symbol)));
        textView.setOnClickListener(this);
        GridStrategyItem gridStrategyItem3 = gridStrategyItem;
        view.setTag(R$id.item_data1, gridStrategyItem3);
        view.setOnClickListener(this);
        textView2.setTag(R$id.item_data2, gridStrategyItem3);
        textView2.setOnClickListener(this);
        imageButton.setTag(R$id.item_data3, gridStrategyItem3);
        imageButton.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_grid_strategy;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        int id2 = view.getId();
        Context context = view.getContext();
        if (id2 == R$id.grid_strategy_stop_ll) {
            GridStrategyItem gridStrategyItem = (GridStrategyItem) view.getTag(R$id.item_data1);
            GridStrategyStopDialogFragment gridStrategyStopDialogFragment = new GridStrategyStopDialogFragment();
            gridStrategyStopDialogFragment.Ch(gridStrategyItem.d());
            gridStrategyStopDialogFragment.Bh(gridStrategyItem.c());
            gridStrategyStopDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "GridStrategyStopDialogFragment");
            HashMap hashMap = new HashMap();
            hashMap.put("symbol", gridStrategyItem.d().getSymbol());
            b.a().d("5849", hashMap, "1005373");
        } else if (id2 == R$id.grid_strategy_profit_label_tv) {
            FragmentActivity fragmentActivity = (FragmentActivity) a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(context.getString(R$string.n_grid_strategy_profit_title)).C0(context.getString(R$string.n_grid_strategy_profit_content)).q0(false).Y0(context.getString(R$string.n_otc_advert_list_select_blue_shield_more)).a1(new zc.a(context)).P0(context.getString(R$string.n_known)).Q0(zc.b.f62130a).k0().show(fragmentActivity.getSupportFragmentManager(), "");
            b.a().d("5850", (Map<String, Object>) null, "1005373");
        } else if (id2 == R$id.gird_strategy_detail_btn) {
            GridStrategyItem gridStrategyItem2 = (GridStrategyItem) view.getTag(R$id.item_data2);
            gridStrategyItem2.c().c(gridStrategyItem2, context);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("symbol", gridStrategyItem2.d().getSymbol());
            b.a().d("5848", hashMap2, "1005373");
        } else if (id2 == R$id.grid_strategy_share_tv) {
            GridStrategyItem gridStrategyItem3 = (GridStrategyItem) view.getTag(R$id.item_data3);
            gridStrategyItem3.c().a(gridStrategyItem3, context);
            HashMap hashMap3 = new HashMap();
            hashMap3.put("symbol", gridStrategyItem3.d().getSymbol());
            b.a().d("5847", hashMap3, "1005373");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
