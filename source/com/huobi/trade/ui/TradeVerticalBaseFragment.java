package com.huobi.trade.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.fastjson.JSON;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.ExchangeSettingsController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.RankScreenBean;
import com.hbg.lib.network.pro.core.bean.ExchangeSettings;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.anim.CommonAnimateUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.account.entity.AccountType;
import com.huobi.coupon.CouponChooseDialog;
import com.huobi.coupon.CouponFragment;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.ui.dialog.LimitChooseDialog;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.margin.ui.TradeMarginRiskRateViewNew;
import com.huobi.supermargin.ui.TradeVerticalSuperMarginFragment;
import com.huobi.trade.bean.DepthItem;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.TradeTimeInfo;
import com.huobi.trade.helper.x;
import com.huobi.trade.presenter.TradePresenter;
import com.huobi.trade.presenter.TradeVerticalBasePresenter;
import com.huobi.trade.ui.TradeBaseFragment;
import com.huobi.trade.ui.y3;
import com.huobi.trade.utils.TradeTimeMonitorUtils;
import com.huobi.trade.utils.a;
import com.huobi.utils.HBHTtoHTXManager;
import com.huobi.utils.SymbolUtil;
import com.huobi.utils.k0;
import com.huobi.view.TradeAmountEditext;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.TradeIceBergLayout;
import com.huobi.view.TradeMarketAmountVolume;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.TradeRangeBarView;
import com.huobi.view.UnderLineTextView;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.keyboard.KeyboardTouchListener;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import dt.h2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k6.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import qk.v0;
import rx.Observable;

public abstract class TradeVerticalBaseFragment<P extends TradeVerticalBasePresenter<V>, V extends y3> extends TradeBaseFragment<P, V> implements y3, View.OnClickListener {
    public boolean A0;
    public View A1;
    public TextView B0;
    public CommonSwitchButton B1;
    public TextView C0;
    public TextView C1;
    public TextView D0;
    public View D1;
    public TextView E0;
    public UnderLineTextView E1;
    public EditText F0;
    public TextView F1;
    public TradeMarketAmountVolume G0;
    public UnderLineTextView G1;
    public TradeIceBergLayout H0;
    public UnderLineTextView H1;
    public LinearLayout I0;
    public TextView I1;
    public TextView J0;
    public TextView J1;
    public TradePriceEditext K0;
    public TextView K1;
    public EditText L0;
    public TextView L1;
    public TradeAmountEditext M0;
    public HuobiKeyboardHelper M1;
    public TradeAmountEditext N0;
    public View N1;
    public EditText O0;
    public View O1;
    public ImageView P0;
    public TextView P1;
    public TextView Q0;
    public TextView Q1;
    public TextView R0;
    public View R1;
    public View S0;
    public TextView S1;
    public UnderLineTextView T0;
    public TextView T1;
    public UnderLineTextView U0;
    public ImageView U1;
    public CommonListPopupDialog V0;
    public View V1;
    public CommonListPopupDialog W0;
    public TextView W1;
    public List<CommonPopListItem> X0 = new ArrayList();
    public View X1;
    public final List<CommonPopListItem> Y0 = new ArrayList();
    public View Y1;
    public List<String> Z0 = new ArrayList();
    public View Z1;

    /* renamed from: a1  reason: collision with root package name */
    public MagicIndicator f82492a1;

    /* renamed from: a2  reason: collision with root package name */
    public CouponFragment f82493a2;

    /* renamed from: b1  reason: collision with root package name */
    public TextView f82494b1;

    /* renamed from: b2  reason: collision with root package name */
    public TradeTimeOrderFragment f82495b2;

    /* renamed from: c1  reason: collision with root package name */
    public MultiColorSeekBar f82496c1;

    /* renamed from: c2  reason: collision with root package name */
    public String f82497c2 = "";

    /* renamed from: d1  reason: collision with root package name */
    public TextView f82498d1;

    /* renamed from: d2  reason: collision with root package name */
    public String f82499d2 = "";

    /* renamed from: e1  reason: collision with root package name */
    public TextView f82500e1;

    /* renamed from: e2  reason: collision with root package name */
    public CommonPopListItem f82501e2;

    /* renamed from: f1  reason: collision with root package name */
    public TextView f82502f1;

    /* renamed from: f2  reason: collision with root package name */
    public CommonPopListItem.a f82503f2 = new k();

    /* renamed from: g1  reason: collision with root package name */
    public ImageView f82504g1;

    /* renamed from: g2  reason: collision with root package name */
    public final CommonPopListItem.a f82505g2 = new l();

    /* renamed from: h1  reason: collision with root package name */
    public View f82506h1;

    /* renamed from: h2  reason: collision with root package name */
    public TradeBaseFragment<P, V>.k f82507h2 = new c();

    /* renamed from: i1  reason: collision with root package name */
    public View f82508i1;

    /* renamed from: i2  reason: collision with root package name */
    public TradeBaseFragment<P, V>.k f82509i2 = new d();

    /* renamed from: j1  reason: collision with root package name */
    public TradePriceEditext f82510j1;

    /* renamed from: j2  reason: collision with root package name */
    public TradeBaseFragment<P, V>.k f82511j2 = new e();

    /* renamed from: k1  reason: collision with root package name */
    public TextView f82512k1;

    /* renamed from: k2  reason: collision with root package name */
    public View.OnTouchListener f82513k2 = new r2(this);

    /* renamed from: l1  reason: collision with root package name */
    public LinearLayout f82514l1;

    /* renamed from: l2  reason: collision with root package name */
    public MenuItemOnClickListener f82515l2 = new f();

    /* renamed from: m1  reason: collision with root package name */
    public LinearLayout f82516m1;

    /* renamed from: m2  reason: collision with root package name */
    public MenuItemOnClickListener f82517m2 = new g();

    /* renamed from: n1  reason: collision with root package name */
    public View f82518n1;

    /* renamed from: n2  reason: collision with root package name */
    public final ViewTreeObserver.OnPreDrawListener f82519n2 = new h();

    /* renamed from: o1  reason: collision with root package name */
    public BottomMenuFragment f82520o1;

    /* renamed from: p1  reason: collision with root package name */
    public List<MenuItem> f82521p1 = new ArrayList();

    /* renamed from: q1  reason: collision with root package name */
    public LinearLayout f82522q1;

    /* renamed from: r1  reason: collision with root package name */
    public ImageView f82523r1;

    /* renamed from: s1  reason: collision with root package name */
    public TextView f82524s1;

    /* renamed from: t1  reason: collision with root package name */
    public TextView f82525t1;

    /* renamed from: u1  reason: collision with root package name */
    public TradeMarginRiskRateViewNew f82526u1;

    /* renamed from: v1  reason: collision with root package name */
    public BottomMenuFragment f82527v1;

    /* renamed from: w1  reason: collision with root package name */
    public List<MenuItem> f82528w1 = new ArrayList();

    /* renamed from: x1  reason: collision with root package name */
    public LinearLayout f82529x1;

    /* renamed from: y1  reason: collision with root package name */
    public View f82530y1;

    /* renamed from: z1  reason: collision with root package name */
    public View f82531z1;

    public class a implements BaseDialogFragment.c {
        public a() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
            tradeVerticalBaseFragment.R0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(tradeVerticalBaseFragment.getActivity(), R.drawable.trade_arrow_down), (Drawable) null);
        }

        public void onDialogFragmentResume() {
            TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
            tradeVerticalBaseFragment.R0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(tradeVerticalBaseFragment.getActivity(), R.drawable.trade_arrow_up), (Drawable) null);
        }
    }

    public class b implements MultiColorSeekBar.OnProgressChangedListener {
        public b() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).z2(z11);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).x2(i11, z11);
            if (z11) {
                TradeVerticalBaseFragment.this.M1.hideKeyboard();
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).z2(false);
            }
        }
    }

    public class c extends TradeBaseFragment<P, V>.k {
        public c() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            boolean unused = TradeVerticalBaseFragment.this.A0 = true;
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).j2(TradeVerticalBaseFragment.this.O0, editable, false);
            boolean unused2 = TradeVerticalBaseFragment.this.A0 = false;
        }
    }

    public class d extends TradeBaseFragment<P, V>.k {
        public d() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            if (!((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).v2()) {
                boolean unused = TradeVerticalBaseFragment.this.A0 = true;
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).g2(TradeVerticalBaseFragment.this.G0.getVolumeEt(), editable);
                boolean unused2 = TradeVerticalBaseFragment.this.A0 = false;
            }
        }
    }

    public class e extends TradeBaseFragment<P, V>.k {
        public e() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            if (!((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).v2()) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).f2(TradeVerticalBaseFragment.this.G0.getAmountEt(), editable);
            }
        }
    }

    public class f implements MenuItemOnClickListener {
        public f() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).m2(i11);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).z1(false);
            if (TradeVerticalBaseFragment.this.f82527v1 != null) {
                TradeVerticalBaseFragment.this.f82527v1.dismiss();
            }
        }
    }

    public class g implements MenuItemOnClickListener {
        public g() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (i11 == 0) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).A2(0);
                if (w.l()) {
                    TradeVerticalBaseFragment.this.P0.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    TradeVerticalBaseFragment.this.P0.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                TradeVerticalBaseFragment.this.f82331u.c(0);
            } else if (i11 == 1) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).A2(1);
                if (w.l()) {
                    TradeVerticalBaseFragment.this.P0.setImageResource(R.drawable.trade_trend_red);
                } else {
                    TradeVerticalBaseFragment.this.P0.setImageResource(R.drawable.trade_trend_green);
                }
                TradeVerticalBaseFragment.this.f82331u.c(1);
            } else {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).A2(2);
                if (w.l()) {
                    TradeVerticalBaseFragment.this.P0.setImageResource(R.drawable.trade_trend_green);
                } else {
                    TradeVerticalBaseFragment.this.P0.setImageResource(R.drawable.trade_trend_red);
                }
                TradeVerticalBaseFragment.this.f82331u.c(2);
            }
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).D2();
            if (TradeVerticalBaseFragment.this.f82520o1 != null) {
                TradeVerticalBaseFragment.this.f82520o1.dismiss();
                BottomMenuFragment unused = TradeVerticalBaseFragment.this.f82520o1 = null;
            }
        }
    }

    public class h implements ViewTreeObserver.OnPreDrawListener {
        public h() {
        }

        public boolean onPreDraw() {
            TradeVerticalBaseFragment.this.Z1.getViewTreeObserver().removeOnPreDrawListener(this);
            int itemHeight = TradeVerticalBaseFragment.this.f82331u.getItemHeight();
            ViewGroup.LayoutParams layoutParams = TradeVerticalBaseFragment.this.f82333v.getLayoutParams();
            int height = TradeVerticalBaseFragment.this.f82331u.getHeight() - layoutParams.height;
            int newestPriceItemViewHeight = TradeVerticalBaseFragment.this.f82331u.getNewestPriceItemViewHeight();
            int i11 = height - newestPriceItemViewHeight;
            int i12 = i11 / itemHeight;
            int i13 = i12 / 2;
            if (i13 >= 5 || !TradeVerticalBaseFragment.this.f82331u.g()) {
                TradeVerticalBaseFragment.this.f82331u.setInsidePadding(i11 - ((itemHeight * i13) * 2));
                TradeVerticalBaseFragment.this.f82331u.l(i13, i12);
                layoutParams.height = 0;
                TradeVerticalBaseFragment.this.f82333v.setLayoutParams(layoutParams);
                return true;
            }
            layoutParams.height = (newestPriceItemViewHeight + (itemHeight * 10)) - height;
            TradeVerticalBaseFragment.this.f82333v.setLayoutParams(layoutParams);
            TradeVerticalBaseFragment.this.f82331u.setInsidePadding(0);
            TradeVerticalBaseFragment.this.f82331u.l(5, 10);
            return true;
        }
    }

    public class i implements a.c {
        public i() {
        }

        public void a() {
            ConfigPreferences.n("user_config", "margin_guide", true);
        }

        public boolean b() {
            return TradeVerticalBaseFragment.this.Ik();
        }

        public void onFinish() {
            ConfigPreferences.n("user_config", "margin_guide", true);
        }

        public void onShow() {
            TradeVerticalBaseFragment.this.O2(0, 0);
        }
    }

    public static /* synthetic */ class j {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f82541a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.hbg.lib.data.symbol.TradeType[] r0 = com.hbg.lib.data.symbol.TradeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f82541a = r0
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.PRO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f82541a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.MARGIN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f82541a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.hbg.lib.data.symbol.TradeType r1 = com.hbg.lib.data.symbol.TradeType.SUPERMARGIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.trade.ui.TradeVerticalBaseFragment.j.<clinit>():void");
        }
    }

    public class k implements CommonPopListItem.a {
        public k() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            if (TradeVerticalBaseFragment.this.V0 != null) {
                TradeVerticalBaseFragment.this.V0.dismiss();
                CommonListPopupDialog unused = TradeVerticalBaseFragment.this.V0 = null;
            }
            TradeVerticalBaseFragment.this.I0.setVisibility(8);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).A1(Integer.MIN_VALUE);
            if (commonPopListItem.getType() != 4) {
                boolean z11 = false;
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).x0(commonPopListItem.getType(), false);
                if (commonPopListItem.getType() == 3) {
                    TradeVerticalBaseFragment.this.R1.setVisibility(8);
                } else if (commonPopListItem.getType() == 0) {
                    ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).A1(commonPopListItem.getChildType());
                    TradeVerticalBaseFragment.this.I0.setVisibility(0);
                    TradeIceBergLayout tradeIceBergLayout = TradeVerticalBaseFragment.this.H0;
                    if (commonPopListItem.getChildType() == 0 && com.huobi.trade.helper.m.e().c()) {
                        z11 = true;
                    }
                    ViewUtil.m(tradeIceBergLayout, z11);
                }
            } else if (tg.r.x().F0()) {
                TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
                TradeTimeOrderFragment unused2 = tradeVerticalBaseFragment.f82495b2 = TradeTimeOrderFragment.uh(tradeVerticalBaseFragment.Vk());
                TradeVerticalBaseFragment.this.f82495b2.show(TradeVerticalBaseFragment.this.getActivity().getSupportFragmentManager(), "");
            } else {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).D1();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", TradeVerticalBaseFragment.this.Xk(commonPopListItem.getType()));
            TradeVerticalBaseFragment tradeVerticalBaseFragment2 = TradeVerticalBaseFragment.this;
            hashMap.put("trade_mode", tradeVerticalBaseFragment2.Zk(((TradeVerticalBasePresenter) tradeVerticalBaseFragment2.yh()).V0()));
            gs.g.i("app_trade_order_type_click", hashMap);
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).W0() == commonPopListItem.getType();
        }
    }

    public class l implements CommonPopListItem.a {
        public l() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            if (TradeVerticalBaseFragment.this.W0 != null) {
                TradeVerticalBaseFragment.this.W0.dismiss();
                CommonListPopupDialog unused = TradeVerticalBaseFragment.this.W0 = null;
            }
            TradeVerticalBaseFragment.this.Lk(commonPopListItem.getType());
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ks.a.a().b() == commonPopListItem.getType();
        }
    }

    public class m extends CommonNavigatorAdapter {
        public m() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (i11 != 0 || !((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).a1()) {
                boolean z11 = true;
                if (i11 != 1 || ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).a1()) {
                    ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).z1(false);
                    if (i11 == 0) {
                        TradeVerticalBaseFragment.this.F0.setText("");
                        if (a1.v().S(((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o0())) {
                            ViewUtil.m(TradeVerticalBaseFragment.this.N0, false);
                            if (ht.o.B().F() != null) {
                                TradeVerticalBaseFragment.this.Wl(ht.o.B().F().getCurrentPrice(), true, false);
                            }
                        } else {
                            TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
                            tradeVerticalBaseFragment.Wl(((TradeVerticalBasePresenter) tradeVerticalBaseFragment.yh()).O0(), true, false);
                        }
                    } else if (i11 == 1) {
                        TradeVerticalBaseFragment.this.F0.setText("");
                        if (!a1.v().S(((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o0()) || ht.o.B().F() == null) {
                            TradeVerticalBaseFragment tradeVerticalBaseFragment2 = TradeVerticalBaseFragment.this;
                            tradeVerticalBaseFragment2.Wl(((TradeVerticalBasePresenter) tradeVerticalBaseFragment2.yh()).F0(), true, true);
                        } else {
                            ViewUtil.m(TradeVerticalBaseFragment.this.N0, false);
                            if (TextUtils.isEmpty(ht.o.B().F().getRoundLimitOrderPrice())) {
                                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).z1(true);
                            } else {
                                TradeVerticalBaseFragment.this.Wl(ht.o.B().F().getRoundLimitOrderPrice(), true, true);
                            }
                        }
                        z11 = false;
                    }
                    if (!a1.v().S(((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o0()) || !z11) {
                        TradeVerticalBaseFragment tradeVerticalBaseFragment3 = TradeVerticalBaseFragment.this;
                        tradeVerticalBaseFragment3.T0.setText(tradeVerticalBaseFragment3.getString(R.string.trade_asset_available));
                    } else {
                        TradeVerticalBaseFragment tradeVerticalBaseFragment4 = TradeVerticalBaseFragment.this;
                        tradeVerticalBaseFragment4.T0.setText(tradeVerticalBaseFragment4.getString(R.string.trade_prime_asset_available));
                    }
                    TradeVerticalBaseFragment.this.I3(z11);
                    ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).v1(z11);
                    TradeVerticalBaseFragment.this.G0.setBuy(z11);
                    ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).w0(tg.r.x().F0(), z11);
                    TradeVerticalBaseFragment.this.f82492a1.c(i11);
                    TradeVerticalBaseFragment.this.f82492a1.b(i11, 0.0f, 0);
                    TradeVerticalBaseFragment.this.f82326q.scrollTo(0, 0);
                    ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).C1();
                    if (((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).V0() == TradeType.MARGIN || ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).V0() == TradeType.SUPERMARGIN) {
                        TradeVerticalBaseFragment.this.Lk(ks.a.a().b());
                    }
                    TradeVerticalBaseFragment.this.Uk();
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    return;
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return TradeVerticalBaseFragment.this.Z0.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            tradeBuySellView.setTextSize(1, 14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) TradeVerticalBaseFragment.this.Z0.get(i11));
            tradeBuySellView.setNormalColor(ContextCompat.getColor(context, R.color.global_secondary_text_color));
            tradeBuySellView.setSelectedColor(ContextCompat.getColor(context, R.color.baseTextColor));
            if (i11 == 0) {
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg);
                }
            } else if (w.l()) {
                tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_right);
                tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg_right);
            } else {
                tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_right);
                tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg_right);
            }
            tradeBuySellView.setOnClickListener(new w3(this, i11));
            return tradeBuySellView;
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeVerticalBaseFragment.this.vi();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class o extends TradeBaseFragment.k {
        public o() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            if (!TradeVerticalBaseFragment.this.A0) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).d2(TradeVerticalBaseFragment.this.L0, editable, !TextUtils.isEmpty(editable));
            }
        }
    }

    public class p extends TradeBaseFragment.k {
        public p() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).h2(TradeVerticalBaseFragment.this.F0, editable, false);
        }
    }

    public class q extends TradeBaseFragment.k {
        public q() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).i2(TradeVerticalBaseFragment.this.f82510j1.getEditText(), editable);
        }
    }

    public class r implements TradeIceBergLayout.Callback {
        public r() {
        }

        public void afterTextChanged(EditText editText, String str) {
        }

        public int getTradePricePrecision() {
            return PrecisionUtil.C(((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o0());
        }

        public void onCheckedChange(CompoundButton compoundButton, boolean z11) {
            TradeVerticalBaseFragment.this.Uk();
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).W0() == 3) {
                if (((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).a1()) {
                    TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
                    if (tradeVerticalBaseFragment.f82311e0 == 1) {
                        tradeVerticalBaseFragment.Pk();
                    } else {
                        tradeVerticalBaseFragment.Ok();
                    }
                } else {
                    TradeVerticalBaseFragment tradeVerticalBaseFragment2 = TradeVerticalBaseFragment.this;
                    if (tradeVerticalBaseFragment2.f82312f0 == 1) {
                        tradeVerticalBaseFragment2.Pk();
                    } else {
                        tradeVerticalBaseFragment2.Ok();
                    }
                }
            }
            TradeVerticalBaseFragment.this.f82496c1.setProgress(0.0f);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Al() {
        this.f82504g1.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Bl() {
        this.f82504g1.setImageResource(R.drawable.trade_arrow_down_new);
        this.f82527v1 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Cl(View view) {
        if (((TradeVerticalBasePresenter) yh()).I0().x().size() > 0) {
            BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
            this.f82527v1 = bottomMenuFragment;
            bottomMenuFragment.setBottomMenuShowListener(new c3(this));
            this.f82527v1.setBottomMenuDismissListener(new b3(this));
            this.f82527v1.setMenuItems(this.f82528w1);
            this.f82527v1.show(getActivity().getFragmentManager(), TradeVerticalBaseFragment.class.getName());
        }
        this.f82335w.hideKeyboardLayout();
        HashMap hashMap = new HashMap(2);
        int i11 = j.f82541a[((TradeVerticalBasePresenter) yh()).V0().ordinal()];
        if (i11 == 2) {
            hashMap.put("trade_firtab_name", "lsolated");
        } else if (i11 != 3) {
            hashMap.put("trade_firtab_name", RankScreenBean.SCREEN_VALUE_SPOT);
        } else {
            hashMap.put("trade_firtab_name", FutureContractInfo.MARGIN_CROSS);
        }
        hashMap.put("trade_edition", "vertical");
        gs.g.i("App_trade_depth_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Dl(View view, boolean z11) {
        if (z11) {
            this.f82335w.showKeyBoardLayout(this.F0, 3);
            if (this.f82494b1.getText() == null || this.f82494b1.getText().length() == 0) {
                this.f82516m1.setVisibility(8);
            } else {
                this.f82516m1.setVisibility(0);
            }
        } else {
            this.f82516m1.setVisibility(8);
        }
        if (((TradeVerticalBasePresenter) yh()).W0() == 3) {
            Ul(this.K0.getInputPriceRl(), z11);
        } else {
            Ul(this.K0, z11);
        }
    }

    private void Ei() {
        bl();
        this.R0 = (TextView) this.f67460i.b(R.id.trade_type_tv);
        this.N1 = this.f67460i.b(R.id.order_type_ll);
        this.f82494b1 = (TextView) this.f67460i.b(R.id.price_convert_tv);
        this.f82496c1 = (MultiColorSeekBar) this.f67460i.b(R.id.trade_seekbar);
        this.f82498d1 = (TextView) this.f67460i.b(R.id.progress_leverage);
        this.f82500e1 = (TextView) this.f67460i.b(R.id.progress_leverage_label_tv);
        el();
        this.W1 = (TextView) this.f67460i.b(R.id.tv_loan_repay_type);
        this.V1 = this.f67460i.b(R.id.ll_loan_repay_type);
        this.X1 = this.f67460i.b(R.id.iv_loan_repay_guide);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void El(View view, boolean z11) {
        Ul(this.f82510j1, z11);
        if (!z11) {
            this.f82514l1.setVisibility(8);
        } else if (this.f82512k1.getText() == null || this.f82512k1.getText().length() == 0) {
            this.f82514l1.setVisibility(8);
        } else {
            this.f82514l1.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Fl(View view, boolean z11) {
        Ul(this.M0, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gl(View view, boolean z11) {
        Ul(this.N0, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hl(View view) {
        if (getActivity() != null) {
            this.V0 = new CommonListPopupDialog();
            y2();
            this.V0.setData(this.X0);
            this.V0.setDialogFragmentListener(new a());
            this.V0.setFollowViewWidth(true);
            this.V0.showAsDropDown(getActivity().getSupportFragmentManager(), this.N1);
        }
        this.f82335w.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public boolean Ik() {
        return isCanBeSeen() && !ConfigPreferences.c("user_config", "margin_guide", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Il(Void voidR) {
        if (this.f82330t0 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(ks.a.a().b()));
            rj.b bVar = this.f82330t0;
            bVar.I("sendBrrowAndRepayType(" + JSON.toJSONString(hashMap) + ")");
        }
        this.f82335w.hideKeyboardLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jl(Void voidR) {
        ContractGuideHelper.g(getActivity().getSupportFragmentManager(), ks.a.a().b());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kl(Void voidR) {
        String str;
        String str2;
        List<? extends c.a> list;
        if (tg.r.x().F0()) {
            wi();
            I3(((TradeVerticalBasePresenter) yh()).a1());
            if (((TradeVerticalBasePresenter) yh()).a1()) {
                ((TradeVerticalBasePresenter) yh()).x1(this.f82311e0);
            } else {
                ((TradeVerticalBasePresenter) yh()).x1(this.f82312f0);
            }
            if (((TradeVerticalBasePresenter) yh()).W0() == 1) {
                if (((TradeVerticalBasePresenter) yh()).a1()) {
                    str = this.G0.getAmountPrice();
                    str2 = this.G0.getVolumePrice();
                } else {
                    str2 = this.G0.getAmountPrice();
                    str = this.G0.getVolumePrice();
                }
                if (this.G0.isSelectedMarketAmount() && i6.m.a(this.G0.getAmountPrice()).compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{getString(R.string.n_exchange_order_list_amount)}));
                    return;
                } else if (!this.G0.isSelectedMarketAmount() && i6.m.a(this.G0.getVolumePrice()).compareTo(BigDecimal.ZERO) <= 0) {
                    HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{getString(R.string.n_exchange_order_list_volume)}));
                    return;
                }
            } else {
                str2 = getInputAmountText();
                str = "";
            }
            String str3 = str;
            String str4 = str2;
            double d11 = 0.0d;
            try {
                d11 = this.f82331u.f68641c.c().a();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            double d12 = d11;
            TradeVerticalBasePresenter tradeVerticalBasePresenter = (TradeVerticalBasePresenter) yh();
            String inputPriceText = getInputPriceText();
            boolean a12 = ((TradeVerticalBasePresenter) yh()).a1();
            String eg2 = eg();
            CouponReturn s22 = ((TradeVerticalBasePresenter) yh()).s2();
            if (((TradeVerticalBasePresenter) yh()).a1()) {
                list = this.f82331u.f68649k;
            } else {
                list = this.f82331u.f68648j;
            }
            tradeVerticalBasePresenter.Q1(inputPriceText, str3, str4, a12, eg2, s22, d12, list);
            if (TradeType.PRO == ((TradeVerticalBasePresenter) yh()).V0()) {
                try {
                    gs.g.l(((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).o0(), "Vertical", ((TradeVerticalBasePresenter) yh()).W0());
                } catch (Exception e11) {
                    i6.k.j("SensorsData", e11);
                }
            }
        } else {
            ((TradeVerticalBasePresenter) yh()).D1();
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Li(View view) {
        this.f82520o1 = new BottomMenuFragment();
        for (MenuItem next : this.f82521p1) {
            if (((TradeVerticalBasePresenter) yh()).t2() == next.getType()) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f82520o1.setMenuItems(this.f82521p1);
        this.f82520o1.show(getActivity().getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ll(int i11) {
        this.f82501e2.setChildType(i11);
        ((TradeVerticalBasePresenter) yh()).A1(i11);
        boolean z11 = true;
        this.J0.setText(i11 == 0 ? "GTC" : i11 == 1 ? "IOC" : "FOK");
        TradeIceBergLayout tradeIceBergLayout = this.H0;
        if (i11 != 0 || !com.huobi.trade.helper.m.e().c()) {
            z11 = false;
        }
        ViewUtil.m(tradeIceBergLayout, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ml(View view) {
        LimitChooseDialog vh2 = LimitChooseDialog.vh();
        Bundle bundle = new Bundle();
        bundle.putInt("selIndex", this.f82501e2.getChildType());
        vh2.setArguments(bundle);
        vh2.wh(new a3(this)).show(getChildFragmentManager(), "limitChoose");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nl(Object obj) {
        Tl();
    }

    /* access modifiers changed from: private */
    public void Ok() {
        this.F0.setText("");
        this.L0.setText("");
        ViewUtil.m(this.N0, true);
        this.K0.setHintText((int) R.string.trade_input_price);
        this.K0.setPriceInputType(3);
        this.K0.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        this.K0.setMarketPriceStyle(true);
        this.K0.setMarketPriceAreaPressStyle(false);
        this.K0.getInputPriceRl().setTag((Object) null);
        this.f82312f0 = 1;
        this.f82311e0 = 1;
        Kk(((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).W0(), ((TradeVerticalBasePresenter) yh()).o0());
        ((TradeVerticalBasePresenter) yh()).Z1();
        Uk();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Ol(View view, MotionEvent motionEvent) {
        z8(false, true);
        return false;
    }

    /* access modifiers changed from: private */
    public void Pk() {
        this.F0.setText("");
        this.L0.setText("");
        ViewUtil.m(this.N0, false);
        this.f82335w.hideKeyboardLayout();
        this.K0.setMarketPriceStyle(true);
        this.K0.setHintText((int) R.string.n_trade_current_best);
        this.K0.setPriceInputType(2);
        this.K0.getInputPriceRl().setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
        this.K0.setMarketPriceAreaPressStyle(true);
        this.K0.getInputPriceRl().setTag("PLAN_MARKET_VIEW_TAG");
        this.f82312f0 = 2;
        this.f82311e0 = 2;
        Kk(((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).W0(), ((TradeVerticalBasePresenter) yh()).o0());
        ((TradeVerticalBasePresenter) yh()).Z1();
        Uk();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Pl(Object obj) {
        if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            if (num.intValue() != ks.a.a().b()) {
                Lk(num.intValue());
            }
        }
    }

    private void Rk(boolean z11) {
        if (z11) {
            if (w.l()) {
                this.Q0.setBackgroundResource(R.drawable.trade_btn_sell_selector);
            } else {
                this.Q0.setBackgroundResource(R.drawable.trade_btn_buy_selector);
            }
        } else if (w.l()) {
            this.Q0.setBackgroundResource(R.drawable.trade_btn_buy_selector);
        } else {
            this.Q0.setBackgroundResource(R.drawable.trade_btn_sell_selector);
        }
        if (!tg.r.x().F0()) {
            this.Q0.setBackgroundResource(R.drawable.common_blue_5_radius_selector);
        }
        this.f82496c1.getConfigBuilder().colorConfig(getContext(), NightHelper.e().g(), z11).build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Rl() {
        com.huobi.trade.helper.o.e(this.O1, v3.f82727b);
    }

    private void Ul(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            Object tag = view.getTag();
            if ((tag instanceof String) && "PLAN_MARKET_VIEW_TAG".equals((String) tag)) {
                view.setBackgroundResource(R.drawable.custom_edittext_unenable_bg);
            }
        } else if (((TradeVerticalBasePresenter) yh()).a1()) {
            if (w.l()) {
                view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
            } else {
                view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
            }
        } else if (w.l()) {
            view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
        }
    }

    private String Yk() {
        int i11 = j.f82541a[((TradeVerticalBasePresenter) yh()).V0().ordinal()];
        if (i11 != 2) {
            return i11 != 3 ? RankScreenBean.SCREEN_VALUE_SPOT : FutureContractInfo.MARGIN_CROSS;
        }
        return FutureContractInfo.MARGIN_ISOLATED;
    }

    private void al() {
        this.C0 = (TextView) this.f67460i.b(R.id.tv_available_fund_value);
        this.B0 = (TextView) this.f67460i.b(R.id.available_fund_type_tv);
        this.Y1 = this.f67460i.b(R.id.available_open_rl);
        this.E0 = (TextView) this.f67460i.b(R.id.tv_available_open_value);
        this.D0 = (TextView) this.f67460i.b(R.id.available_open_type_tv);
    }

    private void bl() {
        this.Z0.add(getString(R.string.trade_buy_label));
        this.Z0.add(getString(R.string.trade_sell_label));
        this.f82492a1 = (MagicIndicator) this.f67460i.b(R.id.buy_shell_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new m());
        this.f82492a1.setNavigator(commonNavigator);
    }

    private void el() {
        TradePriceEditext tradePriceEditext = (TradePriceEditext) this.f67460i.b(R.id.limit_input_price);
        this.K0 = tradePriceEditext;
        this.F0 = tradePriceEditext.getEditText();
        this.G0 = (TradeMarketAmountVolume) this.f67460i.b(R.id.layout_amount_volume);
        TradeAmountEditext tradeAmountEditext = (TradeAmountEditext) this.f67460i.b(R.id.layout_input_amount);
        this.M0 = tradeAmountEditext;
        this.L0 = tradeAmountEditext.getEditText();
        TradeAmountEditext tradeAmountEditext2 = (TradeAmountEditext) this.f67460i.b(R.id.volume_et_layout);
        this.N0 = tradeAmountEditext2;
        this.O0 = tradeAmountEditext2.getEditText();
        this.Q0 = (TextView) this.f67460i.b(R.id.btn_trade_confirm);
        String o02 = ((TradeVerticalBasePresenter) yh()).o0();
        this.K0.setEditHint(R.string.trade_bid_price);
        this.K0.setLabel(SymbolUtil.c(o02, false));
        this.f82510j1.setLabel(SymbolUtil.c(o02, false));
    }

    private void gl() {
        this.L0.addTextChangedListener(new o());
        this.F0.addTextChangedListener(new p());
        this.f82510j1.getEditText().addTextChangedListener(new q());
        this.O0.addTextChangedListener(this.f82507h2);
        this.G0.getVolumeEt().addTextChangedListener(this.f82509i2);
        this.G0.getAmountEt().addTextChangedListener(this.f82511j2);
        this.H0.setCallback(new r());
        this.F0.setOnFocusChangeListener(new n2(this));
        this.f82510j1.getEditText().setOnFocusChangeListener(new p2(this));
        this.K0.getMarketPriceArea().setOnClickListener(new s());
        this.L0.setOnFocusChangeListener(new o2(this));
        this.O0.setOnFocusChangeListener(new q2(this));
        KeyboardTouchListener keyboardTouchListener = new KeyboardTouchListener(this.f82335w, 3, -1, this.f82513k2);
        this.L0.setOnTouchListener(keyboardTouchListener);
        this.O0.setOnTouchListener(keyboardTouchListener);
        this.G0.getVolumeEt().setOnTouchListener(keyboardTouchListener);
        this.G0.getAmountEt().setOnTouchListener(keyboardTouchListener);
        this.H0.getAmountEt().setOnTouchListener(keyboardTouchListener);
        this.F0.setOnTouchListener(keyboardTouchListener);
        this.f82510j1.getEditText().setOnTouchListener(keyboardTouchListener);
        this.R0.setOnClickListener(new r3(this));
        View view = this.V1;
        if (view != null) {
            dw.a.a(view).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new k3(this));
        }
        View view2 = this.X1;
        if (view2 != null) {
            dw.a.a(view2).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new j3(this));
        }
        dw.a.a(this.Q0).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new m3(this));
        this.f82496c1.setOnProgressChangedListener(new b());
    }

    private void hl() {
        this.P0 = (ImageView) this.f67460i.b(R.id.trend_change_iv);
        this.f82521p1.add(new MenuItem(0, getString(R.string.trade_trend_default), getString(R.string.trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f82517m2));
        List<MenuItem> list = this.f82521p1;
        String string = getString(R.string.trade_trend_buy);
        String string2 = getString(R.string.trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f82517m2));
        this.f82521p1.add(new MenuItem(2, getString(R.string.trade_trend_sell), getString(R.string.trade_trend_sell), menuItemStyle, this.f82517m2));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ll(View view) {
        if (this.B1.isChecked()) {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_buy_to_repay_open_hint)).q0(false).P0(getActivity().getString(R.string.n_known)).Q0(v2.f82726a).k0().show(getActivity().getSupportFragmentManager(), "");
        } else {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_buy_to_repay_hint)).q0(false).P0(getActivity().getString(R.string.n_known)).Q0(y2.f82747a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void nl(View view) {
        String str;
        if (((TradeVerticalBasePresenter) yh()).W0() == 1) {
            if (((TradeVerticalBasePresenter) yh()).a1()) {
                str = getString(R.string.n_trade_buy_auto_repay_not_support);
            } else {
                str = getString(R.string.n_trade_sell_auto_repay_not_support);
            }
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_login_tip)).C0(str).q0(false).P0(getActivity().getString(R.string.n_sure)).Q0(w2.f82732a).k0().show(getActivity().getSupportFragmentManager(), "");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        CommonSwitchButton commonSwitchButton = this.B1;
        commonSwitchButton.b(!commonSwitchButton.isChecked(), true);
        HashMap hashMap = new HashMap();
        if (this.B1.isChecked()) {
            hashMap.put("type", "open");
        } else {
            hashMap.put("type", "close");
        }
        String str2 = ((TradeVerticalBasePresenter) yh()).a1() ? "5972" : "5973";
        if (((TradeVerticalBasePresenter) yh()).V0() == TradeType.MARGIN) {
            is.a.j(str2, hashMap, "1000101");
        } else if (((TradeVerticalBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            is.a.j(str2, hashMap, "1000100");
        }
        Sl(((TradeVerticalBasePresenter) yh()).a1());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ol(View view) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_margin_repay_need_tip)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void pl(View view) {
        k0.S(getActivity(), ((TradeVerticalBasePresenter) yh()).o0(), ((TradeVerticalBasePresenter) yh()).a1(), TradeType.PRO);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void rl(HBDialogFragment hBDialogFragment) {
        if (k0.k() == TradeType.MARGIN) {
            k0.M(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
        } else {
            k0.R(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", ((TradeVerticalBasePresenter) yh()).o0());
        hashMap.put("mag_numb", this.Q1.getText().toString().replace("X", ""));
        gs.g.i("App_targe_switch_mag_click", hashMap);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void sl(View view) {
        if (!x.a()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_margin_alert_title)).C0(String.format(Locale.ENGLISH, getString(R.string.n_trade_margin_alert_content), new Object[]{this.Q1.getText()})).q0(false).x0(true).y0(getString(R.string.n_login_donot_prompt)).v0(t2.f82713a).P0(getString(R.string.n_known)).Q0(new u2(this)).j0().show(getActivity().getSupportFragmentManager(), "");
        } else {
            if (k0.k() == TradeType.MARGIN) {
                k0.M(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
            } else {
                k0.R(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("TransPair_current_id", ((TradeVerticalBasePresenter) yh()).o0());
            hashMap.put("mag_numb", this.Q1.getText().toString().replace("X", ""));
            gs.g.i("App_targe_switch_mag_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void tl(CouponReturn couponReturn) {
        ((TradeVerticalBasePresenter) yh()).y2(couponReturn);
        if (((TradeVerticalBasePresenter) yh()).a1()) {
            ((TradeVerticalBasePresenter) yh()).E2(((TradeVerticalBasePresenter) yh()).G0());
        } else {
            ((TradeVerticalBasePresenter) yh()).E2(((TradeVerticalBasePresenter) yh()).P0());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ul(Void voidR) {
        ArrayList<CouponReturn> f11 = ij.j.g().f("9", ((TradeVerticalBasePresenter) yh()).s2());
        if (f11 != null && f11.size() > 0) {
            CouponChooseDialog.th().wh("9", new z2(this)).show(getChildFragmentManager(), FirebaseAnalytics.Param.COUPON);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void vl(Void voidR) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_margin_loan_tip_new)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wl(Void voidR) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_margin_repay_tip_new)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xl(Void voidR) {
        if (((TradeVerticalBasePresenter) yh()).W0() == 0) {
            ContractGuideHelper.f(getActivity().getSupportFragmentManager(), 5, il(), Zk(((TradeVerticalBasePresenter) yh()).V0()));
        } else if (((TradeVerticalBasePresenter) yh()).W0() == 1) {
            ContractGuideHelper.f(getActivity().getSupportFragmentManager(), 6, il(), Zk(((TradeVerticalBasePresenter) yh()).V0()));
        } else if (((TradeVerticalBasePresenter) yh()).W0() == 2) {
            ContractGuideHelper.f(getActivity().getSupportFragmentManager(), 7, il(), Zk(((TradeVerticalBasePresenter) yh()).V0()));
        } else if (((TradeVerticalBasePresenter) yh()).W0() == 3) {
            ContractGuideHelper.f(getActivity().getSupportFragmentManager(), 8, il(), Zk(((TradeVerticalBasePresenter) yh()).V0()));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yl(Void voidR) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_margin_available_desc)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void zl(Void voidR) {
        new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_margin_total_available_alert)).P0(getString(R.string.n_known)).Q0(ad.b.f3517a).k0().show(getActivity().getSupportFragmentManager(), "");
    }

    public void A1(boolean z11) {
        String J02 = ((TradeVerticalBasePresenter) yh()).J0(this.f82510j1.getEditText().getText().toString());
        if (TextUtils.isEmpty(J02) || BigDecimal.ZERO.compareTo(new BigDecimal(J02)) == 0) {
            ViewUtil.m(this.f82514l1, false);
            this.f82512k1.setText((CharSequence) null);
        } else {
            this.f82512k1.setText(String.format(getString(R.string.balance_total_cny), new Object[]{J02}) + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US));
            ViewUtil.m(this.f82514l1, true);
        }
        if (!this.f82510j1.getEditText().isFocused()) {
            ViewUtil.m(this.f82514l1, false);
        }
    }

    public void Ah() {
        super.Ah();
        Observable<Void> a11 = dw.a.a(this.G1);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new f3(this));
        dw.a.a(this.H1).throttleFirst(300, timeUnit).subscribe(new l3(this));
        dw.a.a(this.f82518n1).throttleFirst(300, timeUnit).subscribe(new e3(this));
        this.P0.setOnClickListener(new m2(this));
        dw.a.a(this.T0).throttleFirst(300, timeUnit).subscribe(new h3(this));
        dw.a.a(this.U0).throttleFirst(300, timeUnit).subscribe(new g3(this));
        gl();
        cl();
        this.f82529x1.setOnClickListener(new n());
        this.C1.setOnClickListener(new u3(this));
        this.B1.setOnClickListener(new q3(this));
        this.E1.setOnClickListener(new s3(this));
        this.P1.setOnClickListener(new i3(this));
        this.Q1.setOnClickListener(new t3(this));
        dw.a.a(this.R1).throttleFirst(500, timeUnit).subscribe(new n3(this));
    }

    public void B(int i11) {
        this.f82492a1.c(i11);
        this.f82492a1.b(i11, 0.0f, 0);
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        if (getActivity() != null && list != null) {
            this.f82331u.setBuyList(list);
            if (!((TradeVerticalBasePresenter) yh()).a1()) {
                String valueOf = !list.isEmpty() ? String.valueOf(list.get(0).a()) : "";
                if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0())) {
                    Wl(valueOf, z11, true);
                }
            }
        }
    }

    public void D2() {
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).D2();
        }
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        if (getActivity() != null && list != null) {
            this.f82331u.setSellList(list);
            if (((TradeVerticalBasePresenter) yh()).a1()) {
                String valueOf = !list.isEmpty() ? String.valueOf(list.get(0).a()) : "";
                if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0())) {
                    Wl(valueOf, z11, false);
                }
            }
            if (z11 && (getParentFragment() instanceof TradeFragment)) {
                if (((TradePresenter) ((TradeFragment) getParentFragment()).yh()).b0() instanceof TradeVerticalSpotFragment) {
                    TradeTimeMonitorUtils.c(3);
                } else if (((TradePresenter) ((TradeFragment) getParentFragment()).yh()).b0() instanceof TradeVerticalMarginFragment) {
                    TradeTimeMonitorUtils.d(6);
                } else if (((TradePresenter) ((TradeFragment) getParentFragment()).yh()).b0() instanceof TradeVerticalSuperMarginFragment) {
                    TradeTimeMonitorUtils.d(6);
                }
            }
        }
    }

    public void E3(boolean z11) {
        boolean z12 = true;
        if (z11) {
            this.R0.setClickable(false);
            this.R0.setText(R.string.prime);
            this.R0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (((TradeVerticalBasePresenter) yh()).a1()) {
                this.T0.setText(getString(R.string.trade_prime_asset_available));
            } else {
                this.T0.setText(getString(R.string.trade_asset_available));
            }
        } else {
            this.R0.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_down, 0);
            this.R0.setClickable(true);
            Tk(((TradeVerticalBasePresenter) yh()).W0());
            this.T0.setText(getString(R.string.trade_asset_available));
        }
        TradeHeadView tradeHeadView = this.f82339y;
        if (tradeHeadView != null) {
            if (HBHTtoHTXManager.f83692a.f(((TradeVerticalBasePresenter) yh()).o0()) || z11) {
                z12 = false;
            }
            tradeHeadView.setTradePriceChangeTvVisible(z12);
        }
        Uk();
    }

    public void F(int i11, boolean z11) {
        if (getRootView() != null && getActivity() != null) {
            if (z11) {
                this.F0.setText("");
                this.f82510j1.getEditText().setText("");
            }
            this.L0.setText("");
            this.G0.reset();
            this.H0.reset();
            Ya("--", ((TradeVerticalBasePresenter) yh()).a1());
            u9("--", ((TradeVerticalBasePresenter) yh()).a1());
            this.f82496c1.setProgress(0.0f);
            this.f82335w.hideKeyboardLayout();
        }
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        super.H0(marketCurrentPriceItem);
        if (this.f82495b2 != null && Double.compare(marketCurrentPriceItem.a(), 0.0d) != 0) {
            this.f82495b2.vh(i6.m.w(marketCurrentPriceItem.a(), PrecisionUtil.e(((TradeVerticalBasePresenter) yh()).o0())), marketCurrentPriceItem.i());
        }
    }

    public void Hk(String str, String str2) {
        TradeTimeOrderFragment tradeTimeOrderFragment = this.f82495b2;
        if (tradeTimeOrderFragment != null) {
            tradeTimeOrderFragment.th(str, str2);
        }
    }

    public void I3(boolean z11) {
        this.F0.clearFocus();
        this.f82510j1.clearFocus();
        this.L0.clearFocus();
        this.O0.clearFocus();
        this.G0.clearInnerFocus();
        this.H0.clearInnerFocus();
        CustomBoardView customBoardView = this.f82335w;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    public void J(String str) {
    }

    public void Jk(String str, boolean z11) {
        if (z11) {
            this.K1.setText(SymbolUtil.c(str, !z11));
            this.L1.setText(SymbolUtil.c(str, z11));
            return;
        }
        this.K1.setText(SymbolUtil.c(str, !z11));
        this.L1.setText(SymbolUtil.c(str, z11));
    }

    public String Kc() {
        String trim = this.G0.getVolumeEt().getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public void Kk(boolean z11, int i11, String str) {
        this.K0.setLabel(SymbolUtil.c(str, false));
        this.N0.setLabel(SymbolUtil.c(str, false));
        this.G0.setAmountLabel(SymbolUtil.c(str, true));
        this.G0.setVolumeLabel(SymbolUtil.c(str, false));
        this.H0.setAmountLabel(SymbolUtil.c(str, true));
        if (z11 && (i11 == 1 || a1.v().Q(str))) {
            this.M0.setLabel(SymbolUtil.c(str, false));
            this.M0.setEditHint(R.string.n_exchange_order_list_volume);
        } else if (i11 != 3) {
            if (!a1.v().Q(str) || !z11) {
                this.M0.setLabel(SymbolUtil.c(str, true));
            } else {
                this.M0.setLabel(SymbolUtil.c(str, false));
            }
            this.M0.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (!z11) {
            this.M0.setLabel(SymbolUtil.c(str, true));
            this.M0.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (this.f82311e0 == 2) {
            this.M0.setLabel(SymbolUtil.c(str, false));
            this.M0.setEditHint(R.string.n_exchange_order_list_volume);
        } else {
            this.M0.setLabel(SymbolUtil.c(str, true));
            this.M0.setEditHint(R.string.n_exchange_order_list_amount);
        }
        Mk(z11, i11, str);
        this.B0.setText(SymbolUtil.c(str, !z11));
        this.D0.setText(SymbolUtil.c(str, !z11));
        Jk(str, z11);
    }

    public void Lk(int i11) {
        if (i11 < this.Y0.size()) {
            ks.a.a().c(i11);
            vf();
            if (i11 == 0) {
                ks.g.q(2);
                U1(2, false);
                return;
            }
            ks.g.q(1);
            U1(1, false);
        }
    }

    public void M4(String str) {
        this.G0.getVolumeEt().removeTextChangedListener(this.f82509i2);
        this.G0.updateTotalVolume(str);
        this.G0.getVolumeEt().addTextChangedListener(this.f82509i2);
    }

    public final void Mk(boolean z11, int i11, String str) {
        if (z11 && (i11 == 1 || a1.v().Q(str))) {
            this.f82500e1.setText(SymbolUtil.c(str, false));
        } else if (i11 != 3) {
            this.f82500e1.setText(SymbolUtil.c(str, true));
        } else if (!z11 || this.f82311e0 != 2) {
            this.f82500e1.setText(SymbolUtil.c(str, true));
        } else {
            this.f82500e1.setText(SymbolUtil.c(str, false));
        }
    }

    public void Nb(boolean z11) {
        if (z11 || Ik()) {
            int a11 = PixelUtils.a(4.0f);
            int i11 = -PixelUtils.a(10.0f);
            int i12 = -a11;
            com.huobi.trade.utils.a.j().r(getActivity(), new a.e[]{new a.e(this.S0, getString(R.string.n_spot_asset_transfer), getString(R.string.n_margin_guide_transfer_desc)).j(i11, a11, i11, a11).k(false), new a.e(this.f82526u1.getSubContainer(), getString(R.string.n_margin_guide_mode_title), getString(R.string.n_margin_guide_mode_desc)).j(i11, 0, i11, 0), new a.e(this.Z1, getString(R.string.n_margin_guide_trade_title), getString(R.string.n_margin_guide_trade_desc)).j(i11, -PixelUtils.a(25.0f), i11, i12), new a.e(this.f82526u1.getMarginRiskRate(), getString(R.string.n_margin_guide_risk_rate_title), getString(R.string.n_margin_guide_risk_rate_desc)).j(a11, a11, a11, a11), new a.e(this.J, getString(R.string.n_margin_guide_order_title), getString(R.string.n_margin_guide_order_desc)).j(i11, 0, i11, a11).k(false), new a.e(this.f82339y.getTradeRightPopIv(), getString(R.string.n_margin_guide_finish_title), getString(R.string.n_margin_guide_finish_desc)).j(0, i12, 0, i12)}, z11, new i());
        }
    }

    public void Nk(boolean z11) {
        if (z11) {
            int i11 = this.f82320m;
            if (i11 == 1) {
                if (this.B1.isChecked()) {
                    this.B1.b(false, false);
                    Sl(z11);
                }
            } else if (i11 == 2 || i11 == 3) {
                if (!this.B1.isChecked()) {
                    this.B1.b(true, false);
                    Sl(z11);
                }
            } else if (this.B1.isChecked()) {
                this.B1.b(false, false);
                Sl(z11);
            }
            this.C1.setText(R.string.n_trade_buy_to_repay);
            return;
        }
        int i12 = this.f82322n;
        if (i12 == 1) {
            if (this.B1.isChecked()) {
                this.B1.b(false, false);
                Sl(z11);
            }
        } else if (i12 == 2 || i12 == 3) {
            if (!this.B1.isChecked()) {
                this.B1.b(true, false);
                Sl(z11);
            }
        } else if (this.B1.isChecked()) {
            this.B1.b(false, false);
            Sl(z11);
        }
        this.C1.setText(R.string.n_trade_sell_to_repay);
    }

    public void Of() {
        x3.c(this);
        this.I0.setVisibility(0);
    }

    public void P4(String str) {
        this.G0.getAmountEt().removeTextChangedListener(this.f82511j2);
        this.G0.updateAmount(str);
        this.G0.getAmountEt().addTextChangedListener(this.f82511j2);
    }

    public void Qb(List<DepthItem> list, int i11) {
    }

    public void Qk(boolean z11) {
        this.B1.b(z11, false);
        HashMap hashMap = new HashMap();
        if (this.B1.isChecked()) {
            hashMap.put("type", "open");
        } else {
            hashMap.put("type", "close");
        }
        String str = ((TradeVerticalBasePresenter) yh()).a1() ? "5972" : "5973";
        if (((TradeVerticalBasePresenter) yh()).V0() == TradeType.MARGIN) {
            is.a.j(str, hashMap, "1000101");
        } else if (((TradeVerticalBasePresenter) yh()).V0() == TradeType.SUPERMARGIN) {
            is.a.j(str, hashMap, "1000100");
        }
    }

    public void R1(boolean z11, boolean z12) {
        this.Q0.setEnabled(z11);
    }

    public void Sk(boolean z11, int i11, String str) {
        String str2;
        if (tg.r.x().F0()) {
            String p11 = a1.v().p(str);
            if (z11) {
                str2 = String.format(getString(R.string.string_trade_bid), new Object[]{p11});
            } else {
                str2 = String.format(getString(R.string.string_trade_ask), new Object[]{p11});
            }
            this.Q0.setText(str2);
        } else {
            this.Q0.setText(R.string.n_trade_log_in_to_exchange);
        }
        Uk();
    }

    public void Sl(boolean z11) {
        if (ks.a.a().b() == 0) {
            this.f82530y1.setVisibility(8);
            this.D1.setVisibility(8);
            this.f82531z1.setVisibility(8);
            this.Y1.setVisibility(8);
        } else if (ks.a.a().b() == 1) {
            this.f82530y1.setVisibility(0);
            this.D1.setVisibility(8);
            this.f82531z1.setVisibility(8);
            this.Y1.setVisibility(0);
        } else if (ks.a.a().b() == 2) {
            this.f82530y1.setVisibility(8);
            this.D1.setVisibility(0);
            this.f82531z1.setVisibility(0);
            this.Y1.setVisibility(8);
        } else if (ks.a.a().b() == 3) {
            this.f82530y1.setVisibility(0);
            this.D1.setVisibility(0);
            this.f82531z1.setVisibility(0);
            this.Y1.setVisibility(0);
        }
        if (z11) {
            int b11 = ks.a.a().b();
            this.f82320m = b11;
            ks.g.s(b11);
            ks.g.r(this.f82320m);
        } else {
            int b12 = ks.a.a().b();
            this.f82322n = b12;
            ks.g.u(b12);
            ks.g.t(this.f82322n);
        }
        this.L0.setText("");
        this.f82496c1.setProgress(0.0f);
        I3(((TradeVerticalBasePresenter) yh()).a1());
        this.I1.setText("--");
        this.J1.setText("--");
        ((TradeVerticalBasePresenter) yh()).V1();
        ((TradeVerticalBasePresenter) yh()).U1();
        Jk(((TradeVerticalBasePresenter) yh()).o0(), ((TradeVerticalBasePresenter) yh()).a1());
        Uk();
    }

    public TradeRangeBarView T2() {
        return null;
    }

    public void Tk(int i11) {
        if (a1.v().Q(((TradeVerticalBasePresenter) yh()).o0())) {
            return;
        }
        if (i11 < this.X0.size()) {
            this.R0.setText(this.X0.get(i11).getText());
        } else if (i11 == 7) {
            this.R0.setText(getString(R.string.n_contract_trade_post_only));
        }
    }

    public final void Tl() {
        if (!com.hbg.module.libkt.base.ext.b.w(ij.j.g().f("9", (CouponReturn) null))) {
            int i11 = 0;
            boolean k11 = SP.k("couponChoose", "hasNewCoupon9", false);
            ImageView imageView = this.U1;
            if (!k11) {
                i11 = 8;
            }
            imageView.setVisibility(i11);
        }
    }

    public void U(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.F0.getHint()}));
    }

    public void U1(int i11, boolean z11) {
        this.L0.setText("");
        if (TradeType.MARGIN == ((TradeVerticalBasePresenter) yh()).V0() || TradeType.SUPERMARGIN == ((TradeVerticalBasePresenter) yh()).V0()) {
            if (i11 == 1) {
                if (((TradeVerticalBasePresenter) yh()).W0() == 3) {
                    ((TradeVerticalBasePresenter) yh()).x0(0, true);
                }
                Xl();
            } else {
                this.f82320m = 0;
                this.f82322n = 0;
                ks.g.s(0);
                ks.g.u(this.f82322n);
            }
        }
        Uk();
    }

    public void U2() {
    }

    public boolean U7() {
        return this.G0.isSelectedMarketAmount();
    }

    public void Uk() {
        this.Z1.getViewTreeObserver().removeOnPreDrawListener(this.f82519n2);
        this.Z1.getViewTreeObserver().addOnPreDrawListener(this.f82519n2);
    }

    public final TradeTimeInfo Vk() {
        TradeTimeInfo tradeTimeInfo = new TradeTimeInfo();
        tradeTimeInfo.setSymbol(((TradeVerticalBasePresenter) yh()).o0());
        tradeTimeInfo.setLastPriceNew(i6.m.w(((TradeVerticalBasePresenter) yh()).I0().B(), PrecisionUtil.e(((TradeVerticalBasePresenter) yh()).o0())));
        tradeTimeInfo.setRise(((TradeVerticalBasePresenter) yh()).I0().A());
        tradeTimeInfo.setAvailableOfBuy(this.f82497c2);
        tradeTimeInfo.setAvailableOfSell(this.f82499d2);
        try {
            tradeTimeInfo.setAccountId(String.valueOf(h2.t1().b1(TradeType.PRO, AccountType.spot.toString()).toBlocking().firstOrDefault(null)));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        ExchangeSettings b11 = ExchangeSettingsController.d().b(((TradeVerticalBasePresenter) yh()).o0());
        if (b11 != null) {
            tradeTimeInfo.setLessThan(b11.getLimitOrderMustLessThan());
            tradeTimeInfo.setGreaterThan(b11.getLimitOrderMustGreaterThan());
        }
        SymbolBean J = a1.v().J(((TradeVerticalBasePresenter) yh()).o0(), TradeType.PRO);
        if (J == null) {
            tradeTimeInfo.setPricePrecision(8);
            tradeTimeInfo.setAmountPrecision(8);
        } else {
            tradeTimeInfo.setPricePrecision(J.getTradePricePrecision());
            tradeTimeInfo.setAmountPrecision(J.getTradeAmountPrecision());
        }
        if (v0.b().a() != null) {
            tradeTimeInfo.setMaxTimeInterval(v0.b().a().getMaxInterval());
            tradeTimeInfo.setMinTimeInterval(v0.b().a().getMinInterval());
            tradeTimeInfo.setMaxPriceIntervalRatio(v0.b().a().getMaxOrderPriceRatio());
            tradeTimeInfo.setMinPriceIntervalRatio(v0.b().a().getMinOrderPriceRatio());
        }
        return tradeTimeInfo;
    }

    public void Vl(String str) {
        this.F0.setText(str);
        EditText editText = this.F0;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.F0);
    }

    public String Wf() {
        return this.H0.getAmountText();
    }

    public String Wk() {
        String str;
        String o02 = ((TradeVerticalBasePresenter) yh()).o0();
        boolean a12 = ((TradeVerticalBasePresenter) yh()).a1();
        if (a12) {
            int i11 = this.f82320m;
            if (i11 == 1) {
                str = SymbolUtil.c(o02, !a12);
            } else if (i11 == 2 || i11 == 3) {
                str = SymbolUtil.c(o02, a12);
            }
            return " " + str;
        }
        int i12 = this.f82322n;
        if (i12 == 1) {
            str = SymbolUtil.c(o02, !a12);
        } else if (i12 == 2 || i12 == 3) {
            str = SymbolUtil.c(o02, a12);
        }
        return " " + str;
        str = "";
        return " " + str;
    }

    public void Wl(String str, boolean z11, boolean z12) {
        if (((TradeVerticalBasePresenter) yh()).W0() != 1 && ((TradeVerticalBasePresenter) yh()).W0() != 2 && ((TradeVerticalBasePresenter) yh()).W0() != 3 && !TextUtils.isEmpty(str) && !((TradeVerticalBasePresenter) yh()).c1() && z11) {
            if (i6.m.a(str).compareTo(BigDecimal.ZERO) > 0) {
                this.F0.setText(i6.m.m(str, PrecisionUtil.e(((TradeVerticalBasePresenter) yh()).o0())));
                EditText editText = this.F0;
                editText.setSelection(editText.getText().length());
                ((TradeVerticalBasePresenter) yh()).z1(true);
                return;
            }
            this.F0.setText("");
            ((TradeVerticalBasePresenter) yh()).z1(true);
        }
    }

    public void X1(boolean z11) {
        if (!z11 || !((TradeVerticalBasePresenter) yh()).a1()) {
            this.f82313g0.setVisibility(8);
            return;
        }
        this.f82313g0.setVisibility(0);
        xi();
        oj();
    }

    public boolean X5() {
        CustomBoardView customBoardView = this.f82335w;
        if (customBoardView == null || !customBoardView.keyboardVisible()) {
            return false;
        }
        this.f82335w.hideKeyboardLayout();
        return true;
    }

    public final String Xk(int i11) {
        return i11 == 3 ? "trigger_order" : i11 == 0 ? "limit_order" : i11 == 2 ? "stop_limit_order" : i11 == 4 ? "twap_order" : i11 == 1 ? "market_order" : "";
    }

    public void Xl() {
        int b11 = ks.a.a().b();
        this.f82320m = b11;
        ks.g.r(b11);
        ks.g.s(this.f82320m);
        int b12 = ks.a.a().b();
        this.f82322n = b12;
        ks.g.t(b12);
        ks.g.u(this.f82322n);
    }

    public void Y2(DepthItem depthItem, String str) {
        if (i6.m.a0(str)) {
            str = ((TradeVerticalBasePresenter) yh()).I0().w(((TradeVerticalBasePresenter) yh()).o0(), Integer.valueOf(str).intValue() - 1);
            if (TextUtils.isEmpty(str)) {
                str = "--";
            }
        }
        this.f82502f1.setText(str);
    }

    public void Ya(String str, boolean z11) {
        this.I1.setText(str);
    }

    public void Yb(int i11, boolean z11, boolean z12) {
    }

    public void Yd(int i11, String str, int i12) {
        if (((TradeVerticalBasePresenter) yh()).W0() == 3) {
            i11 = 8;
        }
        if (this.R1.getVisibility() != 0 && i11 == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("trade_firtab_name", Yk());
            gs.g.i("App_trade_coupons_show", hashMap);
        }
        this.R1.setVisibility(i11);
        if (i11 == 0) {
            Tl();
            this.T1.setText(str);
        }
        Uk();
    }

    public final String Zk(TradeType tradeType) {
        if (tradeType == TradeType.PRO) {
            return RankScreenBean.SCREEN_VALUE_SPOT;
        }
        if (tradeType == TradeType.MARGIN) {
            return FutureContractInfo.MARGIN_ISOLATED;
        }
        return tradeType == TradeType.SUPERMARGIN ? FutureContractInfo.MARGIN_CROSS : "";
    }

    public void b3() {
        this.C0.setText("--");
        this.E0.setText("--");
        TextView textView = this.F1;
        textView.setText("--" + Wk());
        TextView textView2 = this.F1;
        textView2.setPaintFlags(textView2.getPaintFlags() & -9);
    }

    public void c(int i11) {
        if (i11 == 0) {
            if (w.l()) {
                this.P0.setImageResource(R.drawable.trade_trend_default_green_red);
            } else {
                this.P0.setImageResource(R.drawable.trade_trend_default_red_green);
            }
            this.f82331u.c(0);
        } else if (i11 == 1) {
            if (w.l()) {
                this.P0.setImageResource(R.drawable.trade_trend_red);
            } else {
                this.P0.setImageResource(R.drawable.trade_trend_green);
            }
            this.f82331u.c(1);
        } else if (i11 == 2) {
            if (w.l()) {
                this.P0.setImageResource(R.drawable.trade_trend_green);
            } else {
                this.P0.setImageResource(R.drawable.trade_trend_red);
            }
            this.f82331u.c(2);
        }
    }

    public void c0(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.L0.getHint()}));
    }

    public final void cl() {
        this.f82506h1.setOnClickListener(new x2(this));
    }

    public void d(boolean z11) {
        super.d(z11);
        this.K0.setBtnClickEnable(z11);
        this.f82510j1.setBtnClickEnable(z11);
        this.M0.setBtnClickEnable(z11);
        this.N0.setBtnClickEnable(z11);
        if (!z11) {
            this.C0.setText("--");
            this.E0.setText("--");
            this.F1.setText("--");
            TextView textView = this.I1;
            textView.setText("--" + Wk());
            TextView textView2 = this.J1;
            textView2.setText("--" + Wk());
            TextView textView3 = this.F1;
            textView3.setPaintFlags(textView3.getPaintFlags() & -9);
            this.R1.setVisibility(8);
            Uk();
        }
    }

    public void d2(int i11) {
        this.K0.setLength(i11);
        this.f82510j1.setLength(i11);
    }

    public String d8() {
        String trim = this.G0.getAmountEt().getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public MultiColorSeekBar dd() {
        return this.f82496c1;
    }

    public final void dl() {
        TextView textView = (TextView) this.f67460i.b(R.id.vertical_depth_tv);
        this.f82502f1 = textView;
        textView.setText("--");
        this.f82504g1 = (ImageView) this.f67460i.b(R.id.vertical_depth_arrow_iv);
        this.f82506h1 = this.f67460i.b(R.id.depth_ll);
    }

    public String eg() {
        String trim = this.f82510j1.getEditText().getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public void fl() {
        this.Y0.clear();
        this.Y0.add(new CommonPopListItem(0, getString(R.string.n_trade_margin_manual), this.f82505g2));
        this.Y0.add(new CommonPopListItem(1, getString(R.string.n_trade_margin_auto_borrow), this.f82505g2));
        this.Y0.add(new CommonPopListItem(2, getString(R.string.n_trade_margin_auto_repay), this.f82505g2));
        this.Y0.add(new CommonPopListItem(3, getString(R.string.n_trade_automatic_loan_repay), this.f82505g2));
    }

    public String getInputAmountText() {
        String trim = this.L0.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public String getInputPriceText() {
        String trim = this.F0.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public void h2() {
        this.f82331u.i();
    }

    public void i3(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.f82510j1.getEditText().getHint()}));
    }

    public boolean il() {
        return ((TradeVerticalBasePresenter) yh()).V0() == TradeType.MARGIN || ((TradeVerticalBasePresenter) yh()).V0() == TradeType.SUPERMARGIN;
    }

    public void initViews() {
        super.initViews();
        this.f82508i1 = this.f67460i.b(R.id.stop_input_price_layout);
        this.f82510j1 = (TradePriceEditext) this.f67460i.b(R.id.stop_input_price_et);
        this.f82512k1 = (TextView) this.f67460i.b(R.id.price_convert_stop_tv);
        this.f82518n1 = this.f67460i.b(R.id.iv_contract_guide);
        this.S0 = this.f67460i.b(R.id.asset_head_rl);
        this.T0 = (UnderLineTextView) this.f67460i.b(R.id.trade_spot_label1);
        this.U0 = (UnderLineTextView) this.f67460i.b(R.id.trade_spot_label2);
        this.f82514l1 = (LinearLayout) this.f67460i.b(R.id.trade_price_stop_convert_container);
        this.f82516m1 = (LinearLayout) this.f67460i.b(R.id.trade_price_limit_convert_container);
        this.f82526u1 = (TradeMarginRiskRateViewNew) this.f67460i.b(R.id.margin_risk_rate_view);
        this.H0 = (TradeIceBergLayout) this.f67460i.b(R.id.layout_iceberg);
        this.I0 = (LinearLayout) this.f67460i.b(R.id.llLimitChoose);
        this.J0 = (TextView) this.f67460i.b(R.id.tvLimitTitle);
        this.I0.setOnClickListener(new p3(this));
        dl();
        hl();
        Ei();
        al();
        fl();
        this.f82522q1 = (LinearLayout) this.f67460i.b(R.id.stop_trade_ll);
        this.f82523r1 = (ImageView) this.f67460i.b(R.id.trade_mask_iv);
        this.f82524s1 = (TextView) this.f67460i.b(R.id.trade_mask_title_tv);
        this.f82525t1 = (TextView) this.f67460i.b(R.id.trade_suspend_instruction_tv);
        this.f82529x1 = (LinearLayout) this.f67460i.b(R.id.trade_transfer_area);
        this.f82530y1 = this.f67460i.b(R.id.current_loan_repay_container);
        this.f82531z1 = this.f67460i.b(R.id.current_repay_container);
        this.G1 = (UnderLineTextView) this.f67460i.b(R.id.current_loan_repay_label_tv);
        this.H1 = (UnderLineTextView) this.f67460i.b(R.id.current_repay_label_tv);
        this.I1 = (TextView) this.f67460i.b(R.id.current_loan_amount_tv);
        this.J1 = (TextView) this.f67460i.b(R.id.current_repay_amount_tv);
        this.F1 = (TextView) this.f67460i.b(R.id.need_to_repay_amount_tv);
        this.K1 = (TextView) this.f67460i.b(R.id.current_loan_amount_unit_tv);
        this.L1 = (TextView) this.f67460i.b(R.id.current_repay_amount_unit_tv);
        this.A1 = this.f67460i.b(R.id.buy_auto_repay_container);
        this.B1 = (CommonSwitchButton) this.f67460i.b(R.id.auto_repay_switch);
        this.C1 = (TextView) this.f67460i.b(R.id.auto_repay_label_tv);
        this.D1 = this.f67460i.b(R.id.need_to_repay_container);
        this.E1 = (UnderLineTextView) this.f67460i.b(R.id.need_to_repay_label_tv);
        this.M1 = new HuobiKeyboardHelper().attach(getActivity());
        this.O1 = this.f67460i.b(R.id.lever_change_ll);
        this.P1 = (TextView) this.f67460i.b(R.id.spot_lever_tv);
        this.Q1 = (TextView) this.f67460i.b(R.id.margin_change_lever_tv);
        this.R1 = this.f67460i.b(R.id.coupon_rl);
        this.S1 = (TextView) this.f67460i.b(R.id.coupon_label_tv);
        this.T1 = (TextView) this.f67460i.b(R.id.coupon_value_tv);
        this.U1 = (ImageView) this.f67460i.b(R.id.coupon_red_point);
        this.Z1 = this.f67460i.b(R.id.left_ll);
        we.b.l("tradeCouponPoint", Object.class).observe(this, new s2(this));
        Uk();
    }

    public void l(BigDecimal bigDecimal) {
        String str = "";
        if (bigDecimal == null) {
            if (this.N0.getVisibility() == 0) {
                this.O0.removeTextChangedListener(this.f82507h2);
                this.O0.setText(str);
                this.O0.addTextChangedListener(this.f82507h2);
            }
        } else if (this.N0.getVisibility() == 0) {
            this.O0.removeTextChangedListener(this.f82507h2);
            if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                this.O0.setText(str);
            } else {
                this.O0.setText(bigDecimal.toPlainString());
            }
            this.O0.addTextChangedListener(this.f82507h2);
        }
        if (TextUtils.isEmpty(this.O0.getText())) {
            this.O0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.O0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
        if (!this.A0) {
            if (!(bigDecimal == null || bigDecimal.compareTo(BigDecimal.ZERO) == 0)) {
                str = bigDecimal.toPlainString();
            }
            M4(str);
        }
    }

    public void m2(List<DepthItem> list, int i11) {
        int size = list.size();
        this.f82528w1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String w11 = ((TradeVerticalBasePresenter) yh()).I0().w(((TradeVerticalBasePresenter) yh()).o0(), i12);
            if (TextUtils.isEmpty(w11)) {
                w11 = "--";
            }
            if (i11 == i12) {
                this.f82528w1.add(new MenuItem("", w11, MenuItem.MenuItemStyle.STRESS, this.f82515l2));
            } else {
                this.f82528w1.add(new MenuItem("", w11, MenuItem.MenuItemStyle.COMMON, this.f82515l2));
            }
        }
    }

    public void n(boolean z11, int i11, String str) {
        int i12;
        Kk(z11, i11, str);
        Sk(z11, i11, str);
        Nk(z11);
        Rk(z11);
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).Th(str);
        }
        if (i11 == 3) {
            int i13 = this.f82311e0;
            if (i13 == 2 || (i12 = this.f82312f0) == 2) {
                Pk();
            } else if (i13 == 1 || i12 == 1) {
                Ok();
            }
        }
    }

    public void n0() {
        this.f82492a1.getNavigator().notifyDataSetChanged();
    }

    public void n1(boolean z11) {
        String J02 = ((TradeVerticalBasePresenter) yh()).J0(this.F0.getText().toString());
        if (TextUtils.isEmpty(J02) || BigDecimal.ZERO.compareTo(new BigDecimal(J02)) == 0) {
            ViewUtil.m(this.f82516m1, false);
            this.f82494b1.setText((CharSequence) null);
        } else {
            this.f82494b1.setText(String.format(getString(R.string.balance_total_cny), new Object[]{J02}) + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US));
            ViewUtil.m(this.f82516m1, true);
        }
        if (!this.F0.isFocused()) {
            ViewUtil.m(this.f82516m1, false);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean a12 = ((TradeVerticalBasePresenter) yh()).a1();
        boolean z11 = !a12;
        this.f82492a1.b(z11 ? 1 : 0, 0.0f, 0);
        this.f82492a1.c(z11);
        this.G0.initDataAndTab(a12, ((TradeVerticalBasePresenter) yh()).W0(), ((TradeVerticalBasePresenter) yh()).V0());
        this.H0.setParams(((TradeVerticalBasePresenter) yh()).W0(), ((TradeVerticalBasePresenter) yh()).V0());
    }

    public void p(int i11, String str) {
        this.Q1.setVisibility(i11);
        this.P1.setVisibility(i11);
        this.O1.setVisibility(i11);
        this.Q1.setText(str);
        if (i11 == 0) {
            this.O1.post(new d3(this));
        }
    }

    public void setInputAmountText(String str) {
        if (i6.m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.L0.setText("");
        } else {
            this.L0.setText(str);
            EditText editText = this.L0;
            editText.setSelection(editText.getText().length());
        }
        if (TextUtils.isEmpty(this.L0.getText())) {
            this.L0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.L0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
        if (this.G0.getVisibility() != 0) {
            return;
        }
        if (((TradeVerticalBasePresenter) yh()).a1()) {
            this.G0.updateTotalVolume(str);
        } else {
            this.G0.updateAmount(str);
        }
    }

    public void setProgressText(String str) {
        this.f82498d1.setText(str);
    }

    public void t(SymbolBean symbolBean) {
        if (!MarginBalanceQueryData.STATE_FL_SYS.equals(this.f82522q1.getTag(R.id.item_data1))) {
            if (symbolBean == null) {
                this.f82522q1.setVisibility(8);
            } else if (SymbolBean.PRE_ONLINE.equals(symbolBean.getState())) {
                if (symbolBean.isWhiteEnabled()) {
                    this.f82522q1.setVisibility(8);
                    return;
                }
                this.f82523r1.setImageResource(R.drawable.exchange_forbiden_waiting_image);
                this.f82524s1.setText(R.string.trade_pre_online);
                this.f82525t1.setVisibility(8);
                this.f82522q1.setVisibility(0);
            } else if (SymbolBean.SUSPEND.equals(symbolBean.getState())) {
                if (symbolBean.isWhiteEnabled()) {
                    this.f82522q1.setVisibility(8);
                    return;
                }
                this.f82523r1.setImageResource(R.drawable.exchange_forbiden_image);
                this.f82524s1.setText(R.string.trade_suspend);
                this.f82525t1.setText(symbolBean.getSuspendDesc());
                this.f82525t1.setVisibility(0);
                this.f82522q1.setVisibility(0);
            } else if (SymbolBean.TRANSFER_BOARD.equals(symbolBean.getState())) {
                this.f82523r1.setImageResource(R.drawable.exchange_transfer_type_image);
                this.f82524s1.setText(R.string.trade_transfer_board);
                this.f82525t1.setText(symbolBean.getTransferBoardDesc());
                this.f82525t1.setVisibility(0);
                this.f82522q1.setVisibility(0);
            } else if (SymbolBean.FUSE.equals(symbolBean.getState())) {
                this.f82523r1.setImageResource(R.drawable.exchange_forbiden_image);
                this.f82524s1.setText(R.string.trade_fuse_hint);
                this.f82525t1.setVisibility(8);
                this.f82522q1.setVisibility(0);
            } else {
                this.f82522q1.setVisibility(8);
            }
        }
    }

    public void t4() {
        CouponFragment couponFragment = this.f82493a2;
        if (couponFragment != null) {
            couponFragment.dismiss();
        }
        TradeTimeOrderFragment tradeTimeOrderFragment = this.f82495b2;
        if (tradeTimeOrderFragment != null) {
            tradeTimeOrderFragment.dismiss();
        }
    }

    public void u3(String str) {
        int W02 = ((TradeVerticalBasePresenter) yh()).W0();
        if (W02 == 0 || W02 == 2) {
            if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0()) || !ht.o.B().P()) {
                Vl(str);
            }
        } else if (W02 == 3) {
            if (1 != this.f82311e0 && 1 != this.f82312f0) {
                return;
            }
            if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0()) || !ht.o.B().P()) {
                Vl(str);
            }
        }
    }

    public void u9(String str, boolean z11) {
        this.J1.setText(str);
    }

    public void v(int i11, int i12, boolean z11, String str) {
        if (i12 == 3) {
            this.f82311e0 = 1;
            this.f82312f0 = 1;
            F(i12, true);
        }
        if (i12 == 1 || this.F1.getText().toString().contains("--")) {
            TextView textView = this.F1;
            textView.setPaintFlags(textView.getPaintFlags() & -9);
        } else {
            TextView textView2 = this.F1;
            textView2.setPaintFlags(textView2.getPaintFlags() | 8);
        }
        ViewUtil.m(this.M0, true);
        ViewUtil.m(this.G0, false);
        ViewUtil.m(this.H0, false);
        if (i12 == 1) {
            ViewUtil.m(this.f82494b1, false);
            ViewUtil.m(this.N0, false);
            ViewUtil.m(this.G0, true);
            ViewUtil.m(this.M0, false);
            this.K0.setMarketPriceStyle(false);
            this.K0.setHintText((int) R.string.trade_market_input_price_hint);
            this.K0.setPriceInputType(2);
            this.K0.setBackgroundResource(R.drawable.custom_edittext_unable_bg);
            this.f82510j1.setViewVisibilityAndEnable(0, true);
            this.f82510j1.setLabelVisibility(8);
            this.f82510j1.setMarketPriceStyle(false);
            this.F0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
            F(i12, true);
            ViewUtil.m(this.f82508i1, false);
        } else if (i12 == 2) {
            ViewUtil.m(this.N0, true);
            ViewUtil.m(this.f82494b1, true);
            this.K0.setHintText((int) R.string.trade_input_price);
            this.K0.setPriceInputType(3);
            this.K0.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.K0.setMarketPriceStyle(false);
            this.f82510j1.setViewVisibilityAndEnable(0, true);
            this.f82510j1.setLabelVisibility(8);
            this.f82510j1.setMarketPriceStyle(false);
            F(i12, true);
            ViewUtil.m(this.f82508i1, true);
        } else if (i12 == 3) {
            ViewUtil.m(this.N0, true);
            ViewUtil.m(this.f82494b1, true);
            Ok();
            this.f82510j1.setViewVisibilityAndEnable(8, true);
            this.f82510j1.setLabelVisibility(8);
            F(i12, true);
            ViewUtil.m(this.f82508i1, true);
        } else {
            ViewUtil.m(this.f82494b1, true);
            boolean c11 = com.huobi.trade.helper.m.e().c();
            if ((i12 == 0 && (((TradeVerticalBasePresenter) yh()).K0() == 1 || ((TradeVerticalBasePresenter) yh()).K0() == 2)) || i12 == 7) {
                c11 = false;
            }
            ViewUtil.m(this.H0, c11);
            if (((TradeVerticalBasePresenter) yh()).a1()) {
                ((TradeVerticalBasePresenter) yh()).z1(false);
                Wl(((TradeVerticalBasePresenter) yh()).O0(), true, false);
            } else {
                ((TradeVerticalBasePresenter) yh()).z1(false);
                Wl(((TradeVerticalBasePresenter) yh()).F0(), true, true);
            }
            ViewUtil.m(this.N0, true);
            this.K0.setHintText((int) R.string.trade_input_price);
            this.K0.setPriceInputType(1);
            this.K0.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
            this.K0.setMarketPriceStyle(false);
            this.f82510j1.setViewVisibilityAndEnable(0, true);
            this.f82510j1.setLabelVisibility(8);
            this.f82510j1.setMarketPriceStyle(false);
            F(i12, false);
            ViewUtil.m(this.f82508i1, false);
        }
        if (a1.v().Q(str) && z11) {
            ViewUtil.m(this.N0, false);
        }
        this.G0.setParams(i12, ((TradeVerticalBasePresenter) yh()).V0());
        this.H0.setParams(i12, ((TradeVerticalBasePresenter) yh()).V0());
        Tk(i12);
        n(z11, i12, str);
        Uk();
    }

    public void vf() {
        TextView textView;
        if (ks.a.a().b() < this.Y0.size() && (textView = this.W1) != null) {
            textView.setText(this.Y0.get(ks.a.a().b()).getText());
        }
        if (ks.a.a().b() == 1) {
            Qk(false);
        } else if (ks.a.a().b() == 2 || ks.a.a().b() == 3) {
            Qk(true);
        }
        Sl(((TradeVerticalBasePresenter) yh()).a1());
        Uk();
    }

    public void w3() {
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).w3();
        }
    }

    public void y2() {
        this.X0.clear();
        boolean z11 = ((TradeVerticalBasePresenter) yh()).V0() == TradeType.SUPERMARGIN || ((TradeVerticalBasePresenter) yh()).V0() == TradeType.MARGIN;
        if (this.f82501e2 == null) {
            this.f82501e2 = new CommonPopListItem(0, getString(R.string.n_contract_trade_order_type_limit), this.f82503f2);
        }
        if (z11 && ks.g.j()) {
            this.X0.add(this.f82501e2);
            this.X0.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f82503f2));
            this.X0.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f82503f2));
            this.X0.add(new CommonPopListItem(7, getString(R.string.n_contract_trade_post_only), this.f82503f2));
        } else if (((TradeVerticalBasePresenter) yh()).d1()) {
            this.X0.add(new CommonPopListItem(0, getString(R.string.n_contract_trade_order_type_limit), this.f82503f2));
            this.X0.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f82503f2));
            this.X0.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f82503f2));
        } else {
            this.X0.add(this.f82501e2);
            this.X0.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f82503f2));
            this.X0.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f82503f2));
            this.X0.add(new CommonPopListItem(3, getString(R.string.n_exchange_plan_entrusts), this.f82503f2));
            if (v0.b().c(!il())) {
                this.X0.add(new CommonPopListItem(4, getString(R.string.n_exchange_timing_deal), this.f82503f2));
            }
            this.X0.add(new CommonPopListItem(7, getString(R.string.n_contract_trade_post_only), this.f82503f2));
        }
    }

    public void z(boolean z11, int i11) {
        if (i11 == 3 && tg.r.x().F0()) {
            this.f82510j1.setReduceEnable(z11);
            this.f82510j1.setReduceLongClickable(z11);
        }
        if (i11 == 1 && tg.r.x().F0()) {
            this.K0.setReduceEnable(z11);
            this.K0.setReduceLongClickable(z11);
        }
    }

    public boolean z6() {
        return this.H0.isChecked() && this.H0.getVisibility() == 0;
    }

    public void zj() {
        super.zj();
        this.f82330t0.u("brrowAndRepayTypePop.brrowAndRepayType", new o3(this));
    }
}
