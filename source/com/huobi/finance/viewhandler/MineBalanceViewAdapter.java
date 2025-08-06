package com.huobi.finance.viewhandler;

import al.p;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import bl.x2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.network.pro.core.bean.CurrencyBean;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.MineDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import java.util.Locale;
import s9.c;

public class MineBalanceViewAdapter implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(Context context, MineDetailInfo mineDetailInfo, View view) {
        if (!p.d(context)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().F0(context, mineDetailInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(MineDetailInfo mineDetailInfo) {
        return mineDetailInfo.getEstimateAmount();
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, MineDetailInfo mineDetailInfo, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.tv_available);
        TextView textView2 = (TextView) e11.b(R$id.tv_frozen_sum);
        TextView textView3 = (TextView) e11.b(R$id.tv_estimate_content);
        TextView textView4 = (TextView) e11.b(R$id.tv_estimate_label);
        ((TextView) e11.b(R$id.tv_title)).setText(StringUtils.i(mineDetailInfo.getCurrency()));
        ImageView c11 = e11.c(R$id.item_margin_balance_symbol_icon);
        TextView e12 = e11.e(R$id.item_balance_currency_name_all);
        CurrencyBean s11 = k.C().s(mineDetailInfo.getCurrency());
        if (s11 != null) {
            e12.setText(s11.getFullName());
        } else {
            e12.setText("");
        }
        f6.c.a().l(context, p.k(mineDetailInfo.getCurrency()), c11, p.m());
        if (p.u()) {
            textView.setText(p.j(mineDetailInfo.getAvaialAble(), mineDetailInfo.getCurrency()));
            textView2.setText(p.j(m.a(mineDetailInfo.getLock()).add(m.a(mineDetailInfo.getBank())).add(m.a(mineDetailInfo.getOnOrders())).toPlainString(), mineDetailInfo.getCurrency()));
            String upperCase = LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
            textView4.setText(context.getString(R$string.n_balance_equivalent_ph, new Object[]{StringUtils.i(upperCase)}));
            textView3.setText(c(mineDetailInfo));
        } else {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            textView.setText(string);
            textView2.setText(string);
            textView3.setText(string);
        }
        view.setTag(R$id.item_data, mineDetailInfo);
        view.setOnClickListener(new x2(context, mineDetailInfo));
    }

    public int getResId() {
        return R$layout.item_mine_balance_detail;
    }
}
