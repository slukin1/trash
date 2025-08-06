package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.b {

    /* renamed from: b  reason: collision with root package name */
    public int f10757b = -1;

    /* renamed from: c  reason: collision with root package name */
    public c[] f10758c;

    /* renamed from: d  reason: collision with root package name */
    public r f10759d;

    /* renamed from: e  reason: collision with root package name */
    public r f10760e;

    /* renamed from: f  reason: collision with root package name */
    public int f10761f;

    /* renamed from: g  reason: collision with root package name */
    public int f10762g;

    /* renamed from: h  reason: collision with root package name */
    public final m f10763h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10764i = false;

    /* renamed from: j  reason: collision with root package name */
    public boolean f10765j = false;

    /* renamed from: k  reason: collision with root package name */
    public BitSet f10766k;

    /* renamed from: l  reason: collision with root package name */
    public int f10767l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f10768m = Integer.MIN_VALUE;

    /* renamed from: n  reason: collision with root package name */
    public LazySpanLookup f10769n = new LazySpanLookup();

    /* renamed from: o  reason: collision with root package name */
    public int f10770o = 2;

    /* renamed from: p  reason: collision with root package name */
    public boolean f10771p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f10772q;

    /* renamed from: r  reason: collision with root package name */
    public SavedState f10773r;

    /* renamed from: s  reason: collision with root package name */
    public int f10774s;

    /* renamed from: t  reason: collision with root package name */
    public final Rect f10775t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    public final b f10776u = new b();

    /* renamed from: v  reason: collision with root package name */
    public boolean f10777v = false;

    /* renamed from: w  reason: collision with root package name */
    public boolean f10778w = true;

    /* renamed from: x  reason: collision with root package name */
    public int[] f10779x;

    /* renamed from: y  reason: collision with root package name */
    public final Runnable f10780y = new a();

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public c f10781a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10782b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public final int a() {
            c cVar = this.f10781a;
            if (cVar == null) {
                return -1;
            }
            return cVar.f10797e;
        }

        public boolean b() {
            return this.f10782b;
        }

        public void c(boolean z11) {
            this.f10782b = z11;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorPosition;
        public List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

        public class a implements Parcelable.Creator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            int readInt = parcel.readInt();
            this.mSpanOffsetsSize = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.mSpanOffsets = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.mSpanLookupSize = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.mSpanLookup = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z11 = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1 ? true : z11;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.g();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f10786a;

        /* renamed from: b  reason: collision with root package name */
        public int f10787b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10788c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10789d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10790e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f10791f;

        public b() {
            c();
        }

        public void a() {
            int i11;
            if (this.f10788c) {
                i11 = StaggeredGridLayoutManager.this.f10759d.i();
            } else {
                i11 = StaggeredGridLayoutManager.this.f10759d.m();
            }
            this.f10787b = i11;
        }

        public void b(int i11) {
            if (this.f10788c) {
                this.f10787b = StaggeredGridLayoutManager.this.f10759d.i() - i11;
            } else {
                this.f10787b = StaggeredGridLayoutManager.this.f10759d.m() + i11;
            }
        }

        public void c() {
            this.f10786a = -1;
            this.f10787b = Integer.MIN_VALUE;
            this.f10788c = false;
            this.f10789d = false;
            this.f10790e = false;
            int[] iArr = this.f10791f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(c[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f10791f;
            if (iArr == null || iArr.length < length) {
                this.f10791f = new int[StaggeredGridLayoutManager.this.f10758c.length];
            }
            for (int i11 = 0; i11 < length; i11++) {
                this.f10791f[i11] = cVarArr[i11].t(Integer.MIN_VALUE);
            }
        }
    }

    public class c {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f10793a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public int f10794b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        public int f10795c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f10796d = 0;

        /* renamed from: e  reason: collision with root package name */
        public final int f10797e;

        public c(int i11) {
            this.f10797e = i11;
        }

        public void a(View view) {
            LayoutParams r11 = r(view);
            r11.f10781a = this;
            this.f10793a.add(view);
            this.f10795c = Integer.MIN_VALUE;
            if (this.f10793a.size() == 1) {
                this.f10794b = Integer.MIN_VALUE;
            }
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f10796d += StaggeredGridLayoutManager.this.f10759d.e(view);
            }
        }

        public void b(boolean z11, int i11) {
            int i12;
            if (z11) {
                i12 = p(Integer.MIN_VALUE);
            } else {
                i12 = t(Integer.MIN_VALUE);
            }
            e();
            if (i12 != Integer.MIN_VALUE) {
                if (z11 && i12 < StaggeredGridLayoutManager.this.f10759d.i()) {
                    return;
                }
                if (z11 || i12 <= StaggeredGridLayoutManager.this.f10759d.m()) {
                    if (i11 != Integer.MIN_VALUE) {
                        i12 += i11;
                    }
                    this.f10795c = i12;
                    this.f10794b = i12;
                }
            }
        }

        public void c() {
            LazySpanLookup.FullSpanItem f11;
            ArrayList<View> arrayList = this.f10793a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams r11 = r(view);
            this.f10795c = StaggeredGridLayoutManager.this.f10759d.d(view);
            if (r11.f10782b && (f11 = StaggeredGridLayoutManager.this.f10769n.f(r11.getViewLayoutPosition())) != null && f11.mGapDir == 1) {
                this.f10795c += f11.getGapForSpan(this.f10797e);
            }
        }

        public void d() {
            LazySpanLookup.FullSpanItem f11;
            View view = this.f10793a.get(0);
            LayoutParams r11 = r(view);
            this.f10794b = StaggeredGridLayoutManager.this.f10759d.g(view);
            if (r11.f10782b && (f11 = StaggeredGridLayoutManager.this.f10769n.f(r11.getViewLayoutPosition())) != null && f11.mGapDir == -1) {
                this.f10794b -= f11.getGapForSpan(this.f10797e);
            }
        }

        public void e() {
            this.f10793a.clear();
            u();
            this.f10796d = 0;
        }

        public int f() {
            if (StaggeredGridLayoutManager.this.f10764i) {
                return l(this.f10793a.size() - 1, -1, true);
            }
            return l(0, this.f10793a.size(), true);
        }

        public int g() {
            if (StaggeredGridLayoutManager.this.f10764i) {
                return m(this.f10793a.size() - 1, -1, false);
            }
            return m(0, this.f10793a.size(), false);
        }

        public int h() {
            if (StaggeredGridLayoutManager.this.f10764i) {
                return m(0, this.f10793a.size(), true);
            }
            return m(this.f10793a.size() - 1, -1, true);
        }

        public int i() {
            if (StaggeredGridLayoutManager.this.f10764i) {
                return l(0, this.f10793a.size(), true);
            }
            return l(this.f10793a.size() - 1, -1, true);
        }

        public int j() {
            if (StaggeredGridLayoutManager.this.f10764i) {
                return m(0, this.f10793a.size(), false);
            }
            return m(this.f10793a.size() - 1, -1, false);
        }

        public int k(int i11, int i12, boolean z11, boolean z12, boolean z13) {
            int m11 = StaggeredGridLayoutManager.this.f10759d.m();
            int i13 = StaggeredGridLayoutManager.this.f10759d.i();
            int i14 = i12 > i11 ? 1 : -1;
            while (i11 != i12) {
                View view = this.f10793a.get(i11);
                int g11 = StaggeredGridLayoutManager.this.f10759d.g(view);
                int d11 = StaggeredGridLayoutManager.this.f10759d.d(view);
                boolean z14 = false;
                boolean z15 = !z13 ? g11 < i13 : g11 <= i13;
                if (!z13 ? d11 > m11 : d11 >= m11) {
                    z14 = true;
                }
                if (z15 && z14) {
                    if (!z11 || !z12) {
                        if (z12) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (g11 < m11 || d11 > i13) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (g11 >= m11 && d11 <= i13) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i11 += i14;
            }
            return -1;
        }

        public int l(int i11, int i12, boolean z11) {
            return k(i11, i12, false, false, z11);
        }

        public int m(int i11, int i12, boolean z11) {
            return k(i11, i12, z11, true, false);
        }

        public int n() {
            return this.f10796d;
        }

        public int o() {
            int i11 = this.f10795c;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            c();
            return this.f10795c;
        }

        public int p(int i11) {
            int i12 = this.f10795c;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.f10793a.size() == 0) {
                return i11;
            }
            c();
            return this.f10795c;
        }

        public View q(int i11, int i12) {
            View view = null;
            if (i12 != -1) {
                int size = this.f10793a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f10793a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f10764i && staggeredGridLayoutManager.getPosition(view2) >= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f10764i && staggeredGridLayoutManager2.getPosition(view2) <= i11) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f10793a.size();
                int i13 = 0;
                while (i13 < size2) {
                    View view3 = this.f10793a.get(i13);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f10764i && staggeredGridLayoutManager3.getPosition(view3) <= i11) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f10764i && staggeredGridLayoutManager4.getPosition(view3) >= i11) || !view3.hasFocusable()) {
                        break;
                    }
                    i13++;
                    view = view3;
                }
            }
            return view;
        }

        public LayoutParams r(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public int s() {
            int i11 = this.f10794b;
            if (i11 != Integer.MIN_VALUE) {
                return i11;
            }
            d();
            return this.f10794b;
        }

        public int t(int i11) {
            int i12 = this.f10794b;
            if (i12 != Integer.MIN_VALUE) {
                return i12;
            }
            if (this.f10793a.size() == 0) {
                return i11;
            }
            d();
            return this.f10794b;
        }

        public void u() {
            this.f10794b = Integer.MIN_VALUE;
            this.f10795c = Integer.MIN_VALUE;
        }

        public void v(int i11) {
            int i12 = this.f10794b;
            if (i12 != Integer.MIN_VALUE) {
                this.f10794b = i12 + i11;
            }
            int i13 = this.f10795c;
            if (i13 != Integer.MIN_VALUE) {
                this.f10795c = i13 + i11;
            }
        }

        public void w() {
            int size = this.f10793a.size();
            View remove = this.f10793a.remove(size - 1);
            LayoutParams r11 = r(remove);
            r11.f10781a = null;
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f10796d -= StaggeredGridLayoutManager.this.f10759d.e(remove);
            }
            if (size == 1) {
                this.f10794b = Integer.MIN_VALUE;
            }
            this.f10795c = Integer.MIN_VALUE;
        }

        public void x() {
            View remove = this.f10793a.remove(0);
            LayoutParams r11 = r(remove);
            r11.f10781a = null;
            if (this.f10793a.size() == 0) {
                this.f10795c = Integer.MIN_VALUE;
            }
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f10796d -= StaggeredGridLayoutManager.this.f10759d.e(remove);
            }
            this.f10794b = Integer.MIN_VALUE;
        }

        public void y(View view) {
            LayoutParams r11 = r(view);
            r11.f10781a = this;
            this.f10793a.add(0, view);
            this.f10794b = Integer.MIN_VALUE;
            if (this.f10793a.size() == 1) {
                this.f10795c = Integer.MIN_VALUE;
            }
            if (r11.isItemRemoved() || r11.isItemChanged()) {
                this.f10796d += StaggeredGridLayoutManager.this.f10759d.e(view);
            }
        }

        public void z(int i11) {
            this.f10794b = i11;
            this.f10795c = i11;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.orientation);
        S(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.f10763h = new m();
        k();
    }

    public final int A(int i11) {
        int p11 = this.f10758c[0].p(i11);
        for (int i12 = 1; i12 < this.f10757b; i12++) {
            int p12 = this.f10758c[i12].p(i11);
            if (p12 < p11) {
                p11 = p12;
            }
        }
        return p11;
    }

    public final int B(int i11) {
        int t11 = this.f10758c[0].t(i11);
        for (int i12 = 1; i12 < this.f10757b; i12++) {
            int t12 = this.f10758c[i12].t(i11);
            if (t12 < t11) {
                t11 = t12;
            }
        }
        return t11;
    }

    public final c C(m mVar) {
        int i11;
        int i12;
        int i13 = -1;
        if (K(mVar.f10905e)) {
            i12 = this.f10757b - 1;
            i11 = -1;
        } else {
            i12 = 0;
            i13 = this.f10757b;
            i11 = 1;
        }
        c cVar = null;
        if (mVar.f10905e == 1) {
            int i14 = Integer.MAX_VALUE;
            int m11 = this.f10759d.m();
            while (i12 != i13) {
                c cVar2 = this.f10758c[i12];
                int p11 = cVar2.p(m11);
                if (p11 < i14) {
                    cVar = cVar2;
                    i14 = p11;
                }
                i12 += i11;
            }
            return cVar;
        }
        int i15 = Integer.MIN_VALUE;
        int i16 = this.f10759d.i();
        while (i12 != i13) {
            c cVar3 = this.f10758c[i12];
            int t11 = cVar3.t(i16);
            if (t11 > i15) {
                cVar = cVar3;
                i15 = t11;
            }
            i12 += i11;
        }
        return cVar;
    }

    public int D() {
        return this.f10757b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f10765j
            if (r0 == 0) goto L_0x0009
            int r0 = r6.x()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.w()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f10769n
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f10769n
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f10769n
            r7.j(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f10769n
            r9.k(r7, r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f10769n
            r9.j(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f10765j
            if (r7 == 0) goto L_0x004d
            int r7 = r6.w()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.x()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.requestLayout()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.E(int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View F() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f10757b
            r2.<init>(r3)
            int r3 = r12.f10757b
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f10761f
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            boolean r6 = r12.f10765j
            if (r6 == 0) goto L_0x0027
            r6 = r5
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = r1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f10781a
            int r9 = r9.f10797e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f10781a
            boolean r9 = r12.h(r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.f10781a
            int r9 = r9.f10797e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f10782b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f10765j
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.r r10 = r12.f10759d
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.r r11 = r12.f10759d
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.r r10 = r12.f10759d
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.r r11 = r12.f10759d
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = r1
            goto L_0x008b
        L_0x008a:
            r10 = r4
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.f10781a
            int r8 = r8.f10797e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.f10781a
            int r9 = r9.f10797e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = r1
            goto L_0x00a1
        L_0x00a0:
            r8 = r4
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = r1
            goto L_0x00a6
        L_0x00a5:
            r9 = r4
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.F():android.view.View");
    }

    public void G() {
        this.f10769n.b();
        requestLayout();
    }

    public final void H(View view, int i11, int i12, boolean z11) {
        boolean z12;
        calculateItemDecorationsForChild(view, this.f10775t);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i13 = layoutParams.leftMargin;
        Rect rect = this.f10775t;
        int a02 = a0(i11, i13 + rect.left, layoutParams.rightMargin + rect.right);
        int i14 = layoutParams.topMargin;
        Rect rect2 = this.f10775t;
        int a03 = a0(i12, i14 + rect2.top, layoutParams.bottomMargin + rect2.bottom);
        if (z11) {
            z12 = shouldReMeasureChild(view, a02, a03, layoutParams);
        } else {
            z12 = shouldMeasureChild(view, a02, a03, layoutParams);
        }
        if (z12) {
            view.measure(a02, a03);
        }
    }

    public final void I(View view, LayoutParams layoutParams, boolean z11) {
        if (layoutParams.f10782b) {
            if (this.f10761f == 1) {
                H(view, this.f10774s, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z11);
            } else {
                H(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.f10774s, z11);
            }
        } else if (this.f10761f == 1) {
            H(view, RecyclerView.LayoutManager.getChildMeasureSpec(this.f10762g, getWidthMode(), 0, layoutParams.width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true), z11);
        } else {
            H(view, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.f10762g, getHeightMode(), 0, layoutParams.height, false), z11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0157, code lost:
        if (g() != false) goto L_0x015b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void J(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r0 = r8.f10776u
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f10773r
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f10767l
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.b()
            if (r1 != 0) goto L_0x0018
            r8.removeAndRecycleAllViews(r9)
            r0.c()
            return
        L_0x0018:
            boolean r1 = r0.f10790e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f10767l
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.f10773r
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r4
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.c()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f10773r
            if (r5 == 0) goto L_0x0037
            r8.b(r0)
            goto L_0x003e
        L_0x0037:
            r8.resolveShouldLayoutReverse()
            boolean r5 = r8.f10765j
            r0.f10788c = r5
        L_0x003e:
            r8.W(r10, r0)
            r0.f10790e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f10773r
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f10767l
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f10788c
            boolean r6 = r8.f10771p
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.isLayoutRTL()
            boolean r6 = r8.f10772q
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.f10769n
            r5.b()
            r0.f10789d = r4
        L_0x0060:
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.f10773r
            if (r5 == 0) goto L_0x006e
            int r5 = r5.mSpanOffsetsSize
            if (r5 >= r4) goto L_0x00c9
        L_0x006e:
            boolean r5 = r0.f10789d
            if (r5 == 0) goto L_0x008e
            r1 = r3
        L_0x0073:
            int r5 = r8.f10757b
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f10758c
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f10787b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008b
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r6 = r8.f10758c
            r6 = r6[r1]
            r6.z(r5)
        L_0x008b:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x008e:
            if (r1 != 0) goto L_0x00af
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f10776u
            int[] r1 = r1.f10791f
            if (r1 != 0) goto L_0x0097
            goto L_0x00af
        L_0x0097:
            r1 = r3
        L_0x0098:
            int r5 = r8.f10757b
            if (r1 >= r5) goto L_0x00c9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f10758c
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r6 = r8.f10776u
            int[] r6 = r6.f10791f
            r6 = r6[r1]
            r5.z(r6)
            int r1 = r1 + 1
            goto L_0x0098
        L_0x00af:
            r1 = r3
        L_0x00b0:
            int r5 = r8.f10757b
            if (r1 >= r5) goto L_0x00c2
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f10758c
            r5 = r5[r1]
            boolean r6 = r8.f10765j
            int r7 = r0.f10787b
            r5.b(r6, r7)
            int r1 = r1 + 1
            goto L_0x00b0
        L_0x00c2:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r1 = r8.f10776u
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r5 = r8.f10758c
            r1.d(r5)
        L_0x00c9:
            r8.detachAndScrapAttachedViews(r9)
            androidx.recyclerview.widget.m r1 = r8.f10763h
            r1.f10901a = r3
            r8.f10777v = r3
            androidx.recyclerview.widget.r r1 = r8.f10760e
            int r1 = r1.n()
            r8.Y(r1)
            int r1 = r0.f10786a
            r8.X(r1, r10)
            boolean r1 = r0.f10788c
            if (r1 == 0) goto L_0x00fc
            r8.R(r2)
            androidx.recyclerview.widget.m r1 = r8.f10763h
            r8.l(r9, r1, r10)
            r8.R(r4)
            androidx.recyclerview.widget.m r1 = r8.f10763h
            int r2 = r0.f10786a
            int r5 = r1.f10904d
            int r2 = r2 + r5
            r1.f10903c = r2
            r8.l(r9, r1, r10)
            goto L_0x0113
        L_0x00fc:
            r8.R(r4)
            androidx.recyclerview.widget.m r1 = r8.f10763h
            r8.l(r9, r1, r10)
            r8.R(r2)
            androidx.recyclerview.widget.m r1 = r8.f10763h
            int r2 = r0.f10786a
            int r5 = r1.f10904d
            int r2 = r2 + r5
            r1.f10903c = r2
            r8.l(r9, r1, r10)
        L_0x0113:
            r8.Q()
            int r1 = r8.getChildCount()
            if (r1 <= 0) goto L_0x012d
            boolean r1 = r8.f10765j
            if (r1 == 0) goto L_0x0127
            r8.u(r9, r10, r4)
            r8.v(r9, r10, r3)
            goto L_0x012d
        L_0x0127:
            r8.v(r9, r10, r4)
            r8.u(r9, r10, r3)
        L_0x012d:
            if (r11 == 0) goto L_0x015a
            boolean r11 = r10.e()
            if (r11 != 0) goto L_0x015a
            int r11 = r8.f10770o
            if (r11 == 0) goto L_0x014b
            int r11 = r8.getChildCount()
            if (r11 <= 0) goto L_0x014b
            boolean r11 = r8.f10777v
            if (r11 != 0) goto L_0x0149
            android.view.View r11 = r8.F()
            if (r11 == 0) goto L_0x014b
        L_0x0149:
            r11 = r4
            goto L_0x014c
        L_0x014b:
            r11 = r3
        L_0x014c:
            if (r11 == 0) goto L_0x015a
            java.lang.Runnable r11 = r8.f10780y
            r8.removeCallbacks(r11)
            boolean r11 = r8.g()
            if (r11 == 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r4 = r3
        L_0x015b:
            boolean r11 = r10.e()
            if (r11 == 0) goto L_0x0166
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f10776u
            r11.c()
        L_0x0166:
            boolean r11 = r0.f10788c
            r8.f10771p = r11
            boolean r11 = r8.isLayoutRTL()
            r8.f10772q = r11
            if (r4 == 0) goto L_0x017a
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r11 = r8.f10776u
            r11.c()
            r8.J(r9, r10, r3)
        L_0x017a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.J(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public final boolean K(int i11) {
        if (this.f10761f == 0) {
            if ((i11 == -1) != this.f10765j) {
                return true;
            }
            return false;
        }
        if (((i11 == -1) == this.f10765j) == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    public void L(int i11, RecyclerView.State state) {
        int i12;
        int i13;
        if (i11 > 0) {
            i13 = x();
            i12 = 1;
        } else {
            i12 = -1;
            i13 = w();
        }
        this.f10763h.f10901a = true;
        X(i13, state);
        R(i12);
        m mVar = this.f10763h;
        mVar.f10903c = i13 + mVar.f10904d;
        mVar.f10902b = Math.abs(i11);
    }

    public final void M(View view) {
        for (int i11 = this.f10757b - 1; i11 >= 0; i11--) {
            this.f10758c[i11].y(view);
        }
    }

    public final void N(RecyclerView.Recycler recycler, m mVar) {
        int i11;
        int i12;
        if (mVar.f10901a && !mVar.f10909i) {
            if (mVar.f10902b == 0) {
                if (mVar.f10905e == -1) {
                    O(recycler, mVar.f10907g);
                } else {
                    P(recycler, mVar.f10906f);
                }
            } else if (mVar.f10905e == -1) {
                int i13 = mVar.f10906f;
                int z11 = i13 - z(i13);
                if (z11 < 0) {
                    i12 = mVar.f10907g;
                } else {
                    i12 = mVar.f10907g - Math.min(z11, mVar.f10902b);
                }
                O(recycler, i12);
            } else {
                int A = A(mVar.f10907g) - mVar.f10907g;
                if (A < 0) {
                    i11 = mVar.f10906f;
                } else {
                    i11 = Math.min(A, mVar.f10902b) + mVar.f10906f;
                }
                P(recycler, i11);
            }
        }
    }

    public final void O(RecyclerView.Recycler recycler, int i11) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f10759d.g(childAt) >= i11 && this.f10759d.q(childAt) >= i11) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f10782b) {
                    int i12 = 0;
                    while (i12 < this.f10757b) {
                        if (this.f10758c[i12].f10793a.size() != 1) {
                            i12++;
                        } else {
                            return;
                        }
                    }
                    for (int i13 = 0; i13 < this.f10757b; i13++) {
                        this.f10758c[i13].w();
                    }
                } else if (layoutParams.f10781a.f10793a.size() != 1) {
                    layoutParams.f10781a.w();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    public final void P(RecyclerView.Recycler recycler, int i11) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f10759d.d(childAt) <= i11 && this.f10759d.p(childAt) <= i11) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f10782b) {
                    int i12 = 0;
                    while (i12 < this.f10757b) {
                        if (this.f10758c[i12].f10793a.size() != 1) {
                            i12++;
                        } else {
                            return;
                        }
                    }
                    for (int i13 = 0; i13 < this.f10757b; i13++) {
                        this.f10758c[i13].x();
                    }
                } else if (layoutParams.f10781a.f10793a.size() != 1) {
                    layoutParams.f10781a.x();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    public final void Q() {
        if (this.f10760e.k() != 1073741824) {
            float f11 = 0.0f;
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                float e11 = (float) this.f10760e.e(childAt);
                if (e11 >= f11) {
                    if (((LayoutParams) childAt.getLayoutParams()).b()) {
                        e11 = (e11 * 1.0f) / ((float) this.f10757b);
                    }
                    f11 = Math.max(f11, e11);
                }
            }
            int i12 = this.f10762g;
            int round = Math.round(f11 * ((float) this.f10757b));
            if (this.f10760e.k() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f10760e.n());
            }
            Y(round);
            if (this.f10762g != i12) {
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt2 = getChildAt(i13);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.f10782b) {
                        if (!isLayoutRTL() || this.f10761f != 1) {
                            int i14 = layoutParams.f10781a.f10797e;
                            int i15 = this.f10762g * i14;
                            int i16 = i14 * i12;
                            if (this.f10761f == 1) {
                                childAt2.offsetLeftAndRight(i15 - i16);
                            } else {
                                childAt2.offsetTopAndBottom(i15 - i16);
                            }
                        } else {
                            int i17 = this.f10757b;
                            int i18 = layoutParams.f10781a.f10797e;
                            childAt2.offsetLeftAndRight(((-((i17 - 1) - i18)) * this.f10762g) - ((-((i17 - 1) - i18)) * i12));
                        }
                    }
                }
            }
        }
    }

    public final void R(int i11) {
        m mVar = this.f10763h;
        mVar.f10905e = i11;
        int i12 = 1;
        if (this.f10765j != (i11 == -1)) {
            i12 = -1;
        }
        mVar.f10904d = i12;
    }

    public void S(int i11) {
        assertNotInLayoutOrScroll((String) null);
        if (i11 != this.f10757b) {
            G();
            this.f10757b = i11;
            this.f10766k = new BitSet(this.f10757b);
            this.f10758c = new c[this.f10757b];
            for (int i12 = 0; i12 < this.f10757b; i12++) {
                this.f10758c[i12] = new c(i12);
            }
            requestLayout();
        }
    }

    public final void T(int i11, int i12) {
        for (int i13 = 0; i13 < this.f10757b; i13++) {
            if (!this.f10758c[i13].f10793a.isEmpty()) {
                Z(this.f10758c[i13], i11, i12);
            }
        }
    }

    public final boolean U(RecyclerView.State state, b bVar) {
        int i11;
        if (this.f10771p) {
            i11 = s(state.b());
        } else {
            i11 = m(state.b());
        }
        bVar.f10786a = i11;
        bVar.f10787b = Integer.MIN_VALUE;
        return true;
    }

    public boolean V(RecyclerView.State state, b bVar) {
        int i11;
        int i12;
        int i13;
        boolean z11 = false;
        if (!state.e() && (i11 = this.f10767l) != -1) {
            if (i11 < 0 || i11 >= state.b()) {
                this.f10767l = -1;
                this.f10768m = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.f10773r;
                if (savedState == null || savedState.mAnchorPosition == -1 || savedState.mSpanOffsetsSize < 1) {
                    View findViewByPosition = findViewByPosition(this.f10767l);
                    if (findViewByPosition != null) {
                        if (this.f10765j) {
                            i12 = x();
                        } else {
                            i12 = w();
                        }
                        bVar.f10786a = i12;
                        if (this.f10768m != Integer.MIN_VALUE) {
                            if (bVar.f10788c) {
                                bVar.f10787b = (this.f10759d.i() - this.f10768m) - this.f10759d.d(findViewByPosition);
                            } else {
                                bVar.f10787b = (this.f10759d.m() + this.f10768m) - this.f10759d.g(findViewByPosition);
                            }
                            return true;
                        } else if (this.f10759d.e(findViewByPosition) > this.f10759d.n()) {
                            if (bVar.f10788c) {
                                i13 = this.f10759d.i();
                            } else {
                                i13 = this.f10759d.m();
                            }
                            bVar.f10787b = i13;
                            return true;
                        } else {
                            int g11 = this.f10759d.g(findViewByPosition) - this.f10759d.m();
                            if (g11 < 0) {
                                bVar.f10787b = -g11;
                                return true;
                            }
                            int i14 = this.f10759d.i() - this.f10759d.d(findViewByPosition);
                            if (i14 < 0) {
                                bVar.f10787b = i14;
                                return true;
                            }
                            bVar.f10787b = Integer.MIN_VALUE;
                        }
                    } else {
                        int i15 = this.f10767l;
                        bVar.f10786a = i15;
                        int i16 = this.f10768m;
                        if (i16 == Integer.MIN_VALUE) {
                            if (f(i15) == 1) {
                                z11 = true;
                            }
                            bVar.f10788c = z11;
                            bVar.a();
                        } else {
                            bVar.b(i16);
                        }
                        bVar.f10789d = true;
                    }
                } else {
                    bVar.f10787b = Integer.MIN_VALUE;
                    bVar.f10786a = this.f10767l;
                }
                return true;
            }
        }
        return false;
    }

    public void W(RecyclerView.State state, b bVar) {
        if (!V(state, bVar) && !U(state, bVar)) {
            bVar.a();
            bVar.f10786a = 0;
        }
    }

    public final void X(int i11, RecyclerView.State state) {
        int i12;
        int i13;
        int c11;
        m mVar = this.f10763h;
        boolean z11 = false;
        mVar.f10902b = 0;
        mVar.f10903c = i11;
        if (!isSmoothScrolling() || (c11 = state.c()) == -1) {
            i13 = 0;
            i12 = 0;
        } else {
            if (this.f10765j == (c11 < i11)) {
                i13 = this.f10759d.n();
                i12 = 0;
            } else {
                i12 = this.f10759d.n();
                i13 = 0;
            }
        }
        if (getClipToPadding()) {
            this.f10763h.f10906f = this.f10759d.m() - i12;
            this.f10763h.f10907g = this.f10759d.i() + i13;
        } else {
            this.f10763h.f10907g = this.f10759d.h() + i13;
            this.f10763h.f10906f = -i12;
        }
        m mVar2 = this.f10763h;
        mVar2.f10908h = false;
        mVar2.f10901a = true;
        if (this.f10759d.k() == 0 && this.f10759d.h() == 0) {
            z11 = true;
        }
        mVar2.f10909i = z11;
    }

    public void Y(int i11) {
        this.f10762g = i11 / this.f10757b;
        this.f10774s = View.MeasureSpec.makeMeasureSpec(i11, this.f10760e.k());
    }

    public final void Z(c cVar, int i11, int i12) {
        int n11 = cVar.n();
        if (i11 == -1) {
            if (cVar.s() + n11 <= i12) {
                this.f10766k.set(cVar.f10797e, false);
            }
        } else if (cVar.o() - n11 >= i12) {
            this.f10766k.set(cVar.f10797e, false);
        }
    }

    public final void a(View view) {
        for (int i11 = this.f10757b - 1; i11 >= 0; i11--) {
            this.f10758c[i11].a(view);
        }
    }

    public final int a0(int i11, int i12, int i13) {
        if (i12 == 0 && i13 == 0) {
            return i11;
        }
        int mode = View.MeasureSpec.getMode(i11);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i11) - i12) - i13), mode);
        }
        return i11;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.f10773r == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public final void b(b bVar) {
        int i11;
        SavedState savedState = this.f10773r;
        int i12 = savedState.mSpanOffsetsSize;
        if (i12 > 0) {
            if (i12 == this.f10757b) {
                for (int i13 = 0; i13 < this.f10757b; i13++) {
                    this.f10758c[i13].e();
                    SavedState savedState2 = this.f10773r;
                    int i14 = savedState2.mSpanOffsets[i13];
                    if (i14 != Integer.MIN_VALUE) {
                        if (savedState2.mAnchorLayoutFromEnd) {
                            i11 = this.f10759d.i();
                        } else {
                            i11 = this.f10759d.m();
                        }
                        i14 += i11;
                    }
                    this.f10758c[i13].z(i14);
                }
            } else {
                savedState.invalidateSpanInfo();
                SavedState savedState3 = this.f10773r;
                savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
            }
        }
        SavedState savedState4 = this.f10773r;
        this.f10772q = savedState4.mLastLayoutRTL;
        setReverseLayout(savedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState savedState5 = this.f10773r;
        int i15 = savedState5.mAnchorPosition;
        if (i15 != -1) {
            this.f10767l = i15;
            bVar.f10788c = savedState5.mAnchorLayoutFromEnd;
        } else {
            bVar.f10788c = this.f10765j;
        }
        if (savedState5.mSpanLookupSize > 1) {
            LazySpanLookup lazySpanLookup = this.f10769n;
            lazySpanLookup.f10783a = savedState5.mSpanLookup;
            lazySpanLookup.f10784b = savedState5.mFullSpanItems;
        }
    }

    public boolean c() {
        int p11 = this.f10758c[0].p(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.f10757b; i11++) {
            if (this.f10758c[i11].p(Integer.MIN_VALUE) != p11) {
                return false;
            }
        }
        return true;
    }

    public boolean canScrollHorizontally() {
        return this.f10761f == 0;
    }

    public boolean canScrollVertically() {
        return this.f10761f == 1;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.State state, RecyclerView.LayoutManager.c cVar) {
        int i13;
        int i14;
        if (this.f10761f != 0) {
            i11 = i12;
        }
        if (getChildCount() != 0 && i11 != 0) {
            L(i11, state);
            int[] iArr = this.f10779x;
            if (iArr == null || iArr.length < this.f10757b) {
                this.f10779x = new int[this.f10757b];
            }
            int i15 = 0;
            for (int i16 = 0; i16 < this.f10757b; i16++) {
                m mVar = this.f10763h;
                if (mVar.f10904d == -1) {
                    i14 = mVar.f10906f;
                    i13 = this.f10758c[i16].t(i14);
                } else {
                    i14 = this.f10758c[i16].p(mVar.f10907g);
                    i13 = this.f10763h.f10907g;
                }
                int i17 = i14 - i13;
                if (i17 >= 0) {
                    this.f10779x[i15] = i17;
                    i15++;
                }
            }
            Arrays.sort(this.f10779x, 0, i15);
            for (int i18 = 0; i18 < i15 && this.f10763h.a(state); i18++) {
                cVar.a(this.f10763h.f10903c, this.f10779x[i18]);
                m mVar2 = this.f10763h;
                mVar2.f10903c += mVar2.f10904d;
            }
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return t.a(state, this.f10759d, o(!this.f10778w), n(!this.f10778w), this, this.f10778w);
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return t.b(state, this.f10759d, o(!this.f10778w), n(!this.f10778w), this, this.f10778w, this.f10765j);
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return t.c(state, this.f10759d, o(!this.f10778w), n(!this.f10778w), this, this.f10778w);
    }

    public PointF computeScrollVectorForPosition(int i11) {
        int f11 = f(i11);
        PointF pointF = new PointF();
        if (f11 == 0) {
            return null;
        }
        if (this.f10761f == 0) {
            pointF.x = (float) f11;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) f11;
        }
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int convertFocusDirectionToLayoutDirection(int i11) {
        if (i11 == 1) {
            return (this.f10761f != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i11 == 2) {
            return (this.f10761f != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        return Integer.MIN_VALUE;
                    }
                    return this.f10761f == 1 ? 1 : Integer.MIN_VALUE;
                } else if (this.f10761f == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.f10761f == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.f10761f == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public boolean d() {
        int t11 = this.f10758c[0].t(Integer.MIN_VALUE);
        for (int i11 = 1; i11 < this.f10757b; i11++) {
            if (this.f10758c[i11].t(Integer.MIN_VALUE) != t11) {
                return false;
            }
        }
        return true;
    }

    public final void e(View view, LayoutParams layoutParams, m mVar) {
        if (mVar.f10905e == 1) {
            if (layoutParams.f10782b) {
                a(view);
            } else {
                layoutParams.f10781a.a(view);
            }
        } else if (layoutParams.f10782b) {
            M(view);
        } else {
            layoutParams.f10781a.y(view);
        }
    }

    public final int f(int i11) {
        if (getChildCount() != 0) {
            if ((i11 < w()) != this.f10765j) {
                return -1;
            }
            return 1;
        } else if (this.f10765j) {
            return 1;
        } else {
            return -1;
        }
    }

    public boolean g() {
        int i11;
        int i12;
        if (getChildCount() == 0 || this.f10770o == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f10765j) {
            i12 = x();
            i11 = w();
        } else {
            i12 = w();
            i11 = x();
        }
        if (i12 == 0 && F() != null) {
            this.f10769n.b();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.f10777v) {
            return false;
        } else {
            int i13 = this.f10765j ? -1 : 1;
            int i14 = i11 + 1;
            LazySpanLookup.FullSpanItem e11 = this.f10769n.e(i12, i14, i13, true);
            if (e11 == null) {
                this.f10777v = false;
                this.f10769n.d(i14);
                return false;
            }
            LazySpanLookup.FullSpanItem e12 = this.f10769n.e(i12, e11.mPosition, i13 * -1, true);
            if (e12 == null) {
                this.f10769n.d(e11.mPosition);
            } else {
                this.f10769n.d(e12.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f10761f == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getOrientation() {
        return this.f10761f;
    }

    public final boolean h(c cVar) {
        if (this.f10765j) {
            if (cVar.o() < this.f10759d.i()) {
                ArrayList<View> arrayList = cVar.f10793a;
                return !cVar.r(arrayList.get(arrayList.size() - 1)).f10782b;
            }
        } else if (cVar.s() > this.f10759d.m()) {
            return !cVar.r(cVar.f10793a.get(0)).f10782b;
        }
        return false;
    }

    public final LazySpanLookup.FullSpanItem i(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.f10757b];
        for (int i12 = 0; i12 < this.f10757b; i12++) {
            fullSpanItem.mGapPerSpan[i12] = i11 - this.f10758c[i12].p(i11);
        }
        return fullSpanItem;
    }

    public boolean isAutoMeasureEnabled() {
        return this.f10770o != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public final LazySpanLookup.FullSpanItem j(int i11) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.f10757b];
        for (int i12 = 0; i12 < this.f10757b; i12++) {
            fullSpanItem.mGapPerSpan[i12] = this.f10758c[i12].t(i11) - i11;
        }
        return fullSpanItem;
    }

    public final void k() {
        this.f10759d = r.b(this, this.f10761f);
        this.f10760e = r.b(this, 1 - this.f10761f);
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r9v5 */
    public final int l(RecyclerView.Recycler recycler, m mVar, RecyclerView.State state) {
        int i11;
        int i12;
        int i13;
        c cVar;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z11;
        int i18;
        int i19;
        boolean z12;
        int i21;
        int i22;
        RecyclerView.Recycler recycler2 = recycler;
        m mVar2 = mVar;
        ? r92 = 0;
        this.f10766k.set(0, this.f10757b, true);
        if (this.f10763h.f10909i) {
            i11 = mVar2.f10905e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (mVar2.f10905e == 1) {
            i11 = mVar2.f10907g + mVar2.f10902b;
        } else {
            i11 = mVar2.f10906f - mVar2.f10902b;
        }
        int i23 = i11;
        T(mVar2.f10905e, i23);
        if (this.f10765j) {
            i12 = this.f10759d.i();
        } else {
            i12 = this.f10759d.m();
        }
        int i24 = i12;
        boolean z13 = false;
        while (mVar.a(state) && (this.f10763h.f10909i || !this.f10766k.isEmpty())) {
            View b11 = mVar2.b(recycler2);
            LayoutParams layoutParams = (LayoutParams) b11.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int g11 = this.f10769n.g(viewLayoutPosition);
            boolean z14 = g11 == -1 ? true : r92;
            if (z14) {
                cVar = layoutParams.f10782b ? this.f10758c[r92] : C(mVar2);
                this.f10769n.n(viewLayoutPosition, cVar);
            } else {
                cVar = this.f10758c[g11];
            }
            c cVar2 = cVar;
            layoutParams.f10781a = cVar2;
            if (mVar2.f10905e == 1) {
                addView(b11);
            } else {
                addView(b11, r92);
            }
            I(b11, layoutParams, r92);
            if (mVar2.f10905e == 1) {
                if (layoutParams.f10782b) {
                    i22 = y(i24);
                } else {
                    i22 = cVar2.p(i24);
                }
                int e11 = this.f10759d.e(b11) + i22;
                if (z14 && layoutParams.f10782b) {
                    LazySpanLookup.FullSpanItem i25 = i(i22);
                    i25.mGapDir = -1;
                    i25.mPosition = viewLayoutPosition;
                    this.f10769n.a(i25);
                }
                i14 = e11;
                i15 = i22;
            } else {
                if (layoutParams.f10782b) {
                    i21 = B(i24);
                } else {
                    i21 = cVar2.t(i24);
                }
                i15 = i21 - this.f10759d.e(b11);
                if (z14 && layoutParams.f10782b) {
                    LazySpanLookup.FullSpanItem j11 = j(i21);
                    j11.mGapDir = 1;
                    j11.mPosition = viewLayoutPosition;
                    this.f10769n.a(j11);
                }
                i14 = i21;
            }
            if (layoutParams.f10782b && mVar2.f10904d == -1) {
                if (z14) {
                    this.f10777v = true;
                } else {
                    if (mVar2.f10905e == 1) {
                        z12 = c();
                    } else {
                        z12 = d();
                    }
                    if (!z12) {
                        LazySpanLookup.FullSpanItem f11 = this.f10769n.f(viewLayoutPosition);
                        if (f11 != null) {
                            f11.mHasUnwantedGapAfter = true;
                        }
                        this.f10777v = true;
                    }
                }
            }
            e(b11, layoutParams, mVar2);
            if (!isLayoutRTL() || this.f10761f != 1) {
                if (layoutParams.f10782b) {
                    i18 = this.f10760e.m();
                } else {
                    i18 = (cVar2.f10797e * this.f10762g) + this.f10760e.m();
                }
                i17 = i18;
                i16 = this.f10760e.e(b11) + i18;
            } else {
                if (layoutParams.f10782b) {
                    i19 = this.f10760e.i();
                } else {
                    i19 = this.f10760e.i() - (((this.f10757b - 1) - cVar2.f10797e) * this.f10762g);
                }
                i16 = i19;
                i17 = i19 - this.f10760e.e(b11);
            }
            if (this.f10761f == 1) {
                layoutDecoratedWithMargins(b11, i17, i15, i16, i14);
            } else {
                layoutDecoratedWithMargins(b11, i15, i17, i14, i16);
            }
            if (layoutParams.f10782b) {
                T(this.f10763h.f10905e, i23);
            } else {
                Z(cVar2, this.f10763h.f10905e, i23);
            }
            N(recycler2, this.f10763h);
            if (this.f10763h.f10908h && b11.hasFocusable()) {
                if (layoutParams.f10782b) {
                    this.f10766k.clear();
                } else {
                    z11 = false;
                    this.f10766k.set(cVar2.f10797e, false);
                    r92 = z11;
                    z13 = true;
                }
            }
            z11 = false;
            r92 = z11;
            z13 = true;
        }
        int i26 = r92;
        if (!z13) {
            N(recycler2, this.f10763h);
        }
        if (this.f10763h.f10905e == -1) {
            i13 = this.f10759d.m() - B(this.f10759d.m());
        } else {
            i13 = y(this.f10759d.i()) - this.f10759d.i();
        }
        return i13 > 0 ? Math.min(mVar2.f10902b, i13) : i26;
    }

    public final int m(int i11) {
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            int position = getPosition(getChildAt(i12));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    public View n(boolean z11) {
        int m11 = this.f10759d.m();
        int i11 = this.f10759d.i();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int g11 = this.f10759d.g(childAt);
            int d11 = this.f10759d.d(childAt);
            if (d11 > m11 && g11 < i11) {
                if (d11 <= i11 || !z11) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View o(boolean z11) {
        int m11 = this.f10759d.m();
        int i11 = this.f10759d.i();
        int childCount = getChildCount();
        View view = null;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int g11 = this.f10759d.g(childAt);
            if (this.f10759d.d(childAt) > m11 && g11 < i11) {
                if (g11 >= m11 || !z11) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public void offsetChildrenHorizontal(int i11) {
        super.offsetChildrenHorizontal(i11);
        for (int i12 = 0; i12 < this.f10757b; i12++) {
            this.f10758c[i12].v(i11);
        }
    }

    public void offsetChildrenVertical(int i11) {
        super.offsetChildrenVertical(i11);
        for (int i12 = 0; i12 < this.f10757b; i12++) {
            this.f10758c[i12].v(i11);
        }
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f10769n.b();
        for (int i11 = 0; i11 < this.f10757b; i11++) {
            this.f10758c[i11].e();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.f10780y);
        for (int i11 = 0; i11 < this.f10757b; i11++) {
            this.f10758c[i11].e();
        }
        recyclerView.requestLayout();
    }

    public View onFocusSearchFailed(View view, int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i12;
        int i13;
        int i14;
        int i15;
        View q11;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11);
        if (convertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z11 = layoutParams.f10782b;
        c cVar = layoutParams.f10781a;
        if (convertFocusDirectionToLayoutDirection == 1) {
            i12 = x();
        } else {
            i12 = w();
        }
        X(i12, state);
        R(convertFocusDirectionToLayoutDirection);
        m mVar = this.f10763h;
        mVar.f10903c = mVar.f10904d + i12;
        mVar.f10902b = (int) (((float) this.f10759d.n()) * 0.33333334f);
        m mVar2 = this.f10763h;
        mVar2.f10908h = true;
        mVar2.f10901a = false;
        l(recycler, mVar2, state);
        this.f10771p = this.f10765j;
        if (!z11 && (q11 = cVar.q(i12, convertFocusDirectionToLayoutDirection)) != null && q11 != findContainingItemView) {
            return q11;
        }
        if (K(convertFocusDirectionToLayoutDirection)) {
            for (int i16 = this.f10757b - 1; i16 >= 0; i16--) {
                View q12 = this.f10758c[i16].q(i12, convertFocusDirectionToLayoutDirection);
                if (q12 != null && q12 != findContainingItemView) {
                    return q12;
                }
            }
        } else {
            for (int i17 = 0; i17 < this.f10757b; i17++) {
                View q13 = this.f10758c[i17].q(i12, convertFocusDirectionToLayoutDirection);
                if (q13 != null && q13 != findContainingItemView) {
                    return q13;
                }
            }
        }
        boolean z12 = (this.f10764i ^ true) == (convertFocusDirectionToLayoutDirection == -1);
        if (!z11) {
            if (z12) {
                i15 = cVar.f();
            } else {
                i15 = cVar.i();
            }
            View findViewByPosition = findViewByPosition(i15);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (K(convertFocusDirectionToLayoutDirection)) {
            for (int i18 = this.f10757b - 1; i18 >= 0; i18--) {
                if (i18 != cVar.f10797e) {
                    if (z12) {
                        i14 = this.f10758c[i18].f();
                    } else {
                        i14 = this.f10758c[i18].i();
                    }
                    View findViewByPosition2 = findViewByPosition(i14);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i19 = 0; i19 < this.f10757b; i19++) {
                if (z12) {
                    i13 = this.f10758c[i19].f();
                } else {
                    i13 = this.f10758c[i19].i();
                }
                View findViewByPosition3 = findViewByPosition(i13);
                if (findViewByPosition3 != null && findViewByPosition3 != findContainingItemView) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View o11 = o(false);
            View n11 = n(false);
            if (o11 != null && n11 != null) {
                int position = getPosition(o11);
                int position2 = getPosition(n11);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        E(i11, i12, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f10769n.b();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        E(i11, i12, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        E(i11, i12, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        E(i11, i12, 4);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        J(recycler, state, true);
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f10767l = -1;
        this.f10768m = Integer.MIN_VALUE;
        this.f10773r = null;
        this.f10776u.c();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f10773r = savedState;
            if (this.f10767l != -1) {
                savedState.invalidateAnchorPositionInfo();
                this.f10773r.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        int i11;
        int i12;
        int i13;
        int[] iArr;
        if (this.f10773r != null) {
            return new SavedState(this.f10773r);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.f10764i;
        savedState.mAnchorLayoutFromEnd = this.f10771p;
        savedState.mLastLayoutRTL = this.f10772q;
        LazySpanLookup lazySpanLookup = this.f10769n;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f10783a) == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = iArr;
            savedState.mSpanLookupSize = iArr.length;
            savedState.mFullSpanItems = lazySpanLookup.f10784b;
        }
        if (getChildCount() > 0) {
            if (this.f10771p) {
                i11 = x();
            } else {
                i11 = w();
            }
            savedState.mAnchorPosition = i11;
            savedState.mVisibleAnchorPosition = p();
            int i14 = this.f10757b;
            savedState.mSpanOffsetsSize = i14;
            savedState.mSpanOffsets = new int[i14];
            for (int i15 = 0; i15 < this.f10757b; i15++) {
                if (this.f10771p) {
                    i12 = this.f10758c[i15].p(Integer.MIN_VALUE);
                    if (i12 != Integer.MIN_VALUE) {
                        i13 = this.f10759d.i();
                    } else {
                        savedState.mSpanOffsets[i15] = i12;
                    }
                } else {
                    i12 = this.f10758c[i15].t(Integer.MIN_VALUE);
                    if (i12 != Integer.MIN_VALUE) {
                        i13 = this.f10759d.m();
                    } else {
                        savedState.mSpanOffsets[i15] = i12;
                    }
                }
                i12 -= i13;
                savedState.mSpanOffsets[i15] = i12;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i11) {
        if (i11 == 0) {
            g();
        }
    }

    public int p() {
        View view;
        if (this.f10765j) {
            view = n(true);
        } else {
            view = o(true);
        }
        if (view == null) {
            return -1;
        }
        return getPosition(view);
    }

    public int[] q(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f10757b];
        } else if (iArr.length < this.f10757b) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f10757b + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.f10757b; i11++) {
            iArr[i11] = this.f10758c[i11].g();
        }
        return iArr;
    }

    public int[] r(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f10757b];
        } else if (iArr.length < this.f10757b) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f10757b + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.f10757b; i11++) {
            iArr[i11] = this.f10758c[i11].h();
        }
        return iArr;
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f10761f == 1 || !isLayoutRTL()) {
            this.f10765j = this.f10764i;
        } else {
            this.f10765j = !this.f10764i;
        }
    }

    public final int s(int i11) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i11) {
                return position;
            }
        }
        return 0;
    }

    public int scrollBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        L(i11, state);
        int l11 = l(recycler, this.f10763h, state);
        if (this.f10763h.f10902b >= l11) {
            i11 = i11 < 0 ? -l11 : l11;
        }
        this.f10759d.r(-i11);
        this.f10771p = this.f10765j;
        m mVar = this.f10763h;
        mVar.f10902b = 0;
        N(recycler, mVar);
        return i11;
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i11, recycler, state);
    }

    public void scrollToPosition(int i11) {
        SavedState savedState = this.f10773r;
        if (!(savedState == null || savedState.mAnchorPosition == i11)) {
            savedState.invalidateAnchorPositionInfo();
        }
        this.f10767l = i11;
        this.f10768m = Integer.MIN_VALUE;
        requestLayout();
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i11, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int i13;
        int i14;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f10761f == 1) {
            i14 = RecyclerView.LayoutManager.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            i13 = RecyclerView.LayoutManager.chooseSize(i11, (this.f10762g * this.f10757b) + paddingLeft, getMinimumWidth());
        } else {
            i13 = RecyclerView.LayoutManager.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            i14 = RecyclerView.LayoutManager.chooseSize(i12, (this.f10762g * this.f10757b) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i13, i14);
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i11 != this.f10761f) {
                this.f10761f = i11;
                r rVar = this.f10759d;
                this.f10759d = this.f10760e;
                this.f10760e = rVar;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z11) {
        assertNotInLayoutOrScroll((String) null);
        SavedState savedState = this.f10773r;
        if (!(savedState == null || savedState.mReverseLayout == z11)) {
            savedState.mReverseLayout = z11;
        }
        this.f10764i = z11;
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        n nVar = new n(recyclerView.getContext());
        nVar.setTargetPosition(i11);
        startSmoothScroll(nVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.f10773r == null;
    }

    public int[] t(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f10757b];
        } else if (iArr.length < this.f10757b) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f10757b + ", array size:" + iArr.length);
        }
        for (int i11 = 0; i11 < this.f10757b; i11++) {
            iArr[i11] = this.f10758c[i11].j();
        }
        return iArr;
    }

    public final void u(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int i11;
        int y11 = y(Integer.MIN_VALUE);
        if (y11 != Integer.MIN_VALUE && (i11 = this.f10759d.i() - y11) > 0) {
            int i12 = i11 - (-scrollBy(-i11, recycler, state));
            if (z11 && i12 > 0) {
                this.f10759d.r(i12);
            }
        }
    }

    public final void v(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int m11;
        int B = B(Integer.MAX_VALUE);
        if (B != Integer.MAX_VALUE && (m11 = B - this.f10759d.m()) > 0) {
            int scrollBy = m11 - scrollBy(m11, recycler, state);
            if (z11 && scrollBy > 0) {
                this.f10759d.r(-scrollBy);
            }
        }
    }

    public int w() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int x() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int y(int i11) {
        int p11 = this.f10758c[0].p(i11);
        for (int i12 = 1; i12 < this.f10757b; i12++) {
            int p12 = this.f10758c[i12].p(i11);
            if (p12 > p11) {
                p11 = p12;
            }
        }
        return p11;
    }

    public final int z(int i11) {
        int t11 = this.f10758c[0].t(i11);
        for (int i12 = 1; i12 < this.f10757b; i12++) {
            int t12 = this.f10758c[i12].t(i11);
            if (t12 > t11) {
                t11 = t12;
            }
        }
        return t11;
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        public int[] f10783a;

        /* renamed from: b  reason: collision with root package name */
        public List<FullSpanItem> f10784b;

        public void a(FullSpanItem fullSpanItem) {
            if (this.f10784b == null) {
                this.f10784b = new ArrayList();
            }
            int size = this.f10784b.size();
            for (int i11 = 0; i11 < size; i11++) {
                FullSpanItem fullSpanItem2 = this.f10784b.get(i11);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.f10784b.remove(i11);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.f10784b.add(i11, fullSpanItem);
                    return;
                }
            }
            this.f10784b.add(fullSpanItem);
        }

        public void b() {
            int[] iArr = this.f10783a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f10784b = null;
        }

        public void c(int i11) {
            int[] iArr = this.f10783a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i11, 10) + 1)];
                this.f10783a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i11 >= iArr.length) {
                int[] iArr3 = new int[o(i11)];
                this.f10783a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f10783a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i11) {
            List<FullSpanItem> list = this.f10784b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f10784b.get(size).mPosition >= i11) {
                        this.f10784b.remove(size);
                    }
                }
            }
            return h(i11);
        }

        public FullSpanItem e(int i11, int i12, int i13, boolean z11) {
            List<FullSpanItem> list = this.f10784b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i14 = 0; i14 < size; i14++) {
                FullSpanItem fullSpanItem = this.f10784b.get(i14);
                int i15 = fullSpanItem.mPosition;
                if (i15 >= i12) {
                    return null;
                }
                if (i15 >= i11 && (i13 == 0 || fullSpanItem.mGapDir == i13 || (z11 && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem f(int i11) {
            List<FullSpanItem> list = this.f10784b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f10784b.get(size);
                if (fullSpanItem.mPosition == i11) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public int g(int i11) {
            int[] iArr = this.f10783a;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            return iArr[i11];
        }

        public int h(int i11) {
            int[] iArr = this.f10783a;
            if (iArr == null || i11 >= iArr.length) {
                return -1;
            }
            int i12 = i(i11);
            if (i12 == -1) {
                int[] iArr2 = this.f10783a;
                Arrays.fill(iArr2, i11, iArr2.length, -1);
                return this.f10783a.length;
            }
            int min = Math.min(i12 + 1, this.f10783a.length);
            Arrays.fill(this.f10783a, i11, min, -1);
            return min;
        }

        public final int i(int i11) {
            if (this.f10784b == null) {
                return -1;
            }
            FullSpanItem f11 = f(i11);
            if (f11 != null) {
                this.f10784b.remove(f11);
            }
            int size = this.f10784b.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    i12 = -1;
                    break;
                } else if (this.f10784b.get(i12).mPosition >= i11) {
                    break;
                } else {
                    i12++;
                }
            }
            if (i12 == -1) {
                return -1;
            }
            this.f10784b.remove(i12);
            return this.f10784b.get(i12).mPosition;
        }

        public void j(int i11, int i12) {
            int[] iArr = this.f10783a;
            if (iArr != null && i11 < iArr.length) {
                int i13 = i11 + i12;
                c(i13);
                int[] iArr2 = this.f10783a;
                System.arraycopy(iArr2, i11, iArr2, i13, (iArr2.length - i11) - i12);
                Arrays.fill(this.f10783a, i11, i13, -1);
                l(i11, i12);
            }
        }

        public void k(int i11, int i12) {
            int[] iArr = this.f10783a;
            if (iArr != null && i11 < iArr.length) {
                int i13 = i11 + i12;
                c(i13);
                int[] iArr2 = this.f10783a;
                System.arraycopy(iArr2, i13, iArr2, i11, (iArr2.length - i11) - i12);
                int[] iArr3 = this.f10783a;
                Arrays.fill(iArr3, iArr3.length - i12, iArr3.length, -1);
                m(i11, i12);
            }
        }

        public final void l(int i11, int i12) {
            List<FullSpanItem> list = this.f10784b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f10784b.get(size);
                    int i13 = fullSpanItem.mPosition;
                    if (i13 >= i11) {
                        fullSpanItem.mPosition = i13 + i12;
                    }
                }
            }
        }

        public final void m(int i11, int i12) {
            List<FullSpanItem> list = this.f10784b;
            if (list != null) {
                int i13 = i11 + i12;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f10784b.get(size);
                    int i14 = fullSpanItem.mPosition;
                    if (i14 >= i11) {
                        if (i14 < i13) {
                            this.f10784b.remove(size);
                        } else {
                            fullSpanItem.mPosition = i14 - i12;
                        }
                    }
                }
            }
        }

        public void n(int i11, c cVar) {
            c(i11);
            this.f10783a[i11] = cVar.f10797e;
        }

        public int o(int i11) {
            int length = this.f10783a.length;
            while (length <= i11) {
                length *= 2;
            }
            return length;
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();
            public int mGapDir;
            public int[] mGapPerSpan;
            public boolean mHasUnwantedGapAfter;
            public int mPosition;

            public class a implements Parcelable.Creator<FullSpanItem> {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: b */
                public FullSpanItem[] newArray(int i11) {
                    return new FullSpanItem[i11];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.mGapPerSpan = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public int getGapForSpan(int i11) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i11];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public FullSpanItem() {
            }
        }
    }

    public StaggeredGridLayoutManager(int i11, int i12) {
        this.f10761f = i12;
        S(i11);
        this.f10763h = new m();
        k();
    }
}
