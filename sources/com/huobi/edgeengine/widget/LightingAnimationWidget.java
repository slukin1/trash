package com.huobi.edgeengine.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.edgeengine.template.widget.Widget;
import java.util.Map;
import kotlin.jvm.internal.r;
import pro.huobi.R;

public final class LightingAnimationWidget extends Widget {

    /* renamed from: n0  reason: collision with root package name */
    public static final a f44377n0 = new a((r) null);

    /* renamed from: h0  reason: collision with root package name */
    public String f44378h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44379i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f44380j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f44381k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f44382l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f44383m0;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public static final void c0(LightingAnimationWidget lightingAnimationWidget, Context context, TextView textView, String str) {
        try {
            textView.setTextSize(0, (float) lightingAnimationWidget.A(context, Float.parseFloat(str)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void d0(TextView textView, LightingAnimationWidget lightingAnimationWidget, Context context, String str) {
        try {
            textView.setTextColor(lightingAnimationWidget.a0(context, str));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void e0(TextView textView, String str) {
        try {
            textView.setText(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        this.f44378h0 = map.get("text");
        this.f44379i0 = map.get("textSize");
        this.f44380j0 = map.get("textColor");
        this.f44381k0 = map.get("textFontWeight");
        this.f44382l0 = map.get("paddingHorizontal");
        this.f44383m0 = map.get("paddingVertical");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0026, code lost:
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View Q(android.content.Context r8, rj.n r9) {
        /*
            r7 = this;
            android.view.View r0 = super.Q(r8, r9)
            r1 = 2131435944(0x7f0b21a8, float:1.8493744E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = r7.f44379i0
            fk.c r3 = new fk.c
            r3.<init>(r7, r8, r1)
            r7.w(r8, r2, r3, r9)
            java.lang.String r2 = r7.f44380j0
            fk.b r3 = new fk.b
            r3.<init>(r1, r7, r8)
            r7.w(r8, r2, r3, r9)
            java.lang.String r2 = r7.f44381k0
            r3 = 0
            if (r2 == 0) goto L_0x0031
            java.lang.Integer r2 = kotlin.text.StringsKt__StringNumberConversionsKt.m(r2)
            if (r2 == 0) goto L_0x0031
            int r2 = r2.intValue()
            goto L_0x0032
        L_0x0031:
            r2 = r3
        L_0x0032:
            r4 = -1
            if (r2 <= r4) goto L_0x0053
            android.graphics.Typeface r4 = r1.getTypeface()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r5 < r6) goto L_0x0053
            r5 = 700(0x2bc, float:9.81E-43)
            r6 = 400(0x190, float:5.6E-43)
            if (r2 > r6) goto L_0x0047
            r5 = r6
            goto L_0x004c
        L_0x0047:
            if (r2 > r5) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r5 = 900(0x384, float:1.261E-42)
        L_0x004c:
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r4, r5, r3)
            r1.setTypeface(r2)
        L_0x0053:
            java.lang.String r2 = r7.f44378h0
            fk.a r3 = new fk.a
            r3.<init>(r1)
            r7.w(r8, r2, r3, r9)
            java.lang.String r9 = r7.f44382l0
            r1 = 0
            if (r9 == 0) goto L_0x006d
            java.lang.Float r9 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.k(r9)
            if (r9 == 0) goto L_0x006d
            float r9 = r9.floatValue()
            goto L_0x006e
        L_0x006d:
            r9 = r1
        L_0x006e:
            int r9 = r7.A(r8, r9)
            java.lang.String r2 = r7.f44383m0
            if (r2 == 0) goto L_0x0080
            java.lang.Float r2 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.k(r2)
            if (r2 == 0) goto L_0x0080
            float r1 = r2.floatValue()
        L_0x0080:
            int r8 = r7.A(r8, r1)
            r1 = 2131429568(0x7f0b08c0, float:1.8480812E38)
            android.view.View r1 = r0.findViewById(r1)
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            r1.setPadding(r9, r8, r9, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.widget.LightingAnimationWidget.Q(android.content.Context, rj.n):android.view.View");
    }

    public final int a0(Context context, String str) {
        return ContextCompat.getColor(context, b0(context, "color", str));
    }

    public final int b0(Context context, String str, String str2) {
        Resources resources;
        if (str2 == null || context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getIdentifier(str2, str, context.getPackageName());
    }

    public View q(Context context) {
        return View.inflate(context, R.layout.widget_lighting_animation_view, (ViewGroup) null);
    }
}
