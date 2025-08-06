package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
    private final PolystarShape.Type type;

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = r0
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.PolystarContent.AnonymousClass1.<clinit>():void");
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable2;
        this.name = polystarShape.getName();
        PolystarShape.Type type2 = polystarShape.getType();
        this.type = type2;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = createAnimation5;
        PolystarShape.Type type3 = PolystarShape.Type.STAR;
        if (type2 == type3) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type2 == type3) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type2 == type3) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        double d11;
        double d12;
        double d13;
        int i11;
        int floor = (int) Math.floor((double) this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d14 = (double) floor;
        float floatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d15 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d15);
        float sin = (float) (Math.sin(radians) * d15);
        this.path.moveTo(cos, sin);
        double d16 = (double) ((float) (6.283185307179586d / d14));
        double d17 = radians + d16;
        double ceil = Math.ceil(d14);
        int i12 = 0;
        while (((double) i12) < ceil) {
            float cos2 = (float) (Math.cos(d17) * d15);
            double d18 = ceil;
            float sin2 = (float) (d15 * Math.sin(d17));
            if (floatValue != 0.0f) {
                d13 = d15;
                i11 = i12;
                d12 = d17;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d11 = d16;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f11 = floatValue2 * floatValue * 0.25f;
                this.path.cubicTo(cos - (cos3 * f11), sin - (((float) Math.sin(atan2)) * f11), cos2 + (((float) Math.cos(atan22)) * f11), sin2 + (f11 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d12 = d17;
                d13 = d15;
                d11 = d16;
                i11 = i12;
                this.path.lineTo(cos2, sin2);
            }
            d17 = d12 + d11;
            i12 = i11 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d18;
            d15 = d13;
            d16 = d11;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    private void createStarPath() {
        double d11;
        int i11;
        float f11;
        float f12;
        float f13;
        double d12;
        float f14;
        float f15;
        double d13;
        float f16;
        float f17;
        float f18;
        float f19;
        float floatValue = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        double radians = Math.toRadians((baseKeyframeAnimation == null ? 0.0d : (double) baseKeyframeAnimation.getValue().floatValue()) - 90.0d);
        double d14 = (double) floatValue;
        float f21 = (float) (6.283185307179586d / d14);
        if (this.isReversed) {
            f21 *= -1.0f;
        }
        float f22 = f21 / 2.0f;
        float f23 = floatValue - ((float) ((int) floatValue));
        int i12 = (f23 > 0.0f ? 1 : (f23 == 0.0f ? 0 : -1));
        if (i12 != 0) {
            radians += (double) ((1.0f - f23) * f22);
        }
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        float floatValue4 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.getValue().floatValue() / 100.0f : 0.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        float floatValue5 = baseKeyframeAnimation3 != null ? baseKeyframeAnimation3.getValue().floatValue() / 100.0f : 0.0f;
        if (i12 != 0) {
            f11 = ((floatValue2 - floatValue3) * f23) + floatValue3;
            i11 = i12;
            double d15 = (double) f11;
            d11 = d14;
            f13 = (float) (d15 * Math.cos(radians));
            f12 = (float) (d15 * Math.sin(radians));
            this.path.moveTo(f13, f12);
            d12 = radians + ((double) ((f21 * f23) / 2.0f));
        } else {
            d11 = d14;
            i11 = i12;
            double d16 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d16);
            float sin = (float) (d16 * Math.sin(radians));
            this.path.moveTo(cos, sin);
            d12 = radians + ((double) f22);
            f13 = cos;
            f12 = sin;
            f11 = 0.0f;
        }
        double ceil = Math.ceil(d11) * 2.0d;
        float f24 = floatValue2;
        float f25 = floatValue3;
        int i13 = 0;
        boolean z11 = false;
        while (true) {
            double d17 = (double) i13;
            if (d17 < ceil) {
                float f26 = z11 ? f24 : f25;
                int i14 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
                if (i14 == 0 || d17 != ceil - 2.0d) {
                    f14 = f21;
                    f15 = f22;
                } else {
                    f14 = f21;
                    f15 = (f21 * f23) / 2.0f;
                }
                if (i14 == 0 || d17 != ceil - 1.0d) {
                    f16 = f22;
                    d13 = d17;
                    f17 = f26;
                } else {
                    f16 = f22;
                    d13 = d17;
                    f17 = f11;
                }
                double d18 = (double) f17;
                double d19 = ceil;
                float cos2 = (float) (d18 * Math.cos(d12));
                float sin2 = (float) (d18 * Math.sin(d12));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.path.lineTo(cos2, sin2);
                    f19 = floatValue4;
                    f18 = f11;
                } else {
                    f19 = floatValue4;
                    f18 = f11;
                    double atan2 = (double) ((float) (Math.atan2((double) f12, (double) f13) - 1.5707963267948966d));
                    float sin3 = (float) Math.sin(atan2);
                    float cos3 = (float) Math.cos(atan2);
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f27 = z11 ? f19 : floatValue5;
                    float f28 = z11 ? floatValue5 : f19;
                    float f29 = z11 ? f25 : f24;
                    float f31 = z11 ? f24 : f25;
                    float f32 = f29 * f27 * POLYSTAR_MAGIC_NUMBER;
                    float f33 = cos3 * f32;
                    float f34 = f32 * sin3;
                    float f35 = f31 * f28 * POLYSTAR_MAGIC_NUMBER;
                    float f36 = cos4 * f35;
                    float f37 = f35 * sin4;
                    if (i11 != 0) {
                        if (i13 == 0) {
                            f33 *= f23;
                            f34 *= f23;
                        } else if (d13 == d19 - 1.0d) {
                            f36 *= f23;
                            f37 *= f23;
                        }
                    }
                    this.path.cubicTo(f13 - f33, f12 - f34, cos2 + f36, sin2 + f37, cos2, sin2);
                }
                d12 += (double) f15;
                z11 = !z11;
                i13++;
                f13 = cos2;
                f12 = sin2;
                floatValue4 = f19;
                f11 = f18;
                f22 = f16;
                f21 = f14;
                ceil = d19;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public <T> void addValueCallback(T t11, LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t11 == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i11 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        if (i11 == 1) {
            createStarPath();
        } else if (i11 == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public void onValueChanged() {
        invalidate();
    }

    public void resolveKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i11, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Content content = list.get(i11);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.getType() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.addTrimPath(trimPathContent);
                    trimPathContent.addListener(this);
                }
            }
        }
    }
}
