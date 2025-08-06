package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMMergerElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.MergeReplyQuoteBean;
import java.util.ArrayList;
import java.util.List;

public class MergeMessageBean extends TUIMessageBean {
    private V2TIMMergerElem mergerElem;

    public List<String> getAbstractList() {
        V2TIMMergerElem v2TIMMergerElem = this.mergerElem;
        if (v2TIMMergerElem != null) {
            return v2TIMMergerElem.getAbstractList();
        }
        return new ArrayList();
    }

    public V2TIMMergerElem getMergerElem() {
        return this.mergerElem;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return MergeReplyQuoteBean.class;
    }

    public String getTitle() {
        V2TIMMergerElem v2TIMMergerElem = this.mergerElem;
        return v2TIMMergerElem != null ? v2TIMMergerElem.getTitle() : "";
    }

    public boolean isLayersOverLimit() {
        V2TIMMergerElem v2TIMMergerElem = this.mergerElem;
        if (v2TIMMergerElem != null) {
            return v2TIMMergerElem.isLayersOverLimit();
        }
        return false;
    }

    public String onGetDisplayString() {
        return getExtra();
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        this.mergerElem = v2TIMMessage.getMergerElem();
        setExtra(ServiceInitializer.getAppContext().getString(R.string.forward_extra));
    }
}
