package com.huobi.otc.handler;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.bean.OtcTradeType;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.p;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$color;
import com.hbg.module.otc.R$drawable;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.account.entity.OTCKycInfo;
import com.huobi.login.usercenter.data.source.bean.UserSecurityInfoData;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.widget.PaymentGroupView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.HashMap;
import java.util.Locale;
import jp.v1;
import oa.a;
import s9.c;
import up.f;
import va.b;

public class MerchantOnlineViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, Ads ads, ViewGroup viewGroup) {
        int i12;
        v9.c cVar2 = cVar;
        r e11 = cVar.e();
        Resources resources = cVar2.itemView.getResources();
        Context context = cVar2.itemView.getContext();
        ImageView imageView = (ImageView) e11.b(R$id.otc_merchant_cointype_iv);
        TextView textView = (TextView) e11.b(R$id.otc_merchant_limitmoney_tv);
        TextView textView2 = (TextView) e11.b(R$id.otc_merchant_price_tv);
        TextView textView3 = (TextView) e11.b(R$id.otc_merchant_symbol_tv);
        TextView textView4 = (TextView) e11.b(R$id.otc_merchant_buy_sell);
        TextView textView5 = (TextView) e11.b(R$id.id_receive_order_flag_tv);
        PaymentGroupView paymentGroupView = (PaymentGroupView) e11.b(R$id.support_pay_container);
        ImageView imageView2 = (ImageView) e11.b(R$id.id_trust_iv);
        OtcTradeType tradeType = ads.getTradeType();
        String m11 = b.m(ads.getCurrency());
        String g11 = b.g(ads.getCoinId());
        ((TextView) e11.b(R$id.otc_merchant_coinname_tv)).setText(g11);
        ((TextView) e11.b(R$id.otc_merchant_coinnum_tv)).setText(ads.getTradeCount() + " " + g11);
        String v11 = OtcModuleConfig.a().v(ads.getMinTradeLimit(), m.U(ads.getMinTradeLimit()));
        Context context2 = context;
        String v12 = OtcModuleConfig.a().v(ads.getMaxTradeLimit(), m.U(ads.getMaxTradeLimit()));
        int i13 = R$string.otc_limit_range;
        OtcTradeType otcTradeType = tradeType;
        Object[] objArr = new Object[2];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m11);
        if (TextUtils.isEmpty(v11)) {
            v11 = "--";
        }
        sb2.append(v11);
        String sb3 = sb2.toString();
        boolean z11 = false;
        objArr[0] = sb3;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(m11);
        if (TextUtils.isEmpty(v12)) {
            v12 = "--";
        }
        sb4.append(v12);
        objArr[1] = sb4.toString();
        textView.setText(resources.getString(i13, objArr));
        textView2.setText(OtcModuleConfig.a().v(ads.getPrice(), m.U(ads.getPrice())));
        Resources resources2 = textView2.getResources();
        int i14 = R$color.baseColorPrimaryText;
        int color = resources2.getColor(i14);
        textView2.setTextColor(color);
        textView3.setTextColor(color);
        textView3.setText(m11);
        f6.c.a().f(imageView, f.b().c(g11), R$drawable.coin_default_icon);
        paymentGroupView.setPaymentInfos(ads.getPayMethods());
        int i15 = 8;
        imageView2.setVisibility(ads.isBlueShieldMerchant() ? 0 : 8);
        if (ads.isAcceptOrder()) {
            i15 = 0;
        }
        textView5.setVisibility(i15);
        Resources resources3 = textView4.getResources();
        int i16 = R$color.white;
        textView4.setTextColor(resources3.getColor(i16));
        OtcTradeActivity otcTradeActivity = null;
        Context f11 = a.g().f(OtcTradeActivity.class);
        if (f11 != null && (f11 instanceof OtcTradeActivity)) {
            otcTradeActivity = (OtcTradeActivity) f11;
        }
        if (otcTradeActivity == null || otcTradeActivity.isFinishing()) {
            return;
        }
        UserSecurityInfoData Wh = otcTradeActivity.Wh();
        OTCKycInfo Oh = otcTradeActivity.Oh();
        if (Wh != null && !TextUtils.isEmpty(Wh.getPhone())) {
            z11 = true;
        }
        if ((ads.isNeedKyc() && Oh != null && Oh.getStatus() == 0) || (ads.isNeedAdvancedKyc() && Oh != null && Oh.getStatus() != 2)) {
            textView4.setTextColor(textView4.getResources().getColor(R$color.baseColorMajorTheme100));
            textView4.setBackgroundResource(R$drawable.shape_trade_limit_btn_bg);
            textView4.setText(R$string.n_otc_advert_btn_kyc);
        } else if (ads.isNeedBindPhoneNum() && !z11) {
            textView4.setText(R$string.n_otc_advert_btn_bind_phone);
            textView4.setTextColor(textView4.getResources().getColor(R$color.baseColorMajorTheme100));
            textView4.setBackgroundResource(R$drawable.shape_trade_limit_btn_bg);
        } else if (ads.isTradeLimit()) {
            textView4.setText(R$string.n_otc_taker_limit_new);
            textView4.setTextColor(textView4.getResources().getColor(i14));
            textView4.setBackgroundResource(R$drawable.btn_otc_trade_unable);
        } else {
            textView4.setTextColor(textView4.getResources().getColor(i16));
            if (otcTradeType.isBuy()) {
                textView4.setText(resources.getText(R$string.otc_merchant_sell));
                textView4.setBackgroundResource(R$drawable.btn_otc_merchant_ads_sell_new_header_bg);
            } else {
                textView4.setText(resources.getText(R$string.otc_merchant_buy));
                textView4.setBackgroundResource(R$drawable.btn_otc_merchant_ads_buy_new_header_bg);
            }
        }
        Locale locale = context2.getResources().getConfiguration().locale;
        if (locale.getLanguage().toLowerCase().endsWith("zh") && locale.getCountry().toLowerCase().endsWith("hk")) {
            i12 = R$drawable.otc_trust_tw_icon;
        } else if (p.h(context2)) {
            i12 = R$drawable.otc_trust_zh_icon;
        } else {
            i12 = R$drawable.otc_trust_en_icon;
        }
        imageView2.setImageResource(i12);
        textView5.setBackgroundResource(R$drawable.shape_otc_dialog_bg);
        textView5.setTextColor(v1.b());
        textView4.setTag(R$id.item_data, ads);
        textView4.setTag(R$id.item_data1, Integer.valueOf(i11));
        textView4.setOnClickListener(this);
    }

    public int getResId() {
        return R$layout.item_merchant_online_sell_buy;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Ads ads = (Ads) view.getTag(R$id.item_data);
        int intValue = ((Integer) view.getTag(R$id.item_data1)).intValue();
        kp.a adsClickListener = ads.getAdsClickListener();
        if (adsClickListener != null) {
            adsClickListener.a(ads, intValue);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("is_blueshield", Boolean.valueOf(ads.isBlueShieldMerchant()));
        hashMap.put("currency_type", b.k(ads.getCurrency()));
        hashMap.put("ad_name", ads.getUserName());
        hashMap.put("coin_name", b.g(ads.getCoinId()));
        if (!CollectionsUtils.b(OtcModuleConfig.a().d())) {
            hashMap.put("country_id", OtcModuleConfig.a().d().get(0));
        }
        uf.c.b().h(ads.getTradeType().isSell() ? "otc_buydetail_buyinfo_click" : "otc_buydetail_sellinfo_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
