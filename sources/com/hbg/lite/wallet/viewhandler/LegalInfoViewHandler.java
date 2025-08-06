package com.hbg.lite.wallet.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lite.R$drawable;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.record.ui.SingleCurrencyRecordActivity;
import com.hbg.lite.wallet.bean.LegalDetailInfo;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import g6.b;
import i6.m;
import i6.r;
import java.util.HashMap;
import java.util.Locale;
import s9.c;
import sa.a;

public class LegalInfoViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LegalDetailInfo legalDetailInfo, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R$id.balance_zh_name_tv);
        TextView textView2 = (TextView) e11.b(R$id.balance_amount_tv);
        TextView textView3 = (TextView) e11.b(R$id.balance_amount_convert_tv);
        b.c().i((ImageView) e11.b(R$id.balance_icon_iv), legalDetailInfo.getLogo(), R$drawable.shape_logo_default_bg);
        ((TextView) e11.b(R$id.balance_name_tv)).setText(legalDetailInfo.getCurrency().toUpperCase());
        String fullName = va.b.s(legalDetailInfo.getCoinId()).getFullName();
        if (TextUtils.isEmpty(fullName)) {
            fullName = "";
        }
        textView.setText(fullName);
        if (legalDetailInfo.isShow()) {
            textView3.setText(String.format(context.getString(R$string.two_label_with_space_with_space_abount), new Object[]{va.b.n(a.c()), ra.c.c().v(m.a(legalDetailInfo.getEstimateAmountToLegal()))}));
        } else {
            int i12 = R$string.balance_hide_star;
            textView2.setText(context.getString(i12));
            textView3.setText(context.getString(i12));
        }
        cVar.itemView.setOnClickListener(this);
        cVar.itemView.setTag(R$id.item_data1, legalDetailInfo);
        if (legalDetailInfo.isSecond()) {
            cVar.itemView.setBackgroundResource(R$drawable.shape_wallet_item_bg);
        } else {
            cVar.itemView.setBackgroundResource(R$drawable.selector_lite_item_bg);
        }
    }

    public int getResId() {
        return R$layout.item_lite_wallet_balance;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        LegalDetailInfo legalDetailInfo = (LegalDetailInfo) view.getTag(R$id.item_data1);
        if (legalDetailInfo == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        try {
            HashMap hashMap = new HashMap(1);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, legalDetailInfo.getCurrency().toLowerCase(Locale.US));
            ra.c.c().l("186", hashMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        if (k.C().L(legalDetailInfo.getCurrency())) {
            com.hbg.lib.widgets.dialog.b.a((FragmentActivity) oa.a.g().b());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        va.b.s(legalDetailInfo.getCoinId());
        SingleCurrencyRecordActivity.Dh(view.getContext(), legalDetailInfo);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
