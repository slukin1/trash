package com.youth.banner.transformer;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public class MZScaleInTransformer extends BasePageTransformer {
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    private float mMinScale = DEFAULT_MIN_SCALE;

    public MZScaleInTransformer() {
    }

    private ViewPager2 requireViewPager(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    public void transformPage(View view, float f11) {
        ViewPager2 requireViewPager = requireViewPager(view);
        float paddingLeft = (float) requireViewPager.getPaddingLeft();
        float measuredWidth = f11 - (paddingLeft / ((((float) requireViewPager.getMeasuredWidth()) - paddingLeft) - ((float) requireViewPager.getPaddingRight())));
        float f12 = this.mMinScale;
        float width = ((1.0f - f12) * ((float) view.getWidth())) / 2.0f;
        if (measuredWidth <= -1.0f) {
            view.setTranslationX(width);
            view.setScaleX(this.mMinScale);
            view.setScaleY(this.mMinScale);
            return;
        }
        double d11 = (double) measuredWidth;
        if (d11 <= 1.0d) {
            float abs = (1.0f - f12) * Math.abs(1.0f - Math.abs(measuredWidth));
            float f13 = (-width) * measuredWidth;
            if (d11 <= -0.5d) {
                view.setTranslationX(f13 + (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else if (measuredWidth <= 0.0f) {
                view.setTranslationX(f13);
            } else if (d11 >= 0.5d) {
                view.setTranslationX(f13 - (Math.abs(Math.abs(measuredWidth) - 0.5f) / 0.5f));
            } else {
                view.setTranslationX(f13);
            }
            view.setScaleX(this.mMinScale + abs);
            view.setScaleY(abs + this.mMinScale);
            return;
        }
        view.setScaleX(f12);
        view.setScaleY(this.mMinScale);
        view.setTranslationX(-width);
    }

    public MZScaleInTransformer(float f11) {
        this.mMinScale = f11;
    }
}
