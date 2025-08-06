package com.huobi.finance.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.ClosePathFloatView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.LoadingRelativeLayout;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.tablayout.TabItemLayoutData;
import com.hbg.lib.widgets.tablayout.TabItemLayoutIndicator;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.ui.AbstractMaintenanceView;
import com.huobi.finance.account.GridAssetAccount;
import com.huobi.finance.account.MiningAssetAccount;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.MiningDataTotal;
import com.huobi.finance.bean.OnChainDataTotal;
import com.huobi.finance.presenter.BalanceAssetPresenter;
import com.huobi.finance.ui.BalanceAndProfitView;
import com.huobi.finance.ui.x2;
import com.huobi.finance.utils.AssetAnimHelper;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.homemarket.helper.AppBarStateChangeListener;
import com.huobi.otc.widget.OtcOrderReminder;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import com.huobi.view.chart.data.PieEntry;
import com.huobi.view.rv.VerticalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.k0;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import vk.v;
import vp.i0;

public class BalanceAssetFragment extends BaseFragment<BalanceAssetPresenter, BalanceAssetPresenter.f> implements BalanceAssetPresenter.f, i0 {

    /* renamed from: e1  reason: collision with root package name */
    public static boolean f46300e1 = false;
    public int A = -1;
    public AssetSmartRefreshHeader A0;
    public String B;
    public Integer B0;
    public String C;
    public View C0;
    public Drawable D;
    public TextView D0;
    public Drawable E;
    public boolean E0;
    public BalanceTabIndicator F;
    public View F0;
    public BalanceNavigatorAdapter G;
    public int G0;
    public CommonNavigator H;
    public boolean H0;
    public List<String> I;
    public int I0;
    public List<Integer> J;
    public ViewPager J0;
    public TextView K;
    public ViewPager K0;
    public TextView L;
    public ViewPager.OnPageChangeListener L0;
    public TextView M;
    public ViewPager.OnPageChangeListener M0;
    public AssetSmartRefreshLayout N;
    public float N0;
    public int O;
    public TabItemLayoutIndicator O0;
    public int P;
    public TabItemLayoutIndicator P0;
    public int Q;
    public boolean Q0;
    public int R;
    public BalanceAndProfitView R0;
    public int S;
    public ImageView S0;
    public int T;
    public boolean T0;
    public View U;
    public ValueAnimator U0;
    public int V;
    public boolean V0;
    public int W;
    public Map<String, Integer> W0;
    public int X;
    public LoadingRelativeLayout X0;
    public int Y;
    public sk.a Y0;
    public float Z;
    public sk.a Z0;

    /* renamed from: a0  reason: collision with root package name */
    public float f46301a0;

    /* renamed from: a1  reason: collision with root package name */
    public sk.k f46302a1;

    /* renamed from: b0  reason: collision with root package name */
    public float f46303b0;

    /* renamed from: b1  reason: collision with root package name */
    public ImageView f46304b1;

    /* renamed from: c0  reason: collision with root package name */
    public AppBarLayout f46305c0;

    /* renamed from: c1  reason: collision with root package name */
    public View f46306c1;

    /* renamed from: d0  reason: collision with root package name */
    public float f46307d0;

    /* renamed from: d1  reason: collision with root package name */
    public RecyclerView f46308d1;

    /* renamed from: e0  reason: collision with root package name */
    public float f46309e0;

    /* renamed from: f0  reason: collision with root package name */
    public float f46310f0;

    /* renamed from: g0  reason: collision with root package name */
    public float f46311g0;

    /* renamed from: h0  reason: collision with root package name */
    public GradientDrawable f46312h0;

    /* renamed from: i0  reason: collision with root package name */
    public int f46313i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f46314j0;

    /* renamed from: k0  reason: collision with root package name */
    public int f46315k0;

    /* renamed from: l  reason: collision with root package name */
    public List<View> f46316l;

    /* renamed from: l0  reason: collision with root package name */
    public int f46317l0;

    /* renamed from: m  reason: collision with root package name */
    public List<View> f46318m;

    /* renamed from: m0  reason: collision with root package name */
    public PieChartDialogFragment f46319m0 = new PieChartDialogFragment();

    /* renamed from: n  reason: collision with root package name */
    public List<View> f46320n;

    /* renamed from: n0  reason: collision with root package name */
    public View f46321n0;

    /* renamed from: o  reason: collision with root package name */
    public List<RecyclerView> f46322o;

    /* renamed from: p  reason: collision with root package name */
    public List<LoadingLayout> f46323p;

    /* renamed from: q  reason: collision with root package name */
    public List<View> f46324q;

    /* renamed from: r  reason: collision with root package name */
    public SparseArray<EditText> f46325r;

    /* renamed from: s  reason: collision with root package name */
    public EditText f46326s;

    /* renamed from: t  reason: collision with root package name */
    public SparseArray<View> f46327t;

    /* renamed from: t0  reason: collision with root package name */
    public View f46328t0;

    /* renamed from: u  reason: collision with root package name */
    public SparseArray<TextView> f46329u;

    /* renamed from: u0  reason: collision with root package name */
    public Integer f46330u0;

    /* renamed from: v  reason: collision with root package name */
    public View f46331v;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f46332v0 = true;

    /* renamed from: w  reason: collision with root package name */
    public n<String> f46333w;

    /* renamed from: w0  reason: collision with root package name */
    public float f46334w0;

    /* renamed from: x  reason: collision with root package name */
    public n<String> f46335x;

    /* renamed from: x0  reason: collision with root package name */
    public float f46336x0;

    /* renamed from: y  reason: collision with root package name */
    public n<Drawable> f46337y;

    /* renamed from: y0  reason: collision with root package name */
    public float f46338y0;

    /* renamed from: z  reason: collision with root package name */
    public ViewPager f46339z;

    /* renamed from: z0  reason: collision with root package name */
    public float f46340z0;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            boolean unused = BalanceAssetFragment.this.H0 = false;
            BalanceAssetFragment.this.uj();
            ViewUtil.m(BalanceAssetFragment.this.C0, false);
            BalanceAssetFragment.this.f46305c0.requestLayout();
            BalanceAssetFragment.this.sk();
        }
    }

    public class b implements n<String> {

        /* renamed from: a  reason: collision with root package name */
        public String f46342a;

        public b() {
        }

        public void a(View view) {
            if ((view instanceof EditText) && BalanceAssetFragment.this.f46326s != view) {
                EditText editText = (EditText) view;
                TextWatcher textWatcher = editText.getTag() instanceof TextWatcher ? (TextWatcher) editText.getTag() : null;
                if (textWatcher != null) {
                    editText.removeTextChangedListener(textWatcher);
                }
                UiFillUtil.b(editText, this.f46342a, true);
                if (textWatcher != null) {
                    editText.addTextChangedListener(textWatcher);
                }
            }
        }

        /* renamed from: b */
        public void setValue(String str) {
            this.f46342a = str;
        }
    }

    public class c implements n<String> {

        /* renamed from: a  reason: collision with root package name */
        public String f46344a;

        public c() {
        }

        public void a(View view) {
            if (view != null) {
                view.setVisibility(TextUtils.isEmpty(this.f46344a) ? 8 : 0);
            }
        }

        /* renamed from: b */
        public void setValue(String str) {
            this.f46344a = str;
        }
    }

    public class d implements n<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        public Drawable f46346a;

        public d() {
        }

        public void a(View view) {
            if (view instanceof TextView) {
                ((TextView) view).setCompoundDrawables(this.f46346a, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        /* renamed from: b */
        public void setValue(Drawable drawable) {
            this.f46346a = drawable;
        }
    }

    public class e implements BalanceAndProfitView.c {
        public e() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).U1();
        }

        public void a() {
            new g7(BalanceAssetFragment.this.getContext(), BalanceAssetFragment.this.zh(), new v2(this)).f();
        }
    }

    public class f extends RecyclerView.OnScrollListener {
        public f() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            OtcOrderReminder.e().k(recyclerView, i11 != 0);
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            BalanceAssetFragment.this.sk();
        }
    }

    public class g implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f46350b;

        public g(List list) {
            this.f46350b = list;
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int R1 = ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).R1(4);
            if (R1 < 0) {
                R1 = ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).R1(0);
            }
            int i12 = R1 + i11;
            BalanceAssetFragment balanceAssetFragment = BalanceAssetFragment.this;
            balanceAssetFragment.fj(((BalanceAssetPresenter) balanceAssetFragment.yh()).D1(i12));
            BalanceAssetFragment balanceAssetFragment2 = BalanceAssetFragment.this;
            RecyclerView unused = balanceAssetFragment2.f46308d1 = balanceAssetFragment2.mj(i12);
            BalanceAssetFragment.this.nk();
            try {
                if (BalanceAssetFragment.this.getResources().getString(R$string.super_margin_title).equals(this.f46350b.get(i11))) {
                    BaseModuleConfig.a().b("222", (Map<String, Object>) null);
                } else if (BalanceAssetFragment.this.getResources().getString(R$string.trade_margin_title).equals(this.f46350b.get(i11))) {
                    BaseModuleConfig.a().b("221", (Map<String, Object>) null);
                } else if (BalanceAssetFragment.this.getResources().getString(R$string.string_c2c_margin).equals(this.f46350b.get(i11))) {
                    BaseModuleConfig.a().b("3965", (Map<String, Object>) null);
                } else if (BalanceAssetFragment.this.getResources().getString(R$string.c_to_c_lend).equals(this.f46350b.get(i11))) {
                    BaseModuleConfig.a().b("3966", (Map<String, Object>) null);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public class h implements ViewPager.OnPageChangeListener {
        public h() {
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            int R1 = ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).R1(3) + i11;
            BalanceAssetFragment balanceAssetFragment = BalanceAssetFragment.this;
            balanceAssetFragment.fj(((BalanceAssetPresenter) balanceAssetFragment.yh()).D1(R1));
            BalanceAssetFragment balanceAssetFragment2 = BalanceAssetFragment.this;
            RecyclerView unused = balanceAssetFragment2.f46308d1 = balanceAssetFragment2.mj(R1);
            BalanceAssetFragment.this.nk();
        }
    }

    public class i implements ny.d {
        public i() {
        }

        public void P8(ky.j jVar) {
        }

        public void bf(ky.j jVar) {
            BaseModuleConfig.a().T();
            ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).w1();
            ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).O1();
            BalanceAssetFragment.this.R0.x(((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).k2());
            ((BalanceAssetPresenter) BalanceAssetFragment.this.yh()).M3();
        }
    }

    public class j implements AppBarLayout.OnOffsetChangedListener {

        /* renamed from: b  reason: collision with root package name */
        public int f46354b;

        /* renamed from: c  reason: collision with root package name */
        public float f46355c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f46356d = true;

        /* renamed from: e  reason: collision with root package name */
        public int f46357e;

        /* renamed from: f  reason: collision with root package name */
        public float f46358f;

        /* renamed from: g  reason: collision with root package name */
        public float f46359g;

        /* renamed from: h  reason: collision with root package name */
        public int f46360h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f46361i;

        /* renamed from: j  reason: collision with root package name */
        public int f46362j;

        /* renamed from: k  reason: collision with root package name */
        public int f46363k;

        /* renamed from: l  reason: collision with root package name */
        public int f46364l;

        /* renamed from: m  reason: collision with root package name */
        public float f46365m;

        /* renamed from: n  reason: collision with root package name */
        public float f46366n;

        /* renamed from: o  reason: collision with root package name */
        public int f46367o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f46368p;

        public j() {
        }

        public void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
            int i12;
            if (BalanceAssetFragment.this.f46330u0 == null || BalanceAssetFragment.this.f46330u0.intValue() != i11) {
                Integer unused = BalanceAssetFragment.this.f46330u0 = Integer.valueOf(i11);
                BalanceAssetFragment balanceAssetFragment = BalanceAssetFragment.this;
                boolean unused2 = balanceAssetFragment.f46332v0 = balanceAssetFragment.f46330u0.intValue() == 0;
                BalanceAssetFragment.this.N.setEnabled(BalanceAssetFragment.this.f46332v0);
                BalanceAssetFragment.this.N.setRefreshHidden(!BalanceAssetFragment.this.f46332v0);
                if (BalanceAssetFragment.this.H0) {
                    i12 = Math.max(BalanceAssetFragment.this.V + i11, 0);
                    BalanceAssetFragment balanceAssetFragment2 = BalanceAssetFragment.this;
                    balanceAssetFragment2.qk(balanceAssetFragment2.C0, i12);
                } else {
                    i12 = 0;
                }
                BalanceAssetFragment balanceAssetFragment3 = BalanceAssetFragment.this;
                balanceAssetFragment3.qk(balanceAssetFragment3.F0, (BalanceAssetFragment.this.G0 - BalanceAssetFragment.this.V) + i12);
                int i13 = -(BalanceAssetFragment.this.G0 - (BalanceAssetFragment.this.I0 + BalanceAssetFragment.this.W));
                int max = Math.max(i11, i13);
                if (BalanceAssetFragment.this.H0 && (max = max + BalanceAssetFragment.this.V) > (-BalanceAssetFragment.this.V)) {
                    max -= i12;
                }
                float f11 = (float) max;
                BalanceAssetFragment.this.F0.setTranslationY(f11);
                int i14 = -BalanceAssetFragment.this.W;
                if (max < (-BalanceAssetFragment.this.Y)) {
                    i14 = (-BalanceAssetFragment.this.W) + Math.abs(BalanceAssetFragment.this.Y + max);
                }
                BalanceAssetFragment.this.U.setTranslationY((float) Math.min(i14, 0));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("BalanceAssetFragment-->onOffsetChanged--> verticalOffset = ");
                float f12 = (float) i11;
                sb2.append(PixelUtils.h(f12));
                sb2.append(" translationY = ");
                sb2.append(PixelUtils.h(f11));
                sb2.append(" mMinTabHeight = ");
                sb2.append(PixelUtils.h((float) BalanceAssetFragment.this.Y));
                sb2.append(" mMaxTabHeight = ");
                sb2.append(PixelUtils.h((float) BalanceAssetFragment.this.X));
                sb2.append(" tabBgTranslationY = ");
                sb2.append(PixelUtils.h((float) i14));
                i6.d.b(sb2.toString());
                if (this.f46354b == 0) {
                    this.f46354b = BalanceAssetFragment.this.f46305c0.getTotalScrollRange();
                    this.f46355c = BalanceAssetFragment.this.getResources().getDimension(R$dimen.dimen_85);
                }
                Math.abs(i11);
                if (BalanceAssetFragment.this.H0) {
                    int unused3 = BalanceAssetFragment.this.V;
                }
                if (i11 <= i13) {
                    this.f46358f = 1.0f;
                    this.f46362j = 0;
                } else {
                    this.f46362j = 8;
                    if (i11 >= (-BalanceAssetFragment.this.W)) {
                        this.f46358f = 0.0f;
                    } else {
                        this.f46358f = ((float) (-max)) / ((float) BalanceAssetFragment.this.X);
                    }
                }
                if (this.f46362j != this.f46357e) {
                    BalanceAssetFragment.this.f46328t0.setVisibility(this.f46362j);
                    this.f46357e = this.f46362j;
                }
                if (Float.compare(this.f46358f, 0.0f) != 0) {
                    BalanceAssetFragment.this.f46321n0.setVisibility(0);
                } else {
                    BalanceAssetFragment.this.f46321n0.setVisibility(8);
                }
                BalanceAssetFragment.this.f46321n0.setAlpha(this.f46358f);
                BalanceAssetFragment.this.f46331v.setAlpha(1.0f - this.f46358f);
                if (BalanceAssetFragment.this.G != null) {
                    this.f46368p = f12 <= (-BalanceAssetFragment.this.f46301a0);
                    this.f46367o = BalanceAssetFragment.this.f46315k0;
                    if (this.f46368p) {
                        float min = Math.min((BalanceAssetFragment.this.Z + f12) / BalanceAssetFragment.this.f46303b0, 0.0f);
                        this.f46363k = BalanceAssetFragment.this.Q;
                        this.f46364l = BalanceAssetFragment.this.P;
                        float f13 = 1.0f - min;
                        this.f46365m = f13;
                        float f14 = 1.0f - f13;
                        this.f46366n = f14;
                        if (Float.compare(f14, 0.0f) == 0) {
                            this.f46367o = BalanceAssetFragment.this.f46317l0;
                            this.f46366n = 1.0f;
                        }
                    } else {
                        this.f46365m = 1.0f;
                        this.f46366n = 1.0f;
                        this.f46363k = BalanceAssetFragment.this.f46314j0;
                        this.f46364l = BalanceAssetFragment.this.f46313i0;
                    }
                    BalanceAssetFragment.this.G.b(this.f46363k, this.f46364l, this.f46365m, this.f46366n, this.f46367o);
                    BalanceAssetFragment.this.lk(i11);
                }
                float Li = BalanceAssetFragment.this.f46307d0 + f12;
                this.f46359g = Li;
                if (Float.compare(Li, BalanceAssetFragment.this.f46309e0) <= 0) {
                    this.f46360h = (int) BalanceAssetFragment.this.f46309e0;
                } else {
                    this.f46360h = (int) this.f46359g;
                }
                if (Float.compare((float) this.f46360h, this.f46355c) <= 0) {
                    this.f46361i = true;
                } else {
                    this.f46361i = false;
                }
                boolean z11 = this.f46361i;
                if (z11 != this.f46356d) {
                    if (z11) {
                        BalanceAssetFragment.this.F.setBackground((Drawable) null);
                    } else {
                        BalanceAssetFragment.this.F.setBackgroundColor(BalanceAssetFragment.this.T);
                    }
                    this.f46356d = this.f46361i;
                }
            }
        }
    }

    public class k implements ViewPager.OnPageChangeListener {
        public k() {
        }

        public void onPageScrollStateChanged(int i11) {
            BalanceAssetFragment.this.Z7(false);
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
            BalanceAssetFragment.this.ik(i11);
        }
    }

    public class l extends bl.f {

        /* renamed from: g  reason: collision with root package name */
        public int f46371g = -1;

        public l(ViewPager viewPager) {
            super(viewPager);
        }

        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageSelected(int i11) {
        }
    }

    public class m extends AppBarStateChangeListener {
        public m() {
        }

        public void a(AppBarLayout appBarLayout, AppBarStateChangeListener.State state) {
            BalanceAssetFragment.this.K.setClickable(false);
            BalanceAssetFragment.this.L.setClickable(false);
            BalanceAssetFragment.this.M.setClickable(false);
            if (state == AppBarStateChangeListener.State.EXPANDED) {
                BalanceAssetFragment.this.K.setVisibility(0);
                BalanceAssetFragment.this.L.setVisibility(0);
                BalanceAssetFragment.this.M.setVisibility(0);
                BalanceAssetFragment.this.K.setClickable(true);
                BalanceAssetFragment.this.L.setClickable(true);
                BalanceAssetFragment.this.M.setClickable(true);
            } else if (state == AppBarStateChangeListener.State.COLLAPSED) {
                BalanceAssetFragment.this.K.setVisibility(4);
                BalanceAssetFragment.this.L.setVisibility(4);
                BalanceAssetFragment.this.M.setVisibility(4);
            } else {
                BalanceAssetFragment.this.K.setVisibility(0);
                BalanceAssetFragment.this.L.setVisibility(0);
                BalanceAssetFragment.this.M.setVisibility(0);
            }
        }
    }

    public interface n<T> {
        void a(View view);

        void setValue(T t11);
    }

    public class o extends StableLinearLayoutManager {

        /* renamed from: b  reason: collision with root package name */
        public c6.b<RecyclerView> f46374b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView f46375c;

        public o(Context context, RecyclerView recyclerView, c6.b<RecyclerView> bVar) {
            super(context);
            this.f46375c = recyclerView;
            this.f46374b = bVar;
        }

        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            super.onLayoutChildren(recycler, state);
            c6.b<RecyclerView> bVar = this.f46374b;
            if (bVar != null) {
                bVar.onCallback(this.f46375c);
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Bj(View view) {
        AssetModuleConfig.a().B(getActivity(), this);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Cj(int i11) {
        Integer num = this.B0;
        if (num == null || num.intValue() != i11) {
            this.B0 = Integer.valueOf(i11);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dj(View view) {
        BaseModuleConfig.a().b("3523", (Map<String, Object>) null);
        AssetModuleConfig.a().v0(getActivity(), "1");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ej(View view) {
        BaseModuleConfig.a().b("3524", (Map<String, Object>) null);
        AssetModuleConfig.a().v0(getActivity(), "2");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Fj(View view) {
        BaseModuleConfig.a().b("3525", (Map<String, Object>) null);
        AssetModuleConfig.a().q(getActivity());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Gj(boolean z11) {
        this.E0 = z11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hj(HBDialogFragment hBDialogFragment) {
        if (this.E0) {
            ConfigPreferences.n("user_config", "config_safety_hint", true);
            jj(false);
        } else {
            ConfigPreferences.n("user_config", "config_safety_hint", false);
        }
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Ij(View view) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new DialogUtils.b.d(activity).c1(getString(R$string.balance_safety_hint)).i1(1).M0(Integer.valueOf(R$drawable.popups_safety_img)).P0(getString(R$string.contract_trade_i_know)).x0(true).y0(getString(R$string.contract_trigger_order_change_not_show)).v0(new z1(this)).q0(false).Q0(new c2(this)).j0().show(getActivity().getSupportFragmentManager(), "");
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Jj() {
        LoadingRelativeLayout loadingRelativeLayout = this.X0;
        if (loadingRelativeLayout != null) {
            loadingRelativeLayout.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kj(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        qk(this.C0, intValue);
        int i11 = (this.G0 - this.V) + intValue;
        qk(this.F0, i11);
        qk(this.f46305c0, i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Lj(int i11) {
        this.K0.setCurrentItem(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mj(int i11) {
        this.J0.setCurrentItem(i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nj(View view) {
        ((BalanceAssetPresenter) yh()).I1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Oj(RecyclerView recyclerView) {
        sk();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Pj(View view, MotionEvent motionEvent) {
        if (getActivity() == null) {
            return false;
        }
        SoftInputUtils.f(getActivity());
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Rj(String str, View view) {
        DialogUtils.Y(getActivity(), str, (String) null, getResources().getString(R$string.balance_hide_zero_positive_btn), d2.f47084a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Sj(View view, boolean z11) {
        if (!z11 && getActivity() != null) {
            SoftInputUtils.f(getActivity());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Tj(View view) {
        ((BalanceAssetPresenter) yh()).K3();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void Uj(EditText editText, View view) {
        UiFillUtil.a(editText, "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean Vj(EditText editText, TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 3) {
            return false;
        }
        if (textView.getContext() instanceof Activity) {
            SoftInputUtils.f((Activity) textView.getContext());
        }
        ((BalanceAssetPresenter) yh()).H3(editText.getText().toString());
        return true;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Wj(View view) {
        ((BalanceAssetPresenter) yh()).I1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Xj(View view) {
        ((BalanceAssetPresenter) yh()).I1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Yj(View view) {
        ((BalanceAssetPresenter) yh()).I1();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Zj(View view) {
        rk();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ak() {
        sk.k kVar = this.f46302a1;
        if (kVar != null) {
            kVar.x();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bk(ValueAnimator valueAnimator) {
        this.F.g(valueAnimator.getAnimatedFraction());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ck(int i11) {
        if (((BalanceAssetPresenter) yh()).C1() == i11) {
            ((BalanceAssetPresenter) yh()).I1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dk() {
        LoadingRelativeLayout loadingRelativeLayout = this.X0;
        if (loadingRelativeLayout != null) {
            loadingRelativeLayout.b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ek() {
        LoadingRelativeLayout loadingRelativeLayout = this.X0;
        if (loadingRelativeLayout != null) {
            loadingRelativeLayout.b();
        }
    }

    public static /* synthetic */ void fk(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        k0.p(fragmentActivity, "btc");
        hBDialogFragment.dismiss();
    }

    public final void Aj() {
        v M1;
        if (((BalanceAssetPresenter) yh()).i2() && (M1 = ((BalanceAssetPresenter) yh()).M1(14)) != null) {
            this.f46316l.add(M1.b(), this.f46302a1.d(getActivity(), this.f46339z, new o2(this)));
            int R1 = ((BalanceAssetPresenter) yh()).R1(14);
            this.f46322o.add(R1, (Object) null);
            this.f46323p.add(R1, (Object) null);
            this.f46324q.add(R1, (Object) null);
        }
    }

    public void B6(int i11) {
        int i12;
        ImageView imageView = this.f46304b1;
        if (((BalanceAssetPresenter) yh()).b2()) {
            i12 = R$drawable.balances_show;
        } else {
            i12 = R$drawable.balances_hide;
        }
        imageView.setImageResource(i12);
        this.f46306c1.setVisibility(ti.a.a() ? 0 : 8);
        uj();
        if (!f46300e1 && this.C0.getVisibility() == 0) {
            f46300e1 = true;
            jj(true);
        }
        qk(this.f46305c0, this.G0);
        qk(this.F0, this.G0);
        ej();
    }

    public boolean Bh() {
        return true;
    }

    public void Da() {
        RecyclerView mj2 = mj(((BalanceAssetPresenter) yh()).R1(this.A));
        if (mj2 != null) {
            mj2.scrollToPosition(0);
        }
    }

    public void Db(int i11) {
        LoadingLayout lj2 = lj(i11);
        if (lj2 != null) {
            pa(i11);
            lj2.setVisibility(0);
            lj2.setTag(Boolean.FALSE);
            lj2.i();
        }
        ViewUtil.m(oj(i11), true);
    }

    public void De() {
        Drawable drawable;
        if (((BalanceAssetPresenter) yh()).c2()) {
            if (this.D == null) {
                Drawable drawable2 = ContextCompat.getDrawable(getActivity(), R$drawable.maket_edit_unselected);
                this.D = drawable2;
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), this.D.getMinimumHeight());
            }
            drawable = this.D;
        } else {
            if (this.E == null) {
                Drawable drawable3 = ContextCompat.getDrawable(getActivity(), R$drawable.maket_edit_selected);
                this.E = drawable3;
                drawable3.setBounds(0, 0, drawable3.getMinimumWidth(), this.E.getMinimumHeight());
            }
            drawable = this.E;
        }
        if (this.f46337y == null) {
            this.f46337y = new d();
        }
        this.f46337y.setValue(drawable);
        hk(this.f46329u, this.f46337y);
    }

    public void L4(int i11) {
        LoadingLayout lj2 = lj(i11);
        if (lj2 != null) {
            pa(i11);
            lj2.setVisibility(8);
            lj2.setTag(Boolean.FALSE);
        }
        ViewUtil.m(oj(i11), true);
    }

    public void L8() {
        uj();
    }

    public boolean O7() {
        int i11;
        ViewPager viewPager = this.f46339z;
        if (viewPager == null) {
            i11 = 0;
        } else {
            i11 = viewPager.getCurrentItem();
        }
        RecyclerView mj2 = mj(i11);
        if (mj2 == null || mj2.getScrollState() == 0) {
            return true;
        }
        return false;
    }

    public void Qc(BaseAssetTotal baseAssetTotal) {
        this.R0.n(!((BalanceAssetPresenter) yh()).b2());
        this.N.finishRefresh();
    }

    public void Vf() {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new h2(this));
        }
    }

    public void X4(EditText editText) {
        this.f46326s = editText;
    }

    public void Y8(v9.a aVar, int i11) {
        RecyclerView mj2 = mj(i11);
        if (mj2 != null) {
            mj2.setAdapter(aVar);
        }
    }

    public void Z7(boolean z11) {
        AssetSmartRefreshLayout assetSmartRefreshLayout = this.N;
        if (assetSmartRefreshLayout != null && assetSmartRefreshLayout.M()) {
            this.N.D(false);
        }
    }

    public void clear() {
        this.R0.j();
    }

    public int df(int i11) {
        if (this.J == null) {
            ArrayList arrayList = new ArrayList();
            this.J = arrayList;
            arrayList.add(Integer.valueOf(ContextCompat.getColor(getActivity(), R$color.balance_main_pie_chart_first)));
            this.J.add(Integer.valueOf(ContextCompat.getColor(getActivity(), R$color.balance_main_pie_chart_second)));
            this.J.add(Integer.valueOf(ContextCompat.getColor(getActivity(), R$color.balance_main_pie_chart_third)));
            this.J.add(Integer.valueOf(ContextCompat.getColor(getActivity(), R$color.balance_main_pie_chart_fouth)));
            this.J.add(Integer.valueOf(ContextCompat.getColor(getActivity(), R$color.balance_main_pie_chart_five)));
            this.J.add(Integer.valueOf(ContextCompat.getColor(getActivity(), R$color.balance_main_pie_chart_six)));
        }
        List<Integer> list = this.J;
        if (i11 < 0 || i11 >= list.size()) {
            i11 = this.J.size() - 1;
        }
        return list.get(i11).intValue();
    }

    public void dismissProgressDialog() {
        i6.i.b().d(new k2(this));
    }

    public final void ej() {
        this.f46306c1.setOnClickListener(new q2(this));
        this.A0.setOnHeightChangeListener(new g2(this));
        this.N.e0(new i());
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f46312h0 = gradientDrawable;
        gradientDrawable.setColor(this.S);
        this.f46312h0.setStroke((int) this.f46310f0, this.R);
        this.f46312h0.setCornerRadius(this.f46311g0);
        this.K.setOnClickListener(new r2(this));
        this.L.setOnClickListener(new q1(this));
        this.M.setOnClickListener(new t2(this));
        this.f46305c0.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new j());
        this.f46339z.addOnPageChangeListener(new k());
        ViewPager viewPager = this.f46339z;
        viewPager.addOnPageChangeListener(new l(viewPager));
        this.f46305c0.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new m());
        this.D0.setOnClickListener(new r1(this));
    }

    public final void fj(int i11) {
        if (this.A != i11) {
            this.A = i11;
            ((BalanceAssetPresenter) yh()).O3(this.A);
            ((BalanceAssetPresenter) yh()).I1();
        }
    }

    public final boolean gj() {
        return ((BalanceAssetPresenter) yh()).C1() == 1;
    }

    public final boolean hj() {
        int C1 = ((BalanceAssetPresenter) yh()).C1();
        return (C1 == 0 || C1 == 4 || C1 == 7 || C1 == 8) || (C1 == 3 || C1 == 6 || C1 == 11 || C1 == 10);
    }

    public final void hk(SparseArray<? extends View> sparseArray, n nVar) {
        if (nVar != null && sparseArray != null && sparseArray.size() != 0) {
            int size = sparseArray.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (((View) sparseArray.valueAt(i11)) != null) {
                    nVar.a((View) sparseArray.valueAt(i11));
                }
            }
        }
    }

    public void ie() {
        this.Y0 = new MiningAssetAccount();
        this.Z0 = new GridAssetAccount();
        sk.k kVar = new sk.k(getActivity());
        this.f46302a1 = kVar;
        kVar.F(this);
        yj();
        vj();
        wj();
        this.f46339z.setAdapter(new yg.e(this.f46316l));
    }

    /* renamed from: ij */
    public BalanceAssetPresenter xh() {
        return new BalanceAssetPresenter();
    }

    public final void ik(int i11) {
        v M1;
        v M12;
        mk(i11);
        int indexOf = this.I.indexOf(getResources().getString(R$string.margin_toolbar_header_title));
        if (i11 == this.I.indexOf(getResources().getString(R$string.n_balance_contract_title))) {
            this.M0.onPageSelected(this.K0.getCurrentItem());
        } else if (i11 == indexOf) {
            this.L0.onPageSelected(this.J0.getCurrentItem());
        } else {
            int intValue = this.W0.get(this.I.get(i11)).intValue();
            fj(intValue);
            this.f46308d1 = mj(((BalanceAssetPresenter) yh()).R1(intValue));
        }
        if (((BalanceAssetPresenter) yh()).e2() && (M12 = ((BalanceAssetPresenter) yh()).M1(13)) != null && M12.b() == i11) {
            BaseModuleConfig.a().b("5968", (Map<String, Object>) null);
        }
        if (((BalanceAssetPresenter) yh()).j2() && (M1 = ((BalanceAssetPresenter) yh()).M1(15)) != null && M1.b() == i11) {
            BaseModuleConfig.a().d("6063", (Map<String, Object>) null, "1005006");
        }
        nk();
        Boolean bool = ((BalanceAssetPresenter) yh()).E1().get(Integer.valueOf(this.A));
        this.N.setEnabled(bool == null ? true : bool.booleanValue());
    }

    public void initViews() {
        this.T0 = AppLanguageHelper.getInstance().isChineseLanguage();
        this.f46306c1 = this.f67460i.b(R$id.tv_cloud_wallet);
        this.Q0 = BaseModuleConfig.a().c();
        this.X0 = (LoadingRelativeLayout) this.f67460i.b(R$id.main_loading);
        this.C0 = this.f67460i.b(R$id.balance_safety_layout);
        this.D0 = (TextView) this.f67460i.b(R$id.balance_safety_see_tv);
        this.F0 = this.f67460i.b(R$id.total_balance_appbar_layout_real);
        BalanceAndProfitView balanceAndProfitView = (BalanceAndProfitView) this.f67460i.b(R$id.profit_loss_container);
        this.R0 = balanceAndProfitView;
        balanceAndProfitView.setCallback(new e());
        this.f46304b1 = (ImageView) this.R0.findViewById(R$id.iv_total_balance_show);
        this.R0.findViewById(R$id.ll_total_title).setOnClickListener(new p2(this));
        boolean z11 = !ConfigPreferences.c("user_config", "config_safety_hint", false);
        this.H0 = z11;
        if (z11) {
            this.C0.setVisibility(0);
        } else {
            this.C0.setVisibility(8);
        }
        tj();
        this.U = this.f67460i.b(R$id.balance_search_bg);
        this.N = (AssetSmartRefreshLayout) this.f67460i.b(R$id.refresh_layout);
        this.A0 = new AssetSmartRefreshHeader(getActivity());
        this.N.i(true);
        this.N.g(false);
        this.N.V(false);
        this.N.j0(this.A0);
        this.f46331v = this.f67460i.b(R$id.total_balance_header_item_layout);
        this.f46305c0 = (AppBarLayout) this.f67460i.b(R$id.total_balance_appbar_layout);
        this.f46321n0 = this.f67460i.b(R$id.balance_top_func);
        this.F = (BalanceTabIndicator) this.f67460i.b(R$id.market_tab);
        this.S0 = (ImageView) this.f67460i.b(R$id.iv_tab_arrow);
        this.K = (TextView) this.f67460i.b(R$id.total_balance_deposit);
        this.L = (TextView) this.f67460i.b(R$id.total_balance_withdraw);
        this.M = (TextView) this.f67460i.b(R$id.total_balance_transfer);
        this.f46328t0 = this.f67460i.b(R$id.divider_title_top);
        this.f46339z = (ViewPager) this.f67460i.b(R$id.total_balance_viewpager);
        this.B = getResources().getString(R$string.global_crossbar);
        this.C = getResources().getString(R$string.balance_hide_star);
    }

    public final void jj(boolean z11) {
        int i11;
        int i12;
        if (this.C0 != null) {
            if (z11) {
                i11 = getResources().getDimensionPixelOffset(R$dimen.dimen_40);
                i12 = 0;
            } else {
                i12 = getResources().getDimensionPixelOffset(R$dimen.dimen_40);
                i11 = 0;
            }
            ValueAnimator duration = ValueAnimator.ofInt(new int[]{i12, i11}).setDuration(200);
            duration.addUpdateListener(new p1(this));
            if (!z11) {
                duration.addListener(new a());
            }
            duration.start();
        }
    }

    public final void jk() {
        this.A = -1;
        ((BalanceAssetPresenter) yh()).W1();
        ie();
        ((BalanceAssetPresenter) yh()).Y1();
    }

    public void kf(int i11) {
        this.A = i11;
        try {
            int pj2 = pj(i11);
            int currentItem = this.f46339z.getCurrentItem();
            this.f46339z.setCurrentItem(pj2, false);
            if (currentItem == pj2) {
                ik(pj2);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        ((BalanceAssetPresenter) yh()).O1();
    }

    public final AbstractMaintenanceView kj(ViewGroup viewGroup) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof AbstractMaintenanceView) {
                return (AbstractMaintenanceView) childAt;
            }
        }
        return null;
    }

    public final void kk() {
        boolean isChineseLanguage = AppLanguageHelper.getInstance().isChineseLanguage();
        if (this.T0 != isChineseLanguage) {
            BalanceNavigatorAdapter balanceNavigatorAdapter = new BalanceNavigatorAdapter(this.f46339z, this.I, this.f46314j0, this.f46313i0);
            this.G = balanceNavigatorAdapter;
            this.H.setAdapter(balanceNavigatorAdapter);
            this.T0 = isChineseLanguage;
        }
        this.F.n();
    }

    public final LoadingLayout lj(int i11) {
        List<LoadingLayout> list = this.f46323p;
        if (list == null || list.isEmpty() || i11 < 0 || i11 >= this.f46323p.size()) {
            return null;
        }
        return this.f46323p.get(i11);
    }

    public final void lk(int i11) {
        int i12;
        boolean z11 = true;
        boolean z12 = ((this.f46301a0 - ((float) PixelUtils.a(17.0f))) + ((float) this.W)) + ((float) i11) < 0.0f;
        if (!z12) {
            this.V0 = true;
        }
        float f11 = (float) (-i11);
        if (this.f46301a0 - ((float) PixelUtils.a(17.0f)) >= f11) {
            z11 = false;
        }
        if (!z11) {
            float a11 = (this.f46301a0 - ((float) PixelUtils.a(17.0f))) * 0.5f;
            float f12 = 1.0f;
            if (f11 > a11) {
                f12 = 1.0f - ((f11 - a11) / a11);
            }
            this.F.g(f12);
        }
        if (z11 && !z12) {
            this.F.g(0.0f);
        }
        if (z12) {
            if (this.U0 == null) {
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                this.U0 = ofFloat;
                ofFloat.setDuration(200);
                this.U0.addUpdateListener(new a2(this));
            }
            if (!this.U0.isRunning() && this.V0) {
                this.U0.start();
                this.V0 = false;
            }
        }
        BalanceTabIndicator balanceTabIndicator = this.F;
        if (z12) {
            i12 = R$drawable.bluebg_arrow_icon;
        } else {
            i12 = R$drawable.otc_arrow_icon;
        }
        balanceTabIndicator.h(i12);
    }

    public void m8() {
        this.R0.x(((BalanceAssetPresenter) yh()).k2());
    }

    public final RecyclerView mj(int i11) {
        List<RecyclerView> list = this.f46322o;
        if (list == null || list.isEmpty() || i11 < 0 || i11 >= this.f46322o.size()) {
            return null;
        }
        return this.f46322o.get(i11);
    }

    public final void mk(int i11) {
        if (getResources().getString(R$string.n_mining_account).replace("账户", "").equals(this.I.get(i11))) {
            AnalyticsExposureItem analyticsExposureItem = new AnalyticsExposureItem();
            analyticsExposureItem.setPageId("1005305");
            analyticsExposureItem.setName("资产页挖矿宝账户页面");
            BaseModuleConfig.a().Y(analyticsExposureItem);
        }
    }

    public final View nj() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.layout_margin_asset, this.f46339z, false);
        this.P0 = (TabItemLayoutIndicator) inflate.findViewById(R$id.rect_tab_layout);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.n_balance_contract_contract_title));
        arrayList.add(getResources().getString(R$string.n_balance_contract_swap_title));
        arrayList.add(getResources().getString(R$string.n_balance_contract_linear_swap_title));
        arrayList.add(getResources().getString(R$string.n_balance_option_contract));
        ArrayList arrayList2 = new ArrayList();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
            tabItemLayoutData.setMiddleTabText((String) arrayList.get(i11));
            tabItemLayoutData.setCheck(i11 == 0);
            arrayList2.add(tabItemLayoutData);
            i11++;
        }
        this.P0.setTabItemLayoutData(arrayList2);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R$id.vp_margin);
        this.K0 = viewPager;
        viewPager.setAdapter(new yg.e(this.f46320n));
        h hVar = new h();
        this.M0 = hVar;
        this.K0.addOnPageChangeListener(hVar);
        this.P0.setItemClickCallBack(new m2(this));
        return inflate;
    }

    public final void nk() {
        AppBarLayout appBarLayout = this.f46305c0;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(true, AssetAnimHelper.b());
        }
        Da();
    }

    public boolean o4() {
        LoadingLayout lj2 = lj(((BalanceAssetPresenter) yh()).R1(((BalanceAssetPresenter) yh()).C1()));
        if (lj2 == null) {
            return false;
        }
        Object tag = lj2.getTag();
        if (tag instanceof Boolean) {
            return ((Boolean) tag).booleanValue();
        }
        return false;
    }

    public final View oj(int i11) {
        List<View> list = this.f46324q;
        if (list == null || list.isEmpty() || i11 < 0 || i11 >= this.f46324q.size()) {
            return null;
        }
        return this.f46324q.get(i11);
    }

    public void ok(boolean z11) {
        this.N.setEnabled(z11);
        ((BalanceAssetPresenter) yh()).E1().put(Integer.valueOf(this.A), Boolean.valueOf(z11));
    }

    public void onPieItemClick(int i11, PieEntry pieEntry) {
        this.f46319m0.onPieItemClick(i11, pieEntry);
    }

    public void p6(BaseAssetTotal baseAssetTotal, List<PieEntry> list, List<Integer> list2) {
        this.f46319m0.xh(baseAssetTotal, list, list2);
        this.f46319m0.show(getActivity().getSupportFragmentManager(), "pieChart");
    }

    public void pa(int i11) {
        int D1 = ((BalanceAssetPresenter) yh()).D1(i11);
        if (sj(D1)) {
            View view = this.f46320n.get(i11 - ((BalanceAssetPresenter) yh()).R1(3));
            if (view instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                AbstractMaintenanceView kj2 = kj(constraintLayout);
                if (!AssetModuleConfig.a().b0(D1)) {
                    ViewUtil.m(kj2, false);
                } else if (kj2 == null) {
                    AbstractMaintenanceView o11 = AbstractMaintenanceView.o(constraintLayout.getContext(), D1);
                    o11.f(false);
                    o11.setUI(zh());
                    o11.setRetryText(R$string.common_reloading_2);
                    o11.setOnMaintenanceEndListener(new f2(this, D1));
                    o11.setCountDownTime(AssetModuleConfig.a().L(D1));
                    constraintLayout.addView(o11, new ConstraintLayout.LayoutParams(-1, -1));
                } else {
                    ViewUtil.m(kj2, true);
                    kj2.setCountDownTime(AssetModuleConfig.a().L(D1));
                }
            }
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_total_balance, viewGroup, false);
    }

    public final int pj(int i11) {
        v M1 = ((BalanceAssetPresenter) yh()).M1(i11);
        if (M1 == null) {
            return 0;
        }
        int b11 = M1.b();
        int c11 = M1.c();
        if (c11 >= 0) {
            if (((BalanceAssetPresenter) yh()).Z1(i11)) {
                this.P0.onItemClick(c11);
            } else if (((BalanceAssetPresenter) yh()).a2(i11)) {
                this.O0.onItemClick(c11);
            }
        }
        return b11;
    }

    public final void pk(int i11) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setStatusBarColor(i11);
        }
    }

    public void qd() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            new DialogUtils.b.d(activity).c1(getResources().getString(R$string.balance_exchange_dialog_content)).E0(false).i1(1).M0(Integer.valueOf(R$drawable.account_popup_window_image)).P0(getResources().getString(R$string.index_deal_guide_fiat)).Q0(new b2(activity)).N0(e2.f47098a).j0().show(activity.getSupportFragmentManager(), "");
        }
    }

    public final View qj() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.layout_margin_asset, this.f46339z, false);
        this.O0 = (TabItemLayoutIndicator) inflate.findViewById(R$id.rect_tab_layout);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getString(R$string.balance_super_margin_title));
        arrayList.add(getResources().getString(R$string.balance_margin_title));
        if (((BalanceAssetPresenter) yh()).F1().indexOfValue(7) >= 0) {
            arrayList.add(getResources().getString(R$string.balance_c2c_margin_title));
        }
        if (((BalanceAssetPresenter) yh()).F1().indexOfValue(8) >= 0) {
            arrayList.add(getResources().getString(R$string.c_to_c_loan));
        }
        ArrayList arrayList2 = new ArrayList();
        int i11 = 0;
        while (i11 < arrayList.size()) {
            TabItemLayoutData tabItemLayoutData = new TabItemLayoutData();
            tabItemLayoutData.setMiddleTabText((String) arrayList.get(i11));
            tabItemLayoutData.setCheck(i11 == 0);
            arrayList2.add(tabItemLayoutData);
            i11++;
        }
        this.O0.setTabItemLayoutData(arrayList2);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R$id.vp_margin);
        this.J0 = viewPager;
        viewPager.setAdapter(new yg.e(this.f46318m));
        g gVar = new g(arrayList);
        this.L0 = gVar;
        this.J0.addOnPageChangeListener(gVar);
        this.O0.setItemClickCallBack(new n2(this));
        return inflate;
    }

    public final void qk(View view, int i11) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i11;
            view.setLayoutParams(layoutParams);
        }
    }

    public void ra(int i11) {
        LoadingLayout lj2 = lj(i11);
        if (lj2 != null) {
            lj2.setVisibility(0);
            lj2.setTag(Boolean.TRUE);
            lj2.p();
        }
    }

    /* renamed from: rj */
    public BalanceAssetPresenter.f zh() {
        return this;
    }

    public final void rk() {
        ((BalanceAssetPresenter) yh()).I3();
        yc();
    }

    public void showProgressDialog() {
        i6.i.b().d(new i2(this));
    }

    public final boolean sj(int i11) {
        return i11 == 3 || i11 == 6 || i11 == 11 || i11 == 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        if (r2 < r1) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        if (r2 < r1) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sk() {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r5.f46308d1
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.hbg.lib.common.mvp.BaseFragmentPresenter r0 = r5.yh()
            com.huobi.finance.presenter.BalanceAssetPresenter r0 = (com.huobi.finance.presenter.BalanceAssetPresenter) r0
            com.hbg.lib.common.mvp.BaseFragmentPresenter r1 = r5.yh()
            com.huobi.finance.presenter.BalanceAssetPresenter r1 = (com.huobi.finance.presenter.BalanceAssetPresenter) r1
            int r1 = r1.C1()
            int r0 = r0.R1(r1)
            if (r0 < 0) goto L_0x00b5
            java.util.List<android.view.View> r1 = r5.f46324q
            int r1 = r1.size()
            if (r0 < r1) goto L_0x0025
            goto L_0x00b5
        L_0x0025:
            java.util.List<android.view.View> r1 = r5.f46324q
            java.lang.Object r0 = r1.get(r0)
            android.view.View r0 = (android.view.View) r0
            if (r0 != 0) goto L_0x0030
            return
        L_0x0030:
            float r1 = r5.f46334w0
            boolean r2 = r5.hj()
            if (r2 == 0) goto L_0x0061
            float r1 = r5.f46334w0
            float r2 = r5.N0
            float r1 = r1 - r2
            androidx.recyclerview.widget.RecyclerView r2 = r5.f46308d1
            int r2 = r2.computeVerticalScrollOffset()
            com.hbg.lib.common.mvp.BaseFragmentPresenter r3 = r5.yh()
            com.huobi.finance.presenter.BalanceAssetPresenter r3 = (com.huobi.finance.presenter.BalanceAssetPresenter) r3
            int r3 = r3.C1()
            r4 = 8
            if (r3 != r4) goto L_0x0054
            float r3 = r5.f46340z0
            goto L_0x0055
        L_0x0054:
            r3 = 0
        L_0x0055:
            float r4 = r5.f46334w0
            float r2 = (float) r2
            float r4 = r4 - r2
            float r4 = r4 + r3
            int r2 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r2 > 0) goto L_0x005f
            goto L_0x009e
        L_0x005f:
            r1 = r4
            goto L_0x009e
        L_0x0061:
            boolean r2 = r5.gj()
            if (r2 == 0) goto L_0x007b
            float r1 = r5.f46334w0
            float r2 = r5.f46336x0
            float r2 = r2 + r1
            androidx.recyclerview.widget.RecyclerView r3 = r5.f46308d1
            int r3 = r3.computeVerticalScrollOffset()
            if (r3 <= 0) goto L_0x0076
            float r3 = (float) r3
            float r2 = r2 - r3
        L_0x0076:
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x009d
            goto L_0x009e
        L_0x007b:
            com.hbg.lib.common.mvp.BaseFragmentPresenter r2 = r5.yh()
            com.huobi.finance.presenter.BalanceAssetPresenter r2 = (com.huobi.finance.presenter.BalanceAssetPresenter) r2
            int r2 = r2.C1()
            r3 = 9
            if (r2 != r3) goto L_0x009e
            float r1 = r5.f46334w0
            float r2 = r5.f46338y0
            float r2 = r2 + r1
            androidx.recyclerview.widget.RecyclerView r3 = r5.f46308d1
            int r3 = r3.computeVerticalScrollOffset()
            if (r3 <= 0) goto L_0x0098
            float r3 = (float) r3
            float r2 = r2 - r3
        L_0x0098:
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r1 = r2
        L_0x009e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "#funcTranY#"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            i6.d.i(r2)
            r0.setTranslationY(r1)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.finance.ui.BalanceAssetFragment.sk():void");
    }

    public void th(boolean z11) {
        int i11;
        if (getActivity() != null && isAdded()) {
            if (z11) {
                i11 = this.O;
            } else {
                i11 = ContextCompat.getColor(getActivity(), R$color.app_bg);
            }
            pk(i11);
        }
        super.th(z11);
    }

    public final void tj() {
        this.O = ContextCompat.getColor(getActivity(), R$color.balance_margin_total_bg_start_color);
        this.P = ContextCompat.getColor(getActivity(), R$color.balance_main_text_color);
        FragmentActivity activity = getActivity();
        int i11 = R$color.balance_search_hint_text_light_color;
        this.Q = ContextCompat.getColor(activity, i11);
        this.f46313i0 = ContextCompat.getColor(getActivity(), R$color.baseColorMajorTheme100);
        this.f46314j0 = ContextCompat.getColor(getActivity(), R$color.baseColorSecondaryText);
        this.f46315k0 = this.f46313i0;
        this.f46317l0 = ContextCompat.getColor(getActivity(), i11);
        this.R = ContextCompat.getColor(getActivity(), R$color.baseColorPrimarySeparator);
        this.S = ContextCompat.getColor(getActivity(), R$color.global_item_bg);
        this.T = ContextCompat.getColor(getActivity(), R$color.baseColorContentBackground);
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (getActivity() != null && isAdded()) {
            if (!z11) {
                PieChartDialogFragment pieChartDialogFragment = this.f46319m0;
                if (pieChartDialogFragment != null && pieChartDialogFragment.isVisible()) {
                    this.f46319m0.dismiss();
                }
                SparseArray<EditText> sparseArray = this.f46325r;
                if (sparseArray != null && sparseArray.size() > 0) {
                    for (int i11 = 0; i11 < this.f46325r.size(); i11++) {
                        this.f46325r.valueAt(i11).clearFocus();
                    }
                }
            } else {
                nk();
                kk();
                boolean c11 = BaseModuleConfig.a().c();
                if (this.Q0 != c11) {
                    this.Q0 = c11;
                    jk();
                }
            }
        }
        if (z11) {
            ClosePathFloatView.g((String) null, getActivity(), false);
        }
    }

    public final void uj() {
        int i11;
        this.I0 = getResources().getDimensionPixelOffset(R$dimen.dimen_46);
        if (((BalanceAssetPresenter) yh()).k2()) {
            i11 = getResources().getDimensionPixelOffset(R$dimen.dimen_50);
        } else {
            i11 = getResources().getDimensionPixelOffset(R$dimen.dimen_22);
        }
        int dimensionPixelOffset = i11 + (ti.a.a() ? getResources().getDimensionPixelOffset(R$dimen.dimen_28) : 0) + getResources().getDimensionPixelOffset(R$dimen.dimen_5);
        qk(this.f46331v, getResources().getDimensionPixelOffset(R$dimen.dimen_108) + dimensionPixelOffset);
        this.V = 0;
        if (this.H0) {
            this.V = getResources().getDimensionPixelOffset(R$dimen.dimen_40);
        }
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R$dimen.dimen_159_5);
        this.G0 = dimensionPixelOffset2;
        int i12 = dimensionPixelOffset2 + dimensionPixelOffset;
        this.G0 = i12;
        if (this.H0) {
            this.G0 = i12 + this.V;
        }
        this.f46307d0 = getResources().getDimension(R$dimen.dimen_130);
        this.W = getResources().getDimensionPixelOffset(R$dimen.dimen_41);
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R$dimen.dimen_73);
        this.X = dimensionPixelOffset3;
        int i13 = dimensionPixelOffset3 + dimensionPixelOffset;
        this.X = i13;
        this.Y = i13 - this.W;
        this.f46334w0 = (float) getResources().getDimensionPixelOffset(R$dimen.dimen_84_5);
        this.f46336x0 = (float) getResources().getDimensionPixelOffset(R$dimen.dimen_35);
        this.f46338y0 = (float) getResources().getDimensionPixelOffset(R$dimen.dimen_40);
        this.f46340z0 = 0.0f;
        float f11 = (float) this.X;
        this.Z = f11;
        if (this.H0) {
            this.Z = f11 + ((float) this.V);
        }
        float a11 = (float) (this.Y + PixelUtils.a(17.0f));
        this.f46301a0 = a11;
        if (this.H0) {
            this.f46301a0 = a11 + ((float) this.V);
        }
        this.f46303b0 = ((float) this.X) - this.f46301a0;
        this.f46309e0 = getResources().getDimension(R$dimen.dimen_44);
        this.f46310f0 = getResources().getDimension(R$dimen.dimen_0_5);
        this.f46311g0 = getResources().getDimension(R$dimen.dimen_1_5);
        this.N0 = getResources().getDimension(R$dimen.dimen_45);
    }

    public void v6(String str) {
        if (this.f46333w == null) {
            this.f46333w = new b();
        }
        this.f46333w.setValue(str);
        hk(this.f46325r, this.f46333w);
        if (this.f46335x == null) {
            this.f46335x = new c();
        }
        this.f46335x.setValue(str);
        hk(this.f46327t, this.f46335x);
    }

    public void vc(int i11, BaseAssetTotal baseAssetTotal) {
        if (i11 == 12 && (baseAssetTotal instanceof MiningDataTotal)) {
            this.Y0.b(baseAssetTotal);
        } else if (i11 == 13) {
            this.Z0.b(baseAssetTotal);
        } else if (i11 == 14) {
            this.f46302a1.b((OnChainDataTotal) baseAssetTotal);
        }
    }

    public final void vj() {
        this.f46316l = new ArrayList();
        this.f46318m = new ArrayList();
        this.f46320n = new ArrayList();
        this.f46323p = new ArrayList();
        this.f46322o = new ArrayList();
        this.f46324q = new ArrayList();
        int size = ((BalanceAssetPresenter) yh()).F1().size();
        int indexOf = this.I.indexOf(getResources().getString(R$string.margin_toolbar_header_title));
        int indexOf2 = this.I.indexOf(getResources().getString(R$string.n_balance_contract_title));
        for (int i11 = 0; i11 < size; i11++) {
            if (!(i11 == ((BalanceAssetPresenter) yh()).R1(12) || i11 == ((BalanceAssetPresenter) yh()).R1(13) || i11 == ((BalanceAssetPresenter) yh()).R1(14))) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R$layout.layout_balance_list, this.f46339z, false);
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.balance_list);
                if (this.f46308d1 == null) {
                    this.f46308d1 = recyclerView;
                }
                VerticalDividerItemDecoration verticalDividerItemDecoration = new VerticalDividerItemDecoration((Drawable) new ColorDrawable(ContextCompat.getColor(getActivity(), R$color.baseColorPrimarySeparator)), (int) getResources().getDimension(R$dimen.dimen_0_5), true, true);
                LoadingLayout loadingLayout = (LoadingLayout) inflate.findViewById(R$id.balance_loading);
                loadingLayout.setOnRetryClickListener(new t1(this));
                o oVar = new o(getActivity(), recyclerView, new y1(this));
                oVar.setOrientation(1);
                recyclerView.setLayoutManager(oVar);
                recyclerView.addItemDecoration(verticalDividerItemDecoration);
                View findViewById = inflate.findViewById(R$id.balance_total_func);
                recyclerView.setOnTouchListener(new w1(this));
                recyclerView.addOnScrollListener(new f());
                this.f46322o.add(recyclerView);
                this.f46323p.add(loadingLayout);
                this.f46324q.add(findViewById);
                if (i11 == ((BalanceAssetPresenter) yh()).R1(3) || i11 == ((BalanceAssetPresenter) yh()).R1(6) || i11 == ((BalanceAssetPresenter) yh()).R1(11) || i11 == ((BalanceAssetPresenter) yh()).R1(10)) {
                    this.f46320n.add(inflate);
                } else if (i11 == ((BalanceAssetPresenter) yh()).R1(0) || i11 == ((BalanceAssetPresenter) yh()).R1(4) || i11 == ((BalanceAssetPresenter) yh()).R1(7) || i11 == ((BalanceAssetPresenter) yh()).R1(8)) {
                    this.f46318m.add(inflate);
                } else {
                    this.f46316l.add(inflate);
                }
            }
        }
        if (indexOf2 >= 0) {
            this.f46316l.add(indexOf2, nj());
        }
        if (indexOf >= 0) {
            this.f46316l.add(indexOf, qj());
        }
        zj();
        xj();
        Aj();
    }

    public final void wj() {
        this.f46325r = new SparseArray<>();
        this.f46329u = new SparseArray<>();
        this.f46327t = new SparseArray<>();
        for (int i11 = 0; i11 < this.f46324q.size(); i11++) {
            View view = this.f46324q.get(i11);
            if (view != null) {
                EditText editText = (EditText) view.findViewById(R$id.total_balance_search);
                ImageView imageView = (ImageView) view.findViewById(R$id.total_balance_search_clear);
                TextView textView = (TextView) view.findViewById(R$id.total_balance_hide_zero_balance);
                ((ImageView) view.findViewById(R$id.total_balance_risk)).setOnClickListener(new u1(this, getResources().getString(R$string.n_balance_hide_balance_tip, new Object[]{wi.a.f48036a.stripTrailingZeros().toPlainString()})));
                editText.addTextChangedListener(new x2(editText, (x2.a) yh()));
                editText.setOnFocusChangeListener(new v1(this));
                textView.setOnClickListener(new s1(this));
                imageView.setOnClickListener(new l2(editText));
                editText.setOnEditorActionListener(new x1(this, editText));
                this.f46327t.put(i11, imageView);
                this.f46329u.put(i11, textView);
                this.f46325r.put(i11, editText);
            }
        }
        De();
    }

    public final void xj() {
        v M1;
        if (((BalanceAssetPresenter) yh()).e2() && (M1 = ((BalanceAssetPresenter) yh()).M1(13)) != null) {
            this.f46316l.add(M1.b(), this.Z0.d(getActivity(), this.f46339z, new u2(this)));
            int R1 = ((BalanceAssetPresenter) yh()).R1(13);
            this.f46322o.add(R1, (Object) null);
            this.f46323p.add(R1, (Object) null);
            this.f46324q.add(R1, (Object) null);
        }
    }

    public void yb(int i11) {
        LoadingLayout lj2 = lj(i11);
        if (lj2 != null) {
            int D1 = ((BalanceAssetPresenter) yh()).D1(i11);
            if (D1 == 3 || D1 == 6 || D1 == 11 || D1 == 10) {
                ((ImageView) lj2.findViewById(R$id.error_img)).setImageResource(R$drawable.common_no_network_icon);
                ((TextView) lj2.findViewById(R$id.error_tip)).setText(R$string.common_no_internet_access);
            }
            pa(i11);
            lj2.setVisibility(0);
            lj2.setTag(Boolean.TRUE);
            lj2.k();
        }
        ViewUtil.m(oj(i11), false);
    }

    public void yc() {
        int i11;
        ImageView imageView = this.f46304b1;
        if (((BalanceAssetPresenter) yh()).b2()) {
            i11 = R$drawable.balances_show;
        } else {
            i11 = R$drawable.balances_hide;
        }
        imageView.setImageResource(i11);
        Qc(((BalanceAssetPresenter) yh()).N1());
        if (!o4()) {
            try {
                ((BalanceAssetPresenter) yh()).Q3();
                this.Y0.a();
                this.Z0.a();
                this.f46302a1.a();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void yj() {
        this.W0 = new HashMap();
        this.I = new ArrayList();
        String string = getResources().getString(R$string.n_spot);
        this.I.add(string);
        this.W0.put(string, 1);
        if (((BalanceAssetPresenter) yh()).d2()) {
            String string2 = getResources().getString(R$string.n_balance_contract_title);
            this.I.add(string2);
            this.W0.put(string2, 3);
        }
        if (!BaseModuleConfig.a().c()) {
            String string3 = getResources().getString(R$string.n_blance_fiat_assets);
            this.I.add(string3);
            this.W0.put(string3, 2);
        }
        if (((BalanceAssetPresenter) yh()).f2()) {
            String string4 = getResources().getString(R$string.margin_toolbar_header_title);
            this.I.add(string4);
            this.W0.put(string4, 0);
        }
        if (((BalanceAssetPresenter) yh()).h2()) {
            String replace = getResources().getString(this.Y0.c()).replace("账户", "");
            this.I.add(replace);
            this.W0.put(replace, 12);
        }
        if (((BalanceAssetPresenter) yh()).e2()) {
            String replace2 = getResources().getString(this.Z0.c()).replace("账户", "");
            this.I.add(replace2);
            this.W0.put(replace2, 13);
        }
        if (((BalanceAssetPresenter) yh()).g2()) {
            String string5 = getResources().getString(R$string.mine_toolbar_header_title);
            this.I.add(string5);
            this.W0.put(string5, 5);
        }
        if (((BalanceAssetPresenter) yh()).j2()) {
            String replace3 = getResources().getString(R$string.n_otc_options_account).replace("账户", "");
            this.I.add(replace3);
            this.W0.put(replace3, 15);
        }
        if (((BalanceAssetPresenter) yh()).l2()) {
            String replace4 = getResources().getString(R$string.n_balance_savings_account).replace("账户", "");
            this.I.add(replace4);
            this.W0.put(replace4, 9);
        }
        if (((BalanceAssetPresenter) yh()).i2()) {
            String string6 = getResources().getString(this.f46302a1.c());
            this.I.add(string6);
            this.W0.put(string6, 14);
        }
        this.H = new CommonNavigator(getActivity());
        BalanceNavigatorAdapter balanceNavigatorAdapter = new BalanceNavigatorAdapter(this.f46339z, this.I, this.f46314j0, this.f46313i0);
        this.G = balanceNavigatorAdapter;
        this.H.setAdapter(balanceNavigatorAdapter);
        this.H.setSmoothScroll(true);
        this.F.setNavigator(this.H);
        this.F.setCoverView(this.S0);
        this.f46339z.clearOnPageChangeListeners();
        ViewPagerHelper.a(this.F, this.f46339z);
    }

    public final void zj() {
        int indexOf;
        if (((BalanceAssetPresenter) yh()).h2() && (indexOf = this.I.indexOf(getResources().getString(this.Y0.c()).replace("账户", ""))) >= 0) {
            this.f46316l.add(indexOf, this.Y0.d(getActivity(), this.f46339z, new s2(this)));
            int R1 = ((BalanceAssetPresenter) yh()).R1(12);
            this.f46322o.add(R1, (Object) null);
            this.f46323p.add(R1, (Object) null);
            this.f46324q.add(R1, (Object) null);
        }
    }

    public void showProgressDialog(boolean z11) {
        i6.i.b().d(new j2(this));
    }
}
