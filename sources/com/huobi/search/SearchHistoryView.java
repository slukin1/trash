package com.huobi.search;

import a7.e;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import ar.h;
import ar.i;
import bh.j;
import br.c;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.view.wraplayout.AutoWrapLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import fr.a;
import gj.d;
import gs.g;
import i6.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import pro.huobi.R;
import sn.f;

public class SearchHistoryView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public String f80750b;

    /* renamed from: c  reason: collision with root package name */
    public AutoWrapLayout f80751c;

    public SearchHistoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h(Context context, View view) {
        c.g(context).f(this.f80750b);
        n(context);
        HashMap hashMap = new HashMap();
        hashMap.put("History_Delete", "");
        g.i("Search_History_Delete_Search_click", hashMap);
        k.o("NewSearch", "Search_History_Delete_Search_click");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void i(boolean z11) {
        HashMap hashMap = new HashMap();
        String str = "Unfold";
        hashMap.put("History_Fold", z11 ? str : "Fold");
        g.i("Search_History_click", hashMap);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Search_History_Fold_click:");
        if (!z11) {
            str = "Fold";
        }
        sb2.append(str);
        k.o("NewSearch", sb2.toString());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(String str, Context context, SwapCurrencyInfo swapCurrencyInfo, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("History_site", str);
        g.i("Search_History_click", hashMap);
        k.o("NewSearch", "Search_History_click:" + str);
        f.I(context, swapCurrencyInfo.getSymbol(), swapCurrencyInfo.getContractCode(), swapCurrencyInfo, TradeType.SWAP);
        c.g(j.c()).m(this.f80750b, swapCurrencyInfo.getContractCode());
        n(context);
        a.d(swapCurrencyInfo.getContractCode());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(String str, Context context, FutureContractInfo futureContractInfo, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("History_site", str);
        g.i("Search_History_click", hashMap);
        k.o("NewSearch", "Search_History_click:" + str);
        f.G(context, futureContractInfo);
        c.g(j.c()).m(this.f80750b, futureContractInfo.getContractCode());
        n(context);
        a.d(futureContractInfo.getContractCode());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l(String str, Context context, ContractCurrencyInfo contractCurrencyInfo, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("History_site", str);
        g.i("Search_History_click", hashMap);
        k.o("NewSearch", "Search_History_click:" + str);
        f.z(context, contractCurrencyInfo.getSymbol(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo, TradeType.CONTRACT);
        c.g(j.c()).m(this.f80750b, contractCurrencyInfo.getContractCode());
        n(context);
        a.d(contractCurrencyInfo.getContractCode());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m(String str, Context context, String str2, SymbolBean symbolBean, View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("History_site", str);
        g.i("Search_History_click", hashMap);
        k.o("NewSearch", "Search_History_click:" + str);
        a1 v11 = a1.v();
        TradeType tradeType = TradeType.PRO;
        f.C(context, v11.I(str2, tradeType), false, tradeType);
        c.g(j.c()).m(this.f80750b, str2);
        if (symbolBean != null) {
            a.d(symbolBean.getBaseCurrency());
        }
        n(context);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void g(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_search_history, this);
        AutoWrapLayout autoWrapLayout = (AutoWrapLayout) findViewById(R.id.wrap_layout);
        this.f80751c = autoWrapLayout;
        autoWrapLayout.setStateImage(R.drawable.search_history_arrow_upper, R.drawable.search_history_arrow_down);
        findViewById(R.id.image_view_clear).setOnClickListener(new ar.f(this, context));
        setOrientation(1);
        this.f80751c.setListener(ar.k.f12193a);
        n(context);
    }

    public void n(Context context) {
        View.OnClickListener onClickListener;
        String str;
        String str2;
        String str3;
        Context context2 = context;
        this.f80750b = "1";
        List<String> j11 = c.g(context).j(this.f80750b);
        LinkedList linkedList = new LinkedList();
        if (j11.size() > 0) {
            int i11 = 0;
            while (i11 < j11.size()) {
                String str4 = j11.get(i11);
                int i12 = i11 + 1;
                String valueOf = String.valueOf(i12);
                SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(str4);
                FutureContractInfo o11 = FutureContractInfoController.n().o(str4);
                ContractCurrencyInfo b11 = ContractCurrencyUtils.b(str4);
                String str5 = "";
                SymbolBean J = a1.v().J(str4.toLowerCase().replace("/", str5), TradeType.PRO);
                if (c11 != null && str4.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && d.n().E()) {
                    String contractCode = c11.getContractCode();
                    if (contractCode.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) > 0) {
                        String[] split = contractCode.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (split.length > 1) {
                            str5 = split[1];
                        }
                    }
                    Application c12 = j.c();
                    String symbol = c11.getSymbol();
                    String contractCode2 = c11.getContractCode();
                    if (TextUtils.isEmpty(c11.getContractType())) {
                        str3 = "swap";
                    } else {
                        str3 = c11.getContractType();
                    }
                    str = e.v(c12, symbol, str5, contractCode2, str3);
                    onClickListener = new i(this, valueOf, context2, c11);
                } else if (o11 != null && str4.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER) && d.n().E()) {
                    String contractCode3 = o11.getContractCode();
                    if (contractCode3.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) > 0) {
                        String[] split2 = contractCode3.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (split2.length > 1) {
                            str5 = split2[1];
                        }
                    }
                    String v11 = (o11.getContractType() == null || TextUtils.isEmpty(o11.getContractType())) ? null : e.v(j.c(), o11.getSymbol(), str5, o11.getContractCode(), o11.getContractType());
                    onClickListener = new ar.g(this, valueOf, context2, o11);
                    str = v11;
                } else if (b11 == null || !d.n().E()) {
                    str = str4.toUpperCase();
                    onClickListener = new ar.j(this, valueOf, context, str4, J);
                } else {
                    String contractCode4 = b11.getContractCode();
                    if (contractCode4.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER) > 0) {
                        String[] split3 = contractCode4.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        str2 = split3.length > 1 ? split3[1] : str5;
                    } else {
                        str2 = "USD";
                    }
                    Application c13 = j.c();
                    String symbol2 = b11.getSymbol();
                    String contractCode5 = b11.getContractCode();
                    if (!TextUtils.isEmpty(b11.getContractType())) {
                        str5 = b11.getContractType();
                    }
                    str = e.v(c13, symbol2, str2, contractCode5, str5);
                    onClickListener = new h(this, valueOf, context2, b11);
                }
                View inflate = LayoutInflater.from(context).inflate(R.layout.item_search_hsitory_text_view, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.text_view_item_search_history_symbol);
                TextView textView2 = (TextView) inflate.findViewById(R.id.text_view_item_search_history_margin);
                String replaceAll = str.replaceAll("/", " /");
                int indexOf = replaceAll.indexOf("/");
                if (-1 == indexOf) {
                    indexOf = replaceAll.indexOf(" ");
                }
                if (-1 != indexOf) {
                    SpannableString spannableString = new SpannableString(replaceAll);
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.baseColorPrimaryText)), 0, indexOf, 33);
                    if (Build.VERSION.SDK_INT >= 28) {
                        spannableString.setSpan(new TypefaceSpan(ResourcesCompat.h(context2, R.font.roboto_medium)), 0, indexOf, 33);
                    }
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.baseColorPrimaryText)), 0, indexOf, 33);
                    textView.setText(spannableString);
                    if (d.n().G() && J != null && !TextUtils.isEmpty(J.getSuperMarginLeverageRatio())) {
                        textView2.setText(J.getSuperMarginLeverageRatio() + "X");
                        textView2.setVisibility(0);
                    } else if (!d.n().G() || J == null || TextUtils.isEmpty(J.getLeverageRatio())) {
                        textView2.setVisibility(8);
                    } else {
                        textView2.setText(J.getLeverageRatio() + "X");
                        textView2.setVisibility(0);
                    }
                } else {
                    textView.setText(replaceAll);
                }
                linkedList.add(inflate);
                inflate.setOnClickListener(onClickListener);
                i11 = i12;
            }
            this.f80751c.addChildView(linkedList);
            setVisibility(0);
            return;
        }
        setVisibility(8);
    }

    public SearchHistoryView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        g(context);
    }
}
