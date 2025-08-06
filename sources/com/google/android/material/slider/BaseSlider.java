package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import com.xiaomi.mipush.sdk.Constants;
import g1.a;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_TO = "valueTo(%s) must be greater than valueFrom(%s)";
    private static final int HALO_ALPHA = 63;
    private static final long LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final long LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String TAG = BaseSlider.class.getSimpleName();
    private static final double THRESHOLD = 1.0E-4d;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    public static final int UNIT_PX = 0;
    public static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERRROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;
    /* access modifiers changed from: private */
    public final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final List<L> changeListeners;
    private int defaultThumbRadius;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Paint inactiveTicksPaint;
    private final Paint inactiveTrackPaint;
    private boolean isLongPress;
    private int labelBehavior;
    private final TooltipDrawableFactory labelMaker;
    private int labelPadding;
    /* access modifiers changed from: private */
    public final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTrackSidePadding;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    private final MaterialShapeDrawable thumbDrawable;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    private int thumbRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private boolean tickVisible;
    private float[] ticksCoordinates;
    private float touchDownX;
    private final List<T> touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackHeight;
    private int trackSidePadding;
    private int trackTop;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetHeight;

    public class AccessibilityEventSender implements Runnable {
        public int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int i11) {
            this.virtualViewId = i11;
        }
    }

    public static class AccessibilityHelper extends a {
        private final BaseSlider<?, ?, ?> slider;
        public Rect virtualViewBounds = new Rect();

        public AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.slider = baseSlider;
        }

        private String startOrEndDescription(int i11) {
            if (i11 == this.slider.getValues().size() - 1) {
                return this.slider.getContext().getString(R.string.material_slider_range_end);
            }
            return i11 == 0 ? this.slider.getContext().getString(R.string.material_slider_range_start) : "";
        }

        public int getVirtualViewAt(float f11, float f12) {
            for (int i11 = 0; i11 < this.slider.getValues().size(); i11++) {
                this.slider.updateBoundsForVirturalViewId(i11, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f11, (int) f12)) {
                    return i11;
                }
            }
            return -1;
        }

        public void getVisibleVirtualViews(List<Integer> list) {
            for (int i11 = 0; i11 < this.slider.getValues().size(); i11++) {
                list.add(Integer.valueOf(i11));
            }
        }

        public boolean onPerformActionForVirtualView(int i11, int i12, Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i12 == 4096 || i12 == 8192) {
                float access$800 = this.slider.calculateStepIncrement(20);
                if (i12 == 8192) {
                    access$800 = -access$800;
                }
                if (this.slider.isRtl()) {
                    access$800 = -access$800;
                }
                if (!this.slider.snapThumbToValue(i11, x0.a.b(this.slider.getValues().get(i11).floatValue() + access$800, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                    return false;
                }
                this.slider.updateHaloHotspot();
                this.slider.postInvalidate();
                invalidateVirtualView(i11);
                return true;
            }
            if (i12 == 16908349 && bundle != null && bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                if (this.slider.snapThumbToValue(i11, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                    this.slider.updateHaloHotspot();
                    this.slider.postInvalidate();
                    invalidateVirtualView(i11);
                    return true;
                }
            }
            return false;
        }

        public void onPopulateNodeForVirtualView(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.a.L);
            List<Float> values = this.slider.getValues();
            float floatValue = values.get(i11).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.a(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.a(4096);
                }
            }
            accessibilityNodeInfoCompat.H0(AccessibilityNodeInfoCompat.g.a(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.o0(SeekBar.class.getName());
            StringBuilder sb2 = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb2.append(this.slider.getContentDescription());
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (values.size() > 1) {
                sb2.append(startOrEndDescription(i11));
                sb2.append(this.slider.formatValue(floatValue));
            }
            accessibilityNodeInfoCompat.s0(sb2.toString());
            this.slider.updateBoundsForVirturalViewId(i11, this.virtualViewBounds);
            accessibilityNodeInfoCompat.j0(this.virtualViewBounds);
        }
    }

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel);
            }

            public SliderState[] newArray(int i11) {
                return new SliderState[i11];
            }
        };
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList<Float> values;

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }
    }

    public interface TooltipDrawableFactory {
        TooltipDrawable createTooltipDrawable();
    }

    public BaseSlider(Context context) {
        this(context, (AttributeSet) null);
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    private Float calculateIncrementForKey(int i11) {
        float calculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (i11 == 21) {
            if (!isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return Float.valueOf(calculateStepIncrement);
        } else if (i11 == 22) {
            if (isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            return Float.valueOf(calculateStepIncrement);
        } else if (i11 == 69) {
            return Float.valueOf(-calculateStepIncrement);
        } else {
            if (i11 == 70 || i11 == 81) {
                return Float.valueOf(calculateStepIncrement);
            }
            return null;
        }
    }

    private float calculateStepIncrement() {
        float f11 = this.stepSize;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        return f11;
    }

    private int calculateTop() {
        int i11 = this.trackTop;
        int i12 = 0;
        if (this.labelBehavior == 1) {
            i12 = this.labels.get(0).getIntrinsicHeight();
        }
        return i11 + i12;
    }

    private ValueAnimator createLabelAnimator(boolean z11) {
        float f11 = 0.0f;
        float animatorCurrentValueOrDefault = getAnimatorCurrentValueOrDefault(z11 ? this.labelsOutAnimator : this.labelsInAnimator, z11 ? 0.0f : 1.0f);
        if (z11) {
            f11 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{animatorCurrentValueOrDefault, f11});
        ofFloat.setDuration(z11 ? LABEL_ANIMATION_ENTER_DURATION : LABEL_ANIMATION_EXIT_DURATION);
        ofFloat.setInterpolator(z11 ? AnimationUtils.DECELERATE_INTERPOLATOR : AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (TooltipDrawable revealFraction : BaseSlider.this.labels) {
                    revealFraction.setRevealFraction(floatValue);
                }
                h0.n0(BaseSlider.this);
            }
        });
        return ofFloat;
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable next : subList) {
                if (h0.Z(this)) {
                    detachLabelFromContentView(next);
                }
            }
            subList.clear();
        }
        while (this.labels.size() < this.values.size()) {
            TooltipDrawable createTooltipDrawable = this.labelMaker.createTooltipDrawable();
            this.labels.add(createTooltipDrawable);
            if (h0.Z(this)) {
                attachLabelToContentView(createTooltipDrawable);
            }
        }
        int i11 = 1;
        if (this.labels.size() == 1) {
            i11 = 0;
        }
        for (TooltipDrawable strokeWidth : this.labels) {
            strokeWidth.setStrokeWidth((float) i11);
        }
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewOverlayImpl contentViewOverlay = ViewUtils.getContentViewOverlay(this);
        if (contentViewOverlay != null) {
            contentViewOverlay.remove(tooltipDrawable);
            tooltipDrawable.detachView(ViewUtils.getContentView(this));
        }
    }

    private float dimenToValue(float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        float f12 = (f11 - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        float f13 = this.valueFrom;
        return (f12 * (f13 - this.valueTo)) + f13;
    }

    private void dispatchOnChangedFromUser(int i11) {
        for (L onValueChange : this.changeListeners) {
            onValueChange.onValueChange(this, this.values.get(i11).floatValue(), true);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            scheduleAccessibilityEventSender(i11);
        }
    }

    private void dispatchOnChangedProgramatically() {
        for (L l11 : this.changeListeners) {
            Iterator<Float> it2 = this.values.iterator();
            while (it2.hasNext()) {
                l11.onValueChange(this, it2.next().floatValue(), false);
            }
        }
    }

    private void drawActiveTrack(Canvas canvas, int i11, int i12) {
        float[] activeRange = getActiveRange();
        int i13 = this.trackSidePadding;
        float f11 = (float) i11;
        float f12 = (float) i12;
        Canvas canvas2 = canvas;
        canvas2.drawLine(((float) i13) + (activeRange[0] * f11), f12, ((float) i13) + (activeRange[1] * f11), f12, this.activeTrackPaint);
    }

    private void drawInactiveTrack(Canvas canvas, int i11, int i12) {
        float[] activeRange = getActiveRange();
        int i13 = this.trackSidePadding;
        float f11 = (float) i11;
        float f12 = ((float) i13) + (activeRange[1] * f11);
        if (f12 < ((float) (i13 + i11))) {
            float f13 = (float) i12;
            canvas.drawLine(f12, f13, (float) (i13 + i11), f13, this.inactiveTrackPaint);
        }
        int i14 = this.trackSidePadding;
        float f14 = ((float) i14) + (activeRange[0] * f11);
        if (f14 > ((float) i14)) {
            float f15 = (float) i12;
            canvas.drawLine((float) i14, f15, f14, f15, this.inactiveTrackPaint);
        }
    }

    private void drawThumbs(Canvas canvas, int i11, int i12) {
        if (!isEnabled()) {
            Iterator<Float> it2 = this.values.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle(((float) this.trackSidePadding) + (normalizeValue(it2.next().floatValue()) * ((float) i11)), (float) i12, (float) this.thumbRadius, this.thumbPaint);
            }
        }
        Iterator<Float> it3 = this.values.iterator();
        while (it3.hasNext()) {
            canvas.save();
            int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(it3.next().floatValue()) * ((float) i11)));
            int i13 = this.thumbRadius;
            canvas.translate((float) (normalizeValue - i13), (float) (i12 - i13));
            this.thumbDrawable.draw(canvas);
            canvas.restore();
        }
    }

    private void ensureLabelsAdded() {
        if (this.labelBehavior != 2) {
            if (!this.labelsAreAnimatedIn) {
                this.labelsAreAnimatedIn = true;
                ValueAnimator createLabelAnimator = createLabelAnimator(true);
                this.labelsInAnimator = createLabelAnimator;
                this.labelsOutAnimator = null;
                createLabelAnimator.start();
            }
            Iterator<TooltipDrawable> it2 = this.labels.iterator();
            for (int i11 = 0; i11 < this.values.size() && it2.hasNext(); i11++) {
                if (i11 != this.focusedThumbIdx) {
                    setValueForLabel(it2.next(), this.values.get(i11).floatValue());
                }
            }
            if (it2.hasNext()) {
                setValueForLabel(it2.next(), this.values.get(this.focusedThumbIdx).floatValue());
            } else {
                throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())}));
            }
        }
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    for (TooltipDrawable remove : BaseSlider.this.labels) {
                        ViewUtils.getContentViewOverlay(BaseSlider.this).remove(remove);
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int i11) {
        if (i11 == 1) {
            moveFocus(Integer.MAX_VALUE);
        } else if (i11 == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i11 == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else if (i11 == 66) {
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    /* access modifiers changed from: private */
    public String formatValue(float f11) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f11);
        }
        return String.format(((float) ((int) f11)) == f11 ? "%.0f" : "%.2f", new Object[]{Float.valueOf(f11)});
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.values.size() == 1) {
            floatValue2 = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue2);
        float normalizeValue2 = normalizeValue(floatValue);
        if (isRtl()) {
            return new float[]{normalizeValue2, normalizeValue};
        }
        return new float[]{normalizeValue, normalizeValue2};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator valueAnimator, float f11) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f11;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float getClampedValue(int i11, float f11) {
        float f12 = 0.0f;
        if (this.stepSize == 0.0f) {
            f12 = getMinSeparation();
        }
        if (this.separationUnit == 0) {
            f12 = dimenToValue(f12);
        }
        if (isRtl()) {
            f12 = -f12;
        }
        int i12 = i11 + 1;
        int i13 = i11 - 1;
        return x0.a.b(f11, i13 < 0 ? this.valueFrom : this.values.get(i13).floatValue() + f12, i12 >= this.values.size() ? this.valueTo : this.values.get(i12).floatValue() - f12);
    }

    private int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl()) {
            snapPosition = 1.0d - snapPosition;
        }
        float f11 = this.valueTo;
        float f12 = this.valueFrom;
        return (float) ((snapPosition * ((double) (f11 - f12))) + ((double) f12));
    }

    private float getValueOfTouchPositionAbsolute() {
        float f11 = this.touchPosition;
        if (isRtl()) {
            f11 = 1.0f - f11;
        }
        float f12 = this.valueTo;
        float f13 = this.valueFrom;
        return (f11 * (f12 - f13)) + f13;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.activeTrackPaint.setStrokeWidth((float) this.trackHeight);
        this.inactiveTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
        this.activeTicksPaint.setStrokeWidth(((float) this.trackHeight) / 2.0f);
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent parent = getParent();
        while (true) {
            boolean z11 = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) {
                z11 = true;
            }
            if (z11 && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void loadResources(Resources resources) {
        this.widgetHeight = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.trackTop = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void maybeCalculateTicksCoordinates() {
        if (this.stepSize > 0.0f) {
            validateConfigurationIfDirty();
            int min = Math.min((int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f), (this.trackWidth / (this.trackHeight * 2)) + 1);
            float[] fArr = this.ticksCoordinates;
            if (fArr == null || fArr.length != min * 2) {
                this.ticksCoordinates = new float[(min * 2)];
            }
            float f11 = ((float) this.trackWidth) / ((float) (min - 1));
            for (int i11 = 0; i11 < min * 2; i11 += 2) {
                float[] fArr2 = this.ticksCoordinates;
                fArr2[i11] = ((float) this.trackSidePadding) + (((float) (i11 / 2)) * f11);
                fArr2[i11 + 1] = (float) calculateTop();
            }
        }
    }

    private void maybeDrawHalo(Canvas canvas, int i11, int i12) {
        if (shouldDrawCompatHalo()) {
            int normalizeValue = (int) (((float) this.trackSidePadding) + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) i11)));
            if (Build.VERSION.SDK_INT < 28) {
                int i13 = this.haloRadius;
                canvas.clipRect((float) (normalizeValue - i13), (float) (i12 - i13), (float) (normalizeValue + i13), (float) (i13 + i12), Region.Op.UNION);
            }
            canvas.drawCircle((float) normalizeValue, (float) i12, (float) this.haloRadius, this.haloPaint);
        }
    }

    private void maybeDrawTicks(Canvas canvas) {
        if (this.tickVisible && this.stepSize > 0.0f) {
            float[] activeRange = getActiveRange();
            int pivotIndex = pivotIndex(this.ticksCoordinates, activeRange[0]);
            int pivotIndex2 = pivotIndex(this.ticksCoordinates, activeRange[1]);
            int i11 = pivotIndex * 2;
            canvas.drawPoints(this.ticksCoordinates, 0, i11, this.inactiveTicksPaint);
            int i12 = pivotIndex2 * 2;
            canvas.drawPoints(this.ticksCoordinates, i11, i12 - i11, this.activeTicksPaint);
            float[] fArr = this.ticksCoordinates;
            canvas.drawPoints(fArr, i12, fArr.length - i12, this.inactiveTicksPaint);
        }
    }

    private void maybeIncreaseTrackSidePadding() {
        this.trackSidePadding = this.minTrackSidePadding + Math.max(this.thumbRadius - this.defaultThumbRadius, 0);
        if (h0.a0(this)) {
            updateTrackWidth(getWidth());
        }
    }

    private boolean moveFocus(int i11) {
        int i12 = this.focusedThumbIdx;
        int d11 = (int) x0.a.d(((long) i12) + ((long) i11), 0, (long) (this.values.size() - 1));
        this.focusedThumbIdx = d11;
        if (d11 == i12) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = d11;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i11) {
        if (isRtl()) {
            i11 = i11 == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i11;
        }
        return moveFocus(i11);
    }

    private float normalizeValue(float f11) {
        float f12 = this.valueFrom;
        float f13 = (f11 - f12) / (this.valueTo - f12);
        return isRtl() ? 1.0f - f13 : f13;
    }

    private Boolean onKeyDownNoActiveThumb(int i11, KeyEvent keyEvent) {
        if (i11 != 61) {
            if (i11 != 66) {
                if (i11 != 81) {
                    if (i11 == 69) {
                        moveFocus(-1);
                        return Boolean.TRUE;
                    } else if (i11 != 70) {
                        switch (i11) {
                            case 21:
                                moveFocusInAbsoluteDirection(-1);
                                return Boolean.TRUE;
                            case 22:
                                moveFocusInAbsoluteDirection(1);
                                return Boolean.TRUE;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                moveFocus(1);
                return Boolean.TRUE;
            }
            this.activeThumbIdx = this.focusedThumbIdx;
            postInvalidate();
            return Boolean.TRUE;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(moveFocus(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(moveFocus(-1));
            }
            return Boolean.FALSE;
        }
    }

    private void onStartTrackingTouch() {
        for (T onStartTrackingTouch : this.touchListeners) {
            onStartTrackingTouch.onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        for (T onStopTrackingTouch : this.touchListeners) {
            onStopTrackingTouch.onStopTrackingTouch(this);
        }
    }

    /* access modifiers changed from: private */
    public static TooltipDrawable parseLabelDrawable(Context context, TypedArray typedArray) {
        return TooltipDrawable.createFromAttributes(context, (AttributeSet) null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private static int pivotIndex(float[] fArr, float f11) {
        return Math.round(f11 * ((float) ((fArr.length / 2) - 1)));
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i11) {
        int i12;
        int i13;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i11, DEF_STYLE_RES, new int[0]);
        this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        int i14 = R.styleable.Slider_trackColor;
        boolean hasValue = obtainStyledAttributes.hasValue(i14);
        if (hasValue) {
            i12 = i14;
        } else {
            i12 = R.styleable.Slider_trackColorInactive;
        }
        if (!hasValue) {
            i14 = R.styleable.Slider_trackColorActive;
        }
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i12);
        if (colorStateList == null) {
            colorStateList = c.a.a(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i14);
        if (colorStateList2 == null) {
            colorStateList2 = c.a.a(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.thumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor));
        int i15 = R.styleable.Slider_thumbStrokeColor;
        if (obtainStyledAttributes.hasValue(i15)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, i15));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = c.a.a(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.tickVisible = obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true);
        int i16 = R.styleable.Slider_tickColor;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i16);
        if (hasValue2) {
            i13 = i16;
        } else {
            i13 = R.styleable.Slider_tickColorInactive;
        }
        if (!hasValue2) {
            i16 = R.styleable.Slider_tickColorActive;
        }
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i13);
        if (colorStateList4 == null) {
            colorStateList4 = c.a.a(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i16);
        if (colorStateList5 == null) {
            colorStateList5 = c.a.a(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.labelBehavior = obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void scheduleAccessibilityEventSender(int i11) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender2);
        }
        this.accessibilityEventSender.setVirtualViewId(i11);
        postDelayed(this.accessibilityEventSender, 200);
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f11) {
        tooltipDrawable.setText(formatValue(f11));
        int normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f11) * ((float) this.trackWidth)))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int calculateTop = calculateTop() - (this.labelPadding + this.thumbRadius);
        tooltipDrawable.setBounds(normalizeValue, calculateTop - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + normalizeValue, calculateTop);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.getContentViewOverlay(this).add(tooltipDrawable);
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() != arrayList.size() || !this.values.equals(arrayList)) {
                this.values = arrayList;
                this.dirtyConfig = true;
                this.focusedThumbIdx = 0;
                updateHaloHotspot();
                createLabelPool();
                dispatchOnChangedProgramatically();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    private boolean snapActiveThumbToValue(float f11) {
        return snapThumbToValue(this.activeThumbIdx, f11);
    }

    private double snapPosition(float f11) {
        float f12 = this.stepSize;
        if (f12 <= 0.0f) {
            return (double) f11;
        }
        int i11 = (int) ((this.valueTo - this.valueFrom) / f12);
        return ((double) Math.round(f11 * ((float) i11))) / ((double) i11);
    }

    /* access modifiers changed from: private */
    public boolean snapThumbToValue(int i11, float f11) {
        if (((double) Math.abs(f11 - this.values.get(i11).floatValue())) < THRESHOLD) {
            return false;
        }
        this.values.set(i11, Float.valueOf(getClampedValue(i11, f11)));
        this.focusedThumbIdx = i11;
        dispatchOnChangedFromUser(i11);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    /* access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int normalizeValue = (int) ((normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * ((float) this.trackWidth)) + ((float) this.trackSidePadding));
                int calculateTop = calculateTop();
                int i11 = this.haloRadius;
                u0.a.l(background, normalizeValue - i11, calculateTop - i11, normalizeValue + i11, calculateTop + i11);
            }
        }
    }

    private void updateTrackWidth(int i11) {
        this.trackWidth = Math.max(i11 - (this.trackSidePadding * 2), 0);
        maybeCalculateTicksCoordinates();
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValueFrom();
            validateValueTo();
            validateStepSize();
            validateValues();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.toString(this.stepSize), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        }
    }

    private void validateValueFrom() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, new Object[]{Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        }
    }

    private void validateValueTo() {
        if (this.valueTo <= this.valueFrom) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_TO, new Object[]{Float.toString(this.valueTo), Float.toString(this.valueFrom)}));
        }
    }

    private void validateValues() {
        Iterator<Float> it2 = this.values.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, new Object[]{Float.toString(next.floatValue()), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
            } else if (this.stepSize > 0.0f && !valueLandsOnTick(next.floatValue())) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, new Object[]{Float.toString(next.floatValue()), Float.toString(this.valueFrom), Float.toString(this.stepSize), Float.toString(this.stepSize)}));
            }
        }
    }

    private boolean valueLandsOnTick(float f11) {
        double doubleValue = new BigDecimal(Float.toString(f11)).subtract(new BigDecimal(Float.toString(this.valueFrom))).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < THRESHOLD;
    }

    private float valueToX(float f11) {
        return (normalizeValue(f11) * ((float) this.trackWidth)) + ((float) this.trackSidePadding);
    }

    private void warnAboutFloatingPointError() {
        float f11 = this.stepSize;
        if (f11 != 0.0f) {
            if (((float) ((int) f11)) != f11) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"stepSize", Float.valueOf(f11)}));
            }
            float f12 = this.valueFrom;
            if (((float) ((int) f12)) != f12) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"valueFrom", Float.valueOf(f12)}));
            }
            float f13 = this.valueTo;
            if (((float) ((int) f13)) != f13) {
                Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERRROR, new Object[]{"valueTo", Float.valueOf(f13)}));
            }
        }
    }

    public void addOnChangeListener(L l11) {
        this.changeListeners.add(l11);
    }

    public void addOnSliderTouchListener(T t11) {
        this.touchListeners.add(t11);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        for (TooltipDrawable next : this.labels) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.thumbDrawable.isStateful()) {
            this.thumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    public void forceDrawCompatHalo(boolean z11) {
        this.forceDrawCompatHalo = z11;
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbDrawable.getElevation();
    }

    public int getThumbRadius() {
        return this.thumbRadius;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.thumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.thumbDrawable.getStrokeWidth();
    }

    public ColorStateList getThumbTintList() {
        return this.thumbDrawable.getFillColor();
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public int getTrackHeight() {
        return this.trackHeight;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public final boolean isRtl() {
        return h0.F(this) == 1;
    }

    public boolean isTickVisible() {
        return this.tickVisible;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (TooltipDrawable attachLabelToContentView : this.labels) {
            attachLabelToContentView(attachLabelToContentView);
        }
    }

    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender2 = this.accessibilityEventSender;
        if (accessibilityEventSender2 != null) {
            removeCallbacks(accessibilityEventSender2);
        }
        this.labelsAreAnimatedIn = false;
        for (TooltipDrawable detachLabelFromContentView : this.labels) {
            detachLabelFromContentView(detachLabelFromContentView);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            maybeCalculateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTop = calculateTop();
        drawInactiveTrack(canvas, this.trackWidth, calculateTop);
        if (((Float) Collections.max(getValues())).floatValue() > this.valueFrom) {
            drawActiveTrack(canvas, this.trackWidth, calculateTop);
        }
        maybeDrawTicks(canvas);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawHalo(canvas, this.trackWidth, calculateTop);
            if (this.activeThumbIdx != -1) {
                ensureLabelsAdded();
            }
        }
        drawThumbs(canvas, this.trackWidth, calculateTop);
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        if (!z11) {
            this.activeThumbIdx = -1;
            ensureLabelsRemoved();
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        focusThumbOnFocusGained(i11);
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i11, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i11, keyEvent);
            return onKeyDownNoActiveThumb != null ? onKeyDownNoActiveThumb.booleanValue() : super.onKeyDown(i11, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float calculateIncrementForKey = calculateIncrementForKey(i11);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i11 != 23) {
            if (i11 != 61) {
                if (i11 != 66) {
                    return super.onKeyDown(i11, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
        }
        this.activeThumbIdx = -1;
        ensureLabelsRemoved();
        postInvalidate();
        return true;
    }

    public boolean onKeyUp(int i11, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i11, keyEvent);
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.widgetHeight;
        int i14 = 0;
        if (this.labelBehavior == 1) {
            i14 = this.labels.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(i13 + i14, 1073741824));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
        dispatchOnChangedProgramatically();
    }

    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        updateTrackWidth(i11);
        updateHaloHotspot();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x11 = motionEvent.getX();
        float f11 = (x11 - ((float) this.trackSidePadding)) / ((float) this.trackWidth);
        this.touchPosition = f11;
        float max = Math.max(0.0f, f11);
        this.touchPosition = max;
        this.touchPosition = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.touchDownX = x11;
            if (!isInVerticalScrollingContainer()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (pickActiveThumb()) {
                    requestFocus();
                    this.thumbIsPressed = true;
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                    onStartTrackingTouch();
                }
            }
        } else if (actionMasked == 1) {
            this.thumbIsPressed = false;
            MotionEvent motionEvent2 = this.lastEvent;
            if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= ((float) this.scaledTouchSlop) && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= ((float) this.scaledTouchSlop) && pickActiveThumb()) {
                onStartTrackingTouch();
            }
            if (this.activeThumbIdx != -1) {
                snapTouchPosition();
                this.activeThumbIdx = -1;
                onStopTrackingTouch();
            }
            ensureLabelsRemoved();
            invalidate();
        } else if (actionMasked == 2) {
            if (!this.thumbIsPressed) {
                if (isInVerticalScrollingContainer() && Math.abs(x11 - this.touchDownX) < ((float) this.scaledTouchSlop)) {
                    return false;
                }
                getParent().requestDisallowInterceptTouchEvent(true);
                onStartTrackingTouch();
            }
            if (pickActiveThumb()) {
                this.thumbIsPressed = true;
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
            }
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i11 = 1; i11 < this.values.size(); i11++) {
            float abs2 = Math.abs(this.values.get(i11).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i11).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z11 = !isRtl() ? valueToX2 - valueToX < 0.0f : valueToX2 - valueToX > 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i11;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(valueToX2 - valueToX) < ((float) this.scaledTouchSlop)) {
                    this.activeThumbIdx = -1;
                    return false;
                } else if (z11) {
                    this.activeThumbIdx = i11;
                }
            }
            abs = abs2;
        }
        if (this.activeThumbIdx != -1) {
            return true;
        }
        return false;
    }

    public void removeOnChangeListener(L l11) {
        this.changeListeners.remove(l11);
    }

    public void removeOnSliderTouchListener(T t11) {
        this.touchListeners.remove(t11);
    }

    public void setActiveThumbIndex(int i11) {
        this.activeThumbIdx = i11;
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        setLayerType(z11 ? 0 : 2, (Paint) null);
    }

    public void setFocusedThumbIndex(int i11) {
        if (i11 < 0 || i11 >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i11;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i11);
        postInvalidate();
    }

    public void setHaloRadius(int i11) {
        if (i11 != this.haloRadius) {
            this.haloRadius = i11;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
            }
        }
    }

    public void setHaloRadiusResource(int i11) {
        setHaloRadius(getResources().getDimensionPixelSize(i11));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.haloColor)) {
            this.haloColor = colorStateList;
            Drawable background = getBackground();
            if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
                this.haloPaint.setColor(getColorForState(colorStateList));
                this.haloPaint.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i11) {
        if (this.labelBehavior != i11) {
            this.labelBehavior = i11;
            requestLayout();
        }
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setSeparationUnit(int i11) {
        this.separationUnit = i11;
    }

    public void setStepSize(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, new Object[]{Float.toString(f11), Float.toString(this.valueFrom), Float.toString(this.valueTo)}));
        } else if (this.stepSize != f11) {
            this.stepSize = f11;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f11) {
        this.thumbDrawable.setElevation(f11);
    }

    public void setThumbElevationResource(int i11) {
        setThumbElevation(getResources().getDimension(i11));
    }

    public void setThumbRadius(int i11) {
        if (i11 != this.thumbRadius) {
            this.thumbRadius = i11;
            maybeIncreaseTrackSidePadding();
            this.thumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, (float) this.thumbRadius).build());
            MaterialShapeDrawable materialShapeDrawable = this.thumbDrawable;
            int i12 = this.thumbRadius;
            materialShapeDrawable.setBounds(0, 0, i12 * 2, i12 * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int i11) {
        setThumbRadius(getResources().getDimensionPixelSize(i11));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.thumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i11) {
        if (i11 != 0) {
            setThumbStrokeColor(c.a.a(getContext(), i11));
        }
    }

    public void setThumbStrokeWidth(float f11) {
        this.thumbDrawable.setStrokeWidth(f11);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i11) {
        if (i11 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i11));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.thumbDrawable.getFillColor())) {
            this.thumbDrawable.setFillColor(colorStateList);
            invalidate();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorActive)) {
            this.tickColorActive = colorStateList;
            this.activeTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorInactive)) {
            this.tickColorInactive = colorStateList;
            this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z11) {
        if (this.tickVisible != z11) {
            this.tickVisible = z11;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorActive)) {
            this.trackColorActive = colorStateList;
            this.activeTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTrackHeight(int i11) {
        if (this.trackHeight != i11) {
            this.trackHeight = i11;
            invalidateTrack();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorInactive)) {
            this.trackColorInactive = colorStateList;
            this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f11) {
        this.valueFrom = f11;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f11) {
        this.valueTo = f11;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void updateBoundsForVirturalViewId(int i11, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i11).floatValue()) * ((float) this.trackWidth)));
        int calculateTop = calculateTop();
        int i12 = this.thumbRadius;
        rect.set(normalizeValue - i12, calculateTop - i12, normalizeValue + i12, calculateTop + i12);
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    /* access modifiers changed from: private */
    public float calculateStepIncrement(int i11) {
        float calculateStepIncrement = calculateStepIncrement();
        float f11 = (this.valueTo - this.valueFrom) / calculateStepIncrement;
        float f12 = (float) i11;
        if (f11 <= f12) {
            return calculateStepIncrement;
        }
        return ((float) Math.round(f11 / f12)) * calculateStepIncrement;
    }

    public BaseSlider(Context context, final AttributeSet attributeSet, final int i11) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i11, DEF_STYLE_RES), attributeSet, i11);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.tickVisible = true;
        this.isLongPress = false;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.thumbDrawable = materialShapeDrawable;
        this.separationUnit = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.inactiveTrackPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.activeTrackPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.thumbPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.haloPaint = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.inactiveTicksPaint = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.activeTicksPaint = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        loadResources(context2.getResources());
        this.labelMaker = new TooltipDrawableFactory() {
            public TooltipDrawable createTooltipDrawable() {
                TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(BaseSlider.this.getContext(), attributeSet, R.styleable.Slider, i11, BaseSlider.DEF_STYLE_RES, new int[0]);
                TooltipDrawable access$000 = BaseSlider.parseLabelDrawable(BaseSlider.this.getContext(), obtainStyledAttributes);
                obtainStyledAttributes.recycle();
                return access$000;
            }
        };
        processAttributes(context2, attributeSet, i11);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper2 = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper2;
        h0.x0(this, accessibilityHelper2);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList(list));
    }
}
