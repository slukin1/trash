package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.qcloud.tuikit.timcommon.R;

public class MinimalistTitleBar extends TitleBarLayout {
    public MinimalistTitleBar(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        setLeftReturnListener(context);
        setBackgroundColor(-1);
        getLeftIcon().setBackgroundResource(R.drawable.core_minimalist_back_icon);
        getLeftTitle().setTextColor(-16554503);
        getRightTitle().setTextColor(-16554503);
    }

    public MinimalistTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public MinimalistTitleBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }
}
