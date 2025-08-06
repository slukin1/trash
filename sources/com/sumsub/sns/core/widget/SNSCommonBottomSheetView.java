package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\r2\b\b\u0001\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0006\u0010 \u001a\u00020\u001bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/sumsub/sns/core/widget/SNSCommonBottomSheetView;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backgroundDrawable", "Landroid/graphics/drawable/ColorDrawable;", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "bottomSheet", "content", "Landroid/view/ViewGroup;", "value", "", "dismissOnTouchOutside", "getDismissOnTouchOutside", "()Z", "setDismissOnTouchOutside", "(Z)V", "showCallback", "Ljava/lang/Runnable;", "hide", "", "inflate", "layout", "isHidden", "onDetachedFromWindow", "show", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSCommonBottomSheetView extends CoordinatorLayout {
    public static final Companion Companion = new Companion((r) null);
    private static final int SHADOW_MAX_ALPHA = 128;
    private static final long SHOW_DELAY = 250;
    /* access modifiers changed from: private */
    public final ColorDrawable backgroundDrawable;
    /* access modifiers changed from: private */
    public BottomSheetBehavior<View> behavior;
    private final View bottomSheet;
    private final ViewGroup content;
    private boolean dismissOnTouchOutside;
    private final Runnable showCallback;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSCommonBottomSheetView$Companion;", "", "()V", "SHADOW_MAX_ALPHA", "", "SHOW_DELAY", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    public SNSCommonBottomSheetView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: _set_dismissOnTouchOutside_$lambda-0  reason: not valid java name */
    public static final void m16_set_dismissOnTouchOutside_$lambda0(boolean z11, SNSCommonBottomSheetView sNSCommonBottomSheetView, View view) {
        if (z11) {
            sNSCommonBottomSheetView.hide();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCallback$lambda-1  reason: not valid java name */
    public static final void m17showCallback$lambda1(SNSCommonBottomSheetView sNSCommonBottomSheetView) {
        BottomSheetBehavior<View> bottomSheetBehavior = sNSCommonBottomSheetView.behavior;
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

    public final View inflate(int i11) {
        ViewGroup viewGroup = this.content;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        return LayoutInflater.from(getContext()).inflate(i11, this.content, true);
    }

    public final boolean isHidden() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.behavior;
        return bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.showCallback);
    }

    public final void setDismissOnTouchOutside(boolean z11) {
        this.dismissOnTouchOutside = z11;
        setOnClickListener(new b(z11, this));
    }

    public final void show() {
        setVisibility(0);
        postDelayed(this.showCallback, 250);
    }

    public SNSCommonBottomSheetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCommonBottomSheetView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_BottomSheetViewStyle : i11);
    }

    public SNSCommonBottomSheetView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ColorDrawable colorDrawable = new ColorDrawable(context.getResources().getColor(17170444));
        this.backgroundDrawable = colorDrawable;
        this.dismissOnTouchOutside = true;
        this.showCallback = new c(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.sns_layout_common_bottom_sheet, this, true);
        View findViewById = inflate.findViewById(R.id.sns_bottom_sheet);
        this.bottomSheet = findViewById;
        this.content = (ViewGroup) inflate.findViewById(R.id.sns_content);
        colorDrawable.setAlpha(0);
        setBackground(colorDrawable);
        BottomSheetBehavior<View> from = BottomSheetBehavior.from(findViewById);
        from.setHideable(true);
        from.setDraggable(true);
        from.setSkipCollapsed(true);
        from.addBottomSheetCallback(new SNSCommonBottomSheetView$3$1(this));
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
        addOnAttachStateChangeListener(new SNSCommonBottomSheetView$special$$inlined$doOnAttach$1(this, this));
    }
}
