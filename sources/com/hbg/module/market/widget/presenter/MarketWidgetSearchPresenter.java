package com.hbg.module.market.widget.presenter;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$string;
import com.hbg.module.market.widget.bean.MarketHotSearchArea;
import com.hbg.module.market.widget.bean.MarketSearchInputItem;
import com.hbg.module.market.widget.bean.MarketSearchResultHeaderItem;
import com.hbg.module.market.widget.bean.MarketSearchResultItem;
import com.hbg.module.market.widget.bean.MarketWidgetInfo;
import com.hbg.module.market.widget.event.MarketSearchSymbolEvent;
import com.hbg.module.market.widget.event.MarketSettingEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import u6.g;

public class MarketWidgetSearchPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public List<s9.a> f26712a;

    /* renamed from: b  reason: collision with root package name */
    public String f26713b;

    /* renamed from: c  reason: collision with root package name */
    public jf.b f26714c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, MarketWidgetInfo> f26715d = new LinkedHashMap();

    /* renamed from: e  reason: collision with root package name */
    public MarketSearchInputItem.a f26716e = new a();

    public class a implements MarketSearchInputItem.a {

        /* renamed from: a  reason: collision with root package name */
        public View f26717a;

        /* renamed from: b  reason: collision with root package name */
        public EditText f26718b;

        public a() {
        }

        public void a(Editable editable) {
            ((b) MarketWidgetSearchPresenter.this.getUI()).yd(editable);
        }

        public void b(View view, EditText editText) {
            this.f26717a = view;
            this.f26718b = editText;
        }

        public void c(boolean z11) {
            EditText editText = this.f26718b;
            if (editText != null) {
                editText.setText("");
                if (z11) {
                    this.f26718b.requestFocus();
                }
            }
        }

        public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
            if (this.f26718b != null) {
                return ((b) MarketWidgetSearchPresenter.this.getUI()).Y3(this.f26718b, textView, i11, keyEvent);
            }
            return false;
        }
    }

    public interface b extends g {
        boolean Y3(EditText editText, TextView textView, int i11, KeyEvent keyEvent);

        void h0(boolean z11);

        void hb(String str);

        void oa(MarketSearchResultItem marketSearchResultItem, ImageView imageView);

        void x6(List<s9.a> list);

        void yd(Editable editable);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(List list) {
        if (list == null || list.isEmpty()) {
            ((b) getUI()).x6(this.f26712a);
            return;
        }
        ((b) getUI()).h0(false);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            MarketSearchResultItem c11 = this.f26714c.c(getActivity(), str);
            if (c11 != null) {
                c11.setSelected(W(str));
                arrayList.add(c11);
            }
        }
        if (!arrayList.isEmpty()) {
            MarketSearchResultHeaderItem marketSearchResultHeaderItem = new MarketSearchResultHeaderItem();
            marketSearchResultHeaderItem.setTitle(getResources().getString(R$string.n_widget_market_optional));
            this.f26712a.add(marketSearchResultHeaderItem);
            this.f26712a.addAll(arrayList);
        }
        ((b) getUI()).x6(this.f26712a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(List list) {
        S(getActivity());
    }

    public void S(Context context) {
        jf.b bVar = this.f26714c;
        if (bVar != null) {
            if (bVar.a()) {
                this.f26713b = this.f26714c.getUid();
            }
            if (TextUtils.isEmpty(this.f26713b)) {
                this.f26713b = "market_widget_local_uid";
            }
            this.f26712a.clear();
            if (!CollectionsUtils.b(this.f26714c.f())) {
                ((b) getUI()).h0(false);
                this.f26712a.add(new MarketHotSearchArea());
            }
            this.f26714c.g(context, new lf.b(this));
        }
    }

    public final void T() {
        jf.b bVar = this.f26714c;
        if (bVar != null) {
            bVar.g(getActivity(), new lf.a(this));
        }
    }

    public final TradeType U(int i11) {
        if (i11 == 1) {
            return TradeType.CONTRACT;
        }
        if (i11 == 2) {
            return TradeType.SWAP;
        }
        if (i11 == 4) {
            return TradeType.LINEAR_SWAP;
        }
        if (i11 == 5) {
            return TradeType.CONTRACT_INDEX;
        }
        if (i11 != 6) {
            return TradeType.PRO;
        }
        return TradeType.LINEAR_SWAP_INDEX;
    }

    public final void V() {
        List<MarketWidgetInfo> p11 = hf.b.p();
        if (p11 != null && !p11.isEmpty()) {
            for (MarketWidgetInfo next : p11) {
                if (next != null) {
                    this.f26715d.put(next.getSymbol(), next);
                }
            }
        }
    }

    public final boolean W(String str) {
        Map<String, MarketWidgetInfo> map = this.f26715d;
        return map != null && !map.isEmpty() && this.f26715d.containsKey(str);
    }

    public void Z(boolean z11) {
        MarketSearchInputItem.a aVar = this.f26716e;
        if (aVar != null) {
            aVar.c(z11);
        }
    }

    /* renamed from: a0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        this.f26714c = MarketModuleConfig.b();
        this.f26712a = new ArrayList();
        EventBus.d().p(this);
        V();
    }

    public boolean b0(Context context, String str) {
        jf.b bVar = this.f26714c;
        boolean z11 = false;
        if (bVar == null) {
            return false;
        }
        List<Pair<String, Object>> e11 = bVar.e(context, str, true);
        this.f26712a.clear();
        if (!this.f26714c.a()) {
            loop2:
            while (true) {
                MarketSearchResultItem marketSearchResultItem = null;
                for (Pair next : e11) {
                    String str2 = (String) next.first;
                    Object obj = next.second;
                    if (obj == null) {
                        marketSearchResultItem = new MarketSearchResultItem();
                        marketSearchResultItem.setItemCurrencyType(0);
                        continue;
                    } else if (obj instanceof ContractCurrencyInfo) {
                        marketSearchResultItem = new MarketSearchResultItem();
                        marketSearchResultItem.setItemCurrencyType(1);
                        marketSearchResultItem.setContractCurrencyInfo((ContractCurrencyInfo) next.second);
                        continue;
                    } else if (obj instanceof SwapCurrencyInfo) {
                        marketSearchResultItem = new MarketSearchResultItem();
                        marketSearchResultItem.setItemCurrencyType(2);
                        marketSearchResultItem.setSwapCurrencyInfo((SwapCurrencyInfo) next.second);
                        continue;
                    } else if (obj instanceof IndexCurrencyInfo) {
                        if (!str2.endsWith("-Index")) {
                            str2 = str2 + "-Index";
                        }
                        marketSearchResultItem = new MarketSearchResultItem();
                        IndexCurrencyInfo indexCurrencyInfo = (IndexCurrencyInfo) next.second;
                        if ("usdt".equalsIgnoreCase(indexCurrencyInfo.getQuoteCurrency())) {
                            marketSearchResultItem.setItemCurrencyType(6);
                        } else {
                            marketSearchResultItem.setItemCurrencyType(5);
                        }
                        marketSearchResultItem.setIndexCurrencyInfo(indexCurrencyInfo);
                        continue;
                    } else if ((obj instanceof FutureContractInfo) && FutureTypeUtil.a(((FutureContractInfo) obj).getContractCode(), ((FutureContractInfo) next.second).getContractShortType(), ((FutureContractInfo) next.second).getOptionCode()) == TradeType.LINEAR_SWAP) {
                        marketSearchResultItem = new MarketSearchResultItem();
                        marketSearchResultItem.setItemCurrencyType(4);
                        marketSearchResultItem.setLinearSwapContractInfo((FutureContractInfo) next.second);
                        continue;
                    }
                    if (marketSearchResultItem != null) {
                        marketSearchResultItem.setSelected(W(str2));
                        marketSearchResultItem.setSymbol((String) next.first);
                        this.f26712a.add(marketSearchResultItem);
                    }
                }
                break loop2;
            }
        } else {
            loop0:
            while (true) {
                MarketSearchResultItem marketSearchResultItem2 = null;
                for (Pair next2 : e11) {
                    String str3 = (String) next2.first;
                    Object obj2 = next2.second;
                    if (obj2 == null) {
                        marketSearchResultItem2 = new MarketSearchResultItem();
                        marketSearchResultItem2.setItemCurrencyType(0);
                        continue;
                    } else if (obj2 instanceof ContractCurrencyInfo) {
                        marketSearchResultItem2 = new MarketSearchResultItem();
                        marketSearchResultItem2.setItemCurrencyType(1);
                        marketSearchResultItem2.setContractCurrencyInfo((ContractCurrencyInfo) next2.second);
                        continue;
                    } else if (obj2 instanceof SwapCurrencyInfo) {
                        marketSearchResultItem2 = new MarketSearchResultItem();
                        marketSearchResultItem2.setItemCurrencyType(2);
                        marketSearchResultItem2.setSwapCurrencyInfo((SwapCurrencyInfo) next2.second);
                        continue;
                    } else if (obj2 instanceof IndexCurrencyInfo) {
                        if (!str3.endsWith("-Index")) {
                            str3 = str3 + "-Index";
                        }
                        marketSearchResultItem2 = new MarketSearchResultItem();
                        IndexCurrencyInfo indexCurrencyInfo2 = (IndexCurrencyInfo) next2.second;
                        if ("usdt".equalsIgnoreCase(indexCurrencyInfo2.getQuoteCurrency())) {
                            marketSearchResultItem2.setItemCurrencyType(6);
                        } else {
                            marketSearchResultItem2.setItemCurrencyType(5);
                        }
                        marketSearchResultItem2.setIndexCurrencyInfo(indexCurrencyInfo2);
                        continue;
                    } else if ((obj2 instanceof FutureContractInfo) && FutureTypeUtil.a(((FutureContractInfo) obj2).getContractCode(), ((FutureContractInfo) next2.second).getContractShortType(), ((FutureContractInfo) next2.second).getOptionCode()) == TradeType.LINEAR_SWAP) {
                        marketSearchResultItem2 = new MarketSearchResultItem();
                        marketSearchResultItem2.setItemCurrencyType(4);
                        marketSearchResultItem2.setLinearSwapContractInfo((FutureContractInfo) next2.second);
                        continue;
                    }
                    if (marketSearchResultItem2 != null) {
                        marketSearchResultItem2.setSelected(W(str3));
                        marketSearchResultItem2.setSymbol((String) next2.first);
                        this.f26712a.add(marketSearchResultItem2);
                    }
                }
                break loop0;
            }
        }
        if (!this.f26712a.isEmpty()) {
            ((b) getUI()).h0(false);
            z11 = true;
        } else {
            ((b) getUI()).h0(true);
        }
        ((b) getUI()).x6(this.f26712a);
        return z11;
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(p000if.a aVar) {
        if (aVar != null) {
            ((b) getUI()).oa(aVar.b(), aVar.a());
            MarketSearchResultItem b11 = aVar.b();
            if (b11 != null) {
                String symbol = b11.getSymbol();
                int itemCurrencyType = b11.getItemCurrencyType();
                if ((itemCurrencyType == 5 || itemCurrencyType == 6) && !symbol.endsWith("-Index")) {
                    symbol = symbol + "-Index";
                }
                this.f26715d.remove(symbol);
                if (b11.isSelected()) {
                    this.f26715d.put(symbol, new MarketWidgetInfo(symbol, U(b11.getItemCurrencyType()).toString()));
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        T();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(MarketSettingEvent marketSettingEvent) {
        if (marketSettingEvent != null && marketSettingEvent.c() && this.f26715d != null) {
            hf.b.C(new ArrayList(this.f26715d.values()));
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(MarketSearchSymbolEvent marketSearchSymbolEvent) {
        if (marketSearchSymbolEvent.b()) {
            S(getActivity());
        } else if (!marketSearchSymbolEvent.d() && marketSearchSymbolEvent.c()) {
            ((b) getUI()).hb(marketSearchSymbolEvent.a());
            b0(getActivity(), marketSearchSymbolEvent.a());
        }
    }
}
