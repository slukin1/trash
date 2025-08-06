package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    private final BaseKeyframeAnimation<?, Float> cornerRadiusAnimation;
    private final boolean hidden;
    private boolean isPathValid;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final RectF rect = new RectF();
    private BaseKeyframeAnimation<Float, Float> roundedCornersAnimation = null;
    private final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.getName();
        this.hidden = rectangleShape.isHidden();
        this.lottieDrawable = lottieDrawable2;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = rectangleShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = rectangleShape.getSize().createAnimation();
        this.sizeAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = rectangleShape.getCornerRadius().createAnimation();
        this.cornerRadiusAnimation = createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public <T> void addValueCallback(T t11, LottieValueCallback<T> lottieValueCallback) {
        if (t11 == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        float f11;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f12 = value.x / 2.0f;
        float f13 = value.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.cornerRadiusAnimation;
        if (baseKeyframeAnimation2 == null) {
            f11 = 0.0f;
        } else {
            f11 = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
        }
        if (f11 == 0.0f && (baseKeyframeAnimation = this.roundedCornersAnimation) != null) {
            f11 = Math.min(baseKeyframeAnimation.getValue().floatValue(), Math.min(f12, f13));
        }
        float min = Math.min(f12, f13);
        if (f11 > min) {
            f11 = min;
        }
        PointF value2 = this.positionAnimation.getValue();
        this.path.moveTo(value2.x + f12, (value2.y - f13) + f11);
        this.path.lineTo(value2.x + f12, (value2.y + f13) - f11);
        int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i11 > 0) {
            RectF rectF = this.rect;
            float f14 = value2.x;
            float f15 = f11 * 2.0f;
            float f16 = value2.y;
            rectF.set((f14 + f12) - f15, (f16 + f13) - f15, f14 + f12, f16 + f13);
            this.path.arcTo(this.rect, 0.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x - f12) + f11, value2.y + f13);
        if (i11 > 0) {
            RectF rectF2 = this.rect;
            float f17 = value2.x;
            float f18 = value2.y;
            float f19 = f11 * 2.0f;
            rectF2.set(f17 - f12, (f18 + f13) - f19, (f17 - f12) + f19, f18 + f13);
            this.path.arcTo(this.rect, 90.0f, 90.0f, false);
        }
        this.path.lineTo(value2.x - f12, (value2.y - f13) + f11);
        if (i11 > 0) {
            RectF rectF3 = this.rect;
            float f21 = value2.x;
            float f22 = value2.y;
            float f23 = f11 * 2.0f;
            rectF3.set(f21 - f12, f22 - f13, (f21 - f12) + f23, (f22 - f13) + f23);
            this.path.arcTo(this.rect, 180.0f, 90.0f, false);
        }
        this.path.lineTo((value2.x + f12) - f11, value2.y - f13);
        if (i11 > 0) {
            RectF rectF4 = this.rect;
            float f24 = value2.x;
            float f25 = f11 * 2.0f;
            float f26 = value2.y;
            rectF4.set((f24 + f12) - f25, f26 - f13, f24 + f12, (f26 - f13) + f25);
            this.path.arcTo(this.rect, 270.0f, 90.0f, false);
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
            if (content instanceof RoundedCornersContent) {
                this.roundedCornersAnimation = ((RoundedCornersContent) content).getRoundedCorners();
            }
        }
    }
}
