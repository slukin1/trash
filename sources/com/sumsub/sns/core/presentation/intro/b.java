package com.sumsub.sns.core.presentation.intro;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.data.source.extensions.a;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final a f31097a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f31098b;

    public b(a aVar, boolean z11) {
        this.f31097a = aVar;
        this.f31098b = z11;
    }

    public static /* synthetic */ void a(b bVar, View view, Map map, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i11 = R.id.sns_container;
        }
        if ((i13 & 8) != 0) {
            i12 = R.id.sns_primary_button;
        }
        bVar.a(view, map, i11, i12);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.widget.TextView, android.view.View] */
    /* JADX WARNING: type inference failed for: r10v1, types: [com.sumsub.sns.core.widget.SNSH2TextView] */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.sumsub.sns.core.widget.SNSH1TextView] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View b(android.content.Context r18, java.lang.CharSequence r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r0.f31098b
            if (r2 == 0) goto L_0x0017
            com.sumsub.sns.core.widget.SNSH1TextView r2 = new com.sumsub.sns.core.widget.SNSH1TextView
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r2
            r4 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L_0x0026
        L_0x0017:
            com.sumsub.sns.core.widget.SNSH2TextView r2 = new com.sumsub.sns.core.widget.SNSH2TextView
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r2
            r11 = r18
            r10.<init>(r11, r12, r13, r14, r15, r16)
        L_0x0026:
            if (r1 == 0) goto L_0x002f
            com.sumsub.sns.internal.core.data.source.extensions.a r3 = r0.f31097a
            android.text.Spanned r1 = r3.a(r1)
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            r2.setText(r1)
            android.content.res.Resources r1 = r18.getResources()
            int r3 = com.sumsub.sns.R.dimen.sns_margin_small
            int r1 = r1.getDimensionPixelSize(r3)
            r3 = 0
            r2.setPadding(r1, r3, r1, r3)
            com.sumsub.sns.core.presentation.helper.a r1 = com.sumsub.sns.core.presentation.helper.a.f31095a
            com.sumsub.sns.internal.core.theme.d r3 = r1.a()
            if (r3 == 0) goto L_0x0051
            com.sumsub.sns.core.theme.SNSMetricElement r4 = com.sumsub.sns.core.theme.SNSMetricElement.SCREEN_HEADER_ALIGNMENT
            java.lang.String r3 = r1.c(r3, r4)
            if (r3 != 0) goto L_0x0057
        L_0x0051:
            com.sumsub.sns.core.theme.SNSThemeMetric$TextAlignment r3 = com.sumsub.sns.core.theme.SNSThemeMetric.TextAlignment.CENTER
            java.lang.String r3 = r3.getValue()
        L_0x0057:
            r1.a((android.widget.TextView) r2, (java.lang.String) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.intro.b.b(android.content.Context, java.lang.CharSequence):android.view.View");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(a aVar, boolean z11, int i11, r rVar) {
        this(aVar, (i11 & 2) != 0 ? true : z11);
    }

    public final void a(View view, Map<String, ?> map, int i11, int i12) {
        int i13;
        Button button;
        Context context = view.getContext();
        if (context != null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            int i14 = 0;
            if (this.f31098b) {
                i13 = 0;
            } else {
                i13 = context.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
            }
            linearLayout.setPadding(i13, 0, i13, 0);
            Object obj = map.get("title");
            String str = null;
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 != null) {
                View b11 = b(context, str2);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                marginLayoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sns_margin_small);
                Unit unit = Unit.f56620a;
                linearLayout.addView(b11, marginLayoutParams);
            }
            Object obj2 = map.get(MessengerShareContentUtility.SUBTITLE);
            String str3 = obj2 instanceof String ? (String) obj2 : null;
            if (str3 != null) {
                View a11 = a(context, str3);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(-1, -2);
                marginLayoutParams2.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
                Unit unit2 = Unit.f56620a;
                linearLayout.addView(a11, marginLayoutParams2);
            }
            if (this.f31098b) {
                i14 = context.getResources().getDimensionPixelSize(R.dimen.sns_margin_small);
            }
            Object obj3 = map.get("contentBlocks");
            List list = obj3 instanceof List ? (List) obj3 : null;
            if (list != null) {
                for (View addView : new a(this.f31097a).a(context, (List<?>) list)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = new ViewGroup.MarginLayoutParams(-1, -2);
                    Resources resources = context.getResources();
                    int i15 = R.dimen.sns_margin_small;
                    marginLayoutParams3.topMargin = resources.getDimensionPixelSize(i15);
                    marginLayoutParams3.bottomMargin = context.getResources().getDimensionPixelSize(i15);
                    marginLayoutParams3.setMarginStart(i14);
                    marginLayoutParams3.setMarginEnd(i14);
                    Unit unit3 = Unit.f56620a;
                    linearLayout.addView(addView, marginLayoutParams3);
                }
            }
            ViewGroup viewGroup = (ViewGroup) view.findViewById(i11);
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
            }
            Object obj4 = map.get("actionTitle");
            if (obj4 instanceof String) {
                str = (String) obj4;
            }
            if (str != null && (button = (Button) view.findViewById(i12)) != null) {
                button.setText(str);
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.widget.TextView, android.view.View] */
    /* JADX WARNING: type inference failed for: r10v1, types: [com.sumsub.sns.core.widget.SNSBodyTextView] */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.sumsub.sns.core.widget.SNSSubtitle2TextView] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(android.content.Context r18, java.lang.CharSequence r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            boolean r2 = r0.f31098b
            if (r2 == 0) goto L_0x0017
            com.sumsub.sns.core.widget.SNSSubtitle2TextView r2 = new com.sumsub.sns.core.widget.SNSSubtitle2TextView
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r2
            r4 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L_0x0026
        L_0x0017:
            com.sumsub.sns.core.widget.SNSBodyTextView r2 = new com.sumsub.sns.core.widget.SNSBodyTextView
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            r10 = r2
            r11 = r18
            r10.<init>(r11, r12, r13, r14, r15, r16)
        L_0x0026:
            if (r1 == 0) goto L_0x002f
            com.sumsub.sns.internal.core.data.source.extensions.a r3 = r0.f31097a
            android.text.Spanned r1 = r3.a(r1)
            goto L_0x0030
        L_0x002f:
            r1 = 0
        L_0x0030:
            r2.setText(r1)
            android.content.res.Resources r1 = r18.getResources()
            int r3 = com.sumsub.sns.R.dimen.sns_margin_medium
            int r1 = r1.getDimensionPixelSize(r3)
            r3 = 0
            r2.setPadding(r1, r3, r1, r3)
            com.sumsub.sns.core.presentation.helper.a r1 = com.sumsub.sns.core.presentation.helper.a.f31095a
            com.sumsub.sns.internal.core.theme.d r3 = r1.a()
            if (r3 == 0) goto L_0x0051
            com.sumsub.sns.core.theme.SNSMetricElement r4 = com.sumsub.sns.core.theme.SNSMetricElement.SCREEN_HEADER_ALIGNMENT
            java.lang.String r3 = r1.c(r3, r4)
            if (r3 != 0) goto L_0x0057
        L_0x0051:
            com.sumsub.sns.core.theme.SNSThemeMetric$TextAlignment r3 = com.sumsub.sns.core.theme.SNSThemeMetric.TextAlignment.CENTER
            java.lang.String r3 = r3.getValue()
        L_0x0057:
            r1.a((android.widget.TextView) r2, (java.lang.String) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.intro.b.a(android.content.Context, java.lang.CharSequence):android.view.View");
    }
}
