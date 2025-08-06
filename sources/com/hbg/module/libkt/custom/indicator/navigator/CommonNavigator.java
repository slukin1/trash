package com.hbg.module.libkt.custom.indicator.navigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.hbg.module.libkt.R$id;
import com.hbg.module.libkt.R$layout;
import com.hbg.module.libkt.custom.indicator.NavigatorHelper;
import com.hbg.module.libkt.custom.indicator.navigator.adapter.NavigatorAdapter;
import com.hbg.module.libkt.custom.indicator.navigator.model.PositionData;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import oe.b;
import pe.c;

public final class CommonNavigator extends FrameLayout implements oe.a, b {

    /* renamed from: b  reason: collision with root package name */
    public HorizontalScrollView f24787b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f24788c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f24789d;

    /* renamed from: e  reason: collision with root package name */
    public pe.b f24790e;

    /* renamed from: f  reason: collision with root package name */
    public NavigatorAdapter f24791f;

    /* renamed from: g  reason: collision with root package name */
    public NavigatorHelper f24792g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24793h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24794i;

    /* renamed from: j  reason: collision with root package name */
    public float f24795j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f24796k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f24797l;

    /* renamed from: m  reason: collision with root package name */
    public int f24798m;

    /* renamed from: n  reason: collision with root package name */
    public int f24799n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f24800o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f24801p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f24802q;

    /* renamed from: r  reason: collision with root package name */
    public int f24803r;

    /* renamed from: s  reason: collision with root package name */
    public final ArrayList<PositionData> f24804s;

    /* renamed from: t  reason: collision with root package name */
    public final DataSetObserver f24805t;

    public static final class a extends DataSetObserver {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CommonNavigator f24806a;

        public a(CommonNavigator commonNavigator) {
            this.f24806a = commonNavigator;
        }

        public void onChanged() {
            NavigatorAdapter mAdapter = this.f24806a.getMAdapter();
            if (mAdapter != null) {
                this.f24806a.f24792g.m(mAdapter.a());
            }
            this.f24806a.d();
        }

        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context, int i11) {
        super(context);
        this.f24792g = new NavigatorHelper();
        this.f24795j = 0.5f;
        this.f24796k = true;
        this.f24797l = true;
        this.f24799n = i11;
        this.f24802q = true;
        this.f24804s = new ArrayList<>();
        this.f24805t = new a(this);
        this.f24792g.k(this);
    }

    public final c c(int i11) {
        LinearLayout linearLayout = this.f24788c;
        View view = null;
        if (linearLayout == null) {
            return null;
        }
        if (linearLayout != null) {
            view = linearLayout.getChildAt(i11);
        }
        return (c) view;
    }

    public final void d() {
        View view;
        ViewParent parent;
        removeAllViews();
        if (this.f24793h) {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        }
        this.f24787b = (HorizontalScrollView) view.findViewById(R$id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.title_container);
        this.f24788c = linearLayout;
        if (linearLayout != null) {
            linearLayout.setPadding(this.f24799n, 0, this.f24798m, 0);
        }
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.indicator_container);
        this.f24789d = linearLayout2;
        if (!(!this.f24800o || linearLayout2 == null || (parent = linearLayout2.getParent()) == null)) {
            parent.bringChildToFront(this.f24789d);
        }
        e();
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [pe.c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r7 = this;
            com.hbg.module.libkt.custom.indicator.NavigatorHelper r0 = r7.f24792g
            int r0 = r0.g()
            r1 = 0
            r2 = r1
        L_0x0008:
            r3 = 0
            r4 = -1
            if (r2 >= r0) goto L_0x004f
            com.hbg.module.libkt.custom.indicator.navigator.adapter.NavigatorAdapter r5 = r7.f24791f
            if (r5 == 0) goto L_0x0018
            android.content.Context r3 = r7.getContext()
            pe.c r3 = r5.c(r3, r2)
        L_0x0018:
            boolean r5 = r3 instanceof android.view.View
            if (r5 == 0) goto L_0x004c
            android.view.View r3 = (android.view.View) r3
            boolean r5 = r7.f24793h
            if (r5 == 0) goto L_0x0038
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r5.<init>(r1, r4)
            com.hbg.module.libkt.custom.indicator.navigator.adapter.NavigatorAdapter r4 = r7.f24791f
            if (r4 == 0) goto L_0x0034
            android.content.Context r6 = r7.getContext()
            float r4 = r4.d(r6, r2)
            goto L_0x0035
        L_0x0034:
            r4 = 0
        L_0x0035:
            r5.weight = r4
            goto L_0x0045
        L_0x0038:
            android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
            r6 = -2
            r5.<init>(r6, r4)
            int r4 = r7.f24803r
            if (r4 <= 0) goto L_0x0045
            r5.setMarginEnd(r4)
        L_0x0045:
            android.widget.LinearLayout r4 = r7.f24788c
            if (r4 == 0) goto L_0x004c
            r4.addView(r3, r5)
        L_0x004c:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x004f:
            com.hbg.module.libkt.custom.indicator.navigator.adapter.NavigatorAdapter r0 = r7.f24791f
            if (r0 == 0) goto L_0x0073
            if (r0 == 0) goto L_0x005d
            android.content.Context r1 = r7.getContext()
            pe.b r3 = r0.b(r1)
        L_0x005d:
            r7.f24790e = r3
            boolean r0 = r3 instanceof android.view.View
            if (r0 == 0) goto L_0x0073
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r0.<init>(r4, r4)
            android.widget.LinearLayout r1 = r7.f24789d
            if (r1 == 0) goto L_0x0073
            pe.b r2 = r7.f24790e
            android.view.View r2 = (android.view.View) r2
            r1.addView(r2, r0)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.custom.indicator.navigator.CommonNavigator.e():void");
    }

    public final void f() {
        this.f24804s.clear();
        int g11 = this.f24792g.g();
        for (int i11 = 0; i11 < g11; i11++) {
            PositionData positionData = new PositionData();
            LinearLayout linearLayout = this.f24788c;
            View childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
            if (childAt != null) {
                positionData.o(childAt.getLeft());
                positionData.q(childAt.getTop());
                positionData.p(childAt.getRight());
                positionData.j(childAt.getBottom());
                if (childAt instanceof pe.a) {
                    pe.a aVar = (pe.a) childAt;
                    positionData.l(aVar.getContentLeft());
                    positionData.n(aVar.getContentTop());
                    positionData.m(aVar.getContentRight());
                    positionData.k(aVar.getContentBottom());
                } else {
                    positionData.l(positionData.f());
                    positionData.n(positionData.h());
                    positionData.m(positionData.g());
                    positionData.k(positionData.a());
                }
            }
            this.f24804s.add(positionData);
        }
    }

    public final NavigatorAdapter getMAdapter() {
        return this.f24791f;
    }

    public void onAttachToMagicIndicator() {
        d();
    }

    public void onDeselected(int i11, int i12) {
        LinearLayout linearLayout = this.f24788c;
        if (linearLayout != null) {
            View childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
            if (childAt instanceof c) {
                ((c) childAt).onDeselected(i11, i12);
            }
        }
    }

    public void onDetachFromMagicIndicator() {
    }

    public void onEnter(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f24788c;
        if (linearLayout != null) {
            View childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
            if (childAt instanceof c) {
                ((c) childAt).onEnter(i11, i12, f11, z11);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f24791f != null) {
            f();
            pe.b bVar = this.f24790e;
            if (bVar != null) {
                bVar.a(this.f24804s);
            }
            if (this.f24802q && this.f24792g.f() == 0) {
                onPageSelected(this.f24792g.e());
                onPageScrolled(this.f24792g.e(), 0.0f, 0);
            }
        }
    }

    public void onLeave(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f24788c;
        if (linearLayout != null) {
            View childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
            if (childAt instanceof c) {
                ((c) childAt).onLeave(i11, i12, f11, z11);
            }
        }
    }

    public void onPageScrollStateChanged(int i11) {
        if (this.f24791f != null) {
            this.f24792g.h(i11);
            pe.b bVar = this.f24790e;
            if (bVar != null) {
                bVar.onPageScrollStateChanged(i11);
            }
        }
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.f24791f != null) {
            this.f24792g.i(i11, f11);
            pe.b bVar = this.f24790e;
            if (!(bVar == null || bVar == null)) {
                bVar.onPageScrolled(i11, f11, i12);
            }
            if (this.f24787b != null && this.f24804s.size() > 0 && i11 >= 0 && i11 < this.f24804s.size() && this.f24797l) {
                int min = Math.min(this.f24804s.size() - 1, i11);
                int min2 = Math.min(this.f24804s.size() - 1, i11 + 1);
                float i13 = ((float) this.f24804s.get(min).i()) - (((float) this.f24787b.getWidth()) * this.f24795j);
                float i14 = ((float) this.f24804s.get(min2).i()) - (((float) this.f24787b.getWidth()) * this.f24795j);
                HorizontalScrollView horizontalScrollView = this.f24787b;
                if (horizontalScrollView != null) {
                    horizontalScrollView.scrollTo((int) (i13 + ((i14 - i13) * f11)), 0);
                }
            }
        }
    }

    public void onPageSelected(int i11) {
        if (this.f24791f != null) {
            this.f24792g.j(i11);
            pe.b bVar = this.f24790e;
            if (bVar != null) {
                bVar.onPageSelected(i11);
            }
        }
    }

    public void onSelected(int i11, int i12) {
        LinearLayout linearLayout = this.f24788c;
        if (linearLayout != null) {
            View childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
            if (childAt instanceof c) {
                ((c) childAt).onSelected(i11, i12);
            }
            if (!this.f24793h && !this.f24797l && this.f24787b != null && this.f24804s.size() > 0) {
                PositionData positionData = this.f24804s.get(Math.min(this.f24804s.size() - 1, i11));
                if (this.f24794i) {
                    float i13 = ((float) positionData.i()) - (((float) this.f24787b.getWidth()) * this.f24795j);
                    if (this.f24796k) {
                        HorizontalScrollView horizontalScrollView = this.f24787b;
                        if (horizontalScrollView != null) {
                            horizontalScrollView.smoothScrollTo((int) i13, 0);
                            return;
                        }
                        return;
                    }
                    HorizontalScrollView horizontalScrollView2 = this.f24787b;
                    if (horizontalScrollView2 != null) {
                        horizontalScrollView2.scrollTo((int) i13, 0);
                    }
                } else if (this.f24787b.getScrollX() > positionData.f()) {
                    if (this.f24796k) {
                        HorizontalScrollView horizontalScrollView3 = this.f24787b;
                        if (horizontalScrollView3 != null) {
                            horizontalScrollView3.smoothScrollTo(positionData.f(), 0);
                            return;
                        }
                        return;
                    }
                    HorizontalScrollView horizontalScrollView4 = this.f24787b;
                    if (horizontalScrollView4 != null) {
                        horizontalScrollView4.scrollTo(positionData.f(), 0);
                    }
                } else if (this.f24787b.getScrollX() + getWidth() >= positionData.g()) {
                } else {
                    if (this.f24796k) {
                        HorizontalScrollView horizontalScrollView5 = this.f24787b;
                        if (horizontalScrollView5 != null) {
                            horizontalScrollView5.smoothScrollTo(positionData.g() - getWidth(), 0);
                            return;
                        }
                        return;
                    }
                    HorizontalScrollView horizontalScrollView6 = this.f24787b;
                    if (horizontalScrollView6 != null) {
                        horizontalScrollView6.scrollTo(positionData.g() - getWidth(), 0);
                    }
                }
            }
        }
    }

    public final void setAdapter(NavigatorAdapter navigatorAdapter) {
        NavigatorAdapter navigatorAdapter2;
        NavigatorAdapter navigatorAdapter3 = this.f24791f;
        if (navigatorAdapter3 != navigatorAdapter) {
            if (navigatorAdapter3 != null) {
                navigatorAdapter3.g(this.f24805t);
            }
            this.f24791f = navigatorAdapter;
            if (navigatorAdapter != null) {
                if (navigatorAdapter != null) {
                    navigatorAdapter.f(this.f24805t);
                }
                NavigatorAdapter navigatorAdapter4 = this.f24791f;
                if (navigatorAdapter4 != null) {
                    this.f24792g.m(navigatorAdapter4.a());
                }
                if (this.f24788c != null && (navigatorAdapter2 = this.f24791f) != null) {
                    navigatorAdapter2.e();
                    return;
                }
                return;
            }
            this.f24792g.m(0);
            d();
        }
    }

    public final void setAdjustMode(boolean z11) {
        this.f24793h = z11;
    }

    public final void setMAdapter(NavigatorAdapter navigatorAdapter) {
        this.f24791f = navigatorAdapter;
    }

    public final void setSkimOver(boolean z11) {
        this.f24801p = z11;
        this.f24792g.l(z11);
    }

    public final void setViwMarginEnd(int i11) {
        this.f24803r = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonNavigator(Context context, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? 0 : i11);
    }
}
