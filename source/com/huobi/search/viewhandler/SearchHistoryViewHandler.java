package com.huobi.search.viewhandler;

import a7.e;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.res.Resources;
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
import com.huobi.search.bean.SearchHistoryItem;
import com.huobi.search.bean.SearchResultItem;
import com.huobi.utils.k0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import ej.g;
import i6.r;
import org.greenrobot.eventbus.EventBus;
import pro.huobi.R;
import sn.f;

public class SearchHistoryViewHandler implements s9.c {

    /* renamed from: b  reason: collision with root package name */
    public String f80787b;

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v9.c f80788b;

        public a(v9.c cVar) {
            this.f80788b = cVar;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            try {
                if (br.c.g(this.f80788b.itemView.getContext()).f(SearchHistoryViewHandler.this.f80787b) > 0) {
                    cr.a aVar = new cr.a(new SearchHistoryItem());
                    aVar.a(true);
                    EventBus.d().k(aVar);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f80790b;

        public b(String str) {
            this.f80790b = str;
        }

        public static /* synthetic */ void b(View view, String str) {
            SearchHistoryItem searchHistoryItem = (SearchHistoryItem) view.getTag(R.id.item_data);
            SearchResultItem searchResultItem = new SearchResultItem();
            searchResultItem.setCollected(searchHistoryItem.isCollected());
            searchResultItem.setSymbol(searchHistoryItem.getSymbol());
            pl.b bVar = new pl.b(searchResultItem, (ImageView) view, str);
            bVar.a(true);
            EventBus.d().k(bVar);
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            SearchHistoryViewHandler.this.e(view);
            view.postDelayed(new gr.a(view, this.f80790b), 300);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SearchHistoryItem f80792b;

        public c(SearchHistoryItem searchHistoryItem) {
            this.f80792b = searchHistoryItem;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            a1 v11 = a1.v();
            String searchKeyWord = this.f80792b.getSearchKeyWord();
            TradeType tradeType = TradeType.PRO;
            String I = v11.I(searchKeyWord, tradeType);
            is.a.w("253", I);
            if (this.f80792b.getItemCurrencyType() == 1 && this.f80792b.getContractCurrencyInfo() != null) {
                ContractCurrencyInfo contractCurrencyInfo = this.f80792b.getContractCurrencyInfo();
                br.c.g(j.c()).m(SearchHistoryViewHandler.this.f80787b, contractCurrencyInfo.getContractShortType());
                f.z(view.getContext(), contractCurrencyInfo.getContractShortType(), contractCurrencyInfo.getContractCode(), contractCurrencyInfo, TradeType.CONTRACT);
            } else if (this.f80792b.getItemCurrencyType() == 2 && this.f80792b.getSwapCurrencyInfo() != null) {
                SwapCurrencyInfo swapCurrencyInfo = this.f80792b.getSwapCurrencyInfo();
                br.c.g(j.c()).m(SearchHistoryViewHandler.this.f80787b, swapCurrencyInfo.getContractShortType());
                f.I(view.getContext(), swapCurrencyInfo.getContractShortType(), swapCurrencyInfo.getContractCode(), swapCurrencyInfo, TradeType.SWAP);
            } else if (this.f80792b.getItemCurrencyType() == 4 && this.f80792b.getLinearSwapContractInfo() != null) {
                FutureContractInfo linearSwapContractInfo = this.f80792b.getLinearSwapContractInfo();
                br.c.g(j.c()).m(SearchHistoryViewHandler.this.f80787b, linearSwapContractInfo.getContractShortType());
                f.G(view.getContext(), linearSwapContractInfo);
            } else if (this.f80792b.getItemCurrencyType() == 3 && this.f80792b.getOptionCurrencyInfo() != null) {
                f.H(view.getContext(), this.f80792b.getOptionCurrencyInfo());
            } else if (this.f80792b.getItemCurrencyType() == 0) {
                SymbolBean J = a1.v().J(this.f80792b.getSymbol(), tradeType);
                if (J == null || !SymbolBean.PRE_ONLINE.equals(J.getState())) {
                    f.C(view.getContext(), I, false, tradeType);
                } else {
                    view.getContext().startActivity(k0.s(view.getContext(), this.f80792b.getSymbol(), true));
                }
                br.c.g(j.c()).m(SearchHistoryViewHandler.this.f80787b, this.f80792b.getSearchKeyWord());
                fr.a.d(a1.v().n(I));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, SearchHistoryItem searchHistoryItem, ViewGroup viewGroup) {
        String str;
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        RelativeLayout relativeLayout = (RelativeLayout) e11.b(R.id.item_search_symbol_layout);
        RelativeLayout relativeLayout2 = (RelativeLayout) e11.b(R.id.rl_search_result_title_area);
        if (resources.getString(R.string.search_symbol_lastest_search).equals(searchHistoryItem.getSearchKeyWord())) {
            relativeLayout2.setVisibility(0);
            relativeLayout.setVisibility(8);
            TextView e12 = e11.e(R.id.tv_search_clear);
            e12.setClickable(true);
            e12.setOnClickListener(new a(cVar));
            return;
        }
        relativeLayout2.setVisibility(8);
        relativeLayout.setVisibility(0);
        TextView e13 = e11.e(R.id.item_search_symbol_result);
        ImageView c11 = e11.c(R.id.item_search_symbol_collect);
        if (searchHistoryItem.getItemCurrencyType() == 1 && searchHistoryItem.getContractCurrencyInfo() != null) {
            e13.setText(g.d(searchHistoryItem.getContractCurrencyInfo().getContractShortType(), searchHistoryItem.getContractCurrencyInfo().getContractCode(), 1));
            str = "CONTRACT";
        } else if (searchHistoryItem.getItemCurrencyType() == 2 && searchHistoryItem.getSwapCurrencyInfo() != null) {
            e13.setText(us.j.f(searchHistoryItem.getSwapCurrencyInfo().getSymbol(), e13.getContext()));
            str = "CONTRACT_SWAP";
        } else if (searchHistoryItem.getItemCurrencyType() != 4 || searchHistoryItem.getLinearSwapContractInfo() == null) {
            if (searchHistoryItem.getItemCurrencyType() == 3 && searchHistoryItem.getOptionCurrencyInfo() != null) {
                e13.setText(e.z(searchHistoryItem.getOptionCurrencyInfo().getSymbol(), searchHistoryItem.getOptionCurrencyInfo().getOptionCode(), cVar.itemView.getContext(), cVar.itemView.getContext().getResources().getColor(R.color.global_main_text_color)));
            } else if (searchHistoryItem.getItemCurrencyType() == 0) {
                e13.setText(a1.v().W(searchHistoryItem.getSymbol()));
            }
            str = "PRO";
        } else {
            e13.setText(e.l(e13.getContext(), searchHistoryItem.getLinearSwapContractInfo().getSymbol(), searchHistoryItem.getLinearSwapContractInfo().getQuoteCurrency()));
            str = "LINEAR_SWAP";
        }
        if (searchHistoryItem.getItemCurrencyType() == 3) {
            c11.setVisibility(8);
        } else {
            c11.setVisibility(0);
            if (searchHistoryItem.isCollected()) {
                c11.setImageResource(R.drawable.star_common_light2);
            } else {
                c11.setImageResource(R.drawable.star_common2);
            }
        }
        c11.setClickable(true);
        c11.setTag(R.id.item_data, searchHistoryItem);
        c11.setOnClickListener(new b(str));
        relativeLayout.setClickable(true);
        relativeLayout.setTag(R.id.item_data, searchHistoryItem);
        relativeLayout.setOnClickListener(new c(searchHistoryItem));
    }

    public final void e(View view) {
        ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.3f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.3f, 1.0f})}).setDuration(300).start();
    }

    public int getResId() {
        if (tg.r.x().F0()) {
            this.f80787b = tg.r.x().J();
            return R.layout.item_search_symbol_history;
        }
        this.f80787b = "local_uid";
        return R.layout.item_search_symbol_history;
    }
}
