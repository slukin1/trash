package com.huobi.contract.websocket;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.retrofit.response.IResponse;
import java.util.List;

public class UnionContractPositionEventResponse implements IResponse {
    public List<LinearSwapPosition> data;
    @SerializedName("err-code")
    private int errCode;
    @SerializedName("err-msg")
    private String errMsg;
    public String event;

    /* renamed from: op  reason: collision with root package name */
    public String f43587op;
    public String topic;
    public String uid;

    public boolean canEqual(Object obj) {
        return obj instanceof UnionContractPositionEventResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnionContractPositionEventResponse)) {
            return false;
        }
        UnionContractPositionEventResponse unionContractPositionEventResponse = (UnionContractPositionEventResponse) obj;
        if (!unionContractPositionEventResponse.canEqual(this)) {
            return false;
        }
        String errMsg2 = getErrMsg();
        String errMsg3 = unionContractPositionEventResponse.getErrMsg();
        if (errMsg2 != null ? !errMsg2.equals(errMsg3) : errMsg3 != null) {
            return false;
        }
        if (getErrCode() != unionContractPositionEventResponse.getErrCode()) {
            return false;
        }
        String event2 = getEvent();
        String event3 = unionContractPositionEventResponse.getEvent();
        if (event2 != null ? !event2.equals(event3) : event3 != null) {
            return false;
        }
        String op2 = getOp();
        String op3 = unionContractPositionEventResponse.getOp();
        if (op2 != null ? !op2.equals(op3) : op3 != null) {
            return false;
        }
        String topic2 = getTopic();
        String topic3 = unionContractPositionEventResponse.getTopic();
        if (topic2 != null ? !topic2.equals(topic3) : topic3 != null) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = unionContractPositionEventResponse.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        List<LinearSwapPosition> data2 = getData();
        List<LinearSwapPosition> data3 = unionContractPositionEventResponse.getData();
        return data2 != null ? data2.equals(data3) : data3 == null;
    }

    public List<LinearSwapPosition> getData() {
        return this.data;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getEvent() {
        return this.event;
    }

    public String getOp() {
        return this.f43587op;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getUid() {
        return this.uid;
    }

    public int hashCode() {
        String errMsg2 = getErrMsg();
        int i11 = 43;
        int hashCode = (((errMsg2 == null ? 43 : errMsg2.hashCode()) + 59) * 59) + getErrCode();
        String event2 = getEvent();
        int hashCode2 = (hashCode * 59) + (event2 == null ? 43 : event2.hashCode());
        String op2 = getOp();
        int hashCode3 = (hashCode2 * 59) + (op2 == null ? 43 : op2.hashCode());
        String topic2 = getTopic();
        int hashCode4 = (hashCode3 * 59) + (topic2 == null ? 43 : topic2.hashCode());
        String uid2 = getUid();
        int hashCode5 = (hashCode4 * 59) + (uid2 == null ? 43 : uid2.hashCode());
        List<LinearSwapPosition> data2 = getData();
        int i12 = hashCode5 * 59;
        if (data2 != null) {
            i11 = data2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSuccess() {
        return this.errCode == 0;
    }

    public void setData(List<LinearSwapPosition> list) {
        this.data = list;
    }

    public void setErrCode(int i11) {
        this.errCode = i11;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setOp(String str) {
        this.f43587op = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "UnionContractPositionEventResponse(errMsg=" + getErrMsg() + ", errCode=" + getErrCode() + ", event=" + getEvent() + ", op=" + getOp() + ", topic=" + getTopic() + ", uid=" + getUid() + ", data=" + getData() + ")";
    }
}
