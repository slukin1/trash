package com.huobi.homemarket.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.market.R$drawable;
import com.huobi.homemarket.helper.DividerHelper;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a extends RecyclerView.ItemDecoration {
    public RecyclerView A;
    public HashMap<Integer, String> B;
    public ExecutorService C;
    public Runnable D;
    public Runnable E;

    /* renamed from: a  reason: collision with root package name */
    public nl.a f72974a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f72975b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72976c;

    /* renamed from: d  reason: collision with root package name */
    public int f72977d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f72978e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f72979f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView.Adapter f72980g;

    /* renamed from: h  reason: collision with root package name */
    public View f72981h;

    /* renamed from: i  reason: collision with root package name */
    public int f72982i;

    /* renamed from: j  reason: collision with root package name */
    public int f72983j;

    /* renamed from: k  reason: collision with root package name */
    public Rect f72984k;

    /* renamed from: l  reason: collision with root package name */
    public int f72985l;

    /* renamed from: m  reason: collision with root package name */
    public int f72986m;

    /* renamed from: n  reason: collision with root package name */
    public int f72987n;

    /* renamed from: o  reason: collision with root package name */
    public int f72988o;

    /* renamed from: p  reason: collision with root package name */
    public int f72989p;

    /* renamed from: q  reason: collision with root package name */
    public int f72990q;

    /* renamed from: r  reason: collision with root package name */
    public nl.b f72991r;

    /* renamed from: s  reason: collision with root package name */
    public int f72992s;

    /* renamed from: t  reason: collision with root package name */
    public int f72993t;

    /* renamed from: u  reason: collision with root package name */
    public int f72994u;

    /* renamed from: v  reason: collision with root package name */
    public int f72995v;

    /* renamed from: w  reason: collision with root package name */
    public int f72996w;

    /* renamed from: x  reason: collision with root package name */
    public int f72997x;

    /* renamed from: y  reason: collision with root package name */
    public int f72998y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f72999z;

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            if (a.this.A != null) {
                try {
                    a aVar = a.this;
                    int a11 = a.this.m(aVar.k(aVar.A.getLayoutManager()));
                    a aVar2 = a.this;
                    a.this.n(a11, aVar2.l(aVar2.A.getLayoutManager()));
                } catch (Exception e11) {
                    i6.d.d(e11.getMessage());
                }
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            if (a.this.A != null) {
                try {
                    a aVar = a.this;
                    a.this.h(aVar.l(aVar.A.getLayoutManager()));
                } catch (Exception e11) {
                    i6.d.d(e11.getMessage());
                }
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            if (a.this.A != null) {
                try {
                    a aVar = a.this;
                    int a11 = a.this.m(aVar.k(aVar.A.getLayoutManager()));
                    a aVar2 = a.this;
                    a.this.n(a11, aVar2.l(aVar2.A.getLayoutManager()));
                } catch (Exception e11) {
                    i6.d.d(e11.getMessage());
                }
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            if (a.this.A != null) {
                try {
                    a aVar = a.this;
                    a.this.h(aVar.l(aVar.A.getLayoutManager()));
                } catch (Exception e11) {
                    i6.d.d(e11.getMessage());
                }
            }
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public nl.a f73005a;

        /* renamed from: b  reason: collision with root package name */
        public int f73006b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f73007c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f73008d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f73009e;

        /* renamed from: f  reason: collision with root package name */
        public int f73010f;

        public f(int i11) {
            this.f73010f = i11;
        }

        public a g() {
            return new a(this, (C0796a) null);
        }

        public f h(boolean z11) {
            this.f73007c = z11;
            return this;
        }

        public f i(int i11) {
            this.f73006b = i11;
            return this;
        }
    }

    public /* synthetic */ a(f fVar, C0796a aVar) {
        this(fVar);
    }

    public static ExecutorService r(int i11, int i12) {
        return new ThreadPoolExecutor(i11, i12, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public final void g(RecyclerView recyclerView) {
        if (this.A != recyclerView) {
            this.A = recyclerView;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (this.f72980g != adapter) {
            this.f72981h = null;
            this.f72982i = -1;
            this.B = new HashMap<>();
            this.f72980g = adapter;
            adapter.registerAdapterDataObserver(new C0796a());
        }
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        g(recyclerView);
        if (this.f72975b) {
            if (this.f72979f == null) {
                Context context = recyclerView.getContext();
                int i11 = this.f72977d;
                if (i11 == 0) {
                    i11 = R$drawable.divider;
                }
                this.f72979f = ContextCompat.getDrawable(context, i11);
            }
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                if (!p(recyclerView, view)) {
                    if (o(recyclerView, recyclerView.getChildAdapterPosition(view), getSpanCount(recyclerView))) {
                        rect.set(this.f72979f.getIntrinsicWidth(), 0, this.f72979f.getIntrinsicWidth(), this.f72979f.getIntrinsicHeight());
                    } else {
                        rect.set(0, 0, this.f72979f.getIntrinsicWidth(), this.f72979f.getIntrinsicHeight());
                    }
                } else {
                    rect.set(0, 0, 0, this.f72979f.getIntrinsicHeight());
                }
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                rect.set(0, 0, 0, this.f72979f.getIntrinsicHeight());
            } else if (!(recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager)) {
            } else {
                if (p(recyclerView, view)) {
                    rect.set(0, 0, 0, this.f72979f.getIntrinsicHeight());
                } else if (((StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams()).a() == 0) {
                    rect.set(this.f72979f.getIntrinsicWidth(), 0, this.f72979f.getIntrinsicWidth(), this.f72979f.getIntrinsicHeight());
                } else {
                    rect.set(0, 0, this.f72979f.getIntrinsicWidth(), this.f72979f.getIntrinsicHeight());
                }
            }
        }
    }

    public final int getSpanCount(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).k();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).D();
        }
        return -1;
    }

    public final void h(int i11) throws Exception {
        RecyclerView.Adapter adapter = this.f72980g;
        if (adapter != null && this.A != null && adapter.getItemCount() >= 1 && i11 >= 0 && q(this.f72980g.getItemViewType(i11)) && this.A != null) {
            s9.a aVar = (s9.a) ((v9.a) this.f72980g).c().get(i11);
            if (this.B.containsKey(Integer.valueOf(i11))) {
                return;
            }
            if (aVar instanceof aj.a) {
                String g11 = ((aj.a) aVar).g();
                this.B.put(Integer.valueOf(i11), g11);
                HashMap hashMap = new HashMap();
                hashMap.put("markets_list_icon_name", g11);
                BaseModuleConfig.a().w("App_markets_list_spot_poineer_view", hashMap);
            } else if (aVar instanceof ml.c) {
                String a11 = ((ml.c) aVar).a();
                this.B.put(Integer.valueOf(i11), a11);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("markets_list_icon_name", a11);
                BaseModuleConfig.a().w("App_markets_list_spot_poineer_view", hashMap2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(androidx.recyclerview.widget.RecyclerView r9) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r8.f72980g
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r9.getLayoutManager()
            r1 = -1
            int r0 = r8.k(r0)     // Catch:{ Exception -> 0x0015 }
            r8.f72996w = r0     // Catch:{ Exception -> 0x0015 }
            int r0 = r8.m(r0)     // Catch:{ Exception -> 0x0015 }
            goto L_0x001e
        L_0x0015:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            i6.d.d(r0)
            r0 = r1
        L_0x001e:
            if (r0 < 0) goto L_0x0183
            int r2 = r8.f72982i
            if (r2 == r0) goto L_0x0183
            r8.f72982i = r0
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r8.f72980g
            int r0 = r2.getItemViewType(r0)
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r8.f72980g
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r2.createViewHolder(r9, r0)
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r8.f72980g
            int r3 = r8.f72982i
            r2.bindViewHolder(r0, r3)
            android.view.View r0 = r0.itemView
            r8.f72981h = r0
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r2 = -2
            if (r0 != 0) goto L_0x004e
            android.view.ViewGroup$LayoutParams r0 = new android.view.ViewGroup$LayoutParams
            r0.<init>(r1, r2)
            android.view.View r3 = r8.f72981h
            r3.setLayoutParams(r0)
        L_0x004e:
            int r3 = r0.height
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 < 0) goto L_0x0058
        L_0x0056:
            r4 = r5
            goto L_0x006a
        L_0x0058:
            if (r3 != r1) goto L_0x005f
            int r3 = r9.getHeight()
            goto L_0x0056
        L_0x005f:
            if (r3 != r2) goto L_0x0066
            int r3 = r9.getHeight()
            goto L_0x006a
        L_0x0066:
            int r3 = r9.getHeight()
        L_0x006a:
            int r2 = r9.getPaddingLeft()
            r8.f72985l = r2
            int r2 = r9.getPaddingRight()
            int r6 = r9.getPaddingTop()
            r8.f72986m = r6
            int r6 = r9.getPaddingBottom()
            boolean r7 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r7 == 0) goto L_0x0094
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r7 = r0.leftMargin
            r8.f72987n = r7
            int r7 = r0.topMargin
            r8.f72988o = r7
            int r7 = r0.rightMargin
            r8.f72989p = r7
            int r0 = r0.bottomMargin
            r8.f72990q = r0
        L_0x0094:
            int r0 = r9.getHeight()
            int r7 = r8.f72986m
            int r0 = r0 - r7
            int r0 = r0 - r6
            int r0 = java.lang.Math.min(r3, r0)
            int r3 = r9.getWidth()
            int r6 = r8.f72985l
            int r3 = r3 - r6
            int r3 = r3 - r2
            int r2 = r8.f72987n
            int r3 = r3 - r2
            int r2 = r8.f72989p
            int r3 = r3 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r5)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            android.view.View r3 = r8.f72981h
            r3.measure(r2, r0)
            int r0 = r8.f72985l
            int r2 = r8.f72987n
            int r0 = r0 + r2
            r8.f72992s = r0
            android.view.View r0 = r8.f72981h
            int r0 = r0.getMeasuredWidth()
            int r2 = r8.f72992s
            int r0 = r0 + r2
            r8.f72994u = r0
            int r0 = r8.f72986m
            int r2 = r8.f72988o
            int r0 = r0 + r2
            r8.f72993t = r0
            android.view.View r0 = r8.f72981h
            int r0 = r0.getMeasuredHeight()
            int r2 = r8.f72993t
            int r0 = r0 + r2
            r8.f72995v = r0
            android.view.View r3 = r8.f72981h
            int r4 = r8.f72992s
            int r5 = r8.f72994u
            r3.layout(r4, r2, r5, r0)
            nl.b r0 = r8.f72991r
            r2 = 0
            if (r0 != 0) goto L_0x0148
            nl.a r0 = r8.f72974a
            if (r0 == 0) goto L_0x0148
            nl.b r0 = new nl.b
            android.content.Context r3 = r9.getContext()
            r0.<init>(r3)
            r8.f72991r = r0
            java.lang.Class r0 = r9.getClass()     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            java.lang.String r3 = "mOnItemTouchListeners"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            r3 = 1
            r0.setAccessible(r3)     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            nl.b r3 = r8.f72991r     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            r0.add(r2, r3)     // Catch:{ NoSuchFieldException -> 0x012a, IllegalAccessException -> 0x0120, Exception -> 0x0116 }
            goto L_0x0133
        L_0x0116:
            r0 = move-exception
            r0.printStackTrace()
            nl.b r0 = r8.f72991r
            r9.addOnItemTouchListener(r0)
            goto L_0x0133
        L_0x0120:
            r0 = move-exception
            r0.printStackTrace()
            nl.b r0 = r8.f72991r
            r9.addOnItemTouchListener(r0)
            goto L_0x0133
        L_0x012a:
            r0 = move-exception
            r0.printStackTrace()
            nl.b r0 = r8.f72991r
            r9.addOnItemTouchListener(r0)
        L_0x0133:
            nl.b r9 = r8.f72991r
            nl.a r0 = r8.f72974a
            r9.q(r0)
            nl.b r9 = r8.f72991r
            boolean r0 = r8.f72976c
            r9.m(r0)
            nl.b r9 = r8.f72991r
            android.view.View r0 = r8.f72981h
            r9.o(r1, r0)
        L_0x0148:
            nl.a r9 = r8.f72974a
            if (r9 == 0) goto L_0x0183
            nl.b r9 = r8.f72991r
            android.view.View r0 = r8.f72981h
            r9.o(r1, r0)
            nl.a r9 = r8.f72974a
            if (r9 == 0) goto L_0x0179
            int[] r9 = r8.f72978e
            if (r9 == 0) goto L_0x0179
            int r0 = r9.length
            if (r0 <= 0) goto L_0x0179
            int r0 = r9.length
        L_0x015f:
            if (r2 >= r0) goto L_0x0179
            r1 = r9[r2]
            android.view.View r3 = r8.f72981h
            android.view.View r3 = r3.findViewById(r1)
            if (r3 == 0) goto L_0x0176
            int r4 = r3.getVisibility()
            if (r4 != 0) goto L_0x0176
            nl.b r4 = r8.f72991r
            r4.o(r1, r3)
        L_0x0176:
            int r2 = r2 + 1
            goto L_0x015f
        L_0x0179:
            nl.b r9 = r8.f72991r
            int r0 = r8.f72982i
            int r1 = r8.f72997x
            int r0 = r0 - r1
            r9.p(r0)
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.homemarket.ui.a.i(androidx.recyclerview.widget.RecyclerView):void");
    }

    public final void j(Canvas canvas, RecyclerView recyclerView) {
        if (this.f72980g != null) {
            canvas.clipRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getWidth() - recyclerView.getPaddingRight(), recyclerView.getHeight() - recyclerView.getPaddingBottom());
            int i11 = 0;
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                int childCount = recyclerView.getChildCount();
                int spanCount = getSpanCount(recyclerView);
                while (i11 < childCount) {
                    View childAt = recyclerView.getChildAt(i11);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                    if (q(this.f72980g.getItemViewType(childAdapterPosition))) {
                        DividerHelper.b(canvas, this.f72979f, childAt, layoutParams);
                    } else {
                        if (o(recyclerView, childAdapterPosition, spanCount)) {
                            DividerHelper.c(canvas, this.f72979f, childAt, layoutParams);
                        }
                        DividerHelper.a(canvas, this.f72979f, childAt, layoutParams);
                        DividerHelper.d(canvas, this.f72979f, childAt, layoutParams);
                    }
                    i11++;
                }
            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                int childCount2 = recyclerView.getChildCount();
                while (i11 < childCount2) {
                    View childAt2 = recyclerView.getChildAt(i11);
                    i11++;
                    if ((i11 >= childCount2 || !p(recyclerView, recyclerView.getChildAt(i11))) && !p(recyclerView, childAt2)) {
                        DividerHelper.b(canvas, this.f72979f, childAt2, (RecyclerView.LayoutParams) childAt2.getLayoutParams());
                    }
                }
            } else if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                int childCount3 = recyclerView.getChildCount();
                while (i11 < childCount3) {
                    View childAt3 = recyclerView.getChildAt(i11);
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) childAt3.getLayoutParams();
                    if (p(recyclerView, childAt3)) {
                        DividerHelper.b(canvas, this.f72979f, childAt3, layoutParams2);
                    } else {
                        DividerHelper.c(canvas, this.f72979f, childAt3, layoutParams2);
                        DividerHelper.a(canvas, this.f72979f, childAt3, layoutParams2);
                        DividerHelper.d(canvas, this.f72979f, childAt3, layoutParams2);
                    }
                    i11++;
                }
            }
        }
    }

    public final int k(RecyclerView.LayoutManager layoutManager) throws Exception {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int D2 = staggeredGridLayoutManager.D();
        int[] iArr = new int[D2];
        staggeredGridLayoutManager.q(iArr);
        int i11 = Integer.MAX_VALUE;
        for (int i12 = 0; i12 < D2; i12++) {
            i11 = Math.min(iArr[i12], i11);
        }
        return i11;
    }

    public int l(RecyclerView.LayoutManager layoutManager) throws Exception {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int D2 = staggeredGridLayoutManager.D();
        int[] iArr = new int[D2];
        staggeredGridLayoutManager.t(iArr);
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < D2; i12++) {
            i11 = Math.max(iArr[i12], i11);
        }
        return i11;
    }

    public final int m(int i11) throws Exception {
        if (this.f72980g.getItemCount() < 1) {
            return -1;
        }
        while (i11 >= 0) {
            if (q(this.f72980g.getItemViewType(i11))) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public final void n(int i11, int i12) throws Exception {
        RecyclerView.Adapter adapter = this.f72980g;
        if (adapter != null && this.A != null && adapter.getItemCount() >= 1 && i11 >= 0) {
            while (i12 >= i11) {
                if (q(this.f72980g.getItemViewType(i12)) && this.A != null) {
                    s9.a aVar = (s9.a) ((v9.a) this.f72980g).c().get(i12);
                    if (!this.B.containsKey(Integer.valueOf(i12))) {
                        if (aVar instanceof aj.a) {
                            String g11 = ((aj.a) aVar).g();
                            this.B.put(Integer.valueOf(i12), g11);
                            HashMap hashMap = new HashMap();
                            hashMap.put("markets_list_icon_name", g11);
                            BaseModuleConfig.a().w("App_markets_list_spot_poineer_view", hashMap);
                        } else if (aVar instanceof ml.c) {
                            String a11 = ((ml.c) aVar).a();
                            this.B.put(Integer.valueOf(i12), a11);
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("markets_list_icon_name", a11);
                            BaseModuleConfig.a().w("App_markets_list_spot_poineer_view", hashMap2);
                        }
                    }
                }
                i12--;
            }
        }
    }

    public final boolean o(RecyclerView recyclerView, int i11, int i12) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return false;
        }
        try {
            int m11 = m(i11);
            if (m11 < 0 || (i11 - (m11 + 1)) % i12 != 0) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            i6.d.d(e11.getMessage());
            return false;
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        i(recyclerView);
        if (!this.f72999z && this.f72981h != null && this.f72996w >= this.f72982i) {
            this.f72984k = canvas.getClipBounds();
            View findChildViewUnder = recyclerView.findChildViewUnder((float) (canvas.getWidth() / 2), (float) (this.f72981h.getTop() + this.f72981h.getHeight()));
            if (recyclerView.getChildAdapterPosition(findChildViewUnder) <= this.f72996w || !p(recyclerView, findChildViewUnder)) {
                this.f72983j = 0;
                this.f72984k.top = this.f72986m;
            } else {
                this.f72983j = findChildViewUnder.getTop() - ((this.f72986m + this.f72981h.getHeight()) + this.f72988o);
                this.f72984k.top = this.f72986m;
            }
            canvas.clipRect(this.f72984k);
        }
        if (this.f72975b) {
            j(canvas, recyclerView);
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f72999z || this.f72981h == null || this.f72996w < this.f72982i) {
            nl.b bVar = this.f72991r;
            if (bVar != null) {
                bVar.n(-1000);
                return;
            }
            return;
        }
        canvas.save();
        nl.b bVar2 = this.f72991r;
        if (bVar2 != null) {
            bVar2.n(this.f72983j);
        }
        Rect rect = this.f72984k;
        rect.top = this.f72986m + this.f72988o;
        canvas.clipRect(rect, Region.Op.INTERSECT);
        canvas.translate((float) (this.f72985l + this.f72987n), (float) (this.f72983j + this.f72986m + this.f72988o));
        this.f72981h.draw(canvas);
        canvas.restore();
    }

    public final boolean p(RecyclerView recyclerView, View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return false;
        }
        return q(this.f72980g.getItemViewType(childAdapterPosition));
    }

    public final boolean q(int i11) {
        return this.f72998y == i11;
    }

    public void s() {
        this.B = new HashMap<>();
    }

    public void t() {
        if (this.C == null) {
            this.C = r(8, 30);
        }
        if (this.E == null) {
            this.E = new e();
        }
        this.C.execute(this.E);
    }

    public void u() {
        if (this.C == null) {
            this.C = r(10, 90);
        }
        if (this.D == null) {
            this.D = new d();
        }
        this.C.execute(this.D);
    }

    public final void v() {
        this.f72982i = -1;
        this.f72981h = null;
    }

    /* renamed from: com.huobi.homemarket.ui.a$a  reason: collision with other inner class name */
    public class C0796a extends RecyclerView.AdapterDataObserver {
        public C0796a() {
        }

        public void onChanged() {
            super.onChanged();
            a.this.v();
        }

        public void onItemRangeChanged(int i11, int i12) {
            super.onItemRangeChanged(i11, i12);
            a.this.v();
        }

        public void onItemRangeInserted(int i11, int i12) {
            super.onItemRangeInserted(i11, i12);
            a.this.v();
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            super.onItemRangeMoved(i11, i12, i13);
            a.this.v();
        }

        public void onItemRangeRemoved(int i11, int i12) {
            super.onItemRangeRemoved(i11, i12);
            a.this.v();
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            super.onItemRangeChanged(i11, i12, obj);
            a.this.v();
        }
    }

    public a(f fVar) {
        this.f72982i = -1;
        this.B = new HashMap<>();
        this.C = r(8, 30);
        this.D = new b();
        this.E = new c();
        this.f72975b = fVar.f73007c;
        this.f72974a = fVar.f73005a;
        this.f72977d = fVar.f73006b;
        this.f72978e = fVar.f73008d;
        this.f72976c = fVar.f73009e;
        this.f72998y = fVar.f73010f;
    }
}
