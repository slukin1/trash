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
import k6.b;
import k6.c;
import m9.z;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import qs.n1;
import rx.Observable;
import ts.a3;
import ts.a4;
import ts.b3;
import ts.c3;
import ts.d3;
import ts.e3;
import ts.f3;
import ts.g3;
import ts.h3;
import ts.i3;
import ts.j3;
import ts.k3;
import ts.l3;
import ts.m3;
import ts.n3;
import ts.o3;
import ts.p3;
import ts.q3;
import ts.r3;
import ts.s3;
import ts.t3;
import ts.u2;
import ts.u3;
import ts.v2;
import ts.v3;
import ts.w2;
import ts.w3;
import ts.x2;
import ts.x3;
import ts.y2;
import ts.y3;
import ts.z2;
import ts.z3;

public class SwapTradeView extends FrameLayout implements a4, m0<SwapAccountInfo> {
    public ContractTradeAmountView A;
    public final LeverSelectDialogFragment A0;
    public EditText B;
    public final CommonListPopupDialog B0;
    public View C;
    public final List<CommonPopListItem> C0;
    public View D;
    public final BottomMenuFragment D0;
    public ContractGearsTradePriceEditText E;
    public final CommonListPopupDialog E0;
    public EditText F;
    public final CommonListPopupDialog F0;
    public RelativeLayout G;
    public final List<MenuItem> G0;
    public TextView H;
    public final List<MenuItem> H0;
    public TextView I;
    public ViewGroup I0;
    public TextView J;
    public String J0;
    public TextView K;
    public String K0;
    public LinearLayout L;
    public String L0;
    public TextView M;
    public String M0;
    public TextView N;
    public boolean N0;
    public ImageView O;
    public boolean O0;
    public View P;
    public boolean P0;
    public ImageView Q;
    public boolean Q0;
    public TextView R;
    public TextView R0;
    public View S;
    public int S0;
    public TradeTrendView T;
    public MultiColorSeekBar T0;
    public ContractTpslLayout U;
    public k4 U0;
    public View V;
    public SwapMaintenanceView V0;
    public View W;
    public HuobiKeyboardHelper W0;
    public HBDialogFragment X0;
    public View Y0;
    public boolean Z0;

    /* renamed from: a0  reason: collision with root package name */
    public CheckBox f81837a0;

    /* renamed from: a1  reason: collision with root package name */
    public View f81838a1;

    /* renamed from: b  reason: collision with root package name */
    public String f81839b;

    /* renamed from: b0  reason: collision with root package name */
    public BottomLineTextView f81840b0;

    /* renamed from: b1  reason: collision with root package name */
    public View f81841b1;

    /* renamed from: c  reason: collision with root package name */
    public String f81842c;

    /* renamed from: c0  reason: collision with root package name */
    public View f81843c0;

    /* renamed from: c1  reason: collision with root package name */
    public LinearLayout f81844c1;

    /* renamed from: d  reason: collision with root package name */
    public int f81845d;

    /* renamed from: d0  reason: collision with root package name */
    public View f81846d0;

    /* renamed from: d1  reason: collision with root package name */
    public TextView f81847d1;

    /* renamed from: e  reason: collision with root package name */
    public int f81848e;

    /* renamed from: e0  reason: collision with root package name */
    public ContractTpslEditText f81849e0;

    /* renamed from: e1  reason: collision with root package name */
    public FragmentManager f81850e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f81851f;

    /* renamed from: f0  reason: collision with root package name */
    public ContractTpslEditText f81852f0;

    /* renamed from: f1  reason: collision with root package name */
    public CommonPopListItem f81853f1;

    /* renamed from: g  reason: collision with root package name */
    public int f81854g;

    /* renamed from: g0  reason: collision with root package name */
    public EditText f81855g0;

    /* renamed from: g1  reason: collision with root package name */
    public final MenuItemOnClickListener f81856g1;

    /* renamed from: h  reason: collision with root package name */
    public n1 f81857h;

    /* renamed from: h0  reason: collision with root package name */
    public EditText f81858h0;

    /* renamed from: h1  reason: collision with root package name */
    public final MenuItemOnClickListener f81859h1;

    /* renamed from: i  reason: collision with root package name */
    public SwapAccountInfo f81860i;

    /* renamed from: i0  reason: collision with root package name */
    public ImageView f81861i0;

    /* renamed from: i1  reason: collision with root package name */
    public final CommonPopListItem.a f81862i1;

    /* renamed from: j  reason: collision with root package name */
    public int f81863j;

    /* renamed from: j0  reason: collision with root package name */
    public ImageView f81864j0;

    /* renamed from: j1  reason: collision with root package name */
    public final CommonPopListItem.a f81865j1;

    /* renamed from: k  reason: collision with root package name */
    public View f81866k;

    /* renamed from: k0  reason: collision with root package name */
    public FutureTpSlSettingParams f81867k0;

    /* renamed from: k1  reason: collision with root package name */
    public final CommonPopListItem.a f81868k1;

    /* renamed from: l  reason: collision with root package name */
    public TextView f81869l;

    /* renamed from: l0  reason: collision with root package name */
    public FutureTpSlSettingParams f81870l0;

    /* renamed from: l1  reason: collision with root package name */
    public final LeverSelectDialogFragment.h f81871l1;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f81872m;

    /* renamed from: m0  reason: collision with root package name */
    public FutureTpSlSettingParams f81873m0;

    /* renamed from: n  reason: collision with root package name */
    public TextView f81874n;

    /* renamed from: n0  reason: collision with root package name */
    public FutureTpSlSettingParams f81875n0;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f81876o;

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f81877p;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup f81878q;

    /* renamed from: r  reason: collision with root package name */
    public ContractTradePriceEditext f81879r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f81880s;

    /* renamed from: t  reason: collision with root package name */
    public ViewGroup f81881t;

    /* renamed from: t0  reason: collision with root package name */
    public FutureTpSlSettingDialogFragment f81882t0;

    /* renamed from: u  reason: collision with root package name */
    public TextView f81883u;

    /* renamed from: u0  reason: collision with root package name */
    public final List<String> f81884u0;

    /* renamed from: v  reason: collision with root package name */
    public ContractGearsTradePriceEditText f81885v;

    /* renamed from: v0  reason: collision with root package name */
    public MagicIndicator f81886v0;

    /* renamed from: w  reason: collision with root package name */
    public EditText f81887w;

    /* renamed from: w0  reason: collision with root package name */
    public Context f81888w0;

    /* renamed from: x  reason: collision with root package name */
    public ImageButton f81889x;

    /* renamed from: x0  reason: collision with root package name */
    public View f81890x0;

    /* renamed from: y  reason: collision with root package name */
    public ViewGroup f81891y;

    /* renamed from: y0  reason: collision with root package name */
    public TextView f81892y0;

    /* renamed from: z  reason: collision with root package name */
    public TextView f81893z;

    /* renamed from: z0  reason: collision with root package name */
    public final BottomMenuFragment f81894z0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            int d11 = SwapTradeView.this.T.d();
            SwapTradeView.this.T.l(d11 / 2, d11);
            return true;
        }
    }

    public class b implements BaseDialogFragment.c {
        public b() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeView.this.f81872m.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeView.this.f81872m.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class c implements BaseDialogFragment.c {
        public c() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeView.this.f81885v.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeView.this.f81885v.p(R.drawable.trade_arrow_up);
        }
    }

    public class d implements BaseDialogFragment.c {
        public d() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            SwapTradeView.this.f81876o.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeView.this.f81876o.setImageResource(R.drawable.trade_arrow_up);
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
                SwapTradeView.this.q1(i11);
            }
        }
    }

    public class f implements ContractGearsTradePriceEditText.c {
        public f() {
        }

        public void a() {
            SwapTradeView.this.F0.showAsDropDown(((FragmentActivity) SwapTradeView.this.getContext()).getSupportFragmentManager(), (View) SwapTradeView.this.E, true, 0, 0, 80);
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
            SwapTradeView.this.E.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            SwapTradeView.this.E.p(R.drawable.trade_arrow_up);
        }
    }

    public class h implements TextWatcher {
        public h() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                SwapTradeView.this.F.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_regular));
            } else {
                SwapTradeView.this.F.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_medium));
            }
            if (i6.m.b(editable, 10, 1) != null) {
                SwapTradeView swapTradeView = SwapTradeView.this;
                swapTradeView.D2(swapTradeView.F, editable.toString());
            }
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
            SwapTradeView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int d11 = SwapTradeView.this.T.d();
            SwapTradeView.this.T.l(d11 / 2, d11);
            return true;
        }
    }

    public class j implements MenuItemOnClickListener {
        public j() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : SwapTradeView.this.G0) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            if (i11 == 0) {
                SwapTradeView.this.f81857h.n().S(0);
                if (com.hbg.lib.core.util.w.l()) {
                    SwapTradeView.this.Q.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    SwapTradeView.this.Q.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                if (SwapTradeView.this.T != null) {
                    SwapTradeView.this.T.c(0);
                }
            } else if (i11 == 1) {
                SwapTradeView.this.f81857h.n().S(1);
                if (com.hbg.lib.core.util.w.l()) {
                    SwapTradeView.this.Q.setImageResource(R.drawable.trade_trend_red);
                } else {
                    SwapTradeView.this.Q.setImageResource(R.drawable.trade_trend_green);
                }
                if (SwapTradeView.this.T != null) {
                    SwapTradeView.this.T.c(1);
                }
            } else {
                SwapTradeView.this.f81857h.n().S(2);
                if (com.hbg.lib.core.util.w.l()) {
                    SwapTradeView.this.Q.setImageResource(R.drawable.trade_trend_green);
                } else {
                    SwapTradeView.this.Q.setImageResource(R.drawable.trade_trend_red);
                }
                if (SwapTradeView.this.T != null) {
                    SwapTradeView.this.T.c(2);
                }
            }
            SwapTradeView.this.f81857h.n().Y(false);
            SwapTradeView.this.D0.dismiss();
        }
    }

    public class k implements ContractTpslEditText.c {
        public k() {
        }

        public void afterTextChanged(EditText editText, String str) {
            if (editText == SwapTradeView.this.f81855g0) {
                if (SwapTradeView.this.O1()) {
                    SwapTradeView swapTradeView = SwapTradeView.this;
                    FutureTpSlSettingParams unused = swapTradeView.f81867k0 = FutureTpSlSettingParams.changeTpSlCache(swapTradeView.f81867k0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
                    return;
                }
                SwapTradeView swapTradeView2 = SwapTradeView.this;
                FutureTpSlSettingParams unused2 = swapTradeView2.f81873m0 = FutureTpSlSettingParams.changeTpSlCache(swapTradeView2.f81873m0, FutureTpSlSettingDialogFragment.OpenType.OpenShort, str);
            } else if (editText != SwapTradeView.this.f81858h0) {
            } else {
                if (SwapTradeView.this.O1()) {
                    SwapTradeView swapTradeView3 = SwapTradeView.this;
                    FutureTpSlSettingParams unused3 = swapTradeView3.f81870l0 = FutureTpSlSettingParams.changeTpSlCache(swapTradeView3.f81870l0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
                    return;
                }
                SwapTradeView swapTradeView4 = SwapTradeView.this;
                FutureTpSlSettingParams unused4 = swapTradeView4.f81875n0 = FutureTpSlSettingParams.changeTpSlCache(swapTradeView4.f81875n0, FutureTpSlSettingDialogFragment.OpenType.OpenShort, str);
            }
        }

        public int getTradePricePrecision() {
            if (SwapTradeView.this.f81857h != null) {
                return us.i.m(SwapTradeView.this.f81857h.t());
            }
            return 14;
        }
    }

    public class l implements MenuItemOnClickListener {
        public l() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (SwapTradeView.this.f81857h.n() != null) {
                SwapTradeView.this.f81857h.n().t(i11);
            }
            SwapTradeView.this.f81894z0.dismiss();
        }
    }

    public class m implements CommonPopListItem.a {
        public m() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            SwapTradeView.this.B0.dismiss();
            int type = commonPopListItem.getType();
            if (type == SwapTradeView.this.f81854g) {
                return;
            }
            if (type != 0 || (SwapTradeView.this.f81854g != 3 && SwapTradeView.this.f81854g != 4)) {
                SwapTradeView.this.T0(type);
                HashMap hashMap = new HashMap();
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                if (type == 0) {
                    if (!SwapTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "limit_order");
                } else if (type == 1) {
                    ContractGuideHelper.b(fragmentActivity, 4);
                    hashMap.put("type", "trigger");
                } else if (type == 2) {
                    if (!SwapTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "post_only");
                } else if (type == 3) {
                    if (!SwapTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "ioc");
                } else if (type == 4) {
                    if (!SwapTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "fok");
                }
                is.a.j("5146", hashMap, is.a.f(TradeType.SWAP));
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == SwapTradeView.this.f81854g || (commonPopListItem.getType() == 0 && (SwapTradeView.this.f81854g == 3 || SwapTradeView.this.f81854g == 4));
        }
    }

    public class n implements CommonPopListItem.a {
        public n() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            String str;
            SwapTradeView.this.f81885v.setPriceInputType(commonPopListItem.getType());
            SwapTradeView.this.f81885v.setCurrentPriceTypeText(commonPopListItem.getText());
            SwapTradeView.this.E0.dismiss();
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
            is.a.j("5147", hashMap, is.a.f(TradeType.SWAP));
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return SwapTradeView.this.f81885v.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class o implements CommonPopListItem.a {
        public o() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            SwapTradeView.this.E.setPriceInputType(commonPopListItem.getType());
            SwapTradeView.this.E.setCurrentPriceTypeText(commonPopListItem.getText());
            SwapTradeView.this.F0.dismiss();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return SwapTradeView.this.E.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class p implements LeverSelectDialogFragment.h {
        public p() {
        }

        public void N0() {
            if (SwapTradeView.this.f81857h != null) {
                SwapTradeView.this.f81857h.w().N0();
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return uc.b.d(tradeType, str, i11);
        }

        public void P0(String str) {
            SwapTradeView.this.x0(str);
            SwapTradeView.this.f81857h.F(str);
            SwapTradeView.this.f81857h.C();
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return SwapTradeView.this.f81857h.k(str, levelAvailableMarginInfo);
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            is.a.j("5148", hashMap, is.a.f(TradeType.SWAP));
            return false;
        }
    }

    public class q implements ContractTradeAmountView.a {
        public q() {
        }

        public String o0() {
            return SwapTradeView.this.f81857h.t();
        }
    }

    public class r extends CommonNavigatorAdapter {
        public r() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (SwapTradeView.this.f81845d == i11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            SwapTradeView.this.w0(true, true);
            SwapTradeView.this.w1();
            SwapTradeView.this.t0();
            SwapTradeView.this.u1(i11);
            if (i11 == 0) {
                if (SwapTradeView.this.f81848e == 0) {
                    SwapTradeView.this.L0();
                    if (SwapTradeView.this.f81867k0 == null || SwapTradeView.this.f81867k0.getTriggerPrice() == null) {
                        SwapTradeView.this.y1();
                    } else {
                        SwapTradeView swapTradeView = SwapTradeView.this;
                        swapTradeView.setTpText(swapTradeView.f81867k0.getTriggerPrice().toPlainString());
                    }
                    if (SwapTradeView.this.f81870l0 == null || SwapTradeView.this.f81870l0.getTriggerPrice() == null) {
                        SwapTradeView.this.x1();
                    } else {
                        SwapTradeView swapTradeView2 = SwapTradeView.this;
                        swapTradeView2.setSlText(swapTradeView2.f81870l0.getTriggerPrice().toPlainString());
                    }
                } else {
                    SwapTradeView.this.U0();
                }
                SwapTradeView.this.U.refreshTpSlView(SwapTradeView.this.f81867k0, SwapTradeView.this.f81870l0);
            } else if (i11 == 1) {
                if (SwapTradeView.this.f81848e == 0) {
                    SwapTradeView.this.U0();
                    if (SwapTradeView.this.f81873m0 == null || SwapTradeView.this.f81873m0.getTriggerPrice() == null) {
                        SwapTradeView.this.y1();
                    } else {
                        SwapTradeView swapTradeView3 = SwapTradeView.this;
                        swapTradeView3.setTpText(swapTradeView3.f81873m0.getTriggerPrice().toPlainString());
                    }
                    if (SwapTradeView.this.f81875n0 == null || SwapTradeView.this.f81875n0.getTriggerPrice() == null) {
                        SwapTradeView.this.x1();
                    } else {
                        SwapTradeView swapTradeView4 = SwapTradeView.this;
                        swapTradeView4.setSlText(swapTradeView4.f81875n0.getTriggerPrice().toPlainString());
                    }
                } else {
                    SwapTradeView.this.L0();
                }
                SwapTradeView.this.U.refreshTpSlView(SwapTradeView.this.f81873m0, SwapTradeView.this.f81875n0);
            }
            SwapTradeView.this.f81857h.i(false);
            SwapTradeView.this.f81886v0.c(i11);
            SwapTradeView.this.f81886v0.b(i11, 0.0f, 0);
            if (SwapTradeView.this.S0 == 5) {
                SwapTradeView.this.B.setText("");
                String unused = SwapTradeView.this.M0 = null;
                String unused2 = SwapTradeView.this.L0 = null;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return SwapTradeView.this.f81884u0.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            SwapTradeView.this.G1();
            if (i11 == 0) {
                tradeBuySellView.setNormalColor(ContextCompat.getColor(SwapTradeView.this.f81888w0, R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(SwapTradeView.this.f81888w0, R.color.baseTextColor));
                if (SwapTradeView.this.f81848e == 0) {
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
                tradeBuySellView.setNormalColor(ContextCompat.getColor(SwapTradeView.this.f81888w0, R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(SwapTradeView.this.f81888w0, R.color.baseTextColor));
                if (SwapTradeView.this.f81848e == 0) {
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
            tradeBuySellView.setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            tradeBuySellView.setText((CharSequence) SwapTradeView.this.f81884u0.get(i11));
            tradeBuySellView.setOnClickListener(new z3(this, i11));
            return tradeBuySellView;
        }
    }

    public class s extends BaseSubscriber<SwapUserInfo.UserBean> {
        public s() {
        }

        /* renamed from: a */
        public void onNext(SwapUserInfo.UserBean userBean) {
            super.onNext(userBean);
            SwapTradeView swapTradeView = SwapTradeView.this;
            swapTradeView.u1(swapTradeView.f81845d);
        }
    }

    public class t implements TextWatcher {
        public t() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                SwapTradeView.this.f81880s.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_regular));
            } else {
                SwapTradeView.this.f81880s.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_medium));
            }
            SwapTradeView swapTradeView = SwapTradeView.this;
            swapTradeView.E2(swapTradeView.f81857h.o(editable.toString()));
            if (i6.m.b(editable, 10, us.i.m(SwapTradeView.this.f81857h.t())) != null) {
                SwapTradeView swapTradeView2 = SwapTradeView.this;
                swapTradeView2.D2(swapTradeView2.f81880s, editable.toString());
            }
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
            SwapTradeView.this.E1();
        }

        public void b() {
            SwapTradeView.this.E1();
        }
    }

    public class v implements TextWatcher {
        public v() {
        }

        public void afterTextChanged(Editable editable) {
            int tradePriceType = SwapTradeView.this.getTradePriceType();
            if (editable.length() == 0) {
                SwapTradeView.this.f81887w.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_regular));
                SwapTradeView.this.x2("0");
            } else {
                SwapTradeView.this.f81887w.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_medium));
            }
            SwapTradeView swapTradeView = SwapTradeView.this;
            swapTradeView.X0(swapTradeView.f81857h.o(editable.toString()));
            String str = null;
            if (tradePriceType == 1) {
                str = i6.m.b(editable, 10, us.i.m(SwapTradeView.this.f81857h.t()));
            }
            if (str != null) {
                SwapTradeView swapTradeView2 = SwapTradeView.this;
                swapTradeView2.D2(swapTradeView2.f81887w, editable.toString());
                return;
            }
            if (SwapTradeView.this.f81848e == 0) {
                if (SwapTradeView.this.f81887w.hasFocus()) {
                    boolean unused = SwapTradeView.this.N0 = false;
                }
                if (SwapTradeView.this.f81854g != 5) {
                    String unused2 = SwapTradeView.this.J0 = editable.toString();
                }
            } else {
                if (SwapTradeView.this.f81887w.hasFocus()) {
                    boolean unused3 = SwapTradeView.this.O0 = false;
                }
                if (SwapTradeView.this.f81854g != 5) {
                    String unused4 = SwapTradeView.this.K0 = editable.toString();
                }
            }
            SwapTradeView.this.f81857h.i(false);
            SwapTradeView.this.w2();
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
            if (editable.length() == 0) {
                int unused = SwapTradeView.this.S0 = 0;
            }
            String obj = editable.toString();
            if (SwapTradeView.this.S0 == 0) {
                if (SwapTradeView.this.f81848e == 0) {
                    String unused2 = SwapTradeView.this.L0 = obj;
                } else {
                    String unused3 = SwapTradeView.this.M0 = obj;
                }
            }
            if (editable.length() == 0) {
                SwapTradeView.this.B.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_regular));
                SwapTradeView.this.x2("0");
                return;
            }
            SwapTradeView.this.B.setTypeface(ResourcesCompat.h(SwapTradeView.this.getContext(), R.font.roboto_medium));
            String str = null;
            if (a7.e.E(TradeType.SWAP)) {
                if (SwapTradeView.this.S0 == 0) {
                    str = i6.m.b(editable, 10, us.i.k(SwapTradeView.this.f81857h.t()));
                }
                if (str != null) {
                    SwapTradeView swapTradeView = SwapTradeView.this;
                    swapTradeView.D2(swapTradeView.B, str);
                    return;
                }
            } else {
                if (SwapTradeView.this.S0 == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = i6.m.b(editable, 10, us.i.l(SwapTradeView.this.f81857h.t()));
                    }
                }
                if (str != null) {
                    SwapTradeView swapTradeView2 = SwapTradeView.this;
                    swapTradeView2.D2(swapTradeView2.B, str);
                    return;
                }
            }
            SwapTradeView.this.f81857h.j(false, true);
            SwapTradeView.this.w2();
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
            SwapTradeView.this.setPriceText(i6.m.i(aVar.a(), us.i.m(aVar.o0())));
            SwapTradeView.this.t0();
            SwapTradeView.this.W0.hideKeyboard();
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
            SwapTradeView.this.setPriceText(i6.m.m(aVar.b(), us.i.m(aVar.o0())));
        }
    }

    public SwapTradeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1(int i11) {
        if (i11 == 0) {
            T0(0);
            this.f81853f1.setType(0);
        } else if (i11 == 1) {
            T0(3);
            this.f81853f1.setType(3);
        } else {
            T0(4);
            this.f81853f1.setType(4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Q1(View view) {
        if (this.f81850e1 != null) {
            LimitChooseDialog vh2 = LimitChooseDialog.vh();
            Bundle bundle = new Bundle();
            int i11 = this.f81854g;
            bundle.putInt("selIndex", i11 == 0 ? 0 : i11 == 3 ? 1 : 2);
            vh2.setArguments(bundle);
            vh2.wh(new k3(this)).show(this.f81850e1, "limitChoose");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean R1(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        sn.f.f(TradeType.SWAP, getContext());
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void S1(View view) {
        if (this.f81857h.n().x().size() > 0) {
            this.f81894z0.show(((Activity) this.f81888w0).getFragmentManager(), "depthBottomMenuFragment");
        }
        this.W0.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void T1(View view) {
        this.W0.hideKeyboard();
        this.f81857h.I();
        gs.g.j(this.f81842c, this.f81839b, "lever_adjust", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void U1(View view) {
        this.D0.show(((Activity) this.f81888w0).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void V1(View view) {
        this.f81885v.clearFocus();
        this.W0.hideKeyboard();
        this.B0.showAsDropDown(((FragmentActivity) this.f81888w0).getSupportFragmentManager(), this.f81866k);
        is.a.j("5182", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
        gs.g.j(this.f81842c, this.f81839b, "entrust_model", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W1() {
        this.O.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X1() {
        this.O.setImageResource(R.drawable.trade_arrow_down_new);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Y1(CompoundButton compoundButton, boolean z11) {
        HashMap hashMap = new HashMap();
        gl.b.b(TradeType.SWAP, z11);
        if (z11) {
            this.f81843c0.setVisibility(0);
            this.f81846d0.setVisibility(0);
            v1();
            hashMap.put("button_type", "open");
        } else {
            this.f81843c0.setVisibility(8);
            this.f81846d0.setVisibility(8);
            u0(true, false);
            v1();
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "split_screen");
        gs.g.i("take_profit_and_stop_loss_switch_click", hashMap);
        gs.g.j(this.f81842c, this.f81839b, "stop_surplus_loss", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Z1(View view, MotionEvent motionEvent) {
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
    public /* synthetic */ void a2(View view) {
        ContractGuideHelper.d(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), SwapTradeTogetherView.class.getName(), ContractGuideHelper.a(this.f81854g));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void b2(View view) {
        ContractGuideHelper.b((FragmentActivity) oa.a.g().b(), 2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c2(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        if (O1()) {
            this.f81867k0 = u2(futureTpSlSettingParams, true);
            FutureTpSlSettingParams u22 = u2(futureTpSlSettingParams2, false);
            this.f81870l0 = u22;
            this.U.refreshTpSlView(this.f81867k0, u22);
            return;
        }
        this.f81873m0 = u2(futureTpSlSettingParams, true);
        FutureTpSlSettingParams u23 = u2(futureTpSlSettingParams2, false);
        this.f81875n0 = u23;
        this.U.refreshTpSlView(this.f81873m0, u23);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d2(FutureTpSlSettingDialogFragment.c cVar, View view) {
        if (TextUtils.isEmpty(this.f81857h.p())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!B2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.W0.hideKeyboard();
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = new FutureTpSlDialogShowBean();
            futureTpSlDialogShowBean.setTradeType(TradeType.SWAP);
            D1(futureTpSlDialogShowBean);
            FutureTpSlSettingDialogFragment Kh = FutureTpSlSettingDialogFragment.Kh(futureTpSlDialogShowBean);
            this.f81882t0 = Kh;
            Kh.Vh(i6.m.a(String.valueOf(this.f81857h.n().z())));
            this.f81882t0.Uh(cVar);
            this.f81882t0.show(((FragmentActivity) this.f81888w0).getSupportFragmentManager(), "FutureTpSettingDialogFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e2(View view) {
        if (O1()) {
            this.f81867k0 = null;
        } else {
            this.f81873m0 = null;
        }
        y1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f2(View view) {
        x1();
        if (O1()) {
            this.f81870l0 = null;
        } else {
            this.f81875n0 = null;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g2(View view) {
        sn.f.f(TradeType.SWAP, this.f81888w0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private String getBboStr() {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return this.f81888w0.getString(R.string.n_contract_trade_rival_price);
        }
        return this.f81888w0.getString(R.string.n_contract_trade_optimal_one);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h2(View view) {
        this.F0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.E, true, 0, 0, 80);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i2(View view) {
        if (!tg.r.x().F0()) {
            Context context = this.f81888w0;
            boolean z11 = ((Activity) context) instanceof HuobiMainActivity;
            Intent v11 = k0.v(context, z11);
            if (!z11) {
                v11.addFlags(67108864);
            }
            rn.c.i().d((Activity) this.f81888w0, new JumpTarget(v11, v11));
        } else if (z.f().h() == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            z.f().g(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new s());
        } else if (z.f().h().getActiveState() != 1) {
            us.h.d(getContext(), true);
            is.a.j("4665", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
            gs.g.i("App_swap_open_click", (HashMap) null);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            this.W0.hideKeyboard();
            this.f81857h.K(z1(O1()));
            is.a.j(O1() ? "4683" : "4684", (Map<String, Object>) null, is.a.f(TradeType.SWAP));
            HashMap hashMap = new HashMap();
            hashMap.put("coin_contract_trade_set", "split_screen");
            gs.g.j(this.f81839b, (String) null, O1() ? "buy_open" : "sell_open", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2(View view, boolean z11) {
        v2(this.f81879r, z11);
        this.U0.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k2(View view) {
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ImageButton imageButton = this.f81889x;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.f81889x.isSelected()) {
            this.W0.hideKeyboard();
            this.f81885v.setCurrentPriceTypeText(this.f81888w0.getString(R.string.contract_trade_position_close_quick));
            this.f81885v.setPriceInputType(6);
            this.f81887w.setText("");
        } else {
            this.f81885v.setPriceInputType(1);
            this.f81857h.i(false);
        }
        setLightingSelect(this.f81889x.isSelected());
        this.R0.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l2(View view) {
        int i11;
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.R0.isSelected() && ((i11 = this.f81854g) == 0 || i11 == 3 || i11 == 4)) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_spot_order_risk)).C0(getContext().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
        TextView textView = this.R0;
        textView.setSelected(!textView.isSelected());
        if (this.f81885v.k()) {
            this.f81885v.setPriceInputType(1);
            this.f81857h.i(false);
        } else {
            if (this.f81887w.hasFocus()) {
                this.W0.hideKeyboard();
            }
            if (this.f81854g == 1) {
                this.f81885v.setCurrentPriceTypeText(this.f81888w0.getString(R.string.n_contract_trade_optimal_five));
                this.f81885v.setPriceInputType(3);
            } else {
                this.f81885v.setCurrentPriceTypeText(getBboStr());
                this.f81885v.setPriceInputType(2);
            }
            this.f81887w.setText("");
        }
        setLightingSelect(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m2(View view, boolean z11) {
        v2(this.f81885v, z11);
        this.U0.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void n2(View view) {
        E1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o2(View view, boolean z11) {
        if (z11) {
            setProgress(0);
            if (this.S0 == 5) {
                this.B.setText("");
            }
            if (O1()) {
                if (com.hbg.lib.core.util.w.l()) {
                    this.A.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
                } else {
                    this.A.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                this.A.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
            } else {
                this.A.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
            }
        } else {
            this.A.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
        this.U0.onFocusChange(view, z11);
    }

    public static /* synthetic */ void p2(HBDialogFragment hBDialogFragment) {
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q2(String str, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Rh((Activity) getContext(), str);
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s2(DialogFragment dialogFragment, View view) {
        v0.e(getContext(), "900000106126");
    }

    private void setLightingSelect(boolean z11) {
        this.f81889x.setSelected(z11);
        if (z11) {
            setProgress(100);
            q1(100);
        } else if (this.f81885v.getLastTradePriceType() == 6) {
            setProgress(0);
            if (this.f81848e == 0) {
                this.B.setText(this.L0);
            } else {
                this.B.setText(this.M0);
            }
        }
        w2();
    }

    /* access modifiers changed from: private */
    public void setSlText(String str) {
        this.f81858h0.setText(str);
    }

    /* access modifiers changed from: private */
    public void setTpText(String str) {
        this.f81855g0.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t2() {
        if (this.V.getVisibility() == 0) {
            ej.j.h(this.W, getContext().getString(R.string.n_contract_tp_sl_guide_hint), b3.f60334b, new l3(this));
        }
    }

    public void A0(int i11) {
        ViewGroup viewGroup = this.I0;
        if (viewGroup != null) {
            viewGroup.setVisibility(i11);
            this.V0.setUI(this.f81857h.w());
            this.V0.setCountDownTime(bj.d.o());
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

    public final void A2() {
        i6.i.b().g(new r3(this), 10);
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

    public final boolean B2() {
        BigDecimal a11 = i6.m.a(getInputPriceText());
        if (getTradePriceType() != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            return this.f81857h.J(z1(O1()));
        }
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.input_unknow_text), new Object[]{this.f81887w.getHint().toString()}));
        return false;
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.T;
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

    public void C2(SwapAccountInfo swapAccountInfo) {
        this.f81860i = swapAccountInfo;
        w2();
    }

    public void D1(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        if (ContractTpslLayout.isLimitlOrder(this.f81854g) && !this.f81885v.k()) {
            futureTpSlDialogShowBean.setEntrustPrice(i6.m.a(getInputPriceText()));
        }
        if (a7.e.E(TradeType.SWAP)) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f81857h.s()).longValue()));
        } else if (this.S0 == 5) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f81857h.s()).longValue()));
        } else {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(getInputAmountText()).longValue()));
        }
        futureTpSlDialogShowBean.setLever(this.f81857h.p());
        futureTpSlDialogShowBean.setSymbol(this.f81857h.t());
        if (this.f81857h.m() != null) {
            futureTpSlDialogShowBean.setContractType(this.f81857h.m().getContractType());
            futureTpSlDialogShowBean.setContractCode(this.f81857h.m().getContractCode());
            futureTpSlDialogShowBean.setContractShortType(this.f81857h.m().getContractShortType());
            futureTpSlDialogShowBean.setPricePrecision(us.i.m(this.f81857h.m().getSymbol()));
            futureTpSlDialogShowBean.setPredictProfitPrecision(us.i.t(this.f81857h.m().getSymbol()));
            futureTpSlDialogShowBean.setContractFace(i6.m.a(this.f81857h.m().getContractFace()));
        }
        if (this.f81845d == 0) {
            FutureTpSlSettingParams C1 = C1(this.f81867k0);
            FutureTpSlSettingParams C12 = C1(this.f81870l0);
            FutureTpSlSettingDialogFragment.OpenType openType = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
            C1.setOpenType(openType);
            C12.setOpenType(openType);
            futureTpSlDialogShowBean.setStopProfitSetting(C1);
            futureTpSlDialogShowBean.setStopLossSetting(C12);
            return;
        }
        FutureTpSlSettingParams C13 = C1(this.f81873m0);
        FutureTpSlSettingParams C14 = C1(this.f81875n0);
        FutureTpSlSettingDialogFragment.OpenType openType2 = FutureTpSlSettingDialogFragment.OpenType.OpenShort;
        C13.setOpenType(openType2);
        C14.setOpenType(openType2);
        futureTpSlDialogShowBean.setStopProfitSetting(C13);
        futureTpSlDialogShowBean.setStopLossSetting(C14);
    }

    public void D2(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.T;
        if (tradeTrendView != null) {
            tradeTrendView.setSellList(list);
        }
    }

    public final void E1() {
        if (this.f81885v.k()) {
            this.E0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f81885v, true, 0, 0, 80);
        }
    }

    public void E2(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(i6.m.a(str)) == 0) {
            this.f81881t.setVisibility(4);
            return;
        }
        this.f81883u.setText(AppUtil.b(String.format(this.f81888w0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f81881t.setVisibility(0);
    }

    public final void F1(Context context, AttributeSet attributeSet) {
        this.f81888w0 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.contract_trade_layout, this, true);
        this.T = (TradeTrendView) inflate.findViewById(R.id.contract_trade_trend_view);
        v1();
        this.f81890x0 = inflate.findViewById(R.id.rl_bond);
        this.f81892y0 = (TextView) inflate.findViewById(R.id.tv_bond2);
        this.f81869l = (TextView) inflate.findViewById(R.id.order_type_tv);
        this.Y0 = inflate.findViewById(R.id.iv_contract_guide);
        this.f81866k = inflate.findViewById(R.id.order_type_ll);
        this.f81872m = (ImageView) inflate.findViewById(R.id.order_type_arrow_iv);
        this.f81874n = (TextView) inflate.findViewById(R.id.contract_trade_lever_value_tv);
        this.f81876o = (ImageView) inflate.findViewById(R.id.contract_trade_lever_arrow_iv);
        this.f81877p = (RelativeLayout) inflate.findViewById(R.id.contract_trade_lever_ll);
        this.f81878q = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_view_container);
        ContractTradePriceEditext contractTradePriceEditext = (ContractTradePriceEditext) inflate.findViewById(R.id.contract_trigger_price_view);
        this.f81879r = contractTradePriceEditext;
        TradeType tradeType = TradeType.SWAP;
        contractTradePriceEditext.setTradeType(tradeType);
        this.f81880s = this.f81879r.getEditText();
        this.f81881t = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_convert_container);
        this.f81883u = (TextView) inflate.findViewById(R.id.contract_trigger_price_convert_tv);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.contract_trade_price_view);
        this.f81885v = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setTradeType(tradeType);
        this.f81885v.setClearEnable(true);
        this.f81887w = this.f81885v.getEditText();
        this.C = inflate.findViewById(R.id.track_price_rl);
        this.D = inflate.findViewById(R.id.call_back_rate_ll);
        this.E = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.track_price_view);
        this.F = (EditText) inflate.findViewById(R.id.call_back_rate_et);
        this.f81889x = (ImageButton) inflate.findViewById(R.id.lighting_trade_ib);
        this.f81891y = (ViewGroup) inflate.findViewById(R.id.contract_price_convert_container);
        this.f81893z = (TextView) inflate.findViewById(R.id.contract_price_convert_tv);
        ContractTradeAmountView contractTradeAmountView = (ContractTradeAmountView) inflate.findViewById(R.id.contract_trade_amount_view);
        this.A = contractTradeAmountView;
        this.B = contractTradeAmountView.getEditText();
        this.f81844c1 = (LinearLayout) inflate.findViewById(R.id.llLimitChoose);
        this.f81847d1 = (TextView) inflate.findViewById(R.id.tvLimitTitle);
        this.f81844c1.setOnClickListener(new v3(this));
        this.T0 = (MultiColorSeekBar) inflate.findViewById(R.id.contract_seekbar_new);
        this.G = (RelativeLayout) inflate.findViewById(R.id.trade_confirm_ll);
        this.H = (TextView) inflate.findViewById(R.id.trade_confirm_btn);
        this.I = (TextView) inflate.findViewById(R.id.trade_instruction_tv);
        this.J = (TextView) inflate.findViewById(R.id.trade_mask_title_tv);
        this.I0 = (ViewGroup) inflate.findViewById(R.id.safeguard_trade_ll);
        SwapMaintenanceView swapMaintenanceView = new SwapMaintenanceView(this.f81888w0);
        this.V0 = swapMaintenanceView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) swapMaintenanceView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.V0.setLayoutParams(layoutParams);
        this.I0.addView(this.V0);
        this.V0.h();
        this.V0.setTopMargin(84);
        this.V0.setTradeSafeguardHint(getContext().getString(R.string.n_contract_service_in_maintain_market));
        this.K = (TextView) inflate.findViewById(R.id.trade_suspend_instruction_tv);
        this.L = (LinearLayout) inflate.findViewById(R.id.stop_trade_ll);
        this.M = (TextView) inflate.findViewById(R.id.contract_vertical_amount_label_tv);
        this.R = (TextView) inflate.findViewById(R.id.input_volume_value_tv);
        this.R0 = (TextView) inflate.findViewById(R.id.contract_trade_rival_price_tv);
        this.f81886v0 = (MagicIndicator) inflate.findViewById(R.id.buy_shell_indicator);
        this.S = inflate.findViewById(R.id.contract_volume_rl);
        ContractTpslLayout contractTpslLayout = (ContractTpslLayout) inflate.findViewById(R.id.contract_tp_sl_include);
        this.U = contractTpslLayout;
        contractTpslLayout.setTradeType(tradeType);
        this.V = inflate.findViewById(R.id.contract_tp_sl_switch_container);
        this.W = inflate.findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_sl_tv);
        this.f81840b0 = bottomLineTextView;
        bottomLineTextView.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.f81840b0.setTextColor(R.color.baseColorSecondaryText);
        this.f81837a0 = (CheckBox) inflate.findViewById(R.id.contract_tp_sl_switch_iv);
        this.f81843c0 = inflate.findViewById(R.id.contract_tp_sl_input_container);
        this.f81846d0 = inflate.findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) inflate.findViewById(R.id.contract_tp_input_container);
        this.f81849e0 = contractTpslEditText;
        this.f81855g0 = contractTpslEditText.getEditText();
        this.f81861i0 = this.f81849e0.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) inflate.findViewById(R.id.contract_sl_input_container);
        this.f81852f0 = contractTpslEditText2;
        this.f81858h0 = contractTpslEditText2.getEditText();
        this.f81864j0 = this.f81852f0.getClearImageView();
        k kVar = new k();
        this.f81849e0.setCallback(kVar);
        this.f81852f0.setCallback(kVar);
        this.f81838a1 = inflate.findViewById(R.id.contract_market_rl);
        this.f81841b1 = inflate.findViewById(R.id.trade_price_ll_container);
        HuobiKeyboardHelper registerInput = new HuobiKeyboardHelper().attach((Activity) this.f81888w0).registerInput(this.f81880s, this.f81887w, this.F, this.f81855g0, this.f81858h0).registerInput(this.B, new e3(this));
        this.W0 = registerInput;
        this.f81879r.setKeyboardHelper(registerInput);
        H1();
        I1(inflate);
        N1(inflate);
        L1();
        K1();
        M1();
        J1();
        this.A.c(tradeType, new q());
    }

    public void F3(PriceLimitInfo priceLimitInfo) {
    }

    public final void G1() {
        this.f81884u0.clear();
        int i11 = this.f81848e;
        if (i11 == 0) {
            this.f81884u0.add(this.f81888w0.getString(R.string.n_contract_trade_open_more));
            this.f81884u0.add(this.f81888w0.getString(R.string.n_contract_trade_open_low));
        } else if (i11 == 1) {
            this.f81884u0.add(this.f81888w0.getString(R.string.n_contract_trade_close_more));
            this.f81884u0.add(this.f81888w0.getString(R.string.n_contract_trade_close_low));
        } else {
            this.f81884u0.add(this.f81888w0.getString(R.string.n_contract_trade_open_more));
            this.f81884u0.add(this.f81888w0.getString(R.string.n_contract_trade_open_low));
        }
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment;
        int i11;
        TradeTrendView tradeTrendView = this.T;
        if (tradeTrendView != null) {
            tradeTrendView.setNewestPrice(marketCurrentPriceItem);
        }
        this.f81857h.i(false);
        String obj = this.f81887w.getText().toString();
        String b11 = marketCurrentPriceItem.b();
        if (TextUtils.isEmpty(obj) && !this.f81887w.hasFocus() && !TextUtils.equals("--", b11) && this.f81885v.getTradePriceType() == 1 && (i11 = this.f81854g) != 5) {
            if (this.f81848e == 0) {
                if (this.P0 || i11 == 6) {
                    this.N0 = true;
                    this.f81887w.setText(b11);
                }
            } else if (this.Q0 || i11 == 6) {
                this.O0 = true;
                this.f81887w.setText(b11);
            }
        }
        if (!TextUtils.equals("--", b11)) {
            if (this.f81848e == 0) {
                this.P0 = false;
            } else {
                this.Q0 = false;
            }
        }
        if (this.f81857h != null && (futureTpSlSettingDialogFragment = this.f81882t0) != null && futureTpSlSettingDialogFragment.isVisible()) {
            this.f81882t0.Vh(i6.m.a(String.valueOf(this.f81857h.n().z())));
        }
    }

    public void H1() {
        this.f81845d = 0;
        G1();
        CommonNavigator commonNavigator = new CommonNavigator(this.f81888w0);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new r());
        this.f81886v0.setNavigator(commonNavigator);
    }

    public void I0() {
        if (this.f81885v.getTradePriceType() != 1) {
            this.f81857h.i(false);
        }
    }

    public final void I1(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vertical_depth_tv);
        this.N = textView;
        textView.setText("--");
        this.O = (ImageView) view.findViewById(R.id.vertical_depth_arrow_iv);
        this.P = view.findViewById(R.id.depth_ll);
        this.f81894z0.setMenuItems(new ArrayList());
        this.f81894z0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void J0() {
        this.B.setText("");
        setProgress(0);
    }

    public final void J1() {
        this.G.setOnClickListener(new w2(this));
        this.f81879r.setOnEditTextFocusChangeListener(new p3(this));
        this.f81889x.setOnClickListener(new u3(this));
        this.R0.setOnClickListener(new y2(this));
        this.f81880s.addTextChangedListener(new t());
        this.f81885v.setOnEditTextFocusChangeListener(new o3(this));
        this.f81885v.setOnClickListener(new y3(this));
        this.f81885v.setCallback(new u());
        this.f81887w.addTextChangedListener(new v());
        this.B.addTextChangedListener(new w());
        this.B.setOnFocusChangeListener(new c3(this));
        this.T.setCallback(new x());
        this.T.setNewestPriceItemViewPreDrawListener(new a());
        this.P.setOnClickListener(new x3(this));
        this.f81877p.setOnClickListener(new x2(this));
        this.Q.setOnClickListener(new v2(this));
        this.f81866k.setOnClickListener(new u2(this));
        this.B0.setDialogFragmentListener(new b());
        this.E0.setDialogFragmentListener(new c());
        this.A0.setDialogFragmentListener(new d());
        this.f81894z0.setBottomMenuShowListener(new n3(this));
        this.f81894z0.setBottomMenuDismissListener(new m3(this));
        this.T0.setOnProgressChangedListener(new e());
        this.f81837a0.setOnCheckedChangeListener(new g3(this));
        this.f81837a0.setOnTouchListener(new d3(this));
        this.Y0.setOnClickListener(new f3(this));
        this.f81840b0.setOnClickListener(a3.f60328b);
        this.f81846d0.setOnClickListener(new z2(this, new j3(this)));
        this.f81861i0.setOnClickListener(new q3(this));
        this.f81864j0.setOnClickListener(new w3(this));
        this.D.setOnClickListener(new s3(this));
        this.E.setOnClickListener(new t3(this));
        this.E.setCallback(new f());
        this.F0.setDialogFragmentListener(new g());
        this.F.addTextChangedListener(new h());
    }

    public void K0() {
        LeverSelectDialogFragment leverSelectDialogFragment = this.A0;
        if (leverSelectDialogFragment != null) {
            leverSelectDialogFragment.dismiss();
        }
    }

    public final void K1() {
        ArrayList arrayList = new ArrayList();
        if (this.f81854g == 1) {
            arrayList.add(new CommonPopListItem(3, this.f81888w0.getString(R.string.n_contract_trade_optimal_five), this.f81865j1));
            arrayList.add(new CommonPopListItem(4, this.f81888w0.getString(R.string.n_contract_trade_optimal_ten), this.f81865j1));
            arrayList.add(new CommonPopListItem(5, this.f81888w0.getString(R.string.n_contract_trade_optimal_twenty), this.f81865j1));
        } else {
            arrayList.add(new CommonPopListItem(2, getBboStr(), ContextCompat.getColor(this.f81888w0, R.color.baseColorPrimaryText), this.f81865j1));
            arrayList.add(new CommonPopListItem(3, this.f81888w0.getString(R.string.n_contract_trade_optimal_five), this.f81865j1));
            arrayList.add(new CommonPopListItem(4, this.f81888w0.getString(R.string.n_contract_trade_optimal_ten), this.f81865j1));
            arrayList.add(new CommonPopListItem(5, this.f81888w0.getString(R.string.n_contract_trade_optimal_twenty), this.f81865j1));
        }
        this.E0.setData(arrayList);
    }

    public void L(int i11, SwapCurrencyInfo swapCurrencyInfo) {
        if (swapCurrencyInfo != null) {
            if (swapCurrencyInfo.getContractStatus() == 5 || swapCurrencyInfo.getContractStatus() == 7) {
                this.J.setText(R.string.n_contract_trade_settling);
                this.K.setText(R.string.n_contract_trade_system_settling);
            } else if (swapCurrencyInfo.getContractStatus() == 6 || swapCurrencyInfo.getContractStatus() == 8) {
                this.J.setText(R.string.n_contract_trade_delivering);
                this.K.setText(R.string.n_contract_trade_system_delivering);
            } else if (swapCurrencyInfo.getContractStatus() == 3) {
                this.J.setText(R.string.n_contract_trade_stop);
                this.K.setText("");
            } else if (swapCurrencyInfo.getContractStatus() == 4) {
                this.J.setText(R.string.n_contract_trade_pre_trade);
                this.K.setText("");
            }
        }
        this.L.setVisibility(i11);
    }

    public void L0() {
        if (this.f81885v.getTradePriceType() == 1) {
            this.f81851f = false;
        } else {
            this.f81857h.i(false);
        }
    }

    public final void L1() {
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getContext().getString(R.string.n_contract_order_type_limit), ContextCompat.getColor(this.f81888w0, R.color.baseColorPrimaryText), this.f81862i1);
        this.f81853f1 = commonPopListItem;
        this.C0.add(commonPopListItem);
        this.C0.add(new CommonPopListItem(6, getContext().getString(R.string.n_exchange_price_market_deal), ContextCompat.getColor(this.f81888w0, R.color.baseColorPrimaryText), this.f81862i1));
        this.C0.add(new CommonPopListItem(1, getContext().getString(R.string.n_contract_order_type_trigger), this.f81862i1));
        this.C0.add(new CommonPopListItem(5, getContext().getString(R.string.n_contract_track_order), this.f81862i1));
        this.C0.add(new CommonPopListItem(2, getContext().getString(R.string.n_contract_trade_post_only), this.f81862i1));
        this.B0.setData(this.C0);
        this.B0.setFollowViewWidth(true);
    }

    public void M0(int i11) {
        boolean z11 = true;
        if (!tg.r.x().F0() || !(z.f().h() == null || z.f().h().getActiveState() == 1)) {
            this.G.setBackgroundResource(R.drawable.shape_contract_login);
        } else if (ContractCalmPeriodHelper.d()) {
            this.G.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
        } else {
            boolean l11 = com.hbg.lib.core.util.w.l();
            int i12 = R.drawable.trade_btn_sell_selector;
            int i13 = l11 ? R.drawable.trade_btn_sell_selector : R.drawable.trade_btn_buy_selector;
            if (com.hbg.lib.core.util.w.l()) {
                i12 = R.drawable.trade_btn_buy_selector;
            }
            RelativeLayout relativeLayout = this.G;
            if (i11 != 0) {
                i13 = i12;
            }
            relativeLayout.setBackgroundResource(i13);
        }
        MultiConfigBuilder configBuilder = this.T0.getConfigBuilder();
        Context context = getContext();
        boolean g11 = NightHelper.e().g();
        if (i11 != 0) {
            z11 = false;
        }
        configBuilder.colorConfig(context, g11, z11).build();
    }

    public final void M1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(7, this.f81888w0.getString(R.string.n_contract_theoretical_price), ContextCompat.getColor(this.f81888w0, R.color.baseColorPrimaryText), this.f81868k1));
        arrayList.add(new CommonPopListItem(3, this.f81888w0.getString(R.string.n_contract_trade_optimal_five), this.f81868k1));
        arrayList.add(new CommonPopListItem(4, this.f81888w0.getString(R.string.n_contract_trade_optimal_ten), this.f81868k1));
        arrayList.add(new CommonPopListItem(5, this.f81888w0.getString(R.string.n_contract_trade_optimal_twenty), this.f81868k1));
        this.F0.setData(arrayList);
    }

    public void N0(ContractDepth contractDepth, int i11) {
        String priceTick = contractDepth.getPriceTick();
        if (!TextUtils.isEmpty(priceTick)) {
            this.N.setText(i6.m.a(priceTick).stripTrailingZeros().toPlainString());
        } else {
            this.N.setText("--");
        }
    }

    public final void N1(View view) {
        this.Q = (ImageView) view.findViewById(R.id.trend_change_iv);
        this.G0.add(new MenuItem(0, this.f81888w0.getString(R.string.n_contract_trade_trend_default), this.f81888w0.getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f81856g1));
        List<MenuItem> list = this.G0;
        String string = this.f81888w0.getString(R.string.n_contract_trade_trend_buy);
        String string2 = this.f81888w0.getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f81856g1));
        this.G0.add(new MenuItem(2, this.f81888w0.getString(R.string.n_contract_trade_trend_sell), this.f81888w0.getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.f81856g1));
        this.D0.setMenuItems(this.G0);
        this.D0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void O0(int i11) {
        this.f81848e = i11;
        this.S0 = 0;
        t0();
        w1();
        G1();
        n0();
        Y0(this.f81848e);
        M0(this.f81845d);
        T0(this.f81854g);
        t1();
        A2();
    }

    public boolean O1() {
        if (this.f81848e == 0) {
            if (this.f81845d == 0) {
                return true;
            }
            return false;
        } else if (this.f81845d != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void P0(String str, String str2) {
    }

    public void Q0() {
        boolean z11 = getPositionType() == 0;
        this.A.setData(z11);
        TradeType tradeType = TradeType.SWAP;
        if (!a7.e.E(tradeType)) {
            this.B.setHint(this.f81888w0.getString(R.string.n_contract_trade_input_amount));
        } else if (!z11 || !a7.e.H(tradeType)) {
            this.B.setHint(this.f81888w0.getString(R.string.n_contract_unit_amount));
        } else {
            this.B.setHint(this.f81888w0.getString(R.string.n_contract_unit_principal));
        }
        z2();
    }

    public void R0(boolean z11) {
        if (z11) {
            this.M0 = null;
            this.L0 = null;
            this.K0 = null;
            this.J0 = null;
        } else {
            int i11 = this.f81848e;
            if (i11 == 0) {
                this.L0 = null;
                this.J0 = null;
            } else if (i11 == 1) {
                this.M0 = null;
                this.K0 = null;
            }
        }
        this.f81887w.setText("");
        this.B.setText("");
    }

    public void S0(String str, String str2) {
        if (!this.B.getText().toString().equals(str2)) {
            this.B.setText(str2);
        }
    }

    public void T0(int i11) {
        SP.q("SwapTradeTogetherViewOrderType", i11);
        this.f81854g = i11;
        this.R0.setSelected(false);
        t1();
        K1();
        ViewUtil.m(this.f81838a1, false);
        ViewUtil.m(this.f81841b1, true);
        if (this.f81845d == 0) {
            this.U.changeTradeOrderType(this.f81854g, this.f81848e, this.f81867k0, this.f81870l0);
        } else {
            this.U.changeTradeOrderType(this.f81854g, this.f81848e, this.f81873m0, this.f81875n0);
        }
        this.f81844c1.setVisibility(8);
        switch (this.f81854g) {
            case 0:
            case 3:
            case 4:
                this.f81844c1.setVisibility(0);
                int i12 = this.f81854g;
                if (i12 == 0) {
                    this.f81847d1.setText("GTC");
                } else if (i12 == 3) {
                    this.f81847d1.setText("IOC");
                } else {
                    this.f81847d1.setText("FOK");
                }
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.f81869l.setText(getContext().getString(R.string.n_contract_order_type_limit));
                this.f81878q.setVisibility(8);
                this.R0.setVisibility(0);
                this.R0.setText(R.string.n_contract_trade_rival_price);
                this.f81885v.setPriceInputType(1);
                this.f81885v.setHintText((int) R.string.n_contract_trade_input_price);
                r1();
                break;
            case 1:
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.f81869l.setText(getContext().getString(R.string.n_contract_order_type_trigger));
                this.f81878q.setVisibility(0);
                this.R0.setVisibility(0);
                this.R0.setText(R.string.n_contract_trade_optimal_n);
                this.f81879r.setPriceInputType(1);
                this.f81879r.setTradeUseType(1);
                this.f81879r.setDividerVisibility(8);
                this.f81879r.setLabelVisibility(8);
                this.f81885v.setPriceInputType(1);
                this.f81885v.setHintText((int) R.string.n_contract_trade_input_price);
                w0(true, false);
                break;
            case 2:
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.f81869l.setText(getContext().getString(R.string.n_contract_trade_post_only));
                this.f81878q.setVisibility(8);
                this.R0.setVisibility(8);
                this.f81885v.setPriceInputType(1);
                this.f81885v.setHintText((int) R.string.n_contract_trade_input_price);
                r1();
                break;
            case 5:
                this.f81869l.setText(getContext().getString(R.string.n_contract_track_order));
                this.f81878q.setVisibility(8);
                this.R0.setVisibility(8);
                this.C.setVisibility(0);
                this.D.setVisibility(0);
                this.E.setPriceInputType(2);
                this.E.setCurrentPriceTypeText(this.f81888w0.getString(R.string.n_contract_trade_optimal_twenty));
                this.E.setPriceInputType(5);
                this.f81885v.setPriceInputType(1);
                this.f81885v.setHintText((int) R.string.n_contract_active_price);
                this.f81887w.setText("");
                break;
            case 6:
                this.C.setVisibility(8);
                this.D.setVisibility(8);
                this.f81869l.setText(getContext().getString(R.string.n_exchange_price_market_deal));
                this.f81878q.setVisibility(8);
                this.R0.setVisibility(0);
                this.R0.setText(R.string.n_contract_trade_rival_price);
                this.f81885v.setPriceInputType(1);
                this.f81885v.setHintText((int) R.string.n_contract_trade_input_price);
                r1();
                ViewUtil.m(this.f81838a1, true);
                ViewUtil.m(this.f81841b1, false);
                break;
        }
        t0();
        v1();
    }

    public void U0() {
        if (this.f81885v.getTradePriceType() == 1) {
            this.f81851f = false;
        } else {
            this.f81857h.i(false);
        }
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.H0.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.H0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.f81859h1));
            } else {
                this.H0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.f81859h1));
            }
        }
        this.f81894z0.setMenuItems(this.H0);
    }

    public boolean W0() {
        return this.f81837a0.isChecked();
    }

    public void X0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.f81891y.setVisibility(8);
            return;
        }
        this.f81893z.setText(AppUtil.b(String.format(this.f81888w0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f81891y.setVisibility(0);
    }

    public void Y0(int i11) {
        if (tg.r.x().F0()) {
            SwapUserInfo.UserBean h11 = z.f().h();
            if (h11 != null && h11.getActiveState() != 1) {
                this.I.setVisibility(8);
                this.H.setText(R.string.n_contract_swap_open_title);
            } else if (ContractCalmPeriodHelper.d()) {
                this.I.setVisibility(8);
                this.H.setText(R.string.n_contract_calm_period_name);
            } else if (i11 == 0) {
                if (this.f81845d == 0) {
                    this.H.setText(R.string.contract_trade_buy_open_more);
                    this.I.setText(R.string.contract_trade_rise);
                } else {
                    this.H.setText(R.string.contract_trade_sell_open_low);
                    this.I.setText(R.string.contract_trade_down);
                }
                this.I.setVisibility(0);
            } else if (i11 == 1) {
                if (this.f81845d == 0) {
                    this.H.setText(R.string.contract_trade_sell_flat_more);
                } else {
                    this.H.setText(R.string.contract_trade_buy_flat_empty);
                }
                this.I.setVisibility(8);
            } else {
                this.H.setText(R.string.contract_trade_position_close);
                this.I.setVisibility(8);
            }
        } else {
            this.H.setText(R.string.n_contract_trade_log_in_to_exchange);
            this.I.setVisibility(8);
        }
        v1();
    }

    public void c(int i11) {
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    if (com.hbg.lib.core.util.w.l()) {
                        this.Q.setImageResource(R.drawable.trade_trend_green);
                    } else {
                        this.Q.setImageResource(R.drawable.trade_trend_red);
                    }
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                this.Q.setImageResource(R.drawable.trade_trend_red);
            } else {
                this.Q.setImageResource(R.drawable.trade_trend_green);
            }
        } else if (com.hbg.lib.core.util.w.l()) {
            this.Q.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.Q.setImageResource(R.drawable.trade_trend_default_red_green);
        }
    }

    public void d(boolean z11) {
        if (z11) {
            this.R0.setEnabled(true);
            this.f81889x.setEnabled(true);
            setLightingSelect(false);
            this.f81837a0.setChecked(gl.b.a(TradeType.SWAP));
        } else {
            this.R0.setSelected(false);
            this.R0.setEnabled(false);
            this.f81889x.setEnabled(false);
            setLightingSelect(false);
            this.f81867k0 = null;
            this.f81870l0 = null;
            this.f81873m0 = null;
            this.f81875n0 = null;
            y1();
            x1();
            this.U.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
            this.f81837a0.setChecked(false);
        }
        A2();
    }

    public String getBondZeroDefault() {
        String t11 = this.f81857h.t();
        return BigDecimal.ZERO.setScale(FuturePrecisionUtil.g(this.f81857h.t()), 4).toPlainString() + t11;
    }

    public String getCallBackRateText() {
        return this.F.getText().toString();
    }

    public String getInputAmountText() {
        return this.B.getText().toString();
    }

    public String getInputPriceText() {
        return this.f81887w.getText().toString();
    }

    public k4 getOnEditTextFocusChangeListener() {
        return this.U0;
    }

    public String getOrderPlaceInputAmount() {
        String obj = this.B.getText().toString();
        if (getTradeAmountType() != 0 || getPositionType() != 0) {
            return obj;
        }
        TradeType tradeType = TradeType.SWAP;
        return (!a7.e.E(tradeType) || !a7.e.H(tradeType)) ? obj : i6.m.a(obj).multiply(i6.m.a(this.f81857h.p())).toPlainString();
    }

    public int getOrderType() {
        return this.f81854g;
    }

    public int getPositionType() {
        return this.f81848e;
    }

    public int getSeekBarProgress() {
        return this.T0.getProgress();
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
        return this.f81837a0.isChecked();
    }

    public int getTradeAmountType() {
        return this.S0;
    }

    public int getTradePosition() {
        return this.f81845d;
    }

    public int getTradePriceType() {
        return this.f81885v.getTradePriceType();
    }

    public String getTriggerPriceText() {
        return this.f81880s.getText().toString();
    }

    public String getVolume() {
        String orderPlaceInputAmount = getOrderPlaceInputAmount();
        if (this.S0 != 5) {
            return orderPlaceInputAmount;
        }
        SwapAccountInfo swapAccountInfo = this.f81860i;
        if (swapAccountInfo != null) {
            return i6.m.a(swapAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.f81863j)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
        }
        return null;
    }

    public void n0() {
        this.f81886v0.getNavigator().notifyDataSetChanged();
    }

    public void notifyDataSetChanged() {
        TradeTrendView tradeTrendView = this.T;
        if (tradeTrendView != null) {
            tradeTrendView.i();
        }
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            w1();
        }
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.X0;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            DialogUtils.b.d Q02 = new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getContext().getString(R.string.n_known)).Q0(i3.f60370a);
            if (!TextUtils.isEmpty(str)) {
                Q02.s0(getContext().getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new h3(this, str));
            }
            HBDialogFragment k02 = Q02.k0();
            this.X0 = k02;
            k02.show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public void q0() {
        HBDialogFragment hBDialogFragment = this.X0;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public final void q1(int i11) {
        this.f81863j = i11;
        this.W0.hideKeyboard();
        t0();
        this.S0 = 5;
        this.f81857h.N(this.f81848e, i11);
        if (this.f81848e == 0) {
            this.L0 = null;
        } else {
            this.M0 = null;
        }
        w2();
    }

    public void r0() {
        this.E0.dismiss();
        this.F0.dismiss();
    }

    public final void r1() {
        int i11 = this.f81845d;
        if (i11 == 0) {
            if (this.f81848e == 0) {
                L0();
            } else {
                U0();
            }
        } else if (i11 == 1) {
            if (this.f81848e == 0) {
                U0();
            } else {
                L0();
            }
        }
        w0(true, false);
    }

    public void s0() {
        for (MenuItem next : this.G0) {
            if (next.getType() == 0) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f81857h.n().S(0);
        if (com.hbg.lib.core.util.w.l()) {
            this.Q.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.Q.setImageResource(R.drawable.trade_trend_default_red_green);
        }
        this.T.c(0);
        this.f81857h.n().Y(false);
    }

    public String s1(boolean z11) {
        if (!tg.r.x().F0() || this.f81857h == null) {
            return "--";
        }
        try {
            FutureEarnestMoneyUtils f11 = FutureEarnestMoneyUtils.f();
            boolean z12 = true;
            f11.i(this.f81888w0).t(getVolume()).q(this.R0).h(a7.e.E(this.f81857h.q())).r(this.f81857h.q()).l(this.f81857h.p()).u(this.f81857h.t()).k(this.f81857h.m().getContractFace()).o(FuturePrecisionUtil.g(this.f81857h.t())).g(BigDecimal.valueOf(this.f81857h.n().v()).toPlainString()).j(getInputPriceText()).m(BigDecimal.valueOf(this.f81857h.n().z()).toPlainString()).p(BigDecimal.valueOf(this.f81857h.n().A()).toPlainString()).n(this.f81854g == 6);
            if (this.S0 != 5) {
                z12 = false;
            }
            return f11.a(z11, z12);
        } catch (FutureEarnestMoneyUtils.ZeroErr e11) {
            e11.printStackTrace();
            return getBondZeroDefault();
        }
    }

    public void setAmountEtText(String str) {
        this.B.setText(str);
    }

    public void setContractTradeViewController(n1 n1Var) {
        this.f81857h = n1Var;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f81850e1 = fragmentManager;
    }

    public void setHasTrade(boolean z11) {
        this.Z0 = z11;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f81851f = z11;
    }

    public void setLeverList(List<String> list) {
        if (list != null) {
            this.A0.tc(list);
        }
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.U0 = k4Var;
    }

    public void setPositionType(int i11) {
        this.f81848e = i11;
    }

    public void setPriceAnimator(String str) {
        this.f81887w.setText(str);
        EditText editText = this.f81887w;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.f81887w);
    }

    public void setPriceInputType(int i11) {
        this.f81885v.setPriceInputType(i11);
    }

    public void setPriceText(String str) {
        this.f81885v.setPriceInputType(1);
        this.R0.setSelected(false);
        setLightingSelect(false);
        if (this.f81848e == 0) {
            this.N0 = false;
            this.J0 = str;
        } else {
            this.K0 = str;
            this.O0 = false;
        }
        int i11 = this.f81854g;
        if (i11 != 5 && i11 != 6) {
            setPriceAnimator(str);
        }
    }

    public void setProgress(int i11) {
        this.T0.setProgress((float) i11);
    }

    public void setTradePosition(int i11) {
        this.f81845d = i11;
    }

    public void setTriggerPriceTypeView(int i11) {
        this.f81879r.setDividerVisibility(8);
        this.f81879r.setLabelVisibility(8);
    }

    public void setViewVisibility(int i11) {
        setVisibility(i11);
    }

    public void t0() {
        this.f81887w.clearFocus();
        this.B.clearFocus();
        this.f81880s.clearFocus();
    }

    public final void t1() {
        setLightingSelect(false);
    }

    public void u0(boolean z11, boolean z12) {
        if (z11) {
            this.f81867k0 = null;
            this.f81870l0 = null;
            this.f81873m0 = null;
            this.f81875n0 = null;
        } else if (this.f81845d == 0) {
            this.f81867k0 = null;
            this.f81870l0 = null;
        } else {
            this.f81873m0 = null;
            this.f81875n0 = null;
        }
        y1();
        x1();
        this.U.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        if (z12) {
            this.f81837a0.setChecked(false);
        }
    }

    public final void u1(int i11) {
        this.f81845d = i11;
        Y0(this.f81848e);
        M0(this.f81845d);
    }

    public final FutureTpSlSettingParams u2(FutureTpSlSettingParams futureTpSlSettingParams, boolean z11) {
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

    public void v0() {
        this.f81874n.setText("--");
        this.f81874n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f81876o.setImageResource(0);
    }

    public final void v1() {
        getViewTreeObserver().addOnPreDrawListener(new i());
    }

    public final void v2(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        } else if (O1()) {
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

    public void w0(boolean z11, boolean z12) {
        if (this.f81885v.getTradePriceType() == 1) {
            if (this.f81848e == 0 && !TextUtils.isEmpty(this.J0)) {
                this.f81887w.setText(this.J0);
            } else if (this.f81848e != 1 || TextUtils.isEmpty(this.K0)) {
                this.f81887w.setText("");
            } else {
                this.f81887w.setText(this.K0);
            }
        }
        if (z11) {
            this.f81880s.setText("");
            this.F.setText("");
        }
        if (z12 && this.f81854g != 5) {
            this.f81885v.setPriceInputType(1);
            this.R0.setSelected(false);
            setLightingSelect(false);
        }
        if (this.f81848e == 0 && !TextUtils.isEmpty(this.L0)) {
            this.B.setText(this.L0);
        } else if (this.f81848e != 1 || TextUtils.isEmpty(this.M0)) {
            this.B.setText("");
        } else {
            this.B.setText(this.M0);
        }
        setProgress(0);
        this.R.setText("--");
        w2();
        this.W0.hideKeyboard();
    }

    public final void w1() {
        if (this.f81848e == 0) {
            if (this.N0) {
                this.f81887w.setText("");
            }
            this.P0 = true;
            return;
        }
        if (this.O0) {
            this.f81887w.setText("");
        }
        this.Q0 = true;
    }

    public final void w2() {
        if (this.f81848e == 0) {
            boolean z11 = false;
            this.f81890x0.setVisibility(0);
            TextView textView = this.f81892y0;
            if (this.f81848e == 0) {
                z11 = true;
            }
            textView.setText(s1(z11));
            return;
        }
        this.f81890x0.setVisibility(8);
    }

    public void x0(String str) {
        this.f81874n.setText(String.format(this.f81888w0.getString(R.string.contract_lever), new Object[]{str}));
        if (this.A0.isResumed()) {
            this.f81876o.setImageResource(R.drawable.trade_arrow_up);
        } else {
            this.f81876o.setImageResource(R.drawable.trade_arrow_down);
        }
        if (i6.m.a(str).compareTo(BigDecimal.TEN) >= 0) {
            this.f81874n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        } else {
            this.f81874n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        }
    }

    public final void x1() {
        this.f81858h0.setText("");
    }

    public void x2(String str) {
        if (this.S0 == 0) {
            if (i6.m.a(str).compareTo(BigDecimal.ZERO) <= 0) {
                this.R.setText("--");
                w2();
            } else if (a7.e.E(TradeType.SWAP)) {
                this.R.setText(String.format(this.f81888w0.getString(R.string.trade_total_volume_value), new Object[]{str, this.f81888w0.getString(R.string.n_contract_vol_sheet)}));
                w2();
            } else {
                this.R.setText(String.format(this.f81888w0.getString(R.string.trade_total_volume_value), new Object[]{str, this.f81857h.t().toUpperCase(Locale.US)}));
                w2();
            }
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(4);
        }
        w2();
    }

    public final void y1() {
        this.f81855g0.setText("");
    }

    public void y2() {
        this.A0.bc(this.f81857h.t());
        this.A0.xi(us.j.f(this.f81857h.t(), this.f81888w0));
        this.A0.vi(this.f81871l1);
        this.A0.ti(this.f81857h.p());
        this.A0.setTradeType(TradeType.SWAP);
        this.A0.zi(ContractWebActivity.Eh(2));
        this.A0.si(this.f81857h.m().getContractCode());
        this.A0.show(((FragmentActivity) this.f81888w0).getSupportFragmentManager(), "leverSelectDialogFragment");
    }

    public void z0(boolean z11) {
        this.G.setEnabled(z11);
    }

    public final ContractOrderPlace z1(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0(getInputPriceText());
        contractOrderPlace.d0(getOrderPlaceInputAmount());
        contractOrderPlace.h0(z11);
        contractOrderPlace.A0(this.f81848e);
        if (this.f81854g == 6) {
            contractOrderPlace.X0(8);
        } else {
            contractOrderPlace.X0(this.f81885v.getTradePriceType());
        }
        contractOrderPlace.g0(getTradeAmountType());
        contractOrderPlace.y0(this.f81854g);
        contractOrderPlace.Z0(getTriggerPriceText());
        contractOrderPlace.Y0(this.f81880s.getHint().toString());
        contractOrderPlace.e0(this.f81888w0.getString(R.string.n_exchange_order_list_amount));
        contractOrderPlace.C0(this.f81887w.getHint().toString());
        contractOrderPlace.W0(this.H.getText().toString());
        contractOrderPlace.x0(this.f81885v.getCurrentPriceTypeText());
        contractOrderPlace.E0(getSeekBarProgress());
        contractOrderPlace.j0(this.F.getHint().toString());
        contractOrderPlace.U0(this.E.getCurrentPriceTypeText());
        contractOrderPlace.k0(getCallBackRateText());
        contractOrderPlace.V0(this.E.getTradePriceType());
        if (this.f81857h.m() != null) {
            contractOrderPlace.n0(this.f81857h.m().getContractType());
        }
        if (this.f81837a0.isChecked() && ContractTpslLayout.supportTpslOrder(this.f81854g)) {
            if (z11) {
                FutureTpSlSettingParams futureTpSlSettingParams = this.f81867k0;
                if (futureTpSlSettingParams != null) {
                    B1(contractOrderPlace, futureTpSlSettingParams);
                }
                FutureTpSlSettingParams futureTpSlSettingParams2 = this.f81870l0;
                if (futureTpSlSettingParams2 != null) {
                    A1(contractOrderPlace, futureTpSlSettingParams2);
                }
            } else {
                FutureTpSlSettingParams futureTpSlSettingParams3 = this.f81873m0;
                if (futureTpSlSettingParams3 != null) {
                    B1(contractOrderPlace, futureTpSlSettingParams3);
                }
                FutureTpSlSettingParams futureTpSlSettingParams4 = this.f81875n0;
                if (futureTpSlSettingParams4 != null) {
                    A1(contractOrderPlace, futureTpSlSettingParams4);
                }
            }
        }
        return contractOrderPlace;
    }

    public final void z2() {
        if (!a7.e.E(TradeType.SWAP)) {
            this.M.setText(String.format(this.f81888w0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f81888w0.getString(R.string.n_contract_vol_sheet)}));
        } else if (TextUtils.isEmpty(this.f81857h.t())) {
            this.M.setText(R.string.n_contract_trade_input_amount);
        } else {
            this.M.setText(String.format(this.f81888w0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f81857h.t()}));
        }
    }

    public SwapTradeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f81839b = "coin_contract";
        this.f81842c = "contract_trade";
        this.f81854g = 0;
        this.f81884u0 = new ArrayList();
        this.f81894z0 = new BottomMenuFragment();
        this.A0 = new LeverSelectDialogFragment();
        this.B0 = new CommonListPopupDialog();
        this.C0 = new ArrayList();
        this.D0 = new BottomMenuFragment();
        this.E0 = new CommonListPopupDialog();
        this.F0 = new CommonListPopupDialog();
        this.G0 = new ArrayList();
        this.H0 = new ArrayList();
        this.N0 = true;
        this.O0 = true;
        this.P0 = true;
        this.Q0 = true;
        this.f81856g1 = new j();
        this.f81859h1 = new l();
        this.f81862i1 = new m();
        this.f81865j1 = new n();
        this.f81868k1 = new o();
        this.f81871l1 = new p();
        F1(context, attributeSet);
    }
}
