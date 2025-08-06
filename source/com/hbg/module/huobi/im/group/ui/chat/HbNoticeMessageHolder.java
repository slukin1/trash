package com.hbg.module.huobi.im.group.ui.chat;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.HbNoticeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import rd.p;
import rd.u;

public class HbNoticeMessageHolder extends HbMessageContentHolder {
    private LinkMovementMethodInterceptor linkMovementMethod = new LinkMovementMethodInterceptor();
    /* access modifiers changed from: private */
    public TextView tvNotice;

    public HbNoticeMessageHolder(View view) {
        super(view);
        this.tvNotice = (TextView) view.findViewById(R$id.tv_notice);
    }

    public int getVariableLayout() {
        return R$layout.im_message_adapter_notice;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        if (tUIMessageBean instanceof HbNoticeMessageBean) {
            this.tvNotice.setText(((HbNoticeMessageBean) tUIMessageBean).getNoticeMsg());
            u.a(this.tvNotice.getContext()).c(this.tvNotice);
            this.linkMovementMethod.a(new p() {
                public void onClickUrl(String str) {
                    TUIChatLog.i("TextMessageHolder", "onClickUrl: url:" + str);
                    HBBaseWebActivity.showWebView(HbNoticeMessageHolder.this.tvNotice.getContext(), str, "", "", false);
                }
            });
            this.tvNotice.setMovementMethod(this.linkMovementMethod);
            this.msgArea.setBackground((Drawable) null);
        }
        this.msgContentFrame.setBackgroundColor(this.tvNotice.getContext().getResources().getColor(R$color.transparent));
    }
}
