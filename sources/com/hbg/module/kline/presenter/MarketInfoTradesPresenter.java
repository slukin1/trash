package com.hbg.module.kline.presenter;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import ce.k;
import ce.l;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.listener.MarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.listener.RequestMarketTradeDetailListener;
import com.hbg.lib.network.pro.socket.response.MarketInfoTradesTick;
import com.hbg.lib.network.pro.socket.response.RequestMarketTradeDetailResponse;
import com.hbg.lib.network.pro.socket.response.TradeDetailResponse;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.bean.MarketInfoTradesItem;
import com.xiaomi.mipush.sdk.Constants;
import d7.a1;
import g9.a;
import i6.i;
import i6.m;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u6.f;

public class MarketInfoTradesPresenter extends BaseFragmentPresenter<c> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f23691c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public u9.a<MarketInfoTradesItem> f23692d;

    /* renamed from: e  reason: collision with root package name */
    public List<MarketInfoTradesItem> f23693e = Collections.synchronizedList(new ArrayList());

    /* renamed from: f  reason: collision with root package name */
    public List<MarketInfoTradesItem> f23694f = Collections.synchronizedList(new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    public String f23695g;

    /* renamed from: h  reason: collision with root package name */
    public TradeType f23696h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23697i;

    /* renamed from: j  reason: collision with root package name */
    public ContractCurrencyInfo f23698j;

    /* renamed from: k  reason: collision with root package name */
    public SwapCurrencyInfo f23699k;

    /* renamed from: l  reason: collision with root package name */
    public FutureContractInfo f23700l;

    /* renamed from: m  reason: collision with root package name */
    public final a.d f23701m = new k(this);

    /* renamed from: n  reason: collision with root package name */
    public final MarketTradeDetailListener f23702n = new a();

    /* renamed from: o  reason: collision with root package name */
    public final RequestMarketTradeDetailListener f23703o = new b();

    public class a extends MarketTradeDetailListener {
        public a() {
        }

        /* renamed from: j */
        public void f(TradeDetailResponse tradeDetailResponse) {
        }

        /* renamed from: k */
        public TradeDetailResponse g(TradeDetailResponse tradeDetailResponse) {
            synchronized (MarketInfoTradesPresenter.this.f23691c) {
                MarketInfoTradesPresenter.this.C0(tradeDetailResponse);
            }
            return (TradeDetailResponse) super.g(tradeDetailResponse);
        }
    }

    public class b extends RequestMarketTradeDetailListener {
        public b() {
        }

        /* renamed from: j */
        public void f(RequestMarketTradeDetailResponse requestMarketTradeDetailResponse) {
            if (requestMarketTradeDetailResponse.isSuccess() && MarketInfoTradesPresenter.this.f23695g.equals(requestMarketTradeDetailResponse.getSymbol())) {
                List list = (List) requestMarketTradeDetailResponse.getData();
                if (list == null || list.size() == 0) {
                    MarketInfoTradesPresenter.this.l0(true);
                    return;
                }
                ((c) MarketInfoTradesPresenter.this.getUI()).f6().g();
                MarketInfoTradesPresenter.this.r0(list);
                MarketInfoTradesPresenter.this.E0();
                MarketInfoTradesPresenter.this.D0(true);
            }
        }
    }

    public interface c extends f {
        void Ue(String str);

        void b6(u9.a<MarketInfoTradesItem> aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ int w0(MarketInfoTradesItem marketInfoTradesItem, MarketInfoTradesItem marketInfoTradesItem2) {
        if (!TradeType.isOption(this.f23696h) && !TradeType.isSwap(this.f23696h) && !TradeType.isLinearSwap(this.f23696h) && !TradeType.isContract(this.f23696h)) {
            return Long.compare(marketInfoTradesItem2.getTradeDetailInfo().getTradeId(), marketInfoTradesItem.getTradeDetailInfo().getTradeId());
        }
        int compare = Long.compare(marketInfoTradesItem2.getTradeDetailInfo().getTs(), marketInfoTradesItem.getTradeDetailInfo().getTs());
        if (compare != 0) {
            return compare;
        }
        return marketInfoTradesItem2.getTradeDetailInfo().getId().compareTo(marketInfoTradesItem.getTradeDetailInfo().getId());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0() {
        D0(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0() {
        synchronized (this.f23691c) {
            E0();
            ((c) getUI()).f6().g();
        }
    }

    /* renamed from: A0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("market_trade_type");
            if (TextUtils.isEmpty(stringExtra)) {
                this.f23696h = TradeType.PRO;
            } else {
                this.f23696h = TradeType.valueOf(stringExtra);
            }
            if (TradeType.isContract(this.f23696h)) {
                this.f23698j = (ContractCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isSwap(this.f23696h)) {
                this.f23699k = (SwapCurrencyInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isOption(this.f23696h)) {
                this.f23700l = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            } else if (TradeType.isLinearSwap(this.f23696h)) {
                this.f23700l = (FutureContractInfo) intent.getSerializableExtra("contract_currency_info");
            }
            this.f23695g = intent.getStringExtra("symbolId");
            ((c) getUI()).Ue(this.f23695g);
        }
        this.f23692d = new u9.a<>(this.f23693e);
        l0(false);
    }

    public void B0() {
        if (TradeType.isContract(this.f23696h)) {
            q7.a.a().i(this.f23695g, this.f23703o, 20);
        } else if (TradeType.isSwap(this.f23696h)) {
            l9.a.a().i(this.f23695g, this.f23703o, 20);
        } else if (TradeType.isOption(this.f23696h)) {
            p8.a.a().i(this.f23695g, this.f23703o, 20);
        } else if (TradeType.isLinearSwap(this.f23696h)) {
            h8.a.a().i(this.f23695g, this.f23703o, 20);
        } else {
            x8.a.a().i(this.f23695g, this.f23703o, 20);
        }
    }

    public final void C0(TradeDetailResponse tradeDetailResponse) {
        if (tradeDetailResponse.isSuccess() && this.f23695g.equals(tradeDetailResponse.getSymbol())) {
            MarketInfoTradesTick tick = tradeDetailResponse.getTick();
            if (tick.getData() != null) {
                r0(tick.getData());
            }
            i.b().f(new l(this));
        }
    }

    public void D0(boolean z11) {
        if (TradeType.isContract(this.f23696h)) {
            q7.a.a().k(z11, this.f23695g, this.f23702n);
        } else if (TradeType.isSwap(this.f23696h)) {
            l9.a.a().k(z11, this.f23695g, this.f23702n);
        } else if (TradeType.isOption(this.f23696h)) {
            p8.a.a().k(z11, this.f23695g, this.f23702n);
        } else if (TradeType.isLinearSwap(this.f23696h)) {
            h8.a.a().k(z11, this.f23695g, this.f23702n);
        } else {
            x8.a.a().k(z11, this.f23695g, this.f23702n);
        }
    }

    public final void E0() {
        if (getUI() != null) {
            ((c) getUI()).b6(this.f23692d);
        }
    }

    public void Z(boolean z11) {
        super.Z(z11);
        this.f23697i = z11;
        if (z11) {
            z0();
            return;
        }
        if (TradeType.isContract(this.f23696h)) {
            q7.a.a().c(this.f23701m);
        } else if (TradeType.isSwap(this.f23696h)) {
            l9.a.a().c(this.f23701m);
        } else if (TradeType.isOption(this.f23696h)) {
            p8.a.a().c(this.f23701m);
        } else if (TradeType.isLinearSwap(this.f23696h)) {
            h8.a.a().c(this.f23701m);
        } else {
            x8.a.a().c(this.f23701m);
        }
        D0(false);
    }

    public final void l0(boolean z11) {
        SymbolBean J = a1.v().J(this.f23695g, p0());
        if (J != null) {
            String state = J.getState();
            state.hashCode();
            char c11 = 65535;
            switch (state.hashCode()) {
                case -1852006340:
                    if (state.equals(SymbolBean.SUSPEND)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3154785:
                    if (state.equals(SymbolBean.FUSE)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 544136836:
                    if (state.equals(SymbolBean.TRANSFER_BOARD)) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    ImageView imageView = (ImageView) ((c) getUI()).f6().findViewById(R$id.image_view_common_empty_layout);
                    TextView textView = (TextView) ((c) getUI()).f6().findViewById(R$id.text_view_common_empty_layout);
                    if (KLineHelper.f()) {
                        imageView.setImageResource(R$drawable.trade_suspend_light);
                    } else {
                        imageView.setImageResource(R$drawable.trade_suspend_night);
                    }
                    textView.setText(R$string.trade_suspend);
                    ((c) getUI()).f6().i();
                    return;
                case 1:
                    ImageView imageView2 = (ImageView) ((c) getUI()).f6().findViewById(R$id.image_view_common_empty_layout);
                    TextView textView2 = (TextView) ((c) getUI()).f6().findViewById(R$id.text_view_common_empty_layout);
                    if (KLineHelper.f()) {
                        imageView2.setImageResource(R$drawable.trade_fuse_light);
                    } else {
                        imageView2.setImageResource(R$drawable.trade_fuse_night);
                    }
                    textView2.setText(R$string.trade_fuse);
                    ((c) getUI()).f6().i();
                    return;
                case 2:
                    ImageView imageView3 = (ImageView) ((c) getUI()).f6().findViewById(R$id.image_view_common_empty_layout);
                    TextView textView3 = (TextView) ((c) getUI()).f6().findViewById(R$id.text_view_common_empty_layout);
                    if (KLineHelper.f()) {
                        imageView3.setImageResource(R$drawable.trade_transfer_board_light);
                    } else {
                        imageView3.setImageResource(R$drawable.trade_transfer_board_night);
                    }
                    textView3.setText(R$string.trade_transfer_board);
                    ((c) getUI()).f6().i();
                    return;
                default:
                    if (z11) {
                        ImageView imageView4 = (ImageView) ((c) getUI()).f6().findViewById(R$id.image_view_common_empty_layout);
                        TextView textView4 = (TextView) ((c) getUI()).f6().findViewById(R$id.text_view_common_empty_layout);
                        if (KLineHelper.f()) {
                            imageView4.setImageResource(R$drawable.common_empty_icon_light);
                        } else {
                            imageView4.setImageResource(R$drawable.common_empty_icon_night);
                        }
                        textView4.setText(R$string.trade_no_record);
                        ((c) getUI()).f6().i();
                        return;
                    }
                    ((c) getUI()).f6().p();
                    return;
            }
        } else if (z11) {
            ImageView imageView5 = (ImageView) ((c) getUI()).f6().findViewById(R$id.image_view_common_empty_layout);
            TextView textView5 = (TextView) ((c) getUI()).f6().findViewById(R$id.text_view_common_empty_layout);
            if (KLineHelper.f()) {
                imageView5.setImageResource(R$drawable.common_empty_icon_light);
            } else {
                imageView5.setImageResource(R$drawable.common_empty_icon_night);
            }
            textView5.setText(R$string.trade_no_record);
            ((c) getUI()).f6().i();
        } else {
            ((c) getUI()).f6().p();
        }
    }

    public String m0() {
        FutureContractInfo futureContractInfo;
        if (TradeType.isContract(this.f23696h)) {
            ContractCurrencyInfo contractCurrencyInfo = this.f23698j;
            if (contractCurrencyInfo != null) {
                return contractCurrencyInfo.getContractFace();
            }
            return null;
        } else if (TradeType.isSwap(this.f23696h)) {
            SwapCurrencyInfo swapCurrencyInfo = this.f23699k;
            if (swapCurrencyInfo != null) {
                return swapCurrencyInfo.getContractFace();
            }
            return null;
        } else if (TradeType.isOption(this.f23696h)) {
            FutureContractInfo futureContractInfo2 = this.f23700l;
            if (futureContractInfo2 != null) {
                return futureContractInfo2.getContractFace();
            }
            return null;
        } else if (!TradeType.isLinearSwap(this.f23696h) || (futureContractInfo = this.f23700l) == null) {
            return null;
        } else {
            return futureContractInfo.getContractFace();
        }
    }

    public String n0() {
        int i11;
        if (!TradeType.isLinearSwap(this.f23696h)) {
            return "";
        }
        FutureContractInfo futureContractInfo = this.f23700l;
        if (futureContractInfo != null) {
            return futureContractInfo.getQuoteCurrency();
        }
        if (TextUtils.isEmpty(this.f23695g) || !this.f23695g.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return "";
        }
        String[] split = this.f23695g.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split == null) {
            i11 = 0;
        } else {
            i11 = split.length;
        }
        return i11 >= 2 ? split[1] : "";
    }

    public TradeType p0() {
        return this.f23696h;
    }

    public final String q0(int i11, String str, String str2, String str3) {
        if (new BigDecimal(str).compareTo(BigDecimal.ZERO) == 0 || m.a(str2).compareTo(BigDecimal.ZERO) == 0) {
            return str;
        }
        return m.m(new BigDecimal(str).multiply(new BigDecimal(str3)).divide(m.a(str2), 32, RoundingMode.DOWN).toString(), i11);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:(3:3|4|(8:7|(2:9|(1:11))(2:12|(2:14|(1:16))(2:17|(1:21)))|22|(2:27|(2:32|(2:37|(1:41))(1:36))(1:31))(1:26)|42|(2:44|59)(1:58)|57|5))|46|47|(1:49)(1:50)|51|52|53) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0196 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r0(java.util.List<com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo> r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f23691c
            monitor-enter(r0)
            if (r10 == 0) goto L_0x0158
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0156 }
        L_0x0009:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x0156 }
            if (r1 == 0) goto L_0x0158
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x0156 }
            com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo r1 = (com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo) r1     // Catch:{ all -> 0x0156 }
            com.hbg.module.kline.bean.MarketInfoTradesItem r2 = new com.hbg.module.kline.bean.MarketInfoTradesItem     // Catch:{ all -> 0x0156 }
            r2.<init>()     // Catch:{ all -> 0x0156 }
            r2.setTradeDetailInfo(r1)     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = r9.f23695g     // Catch:{ all -> 0x0156 }
            r1.setSymbol(r3)     // Catch:{ all -> 0x0156 }
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isContract((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0036
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r3 = r9.f23698j     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0066
            java.lang.String r3 = r3.getContractCode()     // Catch:{ all -> 0x0156 }
            r1.setContractCode(r3)     // Catch:{ all -> 0x0156 }
            goto L_0x0066
        L_0x0036:
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isOption((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x004a
            com.hbg.lib.data.future.bean.FutureContractInfo r3 = r9.f23700l     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0066
            java.lang.String r3 = r3.getOptionCode()     // Catch:{ all -> 0x0156 }
            r1.setOptionCode(r3)     // Catch:{ all -> 0x0156 }
            goto L_0x0066
        L_0x004a:
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isLinearSwap((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0066
            com.hbg.lib.data.future.bean.FutureContractInfo r3 = r9.f23700l     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0066
            java.lang.String r3 = r3.getContractCode()     // Catch:{ all -> 0x0156 }
            r1.setContractCode(r3)     // Catch:{ all -> 0x0156 }
            com.hbg.lib.data.future.bean.FutureContractInfo r3 = r9.f23700l     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = r3.getContractShortType()     // Catch:{ all -> 0x0156 }
            r1.setContractShortType(r3)     // Catch:{ all -> 0x0156 }
        L_0x0066:
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            r2.setTradeType(r3)     // Catch:{ all -> 0x0156 }
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isContract((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x00a2
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.CONTRACT     // Catch:{ all -> 0x0156 }
            boolean r3 = a7.e.E(r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x00a2
            td.i r3 = td.i.a()     // Catch:{ all -> 0x0156 }
            td.h r3 = r3.b()     // Catch:{ all -> 0x0156 }
            com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo r4 = r9.f23698j     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r4.getContractCode()     // Catch:{ all -> 0x0156 }
            int r3 = r3.t(r4)     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r1.getAmount()     // Catch:{ all -> 0x0156 }
            java.lang.String r5 = r1.getPrice()     // Catch:{ all -> 0x0156 }
            java.lang.String r6 = r9.m0()     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = r9.q0(r3, r4, r5, r6)     // Catch:{ all -> 0x0156 }
            r1.setAmount(r3)     // Catch:{ all -> 0x0156 }
            goto L_0x0147
        L_0x00a2:
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isSwap((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x00d8
            com.hbg.lib.data.symbol.TradeType r3 = com.hbg.lib.data.symbol.TradeType.SWAP     // Catch:{ all -> 0x0156 }
            boolean r3 = a7.e.E(r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x00d8
            td.i r3 = td.i.a()     // Catch:{ all -> 0x0156 }
            td.h r3 = r3.b()     // Catch:{ all -> 0x0156 }
            com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo r4 = r9.f23699k     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r4.getSymbol()     // Catch:{ all -> 0x0156 }
            int r3 = r3.m(r4)     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r1.getAmount()     // Catch:{ all -> 0x0156 }
            java.lang.String r5 = r1.getPrice()     // Catch:{ all -> 0x0156 }
            java.lang.String r6 = r9.m0()     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = r9.q0(r3, r4, r5, r6)     // Catch:{ all -> 0x0156 }
            r1.setAmount(r3)     // Catch:{ all -> 0x0156 }
            goto L_0x0147
        L_0x00d8:
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isOption((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x010e
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = a7.e.E(r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x010e
            java.lang.String r3 = r1.getContractCode()     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = ""
            java.lang.String r5 = r1.getOptionCode()     // Catch:{ all -> 0x0156 }
            int r3 = com.hbg.lib.data.future.util.FuturePrecisionUtil.s(r3, r4, r5)     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r1.getAmount()     // Catch:{ all -> 0x0156 }
            java.lang.String r5 = ""
            java.lang.String r6 = r9.m0()     // Catch:{ all -> 0x0156 }
            com.hbg.lib.data.symbol.TradeType r7 = r9.f23696h     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = com.hbg.lib.data.future.util.FutureUnitUtil.a(r4, r5, r6, r7)     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = i6.m.m(r4, r3)     // Catch:{ all -> 0x0156 }
            r1.setAmount(r3)     // Catch:{ all -> 0x0156 }
            goto L_0x0147
        L_0x010e:
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = com.hbg.lib.data.symbol.TradeType.isLinearSwap((com.hbg.lib.data.symbol.TradeType) r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0147
            com.hbg.lib.data.symbol.TradeType r3 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r3 = a7.e.F(r3)     // Catch:{ all -> 0x0156 }
            if (r3 == 0) goto L_0x0147
            java.lang.String r3 = r1.getContractCode()     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r1.getContractShortType()     // Catch:{ all -> 0x0156 }
            java.lang.String r5 = ""
            int r3 = com.hbg.lib.data.future.util.FuturePrecisionUtil.s(r3, r4, r5)     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = r1.getAmount()     // Catch:{ all -> 0x0156 }
            java.lang.String r5 = ""
            java.lang.String r6 = r9.m0()     // Catch:{ all -> 0x0156 }
            com.hbg.lib.data.symbol.TradeType r7 = r9.f23696h     // Catch:{ all -> 0x0156 }
            boolean r8 = a7.e.F(r7)     // Catch:{ all -> 0x0156 }
            java.lang.String r4 = com.hbg.lib.data.future.util.FutureUnitUtil.c(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0156 }
            java.lang.String r3 = i6.m.m(r4, r3)     // Catch:{ all -> 0x0156 }
            r1.setAmount(r3)     // Catch:{ all -> 0x0156 }
        L_0x0147:
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r1 = r9.f23694f     // Catch:{ all -> 0x0156 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0156 }
            if (r1 != 0) goto L_0x0009
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r1 = r9.f23694f     // Catch:{ all -> 0x0156 }
            r1.add(r2)     // Catch:{ all -> 0x0156 }
            goto L_0x0009
        L_0x0156:
            r10 = move-exception
            goto L_0x0198
        L_0x0158:
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23694f     // Catch:{ all -> 0x0196 }
            ce.m r1 = new ce.m     // Catch:{ all -> 0x0196 }
            r1.<init>(r9)     // Catch:{ all -> 0x0196 }
            java.util.Collections.sort(r10, r1)     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23694f     // Catch:{ all -> 0x0196 }
            int r10 = r10.size()     // Catch:{ all -> 0x0196 }
            r1 = 20
            if (r10 <= r1) goto L_0x017e
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23694f     // Catch:{ all -> 0x0196 }
            r2 = 0
            java.util.List r10 = r10.subList(r2, r1)     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r1 = r9.f23693e     // Catch:{ all -> 0x0196 }
            r1.clear()     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r1 = r9.f23693e     // Catch:{ all -> 0x0196 }
            r1.addAll(r10)     // Catch:{ all -> 0x0196 }
            goto L_0x018a
        L_0x017e:
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23693e     // Catch:{ all -> 0x0196 }
            r10.clear()     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23693e     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r1 = r9.f23694f     // Catch:{ all -> 0x0196 }
            r10.addAll(r1)     // Catch:{ all -> 0x0196 }
        L_0x018a:
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23694f     // Catch:{ all -> 0x0196 }
            r10.clear()     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r10 = r9.f23694f     // Catch:{ all -> 0x0196 }
            java.util.List<com.hbg.module.kline.bean.MarketInfoTradesItem> r1 = r9.f23693e     // Catch:{ all -> 0x0196 }
            r10.addAll(r1)     // Catch:{ all -> 0x0196 }
        L_0x0196:
            monitor-exit(r0)     // Catch:{ all -> 0x0156 }
            return
        L_0x0198:
            monitor-exit(r0)     // Catch:{ all -> 0x0156 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.kline.presenter.MarketInfoTradesPresenter.r0(java.util.List):void");
    }

    public boolean s0() {
        return TradeType.isContract(this.f23696h);
    }

    public boolean t0() {
        return TradeType.isLinearSwap(this.f23696h);
    }

    public boolean u0() {
        return TradeType.isOption(this.f23696h);
    }

    public boolean v0() {
        return TradeType.isSwap(this.f23696h);
    }

    public void z0() {
        B0();
        if (TradeType.isContract(this.f23696h)) {
            q7.a.a().d(this.f23701m);
        } else if (TradeType.isSwap(this.f23696h)) {
            l9.a.a().d(this.f23701m);
        } else if (TradeType.isOption(this.f23696h)) {
            p8.a.a().d(this.f23701m);
        } else if (TradeType.isLinearSwap(this.f23696h)) {
            p8.a.a().d(this.f23701m);
        } else {
            x8.a.a().d(this.f23701m);
        }
    }
}
