package com.huobi.edgeengine.template.widget.list;

import ak.f;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huobi.edgeengine.template.widget.ContainerWidget;
import com.huobi.edgeengine.template.widget.FooterWidget;
import com.huobi.edgeengine.template.widget.HeaderWidget;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.util.IdentifierUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ky.j;
import rj.n;

public class RecyclerViewWidget extends ContainerWidget {
    public List<ak.b> A0 = new ArrayList();

    /* renamed from: i0  reason: collision with root package name */
    public String f44262i0 = "item";

    /* renamed from: j0  reason: collision with root package name */
    public String f44263j0 = "i";

    /* renamed from: k0  reason: collision with root package name */
    public String f44264k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44265l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44266m0;

    /* renamed from: n0  reason: collision with root package name */
    public String f44267n0;

    /* renamed from: o0  reason: collision with root package name */
    public String f44268o0;

    /* renamed from: p0  reason: collision with root package name */
    public String f44269p0;

    /* renamed from: q0  reason: collision with root package name */
    public int f44270q0;

    /* renamed from: r0  reason: collision with root package name */
    public int f44271r0;

    /* renamed from: s0  reason: collision with root package name */
    public String f44272s0;

    /* renamed from: t0  reason: collision with root package name */
    public String f44273t0;

    /* renamed from: u0  reason: collision with root package name */
    public String f44274u0;

    /* renamed from: v0  reason: collision with root package name */
    public String f44275v0;

    /* renamed from: w0  reason: collision with root package name */
    public String f44276w0;

    /* renamed from: x0  reason: collision with root package name */
    public String f44277x0;

    /* renamed from: y0  reason: collision with root package name */
    public String f44278y0;

    /* renamed from: z0  reason: collision with root package name */
    public String f44279z0;

    public class a extends com.huobi.edgeengine.template.widget.c<SmartRefreshLayout> {
        public a(SmartRefreshLayout smartRefreshLayout) {
            super(smartRefreshLayout);
        }

        /* renamed from: c */
        public void b(SmartRefreshLayout smartRefreshLayout, String str) {
            if ("1".equals(str)) {
                smartRefreshLayout.u(0);
            } else if (!"2".equals(str)) {
            } else {
                if (smartRefreshLayout.M()) {
                    smartRefreshLayout.finishRefresh();
                } else {
                    smartRefreshLayout.d(1000);
                }
            }
        }
    }

    public class b extends com.huobi.edgeengine.template.widget.c<SmartRefreshLayout> {
        public b(SmartRefreshLayout smartRefreshLayout) {
            super(smartRefreshLayout);
        }

        /* renamed from: c */
        public void b(SmartRefreshLayout smartRefreshLayout, String str) {
            if ("1".equals(str)) {
                smartRefreshLayout.q();
            } else if (!"2".equals(str)) {
            } else {
                if (smartRefreshLayout.K()) {
                    smartRefreshLayout.w();
                } else {
                    smartRefreshLayout.b(1000);
                }
            }
        }
    }

    public class c extends com.huobi.edgeengine.template.widget.c<SmartRefreshLayout> {
        public c(SmartRefreshLayout smartRefreshLayout) {
            super(smartRefreshLayout);
        }

        /* renamed from: c */
        public void b(SmartRefreshLayout smartRefreshLayout, String str) {
            smartRefreshLayout.setNoMoreData("true".equals(str));
        }
    }

    public class d extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f44283a;

        public d(n nVar) {
            this.f44283a = nVar;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
            if (i11 == 0) {
                RecyclerViewWidget recyclerViewWidget = RecyclerViewWidget.this;
                boolean unused = recyclerViewWidget.z(recyclerViewWidget.f44278y0, this.f44283a);
            } else if (i11 == 2 || i11 == 1) {
                RecyclerViewWidget recyclerViewWidget2 = RecyclerViewWidget.this;
                boolean unused2 = recyclerViewWidget2.z(recyclerViewWidget2.f44277x0, this.f44283a);
            }
        }
    }

    public class e extends com.huobi.edgeengine.template.widget.c<SmartRefreshLayout> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RecyclerView f44285b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
            super(smartRefreshLayout);
            this.f44285b = recyclerView;
        }

        /* renamed from: c */
        public void b(SmartRefreshLayout smartRefreshLayout, String str) {
            if (str != null) {
                try {
                    if (!str.isEmpty()) {
                        int parseInt = Integer.parseInt(str);
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f44285b.getLayoutManager();
                        ak.b bVar = (ak.b) this.f44285b.getAdapter();
                        if (bVar != null) {
                            int d11 = parseInt + bVar.d();
                            if (linearLayoutManager != null) {
                                linearLayoutManager.scrollToPositionWithOffset(d11, 0);
                                return;
                            }
                            return;
                        }
                        Log.e("EdgeEngine.Widget", "scrollToPos: adapter is null " + str);
                    }
                } catch (Throwable th2) {
                    Log.e("EdgeEngine.Widget", "scrollToPos 解析失败！！" + th2.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(n nVar, j jVar) {
        z(this.f44274u0, nVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(n nVar, j jVar) {
        z(this.f44275v0, nVar);
    }

    public static /* synthetic */ void j0(ShapeDrawable shapeDrawable, Context context, String str) {
        try {
            if (str.startsWith("#")) {
                shapeDrawable.getPaint().setColor(Color.parseColor(str));
                return;
            }
            shapeDrawable.getPaint().setColor(ContextCompat.getColor(context, IdentifierUtil.a(context, str, "color")));
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void k0(ShapeDrawable shapeDrawable, String str) {
        try {
            shapeDrawable.getPaint().setColor(Color.parseColor(str));
        } catch (Throwable unused) {
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44262i0 = map.get("itemKey");
        this.f44263j0 = map.get("indexKey");
        this.f44264k0 = map.get("typeKey");
        String str = map.get("data");
        this.f44265l0 = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f44265l0.startsWith(TIMMentionEditText.TIM_MENTION_TAG)) {
                int indexOf = this.f44265l0.indexOf(InstructionFileId.DOT);
                if (indexOf > 0) {
                    this.f44267n0 = this.f44265l0.substring(1, indexOf);
                    this.f44266m0 = this.f44265l0.substring(indexOf + 1);
                }
            } else {
                this.f44266m0 = this.f44265l0;
            }
        }
        this.f44268o0 = map.get("showDividers");
        String str2 = map.get("dividerHeight");
        String str3 = map.get("dividerPadding");
        this.f44269p0 = map.get("dividerColor");
        this.f44274u0 = map.get("onRefresh");
        this.f44275v0 = map.get("onLoadMore");
        this.f44272s0 = map.get("refreshStatus");
        this.f44273t0 = map.get("loadMoreStatus");
        this.f44276w0 = map.get("noMoreData");
        this.f44277x0 = map.get("onScrollStart");
        this.f44278y0 = map.get("onScrollStop");
        this.f44279z0 = map.get("scrollToPos");
        try {
            this.f44270q0 = A(context, Float.parseFloat(str3));
        } catch (Throwable unused) {
            Log.e("EdgeEngine.Widget", "dividerPadding 解析失败！！");
        }
        try {
            this.f44271r0 = A(context, Float.parseFloat(str2));
        } catch (Throwable unused2) {
            Log.e("EdgeEngine.Widget", "dividerPadding 解析失败！！");
        }
    }

    public void O() {
        super.O();
        for (ak.b j11 : this.A0) {
            j11.j();
        }
        this.A0.clear();
    }

    /* renamed from: g0 */
    public SmartRefreshLayout q(Context context) {
        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(context);
        smartRefreshLayout.f0(new RecyclerView(context));
        return smartRefreshLayout;
    }

    /* renamed from: l0 */
    public SmartRefreshLayout Q(Context context, n nVar) {
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) super.Q(context, nVar);
        if (TextUtils.isEmpty(this.f44272s0)) {
            smartRefreshLayout.i(false);
        } else {
            smartRefreshLayout.i(true);
            w(context, this.f44272s0, new a(smartRefreshLayout), nVar);
            if (!TextUtils.isEmpty(this.f44274u0)) {
                smartRefreshLayout.d0(new f(this, nVar));
            }
        }
        if (TextUtils.isEmpty(this.f44273t0)) {
            smartRefreshLayout.g(false);
        } else {
            smartRefreshLayout.g(true);
            smartRefreshLayout.V(false);
            w(context, this.f44273t0, new b(smartRefreshLayout), nVar);
            if (!TextUtils.isEmpty(this.f44275v0)) {
                smartRefreshLayout.b0(new ak.e(this, nVar));
            }
        }
        w(context, this.f44276w0, new c(smartRefreshLayout), nVar);
        RecyclerView recyclerView = (RecyclerView) smartRefreshLayout.getChildAt(0);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        recyclerView.addItemDecoration(new StickyItemDecoration());
        ak.b bVar = new ak.b(context);
        bVar.o(this.f44262i0);
        if (TextUtils.isEmpty(this.f44264k0)) {
            this.f44264k0 = "type";
        }
        if (!TextUtils.isEmpty(this.f44277x0) || !TextUtils.isEmpty(this.f44278y0)) {
            recyclerView.addOnScrollListener(new d(nVar));
        }
        bVar.q(this.f44264k0);
        String str = this.f44267n0;
        if (TextUtils.isEmpty(str)) {
            str = nVar.f47793e;
        }
        bVar.l(str, this.f44266m0);
        if ("middle".equals(this.f44268o0)) {
            h hVar = new h(context, 1);
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            if (!u(this.f44269p0, new ak.d(shapeDrawable, context))) {
                w(context, this.f44269p0, new ak.c(shapeDrawable), nVar);
            }
            shapeDrawable.setIntrinsicHeight(this.f44271r0);
            int i11 = this.f44270q0;
            hVar.setDrawable(new InsetDrawable(shapeDrawable, i11, 0, i11, 0));
            recyclerView.addItemDecoration(hVar);
        }
        bVar.p(nVar);
        bVar.r();
        ArrayList arrayList = new ArrayList();
        for (Widget next : this.f44069h0) {
            if (next instanceof CellWidget) {
                arrayList.add((CellWidget) next);
            } else if (next instanceof HeaderWidget) {
                bVar.n((HeaderWidget) next);
            } else if (next instanceof FooterWidget) {
                bVar.m((FooterWidget) next);
            }
        }
        bVar.k(arrayList);
        recyclerView.setLayoutManager(new StableLinearLayoutManager(context));
        recyclerView.setAdapter(bVar);
        bVar.notifyDataSetChanged();
        this.A0.add(bVar);
        w(context, this.f44279z0, new e(smartRefreshLayout, recyclerView), nVar);
        return smartRefreshLayout;
    }
}
