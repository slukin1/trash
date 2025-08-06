package com.huobi.edgeengine.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.widget.view.HotCoinChartView;
import java.util.Map;
import kotlin.jvm.internal.r;
import rj.n;

public final class HotCoinChartWidget extends Widget {

    /* renamed from: k0  reason: collision with root package name */
    public static final a f44369k0 = new a((r) null);

    /* renamed from: h0  reason: collision with root package name */
    public String f44370h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44371i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44372j0;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final class b extends com.huobi.edgeengine.template.widget.c<HotCoinChartView> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotCoinChartWidget f44373b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f44374c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(HotCoinChartView hotCoinChartView, HotCoinChartWidget hotCoinChartWidget, Context context) {
            super(hotCoinChartView);
            this.f44373b = hotCoinChartWidget;
            this.f44374c = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ all -> 0x000d }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.huobi.edgeengine.widget.view.HotCoinChartView r5, java.lang.String r6) {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                if (r6 == 0) goto L_0x000f
                int r2 = r6.length()     // Catch:{ all -> 0x000d }
                if (r2 != 0) goto L_0x000b
                goto L_0x000f
            L_0x000b:
                r2 = r0
                goto L_0x0010
            L_0x000d:
                r5 = move-exception
                goto L_0x002d
            L_0x000f:
                r2 = r1
            L_0x0010:
                if (r2 != 0) goto L_0x0034
                java.lang.String r2 = "null"
                boolean r2 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r2, r1)     // Catch:{ all -> 0x000d }
                if (r2 == 0) goto L_0x001b
                goto L_0x0034
            L_0x001b:
                com.huobi.edgeengine.widget.HotCoinChartWidget r2 = r4.f44373b     // Catch:{ all -> 0x000d }
                android.content.Context r3 = r4.f44374c     // Catch:{ all -> 0x000d }
                float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ all -> 0x000d }
                int r6 = r2.A(r3, r6)     // Catch:{ all -> 0x000d }
                if (r5 == 0) goto L_0x0034
                r5.setXTextWidth(r6)     // Catch:{ all -> 0x000d }
                goto L_0x0034
            L_0x002d:
                java.lang.Object[] r6 = new java.lang.Object[r1]
                r6[r0] = r5
                com.blankj.utilcode.util.LogUtils.j(r6)
            L_0x0034:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.widget.HotCoinChartWidget.b.b(com.huobi.edgeengine.widget.view.HotCoinChartView, java.lang.String):void");
        }
    }

    public static final class c extends com.huobi.edgeengine.template.widget.c<HotCoinChartView> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HotCoinChartWidget f44375b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f44376c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(HotCoinChartView hotCoinChartView, HotCoinChartWidget hotCoinChartWidget, Context context) {
            super(hotCoinChartView);
            this.f44375b = hotCoinChartWidget;
            this.f44376c = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ all -> 0x000d }] */
        /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.huobi.edgeengine.widget.view.HotCoinChartView r5, java.lang.String r6) {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                if (r6 == 0) goto L_0x000f
                int r2 = r6.length()     // Catch:{ all -> 0x000d }
                if (r2 != 0) goto L_0x000b
                goto L_0x000f
            L_0x000b:
                r2 = r0
                goto L_0x0010
            L_0x000d:
                r5 = move-exception
                goto L_0x002d
            L_0x000f:
                r2 = r1
            L_0x0010:
                if (r2 != 0) goto L_0x0034
                java.lang.String r2 = "null"
                boolean r2 = kotlin.text.StringsKt__StringsJVMKt.w(r6, r2, r1)     // Catch:{ all -> 0x000d }
                if (r2 == 0) goto L_0x001b
                goto L_0x0034
            L_0x001b:
                com.huobi.edgeengine.widget.HotCoinChartWidget r2 = r4.f44375b     // Catch:{ all -> 0x000d }
                android.content.Context r3 = r4.f44376c     // Catch:{ all -> 0x000d }
                float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ all -> 0x000d }
                int r6 = r2.A(r3, r6)     // Catch:{ all -> 0x000d }
                if (r5 == 0) goto L_0x0034
                r5.setXTextHeight(r6)     // Catch:{ all -> 0x000d }
                goto L_0x0034
            L_0x002d:
                java.lang.Object[] r6 = new java.lang.Object[r1]
                r6[r0] = r5
                com.blankj.utilcode.util.LogUtils.j(r6)
            L_0x0034:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.widget.HotCoinChartWidget.c.b(com.huobi.edgeengine.widget.view.HotCoinChartView, java.lang.String):void");
        }
    }

    public static final class d extends com.huobi.edgeengine.template.widget.c<HotCoinChartView> {
        public d(HotCoinChartView hotCoinChartView) {
            super(hotCoinChartView);
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0012 A[Catch:{ all -> 0x000d }] */
        /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void b(com.huobi.edgeengine.widget.view.HotCoinChartView r4, java.lang.String r5) {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                if (r5 == 0) goto L_0x000f
                int r2 = r5.length()     // Catch:{ all -> 0x000d }
                if (r2 != 0) goto L_0x000b
                goto L_0x000f
            L_0x000b:
                r2 = r0
                goto L_0x0010
            L_0x000d:
                r4 = move-exception
                goto L_0x0021
            L_0x000f:
                r2 = r1
            L_0x0010:
                if (r2 != 0) goto L_0x0028
                java.lang.String r2 = "null"
                boolean r2 = kotlin.text.StringsKt__StringsJVMKt.w(r5, r2, r1)     // Catch:{ all -> 0x000d }
                if (r2 == 0) goto L_0x001b
                goto L_0x0028
            L_0x001b:
                if (r4 == 0) goto L_0x0028
                r4.setPointListJson(r5)     // Catch:{ all -> 0x000d }
                goto L_0x0028
            L_0x0021:
                java.lang.Object[] r5 = new java.lang.Object[r1]
                r5[r0] = r4
                com.blankj.utilcode.util.LogUtils.j(r5)
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.widget.HotCoinChartWidget.d.b(com.huobi.edgeengine.widget.view.HotCoinChartView, java.lang.String):void");
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44370h0 = String.valueOf(map.get("xTextWidth"));
        this.f44371i0 = String.valueOf(map.get("xTextHeight"));
        this.f44372j0 = String.valueOf(map.get("pointListJson"));
    }

    public View Q(Context context, n nVar) {
        HotCoinChartView hotCoinChartView = (HotCoinChartView) super.Q(context, nVar);
        w(context, this.f44370h0, new b(hotCoinChartView, this, context), nVar);
        w(context, this.f44371i0, new c(hotCoinChartView, this, context), nVar);
        w(context, this.f44372j0, new d(hotCoinChartView), nVar);
        return hotCoinChartView;
    }

    public View q(Context context) {
        return new HotCoinChartView(context, (AttributeSet) null, 0, 6, (r) null);
    }
}
