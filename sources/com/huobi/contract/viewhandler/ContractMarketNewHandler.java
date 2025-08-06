package com.huobi.contract.viewhandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.ClickHelper;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$drawable;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import com.huobi.homemarket.view.MarketContractInfoView;
import com.huobi.homemarket.view.MarketPriceView;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fj.f;
import fj.g;
import i6.m;
import i6.r;
import java.util.HashMap;
import v9.c;

public class ContractMarketNewHandler extends AbsMarketViewHandler<MarketContractSymbolPriceItem> {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d0(c cVar, MarketContractSymbolPriceItem marketContractSymbolPriceItem, int i11, View view) {
        B(cVar, marketContractSymbolPriceItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean e0(MarketContractSymbolPriceItem marketContractSymbolPriceItem, c cVar, View view) {
        if (!ClickHelper.b()) {
            return false;
        }
        if (marketContractSymbolPriceItem.c() == null) {
            return true;
        }
        marketContractSymbolPriceItem.c().a(cVar.itemView, marketContractSymbolPriceItem);
        return true;
    }

    /* renamed from: W */
    public void m(c cVar, MarketContractSymbolPriceItem marketContractSymbolPriceItem, int i11, boolean z11) {
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        if (f11 != null) {
            if (f11.isNotSupportTrade()) {
                HuobiToastUtil.j(R$string.n_futures_not_support_click_hint);
                return;
            }
            if (z11) {
                HashMap hashMap = new HashMap();
                hashMap.put("TransPair_current_click_id", f11.getContractShortType());
                BaseModuleConfig.a().w("App_markets_list_coin_click", hashMap);
            }
            MarketModuleConfig.a().a0(cVar.itemView.getContext(), f11.getContractShortType(), f11.getContractCode(), f11, TradeType.CONTRACT);
        }
    }

    /* renamed from: X */
    public String p(MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        return f11 != null ? f11.getContractCode() : "";
    }

    /* renamed from: Y */
    public String v(MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        return f11 != null ? f11.getSymbol() : "";
    }

    /* renamed from: Z */
    public String w(MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        return f11 != null ? f11.getContractShortType() : "";
    }

    /* renamed from: a0 */
    public TradeType x(MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        return TradeType.CONTRACT;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: b0 */
    public void y(c cVar, int i11, MarketContractSymbolPriceItem marketContractSymbolPriceItem, ViewGroup viewGroup) {
        String str;
        String str2;
        c cVar2 = cVar;
        MarketContractSymbolPriceItem marketContractSymbolPriceItem2 = marketContractSymbolPriceItem;
        super.handleView(cVar, i11, marketContractSymbolPriceItem, viewGroup);
        Context context = cVar2.itemView.getContext();
        ContractCurrencyInfo f11 = marketContractSymbolPriceItem.f();
        r e11 = cVar.e();
        MarketContractInfoView marketContractInfoView = (MarketContractInfoView) e11.b(R$id.marketContractInfoView);
        MarketPriceView marketPriceView = (MarketPriceView) e11.b(R$id.marketContractPriceView);
        marketContractInfoView.setIsCollected(MarketModuleConfig.a().k(f11.getContractShortType()));
        TextView textView = (TextView) e11.b(R$id.item_chart_percent);
        f6.c.a().f(e11.c(R$id.iv_item_basecurrency), AbsMarketViewHandler.q(marketContractSymbolPriceItem.getBaseCurrency()), AbsMarketViewHandler.r());
        marketContractInfoView.setSymbolName(marketContractSymbolPriceItem.i());
        marketContractInfoView.setContractType(marketContractSymbolPriceItem.j());
        SymbolPrice symbolPrice = marketContractSymbolPriceItem.getSymbolPrice();
        String e12 = marketContractSymbolPriceItem.e();
        if (symbolPrice != null) {
            Double close = symbolPrice.getClose();
            Double open = symbolPrice.getOpen();
            double doubleValue = (close == null || open == null) ? 0.0d : close.doubleValue() - open.doubleValue();
            String str3 = "--";
            if (close == null || Double.compare(close.doubleValue(), 0.0d) == 0) {
                str = str3;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : "");
                sb2.append(m.i((doubleValue / open.doubleValue()) * 100.0d, PrecisionUtil.v(f11.getSymbol())));
                sb2.append("%");
                str = sb2.toString();
            }
            int color = context.getResources().getColor(w.k(str));
            if (Double.compare(doubleValue, 0.0d) > 0) {
                if (f11.isNotSupportTrade()) {
                    color = context.getResources().getColor(w.g());
                }
            } else if (Double.compare(doubleValue, 0.0d) < 0 && f11.isNotSupportTrade()) {
                color = context.getResources().getColor(w.f());
            }
            textView.setBackground(new BgColorDrawable(color, AbsMarketViewHandler.f72703g));
            if (TextUtils.isEmpty(marketContractSymbolPriceItem.h())) {
                str2 = str3;
            } else if (AppLanguageHelper.getInstance().isChineseLanguage()) {
                str2 = LegalCurrencyConfigUtil.w() + m.g(marketContractSymbolPriceItem.h());
            } else {
                str2 = LegalCurrencyConfigUtil.w() + m.X(marketContractSymbolPriceItem.h());
            }
            if (textView.getText() == null || !textView.getText().equals(str)) {
                textView.setText(str);
                this.f72706d.put(o(marketContractSymbolPriceItem2), Double.valueOf(doubleValue));
            }
            marketContractInfoView.setAmount(str2);
            marketPriceView.setPriceString(context.getResources().getString(com.hbg.module.market.R$string.contract_symbol_price_dollar) + m.c(marketContractSymbolPriceItem.d(), marketContractSymbolPriceItem.d()));
            marketPriceView.setPriceStringCny(e12);
        } else {
            textView.setBackground(new BgColorDrawable(context.getResources().getColor(w.k("0")), AbsMarketViewHandler.f72703g));
            String str4 = "--";
            textView.setText(str4);
            marketContractInfoView.setAmount(str4);
            marketPriceView.setPriceString(marketContractSymbolPriceItem.d());
            marketPriceView.setPriceStringCny(e12);
        }
        marketPriceView.setPaintColor(f11.isNotSupportTrade());
        if (f11.isNotSupportTrade()) {
            cVar2.itemView.setBackgroundColor(ContextCompat.getColor(context, R$color.baseColorDeepestBackground));
        } else {
            cVar2.itemView.setBackgroundResource(R$drawable.selector_market_item_click);
        }
        marketPriceView.invalidate();
        cVar2.itemView.setOnClickListener(new f(this, cVar2, marketContractSymbolPriceItem2, i11));
        cVar2.itemView.setOnLongClickListener(new g(marketContractSymbolPriceItem2, cVar2));
    }

    /* renamed from: c0 */
    public boolean A(MarketContractSymbolPriceItem marketContractSymbolPriceItem) {
        return false;
    }

    public int getResId() {
        return R$layout.item_contract_market_view;
    }

    public ViewGroup.LayoutParams s(int i11) {
        return new LinearLayout.LayoutParams(-1, i11);
    }
}
