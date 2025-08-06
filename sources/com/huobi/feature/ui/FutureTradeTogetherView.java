package com.huobi.feature.ui;

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
import com.amazonaws.services.s3.model.InstructionFileId;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.ui.TradeTrendView;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FeatureTradeTimeInfo;
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
import com.huobi.feature.util.FutureEarnestMoneyUtils;
import com.huobi.feature.util.MarketTwTradeStateObservable;
import com.huobi.guide.helper.ContractGuideHelper;
import com.huobi.linearswap.bean.ContractLastPriceEvent;
import com.huobi.trade.bean.MarketBuySellItem;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.utils.m0;
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
import java.util.Observer;
import k6.b;
import k6.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import org.greenrobot.eventbus.EventBus;
import pk.a1;
import pk.b0;
import pk.b1;
import pk.c0;
import pk.c1;
import pk.d0;
import pk.d1;
import pk.e0;
import pk.e1;
import pk.f0;
import pk.f1;
import pk.g0;
import pk.g1;
import pk.h0;
import pk.h1;
import pk.i0;
import pk.i1;
import pk.j0;
import pk.j1;
import pk.k0;
import pk.l0;
import pk.n0;
import pk.o0;
import pk.p0;
import pk.q0;
import pk.r0;
import pk.s0;
import pk.t0;
import pk.u0;
import pk.v0;
import pk.w0;
import pk.x0;
import pk.y0;
import pk.z0;
import pro.huobi.R;
import rx.Observable;

public class FutureTradeTogetherView extends FrameLayout implements a, m0<LinearSwapAccountInfo>, Observer {
    public EditText A;
    public View A0;
    public final CommonPopListItem.a A1;
    public ImageButton B;
    public ContractTpslEditText B0;
    public final LeverSelectDialogFragment.h B1;
    public ViewGroup C;
    public ContractTpslEditText C0;
    public TextView D;
    public EditText D0;
    public ContractTradeAmountView E;
    public EditText E0;
    public EditText F;
    public ImageView F0;
    public TextView G;
    public ImageView G0;
    public TextView H;
    public TextView H0;
    public LinearLayout I;
    public ContractMarketTwTradeLayout I0;
    public RelativeLayout J;
    public int J0;
    public RelativeLayout K;
    public FutureTpSlSettingParams K0;
    public TextView L;
    public FutureTpSlSettingParams L0;
    public TextView M;
    public FutureTpSlSettingDialogFragment.OpenType M0;
    public TextView N;
    public FutureTpSlSettingDialogFragment N0;
    public TextView O;
    public Context O0;
    public LinearLayout P;
    public String P0;
    public RelativeLayout Q;
    public String Q0;
    public TextView R;
    public String R0;
    public TextView S;
    public String S0;
    public TextView T;
    public boolean T0;
    public ImageView U;
    public boolean U0;
    public View V;
    public boolean V0;
    public ImageView W;
    public boolean W0;
    public BottomMenuFragment X0;
    public LeverSelectDialogFragment Y0;
    public List<String> Z0;

    /* renamed from: a0  reason: collision with root package name */
    public ImageView f44787a0;

    /* renamed from: a1  reason: collision with root package name */
    public CommonListPopupDialog f44788a1;

    /* renamed from: b  reason: collision with root package name */
    public String f44789b;

    /* renamed from: b0  reason: collision with root package name */
    public ViewGroup f44790b0;

    /* renamed from: b1  reason: collision with root package name */
    public final List<CommonPopListItem> f44791b1;

    /* renamed from: c  reason: collision with root package name */
    public String f44792c;

    /* renamed from: c0  reason: collision with root package name */
    public TextView f44793c0;

    /* renamed from: c1  reason: collision with root package name */
    public BottomMenuFragment f44794c1;

    /* renamed from: d  reason: collision with root package name */
    public int f44795d;

    /* renamed from: d0  reason: collision with root package name */
    public TextView f44796d0;

    /* renamed from: d1  reason: collision with root package name */
    public CommonListPopupDialog f44797d1;

    /* renamed from: e  reason: collision with root package name */
    public int f44798e;

    /* renamed from: e0  reason: collision with root package name */
    public TradeTrendView f44799e0;

    /* renamed from: e1  reason: collision with root package name */
    public CommonListPopupDialog f44800e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44801f;

    /* renamed from: f0  reason: collision with root package name */
    public int f44802f0;

    /* renamed from: f1  reason: collision with root package name */
    public final List<MenuItem> f44803f1;

    /* renamed from: g  reason: collision with root package name */
    public int f44804g;

    /* renamed from: g0  reason: collision with root package name */
    public MultiColorSeekBar f44805g0;

    /* renamed from: g1  reason: collision with root package name */
    public final List<MenuItem> f44806g1;

    /* renamed from: h  reason: collision with root package name */
    public LinearSwapAccountInfo f44807h;

    /* renamed from: h0  reason: collision with root package name */
    public TextView f44808h0;

    /* renamed from: h1  reason: collision with root package name */
    public ViewGroup f44809h1;

    /* renamed from: i  reason: collision with root package name */
    public AccountBalanceInfoV5 f44810i;

    /* renamed from: i0  reason: collision with root package name */
    public TextView f44811i0;

    /* renamed from: i1  reason: collision with root package name */
    public TextView f44812i1;

    /* renamed from: j  reason: collision with root package name */
    public nk.e f44813j;

    /* renamed from: j0  reason: collision with root package name */
    public View f44814j0;

    /* renamed from: j1  reason: collision with root package name */
    public k4 f44815j1;

    /* renamed from: k  reason: collision with root package name */
    public View f44816k;

    /* renamed from: k0  reason: collision with root package name */
    public View f44817k0;

    /* renamed from: k1  reason: collision with root package name */
    public AbstractMaintenanceView f44818k1;

    /* renamed from: l  reason: collision with root package name */
    public TextView f44819l;

    /* renamed from: l0  reason: collision with root package name */
    public TextView f44820l0;

    /* renamed from: l1  reason: collision with root package name */
    public HuobiKeyboardHelper f44821l1;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f44822m;

    /* renamed from: m0  reason: collision with root package name */
    public TextView f44823m0;

    /* renamed from: m1  reason: collision with root package name */
    public HBDialogFragment f44824m1;

    /* renamed from: n  reason: collision with root package name */
    public TextView f44825n;

    /* renamed from: n0  reason: collision with root package name */
    public TextView f44826n0;

    /* renamed from: n1  reason: collision with root package name */
    public final TradeType f44827n1;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f44828o;

    /* renamed from: o1  reason: collision with root package name */
    public View f44829o1;

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f44830p;

    /* renamed from: p1  reason: collision with root package name */
    public boolean f44831p1;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup f44832q;

    /* renamed from: q1  reason: collision with root package name */
    public View f44833q1;

    /* renamed from: r  reason: collision with root package name */
    public ContractTradePriceEditext f44834r;

    /* renamed from: r1  reason: collision with root package name */
    public View f44835r1;

    /* renamed from: s  reason: collision with root package name */
    public EditText f44836s;

    /* renamed from: s1  reason: collision with root package name */
    public LinearLayout f44837s1;

    /* renamed from: t  reason: collision with root package name */
    public ViewGroup f44838t;

    /* renamed from: t0  reason: collision with root package name */
    public TextView f44839t0;

    /* renamed from: t1  reason: collision with root package name */
    public TextView f44840t1;

    /* renamed from: u  reason: collision with root package name */
    public TextView f44841u;

    /* renamed from: u0  reason: collision with root package name */
    public ContractTpslLayout f44842u0;

    /* renamed from: u1  reason: collision with root package name */
    public FragmentManager f44843u1;

    /* renamed from: v  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44844v;

    /* renamed from: v0  reason: collision with root package name */
    public View f44845v0;

    /* renamed from: v1  reason: collision with root package name */
    public CommonPopListItem f44846v1;

    /* renamed from: w  reason: collision with root package name */
    public EditText f44847w;

    /* renamed from: w0  reason: collision with root package name */
    public View f44848w0;

    /* renamed from: w1  reason: collision with root package name */
    public final MenuItemOnClickListener f44849w1;

    /* renamed from: x  reason: collision with root package name */
    public View f44850x;

    /* renamed from: x0  reason: collision with root package name */
    public CheckBox f44851x0;

    /* renamed from: x1  reason: collision with root package name */
    public MenuItemOnClickListener f44852x1;

    /* renamed from: y  reason: collision with root package name */
    public View f44853y;

    /* renamed from: y0  reason: collision with root package name */
    public BottomLineTextView f44854y0;

    /* renamed from: y1  reason: collision with root package name */
    public final CommonPopListItem.a f44855y1;

    /* renamed from: z  reason: collision with root package name */
    public ContractGearsTradePriceEditText f44856z;

    /* renamed from: z0  reason: collision with root package name */
    public View f44857z0;

    /* renamed from: z1  reason: collision with root package name */
    public final CommonPopListItem.a f44858z1;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            String m11;
            if (editable.length() == 0) {
                int unused = FutureTradeTogetherView.this.f44802f0 = 0;
            }
            String obj = editable.toString();
            if (FutureTradeTogetherView.this.f44802f0 == 0) {
                if (FutureTradeTogetherView.this.f44798e == 0) {
                    String unused2 = FutureTradeTogetherView.this.R0 = obj;
                } else {
                    String unused3 = FutureTradeTogetherView.this.S0 = obj;
                }
            }
            if (editable.length() == 0) {
                FutureTradeTogetherView.this.F.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.getContext(), R.font.roboto_regular));
                FutureTradeTogetherView.this.x2("0");
                return;
            }
            FutureTradeTogetherView.this.F.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.getContext(), R.font.roboto_medium));
            String str = null;
            if (!a7.e.E(FutureTradeTogetherView.this.f44827n1) && !a7.e.G(FutureTradeTogetherView.this.f44827n1)) {
                if (FutureTradeTogetherView.this.f44802f0 == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = i6.m.b(editable, 10, FuturePrecisionUtil.B());
                    }
                }
                if (str != null) {
                    FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
                    futureTradeTogetherView.L2(futureTradeTogetherView.F, str);
                    return;
                }
            } else if (FutureTradeTogetherView.this.f44802f0 == 0 && (m11 = FutureTradeTogetherView.this.f44813j.m(editable)) != null) {
                FutureTradeTogetherView futureTradeTogetherView2 = FutureTradeTogetherView.this;
                futureTradeTogetherView2.L2(futureTradeTogetherView2.F, m11);
                return;
            }
            FutureTradeTogetherView.this.f44813j.k(false, true);
            FutureTradeTogetherView.this.B2();
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
                FutureTradeTogetherView.this.l1(i11);
            }
        }
    }

    public class c implements TradeTrendView.b {
        public c() {
        }

        public void a(c.a aVar) {
            if (FutureTradeTogetherView.this.f44813j.o() != null) {
                FutureTradeTogetherView.this.setPriceText(i6.m.i(aVar.a(), FuturePrecisionUtil.y(FutureTradeTogetherView.this.f44813j.o().getContractCode(), FutureTradeTogetherView.this.f44813j.o().getContractShortType(), (String) null)));
            }
            FutureTradeTogetherView.this.t0();
            FutureTradeTogetherView.this.f44821l1.hideKeyboard();
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
            if (FutureTradeTogetherView.this.f44813j.o() != null) {
                FutureTradeTogetherView.this.setPriceText(i6.m.m(aVar.b(), FuturePrecisionUtil.y(FutureTradeTogetherView.this.f44813j.o().getContractCode(), FutureTradeTogetherView.this.f44813j.o().getContractShortType(), (String) null)));
            }
        }
    }

    public class d implements ViewTreeObserver.OnPreDrawListener {
        public d() {
        }

        public boolean onPreDraw() {
            int d11 = FutureTradeTogetherView.this.f44799e0.d();
            FutureTradeTogetherView.this.f44799e0.l(d11 / 2, d11);
            return true;
        }
    }

    public class e implements BaseDialogFragment.c {
        public e() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeTogetherView.this.f44822m.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeTogetherView.this.f44822m.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class f implements ContractGearsTradePriceEditText.c {
        public f() {
        }

        public void a() {
            FutureTradeTogetherView.this.G1();
            FutureTradeTogetherView.this.f44800e1.showAsDropDown(((FragmentActivity) FutureTradeTogetherView.this.getContext()).getSupportFragmentManager(), (View) FutureTradeTogetherView.this.f44856z, true, 0, 0, 80);
        }

        public void b() {
        }
    }

    public class g implements TextWatcher {
        public g() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                FutureTradeTogetherView.this.A.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.getContext(), R.font.roboto_regular));
            } else {
                FutureTradeTogetherView.this.A.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            if (i6.m.b(editable, 10, 1) != null) {
                FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
                futureTradeTogetherView.L2(futureTradeTogetherView.A, editable.toString());
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
            FutureTradeTogetherView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int d11 = FutureTradeTogetherView.this.f44799e0.d();
            FutureTradeTogetherView.this.f44799e0.l(d11 / 2, d11);
            return true;
        }
    }

    public class i implements MenuItemOnClickListener {
        public i() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : FutureTradeTogetherView.this.f44803f1) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            if (i11 == 0) {
                FutureTradeTogetherView.this.f44813j.p().j(0);
                if (com.hbg.lib.core.util.w.l()) {
                    FutureTradeTogetherView.this.W.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    FutureTradeTogetherView.this.W.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                if (FutureTradeTogetherView.this.f44799e0 != null) {
                    FutureTradeTogetherView.this.f44799e0.c(0);
                }
            } else if (i11 == 1) {
                FutureTradeTogetherView.this.f44813j.p().j(1);
                if (com.hbg.lib.core.util.w.l()) {
                    FutureTradeTogetherView.this.W.setImageResource(R.drawable.trade_trend_red);
                } else {
                    FutureTradeTogetherView.this.W.setImageResource(R.drawable.trade_trend_green);
                }
                if (FutureTradeTogetherView.this.f44799e0 != null) {
                    FutureTradeTogetherView.this.f44799e0.c(1);
                }
            } else {
                FutureTradeTogetherView.this.f44813j.p().j(2);
                if (com.hbg.lib.core.util.w.l()) {
                    FutureTradeTogetherView.this.W.setImageResource(R.drawable.trade_trend_green);
                } else {
                    FutureTradeTogetherView.this.W.setImageResource(R.drawable.trade_trend_red);
                }
                if (FutureTradeTogetherView.this.f44799e0 != null) {
                    FutureTradeTogetherView.this.f44799e0.c(2);
                }
            }
            FutureTradeTogetherView.this.f44813j.p().l(false);
            if (FutureTradeTogetherView.this.f44794c1 != null) {
                FutureTradeTogetherView.this.f44794c1.dismiss();
            }
        }
    }

    public class j implements BaseDialogFragment.c {
        public j() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeTogetherView.this.f44828o.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeTogetherView.this.f44828o.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class k implements ContractTpslEditText.c {
        public k() {
        }

        public void afterTextChanged(EditText editText, String str) {
            if (editText == FutureTradeTogetherView.this.D0) {
                FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
                FutureTpSlSettingParams unused = futureTradeTogetherView.K0 = FutureTpSlSettingParams.changeTpSlCache(futureTradeTogetherView.K0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
            } else if (editText == FutureTradeTogetherView.this.E0) {
                FutureTradeTogetherView futureTradeTogetherView2 = FutureTradeTogetherView.this;
                FutureTpSlSettingParams unused2 = futureTradeTogetherView2.L0 = FutureTpSlSettingParams.changeTpSlCache(futureTradeTogetherView2.L0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
            }
        }

        public int getTradePricePrecision() {
            if (FutureTradeTogetherView.this.f44813j.o() != null) {
                return FuturePrecisionUtil.y(FutureTradeTogetherView.this.f44813j.o().getContractCode(), FutureTradeTogetherView.this.f44813j.o().getContractShortType(), (String) null);
            }
            return 14;
        }
    }

    public class l implements MenuItemOnClickListener {
        public l() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (FutureTradeTogetherView.this.f44813j.p() != null) {
                FutureTradeTogetherView.this.f44813j.p().b(i11);
            }
            if (FutureTradeTogetherView.this.X0 != null) {
                FutureTradeTogetherView.this.X0.dismiss();
                BottomMenuFragment unused = FutureTradeTogetherView.this.X0 = null;
            }
        }
    }

    public class m implements CommonPopListItem.a {
        public m() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            if (FutureTradeTogetherView.this.f44788a1 != null) {
                FutureTradeTogetherView.this.f44788a1.dismiss();
            }
            int type = commonPopListItem.getType();
            if (type == FutureTradeTogetherView.this.f44804g) {
                return;
            }
            if (type != 0 || (FutureTradeTogetherView.this.f44804g != 3 && FutureTradeTogetherView.this.f44804g != 4)) {
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                if (type != 7) {
                    FutureTradeTogetherView.this.T0(type);
                } else if (!tg.r.x().F0()) {
                    sn.f.f(FutureTradeTogetherView.this.f44827n1, FutureTradeTogetherView.this.O0);
                } else if (z6.l.c().g(FutureTradeTogetherView.this.f44827n1) == null) {
                    HuobiToastUtil.j(R.string.n_contract_account_loading);
                } else if (!z6.l.c().i(FutureTradeTogetherView.this.f44827n1)) {
                    HuobiToastUtil.j(R.string.n_contract_please_open_first);
                } else {
                    TimeOrderFragment.th(FutureTradeTogetherView.this.u1(), FutureTradeTogetherView.this.f44810i).show(fragmentActivity.getSupportFragmentManager(), "");
                }
                if (type != 0) {
                    if (type == 1) {
                        ContractGuideHelper.b(fragmentActivity, 4);
                        return;
                    } else if (!(type == 2 || type == 3 || type == 4 || type == 6)) {
                        return;
                    }
                }
                if (!FutureTradeTogetherView.this.f44831p1) {
                    ContractGuideHelper.b(fragmentActivity, 1);
                }
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == FutureTradeTogetherView.this.f44804g || (commonPopListItem.getType() == 0 && (FutureTradeTogetherView.this.f44804g == 3 || FutureTradeTogetherView.this.f44804g == 4));
        }
    }

    public class n implements CommonPopListItem.a {
        public n() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            FutureTradeTogetherView.this.f44844v.setPriceInputType(commonPopListItem.getType());
            FutureTradeTogetherView.this.f44844v.setCurrentPriceTypeText(commonPopListItem.getText());
            if (FutureTradeTogetherView.this.f44797d1 != null) {
                FutureTradeTogetherView.this.f44797d1.dismiss();
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return FutureTradeTogetherView.this.f44844v.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class o implements CommonPopListItem.a {
        public o() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            FutureTradeTogetherView.this.f44856z.setPriceInputType(commonPopListItem.getType());
            FutureTradeTogetherView.this.f44856z.setCurrentPriceTypeText(commonPopListItem.getText());
            if (FutureTradeTogetherView.this.f44800e1 != null) {
                FutureTradeTogetherView.this.f44800e1.dismiss();
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return FutureTradeTogetherView.this.f44856z.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class p implements LeverSelectDialogFragment.h {
        public p() {
        }

        public void N0() {
            if (FutureTradeTogetherView.this.f44813j != null) {
                FutureTradeTogetherView.this.f44813j.y().N0();
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return uc.b.d(tradeType, str, i11);
        }

        public void P0(String str) {
            FutureTradeTogetherView.this.x0(str);
            FutureTradeTogetherView.this.f44813j.K(str);
            FutureTradeTogetherView.this.f44813j.F();
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return FutureTradeTogetherView.this.f44813j.l(str, levelAvailableMarginInfo);
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            if (FutureTradeTogetherView.this.f44813j == null) {
                return true;
            }
            FutureTradeTogetherView.this.f44813j.E(leverSelectDialogFragment, str);
            return true;
        }
    }

    public class q implements ContractTradeAmountView.a {
        public q() {
        }

        public String o0() {
            return FutureTradeTogetherView.this.f44813j.v();
        }
    }

    public class r implements BaseDialogFragment.c {
        public r() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeTogetherView.this.f44844v.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeTogetherView.this.f44844v.p(R.drawable.trade_arrow_up);
        }
    }

    public class s implements BaseDialogFragment.c {
        public s() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            FutureTradeTogetherView.this.f44856z.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            FutureTradeTogetherView.this.f44856z.p(R.drawable.trade_arrow_up);
        }
    }

    public class t extends BaseSubscriber<FutureUserInfo> {
        public t() {
        }

        /* renamed from: a */
        public void onNext(FutureUserInfo futureUserInfo) {
            super.onNext(futureUserInfo);
            FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
            futureTradeTogetherView.p1(futureTradeTogetherView.f44795d);
        }
    }

    public class u extends BaseSubscriber<FutureUserInfo> {
        public u() {
        }

        /* renamed from: a */
        public void onNext(FutureUserInfo futureUserInfo) {
            super.onNext(futureUserInfo);
            FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
            futureTradeTogetherView.p1(futureTradeTogetherView.f44795d);
        }
    }

    public class v implements TextWatcher {
        public v() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                FutureTradeTogetherView.this.f44836s.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.f44836s.getContext(), R.font.roboto_regular));
            } else {
                FutureTradeTogetherView.this.f44836s.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.f44836s.getContext(), R.font.roboto_medium));
            }
            FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
            futureTradeTogetherView.O2(futureTradeTogetherView.f44813j.q(editable.toString()));
            String str = null;
            if (FutureTradeTogetherView.this.f44813j.o() != null) {
                str = i6.m.b(editable, 10, FuturePrecisionUtil.y(FutureTradeTogetherView.this.f44813j.o().getContractCode(), FutureTradeTogetherView.this.f44813j.o().getContractShortType(), (String) null));
            }
            if (str != null) {
                FutureTradeTogetherView futureTradeTogetherView2 = FutureTradeTogetherView.this;
                futureTradeTogetherView2.L2(futureTradeTogetherView2.f44836s, editable.toString());
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
            FutureTradeTogetherView.this.A1();
        }

        public void b() {
            FutureTradeTogetherView.this.A1();
        }
    }

    public class x implements TextWatcher {
        public x() {
        }

        public void afterTextChanged(Editable editable) {
            int tradePriceType = FutureTradeTogetherView.this.getTradePriceType();
            if (editable.length() == 0) {
                FutureTradeTogetherView.this.f44847w.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.getContext(), R.font.roboto_regular));
                FutureTradeTogetherView.this.x2("0");
            } else {
                FutureTradeTogetherView.this.f44847w.setTypeface(ResourcesCompat.h(FutureTradeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            FutureTradeTogetherView futureTradeTogetherView = FutureTradeTogetherView.this;
            futureTradeTogetherView.X0(futureTradeTogetherView.f44813j.q(editable.toString()));
            String str = null;
            if (tradePriceType == 1 && FutureTradeTogetherView.this.f44813j.o() != null) {
                str = i6.m.b(editable, 10, FuturePrecisionUtil.y(FutureTradeTogetherView.this.f44813j.o().getContractCode(), FutureTradeTogetherView.this.f44813j.o().getContractShortType(), (String) null));
            }
            if (str != null) {
                FutureTradeTogetherView futureTradeTogetherView2 = FutureTradeTogetherView.this;
                futureTradeTogetherView2.L2(futureTradeTogetherView2.f44847w, editable.toString());
                return;
            }
            if (FutureTradeTogetherView.this.f44798e == 0) {
                if (FutureTradeTogetherView.this.f44847w.hasFocus()) {
                    boolean unused = FutureTradeTogetherView.this.T0 = false;
                }
                if (FutureTradeTogetherView.this.f44804g != 5) {
                    String unused2 = FutureTradeTogetherView.this.P0 = editable.toString();
                }
            } else {
                if (FutureTradeTogetherView.this.f44847w.hasFocus()) {
                    boolean unused3 = FutureTradeTogetherView.this.U0 = false;
                }
                if (FutureTradeTogetherView.this.f44804g != 5) {
                    String unused4 = FutureTradeTogetherView.this.Q0 = editable.toString();
                }
            }
            FutureTradeTogetherView.this.f44813j.j(false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public FutureTradeTogetherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I1(int i11) {
        if (i11 == 0) {
            T0(0);
            this.f44846v1.setType(0);
        } else if (i11 == 1) {
            T0(3);
            this.f44846v1.setType(3);
        } else {
            T0(4);
            this.f44846v1.setType(4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void J1(View view) {
        if (this.f44843u1 != null) {
            LimitChooseDialog vh2 = LimitChooseDialog.vh();
            Bundle bundle = new Bundle();
            int i11 = this.f44804g;
            bundle.putInt("selIndex", i11 == 0 ? 0 : i11 == 3 ? 1 : 2);
            vh2.setArguments(bundle);
            vh2.wh(new w0(this)).show(this.f44843u1, "limitChoose");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean K1(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        sn.f.f(this.f44827n1, getContext());
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1(View view, boolean z11) {
        C2(this.f44844v, z11);
        this.f44815j1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void M1(View view) {
        A1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N1(View view, boolean z11) {
        C2(this.E, z11);
        if (z11) {
            setProgress(0);
            if (this.f44802f0 == 5) {
                this.F.setText("");
            }
            this.f44802f0 = 0;
        }
        this.f44815j1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O1() {
        this.U.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P1() {
        this.U.setImageResource(R.drawable.trade_arrow_down_new);
        this.X0 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Q1(View view) {
        if (!this.f44813j.p().h()) {
            BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
            this.X0 = bottomMenuFragment;
            bottomMenuFragment.setMenuItems(this.f44806g1);
            this.X0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
            this.X0.setBottomMenuShowListener(new a1(this));
            this.X0.setBottomMenuDismissListener(new z0(this));
            this.X0.show(((Activity) this.O0).getFragmentManager(), "depthBottomMenuFragment");
        }
        this.f44821l1.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void R1(View view) {
        this.f44821l1.hideKeyboard();
        this.f44813j.O();
        gs.g.j(this.f44792c, this.f44789b, "lever_adjust", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S1() {
        this.f44794c1 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void T1(View view) {
        BottomMenuFragment bottomMenuFragment = new BottomMenuFragment();
        this.f44794c1 = bottomMenuFragment;
        bottomMenuFragment.setMenuItems(this.f44803f1);
        this.f44794c1.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
        this.f44794c1.setBottomMenuDismissListener(new y0(this));
        this.f44794c1.show(((Activity) this.O0).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U1() {
        this.f44788a1 = null;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void V1(View view) {
        this.f44844v.clearFocus();
        this.f44821l1.hideKeyboard();
        CommonListPopupDialog commonListPopupDialog = new CommonListPopupDialog();
        this.f44788a1 = commonListPopupDialog;
        commonListPopupDialog.setDialogFragmentListener(new e());
        this.f44788a1.setDialogDismissListener(new r0(this));
        this.f44788a1.setData(this.f44791b1);
        this.f44788a1.setFollowViewWidth(true);
        this.f44788a1.showAsDropDown(((FragmentActivity) this.O0).getSupportFragmentManager(), this.f44816k);
        gs.g.j(this.f44792c, this.f44789b, "entrust_model", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void W1(View view) {
        ContractGuideHelper.d(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), FutureTradeTogetherView.class.getName(), ContractGuideHelper.a(this.f44804g));
        gs.g.j(this.f44792c, this.f44789b, "entrust_model_explanation", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void X1(CompoundButton compoundButton, boolean z11) {
        gl.b.b(this.f44827n1, z11);
        HashMap hashMap = new HashMap();
        if (z11) {
            this.f44857z0.setVisibility(0);
            this.A0.setVisibility(0);
            q1();
            hashMap.put("button_type", "open");
            gs.g.j(this.f44792c, this.f44789b, "stop_surplus_loss", (HashMap) null);
        } else {
            this.H0.setVisibility(8);
            this.f44857z0.setVisibility(8);
            this.A0.setVisibility(8);
            u0(true, false);
            q1();
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "same_screen");
        gs.g.i("take_profit_and_stop_loss_switch_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Y1(View view, MotionEvent motionEvent) {
        if (!tg.r.x().F0()) {
            ContractModuleConfig.a().h(this.f44827n1, getContext());
            return true;
        } else if (z6.l.c().i(this.f44827n1)) {
            return false;
        } else {
            HuobiToastUtil.j(R.string.n_contract_please_open_first);
            return true;
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Z1(View view) {
        ContractGuideHelper.b((FragmentActivity) oa.a.g().b(), 2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a2(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        this.K0 = u2(futureTpSlSettingParams, true);
        FutureTpSlSettingParams u22 = u2(futureTpSlSettingParams2, false);
        this.L0 = u22;
        this.f44842u0.refreshTpSlView(this.K0, u22);
        H2();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void b2(FutureTpSlSettingDialogFragment.c cVar, View view) {
        if (TextUtils.isEmpty(this.f44813j.r())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!I2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f44821l1.hideKeyboard();
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = new FutureTpSlDialogShowBean();
            futureTpSlDialogShowBean.setTradeType(this.f44827n1);
            z1(futureTpSlDialogShowBean);
            FutureTpSlSettingDialogFragment Kh = FutureTpSlSettingDialogFragment.Kh(futureTpSlDialogShowBean);
            this.N0 = Kh;
            Kh.Vh(i6.m.a(String.valueOf(this.f44813j.p().e())));
            this.N0.Uh(cVar);
            this.N0.show(((FragmentActivity) this.O0).getSupportFragmentManager(), "FutureTpSettingDialogFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void c2(View view) {
        this.K0 = null;
        t1();
        if (this.L0 == null) {
            this.H0.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d2(View view) {
        this.L0 = null;
        s1();
        if (this.K0 == null) {
            this.H0.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e2(View view) {
        sn.f.f(this.f44827n1, this.O0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void f2(View view) {
        G1();
        this.f44800e1.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f44856z, true, 0, 0, 80);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
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
        this.f44821l1.hideKeyboard();
        if (!tg.r.x().F0()) {
            sn.f.f(this.f44827n1, this.O0);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (z6.l.c().g(this.f44827n1) == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            z6.l.c().d(this.f44827n1, false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new t());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!z6.l.c().i(this.f44827n1)) {
            qk.m.d(getContext(), true, this.f44827n1);
            if (TradeType.isLinearSwap(this.f44827n1)) {
                gs.g.i("App_linear_swap_open_click", (HashMap) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f44813j.Q(v1(true));
            HashMap hashMap = new HashMap();
            hashMap.put("hold_model", "double");
            gs.g.j(this.f44789b, (String) null, this.f44798e == 0 ? "buy_open" : "buy_flat", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i2(View view) {
        this.f44821l1.hideKeyboard();
        if (z6.l.c().g(this.f44827n1) == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            z6.l.c().d(this.f44827n1, false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new u());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!z6.l.c().i(this.f44827n1)) {
            qk.m.d(getContext(), true, this.f44827n1);
            if (TradeType.isLinearSwap(this.f44827n1)) {
                gs.g.i("App_linear_swap_open_click", (HashMap) null);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f44813j.Q(v1(false));
            HashMap hashMap = new HashMap();
            hashMap.put("hold_model", "double");
            gs.g.j(this.f44789b, (String) null, this.f44798e == 0 ? "sell_open" : "sell_flat", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j2(View view, boolean z11) {
        C2(this.f44834r, z11);
        this.f44815j1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void l2(View view) {
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ImageButton imageButton = this.B;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.B.isSelected()) {
            this.f44821l1.hideKeyboard();
            this.f44844v.setCurrentPriceTypeText(this.O0.getString(R.string.contract_trade_position_close_quick));
            this.f44844v.setPriceInputType(6);
            this.f44847w.setText("");
        } else {
            this.f44844v.setPriceInputType(1);
            this.f44813j.j(false);
        }
        setLightingSelect(this.B.isSelected());
        this.f44812i1.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void m2(View view) {
        int i11;
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.f44812i1.isSelected() && ((i11 = this.f44804g) == 0 || i11 == 3 || i11 == 4)) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_spot_order_risk)).C0(getContext().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
        TextView textView = this.f44812i1;
        textView.setSelected(!textView.isSelected());
        if (this.f44844v.k()) {
            this.f44844v.setPriceInputType(1);
            this.f44813j.j(false);
        } else {
            if (this.f44847w.hasFocus()) {
                this.f44821l1.hideKeyboard();
            }
            if (this.f44804g == 1) {
                this.f44844v.setCurrentPriceTypeText(this.O0.getString(R.string.n_contract_trade_optimal_five));
                this.f44844v.setPriceInputType(3);
            } else {
                this.f44844v.setCurrentPriceTypeText(getBboStr());
                this.f44844v.setPriceInputType(2);
            }
            this.f44847w.setText("");
        }
        setLightingSelect(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o2() {
        this.f44797d1 = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p2() {
        this.f44800e1 = null;
    }

    public static /* synthetic */ void q2(HBDialogFragment hBDialogFragment) {
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r2(String str, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Rh((Activity) getContext(), str);
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s2() {
        this.Y0 = null;
    }

    private void setLightingSelect(boolean z11) {
        this.B.setSelected(z11);
        if (z11) {
            setProgress(100);
            l1(100);
        } else if (this.f44844v.getLastTradePriceType() == 6) {
            setProgress(0);
            if (this.f44798e == 0) {
                this.F.setText(this.R0);
            } else {
                this.F.setText(this.S0);
            }
        }
        B2();
    }

    private void setSlText(String str) {
        this.E0.setText(str);
    }

    private void setTpText(String str) {
        this.D0.setText(str);
    }

    public void A0(int i11) {
        ViewGroup viewGroup = this.f44809h1;
        if (viewGroup != null) {
            viewGroup.setVisibility(i11);
            this.f44818k1.setUI(this.f44813j.y());
            this.f44818k1.setCountDownTime(bj.d.n(this.f44827n1));
        }
    }

    public final void A1() {
        if (this.f44844v.k()) {
            E1();
            this.f44797d1.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f44844v, true, 0, 0, 80);
        }
    }

    public void A2(List<CouponReturn> list, boolean z11) {
        int i11 = 8;
        if (CollectionsUtils.b(list)) {
            this.Q.setVisibility(8);
            return;
        }
        this.Q.setVisibility(0);
        ImageView imageView = this.f44787a0;
        if (z11) {
            i11 = 0;
        }
        imageView.setVisibility(i11);
        this.f44796d0.setText(String.format(getResources().getString(R.string.n_exchange_coupon_available_number), new Object[]{list.size() + ""}));
    }

    public final void B1(Context context, AttributeSet attributeSet) {
        this.O0 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.contract_trade_together_layout, this, true);
        dn.a.d().i((TextView) inflate.findViewById(R.id.account_available_label_tv));
        this.f44799e0 = (TradeTrendView) inflate.findViewById(R.id.contract_trade_trend_view);
        q1();
        this.f44819l = (TextView) inflate.findViewById(R.id.order_type_tv);
        this.f44829o1 = inflate.findViewById(R.id.iv_contract_guide);
        this.f44816k = inflate.findViewById(R.id.order_type_ll);
        this.f44822m = (ImageView) inflate.findViewById(R.id.order_type_arrow_iv);
        this.f44825n = (TextView) inflate.findViewById(R.id.contract_trade_lever_value_tv);
        this.f44828o = (ImageView) inflate.findViewById(R.id.contract_trade_lever_arrow_iv);
        this.f44830p = (RelativeLayout) inflate.findViewById(R.id.contract_trade_lever_ll);
        this.f44837s1 = (LinearLayout) inflate.findViewById(R.id.llLimitChoose);
        this.f44840t1 = (TextView) inflate.findViewById(R.id.tvLimitTitle);
        this.f44837s1.setOnClickListener(new j1(this));
        this.f44832q = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_view_container);
        ContractTradePriceEditext contractTradePriceEditext = (ContractTradePriceEditext) inflate.findViewById(R.id.contract_trigger_price_view);
        this.f44834r = contractTradePriceEditext;
        contractTradePriceEditext.setTradeType(this.f44827n1);
        this.f44836s = this.f44834r.getEditText();
        this.f44838t = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_convert_container);
        this.f44841u = (TextView) inflate.findViewById(R.id.contract_trigger_price_convert_tv);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.contract_trade_price_view);
        this.f44844v = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setTradeType(this.f44827n1);
        this.f44844v.setClearEnable(true);
        this.f44847w = this.f44844v.getEditText();
        this.f44850x = inflate.findViewById(R.id.track_price_rl);
        this.f44853y = inflate.findViewById(R.id.call_back_rate_ll);
        this.f44856z = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.track_price_view);
        this.A = (EditText) inflate.findViewById(R.id.call_back_rate_et);
        this.B = (ImageButton) inflate.findViewById(R.id.lighting_trade_ib);
        this.C = (ViewGroup) inflate.findViewById(R.id.contract_price_convert_container);
        this.D = (TextView) inflate.findViewById(R.id.contract_price_convert_tv);
        ContractTradeAmountView contractTradeAmountView = (ContractTradeAmountView) inflate.findViewById(R.id.contract_trade_amount_view);
        this.E = contractTradeAmountView;
        this.F = contractTradeAmountView.getEditText();
        this.G = (TextView) inflate.findViewById(R.id.trade_mask_title_tv);
        this.f44809h1 = (ViewGroup) inflate.findViewById(R.id.safeguard_trade_ll);
        AbstractMaintenanceView p11 = AbstractMaintenanceView.p(context, this.f44827n1);
        this.f44818k1 = p11;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) p11.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f44818k1.setLayoutParams(layoutParams);
        this.f44809h1.addView(this.f44818k1);
        this.f44818k1.setTopMargin(84);
        this.f44818k1.h();
        this.f44818k1.setTradeSafeguardHint(a7.e.B(this.f44827n1, context));
        this.H = (TextView) inflate.findViewById(R.id.trade_suspend_instruction_tv);
        this.I = (LinearLayout) inflate.findViewById(R.id.stop_trade_ll);
        this.R = (TextView) inflate.findViewById(R.id.contract_vertical_amount_label_tv);
        this.S = (TextView) inflate.findViewById(R.id.contract_vertical_price_label_tv);
        this.f44790b0 = (ViewGroup) inflate.findViewById(R.id.contract_input_volume_value_container);
        this.f44793c0 = (TextView) inflate.findViewById(R.id.input_volume_value_tv);
        this.Q = (RelativeLayout) inflate.findViewById(R.id.contract_coupon_rl);
        this.f44796d0 = (TextView) inflate.findViewById(R.id.contract_coupon_value_tv);
        this.f44787a0 = (ImageView) inflate.findViewById(R.id.contract_coupon_red_iv);
        this.J = (RelativeLayout) inflate.findViewById(R.id.trade_long_ll);
        this.K = (RelativeLayout) inflate.findViewById(R.id.trade_short_ll);
        this.L = (TextView) inflate.findViewById(R.id.trade_long_confirm_btn);
        this.M = (TextView) inflate.findViewById(R.id.trade_short_confirm_btn);
        this.N = (TextView) inflate.findViewById(R.id.trade_long_instruction_tv);
        this.O = (TextView) inflate.findViewById(R.id.trade_short_instruction_tv);
        this.P = (LinearLayout) inflate.findViewById(R.id.llshort_value);
        this.f44808h0 = (TextView) inflate.findViewById(R.id.long_value_tv);
        this.f44811i0 = (TextView) inflate.findViewById(R.id.long_value_tv1);
        this.f44814j0 = inflate.findViewById(R.id.ll_bond);
        this.f44817k0 = inflate.findViewById(R.id.ll_bond2);
        this.f44820l0 = (TextView) inflate.findViewById(R.id.tv_bond);
        this.f44823m0 = (TextView) inflate.findViewById(R.id.tv_bond2);
        this.f44826n0 = (TextView) inflate.findViewById(R.id.short_value_tv);
        this.f44839t0 = (TextView) inflate.findViewById(R.id.short_value_tv1);
        this.f44805g0 = (MultiColorSeekBar) inflate.findViewById(R.id.contract_seekbar_new);
        this.f44833q1 = inflate.findViewById(R.id.contract_market_rl);
        this.f44835r1 = inflate.findViewById(R.id.trade_price_ll_container);
        this.f44812i1 = (TextView) inflate.findViewById(R.id.contract_trade_rival_price_tv);
        ContractTpslLayout contractTpslLayout = (ContractTpslLayout) inflate.findViewById(R.id.contract_tp_sl_include);
        this.f44842u0 = contractTpslLayout;
        contractTpslLayout.setTradeType(this.f44827n1);
        this.f44845v0 = inflate.findViewById(R.id.contract_tp_sl_switch_container);
        this.f44848w0 = inflate.findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_sl_tv);
        this.f44854y0 = bottomLineTextView;
        bottomLineTextView.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.f44854y0.setTextColor(R.color.baseColorSecondaryText);
        this.f44851x0 = (CheckBox) inflate.findViewById(R.id.contract_tp_sl_switch_iv);
        this.f44857z0 = inflate.findViewById(R.id.contract_tp_sl_input_container);
        this.A0 = inflate.findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) inflate.findViewById(R.id.contract_tp_input_container);
        this.B0 = contractTpslEditText;
        this.D0 = contractTpslEditText.getEditText();
        this.F0 = this.B0.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) inflate.findViewById(R.id.contract_sl_input_container);
        this.C0 = contractTpslEditText2;
        this.E0 = contractTpslEditText2.getEditText();
        this.G0 = this.C0.getClearImageView();
        k kVar = new k();
        this.B0.setCallback(kVar);
        this.C0.setCallback(kVar);
        this.H0 = (TextView) inflate.findViewById(R.id.tp_sl_tag_tv);
        this.I0 = (ContractMarketTwTradeLayout) inflate.findViewById(R.id.contract_market_twtrade_rl);
        HuobiKeyboardHelper registerInput = new HuobiKeyboardHelper().attach((Activity) this.O0).registerInput(this.f44836s, this.f44847w, this.A, this.D0, this.E0);
        this.f44821l1 = registerInput;
        registerInput.registerInput(this.F, new n0(this));
        TradeType tradeType = this.f44827n1;
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        if (tradeType == tradeType2) {
            this.f44828o.setVisibility(0);
            this.f44825n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
            this.S.setText(R.string.n_exchange_order_list_price);
        } else {
            this.f44828o.setVisibility(0);
            this.f44825n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
            this.S.setText(R.string.n_contract_trade_trend_trigger_price);
        }
        C1(inflate);
        H1(inflate);
        F1();
        D1();
        this.E.c(tradeType2, new q());
    }

    public final void B2() {
        if (this.f44798e == 0) {
            this.f44814j0.setVisibility(0);
            this.f44817k0.setVisibility(0);
        } else {
            this.f44814j0.setVisibility(8);
            this.f44817k0.setVisibility(8);
        }
        this.f44820l0.setText(n1(true));
        this.f44823m0.setText(n1(false));
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.f44799e0;
        if (tradeTrendView != null) {
            tradeTrendView.setBuyList(list);
        }
    }

    public final void C1(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vertical_depth_tv);
        this.T = textView;
        textView.setText("--");
        this.U = (ImageView) view.findViewById(R.id.vertical_depth_arrow_iv);
        this.V = view.findViewById(R.id.depth_ll);
    }

    public final void C2(View view, boolean z11) {
        if (z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    public final void D1() {
        this.J.setOnClickListener(new f0(this));
        this.K.setOnClickListener(new i1(this));
        this.f44834r.setOnEditTextFocusChangeListener(new b1(this));
        this.B.setOnClickListener(new g0(this));
        this.f44812i1.setOnClickListener(new e0(this));
        this.f44836s.addTextChangedListener(new v());
        this.f44844v.setOnEditTextFocusChangeListener(new c1(this));
        this.f44844v.setOnClickListener(new e1(this));
        this.f44844v.setCallback(new w());
        this.f44847w.addTextChangedListener(new x());
        this.F.setOnFocusChangeListener(new k0(this));
        this.F.addTextChangedListener(new a());
        this.f44805g0.setOnProgressChangedListener(new b());
        this.f44799e0.setCallback(new c());
        this.f44799e0.setNewestPriceItemViewPreDrawListener(new d());
        this.V.setOnClickListener(new f1(this));
        this.f44830p.setOnClickListener(new c0(this));
        this.W.setOnClickListener(new h1(this));
        this.f44816k.setOnClickListener(new b0(this));
        this.f44829o1.setOnClickListener(new g1(this));
        this.f44851x0.setOnCheckedChangeListener(new o0(this));
        this.f44851x0.setOnTouchListener(new l0(this));
        this.f44854y0.setOnClickListener(i0.f53093b);
        this.A0.setOnClickListener(new h0(this, new v0(this)));
        this.F0.setOnClickListener(new d0(this));
        this.G0.setOnClickListener(new x0(this));
        this.f44853y.setOnClickListener(new d1(this));
        this.f44856z.setOnClickListener(new pk.m0(this));
        this.f44856z.setCallback(new f());
        this.A.addTextChangedListener(new g());
        this.f44796d0.setOnClickListener(j0.f53098b);
    }

    public final void D2(String str, String str2) {
        this.f44808h0.setText(this.O0.getString(R.string.n_contract_contract_open_long));
        TextView textView = this.f44811i0;
        if (!TextUtils.equals("--", str)) {
            str = AppUtil.b(str, str2);
        }
        textView.setText(str);
        B2();
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.f44799e0;
        if (tradeTrendView != null) {
            tradeTrendView.setSellList(list);
        }
    }

    public final void E1() {
        CommonListPopupDialog commonListPopupDialog = new CommonListPopupDialog();
        this.f44797d1 = commonListPopupDialog;
        commonListPopupDialog.setDialogFragmentListener(new r());
        this.f44797d1.setDialogDismissListener(new q0(this));
        ArrayList arrayList = new ArrayList();
        if (this.f44804g == 1) {
            arrayList.add(new CommonPopListItem(3, this.O0.getString(R.string.n_contract_trade_optimal_five), this.f44858z1));
            arrayList.add(new CommonPopListItem(4, this.O0.getString(R.string.n_contract_trade_optimal_ten), this.f44858z1));
            arrayList.add(new CommonPopListItem(5, this.O0.getString(R.string.n_contract_trade_optimal_twenty), this.f44858z1));
        } else {
            arrayList.add(new CommonPopListItem(2, getBboStr(), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f44858z1));
            arrayList.add(new CommonPopListItem(3, this.O0.getString(R.string.n_contract_trade_optimal_five), this.f44858z1));
            arrayList.add(new CommonPopListItem(4, this.O0.getString(R.string.n_contract_trade_optimal_ten), this.f44858z1));
            arrayList.add(new CommonPopListItem(5, this.O0.getString(R.string.n_contract_trade_optimal_twenty), this.f44858z1));
        }
        this.f44797d1.setData(arrayList);
    }

    public final void E2() {
        if (a7.e.E(this.f44827n1)) {
            if (TextUtils.isEmpty(this.f44813j.v())) {
                this.R.setText(R.string.n_contract_trade_input_amount);
                return;
            }
            this.R.setText(String.format(this.O0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f44813j.v()}));
        } else if (!a7.e.G(this.f44827n1)) {
            this.R.setText(String.format(this.O0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.O0.getString(R.string.n_contract_vol_sheet)}));
        } else if (TextUtils.isEmpty(this.f44813j.v())) {
            this.R.setText(R.string.n_contract_trade_input_amount);
        } else {
            this.R.setText(String.format(this.O0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{"usdt".toUpperCase(Locale.US)}));
        }
    }

    public final void F1() {
        this.f44791b1.clear();
        boolean z11 = false;
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getContext().getString(R.string.n_contract_order_type_limit), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f44855y1);
        this.f44846v1 = commonPopListItem;
        this.f44791b1.add(commonPopListItem);
        this.f44791b1.add(new CommonPopListItem(6, getContext().getString(R.string.n_exchange_price_market_deal), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.f44855y1));
        this.f44791b1.add(new CommonPopListItem(1, getContext().getString(R.string.n_contract_order_type_trigger), this.f44855y1));
        this.f44791b1.add(new CommonPopListItem(5, getContext().getString(R.string.n_contract_track_order), this.f44855y1));
        this.f44791b1.add(new CommonPopListItem(2, getContext().getString(R.string.n_contract_trade_post_only), this.f44855y1));
        qk.a b11 = qk.a.b();
        nk.e eVar = this.f44813j;
        if (eVar != null && eVar.B()) {
            z11 = true;
        }
        b11.i(z11);
        if (qk.a.b().f()) {
            this.f44791b1.add(new CommonPopListItem(7, this.O0.getString(R.string.n_exchange_timing_deal), this.f44855y1));
        }
    }

    public final void F2(int i11, String str, String str2) {
        this.f44808h0.setText(getResources().getString(i11));
        TextView textView = this.f44811i0;
        if (!TextUtils.equals("--", str)) {
            str = AppUtil.b(str, str2);
        }
        textView.setText(str);
        B2();
    }

    public final void G1() {
        CommonListPopupDialog commonListPopupDialog = new CommonListPopupDialog();
        this.f44800e1 = commonListPopupDialog;
        commonListPopupDialog.setDialogFragmentListener(new s());
        this.f44800e1.setDialogDismissListener(new s0(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(7, this.O0.getString(R.string.n_contract_theoretical_price), ContextCompat.getColor(this.O0, R.color.baseColorPrimaryText), this.A1));
        arrayList.add(new CommonPopListItem(3, this.O0.getString(R.string.n_contract_trade_optimal_five), this.A1));
        arrayList.add(new CommonPopListItem(4, this.O0.getString(R.string.n_contract_trade_optimal_ten), this.A1));
        arrayList.add(new CommonPopListItem(5, this.O0.getString(R.string.n_contract_trade_optimal_twenty), this.A1));
        this.f44800e1.setData(arrayList);
    }

    public final void G2(int i11, String str, String str2) {
        this.f44826n0.setText(getResources().getString(i11));
        TextView textView = this.f44839t0;
        if (!TextUtils.equals("--", str)) {
            str = AppUtil.b(str, str2);
        }
        textView.setText(str);
        B2();
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment;
        int i11;
        TradeTrendView tradeTrendView = this.f44799e0;
        if (tradeTrendView != null) {
            tradeTrendView.setNewestPrice(marketCurrentPriceItem);
        }
        this.f44813j.j(false);
        String obj = this.f44847w.getText().toString();
        String b11 = marketCurrentPriceItem.b();
        if (TextUtils.isEmpty(obj) && !this.f44847w.hasFocus() && !TextUtils.equals("--", b11) && this.f44844v.getTradePriceType() == 1 && (i11 = this.f44804g) != 5) {
            if (this.f44798e == 0) {
                if (this.V0 || i11 == 6) {
                    this.T0 = true;
                    this.f44847w.setText(b11);
                }
            } else if (this.W0 || i11 == 6) {
                this.U0 = true;
                this.f44847w.setText(b11);
            }
        }
        if (!TextUtils.equals("--", b11)) {
            if (this.f44798e == 0) {
                this.V0 = false;
            } else {
                this.W0 = false;
            }
        }
        if (this.f44813j != null && (futureTpSlSettingDialogFragment = this.N0) != null && futureTpSlSettingDialogFragment.isVisible()) {
            this.N0.Vh(i6.m.a(String.valueOf(this.f44813j.p().e())));
        }
    }

    public final void H1(View view) {
        this.W = (ImageView) view.findViewById(R.id.trend_change_iv);
        this.f44803f1.add(new MenuItem(0, this.O0.getString(R.string.n_contract_trade_trend_default), this.O0.getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f44849w1));
        List<MenuItem> list = this.f44803f1;
        String string = this.O0.getString(R.string.n_contract_trade_trend_buy);
        String string2 = this.O0.getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f44849w1));
        this.f44803f1.add(new MenuItem(2, this.O0.getString(R.string.n_contract_trade_trend_sell), this.O0.getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.f44849w1));
    }

    public final void H2() {
    }

    public void I0() {
        if (this.f44844v.getTradePriceType() != 1) {
            this.f44813j.j(false);
        }
    }

    public final boolean I2() {
        BigDecimal a11 = i6.m.a(getInputPriceText());
        if (getTradePriceType() != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            return this.f44813j.P(v1(w2()));
        }
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.input_unknow_text), new Object[]{this.f44847w.getHint().toString()}));
        return false;
    }

    public void J0() {
        this.F.setText("");
        setProgress(0);
    }

    public void J2(LinearSwapAccountInfo linearSwapAccountInfo) {
        this.f44807h = linearSwapAccountInfo;
        B2();
        t2();
    }

    public void K0() {
        LeverSelectDialogFragment leverSelectDialogFragment = this.Y0;
        if (leverSelectDialogFragment != null) {
            leverSelectDialogFragment.dismiss();
            this.Y0 = null;
        }
    }

    public void K2(AccountBalanceInfoV5 accountBalanceInfoV5) {
        this.f44810i = accountBalanceInfoV5;
        B2();
        t2();
    }

    public void L0() {
        if (this.f44844v.getTradePriceType() == 1) {
            this.f44801f = false;
        } else {
            this.f44813j.j(false);
        }
    }

    public void L2(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public void M0(int i11) {
        boolean z11 = true;
        if (!tg.r.x().F0() || !(z6.l.c().g(this.f44827n1) == null || z6.l.c().g(this.f44827n1).getActiveState() == 1)) {
            this.J.setBackgroundResource(R.drawable.shape_contract_login);
        } else if (ContractCalmPeriodHelper.d()) {
            this.J.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
            this.K.setBackgroundResource(R.drawable.common_un_enable_radius_selector);
        } else {
            RelativeLayout relativeLayout = this.J;
            boolean l11 = com.hbg.lib.core.util.w.l();
            int i12 = R.drawable.trade_btn_sell_selector;
            relativeLayout.setBackgroundResource(l11 ? R.drawable.trade_btn_sell_selector : R.drawable.trade_btn_buy_selector);
            RelativeLayout relativeLayout2 = this.K;
            if (com.hbg.lib.core.util.w.l()) {
                i12 = R.drawable.trade_btn_buy_selector;
            }
            relativeLayout2.setBackgroundResource(i12);
        }
        MultiConfigBuilder configBuilder = this.f44805g0.getConfigBuilder();
        Context context = getContext();
        boolean g11 = NightHelper.e().g();
        if (this.f44798e != 0) {
            z11 = false;
        }
        configBuilder.colorConfig(context, g11, z11).build();
    }

    public final void M2() {
        if (!qk.a.b().e() || this.f44804g != 6 || !this.f44813j.B()) {
            this.I0.setVisibility(8);
        } else {
            this.I0.setVisibility(0);
            this.I0.setChecked(qk.a.b().d());
        }
        this.I0.setMarketTwTradeAmountLimit(qk.a.b().c());
    }

    public void N0(ContractDepth contractDepth, int i11) {
        String priceTick = contractDepth.getPriceTick();
        if (!TextUtils.isEmpty(priceTick)) {
            this.T.setText(i6.m.a(priceTick).stripTrailingZeros().toPlainString());
        } else {
            this.T.setText("--");
        }
    }

    public void N2() {
        CommonListPopupDialog commonListPopupDialog = this.f44788a1;
        if (commonListPopupDialog != null) {
            commonListPopupDialog.dismiss();
        }
        F1();
        M2();
    }

    public void O0(int i11) {
        this.f44798e = i11;
        this.f44802f0 = 0;
        t0();
        r1();
        n0();
        Y0(this.f44798e);
        M0(this.f44795d);
        T0(this.f44804g);
        o1();
    }

    public void O2(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(i6.m.a(str)) == 0) {
            this.f44838t.setVisibility(8);
            return;
        }
        this.f44841u.setText(AppUtil.b(String.format(this.O0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f44838t.setVisibility(0);
    }

    public void P0(String str, String str2) {
        String v11 = this.f44813j.v();
        boolean E2 = a7.e.E(this.f44827n1);
        boolean G2 = a7.e.G(this.f44827n1);
        if (E2 || G2) {
            int i11 = this.f44798e;
            if (i11 == 0) {
                if (G2) {
                    Locale locale = Locale.US;
                    D2(str, "usdt".toUpperCase(locale));
                    G2(R.string.n_contract_contract_open_short, str2, "usdt".toUpperCase(locale));
                    return;
                }
                F2(R.string.n_contract_contract_open_long, str, v11);
                G2(R.string.n_contract_contract_open_short, str2, v11);
            } else if (i11 != 1) {
            } else {
                if (G2) {
                    Locale locale2 = Locale.US;
                    F2(R.string.n_contract_trade_can_close_short, str, "usdt".toUpperCase(locale2));
                    G2(R.string.n_contract_trade_can_close_long, str2, "usdt".toUpperCase(locale2));
                    return;
                }
                F2(R.string.n_contract_trade_can_close_short, str, v11);
                G2(R.string.n_contract_trade_can_close_long, str2, v11);
            }
        } else {
            int i12 = this.f44798e;
            if (i12 == 0) {
                D2(str, getResources().getString(R.string.contract_trade_unit_sheet));
                G2(R.string.n_contract_contract_open_short, str2, getResources().getString(R.string.contract_trade_unit_sheet));
            } else if (i12 == 1) {
                F2(R.string.n_contract_trade_can_close_short, str, this.O0.getString(R.string.n_contract_vol_sheet));
                G2(R.string.n_contract_trade_can_close_long, str2, this.O0.getString(R.string.n_contract_vol_sheet));
            }
        }
    }

    public void Q0() {
        boolean z11 = getPositionType() == 0;
        this.E.setData(z11);
        if (a7.e.E(this.f44827n1)) {
            this.F.setHint(this.O0.getString(R.string.n_contract_trade_input_amount));
        } else if (!z11 || !a7.e.H(this.f44827n1)) {
            this.F.setHint(this.O0.getString(R.string.n_contract_unit_amount));
        } else {
            this.F.setHint(this.O0.getString(R.string.n_contract_unit_principal));
        }
        E2();
    }

    public void R0(boolean z11) {
        if (z11) {
            this.S0 = null;
            this.R0 = null;
            this.Q0 = null;
            this.P0 = null;
        } else {
            int i11 = this.f44798e;
            if (i11 == 0) {
                this.R0 = null;
                this.P0 = null;
            } else if (i11 == 1) {
                this.S0 = null;
                this.Q0 = null;
            }
        }
        this.f44847w.setText("");
        this.F.setText("");
    }

    public void S0(String str, String str2) {
        if (this.f44798e == 1) {
            this.F.setText(str);
        } else if (!this.F.getText().toString().equals(str2)) {
            this.F.setText(str2);
        }
    }

    public void T0(int i11) {
        SP.q("FutureTradeTogetherViewOrderType", i11);
        this.f44804g = i11;
        this.f44812i1.setSelected(false);
        o1();
        ViewUtil.m(this.f44833q1, false);
        ViewUtil.m(this.f44835r1, true);
        this.f44842u0.changeTradeOrderType(this.f44804g, this.f44798e, this.K0, this.L0);
        this.f44837s1.setVisibility(8);
        switch (this.f44804g) {
            case 0:
            case 3:
            case 4:
                this.f44837s1.setVisibility(0);
                int i12 = this.f44804g;
                if (i12 == 0) {
                    this.f44840t1.setText("GTC");
                } else if (i12 == 3) {
                    this.f44840t1.setText("IOC");
                } else {
                    this.f44840t1.setText("FOK");
                    this.f44812i1.setSelected(false);
                }
                this.f44850x.setVisibility(8);
                this.f44853y.setVisibility(8);
                this.f44819l.setText(getContext().getString(R.string.n_contract_order_type_limit));
                this.f44832q.setVisibility(8);
                this.f44812i1.setVisibility(0);
                this.f44812i1.setText(R.string.n_contract_trade_rival_price);
                this.f44844v.setPriceInputType(1);
                this.f44844v.setHintText((int) R.string.n_contract_trade_input_price);
                m1();
                break;
            case 1:
                this.f44850x.setVisibility(8);
                this.f44853y.setVisibility(8);
                this.f44819l.setText(getContext().getString(R.string.n_contract_order_type_trigger));
                this.f44832q.setVisibility(0);
                this.f44812i1.setVisibility(0);
                this.f44812i1.setText(R.string.n_contract_trade_optimal_n);
                this.f44834r.setPriceInputType(1);
                this.f44834r.setTradeUseType(1);
                this.f44834r.setDividerVisibility(8);
                this.f44834r.setLabelVisibility(8);
                this.f44844v.setPriceInputType(1);
                this.f44844v.setHintText((int) R.string.n_contract_trade_input_price);
                w0(true, false);
                break;
            case 2:
                this.f44850x.setVisibility(8);
                this.f44853y.setVisibility(8);
                this.f44819l.setText(getContext().getString(R.string.n_contract_trade_post_only));
                this.f44832q.setVisibility(8);
                this.f44812i1.setVisibility(8);
                this.f44844v.setPriceInputType(1);
                this.f44844v.setHintText((int) R.string.n_contract_trade_input_price);
                m1();
                break;
            case 5:
                this.f44819l.setText(getContext().getString(R.string.n_contract_track_order));
                this.f44832q.setVisibility(8);
                this.f44812i1.setVisibility(8);
                this.f44850x.setVisibility(0);
                this.f44853y.setVisibility(0);
                this.f44856z.setPriceInputType(2);
                this.f44856z.setCurrentPriceTypeText(this.O0.getString(R.string.n_contract_trade_optimal_twenty));
                this.f44856z.setPriceInputType(5);
                this.f44844v.setPriceInputType(1);
                this.f44844v.setHintText((int) R.string.n_contract_active_price);
                this.f44847w.setText("");
                break;
            case 6:
                this.f44850x.setVisibility(8);
                this.f44853y.setVisibility(8);
                this.f44819l.setText(getContext().getString(R.string.n_exchange_price_market_deal));
                this.f44832q.setVisibility(8);
                this.f44812i1.setVisibility(0);
                this.f44812i1.setText(R.string.n_contract_trade_rival_price);
                this.f44844v.setPriceInputType(1);
                this.f44844v.setHintText((int) R.string.n_contract_trade_input_price);
                m1();
                ViewUtil.m(this.f44833q1, true);
                ViewUtil.m(this.f44835r1, false);
                break;
            case 7:
                this.f44819l.setText(this.O0.getString(R.string.n_exchange_timing_deal));
                break;
        }
        t0();
        q1();
        M2();
    }

    public void U0() {
        if (this.f44844v.getTradePriceType() == 1) {
            this.f44801f = false;
        } else {
            this.f44813j.j(false);
        }
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.f44806g1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.f44806g1.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.f44852x1));
            } else {
                this.f44806g1.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.f44852x1));
            }
        }
    }

    public boolean W0() {
        return this.f44798e == 0 && this.f44851x0.isChecked();
    }

    public void X0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.C.setVisibility(8);
            return;
        }
        this.D.setText(AppUtil.b(String.format(this.O0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.C.setVisibility(0);
    }

    public void Y0(int i11) {
        if (!tg.r.x().F0()) {
            this.P.setVisibility(8);
            this.K.setVisibility(8);
            this.L.setText(R.string.n_contract_trade_log_in_to_exchange);
            this.N.setVisibility(8);
            q1();
            return;
        }
        FutureUserInfo g11 = z6.l.c().g(this.f44827n1);
        if (g11 == null || g11.getActiveState() == 1) {
            this.P.setVisibility(0);
            this.K.setVisibility(0);
            if (ContractCalmPeriodHelper.d()) {
                this.M.setText(R.string.n_contract_calm_period_name);
                this.L.setText(R.string.n_contract_calm_period_name);
                this.N.setVisibility(8);
                this.O.setVisibility(8);
            } else if (i11 == 0) {
                this.L.setText(R.string.contract_trade_buy_open_more);
                this.N.setText(R.string.contract_trade_rise);
                this.M.setText(R.string.contract_trade_sell_open_low);
                this.O.setText(R.string.contract_trade_down);
                this.N.setVisibility(0);
                this.O.setVisibility(0);
            } else if (i11 == 1) {
                this.M.setText(R.string.contract_trade_sell_flat_more);
                this.L.setText(R.string.contract_trade_buy_flat_empty);
                this.N.setVisibility(8);
                this.O.setVisibility(8);
            }
            q1();
            return;
        }
        this.P.setVisibility(8);
        this.K.setVisibility(8);
        this.L.setText(a7.e.x(this.f44827n1, getContext()));
        this.N.setVisibility(8);
        q1();
    }

    public void c(int i11) {
        if (i11 != 0) {
            if (i11 != 1) {
                if (i11 == 2) {
                    if (com.hbg.lib.core.util.w.l()) {
                        this.W.setImageResource(R.drawable.trade_trend_green);
                    } else {
                        this.W.setImageResource(R.drawable.trade_trend_red);
                    }
                }
            } else if (com.hbg.lib.core.util.w.l()) {
                this.W.setImageResource(R.drawable.trade_trend_red);
            } else {
                this.W.setImageResource(R.drawable.trade_trend_green);
            }
        } else if (com.hbg.lib.core.util.w.l()) {
            this.W.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.W.setImageResource(R.drawable.trade_trend_default_red_green);
        }
    }

    public void d(boolean z11) {
        if (z11) {
            this.f44812i1.setEnabled(true);
            this.B.setEnabled(true);
            setLightingSelect(false);
            this.f44851x0.setChecked(gl.b.a(this.f44827n1));
            return;
        }
        this.f44812i1.setSelected(false);
        this.f44812i1.setEnabled(false);
        this.B.setEnabled(false);
        setLightingSelect(false);
        this.K0 = null;
        this.L0 = null;
        t1();
        s1();
        this.f44842u0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        this.f44851x0.setChecked(false);
    }

    public String getBondZeroDefault() {
        return BigDecimal.ZERO.setScale(4, 4).toPlainString() + getResources().getString(R.string.points_pack_usdt);
    }

    public String getCallBackRateText() {
        return this.A.getText().toString();
    }

    public String getInputAmountText() {
        return this.F.getText().toString();
    }

    public EditText getInputPriceEt() {
        return this.f44847w;
    }

    public String getInputPriceText() {
        return this.f44847w.getText().toString();
    }

    public MagicIndicator getMagicIndicator() {
        return (MagicIndicator) findViewById(R.id.buy_shell_indicator);
    }

    public k4 getOnEditTextFocusChangeListener() {
        return this.f44815j1;
    }

    public String getOrderPlaceInputAmount() {
        String obj = this.F.getText().toString();
        return (getTradeAmountType() != 0 || getPositionType() != 0 || a7.e.E(this.f44827n1) || !a7.e.H(this.f44827n1)) ? obj : i6.m.a(obj).multiply(i6.m.a(this.f44813j.r())).toPlainString();
    }

    public int getOrderType() {
        return this.f44804g;
    }

    public int getPositionType() {
        return this.f44798e;
    }

    public int getSeekBarProgress() {
        return this.f44805g0.getProgress();
    }

    public FutureTpSlSettingParams getSlCache() {
        return this.L0;
    }

    public FutureTpSlSettingParams getTpCache() {
        return this.K0;
    }

    public FutureTpSlSettingDialogFragment.OpenType getTpSlDialogOpenType() {
        return this.M0;
    }

    public boolean getTpSlSwitchCheck() {
        return this.f44851x0.isChecked();
    }

    public int getTradeAmountType() {
        return this.f44802f0;
    }

    public int getTradePosition() {
        return this.f44795d;
    }

    public int getTradePriceType() {
        return this.f44844v.getTradePriceType();
    }

    public String getTriggerPriceText() {
        return this.f44836s.getText().toString();
    }

    public String getVolume() {
        String orderPlaceInputAmount = getOrderPlaceInputAmount();
        if (this.f44802f0 != 5) {
            return orderPlaceInputAmount;
        }
        if (SPUtil.j()) {
            AccountBalanceInfoV5 accountBalanceInfoV5 = this.f44810i;
            if (accountBalanceInfoV5 != null) {
                return i6.m.a(accountBalanceInfoV5.getAvailableMargin()).multiply(BigDecimal.valueOf((long) this.J0)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
            }
        } else {
            LinearSwapAccountInfo linearSwapAccountInfo = this.f44807h;
            if (linearSwapAccountInfo != null) {
                return i6.m.a(linearSwapAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.J0)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
            }
        }
        return null;
    }

    public void k2(String str) {
        if (this.f44827n1 == TradeType.LINEAR_SWAP) {
            this.S.setText(String.format(getContext().getString(R.string.order_price_icon_label), new Object[]{StringUtils.i(str)}));
            return;
        }
        this.S.setText(R.string.n_contract_trade_trend_trigger_price);
    }

    public final void l1(int i11) {
        this.J0 = i11;
        this.f44821l1.hideKeyboard();
        t0();
        this.f44802f0 = 5;
        this.f44813j.U(i11, this.f44798e);
        if (this.f44798e == 0) {
            this.R0 = null;
        } else {
            this.S0 = null;
        }
        B2();
    }

    public final void m1() {
        int i11 = this.f44795d;
        if (i11 == 0) {
            if (this.f44798e == 0) {
                L0();
            } else {
                U0();
            }
        } else if (i11 == 1) {
            if (this.f44798e == 0) {
                U0();
            } else {
                L0();
            }
        }
        w0(true, false);
    }

    public void n0() {
    }

    public String n1(boolean z11) {
        if (!tg.r.x().F0() || this.f44813j == null) {
            return "--";
        }
        try {
            FutureEarnestMoneyUtils f11 = FutureEarnestMoneyUtils.f();
            boolean z12 = true;
            f11.i(this.O0).t(getVolume()).s(a7.e.G(this.f44813j.s())).q(this.f44812i1).h(a7.e.E(this.f44813j.s())).r(this.f44813j.s()).l(this.f44813j.r()).u(this.f44813j.v()).k(this.f44813j.o().getContractFace()).o(4).g(BigDecimal.valueOf(this.f44813j.p().c()).toPlainString()).j(getInputPriceText()).m(BigDecimal.valueOf(this.f44813j.p().e()).toPlainString()).p(BigDecimal.valueOf(this.f44813j.p().f()).toPlainString()).n(this.f44804g == 6);
            if (this.f44802f0 != 5) {
                z12 = false;
            }
            return f11.b(z11, z12);
        } catch (FutureEarnestMoneyUtils.ZeroErr unused) {
            return getBondZeroDefault();
        }
    }

    public void n2(FuturePriceLimitInfo futurePriceLimitInfo) {
    }

    public void notifyDataSetChanged() {
        TradeTrendView tradeTrendView = this.f44799e0;
        if (tradeTrendView != null) {
            tradeTrendView.i();
        }
        t2();
    }

    public final void o1() {
        setLightingSelect(false);
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            r1();
            MarketTwTradeStateObservable.a().deleteObserver(this);
            return;
        }
        MarketTwTradeStateObservable.a().addObserver(this);
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.f44824m1;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            DialogUtils.b.d Q02 = new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getContext().getString(R.string.n_known)).Q0(u0.f53147a);
            if (!TextUtils.isEmpty(str)) {
                Q02.s0(getContext().getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new t0(this, str));
            }
            HBDialogFragment k02 = Q02.k0();
            this.f44824m1 = k02;
            k02.show(fragmentActivity.getSupportFragmentManager(), "");
        }
    }

    public final void p1(int i11) {
        this.f44795d = i11;
        Y0(this.f44798e);
        M0(this.f44795d);
    }

    public void q0() {
        HBDialogFragment hBDialogFragment = this.f44824m1;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public final void q1() {
        getViewTreeObserver().addOnPreDrawListener(new h());
    }

    public void r0() {
        CommonListPopupDialog commonListPopupDialog = this.f44797d1;
        if (commonListPopupDialog != null) {
            commonListPopupDialog.dismiss();
        }
        CommonListPopupDialog commonListPopupDialog2 = this.f44800e1;
        if (commonListPopupDialog2 != null) {
            commonListPopupDialog2.dismiss();
        }
    }

    public final void r1() {
        if (this.f44798e == 0) {
            if (this.T0) {
                this.f44847w.setText("");
            }
            this.V0 = true;
            return;
        }
        if (this.U0) {
            this.f44847w.setText("");
        }
        this.W0 = true;
    }

    public void s0() {
        for (MenuItem next : this.f44803f1) {
            if (next.getType() == 0) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f44813j.p().j(0);
        if (com.hbg.lib.core.util.w.l()) {
            this.W.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.W.setImageResource(R.drawable.trade_trend_default_red_green);
        }
        this.f44799e0.c(0);
        this.f44813j.p().l(false);
    }

    public final void s1() {
        this.E0.setText("");
    }

    public void setAmountEtText(String str) {
        this.F.setText(str);
    }

    public void setContractTradeViewController(nk.e eVar) {
        this.f44813j = eVar;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f44843u1 = fragmentManager;
    }

    public void setHasTrade(boolean z11) {
        this.f44831p1 = z11;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f44801f = z11;
    }

    public void setLeverList(List<String> list) {
        if (list != null) {
            this.Z0 = list;
        }
    }

    public void setOnCouponClickListener(View.OnClickListener onClickListener) {
        this.f44796d0.setOnClickListener(onClickListener);
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f44815j1 = k4Var;
    }

    public void setPositionType(int i11) {
        this.f44798e = i11;
    }

    public void setPriceAnimator(String str) {
        this.f44847w.setText(str);
        EditText editText = this.f44847w;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.f44847w);
    }

    public void setPriceInputType(int i11) {
        this.f44844v.setPriceInputType(i11);
    }

    public void setPriceText(String str) {
        this.f44844v.setPriceInputType(1);
        this.f44812i1.setSelected(false);
        setLightingSelect(false);
        if (this.f44798e == 0) {
            this.T0 = false;
            this.P0 = str;
        } else {
            this.Q0 = str;
            this.U0 = false;
        }
        int i11 = this.f44804g;
        if (i11 != 5 && i11 != 6) {
            setPriceAnimator(str);
        }
    }

    public void setProgress(int i11) {
        this.f44805g0.setProgress((float) i11);
    }

    public void setTradePosition(int i11) {
        this.f44795d = i11;
    }

    public void setTriggerPriceTypeView(int i11) {
        this.f44834r.setDividerVisibility(8);
        this.f44834r.setLabelVisibility(8);
    }

    public void setViewVisibility(int i11) {
        setVisibility(i11);
    }

    public void t0() {
        this.f44847w.clearFocus();
        this.F.clearFocus();
        this.f44836s.clearFocus();
    }

    public final void t1() {
        this.D0.setText("");
    }

    public final void t2() {
        nk.e eVar = this.f44813j;
        if (eVar != null && eVar.p() != null) {
            EventBus.d().k(new ContractLastPriceEvent(this.f44813j.p().e(), this.f44813j.p().c(), this.f44813j.p().f(), this.f44807h));
        }
    }

    public void u0(boolean z11, boolean z12) {
        this.K0 = null;
        this.L0 = null;
        t1();
        s1();
        this.f44842u0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        this.H0.setVisibility(8);
        if (z12) {
            this.f44851x0.setChecked(false);
        }
    }

    public final FeatureTradeTimeInfo u1() {
        FeatureTradeTimeInfo featureTradeTimeInfo = new FeatureTradeTimeInfo();
        featureTradeTimeInfo.setTradeType(this.f44827n1);
        featureTradeTimeInfo.setLongConfirmText(this.L.getText().toString());
        featureTradeTimeInfo.setShortConfirmText(this.M.getText().toString());
        featureTradeTimeInfo.setPositionType(this.f44798e);
        featureTradeTimeInfo.setSymbol(this.f44813j.v());
        featureTradeTimeInfo.setLinearSwapCurrencyInfo(this.f44813j.o());
        featureTradeTimeInfo.setBuyFirstPrice(this.f44813j.p().c());
        featureTradeTimeInfo.setSellFirstPrice(this.f44813j.p().f());
        featureTradeTimeInfo.setLastPriceNew(this.f44813j.p().e());
        featureTradeTimeInfo.setBuy(w2());
        featureTradeTimeInfo.setLevelRate(this.f44813j.r());
        featureTradeTimeInfo.setMarginMode(this.f44813j.t());
        featureTradeTimeInfo.setLinearSwapAccountInfo(this.f44807h);
        return featureTradeTimeInfo;
    }

    public final FutureTpSlSettingParams u2(FutureTpSlSettingParams futureTpSlSettingParams, boolean z11) {
        if (futureTpSlSettingParams != null) {
            this.M0 = futureTpSlSettingParams.getOpenType();
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
            t1();
        } else {
            s1();
        }
        return null;
    }

    public void update(java.util.Observable observable, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (booleanValue != this.I0.e()) {
            this.I0.setChecked(booleanValue);
        }
    }

    public void v0() {
        this.f44825n.setText("--");
        this.f44825n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f44828o.setImageResource(0);
    }

    public final ContractOrderPlace v1(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0(getInputPriceText());
        contractOrderPlace.d0(getOrderPlaceInputAmount());
        contractOrderPlace.h0(z11);
        contractOrderPlace.A0(this.f44798e);
        if (this.f44804g == 6) {
            contractOrderPlace.X0(8);
        } else {
            contractOrderPlace.X0(this.f44844v.getTradePriceType());
        }
        contractOrderPlace.g0(getTradeAmountType());
        contractOrderPlace.y0(this.f44804g);
        contractOrderPlace.Z0(getTriggerPriceText());
        contractOrderPlace.Y0(this.f44836s.getHint().toString());
        contractOrderPlace.e0(this.O0.getString(R.string.n_exchange_order_list_amount));
        contractOrderPlace.C0(this.f44847w.getHint().toString());
        contractOrderPlace.E0(getSeekBarProgress());
        contractOrderPlace.j0(this.A.getHint().toString());
        contractOrderPlace.U0(this.f44856z.getCurrentPriceTypeText());
        contractOrderPlace.k0(getCallBackRateText());
        contractOrderPlace.V0(this.f44856z.getTradePriceType());
        if (z11) {
            contractOrderPlace.W0(this.L.getText().toString());
        } else {
            contractOrderPlace.W0(this.M.getText().toString());
        }
        contractOrderPlace.x0(this.f44844v.getCurrentPriceTypeText());
        if (this.f44813j.o() != null) {
            contractOrderPlace.n0(this.f44813j.o().getContractType());
        }
        if (W0() && ContractTpslLayout.supportTpslOrder(this.f44804g)) {
            FutureTpSlSettingParams futureTpSlSettingParams = this.K0;
            if (futureTpSlSettingParams != null) {
                x1(contractOrderPlace, futureTpSlSettingParams);
            }
            FutureTpSlSettingParams futureTpSlSettingParams2 = this.L0;
            if (futureTpSlSettingParams2 != null) {
                w1(contractOrderPlace, futureTpSlSettingParams2);
            }
            if (!this.f44842u0.paramsIsAdvanced(this.K0, this.L0) && !(this.K0 == null && this.L0 == null)) {
                this.M0 = z11 ? FutureTpSlSettingDialogFragment.OpenType.OpenLong : FutureTpSlSettingDialogFragment.OpenType.OpenShort;
            }
        }
        contractOrderPlace.b1(qk.a.b().j(this.f44804g == 6, this.f44813j.B()));
        return contractOrderPlace;
    }

    public void v2(int i11, int i12) {
        if (i12 == 5 || i12 == 7) {
            this.G.setText(R.string.n_contract_trade_settling);
            this.H.setText(R.string.n_contract_trade_system_settling);
        } else if (i12 == 6 || i12 == 8) {
            this.G.setText(R.string.n_contract_trade_delivering);
            this.H.setText(R.string.n_contract_trade_system_delivering);
        } else if (i12 == 3) {
            this.G.setText(R.string.n_contract_trade_stop);
            this.H.setText("");
        } else if (i12 == 4) {
            this.G.setText(R.string.n_contract_trade_pre_trade);
            this.H.setText("");
        }
        this.I.setVisibility(i11);
    }

    public void w0(boolean z11, boolean z12) {
        if (this.f44844v.getTradePriceType() == 1) {
            if (this.f44798e == 0 && !TextUtils.isEmpty(this.P0)) {
                this.f44847w.setText(this.P0);
            } else if (this.f44798e != 1 || TextUtils.isEmpty(this.Q0)) {
                this.f44847w.setText("");
            } else {
                this.f44847w.setText(this.Q0);
            }
        }
        if (z11) {
            this.f44836s.setText("");
            this.A.setText("");
        }
        if (this.f44798e == 0 && !TextUtils.isEmpty(this.R0)) {
            this.F.setText(this.R0);
        } else if (this.f44798e != 1 || TextUtils.isEmpty(this.S0)) {
            this.F.setText("");
        } else {
            this.F.setText(this.S0);
        }
        setProgress(0);
        this.f44790b0.setVisibility(8);
        this.f44821l1.hideKeyboard();
    }

    public final void w1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
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

    public boolean w2() {
        if (this.f44798e == 0) {
            if (this.f44795d == 0) {
                return true;
            }
            return false;
        } else if (this.f44795d != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void x0(String str) {
        this.f44825n.setText(String.format(this.O0.getString(R.string.contract_lever), new Object[]{str}));
        LeverSelectDialogFragment leverSelectDialogFragment = this.Y0;
        if (leverSelectDialogFragment == null || !leverSelectDialogFragment.isResumed()) {
            this.f44828o.setImageResource(R.drawable.trade_arrow_down);
        } else {
            this.f44828o.setImageResource(R.drawable.trade_arrow_up);
        }
        if (i6.m.a(str).compareTo(BigDecimal.TEN) >= 0) {
            this.f44825n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        } else {
            this.f44825n.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        }
    }

    public final void x1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
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

    public void x2(String str) {
        String str2;
        if (this.f44802f0 != 0) {
            this.f44790b0.setVisibility(8);
        } else if (i6.m.a(str).compareTo(BigDecimal.ZERO) > 0) {
            if (a7.e.E(this.f44827n1)) {
                if (this.f44804g == 6 || this.f44812i1.isSelected()) {
                    double e11 = this.f44813j.p().e();
                    if (e11 == 0.0d) {
                        e11 = this.f44813j.p().c();
                    }
                    if (e11 == 0.0d) {
                        e11 = this.f44813j.p().f();
                    }
                    str2 = String.valueOf(e11);
                } else {
                    str2 = getInputPriceText();
                }
                this.f44793c0.setText(String.format(this.O0.getString(a7.e.D()), new Object[]{i6.m.a(str).multiply(i6.m.a(this.f44813j.o().getContractFace()).multiply(i6.m.a(str2))).setScale(this.f44813j.o().getOtherAmountPrecision(), 1).toPlainString(), "usdt".toUpperCase(Locale.US)}));
            } else {
                this.f44793c0.setText(String.format(this.O0.getString(a7.e.D()), new Object[]{i6.m.a(str).multiply(i6.m.a(this.f44813j.o().getContractFace())).setScale(FuturePrecisionUtil.s(this.f44813j.o().getContractCode(), this.f44813j.o().getContractShortType(), (String) null), 1), this.f44813j.v().toUpperCase(Locale.US)}));
            }
            this.f44790b0.setVisibility(0);
        } else {
            this.f44790b0.setVisibility(8);
        }
        B2();
    }

    public final FutureTpSlSettingParams y1(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
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

    public void y2() {
        LeverSelectDialogFragment leverSelectDialogFragment = new LeverSelectDialogFragment();
        this.Y0 = leverSelectDialogFragment;
        AccountBalanceInfoV5 accountBalanceInfoV5 = this.f44810i;
        if (accountBalanceInfoV5 != null) {
            leverSelectDialogFragment.Ai(accountBalanceInfoV5.getAvailableMargin());
        } else {
            leverSelectDialogFragment.Ai((String) null);
        }
        this.Y0.tc(this.Z0);
        this.Y0.wi(this.f44813j.t());
        this.Y0.bc(this.f44813j.v());
        this.Y0.xi(a7.e.m(this.O0, this.f44813j.v(), this.f44813j.o().getQuoteCurrency(), this.f44813j.o().getContractCode(), this.f44813j.o().getContractType(), this.f44813j.t()));
        this.Y0.vi(this.B1);
        this.Y0.ti(this.f44813j.r());
        this.Y0.setTradeType(this.f44827n1);
        this.Y0.zi(ContractWebActivity.Eh(4));
        this.Y0.si(this.f44813j.o().getContractCode());
        this.Y0.setDialogFragmentListener(new j());
        this.Y0.setDialogDismissListener(new p0(this));
        this.Y0.show(((FragmentActivity) this.O0).getSupportFragmentManager(), "LinearSwapLeverSelectDialogFragment");
    }

    public void z0(boolean z11) {
        this.J.setEnabled(z11);
        this.K.setEnabled(z11);
    }

    public void z1(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        if (ContractTpslLayout.isLimitlOrder(this.f44804g) && !this.f44844v.k()) {
            futureTpSlDialogShowBean.setEntrustPrice(i6.m.a(getInputPriceText()));
        }
        futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f44813j.u()).longValue()));
        futureTpSlDialogShowBean.setMarginMode(getContext().getString(this.f44813j.t() == 1 ? R.string.n_contract_super_margin : R.string.n_contract_trade_margin));
        futureTpSlDialogShowBean.setLever(this.f44813j.r());
        futureTpSlDialogShowBean.setSymbol(this.f44813j.v());
        if (this.f44813j.o() != null) {
            futureTpSlDialogShowBean.setContractType(this.f44813j.o().getContractType());
            futureTpSlDialogShowBean.setContractCode(this.f44813j.o().getContractCode());
            futureTpSlDialogShowBean.setContractShortType(this.f44813j.o().getContractShortType());
            futureTpSlDialogShowBean.setPricePrecision(FuturePrecisionUtil.y(this.f44813j.o().getContractCode(), this.f44813j.o().getContractShortType(), (String) null));
            futureTpSlDialogShowBean.setPredictProfitPrecision(FuturePrecisionUtil.w(this.f44813j.o().getContractCode(), this.f44813j.o().getContractShortType(), (String) null));
            futureTpSlDialogShowBean.setContractFace(i6.m.a(this.f44813j.o().getContractFace()));
        }
        futureTpSlDialogShowBean.setStopProfitSetting(y1(this.K0, this.L0));
        futureTpSlDialogShowBean.setStopLossSetting(y1(this.L0, this.K0));
    }

    public void z2() {
        r1();
        R0(true);
        setProgress(0);
    }

    public FutureTradeTogetherView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f44789b = "usdt_contract";
        this.f44792c = "contract_trade";
        this.f44804g = 0;
        this.M0 = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
        this.T0 = true;
        this.U0 = true;
        this.V0 = true;
        this.W0 = true;
        this.f44791b1 = new ArrayList();
        this.f44803f1 = new ArrayList();
        this.f44806g1 = new ArrayList();
        this.f44827n1 = TradeType.LINEAR_SWAP;
        this.f44849w1 = new i();
        this.f44852x1 = new l();
        this.f44855y1 = new m();
        this.f44858z1 = new n();
        this.A1 = new o();
        this.B1 = new p();
        B1(context, attributeSet);
    }
}
