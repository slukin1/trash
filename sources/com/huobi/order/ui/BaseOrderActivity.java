package com.huobi.order.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.widgets.CommonTextListIndicator;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.order.ui.OrderListFragment;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.view.rv.HorizontalDividerItemDecoration;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.k;
import i6.n;
import java.util.ArrayList;
import java.util.List;
import k20.h;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import pro.huobi.R;
import q10.b;
import q10.c;

public abstract class BaseOrderActivity extends EmptyMVPActivity implements SmartRefreshPageSplitter.b, View.OnClickListener, ViewPager.OnPageChangeListener, OrderListFragment.d {

    /* renamed from: b  reason: collision with root package name */
    public ImageView f78129b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f78130c;

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView<io.a> f78131d;

    /* renamed from: e  reason: collision with root package name */
    public OrderListFragment f78132e;

    /* renamed from: f  reason: collision with root package name */
    public OrderListFragment f78133f;

    /* renamed from: g  reason: collision with root package name */
    public OrderListFragment f78134g;

    /* renamed from: h  reason: collision with root package name */
    public final List<io.a> f78135h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public CommonTextListIndicator f78136i;

    /* renamed from: j  reason: collision with root package name */
    public List<String> f78137j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public int f78138k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f78139l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f78140m;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void lambda$getTitleView$0(int i11, View view) {
            BaseOrderActivity.this.f78130c.setCurrentItem(i11);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public int getCount() {
            if (BaseOrderActivity.this.f78137j == null) {
                return 0;
            }
            return BaseOrderActivity.this.f78137j.size();
        }

        public b getIndicator(Context context) {
            return null;
        }

        public c getTitleView(Context context, int i11) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
            colorTransitionPagerTitleView.setTextSize(1, 16.0f);
            colorTransitionPagerTitleView.setText((CharSequence) BaseOrderActivity.this.f78137j.get(i11));
            colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
            colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.baseColorPrimaryText));
            colorTransitionPagerTitleView.getPaint().setTypeface(ResourcesCompat.h(context, R.font.roboto_medium));
            colorTransitionPagerTitleView.setOnClickListener(new c(this, i11));
            return colorTransitionPagerTitleView;
        }
    }

    public static void Eh(Context context, Intent intent) {
        if (context != null) {
            context.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh() {
        this.f78136i.setCoverViewVisibility(((float) this.f78136i.getMeasuredWidth()) > ((float) n.g(this)) - getResources().getDimension(R.dimen.dimen_30));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void yh(FrameLayout.LayoutParams layoutParams) {
        boolean z11 = false;
        this.f78136i.measure(0, 0);
        int measuredWidth = this.f78136i.getMeasuredWidth();
        CommonTextListIndicator commonTextListIndicator = this.f78136i;
        if (((float) measuredWidth) > ((float) layoutParams.width) - getResources().getDimension(R.dimen.dimen_30)) {
            z11 = true;
        }
        commonTextListIndicator.setCoverViewVisibility(z11);
    }

    public abstract void Ah();

    public void Bh() {
        this.f78131d.c();
    }

    public void Ch() {
        Dh();
        OrderListFragment Pg = Pg();
        if (Pg != null) {
            Pg.Hh();
        }
    }

    public void Dh() {
        this.f78135h.clear();
        sh(this.f78135h);
        this.f78131d.setData(this.f78135h);
        if (qh() > 0) {
            zh();
        } else {
            gg();
        }
    }

    public void Fh(int i11) {
        if (i11 == 0) {
            List<io.a> list = this.f78135h;
            if (list == null || list.size() <= 0) {
                gg();
            } else {
                zh();
            }
        } else {
            gg();
        }
        Ah();
        this.f78138k = i11;
        this.f78130c.setCurrentItem(i11);
        Ch();
    }

    public boolean Gh() {
        return true;
    }

    public void N3(int i11, RecyclerView recyclerView, int i12) {
    }

    public abstract SmartRefreshPageSplitter.c Og();

    public OrderListFragment Pg() {
        if (uh()) {
            return this.f78132e;
        }
        if (vh()) {
            return this.f78134g;
        }
        return this.f78133f;
    }

    public abstract SmartRefreshPageSplitter.c Qg();

    public void addEvent() {
        this.f78129b.setOnClickListener(this);
    }

    public void bc(String str) {
        this.f78139l = str;
    }

    public boolean canFullScreen() {
        return true;
    }

    public void e9(int i11, RecyclerView recyclerView, int i12, int i13) {
    }

    public int getContentView() {
        return R.layout.activity_trade_order;
    }

    public int getStatusBarColor() {
        return getResources().getColor(R.color.baseColorDeepestBackground);
    }

    public void gg() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f78136i.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.gravity = 1;
        this.f78136i.setLayoutParams(layoutParams);
        this.f78136i.post(new a(this));
    }

    public void initIntent(Intent intent) {
        if (intent != null) {
            bc(intent.getStringExtra("extra_symbol"));
        }
    }

    public void initView() {
        removeWinBg();
        EventBus.d().p(this);
        initIntent(getIntent());
        ph();
        this.f78129b = (ImageView) this.viewFinder.b(R.id.id_action_bar_back_btn);
        this.f78136i = (CommonTextListIndicator) this.viewFinder.b(R.id.magicIndicator);
        this.f78131d = (EasyRecyclerView) this.viewFinder.b(R.id.id_action_bar_menu_recyclerView);
        ViewPager viewPager = (ViewPager) this.viewFinder.b(R.id.id_trade_order_viewPager);
        this.f78130c = viewPager;
        viewPager.addOnPageChangeListener(this);
        initViewPager();
        th();
    }

    public final void initViewPager() {
        OrderListFragment orderListFragment = new OrderListFragment();
        this.f78132e = orderListFragment;
        orderListFragment.Jh(0);
        this.f78132e.Ih(this);
        OrderListFragment orderListFragment2 = new OrderListFragment();
        this.f78133f = orderListFragment2;
        orderListFragment2.Jh(1);
        this.f78133f.Ih(this);
        if (rh()) {
            OrderListFragment orderListFragment3 = new OrderListFragment();
            this.f78134g = orderListFragment3;
            orderListFragment3.Jh(2);
            this.f78134g.Ih(this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f78132e);
        arrayList.add(this.f78133f);
        if (rh()) {
            arrayList.add(this.f78134g);
        }
        this.f78130c.setAdapter(new yo.a(getSupportFragmentManager(), arrayList));
        CommonNavigator commonNavigator = new CommonNavigator(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_5);
        commonNavigator.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        commonNavigator.setAdapter(new a());
        this.f78136i.setNavigator(commonNavigator);
        ViewPagerHelper.a(this.f78136i, this.f78130c);
    }

    public void l0(int i11, float f11, int i12, int i13, int i14) {
    }

    public String o0() {
        return this.f78139l;
    }

    public abstract SmartRefreshPageSplitter.c oh();

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.id_action_bar_back_btn) {
            zo.a.g().l();
            doFinish();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Dh();
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
    }

    public void onPageSelected(int i11) {
        Fh(i11);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(this, (kn.a) null);
        finish();
    }

    public void pc(int i11, float f11, int i12, int i13, int i14) {
    }

    public final void ph() {
        this.f78137j.add(getString(R.string.n_exchange_order_all_entrusts));
        this.f78137j.add(getString(R.string.n_exchange_order_history_orders));
        if (rh()) {
            this.f78137j.add(getString(R.string.n_exchange_order_filled_orders));
        }
    }

    public int qh() {
        List<io.a> list = this.f78135h;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean rh() {
        return false;
    }

    public SmartRefreshPageSplitter.b sb() {
        return this;
    }

    public void sc(int i11) {
        if (i11 == 0 && !this.f78140m) {
            this.f78140m = true;
            Ch();
        }
    }

    public abstract void sh(List<io.a> list);

    public final void th() {
        StableLinearLayoutManager stableLinearLayoutManager = new StableLinearLayoutManager(this);
        stableLinearLayoutManager.setOrientation(0);
        this.f78131d.setLayoutManager(stableLinearLayoutManager);
        if (Gh()) {
            this.f78131d.addItemDecoration(new HorizontalDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.divider_menu_top_bottom_margin), PixelUtils.a(0.5f), false));
        }
    }

    public boolean uh() {
        return this.f78138k == 0;
    }

    public boolean vh() {
        return this.f78138k == 2;
    }

    public SmartRefreshPageSplitter.c w2(int i11) {
        if (i11 == 0) {
            return Og();
        }
        if (i11 == 2) {
            return Qg();
        }
        return oh();
    }

    public boolean wh() {
        return this.f78138k == 1;
    }

    public void zh() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f78136i.getLayoutParams();
        layoutParams.width = -1;
        k.o("BaseOrderActivity", "updateTitleTab:, getDimensionPixelSize:" + layoutParams.width);
        layoutParams.gravity = 3;
        this.f78136i.setLayoutParams(layoutParams);
        this.f78136i.post(new b(this, layoutParams));
    }
}
