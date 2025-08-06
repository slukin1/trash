package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageBaseHolder;

public class MessageHeaderHolder extends MessageBaseHolder {
    private boolean mLoading;

    public MessageHeaderHolder(View view) {
        super(view);
    }

    public int getVariableLayout() {
        return 0;
    }

    public void layoutViews(TUIMessageBean tUIMessageBean, int i11) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
        if (this.mLoading) {
            layoutParams.height = -2;
            layoutParams.width = -1;
            this.itemView.setVisibility(0);
        } else {
            layoutParams.height = 0;
            layoutParams.width = 0;
            this.itemView.setVisibility(8);
        }
        this.itemView.setLayoutParams(layoutParams);
    }

    public void setLoadingStatus(boolean z11) {
        this.mLoading = z11;
        layoutViews((TUIMessageBean) null, 0);
    }
}
