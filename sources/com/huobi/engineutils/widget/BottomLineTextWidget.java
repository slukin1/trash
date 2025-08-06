package com.huobi.engineutils.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hbg.lib.widgets.AutoSizeTextView;
import com.huobi.asset.widget.BottomLineTextView;
import com.huobi.edgeengine.template.widget.Widget;
import com.huobi.edgeengine.template.widget.b;
import rj.n;

public class BottomLineTextWidget extends Widget {

    /* renamed from: h0  reason: collision with root package name */
    public String f44578h0;

    /* renamed from: i0  reason: collision with root package name */
    public String f44579i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f44580j0 = -1;

    /* renamed from: k0  reason: collision with root package name */
    public int f44581k0;

    public class a extends b {
        public a(View view) {
            super(view);
        }

        public void b(View view, String str) {
            ((TextView) view).setText(str);
        }
    }

    public static /* synthetic */ void Z(Context context, BottomLineTextView bottomLineTextView, String str) {
        try {
            bottomLineTextView.setTextColor(context.getResources().getIdentifier(str, "color", context.getPackageName()));
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void C(android.content.Context r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            r2 = this;
            super.C(r3, r4)
            java.lang.String r0 = "text"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r2.f44578h0 = r0
            java.lang.String r0 = "textColor"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r2.f44579i0 = r0
            java.lang.String r0 = "textFontWeight"
            java.lang.Object r0 = r4.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "textSize"
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r4 = (java.lang.String) r4
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x002d }
            r2.f44580j0 = r0     // Catch:{ Exception -> 0x002d }
        L_0x002d:
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0038 }
            float r4 = (float) r4     // Catch:{ Exception -> 0x0038 }
            int r3 = r2.A(r3, r4)     // Catch:{ Exception -> 0x0038 }
            r2.f44581k0 = r3     // Catch:{ Exception -> 0x0038 }
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.engineutils.widget.BottomLineTextWidget.C(android.content.Context, java.util.Map):void");
    }

    public View Q(Context context, n nVar) {
        BottomLineTextView bottomLineTextView = (BottomLineTextView) super.Q(context, nVar);
        AutoSizeTextView bottomLineText = bottomLineTextView.getBottomLineText();
        bottomLineText.setTextSize(0, (float) this.f44581k0);
        bottomLineText.setMinTextSize((float) this.f44581k0);
        if (!TextUtils.isEmpty(this.E)) {
            int i11 = 0;
            for (String str : this.E.split("\\|")) {
                if (TtmlNode.CENTER.equals(str)) {
                    i11 |= 17;
                } else if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(str)) {
                    i11 |= 48;
                } else if ("bottom".equals(str)) {
                    i11 |= 80;
                } else if ("left".equals(str)) {
                    i11 |= 3;
                } else if (TtmlNode.RIGHT.equals(str)) {
                    i11 |= 5;
                }
            }
            if (i11 != 0) {
                bottomLineText.setGravity(i11);
                bottomLineTextView.setGravity(i11);
            }
        }
        if (this.f44580j0 > -1) {
            Typeface typeface = bottomLineText.getTypeface();
            if (Build.VERSION.SDK_INT >= 28) {
                int i12 = this.f44580j0;
                if (i12 <= 400) {
                    this.f44580j0 = 400;
                } else if (i12 <= 700) {
                    this.f44580j0 = 700;
                } else {
                    this.f44580j0 = 900;
                }
                bottomLineText.setTypeface(Typeface.create(typeface, this.f44580j0, false));
            }
        }
        w(context, this.f44578h0, new a(bottomLineText), nVar);
        u(this.f44579i0, new jk.n(context, bottomLineTextView));
        return bottomLineTextView;
    }

    /* renamed from: Y */
    public BottomLineTextView q(Context context) {
        return new BottomLineTextView(context);
    }
}
