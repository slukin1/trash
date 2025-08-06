package com.huobi.view.wheelpicker;

import android.app.Activity;
import android.view.View;
import com.huobi.view.wheelpicker.WheelView;

public abstract class WheelPicker extends ConfirmPopup<View> {
    private View contentView;
    public boolean cycleDisable = true;
    public WheelView.LineConfig lineConfig;
    public int offset = 2;
    public int textColorFocus = WheelView.TEXT_COLOR_FOCUS;
    public int textColorNormal = WheelView.TEXT_COLOR_NORMAL;
    public int textSize = 16;
    public int typeDimension = 2;

    public WheelPicker(Activity activity) {
        super(activity);
    }

    public View getContentView() {
        if (this.contentView == null) {
            this.contentView = makeCenterView();
        }
        return this.contentView;
    }

    public void setCycleDisable(boolean z11) {
        this.cycleDisable = z11;
    }

    public void setLineColor(int i11) {
        if (this.lineConfig == null) {
            this.lineConfig = new WheelView.LineConfig();
        }
        this.lineConfig.setVisible(true);
        this.lineConfig.setColor(i11);
    }

    public void setLineConfig(WheelView.LineConfig lineConfig2) {
        if (lineConfig2 == null) {
            WheelView.LineConfig lineConfig3 = new WheelView.LineConfig();
            this.lineConfig = lineConfig3;
            lineConfig3.setVisible(false);
            this.lineConfig.setShadowVisible(false);
            return;
        }
        this.lineConfig = lineConfig2;
    }

    public void setLineVisible(boolean z11) {
        if (this.lineConfig == null) {
            this.lineConfig = new WheelView.LineConfig();
        }
        this.lineConfig.setVisible(z11);
    }

    public void setOffset(int i11) {
        this.offset = i11;
    }

    public void setShadowVisible(boolean z11) {
        if (this.lineConfig == null) {
            this.lineConfig = new WheelView.LineConfig();
        }
        this.lineConfig.setShadowVisible(z11);
    }

    public void setTextColor(int i11, int i12) {
        this.textColorFocus = i11;
        this.textColorNormal = i12;
    }

    public void setTextSize(int i11) {
        this.textSize = i11;
    }

    public void setTextSize(int i11, int i12) {
        this.textSize = i11;
        this.typeDimension = i12;
    }

    public void setTextColor(int i11) {
        this.textColorFocus = i11;
    }
}
