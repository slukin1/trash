package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float ELLIPSE_CONTROL_POINT_PERCENTAGE = 0.55228f;
    private final CircleShape circleShape;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, CircleShape circleShape2) {
        this.name = circleShape2.getName();
        this.lottieDrawable = lottieDrawable2;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = circleShape2.getSize().createAnimation();
        this.sizeAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = circleShape2.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        this.circleShape = circleShape2;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public <T> void addValueCallback(T t11, LottieValueCallback<T> lottieValueCallback) {
        if (t11 == LottieProperty.ELLIPSE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
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
        if (this.circleShape.isHidden()) {
            this.isPathValid = true;
            return this.path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f11 = value.x / 2.0f;
        float f12 = value.y / 2.0f;
        float f13 = f11 * ELLIPSE_CONTROL_POINT_PERCENTAGE;
        float f14 = ELLIPSE_CONTROL_POINT_PERCENTAGE * f12;
        this.path.reset();
        if (this.circleShape.isReversed()) {
            float f15 = -f12;
            this.path.moveTo(0.0f, f15);
            float f16 = 0.0f - f13;
            float f17 = -f11;
            float f18 = 0.0f - f14;
            this.path.cubicTo(f16, f15, f17, f18, f17, 0.0f);
            float f19 = f14 + 0.0f;
            float f21 = f15;
            this.path.cubicTo(f17, f19, f16, f12, 0.0f, f12);
            float f22 = f13 + 0.0f;
            this.path.cubicTo(f22, f12, f11, f19, f11, 0.0f);
            this.path.cubicTo(f11, f18, f22, f21, 0.0f, f21);
        } else {
            float f23 = -f12;
            this.path.moveTo(0.0f, f23);
            float f24 = f13 + 0.0f;
            float f25 = 0.0f - f14;
            this.path.cubicTo(f24, f23, f11, f25, f11, 0.0f);
            float f26 = f14 + 0.0f;
            this.path.cubicTo(f11, f26, f24, f12, 0.0f, f12);
            float f27 = 0.0f - f13;
            float f28 = -f11;
            this.path.cubicTo(f27, f12, f28, f26, f28, 0.0f);
            float f29 = f23;
            this.path.cubicTo(f28, f25, f27, f29, 0.0f, f29);
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.offset(value2.x, value2.y);
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
