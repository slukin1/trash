package com.hbg.module.huobi.im.group.ui.chat;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.bean.HbAccountManagerUnreadBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public class HbAccountManagerUnreadHolder extends HbMessageContentHolder {
    public HbAccountManagerUnreadHolder(View view) {
        super(view);
    }

    public int getVariableLayout() {
        return 0;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
    }

    public void layoutViews(TUIMessageBean tUIMessageBean, int i11) {
        super.layoutViews(tUIMessageBean, i11);
        this.chatTimeText.setVisibility(8);
        this.mMutiSelectCheckBox.setVisibility(8);
        this.rightGroupLayout.setVisibility(8);
        if (tUIMessageBean instanceof HbAccountManagerUnreadBean) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.tv_tips);
            textView.setVisibility(0);
            textView.setText(textView.getContext().getResources().getString(R$string.n_im_official_customer_service_tips));
        }
    }
}
