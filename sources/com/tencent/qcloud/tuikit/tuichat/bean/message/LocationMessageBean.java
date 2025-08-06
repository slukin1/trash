package com.tencent.qcloud.tuikit.tuichat.bean.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.LocationReplyQuoteBean;

public class LocationMessageBean extends TUIMessageBean {
    private String desc;
    private double latitude;
    private double longitude;

    public String getDesc() {
        return this.desc;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public Class<? extends TUIReplyQuoteBean> getReplyQuoteBeanClass() {
        return LocationReplyQuoteBean.class;
    }

    public String onGetDisplayString() {
        return this.desc;
    }

    public void onProcessMessage(V2TIMMessage v2TIMMessage) {
        this.desc = v2TIMMessage.getLocationElem().getDesc();
        this.longitude = v2TIMMessage.getLocationElem().getLongitude();
        this.latitude = v2TIMMessage.getLocationElem().getLatitude();
    }
}
