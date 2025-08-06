package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

public class CommonTextListIndicator extends MagicIndicator {

    /* renamed from: z  reason: collision with root package name */
    public static float f71264z = 8.0f;

    /* renamed from: c  reason: collision with root package name */
    public boolean f71265c = true;

    /* renamed from: d  reason: collision with root package name */
    public CommonNavigatorAdapter f71266d;

    /* renamed from: e  reason: collision with root package name */
    public CommonNavigator f71267e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f71268f;

    /* renamed from: g  reason: collision with root package name */
    public b f71269g;

    /* renamed from: h  reason: collision with root package name */
    public int f71270h;

    /* renamed from: i  reason: collision with root package name */
    public int f71271i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71272j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71273k;

    /* renamed from: l  reason: collision with root package name */
    public HorizontalScrollView f71274l;

    /* renamed from: m  reason: collision with root package name */
    public c f71275m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f71276n = true;

    /* renamed from: o  reason: collision with root package name */
    public boolean f71277o = false;

    /* renamed from: p  reason: collision with root package name */
    public View f71278p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f71279q = true;

    /* renamed from: r  reason: collision with root package name */
    public int f71280r;

    /* renamed from: s  reason: collision with root package name */
    public int f71281s = PixelUtils.a(20.0f);

    /* renamed from: t  reason: collision with root package name */
    public int f71282t;

    /* renamed from: u  reason: collision with root package name */
    public int f71283u = 2;

    /* renamed from: v  reason: collision with root package name */
    public int f71284v = PixelUtils.a(20.0f);

    /* renamed from: w  reason: collision with root package name */
    public int f71285w = 17;

    /* renamed from: x  reason: collision with root package name */
    public int f71286x;

    /* renamed from: y  reason: collision with root package name */
    public int f71287y;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        public int getCount() {
            if (CommonTextListIndicator.this.f71268f == null) {
                return 0;
            }
            return CommonTextListIndicator.this.f71268f.size();
        }

        public q10.b getIndicator(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(CommonTextListIndicator.this.f71283u);
            linePagerIndicator.setColors(Integer.valueOf(CommonTextListIndicator.this.f71280r));
            linePagerIndicator.setLineWidth((float) CommonTextListIndicator.this.f71281s);
            linePagerIndicator.setRoundRadius((float) CommonTextListIndicator.this.f71282t);
            linePagerIndicator.setLineHeight((float) PixelUtils.a(2.0f));
            linePagerIndicator.setRoundRadius((float) (PixelUtils.a(2.0f) / 2));
            return linePagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            CommonTextListIndicator commonTextListIndicator = CommonTextListIndicator.this;
            return commonTextListIndicator.p(context, i11, commonTextListIndicator.f71268f);
        }
    }

    public interface b {
        void a(int i11, View view);

        void onItemClick(int i11);
    }

    public interface c {
        void a(boolean z11);
    }

    public CommonTextListIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonTextListIndicator, 0, 0);
            this.f71272j = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_use_transparent_pic, false);
            this.f71277o = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_auto_hide_cover_view, false);
            f71264z = obtainStyledAttributes.getDimension(R$styleable.CommonTextListIndicator_padding_inside, f71264z);
            if (this.f71272j) {
                this.f71271i = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.sidebar_transparent_pic);
            } else {
                this.f71271i = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.market_indicator_shadow);
            }
            obtainStyledAttributes.recycle();
        }
        q(context);
    }

    private void q(Context context) {
        this.f71270h = getResources().getDimensionPixelOffset(R$dimen.dimen_30);
        this.f71280r = ContextCompat.getColor(getContext(), R$color.baseColorMajorTheme100);
        this.f71287y = ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText);
        this.f71286x = ContextCompat.getColor(getContext(), R$color.baseColorSecondaryTextNew);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        if (this.f71275m != null) {
            this.f71275m.a(n() || !s());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void u(int i11, View view) {
        b bVar = this.f71269g;
        if (bVar != null) {
            bVar.onItemClick(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(View view, int i11, int i12, int i13, int i14) {
        boolean z11 = false;
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f71274l.getChildAt(0).getWidth()) {
            z11 = true;
        }
        if (this.f71277o) {
            setCoverViewVisibility(!z11);
        }
        c cVar = this.f71275m;
        if (cVar != null) {
            cVar.a(!z11);
        }
    }

    public boolean getCapitalTitle() {
        return this.f71265c;
    }

    public List<String> getList() {
        return this.f71268f;
    }

    public CommonNavigatorAdapter getMCommonNavigatorAdapter() {
        return this.f71266d;
    }

    public HorizontalScrollView getScrollView() {
        return this.f71274l;
    }

    public CommonNavigator getmCommonNavigator() {
        return this.f71267e;
    }

    public final void m() {
        View view = this.f71278p;
        if (view != null) {
            try {
                removeView(view);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f71278p = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f71270h, -1);
        layoutParams.gravity = 8388613;
        this.f71278p.setLayoutParams(layoutParams);
        this.f71278p.setBackgroundResource(this.f71271i);
        addView(this.f71278p);
    }

    public boolean n() {
        View childAt;
        HorizontalScrollView horizontalScrollView = this.f71274l;
        if (horizontalScrollView == null || (childAt = horizontalScrollView.getChildAt(0)) == null || childAt.getWidth() <= this.f71274l.getWidth()) {
            return false;
        }
        return true;
    }

    public void o() {
        HorizontalScrollView horizontalScrollView;
        r();
        if (this.f71279q && (horizontalScrollView = this.f71274l) != null) {
            horizontalScrollView.post(new d0(this));
        }
    }

    public final RedPointPagerTitleView p(Context context, int i11, List<String> list) {
        RedPointPagerTitleView redPointPagerTitleView = new RedPointPagerTitleView(context);
        ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
        redPointPagerTitleView.b(colorTransitionPagerTitleView, this.f71273k);
        if (this.f71286x == 0) {
            this.f71286x = ContextCompat.getColor(context, R$color.baseColorSecondaryTextNew);
        }
        colorTransitionPagerTitleView.setNormalColor(this.f71286x);
        if (this.f71287y == 0) {
            this.f71287y = ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText);
        }
        colorTransitionPagerTitleView.setSelectedColor(this.f71287y);
        colorTransitionPagerTitleView.setTextSize(1, 14.0f);
        colorTransitionPagerTitleView.getPaint().setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        colorTransitionPagerTitleView.setPadding(0, 0, 0, 0);
        redPointPagerTitleView.setPadding(PixelUtils.a(f71264z), 0, PixelUtils.a(f71264z), 0);
        redPointPagerTitleView.setClipChildren(false);
        if (this.f71265c) {
            colorTransitionPagerTitleView.setText(StringUtils.i(list.get(i11)));
        } else {
            colorTransitionPagerTitleView.setText(list.get(i11));
        }
        colorTransitionPagerTitleView.setGravity(this.f71285w);
        redPointPagerTitleView.setClickable(true);
        redPointPagerTitleView.setOnClickListener(new b0(this, i11));
        b bVar = this.f71269g;
        if (bVar != null) {
            bVar.a(i11, colorTransitionPagerTitleView);
        }
        return redPointPagerTitleView;
    }

    public final void r() {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R$id.scroll_view);
        this.f71274l = horizontalScrollView;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new c0(this));
        }
    }

    public boolean s() {
        HorizontalScrollView horizontalScrollView = this.f71274l;
        if (horizontalScrollView == null || horizontalScrollView.getChildCount() == 0 || this.f71274l.getScrollX() >= this.f71274l.getChildAt(0).getWidth() - this.f71274l.getMeasuredWidth()) {
            return true;
        }
        return false;
    }

    public void setCallback(b bVar) {
        this.f71269g = bVar;
    }

    public void setCapitalTitle(boolean z11) {
        this.f71265c = z11;
    }

    public void setCoverViewVisibility(boolean z11) {
        ViewUtil.n(this.f71278p, z11);
    }

    public void setDataList(List<String> list) {
        if (this.f71268f == null) {
            this.f71268f = new ArrayList();
        }
        if (list != null) {
            this.f71268f.clear();
            this.f71268f.addAll(list);
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71266d;
        if (commonNavigatorAdapter == null) {
            this.f71266d = new a();
            CommonNavigator commonNavigator = new CommonNavigator(getContext());
            this.f71267e = commonNavigator;
            commonNavigator.setPadding(PixelUtils.a(f71264z), 0, PixelUtils.a(f71264z), 0);
            this.f71267e.setAdapter(this.f71266d);
            this.f71267e.setSmoothScroll(true);
            setNavigator(this.f71267e);
        } else {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
        o();
    }

    public void setGravity(int i11) {
        this.f71285w = i11;
    }

    public void setIndicatorColor(int i11) {
        this.f71280r = i11;
    }

    public void setIndicatorLineRoundRadius(int i11) {
        this.f71282t = i11;
    }

    public void setIndicatorLineWidth(int i11) {
        this.f71281s = i11;
    }

    public void setInitPostScrollCallback(boolean z11) {
        this.f71279q = z11;
    }

    public void setNavigator(p10.a aVar) {
        super.setNavigator(aVar);
        if (this.f71276n) {
            m();
        }
    }

    public void setOnScrollChangeCallback(c cVar) {
        this.f71275m = cVar;
    }

    public void setShowRedPoint(boolean z11) {
        this.f71273k = z11;
    }

    public void setTitleViewNormalColor(int i11) {
        this.f71286x = i11;
    }

    public void setTitleViewSelectColor(int i11) {
        this.f71287y = i11;
    }

    public void setUseCoverView(boolean z11) {
        this.f71276n = z11;
        ViewUtil.n(this.f71278p, false);
    }

    public void w() {
        HorizontalScrollView horizontalScrollView = this.f71274l;
        if (horizontalScrollView != null) {
            horizontalScrollView.smoothScrollTo(Integer.MAX_VALUE, 0);
        }
    }

    public void x(int i11, int i12) {
        this.f71283u = i11;
        this.f71284v = i12;
    }
}
