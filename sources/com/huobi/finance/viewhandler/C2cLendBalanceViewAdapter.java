package com.huobi.finance.viewhandler;

import al.p;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.f2;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.C2CLendBalanceDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import s9.c;

public class C2cLendBalanceViewAdapter implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo, View view) {
        if (!p.d(view.getContext())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        AssetModuleConfig.a().y((Activity) view.getContext(), c2CLendBalanceDetailInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final String c(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return m.u0(str, 12, 3);
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, C2CLendBalanceDetailInfo c2CLendBalanceDetailInfo, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        r e11 = cVar.e();
        TextView e12 = e11.e(R$id.tv_currency);
        TextView e13 = e11.e(R$id.tv_total);
        TextView e14 = e11.e(R$id.tv_lend);
        TextView e15 = e11.e(R$id.tv_frozen);
        TextView e16 = e11.e(R$id.tv_estimate);
        e12.setText(c2CLendBalanceDetailInfo.getDisplayName());
        if (c2CLendBalanceDetailInfo.isShow()) {
            e13.setText(c(c2CLendBalanceDetailInfo.getTotalAmount()));
            e14.setText(c(c2CLendBalanceDetailInfo.getLending()));
            e15.setText(c(c2CLendBalanceDetailInfo.getTrade()));
            e16.setText(context.getString(R$string.balance_margin_item_short_estimate, new Object[]{c2CLendBalanceDetailInfo.getEstimateAmount(), StringUtils.i(LegalCurrencyConfigUtil.y())}));
        } else {
            String string = cVar.itemView.getResources().getString(R$string.balance_hide_star);
            e13.setText(string);
            e14.setText(string);
            e15.setText(string);
            e16.setText(context.getString(R$string.balance_margin_item_short_estimate, new Object[]{string, StringUtils.i(LegalCurrencyConfigUtil.y())}));
        }
        view.setOnClickListener(new f2(c2CLendBalanceDetailInfo));
    }

    public int getResId() {
        return R$layout.item_c2c_lend_balance_detail;
    }
}
