package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import d10.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0016JN\u0010 \u001a\u00020\u001e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010#R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSErrorBottomSheetView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundDrawable", "Landroid/graphics/drawable/ColorDrawable;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "bottomSheet", "value", "", "dismissOnTouchOutside", "getDismissOnTouchOutside", "()Z", "setDismissOnTouchOutside", "(Z)V", "primaryButton", "Landroid/widget/Button;", "secondaryButton", "showCallback", "Ljava/lang/Runnable;", "text", "Landroid/widget/TextView;", "hide", "", "onDetachedFromWindow", "show", "", "onPrimaryButtonClicked", "Lkotlin/Function0;", "onSecondaryButtonClicked", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSErrorBottomSheetView extends CoordinatorLayout {
    public static final Companion Companion = new Companion((r) null);
    private static final int SHADOW_MAX_ALPHA = 128;
    private static final long SHOW_DELAY = 250;
    /* access modifiers changed from: private */
    public final ColorDrawable backgroundDrawable;
    /* access modifiers changed from: private */
    public BottomSheetBehavior<View> behavior;
    private final View bottomSheet;
    private boolean dismissOnTouchOutside;
    private final Button primaryButton;
    private final Button secondaryButton;
    private final Runnable showCallback;
    private final TextView text;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSErrorBottomSheetView$Companion;", "", "()V", "SHADOW_MAX_ALPHA", "", "SHOW_DELAY", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    public SNSErrorBottomSheetView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_dismissOnTouchOutside_$lambda-0  reason: not valid java name */
    public static final void m25_set_dismissOnTouchOutside_$lambda0(boolean z11, SNSErrorBottomSheetView sNSErrorBottomSheetView, View view) {
        if (z11) {
            sNSErrorBottomSheetView.hide();
        }
    }

    public static /* synthetic */ void show$default(SNSErrorBottomSheetView sNSErrorBottomSheetView, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a aVar, a aVar2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = null;
        }
        if ((i11 & 2) != 0) {
            charSequence2 = null;
        }
        if ((i11 & 4) != 0) {
            charSequence3 = null;
        }
        if ((i11 & 8) != 0) {
            aVar = null;
        }
        if ((i11 & 16) != 0) {
            aVar2 = null;
        }
        sNSErrorBottomSheetView.show(charSequence, charSequence2, charSequence3, aVar, aVar2);
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-6  reason: not valid java name */
    public static final void m26show$lambda6(a aVar, SNSErrorBottomSheetView sNSErrorBottomSheetView, View view) {
        if (aVar != null) {
            aVar.invoke();
        }
        sNSErrorBottomSheetView.hide();
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-7  reason: not valid java name */
    public static final void m27show$lambda7(a aVar, SNSErrorBottomSheetView sNSErrorBottomSheetView, View view) {
        if (aVar != null) {
            aVar.invoke();
        }
        sNSErrorBottomSheetView.hide();
    }

    /* access modifiers changed from: private */
    /* renamed from: showCallback$lambda-1  reason: not valid java name */
    public static final void m28showCallback$lambda1(SNSErrorBottomSheetView sNSErrorBottomSheetView) {
        BottomSheetBehavior<View> bottomSheetBehavior = sNSErrorBottomSheetView.behavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public final boolean getDismissOnTouchOutside() {
        return this.dismissOnTouchOutside;
    }

    public final void hide() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(5);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.showCallback);
    }

    public final void setDismissOnTouchOutside(boolean z11) {
        this.dismissOnTouchOutside = z11;
        setOnClickListener(new m(z11, this));
    }

    public final void show(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, a<Unit> aVar, a<Unit> aVar2) {
        TextView textView = this.text;
        if (textView != null) {
            i.a(textView, charSequence);
        }
        Button button = this.primaryButton;
        if (button != null) {
            i.a((TextView) button, charSequence2);
        }
        Button button2 = this.secondaryButton;
        if (button2 != null) {
            i.a((TextView) button2, charSequence3);
        }
        Button button3 = this.primaryButton;
        if (button3 != null) {
            button3.setOnClickListener(new k(aVar, this));
        }
        Button button4 = this.secondaryButton;
        if (button4 != null) {
            button4.setOnClickListener(new l(aVar2, this));
        }
        setVisibility(0);
        postDelayed(this.showCallback, 250);
    }

    public SNSErrorBottomSheetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSErrorBottomSheetView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_BottomSheetViewStyle : i11);
    }

    public SNSErrorBottomSheetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ColorDrawable colorDrawable = new ColorDrawable(context.getResources().getColor(17170444));
        this.backgroundDrawable = colorDrawable;
        this.dismissOnTouchOutside = true;
        this.showCallback = new n(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.sns_layout_error_bottom_sheet, this, true);
        View findViewById = inflate.findViewById(R.id.sns_bottom_sheet);
        this.bottomSheet = findViewById;
        this.text = (TextView) inflate.findViewById(R.id.sns_text);
        this.primaryButton = (Button) inflate.findViewById(R.id.sns_primary_button);
        this.secondaryButton = (Button) inflate.findViewById(R.id.sns_secondary_button);
        ((ImageView) inflate.findViewById(R.id.sns_start_icon)).setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(context, SNSIconHandler.SNSCommonIcons.WARNING_OUTLINE.getImageName()));
        colorDrawable.setAlpha(0);
        setBackground(colorDrawable);
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(findViewById);
        from.setHideable(true);
        from.setDraggable(true);
        from.setSkipCollapsed(true);
        from.addBottomSheetCallback(new SNSErrorBottomSheetView$3$1(this));
        this.behavior = from;
        setDismissOnTouchOutside(true);
        if (h0.Z(this)) {
            BottomSheetBehavior access$getBehavior$p = this.behavior;
            if (access$getBehavior$p != null) {
                access$getBehavior$p.setState(5);
            }
            setVisibility(8);
            return;
        }
        addOnAttachStateChangeListener(new SNSErrorBottomSheetView$special$$inlined$doOnAttach$1(this, this));
    }
}
