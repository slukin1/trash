package com.huobi.swap.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.TradeTrendView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.controller.FutureClearDialogConfigController;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.PriceLimitInfo;
import com.hbg.lib.network.swap.core.bean.SwapAccountInfo;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.bean.SwapUserInfo;
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
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.contract.ui.ContractTpslEditText;
import com.huobi.contract.ui.ContractTradePriceEditext;
import com.huobi.contract.ui.SwapMaintenanceView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.feature.bean.FutureTpSlDialogShowBean;
import com.huobi.feature.bean.FutureTpSlSettingParams;
import com.huobi.feature.ui.ContractTradeAmountView;
import com.huobi.feature.ui.FutureTpSlSettingDialogFragment;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.huobi.feature.ui.dialog.LimitChooseDialog;
import com.huobi.feature.util.ContractCalmPeriodHelper;
import com.huobi.feature.util.FutureEarnestMoneyUtils;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.login.bean.JumpTarget;
import com.huobi.main.ui.HuobiMainActivity;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.utils.k0;
import com.huobi.utils.m0;
import com.huobi.utils.v0;
import com.huobi.view.ContractTpslLayout;
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
import k6.b;
import k6.c;
import m9.z;
import net.lucode.hackware.magicindicator.MagicIndicator;
import pro.huobi.R;
import qs.n1;
import rx.Observable;
import ts.a2;
import ts.a4;
import ts.b2;
import ts.c2;
import ts.d2;
import ts.e2;
import ts.f2;
import ts.g2;
import ts.h2;
import ts.i2;
import ts.j1;
import ts.j2;
import ts.k1;
import ts.k2;
import ts.l1;
import ts.l2;
import ts.m1;
import ts.m2;
import ts.n2;
import ts.o1;
import ts.o2;
import ts.p1;
import ts.p2;
import ts.q1;
import ts.q2;
import ts.r1;
import ts.r2;
import ts.s1;
import ts.s2;
import ts.t1;
import ts.t2;
import ts.u1;
import ts.v1;
import ts.w1;
import ts.x1;
import ts.y1;
import ts.z1;

public class SwapTradeTogetherView extends FrameLayout implements a4, m0<SwapAccountInfo> {
    public ViewGroup A;
    public ContractTpslEditText A0;
    public TextView B;
    public EditText B0;
    public ContractTradeAmountView C;
    public EditText C0;
    public EditText D;
    public ImageView D0;
    public TextView E;
    public ImageView E0;
    public TextView F;
    public TextView F0;
    public LinearLayout G;
    public FutureTpSlSettingParams G0;
    public RelativeLayout H;
    public FutureTpSlSettingParams H0;
    public RelativeLayout I;
    public FutureTpSlSettingDialogFragment.OpenType I0;
    public TextView J;
    public FutureTpSlSettingDialogFragment J0;
    public TextView K;
    public boolean K0;
    public TextView L;
    public boolean L0;
    public TextView M;
    public boolean M0;
    public LinearLayout N;
    public boolean N0;
    public TextView O;
    public Context O0;
    public TextView P;
    public BottomMenuFragment P0;
    public ImageView Q;
    public LeverSelectDialogFragment Q0;
    public View R;
    public List<String> R0;
    public ImageView S;
    public CommonListPopupDialog S0;
    public ViewGroup T;
    public final List<CommonPopListItem> T0;
    public TextView U;
    public BottomMenuFragment U0;
    public TradeTrendView V;
    public CommonListPopupDialog V0;
    public int W;
    public CommonListPopupDialog W0;
    public String X0;
    public String Y0;
    public final List<MenuItem> Z0;

    /* renamed from: a0  reason: collision with root package name */
    public MultiColorSeekBar f81746a0;

    /* renamed from: a1  reason: collision with root package name */
    public final List<MenuItem> f81747a1;

    /* renamed from: b  reason: collision with root package name */
    public int f81748b;

    /* renamed from: b0  reason: collision with root package name */
    public TextView f81749b0;

    /* renamed from: b1  reason: collision with root package name */
    public ViewGroup f81750b1;

    /* renamed from: c  reason: collision with root package name */
    public int f81751c;

    /* renamed from: c0  reason: collision with root package name */
    public TextView f81752c0;

    /* renamed from: c1  reason: collision with root package name */
    public boolean f81753c1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f81754d;

    /* renamed from: d0  reason: collision with root package name */
    public String f81755d0;

    /* renamed from: d1  reason: collision with root package name */
    public TextView f81756d1;

    /* renamed from: e  reason: collision with root package name */
    public int f81757e;

    /* renamed from: e0  reason: collision with root package name */
    public String f81758e0;

    /* renamed from: e1  reason: collision with root package name */
    public k4 f81759e1;

    /* renamed from: f  reason: collision with root package name */
    public n1 f81760f;

    /* renamed from: f0  reason: collision with root package name */
    public String f81761f0;

    /* renamed from: f1  reason: collision with root package name */
    public SwapMaintenanceView f81762f1;

    /* renamed from: g  reason: collision with root package name */
    public SwapAccountInfo f81763g;

    /* renamed from: g0  reason: collision with root package name */
    public String f81764g0;

    /* renamed from: g1  reason: collision with root package name */
    public HuobiKeyboardHelper f81765g1;

    /* renamed from: h  reason: collision with root package name */
    public int f81766h;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f81767h0;

    /* renamed from: h1  reason: collision with root package name */
    public HBDialogFragment f81768h1;

    /* renamed from: i  reason: collision with root package name */
    public View f81769i;

    /* renamed from: i0  reason: collision with root package name */
    public View f81770i0;

    /* renamed from: i1  reason: collision with root package name */
    public View f81771i1;

    /* renamed from: j  reason: collision with root package name */
    public TextView f81772j;

    /* renamed from: j0  reason: collision with root package name */
    public View f81773j0;

    /* renamed from: j1  reason: collision with root package name */
    public View f81774j1;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f81775k;

    /* renamed from: k0  reason: collision with root package name */
    public TextView f81776k0;

    /* renamed from: k1  reason: collision with root package name */
    public View f81777k1;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81778l;

    /* renamed from: l0  reason: collision with root package name */
    public TextView f81779l0;

    /* renamed from: l1  reason: collision with root package name */
    public LinearLayout f81780l1;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f81781m;

    /* renamed from: m0  reason: collision with root package name */
    public TextView f81782m0;

    /* renamed from: m1  reason: collision with root package name */
    public TextView f81783m1;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f81784n;

    /* renamed from: n0  reason: collision with root package name */
    public ContractTpslLayout f81785n0;

    /* renamed from: n1  reason: collision with root package name */
    public FragmentManager f81786n1;

    /* renamed from: o  reason: collision with root package name */
    public ViewGroup f81787o;

    /* renamed from: o1  reason: collision with root package name */
    public CommonPopListItem f81788o1;

    /* renamed from: p  reason: collision with root package name */
    public ContractTradePriceEditext f81789p;

    /* renamed from: p1  reason: collision with root package name */
    public final MenuItemOnClickListener f81790p1;

    /* renamed from: q  reason: collision with root package name */
    public EditText f81791q;

    /* renamed from: q1  reason: collision with root package name */
    public final MenuItemOnClickListener f81792q1;

    /* renamed from: r  reason: collision with root package name */
    public ViewGroup f81793r;

    /* renamed from: r1  reason: collision with root package name */
    public final CommonPopListItem.a f81794r1;

    /* renamed from: s  reason: collision with root package name */
    public TextView f81795s;

    /* renamed from: s1  reason: collision with root package name */
    public final CommonPopListItem.a f81796s1;

    /* renamed from: t  reason: collision with root package name */
    public ContractGearsTradePriceEditText f81797t;

    /* renamed from: t0  reason: collision with root package name */
    public View f81798t0;

    /* renamed from: t1  reason: collision with root package name */
    public final CommonPopListItem.a f81799t1;

    /* renamed from: u  reason: collision with root package name */
    public EditText f81800u;

    /* renamed from: u0  reason: collision with root package name */
    public View f81801u0;

    /* renamed from: u1  reason: collision with root package name */
    public final LeverSelectDialogFragment.h f81802u1;

    /* renamed from: v  reason: collision with root package name */
    public View f81803v;

    /* renamed from: v0  reason: collision with root package name */
    public CheckBox f81804v0;

    /* renamed from: w  reason: collision with root package name */
    public View f81805w;

    /* renamed from: w0  reason: collision with root package name */
    public BottomLineTextView f81806w0;

    /* renamed from: x  reason: collision with root package name */
    public ContractGearsTradePriceEditText f81807x;

    /* renamed from: x0  reason: collision with root package name */
    public View f81808x0;

    /* renamed from: y  reason: collision with root package name */
    public EditText f81809y;

    /* renamed from: y0  reason: collision with root package name */
    public View f81810y0;

    /* renamed from: z  reason: collision with root package name */
    public ImageButton f81811z;

    /* renamed from: z0  reason: collision with root package name */
    public ContractTpslEditText f81812z0;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                int unused = SwapTradeTogetherView.this.W = 0;
            }
            String obj = editable.toString();
            if (SwapTradeTogetherView.this.W == 0) {
                if (SwapTradeTogetherView.this.f81751c == 0) {
                    String unused2 = SwapTradeTogetherView.this.f81761f0 = obj;
                } else {
                    String unused3 = SwapTradeTogetherView.this.f81764g0 = obj;
                }
            }
            if (editable.length() == 0) {
                SwapTradeTogetherView.this.D.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_regular));
                SwapTradeTogetherView.this.x2("0");
                return;
            }
            SwapTradeTogetherView.this.D.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_medium));
            String str = null;
            if (a7.e.E(TradeType.SWAP)) {
                if (SwapTradeTogetherView.this.W == 0) {
                    str = i6.m.b(editable, 10, us.i.k(SwapTradeTogetherView.this.f81760f.t()));
                }
                if (str != null) {
                    SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
                    swapTradeTogetherView.F2(swapTradeTogetherView.D, str);
                    return;
                }
            } else {
                if (SwapTradeTogetherView.this.W == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = i6.m.b(editable, 10, us.i.l(SwapTradeTogetherView.this.f81760f.t()));
                    }
                }
                if (str != null) {
                    SwapTradeTogetherView swapTradeTogetherView2 = SwapTradeTogetherView.this;
                    swapTradeTogetherView2.F2(swapTradeTogetherView2.D, str);
                    return;
                }
            }
            SwapTradeTogetherView.this.f81760f.j(false, true);
            SwapTradeTogetherView.this.s2();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
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
            if (z11) {
                SwapTradeTogetherView.this.j1(i11);
            }
        }
    }

    public class c implements TradeTrendView.b {
        public c() {
        }

        public void a(c.a aVar) {
            SwapTradeTogetherView.this.setPriceText(i6.m.i(aVar.a(), us.i.m(aVar.o0())));
            SwapTradeTogetherView.this.t0();
            SwapTradeTogetherView.this.f81765g1.hideKeyboard();
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
            SwapTradeTogetherView.this.setPriceText(i6.m.m(aVar.b(), us.i.m(aVar.o0())));
        }
    }

    public class d implements ViewTreeObserver.OnPreDrawListener {
        public d() {
        }

        public boolean onPreDraw() {
            int d11 = SwapTradeTogetherView.this.V.d();
            SwapTradeTogetherView.this.V.l(d11 / 2, d11);
            return true;
        }
    }

    public class e implements BaseDialogFragment.c {
        public e() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeTogetherView.this.f81775k.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeTogetherView.this.f81775k.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class f implements ContractGearsTradePriceEditText.c {
        public f() {
        }

        public void a() {
            SwapTradeTogetherView.this.D1();
            SwapTradeTogetherView.this.W0.showAsDropDown(((FragmentActivity) SwapTradeTogetherView.this.getContext()).getSupportFragmentManager(), (View) SwapTradeTogetherView.this.f81807x, true, 0, 0, 80);
        }

        public void b() {
        }
    }

    public class g implements TextWatcher {
        public g() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                SwapTradeTogetherView.this.f81809y.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_regular));
            } else {
                SwapTradeTogetherView.this.f81809y.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            if (i6.m.b(editable, 10, 1) != null) {
                SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
                swapTradeTogetherView.F2(swapTradeTogetherView.f81809y, editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class h implements ViewTreeObserver.OnPreDrawListener {
        public h() {
        }

        public boolean onPreDraw() {
            SwapTradeTogetherView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int d11 = SwapTradeTogetherView.this.V.d();
            SwapTradeTogetherView.this.V.l(d11 / 2, d11);
            return true;
        }
    }

    public class i implements MenuItemOnClickListener {
        public i() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : SwapTradeTogetherView.this.Z0) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            if (i11 == 0) {
                SwapTradeTogetherView.this.f81760f.n().S(0);
                if (com.hbg.lib.core.util.w.l()) {
                    SwapTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    SwapTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                if (SwapTradeTogetherView.this.V != null) {
                    SwapTradeTogetherView.this.V.c(0);
                }
            } else if (i11 == 1) {
                SwapTradeTogetherView.this.f81760f.n().S(1);
                if (com.hbg.lib.core.util.w.l()) {
                    SwapTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_red);
                } else {
                    SwapTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_green);
                }
                if (SwapTradeTogetherView.this.V != null) {
                    SwapTradeTogetherView.this.V.c(1);
                }
            } else {
                SwapTradeTogetherView.this.f81760f.n().S(2);
                if (com.hbg.lib.core.util.w.l()) {
                    SwapTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_green);
                } else {
                    SwapTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_red);
                }
                if (SwapTradeTogetherView.this.V != null) {
                    SwapTradeTogetherView.this.V.c(2);
                }
            }
            SwapTradeTogetherView.this.f81760f.n().Y(false);
            if (SwapTradeTogetherView.this.U0 != null) {
                SwapTradeTogetherView.this.U0.dismiss();
            }
        }
    }

    public class j implements BaseDialogFragment.c {
        public j() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeTogetherView.this.f81781m.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeTogetherView.this.f81781m.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class k implements ContractTpslEditText.c {
        public k() {
        }

        public void afterTextChanged(EditText editText, String str) {
            if (editText == SwapTradeTogetherView.this.B0) {
                SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
                FutureTpSlSettingParams unused = swapTradeTogetherView.G0 = FutureTpSlSettingParams.changeTpSlCache(swapTradeTogetherView.G0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
            } else if (editText == SwapTradeTogetherView.this.C0) {
                SwapTradeTogetherView swapTradeTogetherView2 = SwapTradeTogetherView.this;
                FutureTpSlSettingParams unused2 = swapTradeTogetherView2.H0 = FutureTpSlSettingParams.changeTpSlCache(swapTradeTogetherView2.H0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
            }
        }

        public int getTradePricePrecision() {
            if (SwapTradeTogetherView.this.f81760f != null) {
                return us.i.m(SwapTradeTogetherView.this.f81760f.t());
            }
            return 14;
        }
    }

    public class l implements MenuItemOnClickListener {
        public l() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (SwapTradeTogetherView.this.f81760f.n() != null) {
                SwapTradeTogetherView.this.f81760f.n().t(i11);
            }
            if (SwapTradeTogetherView.this.P0 != null) {
                SwapTradeTogetherView.this.P0.dismiss();
            }
        }
    }

    public class m implements CommonPopListItem.a {
        public m() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            if (SwapTradeTogetherView.this.S0 != null) {
                SwapTradeTogetherView.this.S0.dismiss();
            }
            int type = commonPopListItem.getType();
            if (type == SwapTradeTogetherView.this.f81757e) {
                return;
            }
            if (type != 0 || (SwapTradeTogetherView.this.f81757e != 3 && SwapTradeTogetherView.this.f81757e != 4)) {
                SwapTradeTogetherView.this.T0(type);
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                if (type != 0) {
                    if (type == 1) {
                        ContractGuideHelper.b(fragmentActivity, 4);
                        return;
                    } else if (!(type == 2 || type == 3 || type == 4)) {
                        return;
                    }
                }
                if (!SwapTradeTogetherView.this.f81753c1) {
                    ContractGuideHelper.b(fragmentActivity, 1);
                }
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == SwapTradeTogetherView.this.f81757e || (commonPopListItem.getType() == 0 && (SwapTradeTogetherView.this.f81757e == 3 || SwapTradeTogetherView.this.f81757e == 4));
        }
    }

    public class n implements CommonPopListItem.a {
        public n() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            SwapTradeTogetherView.this.f81797t.setPriceInputType(commonPopListItem.getType());
            SwapTradeTogetherView.this.f81797t.setCurrentPriceTypeText(commonPopListItem.getText());
            if (SwapTradeTogetherView.this.V0 != null) {
                SwapTradeTogetherView.this.V0.dismiss();
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return SwapTradeTogetherView.this.f81797t.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class o implements CommonPopListItem.a {
        public o() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            SwapTradeTogetherView.this.f81807x.setPriceInputType(commonPopListItem.getType());
            SwapTradeTogetherView.this.f81807x.setCurrentPriceTypeText(commonPopListItem.getText());
            if (SwapTradeTogetherView.this.W0 != null) {
                SwapTradeTogetherView.this.W0.dismiss();
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return SwapTradeTogetherView.this.f81807x.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class p implements LeverSelectDialogFragment.h {
        public p() {
        }

        public void N0() {
            if (SwapTradeTogetherView.this.f81760f != null) {
                SwapTradeTogetherView.this.f81760f.w().N0();
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return uc.b.d(tradeType, str, i11);
        }

        public void P0(String str) {
            SwapTradeTogetherView.this.x0(str);
            SwapTradeTogetherView.this.f81760f.F(str);
            SwapTradeTogetherView.this.f81760f.C();
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return SwapTradeTogetherView.this.f81760f.k(str, levelAvailableMarginInfo);
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            return false;
        }
    }

    public class q implements ContractTradeAmountView.a {
        public q() {
        }

        public String o0() {
            return SwapTradeTogetherView.this.f81760f.t();
        }
    }

    public class r implements BaseDialogFragment.c {
        public r() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeTogetherView.this.f81797t.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeTogetherView.this.f81797t.p(R.drawable.trade_arrow_up);
        }
    }

    public class s implements BaseDialogFragment.c {
        public s() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeTogetherView.this.f81807x.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeTogetherView.this.f81807x.p(R.drawable.trade_arrow_up);
        }
    }

    public class t extends BaseSubscriber<SwapUserInfo.UserBean> {
        public t() {
        }

        /* renamed from: a */
        public void onNext(SwapUserInfo.UserBean userBean) {
            super.onNext(userBean);
            SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
            swapTradeTogetherView.n1(swapTradeTogetherView.f81748b);
        }
    }

    public class u extends BaseSubscriber<SwapUserInfo.UserBean> {
        public u() {
        }

        /* renamed from: a */
        public void onNext(SwapUserInfo.UserBean userBean) {
            super.onNext(userBean);
            SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
            swapTradeTogetherView.n1(swapTradeTogetherView.f81748b);
        }
    }

    public class v implements TextWatcher {
        public v() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                SwapTradeTogetherView.this.f81791q.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_regular));
            } else {
                SwapTradeTogetherView.this.f81791q.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
            swapTradeTogetherView.G2(swapTradeTogetherView.f81760f.o(editable.toString()));
            if (i6.m.b(editable, 10, us.i.m(SwapTradeTogetherView.this.f81760f.t())) != null) {
                SwapTradeTogetherView swapTradeTogetherView2 = SwapTradeTogetherView.this;
                swapTradeTogetherView2.F2(swapTradeTogetherView2.f81791q, editable.toString());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class w implements ContractGearsTradePriceEditText.c {
        public w() {
        }

        public void a() {
            SwapTradeTogetherView.this.x1();
        }

        public void b() {
            SwapTradeTogetherView.this.x1();
        }
    }

    public class x implements TextWatcher {
        public x() {
        }

        public void afterTextChanged(Editable editable) {
            int tradePriceType = SwapTradeTogetherView.this.getTradePriceType();
            if (editable.length() == 0) {
                SwapTradeTogetherView.this.f81800u.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_regular));
                SwapTradeTogetherView.this.x2("0");
            } else {
                SwapTradeTogetherView.this.f81800u.setTypeface(ResourcesCompat.h(SwapTradeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            SwapTradeTogetherView swapTradeTogetherView = SwapTradeTogetherView.this;
            swapTradeTogetherView.X0(swapTradeTogetherView.f81760f.o(editable.toString()));
            String str = null;
            if (tradePriceType == 1) {
                str = i6.m.b(editable, 10, us.i.m(SwapTradeTogetherView.this.f81760f.t()));
            }
            if (str != null) {
                SwapTradeTogetherView swapTradeTogetherView2 = SwapTradeTogetherView.this;
                swapTradeTogetherView2.F2(swapTradeTogetherView2.f81800u, editable.toString());
                return;
            }
            if (SwapTradeTogetherView.this.f81751c == 0) {
                if (SwapTradeTogetherView.this.f81800u.hasFocus()) {
                    boolean unused = SwapTradeTogetherView.this.K0 = false;
                }
                if (SwapTradeTogetherView.this.f81757e != 5) {
                    String unused2 = SwapTradeTogetherView.this.f81755d0 = editable.toString();
                }
            } else {
                if (SwapTradeTogetherView.this.f81800u.hasFocus()) {
                    boolean unused3 = SwapTradeTogetherView.this.L0 = false;
                }
                if (SwapTradeTogetherView.this.f81757e != 5) {
                    String unused4 = SwapTradeTogetherView.this.f81758e0 = editable.toString();
                }
            }
            SwapTradeTogetherView.this.f81760f.i(false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public SwapTradeTogetherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G1(int i11) {
        if (i11 == 0) {
            T0(0);
            this.f81788o1.setType(0);
        } else if (i11 == 1) {
            T0(3);
            this.f81788o1.setType(3);
        } else {
            T0(4);
            this.f81788o1.setType(4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void H1(View view) {
        if (this.f81786n1 != null) {
            LimitChooseDialog vh2 = LimitChooseDialog.vh();
            Bundle bundle = new Bundle();
            int i11 = this.f81757e;
            bundle.putInt("selIndex", i11 == 0 ? 0 : i11 == 3 ? 1 : 2);
            vh2.setArguments(bundle);
            vh2.wh(new e2(this)).show(this.f81786n1, "limitChoose");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean I1(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        sn.f.f(TradeType.SWAP, getContext());
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J1(View view, boolean z11) {
        t2(this.f81797t, z11);
        this.f81759e1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void K1(View view) {
        x1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(View view, boolean z11) {
        t2(this.C, z11);
        if (z11) {
            setProgress(0);
            if (this.W == 5) {
                this.D.setText("");
            }
            this.W = 0;
        }
        this.f81759e1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M1() {
        this.Q.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N1() {
        this.Q.setImageResource(R.drawable.trade_arrow_down_new);
        this.P0 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void O1(View view) {
        if (this.f81760f.n().x().size() > 0) {
            BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
            this.P0 = bottomMenuFragment;
            bottomMenuFragment.setBottomMenuShowListener(new j2(this));
            this.P0.setBottomMenuDismissListener(new h2(this));
            this.P0.setMenuItems(this.f81747a1);
            this.P0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
            this.P0.show(((Activity) this.O0).getFragmentManager(), "depthBottomMenuFragment");
        }
        this.f81765g1.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void P1(View view) {
        this.f81765g1.hideKeyboard();
        this.f81760f.I();
        gs.g.j(this.Y0, this.X0, "lever_adjust", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q1() {
        this.U0 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void R1(View view) {
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        this.U0 = bottomMenuFragment;
        bottomMenuFragment.setMenuItems(this.Z0);
        this.U0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
        this.U0.setBottomMenuDismissListener(new i2(this));
        this.U0.show(((Activity) this.O0).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S1() {
        this.S0 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void T1(View view) {
        this.f81797t.clearFocus();
        this.f81765g1.hideKeyboard();
        CommonListPopupDialog commonListPopupDialog = new CommonListPopupDialog();
        this.S0 = commonListPopupDialog;
        commonListPopupDialog.setDialogFragmentListener(new e());
        this.S0.setDialogDismissListener(new a2(this));
        this.S0.setData(this.T0);
        this.S0.setFollowViewWidth(true);
        this.S0.showAsDropDown(((FragmentActivity) this.O0).getSupportFragmentManager(), this.f81769i);
        gs.g.j(this.Y0, this.X0, "entrust_model", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void U1(CompoundButton compoundButton, boolean z11) {
        gl.b.b(TradeType.SWAP, z11);
        HashMap hashMap = new HashMap();
        if (z11) {
            this.f81808x0.setVisibility(0);
            this.f81810y0.setVisibility(0);
            o1();
            hashMap.put("button_type", "open");
        } else {
            this.F0.setVisibility(8);
            this.f81808x0.setVisibility(8);
            this.f81810y0.setVisibility(8);
            u0(true, false);
            o1();
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "same_screen");
        gs.g.i("take_profit_and_stop_loss_switch_click", hashMap);
        gs.g.j(this.Y0, this.X0, "stop_surplus_loss", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean V1(View view, MotionEvent motionEvent) {
        if (!tg.r.x().F0()) {
            ContractModuleConfig.a().h(TradeType.SWAP, getContext());
            return true;
        } else if (z.f().k()) {
            return false;
        } else {
            HuobiToastUtil.j(R.string.n_contract_please_open_first);
            return true;
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void W1(View view) {
        ContractGuideHelper.d(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), SwapTradeTogetherView.class.getName(), ContractGuideHelper.a(this.f81757e));
        gs.g.j(this.Y0, this.X0, "entrust_model_explanation", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void X1(View view) {
        ContractGuideHelper.b((FragmentActivity) oa.a.g().b(), 2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y1(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        this.G0 = r2(futureTpSlSettingParams, true);
        FutureTpSlSettingParams r22 = r2(futureTpSlSettingParams2, false);
        this.H0 = r22;
        this.f81785n0.refreshTpSlView(this.G0, r22);
        B2();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Z1(FutureTpSlSettingDialogFragment.c cVar, View view) {
        if (TextUtils.isEmpty(this.f81760f.p())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!D2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f81765g1.hideKeyboard();
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = new FutureTpSlDialogShowBean();
            futureTpSlDialogShowBean.setTradeType(TradeType.SWAP);
            w1(futureTpSlDialogShowBean);
            FutureTpSlSettingDialogFragment Kh = FutureTpSlSettingDialogFragment.Kh(futureTpSlDialogShowBean);
            this.J0 = Kh;
            Kh.Vh(i6.m.a(String.valueOf(this.f81760f.n().z())));
            this.J0.Uh(cVar);
            this.J0.show(((FragmentActivity) this.O0).getSupportFragmentManager(), "FutureTpSettingDialogFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void a2(View view) {
        this.G0 = null;
        r1();
        if (this.H0 == null) {
            this.F0.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void b2(View view) {
        this.H0 = null;
        q1();
        if (this.G0 == null) {
            this.F0.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c2(View view) {
        sn.f.f(TradeType.SWAP, this.O0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d2(View view) {
        D1();
        this.W0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f81807x, true, 0, 0, 80);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e2(View view) {
        this.f81765g1.hideKeyboard();
        if (!tg.r.x().F0()) {
            Context context = this.O0;
            boolean z11 = context instanceof HuobiMainActivity;
            Intent v11 = k0.v(context, z11);
            if (!z11) {
                v11.addFlags(67108864);
            }
            rn.c.i().d(this.O0, new JumpTarget(v11, v11));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (z.f().h() == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            z.f().g(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new t());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!z.f().k()) {
            us.h.d(getContext(), true);
            gs.g.i("App_swap_open_click", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f81760f.K(s1(true));
            HashMap hashMap = new HashMap();
            hashMap.put("coin_contract_trade_set", "same_screen");
            gs.g.j(this.X0, (String) null, this.f81751c == 0 ? "buy_open" : "buy_flat", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f2(View view) {
        this.f81765g1.hideKeyboard();
        if (z.f().h() == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            z.f().g(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new u());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!z.f().k()) {
            us.h.d(getContext(), true);
            gs.g.i("App_swap_open_click", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f81760f.K(s1(false));
            HashMap hashMap = new HashMap();
            hashMap.put("coin_contract_trade_set", "same_screen");
            gs.g.j(this.X0, (String) null, this.f81751c == 0 ? "sell_open" : "sell_flat", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g2(View view, boolean z11) {
        t2(this.f81789p, z11);
        this.f81759e1.onFocusChange(view, z11);
    }

    private String getBboStr() {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return this.O0.getString(R.string.n_contract_trade_rival_price);
        }
        return this.O0.getString(R.string.n_contract_trade_optimal_one);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h2(View view) {
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ImageButton imageButton = this.f81811z;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.f81811z.isSelected()) {
            this.f81765g1.hideKeyboard();
            this.f81797t.setCurrentPriceTypeText(this.O0.getString(R.string.contract_trade_position_close_quick));
            this.f81797t.setPriceInputType(6);
            this.f81800u.setText("");
        } else {
            this.f81797t.setPriceInputType(1);
            this.f81760f.i(false);
        }
        setLightingSelect(this.f81811z.isSelected());
        this.f81756d1.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i2(View view) {
        int i11;
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.f81756d1.isSelected() && ((i11 = this.f81757e) == 0 || i11 == 3 || i11 == 4)) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_spot_order_risk)).C0(getContext().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
        TextView textView = this.f81756d1;
        textView.setSelected(!textView.isSelected());
        if (this.f81797t.k()) {
            this.f81797t.setPriceInputType(1);
            this.f81760f.i(false);
        } else {
            if (this.f81800u.hasFocus()) {
                this.f81765g1.hideKeyboard();
            }
            if (this.f81757e == 1) {
                this.f81797t.setCurrentPriceTypeText(this.O0.getString(R.string.n_contract_trade_optimal_five));
                this.f81797t.setPriceInputType(3);
            } else {
                this.f81797t.setCurrentPriceTypeText(getBboStr());
                this.f81797t.setPriceInputType(2);
            }
            this.f81800u.setText("");
        }
        setLightingSelect(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2() {
        this.V0 = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k2() {
        this.W0 = null;
    }

    public static /* synthetic */ void l2(HBDialogFragment hBDialogFragment) {
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m2(String str, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Rh((Activity) getContext(), str);
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n2() {
        this.Q0 = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p2(DialogFragment dialogFragment, View view) {
        v0.e(getContext(), "900000106126");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q2() {
        if (this.f81798t0.getVisibility() == 0) {
            ej.j.h(this.f81801u0, getContext().getString(R.string.n_contract_tp_sl_guide_hint), r1.f60422b, new g2(this));
        }
    }

    private void setLightingSelect(boolean z11) {
        this.f81811z.setSelected(z11);
        if (z11) {
            setProgress(100);
            j1(100);
        } else if (this.f81797t.getLastTradePriceType() == 6) {
            setProgress(0);
            if (this.f81751c == 0) {
                this.D.setText(this.f81761f0);
            } else {
                this.D.setText(this.f81764g0);
            }
        }
        s2();
    }

    private void setSlText(String str) {
        this.C0.setText(str);
    }

    private void setTpText(String str) {
        this.B0.setText(str);
    }

    public void A0(int i11) {
        ViewGroup viewGroup = this.f81750b1;
        if (viewGroup != null) {
            viewGroup.setVisibility(i11);
            this.f81762f1.setUI(this.f81760f.w());
            this.f81762f1.setCountDownTime(bj.d.o());
        }
    }

    public final void A1() {
        this.H.setOnClickListener(new o2(this));
        this.I.setOnClickListener(new l1(this));
        this.f81789p.setOnEditTextFocusChangeListener(new l2(this));
        this.f81811z.setOnClickListener(new n2(this));
        this.f81756d1.setOnClickListener(new o1(this));
        this.f81791q.addTextChangedListener(new v());
        this.f81797t.setOnEditTextFocusChangeListener(new k2(this));
        this.f81797t.setOnClickListener(new ts.n1(this));
        this.f81797t.setCallback(new w());
        this.f81800u.addTextChangedListener(new x());
        this.D.setOnFocusChangeListener(new s1(this));
        this.D.addTextChangedListener(new a());
        this.f81746a0.setOnProgressChangedListener(new b());
        this.V.setCallback(new c());
        this.V.setNewestPriceItemViewPreDrawListener(new d());
        this.R.setOnClickListener(new t2(this));
        this.f81784n.setOnClickListener(new j1(this));
        this.S.setOnClickListener(new s2(this));
        this.f81769i.setOnClickListener(new m1(this));
        this.f81804v0.setOnCheckedChangeListener(new w1(this));
        this.f81804v0.setOnTouchListener(new t1(this));
        this.f81771i1.setOnClickListener(new u1(this));
        this.f81806w0.setOnClickListener(q1.f60416b);
        this.f81810y0.setOnClickListener(new p1(this, new d2(this)));
        this.D0.setOnClickListener(new k1(this));
        this.E0.setOnClickListener(new p2(this));
        this.f81805w.setOnClickListener(new q2(this));
        this.f81807x.setOnClickListener(new f2(this));
        this.f81807x.setCallback(new f());
        this.f81809y.addTextChangedListener(new g());
    }

    public final void A2(String str, String str2, String str3) {
        if (this.f81751c == 0) {
            this.f81770i0.setVisibility(0);
            this.f81773j0.setVisibility(0);
        } else {
            this.f81770i0.setVisibility(8);
            this.f81773j0.setVisibility(8);
        }
        this.f81752c0.setText(str);
        TextView textView = this.f81782m0;
        if (!TextUtils.equals("--", str2)) {
            str2 = AppUtil.b(str2, str3);
        }
        textView.setText(str2);
        this.f81776k0.setText(l1(true));
        this.f81779l0.setText(l1(false));
        s2();
    }

    public final void B1() {
        CommonListPopupDialog commonListPopupDialog = new CommonListPopupDialog();
        this.V0 = commonListPopupDialog;
        commonListPopupDialog.setDialogFragmentListener(new r());
        this.V0.setDialogDismissListener(new z1(this));
        ArrayList arrayList = new ArrayList();
        if (this.f81757e == 1) {
            arrayList.add(new CommonPopListItem(3, this.O0.getString(R.string.n_contract_trade_optimal_five), this.f81796s1));
            arrayList.add(new CommonPopListItem(4, this.O0.getString(R.string.n_contract_trade_optimal_ten), this.f81796s1));
            arrayList.add(new CommonPopListItem(5, this.O0.getString(R.string.n_contract_trade_optimal_twenty), this.f81796s1));
        } else {
            arrayList.add(new CommonPopListItem(2, getBboStr(), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f81796s1));
            arrayList.add(new CommonPopListItem(3, this.O0.getString(R.string.n_contract_trade_optimal_five), this.f81796s1));
            arrayList.add(new CommonPopListItem(4, this.O0.getString(R.string.n_contract_trade_optimal_ten), this.f81796s1));
            arrayList.add(new CommonPopListItem(5, this.O0.getString(R.string.n_contract_trade_optimal_twenty), this.f81796s1));
        }
        this.V0.setData(arrayList);
    }

    public final void B2() {
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.setBuyList(list);
        }
    }

    public final void C1() {
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getContext().getString(R.string.n_contract_order_type_limit), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f81794r1);
        this.f81788o1 = commonPopListItem;
        this.T0.add(commonPopListItem);
        this.T0.add(new CommonPopListItem(6, getContext().getString(R.string.n_exchange_price_market_deal), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f81794r1));
        this.T0.add(new CommonPopListItem(1, getContext().getString(R.string.n_contract_order_type_trigger), this.f81794r1));
        this.T0.add(new CommonPopListItem(5, getContext().getString(R.string.n_contract_track_order), this.f81794r1));
        this.T0.add(new CommonPopListItem(2, getContext().getString(R.string.n_contract_trade_post_only), this.f81794r1));
    }

    public final void C2() {
        i6.i.b().g(new m2(this), 10);
    }

    public final void D1() {
        CommonListPopupDialog commonListPopupDialog = new CommonListPopupDialog();
        this.W0 = commonListPopupDialog;
        commonListPopupDialog.setDialogFragmentListener(new s());
        this.W0.setDialogDismissListener(new x1(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(7, this.O0.getString(R.string.n_contract_theoretical_price), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f81799t1));
        arrayList.add(new CommonPopListItem(3, this.O0.getString(R.string.n_contract_trade_optimal_five), this.f81799t1));
        arrayList.add(new CommonPopListItem(4, this.O0.getString(R.string.n_contract_trade_optimal_ten), this.f81799t1));
        arrayList.add(new CommonPopListItem(5, this.O0.getString(R.string.n_contract_trade_optimal_twenty), this.f81799t1));
        this.W0.setData(arrayList);
    }

    public final boolean D2() {
        BigDecimal a11 = i6.m.a(getInputPriceText());
        if (getTradePriceType() != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            return this.f81760f.J(s1(F1()));
        }
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.input_unknow_text), new Object[]{this.f81800u.getHint().toString()}));
        return false;
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.setSellList(list);
        }
    }

    public final void E1(View view) {
        this.S = (ImageView) view.findViewById(R.id.trend_change_iv);
        this.Z0.add(new MenuItem(0, this.O0.getString(R.string.n_contract_trade_trend_default), this.O0.getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f81790p1));
        List<MenuItem> list = this.Z0;
        String string = this.O0.getString(R.string.n_contract_trade_trend_buy);
        String string2 = this.O0.getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f81790p1));
        this.Z0.add(new MenuItem(2, this.O0.getString(R.string.n_contract_trade_trend_sell), this.O0.getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.f81790p1));
    }

    public void E2(SwapAccountInfo swapAccountInfo) {
        this.f81763g = swapAccountInfo;
        s2();
    }

    public boolean F1() {
        if (this.f81751c == 0) {
            if (this.f81748b == 0) {
                return true;
            }
            return false;
        } else if (this.f81748b != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void F2(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public void F3(PriceLimitInfo priceLimitInfo) {
    }

    public void G2(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(i6.m.a(str)) == 0) {
            this.f81793r.setVisibility(8);
            return;
        }
        this.f81795s.setText(AppUtil.b(String.format(this.O0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f81793r.setVisibility(0);
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment;
        int i11;
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.setNewestPrice(marketCurrentPriceItem);
        }
        this.f81760f.i(false);
        String obj = this.f81800u.getText().toString();
        String b11 = marketCurrentPriceItem.b();
        if (TextUtils.isEmpty(obj) && !this.f81800u.hasFocus() && !TextUtils.equals("--", b11) && this.f81797t.getTradePriceType() == 1 && (i11 = this.f81757e) != 5) {
            if (this.f81751c == 0) {
                if (this.M0 || i11 == 6) {
                    this.K0 = true;
                    this.f81800u.setText(b11);
                }
            } else if (this.N0 || i11 == 6) {
                this.L0 = true;
                this.f81800u.setText(b11);
            }
        }
        if (!TextUtils.equals("--", b11)) {
            if (this.f81751c == 0) {
                this.M0 = false;
            } else {
                this.N0 = false;
            }
        }
        if (this.f81760f != null && (futureTpSlSettingDialogFragment = this.J0) != null && futureTpSlSettingDialogFragment.isVisible()) {
            this.J0.Vh(i6.m.a(String.valueOf(this.f81760f.n().z())));
        }
    }

    public void I0() {
        if (this.f81797t.getTradePriceType() != 1) {
            this.f81760f.i(false);
        }
    }

    public void J0() {
        this.D.setText("");
        setProgress(0);
    }

    public void K0() {
        LeverSelectDialogFragment leverSelectDialogFragment = this.Q0;
        if (leverSelectDialogFragment != null) {
            leverSelectDialogFragment.dismiss();
            this.Q0 = null;
        }
    }

    public void L(int i11, SwapCurrencyInfo swapCurrencyInfo) {
        if (swapCurrencyInfo != null) {
            if (swapCurrencyInfo.getContractStatus() == 5 || swapCurrencyInfo.getContractStatus() == 7) {
                this.E.setText(R.string.n_contract_trade_settling);
                this.F.setText(R.string.n_contract_trade_system_settling);
            } else if (swapCurrencyInfo.getContractStatus() == 6 || swapCurrencyInfo.getContractStatus() == 8) {
                this.E.setText(R.string.n_contract_trade_delivering);
                this.F.setText(R.string.n_contract_trade_system_delivering);
            } else if (swapCurrencyInfo.getContractStatus() == 3) {
                this.E.setText(R.string.n_contract_trade_stop);
                this.F.setText("");
            } else if (swapCurrencyInfo.getContractStatus() == 4) {
                this.E.setText(R.string.n_contract_trade_pre_trade);
                this.F.setText("");
            }
        }
        this.G.setVisibility(i11);
    }

    public void L0() {
        if (this.f81797t.getTradePriceType() == 1) {
            this.f81754d = false;
        } else {
            this.f81760f.i(false);
        }
    }

    public void M0(int i11) {
        boolean z11 = true;
        if (!tg.r.x().F0() || !(z.f().h() == null || z.f().h().getActiveState() == 1)) {
            this.H.setBackgroundResource(R.drawable.shape_contract_login);
        } else if (ContractCalmPeriodHelper.d()) {
            this.H.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
            this.I.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
        } else {
            RelativeLayout relativeLayout = this.H;
            boolean l11 = com.hbg.lib.core.util.w.l();
            int i12 = R.drawable.trade_btn_sell_selector;
            relativeLayout.setBackgroundResource(l11 ? R.drawable.trade_btn_sell_selector : R.drawable.trade_btn_buy_selector);
            RelativeLayout relativeLayout2 = this.I;
            if (com.hbg.lib.core.util.w.l()) {
                i12 = R.drawable.trade_btn_buy_selector;
            }
            relativeLayout2.setBackgroundResource(i12);
        }
        MultiConfigBuilder configBuilder = this.f81746a0.getConfigBuilder();
        Context context = getContext();
        boolean g11 = NightHelper.e().g();
        if (this.f81751c != 0) {
            z11 = false;
        }
        configBuilder.colorConfig(context, g11, z11).build();
    }

    public void N0(ContractDepth contractDepth, int i11) {
        String priceTick = contractDepth.getPriceTick();
        if (!TextUtils.isEmpty(priceTick)) {
            this.P.setText(i6.m.a(priceTick).stripTrailingZeros().toPlainString());
        } else {
            this.P.setText("--");
        }
    }

    public void O0(int i11) {
        this.f81751c = i11;
        this.W = 0;
        t0();
        p1();
        n0();
        Y0(this.f81751c);
        M0(this.f81748b);
        T0(this.f81757e);
        m1();
        C2();
    }

    public void P0(String str, String str2) {
        String t11 = this.f81760f.t();
        if (a7.e.E(TradeType.SWAP)) {
            int i11 = this.f81751c;
            if (i11 == 0) {
                w2(this.O0.getString(R.string.n_contract_contract_open_long), str, t11);
                A2(this.O0.getString(R.string.n_contract_contract_open_short), str2, t11);
            } else if (i11 == 1) {
                w2(this.O0.getString(R.string.n_contract_trade_can_close_short), str, t11);
                A2(this.O0.getString(R.string.n_contract_trade_can_close_long), str2, t11);
            }
        } else {
            int i12 = this.f81751c;
            if (i12 == 0) {
                v2(this.O0.getString(R.string.n_contract_contract_open_long), str);
                z2(this.O0.getString(R.string.n_contract_contract_open_short), str2);
            } else if (i12 == 1) {
                w2(this.O0.getString(R.string.n_contract_trade_can_close_short), str, this.O0.getString(R.string.n_contract_vol_sheet));
                A2(this.O0.getString(R.string.n_contract_trade_can_close_long), str2, this.O0.getString(R.string.n_contract_vol_sheet));
            }
        }
    }

    public void Q0() {
        boolean z11 = getPositionType() == 0;
        this.C.setData(z11);
        TradeType tradeType = TradeType.SWAP;
        if (!a7.e.E(tradeType)) {
            this.D.setHint(this.O0.getString(R.string.n_contract_trade_input_amount));
        } else if (!z11 || !a7.e.H(tradeType)) {
            this.D.setHint(this.O0.getString(R.string.n_contract_unit_amount));
        } else {
            this.D.setHint(this.O0.getString(R.string.n_contract_unit_principal));
        }
        u2();
    }

    public void R0(boolean z11) {
        if (z11) {
            this.f81764g0 = null;
            this.f81761f0 = null;
            this.f81758e0 = null;
            this.f81755d0 = null;
        } else {
            int i11 = this.f81751c;
            if (i11 == 0) {
                this.f81761f0 = null;
                this.f81755d0 = null;
            } else if (i11 == 1) {
                this.f81764g0 = null;
                this.f81758e0 = null;
            }
        }
        this.f81800u.setText("");
        this.D.setText("");
    }

    public void S0(String str, String str2) {
        if (this.f81751c == 1) {
            this.D.setText(str);
        } else if (!this.D.getText().toString().equals(str2)) {
            this.D.setText(str2);
        }
    }

    public void T0(int i11) {
        SP.q("SwapTradeTogetherViewOrderType", i11);
        this.f81757e = i11;
        this.f81756d1.setSelected(false);
        m1();
        ViewUtil.m(this.f81774j1, false);
        ViewUtil.m(this.f81777k1, true);
        this.f81785n0.changeTradeOrderType(this.f81757e, this.f81751c, this.G0, this.H0);
        this.f81780l1.setVisibility(8);
        switch (this.f81757e) {
            case 0:
            case 3:
            case 4:
                this.f81780l1.setVisibility(0);
                int i12 = this.f81757e;
                if (i12 == 0) {
                    this.f81783m1.setText("GTC");
                } else if (i12 == 3) {
                    this.f81783m1.setText("IOC");
                } else {
                    this.f81783m1.setText("FOK");
                }
                this.f81803v.setVisibility(8);
                this.f81805w.setVisibility(8);
                this.f81772j.setText(getContext().getString(R.string.n_contract_order_type_limit));
                this.f81787o.setVisibility(8);
                this.f81756d1.setVisibility(0);
                this.f81756d1.setText(R.string.n_contract_trade_rival_price);
                this.f81797t.setPriceInputType(1);
                this.f81797t.setHintText((int) R.string.n_contract_trade_input_price);
                k1();
                break;
            case 1:
                this.f81803v.setVisibility(8);
                this.f81805w.setVisibility(8);
                this.f81772j.setText(getContext().getString(R.string.n_contract_order_type_trigger));
                this.f81787o.setVisibility(0);
                this.f81756d1.setVisibility(0);
                this.f81756d1.setText(R.string.n_contract_trade_optimal_n);
                this.f81789p.setPriceInputType(1);
                this.f81789p.setTradeUseType(1);
                this.f81789p.setDividerVisibility(8);
                this.f81789p.setLabelVisibility(8);
                this.f81797t.setPriceInputType(1);
                this.f81797t.setHintText((int) R.string.n_contract_trade_input_price);
                w0(true, false);
                break;
            case 2:
                this.f81803v.setVisibility(8);
                this.f81805w.setVisibility(8);
                this.f81772j.setText(getContext().getString(R.string.n_contract_trade_post_only));
                this.f81787o.setVisibility(8);
                this.f81756d1.setVisibility(8);
                this.f81797t.setPriceInputType(1);
                this.f81797t.setHintText((int) R.string.n_contract_trade_input_price);
                k1();
                break;
            case 5:
                this.f81772j.setText(getContext().getString(R.string.n_contract_track_order));
                this.f81787o.setVisibility(8);
                this.f81756d1.setVisibility(8);
                this.f81803v.setVisibility(0);
                this.f81805w.setVisibility(0);
                this.f81807x.setPriceInputType(2);
                this.f81807x.setCurrentPriceTypeText(this.O0.getString(R.string.n_contract_trade_optimal_twenty));
                this.f81807x.setPriceInputType(5);
                this.f81797t.setPriceInputType(1);
                this.f81797t.setHintText((int) R.string.n_contract_active_price);
                this.f81800u.setText("");
                break;
            case 6:
                this.f81803v.setVisibility(8);
                this.f81805w.setVisibility(8);
                this.f81772j.setText(getContext().getString(R.string.n_exchange_price_market_deal));
                this.f81787o.setVisibility(8);
                this.f81756d1.setVisibility(0);
                this.f81756d1.setText(R.string.n_contract_trade_rival_price);
                this.f81797t.setPriceInputType(1);
                this.f81797t.setHintText((int) R.string.n_contract_trade_input_price);
                k1();
                ViewUtil.m(this.f81774j1, true);
                ViewUtil.m(this.f81777k1, false);
                break;
        }
        t0();
        o1();
    }

    public void U0() {
        if (this.f81797t.getTradePriceType() == 1) {
            this.f81754d = false;
        } else {
            this.f81760f.i(false);
        }
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.f81747a1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.f81747a1.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.f81792q1));
            } else {
                this.f81747a1.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.f81792q1));
            }
        }
    }

    public boolean W0() {
        return this.f81751c == 0 && this.f81804v0.isChecked();
    }

    public void X0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.A.setVisibility(8);
            return;
        }
        this.B.setText(AppUtil.b(String.format(this.O0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.A.setVisibility(0);
    }

    public void Y0(int i11) {
        if (!tg.r.x().F0()) {
            this.N.setVisibility(8);
            this.I.setVisibility(8);
            this.J.setText(R.string.n_contract_trade_log_in_to_exchange);
            this.L.setVisibility(8);
            o1();
            return;
        }
        SwapUserInfo.UserBean h11 = z.f().h();
        if (h11 == null || h11.getActiveState() == 1) {
            this.N.setVisibility(0);
            this.I.setVisibility(0);
            if (ContractCalmPeriodHelper.d()) {
                this.K.setText(R.string.n_contract_calm_period_name);
                this.J.setText(R.string.n_contract_calm_period_name);
                this.L.setVisibility(8);
                this.M.setVisibility(8);
            } else if (i11 == 0) {
                this.J.setText(R.string.contract_trade_buy_open_more);
                this.L.setText(R.string.contract_trade_rise);
                this.K.setText(R.string.contract_trade_sell_open_low);
                this.M.setText(R.string.contract_trade_down);
                this.L.setVisibility(0);
                this.M.setVisibility(0);
            } else if (i11 == 1) {
                this.K.setText(R.string.contract_trade_sell_flat_more);
                this.J.setText(R.string.contract_trade_buy_flat_empty);
                this.L.setVisibility(8);
                this.M.setVisibility(8);
            }
            o1();
            return;
        }
        this.N.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setText(R.string.n_contract_swap_open_title);
        this.L.setVisibility(8);
        o1();
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
            this.f81756d1.setEnabled(true);
            this.f81811z.setEnabled(true);
            setLightingSelect(false);
            this.f81804v0.setChecked(gl.b.a(TradeType.SWAP));
        } else {
            this.f81756d1.setSelected(false);
            this.f81756d1.setEnabled(false);
            this.f81811z.setEnabled(false);
            setLightingSelect(false);
            this.G0 = null;
            this.H0 = null;
            r1();
            q1();
            this.f81785n0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
            this.f81804v0.setChecked(false);
        }
        C2();
    }

    public String getBondZeroDefault() {
        String t11 = this.f81760f.t();
        return BigDecimal.ZERO.setScale(FuturePrecisionUtil.g(this.f81760f.t()), 4).toPlainString() + t11;
    }

    public String getCallBackRateText() {
        return this.f81809y.getText().toString();
    }

    public String getInputAmountText() {
        return this.D.getText().toString();
    }

    public EditText getInputPriceEt() {
        return this.f81800u;
    }

    public String getInputPriceText() {
        return this.f81800u.getText().toString();
    }

    public MagicIndicator getMagicIndicator() {
        return (MagicIndicator) findViewById(R.id.buy_shell_indicator);
    }

    public k4 getOnEditTextFocusChangeListener() {
        return this.f81759e1;
    }

    public String getOrderPlaceInputAmount() {
        String obj = this.D.getText().toString();
        if (getTradeAmountType() != 0 || getPositionType() != 0) {
            return obj;
        }
        TradeType tradeType = TradeType.SWAP;
        return (!a7.e.E(tradeType) || !a7.e.H(tradeType)) ? obj : i6.m.a(obj).multiply(i6.m.a(this.f81760f.p())).toPlainString();
    }

    public int getOrderType() {
        return this.f81757e;
    }

    public int getPositionType() {
        return this.f81751c;
    }

    public int getSeekBarProgress() {
        return this.f81746a0.getProgress();
    }

    public FutureTpSlSettingParams getSlCache() {
        return this.H0;
    }

    public FutureTpSlSettingParams getTpCache() {
        return this.G0;
    }

    public FutureTpSlSettingDialogFragment.OpenType getTpSlDialogOpenType() {
        return this.I0;
    }

    public boolean getTpSlSwitchCheck() {
        return this.f81804v0.isChecked();
    }

    public int getTradeAmountType() {
        return this.W;
    }

    public int getTradePosition() {
        return this.f81748b;
    }

    public int getTradePriceType() {
        return this.f81797t.getTradePriceType();
    }

    public String getTriggerPriceText() {
        return this.f81791q.getText().toString();
    }

    public String getVolume() {
        String orderPlaceInputAmount = getOrderPlaceInputAmount();
        if (this.W != 5) {
            return orderPlaceInputAmount;
        }
        SwapAccountInfo swapAccountInfo = this.f81763g;
        if (swapAccountInfo != null) {
            return i6.m.a(swapAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.f81766h)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
        }
        return null;
    }

    public final void j1(int i11) {
        this.f81766h = i11;
        this.f81765g1.hideKeyboard();
        t0();
        this.W = 5;
        this.f81760f.N(this.f81751c, i11);
        if (this.f81751c == 0) {
            this.f81761f0 = null;
        } else {
            this.f81764g0 = null;
        }
        s2();
    }

    public final void k1() {
        int i11 = this.f81748b;
        if (i11 == 0) {
            if (this.f81751c == 0) {
                L0();
            } else {
                U0();
            }
        } else if (i11 == 1) {
            if (this.f81751c == 0) {
                U0();
            } else {
                L0();
            }
        }
        w0(true, false);
    }

    public String l1(boolean z11) {
        if (!tg.r.x().F0() || this.f81760f == null) {
            return "--";
        }
        try {
            FutureEarnestMoneyUtils f11 = FutureEarnestMoneyUtils.f();
            boolean z12 = true;
            f11.i(this.O0).t(getVolume()).q(this.f81756d1).h(a7.e.E(this.f81760f.q())).r(this.f81760f.q()).l(this.f81760f.p()).u(this.f81760f.t()).k(this.f81760f.m().getContractFace()).o(FuturePrecisionUtil.g(this.f81760f.t())).g(BigDecimal.valueOf(this.f81760f.n().v()).toPlainString()).j(getInputPriceText()).m(BigDecimal.valueOf(this.f81760f.n().z()).toPlainString()).p(BigDecimal.valueOf(this.f81760f.n().A()).toPlainString()).n(this.f81757e == 6);
            if (this.W != 5) {
                z12 = false;
            }
            return f11.a(z11, z12);
        } catch (FutureEarnestMoneyUtils.ZeroErr e11) {
            e11.printStackTrace();
            return getBondZeroDefault();
        }
    }

    public final void m1() {
        setLightingSelect(false);
    }

    public void n0() {
    }

    public final void n1(int i11) {
        this.f81748b = i11;
        Y0(this.f81751c);
        M0(this.f81748b);
    }

    public void notifyDataSetChanged() {
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.i();
        }
    }

    public final void o1() {
        getViewTreeObserver().addOnPreDrawListener(new h());
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            p1();
        }
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.f81768h1;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            DialogUtils.b.d Q02 = new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getContext().getString(R.string.n_known)).Q0(c2.f60338a);
            if (!TextUtils.isEmpty(str)) {
                Q02.s0(getContext().getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new b2(this, str));
            }
            HBDialogFragment k02 = Q02.k0();
            this.f81768h1 = k02;
            k02.show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public final void p1() {
        if (this.f81751c == 0) {
            if (this.K0) {
                this.f81800u.setText("");
            }
            this.M0 = true;
            return;
        }
        if (this.L0) {
            this.f81800u.setText("");
        }
        this.N0 = true;
    }

    public void q0() {
        HBDialogFragment hBDialogFragment = this.f81768h1;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public final void q1() {
        this.C0.setText("");
    }

    public void r0() {
        CommonListPopupDialog commonListPopupDialog = this.V0;
        if (commonListPopupDialog != null) {
            commonListPopupDialog.dismiss();
        }
        CommonListPopupDialog commonListPopupDialog2 = this.W0;
        if (commonListPopupDialog2 != null) {
            commonListPopupDialog2.dismiss();
        }
    }

    public final void r1() {
        this.B0.setText("");
    }

    public final FutureTpSlSettingParams r2(FutureTpSlSettingParams futureTpSlSettingParams, boolean z11) {
        if (futureTpSlSettingParams != null) {
            this.I0 = futureTpSlSettingParams.getOpenType();
            if (futureTpSlSettingParams.getTriggerPrice() == null) {
                return futureTpSlSettingParams;
            }
            if (z11) {
                setTpText(futureTpSlSettingParams.getTriggerPrice().toPlainString());
                return futureTpSlSettingParams;
            }
            setSlText(futureTpSlSettingParams.getTriggerPrice().toPlainString());
            return futureTpSlSettingParams;
        }
        if (z11) {
            r1();
        } else {
            q1();
        }
        return null;
    }

    public void s0() {
        for (MenuItem next : this.Z0) {
            if (next.getType() == 0) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f81760f.n().S(0);
        if (com.hbg.lib.core.util.w.l()) {
            this.S.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.S.setImageResource(R.drawable.trade_trend_default_red_green);
        }
        this.V.c(0);
        this.f81760f.n().Y(false);
    }

    public final ContractOrderPlace s1(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0(getInputPriceText());
        contractOrderPlace.d0(getOrderPlaceInputAmount());
        contractOrderPlace.h0(z11);
        contractOrderPlace.A0(this.f81751c);
        if (this.f81757e == 6) {
            contractOrderPlace.X0(8);
        } else {
            contractOrderPlace.X0(this.f81797t.getTradePriceType());
        }
        contractOrderPlace.g0(getTradeAmountType());
        contractOrderPlace.y0(this.f81757e);
        contractOrderPlace.Z0(getTriggerPriceText());
        contractOrderPlace.Y0(this.f81791q.getHint().toString());
        contractOrderPlace.e0(this.O0.getString(R.string.n_exchange_order_list_amount));
        contractOrderPlace.C0(this.f81800u.getHint().toString());
        contractOrderPlace.E0(getSeekBarProgress());
        contractOrderPlace.j0(this.f81809y.getHint().toString());
        contractOrderPlace.U0(this.f81807x.getCurrentPriceTypeText());
        contractOrderPlace.k0(getCallBackRateText());
        contractOrderPlace.V0(this.f81807x.getTradePriceType());
        if (z11) {
            contractOrderPlace.W0(this.J.getText().toString());
        } else {
            contractOrderPlace.W0(this.K.getText().toString());
        }
        contractOrderPlace.x0(this.f81797t.getCurrentPriceTypeText());
        if (this.f81760f.m() != null) {
            contractOrderPlace.n0(this.f81760f.m().getContractType());
        }
        if (W0() && ContractTpslLayout.supportTpslOrder(this.f81757e)) {
            FutureTpSlSettingParams futureTpSlSettingParams = this.G0;
            if (futureTpSlSettingParams != null) {
                u1(contractOrderPlace, futureTpSlSettingParams);
            }
            FutureTpSlSettingParams futureTpSlSettingParams2 = this.H0;
            if (futureTpSlSettingParams2 != null) {
                t1(contractOrderPlace, futureTpSlSettingParams2);
            }
            if (!this.f81785n0.paramsIsAdvanced(this.G0, this.H0) && !(this.G0 == null && this.H0 == null)) {
                this.I0 = z11 ? FutureTpSlSettingDialogFragment.OpenType.OpenLong : FutureTpSlSettingDialogFragment.OpenType.OpenShort;
            }
        }
        return contractOrderPlace;
    }

    public final void s2() {
        this.f81776k0.setText(l1(true));
        this.f81779l0.setText(l1(false));
    }

    public void setAmountEtText(String str) {
        this.D.setText(str);
    }

    public void setContractTradeViewController(n1 n1Var) {
        this.f81760f = n1Var;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f81786n1 = fragmentManager;
    }

    public void setHasTrade(boolean z11) {
        this.f81753c1 = z11;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f81754d = z11;
    }

    public void setLeverList(List<String> list) {
        if (list != null) {
            this.R0 = list;
        }
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f81759e1 = k4Var;
    }

    public void setPositionType(int i11) {
        this.f81751c = i11;
    }

    public void setPriceAnimator(String str) {
        this.f81800u.setText(str);
        EditText editText = this.f81800u;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.f81800u);
    }

    public void setPriceInputType(int i11) {
        this.f81797t.setPriceInputType(i11);
    }

    public void setPriceText(String str) {
        this.f81797t.setPriceInputType(1);
        this.f81756d1.setSelected(false);
        setLightingSelect(false);
        if (this.f81751c == 0) {
            this.K0 = false;
            this.f81755d0 = str;
        } else {
            this.f81758e0 = str;
            this.L0 = false;
        }
        int i11 = this.f81757e;
        if (i11 != 5 && i11 != 6) {
            setPriceAnimator(str);
        }
    }

    public void setProgress(int i11) {
        this.f81746a0.setProgress((float) i11);
    }

    public void setTradePosition(int i11) {
        this.f81748b = i11;
    }

    public void setTriggerPriceTypeView(int i11) {
        this.f81789p.setDividerVisibility(8);
        this.f81789p.setLabelVisibility(8);
    }

    public void setViewVisibility(int i11) {
        setVisibility(i11);
    }

    public void t0() {
        this.f81800u.clearFocus();
        this.D.clearFocus();
        this.f81791q.clearFocus();
    }

    public final void t1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
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

    public final void t2(View view, boolean z11) {
        if (z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    public void u0(boolean z11, boolean z12) {
        this.G0 = null;
        this.H0 = null;
        r1();
        q1();
        this.f81785n0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        this.F0.setVisibility(8);
        if (z12) {
            this.f81804v0.setChecked(false);
        }
    }

    public final void u1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
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

    public final void u2() {
        if (!a7.e.E(TradeType.SWAP)) {
            this.O.setText(String.format(this.O0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.O0.getString(R.string.n_contract_vol_sheet)}));
        } else if (TextUtils.isEmpty(this.f81760f.t())) {
            this.O.setText(R.string.n_contract_trade_input_amount);
        } else {
            this.O.setText(String.format(this.O0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f81760f.t()}));
        }
    }

    public void v0() {
        this.f81778l.setText("--");
        this.f81778l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f81781m.setImageResource(0);
    }

    public final FutureTpSlSettingParams v1(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        FutureTpSlSettingDialogFragment.OpenType openType;
        if (futureTpSlSettingParams != null) {
            return new FutureTpSlSettingParams(futureTpSlSettingParams);
        }
        double d11 = 0.0d;
        if (futureTpSlSettingParams2 == null) {
            openType = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
        } else {
            openType = futureTpSlSettingParams2.getOpenType();
            d11 = futureTpSlSettingParams2.getTpslVolumeRate();
        }
        FutureTpSlSettingParams futureTpSlSettingParams3 = new FutureTpSlSettingParams(openType, PriceType.MARKET);
        futureTpSlSettingParams3.setTpslVolumeRate(d11);
        return futureTpSlSettingParams3;
    }

    public final void v2(String str, String str2) {
        String string = getResources().getString(R.string.contract_trade_unit_sheet);
        if (this.f81751c == 0) {
            this.f81770i0.setVisibility(0);
            this.f81773j0.setVisibility(0);
        } else {
            this.f81770i0.setVisibility(8);
            this.f81773j0.setVisibility(8);
        }
        this.f81749b0.setText(str);
        TextView textView = this.f81767h0;
        if (!TextUtils.equals("--", str2)) {
            str2 = AppUtil.b(str2, string);
        }
        textView.setText(str2);
        this.f81776k0.setText(l1(true));
        this.f81779l0.setText(l1(false));
        s2();
    }

    public void w0(boolean z11, boolean z12) {
        if (this.f81797t.getTradePriceType() == 1) {
            if (this.f81751c == 0 && !TextUtils.isEmpty(this.f81755d0)) {
                this.f81800u.setText(this.f81755d0);
            } else if (this.f81751c != 1 || TextUtils.isEmpty(this.f81758e0)) {
                this.f81800u.setText("");
            } else {
                this.f81800u.setText(this.f81758e0);
            }
        }
        if (z11) {
            this.f81791q.setText("");
            this.f81809y.setText("");
        }
        if (z12 && this.f81757e != 5) {
            this.f81797t.setPriceInputType(1);
            this.f81756d1.setSelected(false);
            setLightingSelect(false);
        }
        if (this.f81751c == 0 && !TextUtils.isEmpty(this.f81761f0)) {
            this.D.setText(this.f81761f0);
        } else if (this.f81751c != 1 || TextUtils.isEmpty(this.f81764g0)) {
            this.D.setText("");
        } else {
            this.D.setText(this.f81764g0);
        }
        setProgress(0);
        this.T.setVisibility(8);
        this.f81765g1.hideKeyboard();
    }

    public void w1(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        if (ContractTpslLayout.isLimitlOrder(this.f81757e) && !this.f81797t.k()) {
            futureTpSlDialogShowBean.setEntrustPrice(i6.m.a(getInputPriceText()));
        }
        if (a7.e.E(TradeType.SWAP)) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f81760f.s()).longValue()));
        } else if (this.W == 5) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f81760f.s()).longValue()));
        } else {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(getInputAmountText()).longValue()));
        }
        futureTpSlDialogShowBean.setLever(this.f81760f.p());
        futureTpSlDialogShowBean.setSymbol(this.f81760f.t());
        if (this.f81760f.m() != null) {
            futureTpSlDialogShowBean.setContractType(this.f81760f.m().getContractType());
            futureTpSlDialogShowBean.setContractCode(this.f81760f.m().getContractCode());
            futureTpSlDialogShowBean.setContractShortType(this.f81760f.m().getContractShortType());
            futureTpSlDialogShowBean.setPricePrecision(us.i.m(this.f81760f.m().getSymbol()));
            futureTpSlDialogShowBean.setPredictProfitPrecision(us.i.t(this.f81760f.m().getSymbol()));
            futureTpSlDialogShowBean.setContractFace(i6.m.a(this.f81760f.m().getContractFace()));
        }
        futureTpSlDialogShowBean.setStopProfitSetting(v1(this.G0, this.H0));
        futureTpSlDialogShowBean.setStopLossSetting(v1(this.H0, this.G0));
    }

    public final void w2(String str, String str2, String str3) {
        if (this.f81751c == 0) {
            this.f81770i0.setVisibility(0);
            this.f81773j0.setVisibility(0);
        } else {
            this.f81770i0.setVisibility(8);
            this.f81773j0.setVisibility(8);
        }
        this.f81749b0.setText(str);
        TextView textView = this.f81767h0;
        if (!TextUtils.equals("--", str2)) {
            str2 = AppUtil.b(str2, str3);
        }
        textView.setText(str2);
        TextView textView2 = this.f81776k0;
        textView2.setText(l1(true) + this.O0.getString(R.string.transfer_unit_btc));
        TextView textView3 = this.f81779l0;
        textView3.setText(l1(false) + this.O0.getString(R.string.transfer_unit_btc));
        s2();
    }

    public void x0(String str) {
        this.f81778l.setText(String.format(this.O0.getString(R.string.contract_lever), new Object[]{str}));
        LeverSelectDialogFragment leverSelectDialogFragment = this.Q0;
        if (leverSelectDialogFragment == null || !leverSelectDialogFragment.isResumed()) {
            this.f81781m.setImageResource(R.drawable.trade_arrow_down);
        } else {
            this.f81781m.setImageResource(R.drawable.trade_arrow_up);
        }
        if (i6.m.a(str).compareTo(BigDecimal.TEN) >= 0) {
            this.f81778l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        } else {
            this.f81778l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        }
    }

    public final void x1() {
        if (this.f81797t.k()) {
            B1();
            this.V0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f81797t, true, 0, 0, 80);
        }
    }

    public void x2(String str) {
        if (this.W != 0) {
            this.T.setVisibility(8);
        } else if (i6.m.a(str).compareTo(BigDecimal.ZERO) > 0) {
            if (a7.e.E(TradeType.SWAP)) {
                this.U.setText(String.format(this.O0.getString(R.string.two_label_with_space_with_abount), new Object[]{str, this.O0.getString(R.string.n_contract_vol_sheet)}));
            } else {
                this.U.setText(String.format(this.O0.getString(R.string.two_label_with_space_with_abount), new Object[]{str, this.f81760f.t().toUpperCase(Locale.US)}));
            }
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
        s2();
    }

    public final void y1(Context context, AttributeSet attributeSet) {
        this.O0 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.contract_trade_together_layout, this, true);
        this.V = (TradeTrendView) inflate.findViewById(R.id.contract_trade_trend_view);
        o1();
        this.f81772j = (TextView) inflate.findViewById(R.id.order_type_tv);
        this.f81771i1 = inflate.findViewById(R.id.iv_contract_guide);
        this.f81769i = inflate.findViewById(R.id.order_type_ll);
        this.f81775k = (ImageView) inflate.findViewById(R.id.order_type_arrow_iv);
        this.f81778l = (TextView) inflate.findViewById(R.id.contract_trade_lever_value_tv);
        this.f81781m = (ImageView) inflate.findViewById(R.id.contract_trade_lever_arrow_iv);
        this.f81784n = (RelativeLayout) inflate.findViewById(R.id.contract_trade_lever_ll);
        this.f81749b0 = (TextView) inflate.findViewById(R.id.long_value_tv);
        this.f81767h0 = (TextView) inflate.findViewById(R.id.long_value_tv1);
        this.f81782m0 = (TextView) inflate.findViewById(R.id.short_value_tv1);
        this.f81770i0 = inflate.findViewById(R.id.ll_bond);
        this.f81773j0 = inflate.findViewById(R.id.ll_bond2);
        this.f81776k0 = (TextView) inflate.findViewById(R.id.tv_bond);
        this.f81779l0 = (TextView) inflate.findViewById(R.id.tv_bond2);
        this.f81780l1 = (LinearLayout) inflate.findViewById(R.id.llLimitChoose);
        this.f81783m1 = (TextView) inflate.findViewById(R.id.tvLimitTitle);
        this.f81780l1.setOnClickListener(new r2(this));
        this.f81787o = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_view_container);
        ContractTradePriceEditext contractTradePriceEditext = (ContractTradePriceEditext) inflate.findViewById(R.id.contract_trigger_price_view);
        this.f81789p = contractTradePriceEditext;
        TradeType tradeType = TradeType.SWAP;
        contractTradePriceEditext.setTradeType(tradeType);
        this.f81791q = this.f81789p.getEditText();
        this.f81793r = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_convert_container);
        this.f81795s = (TextView) inflate.findViewById(R.id.contract_trigger_price_convert_tv);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.contract_trade_price_view);
        this.f81797t = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setTradeType(tradeType);
        this.f81797t.setClearEnable(true);
        this.f81800u = this.f81797t.getEditText();
        this.f81803v = inflate.findViewById(R.id.track_price_rl);
        this.f81805w = inflate.findViewById(R.id.call_back_rate_ll);
        this.f81807x = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.track_price_view);
        this.f81809y = (EditText) inflate.findViewById(R.id.call_back_rate_et);
        this.f81811z = (ImageButton) inflate.findViewById(R.id.lighting_trade_ib);
        this.A = (ViewGroup) inflate.findViewById(R.id.contract_price_convert_container);
        this.B = (TextView) inflate.findViewById(R.id.contract_price_convert_tv);
        ContractTradeAmountView contractTradeAmountView = (ContractTradeAmountView) inflate.findViewById(R.id.contract_trade_amount_view);
        this.C = contractTradeAmountView;
        this.D = contractTradeAmountView.getEditText();
        this.E = (TextView) inflate.findViewById(R.id.trade_mask_title_tv);
        this.f81750b1 = (ViewGroup) inflate.findViewById(R.id.safeguard_trade_ll);
        SwapMaintenanceView swapMaintenanceView = new SwapMaintenanceView(this.O0);
        this.f81762f1 = swapMaintenanceView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) swapMaintenanceView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f81762f1.setLayoutParams(layoutParams);
        this.f81750b1.addView(this.f81762f1);
        this.f81762f1.setTopMargin(84);
        this.f81762f1.h();
        this.f81762f1.setTradeSafeguardHint(getContext().getString(R.string.n_contract_service_in_maintain_market));
        this.F = (TextView) inflate.findViewById(R.id.trade_suspend_instruction_tv);
        this.G = (LinearLayout) inflate.findViewById(R.id.stop_trade_ll);
        this.O = (TextView) inflate.findViewById(R.id.contract_vertical_amount_label_tv);
        this.T = (ViewGroup) inflate.findViewById(R.id.contract_input_volume_value_container);
        this.U = (TextView) inflate.findViewById(R.id.input_volume_value_tv);
        this.H = (RelativeLayout) inflate.findViewById(R.id.trade_long_ll);
        this.I = (RelativeLayout) inflate.findViewById(R.id.trade_short_ll);
        this.J = (TextView) inflate.findViewById(R.id.trade_long_confirm_btn);
        this.K = (TextView) inflate.findViewById(R.id.trade_short_confirm_btn);
        this.L = (TextView) inflate.findViewById(R.id.trade_long_instruction_tv);
        this.M = (TextView) inflate.findViewById(R.id.trade_short_instruction_tv);
        this.N = (LinearLayout) inflate.findViewById(R.id.llshort_value);
        this.f81749b0 = (TextView) inflate.findViewById(R.id.long_value_tv);
        this.f81752c0 = (TextView) inflate.findViewById(R.id.short_value_tv);
        this.f81746a0 = (MultiColorSeekBar) inflate.findViewById(R.id.contract_seekbar_new);
        this.f81774j1 = inflate.findViewById(R.id.contract_market_rl);
        this.f81777k1 = inflate.findViewById(R.id.trade_price_ll_container);
        this.f81756d1 = (TextView) inflate.findViewById(R.id.contract_trade_rival_price_tv);
        ContractTpslLayout contractTpslLayout = (ContractTpslLayout) inflate.findViewById(R.id.contract_tp_sl_include);
        this.f81785n0 = contractTpslLayout;
        contractTpslLayout.setTradeType(TradeType.CONTRACT);
        this.f81798t0 = inflate.findViewById(R.id.contract_tp_sl_switch_container);
        this.f81801u0 = inflate.findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_sl_tv);
        this.f81806w0 = bottomLineTextView;
        bottomLineTextView.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.f81806w0.setTextColor(R.color.baseColorSecondaryText);
        this.f81804v0 = (CheckBox) inflate.findViewById(R.id.contract_tp_sl_switch_iv);
        this.f81808x0 = inflate.findViewById(R.id.contract_tp_sl_input_container);
        this.f81810y0 = inflate.findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) inflate.findViewById(R.id.contract_tp_input_container);
        this.f81812z0 = contractTpslEditText;
        this.B0 = contractTpslEditText.getEditText();
        this.D0 = this.f81812z0.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) inflate.findViewById(R.id.contract_sl_input_container);
        this.A0 = contractTpslEditText2;
        this.C0 = contractTpslEditText2.getEditText();
        this.E0 = this.A0.getClearImageView();
        k kVar = new k();
        this.f81812z0.setCallback(kVar);
        this.A0.setCallback(kVar);
        this.F0 = (TextView) inflate.findViewById(R.id.tp_sl_tag_tv);
        HuobiKeyboardHelper registerInput = new HuobiKeyboardHelper().attach((Activity) this.O0).registerInput(this.f81791q, this.f81800u, this.f81809y, this.B0, this.C0);
        this.f81765g1 = registerInput;
        registerInput.registerInput(this.D, new v1(this));
        z1(inflate);
        E1(inflate);
        C1();
        A1();
        this.C.c(tradeType, new q());
    }

    public void y2() {
        LeverSelectDialogFragment leverSelectDialogFragment = new LeverSelectDialogFragment();
        this.Q0 = leverSelectDialogFragment;
        leverSelectDialogFragment.tc(this.R0);
        this.Q0.bc(this.f81760f.t());
        this.Q0.xi(us.j.f(this.f81760f.t(), this.O0));
        this.Q0.vi(this.f81802u1);
        this.Q0.ti(this.f81760f.p());
        this.Q0.setTradeType(TradeType.SWAP);
        this.Q0.zi(ContractWebActivity.Eh(2));
        this.Q0.si(this.f81760f.m().getContractCode());
        this.Q0.setDialogFragmentListener(new j());
        this.Q0.setDialogDismissListener(new y1(this));
        this.Q0.show(((FragmentActivity) this.O0).getSupportFragmentManager(), "leverSelectDialogFragment");
    }

    public void z0(boolean z11) {
        this.H.setEnabled(z11);
        this.I.setEnabled(z11);
    }

    public final void z1(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vertical_depth_tv);
        this.P = textView;
        textView.setText("--");
        this.Q = (ImageView) view.findViewById(R.id.vertical_depth_arrow_iv);
        this.R = view.findViewById(R.id.depth_ll);
    }

    public final void z2(String str, String str2) {
        if (this.f81751c == 0) {
            this.f81770i0.setVisibility(0);
            this.f81773j0.setVisibility(0);
        } else {
            this.f81770i0.setVisibility(8);
            this.f81773j0.setVisibility(8);
        }
        this.f81752c0.setText(str);
        TextView textView = this.f81782m0;
        textView.setText(str2 + getResources().getString(R.string.contract_trade_unit_sheet));
        s2();
    }

    public SwapTradeTogetherView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f81757e = 0;
        this.I0 = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
        this.K0 = true;
        this.L0 = true;
        this.M0 = true;
        this.N0 = true;
        this.T0 = new ArrayList();
        this.X0 = "coin_contract";
        this.Y0 = "contract_trade";
        this.Z0 = new ArrayList();
        this.f81747a1 = new ArrayList();
        this.f81753c1 = false;
        this.f81790p1 = new i();
        this.f81792q1 = new l();
        this.f81794r1 = new m();
        this.f81796s1 = new n();
        this.f81799t1 = new o();
        this.f81802u1 = new p();
        y1(context, attributeSet);
    }
}
