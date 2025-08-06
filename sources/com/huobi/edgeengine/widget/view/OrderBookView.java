package com.huobi.edgeengine.widget.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.blankj.utilcode.util.x;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.ui.NewestPriceItemView;
import com.hbg.lib.core.ui.TradeTrendItemView;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.libkt.helper.SensorsDataHelper;
import com.huobi.R$styleable;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import gk.m;
import gk.n;
import gk.o;
import gk.p;
import i6.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import k6.b;
import k6.c;
import pro.huobi.R;

public class OrderBookView extends LinearLayout implements t.a, com.huobi.feature.ui.a {
    public static int K;
    public static int L;
    public String A;
    public TextView B;
    public MenuItemOnClickListener C;
    public View D;
    public ImageView E;
    public TextView F;
    public LinearLayout G;
    public final MenuItemOnClickListener H;
    public c6.b<k6.c> I;
    public b.C0742b J;

    /* renamed from: b  reason: collision with root package name */
    public final List<k6.c> f44486b;

    /* renamed from: c  reason: collision with root package name */
    public k6.b f44487c;

    /* renamed from: d  reason: collision with root package name */
    public int f44488d;

    /* renamed from: e  reason: collision with root package name */
    public int f44489e;

    /* renamed from: f  reason: collision with root package name */
    public final List<k6.c> f44490f;

    /* renamed from: g  reason: collision with root package name */
    public final List<k6.a> f44491g;

    /* renamed from: h  reason: collision with root package name */
    public List<? extends c.a> f44492h;

    /* renamed from: i  reason: collision with root package name */
    public List<? extends c.a> f44493i;

    /* renamed from: j  reason: collision with root package name */
    public e f44494j;

    /* renamed from: k  reason: collision with root package name */
    public t f44495k;

    /* renamed from: l  reason: collision with root package name */
    public long f44496l;

    /* renamed from: m  reason: collision with root package name */
    public int f44497m;

    /* renamed from: n  reason: collision with root package name */
    public int f44498n;

    /* renamed from: o  reason: collision with root package name */
    public int f44499o;

    /* renamed from: p  reason: collision with root package name */
    public int f44500p;

    /* renamed from: q  reason: collision with root package name */
    public NewestPriceItemView f44501q;

    /* renamed from: r  reason: collision with root package name */
    public final int f44502r;

    /* renamed from: s  reason: collision with root package name */
    public final BottomMenuFragment f44503s;

    /* renamed from: t  reason: collision with root package name */
    public final BottomMenuFragment f44504t;

    /* renamed from: u  reason: collision with root package name */
    public final List<MenuItem> f44505u;

    /* renamed from: v  reason: collision with root package name */
    public final List<MenuItem> f44506v;

    /* renamed from: w  reason: collision with root package name */
    public m f44507w;

    /* renamed from: x  reason: collision with root package name */
    public String f44508x;

    /* renamed from: y  reason: collision with root package name */
    public String f44509y;

    /* renamed from: z  reason: collision with root package name */
    public String f44510z;

    public class a implements MenuItemOnClickListener {
        public a() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : OrderBookView.this.f44505u) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("business_category", "copytrading_app_USDT-M");
            if (i11 == 0) {
                hashMap.put("button_name", "default");
                m mVar = OrderBookView.this.f44507w;
                if (mVar != null) {
                    mVar.j(0);
                }
                if (w.l()) {
                    OrderBookView.this.E.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    OrderBookView.this.E.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                OrderBookView.this.k(0);
            } else if (i11 == 1) {
                hashMap.put("button_name", "buy");
                m mVar2 = OrderBookView.this.f44507w;
                if (mVar2 != null) {
                    mVar2.j(1);
                }
                if (w.l()) {
                    OrderBookView.this.E.setImageResource(R.drawable.trade_trend_red);
                } else {
                    OrderBookView.this.E.setImageResource(R.drawable.trade_trend_green);
                }
                OrderBookView.this.k(1);
            } else {
                hashMap.put("button_name", "sell");
                m mVar3 = OrderBookView.this.f44507w;
                if (mVar3 != null) {
                    mVar3.j(2);
                }
                if (w.l()) {
                    OrderBookView.this.E.setImageResource(R.drawable.trade_trend_green);
                } else {
                    OrderBookView.this.E.setImageResource(R.drawable.trade_trend_red);
                }
                OrderBookView.this.k(2);
            }
            SensorsDataHelper.track("appclick_copytrading", hashMap);
            m mVar4 = OrderBookView.this.f44507w;
            if (mVar4 != null) {
                mVar4.l(false);
            }
            OrderBookView.this.f44504t.dismiss();
        }
    }

    public class b implements MenuItemOnClickListener {
        public b() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            m mVar = OrderBookView.this.f44507w;
            if (mVar != null) {
                mVar.b(i11);
            }
            OrderBookView.this.f44503s.dismiss();
        }
    }

    public class c implements b.C0742b {
        public c() {
        }

        public void a(k6.b bVar) {
            if (OrderBookView.this.f44494j != null) {
                OrderBookView.this.f44494j.c(bVar.c());
            }
        }

        public void b(k6.b bVar) {
            if (OrderBookView.this.f44494j != null) {
                OrderBookView.this.f44494j.b(bVar.c());
            }
        }
    }

    public class d implements BottomMenuFragment.CopyTradingCancelListener {
        public d() {
        }

        public void onCancel() {
            HashMap hashMap = new HashMap();
            hashMap.put("business_category", "copytrading_app_USDT-M");
            hashMap.put("button_name", "cancel");
            SensorsDataHelper.track("appclick_copytrading", hashMap);
        }
    }

    public interface e {
        void a(c.a aVar);

        void b(b.a aVar);

        void c(b.a aVar);

        void d(b.a aVar);

        void e(MarketBuySellItem marketBuySellItem, MarketBuySellItem marketBuySellItem2);
    }

    public OrderBookView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("business_category", "copytrading_app_USDT-M");
        hashMap.put("button_name", "depth");
        SensorsDataHelper.track("appclick_copytrading", hashMap);
        this.f44504t.show(((Activity) getContext()).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(View view) {
        m mVar = this.f44507w;
        if (mVar != null && mVar.L().size() > 0) {
            this.f44503s.show(((Activity) getContext()).getFragmentManager(), "depthBottomMenuFragment");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(k6.c cVar) {
        e eVar = this.f44494j;
        if (eVar != null) {
            eVar.a(cVar.c());
        }
        VibrateManager.a(this);
    }

    public void A0(int i11) {
    }

    public void A2(List<CouponReturn> list, boolean z11) {
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        setBuyList(list);
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        setSellList(list);
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        setNewestPrice(marketCurrentPriceItem);
        e eVar = this.f44494j;
        if (eVar != null) {
            eVar.d(marketCurrentPriceItem);
        }
    }

    public void I0() {
    }

    public void J0() {
    }

    public void K0() {
    }

    public void L0() {
    }

    public void M0(int i11) {
    }

    public void N0(ContractDepth contractDepth, int i11) {
        String priceTick = contractDepth.getPriceTick();
        if (!TextUtils.isEmpty(priceTick)) {
            this.F.setText(i6.m.a(priceTick).stripTrailingZeros().toPlainString());
        } else {
            this.F.setText("--");
        }
    }

    public void O0(int i11) {
    }

    public void P0(String str, String str2) {
    }

    public void Q0() {
    }

    public void R0(boolean z11) {
    }

    public void S0(String str, String str2) {
    }

    public void T0(int i11) {
    }

    public void U0() {
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.f44506v.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.f44506v.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.H));
            } else {
                this.f44506v.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.H));
            }
        }
        this.f44503s.setMenuItems(this.f44506v);
    }

    public boolean W0() {
        return false;
    }

    public void X0(String str) {
    }

    public void Y0(int i11) {
    }

    public void c(int i11) {
    }

    public void d(boolean z11) {
    }

    public String getCallBackRateText() {
        return null;
    }

    public TextView getIndexPriceView() {
        NewestPriceItemView newestPriceItemView = this.f44501q;
        if (newestPriceItemView != null) {
            return newestPriceItemView.getIndexTv();
        }
        return null;
    }

    public String getInputAmountText() {
        return null;
    }

    public String getInputPriceText() {
        return null;
    }

    public NewestPriceItemView getNewestPriceItemView() {
        return this.f44501q;
    }

    public int getNewestPriceItemViewHeight() {
        int max;
        int i11;
        NewestPriceItemView newestPriceItemView = this.f44501q;
        if (newestPriceItemView == null) {
            return 0;
        }
        if (newestPriceItemView.f68567c.getVisibility() == 0) {
            max = Math.max(L, this.f44501q.getHeight());
            L = max;
            i11 = this.f44502r;
        } else {
            max = Math.max(K, this.f44501q.getHeight());
            K = max;
            i11 = this.f44502r;
        }
        return max + i11;
    }

    public String getOrderPlaceInputAmount() {
        return null;
    }

    public int getOrderType() {
        return 0;
    }

    public int getPositionType() {
        return 0;
    }

    public int getSeekBarProgress() {
        return 0;
    }

    public FutureTpSlSettingParams getSlCache() {
        return null;
    }

    public FutureTpSlSettingParams getTpCache() {
        return null;
    }

    public FutureTpSlSettingDialogFragment.OpenType getTpSlDialogOpenType() {
        return null;
    }

    public boolean getTpSlSwitchCheck() {
        return false;
    }

    public int getTradeAmountType() {
        return 0;
    }

    public int getTradePosition() {
        return 0;
    }

    public int getTradePriceType() {
        return 0;
    }

    public String getTriggerPriceText() {
        return null;
    }

    public void handleMessage(Message message) {
        this.f44496l = System.currentTimeMillis();
        p();
    }

    public void k(int i11) {
        this.f44497m = i11;
        ArrayList arrayList = new ArrayList();
        if (i11 == 1) {
            arrayList.add(this.f44487c);
            arrayList.addAll(this.f44490f);
        } else if (i11 == 2) {
            arrayList.addAll(this.f44486b);
            arrayList.add(this.f44487c);
        } else {
            for (int size = this.f44486b.size() - this.f44488d; size < this.f44486b.size(); size++) {
                arrayList.add(this.f44486b.get(size));
            }
            arrayList.add(this.f44487c);
            for (int i12 = 0; i12 < this.f44488d; i12++) {
                arrayList.add(this.f44490f.get(i12));
            }
        }
        this.f44491g.clear();
        this.f44491g.addAll(arrayList);
        setSellList(this.f44493i);
        setBuyList(this.f44492h);
        w();
    }

    public void k2(String str) {
    }

    public void l(Context context) {
        this.f44507w = new m(this, (nk.b) null, TradeType.LINEAR_SWAP);
        setOrientation(1);
        this.f44495k = new t(this);
        m();
        o();
        k(0);
    }

    public void m() {
        for (int i11 = 0; i11 < this.f44489e; i11++) {
            this.f44486b.add(new k6.c(this.I));
        }
        this.f44491g.addAll(this.f44486b);
        k6.b bVar = new k6.b(this.J);
        this.f44487c = bVar;
        this.f44491g.add(bVar);
        for (int i12 = 0; i12 < this.f44489e; i12++) {
            this.f44490f.add(new k6.c(this.I));
        }
        this.f44491g.addAll(this.f44490f);
        n();
    }

    public final void n() {
        this.f44505u.add(new MenuItem(0, getContext().getString(R.string.n_contract_trade_trend_default), getContext().getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.C));
        List<MenuItem> list = this.f44505u;
        String string = getContext().getString(R.string.n_contract_trade_trend_buy);
        String string2 = getContext().getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.C));
        this.f44505u.add(new MenuItem(2, getContext().getString(R.string.n_contract_trade_trend_sell), getContext().getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.C));
        this.f44504t.setMenuItems(this.f44505u);
        this.f44504t.setCopyTradingCancel(new d());
        this.f44504t.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void n0() {
    }

    public void n2(FuturePriceLimitInfo futurePriceLimitInfo) {
    }

    public void notifyDataSetChanged() {
        if (this.f44495k != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.f44495k.hasMessages(1)) {
                this.f44495k.sendEmptyMessageDelayed(1, 250);
            } else if (currentTimeMillis - this.f44496l > 200) {
                this.f44496l = currentTimeMillis;
                this.f44495k.removeMessages(1);
                this.f44495k.sendEmptyMessage(1);
            }
        }
    }

    public final void o() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.order_book_title, (ViewGroup) null);
        this.B = (TextView) inflate.findViewById(R.id.contract_vertical_amount_label_tv);
        ((TextView) inflate.findViewById(R.id.contract_vertical_price_label_tv)).setText(String.format(getContext().getString(R.string.order_price_icon_label), new Object[]{"usdt".toUpperCase(Locale.US)}));
        addView(inflate);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.G = linearLayout;
        linearLayout.setOrientation(1);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = PixelUtils.a(4.0f);
        addView(this.G, marginLayoutParams);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.order_book_depth, (ViewGroup) null);
        this.D = inflate2.findViewById(R.id.depth_ll);
        this.E = (ImageView) inflate2.findViewById(R.id.trend_change_iv);
        this.F = (TextView) inflate2.findViewById(R.id.vertical_depth_tv);
        this.E.setOnClickListener(new o(this));
        this.D.setOnClickListener(new n(this));
        addView(inflate2);
    }

    public void p() {
        if (this.G != null) {
            for (int i11 = 0; i11 < this.G.getChildCount(); i11++) {
                View childAt = this.G.getChildAt(i11);
                if (childAt instanceof NewestPriceItemView) {
                    ((NewestPriceItemView) childAt).f();
                } else if (childAt instanceof TradeTrendItemView) {
                    ((TradeTrendItemView) childAt).i();
                }
            }
        }
    }

    public void p0(String str, String str2) {
    }

    public void q0() {
    }

    public void r0() {
    }

    public void s0() {
    }

    public void setAmountEtText(String str) {
    }

    public void setBuyList(List<? extends c.a> list) {
        if (list != null) {
            this.f44492h = list;
            for (int i11 = 0; i11 < this.f44490f.size(); i11++) {
                if (i11 < list.size()) {
                    this.f44490f.get(i11).e((c.a) list.get(i11));
                }
            }
        }
    }

    public void setCallback(e eVar) {
        this.f44494j = eVar;
    }

    public void setContractTradeViewController(nk.e eVar) {
    }

    public void setInputPriceUpdate(boolean z11) {
    }

    public void setLeverList(List<String> list) {
    }

    public void setNewestPrice(b.a aVar) {
        k6.b bVar = this.f44487c;
        if (bVar != null) {
            bVar.e(aVar);
        }
    }

    public void setOnCouponClickListener(View.OnClickListener onClickListener) {
    }

    public void setPriceInputType(int i11) {
    }

    public void setPriceText(String str) {
    }

    public void setSellList(List<? extends c.a> list) {
        if (list != null) {
            this.f44493i = list;
            for (int i11 = 0; i11 < this.f44486b.size(); i11++) {
                List<k6.c> list2 = this.f44486b;
                k6.c cVar = list2.get((list2.size() - 1) - i11);
                if (i11 < list.size()) {
                    cVar.e((c.a) list.get(i11));
                }
            }
        }
    }

    public void setViewVisibility(int i11) {
    }

    public void t(String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        if (this.f44507w != null) {
            this.f44509y = str;
            this.f44508x = str2;
            this.f44510z = str3;
            this.A = str4;
            if (this.B != null) {
                try {
                    str5 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
                } catch (Throwable unused) {
                    str5 = "";
                }
                if (TextUtils.isEmpty(str5)) {
                    this.B.setText(R.string.n_contract_trade_input_amount);
                } else {
                    TextView textView = this.B;
                    String string = getContext().getString(R.string.n_contract_trade_market_amount_label);
                    Object[] objArr = new Object[1];
                    if (str4.equalsIgnoreCase("symbol")) {
                        str6 = str5.toUpperCase(Locale.US);
                    } else {
                        str6 = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1];
                    }
                    objArr[0] = str6;
                    textView.setText(String.format(string, objArr));
                }
            }
            if (TextUtils.isEmpty(this.f44509y)) {
                this.f44507w.b0();
            } else {
                this.f44507w.X(str, str2, str3, TradeType.LINEAR_SWAP);
            }
        }
    }

    public void t0() {
    }

    public void u(boolean z11) {
        m mVar = this.f44507w;
        if (mVar == null) {
            return;
        }
        if (z11) {
            mVar.X(this.f44509y, this.f44508x, this.f44510z, TradeType.LINEAR_SWAP);
        } else {
            mVar.b0();
        }
    }

    public void u0(boolean z11, boolean z12) {
    }

    public final void v() {
        this.f44486b.clear();
        for (int i11 = 0; i11 < this.f44489e; i11++) {
            this.f44486b.add(new k6.c(this.I));
        }
        this.f44490f.clear();
        for (int i12 = 0; i12 < this.f44489e; i12++) {
            this.f44490f.add(new k6.c(this.I));
        }
        k(this.f44497m);
    }

    public void v0() {
    }

    public void v2(int i11, int i12) {
    }

    public void w() {
        this.G.removeAllViews();
        for (k6.a next : this.f44491g) {
            if (next instanceof k6.b) {
                this.G.addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, 0, 1.0f));
                NewestPriceItemView newestPriceItemView = new NewestPriceItemView(getContext());
                this.f44501q = newestPriceItemView;
                newestPriceItemView.g((k6.b) next);
                this.G.addView(this.f44501q, new LinearLayout.LayoutParams(-1, -2));
                this.G.addView(new Space(getContext()), new LinearLayout.LayoutParams(-1, 0, 1.0f));
            } else {
                TradeTrendItemView tradeTrendItemView = new TradeTrendItemView(getContext());
                int i11 = this.f44500p;
                if (i11 != 0) {
                    tradeTrendItemView.setIndexColor(i11);
                }
                int i12 = this.f44499o;
                if (i12 != 0) {
                    tradeTrendItemView.setAmountColor(i12);
                }
                tradeTrendItemView.j((k6.c) next);
                this.G.addView(tradeTrendItemView, new LinearLayout.LayoutParams(-1, this.f44498n));
            }
        }
    }

    public void w0(boolean z11, boolean z12) {
    }

    public boolean w2() {
        return false;
    }

    public void x(int i11, int i12) {
        boolean z11;
        boolean z12 = true;
        if (i11 != this.f44488d) {
            this.f44488d = i11;
            z11 = true;
        } else {
            z11 = false;
        }
        if (i12 != this.f44489e) {
            this.f44489e = i12;
        } else {
            z12 = z11;
        }
        if (z12) {
            v();
        }
    }

    public void x0(String str) {
    }

    public void x2(String str) {
    }

    public void y(MarketBuySellItem marketBuySellItem, MarketBuySellItem marketBuySellItem2) {
        e eVar = this.f44494j;
        if (eVar != null) {
            eVar.e(marketBuySellItem, marketBuySellItem2);
        }
    }

    public void y2() {
    }

    public void z(String str) {
        m mVar = this.f44507w;
        if (mVar != null) {
            mVar.e0(x.b(R.string.n_contract_mark_price) + " " + str);
        }
    }

    public void z0(boolean z11) {
    }

    public void z2() {
    }

    public OrderBookView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrderBookView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44486b = new ArrayList();
        this.f44488d = 5;
        this.f44489e = 10;
        this.f44490f = new ArrayList();
        this.f44491g = new ArrayList();
        this.f44497m = 0;
        this.f44502r = PixelUtils.a(4.0f);
        this.f44503s = new BottomMenuFragment();
        this.f44504t = new BottomMenuFragment();
        this.f44505u = new ArrayList();
        this.f44506v = new ArrayList();
        this.f44508x = "";
        this.f44509y = "";
        this.f44510z = "";
        this.A = "symbol";
        this.C = new a();
        this.H = new b();
        this.I = new p(this);
        this.J = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TradeTrendView, i11, 0);
        this.f44498n = obtainStyledAttributes.getDimensionPixelOffset(1, getResources().getDimensionPixelOffset(R.dimen.dimen_26));
        this.f44499o = obtainStyledAttributes.getColor(0, 0);
        this.f44500p = obtainStyledAttributes.getColor(2, 0);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        l(context);
    }
}
