package com.huobi.search.viewhandler;

import a7.e;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bh.j;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.huobi.search.bean.SearchResultItem;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import ej.g;
import i6.r;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import s9.c;
import sn.f;

public class SearchResultViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f80796b;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80797b;

        public a(String str) {
            this.f80797b = str;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SearchResultViewHandler.this.e(view);
            EventBus.d().k(new pl.b((SearchResultItem) view.getTag(R.id.item_data), (ImageView) view, this.f80797b));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SearchResultItem f80799b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f80800c;

        public b(SearchResultItem searchResultItem, String str) {
            this.f80799b = searchResultItem;
            this.f80800c = str;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            is.a.w("253", this.f80799b.getSymbol());
            SearchResultItem searchResultItem = (SearchResultItem) view.getTag(R.id.item_data1);
            if (searchResultItem.getItemCurrencyType() == 1 && searchResultItem.getContractCurrencyInfo() != null) {
                ContractCurrencyInfo contractCurrencyInfo = searchResultItem.getContractCurrencyInfo();
                br.c.g(j.c()).m(SearchResultViewHandler.this.f80796b, contractCurrencyInfo.getContractShortType());
                f.z(view.getContext(), contractCurrencyInfo.getContractShortType(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo, TradeType.CONTRACT);
            } else if (searchResultItem.getItemCurrencyType() == 2 && searchResultItem.getSwapCurrencyInfo() != null) {
                SwapCurrencyInfo swapCurrencyInfo = searchResultItem.getSwapCurrencyInfo();
                br.c.g(j.c()).m(SearchResultViewHandler.this.f80796b, swapCurrencyInfo.getContractShortType());
                f.I(view.getContext(), swapCurrencyInfo.getContractShortType(), swapCurrencyInfo.getContractCode(), swapCurrencyInfo, TradeType.SWAP);
            } else if (searchResultItem.getItemCurrencyType() == 4 && searchResultItem.getLinearSwapContractInfo() != null) {
                FutureContractInfo linearSwapContractInfo = searchResultItem.getLinearSwapContractInfo();
                br.c.g(j.c()).m(SearchResultViewHandler.this.f80796b, linearSwapContractInfo.getContractShortType());
                f.G(view.getContext(), linearSwapContractInfo);
            } else if (searchResultItem.getItemCurrencyType() == 3 && searchResultItem.getOptionContractInfo() != null) {
                FutureContractInfo optionContractInfo = searchResultItem.getOptionContractInfo();
                br.c.g(j.c()).m(SearchResultViewHandler.this.f80796b, optionContractInfo.getOptionCode());
                f.H(view.getContext(), optionContractInfo);
            } else if (searchResultItem.getItemCurrencyType() == 0) {
                if (!TextUtils.isEmpty(this.f80800c)) {
                    br.c.g(j.c()).m(SearchResultViewHandler.this.f80796b, this.f80800c);
                }
                fr.a.d(a1.v().n(searchResultItem.getSymbol()));
                a1 v11 = a1.v();
                String symbol = searchResultItem.getSymbol();
                TradeType tradeType = TradeType.PRO;
                SymbolBean J = v11.J(symbol, tradeType);
                if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
                    f.C(view.getContext(), searchResultItem.getSymbol(), false, tradeType);
                } else {
                    view.getContext().startActivity(k0.s(view.getContext(), searchResultItem.getSymbol(), true));
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, SearchResultItem searchResultItem, ViewGroup viewGroup) {
        String str;
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.item_search_symbol_result);
        ImageView c11 = e11.c(R.id.item_search_symbol_collect);
        String W = a1.v().W(searchResultItem.getSymbol());
        if (searchResultItem.getItemCurrencyType() == 1 && searchResultItem.getContractCurrencyInfo() != null) {
            e12.setText(g.d(searchResultItem.getContractCurrencyInfo().getContractShortType(), searchResultItem.getContractCurrencyInfo().getContractCode(), 1));
            str = "CONTRACT";
        } else if (searchResultItem.getItemCurrencyType() == 2 && searchResultItem.getSwapCurrencyInfo() != null) {
            e12.setText(us.j.f(searchResultItem.getSwapCurrencyInfo().getSymbol(), e12.getContext()));
            str = "CONTRACT_SWAP";
        } else if (searchResultItem.getItemCurrencyType() != 4 || searchResultItem.getLinearSwapContractInfo() == null) {
            if (searchResultItem.getItemCurrencyType() == 0) {
                e12.setText(W);
            } else if (searchResultItem.getItemCurrencyType() != 3 || searchResultItem.getOptionContractInfo() == null) {
                e12.setText(searchResultItem.getSymbol());
            } else {
                e12.setText(e.z(searchResultItem.getOptionContractInfo().getSymbol(), searchResultItem.getOptionContractInfo().getOptionCode(), cVar.itemView.getContext(), cVar.itemView.getContext().getResources().getColor(R.color.global_main_text_color)));
            }
            str = "PRO";
        } else {
            e12.setText(e.l(e12.getContext(), searchResultItem.getLinearSwapContractInfo().getSymbol(), searchResultItem.getLinearSwapContractInfo().getQuoteCurrency()));
            str = "LINEAR_SWAP";
        }
        if (searchResultItem.getItemCurrencyType() == 3) {
            c11.setVisibility(8);
        } else {
            c11.setVisibility(0);
            if (searchResultItem.isCollected()) {
                c11.setImageResource(R.drawable.star_common_light2);
            } else {
                c11.setImageResource(R.drawable.star_common2);
            }
        }
        c11.setClickable(true);
        c11.setTag(R.id.item_data, searchResultItem);
        c11.setOnClickListener(new a(str));
        RelativeLayout relativeLayout = (RelativeLayout) e11.b(R.id.item_search_symbol_layout);
        relativeLayout.setClickable(true);
        relativeLayout.setTag(R.id.item_data1, searchResultItem);
        relativeLayout.setOnClickListener(new b(searchResultItem, W));
    }

    public final void e(View view) {
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.3f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.3f, 1.0f})}).setDuration(300).start();
    }

    public int getResId() {
        if (tg.r.x().F0()) {
            this.f80796b = tg.r.x().J();
            return R.layout.item_search_symbol_result;
        }
        this.f80796b = "local_uid";
        return R.layout.item_search_symbol_result;
    }
}
