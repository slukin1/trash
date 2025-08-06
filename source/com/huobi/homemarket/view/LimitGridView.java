package com.huobi.homemarket.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Iterator;
import java.util.LinkedList;

public class LimitGridView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public int f73021b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f73022c = 0;

    /* renamed from: d  reason: collision with root package name */
    public DataSetObserver f73023d = new a();

    /* renamed from: e  reason: collision with root package name */
    public BaseAdapter f73024e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f73025f = 10;

    /* renamed from: g  reason: collision with root package name */
    public int f73026g = 8;

    /* renamed from: h  reason: collision with root package name */
    public AdapterView.OnItemClickListener f73027h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f73028i = 0;

    /* renamed from: j  reason: collision with root package name */
    public final int f73029j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int[] f73030k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f73031l;

    /* renamed from: m  reason: collision with root package name */
    public int f73032m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f73033n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f73034o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f73035p = RoundedDrawable.DEFAULT_BORDER_COLOR;

    /* renamed from: q  reason: collision with root package name */
    public int f73036q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f73037r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f73038s = 0;

    /* renamed from: t  reason: collision with root package name */
    public c[] f73039t;

    /* renamed from: u  reason: collision with root package name */
    public LinkedList<d> f73040u = new LinkedList<>();

    /* renamed from: v  reason: collision with root package name */
    public int f73041v = 0;

    /* renamed from: w  reason: collision with root package name */
    public int f73042w = 0;

    public class a extends DataSetObserver {
        public a() {
        }

        public void onChanged() {
            super.onChanged();
            LimitGridView.this.k();
        }
    }

    public class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f73044b;

        public b(int i11) {
            this.f73044b = i11;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (LimitGridView.this.f73027h != null) {
                AdapterView.OnItemClickListener b11 = LimitGridView.this.f73027h;
                int i11 = this.f73044b;
                b11.onItemClick((AdapterView) null, view, i11, (long) i11);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f73046a;

        /* renamed from: b  reason: collision with root package name */
        public int f73047b;

        /* renamed from: c  reason: collision with root package name */
        public int f73048c;

        /* renamed from: d  reason: collision with root package name */
        public int f73049d;

        public c() {
        }

        public /* synthetic */ c(LimitGridView limitGridView, a aVar) {
            this();
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public int f73051a;

        /* renamed from: b  reason: collision with root package name */
        public int f73052b;

        /* renamed from: c  reason: collision with root package name */
        public int f73053c;

        /* renamed from: d  reason: collision with root package name */
        public LinkedList<c> f73054d = new LinkedList<>();

        public d(int i11, int i12) {
            this.f73051a = i11;
            this.f73052b = i12;
        }
    }

    public LimitGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int c(int i11, int i12) {
        int i13 = 0;
        while (i11 <= i12) {
            int[] iArr = this.f73031l;
            if (i11 >= iArr.length) {
                break;
            }
            if (i13 < iArr[i11]) {
                i13 = iArr[i11];
            }
            i11++;
        }
        return i13;
    }

    public final void d(Canvas canvas) {
        int childCount = getChildCount();
        if (childCount > 0) {
            Paint paint = new Paint();
            paint.setColor(this.f73035p);
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if ((this.f73034o & 1) == 1) {
                    canvas.drawRect((float) childAt.getRight(), (float) childAt.getTop(), (float) (childAt.getRight() + 1), (float) (childAt.getBottom() + 1), paint);
                }
                if ((this.f73034o & 2) == 2) {
                    canvas.drawRect((float) childAt.getLeft(), (float) childAt.getBottom(), (float) (childAt.getRight() + 1), (float) (childAt.getBottom() + 1), paint);
                }
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f73034o != 0) {
            d(canvas);
        }
    }

    public final d e(int i11, int i12, int i13) {
        Iterator it2 = this.f73040u.iterator();
        while (it2.hasNext()) {
            d dVar = (d) it2.next();
            int i14 = dVar.f73051a;
            int i15 = this.f73021b;
            if (i14 > i11 + i15) {
                dVar.f73051a = i14 - i15;
                dVar.f73052b += i15;
                if (this.f73042w == 0) {
                    this.f73041v++;
                }
                return dVar;
            }
            this.f73042w++;
        }
        if (this.f73040u.size() >= this.f73025f) {
            return null;
        }
        d dVar2 = new d(i12, getPaddingLeft());
        if (this.f73040u.size() > 0) {
            dVar2.f73053c = this.f73040u.getLast().f73053c + i13 + this.f73022c;
        } else {
            dVar2.f73053c = getPaddingTop();
        }
        this.f73040u.add(dVar2);
        return dVar2;
    }

    public final void f(boolean z11, int i11, int i12, int i13, int i14) {
        int paddingTop = getPaddingTop();
        int i15 = i13 - i11;
        int paddingLeft = (i15 - getPaddingLeft()) - getPaddingRight();
        int i16 = this.f73021b;
        int i17 = (paddingLeft + i16) / (this.f73032m + i16);
        int i18 = this.f73026g;
        if (i17 >= i18) {
            i17 = i18;
        }
        int round = Math.round(((((float) ((i15 - getPaddingLeft()) - getPaddingRight())) - ((float) (this.f73032m * i17))) - ((float) ((i17 - 1) * this.f73021b))) / 2.0f);
        int i19 = 0;
        while (i19 < this.f73025f) {
            for (int i21 = 0; i21 < i17; i21++) {
                int paddingLeft2 = getPaddingLeft() + round + ((this.f73032m + this.f73021b) * i21);
                int i22 = (i19 * i17) + i21;
                View childAt = getChildAt(i22);
                int i23 = this.f73032m + paddingLeft2;
                if (childAt == null) {
                    break;
                }
                childAt.layout(paddingLeft2, paddingTop, i23, this.f73031l[i22] + paddingTop);
            }
            int i24 = i19 * i17;
            i19++;
            paddingTop += c(i24, (i19 * i17) - 1) + this.f73022c;
        }
    }

    public final void g(boolean z11, int i11, int i12, int i13, int i14) {
        for (int i15 = 0; i15 < getChildCount(); i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() == 0) {
                c cVar = this.f73039t[i15];
                int i16 = cVar.f73046a;
                int i17 = cVar.f73047b;
                childAt.layout(i16, i17, cVar.f73048c + i16, cVar.f73049d + i17);
            }
        }
    }

    public BaseAdapter getAdapter() {
        return this.f73024e;
    }

    public int getmMaxColCount() {
        return this.f73041v + 1;
    }

    public final void h(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (getChildCount() > 0) {
            this.f73030k = new int[getChildCount()];
            this.f73031l = new int[getChildCount()];
            int i13 = 0;
            for (int i14 = 0; i14 < getChildCount(); i14++) {
                View childAt = getChildAt(i14);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (this.f73028i == 0) {
                    layoutParams.width = -2;
                    measureChildWithMargins(childAt, i11, 0, i12, 0);
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (this.f73032m < measuredWidth) {
                        this.f73032m = measuredWidth;
                    }
                }
                this.f73031l[i14] = childAt.getMeasuredHeight();
                this.f73030k[i14] = childAt.getMeasuredWidth();
            }
            int i15 = this.f73026g;
            if (mode != 0) {
                int paddingLeft2 = (size - getPaddingLeft()) - getPaddingRight();
                int i16 = this.f73021b;
                i15 = Math.min((paddingLeft2 + i16) / (this.f73032m + i16), this.f73026g);
                if (i15 < 0) {
                    int floor = (int) Math.floor((double) ((((size - getPaddingLeft()) - getPaddingRight()) - (this.f73021b * 2)) / 0));
                    this.f73032m = floor;
                    for (int i17 = 0; i17 < getChildCount(); i17++) {
                        View childAt2 = getChildAt(i17);
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec(floor, 1073741824), i12);
                        this.f73030k[i17] = childAt2.getMeasuredWidth();
                        this.f73031l[i17] = childAt2.getMeasuredHeight();
                    }
                    i15 = 0;
                }
            }
            if (i15 > getChildCount()) {
                i15 = getChildCount();
            }
            paddingLeft += (this.f73032m * i15) + (this.f73021b * (i15 - 1));
            while (i13 < this.f73025f) {
                int i18 = i13 * i15;
                i13++;
                paddingTop += c(i18, (i13 * i15) - 1) + this.f73022c;
            }
        }
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public final void i(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (getChildCount() > 0) {
            this.f73030k = new int[getChildCount()];
            this.f73031l = new int[getChildCount()];
            int i13 = 0;
            for (int i14 = 0; i14 < getChildCount(); i14++) {
                View childAt = getChildAt(i14);
                int paddingLeft2 = (size - getPaddingLeft()) - getPaddingRight();
                int i15 = this.f73021b;
                int i16 = this.f73036q;
                int floor = (int) Math.floor((double) ((paddingLeft2 - (i15 * (i16 - 1))) / i16));
                this.f73032m = floor;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                }
                childAt.measure(FrameLayout.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(floor, 1073741824), 0, layoutParams.width), FrameLayout.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
                this.f73031l[i14] = childAt.getMeasuredHeight();
                this.f73030k[i14] = childAt.getMeasuredWidth();
            }
            int i17 = this.f73036q;
            paddingLeft += (this.f73032m * i17) + (this.f73021b * (i17 - 1));
            while (i13 < this.f73025f) {
                int i18 = this.f73036q;
                int i19 = i13 * i18;
                i13++;
                paddingTop += c(i19, (i18 * i13) - 1) + this.f73022c;
            }
        }
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public final void j(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z11;
        int i17;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        if (mode == 0) {
            if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                i17 = (PixelUtils.g() - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            } else {
                i17 = PixelUtils.g();
            }
            i15 = View.MeasureSpec.makeMeasureSpec(i17, 1073741824);
            i13 = i17;
            i14 = 1073741824;
        } else {
            i15 = i11;
            i14 = mode;
            i13 = size;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int i18 = i13 - paddingLeft;
        int childCount = getChildCount();
        if (childCount > 0) {
            this.f73039t = new c[childCount];
            this.f73040u.clear();
            boolean z12 = false;
            this.f73041v = 0;
            this.f73042w = 0;
            int i19 = paddingTop;
            int i21 = 0;
            boolean z13 = false;
            while (i21 < childCount) {
                View childAt = getChildAt(i21);
                if (z13) {
                    childAt.setVisibility(8);
                    z11 = z12;
                    i16 = i21;
                } else {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    View view = childAt;
                    int i22 = i21;
                    measureChildWithMargins(childAt, i15, 0, i12, 0);
                    c cVar = new c(this, (a) null);
                    cVar.f73048c = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    cVar.f73049d = measuredHeight;
                    d e11 = e(cVar.f73048c, i18, measuredHeight);
                    if (e11 == null) {
                        view.setVisibility(8);
                        z13 = true;
                        i16 = i22;
                        z11 = false;
                    } else {
                        int i23 = e11.f73052b;
                        cVar.f73046a = i23;
                        cVar.f73047b = e11.f73053c;
                        int i24 = e11.f73051a;
                        int i25 = cVar.f73048c;
                        e11.f73051a = i24 - i25;
                        e11.f73052b = i23 + i25;
                        e11.f73054d.add(cVar);
                        i16 = i22;
                        this.f73039t[i16] = cVar;
                        int i26 = cVar.f73047b + cVar.f73049d;
                        i6.d.d("measureUnaequilate i:" + i16 + " info.mHeight:" + cVar.f73049d + " measuredHeight：" + i26 + " info.mY：" + cVar.f73047b);
                        z11 = false;
                        view.setVisibility(0);
                        i19 = i26;
                    }
                }
                i21 = i16 + 1;
                z12 = z11;
            }
            paddingTop = i19;
        }
        int paddingBottom = paddingTop + getPaddingBottom();
        if (i14 != 1073741824) {
            i13 = paddingLeft;
        }
        this.f73037r = i13;
        if (mode2 != 1073741824) {
            size2 = paddingBottom;
        }
        this.f73038s = size2;
        this.f73033n++;
        setMeasuredDimension(i13, size2);
    }

    public final void k() {
        if (this.f73024e != null) {
            this.f73033n = 0;
            removeAllViews();
            int count = this.f73024e.getCount();
            int i11 = this.f73026g;
            int i12 = this.f73025f;
            int count2 = count > i11 * i12 ? i11 * i12 : this.f73024e.getCount();
            for (int i13 = 0; i13 < count2; i13++) {
                View view = null;
                if (i13 < getChildCount()) {
                    view = getChildAt(i13);
                }
                View view2 = this.f73024e.getView(i13, view, this);
                if (view2 != null) {
                    view2.setOnClickListener(new b(i13));
                    if (view != view2) {
                        removeView(view);
                        addView(view2, i13);
                    }
                }
            }
            requestLayout();
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        if (getChildCount() != 0) {
            int i15 = this.f73028i;
            if (i15 == 0) {
                f(z11, i11, i12, i13, i14);
            } else if (i15 == 1) {
                f(z11, i11, i12, i13, i14);
            } else if (i15 == 2) {
                g(z11, i11, i12, i13, i14);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.f73028i;
        if (i13 == 0) {
            h(i11, i12);
        } else if (i13 == 1) {
            i(i11, i12);
        } else if (i13 == 2) {
            j(i11, i12);
        }
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        BaseAdapter baseAdapter2 = this.f73024e;
        if (baseAdapter2 != null) {
            baseAdapter2.unregisterDataSetObserver(this.f73023d);
        }
        this.f73024e = baseAdapter;
        baseAdapter.registerDataSetObserver(this.f73023d);
    }

    public void setFixedLineCount(int i11) {
        this.f73036q = i11;
    }

    public void setGridViewMode(int i11) {
        this.f73028i = i11;
    }

    public void setItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.f73027h = onItemClickListener;
    }

    public void setMaxChildCountPerRow(int i11) {
        this.f73026g = i11;
    }

    public void setMaxRowCount(int i11) {
        this.f73025f = i11;
    }

    public void setMinSpacingX(int i11) {
        this.f73021b = i11;
    }

    public void setMinSpacingY(int i11) {
        this.f73022c = i11;
    }

    public void setSplitColor(int i11) {
        this.f73035p = i11;
    }

    public void setSplitMode(int i11) {
        this.f73034o = i11;
    }
}
