package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R;

public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    public Float get(ViewGroup viewGroup) {
        Float f11 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (f11 != null) {
            return f11;
        }
        return Float.valueOf(1.0f);
    }

    public void set(ViewGroup viewGroup, Float f11) {
        float floatValue = f11.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            viewGroup.getChildAt(i11).setAlpha(floatValue);
        }
    }
}
