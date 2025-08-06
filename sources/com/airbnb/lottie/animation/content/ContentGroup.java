package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ContentGroup implements DrawingContent, PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private final List<Content> contents;
    private final boolean hidden;
    private final LottieDrawable lottieDrawable;
    private final Matrix matrix;
    private final String name;
    private final Paint offScreenPaint;
    private final RectF offScreenRectF;
    private final Path path;
    private List<PathContent> pathContents;
    private final RectF rect;
    private TransformKeyframeAnimation transformAnimation;

    public ContentGroup(LottieDrawable lottieDrawable2, BaseLayer baseLayer, ShapeGroup shapeGroup) {
        this(lottieDrawable2, baseLayer, shapeGroup.getName(), shapeGroup.isHidden(), contentsFromModels(lottieDrawable2, baseLayer, shapeGroup.getItems()), findTransform(shapeGroup.getItems()));
    }

    private static List<Content> contentsFromModels(LottieDrawable lottieDrawable2, BaseLayer baseLayer, List<ContentModel> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            Content content = list.get(i11).toContent(lottieDrawable2, baseLayer);
            if (content != null) {
                arrayList.add(content);
            }
        }
        return arrayList;
    }

    public static AnimatableTransform findTransform(List<ContentModel> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            ContentModel contentModel = list.get(i11);
            if (contentModel instanceof AnimatableTransform) {
                return (AnimatableTransform) contentModel;
            }
        }
        return null;
    }

    private boolean hasTwoOrMoreDrawableContent() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.contents.size(); i12++) {
            if ((this.contents.get(i12) instanceof DrawingContent) && (i11 = i11 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public <T> void addValueCallback(T t11, LottieValueCallback<T> lottieValueCallback) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            transformKeyframeAnimation.applyValueCallback(t11, lottieValueCallback);
        }
    }

    public void draw(Canvas canvas, Matrix matrix2, int i11) {
        if (!this.hidden) {
            this.matrix.set(matrix2);
            TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
            if (transformKeyframeAnimation != null) {
                this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
                i11 = (int) ((((((float) (this.transformAnimation.getOpacity() == null ? 100 : this.transformAnimation.getOpacity().getValue().intValue())) / 100.0f) * ((float) i11)) / 255.0f) * 255.0f);
            }
            boolean z11 = this.lottieDrawable.isApplyingOpacityToLayersEnabled() && hasTwoOrMoreDrawableContent() && i11 != 255;
            if (z11) {
                this.offScreenRectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                getBounds(this.offScreenRectF, this.matrix, true);
                this.offScreenPaint.setAlpha(i11);
                Utils.saveLayerCompat(canvas, this.offScreenRectF, this.offScreenPaint);
            }
            if (z11) {
                i11 = 255;
            }
            for (int size = this.contents.size() - 1; size >= 0; size--) {
                Content content = this.contents.get(size);
                if (content instanceof DrawingContent) {
                    ((DrawingContent) content).draw(canvas, this.matrix, i11);
                }
            }
            if (z11) {
                canvas.restore();
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix2, boolean z11) {
        this.matrix.set(matrix2);
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.preConcat(transformKeyframeAnimation.getMatrix());
        }
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof DrawingContent) {
                ((DrawingContent) content).getBounds(this.rect, this.matrix, z11);
                rectF.union(this.rect);
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public Path getPath() {
        this.matrix.reset();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            this.matrix.set(transformKeyframeAnimation.getMatrix());
        }
        this.path.reset();
        if (this.hidden) {
            return this.path;
        }
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            if (content instanceof PathContent) {
                this.path.addPath(((PathContent) content).getPath(), this.matrix);
            }
        }
        return this.path;
    }

    public List<PathContent> getPathList() {
        if (this.pathContents == null) {
            this.pathContents = new ArrayList();
            for (int i11 = 0; i11 < this.contents.size(); i11++) {
                Content content = this.contents.get(i11);
                if (content instanceof PathContent) {
                    this.pathContents.add((PathContent) content);
                }
            }
        }
        return this.pathContents;
    }

    public Matrix getTransformationMatrix() {
        TransformKeyframeAnimation transformKeyframeAnimation = this.transformAnimation;
        if (transformKeyframeAnimation != null) {
            return transformKeyframeAnimation.getMatrix();
        }
        this.matrix.reset();
        return this.matrix;
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.matches(getName(), i11) || "__container".equals(getName())) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i11)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i11)) {
                int incrementDepthBy = i11 + keyPath.incrementDepthBy(getName(), i11);
                for (int i12 = 0; i12 < this.contents.size(); i12++) {
                    Content content = this.contents.get(i12);
                    if (content instanceof KeyPathElement) {
                        ((KeyPathElement) content).resolveKeyPath(keyPath, incrementDepthBy, list, keyPath2);
                    }
                }
            }
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.contents.size());
        arrayList.addAll(list);
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Content content = this.contents.get(size);
            content.setContents(arrayList, this.contents.subList(0, size));
            arrayList.add(content);
        }
    }

    public ContentGroup(LottieDrawable lottieDrawable2, BaseLayer baseLayer, String str, boolean z11, List<Content> list, AnimatableTransform animatableTransform) {
        this.offScreenPaint = new LPaint();
        this.offScreenRectF = new RectF();
        this.matrix = new Matrix();
        this.path = new Path();
        this.rect = new RectF();
        this.name = str;
        this.lottieDrawable = lottieDrawable2;
        this.hidden = z11;
        this.contents = list;
        if (animatableTransform != null) {
            TransformKeyframeAnimation createAnimation = animatableTransform.createAnimation();
            this.transformAnimation = createAnimation;
            createAnimation.addAnimationsToLayer(baseLayer);
            this.transformAnimation.addListener(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof GreedyContent) {
                arrayList.add((GreedyContent) content);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((GreedyContent) arrayList.get(size2)).absorbContent(list.listIterator(list.size()));
        }
    }
}
