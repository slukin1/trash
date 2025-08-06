package com.huobi.zeroswap.engine.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import rj.n;

public final class KLineListViewWidget extends Widget {

    /* renamed from: i0  reason: collision with root package name */
    public static final a f21213i0 = new a((r) null);

    /* renamed from: j0  reason: collision with root package name */
    public static final Pair<String, Class<? extends Widget>> f21214j0 = new Pair<>("KlineListView", KLineListViewWidget.class);

    /* renamed from: h0  reason: collision with root package name */
    public final HashMap<String, String> f21215h0 = new HashMap<>();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Pair<String, Class<? extends Widget>> a() {
            return KLineListViewWidget.f21214j0;
        }
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [androidx.recyclerview.widget.RecyclerView$Adapter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a0(androidx.recyclerview.widget.RecyclerView r4, com.huobi.zeroswap.engine.widget.KLineListViewWidget r5, java.lang.String r6) {
        /*
            r0 = 0
            android.widget.LinearLayout$LayoutParams r1 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x007c }
            r2 = -1
            r3 = -2
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x007c }
            r4.setLayoutParams(r1)     // Catch:{ Exception -> 0x007c }
            rd.d r1 = rd.d.f23353a     // Catch:{ Exception -> 0x007c }
            java.lang.Class<com.huobi.zeroswap.engine.model.KLineBean> r2 = com.huobi.zeroswap.engine.model.KLineBean.class
            java.util.List r6 = r1.c(r6, r2)     // Catch:{ Exception -> 0x007c }
            if (r6 != 0) goto L_0x0019
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.k()     // Catch:{ Exception -> 0x007c }
        L_0x0019:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007c }
            r1.<init>()     // Catch:{ Exception -> 0x007c }
            java.lang.String r2 = "positionList = "
            r1.append(r2)     // Catch:{ Exception -> 0x007c }
            java.lang.String r2 = com.hbg.module.libkt.base.ext.f.f(r6)     // Catch:{ Exception -> 0x007c }
            r1.append(r2)     // Catch:{ Exception -> 0x007c }
            java.lang.String r2 = " 刷新"
            r1.append(r2)     // Catch:{ Exception -> 0x007c }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x007c }
            r5.Z(r1)     // Catch:{ Exception -> 0x007c }
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r4.getLayoutManager()     // Catch:{ Exception -> 0x007c }
            boolean r2 = r1 instanceof androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x007c }
            if (r2 == 0) goto L_0x0041
            androidx.recyclerview.widget.LinearLayoutManager r1 = (androidx.recyclerview.widget.LinearLayoutManager) r1     // Catch:{ Exception -> 0x007c }
            goto L_0x0042
        L_0x0041:
            r1 = r0
        L_0x0042:
            if (r1 == 0) goto L_0x00a1
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = r4.getAdapter()     // Catch:{ Exception -> 0x007c }
            boolean r3 = r2 instanceof com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x004f
            com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter r2 = (com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter) r2     // Catch:{ Exception -> 0x007c }
            goto L_0x0050
        L_0x004f:
            r2 = r0
        L_0x0050:
            if (r2 == 0) goto L_0x00a1
            int r3 = r1.findFirstVisibleItemPosition()     // Catch:{ Exception -> 0x007c }
            int r1 = r1.findLastVisibleItemPosition()     // Catch:{ Exception -> 0x007c }
            r2.h(r6)     // Catch:{ Exception -> 0x007c }
            boolean r6 = r2.d()     // Catch:{ Exception -> 0x007c }
            if (r6 != 0) goto L_0x0075
            java.util.List r6 = r2.getData()     // Catch:{ Exception -> 0x007c }
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x007c }
            if (r6 == 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            int r1 = r1 - r3
            int r1 = r1 + 1
            r2.notifyItemRangeChanged(r3, r1)     // Catch:{ Exception -> 0x007c }
            goto L_0x00a1
        L_0x0075:
            r2.notifyDataSetChanged()     // Catch:{ Exception -> 0x007c }
            r2.g()     // Catch:{ Exception -> 0x007c }
            goto L_0x00a1
        L_0x007c:
            r6 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "异常:"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r5.Z(r6)
            androidx.recyclerview.widget.RecyclerView$Adapter r4 = r4.getAdapter()
            boolean r5 = r4 instanceof com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter
            if (r5 == 0) goto L_0x009c
            r0 = r4
            com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter r0 = (com.huobi.zeroswap.component.ZeroSwapOpenPositionAdapter) r0
        L_0x009c:
            if (r0 == 0) goto L_0x00a1
            r0.notifyDataSetChanged()
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.zeroswap.engine.widget.KLineListViewWidget.a0(androidx.recyclerview.widget.RecyclerView, com.huobi.zeroswap.engine.widget.KLineListViewWidget, java.lang.String):void");
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f21215h0.clear();
        HashMap<String, String> hashMap = this.f21215h0;
        if (map == null) {
            map = new HashMap<>();
        }
        hashMap.putAll(map);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        RecyclerView recyclerView = Q instanceof RecyclerView ? (RecyclerView) Q : null;
        Z("View: " + Q);
        if (recyclerView != null) {
            Z("参数: " + this.f21215h0);
            String str = this.f21215h0.get("positionList");
            if (str == null) {
                str = "";
            }
            w(context, str, new ov.a(recyclerView, this), nVar);
        }
        return Q;
    }

    public final void Z(String str) {
        Log.d("KLineListViewWidget", str);
    }

    public View q(Context context) {
        Z("View: createView()");
        if (context == null) {
            return null;
        }
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        recyclerView.setAdapter(new ZeroSwapOpenPositionAdapter());
        return recyclerView;
    }
}
