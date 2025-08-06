package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

public class IndexRankSubTextListIndicator extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public boolean f71396c = true;

    /* renamed from: d  reason: collision with root package name */
    public CommonNavigatorAdapter f71397d;

    /* renamed from: e  reason: collision with root package name */
    public CommonNavigator f71398e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f71399f;

    /* renamed from: g  reason: collision with root package name */
    public b f71400g;

    /* renamed from: h  reason: collision with root package name */
    public int f71401h;

    /* renamed from: i  reason: collision with root package name */
    public int f71402i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71403j;

    /* renamed from: k  reason: collision with root package name */
    public HorizontalScrollView f71404k;

    /* renamed from: l  reason: collision with root package name */
    public c f71405l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71406m = true;

    /* renamed from: n  reason: collision with root package name */
    public boolean f71407n = false;

    /* renamed from: o  reason: collision with root package name */
    public View f71408o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f71409p = true;

    /* renamed from: q  reason: collision with root package name */
    public int f71410q;

    /* renamed from: r  reason: collision with root package name */
    public int f71411r = 1;

    /* renamed from: s  reason: collision with root package name */
    public int f71412s = PixelUtils.a(20.0f);

    /* renamed from: t  reason: collision with root package name */
    public int f71413t = 17;

    /* renamed from: u  reason: collision with root package name */
    public int f71414u;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        public int getCount() {
            if (IndexRankSubTextListIndicator.this.f71399f == null) {
                return 0;
            }
            return IndexRankSubTextListIndicator.this.f71399f.size();
        }

        public q10.b getIndicator(Context context) {
            context.getResources();
            WrapPagerIndicator wrapPagerIndicator = new WrapPagerIndicator(context);
            wrapPagerIndicator.setRoundRadius((float) PixelUtils.a(2.0f));
            wrapPagerIndicator.setFillColor(IndexRankSubTextListIndicator.this.f71410q);
            wrapPagerIndicator.setVerticalPadding(UIUtil.a(context, 3.0d));
            wrapPagerIndicator.setHorizontalPadding(UIUtil.a(context, 8.0d));
            wrapPagerIndicator.setStartInterpolator(new DecelerateInterpolator());
            wrapPagerIndicator.setEndInterpolator(new DecelerateInterpolator());
            return wrapPagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            IndexRankSubTextListIndicator indexRankSubTextListIndicator = IndexRankSubTextListIndicator.this;
            return indexRankSubTextListIndicator.m(context, i11, indexRankSubTextListIndicator.f71399f);
        }
    }

    public interface b {
        void a(int i11, View view);

        void onItemClick(int i11);
    }

    public interface c {
        void a(boolean z11);
    }

    public IndexRankSubTextListIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonTextListIndicator, 0, 0);
            this.f71403j = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_use_transparent_pic, false);
            this.f71407n = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_auto_hide_cover_view, false);
            if (this.f71403j) {
                this.f71402i = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.sidebar_transparent_pic);
            } else {
                this.f71402i = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.market_indicator_shadow);
            }
            obtainStyledAttributes.recycle();
        }
        n(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (this.f71405l != null) {
            this.f71405l.a(k() || !p());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(int i11, View view) {
        b bVar = this.f71400g;
        if (bVar != null) {
            bVar.onItemClick(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(View view, int i11, int i12, int i13, int i14) {
        boolean z11 = false;
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f71404k.getChildAt(0).getWidth()) {
            z11 = true;
        }
        if (this.f71407n) {
            setCoverViewVisibility(!z11);
        }
        c cVar = this.f71405l;
        if (cVar != null) {
            cVar.a(!z11);
        }
    }

    public boolean getCapitalTitle() {
        return this.f71396c;
    }

    public List<String> getList() {
        return this.f71399f;
    }

    public CommonNavigatorAdapter getMCommonNavigatorAdapter() {
        return this.f71397d;
    }

    public HorizontalScrollView getScrollView() {
        return this.f71404k;
    }

    public CommonNavigator getmCommonNavigator() {
        return this.f71398e;
    }

    public final void j() {
        View view = this.f71408o;
        if (view != null) {
            try {
                removeView(view);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f71408o = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f71401h, -1);
        layoutParams.gravity = 8388613;
        this.f71408o.setLayoutParams(layoutParams);
        this.f71408o.setBackgroundResource(this.f71402i);
        addView(this.f71408o);
    }

    public boolean k() {
        View childAt;
        HorizontalScrollView horizontalScrollView = this.f71404k;
        if (horizontalScrollView == null || (childAt = horizontalScrollView.getChildAt(0)) == null || childAt.getWidth() <= this.f71404k.getWidth()) {
            return false;
        }
        return true;
    }

    public void l() {
        HorizontalScrollView horizontalScrollView;
        o();
        if (this.f71409p && (horizontalScrollView = this.f71404k) != null) {
            horizontalScrollView.post(new s0(this));
        }
    }

    public final SimplePagerTitleView m(Context context, int i11, List<String> list) {
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        colorTransitionPagerTitleView.setNormalColor(ContextCompat.getColor(context, R$color.baseColorSecondaryTextNew));
        colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(getContext(), R$color.baseColorMajorTheme100));
        colorTransitionPagerTitleView.setTextSize(1, 12.0f);
        colorTransitionPagerTitleView.setPadding(PixelUtils.a(8.0f), 0, PixelUtils.a(8.0f), 0);
        if (this.f71396c) {
            colorTransitionPagerTitleView.setText(StringUtils.i(list.get(i11)));
        } else {
            colorTransitionPagerTitleView.setText(list.get(i11));
        }
        colorTransitionPagerTitleView.setGravity(this.f71413t);
        colorTransitionPagerTitleView.setClickable(true);
        colorTransitionPagerTitleView.setOnClickListener(new q0(this, i11));
        b bVar = this.f71400g;
        if (bVar != null) {
            bVar.a(i11, colorTransitionPagerTitleView);
        }
        return colorTransitionPagerTitleView;
    }

    public final void n(Context context) {
        this.f71401h = getResources().getDimensionPixelOffset(R$dimen.dimen_30);
        Context context2 = getContext();
        int i11 = R$color.baseColorMajorTheme100;
        this.f71410q = ContextCompat.getColor(context2, i11);
        this.f71414u = ContextCompat.getColor(getContext(), i11);
    }

    public final void o() {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R$id.scroll_view);
        this.f71404k = horizontalScrollView;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new r0(this));
        }
    }

    public boolean p() {
        HorizontalScrollView horizontalScrollView = this.f71404k;
        if (horizontalScrollView == null || horizontalScrollView.getChildCount() == 0 || this.f71404k.getScrollX() >= this.f71404k.getChildAt(0).getWidth() - this.f71404k.getMeasuredWidth()) {
            return true;
        }
        return false;
    }

    public void setCallback(b bVar) {
        this.f71400g = bVar;
    }

    public void setCapitalTitle(boolean z11) {
        this.f71396c = z11;
    }

    public void setCoverViewVisibility(boolean z11) {
        ViewUtil.n(this.f71408o, z11);
    }

    public void setDataList(List<String> list) {
        if (this.f71399f == null) {
            this.f71399f = new ArrayList();
        }
        if (list != null) {
            this.f71399f.clear();
            this.f71399f.addAll(list);
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71397d;
        if (commonNavigatorAdapter == null) {
            this.f71397d = new a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            this.f71398e = commonNavigator;
            commonNavigator.setPadding(PixelUtils.a(8.0f) * 2, 0, PixelUtils.a(8.0f) * 2, 0);
            this.f71398e.setAdapter(this.f71397d);
            this.f71398e.setSmoothScroll(true);
            setNavigator(this.f71398e);
        } else {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
        l();
    }

    public void setGravity(int i11) {
        this.f71413t = i11;
    }

    public void setIndicatorColor(int i11) {
        this.f71410q = i11;
    }

    public void setInitPostScrollCallback(boolean z11) {
        this.f71409p = z11;
    }

    public void setNavigator(p10.a aVar) {
        super.setNavigator(aVar);
        if (this.f71406m) {
            j();
        }
    }

    public void setOnScrollChangeCallback(c cVar) {
        this.f71405l = cVar;
    }

    public void setTitleViewSelectColor(int i11) {
        this.f71414u = i11;
    }

    public void setUseCoverView(boolean z11) {
        this.f71406m = z11;
        ViewUtil.n(this.f71408o, false);
    }
}
