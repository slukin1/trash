package com.huobi.otc.handler;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$dimen;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.huobi.otc.bean.OtcFastBuyMatchPaymentBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hp.r;
import i6.d;
import jp.c1;
import jp.v1;
import s9.c;

public class OtcFastBuyMatchPaymentHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(OtcFastBuyMatchPaymentBean otcFastBuyMatchPaymentBean, int i11, View view) {
        if (!(otcFastBuyMatchPaymentBean.getCallback() == null || otcFastBuyMatchPaymentBean.getCallback() == null)) {
            otcFastBuyMatchPaymentBean.getCallback().onPaymentCheck(i11, otcFastBuyMatchPaymentBean, view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final AutoSizeTextView c(Context context) {
        AutoSizeTextView autoSizeTextView = new AutoSizeTextView(context);
        autoSizeTextView.setMaxLines(1);
        autoSizeTextView.setGravity(16);
        autoSizeTextView.setTextColor(ContextCompat.getColor(context, R$color.baseColorPrimaryText));
        autoSizeTextView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R$dimen.global_text_size_12));
        return autoSizeTextView;
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, OtcFastBuyMatchPaymentBean otcFastBuyMatchPaymentBean, ViewGroup viewGroup) {
        int i12;
        int i13;
        View b11 = cVar.e().b(R$id.payment_icon_iv);
        FrameLayout frameLayout = (FrameLayout) cVar.e().b(R$id.payment_container_fl);
        TextView textView = (TextView) cVar.e().b(R$id.best_price_tv);
        ImageView imageView = (ImageView) cVar.e().b(R$id.select_payment_iv);
        FrameLayout frameLayout2 = (FrameLayout) cVar.e().b(R$id.payment_container);
        if (otcFastBuyMatchPaymentBean.getIsBuy() == 0) {
            i12 = R$drawable.green_selected_icon;
        } else {
            i12 = R$drawable.red_selected_icon;
        }
        imageView.setImageResource(i12);
        textView.setBackgroundResource(R$drawable.shape_otc_dialog_bg);
        v1.d(textView);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout2.getLayoutParams();
        marginLayoutParams.width = (int) otcFastBuyMatchPaymentBean.getItemWith();
        marginLayoutParams.setMarginEnd(PixelUtils.a(-10.0f));
        if (otcFastBuyMatchPaymentBean.isFist()) {
            marginLayoutParams.setMarginStart(PixelUtils.a(5.0f));
        }
        if (otcFastBuyMatchPaymentBean.isLast()) {
            marginLayoutParams.setMarginEnd(PixelUtils.a(5.0f));
        }
        frameLayout2.setLayoutParams(marginLayoutParams);
        int color = cVar.itemView.getResources().getColor(R$color.baseColorMajorTheme100);
        try {
            color = Color.parseColor(c1.h().i(otcFastBuyMatchPaymentBean.getBusinessEnum(), otcFastBuyMatchPaymentBean.getPayMethodCode()));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        b11.setBackgroundColor(color);
        AutoSizeTextView c11 = c(cVar.itemView.getContext());
        if (!TextUtils.isEmpty(otcFastBuyMatchPaymentBean.getPayMethodName())) {
            c11.setText(otcFastBuyMatchPaymentBean.getPayMethodName());
        } else {
            c11.setText(c1.h().j(otcFastBuyMatchPaymentBean.getBusinessEnum(), otcFastBuyMatchPaymentBean.getPayMethodCode()));
        }
        d.e("data.getPayId()-->", otcFastBuyMatchPaymentBean.getPayId() + "");
        frameLayout.removeAllViews();
        frameLayout.addView(c11);
        if (otcFastBuyMatchPaymentBean.isPriceLow()) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(4);
        }
        if (otcFastBuyMatchPaymentBean.isChecked()) {
            imageView.setVisibility(0);
            if (otcFastBuyMatchPaymentBean.getIsBuy() == 0) {
                i13 = R$drawable.otc_fast_buy_payment_green_shadow_selected_bg;
            } else {
                i13 = R$drawable.otc_fast_buy_payment_green_shadow_selected_red_bg;
            }
            frameLayout2.setBackground(ContextCompat.getDrawable(frameLayout2.getContext(), i13));
        } else {
            imageView.setVisibility(4);
            frameLayout2.setBackground(ContextCompat.getDrawable(frameLayout2.getContext(), R$drawable.otc_fast_buy_payment_shadow_bg));
        }
        cVar.itemView.setOnClickListener(new r(otcFastBuyMatchPaymentBean, i11));
    }

    public int getResId() {
        return R$layout.item_fast_buy_match_payment_layout;
    }
}
