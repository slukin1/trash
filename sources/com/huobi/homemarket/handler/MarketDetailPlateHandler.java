package com.huobi.homemarket.handler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Keep;
import com.hbg.component.kline.utils.DimenUtils;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.MarketPlateDetail;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.luck.picture.lib.config.PictureMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.m;
import java.util.HashMap;
import java.util.Map;
import s9.b;
import s9.c;
import td.i;

@Keep
public class MarketDetailPlateHandler implements c {
    public static AccelerateDecelerateInterpolator sAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    private static final float[] sBgRadius;
    private static final float sRadius;
    public Drawable defaultDrawable;
    private Map<String, Double> markPriceMap = new HashMap();

    static {
        float a11 = (float) DimenUtils.a(4.0f);
        sRadius = a11;
        sBgRadius = new float[]{a11, a11, a11, a11, a11, a11, a11, a11};
    }

    private String getCNY(String str, String str2, boolean z11) {
        if (TextUtils.isEmpty(str2)) {
            return "--";
        }
        String v11 = i.a().b().v(str2);
        if (!z11) {
            return LegalCurrencyConfigUtil.w() + m.c(v11, v11);
        } else if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return LegalCurrencyConfigUtil.w() + m.g(v11);
        } else {
            return LegalCurrencyConfigUtil.w() + m.X(v11);
        }
    }

    public static String getCurrencyIcon(String str) {
        String j11 = BaseModuleConfig.a().j();
        if (j11 == null) {
            j11 = "";
        }
        return j11 + "/-/x/hb/p/api/contents/currency/icon_png/" + str.toLowerCase() + PictureMimeType.PNG;
    }

    public static int getDefaultAssetCurrencyIcon() {
        if (NightHelper.e().g()) {
            return R$drawable.balances_currencyicon_night;
        }
        return R$drawable.balances_currencyicon;
    }

    private void itemClick(v9.c cVar, MarketPlateDetail.CurrencyItem currencyItem, int i11) {
        Context context = cVar.itemView.getContext();
        if (!NetworkStatus.c(context)) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.server_error);
            return;
        }
        if (a1.v().S(currencyItem.getSymbol())) {
            MarketModuleConfig.a().X(context, currencyItem.getSymbol(), true);
        } else {
            MarketModuleConfig.a().e(context, currencyItem.getSymbol(), MarketModuleConfig.a().w(), TradeType.PRO);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("currency_name", currencyItem.getCurrency());
        BaseModuleConfig.a().w("plate_details_coin_click", hashMap);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$handleView$0(v9.c cVar, MarketPlateDetail.CurrencyItem currencyItem, int i11, View view) {
        itemClick(cVar, currencyItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R$layout.item_market_plate_item;
    }

    public /* bridge */ /* synthetic */ View getView() {
        return b.a(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleView(v9.c r19, int r20, com.hbg.lib.network.hbg.core.bean.MarketPlateDetail.CurrencyItem r21, android.view.ViewGroup r22) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            android.view.View r2 = r1.itemView
            android.content.Context r2 = r2.getContext()
            int r3 = com.hbg.module.market.R$drawable.market_updown_global_default_text_bg
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r2, r3)
            r0.defaultDrawable = r3
            i6.r r3 = r19.e()
            int r4 = com.hbg.module.market.R$id.item_chart_percent
            android.view.View r4 = r3.b(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.hbg.module.market.R$id.iv_item_basecurrency
            android.widget.ImageView r5 = r3.c(r5)
            f6.c r6 = f6.c.a()
            java.lang.String r7 = r21.getCurrency()
            java.lang.String r7 = getCurrencyIcon(r7)
            int r8 = getDefaultAssetCurrencyIcon()
            r6.f(r5, r7, r8)
            int r5 = com.hbg.module.market.R$id.item_chart_basecurrency
            android.widget.TextView r5 = r3.e(r5)
            java.lang.String r6 = r21.getCurrency()
            r5.setText(r6)
            int r6 = com.hbg.module.market.R$id.item_chart_amount
            android.widget.TextView r6 = r3.e(r6)
            int r7 = com.hbg.module.market.R$id.marketContractPriceView
            android.view.View r3 = r3.b(r7)
            com.huobi.homemarket.view.MarketPriceView r3 = (com.huobi.homemarket.view.MarketPriceView) r3
            r7 = 0
            r9 = 0
            java.lang.String r10 = r21.getUpDown()     // Catch:{ all -> 0x008e }
            double r10 = java.lang.Double.parseDouble(r10)     // Catch:{ all -> 0x008e }
            java.lang.String r12 = ""
            int r7 = java.lang.Double.compare(r10, r7)     // Catch:{ all -> 0x008d }
            if (r7 <= 0) goto L_0x0067
            java.lang.String r12 = "+"
        L_0x0067:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            r7.<init>()     // Catch:{ all -> 0x008d }
            r7.append(r12)     // Catch:{ all -> 0x008d }
            java.math.BigDecimal r8 = new java.math.BigDecimal     // Catch:{ all -> 0x008d }
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r12 = r12 * r10
            r8.<init>(r12)     // Catch:{ all -> 0x008d }
            r14 = 2
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x008d }
            java.lang.String r8 = i6.m.t(r8, r14, r9, r12)     // Catch:{ all -> 0x008d }
            r7.append(r8)     // Catch:{ all -> 0x008d }
            java.lang.String r8 = "%"
            r7.append(r8)     // Catch:{ all -> 0x008d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008d }
            goto L_0x0097
        L_0x008d:
            r7 = r10
        L_0x008e:
            java.lang.String r10 = r21.getUpDown()
            r16 = r7
            r7 = r10
            r10 = r16
        L_0x0097:
            java.lang.String r8 = r21.getState()
            java.lang.String r12 = "suspend"
            boolean r8 = r12.equals(r8)
            java.lang.String r13 = "transfer-board"
            r14 = 1
            if (r8 != 0) goto L_0x0131
            java.lang.String r8 = r21.getState()
            boolean r8 = r13.equals(r8)
            if (r8 != 0) goto L_0x0131
            java.lang.String r8 = r21.getState()
            java.lang.String r15 = "fuse"
            boolean r8 = r15.equals(r8)
            if (r8 == 0) goto L_0x00bd
            goto L_0x0131
        L_0x00bd:
            java.lang.String r8 = r21.getState()
            java.lang.String r12 = "pre-online"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x00e5
            int r7 = com.hbg.module.market.R$color.global_default_text_color
            int r8 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r5.setTextColor(r8)
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r6.setTextColor(r2)
            android.graphics.drawable.Drawable r2 = r0.defaultDrawable
            r4.setBackground(r2)
            int r2 = com.hbg.module.market.R$string.trade_pre_online
            r4.setText(r2)
            goto L_0x0198
        L_0x00e5:
            int r8 = com.hbg.module.market.R$color.global_main_text_color
            int r8 = androidx.core.content.ContextCompat.getColor(r2, r8)
            r5.setTextColor(r8)
            r3.setPaintColor(r9)
            int r5 = com.hbg.module.market.R$color.baseColorSecondaryTextNew
            int r5 = androidx.core.content.ContextCompat.getColor(r2, r5)
            r6.setTextColor(r5)
            int r5 = com.hbg.lib.core.util.w.k(r7)
            android.content.res.Resources r2 = r2.getResources()
            int r2 = r2.getColor(r5)
            com.huobi.view.drawable.BgColorDrawable r5 = new com.huobi.view.drawable.BgColorDrawable
            float[] r8 = sBgRadius
            r5.<init>((int) r2, (float[]) r8)
            r4.setBackground(r5)
            java.lang.CharSequence r2 = r4.getText()
            if (r2 == 0) goto L_0x0120
            java.lang.CharSequence r2 = r4.getText()
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x0198
        L_0x0120:
            r4.setText(r7)
            java.lang.String r2 = r21.getSymbol()
            java.util.Map<java.lang.String, java.lang.Double> r4 = r0.markPriceMap
            java.lang.Double r5 = java.lang.Double.valueOf(r10)
            r4.put(r2, r5)
            goto L_0x0198
        L_0x0131:
            int r7 = com.hbg.module.market.R$color.baseColorThreeLevelText
            int r8 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r5.setTextColor(r8)
            int r5 = androidx.core.content.ContextCompat.getColor(r2, r7)
            r6.setTextColor(r5)
            r3.setPaintColor(r14)
            android.graphics.drawable.Drawable r5 = r0.defaultDrawable
            r4.setBackground(r5)
            java.lang.String r5 = r21.getState()
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L_0x0183
            com.hbg.lib.core.BaseModuleConfig$a r5 = com.hbg.lib.core.BaseModuleConfig.a()
            java.lang.String r7 = r21.getSymbol()
            boolean r5 = r5.U(r7)
            if (r5 == 0) goto L_0x017d
            java.lang.String r5 = "0.00%"
            r4.setText(r5)
            int r5 = com.hbg.lib.core.util.w.k(r5)
            android.content.res.Resources r2 = r2.getResources()
            int r2 = r2.getColor(r5)
            com.huobi.view.drawable.BgColorDrawable r5 = new com.huobi.view.drawable.BgColorDrawable
            float[] r7 = sBgRadius
            r5.<init>((int) r2, (float[]) r7)
            r4.setBackground(r5)
            goto L_0x0198
        L_0x017d:
            int r2 = com.hbg.module.market.R$string.trade_suspend
            r4.setText(r2)
            goto L_0x0198
        L_0x0183:
            java.lang.String r2 = r21.getState()
            boolean r2 = r13.equals(r2)
            if (r2 == 0) goto L_0x0193
            int r2 = com.hbg.module.market.R$string.trade_transfer_board
            r4.setText(r2)
            goto L_0x0198
        L_0x0193:
            int r2 = com.hbg.module.market.R$string.trade_fuse
            r4.setText(r2)
        L_0x0198:
            java.lang.String r2 = r21.getSymbol()
            java.lang.String r4 = r21.getTotalVol()
            java.lang.String r2 = r0.getCNY(r2, r4, r14)
            r6.setText(r2)
            java.lang.String r2 = r21.getPrice()
            java.lang.String r4 = r21.getPrice()
            java.lang.String r2 = i6.m.c(r2, r4)
            r3.setPriceString(r2)
            java.lang.String r2 = r21.getSymbol()
            java.lang.String r4 = r21.getPrice()
            java.lang.String r2 = r0.getCNY(r2, r4, r9)
            r3.setPriceStringCny(r2)
            r3.invalidate()
            android.view.View r2 = r1.itemView
            ql.l r3 = new ql.l
            r4 = r20
            r5 = r21
            r3.<init>(r0, r1, r5, r4)
            r2.setOnClickListener(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.handler.MarketDetailPlateHandler.handleView(v9.c, int, com.hbg.lib.network.hbg.core.bean.MarketPlateDetail$CurrencyItem, android.view.ViewGroup):void");
    }
}
