package com.huobi.view.radiogroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class RadioContainer extends LinearLayout implements View.OnClickListener, Checkable {
    private boolean checked;

    public interface OnCheckedChangedListener {
        void onCheckedChanged(View view, boolean z11);
    }

    public RadioContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    private void changeChildChecked(View view, boolean z11) {
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z11);
        } else {
            view.setEnabled(z11);
        }
        if (view instanceof ViewGroup) {
            int i11 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 < viewGroup.getChildCount()) {
                    changeChildChecked(viewGroup.getChildAt(i11), z11);
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private void disenableCheckBox(View view) {
        int i11 = 0;
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i11 < viewGroup.getChildCount()) {
                    disenableCheckBox(viewGroup.getChildAt(i11));
                    i11++;
                } else {
                    return;
                }
            }
        } else {
            view.setClickable(false);
        }
    }

    public boolean isChecked() {
        return this.checked;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (!this.checked) {
            this.checked = true;
            changeChildChecked(this, true);
            if (getParent() instanceof OnCheckedChangedListener) {
                ((OnCheckedChangedListener) getParent()).onCheckedChanged(this, this.checked);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        disenableCheckBox(this);
    }

    public void setChecked(boolean z11) {
        if (z11 != this.checked) {
            this.checked = z11;
            changeChildChecked(this, z11);
        }
    }

    public void toggle() {
        setChecked(!this.checked);
    }

    public RadioContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RadioContainer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.checked = false;
        setOnClickListener(this);
    }
}
