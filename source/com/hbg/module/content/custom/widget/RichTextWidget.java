package com.hbg.module.content.custom.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.c;
import com.huobi.edgeengine.template.widget.Widget;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import rj.n;

public final class RichTextWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f18187h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f18188i0;

    /* renamed from: j0  reason: collision with root package name */
    public String f18189j0;

    /* renamed from: k0  reason: collision with root package name */
    public String f18190k0;

    /* renamed from: l0  reason: collision with root package name */
    public String f18191l0;

    public static final class a extends ClickableSpan {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JSONObject f18192b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f18193c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ RichTextWidget f18194d;

        public a(JSONObject jSONObject, Context context, RichTextWidget richTextWidget) {
            this.f18192b = jSONObject;
            this.f18193c = context;
            this.f18194d = richTextWidget;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            b2.a.d().a("/webView/index").withString("url", this.f18192b.getString("link")).navigation(this.f18193c);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(this.f18194d.a0(this.f18193c, this.f18192b.getString("textColor")));
        }
    }

    public static final void e0(RichTextWidget richTextWidget, Context context, View view, String str) {
        try {
            ((TextView) view).setTextSize(0, (float) richTextWidget.A(context, Float.parseFloat(str)));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static final void f0(View view, RichTextWidget richTextWidget, Context context, String str) {
        RichTextWidget richTextWidget2 = richTextWidget;
        Context context2 = context;
        try {
            JSONObject jSONObject = new JSONObject(str);
            ((TextView) view).setHighlightColor(0);
            ((TextView) view).setTextColor(richTextWidget2.a0(context2, jSONObject.getString("textColor")));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(richTextWidget2.c0(context2, jSONObject.getString("content")));
            JSONArray jSONArray = jSONObject.getJSONArray("highlight");
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i11);
                String c02 = richTextWidget2.c0(context2, jSONObject2.getString("content"));
                boolean optBoolean = jSONObject2.optBoolean(TtmlNode.BOLD, false);
                int g02 = StringsKt__StringsKt.g0(spannableStringBuilder, c02, 0, false, 6, (Object) null);
                int length2 = c02.length() + g02;
                String string = jSONObject2.getString("link");
                if (optBoolean) {
                    spannableStringBuilder.setSpan(new StyleSpan(1), g02, length2, 33);
                }
                if (richTextWidget2.d0(string)) {
                    spannableStringBuilder.setSpan(new a(jSONObject2, context2, richTextWidget2), g02, length2, 33);
                    ((TextView) view).setMovementMethod(LinkMovementMethod.getInstance());
                } else {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(richTextWidget2.a0(context2, jSONObject2.getString("textColor"))), g02, length2, 33);
                }
            }
            ((TextView) view).setText(spannableStringBuilder);
        } catch (Throwable th2) {
            System.out.println(th2.getMessage());
        }
    }

    public void C(Context context, Map<String, String> map) {
        super.C(context, map);
        String str = null;
        this.f18187h0 = map != null ? map.get("richText") : null;
        this.f18188i0 = map != null ? map.get("linkClick") : null;
        this.f18191l0 = map != null ? map.get("lineSpacing") : null;
        this.f18189j0 = map != null ? map.get("textSize") : null;
        if (map != null) {
            str = map.get("textColor");
        }
        this.f18190k0 = str;
    }

    public View Q(Context context, n nVar) {
        View Q = super.Q(context, nVar);
        if (Q instanceof TextView) {
            w(context, this.f18189j0, new f(this, context, Q), nVar);
            String str = this.f18191l0;
            if (str != null) {
                ((TextView) Q).setLineSpacing((float) c.a(Float.parseFloat(str)), 1.0f);
            }
            w(context, this.f18187h0, new e(Q, this, context), nVar);
        }
        return Q;
    }

    public final int a0(Context context, String str) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getColor(b0(context, "color", str));
    }

    public final int b0(Context context, String str, String str2) {
        Resources resources;
        if (str2 == null || context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getIdentifier(str2, str, context.getPackageName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String c0(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0013
            android.content.res.Resources r0 = r3.getResources()
            if (r0 == 0) goto L_0x0013
            java.lang.String r1 = "string"
            int r3 = r2.b0(r3, r1, r4)
            java.lang.String r3 = r0.getString(r3)
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            if (r3 != 0) goto L_0x0018
            java.lang.String r3 = ""
        L_0x0018:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.custom.widget.RichTextWidget.c0(android.content.Context, java.lang.String):java.lang.String");
    }

    public final boolean d0(String str) {
        if (b.x(str)) {
            return false;
        }
        if (StringsKt__StringsJVMKt.M(str, "http", false, 2, (Object) null) || StringsKt__StringsJVMKt.M(str, "holigeit", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    public View q(Context context) {
        return new TextView(context);
    }
}
