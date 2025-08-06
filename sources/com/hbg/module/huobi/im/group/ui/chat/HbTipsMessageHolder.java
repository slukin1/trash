package com.hbg.module.huobi.im.group.ui.chat;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.group.bean.HbTipMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;

public class HbTipsMessageHolder extends HbMessageContentHolder {
    public HbTipsMessageHolder(View view) {
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
        if (tUIMessageBean instanceof HbTipMessageBean) {
            TextView textView = (TextView) this.itemView.findViewById(R$id.tv_tips);
            textView.setVisibility(0);
            textView.setText(((HbTipMessageBean) tUIMessageBean).getText());
        } else if (tUIMessageBean instanceof HbTextMessageBean) {
            TextView textView2 = (TextView) this.itemView.findViewById(R$id.tv_tips);
            textView2.setVisibility(0);
            if (tUIMessageBean.getBusinessID().equals("huobi_live_timeout_unread")) {
                textView2.setText(textView2.getContext().getResources().getString(R$string.n_im_official_customer_service_tips));
            } else {
                textView2.setText(((HbTextMessageBean) tUIMessageBean).getText());
            }
        }
    }
}
