package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.DrawingContent;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.MaskKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.KeyPathElement;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.huobi.view.roundimg.RoundedDrawable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseLayer implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElement {
    private static final int CLIP_SAVE_FLAG = 2;
    private static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    private static final int MATRIX_SAVE_FLAG = 1;
    private static final int SAVE_FLAGS = 19;
    private final List<BaseKeyframeAnimation<?, ?>> animations;
    public BlurMaskFilter blurMaskFilter;
    public float blurMaskFilterRadius;
    public final Matrix boundsMatrix;
    private final RectF canvasBounds;
    private final Matrix canvasMatrix = new Matrix();
    private final Paint clearPaint;
    private final Paint contentPaint = new LPaint(1);
    private final String drawTraceName;
    private final Paint dstInPaint = new LPaint(1, PorterDuff.Mode.DST_IN);
    private final Paint dstOutPaint = new LPaint(1, PorterDuff.Mode.DST_OUT);
    private FloatKeyframeAnimation inOutAnimation;
    public final Layer layerModel;
    public final LottieDrawable lottieDrawable;
    private MaskKeyframeAnimation mask;
    private final RectF maskBoundsRect;
    private final Matrix matrix = new Matrix();
    private final RectF matteBoundsRect;
    private BaseLayer matteLayer;
    private final Paint mattePaint;
    private boolean outlineMasksAndMattes;
    private Paint outlineMasksAndMattesPaint;
    private BaseLayer parentLayer;
    private List<BaseLayer> parentLayers;
    private final Path path = new Path();
    private final RectF rect;
    private final RectF tempMaskBoundsRect;
    public final TransformKeyframeAnimation transform;
    private boolean visible;

    /* renamed from: com.airbnb.lottie.model.layer.BaseLayer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode;
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(3:29|30|32)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        static {
            /*
                com.airbnb.lottie.model.content.Mask$MaskMode[] r0 = com.airbnb.lottie.model.content.Mask.MaskMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode = r0
                r1 = 1
                com.airbnb.lottie.model.content.Mask$MaskMode r2 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.Mask$MaskMode r3 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_SUBTRACT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.model.content.Mask$MaskMode r4 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_INTERSECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.airbnb.lottie.model.content.Mask$MaskMode r5 = com.airbnb.lottie.model.content.Mask.MaskMode.MASK_MODE_ADD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.airbnb.lottie.model.layer.Layer$LayerType[] r4 = com.airbnb.lottie.model.layer.Layer.LayerType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType = r4
                com.airbnb.lottie.model.layer.Layer$LayerType r5 = com.airbnb.lottie.model.layer.Layer.LayerType.SHAPE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x004e }
                com.airbnb.lottie.model.layer.Layer$LayerType r4 = com.airbnb.lottie.model.layer.Layer.LayerType.PRE_COMP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.SOLID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.IMAGE     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x006d }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.NULL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.TEXT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.airbnb.lottie.model.layer.Layer$LayerType r1 = com.airbnb.lottie.model.layer.Layer.LayerType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.BaseLayer.AnonymousClass1.<clinit>():void");
        }
    }

    public BaseLayer(LottieDrawable lottieDrawable2, Layer layer) {
        LPaint lPaint = new LPaint(1);
        this.mattePaint = lPaint;
        this.clearPaint = new LPaint(PorterDuff.Mode.CLEAR);
        this.rect = new RectF();
        this.canvasBounds = new RectF();
        this.maskBoundsRect = new RectF();
        this.matteBoundsRect = new RectF();
        this.tempMaskBoundsRect = new RectF();
        this.boundsMatrix = new Matrix();
        this.animations = new ArrayList();
        this.visible = true;
        this.blurMaskFilterRadius = 0.0f;
        this.lottieDrawable = lottieDrawable2;
        this.layerModel = layer;
        this.drawTraceName = layer.getName() + "#draw";
        if (layer.getMatteType() == Layer.MatteType.INVERT) {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        TransformKeyframeAnimation createAnimation = layer.getTransform().createAnimation();
        this.transform = createAnimation;
        createAnimation.addListener(this);
        if (layer.getMasks() != null && !layer.getMasks().isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer.getMasks());
            this.mask = maskKeyframeAnimation;
            for (BaseKeyframeAnimation<ShapeData, Path> addUpdateListener : maskKeyframeAnimation.getMaskAnimations()) {
                addUpdateListener.addUpdateListener(this);
            }
            for (BaseKeyframeAnimation next : this.mask.getOpacityAnimations()) {
                addAnimation(next);
                next.addUpdateListener(this);
            }
        }
        setupInOutAnimations();
    }

    private void applyAddMask(Canvas canvas, Matrix matrix2, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix2);
        this.contentPaint.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.path, this.contentPaint);
    }

    private void applyIntersectMask(Canvas canvas, Matrix matrix2, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix2);
        this.contentPaint.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.path, this.contentPaint);
        canvas.restore();
    }

    private void applyInvertedAddMask(Canvas canvas, Matrix matrix2, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix2);
        this.contentPaint.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyInvertedIntersectMask(Canvas canvas, Matrix matrix2, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix2);
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyInvertedSubtractMask(Canvas canvas, Matrix matrix2, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation, BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2) {
        Utils.saveLayerCompat(canvas, this.rect, this.dstOutPaint);
        canvas.drawRect(this.rect, this.contentPaint);
        this.dstOutPaint.setAlpha((int) (((float) baseKeyframeAnimation2.getValue().intValue()) * 2.55f));
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix2);
        canvas.drawPath(this.path, this.dstOutPaint);
        canvas.restore();
    }

    private void applyMasks(Canvas canvas, Matrix matrix2) {
        L.beginSection("Layer#saveLayer");
        Utils.saveLayerCompat(canvas, this.rect, this.dstInPaint, 19);
        if (Build.VERSION.SDK_INT < 28) {
            clearCanvas(canvas);
        }
        L.endSection("Layer#saveLayer");
        for (int i11 = 0; i11 < this.mask.getMasks().size(); i11++) {
            Mask mask2 = this.mask.getMasks().get(i11);
            BaseKeyframeAnimation baseKeyframeAnimation = this.mask.getMaskAnimations().get(i11);
            BaseKeyframeAnimation baseKeyframeAnimation2 = this.mask.getOpacityAnimations().get(i11);
            int i12 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask2.getMaskMode().ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    if (i11 == 0) {
                        this.contentPaint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
                        this.contentPaint.setAlpha(255);
                        canvas.drawRect(this.rect, this.contentPaint);
                    }
                    if (mask2.isInverted()) {
                        applyInvertedSubtractMask(canvas, matrix2, baseKeyframeAnimation, baseKeyframeAnimation2);
                    } else {
                        applySubtractMask(canvas, matrix2, baseKeyframeAnimation);
                    }
                } else if (i12 != 3) {
                    if (i12 == 4) {
                        if (mask2.isInverted()) {
                            applyInvertedAddMask(canvas, matrix2, baseKeyframeAnimation, baseKeyframeAnimation2);
                        } else {
                            applyAddMask(canvas, matrix2, baseKeyframeAnimation, baseKeyframeAnimation2);
                        }
                    }
                } else if (mask2.isInverted()) {
                    applyInvertedIntersectMask(canvas, matrix2, baseKeyframeAnimation, baseKeyframeAnimation2);
                } else {
                    applyIntersectMask(canvas, matrix2, baseKeyframeAnimation, baseKeyframeAnimation2);
                }
            } else if (areAllMasksNone()) {
                this.contentPaint.setAlpha(255);
                canvas.drawRect(this.rect, this.contentPaint);
            }
        }
        L.beginSection("Layer#restoreLayer");
        canvas.restore();
        L.endSection("Layer#restoreLayer");
    }

    private void applySubtractMask(Canvas canvas, Matrix matrix2, BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation) {
        this.path.set(baseKeyframeAnimation.getValue());
        this.path.transform(matrix2);
        canvas.drawPath(this.path, this.dstOutPaint);
    }

    private boolean areAllMasksNone() {
        if (this.mask.getMaskAnimations().isEmpty()) {
            return false;
        }
        for (int i11 = 0; i11 < this.mask.getMasks().size(); i11++) {
            if (this.mask.getMasks().get(i11).getMaskMode() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void buildParentLayerListIfNeeded() {
        if (this.parentLayers == null) {
            if (this.parentLayer == null) {
                this.parentLayers = Collections.emptyList();
                return;
            }
            this.parentLayers = new ArrayList();
            for (BaseLayer baseLayer = this.parentLayer; baseLayer != null; baseLayer = baseLayer.parentLayer) {
                this.parentLayers.add(baseLayer);
            }
        }
    }

    private void clearCanvas(Canvas canvas) {
        L.beginSection("Layer#clearLayer");
        RectF rectF = this.rect;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.clearPaint);
        L.endSection("Layer#clearLayer");
    }

    public static BaseLayer forModel(CompositionLayer compositionLayer, Layer layer, LottieDrawable lottieDrawable2, LottieComposition lottieComposition) {
        switch (AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$LayerType[layer.getLayerType().ordinal()]) {
            case 1:
                return new ShapeLayer(lottieDrawable2, layer, compositionLayer);
            case 2:
                return new CompositionLayer(lottieDrawable2, layer, lottieComposition.getPrecomps(layer.getRefId()), lottieComposition);
            case 3:
                return new SolidLayer(lottieDrawable2, layer);
            case 4:
                return new ImageLayer(lottieDrawable2, layer);
            case 5:
                return new NullLayer(lottieDrawable2, layer);
            case 6:
                return new TextLayer(lottieDrawable2, layer);
            default:
                Logger.warning("Unknown layer type " + layer.getLayerType());
                return null;
        }
    }

    private void intersectBoundsWithMask(RectF rectF, Matrix matrix2) {
        this.maskBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (hasMasksOnThisLayer()) {
            int size = this.mask.getMasks().size();
            for (int i11 = 0; i11 < size; i11++) {
                Mask mask2 = this.mask.getMasks().get(i11);
                Path path2 = (Path) this.mask.getMaskAnimations().get(i11).getValue();
                if (path2 != null) {
                    this.path.set(path2);
                    this.path.transform(matrix2);
                    int i12 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$Mask$MaskMode[mask2.getMaskMode().ordinal()];
                    if (i12 != 1 && i12 != 2) {
                        if ((i12 != 3 && i12 != 4) || !mask2.isInverted()) {
                            this.path.computeBounds(this.tempMaskBoundsRect, false);
                            if (i11 == 0) {
                                this.maskBoundsRect.set(this.tempMaskBoundsRect);
                            } else {
                                RectF rectF2 = this.maskBoundsRect;
                                rectF2.set(Math.min(rectF2.left, this.tempMaskBoundsRect.left), Math.min(this.maskBoundsRect.top, this.tempMaskBoundsRect.top), Math.max(this.maskBoundsRect.right, this.tempMaskBoundsRect.right), Math.max(this.maskBoundsRect.bottom, this.tempMaskBoundsRect.bottom));
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            if (!rectF.intersect(this.maskBoundsRect)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void intersectBoundsWithMatte(RectF rectF, Matrix matrix2) {
        if (hasMatteOnThisLayer() && this.layerModel.getMatteType() != Layer.MatteType.INVERT) {
            this.matteBoundsRect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.matteLayer.getBounds(this.matteBoundsRect, matrix2, true);
            if (!rectF.intersect(this.matteBoundsRect)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void invalidateSelf() {
        this.lottieDrawable.invalidateSelf();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupInOutAnimations$0() {
        setVisible(this.inOutAnimation.getFloatValue() == 1.0f);
    }

    private void recordRenderTime(float f11) {
        this.lottieDrawable.getComposition().getPerformanceTracker().recordRenderTime(this.layerModel.getName(), f11);
    }

    private void setVisible(boolean z11) {
        if (z11 != this.visible) {
            this.visible = z11;
            invalidateSelf();
        }
    }

    private void setupInOutAnimations() {
        boolean z11 = true;
        if (!this.layerModel.getInOutKeyframes().isEmpty()) {
            FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.layerModel.getInOutKeyframes());
            this.inOutAnimation = floatKeyframeAnimation;
            floatKeyframeAnimation.setIsDiscrete();
            this.inOutAnimation.addUpdateListener(new a(this));
            if (((Float) this.inOutAnimation.getValue()).floatValue() != 1.0f) {
                z11 = false;
            }
            setVisible(z11);
            addAnimation(this.inOutAnimation);
            return;
        }
        setVisible(true);
    }

    public void addAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation != null) {
            this.animations.add(baseKeyframeAnimation);
        }
    }

    public <T> void addValueCallback(T t11, LottieValueCallback<T> lottieValueCallback) {
        this.transform.applyValueCallback(t11, lottieValueCallback);
    }

    public void draw(Canvas canvas, Matrix matrix2, int i11) {
        Paint paint;
        L.beginSection(this.drawTraceName);
        if (!this.visible || this.layerModel.isHidden()) {
            L.endSection(this.drawTraceName);
            return;
        }
        buildParentLayerListIfNeeded();
        L.beginSection("Layer#parentMatrix");
        this.matrix.reset();
        this.matrix.set(matrix2);
        for (int size = this.parentLayers.size() - 1; size >= 0; size--) {
            this.matrix.preConcat(this.parentLayers.get(size).transform.getMatrix());
        }
        L.endSection("Layer#parentMatrix");
        int intValue = (int) ((((((float) i11) / 255.0f) * ((float) (this.transform.getOpacity() == null ? 100 : this.transform.getOpacity().getValue().intValue()))) / 100.0f) * 255.0f);
        if (hasMatteOnThisLayer() || hasMasksOnThisLayer()) {
            L.beginSection("Layer#computeBounds");
            getBounds(this.rect, this.matrix, false);
            intersectBoundsWithMatte(this.rect, matrix2);
            this.matrix.preConcat(this.transform.getMatrix());
            intersectBoundsWithMask(this.rect, this.matrix);
            this.canvasBounds.set(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
            canvas.getMatrix(this.canvasMatrix);
            if (!this.canvasMatrix.isIdentity()) {
                Matrix matrix3 = this.canvasMatrix;
                matrix3.invert(matrix3);
                this.canvasMatrix.mapRect(this.canvasBounds);
            }
            if (!this.rect.intersect(this.canvasBounds)) {
                this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            L.endSection("Layer#computeBounds");
            if (this.rect.width() >= 1.0f && this.rect.height() >= 1.0f) {
                L.beginSection("Layer#saveLayer");
                this.contentPaint.setAlpha(255);
                Utils.saveLayerCompat(canvas, this.rect, this.contentPaint);
                L.endSection("Layer#saveLayer");
                clearCanvas(canvas);
                L.beginSection("Layer#drawLayer");
                drawLayer(canvas, this.matrix, intValue);
                L.endSection("Layer#drawLayer");
                if (hasMasksOnThisLayer()) {
                    applyMasks(canvas, this.matrix);
                }
                if (hasMatteOnThisLayer()) {
                    L.beginSection("Layer#drawMatte");
                    L.beginSection("Layer#saveLayer");
                    Utils.saveLayerCompat(canvas, this.rect, this.mattePaint, 19);
                    L.endSection("Layer#saveLayer");
                    clearCanvas(canvas);
                    this.matteLayer.draw(canvas, matrix2, intValue);
                    L.beginSection("Layer#restoreLayer");
                    canvas.restore();
                    L.endSection("Layer#restoreLayer");
                    L.endSection("Layer#drawMatte");
                }
                L.beginSection("Layer#restoreLayer");
                canvas.restore();
                L.endSection("Layer#restoreLayer");
            }
            if (this.outlineMasksAndMattes && (paint = this.outlineMasksAndMattesPaint) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.outlineMasksAndMattesPaint.setColor(-251901);
                this.outlineMasksAndMattesPaint.setStrokeWidth(4.0f);
                canvas.drawRect(this.rect, this.outlineMasksAndMattesPaint);
                this.outlineMasksAndMattesPaint.setStyle(Paint.Style.FILL);
                this.outlineMasksAndMattesPaint.setColor(1357638635);
                canvas.drawRect(this.rect, this.outlineMasksAndMattesPaint);
            }
            recordRenderTime(L.endSection(this.drawTraceName));
            return;
        }
        this.matrix.preConcat(this.transform.getMatrix());
        L.beginSection("Layer#drawLayer");
        drawLayer(canvas, this.matrix, intValue);
        L.endSection("Layer#drawLayer");
        recordRenderTime(L.endSection(this.drawTraceName));
    }

    public abstract void drawLayer(Canvas canvas, Matrix matrix2, int i11);

    public BlurEffect getBlurEffect() {
        return this.layerModel.getBlurEffect();
    }

    public BlurMaskFilter getBlurMaskFilter(float f11) {
        if (this.blurMaskFilterRadius == f11) {
            return this.blurMaskFilter;
        }
        BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(f11 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.blurMaskFilter = blurMaskFilter2;
        this.blurMaskFilterRadius = f11;
        return blurMaskFilter2;
    }

    public void getBounds(RectF rectF, Matrix matrix2, boolean z11) {
        this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
        buildParentLayerListIfNeeded();
        this.boundsMatrix.set(matrix2);
        if (z11) {
            List<BaseLayer> list = this.parentLayers;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.boundsMatrix.preConcat(this.parentLayers.get(size).transform.getMatrix());
                }
            } else {
                BaseLayer baseLayer = this.parentLayer;
                if (baseLayer != null) {
                    this.boundsMatrix.preConcat(baseLayer.transform.getMatrix());
                }
            }
        }
        this.boundsMatrix.preConcat(this.transform.getMatrix());
    }

    public DropShadowEffect getDropShadowEffect() {
        return this.layerModel.getDropShadowEffect();
    }

    public Layer getLayerModel() {
        return this.layerModel;
    }

    public String getName() {
        return this.layerModel.getName();
    }

    public boolean hasMasksOnThisLayer() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.mask;
        return maskKeyframeAnimation != null && !maskKeyframeAnimation.getMaskAnimations().isEmpty();
    }

    public boolean hasMatteOnThisLayer() {
        return this.matteLayer != null;
    }

    public void onValueChanged() {
        invalidateSelf();
    }

    public void removeAnimation(BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        this.animations.remove(baseKeyframeAnimation);
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
    }

    public void resolveKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            KeyPath addKey = keyPath2.addKey(baseLayer.getName());
            if (keyPath.fullyResolvesTo(this.matteLayer.getName(), i11)) {
                list.add(addKey.resolve(this.matteLayer));
            }
            if (keyPath.propagateToChildren(getName(), i11)) {
                this.matteLayer.resolveChildKeyPath(keyPath, keyPath.incrementDepthBy(this.matteLayer.getName(), i11) + i11, list, addKey);
            }
        }
        if (keyPath.matches(getName(), i11)) {
            if (!"__container".equals(getName())) {
                keyPath2 = keyPath2.addKey(getName());
                if (keyPath.fullyResolvesTo(getName(), i11)) {
                    list.add(keyPath2.resolve(this));
                }
            }
            if (keyPath.propagateToChildren(getName(), i11)) {
                resolveChildKeyPath(keyPath, i11 + keyPath.incrementDepthBy(getName(), i11), list, keyPath2);
            }
        }
    }

    public void setContents(List<Content> list, List<Content> list2) {
    }

    public void setMatteLayer(BaseLayer baseLayer) {
        this.matteLayer = baseLayer;
    }

    public void setOutlineMasksAndMattes(boolean z11) {
        if (z11 && this.outlineMasksAndMattesPaint == null) {
            this.outlineMasksAndMattesPaint = new LPaint();
        }
        this.outlineMasksAndMattes = z11;
    }

    public void setParentLayer(BaseLayer baseLayer) {
        this.parentLayer = baseLayer;
    }

    public void setProgress(float f11) {
        this.transform.setProgress(f11);
        if (this.mask != null) {
            for (int i11 = 0; i11 < this.mask.getMaskAnimations().size(); i11++) {
                this.mask.getMaskAnimations().get(i11).setProgress(f11);
            }
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.inOutAnimation;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f11);
        }
        BaseLayer baseLayer = this.matteLayer;
        if (baseLayer != null) {
            baseLayer.setProgress(f11);
        }
        for (int i12 = 0; i12 < this.animations.size(); i12++) {
            this.animations.get(i12).setProgress(f11);
        }
    }
}
