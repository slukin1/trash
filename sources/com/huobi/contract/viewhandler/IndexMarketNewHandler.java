package com.huobi.contract.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.R$string;
import com.huobi.homemarket.bean.MarketIndexPriceItem;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import com.huobi.homemarket.view.MarketContractInfoView;
import com.huobi.homemarket.view.MarketPriceView;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import fj.o;
import fj.p;
import i6.m;
import i6.r;
import v9.c;

public class IndexMarketNewHandler extends AbsMarketViewHandler<MarketIndexPriceItem> {
    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c0(c cVar, MarketIndexPriceItem marketIndexPriceItem, int i11, View view) {
        B(cVar, marketIndexPriceItem, i11);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean d0(MarketIndexPriceItem marketIndexPriceItem, c cVar, View view) {
        if (marketIndexPriceItem.c() == null) {
            return true;
        }
        marketIndexPriceItem.c().a(cVar.itemView, marketIndexPriceItem);
        return true;
    }

    /* renamed from: W */
    public void m(c cVar, MarketIndexPriceItem marketIndexPriceItem, int i11, boolean z11) {
        MarketModuleConfig.a().O(cVar.itemView.getContext(), marketIndexPriceItem.f(), x(marketIndexPriceItem));
    }

    /* renamed from: X */
    public String p(MarketIndexPriceItem marketIndexPriceItem) {
        IndexCurrencyInfo f11 = marketIndexPriceItem.f();
        return f11 != null ? f11.getContractCode() : "";
    }

    /* renamed from: Y */
    public String w(MarketIndexPriceItem marketIndexPriceItem) {
        return marketIndexPriceItem.f().getContractCode();
    }

    /* renamed from: Z */
    public TradeType x(MarketIndexPriceItem marketIndexPriceItem) {
        return marketIndexPriceItem.f().getQuoteCurrency().equalsIgnoreCase("usd") ? TradeType.CONTRACT_INDEX : TradeType.LINEAR_SWAP_INDEX;
    }

    /* renamed from: a0 */
    public void y(c cVar, int i11, MarketIndexPriceItem marketIndexPriceItem, ViewGroup viewGroup) {
        String str;
        c cVar2 = cVar;
        MarketIndexPriceItem marketIndexPriceItem2 = marketIndexPriceItem;
        super.handleView(cVar, i11, marketIndexPriceItem, viewGroup);
        IndexCurrencyInfo f11 = marketIndexPriceItem.f();
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        MarketContractInfoView marketContractInfoView = (MarketContractInfoView) e11.b(R$id.marketContractInfoView);
        MarketPriceView marketPriceView = (MarketPriceView) e11.b(R$id.marketContractPriceView);
        TextView textView = (TextView) e11.b(R$id.item_chart_percent);
        f6.c.a().f(e11.c(R$id.iv_item_basecurrency), AbsMarketViewHandler.q(marketIndexPriceItem.getBaseCurrency()), AbsMarketViewHandler.r());
        marketContractInfoView.setSymbolName(marketIndexPriceItem.g());
        SymbolPrice symbolPrice = marketIndexPriceItem.getSymbolPrice();
        marketContractInfoView.setContractType(marketIndexPriceItem.h());
        if (symbolPrice != null) {
            Double close = symbolPrice.getClose();
            Double open = symbolPrice.getOpen();
            double doubleValue = (close == null || open == null) ? 0.0d : close.doubleValue() - open.doubleValue();
            String str2 = "";
            MarketContractInfoView marketContractInfoView2 = marketContractInfoView;
            MarketPriceView marketPriceView2 = marketPriceView;
            if (close == null || Double.compare(close.doubleValue(), 0.0d) == 0) {
                str = "--";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : str2);
                sb2.append(m.i((doubleValue / open.doubleValue()) * 100.0d, PrecisionUtil.v(f11.getContractShortType())));
                sb2.append("%");
                str = sb2.toString();
            }
            textView.setBackground(new BgColorDrawable(context.getResources().getColor(w.k(str)), AbsMarketViewHandler.f72703g));
            if (textView.getText() == null || !textView.getText().equals(str)) {
                textView.setText(str);
                this.f72706d.put(o(marketIndexPriceItem2), Double.valueOf(doubleValue));
            }
            boolean equalsIgnoreCase = "usdt".equalsIgnoreCase(f11.getQuoteCurrency());
            marketContractInfoView = marketContractInfoView2;
            marketContractInfoView.setAmount("--");
            String c11 = m.c(marketIndexPriceItem.d(), marketIndexPriceItem.d());
            StringBuilder sb3 = new StringBuilder();
            if (!equalsIgnoreCase) {
                str2 = context.getResources().getString(R$string.contract_symbol_price_dollar);
            }
            sb3.append(str2);
            sb3.append(c11);
            marketPriceView = marketPriceView2;
            marketPriceView.setPriceString(sb3.toString());
            marketPriceView.setPriceStringCny(marketIndexPriceItem.e());
        } else {
            textView.setBackground(new BgColorDrawable(context.getResources().getColor(w.k("0")), AbsMarketViewHandler.f72703g));
            textView.setText("--");
            marketContractInfoView.setAmount("--");
            marketPriceView.setPriceString(marketIndexPriceItem.d());
            marketPriceView.setPriceStringCny(marketIndexPriceItem.e());
        }
        marketContractInfoView.setAmount("--");
        marketPriceView.invalidate();
        cVar2.itemView.setOnClickListener(new o(this, cVar2, marketIndexPriceItem2, i11));
        cVar2.itemView.setOnLongClickListener(new p(marketIndexPriceItem2, cVar2));
        marketContractInfoView.setIsCollected(MarketModuleConfig.a().k(f11.getContractShortType()) && !marketIndexPriceItem.k());
    }

    /* renamed from: b0 */
    public boolean A(MarketIndexPriceItem marketIndexPriceItem) {
        return false;
    }

    public int getResId() {
        return R$layout.item_contract_market_view;
    }

    public ViewGroup.LayoutParams s(int i11) {
        return new LinearLayout.LayoutParams(-1, i11);
    }
}
