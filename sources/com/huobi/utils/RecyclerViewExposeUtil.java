package com.huobi.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class RecyclerViewExposeUtil {

    /* renamed from: a  reason: collision with root package name */
    public int f83698a;

    /* renamed from: b  reason: collision with root package name */
    public int f83699b;

    /* renamed from: c  reason: collision with root package name */
    public b f83700c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f83701d;

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f83702e;

    public class a extends RecyclerView.OnScrollListener {
        public a() {
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            if (i11 == 0 || i11 == 1 || i11 == 2) {
                RecyclerViewExposeUtil.this.d();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            super.onScrolled(recyclerView, i11, i12);
            RecyclerViewExposeUtil.this.d();
        }
    }

    public interface b {
        void a(boolean z11, int i11);
    }

    public RecyclerViewExposeUtil() {
        this.f83698a = -1;
        this.f83699b = -1;
        this.f83701d = true;
        this.f83701d = true;
    }

    public final int[] a(int[] iArr, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr2[0];
        for (int i13 = 1; i13 < iArr.length; i13++) {
            if (i11 > iArr[i13]) {
                i11 = iArr[i13];
            }
        }
        for (int i14 = 1; i14 < iArr2.length; i14++) {
            if (i12 < iArr2[i14]) {
                i12 = iArr2[i14];
            }
        }
        return new int[]{i11, i12};
    }

    public final int[] b(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] c(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.D()];
        int[] iArr2 = new int[staggeredGridLayoutManager.D()];
        staggeredGridLayoutManager.q(iArr);
        staggeredGridLayoutManager.t(iArr2);
        return a(iArr, iArr2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054 A[Catch:{ Exception -> 0x00d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r9 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r9.f83702e
            if (r0 == 0) goto L_0x00dd
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00dd
            androidx.recyclerview.widget.RecyclerView r0 = r9.f83702e
            boolean r0 = r0.isShown()
            if (r0 == 0) goto L_0x00dd
            androidx.recyclerview.widget.RecyclerView r0 = r9.f83702e
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            boolean r0 = r0.getGlobalVisibleRect(r1)
            if (r0 != 0) goto L_0x0021
            goto L_0x00dd
        L_0x0021:
            r0 = 2
            int[] r1 = new int[r0]     // Catch:{ Exception -> 0x00d2 }
            androidx.recyclerview.widget.RecyclerView r2 = r9.f83702e     // Catch:{ Exception -> 0x00d2 }
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r2.getLayoutManager()     // Catch:{ Exception -> 0x00d2 }
            if (r2 != 0) goto L_0x002d
            return
        L_0x002d:
            boolean r3 = r2 instanceof androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x00d2 }
            r4 = 0
            if (r3 == 0) goto L_0x0041
            r1 = r2
            androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1     // Catch:{ Exception -> 0x00d2 }
            int[] r3 = r9.b(r1)     // Catch:{ Exception -> 0x00d2 }
            int r1 = r1.getOrientation()     // Catch:{ Exception -> 0x00d2 }
        L_0x003d:
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x0052
        L_0x0041:
            boolean r3 = r2 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager     // Catch:{ Exception -> 0x00d2 }
            if (r3 == 0) goto L_0x0051
            r1 = r2
            androidx.recyclerview.widget.StaggeredGridLayoutManager r1 = (androidx.recyclerview.widget.StaggeredGridLayoutManager) r1     // Catch:{ Exception -> 0x00d2 }
            int[] r3 = r9.c(r1)     // Catch:{ Exception -> 0x00d2 }
            int r1 = r1.getOrientation()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x003d
        L_0x0051:
            r3 = r4
        L_0x0052:
            if (r1 == 0) goto L_0x00d1
            int r5 = r1.length     // Catch:{ Exception -> 0x00d2 }
            if (r5 >= r0) goto L_0x0059
            goto L_0x00d1
        L_0x0059:
            r0 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            int r5 = r9.f83698a     // Catch:{ Exception -> 0x00d2 }
            r6 = 1
            if (r0 != r5) goto L_0x0067
            int r0 = r9.f83699b     // Catch:{ Exception -> 0x00d2 }
            r7 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            if (r0 != r7) goto L_0x0067
            return
        L_0x0067:
            r0 = -1
            if (r5 != r0) goto L_0x007e
            int r7 = r9.f83699b     // Catch:{ Exception -> 0x00d2 }
            if (r7 != r0) goto L_0x007e
            r0 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
        L_0x0070:
            r5 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            if (r0 > r5) goto L_0x00a3
            android.view.View r5 = r2.findViewByPosition(r0)     // Catch:{ Exception -> 0x00d2 }
            r9.e(r5, r0, r3)     // Catch:{ Exception -> 0x00d2 }
            int r0 = r0 + 1
            goto L_0x0070
        L_0x007e:
            r0 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            if (r0 < r5) goto L_0x0094
            r0 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            int r7 = r9.f83699b     // Catch:{ Exception -> 0x00d2 }
            if (r0 <= r7) goto L_0x0094
            r0 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            android.view.View r0 = r2.findViewByPosition(r0)     // Catch:{ Exception -> 0x00d2 }
            r2 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            r9.e(r0, r2, r3)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00a3
        L_0x0094:
            r0 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            if (r0 >= r5) goto L_0x00a3
            r0 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            android.view.View r0 = r2.findViewByPosition(r0)     // Catch:{ Exception -> 0x00d2 }
            r2 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            r9.e(r0, r2, r3)     // Catch:{ Exception -> 0x00d2 }
        L_0x00a3:
            r0 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            r9.f83698a = r0     // Catch:{ Exception -> 0x00d2 }
            r0 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            r9.f83699b = r0     // Catch:{ Exception -> 0x00d2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d2 }
            r0.<init>()     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r2 = "屏幕内可见条目的起始位置："
            r0.append(r2)     // Catch:{ Exception -> 0x00d2 }
            r2 = r1[r4]     // Catch:{ Exception -> 0x00d2 }
            r0.append(r2)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r2 = "---"
            r0.append(r2)     // Catch:{ Exception -> 0x00d2 }
            r1 = r1[r6]     // Catch:{ Exception -> 0x00d2 }
            r0.append(r1)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r1 = "---startIndex="
            r0.append(r1)     // Catch:{ Exception -> 0x00d2 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d2 }
            i6.d.b(r0)     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00dd
        L_0x00d1:
            return
        L_0x00d2:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r0 = r0.getMessage()
            i6.d.b(r0)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.RecyclerViewExposeUtil.d():void");
    }

    public final void e(View view, int i11, int i12) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            this.f83700c.a(true, i11);
        }
    }

    public void f(RecyclerView recyclerView, b bVar) {
        this.f83700c = bVar;
        this.f83702e = recyclerView;
        if (recyclerView != null && recyclerView.getVisibility() == 0) {
            this.f83702e.addOnScrollListener(new a());
        }
    }
}
