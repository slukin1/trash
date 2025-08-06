package com.huobi.feature.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bj.o0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.TradeTrendView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FuturePriceLimitInfo;
import com.hbg.lib.data.future.bean.FutureUserInfo;
import com.hbg.lib.data.future.controller.FutureClearDialogConfigController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.linear.swap.core.bean.AccountBalanceInfoV5;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapAccountInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.anim.CommonAnimateUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.PriceType;
import com.huobi.contract.ui.AbstractMaintenanceView;
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.contract.ui.ContractMarketTwTradeLayout;
import com.huobi.contract.ui.ContractTpslEditText;
import com.huobi.contract.ui.ContractTradePriceEditext;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.bean.FutureTpSlDialogShowBean;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import com.huobi.feature.ui.ContractTradeAmountView;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.feature.ui.dialog.LimitChooseDialog;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.feature.util.MarketTwTradeStateObservable;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.utils.m0;
import com.huobi.view.ContractTpslLayout;
import com.huobi.view.TradeBuySellView;
import com.huobi.view.bottompopfragmentmenu.BottomMenuFragment;
import com.huobi.view.bottompopfragmentmenu.MenuItem;
import com.huobi.view.bottompopfragmentmenu.MenuItemOnClickListener;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.huobi.view.seekbar.MultiConfigBuilder;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.k4;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observer;
import k6.b;
import k6.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pk.a2;
import pk.b2;
import pk.c2;
import pk.d2;
import pk.e2;
import pk.f2;
import pk.g2;
import pk.h2;
import pk.i2;
import pk.j2;
import pk.k1;
import pk.k2;
import pk.l1;
import pk.l2;
import pk.m1;
import pk.m2;
import pk.n1;
import pk.n2;
import pk.o1;
import pk.o2;
import pk.p1;
import pk.p2;
import pk.q1;
import pk.r1;
import pk.s1;
import pk.t1;
import pk.u1;
import pk.v1;
import pk.w1;
import pk.x1;
import pk.y1;
import pk.z1;
import pro.huobi.R;
import rx.Observable;

public class FutureTradeView extends FrameLayout implements a, m0<LinearSwapAccountInfo>, Observer {
    public ContractGearsTradePriceEditText A;
    public FutureTpSlSettingParams A0;
    public EditText B;
    public FutureTpSlSettingDialogFragment B0;
    public ImageButton C;
    public final List<String> C0;
    public ViewGroup D;
    public MagicIndicator D0;
    public TextView E;
    public Context E0;
    public ContractTradeAmountView F;
    public String F0;
    public EditText G;
    public String G0;
    public RelativeLayout H;
    public String H0;
    public TextView I;
    public String I0;
    public TextView J;
    public boolean J0;
    public TextView K;
    public boolean K0;
    public TextView L;
    public boolean L0;
    public LinearLayout M;
    public boolean M0;
    public TextView N;
    public final BottomMenuFragment N0;
    public TextView O;
    public final LeverSelectDialogFragment O0;
    public TextView P;
    public final CommonListPopupDialog P0;
    public ImageView Q;
    public final List<CommonPopListItem> Q0;
    public View R;
    public final BottomMenuFragment R0;
    public ImageView S;
    public final CommonListPopupDialog S0;
    public ImageView T;
    public final CommonListPopupDialog T0;
    public TextView U;
    public final List<MenuItem> U0;
    public TextView V;
    public final List<MenuItem> V0;
    public ViewGroup W;
    public ViewGroup W0;
    public TextView X0;
    public int Y0;
    public MultiColorSeekBar Z0;

    /* renamed from: a0  reason: collision with root package name */
    public ViewGroup f44883a0;

    /* renamed from: a1  reason: collision with root package name */
    public k4 f44884a1;

    /* renamed from: b  reason: collision with root package name */
    public String f44885b;

    /* renamed from: b0  reason: collision with root package name */
    public TradeTrendView f44886b0;

    /* renamed from: b1  reason: collision with root package name */
    public AbstractMaintenanceView f44887b1;

    /* renamed from: c  reason: collision with root package name */
    public String f44888c;

    /* renamed from: c0  reason: collision with root package name */
    public View f44889c0;

    /* renamed from: c1  reason: collision with root package name */
    public HuobiKeyboardHelper f44890c1;

    /* renamed from: d  reason: collision with root package name */
    public int f44891d;

    /* renamed from: d0  reason: collision with root package name */
    public View f44892d0;

    /* renamed from: d1  reason: collision with root package name */
    public HBDialogFragment f44893d1;

    /* renamed from: e  reason: collision with root package name */
    public int f44894e;

    /* renamed from: e0  reason: collision with root package name */
    public ContractTpslLayout f44895e0;

    /* renamed from: e1  reason: collision with root package name */
    public final TradeType f44896e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44897f;

    /* renamed from: f0  reason: collision with root package name */
    public CheckBox f44898f0;

    /* renamed from: f1  reason: collision with root package name */
    public View f44899f1;

    /* renamed from: g  reason: collision with root package name */
    public int f44900g;

    /* renamed from: g0  reason: collision with root package name */
    public BottomLineTextView f44901g0;

    /* renamed from: g1  reason: collision with root package name */
    public boolean f44902g1;

    /* renamed from: h  reason: collision with root package name */
    public nk.e f44903h;

    /* renamed from: h0  reason: collision with root package name */
    public View f44904h0;

    /* renamed from: h1  reason: collision with root package name */
    public View f44905h1;

    /* renamed from: i  reason: collision with root package name */
    public LinearSwapAccountInfo f44906i;

    /* renamed from: i0  reason: collision with root package name */
    public View f44907i0;

    /* renamed from: i1  reason: collision with root package name */
    public View f44908i1;

    /* renamed from: j  reason: collision with root package name */
    public AccountBalanceInfoV5 f44909j;

    /* renamed from: j0  reason: collision with root package name */
    public ContractTpslEditText f44910j0;

    /* renamed from: j1  reason: collision with root package name */
    public BottomLineTextView f44911j1;

    /* renamed from: k  reason: collision with root package name */
    public int f44912k;

    /* renamed from: k0  reason: collision with root package name */
    public ContractTpslEditText f44913k0;

    /* renamed from: k1  reason: collision with root package name */
    public CheckBox f44914k1;

    /* renamed from: l  reason: collision with root package name */
    public View f44915l;

    /* renamed from: l0  reason: collision with root package name */
    public EditText f44916l0;

    /* renamed from: l1  reason: collision with root package name */
    public LinearLayout f44917l1;

    /* renamed from: m  reason: collision with root package name */
    public TextView f44918m;

    /* renamed from: m0  reason: collision with root package name */
    public EditText f44919m0;

    /* renamed from: m1  reason: collision with root package name */
    public TextView f44920m1;

    /* renamed from: n  reason: collision with root package name */
    public ImageView f44921n;

    /* renamed from: n0  reason: collision with root package name */
    public ImageView f44922n0;

    /* renamed from: n1  reason: collision with root package name */
    public FragmentManager f44923n1;

    /* renamed from: o  reason: collision with root package name */
    public TextView f44924o;

    /* renamed from: o1  reason: collision with root package name */
    public CommonPopListItem f44925o1;

    /* renamed from: p  reason: collision with root package name */
    public ImageView f44926p;

    /* renamed from: p1  reason: collision with root package name */
    public final MenuItemOnClickListener f44927p1;

    /* renamed from: q  reason: collision with root package name */
    public RelativeLayout f44928q;

    /* renamed from: q1  reason: collision with root package name */
    public final MenuItemOnClickListener f44929q1;

    /* renamed from: r  reason: collision with root package name */
    public ViewGroup f44930r;

    /* renamed from: r1  reason: collision with root package name */
    public final CommonPopListItem.a f44931r1;

    /* renamed from: s  reason: collision with root package name */
    public ContractTradePriceEditext f44932s;

    /* renamed from: s1  reason: collision with root package name */
    public final CommonPopListItem.a f44933s1;

    /* renamed from: t  reason: collision with root package name */
    public EditText f44934t;

    /* renamed from: t0  reason: collision with root package name */
    public ImageView f44935t0;

    /* renamed from: t1  reason: collision with root package name */
    public final CommonPopListItem.a f44936t1;

    /* renamed from: u  reason: collision with root package name */
    public ViewGroup f44937u;

    /* renamed from: u0  reason: collision with root package name */
    public View f44938u0;

    /* renamed from: u1  reason: collision with root package name */
    public final LeverSelectDialogFragment.h f44939u1;

    /* renamed from: v  reason: collision with root package name */
    public TextView f44940v;

    /* renamed from: v0  reason: collision with root package name */
    public TextView f44941v0;

    /* renamed from: w  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44942w;

    /* renamed from: w0  reason: collision with root package name */
    public ContractMarketTwTradeLayout f44943w0;

    /* renamed from: x  reason: collision with root package name */
    public EditText f44944x;

    /* renamed from: x0  reason: collision with root package name */
    public FutureTpSlSettingParams f44945x0;

    /* renamed from: y  reason: collision with root package name */
    public View f44946y;

    /* renamed from: y0  reason: collision with root package name */
    public FutureTpSlSettingParams f44947y0;

    /* renamed from: z  reason: collision with root package name */
    public View f44948z;

    /* renamed from: z0  reason: collision with root package name */
    public FutureTpSlSettingParams f44949z0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            int d11 = FutureTradeView.this.f44886b0.d();
            FutureTradeView.this.f44886b0.l(d11 / 2, d11);
            return true;
        }
    }

    public class b implements BaseDialogFragment.c {
        public b() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeView.this.f44921n.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeView.this.f44921n.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class c implements BaseDialogFragment.c {
        public c() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeView.this.f44942w.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeView.this.f44942w.p(R.drawable.trade_arrow_up);
        }
    }

    public class d implements BaseDialogFragment.c {
        public d() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeView.this.f44926p.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeView.this.f44926p.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class e implements MultiColorSeekBar.OnProgressChangedListener {
        public e() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                FutureTradeView.this.q1(i11);
            }
        }
    }

    public class f implements ContractGearsTradePriceEditText.c {
        public f() {
        }

        public void a() {
            FutureTradeView.this.T0.showAsDropDown(((FragmentActivity) FutureTradeView.this.getContext()).getSupportFragmentManager(), (View) FutureTradeView.this.A, true, 0, 0, 80);
        }

        public void b() {
        }
    }

    public class g implements BaseDialogFragment.c {
        public g() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeView.this.A.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeView.this.A.p(R.drawable.trade_arrow_up);
        }
    }

    public class h implements TextWatcher {
        public h() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                FutureTradeView.this.B.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_regular));
            } else {
                FutureTradeView.this.B.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_medium));
            }
            if (i6.m.b(editable, 10, 1) != null) {
                FutureTradeView futureTradeView = FutureTradeView.this;
                futureTradeView.I2(futureTradeView.B, editable.toString());
                return;
            }
            FutureTradeView.this.D2();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class i implements ViewTreeObserver.OnPreDrawListener {
        public i() {
        }

        public boolean onPreDraw() {
            FutureTradeView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int d11 = FutureTradeView.this.f44886b0.d();
            FutureTradeView.this.f44886b0.l(d11 / 2, d11);
            return true;
        }
    }

    public class j implements MenuItemOnClickListener {
        public j() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : FutureTradeView.this.U0) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            if (i11 == 0) {
                FutureTradeView.this.f44903h.p().j(0);
                if (com.hbg.lib.core.util.w.l()) {
                    FutureTradeView.this.S.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    FutureTradeView.this.S.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                if (FutureTradeView.this.f44886b0 != null) {
                    FutureTradeView.this.f44886b0.c(0);
                }
            } else if (i11 == 1) {
                FutureTradeView.this.f44903h.p().j(1);
                if (com.hbg.lib.core.util.w.l()) {
                    FutureTradeView.this.S.setImageResource(R.drawable.trade_trend_red);
                } else {
                    FutureTradeView.this.S.setImageResource(R.drawable.trade_trend_green);
                }
                if (FutureTradeView.this.f44886b0 != null) {
                    FutureTradeView.this.f44886b0.c(1);
                }
            } else {
                FutureTradeView.this.f44903h.p().j(2);
                if (com.hbg.lib.core.util.w.l()) {
                    FutureTradeView.this.S.setImageResource(R.drawable.trade_trend_green);
                } else {
                    FutureTradeView.this.S.setImageResource(R.drawable.trade_trend_red);
                }
                if (FutureTradeView.this.f44886b0 != null) {
                    FutureTradeView.this.f44886b0.c(2);
                }
            }
            FutureTradeView.this.f44903h.p().l(false);
            FutureTradeView.this.R0.dismiss();
        }
    }

    public class k implements ContractTpslEditText.c {
        public k() {
        }

        public void afterTextChanged(EditText editText, String str) {
            if (editText == FutureTradeView.this.f44916l0) {
                if (FutureTradeView.this.w2()) {
                    FutureTradeView futureTradeView = FutureTradeView.this;
                    FutureTpSlSettingParams unused = futureTradeView.f44945x0 = FutureTpSlSettingParams.changeTpSlCache(futureTradeView.f44945x0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
                    return;
                }
                FutureTradeView futureTradeView2 = FutureTradeView.this;
                FutureTpSlSettingParams unused2 = futureTradeView2.f44949z0 = FutureTpSlSettingParams.changeTpSlCache(futureTradeView2.f44949z0, FutureTpSlSettingDialogFragment.OpenType.OpenShort, str);
            } else if (editText != FutureTradeView.this.f44919m0) {
            } else {
                if (FutureTradeView.this.w2()) {
                    FutureTradeView futureTradeView3 = FutureTradeView.this;
                    FutureTpSlSettingParams unused3 = futureTradeView3.f44947y0 = FutureTpSlSettingParams.changeTpSlCache(futureTradeView3.f44947y0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
                    return;
                }
                FutureTradeView futureTradeView4 = FutureTradeView.this;
                FutureTpSlSettingParams unused4 = futureTradeView4.A0 = FutureTpSlSettingParams.changeTpSlCache(futureTradeView4.A0, FutureTpSlSettingDialogFragment.OpenType.OpenShort, str);
            }
        }

        public int getTradePricePrecision() {
            if (FutureTradeView.this.f44903h.o() != null) {
                return FuturePrecisionUtil.y(FutureTradeView.this.f44903h.o().getContractCode(), FutureTradeView.this.f44903h.o().getContractShortType(), (String) null);
            }
            return 14;
        }
    }

    public class l implements MenuItemOnClickListener {
        public l() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (FutureTradeView.this.f44903h.p() != null) {
                FutureTradeView.this.f44903h.p().b(i11);
            }
            FutureTradeView.this.N0.dismiss();
        }
    }

    public class m implements CommonPopListItem.a {
        public m() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            FutureTradeView.this.P0.dismiss();
            int type = commonPopListItem.getType();
            if (type == FutureTradeView.this.f44900g) {
                return;
            }
            if (type != 0 || (FutureTradeView.this.f44900g != 3 && FutureTradeView.this.f44900g != 4)) {
                FutureTradeView.this.T0(type);
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                if (type != 0) {
                    if (type == 1) {
                        ContractGuideHelper.b(fragmentActivity, 4);
                        return;
                    } else if (!(type == 2 || type == 3 || type == 4 || type == 6)) {
                        return;
                    }
                }
                if (!FutureTradeView.this.f44902g1) {
                    ContractGuideHelper.b(fragmentActivity, 1);
                }
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == FutureTradeView.this.f44900g || (commonPopListItem.getType() == 0 && (FutureTradeView.this.f44900g == 3 || FutureTradeView.this.f44900g == 4));
        }
    }

    public class n implements CommonPopListItem.a {
        public n() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            String str;
            FutureTradeView.this.f44942w.setPriceInputType(commonPopListItem.getType());
            FutureTradeView.this.f44942w.setCurrentPriceTypeText(commonPopListItem.getText());
            FutureTradeView.this.S0.dismiss();
            if (!TextUtils.isEmpty(is.a.f(FutureTradeView.this.f44896e1))) {
                if (commonPopListItem.getType() == 2) {
                    str = "BBO";
                } else if (commonPopListItem.getType() == 3) {
                    str = "optimal5";
                } else if (commonPopListItem.getType() == 4) {
                    str = "optimal10";
                } else {
                    str = commonPopListItem.getType() == 5 ? "optimal20" : "";
                }
                HashMap hashMap = new HashMap();
                hashMap.put("type", str);
                is.a.j("5147", hashMap, is.a.f(FutureTradeView.this.f44896e1));
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return FutureTradeView.this.f44942w.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class o implements CommonPopListItem.a {
        public o() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            FutureTradeView.this.A.setPriceInputType(commonPopListItem.getType());
            FutureTradeView.this.A.setCurrentPriceTypeText(commonPopListItem.getText());
            FutureTradeView.this.T0.dismiss();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return FutureTradeView.this.A.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class p implements LeverSelectDialogFragment.h {
        public p() {
        }

        public void N0() {
            if (FutureTradeView.this.f44903h != null) {
                FutureTradeView.this.f44903h.y().N0();
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return uc.b.d(tradeType, str, i11);
        }

        public void P0(String str) {
            FutureTradeView.this.x0(str);
            FutureTradeView.this.f44903h.K(str);
            FutureTradeView.this.f44903h.F();
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return FutureTradeView.this.f44903h.l(str, levelAvailableMarginInfo);
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            if (FutureTradeView.this.f44903h != null) {
                FutureTradeView.this.f44903h.E(leverSelectDialogFragment, str);
            }
            if (TextUtils.isEmpty(is.a.f(FutureTradeView.this.f44896e1))) {
                return true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            is.a.j("5148", hashMap, is.a.f(FutureTradeView.this.f44896e1));
            return true;
        }
    }

    public class q implements ContractTradeAmountView.a {
        public q() {
        }

        public String o0() {
            return FutureTradeView.this.f44903h.v();
        }
    }

    public class r extends CommonNavigatorAdapter {
        public r() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (FutureTradeView.this.f44891d == i11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            FutureTradeView.this.w0(true, true);
            FutureTradeView.this.t0();
            FutureTradeView.this.u1(i11);
            FutureTradeView.this.w1();
            if (i11 == 0) {
                if (FutureTradeView.this.f44894e == 0) {
                    FutureTradeView.this.L0();
                    if (FutureTradeView.this.f44945x0 == null || FutureTradeView.this.f44945x0.getTriggerPrice() == null) {
                        FutureTradeView.this.y1();
                    } else {
                        FutureTradeView futureTradeView = FutureTradeView.this;
                        futureTradeView.setTpText(futureTradeView.f44945x0.getTriggerPrice().toPlainString());
                    }
                    if (FutureTradeView.this.f44947y0 == null || FutureTradeView.this.f44947y0.getTriggerPrice() == null) {
                        FutureTradeView.this.x1();
                    } else {
                        FutureTradeView futureTradeView2 = FutureTradeView.this;
                        futureTradeView2.setSlText(futureTradeView2.f44947y0.getTriggerPrice().toPlainString());
                    }
                } else {
                    FutureTradeView.this.U0();
                }
                FutureTradeView.this.f44895e0.refreshTpSlView(FutureTradeView.this.f44945x0, FutureTradeView.this.f44947y0);
            } else if (i11 == 1) {
                if (FutureTradeView.this.f44894e == 0) {
                    FutureTradeView.this.U0();
                    if (FutureTradeView.this.f44949z0 == null || FutureTradeView.this.f44949z0.getTriggerPrice() == null) {
                        FutureTradeView.this.y1();
                    } else {
                        FutureTradeView futureTradeView3 = FutureTradeView.this;
                        futureTradeView3.setTpText(futureTradeView3.f44949z0.getTriggerPrice().toPlainString());
                    }
                    if (FutureTradeView.this.A0 == null || FutureTradeView.this.A0.getTriggerPrice() == null) {
                        FutureTradeView.this.x1();
                    } else {
                        FutureTradeView futureTradeView4 = FutureTradeView.this;
                        futureTradeView4.setSlText(futureTradeView4.A0.getTriggerPrice().toPlainString());
                    }
                } else {
                    FutureTradeView.this.L0();
                }
                FutureTradeView.this.f44895e0.refreshTpSlView(FutureTradeView.this.f44949z0, FutureTradeView.this.A0);
            }
            FutureTradeView.this.f44903h.j(false);
            FutureTradeView.this.D0.c(i11);
            FutureTradeView.this.D0.b(i11, 0.0f, 0);
            if (FutureTradeView.this.Y0 == 5) {
                FutureTradeView.this.G.setText("");
                String unused = FutureTradeView.this.I0 = null;
                String unused2 = FutureTradeView.this.H0 = null;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return FutureTradeView.this.C0.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            FutureTradeView.this.G1();
            if (i11 == 0) {
                tradeBuySellView.setNormalColor(ContextCompat.getColor(FutureTradeView.this.E0, R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(FutureTradeView.this.E0, R.color.baseTextColor));
                if (FutureTradeView.this.f44894e == 0) {
                    if (com.hbg.lib.core.util.w.l()) {
                        tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                        tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg);
                    } else {
                        tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                        tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg);
                    }
                } else if (com.hbg.lib.core.util.w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg);
                }
            } else {
                tradeBuySellView.setNormalColor(ContextCompat.getColor(FutureTradeView.this.E0, R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(FutureTradeView.this.E0, R.color.baseTextColor));
                if (FutureTradeView.this.f44894e == 0) {
                    if (com.hbg.lib.core.util.w.l()) {
                        tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_right);
                        tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg_right);
                    } else {
                        tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_right);
                        tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg_right);
                    }
                } else if (com.hbg.lib.core.util.w.l()) {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_red_vertical_light_bg_right);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_green_bg_right);
                } else {
                    tradeBuySellView.setSelectedDrawable(R.drawable.shape_exchange_green_vertical_light_bg_right);
                    tradeBuySellView.setNormalDrawable(R.drawable.shape_contract_trade_view_indicator_red_bg_right);
                }
            }
            tradeBuySellView.setTextSize(1, 14.0f);
            tradeBuySellView.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) FutureTradeView.this.C0.get(i11));
            tradeBuySellView.setOnClickListener(new p2(this, i11));
            return tradeBuySellView;
        }
    }

    public class s extends BaseSubscriber<FutureUserInfo> {
        public s() {
        }

        /* renamed from: a */
        public void onNext(FutureUserInfo futureUserInfo) {
            super.onNext(futureUserInfo);
            FutureTradeView futureTradeView = FutureTradeView.this;
            futureTradeView.u1(futureTradeView.f44891d);
        }
    }

    public class t implements TextWatcher {
        public t() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                FutureTradeView.this.f44934t.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_regular));
            } else {
                FutureTradeView.this.f44934t.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_medium));
            }
            FutureTradeView futureTradeView = FutureTradeView.this;
            futureTradeView.J2(futureTradeView.f44903h.q(editable.toString()));
            String str = null;
            if (FutureTradeView.this.f44903h.o() != null) {
                str = i6.m.b(editable, 10, FuturePrecisionUtil.y(FutureTradeView.this.f44903h.o().getContractCode(), FutureTradeView.this.f44903h.o().getContractShortType(), (String) null));
            }
            if (str != null) {
                FutureTradeView futureTradeView2 = FutureTradeView.this;
                futureTradeView2.I2(futureTradeView2.f44934t, editable.toString());
            }
            FutureTradeView.this.D2();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class u implements ContractGearsTradePriceEditText.c {
        public u() {
        }

        public void a() {
            FutureTradeView.this.E1();
        }

        public void b() {
            FutureTradeView.this.E1();
        }
    }

    public class v implements TextWatcher {
        public v() {
        }

        public void afterTextChanged(Editable editable) {
            int tradePriceType = FutureTradeView.this.getTradePriceType();
            if (editable.length() == 0) {
                FutureTradeView.this.f44944x.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_regular));
                FutureTradeView.this.x2("0");
            } else {
                FutureTradeView.this.f44944x.setTypeface(ResourcesCompat.h(FutureTradeView.this.getContext(), R.font.roboto_medium));
            }
            FutureTradeView futureTradeView = FutureTradeView.this;
            futureTradeView.X0(futureTradeView.f44903h.q(editable.toString()));
            String str = null;
            if (tradePriceType == 1 && FutureTradeView.this.f44903h.o() != null) {
                str = i6.m.b(editable, 10, FuturePrecisionUtil.y(FutureTradeView.this.f44903h.o().getContractCode(), FutureTradeView.this.f44903h.o().getContractShortType(), (String) null));
            }
            if (str != null) {
                FutureTradeView futureTradeView2 = FutureTradeView.this;
                futureTradeView2.I2(futureTradeView2.f44944x, editable.toString());
                return;
            }
            if (FutureTradeView.this.f44894e == 0) {
                if (FutureTradeView.this.f44944x.hasFocus()) {
                    boolean unused = FutureTradeView.this.J0 = false;
                }
                if (FutureTradeView.this.f44900g != 5) {
                    String unused2 = FutureTradeView.this.F0 = editable.toString();
                }
            } else {
                if (FutureTradeView.this.f44944x.hasFocus()) {
                    boolean unused3 = FutureTradeView.this.K0 = false;
                }
                if (FutureTradeView.this.f44900g != 5) {
                    String unused4 = FutureTradeView.this.G0 = editable.toString();
                }
            }
            FutureTradeView.this.f44903h.j(false);
            FutureTradeView.this.D2();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class w implements TextWatcher {
        public w() {
        }

        public void afterTextChanged(Editable editable) {
            String m11;
            if (editable.length() == 0) {
                int unused = FutureTradeView.this.Y0 = 0;
            }
            String obj = editable.toString();
            if (FutureTradeView.this.Y0 == 0) {
                if (FutureTradeView.this.f44894e == 0) {
                    String unused2 = FutureTradeView.this.H0 = obj;
                } else {
                    String unused3 = FutureTradeView.this.I0 = obj;
                }
            }
            if (editable.length() == 0) {
                FutureTradeView.this.G.setTypeface(ResourcesCompat.h(FutureTradeView.this.G.getContext(), R.font.roboto_regular));
                FutureTradeView.this.x2("0");
                return;
            }
            FutureTradeView.this.G.setTypeface(ResourcesCompat.h(FutureTradeView.this.G.getContext(), R.font.roboto_medium));
            String str = null;
            if (!a7.e.E(FutureTradeView.this.f44896e1) && !a7.e.G(FutureTradeView.this.f44896e1)) {
                if (FutureTradeView.this.Y0 == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = i6.m.b(editable, 10, FuturePrecisionUtil.B());
                    }
                }
                if (str != null) {
                    FutureTradeView futureTradeView = FutureTradeView.this;
                    futureTradeView.I2(futureTradeView.G, str);
                    return;
                }
            } else if (FutureTradeView.this.Y0 == 0 && (m11 = FutureTradeView.this.f44903h.m(editable)) != null) {
                FutureTradeView futureTradeView2 = FutureTradeView.this;
                futureTradeView2.I2(futureTradeView2.G, m11);
                return;
            }
            FutureTradeView.this.f44903h.k(false, true);
            FutureTradeView.this.D2();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class x implements TradeTrendView.b {
        public x() {
        }

        public void a(c.a aVar) {
            if (FutureTradeView.this.f44903h.o() != null) {
                FutureTradeView.this.setPriceText(i6.m.i(aVar.a(), FuturePrecisionUtil.y(FutureTradeView.this.f44903h.o().getContractCode(), FutureTradeView.this.f44903h.o().getContractShortType(), (String) null)));
            }
            FutureTradeView.this.t0();
            FutureTradeView.this.f44890c1.hideKeyboard();
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
            if (FutureTradeView.this.f44903h.o() != null) {
                FutureTradeView.this.setPriceText(i6.m.m(aVar.b(), FuturePrecisionUtil.y(FutureTradeView.this.f44903h.o().getContractCode(), FutureTradeView.this.f44903h.o().getContractShortType(), (String) null)));
            }
        }
    }

    public FutureTradeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1(int i11) {
        if (i11 == 0) {
            T0(0);
            this.f44925o1.setType(0);
        } else if (i11 == 1) {
            T0(3);
            this.f44925o1.setType(3);
        } else {
            T0(4);
            this.f44925o1.setType(4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void P1(View view) {
        if (this.f44923n1 != null) {
            LimitChooseDialog vh2 = LimitChooseDialog.vh();
            Bundle bundle = new Bundle();
            int i11 = this.f44900g;
            bundle.putInt("selIndex", i11 == 0 ? 0 : i11 == 3 ? 1 : 2);
            vh2.setArguments(bundle);
            vh2.wh(new c2(this)).show(this.f44923n1, "limitChoose");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Q1(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        sn.f.f(this.f44896e1, getContext());
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R1(View view, boolean z11) {
        if (z11) {
            setProgress(0);
            if (this.Y0 == 5) {
                this.G.setText("");
            }
            if (w2()) {
                if (com.hbg.lib.core.util.w.l()) {
                    this.F.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
                } else {
                    this.F.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                this.F.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
            } else {
                this.F.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
            }
        } else {
            this.F.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
        this.f44884a1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void S1(View view) {
        if (!this.f44903h.p().h()) {
            this.N0.show(((Activity) this.E0).getFragmentManager(), "depthBottomMenuFragment");
        }
        this.f44890c1.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void T1(View view) {
        this.f44890c1.hideKeyboard();
        this.f44903h.O();
        gs.g.j(this.f44888c, this.f44885b, "lever_adjust", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void U1(View view) {
        this.R0.show(((Activity) this.E0).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void V1(View view) {
        this.f44942w.clearFocus();
        this.f44890c1.hideKeyboard();
        this.P0.showAsDropDown(((FragmentActivity) this.E0).getSupportFragmentManager(), this.f44915l);
        if (!TextUtils.isEmpty(is.a.f(this.f44896e1))) {
            is.a.j("5182", (Map<String, Object>) null, is.a.f(this.f44896e1));
        }
        gs.g.j(this.f44888c, this.f44885b, "entrust_model", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W1() {
        this.Q.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X1() {
        this.Q.setImageResource(R.drawable.trade_arrow_down_new);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Y1(CompoundButton compoundButton, boolean z11) {
        gl.b.b(this.f44896e1, z11);
        HashMap hashMap = new HashMap();
        if (z11) {
            this.f44904h0.setVisibility(0);
            this.f44907i0.setVisibility(0);
            v1();
            hashMap.put("button_type", "open");
            gs.g.j(this.f44888c, this.f44885b, "stop_surplus_loss", (HashMap) null);
        } else {
            this.f44904h0.setVisibility(8);
            this.f44907i0.setVisibility(8);
            u0(true, false);
            v1();
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "split_screen");
        gs.g.i("take_profit_and_stop_loss_switch_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Z1(View view, MotionEvent motionEvent) {
        if (!tg.r.x().F0()) {
            ContractModuleConfig.a().h(this.f44896e1, getContext());
            return true;
        } else if (z6.l.c().i(this.f44896e1)) {
            return false;
        } else {
            HuobiToastUtil.j(R.string.n_contract_please_open_first);
            return true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void a2(CompoundButton compoundButton, boolean z11) {
        gl.a.b(this.f44896e1, z11);
        HashMap hashMap = new HashMap();
        if (z11) {
            hashMap.put("button_type", "open");
        } else {
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "split_screen");
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean b2(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        ContractModuleConfig.a().h(this.f44896e1, getContext());
        return true;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void c2(View view) {
        ContractGuideHelper.b((FragmentActivity) oa.a.g().b(), 2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d2(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        if (w2()) {
            this.f44945x0 = B2(futureTpSlSettingParams, true);
            FutureTpSlSettingParams B2 = B2(futureTpSlSettingParams2, false);
            this.f44947y0 = B2;
            this.f44895e0.refreshTpSlView(this.f44945x0, B2);
            return;
        }
        this.f44949z0 = B2(futureTpSlSettingParams, true);
        FutureTpSlSettingParams B22 = B2(futureTpSlSettingParams2, false);
        this.A0 = B22;
        this.f44895e0.refreshTpSlView(this.f44949z0, B22);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e2(FutureTpSlSettingDialogFragment.c cVar, View view) {
        if (TextUtils.isEmpty(this.f44903h.r())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!F2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f44890c1.hideKeyboard();
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = new FutureTpSlDialogShowBean();
            futureTpSlDialogShowBean.setTradeType(this.f44896e1);
            D1(futureTpSlDialogShowBean);
            FutureTpSlSettingDialogFragment Kh = FutureTpSlSettingDialogFragment.Kh(futureTpSlDialogShowBean);
            this.B0 = Kh;
            Kh.Vh(i6.m.a(String.valueOf(this.f44903h.p().e())));
            this.B0.Uh(cVar);
            this.B0.show(((FragmentActivity) this.E0).getSupportFragmentManager(), "FutureTpSettingDialogFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f2(View view) {
        if (w2()) {
            this.f44945x0 = null;
        } else {
            this.f44949z0 = null;
        }
        y1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g2(View view) {
        x1();
        if (w2()) {
            this.f44947y0 = null;
        } else {
            this.A0 = null;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private String getBboStr() {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return this.E0.getString(R.string.n_contract_trade_rival_price);
        }
        return this.E0.getString(R.string.n_contract_trade_optimal_one);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h2(View view) {
        sn.f.f(this.f44896e1, this.E0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i2(View view) {
        this.T0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.A, true, 0, 0, 80);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j2(View view) {
        DialogUtils.X((FragmentActivity) getContext(), getContext().getString(R.string.n_introduction), getContext().getString(R.string.n_contract_side_mode_only_reduce_prompt_description), "", getContext().getString(R.string.n_otc_optional_process_know), o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l2(View view) {
        this.f44890c1.hideKeyboard();
        if (!tg.r.x().F0()) {
            sn.f.f(this.f44896e1, this.E0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (z6.l.c().g(this.f44896e1) == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            z6.l.c().d(this.f44896e1, false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new s());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!z6.l.c().i(this.f44896e1)) {
            qk.m.d(getContext(), true, this.f44896e1);
            if (!TextUtils.isEmpty(is.a.f(this.f44896e1))) {
                is.a.j("4665", (Map<String, Object>) null, is.a.f(this.f44896e1));
            }
            if (TradeType.isLinearSwap(this.f44896e1)) {
                gs.g.i("App_linear_swap_open_click", (HashMap) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f44903h.Q(z1(w2()));
            if (!TextUtils.isEmpty(is.a.f(this.f44896e1))) {
                is.a.j(w2() ? "4683" : "4684", (Map<String, Object>) null, is.a.f(this.f44896e1));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("hold_model", "single");
            gs.g.j(this.f44885b, (String) null, w2() ? "buy_open" : "sell_open", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m2(View view, boolean z11) {
        C2(this.f44932s, z11);
        this.f44884a1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o2(View view) {
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ImageButton imageButton = this.C;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.C.isSelected()) {
            this.f44890c1.hideKeyboard();
            this.f44942w.setCurrentPriceTypeText(this.E0.getString(R.string.contract_trade_position_close_quick));
            this.f44942w.setPriceInputType(6);
            this.f44944x.setText("");
        } else {
            this.f44942w.setPriceInputType(1);
            this.f44903h.j(false);
        }
        setLightingSelect(this.C.isSelected());
        this.X0.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void p2(View view) {
        ContractGuideHelper.d(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), FutureTradeTogetherView.class.getName(), ContractGuideHelper.a(this.f44900g));
        gs.g.j(this.f44888c, this.f44885b, "entrust_model_explanation", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q2(View view) {
        int i11;
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.X0.isSelected() && ((i11 = this.f44900g) == 0 || i11 == 3 || i11 == 4)) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_spot_order_risk)).C0(getContext().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
        TextView textView = this.X0;
        textView.setSelected(!textView.isSelected());
        if (this.f44942w.k()) {
            this.f44942w.setPriceInputType(1);
            this.f44903h.j(false);
        } else {
            if (this.f44944x.hasFocus()) {
                this.f44890c1.hideKeyboard();
            }
            if (this.f44900g == 1) {
                this.f44942w.setCurrentPriceTypeText(this.E0.getString(R.string.n_contract_trade_optimal_five));
                this.f44942w.setPriceInputType(3);
            } else {
                this.f44942w.setCurrentPriceTypeText(getBboStr());
                this.f44942w.setPriceInputType(2);
            }
            this.f44944x.setText("");
        }
        setLightingSelect(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r2(View view, boolean z11) {
        C2(this.f44942w, z11);
        this.f44884a1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s2(View view) {
        E1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void setLightingSelect(boolean z11) {
        this.C.setSelected(z11);
        if (z11) {
            setProgress(100);
            q1(100);
        } else if (this.f44942w.getLastTradePriceType() == 6) {
            setProgress(0);
            if (this.f44894e == 0) {
                this.G.setText(this.H0);
            } else {
                this.G.setText(this.I0);
            }
        }
        D2();
    }

    /* access modifiers changed from: private */
    public void setSlText(String str) {
        this.f44919m0.setText(str);
    }

    /* access modifiers changed from: private */
    public void setTpText(String str) {
        this.f44916l0.setText(str);
    }

    public static /* synthetic */ void t2(HBDialogFragment hBDialogFragment) {
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u2(String str, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Rh((Activity) getContext(), str);
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    public void A0(int i11) {
        ViewGroup viewGroup = this.W0;
        if (viewGroup != null) {
            viewGroup.setVisibility(i11);
            this.f44887b1.setUI(this.f44903h.y());
            this.f44887b1.setCountDownTime(bj.d.n(this.f44896e1));
        }
    }

    public final void A1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
        if (futureTpSlSettingParams.getTriggerPrice() != null) {
            contractOrderPlace.L0(futureTpSlSettingParams.getTriggerPrice().toPlainString());
        }
        if (futureTpSlSettingParams.getEntrustPrice() != null) {
            contractOrderPlace.I0(futureTpSlSettingParams.getEntrustPrice().toPlainString());
        } else {
            contractOrderPlace.I0("");
        }
        contractOrderPlace.K0(futureTpSlSettingParams.getPriceType().getType());
        contractOrderPlace.J0(futureTpSlSettingParams.getPriceType().getName());
        contractOrderPlace.M0(futureTpSlSettingParams.getTriggerType());
        contractOrderPlace.T0(futureTpSlSettingParams.getTpslVolumeRate());
    }

    public void A2(List<CouponReturn> list, boolean z11) {
        int i11 = 8;
        if (CollectionsUtils.b(list)) {
            this.f44883a0.setVisibility(8);
            return;
        }
        this.f44883a0.setVisibility(0);
        ImageView imageView = this.T;
        if (z11) {
            i11 = 0;
        }
        imageView.setVisibility(i11);
        this.V.setText(String.format(getResources().getString(R.string.n_exchange_coupon_available_number), new Object[]{list.size() + ""}));
    }

    public final void B1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
        if (futureTpSlSettingParams.getTriggerPrice() != null) {
            contractOrderPlace.R0(futureTpSlSettingParams.getTriggerPrice().toPlainString());
        }
        if (futureTpSlSettingParams.getEntrustPrice() != null) {
            contractOrderPlace.O0(futureTpSlSettingParams.getEntrustPrice().toPlainString());
        } else {
            contractOrderPlace.O0("");
        }
        contractOrderPlace.Q0(futureTpSlSettingParams.getPriceType().getType());
        contractOrderPlace.P0(futureTpSlSettingParams.getPriceType().getName());
        contractOrderPlace.S0(futureTpSlSettingParams.getTriggerType());
        contractOrderPlace.T0(futureTpSlSettingParams.getTpslVolumeRate());
    }

    public final FutureTpSlSettingParams B2(FutureTpSlSettingParams futureTpSlSettingParams, boolean z11) {
        if (futureTpSlSettingParams == null) {
            if (z11) {
                y1();
            } else {
                x1();
            }
            return null;
        } else if (futureTpSlSettingParams.getTriggerPrice() == null) {
            return futureTpSlSettingParams;
        } else {
            if (z11) {
                setTpText(futureTpSlSettingParams.getTriggerPrice().toPlainString());
                return futureTpSlSettingParams;
            }
            setSlText(futureTpSlSettingParams.getTriggerPrice().toPlainString());
            return futureTpSlSettingParams;
        }
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.f44886b0;
        if (tradeTrendView != null) {
            tradeTrendView.setBuyList(list);
        }
    }

    public final FutureTpSlSettingParams C1(FutureTpSlSettingParams futureTpSlSettingParams) {
        if (futureTpSlSettingParams == null) {
            return new FutureTpSlSettingParams(FutureTpSlSettingDialogFragment.OpenType.OpenLong, PriceType.MARKET);
        }
        return new FutureTpSlSettingParams(futureTpSlSettingParams);
    }

    public final void C2(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        } else if (w2()) {
            if (com.hbg.lib.core.util.w.l()) {
                view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
            } else {
                view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
            }
        } else if (com.hbg.lib.core.util.w.l()) {
            view.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
        }
    }

    public void D1(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        if (ContractTpslLayout.isLimitlOrder(this.f44900g) && !this.f44942w.k()) {
            futureTpSlDialogShowBean.setEntrustPrice(i6.m.a(getInputPriceText()));
        }
        futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f44903h.u()).longValue()));
        futureTpSlDialogShowBean.setSingleMode(true);
        futureTpSlDialogShowBean.setMarginMode(getContext().getString(this.f44903h.t() == 1 ? R.string.n_contract_super_margin : R.string.n_contract_trade_margin));
        futureTpSlDialogShowBean.setLever(this.f44903h.r());
        futureTpSlDialogShowBean.setSymbol(this.f44903h.v());
        if (this.f44903h.o() != null) {
            futureTpSlDialogShowBean.setContractType(this.f44903h.o().getContractType());
            futureTpSlDialogShowBean.setContractCode(this.f44903h.o().getContractCode());
            futureTpSlDialogShowBean.setContractShortType(this.f44903h.o().getContractShortType());
            futureTpSlDialogShowBean.setPricePrecision(FuturePrecisionUtil.y(this.f44903h.o().getContractCode(), this.f44903h.o().getContractShortType(), (String) null));
            futureTpSlDialogShowBean.setPredictProfitPrecision(FuturePrecisionUtil.w(this.f44903h.o().getContractCode(), this.f44903h.o().getContractShortType(), (String) null));
            futureTpSlDialogShowBean.setContractFace(i6.m.a(this.f44903h.o().getContractFace()));
        }
        if (this.f44891d == 0) {
            FutureTpSlSettingParams C1 = C1(this.f44945x0);
            FutureTpSlSettingParams C12 = C1(this.f44947y0);
            FutureTpSlSettingDialogFragment.OpenType openType = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
            C1.setOpenType(openType);
            C12.setOpenType(openType);
            futureTpSlDialogShowBean.setStopProfitSetting(C1);
            futureTpSlDialogShowBean.setStopLossSetting(C12);
            return;
        }
        FutureTpSlSettingParams C13 = C1(this.f44949z0);
        FutureTpSlSettingParams C14 = C1(this.A0);
        FutureTpSlSettingDialogFragment.OpenType openType2 = FutureTpSlSettingDialogFragment.OpenType.OpenShort;
        C13.setOpenType(openType2);
        C14.setOpenType(openType2);
        futureTpSlDialogShowBean.setStopProfitSetting(C13);
        futureTpSlDialogShowBean.setStopLossSetting(C14);
    }

    public final void D2() {
        if (this.f44894e == 0) {
            boolean z11 = false;
            this.f44938u0.setVisibility(0);
            TextView textView = this.f44941v0;
            if (this.f44894e == 0) {
                z11 = true;
            }
            textView.setText(s1(z11));
            return;
        }
        this.f44938u0.setVisibility(8);
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.f44886b0;
        if (tradeTrendView != null) {
            tradeTrendView.setSellList(list);
        }
    }

    public final void E1() {
        if (this.f44942w.k()) {
            this.S0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f44942w, true, 0, 0, 80);
        }
    }

    public final void E2() {
        if (a7.e.E(this.f44896e1)) {
            if (TextUtils.isEmpty(this.f44903h.v())) {
                this.N.setText(R.string.n_contract_trade_input_amount);
                return;
            }
            this.N.setText(String.format(this.E0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f44903h.v()}));
        } else if (!a7.e.G(this.f44896e1)) {
            this.N.setText(String.format(this.E0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.E0.getString(R.string.n_contract_vol_sheet)}));
        } else if (TextUtils.isEmpty(this.f44903h.v())) {
            this.N.setText(R.string.n_contract_trade_input_amount);
        } else {
            this.N.setText(String.format(this.E0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{"usdt"}).toUpperCase(Locale.US));
        }
    }

    public final void F1(Context context, AttributeSet attributeSet) {
        this.E0 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.contract_trade_layout_for_only_reduce, this, true);
        dn.a.d().i((TextView) inflate.findViewById(R.id.account_available_label_tv));
        v1();
        this.f44938u0 = inflate.findViewById(R.id.rl_bond);
        this.f44941v0 = (TextView) inflate.findViewById(R.id.tv_bond2);
        this.f44886b0 = (TradeTrendView) inflate.findViewById(R.id.contract_trade_trend_view);
        this.f44918m = (TextView) inflate.findViewById(R.id.order_type_tv);
        this.f44899f1 = inflate.findViewById(R.id.iv_contract_guide);
        this.f44915l = inflate.findViewById(R.id.order_type_ll);
        this.f44921n = (ImageView) inflate.findViewById(R.id.order_type_arrow_iv);
        this.f44924o = (TextView) inflate.findViewById(R.id.contract_trade_lever_value_tv);
        this.f44926p = (ImageView) inflate.findViewById(R.id.contract_trade_lever_arrow_iv);
        this.f44928q = (RelativeLayout) inflate.findViewById(R.id.contract_trade_lever_ll);
        this.f44930r = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_view_container);
        ContractTradePriceEditext contractTradePriceEditext = (ContractTradePriceEditext) inflate.findViewById(R.id.contract_trigger_price_view);
        this.f44932s = contractTradePriceEditext;
        contractTradePriceEditext.setTradeType(this.f44896e1);
        this.f44934t = this.f44932s.getEditText();
        this.f44937u = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_convert_container);
        this.f44940v = (TextView) inflate.findViewById(R.id.contract_trigger_price_convert_tv);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.contract_trade_price_view);
        this.f44942w = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setTradeType(this.f44896e1);
        this.f44942w.setClearEnable(true);
        this.f44944x = this.f44942w.getEditText();
        this.f44946y = inflate.findViewById(R.id.track_price_rl);
        this.f44948z = inflate.findViewById(R.id.call_back_rate_ll);
        this.A = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.track_price_view);
        this.B = (EditText) inflate.findViewById(R.id.call_back_rate_et);
        this.C = (ImageButton) inflate.findViewById(R.id.lighting_trade_ib);
        this.D = (ViewGroup) inflate.findViewById(R.id.contract_price_convert_container);
        this.E = (TextView) inflate.findViewById(R.id.contract_price_convert_tv);
        ContractTradeAmountView contractTradeAmountView = (ContractTradeAmountView) inflate.findViewById(R.id.contract_trade_amount_view);
        this.F = contractTradeAmountView;
        this.G = contractTradeAmountView.getEditText();
        this.f44917l1 = (LinearLayout) inflate.findViewById(R.id.llLimitChoose);
        this.f44920m1 = (TextView) inflate.findViewById(R.id.tvLimitTitle);
        this.f44917l1.setOnClickListener(new l1(this));
        this.Z0 = (MultiColorSeekBar) inflate.findViewById(R.id.contract_seekbar_new);
        this.H = (RelativeLayout) inflate.findViewById(R.id.trade_confirm_ll);
        this.I = (TextView) inflate.findViewById(R.id.trade_confirm_btn);
        this.J = (TextView) inflate.findViewById(R.id.trade_instruction_tv);
        this.K = (TextView) inflate.findViewById(R.id.trade_mask_title_tv);
        this.W0 = (ViewGroup) inflate.findViewById(R.id.safeguard_trade_ll);
        AbstractMaintenanceView p11 = AbstractMaintenanceView.p(context, this.f44896e1);
        this.f44887b1 = p11;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) p11.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f44887b1.setLayoutParams(layoutParams);
        this.W0.addView(this.f44887b1);
        this.f44887b1.h();
        this.f44887b1.setTopMargin(84);
        this.f44887b1.setTradeSafeguardHint(a7.e.B(this.f44896e1, context));
        this.L = (TextView) inflate.findViewById(R.id.trade_suspend_instruction_tv);
        this.M = (LinearLayout) inflate.findViewById(R.id.stop_trade_ll);
        this.N = (TextView) inflate.findViewById(R.id.contract_vertical_amount_label_tv);
        this.O = (TextView) inflate.findViewById(R.id.contract_vertical_price_label_tv);
        this.U = (TextView) inflate.findViewById(R.id.input_volume_value_tv);
        this.X0 = (TextView) inflate.findViewById(R.id.contract_trade_rival_price_tv);
        this.D0 = (MagicIndicator) inflate.findViewById(R.id.buy_shell_indicator);
        this.W = (ViewGroup) inflate.findViewById(R.id.contract_volume_rl);
        this.f44883a0 = (ViewGroup) inflate.findViewById(R.id.contract_coupon_rl);
        this.V = (TextView) inflate.findViewById(R.id.contract_coupon_value_tv);
        this.T = (ImageView) inflate.findViewById(R.id.contract_coupon_red_iv);
        this.f44905h1 = inflate.findViewById(R.id.contract_market_rl);
        this.f44908i1 = inflate.findViewById(R.id.trade_price_ll_container);
        ContractTpslLayout contractTpslLayout = (ContractTpslLayout) inflate.findViewById(R.id.contract_tp_sl_include);
        this.f44895e0 = contractTpslLayout;
        contractTpslLayout.setTradeType(this.f44896e1);
        this.f44889c0 = inflate.findViewById(R.id.contract_tp_sl_switch_container);
        this.f44892d0 = inflate.findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_sl_tv);
        this.f44901g0 = bottomLineTextView;
        bottomLineTextView.setTextMaxWidth(PixelUtils.a(70.0f));
        this.f44901g0.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.f44901g0.setTextColor(R.color.baseColorSecondaryText);
        this.f44898f0 = (CheckBox) inflate.findViewById(R.id.contract_tp_sl_switch_iv);
        this.f44904h0 = inflate.findViewById(R.id.contract_tp_sl_input_container);
        this.f44907i0 = inflate.findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) inflate.findViewById(R.id.contract_tp_input_container);
        this.f44910j0 = contractTpslEditText;
        this.f44916l0 = contractTpslEditText.getEditText();
        this.f44922n0 = this.f44910j0.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) inflate.findViewById(R.id.contract_sl_input_container);
        this.f44913k0 = contractTpslEditText2;
        this.f44919m0 = contractTpslEditText2.getEditText();
        this.f44935t0 = this.f44913k0.getClearImageView();
        k kVar = new k();
        this.f44910j0.setCallback(kVar);
        this.f44913k0.setCallback(kVar);
        this.f44943w0 = (ContractMarketTwTradeLayout) inflate.findViewById(R.id.contract_market_twtrade_rl);
        HuobiKeyboardHelper registerInput = new HuobiKeyboardHelper().attach((Activity) this.E0).registerInput(this.f44934t, this.f44944x, this.B, this.f44916l0, this.f44919m0).registerInput(this.G, new w1(this));
        this.f44890c1 = registerInput;
        this.f44932s.setKeyboardHelper(registerInput);
        this.f44926p.setVisibility(0);
        this.f44924o.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.O.setText(R.string.n_exchange_order_list_price);
        this.f44914k1 = (CheckBox) inflate.findViewById(R.id.contract_tp_only_reduce_switch_iv);
        BottomLineTextView bottomLineTextView2 = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_only_reduce_tv);
        this.f44911j1 = bottomLineTextView2;
        bottomLineTextView2.setBottomLineText(getContext().getString(R.string.n_contract_side_mode_only_reduce));
        this.f44911j1.setTextColor(R.color.baseColorSecondaryText);
        H1();
        I1(inflate);
        N1(inflate);
        L1();
        K1();
        M1();
        J1();
        this.F.c(TradeType.LINEAR_SWAP, new q());
    }

    public final boolean F2() {
        BigDecimal a11 = i6.m.a(getInputPriceText());
        if (getTradePriceType() != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            return this.f44903h.P(z1(w2()));
        }
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.input_unknow_text), new Object[]{this.f44944x.getHint().toString()}));
        return false;
    }

    public final void G1() {
        this.C0.clear();
        int i11 = this.f44894e;
        if (i11 == 0) {
            this.C0.add(this.E0.getString(R.string.n_spot_order_buy));
            this.C0.add(this.E0.getString(R.string.n_spot_order_sell));
        } else if (i11 == 1) {
            this.C0.add(this.E0.getString(R.string.n_contract_trade_close_more));
            this.C0.add(this.E0.getString(R.string.n_contract_trade_close_low));
        } else {
            this.C0.add(this.E0.getString(R.string.n_spot_order_buy));
            this.C0.add(this.E0.getString(R.string.n_spot_order_sell));
        }
    }

    public void G2(LinearSwapAccountInfo linearSwapAccountInfo) {
        this.f44906i = linearSwapAccountInfo;
        D2();
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment;
        int i11;
        TradeTrendView tradeTrendView = this.f44886b0;
        if (tradeTrendView != null) {
            tradeTrendView.setNewestPrice(marketCurrentPriceItem);
        }
        this.f44903h.j(false);
        String obj = this.f44944x.getText().toString();
        String b11 = marketCurrentPriceItem.b();
        if (TextUtils.isEmpty(obj) && !this.f44944x.hasFocus() && !TextUtils.equals("--", b11) && this.f44942w.getTradePriceType() == 1 && (i11 = this.f44900g) != 5) {
            if (this.f44894e == 0) {
                if (this.L0 || i11 == 6) {
                    this.J0 = true;
                    this.f44944x.setText(b11);
                }
            } else if (this.M0 || i11 == 6) {
                this.K0 = true;
                this.f44944x.setText(b11);
            }
        }
        if (!TextUtils.equals("--", b11)) {
            if (this.f44894e == 0) {
                this.L0 = false;
            } else {
                this.M0 = false;
            }
        }
        if (this.f44903h != null && (futureTpSlSettingDialogFragment = this.B0) != null && futureTpSlSettingDialogFragment.isVisible()) {
            this.B0.Vh(i6.m.a(String.valueOf(this.f44903h.p().e())));
        }
    }

    public void H1() {
        this.f44891d = 0;
        G1();
        CommonNavigator commonNavigator = new CommonNavigator(this.E0);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new r());
        this.D0.setNavigator(commonNavigator);
    }

    public void H2(AccountBalanceInfoV5 accountBalanceInfoV5) {
        this.f44909j = accountBalanceInfoV5;
        D2();
    }

    public void I0() {
        if (this.f44942w.getTradePriceType() != 1) {
            this.f44903h.j(false);
        }
    }

    public final void I1(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vertical_depth_tv);
        this.P = textView;
        textView.setText("--");
        this.Q = (ImageView) view.findViewById(R.id.vertical_depth_arrow_iv);
        this.R = view.findViewById(R.id.depth_ll);
        this.N0.setMenuItems(new ArrayList());
        this.N0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void I2(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public void J0() {
        this.G.setText("");
        setProgress(0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void J1() {
        this.H.setOnClickListener(new n1(this));
        this.f44932s.setOnEditTextFocusChangeListener(new h2(this));
        this.C.setOnClickListener(new i2(this));
        this.f44899f1.setOnClickListener(new g2(this));
        this.X0.setOnClickListener(new k2(this));
        this.f44934t.addTextChangedListener(new t());
        this.f44942w.setOnEditTextFocusChangeListener(new f2(this));
        this.f44942w.setOnClickListener(new m2(this));
        this.f44942w.setCallback(new u());
        this.f44944x.addTextChangedListener(new v());
        this.G.addTextChangedListener(new w());
        this.G.setOnFocusChangeListener(new s1(this));
        this.f44886b0.setCallback(new x());
        this.f44886b0.setNewestPriceItemViewPreDrawListener(new a());
        this.R.setOnClickListener(new v1(this));
        this.f44928q.setOnClickListener(new o1(this));
        this.S.setOnClickListener(new j2(this));
        this.f44915l.setOnClickListener(new l2(this));
        this.P0.setDialogFragmentListener(new b());
        this.S0.setDialogFragmentListener(new c());
        this.O0.setDialogFragmentListener(new d());
        this.N0.setBottomMenuShowListener(new e2(this));
        this.N0.setBottomMenuDismissListener(new d2(this));
        this.Z0.setOnProgressChangedListener(new e());
        this.f44898f0.setOnCheckedChangeListener(new y1(this));
        this.f44898f0.setOnTouchListener(new t1(this));
        this.f44914k1.setOnCheckedChangeListener(new x1(this));
        this.f44914k1.setOnTouchListener(new u1(this));
        this.f44901g0.setOnClickListener(r1.f53135b);
        this.f44907i0.setOnClickListener(new q1(this, new b2(this)));
        this.f44922n0.setOnClickListener(new k1(this));
        this.f44935t0.setOnClickListener(new n2(this));
        this.f44948z.setOnClickListener(new m1(this));
        this.A.setOnClickListener(new o2(this));
        this.A.setCallback(new f());
        this.T0.setDialogFragmentListener(new g());
        this.B.addTextChangedListener(new h());
        this.f44911j1.setOnClickListener(new p1(this));
    }

    public void J2(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(i6.m.a(str)) == 0) {
            this.f44937u.setVisibility(8);
            return;
        }
        this.f44940v.setText(AppUtil.b(String.format(this.E0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f44937u.setVisibility(0);
    }

    public void K0() {
        LeverSelectDialogFragment leverSelectDialogFragment = this.O0;
        if (leverSelectDialogFragment != null) {
            leverSelectDialogFragment.dismiss();
        }
    }

    public final void K1() {
        ArrayList arrayList = new ArrayList();
        if (this.f44900g == 1) {
            arrayList.add(new CommonPopListItem(3, this.E0.getString(R.string.n_contract_trade_optimal_five), this.f44933s1));
            arrayList.add(new CommonPopListItem(4, this.E0.getString(R.string.n_contract_trade_optimal_ten), this.f44933s1));
            arrayList.add(new CommonPopListItem(5, this.E0.getString(R.string.n_contract_trade_optimal_twenty), this.f44933s1));
        } else {
            arrayList.add(new CommonPopListItem(2, getBboStr(), ContextCompat.getColor(this.E0, R.color.baseColorPrimaryText), this.f44933s1));
            arrayList.add(new CommonPopListItem(3, this.E0.getString(R.string.n_contract_trade_optimal_five), this.f44933s1));
            arrayList.add(new CommonPopListItem(4, this.E0.getString(R.string.n_contract_trade_optimal_ten), this.f44933s1));
            arrayList.add(new CommonPopListItem(5, this.E0.getString(R.string.n_contract_trade_optimal_twenty), this.f44933s1));
        }
        this.S0.setData(arrayList);
    }

    public void L0() {
        if (this.f44942w.getTradePriceType() == 1) {
            this.f44897f = false;
        } else {
            this.f44903h.j(false);
        }
    }

    public final void L1() {
        this.Q0.clear();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getContext().getString(R.string.n_contract_order_type_limit), ContextCompat.getColor(this.E0, R.color.baseColorPrimaryText), this.f44931r1);
        this.f44925o1 = commonPopListItem;
        this.Q0.add(commonPopListItem);
        this.Q0.add(new CommonPopListItem(6, getContext().getString(R.string.n_exchange_price_market_deal), ContextCompat.getColor(this.E0, R.color.baseColorPrimaryText), this.f44931r1));
        this.Q0.add(new CommonPopListItem(1, getContext().getString(R.string.n_contract_order_type_trigger), this.f44931r1));
        this.Q0.add(new CommonPopListItem(5, getContext().getString(R.string.n_contract_track_order), this.f44931r1));
        this.Q0.add(new CommonPopListItem(2, getContext().getString(R.string.n_contract_trade_post_only), this.f44931r1));
        this.P0.setData(this.Q0);
        this.P0.setFollowViewWidth(true);
    }

    public void M0(int i11) {
        boolean z11 = true;
        if (!tg.r.x().F0() || !(z6.l.c().g(this.f44896e1) == null || z6.l.c().g(this.f44896e1).getActiveState() == 1)) {
            this.H.setBackgroundResource(R.drawable.shape_contract_login);
        } else if (ContractCalmPeriodHelper.d()) {
            this.H.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
        } else {
            boolean l11 = com.hbg.lib.core.util.w.l();
            int i12 = R.drawable.trade_btn_sell_selector;
            int i13 = l11 ? R.drawable.trade_btn_sell_selector : R.drawable.trade_btn_buy_selector;
            if (com.hbg.lib.core.util.w.l()) {
                i12 = R.drawable.trade_btn_buy_selector;
            }
            RelativeLayout relativeLayout = this.H;
            if (i11 != 0) {
                i13 = i12;
            }
            relativeLayout.setBackgroundResource(i13);
        }
        MultiConfigBuilder configBuilder = this.Z0.getConfigBuilder();
        Context context = getContext();
        boolean g11 = NightHelper.e().g();
        if (i11 != 0) {
            z11 = false;
        }
        configBuilder.colorConfig(context, g11, z11).build();
    }

    public final void M1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(7, this.E0.getString(R.string.n_contract_theoretical_price), ContextCompat.getColor(this.E0, R.color.baseColorPrimaryText), this.f44936t1));
        arrayList.add(new CommonPopListItem(3, this.E0.getString(R.string.n_contract_trade_optimal_five), this.f44936t1));
        arrayList.add(new CommonPopListItem(4, this.E0.getString(R.string.n_contract_trade_optimal_ten), this.f44936t1));
        arrayList.add(new CommonPopListItem(5, this.E0.getString(R.string.n_contract_trade_optimal_twenty), this.f44936t1));
        this.T0.setData(arrayList);
    }

    public void N0(ContractDepth contractDepth, int i11) {
        String priceTick = contractDepth.getPriceTick();
        if (!TextUtils.isEmpty(priceTick)) {
            this.P.setText(i6.m.a(priceTick).stripTrailingZeros().toPlainString());
        } else {
            this.P.setText("--");
        }
    }

    public final void N1(View view) {
        this.S = (ImageView) view.findViewById(R.id.trend_change_iv);
        this.U0.add(new MenuItem(0, this.E0.getString(R.string.n_contract_trade_trend_default), this.E0.getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f44927p1));
        List<MenuItem> list = this.U0;
        String string = this.E0.getString(R.string.n_contract_trade_trend_buy);
        String string2 = this.E0.getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f44927p1));
        this.U0.add(new MenuItem(2, this.E0.getString(R.string.n_contract_trade_trend_sell), this.E0.getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.f44927p1));
        this.R0.setMenuItems(this.U0);
        this.R0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void O0(int i11) {
        this.f44894e = i11;
        this.Y0 = 0;
        t0();
        w1();
        G1();
        n0();
        Y0(this.f44894e);
        M0(this.f44891d);
        T0(this.f44900g);
        t1();
    }

    public void P0(String str, String str2) {
    }

    public void Q0() {
        boolean z11 = getPositionType() == 0;
        this.F.setData(z11);
        if (a7.e.E(this.f44896e1)) {
            this.G.setHint(this.E0.getString(R.string.n_contract_trade_input_amount));
        } else if (!z11 || !a7.e.H(this.f44896e1)) {
            this.G.setHint(this.E0.getString(R.string.n_contract_unit_amount));
        } else {
            this.G.setHint(this.E0.getString(R.string.n_contract_unit_principal));
        }
        E2();
    }

    public void R0(boolean z11) {
        if (z11) {
            this.I0 = null;
            this.H0 = null;
            this.G0 = null;
            this.F0 = null;
        } else {
            int i11 = this.f44894e;
            if (i11 == 0) {
                this.H0 = null;
                this.F0 = null;
            } else if (i11 == 1) {
                this.I0 = null;
                this.G0 = null;
            }
        }
        this.f44944x.setText("");
        this.G.setText("");
    }

    public void S0(String str, String str2) {
        if (!this.G.getText().toString().equals(str2)) {
            this.G.setText(str2);
        }
    }

    public void T0(int i11) {
        SP.q("FutureTradeTogetherViewOrderType", i11);
        this.f44900g = i11;
        this.X0.setSelected(false);
        t1();
        ViewUtil.m(this.f44905h1, false);
        ViewUtil.m(this.f44908i1, true);
        K1();
        if (this.f44891d == 0) {
            this.f44895e0.changeTradeOrderType(this.f44900g, this.f44894e, this.f44945x0, this.f44947y0);
        } else {
            this.f44895e0.changeTradeOrderType(this.f44900g, this.f44894e, this.f44949z0, this.A0);
        }
        this.f44917l1.setVisibility(8);
        switch (this.f44900g) {
            case 0:
            case 3:
            case 4:
                this.f44917l1.setVisibility(0);
                int i12 = this.f44900g;
                if (i12 == 0) {
                    this.f44920m1.setText("GTC");
                } else if (i12 == 3) {
                    this.f44920m1.setText("IOC");
                } else {
                    this.f44920m1.setText("FOK");
                    this.X0.setSelected(false);
                }
                this.f44946y.setVisibility(8);
                this.f44948z.setVisibility(8);
                this.f44918m.setText(getContext().getString(R.string.n_contract_order_type_limit));
                this.f44930r.setVisibility(8);
                this.X0.setVisibility(0);
                this.X0.setText(R.string.n_contract_trade_rival_price);
                this.f44942w.setPriceInputType(1);
                this.f44942w.setHintText((int) R.string.n_contract_trade_input_price);
                r1();
                break;
            case 1:
                this.f44946y.setVisibility(8);
                this.f44948z.setVisibility(8);
                this.f44918m.setText(getContext().getString(R.string.n_contract_order_type_trigger));
                this.f44930r.setVisibility(0);
                this.X0.setVisibility(0);
                this.X0.setText(R.string.n_contract_trade_optimal_n);
                this.f44932s.setPriceInputType(1);
                this.f44932s.setTradeUseType(1);
                this.f44932s.setDividerVisibility(8);
                this.f44932s.setLabelVisibility(8);
                this.f44942w.setPriceInputType(1);
                this.f44942w.setHintText((int) R.string.n_contract_trade_input_price);
                w0(true, false);
                break;
            case 2:
                this.f44946y.setVisibility(8);
                this.f44948z.setVisibility(8);
                this.f44918m.setText(getContext().getString(R.string.n_contract_trade_post_only));
                this.f44930r.setVisibility(8);
                this.X0.setVisibility(8);
                this.f44942w.setPriceInputType(1);
                this.f44942w.setHintText((int) R.string.n_contract_trade_input_price);
                r1();
                break;
            case 5:
                this.f44918m.setText(getContext().getString(R.string.n_contract_track_order));
                this.f44930r.setVisibility(8);
                this.X0.setVisibility(8);
                this.f44946y.setVisibility(0);
                this.f44948z.setVisibility(0);
                this.A.setPriceInputType(2);
                this.A.setCurrentPriceTypeText(this.E0.getString(R.string.n_contract_trade_optimal_twenty));
                this.A.setPriceInputType(5);
                this.f44942w.setPriceInputType(1);
                this.f44942w.setHintText((int) R.string.n_contract_active_price);
                this.f44944x.setText("");
                break;
            case 6:
                this.f44946y.setVisibility(8);
                this.f44948z.setVisibility(8);
                this.f44918m.setText(getContext().getString(R.string.n_exchange_price_market_deal));
                this.f44930r.setVisibility(8);
                this.X0.setVisibility(0);
                this.X0.setText(R.string.n_contract_trade_rival_price);
                this.f44942w.setPriceInputType(1);
                this.f44942w.setHintText((int) R.string.n_contract_trade_input_price);
                r1();
                ViewUtil.m(this.f44905h1, true);
                ViewUtil.m(this.f44908i1, false);
                break;
        }
        t0();
        v1();
    }

    public void U0() {
        if (this.f44942w.getTradePriceType() == 1) {
            this.f44897f = false;
        } else {
            this.f44903h.j(false);
        }
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.V0.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.V0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.f44929q1));
            } else {
                this.V0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.f44929q1));
            }
        }
        this.N0.setMenuItems(this.V0);
    }

    public boolean W0() {
        return this.f44898f0.isChecked();
    }

    public void X0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.D.setVisibility(8);
            return;
        }
        this.E.setText(AppUtil.b(String.format(this.E0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.D.setVisibility(0);
    }

    public void Y0(int i11) {
        if (tg.r.x().F0()) {
            FutureUserInfo g11 = z6.l.c().g(this.f44896e1);
            if (g11 != null && g11.getActiveState() != 1) {
                this.J.setVisibility(8);
                this.I.setText(a7.e.x(this.f44896e1, getContext()));
            } else if (ContractCalmPeriodHelper.d()) {
                this.J.setVisibility(8);
                this.I.setText(R.string.n_contract_calm_period_name);
            } else if (i11 == 0) {
                this.f44938u0.setVisibility(0);
                if (this.f44891d == 0) {
                    this.I.setText(R.string.contract_trade_buy_open_more);
                    this.J.setText(R.string.contract_trade_rise);
                } else {
                    this.I.setText(R.string.contract_trade_sell_open_low);
                    this.J.setText(R.string.contract_trade_down);
                }
                this.J.setVisibility(0);
            } else if (i11 == 1) {
                this.f44938u0.setVisibility(8);
                if (this.f44891d == 0) {
                    this.I.setText(R.string.contract_trade_sell_flat_more);
                } else {
                    this.I.setText(R.string.contract_trade_buy_flat_empty);
                }
                this.J.setVisibility(8);
            } else {
                this.f44938u0.setVisibility(8);
                this.I.setText(R.string.contract_trade_position_close);
                this.J.setVisibility(8);
            }
        } else {
            this.I.setText(R.string.n_contract_trade_log_in_to_exchange);
            this.J.setVisibility(8);
        }
        v1();
    }

    public void c(int i11) {
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    if (com.hbg.lib.core.util.w.l()) {
                        this.S.setImageResource(R.drawable.trade_trend_green);
                    } else {
                        this.S.setImageResource(R.drawable.trade_trend_red);
                    }
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                this.S.setImageResource(R.drawable.trade_trend_red);
            } else {
                this.S.setImageResource(R.drawable.trade_trend_green);
            }
        } else if (com.hbg.lib.core.util.w.l()) {
            this.S.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.S.setImageResource(R.drawable.trade_trend_default_red_green);
        }
    }

    public void d(boolean z11) {
        if (z11) {
            this.X0.setEnabled(true);
            this.C.setEnabled(true);
            setLightingSelect(false);
            this.f44898f0.setChecked(gl.b.a(this.f44896e1));
            return;
        }
        this.X0.setSelected(false);
        this.X0.setEnabled(false);
        this.C.setEnabled(false);
        setLightingSelect(false);
        this.f44945x0 = null;
        this.f44947y0 = null;
        this.f44949z0 = null;
        this.A0 = null;
        y1();
        x1();
        this.f44895e0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        this.f44898f0.setChecked(false);
    }

    public String getBondZeroDefault() {
        return BigDecimal.ZERO.setScale(4, 4).toPlainString() + getResources().getString(R.string.points_pack_usdt);
    }

    public String getCallBackRateText() {
        return this.B.getText().toString();
    }

    public String getInputAmountText() {
        return this.G.getText().toString();
    }

    public String getInputPriceText() {
        return this.f44944x.getText().toString();
    }

    public k4 getOnEditTextFocusChangeListener() {
        return this.f44884a1;
    }

    public String getOrderPlaceInputAmount() {
        String obj = this.G.getText().toString();
        return (getTradeAmountType() != 0 || getPositionType() != 0 || a7.e.E(this.f44896e1) || !a7.e.H(this.f44896e1)) ? obj : i6.m.a(obj).multiply(i6.m.a(this.f44903h.r())).toPlainString();
    }

    public int getOrderType() {
        return this.f44900g;
    }

    public int getPositionType() {
        return this.f44894e;
    }

    public int getSeekBarProgress() {
        return this.Z0.getProgress();
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
        return this.f44898f0.isChecked();
    }

    public int getTradeAmountType() {
        return this.Y0;
    }

    public int getTradePosition() {
        return this.f44891d;
    }

    public int getTradePriceType() {
        return this.f44942w.getTradePriceType();
    }

    public String getTriggerPriceText() {
        return this.f44934t.getText().toString();
    }

    public String getVolume() {
        String orderPlaceInputAmount = getOrderPlaceInputAmount();
        if (this.Y0 != 5) {
            return orderPlaceInputAmount;
        }
        if (SPUtil.j()) {
            AccountBalanceInfoV5 accountBalanceInfoV5 = this.f44909j;
            if (accountBalanceInfoV5 != null) {
                return i6.m.a(accountBalanceInfoV5.getAvailableMargin()).multiply(BigDecimal.valueOf((long) this.f44912k)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
            }
        } else {
            LinearSwapAccountInfo linearSwapAccountInfo = this.f44906i;
            if (linearSwapAccountInfo != null) {
                return i6.m.a(linearSwapAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.f44912k)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
            }
        }
        return null;
    }

    public void k2(String str) {
        if (this.f44896e1 == TradeType.LINEAR_SWAP) {
            this.O.setText(String.format(getContext().getString(R.string.order_price_icon_label), new Object[]{StringUtils.i(str)}));
            return;
        }
        this.O.setText(R.string.n_contract_trade_market_price_label);
    }

    public void n0() {
        this.D0.getNavigator().notifyDataSetChanged();
    }

    public void n2(FuturePriceLimitInfo futurePriceLimitInfo) {
    }

    public void notifyDataSetChanged() {
        TradeTrendView tradeTrendView = this.f44886b0;
        if (tradeTrendView != null) {
            tradeTrendView.i();
        }
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            w1();
            MarketTwTradeStateObservable.a().deleteObserver(this);
            return;
        }
        MarketTwTradeStateObservable.a().addObserver(this);
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.f44893d1;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            DialogUtils.b.d Q02 = new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getContext().getString(R.string.n_known)).Q0(a2.f53055a);
            if (!TextUtils.isEmpty(str)) {
                Q02.s0(getContext().getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new z1(this, str));
            }
            HBDialogFragment k02 = Q02.k0();
            this.f44893d1 = k02;
            k02.show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public void q0() {
        HBDialogFragment hBDialogFragment = this.f44893d1;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public final void q1(int i11) {
        this.f44912k = i11;
        this.f44890c1.hideKeyboard();
        t0();
        this.Y0 = 5;
        this.f44903h.U(i11, this.f44894e);
        if (this.f44894e == 0) {
            this.H0 = null;
        } else {
            this.I0 = null;
        }
        D2();
    }

    public void r0() {
        this.S0.dismiss();
        this.T0.dismiss();
    }

    public final void r1() {
        int i11 = this.f44891d;
        if (i11 == 0) {
            if (this.f44894e == 0) {
                L0();
            } else {
                U0();
            }
        } else if (i11 == 1) {
            if (this.f44894e == 0) {
                U0();
            } else {
                L0();
            }
        }
        w0(true, false);
    }

    public void s0() {
        for (MenuItem next : this.U0) {
            if (next.getType() == 0) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f44903h.p().j(0);
        if (com.hbg.lib.core.util.w.l()) {
            this.S.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.S.setImageResource(R.drawable.trade_trend_default_red_green);
        }
        this.f44886b0.c(0);
        this.f44903h.p().l(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00da A[Catch:{ ZeroErr -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00dc A[Catch:{ ZeroErr -> 0x00eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00e5 A[Catch:{ ZeroErr -> 0x00eb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String s1(boolean r8) {
        /*
            r7 = this;
            tg.r r0 = tg.r.x()
            boolean r0 = r0.F0()
            java.lang.String r1 = "--"
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            nk.e r0 = r7.f44903h
            if (r0 != 0) goto L_0x0012
            return r1
        L_0x0012:
            com.huobi.feature.util.FutureEarnestMoneyUtils r0 = com.huobi.feature.util.FutureEarnestMoneyUtils.f()     // Catch:{ ZeroErr -> 0x00eb }
            android.content.Context r1 = r7.E0     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r0.i(r1)     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r7.getVolume()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.t(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.hbg.lib.data.symbol.TradeType r2 = r2.s()     // Catch:{ ZeroErr -> 0x00eb }
            boolean r2 = a7.e.G(r2)     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.s(r2)     // Catch:{ ZeroErr -> 0x00eb }
            android.widget.TextView r2 = r7.X0     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.q(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.hbg.lib.data.symbol.TradeType r2 = r2.s()     // Catch:{ ZeroErr -> 0x00eb }
            boolean r2 = a7.e.E(r2)     // Catch:{ ZeroErr -> 0x00eb }
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x0055
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.hbg.lib.data.symbol.TradeType r2 = r2.s()     // Catch:{ ZeroErr -> 0x00eb }
            boolean r2 = a7.e.G(r2)     // Catch:{ ZeroErr -> 0x00eb }
            if (r2 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r2 = r3
            goto L_0x0056
        L_0x0055:
            r2 = r4
        L_0x0056:
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.h(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.hbg.lib.data.symbol.TradeType r2 = r2.s()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.r(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r2.r()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.l(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r2.v()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.u(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.hbg.lib.data.future.bean.FutureContractInfo r2 = r2.o()     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r2.getContractFace()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.k(r2)     // Catch:{ ZeroErr -> 0x00eb }
            r2 = 4
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.o(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.controller.FutureMarketDepthController r2 = r2.p()     // Catch:{ ZeroErr -> 0x00eb }
            double r5 = r2.c()     // Catch:{ ZeroErr -> 0x00eb }
            java.math.BigDecimal r2 = java.math.BigDecimal.valueOf(r5)     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r2.toPlainString()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.g(r2)     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r7.getInputPriceText()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.j(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.controller.FutureMarketDepthController r2 = r2.p()     // Catch:{ ZeroErr -> 0x00eb }
            double r5 = r2.e()     // Catch:{ ZeroErr -> 0x00eb }
            java.math.BigDecimal r2 = java.math.BigDecimal.valueOf(r5)     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r2.toPlainString()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.m(r2)     // Catch:{ ZeroErr -> 0x00eb }
            nk.e r2 = r7.f44903h     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.controller.FutureMarketDepthController r2 = r2.p()     // Catch:{ ZeroErr -> 0x00eb }
            double r5 = r2.f()     // Catch:{ ZeroErr -> 0x00eb }
            java.math.BigDecimal r2 = java.math.BigDecimal.valueOf(r5)     // Catch:{ ZeroErr -> 0x00eb }
            java.lang.String r2 = r2.toPlainString()     // Catch:{ ZeroErr -> 0x00eb }
            com.huobi.feature.util.FutureEarnestMoneyUtils r1 = r1.p(r2)     // Catch:{ ZeroErr -> 0x00eb }
            int r2 = r7.f44900g     // Catch:{ ZeroErr -> 0x00eb }
            r5 = 6
            if (r2 != r5) goto L_0x00dc
            r2 = r4
            goto L_0x00dd
        L_0x00dc:
            r2 = r3
        L_0x00dd:
            r1.n(r2)     // Catch:{ ZeroErr -> 0x00eb }
            int r1 = r7.Y0     // Catch:{ ZeroErr -> 0x00eb }
            r2 = 5
            if (r1 != r2) goto L_0x00e6
            r3 = r4
        L_0x00e6:
            java.lang.String r8 = r0.b(r8, r3)     // Catch:{ ZeroErr -> 0x00eb }
            return r8
        L_0x00eb:
            java.lang.String r8 = r7.getBondZeroDefault()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.feature.ui.FutureTradeView.s1(boolean):java.lang.String");
    }

    public void setAmountEtText(String str) {
        this.G.setText(str);
    }

    public void setContractTradeViewController(nk.e eVar) {
        this.f44903h = eVar;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f44923n1 = fragmentManager;
    }

    public void setHasTrade(boolean z11) {
        this.f44902g1 = z11;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f44897f = z11;
    }

    public void setLeverList(List<String> list) {
        if (list != null) {
            this.O0.tc(list);
        }
    }

    public void setOnCouponClickListener(View.OnClickListener onClickListener) {
        this.V.setOnClickListener(onClickListener);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f44884a1 = k4Var;
    }

    public void setPositionType(int i11) {
        this.f44894e = i11;
    }

    public void setPriceAnimator(String str) {
        this.f44944x.setText(str);
        EditText editText = this.f44944x;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.f44944x);
    }

    public void setPriceInputType(int i11) {
        this.f44942w.setPriceInputType(i11);
    }

    public void setPriceText(String str) {
        this.f44942w.setPriceInputType(1);
        this.X0.setSelected(false);
        setLightingSelect(false);
        if (this.f44894e == 0) {
            this.J0 = false;
            this.F0 = str;
        } else {
            this.G0 = str;
            this.K0 = false;
        }
        int i11 = this.f44900g;
        if (i11 != 5 && i11 != 6) {
            setPriceAnimator(str);
        }
    }

    public void setProgress(int i11) {
        this.Z0.setProgress((float) i11);
    }

    public void setTradePosition(int i11) {
        this.f44891d = i11;
    }

    public void setTriggerPriceTypeView(int i11) {
        this.f44932s.setDividerVisibility(8);
        this.f44932s.setLabelVisibility(8);
    }

    public void setViewVisibility(int i11) {
        setVisibility(i11);
    }

    public void t0() {
        this.f44944x.clearFocus();
        this.G.clearFocus();
        this.f44934t.clearFocus();
    }

    public final void t1() {
        setLightingSelect(false);
    }

    public void u0(boolean z11, boolean z12) {
        if (z11) {
            this.f44945x0 = null;
            this.f44947y0 = null;
            this.f44949z0 = null;
            this.A0 = null;
        } else if (this.f44891d == 0) {
            this.f44945x0 = null;
            this.f44947y0 = null;
        } else {
            this.f44949z0 = null;
            this.A0 = null;
        }
        y1();
        x1();
        this.f44895e0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        if (z12) {
            this.f44898f0.setChecked(false);
        }
    }

    public final void u1(int i11) {
        this.f44891d = i11;
        Y0(this.f44894e);
        M0(this.f44891d);
    }

    public void update(java.util.Observable observable, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (booleanValue != this.f44943w0.e()) {
            this.f44943w0.setChecked(booleanValue);
        }
    }

    public void v0() {
        this.f44924o.setText("--");
        this.f44924o.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f44926p.setImageResource(0);
    }

    public final void v1() {
        getViewTreeObserver().addOnPreDrawListener(new i());
    }

    public void v2(int i11, int i12) {
        if (i12 == 5 || i12 == 7) {
            this.K.setText(R.string.n_contract_trade_settling);
            this.L.setText(R.string.n_contract_trade_system_settling);
        } else if (i12 == 6 || i12 == 8) {
            this.K.setText(R.string.n_contract_trade_delivering);
            this.L.setText(R.string.n_contract_trade_system_delivering);
        } else if (i12 == 3) {
            this.K.setText(R.string.n_contract_trade_stop);
            this.L.setText("");
        } else if (i12 == 4) {
            this.K.setText(R.string.n_contract_trade_pre_trade);
            this.L.setText("");
        }
        this.M.setVisibility(i11);
    }

    public void w0(boolean z11, boolean z12) {
        if (this.f44942w.getTradePriceType() == 1) {
            if (this.f44894e == 0 && !TextUtils.isEmpty(this.F0)) {
                this.f44944x.setText(this.F0);
            } else if (this.f44894e != 1 || TextUtils.isEmpty(this.G0)) {
                this.f44944x.setText("");
            } else {
                this.f44944x.setText(this.G0);
            }
        }
        if (z11) {
            this.f44934t.setText("");
            this.B.setText("");
        }
        if (this.f44894e == 0 && !TextUtils.isEmpty(this.H0)) {
            this.G.setText(this.H0);
        } else if (this.f44894e != 1 || TextUtils.isEmpty(this.I0)) {
            this.G.setText("");
        } else {
            this.G.setText(this.I0);
        }
        setProgress(0);
        this.U.setText("--");
        D2();
        this.f44890c1.hideKeyboard();
    }

    public final void w1() {
        if (this.f44894e == 0) {
            if (this.J0) {
                this.f44944x.setText("");
            }
            this.L0 = true;
            return;
        }
        if (this.K0) {
            this.f44944x.setText("");
        }
        this.M0 = true;
    }

    public boolean w2() {
        if (this.f44894e == 0) {
            if (this.f44891d == 0) {
                return true;
            }
            return false;
        } else if (this.f44891d != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void x0(String str) {
        this.f44924o.setText(String.format(this.E0.getString(R.string.contract_lever), new Object[]{str}));
        if (this.O0.isResumed()) {
            this.f44926p.setImageResource(R.drawable.trade_arrow_up);
        } else {
            this.f44926p.setImageResource(R.drawable.trade_arrow_down);
        }
        if (i6.m.a(str).compareTo(BigDecimal.TEN) >= 0) {
            this.f44924o.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        } else {
            this.f44924o.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        }
    }

    public final void x1() {
        this.f44919m0.setText("");
    }

    public void x2(String str) {
        String str2;
        if (this.Y0 == 0) {
            if (i6.m.a(str).compareTo(BigDecimal.ZERO) <= 0) {
                this.U.setText("--");
            } else if (a7.e.E(this.f44896e1)) {
                if (this.f44900g == 6 || this.X0.isSelected()) {
                    double e11 = this.f44903h.p().e();
                    if (e11 == 0.0d) {
                        e11 = this.f44903h.p().c();
                    }
                    if (e11 == 0.0d) {
                        e11 = this.f44903h.p().f();
                    }
                    str2 = String.valueOf(e11);
                } else {
                    str2 = getInputPriceText();
                }
                this.U.setText(String.format(this.E0.getString(a7.e.D()), new Object[]{i6.m.a(str).multiply(i6.m.a(this.f44903h.o().getContractFace()).multiply(i6.m.a(str2))).setScale(this.f44903h.o().getOtherAmountPrecision(), 1).toPlainString(), "usdt".toUpperCase(Locale.US)}));
            } else {
                this.U.setText(String.format(this.E0.getString(a7.e.D()), new Object[]{i6.m.a(str).multiply(i6.m.a(this.f44903h.o().getContractFace())).setScale(FuturePrecisionUtil.s(this.f44903h.o().getContractCode(), this.f44903h.o().getContractShortType(), (String) null), 1), this.f44903h.v().toUpperCase(Locale.US)}));
            }
            this.W.setVisibility(0);
        } else {
            this.W.setVisibility(4);
        }
        D2();
    }

    public final void y1() {
        this.f44916l0.setText("");
    }

    public void y2() {
        AccountBalanceInfoV5 accountBalanceInfoV5 = this.f44909j;
        if (accountBalanceInfoV5 != null) {
            this.O0.Ai(accountBalanceInfoV5.getAvailableMargin());
        } else {
            this.O0.Ai((String) null);
        }
        this.O0.wi(this.f44903h.t());
        this.O0.bc(this.f44903h.v());
        this.O0.xi(a7.e.m(this.E0, this.f44903h.v(), this.f44903h.o().getQuoteCurrency(), this.f44903h.o().getContractCode(), this.f44903h.o().getContractType(), this.f44903h.t()));
        this.O0.setTradeType(this.f44896e1);
        this.O0.zi(ContractWebActivity.Eh(4));
        this.O0.si(this.f44903h.o().getContractCode());
        this.O0.vi(this.f44939u1);
        this.O0.ti(this.f44903h.r());
        this.O0.show(((FragmentActivity) this.E0).getSupportFragmentManager(), "LinearSwapLeverSelectDialogFragment");
    }

    public void z0(boolean z11) {
        this.H.setEnabled(z11);
    }

    public final ContractOrderPlace z1(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0(getInputPriceText());
        contractOrderPlace.d0(getOrderPlaceInputAmount());
        contractOrderPlace.h0(z11);
        contractOrderPlace.A0(this.f44894e);
        if (this.f44900g == 6) {
            contractOrderPlace.X0(8);
        } else {
            contractOrderPlace.X0(this.f44942w.getTradePriceType());
        }
        contractOrderPlace.g0(getTradeAmountType());
        contractOrderPlace.y0(this.f44900g);
        contractOrderPlace.Z0(getTriggerPriceText());
        contractOrderPlace.Y0(this.f44934t.getHint().toString());
        contractOrderPlace.e0(this.E0.getString(R.string.n_exchange_order_list_amount));
        contractOrderPlace.C0(this.f44944x.getHint().toString());
        contractOrderPlace.W0(this.I.getText().toString());
        contractOrderPlace.x0(this.f44942w.getCurrentPriceTypeText());
        contractOrderPlace.E0(getSeekBarProgress());
        contractOrderPlace.j0(this.B.getHint().toString());
        contractOrderPlace.U0(this.A.getCurrentPriceTypeText());
        contractOrderPlace.k0(getCallBackRateText());
        contractOrderPlace.V0(this.A.getTradePriceType());
        if (this.f44903h.o() != null) {
            contractOrderPlace.n0(this.f44903h.o().getContractType());
        }
        if (this.f44898f0.isChecked() && ContractTpslLayout.supportTpslOrder(this.f44900g)) {
            if (z11) {
                FutureTpSlSettingParams futureTpSlSettingParams = this.f44945x0;
                if (futureTpSlSettingParams != null) {
                    B1(contractOrderPlace, futureTpSlSettingParams);
                }
                FutureTpSlSettingParams futureTpSlSettingParams2 = this.f44947y0;
                if (futureTpSlSettingParams2 != null) {
                    A1(contractOrderPlace, futureTpSlSettingParams2);
                }
            } else {
                FutureTpSlSettingParams futureTpSlSettingParams3 = this.f44949z0;
                if (futureTpSlSettingParams3 != null) {
                    B1(contractOrderPlace, futureTpSlSettingParams3);
                }
                FutureTpSlSettingParams futureTpSlSettingParams4 = this.A0;
                if (futureTpSlSettingParams4 != null) {
                    A1(contractOrderPlace, futureTpSlSettingParams4);
                }
            }
        }
        contractOrderPlace.b1(qk.a.b().j(this.f44900g == 6, this.f44903h.B()));
        return contractOrderPlace;
    }

    public void z2() {
        w1();
        R0(true);
        setProgress(0);
    }

    public FutureTradeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44885b = "usdt_contract";
        this.f44888c = "contract_trade";
        this.f44900g = 0;
        this.C0 = new ArrayList();
        this.J0 = true;
        this.K0 = true;
        this.L0 = true;
        this.M0 = true;
        this.N0 = new BottomMenuFragment();
        this.O0 = new LeverSelectDialogFragment();
        this.P0 = new CommonListPopupDialog();
        this.Q0 = new ArrayList();
        this.R0 = new BottomMenuFragment();
        this.S0 = new CommonListPopupDialog();
        this.T0 = new CommonListPopupDialog();
        this.U0 = new ArrayList();
        this.V0 = new ArrayList();
        this.f44896e1 = TradeType.LINEAR_SWAP;
        this.f44927p1 = new j();
        this.f44929q1 = new l();
        this.f44931r1 = new m();
        this.f44933s1 = new n();
        this.f44936t1 = new o();
        this.f44939u1 = new p();
        F1(context, attributeSet);
    }
}
