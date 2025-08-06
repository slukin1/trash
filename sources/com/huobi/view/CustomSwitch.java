package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Switch;
import com.hbg.lib.common.utils.PixelUtils;
import java.lang.reflect.Field;

public class CustomSwitch extends Switch {
    private boolean disableSlide;
    private float downX;
    private float downY;
    private int touchState;

    public CustomSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            this.touchState = 0;
        } else if (action == 2) {
            float x11 = motionEvent.getX() - this.downX;
            float y11 = motionEvent.getY() - this.downY;
            if (this.disableSlide && (Math.abs(x11) >= 10.0f || Math.abs(y11) >= 10.0f)) {
                this.touchState = 1;
            }
        }
        if (this.touchState == 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        try {
            Field declaredField = Switch.class.getDeclaredField("mSwitchWidth");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(PixelUtils.a(40.0f)));
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    public void setDisableSlide(boolean z11) {
        this.disableSlide = z11;
    }
}
