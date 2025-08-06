package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.h0;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import u0.a;

class MaterialButtonHelper {
    private static final boolean IS_LOLLIPOP = (Build.VERSION.SDK_INT >= 21);
    private boolean backgroundOverwritten = false;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private boolean cornerRadiusSet = false;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private Drawable maskDrawable;
    private final MaterialButton materialButton;
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private boolean shouldDrawSurfaceColorStroke = false;
    private ColorStateList strokeColor;
    private int strokeWidth;

    public MaterialButtonHelper(MaterialButton materialButton2, ShapeAppearanceModel shapeAppearanceModel2) {
        this.materialButton = materialButton2;
        this.shapeAppearanceModel = shapeAppearanceModel2;
    }

    private Drawable createBackground() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        a.o(materialShapeDrawable, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            a.p(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
        if (IS_LOLLIPOP) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.maskDrawable = materialShapeDrawable3;
            a.n(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable2 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
            this.rippleDrawable = rippleDrawable2;
            return rippleDrawable2;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = rippleDrawableCompat;
        a.o(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.maskDrawable});
        this.rippleDrawable = layerDrawable;
        return wrapDrawableWithInset(layerDrawable);
    }

    private MaterialShapeDrawable getMaterialShapeDrawable(boolean z11) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (IS_LOLLIPOP) {
            return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(z11 ^ true ? 1 : 0);
        }
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(z11 ^ true ? 1 : 0);
    }

    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    private void setVerticalInsets(int i11, int i12) {
        int L = h0.L(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int K = h0.K(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        int i13 = this.insetTop;
        int i14 = this.insetBottom;
        this.insetBottom = i12;
        this.insetTop = i11;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        h0.P0(this.materialButton, L, (paddingTop + i11) - i13, K, (paddingBottom + i12) - i14);
    }

    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation((float) this.elevation);
        }
    }

    private void updateButtonShape(ShapeAppearanceModel shapeAppearanceModel2) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            getSurfaceColorStrokeDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel2);
        }
    }

    private void updateStroke() {
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke((float) this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.setStroke((float) this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, R.attr.colorSurface) : 0);
            }
        }
    }

    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void loadFromAttributes(TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i11 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i11)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i11, -1);
            this.cornerRadius = dimensionPixelSize;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize((float) dimensionPixelSize));
            this.cornerRadiusSet = true;
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.checkable = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.elevation = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int L = h0.L(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int K = h0.K(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            setBackgroundOverwritten();
        } else {
            updateBackground();
        }
        h0.P0(this.materialButton, L + this.insetLeft, paddingTop + this.insetTop, K + this.insetRight, paddingBottom + this.insetBottom);
    }

    public void setBackgroundColor(int i11) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i11);
        }
    }

    public void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    public void setCheckable(boolean z11) {
        this.checkable = z11;
    }

    public void setCornerRadius(int i11) {
        if (!this.cornerRadiusSet || this.cornerRadius != i11) {
            this.cornerRadius = i11;
            this.cornerRadiusSet = true;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize((float) i11));
        }
    }

    public void setInsetBottom(int i11) {
        setVerticalInsets(this.insetTop, i11);
    }

    public void setInsetTop(int i11) {
        setVerticalInsets(i11, this.insetBottom);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            boolean z11 = IS_LOLLIPOP;
            if (z11 && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else if (!z11 && (this.materialButton.getBackground() instanceof RippleDrawableCompat)) {
                ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel2) {
        this.shapeAppearanceModel = shapeAppearanceModel2;
        updateButtonShape(shapeAppearanceModel2);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z11) {
        this.shouldDrawSurfaceColorStroke = z11;
        updateStroke();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    public void setStrokeWidth(int i11) {
        if (this.strokeWidth != i11) {
            this.strokeWidth = i11;
            updateStroke();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                a.o(getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() != null && this.backgroundTintMode != null) {
                a.p(getMaterialShapeDrawable(), this.backgroundTintMode);
            }
        }
    }

    public void updateMaskBounds(int i11, int i12) {
        Drawable drawable = this.maskDrawable;
        if (drawable != null) {
            drawable.setBounds(this.insetLeft, this.insetTop, i12 - this.insetRight, i11 - this.insetBottom);
        }
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
    }
}
