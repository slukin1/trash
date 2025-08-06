package com.sumsub.sns.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.e;
import androidx.core.widget.l;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.c;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u00015\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0002STB1\b\u0007\u0012\u0006\u0010L\u001a\u00020K\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010M\u0012\b\b\u0002\u0010O\u001a\u00020\n\u0012\b\b\u0002\u0010P\u001a\u00020\n¢\u0006\u0004\bQ\u0010RJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0017J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J*\u0010\u001c\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J*\u0010 \u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u0014\u0010\"\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010(R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u0010(R\u0016\u00102\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u0010(R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bB\u0010(\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u0010J\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\bH\u0010D\"\u0004\bI\u0010F¨\u0006U"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView;", "Landroid/widget/LinearLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "", "x", "", "performTapSelection", "", "", "items", "", "selectedIndex", "", "setItems", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/graphics/Canvas;", "canvas", "onDraw", "e", "onDown", "onShowPress", "onSingleTapUp", "e1", "e2", "distanceX", "distanceY", "onScroll", "onLongPress", "velocityX", "velocityY", "onFling", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "shapeAppearance", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "selectedItemBackground", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "textAppearance", "I", "Landroidx/core/view/e;", "gestureDetector", "Landroidx/core/view/e;", "selected", "F", "isScrolling", "Z", "saveCurrentSelected", "textColor", "selectedTextColor", "segments", "Ljava/util/List;", "com/sumsub/sns/core/widget/SNSSegmentedToggleView$selectedPropertyHolder$1", "selectedPropertyHolder", "Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$selectedPropertyHolder$1;", "Landroidx/dynamicanimation/animation/c;", "animator", "Landroidx/dynamicanimation/animation/c;", "Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$OnItemSelected;", "onItemSelected", "Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$OnItemSelected;", "getOnItemSelected", "()Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$OnItemSelected;", "setOnItemSelected", "(Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$OnItemSelected;)V", "itemPadding", "getItemPadding", "()I", "setItemPadding", "(I)V", "value", "getSelectedItem", "setSelectedItem", "selectedItem", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnItemSelected", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSSegmentedToggleView extends LinearLayout implements GestureDetector.OnGestureListener {
    @Deprecated
    private static final float ANIMATION_MULTIPLIER = 1000.0f;
    private static final Companion Companion = new Companion((r) null);
    @Deprecated
    private static final int[] STATE_SELECTED = {16842913};
    private final c animator;
    private final e gestureDetector;
    private boolean isScrolling;
    private int itemPadding;
    private OnItemSelected onItemSelected;
    private int saveCurrentSelected;
    private List<String> segments;
    /* access modifiers changed from: private */
    public float selected;
    private final MaterialShapeDrawable selectedItemBackground;
    private final SNSSegmentedToggleView$selectedPropertyHolder$1 selectedPropertyHolder;
    private int selectedTextColor;
    private final ShapeAppearanceModel shapeAppearance;
    private int textAppearance;
    private int textColor;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$Companion;", "", "()V", "ANIMATION_MULTIPLIER", "", "STATE_SELECTED", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSSegmentedToggleView$OnItemSelected;", "", "onSelected", "", "index", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnItemSelected {
        void onSelected(int i11);
    }

    public SNSSegmentedToggleView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: animator$lambda-2$lambda-1  reason: not valid java name */
    public static final void m35animator$lambda2$lambda1(SNSSegmentedToggleView sNSSegmentedToggleView, b bVar, boolean z11, float f11, float f12) {
        sNSSegmentedToggleView.performClick();
        OnItemSelected onItemSelected2 = sNSSegmentedToggleView.onItemSelected;
        if (onItemSelected2 != null) {
            onItemSelected2.onSelected(sNSSegmentedToggleView.getSelectedItem());
        }
        int i11 = 0;
        for (View next : ViewGroupKt.a(sNSSegmentedToggleView)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            View view = next;
            TextView textView = view instanceof TextView ? (TextView) view : null;
            if (textView != null) {
                textView.setTextColor(i11 == sNSSegmentedToggleView.getSelectedItem() ? sNSSegmentedToggleView.selectedTextColor : sNSSegmentedToggleView.textColor);
            }
            i11 = i12;
        }
    }

    private final boolean performTapSelection(float f11) {
        int i11 = 0;
        for (View next : ViewGroupKt.a(this)) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            View view = next;
            if (((float) view.getLeft()) >= f11 || ((float) view.getRight()) <= f11 || getSelectedItem() == i11) {
                i11 = i12;
            } else {
                this.animator.p(((float) i11) * ANIMATION_MULTIPLIER);
                return true;
            }
        }
        return false;
    }

    public final int getItemPadding() {
        return this.itemPadding;
    }

    public final OnItemSelected getOnItemSelected() {
        return this.onItemSelected;
    }

    public final int getSelectedItem() {
        return (int) this.selected;
    }

    public boolean onDown(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        return true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getSelectedItem() > -1 && getSelectedItem() < getChildCount()) {
            ArgbEvaluatorCompat instance = ArgbEvaluatorCompat.getInstance();
            Integer valueOf = Integer.valueOf((int) this.selected);
            int i11 = 0;
            TextView textView = null;
            if (!(valueOf.intValue() < getChildCount())) {
                valueOf = null;
            }
            View childAt = valueOf != null ? getChildAt(valueOf.intValue()) : null;
            Integer valueOf2 = Integer.valueOf((int) ((float) Math.ceil((double) this.selected)));
            if (!(valueOf2.intValue() < getChildCount())) {
                valueOf2 = null;
            }
            View childAt2 = valueOf2 != null ? getChildAt(valueOf2.intValue()) : null;
            float f11 = this.selected % ((float) 1);
            if (childAt == null || childAt2 == null || x.b(childAt, childAt2)) {
                if (childAt instanceof TextView) {
                    textView = (TextView) childAt;
                }
                if (textView != null) {
                    textView.setTextColor(this.selectedTextColor);
                }
                int left = childAt != null ? childAt.getLeft() : childAt2 != null ? childAt2.getLeft() : 0;
                if (childAt != null) {
                    i11 = childAt.getRight();
                } else if (childAt2 != null) {
                    i11 = childAt2.getRight();
                }
                this.selectedItemBackground.setBounds(left, getPaddingTop(), i11, getHeight() - getPaddingBottom());
            } else {
                this.selectedItemBackground.setBounds((int) (((float) childAt.getLeft()) + (((float) (childAt2.getLeft() - childAt.getLeft())) * f11)), getPaddingTop(), (int) (((float) childAt.getRight()) + (((float) (childAt2.getRight() - childAt.getRight())) * f11)), getHeight() - getPaddingBottom());
                TextView textView2 = childAt instanceof TextView ? (TextView) childAt : null;
                if (textView2 != null) {
                    textView2.setTextColor(instance.evaluate(f11, Integer.valueOf(this.selectedTextColor), Integer.valueOf(this.textColor)).intValue());
                }
                if (childAt2 instanceof TextView) {
                    textView = (TextView) childAt2;
                }
                if (textView != null) {
                    textView.setTextColor(instance.evaluate(f11, Integer.valueOf(this.textColor), Integer.valueOf(this.selectedTextColor)).intValue());
                }
            }
            canvas.save();
            this.selectedItemBackground.draw(canvas);
            canvas.restore();
        }
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        View childAt;
        if (!this.isScrolling) {
            this.saveCurrentSelected = getSelectedItem();
            this.isScrolling = true;
        }
        if (motionEvent == null) {
            return false;
        }
        float x11 = motionEvent2.getX() - motionEvent.getX();
        int i11 = this.saveCurrentSelected;
        if (i11 == 0 && x11 < 0.0f) {
            return false;
        }
        if ((i11 == getChildCount() - 1 && x11 > 0.0f) || (childAt = getChildAt(this.saveCurrentSelected)) == null || motionEvent.getX() < ((float) childAt.getLeft()) || motionEvent.getX() > ((float) childAt.getRight())) {
            return false;
        }
        this.selected = RangesKt___RangesKt.i(((float) this.saveCurrentSelected) + ((x11 / ((float) ((getWidth() - getPaddingStart()) - getPaddingEnd()))) * ((float) getChildCount())), 0.0f, (float) (getChildCount() - 1));
        postInvalidateOnAnimation();
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return performTapSelection(motionEvent.getX());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.isScrolling) {
            this.isScrolling = false;
            this.selected = (float) MathKt__MathJVMKt.b(this.selected);
            this.animator.p(((float) getSelectedItem()) * ANIMATION_MULTIPLIER);
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.requestDisallowInterceptTouchEvent(false);
            }
        }
        if (this.gestureDetector.a(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setItemPadding(int i11) {
        this.itemPadding = i11;
    }

    public final void setItems(List<String> list, int i11) {
        if (!list.equals(this.segments)) {
            removeAllViews();
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            setGravity(16);
            int i12 = 0;
            for (T next : list) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                SNSTextView sNSTextView = new SNSTextView(getContext(), (AttributeSet) null, 0, 0, (SNSTypographyElement) null, (SNSColorElement) null, 62, (r) null);
                sNSTextView.setText((String) next);
                l.s(sNSTextView, this.textAppearance);
                sNSTextView.setTextColor(this.textColor);
                int i14 = this.itemPadding;
                sNSTextView.setPadding(i14, 0, i14, 0);
                addView(sNSTextView, marginLayoutParams);
                i12 = i13;
            }
            this.animator.i(((float) CollectionsKt__CollectionsKt.m(list)) * ANIMATION_MULTIPLIER);
            this.selected = (float) i11;
        }
    }

    public final void setOnItemSelected(OnItemSelected onItemSelected2) {
        this.onItemSelected = onItemSelected2;
    }

    public final void setSelectedItem(int i11) {
        if (i11 != ((int) this.selected)) {
            if (i11 >= 0 && i11 < getChildCount()) {
                this.animator.p(((float) i11) * ANIMATION_MULTIPLIER);
            }
        }
    }

    public SNSSegmentedToggleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSSegmentedToggleView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSSegmentedToggleView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_SNSSegmentedToggleViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSSegmentedToggleView : i12);
    }

    /* JADX WARNING: type inference failed for: r11v18, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SNSSegmentedToggleView(android.content.Context r9, android.util.AttributeSet r10, int r11, int r12) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11, r12)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r9, (android.util.AttributeSet) r10, (int) r11, (int) r12)
            com.google.android.material.shape.ShapeAppearanceModel r0 = r0.build()
            r8.shapeAppearance = r0
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>((com.google.android.material.shape.ShapeAppearanceModel) r0)
            r8.selectedItemBackground = r1
            r2 = -1
            r8.textAppearance = r2
            r8.textColor = r2
            r3 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r8.selectedTextColor = r3
            com.sumsub.sns.core.widget.SNSSegmentedToggleView$selectedPropertyHolder$1 r4 = new com.sumsub.sns.core.widget.SNSSegmentedToggleView$selectedPropertyHolder$1
            r4.<init>(r8)
            r8.selectedPropertyHolder = r4
            androidx.dynamicanimation.animation.c r5 = new androidx.dynamicanimation.animation.c
            r6 = 0
            r5.<init>(r8, r4, r6)
            androidx.dynamicanimation.animation.SpringForce r4 = r5.r()
            r7 = 1065353216(0x3f800000, float:1.0)
            r4.d(r7)
            androidx.dynamicanimation.animation.SpringForce r4 = r5.r()
            r7 = 1153138688(0x44bb8000, float:1500.0)
            r4.f(r7)
            r5.j(r6)
            com.sumsub.sns.core.widget.u r4 = new com.sumsub.sns.core.widget.u
            r4.<init>(r8)
            r5.b(r4)
            r8.animator = r5
            r4 = 0
            r8.setOrientation(r4)
            int[] r5 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView
            android.content.res.TypedArray r10 = r9.obtainStyledAttributes(r10, r5, r11, r12)
            com.google.android.material.shape.MaterialShapeDrawable r11 = new com.google.android.material.shape.MaterialShapeDrawable
            r11.<init>((com.google.android.material.shape.ShapeAppearanceModel) r0)
            int r12 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_boxStrokeWidth
            r0 = 1
            float r0 = com.sumsub.sns.core.common.b.a((int) r0)
            float r12 = r10.getDimension(r12, r0)
            r11.setStrokeWidth(r12)
            int r12 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_boxStrokeColor
            android.content.res.ColorStateList r12 = r10.getColorStateList(r12)
            r11.setStrokeColor(r12)
            int r12 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_boxBackgroundColor
            android.content.res.ColorStateList r12 = r10.getColorStateList(r12)
            r11.setFillColor(r12)
            r8.setBackground(r11)
            int r11 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_sns_itemBackgroundColor
            android.content.res.ColorStateList r11 = r10.getColorStateList(r11)
            r1.setFillColor(r11)
            int r11 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_sns_itemPadding
            int r11 = r10.getDimensionPixelSize(r11, r4)
            r8.itemPadding = r11
            int r11 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_android_textAppearance
            int r11 = r10.getResourceId(r11, r2)
            r8.textAppearance = r11
            int r11 = com.sumsub.sns.R.styleable.SNSSegmentedToggleView_sns_textColor
            android.content.res.ColorStateList r11 = r10.getColorStateList(r11)
            if (r11 == 0) goto L_0x00a2
            int r2 = r11.getDefaultColor()
        L_0x00a2:
            r8.textColor = r2
            if (r11 == 0) goto L_0x00ac
            int[] r12 = STATE_SELECTED
            int r3 = r11.getColorForState(r12, r2)
        L_0x00ac:
            r8.selectedTextColor = r3
            kotlin.Unit r11 = kotlin.Unit.f56620a
            r10.recycle()
            com.sumsub.sns.core.presentation.helper.a r10 = com.sumsub.sns.core.presentation.helper.a.f31095a
            com.sumsub.sns.core.theme.SNSColorElement r11 = com.sumsub.sns.core.theme.SNSColorElement.CAMERA_CONTENT
            java.lang.Integer r11 = r10.a((android.view.View) r8, (com.sumsub.sns.core.theme.SNSColorElement) r11)
            if (r11 == 0) goto L_0x00ca
            int r11 = r11.intValue()
            r8.textColor = r11
            android.content.res.ColorStateList r11 = android.content.res.ColorStateList.valueOf(r11)
            r1.setFillColor(r11)
        L_0x00ca:
            com.sumsub.sns.core.theme.SNSColorElement r11 = com.sumsub.sns.core.theme.SNSColorElement.CONTENT_LINK
            java.lang.Integer r11 = r10.a((android.view.View) r8, (com.sumsub.sns.core.theme.SNSColorElement) r11)
            if (r11 == 0) goto L_0x00d8
            int r11 = r11.intValue()
            r8.selectedTextColor = r11
        L_0x00d8:
            com.sumsub.sns.core.theme.SNSColorElement r11 = com.sumsub.sns.core.theme.SNSColorElement.CAMERA_BACKGROUND_OVERLAY
            java.lang.Integer r11 = r10.a((android.view.View) r8, (com.sumsub.sns.core.theme.SNSColorElement) r11)
            r12 = 0
            if (r11 == 0) goto L_0x00fb
            int r11 = r11.intValue()
            android.graphics.drawable.Drawable r0 = r8.getBackground()
            boolean r2 = r0 instanceof com.google.android.material.shape.MaterialShapeDrawable
            if (r2 == 0) goto L_0x00f0
            com.google.android.material.shape.MaterialShapeDrawable r0 = (com.google.android.material.shape.MaterialShapeDrawable) r0
            goto L_0x00f1
        L_0x00f0:
            r0 = r12
        L_0x00f1:
            if (r0 != 0) goto L_0x00f4
            goto L_0x00fb
        L_0x00f4:
            android.content.res.ColorStateList r11 = android.content.res.ColorStateList.valueOf(r11)
            r0.setFillColor(r11)
        L_0x00fb:
            com.sumsub.sns.internal.core.theme.d r11 = r10.a()
            if (r11 == 0) goto L_0x0120
            com.sumsub.sns.core.theme.SNSMetricElement r0 = com.sumsub.sns.core.theme.SNSMetricElement.SEGMENTED_CONTROL_CORNER_RADIUS
            java.lang.Float r10 = r10.a((com.sumsub.sns.internal.core.theme.d) r11, (com.sumsub.sns.core.theme.SNSMetricElement) r0)
            if (r10 == 0) goto L_0x0120
            float r10 = r10.floatValue()
            android.graphics.drawable.Drawable r11 = r8.getBackground()
            boolean r0 = r11 instanceof com.google.android.material.shape.MaterialShapeDrawable
            if (r0 == 0) goto L_0x0118
            r12 = r11
            com.google.android.material.shape.MaterialShapeDrawable r12 = (com.google.android.material.shape.MaterialShapeDrawable) r12
        L_0x0118:
            if (r12 == 0) goto L_0x011d
            r12.setCornerSize((float) r10)
        L_0x011d:
            r1.setCornerSize((float) r10)
        L_0x0120:
            androidx.core.view.e r10 = new androidx.core.view.e
            r10.<init>(r9, r8)
            r8.gestureDetector = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.SNSSegmentedToggleView.<init>(android.content.Context, android.util.AttributeSet, int, int):void");
    }
}
