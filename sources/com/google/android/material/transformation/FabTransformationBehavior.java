package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    private float dependencyOriginalTranslationX;
    private float dependencyOriginalTranslationY;
    private final int[] tmpArray = new int[2];
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();

    public static class FabTransformationSpec {
        public Positioning positioning;
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
    }

    private ViewGroup calculateChildContentContainer(View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            return toViewGroupOrNull(findViewById);
        }
        if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
            return toViewGroupOrNull(((ViewGroup) view).getChildAt(0));
        }
        return toViewGroupOrNull(view);
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View view, FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, MotionTiming motionTiming2, float f11, float f12, float f13, float f14, RectF rectF) {
        float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, f11, f13);
        float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, f12, f14);
        Rect rect = this.tmpRect;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.tmpRectF1;
        rectF2.set(rect);
        RectF rectF3 = this.tmpRectF2;
        calculateWindowBounds(view, rectF3);
        rectF3.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void calculateDependencyWindowBounds(View view, RectF rectF) {
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
    }

    private Pair<MotionTiming, MotionTiming> calculateMotionTiming(float f11, float f12, boolean z11, FabTransformationSpec fabTransformationSpec) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        int i11;
        if (f11 == 0.0f || f12 == 0.0f) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        } else if ((!z11 || f12 >= 0.0f) && (z11 || i11 <= 0)) {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
        } else {
            motionTiming2 = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
        }
        return new Pair<>(motionTiming2, motionTiming);
    }

    private float calculateRevealCenterX(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(-calculateTranslationX(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float calculateRevealCenterY(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        rectF2.offset(0.0f, -calculateTranslationY(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float calculateTranslationX(View view, View view2, Positioning positioning) {
        float f11;
        float f12;
        float f13;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i11 = positioning.gravity & 7;
        if (i11 == 1) {
            f13 = rectF2.centerX();
            f12 = rectF.centerX();
        } else if (i11 == 3) {
            f13 = rectF2.left;
            f12 = rectF.left;
        } else if (i11 != 5) {
            f11 = 0.0f;
            return f11 + positioning.xAdjustment;
        } else {
            f13 = rectF2.right;
            f12 = rectF.right;
        }
        f11 = f13 - f12;
        return f11 + positioning.xAdjustment;
    }

    private float calculateTranslationY(View view, View view2, Positioning positioning) {
        float f11;
        float f12;
        float f13;
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateDependencyWindowBounds(view, rectF);
        calculateWindowBounds(view2, rectF2);
        int i11 = positioning.gravity & 112;
        if (i11 == 16) {
            f13 = rectF2.centerY();
            f12 = rectF.centerY();
        } else if (i11 == 48) {
            f13 = rectF2.top;
            f12 = rectF.top;
        } else if (i11 != 80) {
            f11 = 0.0f;
            return f11 + positioning.yAdjustment;
        } else {
            f13 = rectF2.bottom;
            f12 = rectF.bottom;
        }
        f11 = f13 - f12;
        return f11 + positioning.yAdjustment;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f11, float f12) {
        long delay = motionTiming.getDelay();
        long duration = motionTiming.getDuration();
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        return AnimationUtils.lerp(f11, f12, motionTiming.getInterpolator().getInterpolation(((float) (((timing.getDelay() + timing.getDuration()) + 17) - delay)) / ((float) duration)));
    }

    private void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo((float) iArr[0], (float) iArr[1]);
        rectF.offset((float) ((int) (-view.getTranslationX())), (float) ((int) (-view.getTranslationY())));
    }

    private void createChildrenFadeAnimation(View view, View view2, boolean z11, boolean z12, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup calculateChildContentContainer;
        ObjectAnimator objectAnimator;
        if (view2 instanceof ViewGroup) {
            if ((!(view2 instanceof CircularRevealWidget) || CircularRevealHelper.STRATEGY != 0) && (calculateChildContentContainer = calculateChildContentContainer(view2)) != null) {
                if (z11) {
                    if (!z12) {
                        ChildrenAlphaProperty.CHILDREN_ALPHA.set(calculateChildContentContainer, Float.valueOf(0.0f));
                    }
                    objectAnimator = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{1.0f});
                } else {
                    objectAnimator = ObjectAnimator.ofFloat(calculateChildContentContainer, ChildrenAlphaProperty.CHILDREN_ALPHA, new float[]{0.0f});
                }
                fabTransformationSpec.timings.getTiming("contentFade").apply(objectAnimator);
                list.add(objectAnimator);
            }
        }
    }

    private void createColorAnimation(View view, View view2, boolean z11, boolean z12, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if (view2 instanceof CircularRevealWidget) {
            CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            int backgroundTint = getBackgroundTint(view);
            int i11 = 16777215 & backgroundTint;
            if (z11) {
                if (!z12) {
                    circularRevealWidget.setCircularRevealScrimColor(backgroundTint);
                }
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{i11});
            } else {
                objectAnimator = ObjectAnimator.ofInt(circularRevealWidget, CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, new int[]{backgroundTint});
            }
            objectAnimator.setEvaluator(ArgbEvaluatorCompat.getInstance());
            fabTransformationSpec.timings.getTiming("color").apply(objectAnimator);
            list.add(objectAnimator);
        }
    }

    private void createDependencyTranslationAnimation(View view, View view2, boolean z11, FabTransformationSpec fabTransformationSpec, List<Animator> list) {
        float calculateTranslationX = calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float calculateTranslationY = calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z11, fabTransformationSpec);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z11) {
            calculateTranslationX = this.dependencyOriginalTranslationX;
        }
        fArr[0] = calculateTranslationX;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z11) {
            calculateTranslationY = this.dependencyOriginalTranslationY;
        }
        fArr2[0] = calculateTranslationY;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming.apply(ofFloat);
        motionTiming2.apply(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void createElevationAnimation(View view, View view2, boolean z11, boolean z12, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        float z13 = h0.z(view2) - h0.z(view);
        if (z11) {
            if (!z12) {
                view2.setTranslationZ(-z13);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{0.0f});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, new float[]{-z13});
        }
        fabTransformationSpec.timings.getTiming("elevation").apply(objectAnimator);
        list.add(objectAnimator);
    }

    private void createExpansionAnimation(View view, View view2, boolean z11, boolean z12, FabTransformationSpec fabTransformationSpec, float f11, float f12, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        View view3 = view;
        View view4 = view2;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        if (view4 instanceof CircularRevealWidget) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view4;
            float calculateRevealCenterX = calculateRevealCenterX(view3, view4, fabTransformationSpec2.positioning);
            float calculateRevealCenterY = calculateRevealCenterY(view3, view4, fabTransformationSpec2.positioning);
            ((FloatingActionButton) view3).getContentRect(this.tmpRect);
            float width = ((float) this.tmpRect.width()) / 2.0f;
            MotionTiming timing = fabTransformationSpec2.timings.getTiming("expansion");
            if (z11) {
                if (!z12) {
                    circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(calculateRevealCenterX, calculateRevealCenterY, width));
                }
                if (z12) {
                    width = circularRevealWidget.getRevealInfo().radius;
                }
                animator = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, MathUtils.distanceToFurthestCorner(calculateRevealCenterX, calculateRevealCenterY, 0.0f, 0.0f, f11, f12));
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        CircularRevealWidget.RevealInfo revealInfo = circularRevealWidget.getRevealInfo();
                        revealInfo.radius = Float.MAX_VALUE;
                        circularRevealWidget.setRevealInfo(revealInfo);
                    }
                });
                createPreFillRadialExpansion(view2, timing.getDelay(), (int) calculateRevealCenterX, (int) calculateRevealCenterY, width, list);
            } else {
                float f13 = circularRevealWidget.getRevealInfo().radius;
                Animator createCircularReveal = CircularRevealCompat.createCircularReveal(circularRevealWidget, calculateRevealCenterX, calculateRevealCenterY, width);
                int i11 = (int) calculateRevealCenterX;
                int i12 = (int) calculateRevealCenterY;
                View view5 = view2;
                createPreFillRadialExpansion(view5, timing.getDelay(), i11, i12, f13, list);
                long delay = timing.getDelay();
                long duration = timing.getDuration();
                long totalDuration = fabTransformationSpec2.timings.getTotalDuration();
                createPostFillRadialExpansion(view5, delay, duration, totalDuration, i11, i12, width, list);
                animator = createCircularReveal;
            }
            timing.apply(animator);
            list.add(animator);
            list2.add(CircularRevealCompat.createCircularRevealListener(circularRevealWidget));
        }
    }

    private void createIconFadeAnimation(View view, final View view2, boolean z11, boolean z12, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimator;
        if ((view2 instanceof CircularRevealWidget) && (view instanceof ImageView)) {
            final CircularRevealWidget circularRevealWidget = (CircularRevealWidget) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z11) {
                    if (!z12) {
                        drawable.setAlpha(255);
                    }
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{0});
                } else {
                    objectAnimator = ObjectAnimator.ofInt(drawable, DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, new int[]{255});
                }
                objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        view2.invalidate();
                    }
                });
                fabTransformationSpec.timings.getTiming("iconFade").apply(objectAnimator);
                list.add(objectAnimator);
                list2.add(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable((Drawable) null);
                    }

                    public void onAnimationStart(Animator animator) {
                        circularRevealWidget.setCircularRevealOverlayDrawable(drawable);
                    }
                });
            }
        }
    }

    private void createPostFillRadialExpansion(View view, long j11, long j12, long j13, int i11, int i12, float f11, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j14 = j11 + j12;
            if (j14 < j13) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i11, i12, f11, f11);
                createCircularReveal.setStartDelay(j14);
                createCircularReveal.setDuration(j13 - j14);
                list.add(createCircularReveal);
            }
        }
    }

    private void createPreFillRadialExpansion(View view, long j11, int i11, int i12, float f11, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21 && j11 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i11, i12, f11, f11);
            createCircularReveal.setStartDelay(0);
            createCircularReveal.setDuration(j11);
            list.add(createCircularReveal);
        }
    }

    private void createTranslationAnimation(View view, View view2, boolean z11, boolean z12, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        View view3 = view;
        View view4 = view2;
        boolean z13 = z11;
        FabTransformationSpec fabTransformationSpec2 = fabTransformationSpec;
        List<Animator> list3 = list;
        float calculateTranslationX = calculateTranslationX(view3, view4, fabTransformationSpec2.positioning);
        float calculateTranslationY = calculateTranslationY(view3, view4, fabTransformationSpec2.positioning);
        Pair<MotionTiming, MotionTiming> calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z13, fabTransformationSpec2);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        if (z13) {
            if (!z12) {
                view4.setTranslationX(-calculateTranslationX);
                view4.setTranslationY(-calculateTranslationY);
            }
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{0.0f});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{0.0f});
            calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationSpec, motionTiming, motionTiming2, -calculateTranslationX, -calculateTranslationY, 0.0f, 0.0f, rectF);
        } else {
            objectAnimator2 = ObjectAnimator.ofFloat(view4, View.TRANSLATION_X, new float[]{-calculateTranslationX});
            objectAnimator = ObjectAnimator.ofFloat(view4, View.TRANSLATION_Y, new float[]{-calculateTranslationY});
        }
        motionTiming.apply(objectAnimator2);
        motionTiming2.apply(objectAnimator);
        list3.add(objectAnimator2);
        list3.add(objectAnimator);
    }

    private int getBackgroundTint(View view) {
        ColorStateList v11 = h0.v(view);
        if (v11 != null) {
            return v11.getColorForState(view.getDrawableState(), v11.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup toViewGroupOrNull(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.f8119h == 0) {
            layoutParams.f8119h = 80;
        }
    }

    public AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean z11, boolean z12) {
        final boolean z13 = z11;
        FabTransformationSpec onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z13);
        if (z13) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            createElevationAnimation(view, view2, z11, z12, onCreateMotionSpec, arrayList, arrayList2);
        }
        RectF rectF = this.tmpRectF1;
        View view3 = view;
        View view4 = view2;
        boolean z14 = z11;
        ArrayList arrayList3 = arrayList;
        ArrayList arrayList4 = arrayList2;
        createTranslationAnimation(view3, view4, z14, z12, onCreateMotionSpec, arrayList3, arrayList4, rectF);
        float width = rectF.width();
        float height = rectF.height();
        createDependencyTranslationAnimation(view3, view4, z14, onCreateMotionSpec, arrayList);
        boolean z15 = z12;
        FabTransformationSpec fabTransformationSpec = onCreateMotionSpec;
        createIconFadeAnimation(view3, view4, z14, z15, fabTransformationSpec, arrayList3, arrayList4);
        createExpansionAnimation(view3, view4, z14, z15, fabTransformationSpec, width, height, arrayList, arrayList2);
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = arrayList2;
        createColorAnimation(view3, view4, z14, z15, fabTransformationSpec, arrayList5, arrayList6);
        createChildrenFadeAnimation(view3, view4, z14, z15, fabTransformationSpec, arrayList5, arrayList6);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        final View view5 = view;
        final View view6 = view2;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!z13) {
                    view6.setVisibility(4);
                    view5.setAlpha(1.0f);
                    view5.setVisibility(0);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (z13) {
                    view6.setVisibility(0);
                    view5.setAlpha(0.0f);
                    view5.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i11 = 0; i11 < size; i11++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i11));
        }
        return animatorSet;
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z11);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
