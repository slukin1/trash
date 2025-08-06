package net.lucode.hackware.magicindicator.buildins.commonnavigator;

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
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;
import q10.b;
import q10.c;

public class CommonNavigator extends FrameLayout implements p10.a, NavigatorHelper.a {

    /* renamed from: b  reason: collision with root package name */
    public HorizontalScrollView f58474b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f58475c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f58476d;

    /* renamed from: e  reason: collision with root package name */
    public b f58477e;

    /* renamed from: f  reason: collision with root package name */
    public CommonNavigatorAdapter f58478f;

    /* renamed from: g  reason: collision with root package name */
    public NavigatorHelper f58479g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58480h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58481i;

    /* renamed from: j  reason: collision with root package name */
    public float f58482j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    public boolean f58483k = true;

    /* renamed from: l  reason: collision with root package name */
    public boolean f58484l = true;

    /* renamed from: m  reason: collision with root package name */
    public int f58485m;

    /* renamed from: n  reason: collision with root package name */
    public int f58486n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f58487o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f58488p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f58489q = true;

    /* renamed from: r  reason: collision with root package name */
    public List<PositionData> f58490r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    public DataSetObserver f58491s = new a();

    public class a extends DataSetObserver {
        public a() {
        }

        public void onChanged() {
            CommonNavigator.this.f58479g.m(CommonNavigator.this.f58478f.getCount());
            CommonNavigator.this.e();
        }

        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        NavigatorHelper navigatorHelper = new NavigatorHelper();
        this.f58479g = navigatorHelper;
        navigatorHelper.k(this);
    }

    public c d(int i11) {
        LinearLayout linearLayout = this.f58475c;
        if (linearLayout == null) {
            return null;
        }
        return (c) linearLayout.getChildAt(i11);
    }

    public final void e() {
        View view;
        removeAllViews();
        if (this.f58480h) {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        }
        this.f58474b = (HorizontalScrollView) view.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.title_container);
        this.f58475c = linearLayout;
        linearLayout.setPadding(this.f58486n, 0, this.f58485m, 0);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.indicator_container);
        this.f58476d = linearLayout2;
        if (this.f58487o) {
            linearLayout2.getParent().bringChildToFront(this.f58476d);
        }
        f();
    }

    public final void f() {
        LinearLayout.LayoutParams layoutParams;
        int g11 = this.f58479g.g();
        for (int i11 = 0; i11 < g11; i11++) {
            c titleView = this.f58478f.getTitleView(getContext(), i11);
            if (titleView instanceof View) {
                View view = (View) titleView;
                if (this.f58480h) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f58478f.getTitleWeight(getContext(), i11);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f58475c.addView(view, layoutParams);
            }
        }
        CommonNavigatorAdapter commonNavigatorAdapter = this.f58478f;
        if (commonNavigatorAdapter != null) {
            b indicator = commonNavigatorAdapter.getIndicator(getContext());
            this.f58477e = indicator;
            if (indicator instanceof View) {
                this.f58476d.addView((View) this.f58477e, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    public final void g() {
        this.f58490r.clear();
        int g11 = this.f58479g.g();
        for (int i11 = 0; i11 < g11; i11++) {
            PositionData positionData = new PositionData();
            View childAt = this.f58475c.getChildAt(i11);
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
            this.f58490r.add(positionData);
        }
    }

    public CommonNavigatorAdapter getAdapter() {
        return this.f58478f;
    }

    public int getLeftPadding() {
        return this.f58486n;
    }

    public b getPagerIndicator() {
        return this.f58477e;
    }

    public int getRightPadding() {
        return this.f58485m;
    }

    public float getScrollPivotX() {
        return this.f58482j;
    }

    public LinearLayout getTitleContainer() {
        return this.f58475c;
    }

    public void notifyDataSetChanged() {
        CommonNavigatorAdapter commonNavigatorAdapter = this.f58478f;
        if (commonNavigatorAdapter != null) {
            commonNavigatorAdapter.notifyDataSetChanged();
        }
    }

    public void onAttachToMagicIndicator() {
        e();
    }

    public void onDeselected(int i11, int i12) {
        LinearLayout linearLayout = this.f58475c;
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
        LinearLayout linearLayout = this.f58475c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onEnter(i11, i12, f11, z11);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f58478f != null) {
            g();
            b bVar = this.f58477e;
            if (bVar != null) {
                bVar.onPositionDataProvide(this.f58490r);
            }
            if (this.f58489q && this.f58479g.f() == 0) {
                onPageSelected(this.f58479g.e());
                onPageScrolled(this.f58479g.e(), 0.0f, 0);
            }
        }
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f58475c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onLeave(i11, i12, f11, z11);
            }
        }
    }

    public void onPageScrollStateChanged(int i11) {
        if (this.f58478f != null) {
            this.f58479g.h(i11);
            b bVar = this.f58477e;
            if (bVar != null) {
                bVar.onPageScrollStateChanged(i11);
            }
        }
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.f58478f != null) {
            this.f58479g.i(i11, f11, i12);
            b bVar = this.f58477e;
            if (bVar != null) {
                bVar.onPageScrolled(i11, f11, i12);
            }
            if (this.f58474b != null && this.f58490r.size() > 0 && i11 >= 0 && i11 < this.f58490r.size() && this.f58484l) {
                int min = Math.min(this.f58490r.size() - 1, i11);
                int min2 = Math.min(this.f58490r.size() - 1, i11 + 1);
                float a11 = ((float) this.f58490r.get(min).a()) - (((float) this.f58474b.getWidth()) * this.f58482j);
                this.f58474b.scrollTo((int) (a11 + (((((float) this.f58490r.get(min2).a()) - (((float) this.f58474b.getWidth()) * this.f58482j)) - a11) * f11)), 0);
            }
        }
    }

    public void onPageSelected(int i11) {
        if (this.f58478f != null) {
            this.f58479g.j(i11);
            b bVar = this.f58477e;
            if (bVar != null) {
                bVar.onPageSelected(i11);
            }
        }
    }

    public void onSelected(int i11, int i12) {
        LinearLayout linearLayout = this.f58475c;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i11);
            if (childAt instanceof c) {
                ((c) childAt).onSelected(i11, i12);
            }
            if (!this.f58480h && !this.f58484l && this.f58474b != null && this.f58490r.size() > 0) {
                PositionData positionData = this.f58490r.get(Math.min(this.f58490r.size() - 1, i11));
                if (this.f58481i) {
                    float a11 = ((float) positionData.a()) - (((float) this.f58474b.getWidth()) * this.f58482j);
                    if (this.f58483k) {
                        this.f58474b.smoothScrollTo((int) a11, 0);
                    } else {
                        this.f58474b.scrollTo((int) a11, 0);
                    }
                } else {
                    int scrollX = this.f58474b.getScrollX();
                    int i13 = positionData.f58515a;
                    if (scrollX <= i13) {
                        int scrollX2 = this.f58474b.getScrollX() + getWidth();
                        int i14 = positionData.f58517c;
                        if (scrollX2 >= i14) {
                            return;
                        }
                        if (this.f58483k) {
                            this.f58474b.smoothScrollTo(i14 - getWidth(), 0);
                        } else {
                            this.f58474b.scrollTo(i14 - getWidth(), 0);
                        }
                    } else if (this.f58483k) {
                        this.f58474b.smoothScrollTo(i13, 0);
                    } else {
                        this.f58474b.scrollTo(i13, 0);
                    }
                }
            }
        }
    }

    public void setAdapter(CommonNavigatorAdapter commonNavigatorAdapter) {
        CommonNavigatorAdapter commonNavigatorAdapter2 = this.f58478f;
        if (commonNavigatorAdapter2 != commonNavigatorAdapter) {
            if (commonNavigatorAdapter2 != null) {
                commonNavigatorAdapter2.unregisterDataSetObserver(this.f58491s);
            }
            this.f58478f = commonNavigatorAdapter;
            if (commonNavigatorAdapter != null) {
                commonNavigatorAdapter.registerDataSetObserver(this.f58491s);
                this.f58479g.m(this.f58478f.getCount());
                if (this.f58475c != null) {
                    this.f58478f.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.f58479g.m(0);
            e();
        }
    }

    public void setAdjustMode(boolean z11) {
        this.f58480h = z11;
    }

    public void setEnablePivotScroll(boolean z11) {
        this.f58481i = z11;
    }

    public void setFollowTouch(boolean z11) {
        this.f58484l = z11;
    }

    public void setIndicatorOnTop(boolean z11) {
        this.f58487o = z11;
    }

    public void setLeftPadding(int i11) {
        this.f58486n = i11;
    }

    public void setReselectWhenLayout(boolean z11) {
        this.f58489q = z11;
    }

    public void setRightPadding(int i11) {
        this.f58485m = i11;
    }

    public void setScrollPivotX(float f11) {
        this.f58482j = f11;
    }

    public void setSkimOver(boolean z11) {
        this.f58488p = z11;
        this.f58479g.l(z11);
    }

    public void setSmoothScroll(boolean z11) {
        this.f58483k = z11;
    }
}
