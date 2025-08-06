package com.huobi.tradingbot.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import au.s;
import au.t;
import au.u;
import au.v;
import au.w;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.UtilCollections;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.grid.bean.GridSupportedSymbol;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.input.ClearEditText;
import com.huobi.otc.dialog.BaseFullBottomSheetFragment;
import com.huobi.trade.bean.TradingBotSelectMarketInfo;
import com.huobi.tradingbot.widget.TradingBotIndexView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import i6.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import u6.g;

public class SelectMarketDialogFragment extends BaseFullBottomSheetFragment implements TradingBotSelectMarketInfo.a, TradingBotIndexView.a {

    /* renamed from: b  reason: collision with root package name */
    public LoadingLayout f83601b;

    /* renamed from: c  reason: collision with root package name */
    public View f83602c;

    /* renamed from: d  reason: collision with root package name */
    public View f83603d;

    /* renamed from: e  reason: collision with root package name */
    public String f83604e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f83605f;

    /* renamed from: g  reason: collision with root package name */
    public ClearEditText f83606g;

    /* renamed from: h  reason: collision with root package name */
    public EasyRecyclerView<TradingBotSelectMarketInfo> f83607h;

    /* renamed from: i  reason: collision with root package name */
    public EasyRecyclerView<TradingBotSelectMarketInfo> f83608i;

    /* renamed from: j  reason: collision with root package name */
    public TradingBotIndexView f83609j;

    /* renamed from: k  reason: collision with root package name */
    public bu.b f83610k;

    /* renamed from: l  reason: collision with root package name */
    public int f83611l = -1;

    /* renamed from: m  reason: collision with root package name */
    public List<TradingBotSelectMarketInfo> f83612m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    public e f83613n;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            i6.d.d("onScrolled findFirstVisibleItemPosition:" + findFirstVisibleItemPosition + " findFirstCompletelyVisibleItemPosition:" + linearLayoutManager.findFirstCompletelyVisibleItemPosition());
            if (findFirstVisibleItemPosition > 0 && SelectMarketDialogFragment.this.f83611l != findFirstVisibleItemPosition) {
                int unused = SelectMarketDialogFragment.this.f83611l = findFirstVisibleItemPosition;
                if (UtilCollections.h(SelectMarketDialogFragment.this.f83612m, findFirstVisibleItemPosition)) {
                    SelectMarketDialogFragment.this.f83609j.setHighlight(((TradingBotSelectMarketInfo) SelectMarketDialogFragment.this.f83612m.get(findFirstVisibleItemPosition)).getLetter());
                }
            }
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                SelectMarketDialogFragment.this.f83601b.g();
                SelectMarketDialogFragment.this.f83607h.setVisibility(0);
                SelectMarketDialogFragment.this.f83609j.setVisibility(0);
                SelectMarketDialogFragment.this.f83608i.setVisibility(8);
                return;
            }
            SelectMarketDialogFragment.this.Fh(editable.toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class c extends EasySubscriber<GridSupportedSymbol> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(GridSupportedSymbol gridSupportedSymbol) {
            if (SelectMarketDialogFragment.this.isAdded() && gridSupportedSymbol != null && gridSupportedSymbol.getSymbols() != null) {
                ArrayList arrayList = new ArrayList();
                int i11 = 1000;
                Iterator<String> it2 = gridSupportedSymbol.getSymbols().iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    TradingBotSelectMarketInfo tradingBotSelectMarketInfo = new TradingBotSelectMarketInfo();
                    tradingBotSelectMarketInfo.setTradingBotSelectMarketInfo(false, next.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0], next.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""), String.valueOf(next.charAt(0)).toUpperCase(Locale.ROOT), TextUtils.equals(SelectMarketDialogFragment.this.f83604e, next), SelectMarketDialogFragment.this).setSymbol(next).setCallBackStr(a7.e.n(SelectMarketDialogFragment.this.getContext(), next.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""))).setIsContract(SelectMarketDialogFragment.this.f83605f).setWeight(i11);
                    arrayList.add(tradingBotSelectMarketInfo);
                    i11--;
                }
                SelectMarketDialogFragment.this.setData(arrayList);
            }
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            SelectMarketDialogFragment.this.f83601b.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SelectMarketDialogFragment.this.f83601b.k();
        }
    }

    public class d extends EasySubscriber<List<SymbolBean>> {
        public d() {
        }

        public void onError2(Throwable th2) {
            SelectMarketDialogFragment.this.f83601b.k();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            SelectMarketDialogFragment.this.f83601b.k();
        }

        public void onNext(List<SymbolBean> list) {
            super.onNext(list);
            if (SelectMarketDialogFragment.this.isAdded()) {
                SelectMarketDialogFragment.this.Lh(false);
            }
        }
    }

    public interface e {
        void a(TradingBotSelectMarketInfo tradingBotSelectMarketInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(View view, boolean z11) {
        this.f83603d.setSelected(z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih() {
        EasyRecyclerView<TradingBotSelectMarketInfo> easyRecyclerView = this.f83607h;
        if (easyRecyclerView != null) {
            easyRecyclerView.scrollToPosition(0);
        }
    }

    public static /* synthetic */ int Jh(TradingBotSelectMarketInfo tradingBotSelectMarketInfo, TradingBotSelectMarketInfo tradingBotSelectMarketInfo2) {
        if (tradingBotSelectMarketInfo == null || tradingBotSelectMarketInfo2 == null) {
            return 0;
        }
        int compareTo = tradingBotSelectMarketInfo.getLetter().compareTo(tradingBotSelectMarketInfo2.getLetter());
        return compareTo == 0 ? tradingBotSelectMarketInfo2.getWeight() - tradingBotSelectMarketInfo.getWeight() : compareTo;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (this.f83605f) {
            Kh();
        } else {
            Mh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Eh() {
        this.f83602c.setOnClickListener(new s(this));
        this.f83601b.setOnRetryClickListener(new t(this));
        this.f83606g.setClearEditTextOnFocusChangeListener(new u(this));
        this.f83606g.addTextChangedListener(new b());
        if (this.f83605f) {
            Kh();
        } else {
            Lh(true);
        }
    }

    public final void Fh(String str) {
        ArrayList arrayList = new ArrayList();
        for (TradingBotSelectMarketInfo next : this.f83612m) {
            if (next != null) {
                String displayName = next.getDisplayName();
                if (!TextUtils.isEmpty(displayName) && displayName.toUpperCase().contains(str.toUpperCase())) {
                    arrayList.add(next);
                }
            }
        }
        this.f83607h.setVisibility(8);
        this.f83609j.setVisibility(8);
        if (!arrayList.isEmpty()) {
            this.f83601b.g();
            this.f83608i.setVisibility(0);
            this.f83608i.setData(arrayList);
            return;
        }
        this.f83601b.i();
    }

    public final void Gh(List<TradingBotSelectMarketInfo> list) {
        this.f83612m.clear();
        this.f83612m.addAll(list);
        TradingBotSelectMarketInfo tradingBotSelectMarketInfo = new TradingBotSelectMarketInfo();
        tradingBotSelectMarketInfo.setTradingBotSelectMarketInfo(true, "", getString(R.string.n_trade_bot_market_all), "", TextUtils.isEmpty(this.f83604e), this);
        this.f83612m.add(0, tradingBotSelectMarketInfo);
    }

    public void J3(boolean z11, String str, float f11) {
        for (int i11 = 0; i11 < this.f83612m.size(); i11++) {
            if (TextUtils.equals(this.f83612m.get(i11).getLetter(), str)) {
                this.f83607h.scrollToPosition(i11);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f83607h.getLayoutManager();
                if (linearLayoutManager != null) {
                    linearLayoutManager.scrollToPositionWithOffset(i11, 0);
                    return;
                }
                return;
            }
        }
    }

    public void Kh() {
        this.f83601b.p();
        v7.b.a().requestContractGridSymbols().b().compose(RxJavaHelper.t((g) null)).subscribe(new c());
    }

    public void Lh(boolean z11) {
        List<SymbolBean> Z = a1.v().Z(TradeType.PRO);
        if (!UtilCollections.f(Z)) {
            ArrayList arrayList = new ArrayList();
            for (SymbolBean next : Z) {
                if (!next.hasTag(SymbolBean.GRID_DISABLED) && SymbolBean.ONLINE.equals(next.getState())) {
                    TradingBotSelectMarketInfo tradingBotSelectMarketInfo = new TradingBotSelectMarketInfo();
                    tradingBotSelectMarketInfo.setTradingBotSelectMarketInfo(false, next.getBaseCurrency(), next.getSymbolName(), String.valueOf(next.getBaseCurrency().charAt(0)).toUpperCase(Locale.ROOT), TextUtils.equals(this.f83604e, next.getSymbol()), this).setSymbol(next.getSymbol()).setWeight(next.getWeight());
                    arrayList.add(tradingBotSelectMarketInfo);
                }
            }
            setData(arrayList);
        } else if (z11) {
            Mh();
        } else {
            this.f83601b.i();
        }
    }

    public void Mh() {
        this.f83601b.p();
        a1.v().z0(true).compose(RxJavaHelper.t((g) null)).subscribe(new d());
    }

    public void Nh(e eVar) {
        this.f83613n = eVar;
    }

    public void Oh(boolean z11) {
        this.f83605f = z11;
    }

    public void Ph(String str) {
        this.f83604e = str;
    }

    public final void Qh(List<TradingBotSelectMarketInfo> list) {
        Collections.sort(list, w.f12233b);
    }

    public void Zf(TradingBotSelectMarketInfo tradingBotSelectMarketInfo) {
        if (tradingBotSelectMarketInfo != null) {
            dismiss();
            e eVar = this.f83613n;
            if (eVar != null) {
                eVar.a(tradingBotSelectMarketInfo);
            }
        }
    }

    public int getPeekHeight() {
        return PixelUtils.f() - PixelUtils.a(50.0f);
    }

    public final void initView(View view) {
        this.f83601b = (LoadingLayout) view.findViewById(R.id.id_loading_layout);
        this.f83603d = view.findViewById(R.id.et_container);
        this.f83602c = view.findViewById(R.id.iv_close);
        this.f83606g = (ClearEditText) view.findViewById(R.id.search_currency_input);
        this.f83607h = (EasyRecyclerView) view.findViewById(R.id.id_symbol_rv);
        this.f83608i = (EasyRecyclerView) view.findViewById(R.id.id_search_result_rv);
        TradingBotIndexView tradingBotIndexView = (TradingBotIndexView) view.findViewById(R.id.id_select_index_view);
        this.f83609j = tradingBotIndexView;
        tradingBotIndexView.setOnTouchLetterChangeListenner(this);
        bu.b bVar = new bu.b(getContext(), 1);
        this.f83610k = bVar;
        this.f83607h.addItemDecoration(bVar);
        this.f83607h.addOnScrollListener(new a());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tradingbot_select_market, viewGroup, false);
        initView(inflate);
        Eh();
        return inflate;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f83612m.clear();
    }

    public void setData(List<TradingBotSelectMarketInfo> list) {
        if (CollectionsUtils.b(list)) {
            this.f83601b.i();
            this.f83610k.b((List<TradingBotSelectMarketInfo>) null);
            this.f83606g.setEnabled(false);
            return;
        }
        this.f83606g.setEnabled(true);
        Qh(list);
        Gh(list);
        this.f83610k.b(this.f83612m);
        this.f83607h.setData(this.f83612m);
        this.f83601b.g();
        i.b().g(new v(this), 30);
    }
}
