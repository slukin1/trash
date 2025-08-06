package com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public interface INoticeLayout {
    void alwaysShow(boolean z11);

    TextView getContent();

    TextView getContentExtra();

    RelativeLayout getParentLayout();

    void setOnNoticeClickListener(View.OnClickListener onClickListener);
}
