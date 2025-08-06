package com.huobi.contract.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import com.huobi.homemarket.view.MarketContractInfoView;
import com.huobi.homemarket.view.MarketPriceView;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fj.v;
import i6.m;
import i6.r;
import java.util.HashMap;
import v9.c;

public class SwapCollectionMarketNewHandler extends AbsMarketViewHandler<MarketSwapPriceItem> {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d0(c cVar, MarketSwapPriceItem marketSwapPriceItem, int i11, View view) {
        B(cVar, marketSwapPriceItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean e0(MarketSwapPriceItem marketSwapPriceItem, c cVar, View view) {
        if (marketSwapPriceItem.c() == null) {
            return true;
        }
        marketSwapPriceItem.c().a(cVar.itemView, marketSwapPriceItem);
        return true;
    }

    public boolean T() {
        return false;
    }

    /* renamed from: W */
    public void m(c cVar, MarketSwapPriceItem marketSwapPriceItem, int i11, boolean z11) {
        String str;
        SwapCurrencyInfo i12 = marketSwapPriceItem.i();
        if (MarketModuleConfig.a().D()) {
            HuobiToastUtil.k(BaseApplication.b(), R$string.n_market_collection_swap_safeguard);
        } else if (i12 != null) {
            if (i12.isNotSupportTrade()) {
                HuobiToastUtil.j(com.hbg.lib.contract.R$string.n_futures_not_support_click_hint);
                return;
            }
            if (z11) {
                HashMap hashMap = new HashMap();
                hashMap.put("TransPair_current_click_id", i12.getContractShortType());
                BaseModuleConfig.a().w("App_markets_list_coin_click", hashMap);
            }
            MarketModuleConfig.a().s(cVar.itemView.getContext(), i12.getContractShortType(), i12.getContractCode(), i12, TradeType.SWAP);
        } else {
            return;
        }
        if (z11 && i12 != null) {
            String symbol = i12.getSymbol();
            String contractType = i12.getContractType();
            if (symbol == null) {
                str = "";
            } else {
                str = symbol.toLowerCase();
            }
            if (!TextUtils.isEmpty(contractType)) {
                str = str + "_" + contractType;
            }
            MarketModuleConfig.a().t("favorites_symbol_click", str);
        }
    }

    /* renamed from: X */
    public String p(MarketSwapPriceItem marketSwapPriceItem) {
        SwapCurrencyInfo i11 = marketSwapPriceItem.i();
        return i11 != null ? i11.getContractCode() : "";
    }

    /* renamed from: Y */
    public String v(MarketSwapPriceItem marketSwapPriceItem) {
        SwapCurrencyInfo i11 = marketSwapPriceItem.i();
        return i11 != null ? i11.getSymbol() : "";
    }

    /* renamed from: Z */
    public String w(MarketSwapPriceItem marketSwapPriceItem) {
        SwapCurrencyInfo i11 = marketSwapPriceItem.i();
        return i11 != null ? i11.getContractShortType() : "";
    }

    /* renamed from: a0 */
    public TradeType x(MarketSwapPriceItem marketSwapPriceItem) {
        return TradeType.SWAP;
    }

    /* renamed from: b0 */
    public void y(c cVar, int i11, MarketSwapPriceItem marketSwapPriceItem, ViewGroup viewGroup) {
        String str;
        String str2;
        c cVar2 = cVar;
        MarketSwapPriceItem marketSwapPriceItem2 = marketSwapPriceItem;
        super.handleView(cVar, i11, marketSwapPriceItem, viewGroup);
        Context context = cVar2.itemView.getContext();
        SwapCurrencyInfo i12 = marketSwapPriceItem.i();
        r e11 = cVar.e();
        MarketContractInfoView marketContractInfoView = (MarketContractInfoView) e11.b(R$id.marketContractInfoView);
        MarketPriceView marketPriceView = (MarketPriceView) e11.b(R$id.marketContractPriceView);
        TextView textView = (TextView) e11.b(R$id.item_chart_percent);
        f6.c.a().f(e11.c(R$id.iv_item_basecurrency), AbsMarketViewHandler.q(marketSwapPriceItem.getBaseCurrency()), AbsMarketViewHandler.r());
        SymbolPrice symbolPrice = marketSwapPriceItem.getSymbolPrice();
        marketContractInfoView.setSymbolName(marketSwapPriceItem.g());
        marketContractInfoView.setContractType(marketSwapPriceItem.h());
        if (MarketModuleConfig.a().D()) {
            textView.setBackground(new BgColorDrawable(context.getResources().getColor(w.k("0")), AbsMarketViewHandler.f72703g));
            textView.setText("--");
            marketContractInfoView.setAmount("--");
            marketPriceView.setPriceString("--");
            marketPriceView.setPriceStringCny("--");
        } else if (symbolPrice == null || i12 == null) {
            textView.setBackground(new BgColorDrawable(context.getResources().getColor(w.k("0")), AbsMarketViewHandler.f72703g));
            textView.setText("--");
            marketContractInfoView.setAmount("--");
            marketPriceView.setPriceString(marketSwapPriceItem.d());
            marketPriceView.setPriceStringCny(marketSwapPriceItem.e());
        } else {
            Double close = symbolPrice.getClose();
            Double open = symbolPrice.getOpen();
            double doubleValue = (close == null || open == null) ? 0.0d : close.doubleValue() - open.doubleValue();
            if (close == null || Double.compare(close.doubleValue(), 0.0d) == 0) {
                str = "--";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : "");
                sb2.append(m.i((doubleValue / open.doubleValue()) * 100.0d, PrecisionUtil.v(i12.getSymbol())));
                sb2.append("%");
                str = sb2.toString();
            }
            int color = context.getResources().getColor(w.k(str));
            if (Double.compare(doubleValue, 0.0d) > 0) {
                if (i12.isNotSupportTrade()) {
                    color = context.getResources().getColor(w.g());
                }
            } else if (Double.compare(doubleValue, 0.0d) < 0 && i12.isNotSupportTrade()) {
                color = context.getResources().getColor(w.f());
            }
            textView.setBackground(new BgColorDrawable(color, AbsMarketViewHandler.f72703g));
            if (!TextUtils.isEmpty(marketSwapPriceItem.f())) {
                if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                    str2 = LegalCurrencyConfigUtil.w() + m.g(marketSwapPriceItem.f());
                } else {
                    str2 = LegalCurrencyConfigUtil.w() + m.X(marketSwapPriceItem.f());
                }
                marketContractInfoView.setAmount(str2);
            } else {
                marketContractInfoView.setAmount("--");
            }
            if (textView.getText() == null || !textView.getText().equals(str)) {
                textView.setText(str);
                this.f72706d.put(o(marketSwapPriceItem2), Double.valueOf(doubleValue));
            }
            marketPriceView.setPriceString(context.getResources().getString(R$string.contract_symbol_price_dollar) + m.c(marketSwapPriceItem.d(), marketSwapPriceItem.d()));
            marketPriceView.setPriceStringCny(marketSwapPriceItem.e());
        }
        if (i12 == null) {
            marketPriceView.setPaintColor(false);
            cVar2.itemView.setBackgroundResource(R$drawable.selector_market_item_click);
        } else {
            marketPriceView.setPaintColor(i12.isNotSupportTrade());
            if (i12.isNotSupportTrade()) {
                cVar2.itemView.setBackgroundColor(ContextCompat.getColor(context, R$color.baseColorDeepestBackground));
            } else {
                cVar2.itemView.setBackgroundResource(R$drawable.selector_market_item_click);
            }
        }
        marketPriceView.invalidate();
        cVar2.itemView.setOnClickListener(new v(this, cVar2, marketSwapPriceItem2, i11));
        cVar2.itemView.setOnLongClickListener(new fj.w(marketSwapPriceItem2, cVar2));
    }

    /* renamed from: c0 */
    public boolean A(MarketSwapPriceItem marketSwapPriceItem) {
        return false;
    }

    public int getResId() {
        return R$layout.item_contract_market_view;
    }

    public ViewGroup.LayoutParams s(int i11) {
        return new LinearLayout.LayoutParams(-1, i11);
    }
}
