package com.huobi.view.radiogroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.hbg.lib.widgets.LoadingView;
import com.huobi.view.radiogroup.RadioContainer;

public class RadioGroupContainer extends LinearLayout implements RadioContainer.OnCheckedChangedListener {
    private int checkedId = 0;
    private OnCheckedChangeListener onItemSelectedListener;
    private int position = 0;
    private int preAnimPos = -1;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(RadioGroupContainer radioGroupContainer, View view, int i11, int i12);
    }

    public RadioGroupContainer(Context context) {
        super(context);
    }

    private void playAnim(int i11) {
        if (this.preAnimPos != i11) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt instanceof RadioContainer) {
                    View childAt2 = ((RadioContainer) childAt).getChildAt(0);
                    if (childAt2 instanceof LoadingView) {
                        LoadingView loadingView = (LoadingView) childAt2;
                        loadingView.d();
                        loadingView.setProgress(0.0f);
                    }
                }
            }
            View childAt3 = getChildAt(i11);
            if (childAt3 instanceof RadioContainer) {
                View childAt4 = ((RadioContainer) childAt3).getChildAt(0);
                if (childAt4 instanceof LoadingView) {
                    ((LoadingView) childAt4).c();
                    this.preAnimPos = i11;
                }
            }
        }
    }

    public int getCheckedId() {
        return this.checkedId;
    }

    public int getCheckedPosition() {
        return this.position;
    }

    public void onCheckedChanged(View view, boolean z11) {
        int i11 = -1;
        boolean z12 = false;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt instanceof RadioContainer) {
                if (!z12) {
                    i11++;
                }
                if (childAt != view) {
                    ((RadioContainer) childAt).setChecked(false);
                }
                if (childAt == view) {
                    z12 = true;
                }
            }
        }
        this.position = i11;
        this.checkedId = view.getId();
        OnCheckedChangeListener onCheckedChangeListener = this.onItemSelectedListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(this, view, view.getId(), this.position);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        setCheckedPosition(this.position);
    }

    public void setCheckedId(int i11) {
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt instanceof RadioContainer) {
                if (childAt.getId() == i11) {
                    this.checkedId = i11;
                    this.position = i12;
                    ((RadioContainer) childAt).setChecked(true);
                    OnCheckedChangeListener onCheckedChangeListener = this.onItemSelectedListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(this, childAt, childAt.getId(), this.position);
                    }
                } else {
                    ((RadioContainer) childAt).setChecked(false);
                }
            }
        }
        playAnim(this.position);
    }

    public void setCheckedPosition(int i11) {
        int i12 = -1;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            if (childAt instanceof RadioContainer) {
                i12++;
                if (i12 == i11) {
                    ((RadioContainer) childAt).setChecked(true);
                    this.position = i11;
                    this.checkedId = childAt.getId();
                    OnCheckedChangeListener onCheckedChangeListener = this.onItemSelectedListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(this, childAt, childAt.getId(), this.position);
                    }
                } else {
                    ((RadioContainer) childAt).setChecked(false);
                }
            }
        }
        playAnim(i11);
    }

    public void setOnSelelctChangeListner(OnCheckedChangeListener onCheckedChangeListener) {
        this.onItemSelectedListener = onCheckedChangeListener;
    }

    public RadioGroupContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadioGroupContainer(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
