package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private int alpha;
    /* access modifiers changed from: private */
    public final LottieValueAnimator animator;
    private Rect canvasClipBounds;
    private RectF canvasClipBoundsRectF;
    private boolean clipToCompositionBounds;
    private LottieComposition composition;
    /* access modifiers changed from: private */
    public CompositionLayer compositionLayer;
    private boolean enableMergePaths;
    public FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private boolean ignoreSystemAnimationsDisabled = false;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks = new ArrayList<>();
    private boolean maintainOriginalImageBounds;
    private OnVisibleAction onVisibleAction = OnVisibleAction.NONE;
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private RenderMode renderMode;
    private final Matrix renderingMatrix;
    private boolean safeMode = false;
    private Bitmap softwareRenderingBitmap;
    private Canvas softwareRenderingCanvas;
    private Rect softwareRenderingDstBoundsRect;
    private RectF softwareRenderingDstBoundsRectF;
    private Matrix softwareRenderingOriginalCanvasMatrix;
    private Matrix softwareRenderingOriginalCanvasMatrixInverse;
    private Paint softwareRenderingPaint;
    private Rect softwareRenderingSrcBoundsRect;
    private RectF softwareRenderingTransformedBounds;
    private boolean systemAnimationsEnabled = true;
    public TextDelegate textDelegate;
    private boolean useSoftwareRendering;

    public interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    public enum OnVisibleAction {
        NONE,
        PLAY,
        RESUME
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        AnonymousClass1 r32 = new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.compositionLayer != null) {
                    LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
                }
            }
        };
        this.progressUpdateListener = r32;
        this.maintainOriginalImageBounds = false;
        this.clipToCompositionBounds = true;
        this.alpha = 255;
        this.renderMode = RenderMode.AUTOMATIC;
        this.useSoftwareRendering = false;
        this.renderingMatrix = new Matrix();
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(r32);
    }

    private boolean animationsEnabled() {
        return this.systemAnimationsEnabled || this.ignoreSystemAnimationsDisabled;
    }

    private void buildCompositionLayer() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            CompositionLayer compositionLayer2 = new CompositionLayer(this, LayerParser.parse(lottieComposition), lottieComposition.getLayers(), lottieComposition);
            this.compositionLayer = compositionLayer2;
            if (this.outlineMasksAndMattes) {
                compositionLayer2.setOutlineMasksAndMattes(true);
            }
            this.compositionLayer.setClipToCompositionBounds(this.clipToCompositionBounds);
        }
    }

    private void computeRenderMode() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            this.useSoftwareRendering = this.renderMode.useSoftwareRendering(Build.VERSION.SDK_INT, lottieComposition.hasDashPattern(), lottieComposition.getMaskAndMatteCount());
        }
    }

    private void convertRect(RectF rectF, Rect rect) {
        rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
    }

    private void drawDirectlyToCanvas(Canvas canvas) {
        CompositionLayer compositionLayer2 = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer2 != null && lottieComposition != null) {
            this.renderingMatrix.reset();
            Rect bounds = getBounds();
            if (!bounds.isEmpty()) {
                float height = ((float) bounds.height()) / ((float) lottieComposition.getBounds().height());
                this.renderingMatrix.preScale(((float) bounds.width()) / ((float) lottieComposition.getBounds().width()), height);
            }
            compositionLayer2.draw(canvas, this.renderingMatrix, this.alpha);
        }
    }

    private void ensureSoftwareRenderingBitmap(int i11, int i12) {
        Bitmap bitmap = this.softwareRenderingBitmap;
        if (bitmap == null || bitmap.getWidth() < i11 || this.softwareRenderingBitmap.getHeight() < i12) {
            Bitmap createBitmap = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
            this.softwareRenderingBitmap = createBitmap;
            this.softwareRenderingCanvas.setBitmap(createBitmap);
            this.isDirty = true;
        } else if (this.softwareRenderingBitmap.getWidth() > i11 || this.softwareRenderingBitmap.getHeight() > i12) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.softwareRenderingBitmap, 0, 0, i11, i12);
            this.softwareRenderingBitmap = createBitmap2;
            this.softwareRenderingCanvas.setBitmap(createBitmap2);
            this.isDirty = true;
        }
    }

    private void ensureSoftwareRenderingObjectsInitialized() {
        if (this.softwareRenderingCanvas == null) {
            this.softwareRenderingCanvas = new Canvas();
            this.softwareRenderingTransformedBounds = new RectF();
            this.softwareRenderingOriginalCanvasMatrix = new Matrix();
            this.softwareRenderingOriginalCanvasMatrixInverse = new Matrix();
            this.canvasClipBounds = new Rect();
            this.canvasClipBoundsRectF = new RectF();
            this.softwareRenderingPaint = new LPaint();
            this.softwareRenderingSrcBoundsRect = new Rect();
            this.softwareRenderingDstBoundsRect = new Rect();
            this.softwareRenderingDstBoundsRectF = new RectF();
        }
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private ImageAssetManager getImageAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager2 = this.imageAssetManager;
        if (imageAssetManager2 != null && !imageAssetManager2.hasSameContext(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    private boolean ignoreCanvasClipBounds() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        if (Build.VERSION.SDK_INT < 18 || !(parent instanceof ViewGroup)) {
            return false;
        }
        return !((ViewGroup) parent).getClipChildren();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addValueCallback$14(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback, LottieComposition lottieComposition) {
        addValueCallback(keyPath, obj, lottieValueCallback);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$playAnimation$0(LottieComposition lottieComposition) {
        playAnimation();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$resumeAnimation$1(LottieComposition lottieComposition) {
        resumeAnimation();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrame$12(int i11, LottieComposition lottieComposition) {
        setFrame(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxFrame$4(int i11, LottieComposition lottieComposition) {
        setMaxFrame(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxFrame$7(String str, LottieComposition lottieComposition) {
        setMaxFrame(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMaxProgress$5(float f11, LottieComposition lottieComposition) {
        setMaxProgress(f11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxFrame$10(int i11, int i12, LottieComposition lottieComposition) {
        setMinAndMaxFrame(i11, i12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxFrame$8(String str, LottieComposition lottieComposition) {
        setMinAndMaxFrame(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxFrame$9(String str, String str2, boolean z11, LottieComposition lottieComposition) {
        setMinAndMaxFrame(str, str2, z11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinAndMaxProgress$11(float f11, float f12, LottieComposition lottieComposition) {
        setMinAndMaxProgress(f11, f12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinFrame$2(int i11, LottieComposition lottieComposition) {
        setMinFrame(i11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinFrame$6(String str, LottieComposition lottieComposition) {
        setMinFrame(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setMinProgress$3(float f11, LottieComposition lottieComposition) {
        setMinProgress(f11);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setProgress$13(float f11, LottieComposition lottieComposition) {
        setProgress(f11);
    }

    private void renderAndDrawAsBitmap(Canvas canvas, CompositionLayer compositionLayer2) {
        if (this.composition != null && compositionLayer2 != null) {
            ensureSoftwareRenderingObjectsInitialized();
            canvas.getMatrix(this.softwareRenderingOriginalCanvasMatrix);
            canvas.getClipBounds(this.canvasClipBounds);
            convertRect(this.canvasClipBounds, this.canvasClipBoundsRectF);
            this.softwareRenderingOriginalCanvasMatrix.mapRect(this.canvasClipBoundsRectF);
            convertRect(this.canvasClipBoundsRectF, this.canvasClipBounds);
            if (this.clipToCompositionBounds) {
                this.softwareRenderingTransformedBounds.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
            } else {
                compositionLayer2.getBounds(this.softwareRenderingTransformedBounds, (Matrix) null, false);
            }
            this.softwareRenderingOriginalCanvasMatrix.mapRect(this.softwareRenderingTransformedBounds);
            Rect bounds = getBounds();
            float width = ((float) bounds.width()) / ((float) getIntrinsicWidth());
            float height = ((float) bounds.height()) / ((float) getIntrinsicHeight());
            scaleRect(this.softwareRenderingTransformedBounds, width, height);
            if (!ignoreCanvasClipBounds()) {
                RectF rectF = this.softwareRenderingTransformedBounds;
                Rect rect = this.canvasClipBounds;
                rectF.intersect((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
            }
            int ceil = (int) Math.ceil((double) this.softwareRenderingTransformedBounds.width());
            int ceil2 = (int) Math.ceil((double) this.softwareRenderingTransformedBounds.height());
            if (ceil != 0 && ceil2 != 0) {
                ensureSoftwareRenderingBitmap(ceil, ceil2);
                if (this.isDirty) {
                    this.renderingMatrix.set(this.softwareRenderingOriginalCanvasMatrix);
                    this.renderingMatrix.preScale(width, height);
                    Matrix matrix = this.renderingMatrix;
                    RectF rectF2 = this.softwareRenderingTransformedBounds;
                    matrix.postTranslate(-rectF2.left, -rectF2.top);
                    this.softwareRenderingBitmap.eraseColor(0);
                    compositionLayer2.draw(this.softwareRenderingCanvas, this.renderingMatrix, this.alpha);
                    this.softwareRenderingOriginalCanvasMatrix.invert(this.softwareRenderingOriginalCanvasMatrixInverse);
                    this.softwareRenderingOriginalCanvasMatrixInverse.mapRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingTransformedBounds);
                    convertRect(this.softwareRenderingDstBoundsRectF, this.softwareRenderingDstBoundsRect);
                }
                this.softwareRenderingSrcBoundsRect.set(0, 0, ceil, ceil2);
                canvas.drawBitmap(this.softwareRenderingBitmap, this.softwareRenderingSrcBoundsRect, this.softwareRenderingDstBoundsRect, this.softwareRenderingPaint);
            }
        }
    }

    private void scaleRect(RectF rectF, float f11, float f12) {
        rectF.set(rectF.left * f11, rectF.top * f12, rectF.right * f11, rectF.bottom * f12);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t11, LottieValueCallback<T> lottieValueCallback) {
        CompositionLayer compositionLayer2 = this.compositionLayer;
        if (compositionLayer2 == null) {
            this.lazyCompositionTasks.add(new s(this, keyPath, t11, lottieValueCallback));
            return;
        }
        boolean z11 = true;
        if (keyPath == KeyPath.COMPOSITION) {
            compositionLayer2.addValueCallback(t11, lottieValueCallback);
        } else if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t11, lottieValueCallback);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i11 = 0; i11 < resolveKeyPath.size(); i11++) {
                resolveKeyPath.get(i11).getResolvedElement().addValueCallback(t11, lottieValueCallback);
            }
            z11 = true ^ resolveKeyPath.isEmpty();
        }
        if (z11) {
            invalidateSelf();
            if (t11 == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    @Deprecated
    public void disableExtraScaleModeInFitXY() {
    }

    public void draw(Canvas canvas) {
        L.beginSection("Drawable#draw");
        if (this.safeMode) {
            try {
                if (this.useSoftwareRendering) {
                    renderAndDrawAsBitmap(canvas, this.compositionLayer);
                } else {
                    drawDirectlyToCanvas(canvas);
                }
            } catch (Throwable th2) {
                Logger.error("Lottie crashed in draw!", th2);
            }
        } else if (this.useSoftwareRendering) {
            renderAndDrawAsBitmap(canvas, this.compositionLayer);
        } else {
            drawDirectlyToCanvas(canvas);
        }
        this.isDirty = false;
        L.endSection("Drawable#draw");
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public Bitmap getBitmapForId(String str) {
        ImageAssetManager imageAssetManager2 = getImageAssetManager();
        if (imageAssetManager2 != null) {
            return imageAssetManager2.bitmapForId(str);
        }
        return null;
    }

    public boolean getClipToCompositionBounds() {
        return this.clipToCompositionBounds;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    @Deprecated
    public Bitmap getImageAsset(String str) {
        ImageAssetManager imageAssetManager2 = getImageAssetManager();
        if (imageAssetManager2 != null) {
            return imageAssetManager2.bitmapForId(str);
        }
        LottieComposition lottieComposition = this.composition;
        LottieImageAsset lottieImageAsset = lottieComposition == null ? null : lottieComposition.getImages().get(str);
        if (lottieImageAsset != null) {
            return lottieImageAsset.getBitmap();
        }
        return null;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public int getIntrinsicHeight() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.getBounds().height();
    }

    public int getIntrinsicWidth() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return -1;
        }
        return lottieComposition.getBounds().width();
    }

    public LottieImageAsset getLottieImageAssetForId(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return null;
        }
        return lottieComposition.getImages().get(str);
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.maintainOriginalImageBounds;
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public int getOpacity() {
        return -3;
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public RenderMode getRenderMode() {
        return this.useSoftwareRendering ? RenderMode.SOFTWARE : RenderMode.HARDWARE;
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    @SuppressLint({"WrongConstant"})
    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public Typeface getTypeface(String str, String str2) {
        FontAssetManager fontAssetManager2 = getFontAssetManager();
        if (fontAssetManager2 != null) {
            return fontAssetManager2.getTypeface(str, str2);
        }
        return null;
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer2 = this.compositionLayer;
        return compositionLayer2 != null && compositionLayer2.hasMasks();
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer2 = this.compositionLayer;
        return compositionLayer2 != null && compositionLayer2.hasMatte();
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public void invalidateSelf() {
        if (!this.isDirty) {
            this.isDirty = true;
            Drawable.Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isAnimatingOrWillAnimateOnVisible() {
        if (isVisible()) {
            return this.animator.isRunning();
        }
        OnVisibleAction onVisibleAction2 = this.onVisibleAction;
        return onVisibleAction2 == OnVisibleAction.PLAY || onVisibleAction2 == OnVisibleAction.RESUME;
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public boolean isRunning() {
        return isAnimating();
    }

    @Deprecated
    public void loop(boolean z11) {
        this.animator.setRepeatCount(z11 ? -1 : 0);
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
        if (!isVisible()) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
    }

    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new x(this));
            return;
        }
        computeRenderMode();
        if (animationsEnabled() || getRepeatCount() == 0) {
            if (isVisible()) {
                this.animator.playAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.PLAY;
            }
        }
        if (!animationsEnabled()) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        this.animator.addUpdateListener(this.progressUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new q(this));
            return;
        }
        computeRenderMode();
        if (animationsEnabled() || getRepeatCount() == 0) {
            if (isVisible()) {
                this.animator.resumeAnimation();
                this.onVisibleAction = OnVisibleAction.NONE;
            } else {
                this.onVisibleAction = OnVisibleAction.RESUME;
            }
        }
        if (!animationsEnabled()) {
            setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
            this.animator.endAnimation();
            if (!isVisible()) {
                this.onVisibleAction = OnVisibleAction.NONE;
            }
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j11);
        }
    }

    public void setAlpha(int i11) {
        this.alpha = i11;
        invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean z11) {
        this.isApplyingOpacityToLayersEnabled = z11;
    }

    public void setClipToCompositionBounds(boolean z11) {
        if (z11 != this.clipToCompositionBounds) {
            this.clipToCompositionBounds = z11;
            CompositionLayer compositionLayer2 = this.compositionLayer;
            if (compositionLayer2 != null) {
                compositionLayer2.setClipToCompositionBounds(z11);
            }
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = true;
        clearComposition();
        this.composition = lottieComposition;
        buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        setProgress(this.animator.getAnimatedFraction());
        Iterator it2 = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it2.hasNext()) {
            LazyCompositionTask lazyCompositionTask = (LazyCompositionTask) it2.next();
            if (lazyCompositionTask != null) {
                lazyCompositionTask.run(lottieComposition);
            }
            it2.remove();
        }
        this.lazyCompositionTasks.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
        computeRenderMode();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable((Drawable) null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate2) {
        this.fontAssetDelegate = fontAssetDelegate2;
        FontAssetManager fontAssetManager2 = this.fontAssetManager;
        if (fontAssetManager2 != null) {
            fontAssetManager2.setDelegate(fontAssetDelegate2);
        }
    }

    public void setFrame(int i11) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new d0(this, i11));
        } else {
            this.animator.setFrame((float) i11);
        }
    }

    public void setIgnoreDisabledSystemAnimations(boolean z11) {
        this.ignoreSystemAnimationsDisabled = z11;
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate2) {
        this.imageAssetDelegate = imageAssetDelegate2;
        ImageAssetManager imageAssetManager2 = this.imageAssetManager;
        if (imageAssetManager2 != null) {
            imageAssetManager2.setDelegate(imageAssetDelegate2);
        }
    }

    public void setImagesAssetsFolder(String str) {
        this.imageAssetsFolder = str;
    }

    public void setMaintainOriginalImageBounds(boolean z11) {
        this.maintainOriginalImageBounds = z11;
    }

    public void setMaxFrame(int i11) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new e0(this, i11));
        } else {
            this.animator.setMaxFrame(((float) i11) + 0.99f);
        }
    }

    public void setMaxProgress(float f11) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new y(this, f11));
        } else {
            this.animator.setMaxFrame(MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f11));
        }
    }

    public void setMinAndMaxFrame(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new v(this, str));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i11 = (int) marker.startFrame;
            setMinAndMaxFrame(i11, ((int) marker.durationFrames) + i11);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public void setMinAndMaxProgress(float f11, float f12) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new b0(this, f11, f12));
        } else {
            setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f11), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f12));
        }
    }

    public void setMinFrame(int i11) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new c0(this, i11));
        } else {
            this.animator.setMinFrame(i11);
        }
    }

    public void setMinProgress(float f11) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new z(this, f11));
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f11));
        }
    }

    public void setOutlineMasksAndMattes(boolean z11) {
        if (this.outlineMasksAndMattes != z11) {
            this.outlineMasksAndMattes = z11;
            CompositionLayer compositionLayer2 = this.compositionLayer;
            if (compositionLayer2 != null) {
                compositionLayer2.setOutlineMasksAndMattes(z11);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z11) {
        this.performanceTrackingEnabled = z11;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z11);
        }
    }

    public void setProgress(float f11) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new a0(this, f11));
            return;
        }
        L.beginSection("Drawable#setProgress");
        this.animator.setFrame(this.composition.getFrameForProgress(f11));
        L.endSection("Drawable#setProgress");
    }

    public void setRenderMode(RenderMode renderMode2) {
        this.renderMode = renderMode2;
        computeRenderMode();
    }

    public void setRepeatCount(int i11) {
        this.animator.setRepeatCount(i11);
    }

    public void setRepeatMode(int i11) {
        this.animator.setRepeatMode(i11);
    }

    public void setSafeMode(boolean z11) {
        this.safeMode = z11;
    }

    public void setSpeed(float f11) {
        this.animator.setSpeed(f11);
    }

    public void setSystemAnimationsAreEnabled(Boolean bool) {
        this.systemAnimationsEnabled = bool.booleanValue();
    }

    public void setTextDelegate(TextDelegate textDelegate2) {
        this.textDelegate = textDelegate2;
    }

    public boolean setVisible(boolean z11, boolean z12) {
        boolean z13 = !isVisible();
        boolean visible = super.setVisible(z11, z12);
        if (z11) {
            OnVisibleAction onVisibleAction2 = this.onVisibleAction;
            if (onVisibleAction2 == OnVisibleAction.PLAY) {
                playAnimation();
            } else if (onVisibleAction2 == OnVisibleAction.RESUME) {
                resumeAnimation();
            }
        } else if (this.animator.isRunning()) {
            pauseAnimation();
            this.onVisibleAction = OnVisibleAction.RESUME;
        } else if (!z13) {
            this.onVisibleAction = OnVisibleAction.NONE;
        }
        return visible;
    }

    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || !((View) callback).isInEditMode()) {
            playAnimation();
        }
    }

    public void stop() {
        endAnimation();
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        ImageAssetManager imageAssetManager2 = getImageAssetManager();
        if (imageAssetManager2 == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = imageAssetManager2.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public boolean useTextGlyphs() {
        return this.textDelegate == null && this.composition.getCharacters().p() > 0;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z11) {
        if (this.enableMergePaths != z11) {
            if (Build.VERSION.SDK_INT < 19) {
                Logger.warning("Merge paths are not supported pre-Kit Kat.");
                return;
            }
            this.enableMergePaths = z11;
            if (this.composition != null) {
                buildCompositionLayer();
            }
        }
    }

    public void setMaxFrame(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new u(this, str));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMaxFrame((int) (marker.startFrame + marker.durationFrames));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public void setMinFrame(String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new t(this, str));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            setMinFrame((int) marker.startFrame);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    private void convertRect(Rect rect, RectF rectF) {
        rectF.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z11) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new w(this, str, str2, z11));
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker != null) {
            int i11 = (int) marker.startFrame;
            Marker marker2 = this.composition.getMarker(str2);
            if (marker2 != null) {
                setMinAndMaxFrame(i11, (int) (marker2.startFrame + (z11 ? 1.0f : 0.0f)));
                return;
            }
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + InstructionFileId.DOT);
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + InstructionFileId.DOT);
    }

    public void draw(Canvas canvas, Matrix matrix) {
        CompositionLayer compositionLayer2 = this.compositionLayer;
        LottieComposition lottieComposition = this.composition;
        if (compositionLayer2 != null && lottieComposition != null) {
            if (this.useSoftwareRendering) {
                canvas.save();
                canvas.concat(matrix);
                renderAndDrawAsBitmap(canvas, compositionLayer2);
                canvas.restore();
            } else {
                compositionLayer2.draw(canvas, matrix, this.alpha);
            }
            this.isDirty = false;
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t11, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, t11, new LottieValueCallback<T>() {
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setMinAndMaxFrame(int i11, int i12) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new f0(this, i11, i12));
        } else {
            this.animator.setMinAndMaxFrames((float) i11, ((float) i12) + 0.99f);
        }
    }
}
