package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.h;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B=\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0007\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bB\u0010CJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0016\u0010%\u001a\u0004\u0018\u00010\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001aR(\u0010,\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&8F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010/\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&8F@FX\u000e¢\u0006\f\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R(\u00105\u001a\u0004\u0018\u0001002\b\u0010'\u001a\u0004\u0018\u0001008F@FX\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u00108\u001a\u0004\u0018\u0001002\b\u0010'\u001a\u0004\u0018\u0001008F@FX\u000e¢\u0006\f\u001a\u0004\b6\u00102\"\u0004\b7\u00104R(\u0010;\u001a\u0004\u0018\u0001002\b\u0010'\u001a\u0004\u0018\u0001008F@FX\u000e¢\u0006\f\u001a\u0004\b9\u00102\"\u0004\b:\u00104¨\u0006D"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSStepView;", "Lcom/google/android/material/card/MaterialCardView;", "Lcom/sumsub/sns/internal/core/widget/a;", "Lcom/sumsub/sns/core/theme/SNSMetricElement;", "cardStyle", "", "applyTheme", "", "extraSpace", "", "onCreateDrawableState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "getSNSStepState", "state", "setSNSStepState", "Landroid/content/res/ColorStateList;", "tintColor", "setIconTintColor", "getIconTintColor", "colorStateList", "setTitleTextColor", "setSubtitleTextColor", "stepState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "Landroid/widget/ImageView;", "getIconStartView", "()Landroid/widget/ImageView;", "iconStartView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "getTitlePlaceholderView", "titlePlaceholderView", "getSubtitleView", "subtitleView", "getIconEndView", "iconEndView", "Landroid/graphics/drawable/Drawable;", "value", "getIconStart", "()Landroid/graphics/drawable/Drawable;", "setIconStart", "(Landroid/graphics/drawable/Drawable;)V", "iconStart", "getIconEnd", "setIconEnd", "iconEnd", "", "getTitle", "()Ljava/lang/CharSequence;", "setTitle", "(Ljava/lang/CharSequence;)V", "title", "getPlaceholder", "setPlaceholder", "placeholder", "getSubtitle", "setSubtitle", "subtitle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/sumsub/sns/core/theme/SNSMetricElement;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public class SNSStepView extends MaterialCardView implements a {
    private SNSStepState stepState;

    public SNSStepView(Context context) {
        this(context, (AttributeSet) null, 0, 0, (SNSMetricElement) null, 30, (r) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = com.sumsub.sns.core.presentation.helper.a.f31095a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void applyTheme(com.sumsub.sns.core.theme.SNSMetricElement r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            com.sumsub.sns.core.presentation.helper.a r2 = com.sumsub.sns.core.presentation.helper.a.f31095a
            com.sumsub.sns.internal.core.theme.d r3 = r2.a()
            if (r3 != 0) goto L_0x0010
            return
        L_0x0010:
            int[][] r4 = r2.b()
            android.content.res.ColorStateList r5 = r18.getIconTintColor()
            r6 = -65281(0xffffffffffff00ff, float:NaN)
            if (r5 != 0) goto L_0x0021
            android.content.res.ColorStateList r5 = android.content.res.ColorStateList.valueOf(r6)
        L_0x0021:
            com.sumsub.sns.core.theme.SNSColorElement r7 = com.sumsub.sns.core.theme.SNSColorElement.CONTENT_WEAK
            java.lang.Integer r7 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r7)
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0030
            int r7 = r7.intValue()
            goto L_0x003a
        L_0x0030:
            int[] r7 = new int[r8]
            int r10 = com.sumsub.sns.R.attr.sns_stateInit
            r7[r9] = r10
            int r7 = r5.getColorForState(r7, r6)
        L_0x003a:
            boolean r10 = r2.a((android.view.View) r0)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            android.content.res.ColorStateList r7 = r2.a((boolean) r10, (java.lang.Integer) r7, (android.content.res.ColorStateList) r5)
            if (r7 == 0) goto L_0x004b
            r0.setIconTintColor(r7)
        L_0x004b:
            android.content.res.ColorStateList r10 = r18.getCardBackgroundColor()
            com.sumsub.sns.core.theme.SNSColorElement r11 = com.sumsub.sns.core.theme.SNSColorElement.BACKGROUND_NEUTRAL
            java.lang.Integer r12 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r11)
            if (r12 == 0) goto L_0x005c
            int r12 = r12.intValue()
            goto L_0x0066
        L_0x005c:
            int[] r12 = new int[r8]
            int r13 = com.sumsub.sns.R.attr.sns_stateInit
            r12[r9] = r13
            int r12 = r10.getColorForState(r12, r6)
        L_0x0066:
            com.sumsub.sns.core.theme.SNSColorElement r13 = com.sumsub.sns.core.theme.SNSColorElement.BACKGROUND_WARNING
            java.lang.Integer r14 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r13)
            if (r14 == 0) goto L_0x0073
            int r14 = r14.intValue()
            goto L_0x007d
        L_0x0073:
            int[] r14 = new int[r8]
            int r15 = com.sumsub.sns.R.attr.sns_statePending
            r14[r9] = r15
            int r14 = r10.getColorForState(r14, r6)
        L_0x007d:
            com.sumsub.sns.core.theme.SNSColorElement r15 = com.sumsub.sns.core.theme.SNSColorElement.BACKGROUND_SUCCESS
            java.lang.Integer r15 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r15)
            if (r15 == 0) goto L_0x008a
            int r15 = r15.intValue()
            goto L_0x0094
        L_0x008a:
            int[] r15 = new int[r8]
            int r16 = com.sumsub.sns.R.attr.sns_stateApproved
            r15[r9] = r16
            int r15 = r10.getColorForState(r15, r6)
        L_0x0094:
            com.sumsub.sns.core.theme.SNSColorElement r6 = com.sumsub.sns.core.theme.SNSColorElement.BACKGROUND_CRITICAL
            java.lang.Integer r6 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r6)
            if (r6 == 0) goto L_0x00a4
            int r6 = r6.intValue()
            r9 = -65281(0xffffffffffff00ff, float:NaN)
            goto L_0x00b1
        L_0x00a4:
            int[] r6 = new int[r8]
            int r17 = com.sumsub.sns.R.attr.sns_stateRejected
            r6[r9] = r17
            r9 = -65281(0xffffffffffff00ff, float:NaN)
            int r6 = r10.getColorForState(r6, r9)
        L_0x00b1:
            java.lang.Integer r13 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r13)
            if (r13 == 0) goto L_0x00be
            int r9 = r13.intValue()
            r17 = 0
            goto L_0x00ca
        L_0x00be:
            int[] r13 = new int[r8]
            int r16 = com.sumsub.sns.R.attr.sns_stateProcessing
            r17 = 0
            r13[r17] = r16
            int r9 = r10.getColorForState(r13, r9)
        L_0x00ca:
            java.lang.Integer r11 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r11)
            if (r11 == 0) goto L_0x00d5
            int r10 = r11.intValue()
            goto L_0x00d9
        L_0x00d5:
            int r10 = r10.getDefaultColor()
        L_0x00d9:
            r11 = 6
            int[] r11 = new int[r11]
            r11[r17] = r12
            r11[r8] = r14
            r12 = 2
            r11[r12] = r15
            r12 = 3
            r11[r12] = r6
            r6 = 4
            r11[r6] = r9
            r6 = 5
            r11[r6] = r10
            com.sumsub.sns.core.theme.SNSMetricElement r6 = com.sumsub.sns.core.theme.SNSMetricElement.CARD_CORNER_RADIUS
            java.lang.Float r6 = r2.a((com.sumsub.sns.internal.core.theme.d) r3, (com.sumsub.sns.core.theme.SNSMetricElement) r6)
            if (r6 == 0) goto L_0x00fb
            float r6 = r6.floatValue()
            r0.setRadius(r6)
        L_0x00fb:
            com.sumsub.sns.core.theme.SNSColorElement r6 = com.sumsub.sns.core.theme.SNSColorElement.CONTENT_STRONG
            java.lang.Integer r6 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r6)
            if (r6 == 0) goto L_0x0110
            int r6 = r6.intValue()
            android.widget.TextView r9 = r18.getTitleView()
            if (r9 == 0) goto L_0x0110
            r9.setTextColor(r6)
        L_0x0110:
            java.lang.String r1 = r2.c(r3, r1)
            com.sumsub.sns.core.theme.SNSThemeMetric$CardStyle r6 = com.sumsub.sns.core.theme.SNSThemeMetric.CardStyle.BORDERED
            java.lang.String r6 = r6.getValue()
            boolean r6 = kotlin.jvm.internal.x.b(r1, r6)
            r9 = 0
            if (r6 == 0) goto L_0x0172
            com.sumsub.sns.core.theme.SNSMetricElement r1 = com.sumsub.sns.core.theme.SNSMetricElement.CARD_BORDER_WIDTH
            java.lang.Float r1 = r2.a((com.sumsub.sns.internal.core.theme.d) r3, (com.sumsub.sns.core.theme.SNSMetricElement) r1)
            if (r1 == 0) goto L_0x012f
            float r1 = r1.floatValue()
            int r1 = (int) r1
            goto L_0x0133
        L_0x012f:
            int r1 = com.sumsub.sns.internal.core.common.i.a((int) r8)
        L_0x0133:
            r0.setStrokeWidth(r1)
            r0.setStrokeColor((android.content.res.ColorStateList) r7)
            com.sumsub.sns.core.theme.SNSColorElement r1 = com.sumsub.sns.core.theme.SNSColorElement.CARD_BORDERED_BACKGROUND
            java.lang.Integer r1 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r1)
            if (r1 == 0) goto L_0x0159
            int r1 = r1.intValue()
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            float r4 = r18.getRadius()
            r3.setCornerRadius(r4)
            r3.setColor(r1)
            r0.setBackground(r3)
            kotlin.Unit r9 = kotlin.Unit.f56620a
        L_0x0159:
            if (r9 != 0) goto L_0x015f
            r1 = 0
            r0.setBackgroundColor(r1)
        L_0x015f:
            android.widget.TextView r3 = r18.getSubtitleView()
            if (r3 == 0) goto L_0x01df
            r4 = 0
            r6 = 1
            r7 = 0
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            com.sumsub.sns.core.presentation.helper.a.a((com.sumsub.sns.core.presentation.helper.a) r1, (android.view.View) r2, (java.lang.Integer) r3, (android.content.res.ColorStateList) r4, (int) r5, (java.lang.Object) r6)
            goto L_0x01df
        L_0x0172:
            com.sumsub.sns.core.theme.SNSThemeMetric$CardStyle r3 = com.sumsub.sns.core.theme.SNSThemeMetric.CardStyle.PLAIN
            java.lang.String r3 = r3.getValue()
            boolean r1 = kotlin.jvm.internal.x.b(r1, r3)
            if (r1 == 0) goto L_0x01be
            r1 = 0
            r0.setStrokeWidth(r1)
            com.sumsub.sns.core.theme.SNSColorElement r1 = com.sumsub.sns.core.theme.SNSColorElement.CARD_PLAIN_BACKGROUND
            java.lang.Integer r1 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r1)
            if (r1 == 0) goto L_0x01a2
            int r1 = r1.intValue()
            android.graphics.drawable.GradientDrawable r3 = new android.graphics.drawable.GradientDrawable
            r3.<init>()
            float r4 = r18.getRadius()
            r3.setCornerRadius(r4)
            r3.setColor(r1)
            r0.setBackground(r3)
            kotlin.Unit r9 = kotlin.Unit.f56620a
        L_0x01a2:
            if (r9 != 0) goto L_0x01a8
            r1 = 0
            r0.setBackgroundColor(r1)
        L_0x01a8:
            com.sumsub.sns.core.theme.SNSColorElement r1 = com.sumsub.sns.core.theme.SNSColorElement.CONTENT_NEUTRAL
            java.lang.Integer r1 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r1)
            if (r1 == 0) goto L_0x01df
            int r1 = r1.intValue()
            android.widget.TextView r2 = r18.getSubtitleView()
            if (r2 == 0) goto L_0x01df
            r2.setTextColor(r1)
            goto L_0x01df
        L_0x01be:
            r1 = 0
            r0.setStrokeWidth(r1)
            android.content.res.ColorStateList r1 = new android.content.res.ColorStateList
            r1.<init>(r4, r11)
            r0.setCardBackgroundColor((android.content.res.ColorStateList) r1)
            com.sumsub.sns.core.theme.SNSColorElement r1 = com.sumsub.sns.core.theme.SNSColorElement.CONTENT_NEUTRAL
            java.lang.Integer r1 = r2.a((android.view.View) r0, (com.sumsub.sns.core.theme.SNSColorElement) r1)
            if (r1 == 0) goto L_0x01df
            int r1 = r1.intValue()
            android.widget.TextView r2 = r18.getSubtitleView()
            if (r2 == 0) goto L_0x01df
            r2.setTextColor(r1)
        L_0x01df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.SNSStepView.applyTheme(com.sumsub.sns.core.theme.SNSMetricElement):void");
    }

    private final ImageView getIconStartView() {
        return (ImageView) findViewById(R.id.sns_item_start_icon);
    }

    private final TextView getSubtitleView() {
        return (TextView) findViewById(R.id.sns_item_subtitle);
    }

    private final TextView getTitlePlaceholderView() {
        return (TextView) findViewById(R.id.sns_item_title_placeholder);
    }

    private final TextView getTitleView() {
        return (TextView) findViewById(R.id.sns_item_title);
    }

    public final Drawable getIconEnd() {
        ImageView iconEndView = getIconEndView();
        if (iconEndView != null) {
            return iconEndView.getDrawable();
        }
        return null;
    }

    public final ImageView getIconEndView() {
        return (ImageView) findViewById(R.id.sns_item_end_icon);
    }

    public final Drawable getIconStart() {
        ImageView iconStartView = getIconStartView();
        if (iconStartView != null) {
            return iconStartView.getDrawable();
        }
        return null;
    }

    public ColorStateList getIconTintColor() {
        ImageView iconStartView = getIconStartView();
        if (iconStartView != null) {
            return iconStartView.getImageTintList();
        }
        return null;
    }

    public final CharSequence getPlaceholder() {
        TextView titlePlaceholderView = getTitlePlaceholderView();
        if (titlePlaceholderView != null) {
            return titlePlaceholderView.getText();
        }
        return null;
    }

    public SNSStepState getSNSStepState() {
        SNSStepState sNSStepState = this.stepState;
        return sNSStepState == null ? SNSStepState.INIT : sNSStepState;
    }

    public final CharSequence getSubtitle() {
        TextView subtitleView = getSubtitleView();
        if (subtitleView != null) {
            return subtitleView.getText();
        }
        return null;
    }

    public final CharSequence getTitle() {
        TextView titleView = getTitleView();
        if (titleView != null) {
            return titleView.getText();
        }
        return null;
    }

    public int[] onCreateDrawableState(int i11) {
        return View.mergeDrawableStates(super.onCreateDrawableState(i11 + 1), this.stepState != null ? SNSStepViewExtensionsKt.getSnsStepStateDrawable(this) : new int[]{R.attr.sns_stateInit});
    }

    public final void setIconEnd(Drawable drawable) {
        ImageView iconEndView = getIconEndView();
        if (iconEndView != null) {
            iconEndView.setImageDrawable(drawable);
        }
        ImageView iconEndView2 = getIconEndView();
        if (iconEndView2 != null) {
            iconEndView2.setVisibility(drawable == null ? 8 : 0);
        }
    }

    public final void setIconStart(Drawable drawable) {
        ImageView iconStartView = getIconStartView();
        if (iconStartView != null) {
            iconStartView.setImageDrawable(drawable);
        }
        ImageView iconStartView2 = getIconStartView();
        if (iconStartView2 != null) {
            iconStartView2.setVisibility(drawable == null ? 8 : 0);
        }
    }

    public void setIconTintColor(ColorStateList colorStateList) {
        ImageView iconStartView = getIconStartView();
        if (iconStartView != null) {
            h.c(iconStartView, colorStateList);
        }
        ImageView iconEndView = getIconEndView();
        if (iconEndView != null) {
            h.c(iconEndView, colorStateList);
        }
    }

    public final void setPlaceholder(CharSequence charSequence) {
        TextView titlePlaceholderView = getTitlePlaceholderView();
        if (titlePlaceholderView != null) {
            titlePlaceholderView.setText(charSequence);
        }
        TextView titlePlaceholderView2 = getTitlePlaceholderView();
        if (titlePlaceholderView2 != null) {
            CharSequence title = getTitle();
            i.a((View) titlePlaceholderView2, !(title == null || title.length() == 0));
        }
    }

    public void setSNSStepState(SNSStepState sNSStepState) {
        if (sNSStepState != this.stepState) {
            this.stepState = sNSStepState;
            refreshDrawableState();
            TextView titleView = getTitleView();
            if (titleView != null) {
                SNSStepViewExtensionsKt.setSnsStepState(titleView, sNSStepState);
            }
            TextView subtitleView = getSubtitleView();
            if (subtitleView != null) {
                SNSStepViewExtensionsKt.setSnsStepState(subtitleView, sNSStepState);
            }
            ImageView iconStartView = getIconStartView();
            if (iconStartView != null) {
                SNSStepViewExtensionsKt.setSnsStepState(iconStartView, sNSStepState);
            }
            ImageView iconEndView = getIconEndView();
            if (iconEndView != null) {
                SNSStepViewExtensionsKt.setSnsStepState(iconEndView, sNSStepState);
            }
        }
    }

    public final void setSubtitle(CharSequence charSequence) {
        TextView subtitleView = getSubtitleView();
        if (subtitleView != null) {
            subtitleView.setText(charSequence);
        }
        TextView subtitleView2 = getSubtitleView();
        if (subtitleView2 != null) {
            subtitleView2.setVisibility(charSequence == null ? 8 : 0);
        }
    }

    public final void setSubtitleTextColor(ColorStateList colorStateList) {
        TextView subtitleView = getSubtitleView();
        if (subtitleView != null) {
            subtitleView.setTextColor(colorStateList);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        TextView titleView = getTitleView();
        if (titleView != null) {
            titleView.setText(charSequence);
        }
        TextView titleView2 = getTitleView();
        boolean z11 = false;
        if (titleView2 != null) {
            titleView2.setVisibility((charSequence == null || charSequence.length() == 0) ^ true ? 0 : 8);
        }
        TextView titlePlaceholderView = getTitlePlaceholderView();
        if (titlePlaceholderView != null) {
            if (charSequence == null || charSequence.length() == 0) {
                z11 = true;
            }
            i.a((View) titlePlaceholderView, !z11);
        }
    }

    public final void setTitleTextColor(ColorStateList colorStateList) {
        TextView titleView = getTitleView();
        if (titleView != null) {
            titleView.setTextColor(colorStateList);
        }
    }

    public SNSStepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, (SNSMetricElement) null, 28, (r) null);
    }

    public SNSStepView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, (SNSMetricElement) null, 24, (r) null);
    }

    public SNSStepView(Context context, AttributeSet attributeSet, int i11, int i12) {
        this(context, attributeSet, i11, i12, (SNSMetricElement) null, 16, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSStepView(Context context, AttributeSet attributeSet, int i11, int i12, SNSMetricElement sNSMetricElement, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_StepViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSStepView : i12, (i13 & 16) != 0 ? SNSMetricElement.VERIFICATION_STEP_CARD_STYLE : sNSMetricElement);
    }

    public SNSStepView(Context context, AttributeSet attributeSet, int i11, int i12, SNSMetricElement sNSMetricElement) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i11, i12), attributeSet, i11);
        this.stepState = SNSStepState.INIT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSStepView, i11, i12);
        int i13 = R.styleable.SNSStepView_sns_stepBackgroundColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            setCardBackgroundColor(i.a(obtainStyledAttributes, context, i13));
        }
        int i14 = R.styleable.SNSStepView_sns_stepStrokeColor;
        if (obtainStyledAttributes.hasValue(i14)) {
            setStrokeColor(i.a(obtainStyledAttributes, context, i14));
        }
        setStrokeWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.SNSStepView_sns_stepStrokeWidth, 0));
        int i15 = R.styleable.SNSStepView_elevation;
        if (obtainStyledAttributes.hasValue(i15)) {
            setCardElevation(obtainStyledAttributes.getDimension(i15, 0.0f));
        }
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context, attributeSet, i11, i12).build());
        LayoutInflater.from(context).inflate(obtainStyledAttributes.getResourceId(R.styleable.SNSStepView_sns_stepViewLayout, 0), this, true);
        int i16 = R.styleable.SNSStepView_sns_stepIconTintColor;
        if (obtainStyledAttributes.hasValue(i16)) {
            setIconTintColor(i.a(obtainStyledAttributes, context, i16));
        }
        int i17 = R.styleable.SNSStepView_sns_stepTitleTextColor;
        if (obtainStyledAttributes.hasValue(i17)) {
            setTitleTextColor(i.a(obtainStyledAttributes, context, i17));
        }
        int i18 = R.styleable.SNSStepView_sns_stepSubtitleTextColor;
        if (obtainStyledAttributes.hasValue(i18)) {
            setSubtitleTextColor(i.a(obtainStyledAttributes, context, i18));
        }
        setIconStart(obtainStyledAttributes.getDrawable(R.styleable.SNSStepView_sns_iconStart));
        setIconEnd(obtainStyledAttributes.getDrawable(R.styleable.SNSStepView_sns_iconEnd));
        setTitle(obtainStyledAttributes.getText(R.styleable.SNSStepView_sns_title));
        setSubtitle(obtainStyledAttributes.getText(R.styleable.SNSStepView_sns_subtitle));
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        applyTheme(sNSMetricElement);
    }
}
