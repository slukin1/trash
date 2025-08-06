package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.SwitchCompat;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.lang.reflect.Field;

public class SwitchCustomWidth extends SwitchCompat {
    private static final String TAG = "SwitchCustomWidth";
    private int customSwitchWidth;

    public SwitchCustomWidth(Context context) {
        super(context);
        initCustomAttr(context, (AttributeSet) null);
    }

    public void initCustomAttr(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchCustomWidth);
            this.customSwitchWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCustomWidth_custom_width, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        try {
            if (this.customSwitchWidth != 0) {
                Field declaredField = SwitchCompat.class.getDeclaredField("mSwitchWidth");
                declaredField.setAccessible(true);
                declaredField.set(this, Integer.valueOf(this.customSwitchWidth));
            }
        } catch (Exception e11) {
            Log.w(TAG, e11.getMessage());
        }
    }

    public SwitchCustomWidth(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initCustomAttr(context, attributeSet);
    }

    public SwitchCustomWidth(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initCustomAttr(context, attributeSet);
    }
}
