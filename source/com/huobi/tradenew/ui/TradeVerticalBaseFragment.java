package com.huobi.tradenew.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import cd.o0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.CurrencyAsset;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.hbg.lib.widgets.anim.CommonAnimateUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.homemarket.helper.AppBarStateChangeListener;
import com.huobi.margin.entity.MarginBalanceQueryData;
import com.huobi.trade.bean.DepthItem;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.helper.o;
import com.huobi.trade.ui.TradeFragment;
import com.huobi.tradenew.presenter.TradeVerticalBasePresenter;
import com.huobi.tradenew.prime.helper.TradeMarginHelper;
import com.huobi.tradenew.ui.TradeBaseFragment;
import com.huobi.tradenew.ui.kline.KlineView;
import com.huobi.tradenew.ui.n3;
import com.huobi.utils.SymbolUtil;
import com.huobi.utils.k0;
import com.huobi.view.FontIconTextView;
import com.huobi.view.TradeAmountEditext;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.TradePriceEditext;
import com.huobi.view.TradeRangeBarView;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.bubbleseekbar.BubbleSeekBar;
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.keyboard.KeyboardTouchListener;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import qt.r;
import rx.Observable;

public abstract class TradeVerticalBaseFragment<P extends TradeVerticalBasePresenter<V>, V extends n3> extends TradeBaseFragment<P, V> implements n3, View.OnClickListener {
    public RelativeLayout A0;
    public View A1;
    public ImageView B0;
    public TextView B1;
    public EditText C0;
    public FontIconTextView C1;
    public TradePriceEditext D0;
    public TextView D1;
    public EditText E0;
    public TextView E1;
    public TradeAmountEditext F0;
    public TextView F1;
    public TextView G0;
    public TextView G1;
    public RelativeLayout H0;
    public HuobiKeyboardHelper H1;
    public TradeAmountEditext I0;
    public View I1;
    public EditText J0;
    public View J1;
    public ImageView K0;
    public TextView K1;
    public TextView L0;
    public TextView L1;
    public TextView M0;
    public boolean M1 = false;
    public TextView N0;
    public BigDecimal N1 = null;
    public TextView O0;
    public boolean O1;
    public TextView P0;
    public int P1 = 220;
    public ImageView Q0;
    public ViewGroup Q1;
    public View R0;
    public ViewGroup R1;
    public KlineView S0;
    public ViewGroup S1;
    public View T0;
    public TextView T1;
    public TextView U0;
    public AppBarLayout U1;
    public TextView V0;
    public LinearLayout V1;
    public TextView W0;
    public ViewGroup W1;
    public CommonListPopupDialog X0 = new CommonListPopupDialog();
    public TextView X1;
    public List<CommonPopListItem> Y0 = new ArrayList();
    public TextView Y1;
    public List<String> Z0 = new ArrayList();
    public View Z1;

    /* renamed from: a1  reason: collision with root package name */
    public MagicIndicator f83262a1;

    /* renamed from: a2  reason: collision with root package name */
    public int f83263a2 = 0;

    /* renamed from: b1  reason: collision with root package name */
    public TextView f83264b1;

    /* renamed from: b2  reason: collision with root package name */
    public CommonPopListItem.a f83265b2 = new g();

    /* renamed from: c1  reason: collision with root package name */
    public TradeRangeBarView f83266c1;

    /* renamed from: c2  reason: collision with root package name */
    public TradeBaseFragment<P, V>.k f83267c2 = new c();

    /* renamed from: d1  reason: collision with root package name */
    public MultiColorSeekBar f83268d1;

    /* renamed from: d2  reason: collision with root package name */
    public View.OnTouchListener f83269d2 = new s2(this);

    /* renamed from: e1  reason: collision with root package name */
    public TextView f83270e1;

    /* renamed from: e2  reason: collision with root package name */
    public MenuItemOnClickListener f83271e2 = new d();

    /* renamed from: f1  reason: collision with root package name */
    public TextView f83272f1;

    /* renamed from: f2  reason: collision with root package name */
    public MenuItemOnClickListener f83273f2 = new e();

    /* renamed from: g1  reason: collision with root package name */
    public TextView f83274g1;

    /* renamed from: h1  reason: collision with root package name */
    public ImageView f83275h1;

    /* renamed from: i1  reason: collision with root package name */
    public View f83276i1;

    /* renamed from: j1  reason: collision with root package name */
    public View f83277j1;

    /* renamed from: k1  reason: collision with root package name */
    public TradePriceEditext f83278k1;

    /* renamed from: l1  reason: collision with root package name */
    public TextView f83279l1;

    /* renamed from: m1  reason: collision with root package name */
    public View f83280m1;

    /* renamed from: n1  reason: collision with root package name */
    public BottomMenuFragment f83281n1 = new BottomMenuFragment();

    /* renamed from: o1  reason: collision with root package name */
    public List<MenuItem> f83282o1 = new ArrayList();

    /* renamed from: p1  reason: collision with root package name */
    public LinearLayout f83283p1;

    /* renamed from: q1  reason: collision with root package name */
    public ImageView f83284q1;

    /* renamed from: r1  reason: collision with root package name */
    public TextView f83285r1;

    /* renamed from: s1  reason: collision with root package name */
    public TextView f83286s1;

    /* renamed from: t1  reason: collision with root package name */
    public BottomMenuFragment f83287t1 = new BottomMenuFragment();

    /* renamed from: u1  reason: collision with root package name */
    public List<MenuItem> f83288u1 = new ArrayList();

    /* renamed from: v0  reason: collision with root package name */
    public boolean f83289v0;

    /* renamed from: v1  reason: collision with root package name */
    public LinearLayout f83290v1;

    /* renamed from: w0  reason: collision with root package name */
    public TextView f83291w0;

    /* renamed from: w1  reason: collision with root package name */
    public View f83292w1;

    /* renamed from: x0  reason: collision with root package name */
    public TextView f83293x0;

    /* renamed from: x1  reason: collision with root package name */
    public View f83294x1;

    /* renamed from: y0  reason: collision with root package name */
    public TextView f83295y0;

    /* renamed from: y1  reason: collision with root package name */
    public CommonSwitchButton f83296y1;

    /* renamed from: z0  reason: collision with root package name */
    public TextView f83297z0;

    /* renamed from: z1  reason: collision with root package name */
    public TextView f83298z1;

    public class a implements MultiColorSeekBar.OnProgressChangedListener {
        public a() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(false);
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(false);
            }
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(z11);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).p2(i11, z11);
            if (z11) {
                TradeVerticalBaseFragment.this.H1.hideKeyboard();
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(false);
            }
        }
    }

    public class b implements BubbleSeekBar.OnProgressChangedListener {
        public b() {
        }

        public void getProgressOnActionUp(BubbleSeekBar bubbleSeekBar, int i11, float f11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(false);
        }

        public void getProgressOnFinally(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(false);
            }
        }

        public void onProgressChanged(BubbleSeekBar bubbleSeekBar, int i11, float f11, boolean z11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(z11);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).p2(i11, z11);
            if (z11) {
                TradeVerticalBaseFragment.this.H1.hideKeyboard();
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).o2(false);
            }
        }
    }

    public class c extends TradeBaseFragment<P, V>.k {
        public c() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            boolean unused = TradeVerticalBaseFragment.this.f83289v0 = true;
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).h2(TradeVerticalBaseFragment.this.J0, editable, false);
            boolean unused2 = TradeVerticalBaseFragment.this.f83289v0 = false;
        }
    }

    public class d implements MenuItemOnClickListener {
        public d() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).k2(i11);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).G1(false);
            TradeVerticalBaseFragment.this.f83287t1.dismiss();
        }
    }

    public class e implements MenuItemOnClickListener {
        public e() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (i11 == 0) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).q2(0);
                if (w.l()) {
                    TradeVerticalBaseFragment.this.K0.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    TradeVerticalBaseFragment.this.K0.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                TradeVerticalBaseFragment.this.f83106t.c(0);
                TradeVerticalBaseFragment.this.sk(0);
            } else if (i11 == 1) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).q2(1);
                if (w.l()) {
                    TradeVerticalBaseFragment.this.K0.setImageResource(R.drawable.trade_trend_red);
                } else {
                    TradeVerticalBaseFragment.this.K0.setImageResource(R.drawable.trade_trend_green);
                }
                TradeVerticalBaseFragment.this.f83106t.c(1);
                TradeVerticalBaseFragment.this.sk(1);
            } else {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).q2(2);
                if (w.l()) {
                    TradeVerticalBaseFragment.this.K0.setImageResource(R.drawable.trade_trend_green);
                } else {
                    TradeVerticalBaseFragment.this.K0.setImageResource(R.drawable.trade_trend_red);
                }
                TradeVerticalBaseFragment.this.f83106t.c(2);
                TradeVerticalBaseFragment.this.sk(2);
            }
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).s2();
            TradeVerticalBaseFragment.this.f83281n1.dismiss();
        }
    }

    public class f implements Runnable {
        public f() {
        }

        public void run() {
            TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
            tradeVerticalBaseFragment.f83263a2 = tradeVerticalBaseFragment.Z1.getMeasuredHeight();
        }
    }

    public class g implements CommonPopListItem.a {
        public g() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            TradeVerticalBaseFragment.this.X0.dismiss();
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).C0(commonPopListItem.getType(), false);
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).a1() == commonPopListItem.getType();
        }
    }

    public class h extends CommonNavigatorAdapter {
        public h() {
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01ac A[Catch:{ Exception -> 0x01ba }] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01af A[Catch:{ Exception -> 0x01ba }] */
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ void lambda$getTitleView$0(int r6, android.view.View r7) {
            /*
                r5 = this;
                if (r6 != 0) goto L_0x0014
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r0 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r0 = r0.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r0 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r0
                boolean r0 = r0.e1()
                if (r0 == 0) goto L_0x0014
                com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r7)
                return
            L_0x0014:
                r0 = 1
                if (r6 != r0) goto L_0x0029
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r1.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r1
                boolean r1 = r1.e1()
                if (r1 != 0) goto L_0x0029
                com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r7)
                return
            L_0x0029:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r1.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r1
                r2 = 0
                r1.G1(r2)
                java.lang.String r1 = ""
                if (r6 != 0) goto L_0x009d
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                android.widget.EditText r3 = r3.C0
                r3.setText(r1)
                d7.a1 r1 = d7.a1.v()
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r3.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r3 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r3
                java.lang.String r3 = r3.o0()
                boolean r1 = r1.S(r3)
                if (r1 == 0) goto L_0x0080
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                android.widget.RelativeLayout r1 = r1.H0
                com.hbg.lib.common.utils.ViewUtil.m(r1, r2)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.huobi.view.TradeAmountEditext r1 = r1.I0
                com.hbg.lib.common.utils.ViewUtil.m(r1, r2)
                ut.o r1 = ut.o.C()
                com.hbg.lib.data.symbol.PrimeInfo r1 = r1.G()
                if (r1 == 0) goto L_0x008f
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                ut.o r3 = ut.o.C()
                com.hbg.lib.data.symbol.PrimeInfo r3 = r3.G()
                java.lang.String r3 = r3.getCurrentPrice()
                r1.hl(r3, r0, r2)
                goto L_0x008f
            L_0x0080:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r1.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r3 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r3
                java.lang.String r3 = r3.T0()
                r1.hl(r3, r0, r2)
            L_0x008f:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                net.lucode.hackware.magicindicator.MagicIndicator r1 = r1.f83262a1
                r3 = 2131235077(0x7f081105, float:1.8086338E38)
                r1.setBackgroundResource(r3)
                goto L_0x0121
            L_0x009d:
                if (r6 != r0) goto L_0x0121
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                android.widget.EditText r3 = r3.C0
                r3.setText(r1)
                d7.a1 r1 = d7.a1.v()
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r3.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r3 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r3
                java.lang.String r3 = r3.o0()
                boolean r1 = r1.S(r3)
                if (r1 == 0) goto L_0x0104
                ut.o r1 = ut.o.C()
                com.hbg.lib.data.symbol.PrimeInfo r1 = r1.G()
                if (r1 == 0) goto L_0x0104
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                android.widget.RelativeLayout r1 = r1.H0
                com.hbg.lib.common.utils.ViewUtil.m(r1, r0)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.huobi.view.TradeAmountEditext r1 = r1.I0
                com.hbg.lib.common.utils.ViewUtil.m(r1, r2)
                ut.o r1 = ut.o.C()
                com.hbg.lib.data.symbol.PrimeInfo r1 = r1.G()
                java.lang.String r1 = r1.getRoundLimitOrderPrice()
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x00f2
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r1.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r1
                r1.G1(r0)
                goto L_0x0113
            L_0x00f2:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                ut.o r3 = ut.o.C()
                com.hbg.lib.data.symbol.PrimeInfo r3 = r3.G()
                java.lang.String r3 = r3.getRoundLimitOrderPrice()
                r1.hl(r3, r0, r0)
                goto L_0x0113
            L_0x0104:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r1.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r3 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r3
                java.lang.String r3 = r3.K0()
                r1.hl(r3, r0, r0)
            L_0x0113:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                net.lucode.hackware.magicindicator.MagicIndicator r1 = r1.f83262a1
                r3 = 2131235083(0x7f08110b, float:1.808635E38)
                r1.setBackgroundResource(r3)
                r1 = r2
                goto L_0x0122
            L_0x0121:
                r1 = r0
            L_0x0122:
                d7.a1 r3 = d7.a1.v()
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r4 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r4 = r4.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r4 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r4
                java.lang.String r4 = r4.o0()
                boolean r3 = r3.S(r4)
                if (r3 == 0) goto L_0x0145
                if (r1 == 0) goto L_0x0145
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                android.widget.TextView r3 = r3.N0
                r4 = 2132027204(0x7f142744, float:1.9692962E38)
                r3.setText(r4)
                goto L_0x014f
            L_0x0145:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                android.widget.TextView r3 = r3.N0
                r4 = 2132027162(0x7f14271a, float:1.9692877E38)
                r3.setText(r4)
            L_0x014f:
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                r3.I3(r1)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r3.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r3 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r3
                r3.C1(r1)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r3 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r3.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r3 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r3
                tg.r r4 = tg.r.x()
                boolean r4 = r4.F0()
                r3.B0(r4, r1)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                net.lucode.hackware.magicindicator.MagicIndicator r1 = r1.f83262a1
                r1.c(r6)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                net.lucode.hackware.magicindicator.MagicIndicator r1 = r1.f83262a1
                r3 = 0
                r1.b(r6, r3, r2)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r6 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.huobi.view.MyNestedScrollView r6 = r6.f83104r
                r6.scrollTo(r2, r2)
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r6 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this
                com.hbg.lib.common.mvp.BaseFragmentPresenter r6 = r6.yh()
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r6 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r6
                r6.J1()
                java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x01ba }
                r6.<init>(r0)     // Catch:{ Exception -> 0x01ba }
                java.lang.String r0 = "Button_id"
                com.huobi.tradenew.ui.TradeVerticalBaseFragment r1 = com.huobi.tradenew.ui.TradeVerticalBaseFragment.this     // Catch:{ Exception -> 0x01ba }
                com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r1.yh()     // Catch:{ Exception -> 0x01ba }
                com.huobi.tradenew.presenter.TradeVerticalBasePresenter r1 = (com.huobi.tradenew.presenter.TradeVerticalBasePresenter) r1     // Catch:{ Exception -> 0x01ba }
                boolean r1 = r1.e1()     // Catch:{ Exception -> 0x01ba }
                if (r1 == 0) goto L_0x01af
                java.lang.String r1 = "buy"
                goto L_0x01b1
            L_0x01af:
                java.lang.String r1 = "sell"
            L_0x01b1:
                r6.put(r0, r1)     // Catch:{ Exception -> 0x01ba }
                java.lang.String r0 = "App_trade_transDirection_click"
                gs.g.i(r0, r6)     // Catch:{ Exception -> 0x01ba }
                goto L_0x01c0
            L_0x01ba:
                r6 = move-exception
                java.lang.String r0 = "SensorsData"
                i6.k.j(r0, r6)
            L_0x01c0:
                com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.tradenew.ui.TradeVerticalBaseFragment.h.lambda$getTitleView$0(int, android.view.View):void");
        }

        public int getCount() {
            return TradeVerticalBaseFragment.this.Z0.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            if (i11 == 0) {
                tradeBuySellView.setNormalDrawable(R.color.baseColorContentBackground);
                tradeBuySellView.setNormalColor(ContextCompat.getColor(TradeVerticalBaseFragment.this.getContext(), R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(TradeVerticalBaseFragment.this.getContext(), R.color.baseTextColor));
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_without_corners);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_without_corners);
                }
            } else {
                tradeBuySellView.setNormalColor(ContextCompat.getColor(TradeVerticalBaseFragment.this.getContext(), R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(TradeVerticalBaseFragment.this.getContext(), R.color.baseTextColor));
                tradeBuySellView.setNormalDrawable(R.color.baseColorContentBackground);
                if (w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_without_corners);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_without_corners);
                }
            }
            tradeBuySellView.setTextSize(14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(TradeVerticalBaseFragment.this.getContext(), R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) TradeVerticalBaseFragment.this.Z0.get(i11));
            tradeBuySellView.setOnClickListener(new m3(this, i11));
            return tradeBuySellView;
        }
    }

    public class i implements View.OnClickListener {
        public i() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            TradeVerticalBaseFragment.this.ui();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class j extends TradeBaseFragment.k {
        public j() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            if (!TradeVerticalBaseFragment.this.f83289v0) {
                ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).d2(TradeVerticalBaseFragment.this.E0, editable, !TextUtils.isEmpty(editable));
            }
        }
    }

    public class k extends TradeBaseFragment.k {
        public k() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).f2(TradeVerticalBaseFragment.this.C0, editable, false);
        }
    }

    public class l extends TradeBaseFragment.k {
        public l() {
            super();
        }

        public void afterTextChanged(Editable editable) {
            super.afterTextChanged(editable);
            ((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).g2(TradeVerticalBaseFragment.this.f83278k1.getEditText(), editable);
        }
    }

    public class m implements View.OnClickListener {
        public m() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).a1() == 3) {
                if (((TradeVerticalBasePresenter) TradeVerticalBaseFragment.this.yh()).e1()) {
                    TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
                    if (tradeVerticalBaseFragment.Z == 1) {
                        tradeVerticalBaseFragment.rk();
                    } else {
                        tradeVerticalBaseFragment.qk();
                    }
                } else {
                    TradeVerticalBaseFragment tradeVerticalBaseFragment2 = TradeVerticalBaseFragment.this;
                    if (tradeVerticalBaseFragment2.f83084a0 == 1) {
                        tradeVerticalBaseFragment2.rk();
                    } else {
                        tradeVerticalBaseFragment2.qk();
                    }
                }
            }
            TradeVerticalBaseFragment.this.f83266c1.setProgress(0);
            TradeVerticalBaseFragment.this.Hb(0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class n implements BaseDialogFragment.c {
        public n() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
            tradeVerticalBaseFragment.M0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(tradeVerticalBaseFragment.getActivity(), R.drawable.trade_arrow_down_new), (Drawable) null);
        }

        public void onDialogFragmentResume() {
            TradeVerticalBaseFragment tradeVerticalBaseFragment = TradeVerticalBaseFragment.this;
            tradeVerticalBaseFragment.M0.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ContextCompat.getDrawable(tradeVerticalBaseFragment.getActivity(), R.drawable.trade_arrow_up_new), (Drawable) null);
        }
    }

    private void Ak() {
        this.f83293x0 = (TextView) this.f67460i.b(R.id.tv_available_fund_value);
        this.f83291w0 = (TextView) this.f67460i.b(R.id.available_fund_type_tv);
        this.f83295y0 = (TextView) this.f67460i.b(R.id.tv_max_available_fund_value);
        this.f83297z0 = (TextView) this.f67460i.b(R.id.max_available_fund_type_tv);
        this.A0 = (RelativeLayout) this.f67460i.b(R.id.asset_max_head_rl);
        this.B0 = (ImageView) this.f67460i.b(R.id.asset_transfer_iv);
    }

    private void Bk() {
        this.Z0.add(getString(R.string.trade_buy_label));
        this.Z0.add(getString(R.string.trade_sell_label));
        this.f83262a1 = (MagicIndicator) this.f67460i.b(R.id.buy_shell_indicator);
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new h());
        this.f83262a1.setNavigator(commonNavigator);
        int a11 = PixelUtils.a(1.0f);
        ((FrameLayout.LayoutParams) commonNavigator.getLayoutParams()).setMargins(a11, a11, a11, a11);
    }

    private void Ck() {
        this.f83276i1.setOnClickListener(new e3(this));
    }

    private void Di() {
        Bk();
        this.M0 = (TextView) this.f67460i.b(R.id.trade_type_tv);
        View b11 = this.f67460i.b(R.id.order_type_ll);
        this.I1 = b11;
        b11.setBackgroundResource(R.drawable.custom_edittext_normal_bg_without_corners);
        this.f83264b1 = (TextView) this.f67460i.b(R.id.price_convert_tv);
        this.f83266c1 = (TradeRangeBarView) this.f67460i.b(R.id.trade_range_bar);
        this.f83268d1 = (MultiColorSeekBar) this.f67460i.b(R.id.trade_new_seek_bar);
        this.f83270e1 = (TextView) this.f67460i.b(R.id.progress_leverage);
        this.f83272f1 = (TextView) this.f67460i.b(R.id.progress_leverage_label_tv);
        Ek();
    }

    private void Dk() {
        TextView textView = (TextView) this.f67460i.b(R.id.vertical_depth_tv);
        this.f83274g1 = textView;
        textView.setText(String.format(getString(R.string.trade_depth_text), new Object[]{"--"}));
        this.f83275h1 = (ImageView) this.f67460i.b(R.id.vertical_depth_arrow_iv);
        this.f83276i1 = this.f67460i.b(R.id.depth_ll);
        this.f83287t1.setMenuItems(new ArrayList());
    }

    private void Ek() {
        TradePriceEditext tradePriceEditext = (TradePriceEditext) this.f67460i.b(R.id.limit_input_price);
        this.D0 = tradePriceEditext;
        this.C0 = tradePriceEditext.getEditText();
        TradeAmountEditext tradeAmountEditext = (TradeAmountEditext) this.f67460i.b(R.id.layout_input_amount);
        this.F0 = tradeAmountEditext;
        this.E0 = tradeAmountEditext.getEditText();
        this.G0 = (TextView) this.f67460i.b(R.id.tv_input_volume_value);
        this.H0 = (RelativeLayout) this.f67460i.b(R.id.layout_input_volume);
        TradeAmountEditext tradeAmountEditext2 = (TradeAmountEditext) this.f67460i.b(R.id.volume_et_layout);
        this.I0 = tradeAmountEditext2;
        this.J0 = tradeAmountEditext2.getEditText();
        this.L0 = (TextView) this.f67460i.b(R.id.btn_trade_confirm);
        String o02 = ((TradeVerticalBasePresenter) yh()).o0();
        this.D0.setEditHint(R.string.trade_bid_price);
        this.D0.setLabel(SymbolUtil.c(o02, false));
        this.f83278k1.setLabel(SymbolUtil.c(o02, false));
    }

    private void Fk() {
        this.E0.addTextChangedListener(new j());
        this.C0.addTextChangedListener(new k());
        this.f83278k1.getEditText().addTextChangedListener(new l());
        this.J0.addTextChangedListener(this.f83267c2);
        this.C0.setOnFocusChangeListener(new p2(this));
        this.f83278k1.getEditText().setOnFocusChangeListener(new o2(this));
        this.D0.getMarketPriceArea().setOnClickListener(new m());
        this.E0.setOnFocusChangeListener(new q2(this));
        this.E0.setOnTouchListener(new KeyboardTouchListener(this.f83108u, 3, -1, this.f83269d2));
        this.J0.setOnFocusChangeListener(new r2(this));
        this.J0.setOnTouchListener(new KeyboardTouchListener(this.f83108u, 3, -1, this.f83269d2));
        this.C0.setOnTouchListener(new KeyboardTouchListener(this.f83108u, 3, -1, this.f83269d2));
        this.f83278k1.getEditText().setOnTouchListener(new KeyboardTouchListener(this.f83108u, 3, -1, this.f83269d2));
        this.X0.setDialogFragmentListener(new n());
        this.M0.setOnClickListener(new j3(this));
        Observable<Void> a11 = dw.a.a(this.L0);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new b3(this));
        dw.a.a(this.Q0).throttleFirst(300, timeUnit).subscribe(new c3(this));
        this.f83268d1.setOnProgressChangedListener(new a());
        this.f83266c1.setOnProgressChangedListener(new b());
    }

    private void Gk() {
        this.K0 = (ImageView) this.f67460i.b(R.id.trend_change_iv);
        this.f83282o1.add(new MenuItem(0, getString(R.string.trade_trend_default), getString(R.string.trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f83273f2));
        List<MenuItem> list = this.f83282o1;
        String string = getString(R.string.trade_trend_buy);
        String string2 = getString(R.string.trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f83273f2));
        this.f83282o1.add(new MenuItem(2, getString(R.string.trade_trend_sell), getString(R.string.trade_trend_sell), menuItemStyle, this.f83273f2));
        this.f83281n1.setMenuItems(this.f83282o1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hk(Void voidR) {
        if (((TradeVerticalBasePresenter) yh()).a1() == 0) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 5);
        } else if (((TradeVerticalBasePresenter) yh()).a1() == 1) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 6);
        } else if (((TradeVerticalBasePresenter) yh()).a1() == 2) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 7);
        } else if (((TradeVerticalBasePresenter) yh()).a1() == 3) {
            ContractGuideHelper.e(getActivity().getSupportFragmentManager(), 8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jk(HBDialogFragment hBDialogFragment) {
        if (k0.k() == TradeType.MARGIN) {
            k0.M(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
        } else {
            k0.R(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", ((TradeVerticalBasePresenter) yh()).o0());
        hashMap.put("mag_numb", this.L1.getText().toString().replace("X", ""));
        gs.g.i("App_targe_switch_mag_click", hashMap);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Kk(View view) {
        if (!r.a()) {
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_margin_alert_title)).C0(String.format(Locale.ENGLISH, getString(R.string.n_trade_margin_alert_content), new Object[]{this.L1.getText()})).q0(false).x0(true).y0(getString(R.string.n_login_donot_prompt)).v0(t2.f83529a).P0(getString(R.string.n_known)).Q0(new u2(this)).j0().show(getActivity().getSupportFragmentManager(), "");
        } else {
            if (k0.k() == TradeType.MARGIN) {
                k0.M(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
            } else {
                k0.R(((TradeVerticalBasePresenter) yh()).o0(), "0", true, getActivity());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("TransPair_current_id", ((TradeVerticalBasePresenter) yh()).o0());
            hashMap.put("mag_numb", this.L1.getText().toString().replace("X", ""));
            gs.g.i("App_targe_switch_mag_click", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Lk(View view) {
        ll();
        try {
            gs.g.i("App_trade_kline_click", (HashMap) null);
        } catch (Exception e11) {
            i6.k.j("SensorsData", e11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Oi(View view) {
        this.C1.performClick();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ok(View view) {
        String str;
        if (((TradeVerticalBasePresenter) yh()).a1() == 1) {
            if (((TradeVerticalBasePresenter) yh()).e1()) {
                str = getString(R.string.n_trade_buy_auto_repay_not_support);
            } else {
                str = getString(R.string.n_trade_sell_auto_repay_not_support);
            }
            new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_login_tip)).C0(str).q0(false).P0(getActivity().getString(R.string.n_sure)).Q0(y2.f83560a).k0().show(getActivity().getSupportFragmentManager(), "");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        CommonSwitchButton commonSwitchButton = this.f83296y1;
        commonSwitchButton.b(!commonSwitchButton.isChecked(), true);
        HashMap hashMap = new HashMap();
        if (this.f83296y1.isChecked()) {
            hashMap.put("type", "open");
        } else {
            hashMap.put("type", "close");
        }
        String str2 = ((TradeVerticalBasePresenter) yh()).e1() ? "5972" : "5973";
        if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.MARGIN) {
            is.a.j(str2, hashMap, "1000101");
        } else if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN) {
            is.a.j(str2, hashMap, "1000100");
        }
        cl(((TradeVerticalBasePresenter) yh()).e1());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Pk(View view) {
        o0.a(this.C1, getResources().getString(R.string.n_trade_waiting_to_repay_hint), false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qi(View view) {
        k0.S(getActivity(), ((TradeVerticalBasePresenter) yh()).o0(), ((TradeVerticalBasePresenter) yh()).e1(), TradeType.PRO);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qk(View view) {
        if (((TradeVerticalBasePresenter) yh()).M0().w().size() > 0) {
            this.f83287t1.show(getActivity().getFragmentManager(), TradeVerticalBaseFragment.class.getName());
        }
        this.f83108u.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Rk(View view, boolean z11) {
        if (z11) {
            this.f83108u.showKeyBoardLayout(this.C0, 3);
        }
        if (((TradeVerticalBasePresenter) yh()).a1() == 3) {
            el(this.D0.getInputPriceRl(), z11);
        } else {
            el(this.D0, z11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sk(View view, boolean z11) {
        el(this.f83278k1, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Tk(View view, boolean z11) {
        el(this.F0, z11);
        if (z11) {
            try {
                gs.g.i("App_trade_quantity_click", (HashMap) null);
            } catch (Exception e11) {
                i6.k.j("SensorsData", e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Uk(View view, boolean z11) {
        el(this.I0, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Vk(View view) {
        if (getActivity() != null) {
            y2();
            this.X0.setData(this.Y0);
            this.X0.setFollowViewWidth(true);
            this.X0.showAsDropDown(getActivity().getSupportFragmentManager(), this.I1);
        }
        this.f83108u.hideKeyboardLayout();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Wk(Void voidR) {
        if (tg.r.x().F0()) {
            vi();
            I3(((TradeVerticalBasePresenter) yh()).e1());
            if (((TradeVerticalBasePresenter) yh()).e1()) {
                ((TradeVerticalBasePresenter) yh()).E1(this.Z);
            } else {
                ((TradeVerticalBasePresenter) yh()).E1(this.f83084a0);
            }
            ((TradeVerticalBasePresenter) yh()).Q1(getInputPriceText(), getInputAmountText(), ((TradeVerticalBasePresenter) yh()).e1(), eg());
            if (TradeType.PRO == ((TradeVerticalBasePresenter) yh()).Z0()) {
                try {
                    gs.g.l(((TradeVerticalBasePresenter) yh()).e1(), ((TradeVerticalBasePresenter) yh()).o0(), "Vertical", ((TradeVerticalBasePresenter) yh()).a1());
                } catch (Exception e11) {
                    i6.k.j("SensorsData", e11);
                }
                try {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("Button_id", ((TradeVerticalBasePresenter) yh()).e1() ? "buy" : "sell");
                    gs.g.i("App_trade_tradeButton_click", hashMap);
                } catch (Exception e12) {
                    i6.k.j("SensorsData", e12);
                }
            }
        } else {
            ((TradeVerticalBasePresenter) yh()).K1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Xk(Void voidR) {
        if (tg.r.x().F0()) {
            vi();
            I3(((TradeVerticalBasePresenter) yh()).e1());
            return;
        }
        ((TradeVerticalBasePresenter) yh()).K1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Yk(View view, MotionEvent motionEvent) {
        z8(false, true);
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Zk() {
        this.S0.r();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bl() {
        o.e(this.J1, n2.f83491b);
    }

    private void el(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg_without_corners);
            Object tag = view.getTag();
            if ((tag instanceof String) && "PLAN_MARKET_VIEW_TAG".equals((String) tag)) {
                view.setBackgroundResource(R.drawable.custom_edittext_unenable_bg_without_corner);
            }
        } else if (((TradeVerticalBasePresenter) yh()).e1()) {
            if (w.l()) {
                view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg_without_corners);
            } else {
                view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg_without_corners);
            }
        } else if (w.l()) {
            view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg_without_corners);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg_without_corners);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        for (MenuItem next : this.f83282o1) {
            if (((TradeVerticalBasePresenter) yh()).l2() == next.getType()) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f83281n1.show(getActivity().getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        if (this.f83296y1.isChecked()) {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_buy_to_repay_open_hint)).q0(false).P0(getActivity().getString(R.string.n_known)).Q0(w2.f83548a).k0().show(getActivity().getSupportFragmentManager(), "");
        } else {
            new DialogUtils.b.d(getActivity()).C0(getString(R.string.n_trade_buy_to_repay_hint)).q0(false).P0(getActivity().getString(R.string.n_known)).Q0(v2.f83543a).k0().show(getActivity().getSupportFragmentManager(), "");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void ok(boolean z11, int i11, String str) {
        if (z11 && (i11 == 1 || a1.v().Q(str))) {
            this.f83272f1.setText(SymbolUtil.c(str, false));
        } else if (i11 != 3) {
            this.f83272f1.setText(SymbolUtil.c(str, true));
        } else if (!z11 || this.Z != 2) {
            this.f83272f1.setText(SymbolUtil.c(str, true));
        } else {
            this.f83272f1.setText(SymbolUtil.c(str, false));
        }
    }

    /* access modifiers changed from: private */
    public void qk() {
        this.C0.setText("");
        this.E0.setText("");
        boolean z11 = true;
        if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.PRO) {
            this.H0.setVisibility(8);
            ViewUtil.m(this.I0, true);
        } else {
            this.H0.setVisibility(0);
            ViewUtil.m(this.I0, false);
        }
        this.f83264b1.setVisibility(0);
        this.D0.setHintText((int) R.string.trade_input_price);
        this.D0.setHintTextColor(getResources().getColor(R.color.global_input_hint_color));
        this.F0.setAddReduceVisibility(true);
        this.D0.setPriceInputType(3);
        this.D0.setMarketStyle(false);
        this.D0.setSelectorVisible(false);
        this.D0.setBackgroundResource(R.drawable.custom_edittext_normal_bg_without_corners);
        this.D0.setMarketPriceStyleWithoutCorners(true);
        this.D0.setMarketPriceAreaPressStyle(false);
        this.D0.getInputPriceRl().setTag((Object) null);
        this.f83084a0 = 1;
        this.Z = 1;
        nk(((TradeVerticalBasePresenter) yh()).e1(), ((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).o0());
        if (tg.r.x().F0()) {
            og(this.f83094k0);
        } else {
            if (!((TradeVerticalBasePresenter) yh()).e1() || !((TradeVerticalBasePresenter) yh()).f1()) {
                z11 = false;
            }
            C8(z11);
        }
        ((TradeVerticalBasePresenter) yh()).a2();
    }

    /* access modifiers changed from: private */
    public void rk() {
        this.C0.setText("");
        this.E0.setText("");
        this.H0.setVisibility(8);
        boolean z11 = false;
        this.F0.setAddReduceVisibility(false);
        ViewUtil.m(this.I0, false);
        this.f83264b1.setVisibility(8);
        this.f83108u.hideKeyboardLayout();
        this.D0.setHintText((int) R.string.n_trade_current_best);
        this.D0.setHintTextColor(getResources().getColor(R.color.baseColorPrimaryText));
        this.D0.setPriceInputType(2);
        this.D0.setMarketPriceStyleWithoutCorners(true);
        this.D0.setMarketStyle(true);
        this.D0.getInputPriceRl().setBackgroundResource(R.drawable.custom_edittext_unenable_bg_without_corner);
        this.D0.setMarketPriceAreaPressStyle(true);
        this.D0.getInputPriceRl().setTag("PLAN_MARKET_VIEW_TAG");
        this.f83084a0 = 2;
        this.Z = 2;
        nk(((TradeVerticalBasePresenter) yh()).e1(), ((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).o0());
        if (tg.r.x().F0()) {
            og(this.f83094k0);
        } else {
            if (((TradeVerticalBasePresenter) yh()).e1() && ((TradeVerticalBasePresenter) yh()).f1()) {
                z11 = true;
            }
            C8(z11);
        }
        ((TradeVerticalBasePresenter) yh()).a2();
    }

    private void tk(boolean z11) {
        boolean z12 = this.f67460i.b(R.id.order_container).getVisibility() == 0;
        p10.a navigator = this.H.getNavigator();
        if (navigator != null) {
            navigator.notifyDataSetChanged();
        }
        if (z11) {
            if (w.l()) {
                this.L0.setBackgroundResource(R.drawable.trade_btn_sell_selector_without_corners);
                this.f83262a1.setBackgroundResource(R.drawable.shape_exchange_red_vertical_container_bg_without_corners);
                this.B0.setImageResource(R.drawable.trade_transfer_margin_red);
                if (z12) {
                    this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_red);
                }
            } else {
                this.L0.setBackgroundResource(R.drawable.trade_btn_buy_selector_without_corners);
                this.f83262a1.setBackgroundResource(R.drawable.shape_exchange_green_vertical_container_bg_without_corners);
                this.B0.setImageResource(R.drawable.trade_transfer_margin_green);
                if (z12) {
                    this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_green);
                }
            }
        } else if (w.l()) {
            this.L0.setBackgroundResource(R.drawable.trade_btn_buy_selector_without_corners);
            this.f83262a1.setBackgroundResource(R.drawable.shape_exchange_green_vertical_container_bg_without_corners);
            this.B0.setImageResource(R.drawable.trade_transfer_margin_green);
            if (z12) {
                this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_green);
            }
        } else {
            this.L0.setBackgroundResource(R.drawable.trade_btn_sell_selector_without_corners);
            this.f83262a1.setBackgroundResource(R.drawable.shape_exchange_red_vertical_container_bg_without_corners);
            this.B0.setImageResource(R.drawable.trade_transfer_margin_red);
            if (z12) {
                this.Q0.setBackgroundResource(R.drawable.trade_order_entrance_disable_red);
            }
        }
        if (!tg.r.x().F0()) {
            this.L0.setBackgroundResource(R.drawable.common_blue_5_radius_selector);
        }
        if (z11) {
            this.f83266c1.setIsBuy(true);
            this.f83266c1.setSecondTrackColor(bh.j.b(R.color.baseColorMajorTheme100));
            if (w.l()) {
                this.f83266c1.setThumbBitmap(R.drawable.trade_slider_sell);
            } else {
                this.f83266c1.setThumbBitmap(R.drawable.trade_slider_buy);
            }
        } else {
            this.f83266c1.setIsBuy(false);
            this.f83266c1.setSecondTrackColor(bh.j.b(R.color.baseColorMajorTheme100));
            if (w.l()) {
                this.f83266c1.setThumbBitmap(R.drawable.trade_slider_buy);
            } else {
                this.f83266c1.setThumbBitmap(R.drawable.trade_slider_sell);
            }
        }
        this.f83268d1.getConfigBuilder().colorConfig(getContext(), NightHelper.e().g(), z11).build();
    }

    public void A1(boolean z11) {
        String str;
        String O02 = ((TradeVerticalBasePresenter) yh()).O0(this.f83278k1.getEditText().getText().toString());
        if (TextUtils.isEmpty(O02) || BigDecimal.ZERO.compareTo(new BigDecimal(O02)) == 0) {
            str = "";
        } else {
            str = String.format(getString(R.string.balance_total_cny), new Object[]{O02}) + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        }
        this.f83279l1.setText(str);
    }

    public void Ah() {
        super.Ah();
        dw.a.a(this.f83280m1).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new d3(this));
        this.K0.setOnClickListener(new f3(this));
        Fk();
        Ck();
        this.B0.setOnClickListener(new i());
        this.f83298z1.setOnClickListener(new x2(this));
        this.f83296y1.setOnClickListener(new i3(this));
        this.B1.setOnClickListener(new h3(this));
        this.C1.setOnClickListener(new m2(this));
        this.K1.setOnClickListener(new g3(this));
        this.L1.setOnClickListener(new l3(this));
        this.W0.setOnClickListener(new k3(this));
    }

    public void B(int i11) {
        this.f83262a1.c(i11);
        this.f83262a1.b(i11, 0.0f, 0);
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        if (getActivity() != null && list != null) {
            this.f83106t.setBuyList(list);
            dl(list);
            if (!((TradeVerticalBasePresenter) yh()).e1()) {
                String valueOf = !list.isEmpty() ? String.valueOf(list.get(0).a()) : "";
                if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0())) {
                    hl(valueOf, z11, true);
                }
            }
        }
    }

    public void C8(boolean z11) {
        if (z11) {
            this.f83090g0.setVisibility(0);
            sj();
            return;
        }
        this.f83090g0.setVisibility(8);
    }

    public void D2() {
        if (this.O1) {
            this.S0.q();
        }
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        if (getActivity() != null && list != null) {
            this.f83106t.setSellList(list);
            il(list);
            if (((TradeVerticalBasePresenter) yh()).e1()) {
                String valueOf = !list.isEmpty() ? String.valueOf(list.get(0).a()) : "";
                if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0())) {
                    hl(valueOf, z11, false);
                }
            }
        }
    }

    public void E3(boolean z11) {
        if (z11) {
            this.M0.setClickable(false);
            this.M0.setText(R.string.prime);
            this.M0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            if (((TradeVerticalBasePresenter) yh()).e1()) {
                this.N0.setText(R.string.trade_prime_asset_available);
            } else {
                this.N0.setText(R.string.trade_asset_available);
            }
        } else {
            this.M0.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.trade_arrow_down_new, 0);
            this.M0.setClickable(true);
            vk(((TradeVerticalBasePresenter) yh()).a1());
            this.N0.setText(R.string.trade_asset_available);
        }
        TradeHeadView tradeHeadView = this.f83111w;
        if (tradeHeadView != null) {
            tradeHeadView.setTradePriceChangeTvVisible(!z11);
        }
    }

    public void F(int i11, boolean z11) {
        if (getRootView() != null && getActivity() != null) {
            if (!qt.g.a().c()) {
                if (z11) {
                    this.C0.setText("");
                    this.f83278k1.getEditText().setText("");
                }
                this.E0.setText("");
                if (this.P0.getVisibility() == 0) {
                    this.P0.setVisibility(4);
                    this.M1 = false;
                }
            }
            o6("--", ((TradeVerticalBasePresenter) yh()).e1());
            this.G0.setText("--");
            if (!qt.g.a().c()) {
                this.f83266c1.setProgress(0);
                Hb(0);
            }
            this.f83108u.hideKeyboardLayout();
        }
    }

    public void Hb(int i11) {
        this.f83268d1.setProgress((float) i11);
    }

    public void I3(boolean z11) {
        this.C0.clearFocus();
        this.f83278k1.clearFocus();
        this.E0.clearFocus();
        this.J0.clearFocus();
        CustomBoardView customBoardView = this.f83108u;
        if (customBoardView != null) {
            customBoardView.hideKeyboardLayout();
        }
    }

    public void J(String str) {
    }

    public void Mg(double d11, int i11, int i12) {
        ml(d11, i11, i12);
    }

    public void Nd(AppBarStateChangeListener.State state) {
        super.Nd(state);
    }

    public void R1(boolean z11, boolean z12) {
        this.L0.setEnabled(z11);
    }

    public TradeRangeBarView T2() {
        return this.f83266c1;
    }

    public void U(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.C0.getHint()}));
    }

    public void U1(int i11, boolean z11) {
        this.E0.setText("");
        if (TradeType.MARGIN != ((TradeVerticalBasePresenter) yh()).Z0() && TradeType.SUPERMARGIN != ((TradeVerticalBasePresenter) yh()).Z0()) {
            this.f83292w1.setVisibility(8);
            this.f83294x1.setVisibility(8);
            this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            this.f83106t.l(5, 10);
            fl(5, 10);
        } else if (i11 == 1) {
            if (((TradeVerticalBasePresenter) yh()).a1() == 3) {
                ((TradeVerticalBasePresenter) yh()).C0(0, true);
            }
            nl(ks.g.c(), ks.g.g());
            if (((TradeVerticalBasePresenter) yh()).e1()) {
                if (this.f83097m == 1) {
                    this.f83292w1.setVisibility(0);
                    this.f83294x1.setVisibility(0);
                    this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_ask, 0);
                    this.O0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_info_grey, 0);
                } else {
                    this.f83292w1.setVisibility(0);
                    this.f83294x1.setVisibility(0);
                    this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                }
            } else if (this.f83099n == 1) {
                this.f83292w1.setVisibility(0);
                this.f83294x1.setVisibility(0);
                this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_ask, 0);
                this.O0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_info_grey, 0);
            } else {
                this.f83292w1.setVisibility(0);
                this.f83294x1.setVisibility(0);
                this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            }
            this.f83106t.l(6, 12);
            fl(6, 12);
        } else {
            this.f83097m = 0;
            this.f83099n = 0;
            ks.g.s(0);
            ks.g.u(this.f83099n);
            this.f83292w1.setVisibility(8);
            this.f83294x1.setVisibility(8);
            this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            this.f83106t.l(5, 10);
            fl(5, 10);
        }
    }

    public void U2() {
    }

    public void X1(boolean z11) {
        if (!z11 || !((TradeVerticalBasePresenter) yh()).e1()) {
            this.f83085b0.setVisibility(8);
            return;
        }
        this.f83085b0.setVisibility(0);
        xi();
        tj();
    }

    public boolean X5() {
        CustomBoardView customBoardView = this.f83108u;
        if (customBoardView == null || !customBoardView.keyboardVisible()) {
            return false;
        }
        this.f83108u.hideKeyboardLayout();
        return true;
    }

    public void Y2(DepthItem depthItem, String str) {
        this.f83274g1.setText(String.format(getString(R.string.trade_depth_text), new Object[]{str}));
    }

    public void b3() {
        this.f83293x0.setText("--");
        this.f83295y0.setText("--");
        TextView textView = this.D1;
        textView.setText("--" + xk());
        TextView textView2 = this.D1;
        textView2.setPaintFlags(textView2.getPaintFlags() & -9);
    }

    public void c(int i11) {
        if (i11 == 0) {
            if (w.l()) {
                this.K0.setImageResource(R.drawable.trade_trend_default_green_red);
            } else {
                this.K0.setImageResource(R.drawable.trade_trend_default_red_green);
            }
            this.f83106t.c(0);
            sk(0);
        } else if (i11 == 1) {
            if (w.l()) {
                this.K0.setImageResource(R.drawable.trade_trend_red);
            } else {
                this.K0.setImageResource(R.drawable.trade_trend_green);
            }
            this.f83106t.c(1);
            sk(1);
        } else if (i11 == 2) {
            if (w.l()) {
                this.K0.setImageResource(R.drawable.trade_trend_green);
            } else {
                this.K0.setImageResource(R.drawable.trade_trend_red);
            }
            this.f83106t.c(2);
            sk(2);
        }
    }

    public void c0(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.E0.getHint()}));
    }

    public void c4(BigDecimal bigDecimal) {
        if (bigDecimal != null && ((TradeVerticalBasePresenter) yh()).i1()) {
            String a11 = TradeMarginHelper.b().a();
            boolean e12 = ((TradeVerticalBasePresenter) yh()).e1();
            if (i6.m.f0(bigDecimal, i6.m.a(a11))) {
                this.N1 = bigDecimal.subtract(i6.m.a(TradeMarginHelper.b().a()));
                this.P0.setVisibility(0);
                String string = getString(R.string.n_spot_margin_had_loan_hint);
                this.P0.setText(Html.fromHtml(String.format(string, new Object[]{"<font color='" + getResources().getColor(R.color.trade_tag_text_color) + "'>" + i6.m.q(this.N1, PrecisionUtil.A(SymbolUtil.c(((TradeVerticalBasePresenter) yh()).o0(), !e12))) + SymbolUtil.c(((TradeVerticalBasePresenter) yh()).o0(), !e12) + "</font>"})));
                this.M1 = true;
                uk(((TradeVerticalBasePresenter) yh()).e1(), ((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).o0());
                return;
            }
            this.M1 = false;
            uk(((TradeVerticalBasePresenter) yh()).e1(), ((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).o0());
            if (this.P0.getVisibility() == 0) {
                this.P0.setVisibility(4);
            }
        } else if (this.P0.getVisibility() == 0) {
            this.P0.setVisibility(4);
            this.M1 = false;
            uk(((TradeVerticalBasePresenter) yh()).e1(), ((TradeVerticalBasePresenter) yh()).a1(), ((TradeVerticalBasePresenter) yh()).o0());
        }
    }

    public void ca(int i11) {
        this.F0.setLength(i11);
    }

    public void cl(boolean z11) {
        if (this.f83296y1.isChecked()) {
            this.f83298z1.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.A1.setVisibility(0);
            this.E1.setText(R.string.n_trade_current_repay);
            this.f83292w1.setVisibility(0);
            this.f83294x1.setVisibility(0);
            if (z11) {
                this.f83097m = 2;
                ks.g.s(2);
                ks.g.r(2);
            } else {
                this.f83099n = 2;
                ks.g.u(2);
                ks.g.t(2);
            }
            this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            this.N0.setClickable(false);
        } else {
            this.f83298z1.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorSecondaryText));
            this.A1.setVisibility(8);
            this.E1.setText(R.string.n_trade_current_loan);
            this.f83292w1.setVisibility(0);
            this.f83294x1.setVisibility(0);
            if (z11) {
                this.f83097m = 1;
                ks.g.s(1);
                ks.g.r(1);
            } else {
                this.f83099n = 1;
                ks.g.u(1);
                ks.g.t(1);
            }
            this.N0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_ask, 0);
            this.N0.setClickable(true);
            this.O0.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.icon_info_grey, 0);
            this.O0.setClickable(true);
        }
        this.E0.setText("");
        this.f83266c1.setProgress(0);
        Hb(0);
        I3(((TradeVerticalBasePresenter) yh()).e1());
        this.F1.setText("--");
        ((TradeVerticalBasePresenter) yh()).W1();
        ((TradeVerticalBasePresenter) yh()).V1();
        mk(((TradeVerticalBasePresenter) yh()).o0(), ((TradeVerticalBasePresenter) yh()).e1());
    }

    public void d(boolean z11) {
        super.d(z11);
        this.D0.setBtnClickEnable(z11);
        this.f83278k1.setBtnClickEnable(z11);
        this.F0.setBtnClickEnable(z11);
        this.I0.setBtnClickEnable(z11);
        if (!z11) {
            this.f83293x0.setText("--");
            this.D1.setText("--");
            TextView textView = this.F1;
            textView.setText("--" + xk());
            TextView textView2 = this.D1;
            textView2.setPaintFlags(textView2.getPaintFlags() & -9);
        }
    }

    public void d2(int i11) {
        this.D0.setLength(i11);
        this.f83278k1.setLength(i11);
    }

    public void db(boolean z11) {
        if (this.O1) {
            this.S0.i(false, ((TradeVerticalBasePresenter) yh()).Z0().toString(), ((TradeVerticalBasePresenter) yh()).o0(), PrecisionUtil.e(((TradeVerticalBasePresenter) yh()).o0()), PrecisionUtil.w(((TradeVerticalBasePresenter) yh()).o0(), ((TradeVerticalBasePresenter) yh()).Z0()));
            if (z11) {
                this.S0.C();
            }
            this.S0.r();
        }
    }

    public void dl(List<MarketBuySellItem> list) {
    }

    public String eg() {
        String trim = this.f83278k1.getEditText().getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public void fl(int i11, int i12) {
    }

    public String getInputAmountText() {
        String trim = this.E0.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public String getInputPriceText() {
        String trim = this.C0.getText().toString().trim();
        return (TextUtils.isEmpty(trim) || !trim.endsWith(InstructionFileId.DOT)) ? trim : trim.substring(0, trim.length() - 1);
    }

    public void gl(String str) {
        this.C0.setText(str);
        EditText editText = this.C0;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.C0);
    }

    public void h2() {
        this.f83106t.i();
    }

    public void ha(boolean z11) {
        if (tg.r.x().F0()) {
            this.F0.setReduceEnable(z11);
            this.F0.setReduceLongClickable(z11);
        }
    }

    public void hl(String str, boolean z11, boolean z12) {
        if (((TradeVerticalBasePresenter) yh()).a1() != 1 && ((TradeVerticalBasePresenter) yh()).a1() != 2 && ((TradeVerticalBasePresenter) yh()).a1() != 3 && !TextUtils.isEmpty(str) && !((TradeVerticalBasePresenter) yh()).g1() && z11) {
            if (i6.m.a(str).compareTo(BigDecimal.ZERO) > 0) {
                this.C0.setText(i6.m.m(str, PrecisionUtil.e(((TradeVerticalBasePresenter) yh()).o0())));
                EditText editText = this.C0;
                editText.setSelection(editText.getText().length());
                ((TradeVerticalBasePresenter) yh()).G1(true);
                return;
            }
            if (!qt.g.a().c()) {
                this.C0.setText("");
            }
            ((TradeVerticalBasePresenter) yh()).G1(true);
        }
    }

    public void i3(boolean z11) {
        HuobiToastUtil.l(bh.j.c(), String.format(getString(R.string.input_unknow_text), new Object[]{this.f83278k1.getEditText().getHint()}));
    }

    public void il(List<MarketBuySellItem> list) {
    }

    public void initViews() {
        super.initViews();
        this.Q1 = (ViewGroup) this.f67460i.b(R.id.asset_head_rl);
        this.R1 = (ViewGroup) this.f67460i.b(R.id.asset_max_head_rl);
        this.S1 = (ViewGroup) this.f67460i.b(R.id.trade_max_transfer_area);
        this.f83277j1 = this.f67460i.b(R.id.stop_input_price_layout);
        this.f83278k1 = (TradePriceEditext) this.f67460i.b(R.id.stop_input_price_et);
        this.f83279l1 = (TextView) this.f67460i.b(R.id.price_convert_stop_tv);
        this.f83280m1 = this.f67460i.b(R.id.iv_contract_guide);
        this.N0 = (TextView) this.f67460i.b(R.id.trade_spot_label1);
        this.O0 = (TextView) this.f67460i.b(R.id.trade_max_spot_max_label1);
        this.P0 = (TextView) this.f67460i.b(R.id.trade_over_loan_tips_label);
        this.R0 = this.f67460i.b(R.id.view_candle_divider_header);
        this.S0 = (KlineView) this.f67460i.b(R.id.kline_spot_margin);
        this.T0 = this.f67460i.b(R.id.view_candle_divider_tail);
        this.U0 = (TextView) this.f67460i.b(R.id.tv_price_kline_title);
        this.V0 = (TextView) this.f67460i.b(R.id.tv_price_kline_change);
        this.W0 = (TextView) this.f67460i.b(R.id.tv_trade_vertical_kline_show);
        this.T1 = (TextView) this.f67460i.b(R.id.tv_legal_price);
        this.U1 = (AppBarLayout) this.f67460i.b(R.id.appbar_layout);
        this.V1 = (LinearLayout) this.f67460i.b(R.id.ll_right);
        this.W1 = (ViewGroup) this.f67460i.b(R.id.rl_rigth);
        View b11 = this.f67460i.b(R.id.rl_kline_header);
        this.Z1 = b11;
        b11.post(new f());
        this.X1 = (TextView) this.f67460i.b(R.id.tv_top_price_kline_title);
        this.Y1 = (TextView) this.f67460i.b(R.id.tv_top_price_kline_change);
        Dk();
        Gk();
        Di();
        Ak();
        this.f83278k1.setDividerColor(getResources().getColor(R.color.baseColorPrimarySeparator));
        this.D0.setDividerColor(getResources().getColor(R.color.baseColorPrimarySeparator));
        this.F0.setDividerColor(getResources().getColor(R.color.baseColorPrimarySeparator));
        this.Q0 = (ImageView) this.f67460i.b(R.id.iv_trade_order_entrance);
        this.f83283p1 = (LinearLayout) this.f67460i.b(R.id.stop_trade_ll);
        this.f83284q1 = (ImageView) this.f67460i.b(R.id.trade_mask_iv);
        this.f83285r1 = (TextView) this.f67460i.b(R.id.trade_mask_title_tv);
        this.f83286s1 = (TextView) this.f67460i.b(R.id.trade_suspend_instruction_tv);
        this.f83290v1 = (LinearLayout) this.f67460i.b(R.id.trade_transfer_area);
        this.f83292w1 = this.f67460i.b(R.id.current_loan_repay_container);
        this.E1 = (TextView) this.f67460i.b(R.id.current_loan_repay_label_tv);
        this.F1 = (TextView) this.f67460i.b(R.id.current_loan_amount_tv);
        this.D1 = (TextView) this.f67460i.b(R.id.need_to_repay_amount_tv);
        this.G1 = (TextView) this.f67460i.b(R.id.current_loan_amount_unit_tv);
        this.f83294x1 = this.f67460i.b(R.id.buy_auto_repay_container);
        this.f83296y1 = (CommonSwitchButton) this.f67460i.b(R.id.auto_repay_switch);
        this.f83298z1 = (TextView) this.f67460i.b(R.id.auto_repay_label_tv);
        this.A1 = this.f67460i.b(R.id.need_to_repay_container);
        this.B1 = (TextView) this.f67460i.b(R.id.need_to_repay_label_tv);
        this.C1 = (FontIconTextView) this.f67460i.b(R.id.need_to_repay_iv);
        this.H1 = new HuobiKeyboardHelper().attach(getActivity());
        this.J1 = this.f67460i.b(R.id.lever_change_ll);
        this.K1 = (TextView) this.f67460i.b(R.id.spot_lever_tv);
        this.L1 = (TextView) this.f67460i.b(R.id.margin_change_lever_tv);
    }

    public void jl(boolean z11) {
        int i11 = 8;
        int i12 = 0;
        if (!z11) {
            i12 = 8;
            i11 = 0;
        }
        if (this.V1.getVisibility() != i11) {
            this.V1.setVisibility(i11);
        }
        if (this.W1.getVisibility() != i12) {
            this.W1.setVisibility(i12);
        }
    }

    public void kl(String str) {
        if (!((TradeVerticalBasePresenter) yh()).e1()) {
            setInputAmountText(str);
        } else if (((TradeVerticalBasePresenter) yh()).a1() == 1) {
            setInputAmountText(str);
        } else if (this.Z == 2) {
            setInputAmountText(str);
        } else {
            ((TradeVerticalBasePresenter) yh()).h2(this.J0, new SpannableStringBuilder(str), false);
        }
    }

    public void l(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            if (this.H0.getVisibility() == 0) {
                this.G0.setText("--");
            }
            if (this.I0.getVisibility() == 0) {
                this.J0.removeTextChangedListener(this.f83267c2);
                this.J0.setText("");
                this.J0.addTextChangedListener(this.f83267c2);
            }
        } else {
            if (this.H0.getVisibility() == 0) {
                this.G0.setText(String.format(getString(R.string.trade_total_volume_value), new Object[]{bigDecimal.toPlainString(), SymbolUtil.c(((TradeVerticalBasePresenter) yh()).o0(), false)}));
            }
            if (this.I0.getVisibility() == 0) {
                this.J0.removeTextChangedListener(this.f83267c2);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
                    this.J0.setText("");
                } else {
                    this.J0.setText(bigDecimal.toPlainString());
                }
                this.J0.addTextChangedListener(this.f83267c2);
            }
        }
        if (TextUtils.isEmpty(this.J0.getText())) {
            this.J0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.J0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
    }

    public void ll() {
        if (this.O1) {
            this.W0.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_spot_margin_open_candle, 0);
            this.W0.setText(R.string.n_exchange_kline);
            this.R0.setVisibility(8);
            this.S0.setVisibility(8);
            this.T0.setVisibility(8);
            this.S0.q();
            this.O1 = false;
            return;
        }
        this.W0.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_spot_margin_close_candle, 0);
        this.W0.setText(R.string.n_content_collapse);
        this.S0.i(false, ((TradeVerticalBasePresenter) yh()).Z0().toString(), ((TradeVerticalBasePresenter) yh()).o0(), PrecisionUtil.e(((TradeVerticalBasePresenter) yh()).o0()), PrecisionUtil.w(((TradeVerticalBasePresenter) yh()).o0(), ((TradeVerticalBasePresenter) yh()).Z0()));
        this.R0.setVisibility(0);
        this.S0.setVisibility(0);
        this.T0.setVisibility(0);
        i6.i.b().f(new z2(this));
        this.O1 = true;
    }

    public void m2(List<DepthItem> list, int i11) {
        int size = list.size();
        this.f83288u1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String v11 = ((TradeVerticalBasePresenter) yh()).M0().v(((TradeVerticalBasePresenter) yh()).o0(), i12);
            if (TextUtils.isEmpty(v11)) {
                v11 = "--";
            }
            if (i11 == i12) {
                this.f83288u1.add(new MenuItem("", v11, MenuItem.MenuItemStyle.STRESS, this.f83271e2));
            } else {
                this.f83288u1.add(new MenuItem("", v11, MenuItem.MenuItemStyle.COMMON, this.f83271e2));
            }
        }
        this.f83287t1.setMenuItems(this.f83288u1);
    }

    public void me(int i11) {
    }

    public void mk(String str, boolean z11) {
        if (z11) {
            int i11 = this.f83097m;
            if (i11 == 1) {
                this.G1.setText(SymbolUtil.c(str, !z11));
            } else if (i11 == 2) {
                this.G1.setText(SymbolUtil.c(str, z11));
            }
        } else {
            int i12 = this.f83099n;
            if (i12 == 1) {
                this.G1.setText(SymbolUtil.c(str, !z11));
            } else if (i12 == 2) {
                this.G1.setText(SymbolUtil.c(str, z11));
            }
        }
    }

    public void ml(double d11, int i11, int i12) {
    }

    public void n(boolean z11, int i11, String str) {
        int i12;
        nk(z11, i11, str);
        uk(z11, i11, str);
        pk(z11);
        tk(z11);
        if (getParentFragment() instanceof TradeFragment) {
            ((TradeFragment) getParentFragment()).Th(str);
        }
        if (i11 == 3) {
            int i13 = this.Z;
            if (i13 == 2 || (i12 = this.f83084a0) == 2) {
                rk();
            } else if (i13 == 1 || i12 == 1) {
                qk();
            }
        }
    }

    public void n0() {
        this.f83262a1.getNavigator().notifyDataSetChanged();
    }

    public void n1(boolean z11) {
        String str;
        String O02 = ((TradeVerticalBasePresenter) yh()).O0(this.C0.getText().toString());
        if (TextUtils.isEmpty(O02) || BigDecimal.ZERO.compareTo(new BigDecimal(O02)) == 0) {
            str = "";
        } else {
            str = String.format(getString(R.string.balance_total_cny), new Object[]{O02}) + LegalCurrencyConfigUtil.y().toUpperCase(Locale.US);
        }
        this.f83264b1.setText(str);
    }

    public void nk(boolean z11, int i11, String str) {
        this.D0.setLabel(SymbolUtil.c(str, false));
        this.f83278k1.setLabel(SymbolUtil.c(str, false));
        this.I0.setLabel(SymbolUtil.c(str, false));
        if (z11 && (i11 == 1 || a1.v().Q(str))) {
            this.F0.setLabel(SymbolUtil.c(str, false));
            this.F0.setEditHint(R.string.n_exchange_order_list_volume);
        } else if (i11 != 3) {
            if (!a1.v().Q(str) || !z11) {
                this.F0.setLabel(SymbolUtil.c(str, true));
            } else {
                this.F0.setLabel(SymbolUtil.c(str, false));
            }
            this.F0.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (!z11) {
            this.F0.setLabel(SymbolUtil.c(str, true));
            this.F0.setEditHint(R.string.n_exchange_order_list_amount);
        } else if (this.Z == 2) {
            this.F0.setLabel(SymbolUtil.c(str, false));
            this.F0.setEditHint(R.string.n_exchange_order_list_volume);
        } else {
            this.F0.setLabel(SymbolUtil.c(str, true));
            this.F0.setEditHint(R.string.n_exchange_order_list_amount);
        }
        ok(z11, i11, str);
        this.f83291w0.setText(SymbolUtil.c(str, !z11));
        this.f83297z0.setText(SymbolUtil.c(str, !z11));
        mk(str, z11);
    }

    public void nl(int i11, int i12) {
        if (i11 == 1) {
            this.f83097m = 1;
            ks.g.r(1);
            ks.g.s(this.f83097m);
        } else if (i11 == 2) {
            this.f83097m = 2;
            ks.g.r(2);
            ks.g.s(this.f83097m);
        } else if (i11 == -1) {
            this.f83097m = 1;
            ks.g.r(1);
            ks.g.s(this.f83097m);
        } else if (i11 == 3) {
            this.f83097m = 3;
            ks.g.r(3);
            ks.g.s(this.f83097m);
        }
        if (i12 == 1) {
            this.f83099n = 1;
            ks.g.t(1);
            ks.g.u(this.f83099n);
        } else if (i12 == 2) {
            this.f83099n = 2;
            ks.g.t(2);
            ks.g.u(this.f83099n);
        } else if (i12 == -1) {
            this.f83099n = 1;
            ks.g.t(1);
            ks.g.u(this.f83099n);
        } else if (i12 == 3) {
            this.f83099n = 3;
            ks.g.t(3);
            ks.g.u(this.f83099n);
        }
    }

    public void o6(String str, boolean z11) {
        this.F1.setText(str);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        boolean z11 = !((TradeVerticalBasePresenter) yh()).e1();
        this.f83262a1.b(z11 ? 1 : 0, 0.0f, 0);
        this.f83262a1.c(z11);
    }

    public void p(int i11, String str) {
        this.L1.setVisibility(i11);
        this.K1.setVisibility(i11);
        this.J1.setVisibility(i11);
        this.L1.setText(str);
        if (i11 == 0) {
            this.J1.post(new a3(this));
        }
    }

    public void pk(boolean z11) {
        if (z11) {
            int i11 = this.f83097m;
            if (i11 == 1) {
                if (this.f83296y1.isChecked()) {
                    this.f83296y1.b(false, false);
                    cl(z11);
                }
            } else if (i11 == 2) {
                if (!this.f83296y1.isChecked()) {
                    this.f83296y1.b(true, false);
                    cl(z11);
                }
            } else if (this.f83296y1.isChecked()) {
                this.f83296y1.b(false, false);
                cl(z11);
            }
            this.f83298z1.setText(R.string.n_trade_buy_to_repay);
            return;
        }
        int i12 = this.f83099n;
        if (i12 == 1) {
            if (this.f83296y1.isChecked()) {
                this.f83296y1.b(false, false);
                cl(z11);
            }
        } else if (i12 == 2) {
            if (!this.f83296y1.isChecked()) {
                this.f83296y1.b(true, false);
                cl(z11);
            }
        } else if (this.f83296y1.isChecked()) {
            this.f83296y1.b(false, false);
            cl(z11);
        }
        this.f83298z1.setText(R.string.n_trade_sell_to_repay);
    }

    public void setInputAmountText(String str) {
        if (i6.m.a(str).compareTo(BigDecimal.ZERO) == 0) {
            this.E0.setText("");
        } else {
            this.E0.setText(str);
            EditText editText = this.E0;
            editText.setSelection(editText.getText().length());
        }
        if (TextUtils.isEmpty(this.E0.getText())) {
            this.E0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
        } else {
            this.E0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_medium));
        }
    }

    public void setProgressText(String str) {
        this.f83270e1.setText(str);
    }

    public void sk(int i11) {
    }

    public void t(SymbolBean symbolBean) {
        if (!MarginBalanceQueryData.STATE_FL_SYS.equals(this.f83283p1.getTag(R.id.item_data1))) {
            if (symbolBean != null) {
                if (SymbolBean.PRE_ONLINE.equals(symbolBean.getState())) {
                    if (symbolBean.isWhiteEnabled()) {
                        this.f83283p1.setVisibility(8);
                    } else {
                        this.f83284q1.setImageResource(R.drawable.exchange_forbiden_waiting_image);
                        this.f83285r1.setText(R.string.trade_pre_online);
                        this.f83286s1.setVisibility(8);
                        this.f83283p1.setVisibility(0);
                    }
                } else if (SymbolBean.SUSPEND.equals(symbolBean.getState())) {
                    if (symbolBean.isWhiteEnabled()) {
                        this.f83283p1.setVisibility(8);
                    } else {
                        this.f83284q1.setImageResource(R.drawable.exchange_forbiden_image);
                        this.f83285r1.setText(R.string.trade_suspend);
                        this.f83286s1.setText(symbolBean.getSuspendDesc());
                        this.f83286s1.setVisibility(0);
                        this.f83283p1.setVisibility(0);
                    }
                } else if (SymbolBean.TRANSFER_BOARD.equals(symbolBean.getState())) {
                    this.f83284q1.setImageResource(R.drawable.exchange_transfer_type_image);
                    this.f83285r1.setText(R.string.trade_transfer_board);
                    this.f83286s1.setText(symbolBean.getTransferBoardDesc());
                    this.f83286s1.setVisibility(0);
                    this.f83283p1.setVisibility(0);
                } else if (SymbolBean.FUSE.equals(symbolBean.getState())) {
                    this.f83284q1.setImageResource(R.drawable.exchange_forbiden_image);
                    this.f83285r1.setText(R.string.trade_fuse_hint);
                    this.f83286s1.setVisibility(8);
                    this.f83283p1.setVisibility(0);
                } else {
                    this.f83283p1.setVisibility(8);
                }
                if (symbolBean.getSupportMargin() == 0) {
                    ((TradeVerticalBasePresenter) yh()).H1(false);
                    this.A0.setVisibility(8);
                } else {
                    ((TradeVerticalBasePresenter) yh()).H1(true);
                    this.A0.setVisibility(0);
                }
                f0((CurrencyAsset) null);
                return;
            }
            this.f83283p1.setVisibility(8);
        }
    }

    public void t5() {
        if (this.O1) {
            db(false);
        }
    }

    public void t7(String str, String str2, int i11, int i12) {
        this.U0.setText(str);
        this.U0.setTextColor(i11);
        this.V0.setText(str2);
        this.V0.setTextColor(i11);
        this.V0.setBackgroundResource(i12);
        this.X1.setText(str);
        this.X1.setTextColor(i11);
        this.Y1.setText(str2);
        this.Y1.setTextColor(i11);
        this.Y1.setBackgroundResource(i12);
    }

    public void u3(String str) {
        int a12 = ((TradeVerticalBasePresenter) yh()).a1();
        if (a12 == 0 || a12 == 2) {
            if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0()) || !ut.o.C().T()) {
                gl(str);
            }
        } else if (a12 == 3) {
            if (1 != this.Z && 1 != this.f83084a0) {
                return;
            }
            if (!a1.v().S(((TradeVerticalBasePresenter) yh()).o0()) || !ut.o.C().T()) {
                gl(str);
            }
        }
    }

    public void uk(boolean z11, int i11, String str) {
        String str2;
        if (tg.r.x().F0()) {
            String p11 = a1.v().p(str);
            if (z11) {
                if (TradeType.PRO != ((TradeVerticalBasePresenter) yh()).Z0()) {
                    str2 = String.format(getString(R.string.string_margin_trade_bid), new Object[]{p11});
                } else if (this.M1) {
                    str2 = String.format(getString(R.string.n_spot_margin_buy), new Object[]{p11});
                } else {
                    str2 = String.format(getString(R.string.string_trade_bid), new Object[]{p11});
                }
            } else if (TradeType.PRO != ((TradeVerticalBasePresenter) yh()).Z0()) {
                str2 = String.format(getString(R.string.string_margin_trade_ask), new Object[]{p11});
            } else if (this.M1) {
                str2 = String.format(getString(R.string.n_spot_margin_sell), new Object[]{p11});
            } else {
                str2 = String.format(getString(R.string.string_trade_ask), new Object[]{p11});
            }
            this.L0.setText(str2);
            return;
        }
        this.L0.setText(R.string.n_trade_log_in_to_exchange);
    }

    public void v(int i11, int i12, boolean z11, String str) {
        int i13 = i11;
        int i14 = i12;
        boolean z12 = z11;
        String str2 = str;
        String wk2 = wk(i11, i12);
        String zk2 = zk(i11, i12);
        if (i14 == 3) {
            this.Z = 1;
            this.f83084a0 = 1;
            F(i14, true);
        }
        boolean z13 = false;
        if (i14 == 1) {
            this.H0.setVisibility(8);
            ViewUtil.m(this.I0, false);
            this.f83264b1.setVisibility(8);
            this.F0.setAddReduceVisibility(false);
            if (((TradeVerticalBasePresenter) yh()).Z0() != TradeType.SUPERMARGIN && ((TradeVerticalBasePresenter) yh()).Z0() != TradeType.MARGIN) {
                this.f83106t.l(5, 10);
                fl(5, 10);
            } else if (ks.g.j()) {
                this.f83292w1.setVisibility(0);
                this.f83294x1.setVisibility(0);
                this.f83106t.l(6, 12);
                fl(6, 12);
                if (this.f83097m == 2 || this.f83099n == 2) {
                    this.f83296y1.b(false, false);
                    cl(true);
                    cl(false);
                }
            } else {
                this.f83106t.l(5, 10);
                fl(5, 10);
            }
            this.D0.setHintText((int) R.string.trade_market_input_price_hint);
            this.D0.setHintTextColor(getResources().getColor(R.color.global_input_hint_color));
            this.D0.setPriceInputType(2);
            this.D0.setMarketPriceStyleWithoutCorners(false);
            this.D0.setViewVisibilityAndEnable(8, false);
            this.D0.setMarketStyle(true);
            this.D0.setBackgroundResource(R.drawable.custom_edittext_unenable_bg_without_corner);
            this.f83278k1.setViewVisibilityAndEnable(0, true);
            this.f83278k1.setMarketPriceStyleWithoutCorners(false);
            this.C0.setTypeface(ResourcesCompat.h(getContext(), R.font.roboto_regular));
            F(i14, true);
            ViewUtil.m(this.f83277j1, false);
        } else if (i14 == 2) {
            this.f83264b1.setVisibility(0);
            if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.PRO) {
                this.H0.setVisibility(8);
                ViewUtil.m(this.I0, true);
            } else {
                this.H0.setVisibility(0);
                ViewUtil.m(this.I0, false);
            }
            if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN || ((TradeVerticalBasePresenter) yh()).Z0() == TradeType.MARGIN) {
                if (z12) {
                    int i15 = this.f83097m;
                    if (i15 == 2 || i15 == 1) {
                        this.f83292w1.setVisibility(0);
                        this.f83294x1.setVisibility(0);
                    }
                } else {
                    int i16 = this.f83099n;
                    if (i16 == 2 || i16 == 1) {
                        this.f83292w1.setVisibility(0);
                        this.f83294x1.setVisibility(0);
                    }
                }
            }
            this.F0.setAddReduceVisibility(true);
            this.D0.setHintText((int) R.string.trade_input_price);
            this.D0.setHintTextColor(getResources().getColor(R.color.global_input_hint_color));
            this.D0.setPriceInputType(3);
            this.D0.setMarketStyle(false);
            this.D0.setBackgroundResource(R.drawable.custom_edittext_normal_bg_without_corners);
            this.D0.setMarketPriceStyleWithoutCorners(false);
            this.f83278k1.setViewVisibilityAndEnable(0, true);
            this.f83278k1.setMarketPriceStyleWithoutCorners(false);
            F(i14, true);
            ViewUtil.m(this.f83277j1, true);
            this.f83106t.l(6, 12);
            fl(6, 12);
        } else if (i14 == 3) {
            this.f83264b1.setVisibility(0);
            if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.PRO) {
                this.H0.setVisibility(8);
                ViewUtil.m(this.I0, true);
            } else {
                this.H0.setVisibility(0);
                ViewUtil.m(this.I0, false);
            }
            if (((TradeVerticalBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN || ((TradeVerticalBasePresenter) yh()).Z0() == TradeType.MARGIN) {
                if (z12) {
                    int i17 = this.f83097m;
                    if (i17 == 2 || i17 == 1) {
                        this.f83292w1.setVisibility(0);
                        this.f83294x1.setVisibility(0);
                    }
                } else {
                    int i18 = this.f83099n;
                    if (i18 == 2 || i18 == 1) {
                        this.f83292w1.setVisibility(0);
                        this.f83294x1.setVisibility(0);
                    }
                }
            }
            this.F0.setAddReduceVisibility(true);
            this.D0.setSelectorVisible(false);
            qk();
            this.f83278k1.setViewVisibilityAndEnable(0, true);
            F(i14, true);
            ViewUtil.m(this.f83277j1, true);
            this.f83106t.l(6, 12);
            fl(6, 12);
        } else {
            this.f83264b1.setVisibility(0);
            if (((TradeVerticalBasePresenter) yh()).e1()) {
                ((TradeVerticalBasePresenter) yh()).G1(false);
                hl(((TradeVerticalBasePresenter) yh()).T0(), true, false);
            } else {
                ((TradeVerticalBasePresenter) yh()).G1(false);
                hl(((TradeVerticalBasePresenter) yh()).K0(), true, true);
            }
            this.H0.setVisibility(8);
            this.F0.setAddReduceVisibility(true);
            ViewUtil.m(this.I0, true);
            TradeType Z02 = ((TradeVerticalBasePresenter) yh()).Z0();
            TradeType tradeType = TradeType.SUPERMARGIN;
            if (Z02 == tradeType || ((TradeVerticalBasePresenter) yh()).Z0() == TradeType.MARGIN) {
                if (z12) {
                    int i19 = this.f83097m;
                    if (i19 == 2 || i19 == 1) {
                        this.f83292w1.setVisibility(0);
                        this.f83294x1.setVisibility(0);
                    }
                } else {
                    int i21 = this.f83099n;
                    if (i21 == 2 || i21 == 1) {
                        this.f83292w1.setVisibility(0);
                        this.f83294x1.setVisibility(0);
                    }
                }
            }
            this.D0.setHintText((int) R.string.trade_input_price);
            this.D0.setHintTextColor(getResources().getColor(R.color.global_input_hint_color));
            this.D0.setPriceInputType(1);
            this.D0.setMarketStyle(false);
            this.D0.setBackgroundResource(R.drawable.custom_edittext_normal_bg_without_corners);
            this.D0.setMarketPriceStyleWithoutCorners(false);
            this.f83278k1.setViewVisibilityAndEnable(0, true);
            this.f83278k1.setMarketPriceStyleWithoutCorners(false);
            F(i14, false);
            ViewUtil.m(this.f83277j1, false);
            if (((TradeVerticalBasePresenter) yh()).Z0() != tradeType && ((TradeVerticalBasePresenter) yh()).Z0() != TradeType.MARGIN) {
                this.f83106t.l(5, 10);
                fl(5, 10);
            } else if (z12) {
                int i22 = this.f83097m;
                if (i22 == 2 || i22 == 1) {
                    this.f83106t.l(6, 12);
                    fl(6, 12);
                } else {
                    this.f83106t.l(5, 10);
                    fl(5, 10);
                }
            } else {
                int i23 = this.f83099n;
                if (i23 == 2 || i23 == 1) {
                    this.f83106t.l(6, 12);
                    fl(6, 12);
                } else {
                    this.f83106t.l(5, 10);
                    fl(5, 10);
                }
            }
        }
        if (a1.v().Q(str2) && z12) {
            ViewUtil.m(this.H0, false);
            ViewUtil.m(this.I0, false);
        }
        vk(i14);
        n(z12, i14, str2);
        if (tg.r.x().F0()) {
            og(this.f83094k0);
        } else {
            if (((TradeVerticalBasePresenter) yh()).e1() && ((TradeVerticalBasePresenter) yh()).f1()) {
                z13 = true;
            }
            C8(z13);
        }
        if (i13 != 1 && i14 != 1) {
            if (!z12 || i13 != 3 || this.Z != 2) {
                yk().setText(zk2);
                setInputAmountText(wk2);
            }
        }
    }

    public void vk(int i11) {
        if (!a1.v().Q(((TradeVerticalBasePresenter) yh()).o0()) && i11 < this.Y0.size()) {
            this.M0.setText(this.Y0.get(i11).getText());
        }
    }

    public void w3() {
    }

    public String wk(int i11, int i12) {
        return (i11 == 1 || i12 == 1) ? "" : getInputAmountText();
    }

    public String xk() {
        String str;
        String o02 = ((TradeVerticalBasePresenter) yh()).o0();
        boolean e12 = ((TradeVerticalBasePresenter) yh()).e1();
        if (e12) {
            int i11 = this.f83097m;
            if (i11 == 1) {
                str = SymbolUtil.c(o02, !e12);
            } else if (i11 == 2) {
                str = SymbolUtil.c(o02, e12);
            }
            return " " + str;
        }
        int i12 = this.f83099n;
        if (i12 == 1) {
            str = SymbolUtil.c(o02, !e12);
        } else if (i12 == 2) {
            str = SymbolUtil.c(o02, e12);
        }
        return " " + str;
        str = "";
        return " " + str;
    }

    public void y2() {
        this.Y0.clear();
        if ((((TradeVerticalBasePresenter) yh()).Z0() == TradeType.SUPERMARGIN || ((TradeVerticalBasePresenter) yh()).Z0() == TradeType.MARGIN) && ks.g.j()) {
            this.Y0.add(new CommonPopListItem(0, getString(R.string.n_contract_trade_order_type_limit), this.f83265b2));
            this.Y0.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f83265b2));
            this.Y0.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f83265b2));
        } else if (((TradeVerticalBasePresenter) yh()).h1()) {
            this.Y0.add(new CommonPopListItem(0, getString(R.string.n_contract_trade_order_type_limit), this.f83265b2));
            this.Y0.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f83265b2));
            this.Y0.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f83265b2));
        } else {
            this.Y0.add(new CommonPopListItem(0, getString(R.string.n_contract_trade_order_type_limit), this.f83265b2));
            this.Y0.add(new CommonPopListItem(1, getString(R.string.trade_price_market_deal), this.f83265b2));
            this.Y0.add(new CommonPopListItem(2, getString(R.string.trade_trend_stop), this.f83265b2));
            this.Y0.add(new CommonPopListItem(3, getString(R.string.n_exchange_plan_entrusts), this.f83265b2));
        }
    }

    public EditText yk() {
        return this.C0;
    }

    public void z(boolean z11, int i11) {
        if (i11 == 3 && tg.r.x().F0()) {
            this.f83278k1.setReduceEnable(z11);
            this.f83278k1.setReduceLongClickable(z11);
        }
        if (i11 == 1 && tg.r.x().F0()) {
            this.D0.setReduceEnable(z11);
            this.D0.setReduceLongClickable(z11);
        }
    }

    public String zk(int i11, int i12) {
        return (i11 == 1 || i12 == 1 || (i11 == 3 && this.Z == 2)) ? "" : getInputPriceText();
    }
}
