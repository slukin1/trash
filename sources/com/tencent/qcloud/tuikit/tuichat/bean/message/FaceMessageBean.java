package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMFaceElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;

public class FaceMessageBean extends TUIMessageBean {
    private V2TIMFaceElem faceElem;

    public byte[] getData() {
        V2TIMFaceElem v2TIMFaceElem = this.faceElem;
        return v2TIMFaceElem != null ? v2TIMFaceElem.getData() : new byte[0];
    }

    public int getIndex() {
        V2TIMFaceElem v2TIMFaceElem = this.faceElem;
        if (v2TIMFaceElem != null) {
            return v2TIMFaceElem.getIndex();
        }
        return 0;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return FaceReplyQuoteBean.class;
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        V2TIMFaceElem faceElem2 = v2TIMMessage.getFaceElem();
        this.faceElem = faceElem2;
        if (faceElem2.getIndex() < 1 || this.faceElem.getData() == null) {
            TUIChatLog.e("FaceMessageBean", "faceElem data is null or index<1");
        } else {
            setExtra(ServiceInitializer.getAppContext().getString(R.string.custom_emoji));
        }
    }
}
