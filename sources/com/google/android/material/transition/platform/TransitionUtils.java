package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import c1.b;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.xiaomi.mipush.sdk.Constants;
import t0.f;

class TransitionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";
    public static final int NO_ATTR_RES_ID = 0;
    public static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = new RectF();

    public interface CanvasOperation {
        void run(Canvas canvas);
    }

    public interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2);
    }

    private TransitionUtils() {
    }

    public static float calculateArea(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    public static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() {
            public CornerSize apply(CornerSize cornerSize) {
                return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
            }
        });
    }

    public static Shader createColorShader(int i11) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i11, i11, Shader.TileMode.CLAMP);
    }

    public static <T> T defaultIfNull(T t11, T t12) {
        return t11 != null ? t11 : t12;
    }

    public static View findAncestorById(View view, int i11) {
        String resourceName = view.getResources().getResourceName(i11);
        while (view != null) {
            if (view.getId() != i11) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    public static View findDescendantOrAncestorById(View view, int i11) {
        View findViewById = view.findViewById(i11);
        if (findViewById != null) {
            return findViewById;
        }
        return findAncestorById(view, i11);
    }

    private static float getControlPoint(String[] strArr, int i11) {
        float parseFloat = Float.parseFloat(strArr[i11]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String getEasingContent(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        return new RectF((float) i11, (float) i12, (float) (view.getWidth() + i11), (float) (view.getHeight() + i12));
    }

    public static RectF getRelativeBounds(View view) {
        return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
    }

    public static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean isEasingType(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(EASING_TYPE_FORMAT_START);
        return str.startsWith(sb2.toString()) && str.endsWith(EASING_TYPE_FORMAT_END);
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    public static float lerp(float f11, float f12, float f13) {
        return f11 + (f13 * (f12 - f11));
    }

    public static float lerp(float f11, float f12, float f13, float f14, float f15) {
        return lerp(f11, f12, f13, f14, f15, false);
    }

    public static void maybeAddTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    public static boolean maybeApplyThemeDuration(Transition transition, Context context, int i11) {
        int resolveInteger;
        if (i11 == 0 || transition.getDuration() != -1 || (resolveInteger = MaterialAttributes.resolveInteger(context, i11, -1)) == -1) {
            return false;
        }
        transition.setDuration((long) resolveInteger);
        return true;
    }

    public static boolean maybeApplyThemeInterpolator(Transition transition, Context context, int i11, TimeInterpolator timeInterpolator) {
        if (i11 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(resolveThemeInterpolator(context, i11, timeInterpolator));
        return true;
    }

    public static boolean maybeApplyThemePath(Transition transition, Context context, int i11) {
        PathMotion resolveThemePath;
        if (i11 == 0 || (resolveThemePath = resolveThemePath(context, i11)) == null) {
            return false;
        }
        transition.setPathMotion(resolveThemePath);
        return true;
    }

    public static void maybeRemoveTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    public static TimeInterpolator resolveThemeInterpolator(Context context, int i11, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (isEasingType(valueOf, EASING_TYPE_CUBIC_BEZIER)) {
                String[] split = getEasingContent(valueOf, EASING_TYPE_CUBIC_BEZIER).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length == 4) {
                    return b.a(getControlPoint(split, 0), getControlPoint(split, 1), getControlPoint(split, 2), getControlPoint(split, 3));
                }
                throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
            } else if (isEasingType(valueOf, "path")) {
                return b.b(f.e(getEasingContent(valueOf, "path")));
            } else {
                throw new IllegalArgumentException("Invalid motion easing type: " + valueOf);
            }
        } else {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
    }

    public static PathMotion resolveThemePath(Context context, int i11) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i11, typedValue, true)) {
            return null;
        }
        int i12 = typedValue.type;
        if (i12 == 16) {
            int i13 = typedValue.data;
            if (i13 == 0) {
                return null;
            }
            if (i13 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i13);
        } else if (i12 == 3) {
            return new PatternPathMotion(f.e(String.valueOf(typedValue.string)));
        } else {
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i11) {
        RectF rectF = transformAlphaRectF;
        rectF.set(rect);
        if (Build.VERSION.SDK_INT >= 21) {
            return canvas.saveLayerAlpha(rectF, i11);
        }
        return canvas.saveLayerAlpha(rectF.left, rectF.top, rectF.right, rectF.bottom, i11, 31);
    }

    public static void transform(Canvas canvas, Rect rect, float f11, float f12, float f13, int i11, CanvasOperation canvasOperation) {
        if (i11 > 0) {
            int save = canvas.save();
            canvas.translate(f11, f12);
            canvas.scale(f13, f13);
            if (i11 < 255) {
                saveLayerAlphaCompat(canvas, rect, i11);
            }
            canvasOperation.run(canvas);
            canvas.restoreToCount(save);
        }
    }

    public static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    public static float lerp(float f11, float f12, float f13, float f14, float f15, boolean z11) {
        if (z11 && (f15 < 0.0f || f15 > 1.0f)) {
            return lerp(f11, f12, f15);
        }
        if (f15 < f13) {
            return f11;
        }
        if (f15 > f14) {
            return f12;
        }
        return lerp(f11, f12, (f15 - f13) / (f14 - f13));
    }

    public static int lerp(int i11, int i12, float f11, float f12, float f13) {
        if (f13 < f11) {
            return i11;
        }
        return f13 > f12 ? i12 : (int) lerp((float) i11, (float) i12, (f13 - f11) / (f12 - f11));
    }

    public static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, float f11, float f12, float f13) {
        if (f13 < f11) {
            return shapeAppearanceModel;
        }
        if (f13 > f12) {
            return shapeAppearanceModel2;
        }
        final RectF rectF3 = rectF;
        final RectF rectF4 = rectF2;
        final float f14 = f11;
        final float f15 = f12;
        final float f16 = f13;
        return transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() {
            public CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF3), cornerSize2.getCornerSize(rectF4), f14, f15, f16));
            }
        });
    }
}
