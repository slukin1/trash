package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
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
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;

public class CommonWrapTextListIndicator extends MagicIndicator {

    /* renamed from: c  reason: collision with root package name */
    public boolean f71289c = true;

    /* renamed from: d  reason: collision with root package name */
    public CommonNavigatorAdapter f71290d;

    /* renamed from: e  reason: collision with root package name */
    public CopyCommonNavigator f71291e;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f71292f;

    /* renamed from: g  reason: collision with root package name */
    public b f71293g;

    /* renamed from: h  reason: collision with root package name */
    public int f71294h;

    /* renamed from: i  reason: collision with root package name */
    public int f71295i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f71296j;

    /* renamed from: k  reason: collision with root package name */
    public HorizontalScrollView f71297k;

    /* renamed from: l  reason: collision with root package name */
    public c f71298l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f71299m = false;

    /* renamed from: n  reason: collision with root package name */
    public boolean f71300n = false;

    /* renamed from: o  reason: collision with root package name */
    public View f71301o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f71302p = true;

    /* renamed from: q  reason: collision with root package name */
    public int f71303q;

    /* renamed from: r  reason: collision with root package name */
    public int f71304r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f71305s = true;

    public class a extends CommonNavigatorAdapter {
        public a() {
        }

        public int getCount() {
            if (CommonWrapTextListIndicator.this.f71292f == null) {
                return 0;
            }
            return CommonWrapTextListIndicator.this.f71292f.size();
        }

        public q10.b getIndicator(Context context) {
            Resources resources = context.getResources();
            WrapPagerIndicator wrapPagerIndicator = new WrapPagerIndicator(context);
            wrapPagerIndicator.setRoundRadius(resources.getDimension(R$dimen.dimen_3));
            wrapPagerIndicator.setFillColor(CommonWrapTextListIndicator.this.f71303q);
            wrapPagerIndicator.setStartInterpolator(new DecelerateInterpolator());
            wrapPagerIndicator.setEndInterpolator(new DecelerateInterpolator());
            return wrapPagerIndicator;
        }

        public q10.c getTitleView(Context context, int i11) {
            CommonWrapTextListIndicator commonWrapTextListIndicator = CommonWrapTextListIndicator.this;
            return commonWrapTextListIndicator.m(context, i11, commonWrapTextListIndicator.f71292f);
        }

        public float getTitleWeight(Context context, int i11) {
            return 1.0f;
        }
    }

    public interface b {
        void a(int i11, View view);

        void onItemClick(int i11);
    }

    public interface c {
        void a(boolean z11);
    }

    public CommonWrapTextListIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CommonTextListIndicator, 0, 0);
            this.f71296j = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_use_transparent_pic, false);
            this.f71300n = obtainStyledAttributes.getBoolean(R$styleable.CommonTextListIndicator_auto_hide_cover_view, false);
            if (this.f71296j) {
                this.f71295i = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.sidebar_transparent_pic);
            } else {
                this.f71295i = obtainStyledAttributes.getResourceId(R$styleable.CommonTextListIndicator_cover_bg_res, R$drawable.market_indicator_shadow);
            }
            obtainStyledAttributes.recycle();
        }
        n(context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q() {
        if (this.f71298l != null) {
            this.f71298l.a(k() || !p());
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void r(int i11, View view) {
        b bVar = this.f71293g;
        if (bVar != null) {
            bVar.onItemClick(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(View view, int i11, int i12, int i13, int i14) {
        boolean z11 = false;
        if (((view.getScrollX() + view.getWidth()) - view.getPaddingLeft()) - view.getPaddingRight() == this.f71297k.getChildAt(0).getWidth()) {
            z11 = true;
        }
        if (this.f71300n) {
            setCoverViewVisibility(!z11);
        }
        c cVar = this.f71298l;
        if (cVar != null) {
            cVar.a(!z11);
        }
    }

    public boolean getCapitalTitle() {
        return this.f71289c;
    }

    public List<String> getList() {
        return this.f71292f;
    }

    public CommonNavigatorAdapter getMCommonNavigatorAdapter() {
        return this.f71290d;
    }

    public HorizontalScrollView getScrollView() {
        return this.f71297k;
    }

    public final void j() {
        View view = this.f71301o;
        if (view != null) {
            try {
                removeView(view);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f71301o = new View(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f71294h, -1);
        layoutParams.gravity = 8388613;
        this.f71301o.setLayoutParams(layoutParams);
        this.f71301o.setBackgroundResource(this.f71295i);
        addView(this.f71301o);
    }

    public boolean k() {
        View childAt;
        HorizontalScrollView horizontalScrollView = this.f71297k;
        if (horizontalScrollView == null || (childAt = horizontalScrollView.getChildAt(0)) == null || childAt.getWidth() <= this.f71297k.getWidth()) {
            return false;
        }
        return true;
    }

    public void l() {
        HorizontalScrollView horizontalScrollView;
        o();
        if (this.f71302p && (horizontalScrollView = this.f71297k) != null) {
            horizontalScrollView.post(new g0(this));
        }
    }

    public final q10.c m(Context context, int i11, List<String> list) {
        final int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R$dimen.dimen_6);
        AnonymousClass2 r12 = new GridTradeDrawableTabView(context) {
            public int getContentBottom() {
                return super.getBottom() - dimensionPixelOffset;
            }

            public int getContentLeft() {
                return super.getLeft() + dimensionPixelOffset;
            }

            public int getContentRight() {
                return super.getRight() - dimensionPixelOffset;
            }

            public int getContentTop() {
                return super.getTop() + dimensionPixelOffset;
            }
        };
        TextView textView = r12.getTextView();
        r12.setNormalColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
        r12.setSelectedColor(this.f71304r);
        textView.setTextSize(1, 12.0f);
        int a11 = PixelUtils.a(20.0f);
        r12.setPadding(a11, 0, a11, 0);
        if (this.f71289c) {
            textView.setText(StringUtils.i(list.get(i11)));
        } else {
            textView.setText(list.get(i11));
        }
        r12.setClickable(true);
        r12.setOnClickListener(new e0(this, i11));
        b bVar = this.f71293g;
        if (bVar != null) {
            bVar.a(i11, r12);
        }
        return r12;
    }

    public final void n(Context context) {
        this.f71294h = getResources().getDimensionPixelOffset(R$dimen.dimen_30);
        this.f71303q = ContextCompat.getColor(getContext(), R$color.grid_trade_subtab_bg_color);
        this.f71304r = ContextCompat.getColor(getContext(), R$color.baseColorPrimaryText);
    }

    public final void o() {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R$id.scroll_view);
        this.f71297k = horizontalScrollView;
        if (horizontalScrollView != null && Build.VERSION.SDK_INT >= 23) {
            horizontalScrollView.setOnScrollChangeListener(new f0(this));
        }
    }

    public boolean p() {
        HorizontalScrollView horizontalScrollView = this.f71297k;
        if (horizontalScrollView == null || horizontalScrollView.getChildCount() == 0 || this.f71297k.getScrollX() >= this.f71297k.getChildAt(0).getWidth() - this.f71297k.getMeasuredWidth()) {
            return true;
        }
        return false;
    }

    public void setAdjustMode(boolean z11) {
        this.f71305s = z11;
    }

    public void setCallback(b bVar) {
        this.f71293g = bVar;
    }

    public void setCapitalTitle(boolean z11) {
        this.f71289c = z11;
    }

    public void setCoverViewVisibility(boolean z11) {
        ViewUtil.n(this.f71301o, z11);
    }

    public void setDataList(List<String> list) {
        if (this.f71292f == null) {
            this.f71292f = new ArrayList();
        }
        if (list != null) {
            this.f71292f.clear();
            this.f71292f.addAll(list);
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71290d;
        if (commonNavigatorAdapter == null) {
            this.f71290d = new a();
            CopyCommonNavigator copyCommonNavigator = new CopyCommonNavigator(getContext());
            this.f71291e = copyCommonNavigator;
            copyCommonNavigator.setAdjustMode(this.f71305s);
            this.f71291e.setAdapter(this.f71290d);
            this.f71291e.setSmoothScroll(true);
            setNavigator(this.f71291e);
        } else {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
        l();
    }

    public void setIndicatorColor(int i11) {
        this.f71303q = i11;
    }

    public void setInitPostScrollCallback(boolean z11) {
        this.f71302p = z11;
    }

    public void setNavigator(p10.a aVar) {
        super.setNavigator(aVar);
        if (this.f71299m) {
            j();
        }
    }

    public void setOnScrollChangeCallback(c cVar) {
        this.f71298l = cVar;
    }

    public void setTitleViewSelectColor(int i11) {
        this.f71304r = i11;
    }

    public void setUseCoverView(boolean z11) {
        this.f71299m = z11;
        ViewUtil.n(this.f71301o, false);
    }
}
