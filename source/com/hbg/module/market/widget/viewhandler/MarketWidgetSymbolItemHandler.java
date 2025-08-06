package com.hbg.module.market.widget.viewhandler;

import a7.e;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.linear.swap.controller.LinearSwapCurrencyInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapContractInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.module.market.R$id;
import com.hbg.module.market.R$layout;
import com.hbg.module.market.widget.bean.MarketWidgetInfo;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import ej.g;
import i6.r;
import pf.d;
import pf.f;
import pf.h;
import pf.i;
import us.j;

public class MarketWidgetSymbolItemHandler implements s9.c {

    /* renamed from: d  reason: collision with root package name */
    public static int f26803d;

    /* renamed from: b  reason: collision with root package name */
    public Interpolator f26804b = new DecelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public int f26805c;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarketWidgetSymbolItem f26806b;

        public a(MarketWidgetSymbolItem marketWidgetSymbolItem) {
            this.f26806b = marketWidgetSymbolItem;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f26806b.getCallback() != null) {
                this.f26806b.getCallback().b(false);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f26806b.getCallback() != null) {
                this.f26806b.getCallback().b(true);
            }
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MarketWidgetSymbolItem f26808b;

        public b(MarketWidgetSymbolItem marketWidgetSymbolItem) {
            this.f26808b = marketWidgetSymbolItem;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f26808b.getCallback() != null) {
                this.f26808b.getCallback().b(false);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (this.f26808b.getCallback() != null) {
                this.f26808b.getCallback().b(true);
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26810a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26810a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26810a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26810a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT_INDEX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f26810a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP_INDEX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f26810a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler.c.<clinit>():void");
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(MarketWidgetSymbolItem marketWidgetSymbolItem, View view) {
        if (marketWidgetSymbolItem != null) {
            marketWidgetSymbolItem.getCallback().a(marketWidgetSymbolItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ boolean j(MarketWidgetSymbolItem marketWidgetSymbolItem, v9.c cVar, View view, MotionEvent motionEvent) {
        if (marketWidgetSymbolItem.getItemTouchHelp() == null) {
            return false;
        }
        marketWidgetSymbolItem.getItemTouchHelp().w(cVar);
        return false;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(MarketWidgetSymbolItem.a aVar, MarketWidgetSymbolItem marketWidgetSymbolItem, View view) {
        if (aVar != null) {
            aVar.e(marketWidgetSymbolItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(MarketWidgetSymbolItem.a aVar, View view) {
        if (aVar != null) {
            aVar.c();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(MarketWidgetSymbolItem.a aVar, View view, TextView textView, MarketWidgetSymbolItem marketWidgetSymbolItem, View view2) {
        if (aVar != null) {
            aVar.d(view, textView, marketWidgetSymbolItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(TextView textView, MarketWidgetSymbolItem marketWidgetSymbolItem, View view, View view2) {
        f26803d = textView.getWidth();
        q(marketWidgetSymbolItem, view, view2, textView);
    }

    public static String o(MarketWidgetInfo marketWidgetInfo, Context context) {
        if (marketWidgetInfo == null) {
            return "";
        }
        String symbol = marketWidgetInfo.getSymbol();
        int i11 = c.f26810a[marketWidgetInfo.getTradeType().ordinal()];
        if (i11 == 1) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(marketWidgetInfo.getSymbol());
            if (b11 != null) {
                return g.i(BaseApplication.b(), b11.getSymbol());
            }
            return "";
        } else if (i11 == 2) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(marketWidgetInfo.getSymbol());
            if (c11 == null || !marketWidgetInfo.getSymbol().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return "";
            }
            return j.i(c11.getSymbol());
        } else if (i11 == 3 || i11 == 4) {
            if (symbol.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return j.c(BaseApplication.b(), marketWidgetInfo.getBaseCurrency(), marketWidgetInfo.getQuoteCurrency());
            }
            return "";
        } else if (i11 != 5) {
            return marketWidgetInfo.getBaseCurrency();
        } else {
            LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(marketWidgetInfo.getSymbol());
            if (n11 == null || !marketWidgetInfo.getSymbol().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return "";
            }
            return e.p(context, n11.getSymbol(), marketWidgetInfo.getQuoteCurrency());
        }
    }

    public static String p(MarketWidgetInfo marketWidgetInfo, Context context) {
        if (marketWidgetInfo == null) {
            return "";
        }
        if (marketWidgetInfo.getTradeType() == TradeType.SWAP) {
            return j.k(BaseApplication.b());
        }
        if (marketWidgetInfo.getTradeType() == TradeType.LINEAR_SWAP) {
            LinearSwapContractInfo n11 = LinearSwapCurrencyInfoController.l().n(marketWidgetInfo.getSymbol());
            if (n11 == null || !marketWidgetInfo.getSymbol().contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return e.f(marketWidgetInfo.getSymbol());
            }
            return e.r(context, n11.getContractCode(), n11.getContractType());
        } else if (marketWidgetInfo.getTradeType() == TradeType.CONTRACT) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(marketWidgetInfo.getSymbol());
            if (b11 != null) {
                return g.k(BaseApplication.b(), b11.getContractCode(), b11.getContractType());
            }
            return e.f(marketWidgetInfo.getSymbol());
        } else if (marketWidgetInfo.getTradeType() == TradeType.CONTRACT_INDEX || marketWidgetInfo.getTradeType() == TradeType.LINEAR_SWAP_INDEX) {
            return j.d(BaseApplication.b());
        } else {
            return marketWidgetInfo.getQuoteCurrency();
        }
    }

    public int getResId() {
        return R$layout.item_market_widget_symbol_list;
    }

    /* renamed from: h */
    public void handleView(v9.c cVar, int i11, MarketWidgetSymbolItem marketWidgetSymbolItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View b11 = e11.b(R$id.item_search_symbol_root);
        View b12 = e11.b(R$id.item_search_symbol_layout);
        ImageView c11 = e11.c(R$id.iv_item_delete_btn);
        TextView e12 = e11.e(R$id.item_search_symbol_currency);
        TextView e13 = e11.e(R$id.item_search_qotue_currency);
        TextView e14 = e11.e(R$id.tv_item_confirm_delete);
        this.f26805c = PixelUtils.a(50.0f);
        MarketWidgetSymbolItem.a callback = marketWidgetSymbolItem.getCallback();
        e11.c(R$id.iv_market_coll_top).setOnClickListener(new pf.g(marketWidgetSymbolItem));
        e11.c(R$id.iv_market_coll_drag).setOnTouchListener(new h(marketWidgetSymbolItem, cVar));
        MarketWidgetInfo marketWidgetInfo = marketWidgetSymbolItem.getMarketWidgetInfo();
        c11.setOnClickListener(new f(callback, marketWidgetSymbolItem));
        b12.setOnClickListener(new d(callback));
        e14.setOnClickListener(new pf.e(callback, b11, e14, marketWidgetSymbolItem));
        String o11 = o(marketWidgetInfo, cVar.itemView.getContext());
        String p11 = p(marketWidgetInfo, cVar.itemView.getContext());
        if (TextUtils.isEmpty(o11)) {
            o11 = "--";
        }
        if (!(marketWidgetSymbolItem.getTradeType() == TradeType.SWAP || marketWidgetSymbolItem.getTradeType() == TradeType.CONTRACT || marketWidgetSymbolItem.getTradeType() == TradeType.LINEAR_SWAP || marketWidgetSymbolItem.getTradeType() == TradeType.CONTRACT_INDEX || marketWidgetSymbolItem.getTradeType() == TradeType.LINEAR_SWAP_INDEX || TextUtils.isEmpty(p11))) {
            p11 = "/" + p11;
        }
        e12.setText(o11);
        e13.setText(p11);
        if (f26803d == 0) {
            e14.post(new i(this, e14, marketWidgetSymbolItem, b11, b12));
        } else {
            q(marketWidgetSymbolItem, b11, b12, e14);
        }
    }

    public final void q(MarketWidgetSymbolItem marketWidgetSymbolItem, View view, View view2, View view3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = this.f26805c;
        view.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = view3.getLayoutParams();
        layoutParams2.width = f26803d;
        view3.setLayoutParams(layoutParams2);
        int delBtnStatus = marketWidgetSymbolItem.getDelBtnStatus();
        if (delBtnStatus == 0) {
            view3.setTranslationX((float) f26803d);
            view2.setTranslationX(0.0f);
        } else if (delBtnStatus == 1) {
            view3.setTranslationX(0.0f);
            view2.setTranslationX((float) (-f26803d));
        } else if (delBtnStatus == 2) {
            marketWidgetSymbolItem.setDelBtnStatus(1);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, View.TRANSLATION_X, new float[]{(float) f26803d, 0.0f});
            ofFloat.addListener(new a(marketWidgetSymbolItem));
            ofFloat.setDuration(270);
            ofFloat.setInterpolator(this.f26804b);
            ofFloat.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{0.0f, (float) (-f26803d)});
            ofFloat2.setDuration(270);
            ofFloat2.setInterpolator(this.f26804b);
            ofFloat2.start();
        } else if (delBtnStatus == 3) {
            marketWidgetSymbolItem.setDelBtnStatus(0);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view3, View.TRANSLATION_X, new float[]{0.0f, (float) f26803d});
            ofFloat3.addListener(new b(marketWidgetSymbolItem));
            ofFloat3.setDuration(270);
            ofFloat3.setInterpolator(this.f26804b);
            ofFloat3.start();
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, new float[]{(float) (-f26803d), 0.0f});
            ofFloat4.setDuration(270);
            ofFloat4.setInterpolator(this.f26804b);
            ofFloat4.start();
        }
    }
}
