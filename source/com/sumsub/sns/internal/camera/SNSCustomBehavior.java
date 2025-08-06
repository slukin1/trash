package com.sumsub.sns.internal.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d10.l;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R0\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\t\u0010\f\"\u0004\b\t\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/sumsub/sns/internal/camera/SNSCustomBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/ViewGroup;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "parent", "child", "", "layoutDirection", "", "a", "Lkotlin/Function1;", "Ld10/l;", "()Ld10/l;", "(Ld10/l;)V", "expandedOffsetCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSCustomBehavior extends BottomSheetBehavior<ViewGroup> {

    /* renamed from: a  reason: collision with root package name */
    public l<? super CoordinatorLayout, Integer> f31316a;

    public SNSCustomBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final l<CoordinatorLayout, Integer> a() {
        return this.f31316a;
    }

    public final void a(l<? super CoordinatorLayout, Integer> lVar) {
        this.f31316a = lVar;
    }

    /* renamed from: a */
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, int i11) {
        l<? super CoordinatorLayout, Integer> lVar = this.f31316a;
        int intValue = lVar != null ? lVar.invoke(coordinatorLayout).intValue() : 0;
        float height = ((((float) coordinatorLayout.getHeight()) - ((float) intValue)) / 2.0f) / ((float) coordinatorLayout.getHeight());
        if (intValue > coordinatorLayout.getHeight()) {
            return super.onLayoutChild(coordinatorLayout, viewGroup, i11);
        }
        setExpandedOffset(intValue);
        setHalfExpandedRatio(height);
        return super.onLayoutChild(coordinatorLayout, viewGroup, i11);
    }
}
