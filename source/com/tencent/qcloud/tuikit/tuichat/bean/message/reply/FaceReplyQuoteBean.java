package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;

public class FaceReplyQuoteBean extends TUIReplyQuoteBean {
    private byte[] data;
    private int index;

    public byte[] getData() {
        byte[] bArr = this.data;
        return bArr != null ? bArr : new byte[0];
    }

    public int getIndex() {
        return this.index;
    }

    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof FaceMessageBean) {
            FaceMessageBean faceMessageBean = (FaceMessageBean) tUIMessageBean;
            this.data = faceMessageBean.getData();
            this.index = faceMessageBean.getIndex();
        }
    }
}
