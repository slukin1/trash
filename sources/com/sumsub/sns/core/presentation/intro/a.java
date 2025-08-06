package com.sumsub.sns.core.presentation.intro;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import com.sumsub.sns.core.widget.SNSBodyTextView;
import com.sumsub.sns.core.widget.SNSH2TextView;
import com.sumsub.sns.core.widget.SNSImageView;
import com.sumsub.sns.core.widget.SNSIntroItemView;
import com.sumsub.sns.core.widget.SNSListItemView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.theme.d;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f31096a;

    public a(com.sumsub.sns.internal.core.data.source.extensions.a aVar) {
        this.f31096a = aVar;
    }

    public final View a(Context context, String str) {
        SNSImageView sNSImageView = new SNSImageView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSImageView.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(context, str));
        return sNSImageView;
    }

    public final View b(Context context, CharSequence charSequence) {
        SNSBodyTextView sNSBodyTextView = new SNSBodyTextView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSBodyTextView.setText(charSequence != null ? this.f31096a.a(charSequence) : null);
        return sNSBodyTextView;
    }

    public final View c(Context context, String str, CharSequence charSequence, CharSequence charSequence2) {
        String str2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        SNSImageView sNSImageView = new SNSImageView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        sNSImageView.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(context, str));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.sns_icon_size_huge));
        marginLayoutParams.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium_small);
        Unit unit = Unit.f56620a;
        linearLayout.addView(sNSImageView, marginLayoutParams);
        SNSH2TextView sNSH2TextView = new SNSH2TextView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        Spanned spanned = null;
        sNSH2TextView.setText(charSequence != null ? this.f31096a.a(charSequence) : null);
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        d a11 = aVar.a();
        if (a11 == null || (str2 = aVar.c(a11, SNSMetricElement.SCREEN_HEADER_ALIGNMENT)) == null) {
            str2 = SNSThemeMetric.TextAlignment.CENTER.getValue();
        }
        aVar.a((TextView) sNSH2TextView, str2);
        ViewGroup.MarginLayoutParams a12 = a();
        a12.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
        linearLayout.addView(sNSH2TextView, a12);
        SNSBodyTextView sNSBodyTextView = new SNSBodyTextView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        if (charSequence2 != null) {
            spanned = this.f31096a.a(charSequence2);
        }
        sNSBodyTextView.setText(spanned);
        ViewGroup.MarginLayoutParams a13 = a();
        Resources resources = context.getResources();
        int i11 = R.dimen.sns_margin_small_tiny;
        a13.topMargin = resources.getDimensionPixelSize(i11);
        a13.bottomMargin = context.getResources().getDimensionPixelSize(i11);
        linearLayout.addView(sNSBodyTextView, a13);
        return linearLayout;
    }

    public final View a(Context context, CharSequence charSequence) {
        String str;
        SNSH2TextView sNSH2TextView = new SNSH2TextView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSH2TextView.setText(charSequence != null ? this.f31096a.a(charSequence) : null);
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        d a11 = aVar.a();
        if (a11 == null || (str = aVar.c(a11, SNSMetricElement.SCREEN_HEADER_ALIGNMENT)) == null) {
            str = SNSThemeMetric.TextAlignment.CENTER.getValue();
        }
        aVar.a((TextView) sNSH2TextView, str);
        return sNSH2TextView;
    }

    public final View b(Context context, String str, CharSequence charSequence, CharSequence charSequence2) {
        return a(context, str, charSequence, charSequence2, SNSStepState.REJECTED);
    }

    public final View b(Context context, List<? extends Map<String, ?>> list) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ArrayList<Map> arrayList = new ArrayList<>();
        for (T next : list) {
            if (next instanceof Map) {
                arrayList.add(next);
            }
        }
        for (Map map : arrayList) {
            SNSListItemView sNSListItemView = new SNSListItemView(context, (AttributeSet) null, 0, 0, 14, (r) null);
            SNSIconHandler iconHandler = e0.f32018a.getIconHandler();
            String str = (String) map.get("image");
            if (str == null) {
                str = "";
            }
            sNSListItemView.setIconStart(iconHandler.onResolveIcon(context, str));
            String str2 = (String) map.get("title");
            Spanned spanned = null;
            sNSListItemView.setTitle(str2 != null ? this.f31096a.a(str2) : null);
            String str3 = (String) map.get(MessengerShareContentUtility.SUBTITLE);
            if (str3 != null) {
                spanned = this.f31096a.a(str3);
            }
            sNSListItemView.setSubtitle(spanned);
            linearLayout.addView(sNSListItemView, a());
        }
        return linearLayout;
    }

    public final View a(Context context, String str, CharSequence charSequence, CharSequence charSequence2) {
        return a(context, str, charSequence, charSequence2, SNSStepState.APPROVED);
    }

    public final View a(Context context, String str, CharSequence charSequence, CharSequence charSequence2, SNSStepState sNSStepState) {
        SNSIntroItemView sNSIntroItemView = new SNSIntroItemView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        Spanned spanned = null;
        sNSIntroItemView.setTitle(charSequence != null ? this.f31096a.a(charSequence) : null);
        if (charSequence2 != null) {
            spanned = this.f31096a.a(charSequence2);
        }
        sNSIntroItemView.setSubtitle(spanned);
        sNSIntroItemView.setIconStart(e0.f32018a.getIconHandler().onResolveIcon(context, str));
        SNSStepViewExtensionsKt.setSnsStepState(sNSIntroItemView, sNSStepState);
        return sNSIntroItemView;
    }

    public final ViewGroup.MarginLayoutParams a() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r6v2, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v4, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v8, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v12, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v16, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v19, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r6v24, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.view.View> a(android.content.Context r10, java.util.List<?> r11) {
        /*
            r9 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x0009:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x001b
            java.lang.Object r1 = r11.next()
            boolean r2 = r1 instanceof java.util.Map
            if (r2 == 0) goto L_0x0009
            r0.add(r1)
            goto L_0x0009
        L_0x001b:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0024:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0176
            java.lang.Object r1 = r0.next()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = "type"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r3 = "image"
            boolean r4 = kotlin.jvm.internal.x.b(r2, r3)
            java.lang.String r5 = ""
            r6 = 0
            if (r4 == 0) goto L_0x0056
            java.lang.Object r1 = r1.get(r3)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x004c
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x004c:
            if (r6 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r5 = r6
        L_0x0050:
            android.view.View r6 = r9.a((android.content.Context) r10, (java.lang.String) r5)
            goto L_0x016f
        L_0x0056:
            java.lang.String r4 = "header"
            boolean r7 = kotlin.jvm.internal.x.b(r2, r4)
            java.lang.String r8 = "text"
            if (r7 == 0) goto L_0x0085
            java.lang.Object r2 = r1.get(r4)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x006b
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x006c
        L_0x006b:
            r2 = r6
        L_0x006c:
            if (r2 != 0) goto L_0x007e
            java.lang.Object r1 = r1.get(r8)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0079
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x0079:
            if (r6 != 0) goto L_0x007c
            goto L_0x007f
        L_0x007c:
            r5 = r6
            goto L_0x007f
        L_0x007e:
            r5 = r2
        L_0x007f:
            android.view.View r6 = r9.a((android.content.Context) r10, (java.lang.CharSequence) r5)
            goto L_0x016f
        L_0x0085:
            boolean r7 = kotlin.jvm.internal.x.b(r2, r8)
            if (r7 == 0) goto L_0x009c
            java.lang.Object r1 = r1.get(r8)
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0096
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x0096:
            android.view.View r6 = r9.b((android.content.Context) r10, (java.lang.CharSequence) r6)
            goto L_0x016f
        L_0x009c:
            java.lang.String r7 = "single"
            boolean r7 = kotlin.jvm.internal.x.b(r2, r7)
            if (r7 == 0) goto L_0x00d1
            java.lang.Object r2 = r1.get(r3)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x00af
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00b0
        L_0x00af:
            r2 = r6
        L_0x00b0:
            if (r2 != 0) goto L_0x00b3
            goto L_0x00b4
        L_0x00b3:
            r5 = r2
        L_0x00b4:
            java.lang.Object r2 = r1.get(r4)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x00bf
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00c0
        L_0x00bf:
            r2 = r6
        L_0x00c0:
            java.lang.Object r1 = r1.get(r8)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x00cb
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x00cb:
            android.view.View r6 = r9.c(r10, r5, r2, r6)
            goto L_0x016f
        L_0x00d1:
            java.lang.String r7 = "do"
            boolean r7 = kotlin.jvm.internal.x.b(r2, r7)
            if (r7 == 0) goto L_0x0106
            java.lang.Object r2 = r1.get(r3)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x00e4
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00e5
        L_0x00e4:
            r2 = r6
        L_0x00e5:
            if (r2 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r5 = r2
        L_0x00e9:
            java.lang.Object r2 = r1.get(r4)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x00f4
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00f5
        L_0x00f4:
            r2 = r6
        L_0x00f5:
            java.lang.Object r1 = r1.get(r8)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0100
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x0100:
            android.view.View r6 = r9.a(r10, r5, r2, r6)
            goto L_0x016f
        L_0x0106:
            java.lang.String r7 = "dont"
            boolean r7 = kotlin.jvm.internal.x.b(r2, r7)
            if (r7 == 0) goto L_0x013a
            java.lang.Object r2 = r1.get(r3)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0119
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x011a
        L_0x0119:
            r2 = r6
        L_0x011a:
            if (r2 != 0) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r5 = r2
        L_0x011e:
            java.lang.Object r2 = r1.get(r4)
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x0129
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x012a
        L_0x0129:
            r2 = r6
        L_0x012a:
            java.lang.Object r1 = r1.get(r8)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0135
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        L_0x0135:
            android.view.View r6 = r9.b(r10, r5, r2, r6)
            goto L_0x016f
        L_0x013a:
            java.lang.String r3 = "listItems"
            boolean r2 = kotlin.jvm.internal.x.b(r2, r3)
            if (r2 == 0) goto L_0x016f
            java.lang.Object r1 = r1.get(r3)
            boolean r2 = r1 instanceof java.util.List
            if (r2 == 0) goto L_0x014d
            java.util.List r1 = (java.util.List) r1
            goto L_0x014e
        L_0x014d:
            r1 = r6
        L_0x014e:
            if (r1 == 0) goto L_0x016f
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0159:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x016b
            java.lang.Object r3 = r1.next()
            boolean r4 = r3 instanceof java.util.Map
            if (r4 == 0) goto L_0x0159
            r2.add(r3)
            goto L_0x0159
        L_0x016b:
            android.view.View r6 = r9.b((android.content.Context) r10, (java.util.List<? extends java.util.Map<java.lang.String, ?>>) r2)
        L_0x016f:
            if (r6 == 0) goto L_0x0024
            r11.add(r6)
            goto L_0x0024
        L_0x0176:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.intro.a.a(android.content.Context, java.util.List):java.util.List");
    }
}
