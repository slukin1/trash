package com.hbg.module.market.widget.presenter;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.widget.bean.MarketWidgetInfo;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.event.MarketSettingEvent;
import d7.a1;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import kf.c;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rl.b;
import u6.g;

public class MarketWidgetSettingPresenter extends ActivityPresenter<d> {

    /* renamed from: a  reason: collision with root package name */
    public jf.b f26720a;

    /* renamed from: b  reason: collision with root package name */
    public rl.c f26721b;

    /* renamed from: c  reason: collision with root package name */
    public List<s9.a> f26722c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public MarketWidgetSymbolItem.a f26723d = new kf.c((g) getUI(), new a());

    /* renamed from: e  reason: collision with root package name */
    public b.a f26724e = new b();

    public class a implements c.C0254c {
        public a() {
        }

        public void J0() {
            ((d) MarketWidgetSettingPresenter.this.getUI()).cb();
        }

        public void a(MarketWidgetSymbolItem marketWidgetSymbolItem) {
            ((d) MarketWidgetSettingPresenter.this.getUI()).Mc(marketWidgetSymbolItem);
        }
    }

    public class b implements b.a {
        public b() {
        }

        public void a(int i11) {
        }

        public boolean onMove(int i11, int i12) {
            return ((d) MarketWidgetSettingPresenter.this.getUI()).i7(i11, i12);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26727a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26727a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26727a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26727a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f26727a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.CONTRACT_INDEX     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f26727a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP_INDEX     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f26727a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.market.widget.presenter.MarketWidgetSettingPresenter.c.<clinit>():void");
        }
    }

    public interface d extends g {
        void G(List<s9.a> list);

        void Mc(MarketWidgetSymbolItem marketWidgetSymbolItem);

        void a5(s9.a aVar);

        void cb();

        void h0(boolean z11);

        boolean i7(int i11, int i12);

        void xe(rl.c cVar);
    }

    public void Q() {
        MarketWidgetSymbolItem.a aVar = this.f26723d;
        if (aVar != null && aVar.f()) {
            this.f26723d.c();
        }
    }

    public final MarketWidgetSymbolItem R(MarketWidgetInfo marketWidgetInfo) {
        MarketWidgetSymbolItem marketWidgetSymbolItem;
        if (marketWidgetInfo == null) {
            return null;
        }
        String symbol = marketWidgetInfo.getSymbol();
        switch (c.f26727a[marketWidgetInfo.getTradeType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                marketWidgetSymbolItem = new MarketWidgetSymbolItem();
                break;
            default:
                marketWidgetSymbolItem = null;
                break;
        }
        if (marketWidgetSymbolItem == null) {
            return null;
        }
        marketWidgetSymbolItem.setTradeType(marketWidgetInfo.getTradeType());
        marketWidgetSymbolItem.setSymbol(symbol);
        marketWidgetSymbolItem.setMarketWidgetInfo(marketWidgetInfo);
        marketWidgetSymbolItem.setCallback(this.f26723d);
        marketWidgetSymbolItem.setItemTouchHelp(this.f26721b);
        return marketWidgetSymbolItem;
    }

    public void S() {
        this.f26722c.clear();
        U(hf.b.p());
    }

    public void T(List<s9.a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (s9.a next : list) {
                if (next instanceof MarketWidgetSymbolItem) {
                    MarketWidgetSymbolItem marketWidgetSymbolItem = (MarketWidgetSymbolItem) next;
                    arrayList.add(new MarketWidgetInfo(marketWidgetSymbolItem.getSymbol(), marketWidgetSymbolItem.getTradeType().toString()));
                }
            }
        }
        hf.b.C(arrayList);
    }

    public final void U(List<MarketWidgetInfo> list) {
        MarketWidgetSymbolItem R;
        if (list != null && !list.isEmpty()) {
            for (MarketWidgetInfo next : list) {
                if (!(next == null || TextUtils.isEmpty(next.getSymbol()) || (R = R(next)) == null)) {
                    R.setMarketWidgetInfo(next);
                    this.f26722c.add(R);
                }
            }
        }
        X();
    }

    /* renamed from: V */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        this.f26720a = MarketModuleConfig.b();
        W();
        rl.c cVar = new rl.c(this.f26724e);
        this.f26721b = cVar;
        cVar.C(true);
        ((d) getUI()).xe(this.f26721b);
        EventBus.d().p(this);
    }

    public final void W() {
        jf.b bVar = this.f26720a;
        if (bVar != null) {
            bVar.d();
            this.f26720a.i();
            this.f26720a.b(a1.v().H(TradeType.PRO));
        }
    }

    public final void X() {
        ((d) getUI()).G(this.f26722c);
        ((d) getUI()).h0(this.f26722c.isEmpty());
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onEvent(MarketSettingEvent marketSettingEvent) {
        if (marketSettingEvent != null && marketSettingEvent.d()) {
            hf.b.z(marketSettingEvent.a(), marketSettingEvent.b());
            for (s9.a next : this.f26722c) {
                if (next instanceof MarketWidgetSymbolItem) {
                    MarketWidgetSymbolItem marketWidgetSymbolItem = (MarketWidgetSymbolItem) next;
                    if (!TextUtils.isEmpty(marketSettingEvent.a()) && marketSettingEvent.a().equals(marketWidgetSymbolItem.getSymbol())) {
                        this.f26722c.remove(next);
                        ((d) getUI()).a5(next);
                        X();
                    }
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        S();
    }
}
