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
import dj.a2;
import dj.a3;
import dj.b2;
import dj.c2;
import dj.d2;
import dj.e2;
import dj.f2;
import dj.g2;
import dj.h2;
import dj.i2;
import dj.j2;
import dj.j4;
import dj.k2;
import dj.k4;
import dj.l2;
import dj.m2;
import dj.n2;
import dj.o2;
import dj.p2;
import dj.r2;
import dj.s2;
import dj.t2;
import dj.u2;
import dj.v1;
import dj.v2;
import dj.w1;
import dj.w2;
import dj.x1;
import dj.x2;
import dj.y1;
import dj.y2;
import dj.z1;
import dj.z2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import k6.b;
import k6.c;
import net.lucode.hackware.magicindicator.MagicIndicator;
import pro.huobi.R;
import rx.Observable;

public class ContractTradeTogetherView extends FrameLayout implements j4, m0<ContractAccountInfo> {
    public EditText A;
    public TextView A0;
    public ImageButton B;
    public TextView B0;
    public ContractTradeAmountView C;
    public FutureTpSlSettingParams C0;
    public EditText D;
    public FutureTpSlSettingParams D0;
    public TextView E;
    public FutureTpSlSettingDialogFragment.OpenType E0;
    public TextView F;
    public FutureTpSlSettingDialogFragment F0;
    public LinearLayout G;
    public Context G0;
    public RelativeLayout H;
    public String H0;
    public RelativeLayout I;
    public String I0;
    public TextView J;
    public String J0;
    public TextView K;
    public String K0;
    public TextView L;
    public boolean L0;
    public TextView M;
    public boolean M0;
    public LinearLayout N;
    public boolean N0;
    public TextView O;
    public boolean O0;
    public TextView P;
    public final BottomMenuFragment P0;
    public ImageView Q;
    public final LeverSelectDialogFragment Q0;
    public View R;
    public final CommonListPopupDialog R0;
    public ImageView S;
    public final List<CommonPopListItem> S0;
    public ViewGroup T;
    public final BottomMenuFragment T0;
    public TextView U;
    public final CommonListPopupDialog U0;
    public TradeTrendView V;
    public final CommonListPopupDialog V0;
    public int W;
    public final List<MenuItem> W0;
    public final List<MenuItem> X0;
    public ViewGroup Y0;
    public TextView Z0;

    /* renamed from: a0  reason: collision with root package name */
    public MultiColorSeekBar f43407a0;

    /* renamed from: a1  reason: collision with root package name */
    public k4 f43408a1;

    /* renamed from: b  reason: collision with root package name */
    public String f43409b;

    /* renamed from: b0  reason: collision with root package name */
    public ContractTpslLayout f43410b0;

    /* renamed from: b1  reason: collision with root package name */
    public ContractMaintenanceView f43411b1;

    /* renamed from: c  reason: collision with root package name */
    public String f43412c;

    /* renamed from: c0  reason: collision with root package name */
    public View f43413c0;

    /* renamed from: c1  reason: collision with root package name */
    public HuobiKeyboardHelper f43414c1;

    /* renamed from: d  reason: collision with root package name */
    public int f43415d;

    /* renamed from: d0  reason: collision with root package name */
    public View f43416d0;

    /* renamed from: d1  reason: collision with root package name */
    public HBDialogFragment f43417d1;

    /* renamed from: e  reason: collision with root package name */
    public int f43418e;

    /* renamed from: e0  reason: collision with root package name */
    public CheckBox f43419e0;

    /* renamed from: e1  reason: collision with root package name */
    public View f43420e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43421f;

    /* renamed from: f0  reason: collision with root package name */
    public BottomLineTextView f43422f0;

    /* renamed from: f1  reason: collision with root package name */
    public boolean f43423f1;

    /* renamed from: g  reason: collision with root package name */
    public int f43424g;

    /* renamed from: g0  reason: collision with root package name */
    public View f43425g0;

    /* renamed from: g1  reason: collision with root package name */
    public ContractAccountInfo f43426g1;

    /* renamed from: h  reason: collision with root package name */
    public q2 f43427h;

    /* renamed from: h0  reason: collision with root package name */
    public View f43428h0;

    /* renamed from: h1  reason: collision with root package name */
    public int f43429h1;

    /* renamed from: i  reason: collision with root package name */
    public View f43430i;

    /* renamed from: i0  reason: collision with root package name */
    public ContractTpslEditText f43431i0;

    /* renamed from: i1  reason: collision with root package name */
    public View f43432i1;

    /* renamed from: j  reason: collision with root package name */
    public TextView f43433j;

    /* renamed from: j0  reason: collision with root package name */
    public ContractTpslEditText f43434j0;

    /* renamed from: j1  reason: collision with root package name */
    public View f43435j1;

    /* renamed from: k  reason: collision with root package name */
    public ImageView f43436k;

    /* renamed from: k0  reason: collision with root package name */
    public EditText f43437k0;

    /* renamed from: k1  reason: collision with root package name */
    public LinearLayout f43438k1;

    /* renamed from: l  reason: collision with root package name */
    public TextView f43439l;

    /* renamed from: l0  reason: collision with root package name */
    public EditText f43440l0;

    /* renamed from: l1  reason: collision with root package name */
    public TextView f43441l1;

    /* renamed from: m  reason: collision with root package name */
    public ImageView f43442m;

    /* renamed from: m0  reason: collision with root package name */
    public ImageView f43443m0;

    /* renamed from: m1  reason: collision with root package name */
    public FragmentManager f43444m1;

    /* renamed from: n  reason: collision with root package name */
    public RelativeLayout f43445n;

    /* renamed from: n0  reason: collision with root package name */
    public ImageView f43446n0;

    /* renamed from: n1  reason: collision with root package name */
    public CommonPopListItem f43447n1;

    /* renamed from: o  reason: collision with root package name */
    public ViewGroup f43448o;

    /* renamed from: o1  reason: collision with root package name */
    public final MenuItemOnClickListener f43449o1;

    /* renamed from: p  reason: collision with root package name */
    public ContractTradePriceEditext f43450p;

    /* renamed from: p1  reason: collision with root package name */
    public final MenuItemOnClickListener f43451p1;

    /* renamed from: q  reason: collision with root package name */
    public EditText f43452q;

    /* renamed from: q1  reason: collision with root package name */
    public final CommonPopListItem.a f43453q1;

    /* renamed from: r  reason: collision with root package name */
    public ViewGroup f43454r;

    /* renamed from: r1  reason: collision with root package name */
    public final CommonPopListItem.a f43455r1;

    /* renamed from: s  reason: collision with root package name */
    public TextView f43456s;

    /* renamed from: s1  reason: collision with root package name */
    public final CommonPopListItem.a f43457s1;

    /* renamed from: t  reason: collision with root package name */
    public ContractGearsTradePriceEditText f43458t;

    /* renamed from: t0  reason: collision with root package name */
    public TextView f43459t0;

    /* renamed from: t1  reason: collision with root package name */
    public final LeverSelectDialogFragment.h f43460t1;

    /* renamed from: u  reason: collision with root package name */
    public EditText f43461u;

    /* renamed from: u0  reason: collision with root package name */
    public TextView f43462u0;

    /* renamed from: v  reason: collision with root package name */
    public ViewGroup f43463v;

    /* renamed from: v0  reason: collision with root package name */
    public TextView f43464v0;

    /* renamed from: w  reason: collision with root package name */
    public TextView f43465w;

    /* renamed from: w0  reason: collision with root package name */
    public View f43466w0;

    /* renamed from: x  reason: collision with root package name */
    public View f43467x;

    /* renamed from: x0  reason: collision with root package name */
    public View f43468x0;

    /* renamed from: y  reason: collision with root package name */
    public View f43469y;

    /* renamed from: y0  reason: collision with root package name */
    public TextView f43470y0;

    /* renamed from: z  reason: collision with root package name */
    public ContractGearsTradePriceEditText f43471z;

    /* renamed from: z0  reason: collision with root package name */
    public TextView f43472z0;

    public class a implements TradeTrendView.b {
        public a() {
        }

        public void a(c.a aVar) {
            ContractTradeTogetherView.this.setPriceText(i6.m.i(aVar.a(), ej.f.p(aVar.E0())));
            ContractTradeTogetherView.this.t0();
            ContractTradeTogetherView.this.f43414c1.hideKeyboard();
        }

        public void b(b.a aVar) {
        }

        public void c(b.a aVar) {
            ContractTradeTogetherView.this.setPriceText(i6.m.m(aVar.b(), ej.f.p(aVar.E0())));
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public b() {
        }

        public boolean onPreDraw() {
            int d11 = ContractTradeTogetherView.this.V.d();
            ContractTradeTogetherView.this.V.l(d11 / 2, d11);
            return true;
        }
    }

    public class c implements BaseDialogFragment.c {
        public c() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractTradeTogetherView.this.f43436k.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeTogetherView.this.f43436k.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class d implements BaseDialogFragment.c {
        public d() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractTradeTogetherView.this.f43458t.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeTogetherView.this.f43458t.p(R.drawable.trade_arrow_up);
        }
    }

    public class e implements BaseDialogFragment.c {
        public e() {
        }

        public void onDialogFragmentBackPressed() {
        }

        public void onDialogFragmentPause() {
            ContractTradeTogetherView.this.f43442m.setImageResource(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeTogetherView.this.f43442m.setImageResource(R.drawable.trade_arrow_up);
        }
    }

    public class f implements ContractGearsTradePriceEditText.c {
        public f() {
        }

        public void a() {
            ContractTradeTogetherView.this.V0.showAsDropDown(((FragmentActivity) ContractTradeTogetherView.this.getContext()).getSupportFragmentManager(), (View) ContractTradeTogetherView.this.f43471z, true, 0, 0, 80);
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
            ContractTradeTogetherView.this.f43471z.p(R.drawable.trade_arrow_down);
        }

        public void onDialogFragmentResume() {
            ContractTradeTogetherView.this.f43471z.p(R.drawable.trade_arrow_up);
        }
    }

    public class h implements TextWatcher {
        public h() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                ContractTradeTogetherView.this.A.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.getContext(), R.font.roboto_regular));
            } else {
                ContractTradeTogetherView.this.A.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.getContext(), R.font.roboto_medium));
            }
            if (i6.m.b(editable, 10, 1) != null) {
                ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
                contractTradeTogetherView.t2(contractTradeTogetherView.A, editable.toString());
                return;
            }
            ContractTradeTogetherView.this.k2();
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
            ContractTradeTogetherView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            int d11 = ContractTradeTogetherView.this.V.d();
            ContractTradeTogetherView.this.V.l(d11 / 2, d11);
            return true;
        }
    }

    public class j implements MenuItemOnClickListener {
        public j() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            for (MenuItem menuItem2 : ContractTradeTogetherView.this.W0) {
                if (i11 == menuItem2.getType()) {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.STRESS);
                } else {
                    menuItem2.setStyle(MenuItem.MenuItemStyle.COMMON);
                }
            }
            if (i11 == 0) {
                ContractTradeTogetherView.this.f43427h.l().S(0);
                if (com.hbg.lib.core.util.w.l()) {
                    ContractTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_default_green_red);
                } else {
                    ContractTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_default_red_green);
                }
                if (ContractTradeTogetherView.this.V != null) {
                    ContractTradeTogetherView.this.V.c(0);
                }
            } else if (i11 == 1) {
                ContractTradeTogetherView.this.f43427h.l().S(1);
                if (com.hbg.lib.core.util.w.l()) {
                    ContractTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_red);
                } else {
                    ContractTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_green);
                }
                if (ContractTradeTogetherView.this.V != null) {
                    ContractTradeTogetherView.this.V.c(1);
                }
            } else {
                ContractTradeTogetherView.this.f43427h.l().S(2);
                if (com.hbg.lib.core.util.w.l()) {
                    ContractTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_green);
                } else {
                    ContractTradeTogetherView.this.S.setImageResource(R.drawable.trade_trend_red);
                }
                if (ContractTradeTogetherView.this.V != null) {
                    ContractTradeTogetherView.this.V.c(2);
                }
            }
            ContractTradeTogetherView.this.f43427h.l().Y(false);
            ContractTradeTogetherView.this.T0.dismiss();
        }
    }

    public class k implements ContractTpslEditText.c {
        public k() {
        }

        public void afterTextChanged(EditText editText, String str) {
            if (editText == ContractTradeTogetherView.this.f43437k0) {
                ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
                FutureTpSlSettingParams unused = contractTradeTogetherView.C0 = FutureTpSlSettingParams.changeTpSlCache(contractTradeTogetherView.C0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
            } else if (editText == ContractTradeTogetherView.this.f43440l0) {
                ContractTradeTogetherView contractTradeTogetherView2 = ContractTradeTogetherView.this;
                FutureTpSlSettingParams unused2 = contractTradeTogetherView2.D0 = FutureTpSlSettingParams.changeTpSlCache(contractTradeTogetherView2.D0, FutureTpSlSettingDialogFragment.OpenType.OpenLong, str);
            }
        }

        public int getTradePricePrecision() {
            if (ContractTradeTogetherView.this.f43427h.j() != null) {
                return ej.f.p(ContractTradeTogetherView.this.f43427h.j().getContractCode());
            }
            return 14;
        }
    }

    public class l implements MenuItemOnClickListener {
        public l() {
        }

        public void onClickMenuItem(View view, MenuItem menuItem, int i11) {
            if (ContractTradeTogetherView.this.f43427h.l() != null) {
                ContractTradeTogetherView.this.f43427h.l().t(i11);
            }
            ContractTradeTogetherView.this.P0.dismiss();
        }
    }

    public class m implements CommonPopListItem.a {
        public m() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            ContractTradeTogetherView.this.R0.dismiss();
            int type = commonPopListItem.getType();
            if (type == ContractTradeTogetherView.this.f43424g) {
                return;
            }
            if (type != 0 || (ContractTradeTogetherView.this.f43424g != 3 && ContractTradeTogetherView.this.f43424g != 4)) {
                ContractTradeTogetherView.this.T0(type);
                FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
                if (type != 0) {
                    if (type == 1) {
                        ContractGuideHelper.b(fragmentActivity, 4);
                        return;
                    } else if (!(type == 2 || type == 3 || type == 4)) {
                        return;
                    }
                }
                if (!ContractTradeTogetherView.this.f43423f1) {
                    ContractGuideHelper.b(fragmentActivity, 1);
                }
            }
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return commonPopListItem.getType() == ContractTradeTogetherView.this.f43424g || (commonPopListItem.getType() == 0 && (ContractTradeTogetherView.this.f43424g == 3 || ContractTradeTogetherView.this.f43424g == 4));
        }
    }

    public class n implements CommonPopListItem.a {
        public n() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            ContractTradeTogetherView.this.f43458t.setPriceInputType(commonPopListItem.getType());
            ContractTradeTogetherView.this.f43458t.setCurrentPriceTypeText(commonPopListItem.getText());
            ContractTradeTogetherView.this.U0.dismiss();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ContractTradeTogetherView.this.f43458t.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class o implements CommonPopListItem.a {
        public o() {
        }

        public void V6(CommonPopListItem commonPopListItem) {
            ContractTradeTogetherView.this.f43471z.setPriceInputType(commonPopListItem.getType());
            ContractTradeTogetherView.this.f43471z.setCurrentPriceTypeText(commonPopListItem.getText());
            ContractTradeTogetherView.this.V0.dismiss();
        }

        public boolean ic(CommonPopListItem commonPopListItem) {
            return ContractTradeTogetherView.this.f43471z.getTradePriceType() == commonPopListItem.getType();
        }
    }

    public class p implements LeverSelectDialogFragment.h {
        public p() {
        }

        public void N0() {
            if (ContractTradeTogetherView.this.f43427h != null) {
                ContractTradeTogetherView.this.f43427h.u().N0();
            }
        }

        public Observable<List<LevelAvailableMarginInfo>> O0(TradeType tradeType, String str, int i11) {
            return uc.b.d(tradeType, str, i11);
        }

        public void P0(String str) {
            ContractTradeTogetherView.this.x0(str);
            ContractTradeTogetherView.this.f43427h.E(str);
            ContractTradeTogetherView.this.f43427h.B();
        }

        public String[] Q0(String str, LevelAvailableMarginInfo levelAvailableMarginInfo) {
            return ContractTradeTogetherView.this.f43427h.h(str, levelAvailableMarginInfo);
        }

        public boolean R0(LeverSelectDialogFragment leverSelectDialogFragment, String str) {
            if (ContractTradeTogetherView.this.f43427h == null) {
                return true;
            }
            ContractTradeTogetherView.this.f43427h.A(leverSelectDialogFragment, str, ContractTradeTogetherView.this.f43427h.r());
            return true;
        }
    }

    public class q implements ContractTradeAmountView.a {
        public q() {
        }

        public String o0() {
            return ContractTradeTogetherView.this.f43427h.r();
        }
    }

    public class r extends BaseSubscriber<ContractUserInfo.UserBean> {
        public r() {
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo.UserBean userBean) {
            super.onNext(userBean);
            ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
            contractTradeTogetherView.j1(contractTradeTogetherView.f43415d);
        }
    }

    public class s extends BaseSubscriber<ContractUserInfo.UserBean> {
        public s() {
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo.UserBean userBean) {
            super.onNext(userBean);
            ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
            contractTradeTogetherView.j1(contractTradeTogetherView.f43415d);
        }
    }

    public class t implements TextWatcher {
        public t() {
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() == 0) {
                ContractTradeTogetherView.this.f43452q.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.f43452q.getContext(), R.font.roboto_regular));
            } else {
                ContractTradeTogetherView.this.f43452q.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.f43452q.getContext(), R.font.roboto_medium));
            }
            ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
            contractTradeTogetherView.u2(contractTradeTogetherView.f43427h.m(editable.toString()));
            if (!(ContractTradeTogetherView.this.f43427h.j() == null || i6.m.b(editable, 10, ej.f.p(ContractTradeTogetherView.this.f43427h.j().getContractCode())) == null)) {
                ContractTradeTogetherView contractTradeTogetherView2 = ContractTradeTogetherView.this;
                contractTradeTogetherView2.t2(contractTradeTogetherView2.f43452q, editable.toString());
            }
            ContractTradeTogetherView.this.k2();
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
            ContractTradeTogetherView.this.t1();
        }

        public void b() {
            ContractTradeTogetherView.this.t1();
        }
    }

    public class v implements TextWatcher {
        public v() {
        }

        public void afterTextChanged(Editable editable) {
            int tradePriceType = ContractTradeTogetherView.this.getTradePriceType();
            if (editable.length() == 0) {
                ContractTradeTogetherView.this.f43461u.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.f43461u.getContext(), R.font.roboto_regular));
                ContractTradeTogetherView.this.l(BigDecimal.ZERO);
            } else {
                ContractTradeTogetherView.this.f43461u.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.f43461u.getContext(), R.font.roboto_medium));
            }
            ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
            contractTradeTogetherView.X0(contractTradeTogetherView.f43427h.m(editable.toString()));
            String str = null;
            if (tradePriceType == 1 && ContractTradeTogetherView.this.f43427h.j() != null) {
                str = i6.m.b(editable, 10, ej.f.p(ContractTradeTogetherView.this.f43427h.j().getContractCode()));
            }
            if (str != null) {
                ContractTradeTogetherView contractTradeTogetherView2 = ContractTradeTogetherView.this;
                contractTradeTogetherView2.t2(contractTradeTogetherView2.f43461u, editable.toString());
                return;
            }
            if (ContractTradeTogetherView.this.f43418e == 0) {
                if (ContractTradeTogetherView.this.f43461u.hasFocus()) {
                    boolean unused = ContractTradeTogetherView.this.L0 = false;
                }
                if (ContractTradeTogetherView.this.f43424g != 5) {
                    String unused2 = ContractTradeTogetherView.this.H0 = editable.toString();
                }
            } else {
                if (ContractTradeTogetherView.this.f43461u.hasFocus()) {
                    boolean unused3 = ContractTradeTogetherView.this.M0 = false;
                }
                if (ContractTradeTogetherView.this.f43424g != 5) {
                    String unused4 = ContractTradeTogetherView.this.I0 = editable.toString();
                }
            }
            ContractTradeTogetherView.this.f43427h.f(false);
            ContractTradeTogetherView.this.k2();
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
                int unused = ContractTradeTogetherView.this.W = 0;
            }
            String obj = editable.toString();
            if (ContractTradeTogetherView.this.W == 0) {
                if (ContractTradeTogetherView.this.f43418e == 0) {
                    String unused2 = ContractTradeTogetherView.this.J0 = obj;
                } else {
                    String unused3 = ContractTradeTogetherView.this.K0 = obj;
                }
            }
            if (editable.length() == 0) {
                ContractTradeTogetherView.this.D.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.D.getContext(), R.font.roboto_regular));
                ContractTradeTogetherView.this.l(BigDecimal.ZERO);
                return;
            }
            ContractTradeTogetherView.this.D.setTypeface(ResourcesCompat.h(ContractTradeTogetherView.this.D.getContext(), R.font.roboto_medium));
            String str = null;
            if (!a7.e.E(TradeType.CONTRACT)) {
                if (ContractTradeTogetherView.this.W == 0) {
                    if (editable.toString().lastIndexOf(InstructionFileId.DOT) > 0) {
                        str = editable.toString().substring(0, editable.toString().lastIndexOf(InstructionFileId.DOT));
                    } else {
                        str = i6.m.b(editable, 10, ej.f.g(ContractTradeTogetherView.this.f43427h.r()));
                    }
                }
                if (str != null) {
                    ContractTradeTogetherView contractTradeTogetherView = ContractTradeTogetherView.this;
                    contractTradeTogetherView.t2(contractTradeTogetherView.D, str);
                    return;
                }
            } else if (ContractTradeTogetherView.this.f43427h.j() != null) {
                if (ContractTradeTogetherView.this.W == 0) {
                    str = i6.m.b(editable, 10, ej.f.n(ContractTradeTogetherView.this.f43427h.j().getContractCode()));
                }
                if (str != null) {
                    ContractTradeTogetherView contractTradeTogetherView2 = ContractTradeTogetherView.this;
                    contractTradeTogetherView2.t2(contractTradeTogetherView2.D, str);
                    return;
                }
            }
            ContractTradeTogetherView.this.f43427h.g(false, true);
            ContractTradeTogetherView.this.k2();
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class x implements MultiColorSeekBar.OnProgressChangedListener {
        public x() {
        }

        public void getProgressOnActionUp(MultiColorSeekBar multiColorSeekBar, int i11, float f11) {
        }

        public void getProgressOnFinally(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
        }

        public void onProgressChanged(MultiColorSeekBar multiColorSeekBar, int i11, float f11, boolean z11) {
            if (z11) {
                ContractTradeTogetherView.this.f1(i11);
            }
        }
    }

    public ContractTradeTogetherView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C1(int i11) {
        if (i11 == 0) {
            T0(0);
            this.f43447n1.setType(0);
        } else if (i11 == 1) {
            T0(3);
            this.f43447n1.setType(3);
        } else {
            T0(4);
            this.f43447n1.setType(4);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void D1(View view) {
        if (this.f43444m1 != null) {
            LimitChooseDialog vh2 = LimitChooseDialog.vh();
            Bundle bundle = new Bundle();
            int i11 = this.f43424g;
            bundle.putInt("selIndex", i11 == 0 ? 0 : i11 == 3 ? 1 : 2);
            vh2.setArguments(bundle);
            vh2.wh(new m2(this)).show(this.f43444m1, "limitChoose");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean E1(View view, MotionEvent motionEvent) {
        if (tg.r.x().F0()) {
            return false;
        }
        rn.c.i().d((Activity) getContext(), new JumpTarget((Intent) null, (Intent) null));
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F1(View view, boolean z11) {
        l2(this.C, z11);
        if (z11) {
            setProgress(0);
            if (this.W == 5) {
                this.D.setText("");
            }
            this.W = 0;
        }
        this.f43408a1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void G1(View view) {
        if (this.f43427h.l().x().size() > 0) {
            this.P0.show(((Activity) this.G0).getFragmentManager(), "depthBottomMenuFragment");
        }
        this.f43414c1.hideKeyboard();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void H1(View view) {
        this.f43414c1.hideKeyboard();
        this.f43427h.I();
        gs.g.j(this.f43412c, this.f43409b, "lever_adjust", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void I1(View view) {
        this.T0.show(((Activity) this.G0).getFragmentManager(), "trendChangeMenuFragment");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void J1(View view) {
        this.f43458t.clearFocus();
        this.f43414c1.hideKeyboard();
        this.R0.showAsDropDown(((FragmentActivity) this.G0).getSupportFragmentManager(), this.f43430i);
        gs.g.j(this.f43412c, this.f43409b, "entrust_model", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K1() {
        this.Q.setImageResource(R.drawable.trade_arrow_up_new);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L1() {
        this.Q.setImageResource(R.drawable.trade_arrow_down_new);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void M1(CompoundButton compoundButton, boolean z11) {
        gl.b.b(TradeType.CONTRACT, z11);
        HashMap hashMap = new HashMap();
        if (z11) {
            this.f43425g0.setVisibility(0);
            this.f43428h0.setVisibility(0);
            k1();
            hashMap.put("button_type", "open");
        } else {
            this.f43459t0.setVisibility(8);
            this.f43425g0.setVisibility(8);
            this.f43428h0.setVisibility(8);
            u0(true, false);
            k1();
            hashMap.put("button_type", "close");
        }
        hashMap.put("view_name", "same_screen");
        gs.g.i("take_profit_and_stop_loss_switch_click", hashMap);
        gs.g.j(this.f43412c, this.f43409b, "stop_surplus_loss", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void N1(View view) {
        ContractGuideHelper.d(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), ContractTradeTogetherView.class.getName(), ContractGuideHelper.a(this.f43424g));
        gs.g.j(this.f43412c, this.f43409b, "entrust_model_explanation", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O1(View view, MotionEvent motionEvent) {
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
    public static /* synthetic */ void P1(View view) {
        ContractGuideHelper.b((FragmentActivity) oa.a.g().b(), 2);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R1(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
        this.C0 = j2(futureTpSlSettingParams, true);
        FutureTpSlSettingParams j22 = j2(futureTpSlSettingParams2, false);
        this.D0 = j22;
        this.f43410b0.refreshTpSlView(this.C0, j22);
        p2();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void S1(FutureTpSlSettingDialogFragment.c cVar, View view) {
        if (TextUtils.isEmpty(this.f43427h.n())) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!r2()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f43414c1.hideKeyboard();
            FutureTpSlDialogShowBean futureTpSlDialogShowBean = new FutureTpSlDialogShowBean();
            futureTpSlDialogShowBean.setTradeType(TradeType.CONTRACT);
            s1(futureTpSlDialogShowBean);
            FutureTpSlSettingDialogFragment Kh = FutureTpSlSettingDialogFragment.Kh(futureTpSlDialogShowBean);
            this.F0 = Kh;
            Kh.Vh(i6.m.a(String.valueOf(this.f43427h.l().z())));
            this.F0.Uh(cVar);
            this.F0.show(((FragmentActivity) this.G0).getSupportFragmentManager(), "FutureTpSettingDialogFragment");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void T1(View view) {
        this.C0 = null;
        n1();
        if (this.D0 == null) {
            this.f43459t0.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void U1(View view) {
        this.D0 = null;
        m1();
        if (this.C0 == null) {
            this.f43459t0.setVisibility(8);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void V1(View view) {
        sn.f.f(TradeType.CONTRACT, this.G0);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void W1(View view) {
        this.V0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f43471z, true, 0, 0, 80);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void X1(View view) {
        this.f43414c1.hideKeyboard();
        if (!tg.r.x().F0()) {
            Context context = this.G0;
            boolean z11 = context instanceof HuobiMainActivity;
            Intent d11 = k0.d(context, z11);
            if (!z11) {
                d11.addFlags(67108864);
            }
            rn.c.i().d(this.G0, new JumpTarget(d11, d11));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractUserInfoProvider.i().o() == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            ContractUserInfoProvider.i().p(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new r());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!ContractUserInfoProvider.i().r()) {
            ej.c.d(getContext(), true);
            gs.g.i("App_contract_open_click", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f43427h.K(o1(true));
            HashMap hashMap = new HashMap();
            hashMap.put("coin_contract_trade_set", "same_screen");
            gs.g.j(this.f43409b, (String) null, this.f43418e == 0 ? "buy_open" : "buy_flat", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Y1(View view) {
        this.f43414c1.hideKeyboard();
        if (ContractUserInfoProvider.i().o() == null) {
            HuobiToastUtil.j(R.string.n_contract_account_loading);
            ContractUserInfoProvider.i().p(false).compose(RxJavaHelper.t((u6.g) null)).subscribe(new s());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (!ContractUserInfoProvider.i().r()) {
            ej.c.d(getContext(), true);
            gs.g.i("App_contract_open_click", (HashMap) null);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (ContractCalmPeriodHelper.d()) {
            ContractCalmPeriodHelper.h(getResources());
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            this.f43427h.K(o1(false));
            HashMap hashMap = new HashMap();
            hashMap.put("coin_contract_trade_set", "same_screen");
            gs.g.j(this.f43409b, (String) null, this.f43418e == 0 ? "sell_open" : "sell_flat", hashMap);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z1(View view, boolean z11) {
        l2(this.f43450p, z11);
        this.f43408a1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void a2(View view) {
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ImageButton imageButton = this.B;
        imageButton.setSelected(!imageButton.isSelected());
        if (this.B.isSelected()) {
            this.f43414c1.hideKeyboard();
            this.f43458t.setCurrentPriceTypeText(this.G0.getString(R.string.contract_trade_position_close_quick));
            this.f43458t.setPriceInputType(6);
            this.f43461u.setText("");
        } else {
            this.f43458t.setPriceInputType(1);
            this.f43427h.f(false);
        }
        setLightingSelect(this.B.isSelected());
        this.Z0.setSelected(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void b2(View view) {
        int i11;
        if (!tg.r.x().F0()) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (!this.Z0.isSelected() && ((i11 = this.f43424g) == 0 || i11 == 3 || i11 == 4)) {
            FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
            new DialogUtils.b.d(fragmentActivity).c1(getContext().getString(R.string.n_spot_order_risk)).C0(getContext().getString(R.string.n_contract_trade_bbo_tips)).q0(false).P0(getContext().getString(R.string.n_known)).Q0(cn.n.f13170a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
        }
        TextView textView = this.Z0;
        textView.setSelected(!textView.isSelected());
        if (this.f43458t.k()) {
            this.f43458t.setPriceInputType(1);
            this.f43427h.f(false);
        } else {
            if (this.f43461u.hasFocus()) {
                this.f43414c1.hideKeyboard();
            }
            if (this.f43424g == 1) {
                this.f43458t.setCurrentPriceTypeText(this.G0.getString(R.string.contract_trade_optimal_five));
                this.f43458t.setPriceInputType(3);
            } else {
                this.f43458t.setCurrentPriceTypeText(getBboStr());
                this.f43458t.setPriceInputType(2);
            }
            this.f43461u.setText("");
        }
        setLightingSelect(false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c2(View view, boolean z11) {
        l2(this.f43458t, z11);
        this.f43408a1.onFocusChange(view, z11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void d2(View view) {
        t1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void e2(HBDialogFragment hBDialogFragment) {
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f2(String str, HBDialogFragment hBDialogFragment) {
        ContractWebActivity.Rh((Activity) getContext(), str);
        FutureClearDialogConfigController.f(20);
        hBDialogFragment.dismiss();
    }

    private String getBboStr() {
        if (AppLanguageHelper.getInstance().isChineseLanguage()) {
            return this.G0.getString(R.string.n_contract_trade_rival_price);
        }
        return this.G0.getString(R.string.n_contract_trade_optimal_one);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h2(DialogFragment dialogFragment, View view) {
        v0.e(getContext(), "900003870186");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i2() {
        if (this.f43413c0.getVisibility() == 0) {
            ej.j.h(this.f43416d0, getContext().getString(R.string.n_contract_tp_sl_guide_hint), d2.f53662b, new n2(this));
        }
    }

    private void setLightingSelect(boolean z11) {
        this.B.setSelected(z11);
        if (z11) {
            setProgress(100);
            f1(100);
        } else if (this.f43458t.getLastTradePriceType() == 6) {
            setProgress(0);
            if (this.f43418e == 0) {
                this.D.setText(this.J0);
            } else {
                this.D.setText(this.K0);
            }
        }
    }

    private void setProgress(int i11) {
        this.f43407a0.setProgress((float) i11);
    }

    private void setSlText(String str) {
        this.f43440l0.setText(str);
    }

    private void setTpText(String str) {
        this.f43437k0.setText(str);
    }

    public void A0(int i11) {
        ViewGroup viewGroup = this.Y0;
        if (viewGroup != null) {
            viewGroup.setVisibility(i11);
            this.f43411b1.setUI(this.f43427h.u());
            this.f43411b1.setCountDownTime(bj.d.e());
        }
    }

    public final void A1(View view) {
        this.S = (ImageView) view.findViewById(R.id.trend_change_iv);
        this.W0.add(new MenuItem(0, this.G0.getString(R.string.n_contract_trade_trend_default), this.G0.getString(R.string.n_contract_trade_trend_default), MenuItem.MenuItemStyle.STRESS, this.f43449o1));
        List<MenuItem> list = this.W0;
        String string = this.G0.getString(R.string.n_contract_trade_trend_buy);
        String string2 = this.G0.getString(R.string.n_contract_trade_trend_buy);
        MenuItem.MenuItemStyle menuItemStyle = MenuItem.MenuItemStyle.COMMON;
        list.add(new MenuItem(1, string, string2, menuItemStyle, this.f43449o1));
        this.W0.add(new MenuItem(2, this.G0.getString(R.string.n_contract_trade_trend_sell), this.G0.getString(R.string.n_contract_trade_trend_sell), menuItemStyle, this.f43449o1));
        this.T0.setMenuItems(this.W0);
        this.T0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public boolean B1() {
        if (this.f43418e == 0) {
            if (this.f43415d == 0) {
                return true;
            }
            return false;
        } else if (this.f43415d != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void C0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.setBuyList(list);
        }
    }

    public void E0(List<MarketBuySellItem> list, boolean z11) {
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.setSellList(list);
        }
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        FutureTpSlSettingDialogFragment futureTpSlSettingDialogFragment;
        int i11;
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.setNewestPrice(marketCurrentPriceItem);
        }
        this.f43427h.f(false);
        String obj = this.f43461u.getText().toString();
        String b11 = marketCurrentPriceItem.b();
        if (TextUtils.isEmpty(obj) && !this.f43461u.hasFocus() && !TextUtils.equals("--", b11) && this.f43458t.getTradePriceType() == 1 && (i11 = this.f43424g) != 5) {
            if (this.f43418e == 0) {
                if (this.N0 || i11 == 6) {
                    this.L0 = true;
                    this.f43461u.setText(b11);
                }
            } else if (this.O0 || i11 == 6) {
                this.M0 = true;
                this.f43461u.setText(b11);
            }
        }
        if (!TextUtils.equals("--", b11)) {
            if (this.f43418e == 0) {
                this.N0 = false;
            } else {
                this.O0 = false;
            }
        }
        if (this.f43427h != null && (futureTpSlSettingDialogFragment = this.F0) != null && futureTpSlSettingDialogFragment.isVisible()) {
            this.F0.Vh(i6.m.a(String.valueOf(this.f43427h.l().z())));
        }
    }

    public void I0() {
        if (this.f43458t.getTradePriceType() != 1) {
            this.f43427h.f(false);
        }
    }

    public void J0() {
        this.D.setText("");
        setProgress(0);
    }

    public void K0() {
        this.Q0.dismiss();
    }

    public void L0() {
        if (this.f43458t.getTradePriceType() == 1) {
            this.f43421f = false;
        } else {
            this.f43427h.f(false);
        }
    }

    public void M0(int i11) {
        boolean z11 = true;
        if (!tg.r.x().F0() || !(ContractUserInfoProvider.i().o() == null || ContractUserInfoProvider.i().o().getActiveState() == 1)) {
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
        MultiConfigBuilder configBuilder = this.f43407a0.getConfigBuilder();
        Context context = getContext();
        boolean g11 = NightHelper.e().g();
        if (this.f43418e != 0) {
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
        this.f43418e = i11;
        this.W = 0;
        t0();
        l1();
        n0();
        Y0(this.f43418e);
        M0(this.f43415d);
        T0(this.f43424g);
        i1(i11);
        q2();
    }

    public void P0(String str, String str2) {
        String r11 = this.f43427h.r();
        if (a7.e.E(TradeType.CONTRACT)) {
            int i11 = this.f43418e;
            if (i11 == 0) {
                n2(this.G0.getString(R.string.n_contract_contract_open_long), str, r11);
                o2(this.G0.getString(R.string.n_contract_contract_open_short), str2, r11);
            } else if (i11 == 1) {
                n2(this.G0.getString(R.string.n_contract_trade_can_close_short), str, r11);
                o2(this.G0.getString(R.string.n_contract_trade_can_close_long), str2, r11);
            }
        } else {
            int i12 = this.f43418e;
            if (i12 == 0) {
                n2(this.G0.getString(R.string.n_contract_contract_open_long), str, getResources().getString(R.string.n_contract_trade_unit_sheet));
                o2(this.G0.getString(R.string.n_contract_contract_open_short), str2, getResources().getString(R.string.n_contract_trade_unit_sheet));
            } else if (i12 == 1) {
                n2(this.G0.getString(R.string.n_contract_trade_can_close_short), str, this.G0.getString(R.string.n_contract_vol_sheet));
                o2(this.G0.getString(R.string.n_contract_trade_can_close_long), str2, this.G0.getString(R.string.n_contract_vol_sheet));
            }
        }
    }

    public void Q0() {
        boolean z11 = getPositionType() == 0;
        this.C.setData(z11);
        TradeType tradeType = TradeType.CONTRACT;
        if (!a7.e.E(tradeType)) {
            this.D.setHint(this.G0.getString(R.string.n_contract_trade_input_amount));
        } else if (!z11 || !a7.e.H(tradeType)) {
            this.D.setHint(this.G0.getString(R.string.n_contract_unit_amount));
        } else {
            this.D.setHint(this.G0.getString(R.string.n_contract_unit_principal));
        }
        m2();
    }

    public void Q1(int i11, ContractCurrencyInfo contractCurrencyInfo) {
        if (contractCurrencyInfo != null) {
            if (contractCurrencyInfo.getContractStatus() == 5 || contractCurrencyInfo.getContractStatus() == 7) {
                this.E.setText(R.string.n_contract_trade_settling);
                this.F.setText(R.string.n_contract_trade_system_settling);
            } else if (contractCurrencyInfo.getContractStatus() == 6 || contractCurrencyInfo.getContractStatus() == 8) {
                this.E.setText(R.string.n_contract_trade_delivering);
                this.F.setText(R.string.n_contract_trade_system_delivering);
            } else if (contractCurrencyInfo.getContractStatus() == 3) {
                this.E.setText(R.string.n_contract_trade_stop);
                this.F.setText("");
            } else if (contractCurrencyInfo.getContractStatus() == 9) {
                this.E.setText(R.string.n_contract_trade_suspend);
                this.F.setText("");
            }
        }
        this.G.setVisibility(i11);
    }

    public void R0(boolean z11) {
        if (z11) {
            this.K0 = null;
            this.J0 = null;
            this.I0 = null;
            this.H0 = null;
        } else {
            int i11 = this.f43418e;
            if (i11 == 0) {
                this.J0 = null;
                this.H0 = null;
            } else if (i11 == 1) {
                this.K0 = null;
                this.I0 = null;
            }
        }
        this.f43461u.setText("");
        this.D.setText("");
    }

    public void S0(String str, String str2) {
        if (this.f43418e == 1) {
            this.D.setText(str);
        } else if (!this.D.getText().toString().equals(str2)) {
            this.D.setText(str2);
        }
    }

    public void T0(int i11) {
        SP.q("ContractTradeTogetherViewOrderType", i11);
        this.f43424g = i11;
        this.Z0.setSelected(false);
        i1(this.f43418e);
        ViewUtil.m(this.f43432i1, false);
        ViewUtil.m(this.f43435j1, true);
        x1();
        this.f43410b0.changeTradeOrderType(this.f43424g, this.f43418e, this.C0, this.D0);
        this.f43438k1.setVisibility(8);
        switch (this.f43424g) {
            case 0:
            case 3:
            case 4:
                this.f43438k1.setVisibility(0);
                int i12 = this.f43424g;
                if (i12 == 0) {
                    this.f43441l1.setText("GTC");
                } else if (i12 == 3) {
                    this.f43441l1.setText("IOC");
                } else {
                    this.f43441l1.setText("FOK");
                }
                this.f43467x.setVisibility(8);
                this.f43469y.setVisibility(8);
                this.f43433j.setText(getContext().getString(R.string.n_contract_order_type_limit));
                this.f43448o.setVisibility(8);
                this.Z0.setVisibility(0);
                this.Z0.setText(R.string.n_contract_trade_rival_price);
                this.f43458t.setPriceInputType(1);
                this.f43458t.setHintText((int) R.string.n_contract_trade_input_price);
                g1();
                break;
            case 1:
                this.f43467x.setVisibility(8);
                this.f43469y.setVisibility(8);
                this.f43433j.setText(getContext().getString(R.string.n_contract_order_type_trigger));
                this.f43448o.setVisibility(0);
                this.Z0.setVisibility(0);
                this.Z0.setText(R.string.n_contract_trade_optimal_n);
                this.f43450p.setPriceInputType(1);
                this.f43450p.setTradeUseType(1);
                this.f43450p.setDividerVisibility(8);
                this.f43450p.setLabelVisibility(8);
                this.f43458t.setPriceInputType(1);
                this.f43458t.setHintText((int) R.string.n_contract_trade_input_price);
                w0(true, false);
                break;
            case 2:
                this.f43467x.setVisibility(8);
                this.f43469y.setVisibility(8);
                this.f43433j.setText(getContext().getString(R.string.n_contract_trade_post_only));
                this.f43448o.setVisibility(8);
                this.Z0.setVisibility(8);
                this.f43458t.setPriceInputType(1);
                this.f43458t.setHintText((int) R.string.n_contract_trade_input_price);
                g1();
                break;
            case 5:
                this.f43433j.setText(getContext().getString(R.string.n_contract_track_order));
                this.f43448o.setVisibility(8);
                this.Z0.setVisibility(8);
                this.f43467x.setVisibility(0);
                this.f43469y.setVisibility(0);
                this.f43471z.setPriceInputType(2);
                this.f43471z.setCurrentPriceTypeText(this.G0.getString(R.string.n_contract_trade_optimal_twenty));
                this.f43471z.setPriceInputType(5);
                this.f43458t.setPriceInputType(1);
                this.f43458t.setHintText((int) R.string.n_contract_active_price);
                this.f43461u.setText("");
                break;
            case 6:
                this.f43467x.setVisibility(8);
                this.f43469y.setVisibility(8);
                this.f43433j.setText(getContext().getString(R.string.n_exchange_price_market_deal));
                this.f43448o.setVisibility(8);
                this.Z0.setVisibility(0);
                this.Z0.setText(R.string.n_contract_trade_rival_price);
                this.f43458t.setPriceInputType(1);
                this.f43458t.setHintText((int) R.string.n_contract_trade_input_price);
                g1();
                ViewUtil.m(this.f43432i1, true);
                ViewUtil.m(this.f43435j1, false);
                break;
        }
        t0();
        k1();
    }

    public void U0() {
        if (this.f43458t.getTradePriceType() == 1) {
            this.f43421f = false;
        } else {
            this.f43427h.f(false);
        }
    }

    public void V0(List<ContractDepth> list, int i11) {
        int size = list.size();
        this.X0.clear();
        for (int i12 = 0; i12 < size; i12++) {
            String priceTick = list.get(i12).getPriceTick();
            String plainString = !TextUtils.isEmpty(priceTick) ? i6.m.a(priceTick).stripTrailingZeros().toPlainString() : "--";
            if (i11 == i12) {
                this.X0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.STRESS, this.f43451p1));
            } else {
                this.X0.add(new MenuItem("", plainString, MenuItem.MenuItemStyle.COMMON, this.f43451p1));
            }
        }
        this.P0.setMenuItems(this.X0);
    }

    public boolean W0() {
        return this.f43418e == 0 && this.f43419e0.isChecked();
    }

    public void X0(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(new BigDecimal(str)) == 0) {
            this.f43463v.setVisibility(8);
            return;
        }
        this.f43465w.setText(AppUtil.b(String.format(this.G0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f43463v.setVisibility(0);
    }

    public void Y0(int i11) {
        if (!tg.r.x().F0()) {
            this.N.setVisibility(8);
            this.I.setVisibility(8);
            this.J.setText(R.string.n_contract_trade_log_in_to_exchange);
            this.L.setVisibility(8);
            k1();
            return;
        }
        ContractUserInfo.UserBean o11 = ContractUserInfoProvider.i().o();
        if (o11 == null || o11.getActiveState() == 1) {
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
            k1();
            return;
        }
        this.N.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setText(R.string.n_contract_delivery_open_dm_title);
        this.L.setVisibility(8);
        k1();
    }

    public void a() {
        this.Q0.bc(this.f43427h.r());
        this.Q0.xi(this.f43427h.k());
        this.Q0.vi(this.f43460t1);
        this.Q0.ti(this.f43427h.n());
        this.Q0.setTradeType(TradeType.CONTRACT);
        this.Q0.zi(ContractWebActivity.Eh(1));
        this.Q0.si(this.f43427h.j().getContractCode());
        this.Q0.show(((FragmentActivity) this.G0).getSupportFragmentManager(), "leverSelectDialogFragment");
    }

    public boolean b() {
        return (this.C0 == null && this.D0 == null) ? false : true;
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
            this.Z0.setEnabled(true);
            this.B.setEnabled(true);
            setLightingSelect(false);
            this.f43419e0.setChecked(gl.b.a(TradeType.CONTRACT));
        } else {
            this.Z0.setSelected(false);
            this.Z0.setEnabled(false);
            this.B.setEnabled(false);
            setLightingSelect(false);
            this.C0 = null;
            this.D0 = null;
            n1();
            m1();
            this.f43410b0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
            this.f43419e0.setChecked(false);
        }
        q2();
    }

    public final void f1(int i11) {
        this.f43429h1 = i11;
        this.f43414c1.hideKeyboard();
        t0();
        this.W = 5;
        this.f43427h.N(this.f43418e, i11);
        if (this.f43418e == 0) {
            this.J0 = null;
        } else {
            this.K0 = null;
        }
        k2();
    }

    public final void g1() {
        int i11 = this.f43415d;
        if (i11 == 0) {
            if (this.f43418e == 0) {
                L0();
            } else {
                U0();
            }
        } else if (i11 == 1) {
            if (this.f43418e == 0) {
                U0();
            } else {
                L0();
            }
        }
        w0(true, false);
    }

    public String getBondZeroDefault() {
        String r11 = this.f43427h.r();
        return BigDecimal.ZERO.setScale(FuturePrecisionUtil.g(this.f43427h.r()), 4).toPlainString() + r11;
    }

    public String getCallBackRateText() {
        return this.A.getText().toString();
    }

    public String getInputAmountText() {
        return this.D.getText().toString();
    }

    public EditText getInputPriceEt() {
        return this.f43461u;
    }

    public String getInputPriceText() {
        return this.f43461u.getText().toString();
    }

    public MagicIndicator getMagicIndicator() {
        return (MagicIndicator) findViewById(R.id.buy_shell_indicator);
    }

    public k4 getOnEditTextFocusChangeListener() {
        return this.f43408a1;
    }

    public String getOrderPlaceInputAmount() {
        String obj = this.D.getText().toString();
        if (getTradeAmountType() != 0 || getPositionType() != 0) {
            return obj;
        }
        TradeType tradeType = TradeType.CONTRACT;
        return (!a7.e.E(tradeType) || !a7.e.H(tradeType)) ? obj : i6.m.a(obj).multiply(i6.m.a(this.f43427h.n())).toPlainString();
    }

    public int getOrderType() {
        return this.f43424g;
    }

    public int getPositionType() {
        return this.f43418e;
    }

    public int getSeekBarProgress() {
        return this.f43407a0.getProgress();
    }

    public boolean getTpSlDialogOpenTypeisOpenLong() {
        return this.E0 == FutureTpSlSettingDialogFragment.OpenType.OpenLong;
    }

    public boolean getTpSlSwitchCheck() {
        return this.f43419e0.isChecked();
    }

    public int getTradeAmountType() {
        return this.W;
    }

    public int getTradePosition() {
        return this.f43415d;
    }

    public int getTradePriceType() {
        return this.f43458t.getTradePriceType();
    }

    public String getTriggerPriceText() {
        return this.f43452q.getText().toString();
    }

    public String getVolume() {
        String orderPlaceInputAmount = getOrderPlaceInputAmount();
        if (this.W != 5) {
            return orderPlaceInputAmount;
        }
        ContractAccountInfo contractAccountInfo = this.f43426g1;
        if (contractAccountInfo != null) {
            return i6.m.a(contractAccountInfo.getMarginAvailable()).multiply(BigDecimal.valueOf((long) this.f43429h1)).divide(BigDecimal.valueOf(100), 4, 4).toPlainString();
        }
        return null;
    }

    public String h1(boolean z11) {
        if (!tg.r.x().F0() || this.f43427h == null) {
            return "--";
        }
        try {
            FutureEarnestMoneyUtils f11 = FutureEarnestMoneyUtils.f();
            boolean z12 = true;
            f11.i(this.G0).t(getVolume()).q(this.Z0).h(a7.e.E(this.f43427h.o())).r(this.f43427h.o()).l(this.f43427h.n()).u(this.f43427h.r()).k(this.f43427h.j().getContractFace()).o(FuturePrecisionUtil.g(this.f43427h.r())).g(BigDecimal.valueOf(this.f43427h.l().v()).toPlainString()).j(getInputPriceText()).m(BigDecimal.valueOf(this.f43427h.l().z()).toPlainString()).p(BigDecimal.valueOf(this.f43427h.l().A()).toPlainString()).n(this.f43424g == 6);
            if (this.W != 5) {
                z12 = false;
            }
            return f11.a(z11, z12);
        } catch (FutureEarnestMoneyUtils.ZeroErr e11) {
            e11.printStackTrace();
            return getBondZeroDefault();
        }
    }

    public final void i1(int i11) {
        setLightingSelect(false);
    }

    public final void j1(int i11) {
        this.f43415d = i11;
        Y0(this.f43418e);
        M0(this.f43415d);
    }

    public final FutureTpSlSettingParams j2(FutureTpSlSettingParams futureTpSlSettingParams, boolean z11) {
        if (futureTpSlSettingParams != null) {
            this.E0 = futureTpSlSettingParams.getOpenType();
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
            n1();
        } else {
            m1();
        }
        return null;
    }

    public final void k1() {
        getViewTreeObserver().addOnPreDrawListener(new i());
    }

    public final void k2() {
        if (this.f43418e == 0) {
            this.f43466w0.setVisibility(0);
            this.f43468x0.setVisibility(0);
        } else {
            this.f43466w0.setVisibility(8);
            this.f43468x0.setVisibility(8);
        }
        this.f43470y0.setText(h1(true));
        this.f43472z0.setText(h1(false));
    }

    public void l(BigDecimal bigDecimal) {
        BigDecimal bigDecimal2;
        if (this.W != 0) {
            this.T.setVisibility(8);
        } else if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
            if (a7.e.E(TradeType.CONTRACT)) {
                int i11 = this.f43418e;
                if (i11 != 1 && i11 != 2) {
                    bigDecimal2 = bigDecimal.setScale(ej.f.t(this.f43427h.j().getContractCode()), 1);
                } else if (bigDecimal.compareTo(BigDecimal.ONE) < 0) {
                    bigDecimal2 = bigDecimal.setScale(ej.f.t(this.f43427h.j().getContractCode()), 0);
                } else {
                    bigDecimal2 = bigDecimal.setScale(ej.f.t(this.f43427h.j().getContractCode()), 1);
                }
                this.U.setText(String.format(this.G0.getString(R.string.two_label_with_space_with_abount), new Object[]{bigDecimal2.toPlainString(), this.G0.getString(R.string.n_contract_vol_sheet)}));
            } else {
                BigDecimal scale = bigDecimal.setScale(ej.f.n(this.f43427h.j().getContractCode()), 1);
                this.U.setText(String.format(this.G0.getString(R.string.two_label_with_space_with_abount), new Object[]{scale.toPlainString(), this.f43427h.r().toUpperCase(Locale.US)}));
            }
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
        k2();
    }

    public final void l1() {
        if (this.f43418e == 0) {
            if (this.L0) {
                this.f43461u.setText("");
            }
            this.N0 = true;
            return;
        }
        if (this.M0) {
            this.f43461u.setText("");
        }
        this.O0 = true;
    }

    public final void l2(View view, boolean z11) {
        if (z11) {
            view.setBackgroundResource(R.drawable.custom_edittext_blue_focused_bg);
        } else {
            view.setBackgroundResource(R.drawable.custom_edittext_normal_bg);
        }
    }

    public final void m1() {
        this.f43440l0.setText("");
    }

    public final void m2() {
        if (!a7.e.E(TradeType.CONTRACT)) {
            this.O.setText(String.format(this.G0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.G0.getString(R.string.n_contract_vol_sheet)}));
        } else if (TextUtils.isEmpty(this.f43427h.r())) {
            this.O.setText(R.string.n_contract_trade_input_amount);
        } else {
            this.O.setText(String.format(this.G0.getString(R.string.n_contract_trade_market_amount_label), new Object[]{this.f43427h.r()}));
        }
    }

    public void n0() {
    }

    public final void n1() {
        this.f43437k0.setText("");
    }

    public final void n2(String str, String str2, String str3) {
        this.f43462u0.setText(str);
        TextView textView = this.f43464v0;
        if (!TextUtils.equals("--", str2)) {
            str2 = AppUtil.b(str2, str3);
        }
        textView.setText(str2);
        this.f43470y0.setText(h1(true));
        this.f43472z0.setText(h1(false));
        if (this.f43418e == 0) {
            this.f43466w0.setVisibility(0);
            this.f43468x0.setVisibility(0);
        } else {
            this.f43466w0.setVisibility(8);
            this.f43468x0.setVisibility(8);
        }
        k2();
    }

    public void notifyDataSetChanged() {
        TradeTrendView tradeTrendView = this.V;
        if (tradeTrendView != null) {
            tradeTrendView.i();
        }
    }

    public final ContractOrderPlace o1(boolean z11) {
        ContractOrderPlace contractOrderPlace = new ContractOrderPlace();
        contractOrderPlace.B0(getInputPriceText());
        contractOrderPlace.d0(getOrderPlaceInputAmount());
        contractOrderPlace.h0(z11);
        contractOrderPlace.A0(this.f43418e);
        if (this.f43424g == 6) {
            contractOrderPlace.X0(8);
        } else {
            contractOrderPlace.X0(this.f43458t.getTradePriceType());
        }
        contractOrderPlace.g0(getTradeAmountType());
        contractOrderPlace.y0(this.f43424g);
        contractOrderPlace.Z0(getTriggerPriceText());
        contractOrderPlace.Y0(this.f43452q.getHint().toString());
        contractOrderPlace.e0(this.D.getHint().toString());
        contractOrderPlace.C0(this.f43461u.getHint().toString());
        contractOrderPlace.E0(getSeekBarProgress());
        contractOrderPlace.j0(this.A.getHint().toString());
        contractOrderPlace.U0(this.f43471z.getCurrentPriceTypeText());
        contractOrderPlace.k0(getCallBackRateText());
        contractOrderPlace.V0(this.f43471z.getTradePriceType());
        if (z11) {
            contractOrderPlace.W0(this.J.getText().toString());
        } else {
            contractOrderPlace.W0(this.K.getText().toString());
        }
        contractOrderPlace.x0(this.f43458t.getCurrentPriceTypeText());
        if (this.f43427h.j() != null) {
            contractOrderPlace.n0(this.f43427h.j().getContractType());
        }
        if (W0() && ContractTpslLayout.supportTpslOrder(this.f43424g)) {
            FutureTpSlSettingParams futureTpSlSettingParams = this.C0;
            if (futureTpSlSettingParams != null) {
                q1(contractOrderPlace, futureTpSlSettingParams);
            }
            FutureTpSlSettingParams futureTpSlSettingParams2 = this.D0;
            if (futureTpSlSettingParams2 != null) {
                p1(contractOrderPlace, futureTpSlSettingParams2);
            }
            if (!this.f43410b0.paramsIsAdvanced(this.C0, this.D0) && !(this.C0 == null && this.D0 == null)) {
                this.E0 = z11 ? FutureTpSlSettingDialogFragment.OpenType.OpenLong : FutureTpSlSettingDialogFragment.OpenType.OpenShort;
            }
        }
        return contractOrderPlace;
    }

    public final void o2(String str, String str2, String str3) {
        this.A0.setText(str);
        TextView textView = this.B0;
        if (!TextUtils.equals("--", str2)) {
            str2 = AppUtil.b(str2, str3);
        }
        textView.setText(str2);
        k2();
    }

    public void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0) {
            l1();
        }
    }

    public void p0(String str, String str2) {
        HBDialogFragment hBDialogFragment = this.f43417d1;
        if (hBDialogFragment == null || !hBDialogFragment.th()) {
            DialogUtils.b.d Q02 = new DialogUtils.b.d((FragmentActivity) oa.a.g().b()).c1(getContext().getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getContext().getString(R.string.n_known)).Q0(k2.f53706a);
            if (!TextUtils.isEmpty(str)) {
                Q02.s0(getContext().getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new j2(this, str));
            }
            HBDialogFragment k02 = Q02.k0();
            this.f43417d1 = k02;
            k02.show(((FragmentActivity) oa.a.g().b()).getSupportFragmentManager(), "");
        }
    }

    public final void p1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
        if (futureTpSlSettingParams != null) {
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
    }

    public final void p2() {
    }

    public void q0() {
        HBDialogFragment hBDialogFragment = this.f43417d1;
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    public final void q1(ContractOrderPlace contractOrderPlace, FutureTpSlSettingParams futureTpSlSettingParams) {
        if (futureTpSlSettingParams != null) {
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
    }

    public final void q2() {
        i6.i.b().g(new t2(this), 10);
    }

    public void r0() {
        this.U0.dismiss();
        this.V0.dismiss();
    }

    public final FutureTpSlSettingParams r1(FutureTpSlSettingParams futureTpSlSettingParams, FutureTpSlSettingParams futureTpSlSettingParams2) {
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

    public final boolean r2() {
        BigDecimal a11 = i6.m.a(getInputPriceText());
        if (getTradePriceType() != 1 || a11.compareTo(BigDecimal.ZERO) > 0) {
            return this.f43427h.J(o1(B1()));
        }
        HuobiToastUtil.l(getContext(), String.format(getContext().getString(R.string.input_unknow_text), new Object[]{this.f43461u.getHint().toString()}));
        return false;
    }

    public void s0() {
        for (MenuItem next : this.W0) {
            if (next.getType() == 0) {
                next.setStyle(MenuItem.MenuItemStyle.STRESS);
            } else {
                next.setStyle(MenuItem.MenuItemStyle.COMMON);
            }
        }
        this.f43427h.l().S(0);
        if (com.hbg.lib.core.util.w.l()) {
            this.S.setImageResource(R.drawable.trade_trend_default_green_red);
        } else {
            this.S.setImageResource(R.drawable.trade_trend_default_red_green);
        }
        this.V.c(0);
        this.f43427h.l().Y(false);
    }

    public void s1(FutureTpSlDialogShowBean futureTpSlDialogShowBean) {
        if (ContractTpslLayout.isLimitlOrder(this.f43424g) && !this.f43458t.k()) {
            futureTpSlDialogShowBean.setEntrustPrice(i6.m.a(getInputPriceText()));
        }
        if (a7.e.E(TradeType.CONTRACT)) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f43427h.q()).longValue()));
        } else if (this.W == 5) {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(this.f43427h.q()).longValue()));
        } else {
            futureTpSlDialogShowBean.setContVolume(Long.valueOf(i6.m.a(getInputAmountText()).longValue()));
        }
        futureTpSlDialogShowBean.setLever(this.f43427h.n());
        futureTpSlDialogShowBean.setSymbol(this.f43427h.r());
        if (this.f43427h.j() != null) {
            futureTpSlDialogShowBean.setContractType(this.f43427h.j().getContractType());
            futureTpSlDialogShowBean.setContractCode(this.f43427h.j().getContractCode());
            futureTpSlDialogShowBean.setContractShortType(this.f43427h.j().getContractShortType());
            futureTpSlDialogShowBean.setPricePrecision(ej.f.p(this.f43427h.j().getContractCode()));
            futureTpSlDialogShowBean.setPredictProfitPrecision(ej.f.n(this.f43427h.j().getContractCode()));
            futureTpSlDialogShowBean.setContractFace(i6.m.a(this.f43427h.j().getContractFace()));
        }
        futureTpSlDialogShowBean.setStopProfitSetting(r1(this.C0, this.D0));
        futureTpSlDialogShowBean.setStopLossSetting(r1(this.D0, this.C0));
    }

    public void s2(ContractAccountInfo contractAccountInfo) {
        this.f43426g1 = contractAccountInfo;
        k2();
    }

    public void setAmountEtText(String str) {
        this.D.setText(str);
    }

    public void setContractTradeViewController(q2 q2Var) {
        this.f43427h = q2Var;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f43444m1 = fragmentManager;
    }

    public void setHasTrade(boolean z11) {
        this.f43423f1 = z11;
    }

    public void setInputPriceUpdate(boolean z11) {
        this.f43421f = z11;
    }

    public void setKeyboardStateChangeListener(CustomBoardView.KeyBoardStateChangeListener keyBoardStateChangeListener) {
        this.f43414c1.getBoardView().setKeyBoardStateChangeListener(keyBoardStateChangeListener);
    }

    public void setLeverList(List<String> list) {
        if (list != null) {
            this.Q0.tc(list);
        }
    }

    public void setOnEditTextFocusChangeListener(k4 k4Var) {
        this.f43408a1 = k4Var;
    }

    public void setPositionType(int i11) {
        this.f43418e = i11;
    }

    public void setPriceAnimator(String str) {
        this.f43461u.setText(str);
        EditText editText = this.f43461u;
        editText.setSelection(editText.getText().length());
        CommonAnimateUtil.a(this.f43461u);
    }

    public void setPriceInputType(int i11) {
        this.f43458t.setPriceInputType(i11);
    }

    public void setPriceText(String str) {
        this.f43458t.setPriceInputType(1);
        this.Z0.setSelected(false);
        setLightingSelect(false);
        if (this.f43418e == 0) {
            this.L0 = false;
            this.H0 = str;
        } else {
            this.I0 = str;
            this.M0 = false;
        }
        int i11 = this.f43424g;
        if (i11 != 5 && i11 != 6) {
            setPriceAnimator(str);
        }
    }

    public void setTradePosition(int i11) {
        this.f43415d = i11;
    }

    public void setTriggerPriceTypeView(int i11) {
        this.f43450p.setDividerVisibility(8);
        this.f43450p.setLabelVisibility(8);
    }

    public void setViewVisibility(int i11) {
        setVisibility(i11);
    }

    public void t0() {
        this.f43461u.clearFocus();
        this.D.clearFocus();
        this.f43452q.clearFocus();
    }

    public final void t1() {
        if (this.f43458t.k()) {
            this.U0.showAsDropDown(((FragmentActivity) getContext()).getSupportFragmentManager(), (View) this.f43458t, true, 0, 0, 80);
        }
    }

    public void t2(EditText editText, String str) {
        editText.setText(str);
        editText.setSelection(editText.getText().length());
    }

    public void u0(boolean z11, boolean z12) {
        this.C0 = null;
        this.D0 = null;
        n1();
        m1();
        this.f43410b0.refreshTpSlView((FutureTpSlSettingParams) null, (FutureTpSlSettingParams) null);
        this.f43459t0.setVisibility(8);
        if (z12) {
            this.f43419e0.setChecked(false);
        }
    }

    public final void u1(Context context, AttributeSet attributeSet) {
        this.G0 = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.contract_trade_together_layout, this, true);
        this.V = (TradeTrendView) inflate.findViewById(R.id.contract_trade_trend_view);
        k1();
        this.f43433j = (TextView) inflate.findViewById(R.id.order_type_tv);
        this.f43420e1 = inflate.findViewById(R.id.iv_contract_guide);
        this.f43430i = inflate.findViewById(R.id.order_type_ll);
        this.f43436k = (ImageView) inflate.findViewById(R.id.order_type_arrow_iv);
        this.f43439l = (TextView) inflate.findViewById(R.id.contract_trade_lever_value_tv);
        this.f43442m = (ImageView) inflate.findViewById(R.id.contract_trade_lever_arrow_iv);
        this.f43445n = (RelativeLayout) inflate.findViewById(R.id.contract_trade_lever_ll);
        this.f43438k1 = (LinearLayout) inflate.findViewById(R.id.llLimitChoose);
        this.f43441l1 = (TextView) inflate.findViewById(R.id.tvLimitTitle);
        this.f43438k1.setOnClickListener(new z1(this));
        this.f43448o = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_view_container);
        ContractTradePriceEditext contractTradePriceEditext = (ContractTradePriceEditext) inflate.findViewById(R.id.contract_trigger_price_view);
        this.f43450p = contractTradePriceEditext;
        this.f43452q = contractTradePriceEditext.getEditText();
        this.f43454r = (ViewGroup) inflate.findViewById(R.id.contract_trigger_price_convert_container);
        this.f43456s = (TextView) inflate.findViewById(R.id.contract_trigger_price_convert_tv);
        ContractGearsTradePriceEditText contractGearsTradePriceEditText = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.contract_trade_price_view);
        this.f43458t = contractGearsTradePriceEditText;
        contractGearsTradePriceEditText.setClearEnable(true);
        this.f43461u = this.f43458t.getEditText();
        this.f43467x = inflate.findViewById(R.id.track_price_rl);
        this.f43469y = inflate.findViewById(R.id.call_back_rate_ll);
        this.f43471z = (ContractGearsTradePriceEditText) inflate.findViewById(R.id.track_price_view);
        this.A = (EditText) inflate.findViewById(R.id.call_back_rate_et);
        this.B = (ImageButton) inflate.findViewById(R.id.lighting_trade_ib);
        this.f43463v = (ViewGroup) inflate.findViewById(R.id.contract_price_convert_container);
        this.f43465w = (TextView) inflate.findViewById(R.id.contract_price_convert_tv);
        ContractTradeAmountView contractTradeAmountView = (ContractTradeAmountView) inflate.findViewById(R.id.contract_trade_amount_view);
        this.C = contractTradeAmountView;
        this.D = contractTradeAmountView.getEditText();
        this.E = (TextView) inflate.findViewById(R.id.trade_mask_title_tv);
        this.Y0 = (ViewGroup) inflate.findViewById(R.id.safeguard_trade_ll);
        ContractMaintenanceView contractMaintenanceView = new ContractMaintenanceView(this.G0);
        this.f43411b1 = contractMaintenanceView;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) contractMaintenanceView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f43411b1.setLayoutParams(layoutParams);
        this.Y0.addView(this.f43411b1);
        this.f43411b1.setTopMargin(84);
        this.f43411b1.h();
        this.f43411b1.setTradeSafeguardHint(getContext().getString(R.string.n_contract_service_in_maintain_market));
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
        this.f43462u0 = (TextView) inflate.findViewById(R.id.long_value_tv);
        this.A0 = (TextView) inflate.findViewById(R.id.short_value_tv);
        this.f43407a0 = (MultiColorSeekBar) inflate.findViewById(R.id.contract_seekbar_new);
        this.f43432i1 = inflate.findViewById(R.id.contract_market_rl);
        this.f43435j1 = inflate.findViewById(R.id.trade_price_ll_container);
        this.Z0 = (TextView) inflate.findViewById(R.id.contract_trade_rival_price_tv);
        ContractTpslLayout contractTpslLayout = (ContractTpslLayout) inflate.findViewById(R.id.contract_tp_sl_include);
        this.f43410b0 = contractTpslLayout;
        contractTpslLayout.setTradeType(TradeType.SWAP);
        this.f43413c0 = inflate.findViewById(R.id.contract_tp_sl_switch_container);
        this.f43416d0 = inflate.findViewById(R.id.contract_tp_sl_switch_iv_container);
        BottomLineTextView bottomLineTextView = (BottomLineTextView) inflate.findViewById(R.id.contract_tp_sl_tv);
        this.f43422f0 = bottomLineTextView;
        bottomLineTextView.setBottomLineText(getContext().getString(R.string.n_contract_trade_trend_stop));
        this.f43422f0.setTextColor(R.color.baseColorSecondaryText);
        this.f43419e0 = (CheckBox) inflate.findViewById(R.id.contract_tp_sl_switch_iv);
        this.f43425g0 = inflate.findViewById(R.id.contract_tp_sl_input_container);
        this.f43428h0 = inflate.findViewById(R.id.tp_sl_advanced_tv);
        ContractTpslEditText contractTpslEditText = (ContractTpslEditText) inflate.findViewById(R.id.contract_tp_input_container);
        this.f43431i0 = contractTpslEditText;
        this.f43437k0 = contractTpslEditText.getEditText();
        this.f43443m0 = this.f43431i0.getClearImageView();
        ContractTpslEditText contractTpslEditText2 = (ContractTpslEditText) inflate.findViewById(R.id.contract_sl_input_container);
        this.f43434j0 = contractTpslEditText2;
        this.f43440l0 = contractTpslEditText2.getEditText();
        this.f43446n0 = this.f43434j0.getClearImageView();
        k kVar = new k();
        this.f43431i0.setCallback(kVar);
        this.f43434j0.setCallback(kVar);
        this.f43459t0 = (TextView) inflate.findViewById(R.id.tp_sl_tag_tv);
        this.f43462u0 = (TextView) inflate.findViewById(R.id.long_value_tv);
        this.f43464v0 = (TextView) inflate.findViewById(R.id.long_value_tv1);
        this.B0 = (TextView) inflate.findViewById(R.id.short_value_tv1);
        this.f43466w0 = inflate.findViewById(R.id.ll_bond);
        this.f43468x0 = inflate.findViewById(R.id.ll_bond2);
        this.f43470y0 = (TextView) inflate.findViewById(R.id.tv_bond);
        this.f43472z0 = (TextView) inflate.findViewById(R.id.tv_bond2);
        v1(inflate);
        A1(inflate);
        y1();
        x1();
        z1();
        w1();
        this.f43414c1 = new HuobiKeyboardHelper().attach((Activity) this.G0).registerInput(this.f43452q, this.f43461u, this.A, this.f43437k0, this.f43440l0).registerInput(this.D, new h2(this));
        this.C.c(TradeType.CONTRACT, new q());
    }

    public void u2(String str) {
        if (TextUtils.isEmpty(str) || BigDecimal.ZERO.compareTo(i6.m.a(str)) == 0) {
            this.f43454r.setVisibility(8);
            return;
        }
        this.f43456s.setText(AppUtil.b(String.format(this.G0.getString(R.string.balance_total_cny), new Object[]{str}), LegalCurrencyConfigUtil.y().toUpperCase(Locale.US)));
        this.f43454r.setVisibility(0);
    }

    public void v0() {
        this.f43439l.setText("--");
        this.f43439l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        this.f43442m.setImageResource(0);
    }

    public final void v1(View view) {
        TextView textView = (TextView) view.findViewById(R.id.vertical_depth_tv);
        this.P = textView;
        textView.setText("--");
        this.Q = (ImageView) view.findViewById(R.id.vertical_depth_arrow_iv);
        this.R = view.findViewById(R.id.depth_ll);
        this.P0.setMenuItems(new ArrayList());
        this.P0.setCancelText(getResources().getText(R.string.n_contract_cancel).toString());
    }

    public void w0(boolean z11, boolean z12) {
        if (this.f43458t.getTradePriceType() == 1) {
            if (this.f43418e == 0 && !TextUtils.isEmpty(this.H0)) {
                this.f43461u.setText(this.H0);
            } else if (this.f43418e != 1 || TextUtils.isEmpty(this.I0)) {
                this.f43461u.setText("");
            } else {
                this.f43461u.setText(this.I0);
            }
        }
        if (z11) {
            this.f43452q.setText("");
            this.A.setText("");
        }
        if (z12 && this.f43424g != 5) {
            this.f43458t.setPriceInputType(1);
            this.Z0.setSelected(false);
            setLightingSelect(false);
        }
        if (this.f43418e == 0 && !TextUtils.isEmpty(this.J0)) {
            this.D.setText(this.J0);
        } else if (this.f43418e != 1 || TextUtils.isEmpty(this.K0)) {
            this.D.setText("");
        } else {
            this.D.setText(this.K0);
        }
        setProgress(0);
        this.T.setVisibility(8);
        this.f43414c1.hideKeyboard();
    }

    public final void w1() {
        this.H.setOnClickListener(new w2(this));
        this.I.setOnClickListener(new u2(this));
        this.f43450p.setOnEditTextFocusChangeListener(new s2(this));
        this.B.setOnClickListener(new z2(this));
        this.Z0.setOnClickListener(new y2(this));
        this.f43452q.addTextChangedListener(new t());
        this.f43458t.setOnEditTextFocusChangeListener(new dj.q2(this));
        this.f43458t.setOnClickListener(new x2(this));
        this.f43458t.setCallback(new u());
        this.f43461u.addTextChangedListener(new v());
        this.D.setOnFocusChangeListener(new e2(this));
        this.D.addTextChangedListener(new w());
        this.f43407a0.setOnProgressChangedListener(new x());
        this.V.setCallback(new a());
        this.V.setNewestPriceItemViewPreDrawListener(new b());
        this.R.setOnClickListener(new g2(this));
        this.f43445n.setOnClickListener(new v2(this));
        this.S.setOnClickListener(new w1(this));
        this.f43430i.setOnClickListener(new r2(this));
        this.R0.setDialogFragmentListener(new c());
        this.U0.setDialogFragmentListener(new d());
        this.Q0.setDialogFragmentListener(new e());
        this.P0.setBottomMenuShowListener(new p2(this));
        this.P0.setBottomMenuDismissListener(new o2(this));
        this.f43419e0.setOnCheckedChangeListener(new i2(this));
        this.f43420e1.setOnClickListener(new a3(this));
        this.f43419e0.setOnTouchListener(new f2(this));
        this.f43422f0.setOnClickListener(c2.f53655b);
        this.f43428h0.setOnClickListener(new b2(this, new l2(this)));
        this.f43443m0.setOnClickListener(new x1(this));
        this.f43446n0.setOnClickListener(new v1(this));
        this.f43469y.setOnClickListener(new y1(this));
        this.f43471z.setOnClickListener(new a2(this));
        this.f43471z.setCallback(new f());
        this.V0.setDialogFragmentListener(new g());
        this.A.addTextChangedListener(new h());
    }

    public void x0(String str) {
        this.f43439l.setText(String.format(this.G0.getString(R.string.contract_lever), new Object[]{str}));
        if (this.Q0.isResumed()) {
            this.f43442m.setImageResource(R.drawable.trade_arrow_up);
        } else {
            this.f43442m.setImageResource(R.drawable.trade_arrow_down);
        }
        if (i6.m.a(str).compareTo(BigDecimal.TEN) >= 0) {
            this.f43439l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorMajorTheme100));
        } else {
            this.f43439l.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText));
        }
    }

    public final void x1() {
        ArrayList arrayList = new ArrayList();
        if (this.f43424g == 1) {
            arrayList.add(new CommonPopListItem(3, this.G0.getString(R.string.n_contract_trade_optimal_five), this.f43455r1));
            arrayList.add(new CommonPopListItem(4, this.G0.getString(R.string.n_contract_trade_optimal_ten), this.f43455r1));
            arrayList.add(new CommonPopListItem(5, this.G0.getString(R.string.n_contract_trade_optimal_twenty), this.f43455r1));
        } else {
            arrayList.add(new CommonPopListItem(2, getBboStr(), ContextCompat.getColor(this.G0, R.color.baseColorPrimaryText), this.f43455r1));
            arrayList.add(new CommonPopListItem(3, this.G0.getString(R.string.n_contract_trade_optimal_five), this.f43455r1));
            arrayList.add(new CommonPopListItem(4, this.G0.getString(R.string.n_contract_trade_optimal_ten), this.f43455r1));
            arrayList.add(new CommonPopListItem(5, this.G0.getString(R.string.n_contract_trade_optimal_twenty), this.f43455r1));
        }
        this.U0.setData(arrayList);
    }

    public final void y1() {
        this.S0.clear();
        CommonPopListItem commonPopListItem = new CommonPopListItem(0, getContext().getString(R.string.n_contract_order_type_limit), ContextCompat.getColor(this.G0, R.color.baseColorPrimaryText), this.f43453q1);
        this.f43447n1 = commonPopListItem;
        this.S0.add(commonPopListItem);
        this.S0.add(new CommonPopListItem(6, getContext().getString(R.string.n_exchange_price_market_deal), ContextCompat.getColor(this.G0, R.color.baseColorPrimaryText), this.f43453q1));
        this.S0.add(new CommonPopListItem(1, getContext().getString(R.string.n_contract_order_type_trigger), this.f43453q1));
        this.S0.add(new CommonPopListItem(5, getContext().getString(R.string.n_contract_track_order), this.f43453q1));
        this.S0.add(new CommonPopListItem(2, getContext().getString(R.string.n_contract_trade_post_only), this.f43453q1));
        this.R0.setData(this.S0);
        this.R0.setFollowViewWidth(true);
    }

    public void z0(boolean z11) {
        this.H.setEnabled(z11);
        this.I.setEnabled(z11);
    }

    public final void z1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CommonPopListItem(7, this.G0.getString(R.string.n_contract_theoretical_price), ContextCompat.getColor(this.G0, R.color.baseColorPrimaryText), this.f43457s1));
        arrayList.add(new CommonPopListItem(3, this.G0.getString(R.string.n_contract_trade_optimal_five), this.f43457s1));
        arrayList.add(new CommonPopListItem(4, this.G0.getString(R.string.n_contract_trade_optimal_ten), this.f43457s1));
        arrayList.add(new CommonPopListItem(5, this.G0.getString(R.string.n_contract_trade_optimal_twenty), this.f43457s1));
        this.V0.setData(arrayList);
    }

    public ContractTradeTogetherView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f43409b = "coin_contract";
        this.f43412c = "contract_trade";
        this.f43424g = 0;
        this.E0 = FutureTpSlSettingDialogFragment.OpenType.OpenLong;
        this.L0 = true;
        this.M0 = true;
        this.N0 = true;
        this.O0 = true;
        this.P0 = new BottomMenuFragment();
        this.Q0 = new LeverSelectDialogFragment();
        this.R0 = new CommonListPopupDialog();
        this.S0 = new ArrayList();
        this.T0 = new BottomMenuFragment();
        this.U0 = new CommonListPopupDialog();
        this.V0 = new CommonListPopupDialog();
        this.W0 = new ArrayList();
        this.X0 = new ArrayList();
        this.f43449o1 = new j();
        this.f43451p1 = new l();
        this.f43453q1 = new m();
        this.f43455r1 = new n();
        this.f43457s1 = new o();
        this.f43460t1 = new p();
        u1(context, attributeSet);
    }
}
