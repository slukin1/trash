package com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;

public class NoticeLayout extends RelativeLayout implements INoticeLayout {
    private boolean mAwaysShow;
    private TextView mContentExtraText;
    private TextView mContentText;
    private RelativeLayout mNoticeLayout;

    public NoticeLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        RelativeLayout.inflate(getContext(), R.layout.notice_layout, this);
        this.mNoticeLayout = (RelativeLayout) findViewById(R.id.notice_layout);
        this.mContentText = (TextView) findViewById(R.id.notice_content);
        this.mContentExtraText = (TextView) findViewById(R.id.notice_content_extra);
    }

    public void alwaysShow(boolean z11) {
        this.mAwaysShow = z11;
        if (z11) {
            super.setVisibility(0);
        }
    }

    public TextView getContent() {
        return this.mContentText;
    }

    public TextView getContentExtra() {
        return this.mContentExtraText;
    }

    public RelativeLayout getParentLayout() {
        return this.mNoticeLayout;
    }

    public void setOnNoticeClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void setVisibility(int i11) {
        if (this.mAwaysShow) {
            super.setVisibility(0);
        } else {
            super.setVisibility(i11);
        }
    }

    public NoticeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NoticeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
