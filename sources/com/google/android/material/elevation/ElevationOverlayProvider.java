package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import t0.c;

public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        this.elevationOverlayEnabled = MaterialAttributes.resolveBoolean(context, R.attr.elevationOverlayEnabled, false);
        this.elevationOverlayColor = MaterialColors.getColor(context, R.attr.elevationOverlayColor, 0);
        this.colorSurface = MaterialColors.getColor(context, R.attr.colorSurface, 0);
        this.displayDensity = context.getResources().getDisplayMetrics().density;
    }

    private boolean isThemeSurfaceColor(int i11) {
        return c.j(i11, 255) == this.colorSurface;
    }

    public int calculateOverlayAlpha(float f11) {
        return Math.round(calculateOverlayAlphaFraction(f11) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float f11) {
        float f12 = this.displayDensity;
        if (f12 <= 0.0f || f11 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p((double) (f11 / f12))) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
    }

    public int compositeOverlay(int i11, float f11, View view) {
        return compositeOverlay(i11, f11 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayIfNeeded(int i11, float f11, View view) {
        return compositeOverlayIfNeeded(i11, f11 + getParentAbsoluteElevation(view));
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f11, View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f11 + getParentAbsoluteElevation(view));
    }

    public float getParentAbsoluteElevation(View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    public int compositeOverlay(int i11, float f11) {
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f11);
        return c.j(MaterialColors.layer(c.j(i11, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction), Color.alpha(i11));
    }

    public int compositeOverlayIfNeeded(int i11, float f11) {
        return (!this.elevationOverlayEnabled || !isThemeSurfaceColor(i11)) ? i11 : compositeOverlay(i11, f11);
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f11) {
        return compositeOverlayIfNeeded(this.colorSurface, f11);
    }
}
