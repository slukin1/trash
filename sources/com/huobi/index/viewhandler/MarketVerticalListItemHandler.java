package com.huobi.index.viewhandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.sharesdk.framework.InnerShareParams;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.lite.market.widget.TradingCurveView;
import com.huawei.secure.android.common.ssl.util.f;
import com.huobi.contract.utils.LegalContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.index.bean.RealTimePrice;
import com.huobi.index.presenter.IndexPresenter;
import com.huobi.statistics.GrowingIOStatics;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.imsdk.v2.V2TIMConversation;
import d7.a1;
import ej.g;
import i6.d;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import pro.huobi.R;
import s9.c;
import us.i;
import us.j;

public class MarketVerticalListItemHandler implements c, View.OnClickListener {

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f74229a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f74229a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f74229a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.index.viewhandler.MarketVerticalListItemHandler.a.<clinit>():void");
        }
    }

    public static String c(RealTimePrice realTimePrice) {
        if (realTimePrice == null || Double.compare(realTimePrice.j(), 0.0d) <= 0) {
            return "--";
        }
        BigDecimal subtract = BigDecimal.valueOf(realTimePrice.j()).subtract(BigDecimal.valueOf(realTimePrice.s()));
        if (BigDecimal.valueOf(realTimePrice.s()).compareTo(BigDecimal.ZERO) != 0) {
            int v11 = PrecisionUtil.v(realTimePrice.o());
            String str = subtract.compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
            return str + m.V(m.m(String.valueOf((subtract.doubleValue() * 100.0d) / realTimePrice.s()), v11), v11) + "%";
        }
        return String.format("%." + PrecisionUtil.v(realTimePrice.o()) + f.f38658a, new Object[]{Float.valueOf(0.0f)});
    }

    public static String d(RealTimePrice realTimePrice) {
        int i11;
        if (Double.compare(realTimePrice.j(), 0.0d) <= 0) {
            return "--";
        }
        if (realTimePrice.p() != 1) {
            i11 = PrecisionUtil.x(realTimePrice.o());
        } else if ("usdt".equalsIgnoreCase(realTimePrice.k())) {
            i11 = FuturePrecisionUtil.c(realTimePrice.a());
        } else if ("usd".equalsIgnoreCase(realTimePrice.k())) {
            i11 = i.o(realTimePrice.a());
        } else {
            i11 = PrecisionUtil.x(realTimePrice.o());
        }
        return m.V(m.w(realTimePrice.j(), i11), i11);
    }

    public static String f(Context context, wl.c cVar, RealTimePrice realTimePrice) {
        if ("2".equals(realTimePrice.q()) && cVar != null && cVar.c() != null) {
            return g.d(cVar.c().getContractShortType(), cVar.c().getContractCode(), 1);
        }
        if (!"3".equals(realTimePrice.q()) || cVar == null || cVar.e() == null) {
            return a1.v().X(realTimePrice.o(), TradeType.PRO);
        }
        return j.f(cVar.e().getSymbol(), context);
    }

    public static int g(Context context, RealTimePrice realTimePrice) {
        double doubleValue = Double.valueOf(realTimePrice.g()).doubleValue() - Double.valueOf(realTimePrice.s()).doubleValue();
        if (Double.compare(doubleValue, 0.0d) > 0) {
            if (w.l()) {
                return ContextCompat.getColor(context, R.color.color_down);
            }
            return ContextCompat.getColor(context, R.color.color_rise);
        } else if (Double.compare(doubleValue, 0.0d) >= 0) {
            return ContextCompat.getColor(context, R.color.color_flat);
        } else {
            if (w.l()) {
                return ContextCompat.getColor(context, R.color.color_rise);
            }
            return ContextCompat.getColor(context, R.color.color_down);
        }
    }

    public final String b(Context context, wl.c cVar, RealTimePrice realTimePrice) {
        int p11 = realTimePrice.p();
        String a11 = realTimePrice.a();
        String k11 = realTimePrice.k();
        if (p11 != 1) {
            return f(context, cVar, cVar.d());
        }
        return a11 + "/" + k11;
    }

    public final int e(int i11, int i12) {
        if (i11 == 0) {
            return i12 + 1;
        }
        return (i11 == 1 ? i12 - 3 : i12 - 6) + 1;
    }

    public int getResId() {
        return R.layout.index_market_vertical_list_item;
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: h */
    public void handleView(v9.c cVar, int i11, wl.c cVar2, ViewGroup viewGroup) {
        boolean z11;
        String str;
        v9.c cVar3 = cVar;
        int i12 = i11;
        wl.c cVar4 = cVar2;
        RealTimePrice d11 = cVar2.d();
        Context context = cVar3.itemView.getContext();
        cVar3.itemView.setOnClickListener(this);
        cVar3.itemView.setTag(R.id.item_data1, Integer.valueOf(i11));
        cVar3.itemView.setTag(R.id.item_data, cVar4);
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.id_index_market_vertical_list_item_symbol);
        TextView textView2 = (TextView) e11.b(R.id.id_index_market_vertical_list_item_percent);
        TextView textView3 = (TextView) e11.b(R.id.id_index_market_vertical_list_item_price);
        TextView textView4 = (TextView) e11.b(R.id.id_index_market_vertical_list_item_legal);
        ImageView imageView = (ImageView) e11.b(R.id.id_index_market_vertical_list_item_tag);
        TextView textView5 = (TextView) e11.b(R.id.id_index_market_vertical_list_item_tag_new);
        TradingCurveView tradingCurveView = (TradingCurveView) e11.b(R.id.lite_trading_view);
        int g11 = g(context, d11);
        tradingCurveView.setColor(g11);
        if (!CollectionsUtils.b(d11.r())) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(d11.r());
            Collections.reverse(arrayList);
            tradingCurveView.setData(arrayList);
        } else {
            tradingCurveView.setData((List<String>) null);
        }
        if (d11.p() == 1) {
            String a11 = d11.a();
            String k11 = d11.k();
            textView.setText(a11 + k11);
        } else {
            textView.setText(f(context, cVar4, d11));
        }
        if (d11.p() == 1) {
            textView5.setVisibility(0);
            textView5.setText(d11.f());
        } else {
            textView5.setVisibility(8);
        }
        ImageView imageView2 = imageView;
        if (!"2".equals(d11.q()) || cVar2.c() == null) {
            z11 = false;
            if (!"3".equals(d11.q()) || cVar2.e() == null) {
                if (Double.compare(d11.j(), 0.0d) > 0) {
                    textView2.setText(c(d11));
                    textView2.setTextColor(g11);
                    String d12 = d(d11);
                    textView3.setText(m.c(d12, d12));
                    try {
                        str = LegalCurrencyConfigUtil.B(String.valueOf(d11.l()));
                    } catch (Exception e12) {
                        d.g(e12);
                        str = "";
                    }
                    String c11 = m.c(str, str);
                    textView4.setText(LegalCurrencyConfigUtil.w() + c11);
                    if (imageView2 != null) {
                        if (d11.d() != 1 || TextUtils.isEmpty(d11.e())) {
                            imageView2.setVisibility(8);
                        } else if (URLUtil.isValidUrl(d11.e())) {
                            ImageView imageView3 = imageView2;
                            imageView3.setVisibility(0);
                            f6.c.a().f(imageView3, d11.e(), 0);
                        }
                    }
                } else {
                    i(textView2, textView3, textView4, g11, "--", "--");
                }
            } else if (bj.d.x()) {
                i(textView2, textView3, textView4, g11, "--", "--");
            } else if (Double.compare(d11.j(), 0.0d) > 0) {
                textView2.setText(c(d11));
                textView2.setTextColor(g11);
                Double valueOf = Double.valueOf(d11.j());
                int o11 = i.o(cVar2.e().getSymbol());
                textView3.setTextColor(g11);
                textView3.setText(String.format("%s%s", new Object[]{context.getString(R.string.contract_symbol_price_dollar), m.m(String.valueOf(valueOf), o11)}));
                String b11 = LegalContractCurrencyUtils.b(d11);
                textView4.setText(LegalCurrencyConfigUtil.w() + b11);
            } else {
                i(textView2, textView3, textView4, g11, "--", "--");
            }
        } else if (bj.d.s()) {
            z11 = false;
            i(textView2, textView3, textView4, g11, "--", "--");
        } else {
            TextView textView6 = textView4;
            z11 = false;
            if (Double.compare(d11.j(), 0.0d) > 0) {
                textView2.setText(c(d11));
                textView2.setTextColor(g11);
                textView3.setTextColor(g11);
                Double valueOf2 = Double.valueOf(d11.j());
                textView3.setText(String.format("%s%s", new Object[]{context.getString(R.string.contract_symbol_price_dollar), m.m(String.valueOf(valueOf2), ej.f.p(cVar2.c().getContractCode()))}));
                String b12 = LegalContractCurrencyUtils.b(d11);
                textView6.setText(LegalCurrencyConfigUtil.w() + b12);
            } else {
                i(textView2, textView3, textView6, g11, "--", "--");
            }
        }
        CharSequence text = textView3.getText();
        if (TextUtils.isEmpty(text)) {
            ViewUtil.n(textView2, z11);
        } else if ("--".equalsIgnoreCase(text.toString())) {
            ViewUtil.n(textView2, z11);
        } else {
            ViewUtil.n(textView2, true);
        }
        int i13 = i11;
        if (j(IndexPresenter.X, i13)) {
            HashMap hashMap = new HashMap();
            hashMap.put(InnerShareParams.SITE, String.valueOf(e(IndexPresenter.X, i13)));
            hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, Integer.valueOf(IndexPresenter.X + 1));
            hashMap.put("name", b(context, cVar2, cVar2.d()));
            hashMap.put("type", String.valueOf(d11.p()));
            hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
            gs.g.i("symbol_show", hashMap);
        }
    }

    public final void i(TextView textView, TextView textView2, TextView textView3, int i11, String str, String str2) {
        textView.setText(str);
        textView.setTextColor(i11);
        textView2.setText(str2);
        textView2.setTextColor(i11);
        textView3.setText(str);
    }

    public final boolean j(int i11, int i12) {
        return i11 == 0 ? i12 >= 0 && i12 <= 2 : i11 == 1 ? i12 >= 3 && i12 <= 5 : i12 >= 6 && i12 <= 8;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!NetworkStatus.c(view.getContext())) {
            HuobiToastUtil.k(bh.j.c(), R.string.server_error);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        wl.c cVar = (wl.c) view.getTag(R.id.item_data);
        RealTimePrice d11 = cVar.d();
        if (d11 == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        int p11 = d11.p();
        if (p11 == 1) {
            TradeType tradeTypeBySymbol = TradeType.getTradeTypeBySymbol(d11.o());
            int i11 = a.f74229a[tradeTypeBySymbol.ordinal()];
            if (i11 == 1) {
                FutureContractInfo futureContractInfo = new FutureContractInfo();
                futureContractInfo.setSymbol(d11.a());
                futureContractInfo.setQuoteCurrency(d11.k());
                futureContractInfo.setContractCode(d11.o());
                futureContractInfo.setContractShortType(d11.o());
                LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(d11.o());
                if (n11 != null) {
                    futureContractInfo.setContractFace(n11.getContractFace());
                }
                futureContractInfo.setContractType("swap");
                sn.f.G(view.getContext(), futureContractInfo);
            } else if (i11 != 2) {
                sn.f.E(view.getContext(), d11.o(), false, false, tradeTypeBySymbol);
            } else {
                SwapCurrencyInfo h11 = SwapCurrencyInfoController.k().h(d11.a());
                if (h11 != null) {
                    h11.setSymbol(d11.a());
                    h11.setContractShortType(d11.o());
                    sn.f.I(view.getContext(), d11.o(), d11.o(), h11, TradeType.SWAP);
                } else {
                    sn.f.E(view.getContext(), d11.o(), false, false, tradeTypeBySymbol);
                }
            }
        } else {
            String o11 = cVar.d().o();
            sn.f.C(view.getContext(), o11, false, TradeType.PRO);
            GrowingIOStatics.f(o11);
            is.a.w("130", cVar.d().a() + cVar.d().k());
        }
        Object tag = view.getTag(R.id.item_data1);
        HashMap hashMap = new HashMap();
        hashMap.put(InnerShareParams.SITE, String.valueOf(e(IndexPresenter.X, ((Integer) tag).intValue())));
        hashMap.put(V2TIMConversation.CONVERSATION_GROUP_TYPE, Integer.valueOf(IndexPresenter.X + 1));
        hashMap.put("name", b(view.getContext(), cVar, cVar.d()));
        hashMap.put("type", String.valueOf(p11));
        hashMap.put("testKey", SP.i("key_home_page_layout_type", "A"));
        gs.g.i("symbol_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
