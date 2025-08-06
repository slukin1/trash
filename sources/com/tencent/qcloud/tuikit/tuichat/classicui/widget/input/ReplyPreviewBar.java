package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.tuichat.R;

public class ReplyPreviewBar extends RelativeLayout {
    public ReplyPreviewBar(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        RelativeLayout.inflate(getContext(), R.layout.reply_preview_layout, this);
    }

    public ReplyPreviewBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public ReplyPreviewBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initViews();
    }
}
