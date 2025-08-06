package com.hbg.lib.widgets;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.NavigatorHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;
import q10.b;
import q10.c;

public class CopyCommonNavigator extends FrameLayout implements p10.a, NavigatorHelper.a {

    /* renamed from: b  reason: collision with root package name */
    public HorizontalScrollView f71309b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f71310c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f71311d;

    /* renamed from: e  reason: collision with root package name */
    public b f71312e;

    /* renamed from: f  reason: collision with root package name */
    public CommonNavigatorAdapter f71313f;

    /* renamed from: g  reason: collision with root package name */
    public NavigatorHelper f71314g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71315h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71316i;

    /* renamed from: j  reason: collision with root package name */
    public float f71317j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    public boolean f71318k = true;

    /* renamed from: l  reason: collision with root package name */
    public boolean f71319l = true;

    /* renamed from: m  reason: collision with root package name */
    public int f71320m;

    /* renamed from: n  reason: collision with root package name */
    public int f71321n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f71322o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f71323p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f71324q = true;

    /* renamed from: r  reason: collision with root package name */
    public List<PositionData> f71325r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public DataSetObserver f71326s = new a();

    public class a extends DataSetObserver {
        public a() {
        }

        public void onChanged() {
            CopyCommonNavigator.this.f71314g.m(CopyCommonNavigator.this.f71313f.getCount());
            CopyCommonNavigator.this.d();
        }

        public void onInvalidated() {
        }
    }

    public CopyCommonNavigator(Context context) {
        super(context);
        NavigatorHelper navigatorHelper = new NavigatorHelper();
        this.f71314g = navigatorHelper;
        navigatorHelper.k(this);
    }

    public final void d() {
        View view;
        removeAllViews();
        if (this.f71315h) {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        }
        this.f71309b = (HorizontalScrollView) view.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.title_container);
        this.f71310c = linearLayout;
        linearLayout.setPadding(this.f71321n, 0, this.f71320m, 0);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.indicator_container);
        this.f71311d = linearLayout2;
        if (this.f71322o) {
            linearLayout2.getParent().bringChildToFront(this.f71311d);
        }
        e();
    }

    public final void e() {
        LinearLayout.LayoutParams layoutParams;
        int g11 = this.f71314g.g();
        for (int i11 = 0; i11 < g11; i11++) {
            c titleView = this.f71313f.getTitleView(getContext(), i11);
            if (titleView instanceof View) {
                View view = (View) titleView;
                if (this.f71315h) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f71313f.getTitleWeight(getContext(), i11);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f71310c.addView(view, layoutParams);
            }
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71313f;
        if (commonNavigatorAdapter != null) {
            b indicator = commonNavigatorAdapter.getIndicator(getContext());
            this.f71312e = indicator;
            if (!(indicator instanceof View)) {
                return;
            }
            if (((View) indicator).getLayoutParams() == null) {
                this.f71311d.addView((View) this.f71312e, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            this.f71311d.addView((View) this.f71312e);
        }
    }

    public final void f() {
        this.f71325r.clear();
        int g11 = this.f71314g.g();
        for (int i11 = 0; i11 < g11; i11++) {
            PositionData positionData = new PositionData();
            View childAt = this.f71310c.getChildAt(i11);
            if (childAt != null) {
                positionData.f58515a = childAt.getLeft();
                positionData.f58516b = childAt.getTop();
                positionData.f58517c = childAt.getRight();
                int bottom = childAt.getBottom();
                positionData.f58518d = bottom;
                if (childAt instanceof q10.a) {
                    q10.a aVar = (q10.a) childAt;
                    positionData.f58519e = aVar.getContentLeft();
                    positionData.f58520f = aVar.getContentTop();
                    positionData.f58521g = aVar.getContentRight();
                    positionData.f58522h = aVar.getContentBottom();
                } else {
                    positionData.f58519e = positionData.f58515a;
                    positionData.f58520f = positionData.f58516b;
                    positionData.f58521g = positionData.f58517c;
                    positionData.f58522h = bottom;
                }
            }
            this.f71325r.add(positionData);
        }
    }

    public CommonNavigatorAdapter getAdapter() {
        return this.f71313f;
    }

    public int getLeftPadding() {
        return this.f71321n;
    }

    public b getPagerIndicator() {
        return this.f71312e;
    }

    public int getRightPadding() {
        return this.f71320m;
    }

    public float getScrollPivotX() {
        return this.f71317j;
    }

    public LinearLayout getTitleContainer() {
        return this.f71310c;
    }

    public void notifyDataSetChanged() {
        CommonNavigatorAdapter commonNavigatorAdapter = this.f71313f;
        if (commonNavigatorAdapter != null) {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
    }

    public void onAttachToMagicIndicator() {
        d();
    }

    public void onDeselected(int i11, int i12) {
        LinearLayout linearLayout = this.f71310c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onDeselected(i11, i12);
            }
        }
    }

    public void onDetachFromMagicIndicator() {
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f71310c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onEnter(i11, i12, f11, z11);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f71313f != null) {
            f();
            b bVar = this.f71312e;
            if (bVar != null) {
                bVar.onPositionDataProvide(this.f71325r);
            }
            if (this.f71324q && this.f71314g.f() == 0) {
                onPageSelected(this.f71314g.e());
                onPageScrolled(this.f71314g.e(), 0.0f, 0);
            }
        }
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f71310c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onLeave(i11, i12, f11, z11);
            }
        }
    }

    public void onPageScrollStateChanged(int i11) {
        if (this.f71313f != null) {
            this.f71314g.h(i11);
            b bVar = this.f71312e;
            if (bVar != null) {
                bVar.onPageScrollStateChanged(i11);
            }
        }
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.f71313f != null) {
            this.f71314g.i(i11, f11, i12);
            b bVar = this.f71312e;
            if (bVar != null) {
                bVar.onPageScrolled(i11, f11, i12);
            }
            if (this.f71309b != null && this.f71325r.size() > 0 && i11 >= 0 && i11 < this.f71325r.size() && this.f71319l) {
                int min = Math.min(this.f71325r.size() - 1, i11);
                int min2 = Math.min(this.f71325r.size() - 1, i11 + 1);
                float a11 = ((float) this.f71325r.get(min).a()) - (((float) this.f71309b.getWidth()) * this.f71317j);
                this.f71309b.scrollTo((int) (a11 + (((((float) this.f71325r.get(min2).a()) - (((float) this.f71309b.getWidth()) * this.f71317j)) - a11) * f11)), 0);
            }
        }
    }

    public void onPageSelected(int i11) {
        if (this.f71313f != null) {
            this.f71314g.j(i11);
            b bVar = this.f71312e;
            if (bVar != null) {
                bVar.onPageSelected(i11);
            }
        }
    }

    public void onSelected(int i11, int i12) {
        LinearLayout linearLayout = this.f71310c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onSelected(i11, i12);
            }
            if (!this.f71315h && !this.f71319l && this.f71309b != null && this.f71325r.size() > 0) {
                PositionData positionData = this.f71325r.get(Math.min(this.f71325r.size() - 1, i11));
                if (this.f71316i) {
                    float a11 = ((float) positionData.a()) - (((float) this.f71309b.getWidth()) * this.f71317j);
                    if (this.f71318k) {
                        this.f71309b.smoothScrollTo((int) a11, 0);
                    } else {
                        this.f71309b.scrollTo((int) a11, 0);
                    }
                } else {
                    int scrollX = this.f71309b.getScrollX();
                    int i13 = positionData.f58515a;
                    if (scrollX <= i13) {
                        int scrollX2 = this.f71309b.getScrollX() + getWidth();
                        int i14 = positionData.f58517c;
                        if (scrollX2 >= i14) {
                            return;
                        }
                        if (this.f71318k) {
                            this.f71309b.smoothScrollTo(i14 - getWidth(), 0);
                        } else {
                            this.f71309b.scrollTo(i14 - getWidth(), 0);
                        }
                    } else if (this.f71318k) {
                        this.f71309b.smoothScrollTo(i13, 0);
                    } else {
                        this.f71309b.scrollTo(i13, 0);
                    }
                }
            }
        }
    }

    public void setAdapter(CommonNavigatorAdapter commonNavigatorAdapter) {
        CommonNavigatorAdapter commonNavigatorAdapter2 = this.f71313f;
        if (commonNavigatorAdapter2 != commonNavigatorAdapter) {
            if (commonNavigatorAdapter2 != null) {
                commonNavigatorAdapter2.unregisterDataSetObserver(this.f71326s);
            }
            this.f71313f = commonNavigatorAdapter;
            if (commonNavigatorAdapter != null) {
                commonNavigatorAdapter.registerDataSetObserver(this.f71326s);
                this.f71314g.m(this.f71313f.getCount());
                if (this.f71310c != null) {
                    this.f71313f.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.f71314g.m(0);
            d();
        }
    }

    public void setAdjustMode(boolean z11) {
        this.f71315h = z11;
    }

    public void setEnablePivotScroll(boolean z11) {
        this.f71316i = z11;
    }

    public void setFollowTouch(boolean z11) {
        this.f71319l = z11;
    }

    public void setIndicatorOnTop(boolean z11) {
        this.f71322o = z11;
    }

    public void setLeftPadding(int i11) {
        this.f71321n = i11;
    }

    public void setReselectWhenLayout(boolean z11) {
        this.f71324q = z11;
    }

    public void setRightPadding(int i11) {
        this.f71320m = i11;
    }

    public void setScrollPivotX(float f11) {
        this.f71317j = f11;
    }

    public void setSkimOver(boolean z11) {
        this.f71323p = z11;
        this.f71314g.l(z11);
    }

    public void setSmoothScroll(boolean z11) {
        this.f71318k = z11;
    }
}
