package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.DropShadowEffect;
import java.util.Collections;
import java.util.List;

public class ShapeLayer extends BaseLayer {
    private final CompositionLayer compositionLayer;
    private final ContentGroup contentGroup;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer, CompositionLayer compositionLayer2) {
        super(lottieDrawable, layer);
        this.compositionLayer = compositionLayer2;
        ContentGroup contentGroup2 = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.getShapes(), false));
        this.contentGroup = contentGroup2;
        contentGroup2.setContents(Collections.emptyList(), Collections.emptyList());
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i11) {
        this.contentGroup.draw(canvas, matrix, i11);
    }

    public BlurEffect getBlurEffect() {
        BlurEffect blurEffect = super.getBlurEffect();
        if (blurEffect != null) {
            return blurEffect;
        }
        return this.compositionLayer.getBlurEffect();
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z11) {
        super.getBounds(rectF, matrix, z11);
        this.contentGroup.getBounds(rectF, this.boundsMatrix, z11);
    }

    public DropShadowEffect getDropShadowEffect() {
        DropShadowEffect dropShadowEffect = super.getDropShadowEffect();
        if (dropShadowEffect != null) {
            return dropShadowEffect;
        }
        return this.compositionLayer.getDropShadowEffect();
    }

    public void resolveChildKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, i11, list, keyPath2);
    }
}
