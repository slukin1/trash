package com.tencent.qcloud.tuikit.timcommon.component.interfaces;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public interface ITitleBarLayout {

    public enum Position {
        LEFT,
        MIDDLE,
        EXTRAL,
        RIGHT
    }

    LinearLayout getLeftGroup();

    ImageView getLeftIcon();

    TextView getLeftTitle();

    TextView getMiddleTitle();

    LinearLayout getRightGroup();

    ImageView getRightIcon();

    TextView getRightTitle();

    void setLeftIcon(int i11);

    void setOnLeftClickListener(View.OnClickListener onClickListener);

    void setOnRightClickListener(View.OnClickListener onClickListener);

    void setRightIcon(int i11);

    void setTitle(String str, Position position);
}
