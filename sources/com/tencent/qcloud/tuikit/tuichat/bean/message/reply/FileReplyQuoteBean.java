package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;

public class FileReplyQuoteBean extends TUIReplyQuoteBean {
    private String fileName;

    public String getFileName() {
        return this.fileName;
    }

    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof FileMessageBean) {
            this.fileName = ((FileMessageBean) tUIMessageBean).getFileName();
        }
    }
}
