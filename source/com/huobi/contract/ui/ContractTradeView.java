package com.huobi.contract.ui;

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
import bj.q2;
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
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.bean.LevelAvailableMarginInfo;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.anim.CommonAnimateUtil;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.CommonListPopupDialog;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.contract.entity.ContractDepth;
import com.huobi.contract.entity.ContractOrderPlace;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.entity.PriceType;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.contract.ui.ContractGearsTradePriceEditText;
import com.huobi.contract.ui.ContractTpslEditText;
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
import com.huobi.view.keyboard.CustomBoardView;
import com.huobi.view.keyboard.HuobiKeyboardHelper;
import com.huobi.view.seekbar.MultiColorSeekBar;
import com.huobi.view.seekbar.MultiConfigBuilder;
import com.huobi.webview2.ui.ContractWebActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dj.a4;
import dj.b4;
import dj.c4;
import dj.d3;
import dj.d4;
import dj.e3;
import dj.e4;
import dj.f3;
import dj.f4;
import dj.g3;
import dj.g4;
import dj.h3;
import dj.h4;
import dj.i3;
import dj.i4;
import dj.j3;
import dj.j4;
import dj.k3;
import dj.k4;
import dj.l3;
import dj.m3;
import dj.n3;
import dj.o3;
import dj.p3;
import dj.q3;
import dj.r3;
import dj.s3;
import dj.t3;
import dj.u3;
import dj.v3;
import dj.w3;
import dj.x3;
import dj.y3;
import dj.z3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.b;
import k6.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import pro.huobi.R;
import rx.Observable;

public class ContractTradeView extends FrameLayout implements j4, m0<ContractAccountInfo> {
    public EditText A;
    public String A0;
    public View B;
    public View B0;
    public View C;
    public TextView C0;
    public ContractGearsTradePriceEditText D;
    public boolean D0;
    public EditText E;
    public boolean E0;
    public ImageButton F;
    public boolean F0;
    public RelativeLayout G;
    public boolean G0;
    public TextView H;
    public final BottomMenuFragment H0;
    public TextView I;
    public final LeverSelectDialogFragment I0;
    public TextView J;
    public final CommonListPopupDialog J0;
    public TextView K;
    public final List<CommonPopListItem> K0;
    public LinearLayout L;
    public final BottomMenuFragment L0;
    public TextView M;
    public final CommonListPopupDialog M0;
    public TextView N;
    public final CommonListPopupDialog N0;
    public ImageView O;
    public final List<MenuItem> O0;
    public View P;
    public final List<MenuItem> P0;
    public ImageView Q;
    public ViewGroup Q0;
    public TextView R;
    public TextView R0;
    public ViewGroup S;
    public int S0;
    public TradeTrendView T;
    public MultiColorSeekBar T0;
    public ContractTpslLayout U;
    public k4 U0;
    public View V;
    public ContractMaintenanceView V0;
    public View W;
    public HuobiKeyboardHelper W0;
    public HBDialogFragment X0;
    public View Y0;
    public boolean Z0;

    /* renamed from: a0  reason: collision with root package name */
    public CheckBox f43500a0;

    /* renamed from: a1  reason: collision with root package name */
    public View f43501a1;

    /* renamed from: b  reason: collision with root package name */
    public String f43502b;

    /* renamed from: b0  reason: collision with root package name */
    public BottomLineTextView f43503b0;

    /* renamed from: b1  reason: collision with root package name */
    public View f43504b1;

    /* renamed from: c  reason: collision with root package name */
    public String f43505c;

    /* renamed from: c0  reason: collision with root package name */
    public View f43506c0;

    /* renamed from: c1  reason: collision with root package name */
    public LinearLayout f43507c1;

    /* renamed from: d  reason: collision with root package name */
    public int f43508d;

    /* renamed from: d0  reason: collision with root package name */
    public View f43509d0;

    /* renamed from: d1  reason: collision with root package name */
    public TextView f43510d1;

    /* renamed from: e  reason: collision with root package name */
    public int f43511e;

    /* renamed from: e0  reason: collision with root package name */
    public ContractTpslEditText f43512e0;

    /* renamed from: e1  reason: collision with root package name */
    public FragmentManager f43513e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43514f;

    /* renamed from: f0  reason: collision with root package name */
    public ContractTpslEditText f43515f0;

    /* renamed from: f1  reason: collision with root package name */
    public CommonPopListItem f43516f1;

    /* renamed from: g  reason: collision with root package name */
    public int f43517g;

    /* renamed from: g0  reason: collision with root package name */
    public EditText f43518g0;

    /* renamed from: g1  reason: collision with root package name */
    public MenuItemOnClickListener f43519g1;

    /* renamed from: h  reason: collision with root package name */
    public q2 f43520h;

    /* renamed from: h0  reason: collision with root package name */
    public EditText f43521h0;

    /* renamed from: h1  reason: collision with root package name */
    public final MenuItemOnClickListener f43522h1;

    /* renamed from: i  reason: collision with root package name */
    public ContractAccountInfo f43523i;

    /* renamed from: i0  reason: collision with root package name */
    public ImageView f43524i0;

    /* renamed from: i1  reason: collision with root package name */
    public final CommonPopListItem.a f43525i1;

    /* renamed from: j  reason: collision with root package name */
    public int f43526j;

    /* renamed from: j0  reason: collision with root package name */
    public ImageView f43527j0;

    /* renamed from: j1  reason: collision with root package name */
    public final CommonPopListItem.a f43528j1;

    /* renamed from: k  reason: collision with root package name */
    public View f43529k;

    /* renamed from: k0  reason: collision with root package name */
    public FutureTpSlSettingParams f43530k0;

    /* renamed from: k1  reason: collision with root package name */
    public final CommonPopListItem.a f43531k1;

    /* renamed from: l  reason: collision with root package name */
    public TextView f43532l;

    /* renamed from: l0  reason: collision with root package name */
    public FutureTpSlSettingParams f43533l0;

    /* renamed from: l1  reason: collision with root package name */
    public final LeverSelectDialogFragment.h f43534l1;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f43535m;

    /* renamed from: m0  reason: collision with root package name */
    public FutureTpSlSettingParams f43536m0;

    /* renamed from: n  reason: collision with root package name */
    public TextView f43537n;

    /* renamed from: n0  reason: collision with root package name */
    public FutureTpSlSettingParams f43538n0;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f43539o;

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f43540p;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup f43541q;

    /* renamed from: r  reason: collision with root package name */
    public ContractTradePriceEditext f43542r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f43543s;

    /* renamed from: t  reason: collision with root package name */
    public ViewGroup f43544t;

    /* renamed from: t0  reason: collision with root package name */
    public FutureTpSlSettingDialogFragment f43545t0;

    /* renamed from: u  reason: collision with root package name */
    public TextView f43546u;

    /* renamed from: u0  reason: collision with root package name */
    public final List<String> f43547u0;

    /* renamed from: v  reason: collision with root package name */
    public ContractGearsTradePriceEditText f43548v;

    /* renamed from: v0  reason: collision with root package name */
    public MagicIndicator f43549v0;

    /* renamed from: w  reason: collision with root package name */
    public EditText f43550w;

    /* renamed from: w0  reason: collision with root package name */
    public Context f43551w0;

    /* renamed from: x  reason: collision with root package name */
    public ViewGroup f43552x;

    /* renamed from: x0  reason: collision with root package name */
    public String f43553x0;

    /* renamed from: y  reason: collision with root package name */
    public TextView f43554y;

    /* renamed from: y0  reason: collision with root package name */
    public String f43555y0;

    /* renamed from: z  reason: collision with root package name */
    public ContractTradeAmountView f43556z;

    /* renamed from: z0  reason: collision with root package name */
    public String f43557z0;

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public boolean onPreDraw() {
            int d11 = ContractTradeView.this.T.d();
            ContractTradeView.this.T.l(d11 / 2, d11);
            return true;
        }
    }

    public class b implements BaseDialogFragment.c {
        public b() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractTradeView.this.f43535m.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeView.this.f43535m.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class c implements BaseDialogFragment.c {
        public c() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractTradeView.this.f43548v.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeView.this.f43548v.p(R.drawable.trade_arrow_up);
        }
    }

    public class d implements BaseDialogFragment.c {
        public d() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractTradeView.this.f43539o.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeView.this.f43539o.setImageResource(R.drawable.trade_arrow_up);
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
                ContractTradeView.this.s1(i11);
            }
        }
    }

    public class f implements ContractGearsTradePriceEditText.c {
        public f() {
        }

        public void a() {
            ContractTradeView.this.N0.showAsDropDown(((FragmentActivity) ContractTradeView.this.getContext()).getSupportFragmentManager(), (View) ContractTradeView.this.D, true, 0, 0, 80);
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
            ContractTradeView.this.D.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeView.this.D.p(R.drawable.trade_arrow_up);
        }
    }

    public class h implements TextWatcher {
        public h() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                ContractTradeView.this.E.setTypeface(ResourcesCompat.h(ContractTradeView.this.getContext(), R.font.roboto_regular));
            } else {
                ContractTradeView.this.E.setTypeface(ResourcesCompat.h(ContractTradeView.this.getContext(), R.font.roboto_medium));
            }
            if (i6.m.b(editable, 10, 1) != null) {
                ContractTradeView contractTradeView = ContractTradeView.this;
                contractTradeView.G2(contractTradeView.E, editable.toString());
                return;
            }
            ContractTradeView.this.y2();
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
            ContractTradeView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int d11 = ContractTradeView.this.T.d();
            ContractTradeView.this.T.l(d11 / 2, d11);
            return true;
        }
    }

    public class j implements MenuItemOnClickListener {
        public j() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : ContractTradeView.this.O0) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            if (i11 == 0) {
                ContractTradeView.this.f43520h.l().S(0);
                if (com.hbg.lib.core.util.w.l()) {
                    ContractTradeView.this.Q.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    ContractTradeView.this.Q.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                if (ContractTradeView.this.T != null) {
                    ContractTradeView.this.T.c(0);
                }
            } else if (i11 == 1) {
                ContractTradeView.this.f43520h.l().S(1);
                if (com.hbg.lib.core.util.w.l()) {
                    ContractTradeView.this.Q.setImageResource(R.drawable.trade_trend_red);
                } else {
                    ContractTradeView.this.Q.setImageResource(R.drawable.trade_trend_green);
                }
                if (ContractTradeView.this.T != null) {
                    ContractTradeView.this.T.c(1);
                }
            } else {
                ContractTradeView.this.f43520h.l().S(2);
                if (com.hbg.lib.core.util.w.l()) {
                    ContractTradeView.this.Q.setImageResource(R.drawable.trade_trend_green);
                } else {
                    ContractTradeView.this.Q.setImageResource(R.drawable.trade_trend_red);
                }
                if (ContractTradeView.this.T != null) {
                    ContractTradeView.this.T.c(2);
                }
            }
            ContractTradeView.this.f43520h.l().Y(false);
            ContractTradeView.this.L0.dismiss();
        }
    }

    public class k implements ContractTpslEditText.c {
        public k() {
        }

        public void afterTextChanged(EditText editText, String str) {
            if (editText == ContractTradeView.this.f43518g0) {
                if (ContractTradeView.this.R1()) {
                    ContractTradeView contractTradeView = ContractTradeView.this;
                    FutureTpSlSettingParams unused = contractTradeView.f43530k0 = FutureTpSlSettingParams.changeTpSlCache(contractTradeView.f43530k0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
                    return;
                }
                ContractTradeView contractTradeView2 = ContractTradeView.this;
                FutureTpSlSettingParams unused2 = contractTradeView2.f43536m0 = FutureTpSlSettingParams.changeTpSlCache(contractTradeView2.f43536m0, FutureTpSlSettingDialogFragment.OpenType.OpenShort, str);
            } else if (editText != ContractTradeView.this.f43521h0) {
            } else {
                if (ContractTradeView.this.R1()) {
                    ContractTradeView contractTradeView3 = ContractTradeView.this;
                    FutureTpSlSettingParams unused3 = contractTradeView3.f43533l0 = FutureTpSlSettingParams.changeTpSlCache(contractTradeView3.f43533l0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
                    return;
                }
                ContractTradeView contractTradeView4 = ContractTradeView.this;
                FutureTpSlSettingParams unused4 = contractTradeView4.f43538n0 = FutureTpSlSettingParams.changeTpSlCache(contractTradeView4.f43538n0, FutureTpSlSettingDialogFragment.OpenType.OpenShort, str);
            }
        }

        public int getTradePricePrecision() {
            if (ContractTradeView.this.f43520h.j() != null) {
                return ej.f.p(ContractTradeView.this.f43520h.j().getContractCode());
            }
            return 14;
        }
    }

    public class l implements MenuItemOnClickListener {
        public l() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (ContractTradeView.this.f43520h.l() != null) {
                ContractTradeView.this.f43520h.l().t(i11);
            }
            ContractTradeView.this.H0.dismiss();
        }
    }

    public class m implements CommonPopListItem.a {
        public m() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            ContractTradeView.this.J0.dismiss();
            int type = commonPopListItem.getType();
            if (type != ContractTradeView.this.f43517g) {
                ContractTradeView.this.T0(type);
                HashMap hashMap = new HashMap();
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                if (type == 0) {
                    if (!ContractTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "limit_order");
                } else if (type == 1) {
                    ContractGuideHelper.b(fragmentActivity, 4);
                    hashMap.put("type", "trigger");
                } else if (type == 2) {
                    if (!ContractTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "post_only");
                } else if (type == 3) {
                    if (!ContractTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "ioc");
                } else if (type == 4) {
                    if (!ContractTradeView.this.Z0) {
                        ContractGuideHelper.b(fragmentActivity, 1);
                    }
                    hashMap.put("type", "fok");
                }
                is.a.j("5146", hashMap, is.a.f(TradeType.CONTRACT));
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == ContractTradeView.this.f43517g;
        }
    }

    public class n implements CommonPopListItem.a {
        public n() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            String str;
            ContractTradeView.this.f43548v.setPriceInputType(commonPopListItem.getType());
            ContractTradeView.this.f43548v.setCurrentPriceTypeText(commonPopListItem.getText());
            ContractTradeView.this.M0.dismiss();
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
            is.a.j("5147", hashMap, is.a.f(TradeType.CONTRACT));
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ContractTradeView.this.f43548v.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class o implements CommonPopListItem.a {
        public o() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            ContractTradeView.this.D.setPriceInputType(commonPopListItem.getType());
            ContractTradeView.this.D.setCurrentPriceTypeText(commonPopListItem.getText());
            ContractTradeView.this.N0.dismiss();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ContractTradeView.this.D.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class p implements LeverSelectDialogFragment.h {
        public p() {
        }

        public void N0() {
            if (ContractTradeView.this.f43520h != null) {
                ContractTradeView.this.f43520h.u().N0();
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return uc.b.d(tradeType, str, i11);
        }

        public void P0(String str) {
            ContractTradeView.this.x0(str);
            ContractTradeView.this.f43520h.E(str);
            ContractTradeView.this.f43520h.B();
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return ContractTradeView.this.f43520h.h(str, levelAvailableMarginInfo);
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            if (ContractTradeView.this.f43520h != null) {
                ContractTradeView.this.f43520h.A(leverSelectDialogFragment, str, ContractTradeView.this.f43520h.r());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            is.a.j("5148", hashMap, is.a.f(TradeType.CONTRACT));
            return true;
        }
    }

    public class q implements ContractTradeAmountView.a {
        public q() {
        }

        public String o0() {
            return ContractTradeView.this.f43520h.r();
        }
    }

    public class r extends CommonNavigatorAdapter {
        public r() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            if (ContractTradeView.this.f43508d == i11) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            ContractTradeView.this.w0(true, true);
            ContractTradeView.this.t0();
            ContractTradeView.this.w1(i11);
            ContractTradeView.this.y1();
            if (i11 == 0) {
                if (ContractTradeView.this.f43511e == 0) {
                    ContractTradeView.this.L0();
                    if (ContractTradeView.this.f43530k0 == null || ContractTradeView.this.f43530k0.getTriggerPrice() == null) {
                        ContractTradeView.this.A1();
                    } else {
                        ContractTradeView contractTradeView = ContractTradeView.this;
                        contractTradeView.setTpText(contractTradeView.f43530k0.getTriggerPrice().toPlainString());
                    }
                    if (ContractTradeView.this.f43533l0 == null || ContractTradeView.this.f43533l0.getTriggerPrice() == null) {
                        ContractTradeView.this.z1();
                    } else {
                        ContractTradeView contractTradeView2 = ContractTradeView.this;
                        contractTradeView2.setSlText(contractTradeView2.f43533l0.getTriggerPrice().toPlainString());
                    }
                } else {
                    ContractTradeView.this.U0();
                }
                ContractTradeView.this.U.refreshTpSlView(ContractTradeView.this.f43530k0, ContractTradeView.this.f43533l0);
            } else if (i11 == 1) {
                if (ContractTradeView.this.f43511e == 0) {
                    if (ContractTradeView.this.f43536m0 == null || ContractTradeView.this.f43536m0.getTriggerPrice() == null) {
                        ContractTradeView.this.A1();
                    } else {
                        ContractTradeView contractTradeView3 = ContractTradeView.this;
                        contractTradeView3.setTpText(contractTradeView3.f43536m0.getTriggerPrice().toPlainString());
                    }
                    if (ContractTradeView.this.f43538n0 == null || ContractTradeView.this.f43538n0.getTriggerPrice() == null) {
                        ContractTradeView.this.z1();
                    } else {
                        ContractTradeView contractTradeView4 = ContractTradeView.this;
                        contractTradeView4.setSlText(contractTradeView4.f43538n0.getTriggerPrice().toPlainString());
                    }
                    ContractTradeView.this.U0();
                } else {
                    ContractTradeView.this.L0();
                }
                ContractTradeView.this.U.refreshTpSlView(ContractTradeView.this.f43536m0, ContractTradeView.this.f43538n0);
            }
            ContractTradeView.this.f43520h.f(false);
            ContractTradeView.this.f43549v0.c(i11);
            ContractTradeView.this.f43549v0.b(i11, 0.0f, 0);
            if (ContractTradeView.this.S0 == 5) {
                ContractTradeView.this.A.setText("");
                String unused = ContractTradeView.this.A0 = null;
                String unused2 = ContractTradeView.this.f43557z0 = null;
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            return ContractTradeView.this.f43547u0.size();
        }

        public q10.b getIndicator(Context context) {
            return null;
        }

        public q10.c getTitleView(Context context, int i11) {
            TradeBuySellView tradeBuySellView = new TradeBuySellView(context);
            ContractTradeView.this.I1();
            if (i11 == 0) {
                tradeBuySellView.setNormalColor(ContextCompat.getColor(ContractTradeView.this.f43551w0, R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(ContractTradeView.this.f43551w0, R.color.baseTextColor));
                if (ContractTradeView.this.f43511e == 0) {
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
                tradeBuySellView.setNormalColor(ContextCompat.getColor(ContractTradeView.this.f43551w0, R.color.global_secondary_text_color));
                tradeBuySellView.setSelectedColor(ContextCompat.getColor(ContractTradeView.this.f43551w0, R.color.baseTextColor));
                if (ContractTradeView.this.f43511e == 0) {
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
            tradeBuySellView.setText((CharSequence) ContractTradeView.this.f43547u0.get(i11));
            tradeBuySellView.setOnClickListener(new i4(this, i11));
            return tradeBuySellView;
        }
    }

    public class s extends BaseSubscriber<ContractUserInfo.UserBean> {
        public s() {
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo.UserBean userBean) {
            super.onNext(userBean);
            ContractTradeView contractTradeView = ContractTradeView.this;
            contractTradeView.w1(contractTradeView.f43508d);
        }
    }

    public class t implements TextWatcher {
        public t() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                ContractTradeView.this.f43543s.setTypeface(ResourcesCompat.h(ContractTradeView.this.f43543s.getContext(), R.font.roboto_regular));
            } else {
                ContractTradeView.this.f43543s.setTypeface(ResourcesCompat.h(ContractTradeView.this.f43543s.getContext(), R.font.roboto_medium));
            }
            ContractTradeView contractTradeView = ContractTradeView.this;
            contractTradeView.H2(contractTradeView.f43520h.m(editable.toString()));
            if (!(ContractTradeView.this.f43520h.j() == null || i6.m.b(editable, 10, ej.f.p(ContractTradeView.this.f43520h.j().getContractCode())) == null)) {
                ContractTradeView contractTradeView2 = ContractTradeView.this;
                contractTradeView2.G2(contractTradeView2.f43543s, editable.toString());
            }
            ContractTradeView.this.y2();
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
            ContractTradeView.this.G1();
        }

        public void b() {
            ContractTradeView.this.G1();
        }
    }

    public class v implements TextWatcher {
        public v() {
        }

        public void afterTextChanged(Editable editable) {
            int tradePriceType = ContractTradeView.this.getTradePriceType();
            if (editable.length() == 0) {
                ContractTradeView.this.f43550w.setTypeface(ResourcesCompat.h(ContractTradeView.this.getContext(), R.font.roboto_regular));
                ContractTradeView.this.l(BigDecimal.ZERO);
            } else {
                ContractTradeView.this.f43550w.setTypeface(ResourcesCompat.h(ContractTradeView.this.getContext(), R.font.roboto_medium));
            }
            ContractTradeView contractTradeView = ContractTradeView.this;
            contractTradeView.X0(contractTradeView.f43520h.m(editable.toString()));
            String str = null;
            if (tradePriceType == 1 && ContractTradeView.this.f43520h.j() != null) {
                str = i6.m.b(editable, 10, ej.f.p(ContractTradeView.this.f43520h.j().getContractCode()));
            }
            if (str != null) {
                ContractTradeView contractTradeView2 = ContractTradeView.this;
                contractTradeView2.G2(contractTradeView2.f43550w, editable.toString());
                return;
            }
            if (ContractTradeView.this.f43511e == 0) {
                if (ContractTradeView.this.f43550w.hasFocus()) {
                    boolean unused = ContractTradeView.this.D0 = false;
                }
                if (ContractTradeView.this.f43517g != 5) {
                    String unused2 = ContractTradeView.this.f43553x0 = editable.toString();
                }
            } else {
                if (ContractTradeView.this.f43550w.hasFocus()) {
                    boolean unused3 = ContractTradeView.this.E0 = false;
                }
                if (ContractTradeView.this.f43517g != 5) {
                    String unused4 = ContractTradeView.this.f43555y0 = editable.toString();
                }
            }
            ContractTradeView.this.f43520h.f(false);
            ContractTradeView.this.y2();
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
                int unused = ContractTradeView.this.S0 = 0;
            }
            String obj = editable.toString();
            if (ContractTradeView.this.S0 == 0) {
                if (ContractTradeView.this.f43511e == 0) {
                    String unused2 = ContractTradeView.this.f43557z0 = obj;
                } else {
                    String unused3 = ContractTradeView.this.A0 = obj;
                }
            }
            if (editable.length() == 0) {
                ContractTradeView.this.A.setTypeface(ResourcesCompat.h(ContractTradeView.this.getContext(), R.font.roboto_regular));
                ContractTradeView.this.l(BigDecimal.ZERO);
                return;
            }
            ContractTradeView.this.A.setTypeface(ResourcesCompat.h(ContractTradeView.this.getContext(), R.font.roboto_medium));
            String str = null;
            if (!a7.e.E(TradeType.CONTRACT)) {
                if (ContractTradeView.this.S0 == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = i6.m.b(editable, 10, ej.f.g(ContractTradeView.this.f43520h.r()));
                    }
                }
                if (str != null) {
                    ContractTradeView contractTradeView = ContractTradeView.this;
                    contractTradeView.G2(contractTradeView.A, str);
                    return;
                }
            } else if (ContractTradeView.this.f43520h.j() != null) {
                if (ContractTradeView.this.S0 == 0) {
                    str = i6.m.b(editable, 10, ej.f.n(ContractTradeView.this.f43520h.j().getContractCode()));
                }
                if (str != null) {
                    ContractTradeView contractTradeView2 = ContractTradeView.this;
                    contractTradeView2.G2(contractTradeView2.A, str);
                    return;
                }
            }
            ContractTradeView.this.f43520h.g(false, true);
            ContractTradeView.this.y2();
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
            ContractTradeView.this.setPriceText(i6.m.i(aVar.a(), ej.f.p(aVar.E0())));
            ContractTradeView.this.t0();
            ContractTradeView.this.W0.hideKeyboard();
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
            ContractTradeView.this.setPriceText(i6.m.m(aVar.b(), ej.f.p(aVar.E0())));
        }
    }

    public ContractTradeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S1(int i11) {
        if (i11 == 0) {
            T0(0);
            this.f43516f1.setType(0);
        } else if (i11 == 1) {
            T0(3);
            this.f43516f1.setType(3);
        } else {
            T0(4);
            this.f43516f1.setType(4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void T1(View view) {
        if (this.f43513e1 != null) {
            LimitChooseDialog vh2 = LimitChooseDialog.vh();
            Bundle bundle = new Bundle();
            int i11 = this.f43517g;
            bundle.putInt("selIndex", i11 == 0 ? 0 : i11 == 3 ? 1 : 2);
            vh2.setArguments(bundle);
            vh2.wh(new t3(this)).show(this.f43513e1, "limitChoose");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean U1(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        rn.c.i().d((Activity) getContext(), new JumpTarget((Intent) null, (Intent) null));
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V1(View view, boolean z11) {
        if (z11) {
            setProgress(0);
            if (this.S0 == 5) {
                this.A.setText("");
            }
            if (R1()) {
                if (com.hbg.lib.core.util.w.l()) {
                    this.f43556z.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
                } else {
                    this.f43556z.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                this.f43556z.setBackgroundResource(R.drawable.custom_edittext_green_focused_bg);
            } else {
                this.f43556z.setBackgroundResource(R.drawable.custom_edittext_red_focused_bg);
            }
        } else {
            this.f43556z.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
        this.U0.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void W1(View view) {
        if (this.f43520h.l().x().size() > 0) {
            this.H0.show(((Activity) this.f43551w0).getFragmentManager(), "depthBottomMenuFragment");
        }
        this.W0.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void X1(View view) {
        this.W0.hideKeyboard();
        this.f43520h.I();
        gs.g.j(this.f43505c, this.f43502b, "lever_adjust", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Y1(View view) {
        this.L0.show(((Activity) this.f43551w0).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Z1(View view) {
        this.f43548v.clearFocus();
        this.W0.hideKeyboard();
        this.J0.showAsDropDown(((FragmentActivity) this.f43551w0).getSupportFragmentManager(), this.f43529k);
        is.a.j("5182", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
        gs.g.j(this.f43505c, this.f43502b, "entrust_model", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a2() {
        this.O.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b2() {
        this.O.setImageResource(R.drawable.trade_arrow_down_new);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c2(CompoundButton compoundButton, boolean z11) {
        HashMap hashMap = new HashMap();
        gl.b.b(TradeType.CONTRACT, z11);
        if (z11) {
            this.f43506c0.setVisibility(0);
            this.f43509d0.setVisibility(0);
            x1();
            hashMap.put("button_type", "open");
        } else {
            this.f43506c0.setVisibility(8);
            this.f43509d0.setVisibility(8);
            u0(true, false);
            x1();
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "split_screen");
        gs.g.i("take_profit_and_stop_loss_switch_click", hashMap);
        gs.g.j(this.f43505c, this.f43502b, "stop_surplus_loss", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean d2(View view, MotionEvent motionEvent) {
        if (!tg.r.x().F0()) {
            ContractModuleConfig.a().h(TradeType.CONTRACT, getContext());
            return true;
        } else if (ContractUserInfoProvider.i().r()) {
            return false;
        } else {
            HuobiToastUtil.j(R.string.n_contract_please_open_first);
            return true;
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e2(View view) {
        ContractGuideHelper.b((FragmentActivity) oa.a.g().b(), 2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f2(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        if (R1()) {
            this.f43530k0 = x2(futureTpSlSettingParams, true);
            FutureTpSlSettingParams x22 = x2(futureTpSlSettingParams2, false);
            this.f43533l0 = x22;
            this.U.refreshTpSlView(this.f43530k0, x22);
            return;
        }
        this.f43536m0 = x2(futureTpSlSettingParams, true);
        FutureTpSlSettingParams x23 = x2(futureTpSlSettingParams2, false);
        this.f43538n0 = x23;
        this.U.refreshTpSlView(this.f43536m0, x23);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void g2(FutureTpSlSettingDialogFragment.c cVar, View view) {
        if (TextUtils.isEmpty(this.f43520h.n())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!D2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.W0.hideKeyboard();
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = new FutureTpSlDialogShowBean();
            futureTpSlDialogShowBean.setTradeType(TradeType.CONTRACT);
            F1(futureTpSlDialogShowBean);
            FutureTpSlSettingDialogFragment Kh = FutureTpSlSettingDialogFragment.Kh(futureTpSlDialogShowBean);
            this.f43545t0 = Kh;
            Kh.Vh(i6.m.a(String.valueOf(this.f43520h.l().z())));
            this.f43545t0.Uh(cVar);
            this.f43545t0.show(((FragmentActivity) this.f43551w0).getSupportFragmentManager(), "FutureTpSettingDialogFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private String getBboStr() {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return this.f43551w0.getString(R.string.n_contract_trade_rival_price);
        }
        return this.f43551w0.getString(R.string.n_contract_trade_optimal_one);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void h2(View view) {
        if (R1()) {
            this.f43530k0 = null;
        } else {
            this.f43536m0 = null;
        }
        A1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i2(View view) {
        z1();
        if (R1()) {
            this.f43533l0 = null;
        } else {
            this.f43538n0 = null;
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j2(View view) {
        sn.f.f(TradeType.CONTRACT, this.f43551w0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k2(View view) {
        this.N0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.D, true, 0, 0, 80);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l2(View view) {
        if (!tg.r.x().F0()) {
            Context context = this.f43551w0;
            boolean z11 = ((Activity) context) instanceof HuobiMainActivity;
            Intent d11 = k0.d(context, z11);
            if (!z11) {
                d11.addFlags(67108864);
            }
            rn.c.i().d(this.f43551w0, new JumpTarget(d11, d11));
            is.a.j("4251", (Map<String, Object>) null, "1005011");
        } else if (ContractUserInfoProvider.i().o() == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            ContractUserInfoProvider.i().p(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new s());
        } else if (ContractUserInfoProvider.i().o().getActiveState() != 1) {
            ej.c.d(getContext(), true);
            gs.g.i("App_contract_open_click", (HashMap) null);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        } else {
            E2();
            is.a.j(R1() ? "4683" : "4684", (Map<String, Object>) null, is.a.f(TradeType.CONTRACT));
            HashMap hashMap = new HashMap();
            hashMap.put("coin_contract_trade_set", "split_screen");
            gs.g.j(this.f43502b, (String) null, R1() ? "buy_open" : "sell_open", hashMap);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m2(View view) {
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ImageButton imageButton = this.F;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.F.isSelected()) {
            this.W0.hideKeyboard();
            this.f43548v.setCurrentPriceTypeText(this.f43551w0.getString(R.string.contract_trade_position_close_quick));
            this.f43548v.setPriceInputType(6);
            this.f43550w.setText("");
        } else {
            this.f43548v.setPriceInputType(1);
            this.f43520h.f(false);
        }
        setLightingSelect(this.F.isSelected());
        this.R0.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n2(View view, boolean z11) {
        z2(this.f43542r, z11);
        this.U0.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void o2(View view) {
        int i11;
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.R0.isSelected() && ((i11 = this.f43517g) == 0 || i11 == 3 || i11 == 4)) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_spot_order_risk)).C0(getContext().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
        TextView textView = this.R0;
        textView.setSelected(!textView.isSelected());
        if (this.f43548v.k()) {
            this.f43548v.setPriceInputType(1);
            this.f43520h.f(false);
        } else {
            if (this.f43550w.hasFocus()) {
                this.W0.hideKeyboard();
            }
            if (this.f43517g == 1) {
                this.f43548v.setCurrentPriceTypeText(this.f43551w0.getString(R.string.n_contract_trade_optimal_five));
                this.f43548v.setPriceInputType(3);
            } else {
                this.f43548v.setCurrentPriceTypeText(getBboStr());
                this.f43548v.setPriceInputType(2);
            }
            this.f43550w.setText("");
        }
        setLightingSelect(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p2(View view, boolean z11) {
        z2(this.f43548v, z11);
        this.U0.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void q2(View view) {
        G1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r2(View view) {
        ContractGuideHelper.d(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), ContractTradeView.class.getName(), ContractGuideHelper.a(this.f43517g));
        gs.g.j(this.f43505c, this.f43502b, "entrust_model_explanation", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void s2(HBDialogFragment hBDialogFragment) {
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    private void setLightingSelect(boolean z11) {
        this.F.setSelected(z11);
        if (z11) {
            setProgress(100);
            s1(100);
        } else if (this.f43548v.getLastTradePriceType() == 6) {
            setProgress(0);
            if (this.f43511e == 0) {
                this.A.setText(this.f43557z0);
            } else {
                this.A.setText(this.A0);
            }
        }
        y2();
    }

    /* access modifiers changed from: private */
    public void setSlText(String str) {
        this.f43521h0.setText(str);
    }

    /* access modifiers changed from: private */
    public void setTpText(String str) {
        this.f43518g0.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t2(String str, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Rh((Activity) getContext(), str);
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v2(DialogFragment dialogFragment, View view) {
        v0.e(getContext(), "900003870186");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w2() {
        if (this.V.getVisibility() == 0) {
            ej.j.h(this.W, getContext().getString(R.string.n_contract_tp_sl_guide_hint), j3.f53702b, new u3(this));
        }
    }

    public void A0(int i11) {
        ViewGroup viewGroup = this.Q0;
        if (viewGroup != null) {
            viewGroup.setVisibility(i11);
            this.V0.setUI(this.f43520h.u());
            this.V0.setCountDownTime(bj.d.e());
        }
    }

    public final void A1() {
        this.f43518g0.setText("");
    }

    public final void A2() {
        if (this.f43511e == 0) {
            this.B0.setVisibility(0);
        } else {
            this.B0.setVisibility(8);
        }
        y2();
    }

    public final ContractOrderPlace B1(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0(getInputPriceText());
        contractOrderPlace.d0(getOrderPlaceInputAmount());
        contractOrderPlace.h0(z11);
        contractOrderPlace.A0(this.f43511e);
        if (this.f43517g == 6) {
            contractOrderPlace.X0(8);
        } else {
            contractOrderPlace.X0(this.f43548v.getTradePriceType());
        }
        contractOrderPlace.g0(getTradeAmountType());
        contractOrderPlace.y0(this.f43517g);
        contractOrderPlace.Z0(getTriggerPriceText());
        contractOrderPlace.Y0(this.f43543s.getHint().toString());
        contractOrderPlace.e0(this.A.getHint().toString());
        contractOrderPlace.C0(this.f43550w.getHint().toString());
        contractOrderPlace.W0(this.H.getText().toString());
        contractOrderPlace.x0(this.f43548v.getCurrentPriceTypeText());
        contractOrderPlace.E0(getSeekBarProgress());
        contractOrderPlace.j0(this.E.getHint().toString());
        contractOrderPlace.U0(this.D.getCurrentPriceTypeText());
        contractOrderPlace.k0(getCallBackRateText());
        contractOrderPlace.V0(this.D.getTradePriceType());
        if (this.f43520h.j() != null) {
            contractOrderPlace.n0(this.f43520h.j().getContractType());
        }
        if (this.f43500a0.isChecked() && ContractTpslLayout.supportTpslOrder(this.f43517g)) {
            if (z11) {
                FutureTpSlSettingParams futureTpSlSettingParams = this.f43530k0;
                if (futureTpSlSettingParams != null) {
                    D1(contractOrderPlace, futureTpSlSettingParams);
                }
                FutureTpSlSettingParams futureTpSlSettingParams2 = this.f43533l0;
                if (futureTpSlSettingParams2 != null) {
                    C1(contractOrderPlace, futureTpSlSettingParams2);
                }
            } else {
                FutureTpSlSettingParams futureTpSlSettingParams3 = this.f43536m0;
                if (futureTpSlSettingParams3 != null) {
                    D1(contractOrderPlace, futureTpSlSettingParams3);
                }
                FutureTpSlSettingParams futureTpSlSettingParams4 = this.f43538n0;
                if (futureTpSlSettingParams4 != null) {
                    C1(contractOrderPlace, futureTpSlSettingParams4);
                }
            }
        }
        return contractOrderPlace;
    }

    public final void B2() {
        if (!a7.e.E(TradeType.CONTRACT)) {
            this.M.setText(String.format(this.f43551w0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f43551w0.getString(R.string.n_contract_vol_sheet)}));
        } else if (TextUtils.isEmpty(this.f43520h.r())) {
            this.M.setText(R.string.n_contract_trade_input_amount);
        } else {
            this.M.setText(String.format(this.f43551w0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f43520h.r()}));
        }
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.T;
        if (tradeTrendView != null) {
            tradeTrendView.setBuyList(list);
        }
    }

    public final void C1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
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

    public final void C2() {
        i6.i.b().g(new a4(this), 10);
    }

    public final void D1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
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

    public final boolean D2() {
        BigDecimal a11 = i6.m.a(getInputPriceText());
        if (getTradePriceType() != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            return this.f43520h.J(B1(R1()));
        }
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.input_unknow_text), new Object[]{this.f43550w.getHint().toString()}));
        return false;
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.T;
        if (tradeTrendView != null) {
            tradeTrendView.setSellList(list);
        }
    }

    public final FutureTpSlSettingParams E1(FutureTpSlSettingParams futureTpSlSettingParams) {
        if (futureTpSlSettingParams == null) {
            return new FutureTpSlSettingParams(FutureTpSlSettingDialogFragment.OpenType.OpenLong, PriceType.MARKET);
        }
        return new FutureTpSlSettingParams(futureTpSlSettingParams);
    }

    public final void E2() {
        this.W0.hideKeyboard();
        this.f43520h.K(B1(R1()));
    }

    public void F1(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        if (ContractTpslLayout.isLimitlOrder(this.f43517g) && !this.f43548v.k()) {
            futureTpSlDialogShowBean.setEntrustPrice(i6.m.a(getInputPriceText()));
        }
        if (a7.e.E(TradeType.CONTRACT)) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f43520h.q()).longValue()));
        } else if (this.S0 == 5) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f43520h.q()).longValue()));
        } else {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(getInputAmountText()).longValue()));
        }
        futureTpSlDialogShowBean.setLever(this.f43520h.n());
        futureTpSlDialogShowBean.setSymbol(this.f43520h.r());
        if (this.f43520h.j() != null) {
            futureTpSlDialogShowBean.setContractType(this.f43520h.j().getContractType());
            futureTpSlDialogShowBean.setContractCode(this.f43520h.j().getContractCode());
            futureTpSlDialogShowBean.setContractShortType(this.f43520h.j().getContractShortType());
            futureTpSlDialogShowBean.setPricePrecision(ej.f.p(this.f43520h.j().getContractCode()));
            futureTpSlDialogShowBean.setPredictProfitPrecision(ej.f.n(this.f43520h.j().getContractCode()));
            futureTpSlDialogShowBean.setContractFace(i6.m.a(this.f43520h.j().getContractFace()));
        }
        if (this.f43508d == 0) {
            FutureTpSlSettingParams E1 = E1(this.f43530k0);
            FutureTpSlSettingParams E12 = E1(this.f43533l0);
            FutureTpSlSettingDialogFragment.OpenType openType = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
            E1.setOpenType(openType);
            E12.setOpenType(openType);
            futureTpSlDialogShowBean.setStopProfitSetting(E1);
            futureTpSlDialogShowBean.setStopLossSetting(E12);
            return;
        }
        FutureTpSlSettingParams E13 = E1(this.f43536m0);
        FutureTpSlSettingParams E14 = E1(this.f43538n0);
        FutureTpSlSettingDialogFragment.OpenType openType2 = FutureTpSlSettingDialogFragment.OpenType.OpenShort;
        E13.setOpenType(openType2);
        E14.setOpenType(openType2);
        futureTpSlDialogShowBean.setStopProfitSetting(E13);
        futureTpSlDialogShowBean.setStopLossSetting(E14);
    }

    public void F2(ContractAccountInfo contractAccountInfo) {
        this.f43523i = contractAccountInfo;
        A2();
    }

    public final void G1() {
        if (this.f43548v.k()) {
            this.M0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f43548v, true, 0, 0, 80);
        }
    }

    public void G2(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment;
        int i11;
        TradeTrendView tradeTrendView = this.T;
        if (tradeTrendView != null) {
            tradeTrendView.setNewestPrice(marketCurrentPriceItem);
        }
        this.f43520h.f(false);
        String obj = this.f43550w.getText().toString();
        String b11 = marketCurrentPriceItem.b();
        if (TextUtils.isEmpty(obj) && !this.f43550w.hasFocus() && !TextUtils.equals("--", b11) && this.f43548v.getTradePriceType() == 1 && (i11 = this.f43517g) != 5) {
            if (this.f43511e == 0) {
                if (this.F0 || i11 == 6) {
                    this.D0 = true;
                    this.f43550w.setText(b11);
                }
            } else if (this.G0 || i11 == 6) {
                this.E0 = true;
                this.f43550w.setText(b11);
            }
        }
        if (!TextUtils.equals("--", b11)) {
            if (this.f43511e == 0) {
                this.F0 = false;
            } else {
                this.G0 = false;
            }
        }
        if (this.f43520h != null && (futureTpSlSettingDialogFragment = this.f43545t0) != null && futureTpSlSettingDialogFragment.isVisible()) {
            this.f43545t0.Vh(i6.m.a(String.valueOf(this.f43520h.l().z())));
        }
    }

    public final void H1(Context context, AttributeSet attributeSet) {
        this.f43551w0 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.contract_trade_layout, this, true);
        this.B0 = inflate.findViewById(R.id.rl_bond);
        this.C0 = (TextView) inflate.findViewById(R.id.tv_bond2);
        this.T = (TradeTrendView) inflate.findViewById(R.id.contract_trade_trend_view);
        x1();
        this.f43532l = (TextView) inflate.findViewById(R.id.order_type_tv);
        this.Y0 = inflate.findViewById(R.id.iv_contract_guide);
        this.f43529k = inflate.findViewById(R.id.order_type_ll);
        this.f43535m = (ImageView) inflate.findViewById(R.id.order_type_arrow_iv);
        this.f43537n = (TextView) inflate.findViewById(R.id.contract_trade_lever_value_tv);
        this.f43539o = (ImageView) inflate.findViewById(R.id.contract_trade_lever_arrow_iv);
        this.f43540p = (RelativeLayout) inflate.findViewById(R.id.contract_trade_lever_ll);
        this.f43541q = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_view_container);
        ContractTradePriceEditext contractTradePriceEditext = (ContractTradePriceEditext) inflate.findViewById(R.id.contract_trigger_price_view);
        this.f43542r = contractTradePriceEditext;
        this.f43543s = contractTradePriceEditext.getEditText();
        this.f43544t = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_convert_container);
        this.f43546u = (TextView) inflate.findViewById(R.id.contract_trigger_price_convert_tv);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.contract_trade_price_view);
        this.f43548v = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setClearEnable(true);
        this.f43550w = this.f43548v.getEditText();
        this.B = inflate.findViewById(R.id.track_price_rl);
        this.C = inflate.findViewById(R.id.call_back_rate_ll);
        this.D = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.track_price_view);
        this.E = (EditText) inflate.findViewById(R.id.call_back_rate_et);
        this.F = (ImageButton) inflate.findViewById(R.id.lighting_trade_ib);
        this.f43552x = (ViewGroup) inflate.findViewById(R.id.contract_price_convert_container);
        this.f43554y = (TextView) inflate.findViewById(R.id.contract_price_convert_tv);
        ContractTradeAmountView contractTradeAmountView = (ContractTradeAmountView) inflate.findViewById(R.id.contract_trade_amount_view);
        this.f43556z = contractTradeAmountView;
        this.A = contractTradeAmountView.getEditText();
        this.f43507c1 = (LinearLayout) inflate.findViewById(R.id.llLimitChoose);
        this.f43510d1 = (TextView) inflate.findViewById(R.id.tvLimitTitle);
        this.f43507c1.setOnClickListener(new g3(this));
        this.T0 = (MultiColorSeekBar) inflate.findViewById(R.id.contract_seekbar_new);
        this.G = (RelativeLayout) inflate.findViewById(R.id.trade_confirm_ll);
        this.H = (TextView) inflate.findViewById(R.id.trade_confirm_btn);
        this.I = (TextView) inflate.findViewById(R.id.trade_instruction_tv);
        this.J = (TextView) inflate.findViewById(R.id.trade_mask_title_tv);
        this.Q0 = (ViewGroup) inflate.findViewById(R.id.safeguard_trade_ll);
        ContractMaintenanceView contractMaintenanceView = new ContractMaintenanceView(this.f43551w0);
        this.V0 = contractMaintenanceView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) contractMaintenanceView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.V0.setLayoutParams(layoutParams);
        this.Q0.addView(this.V0);
        this.V0.h();
        this.V0.setTopMargin(84);
        this.V0.setTradeSafeguardHint(getContext().getString(R.string.n_contract_service_in_maintain_market));
        this.K = (TextView) inflate.findViewById(R.id.trade_suspend_instruction_tv);
        this.L = (LinearLayout) inflate.findViewById(R.id.stop_trade_ll);
        this.M = (TextView) inflate.findViewById(R.id.contract_vertical_amount_label_tv);
        this.R = (TextView) inflate.findViewById(R.id.input_volume_value_tv);
        this.R0 = (TextView) inflate.findViewById(R.id.contract_trade_rival_price_tv);
        this.f43549v0 = (MagicIndicator) inflate.findViewById(R.id.buy_shell_indicator);
        this.S = (ViewGroup) inflate.findViewById(R.id.contract_volume_rl);
        ContractTpslLayout contractTpslLayout = (ContractTpslLayout) inflate.findViewById(R.id.contract_tp_sl_include);
        this.U = contractTpslLayout;
        TradeType tradeType = TradeType.CONTRACT;
        contractTpslLayout.setTradeType(tradeType);
        this.V = inflate.findViewById(R.id.contract_tp_sl_switch_container);
        this.W = inflate.findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_sl_tv);
        this.f43503b0 = bottomLineTextView;
        bottomLineTextView.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.f43503b0.setTextColor(R.color.baseColorSecondaryText);
        this.f43500a0 = (CheckBox) inflate.findViewById(R.id.contract_tp_sl_switch_iv);
        this.f43506c0 = inflate.findViewById(R.id.contract_tp_sl_input_container);
        this.f43509d0 = inflate.findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) inflate.findViewById(R.id.contract_tp_input_container);
        this.f43512e0 = contractTpslEditText;
        this.f43518g0 = contractTpslEditText.getEditText();
        this.f43524i0 = this.f43512e0.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) inflate.findViewById(R.id.contract_sl_input_container);
        this.f43515f0 = contractTpslEditText2;
        this.f43521h0 = contractTpslEditText2.getEditText();
        this.f43527j0 = this.f43515f0.getClearImageView();
        k kVar = new k();
        this.f43512e0.setCallback(kVar);
        this.f43515f0.setCallback(kVar);
        this.f43501a1 = inflate.findViewById(R.id.contract_market_rl);
        this.f43504b1 = inflate.findViewById(R.id.trade_price_ll_container);
        J1();
        K1(inflate);
        P1(inflate);
        N1();
        M1();
        O1();
        L1();
        HuobiKeyboardHelper registerInput = new HuobiKeyboardHelper().attach((Activity) this.f43551w0).registerInput(this.f43543s, this.f43550w, this.E, this.f43518g0, this.f43521h0).registerInput(this.A, new n3(this));
        this.W0 = registerInput;
        this.f43542r.setKeyboardHelper(registerInput);
        this.f43556z.c(tradeType, new q());
    }

    public void H2(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(i6.m.a(str)) == 0) {
            this.f43544t.setVisibility(8);
            return;
        }
        this.f43546u.setText(AppUtil.b(String.format(this.f43551w0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f43544t.setVisibility(0);
    }

    public void I0() {
        if (this.f43548v.getTradePriceType() != 1) {
            this.f43520h.f(false);
        }
    }

    public final void I1() {
        this.f43547u0.clear();
        int i11 = this.f43511e;
        if (i11 == 0) {
            this.f43547u0.add(this.f43551w0.getString(R.string.n_contract_trade_open_more));
            this.f43547u0.add(this.f43551w0.getString(R.string.n_contract_trade_open_low));
        } else if (i11 == 1) {
            this.f43547u0.add(this.f43551w0.getString(R.string.n_contract_trade_close_more));
            this.f43547u0.add(this.f43551w0.getString(R.string.n_contract_trade_close_low));
        } else {
            this.f43547u0.add(this.f43551w0.getString(R.string.n_contract_trade_open_more));
            this.f43547u0.add(this.f43551w0.getString(R.string.n_contract_trade_open_low));
        }
    }

    public void J0() {
        this.A.setText("");
        setProgress(0);
    }

    public void J1() {
        this.f43508d = 0;
        I1();
        CommonNavigator commonNavigator = new CommonNavigator(this.f43551w0);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new r());
        this.f43549v0.setNavigator(commonNavigator);
    }

    public void K0() {
        this.I0.dismiss();
    }

    public final void K1(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vertical_depth_tv);
        this.N = textView;
        textView.setText("--");
        this.O = (ImageView) view.findViewById(R.id.vertical_depth_arrow_iv);
        this.P = view.findViewById(R.id.depth_ll);
        this.H0.setMenuItems(new ArrayList());
        this.H0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void L0() {
        if (this.f43548v.getTradePriceType() == 1) {
            this.f43514f = false;
        } else {
            this.f43520h.f(false);
        }
    }

    public final void L1() {
        this.G.setOnClickListener(new f4(this));
        this.F.setOnClickListener(new e3(this));
        this.f43542r.setOnEditTextFocusChangeListener(new y3(this));
        this.R0.setOnClickListener(new b4(this));
        this.f43543s.addTextChangedListener(new t());
        this.f43548v.setOnEditTextFocusChangeListener(new x3(this));
        this.f43548v.setOnClickListener(new f3(this));
        this.f43548v.setCallback(new u());
        this.f43550w.addTextChangedListener(new v());
        this.Y0.setOnClickListener(new o3(this));
        this.A.addTextChangedListener(new w());
        this.A.setOnFocusChangeListener(new l3(this));
        this.T.setCallback(new x());
        this.T.setNewestPriceItemViewPreDrawListener(new a());
        this.P.setOnClickListener(new d3(this));
        this.f43540p.setOnClickListener(new c4(this));
        this.Q.setOnClickListener(new g4(this));
        this.f43529k.setOnClickListener(new z3(this));
        this.J0.setDialogFragmentListener(new b());
        this.M0.setDialogFragmentListener(new c());
        this.I0.setDialogFragmentListener(new d());
        this.H0.setBottomMenuShowListener(new w3(this));
        this.H0.setBottomMenuDismissListener(new v3(this));
        this.T0.setOnProgressChangedListener(new e());
        this.f43500a0.setOnCheckedChangeListener(new p3(this));
        this.f43500a0.setOnTouchListener(new m3(this));
        this.f43503b0.setOnClickListener(k3.f53707b);
        this.f43509d0.setOnClickListener(new i3(this, new s3(this)));
        this.f43524i0.setOnClickListener(new d4(this));
        this.f43527j0.setOnClickListener(new e4(this));
        this.C.setOnClickListener(new h4(this));
        this.D.setOnClickListener(new h3(this));
        this.D.setCallback(new f());
        this.N0.setDialogFragmentListener(new g());
        this.E.addTextChangedListener(new h());
    }

    public void M0(int i11) {
        boolean z11 = true;
        if (!tg.r.x().F0() || !(ContractUserInfoProvider.i().o() == null || ContractUserInfoProvider.i().o().getActiveState() == 1)) {
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
        if (this.f43517g == 1) {
            arrayList.add(new CommonPopListItem(3, this.f43551w0.getString(R.string.n_contract_trade_optimal_five), this.f43528j1));
            arrayList.add(new CommonPopListItem(4, this.f43551w0.getString(R.string.n_contract_trade_optimal_ten), this.f43528j1));
            arrayList.add(new CommonPopListItem(5, this.f43551w0.getString(R.string.n_contract_trade_optimal_twenty), this.f43528j1));
        } else {
            arrayList.add(new CommonPopListItem(2, getBboStr(), ContextCompat.getColor(this.f43551w0, R.color.baseColorPrimaryText), this.f43528j1));
            arrayList.add(new CommonPopListItem(3, this.f43551w0.getString(R.string.n_contract_trade_optimal_five), this.f43528j1));
            arrayList.add(new CommonPopListItem(4, this.f43551w0.getString(R.string.n_contract_trade_optimal_ten), this.f43528j1));
            arrayList.add(new CommonPopListItem(5, this.f43551w0.getString(R.string.n_contract_trade_optimal_twenty), this.f43528j1));
        }
        this.M0.setData(arrayList);
    }

    public void N0(ContractDepth contractDepth, int i11) {
        String priceTick = contractDepth.getPriceTick();
        if (!TextUtils.isEmpty(priceTick)) {
            this.N.setText(i6.m.a(priceTick).stripTrailingZeros().toPlainString());
        } else {
            this.N.setText("--");
        }
    }

    public final void N1() {
        this.K0.clear();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getContext().getString(R.string.n_contract_order_type_limit), ContextCompat.getColor(this.f43551w0, R.color.baseColorPrimaryText), this.f43525i1);
        this.f43516f1 = commonPopListItem;
        this.K0.add(commonPopListItem);
        this.K0.add(new CommonPopListItem(6, getContext().getString(R.string.n_exchange_price_market_deal), ContextCompat.getColor(this.f43551w0, R.color.baseColorPrimaryText), this.f43525i1));
        this.K0.add(new CommonPopListItem(1, getContext().getString(R.string.n_contract_order_type_trigger), this.f43525i1));
        this.K0.add(new CommonPopListItem(5, getContext().getString(R.string.n_contract_track_order), this.f43525i1));
        this.K0.add(new CommonPopListItem(2, getContext().getString(R.string.n_contract_trade_post_only), this.f43525i1));
        this.J0.setData(this.K0);
        this.J0.setFollowViewWidth(true);
    }

    public void O0(int i11) {
        this.f43511e = i11;
        this.S0 = 0;
        t0();
        y1();
        I1();
        n0();
        Y0(this.f43511e);
        M0(this.f43508d);
        T0(this.f43517g);
        v1();
        C2();
    }

    public final void O1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(7, this.f43551w0.getString(R.string.n_contract_theoretical_price), ContextCompat.getColor(this.f43551w0, R.color.baseColorPrimaryText), this.f43531k1));
        arrayList.add(new CommonPopListItem(3, this.f43551w0.getString(R.string.n_contract_trade_optimal_five), this.f43531k1));
        arrayList.add(new CommonPopListItem(4, this.f43551w0.getString(R.string.n_contract_trade_optimal_ten), this.f43531k1));
        arrayList.add(new CommonPopListItem(5, this.f43551w0.getString(R.string.n_contract_trade_optimal_twenty), this.f43531k1));
        this.N0.setData(arrayList);
    }

    public void P0(String str, String str2) {
    }

    public final void P1(View view) {
        this.Q = (ImageView) view.findViewById(R.id.trend_change_iv);
        this.O0.add(new MenuItem(0, this.f43551w0.getString(R.string.n_contract_trade_trend_default), this.f43551w0.getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f43519g1));
        List<MenuItem> list = this.O0;
        String string = this.f43551w0.getString(R.string.n_contract_trade_trend_buy);
        String string2 = this.f43551w0.getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f43519g1));
        this.O0.add(new MenuItem(2, this.f43551w0.getString(R.string.n_contract_trade_trend_sell), this.f43551w0.getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.f43519g1));
        this.L0.setMenuItems(this.O0);
        this.L0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void Q0() {
        boolean z11 = getPositionType() == 0;
        this.f43556z.setData(z11);
        TradeType tradeType = TradeType.CONTRACT;
        if (!a7.e.E(tradeType)) {
            this.A.setHint(this.f43551w0.getString(R.string.n_contract_trade_input_amount));
        } else if (!z11 || !a7.e.H(tradeType)) {
            this.A.setHint(this.f43551w0.getString(R.string.n_contract_unit_amount));
        } else {
            this.A.setHint(this.f43551w0.getString(R.string.n_contract_unit_principal));
        }
        B2();
    }

    public void Q1(int i11, ContractCurrencyInfo contractCurrencyInfo) {
        if (contractCurrencyInfo != null) {
            if (contractCurrencyInfo.getContractStatus() == 5 || contractCurrencyInfo.getContractStatus() == 7) {
                this.J.setText(R.string.n_contract_trade_settling);
                this.K.setText(R.string.n_contract_trade_system_settling);
            } else if (contractCurrencyInfo.getContractStatus() == 6 || contractCurrencyInfo.getContractStatus() == 8) {
                this.J.setText(R.string.n_contract_trade_delivering);
                this.K.setText(R.string.n_contract_trade_system_delivering);
            } else if (contractCurrencyInfo.getContractStatus() == 3) {
                this.J.setText(R.string.n_contract_trade_stop);
                this.K.setText("");
            } else if (contractCurrencyInfo.getContractStatus() == 9) {
                this.J.setText(R.string.n_contract_trade_suspend);
                this.K.setText("");
            }
        }
        this.L.setVisibility(i11);
    }

    public void R0(boolean z11) {
        if (z11) {
            this.A0 = null;
            this.f43557z0 = null;
            this.f43555y0 = null;
            this.f43553x0 = null;
        } else {
            int i11 = this.f43511e;
            if (i11 == 0) {
                this.f43557z0 = null;
                this.f43553x0 = null;
            } else if (i11 == 1) {
                this.A0 = null;
                this.f43555y0 = null;
            }
        }
        this.f43550w.setText("");
        this.A.setText("");
    }

    public boolean R1() {
        if (this.f43511e == 0) {
            if (this.f43508d == 0) {
                return true;
            }
            return false;
        } else if (this.f43508d != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void S0(String str, String str2) {
        if (!this.A.getText().toString().equals(str2)) {
            this.A.setText(str2);
        }
    }

    public void T0(int i11) {
        SP.q("ContractTradeTogetherViewOrderType", i11);
        this.f43517g = i11;
        this.R0.setSelected(false);
        v1();
        M1();
        ViewUtil.m(this.f43501a1, false);
        ViewUtil.m(this.f43504b1, true);
        if (this.f43508d == 0) {
            this.U.changeTradeOrderType(this.f43517g, this.f43511e, this.f43530k0, this.f43533l0);
        } else {
            this.U.changeTradeOrderType(this.f43517g, this.f43511e, this.f43536m0, this.f43538n0);
        }
        this.f43507c1.setVisibility(8);
        switch (this.f43517g) {
            case 0:
            case 3:
            case 4:
                this.f43507c1.setVisibility(0);
                int i12 = this.f43517g;
                if (i12 == 0) {
                    this.f43510d1.setText("GTC");
                } else if (i12 == 3) {
                    this.f43510d1.setText("IOC");
                } else {
                    this.f43510d1.setText("FOK");
                }
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.f43532l.setText(getContext().getString(R.string.n_contract_order_type_limit));
                this.f43541q.setVisibility(8);
                this.R0.setVisibility(0);
                this.R0.setText(R.string.n_contract_trade_rival_price);
                this.f43548v.setPriceInputType(1);
                this.f43548v.setHintText((int) R.string.n_contract_trade_input_price);
                t1();
                break;
            case 1:
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.f43532l.setText(getContext().getString(R.string.n_contract_trade_order_type_plan));
                this.f43541q.setVisibility(0);
                this.R0.setVisibility(0);
                this.R0.setText(R.string.n_contract_trade_optimal_n);
                this.f43542r.setPriceInputType(1);
                this.f43542r.setTradeUseType(1);
                this.f43542r.setDividerVisibility(8);
                this.f43542r.setLabelVisibility(8);
                this.f43548v.setPriceInputType(1);
                this.f43548v.setHintText((int) R.string.n_contract_trade_input_price);
                w0(true, false);
                break;
            case 2:
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.f43532l.setText(getContext().getString(R.string.n_contract_trade_post_only));
                this.f43541q.setVisibility(8);
                this.R0.setVisibility(8);
                this.f43548v.setPriceInputType(1);
                this.f43548v.setHintText((int) R.string.n_contract_trade_input_price);
                t1();
                break;
            case 5:
                this.f43532l.setText(getContext().getString(R.string.n_contract_track_order));
                this.f43541q.setVisibility(8);
                this.R0.setVisibility(8);
                this.B.setVisibility(0);
                this.C.setVisibility(0);
                this.D.setPriceInputType(2);
                this.D.setCurrentPriceTypeText(this.f43551w0.getString(R.string.n_contract_trade_optimal_twenty));
                this.D.setPriceInputType(5);
                this.f43548v.setPriceInputType(1);
                this.f43548v.setHintText((int) R.string.n_contract_active_price);
                this.f43550w.setText("");
                break;
            case 6:
                this.B.setVisibility(8);
                this.C.setVisibility(8);
                this.f43532l.setText(getContext().getString(R.string.n_exchange_price_market_deal));
                this.f43541q.setVisibility(8);
                this.R0.setVisibility(0);
                this.R0.setText(R.string.n_contract_trade_rival_price);
                this.f43548v.setPriceInputType(1);
                this.f43548v.setHintText((int) R.string.n_contract_trade_input_price);
                t1();
                ViewUtil.m(this.f43501a1, true);
                ViewUtil.m(this.f43504b1, false);
                break;
        }
        t0();
        x1();
    }

    public void U0() {
        if (this.f43548v.getTradePriceType() == 1) {
            this.f43514f = false;
        } else {
            this.f43520h.f(false);
        }
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.P0.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.P0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.f43522h1));
            } else {
                this.P0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.f43522h1));
            }
        }
        this.H0.setMenuItems(this.P0);
    }

    public boolean W0() {
        return this.f43500a0.isChecked();
    }

    public void X0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.f43552x.setVisibility(8);
            return;
        }
        this.f43554y.setText(AppUtil.b(String.format(this.f43551w0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f43552x.setVisibility(0);
    }

    public void Y0(int i11) {
        if (tg.r.x().F0()) {
            ContractUserInfo.UserBean o11 = ContractUserInfoProvider.i().o();
            if (o11 != null && o11.getActiveState() != 1) {
                this.I.setVisibility(8);
                this.H.setText(R.string.n_contract_delivery_open_dm_title);
            } else if (ContractCalmPeriodHelper.d()) {
                this.I.setVisibility(8);
                this.H.setText(R.string.n_contract_calm_period_name);
            } else if (i11 == 0) {
                if (this.f43508d == 0) {
                    this.H.setText(R.string.contract_trade_buy_open_more);
                    this.I.setText(R.string.contract_trade_rise);
                } else {
                    this.H.setText(R.string.contract_trade_sell_open_low);
                    this.I.setText(R.string.contract_trade_down);
                }
                this.I.setVisibility(0);
            } else if (i11 == 1) {
                if (this.f43508d == 0) {
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
        x1();
    }

    public void a() {
        this.I0.bc(this.f43520h.r());
        this.I0.xi(this.f43520h.k());
        this.I0.vi(this.f43534l1);
        this.I0.ti(this.f43520h.n());
        this.I0.setTradeType(TradeType.CONTRACT);
        this.I0.zi(ContractWebActivity.Eh(1));
        this.I0.si(this.f43520h.j().getContractCode());
        this.I0.show(((FragmentActivity) this.f43551w0).getSupportFragmentManager(), "leverSelectDialogFragment");
    }

    public boolean b() {
        if (R1()) {
            if (this.f43530k0 == null && this.f43533l0 == null) {
                return false;
            }
            return true;
        } else if (this.f43536m0 == null && this.f43538n0 == null) {
            return false;
        } else {
            return true;
        }
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
            this.F.setEnabled(true);
            setLightingSelect(false);
            this.f43500a0.setChecked(gl.b.a(TradeType.CONTRACT));
        } else {
            this.R0.setSelected(false);
            this.R0.setEnabled(false);
            this.F.setEnabled(false);
            setLightingSelect(false);
            this.f43530k0 = null;
            this.f43533l0 = null;
            this.f43536m0 = null;
            this.f43538n0 = null;
            A1();
            z1();
            this.U.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
            this.f43500a0.setChecked(false);
        }
        C2();
    }

    public String getBondZeroDefault() {
        String r11 = this.f43520h.r();
        return BigDecimal.ZERO.setScale(FuturePrecisionUtil.g(this.f43520h.r()), 4).toPlainString() + r11;
    }

    public String getCallBackRateText() {
        return this.E.getText().toString();
    }

    public String getInputAmountText() {
        return this.A.getText().toString();
    }

    public EditText getInputPriceEt() {
        return this.f43550w;
    }

    public String getInputPriceText() {
        return this.f43550w.getText().toString();
    }

    public k4 getOnEditTextFocusChangeListener() {
        return this.U0;
    }

    public String getOrderPlaceInputAmount() {
        String obj = this.A.getText().toString();
        if (getTradeAmountType() != 0 || getPositionType() != 0) {
            return obj;
        }
        TradeType tradeType = TradeType.CONTRACT;
        return (!a7.e.E(tradeType) || !a7.e.H(tradeType)) ? obj : i6.m.a(obj).multiply(i6.m.a(this.f43520h.n())).toPlainString();
    }

    public int getOrderType() {
        return this.f43517g;
    }

    public int getPositionType() {
        return this.f43511e;
    }

    public int getSeekBarProgress() {
        return this.T0.getProgress();
    }

    public boolean getTpSlDialogOpenTypeisOpenLong() {
        return R1();
    }

    public boolean getTpSlSwitchCheck() {
        return this.f43500a0.isChecked();
    }

    public int getTradeAmountType() {
        return this.S0;
    }

    public int getTradePosition() {
        return this.f43508d;
    }

    public int getTradePriceType() {
        return this.f43548v.getTradePriceType();
    }

    public String getTriggerPriceText() {
        return this.f43543s.getText().toString();
    }

    public String getVolume() {
        String orderPlaceInputAmount = getOrderPlaceInputAmount();
        if (this.S0 != 5) {
            return orderPlaceInputAmount;
        }
        ContractAccountInfo contractAccountInfo = this.f43523i;
        if (contractAccountInfo != null) {
            return i6.m.a(contractAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.f43526j)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
        }
        return null;
    }

    public void l(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2;
        if (this.S0 == 0) {
            if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                A2();
                this.R.setText("--");
            } else if (a7.e.E(TradeType.CONTRACT)) {
                int i11 = this.f43511e;
                if (i11 != 1 && i11 != 2) {
                    bigDecimal2 = bigDecimal.setScale(ej.f.t(this.f43520h.j().getContractCode()), 1);
                } else if (bigDecimal.compareTo(BigDecimal.ONE) < 0) {
                    bigDecimal2 = bigDecimal.setScale(ej.f.t(this.f43520h.r()), 0);
                } else {
                    bigDecimal2 = bigDecimal.setScale(ej.f.t(this.f43520h.j().getContractCode()), 1);
                }
                this.R.setText(String.format(this.f43551w0.getString(R.string.trade_total_volume_value), new Object[]{bigDecimal2.toPlainString(), this.f43551w0.getString(R.string.n_contract_vol_sheet)}));
                A2();
            } else {
                BigDecimal scale = bigDecimal.setScale(ej.f.n(this.f43520h.j().getContractCode()), 1);
                this.R.setText(String.format(this.f43551w0.getString(R.string.trade_total_volume_value), new Object[]{scale.toPlainString(), this.f43520h.r().toUpperCase(Locale.US)}));
                A2();
            }
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(4);
        }
        y2();
    }

    public void n0() {
        this.f43549v0.getNavigator().notifyDataSetChanged();
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
            y1();
        }
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.X0;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            DialogUtils.b.d Q02 = new DialogUtils.b.d((FragmentActivity) oa.a.g().b()).c1(getContext().getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getContext().getString(R.string.n_known)).Q0(r3.f53744a);
            if (!TextUtils.isEmpty(str)) {
                Q02.s0(getContext().getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new q3(this, str));
            }
            HBDialogFragment k02 = Q02.k0();
            this.X0 = k02;
            k02.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "");
        }
    }

    public void q0() {
        HBDialogFragment hBDialogFragment = this.X0;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public void r0() {
        this.M0.dismiss();
        this.N0.dismiss();
    }

    public void s0() {
        for (MenuItem next : this.O0) {
            if (next.getType() == 0) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f43520h.l().S(0);
        if (com.hbg.lib.core.util.w.l()) {
            this.Q.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.Q.setImageResource(R.drawable.trade_trend_default_red_green);
        }
        this.T.c(0);
        this.f43520h.l().Y(false);
    }

    public final void s1(int i11) {
        this.f43526j = i11;
        this.W0.hideKeyboard();
        t0();
        this.S0 = 5;
        this.f43520h.N(this.f43511e, i11);
        if (this.f43511e == 0) {
            this.f43557z0 = null;
        } else {
            this.A0 = null;
        }
        y2();
    }

    public void setAmountEtText(String str) {
        this.A.setText(str);
    }

    public void setContractTradeViewController(q2 q2Var) {
        this.f43520h = q2Var;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f43513e1 = fragmentManager;
    }

    public void setHasTrade(boolean z11) {
        this.Z0 = z11;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f43514f = z11;
    }

    public void setKeyboardStateChangeListener(CustomBoardView.KeyBoardStateChangeListener keyBoardStateChangeListener) {
        this.W0.getBoardView().setKeyBoardStateChangeListener(keyBoardStateChangeListener);
    }

    public void setLeverList(List<String> list) {
        if (list != null) {
            this.I0.tc(list);
        }
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.U0 = k4Var;
    }

    public void setPriceAnimator(String str) {
        this.f43550w.setText(str);
        EditText editText = this.f43550w;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.f43550w);
    }

    public void setPriceInputType(int i11) {
        this.f43548v.setPriceInputType(i11);
    }

    public void setPriceText(String str) {
        this.f43548v.setPriceInputType(1);
        this.R0.setSelected(false);
        setLightingSelect(false);
        if (this.f43511e == 0) {
            this.D0 = false;
            this.f43553x0 = str;
        } else {
            this.f43555y0 = str;
            this.E0 = false;
        }
        int i11 = this.f43517g;
        if (i11 != 5 && i11 != 6) {
            setPriceAnimator(str);
        }
    }

    public void setProgress(int i11) {
        this.T0.setProgress((float) i11);
    }

    public void setTradePosition(int i11) {
        this.f43508d = i11;
    }

    public void setTriggerPriceTypeView(int i11) {
        this.f43542r.setDividerVisibility(8);
        this.f43542r.setLabelVisibility(8);
    }

    public void setViewVisibility(int i11) {
        setVisibility(i11);
    }

    public void t0() {
        this.f43550w.clearFocus();
        this.A.clearFocus();
        this.f43543s.clearFocus();
    }

    public final void t1() {
        int i11 = this.f43508d;
        if (i11 == 0) {
            if (this.f43511e == 0) {
                L0();
            } else {
                U0();
            }
        } else if (i11 == 1) {
            if (this.f43511e == 0) {
                U0();
            } else {
                L0();
            }
        }
        w0(true, false);
    }

    public void u0(boolean z11, boolean z12) {
        if (z11) {
            this.f43530k0 = null;
            this.f43533l0 = null;
            this.f43536m0 = null;
            this.f43538n0 = null;
        } else if (this.f43508d == 0) {
            this.f43530k0 = null;
            this.f43533l0 = null;
        } else {
            this.f43536m0 = null;
            this.f43538n0 = null;
        }
        A1();
        z1();
        this.U.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        if (z12) {
            this.f43500a0.setChecked(false);
        }
    }

    public String u1(boolean z11) {
        if (!tg.r.x().F0() || this.f43520h == null) {
            return "--";
        }
        try {
            FutureEarnestMoneyUtils f11 = FutureEarnestMoneyUtils.f();
            boolean z12 = true;
            f11.i(this.f43551w0).t(getVolume()).q(this.R0).h(a7.e.E(this.f43520h.o())).r(this.f43520h.o()).l(this.f43520h.n()).u(this.f43520h.r()).k(this.f43520h.j().getContractFace()).o(FuturePrecisionUtil.g(this.f43520h.r())).g(BigDecimal.valueOf(this.f43520h.l().v()).toPlainString()).j(getInputPriceText()).m(BigDecimal.valueOf(this.f43520h.l().z()).toPlainString()).p(BigDecimal.valueOf(this.f43520h.l().A()).toPlainString()).n(this.f43517g == 6);
            if (this.S0 != 5) {
                z12 = false;
            }
            return f11.a(z11, z12);
        } catch (FutureEarnestMoneyUtils.ZeroErr e11) {
            e11.printStackTrace();
            return getBondZeroDefault();
        }
    }

    public void v0() {
        this.f43537n.setText("--");
        this.f43537n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f43539o.setImageResource(0);
    }

    public final void v1() {
        setLightingSelect(false);
    }

    public void w0(boolean z11, boolean z12) {
        if (this.f43548v.getTradePriceType() == 1) {
            if (this.f43511e == 0 && !TextUtils.isEmpty(this.f43553x0)) {
                this.f43550w.setText(this.f43553x0);
            } else if (this.f43511e != 1 || TextUtils.isEmpty(this.f43555y0)) {
                this.f43550w.setText("");
            } else {
                this.f43550w.setText(this.f43555y0);
            }
        }
        if (z11) {
            this.f43543s.setText("");
            this.E.setText("");
        }
        if (z12 && this.f43517g != 5) {
            this.f43548v.setPriceInputType(1);
            this.R0.setSelected(false);
            setLightingSelect(false);
        }
        if (this.f43511e == 0 && !TextUtils.isEmpty(this.f43557z0)) {
            this.A.setText(this.f43557z0);
        } else if (this.f43511e != 1 || TextUtils.isEmpty(this.A0)) {
            this.A.setText("");
        } else {
            this.A.setText(this.A0);
        }
        setProgress(0);
        this.R.setText("--");
        A2();
        this.W0.hideKeyboard();
    }

    public final void w1(int i11) {
        this.f43508d = i11;
        Y0(this.f43511e);
        M0(this.f43508d);
    }

    public void x0(String str) {
        this.f43537n.setText(String.format(this.f43551w0.getString(R.string.contract_lever), new Object[]{str}));
        if (this.I0.isResumed()) {
            this.f43539o.setImageResource(R.drawable.trade_arrow_up);
        } else {
            this.f43539o.setImageResource(R.drawable.trade_arrow_down);
        }
        if (i6.m.a(str).compareTo(BigDecimal.TEN) >= 0) {
            this.f43537n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        } else {
            this.f43537n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        }
    }

    public final void x1() {
        getViewTreeObserver().addOnPreDrawListener(new i());
    }

    public final FutureTpSlSettingParams x2(FutureTpSlSettingParams futureTpSlSettingParams, boolean z11) {
        if (futureTpSlSettingParams == null) {
            if (z11) {
                A1();
            } else {
                z1();
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

    public final void y1() {
        if (this.f43511e == 0) {
            if (this.D0) {
                this.f43550w.setText("");
            }
            this.F0 = true;
            return;
        }
        if (this.E0) {
            this.f43550w.setText("");
        }
        this.G0 = true;
    }

    public final void y2() {
        boolean z11 = false;
        if (this.f43511e == 0) {
            this.B0.setVisibility(0);
        } else {
            this.B0.setVisibility(8);
        }
        TextView textView = this.C0;
        if (this.f43511e == 0) {
            z11 = true;
        }
        textView.setText(u1(z11));
    }

    public void z0(boolean z11) {
        this.G.setEnabled(z11);
    }

    public final void z1() {
        this.f43521h0.setText("");
    }

    public final void z2(View view, boolean z11) {
        if (!z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        } else if (R1()) {
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

    public ContractTradeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43502b = "coin_contract";
        this.f43505c = "contract_trade";
        this.f43517g = 0;
        this.f43547u0 = new ArrayList();
        this.D0 = true;
        this.E0 = true;
        this.F0 = true;
        this.G0 = true;
        this.H0 = new BottomMenuFragment();
        this.I0 = new LeverSelectDialogFragment();
        this.J0 = new CommonListPopupDialog();
        this.K0 = new ArrayList();
        this.L0 = new BottomMenuFragment();
        this.M0 = new CommonListPopupDialog();
        this.N0 = new CommonListPopupDialog();
        this.O0 = new ArrayList();
        this.P0 = new ArrayList();
        this.f43519g1 = new j();
        this.f43522h1 = new l();
        this.f43525i1 = new m();
        this.f43528j1 = new n();
        this.f43531k1 = new o();
        this.f43534l1 = new p();
        H1(context, attributeSet);
    }
}
