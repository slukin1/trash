package com.hbg.lib.network.pro.socket.response;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.pro.socket.bean.ContractPositionTpslWs;
import com.hbg.lib.network.pro.socket.response.ContractPositionWsData;
import com.hbg.lib.network.retrofit.response.IResponse;
import java.util.List;

public class BaseContractPositionResponse<T extends ContractPositionWsData> implements IResponse {
    public List<T> data;
    @SerializedName("err-code")
    private int errCode;
    @SerializedName("err-msg")
    private String errMsg;
    public String event;

    /* renamed from: op  reason: collision with root package name */
    public String f70638op;
    public String topic;
    public List<ContractPositionTpslWs> tpslInfo;
    public String uid;

    public boolean canEqual(Object obj) {
        return obj instanceof BaseContractPositionResponse;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseContractPositionResponse)) {
            return false;
        }
        BaseContractPositionResponse baseContractPositionResponse = (BaseContractPositionResponse) obj;
        if (!baseContractPositionResponse.canEqual(this)) {
            return false;
        }
        String errMsg2 = getErrMsg();
        String errMsg3 = baseContractPositionResponse.getErrMsg();
        if (errMsg2 != null ? !errMsg2.equals(errMsg3) : errMsg3 != null) {
            return false;
        }
        if (getErrCode() != baseContractPositionResponse.getErrCode()) {
            return false;
        }
        String event2 = getEvent();
        String event3 = baseContractPositionResponse.getEvent();
        if (event2 != null ? !event2.equals(event3) : event3 != null) {
            return false;
        }
        String op2 = getOp();
        String op3 = baseContractPositionResponse.getOp();
        if (op2 != null ? !op2.equals(op3) : op3 != null) {
            return false;
        }
        String topic2 = getTopic();
        String topic3 = baseContractPositionResponse.getTopic();
        if (topic2 != null ? !topic2.equals(topic3) : topic3 != null) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = baseContractPositionResponse.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        List data2 = getData();
        List data3 = baseContractPositionResponse.getData();
        if (data2 != null ? !data2.equals(data3) : data3 != null) {
            return false;
        }
        List<ContractPositionTpslWs> tpslInfo2 = getTpslInfo();
        List<ContractPositionTpslWs> tpslInfo3 = baseContractPositionResponse.getTpslInfo();
        return tpslInfo2 != null ? tpslInfo2.equals(tpslInfo3) : tpslInfo3 == null;
    }

    public List<T> getData() {
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
        return this.f70638op;
    }

    public String getTopic() {
        return this.topic;
    }

    public List<ContractPositionTpslWs> getTpslInfo() {
        return this.tpslInfo;
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
        List data2 = getData();
        int hashCode6 = (hashCode5 * 59) + (data2 == null ? 43 : data2.hashCode());
        List<ContractPositionTpslWs> tpslInfo2 = getTpslInfo();
        int i12 = hashCode6 * 59;
        if (tpslInfo2 != null) {
            i11 = tpslInfo2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSuccess() {
        return this.errCode == 0;
    }

    public void setData(List<T> list) {
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
        this.f70638op = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setTpslInfo(List<ContractPositionTpslWs> list) {
        this.tpslInfo = list;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "BaseContractPositionResponse(errMsg=" + getErrMsg() + ", errCode=" + getErrCode() + ", event=" + getEvent() + ", op=" + getOp() + ", topic=" + getTopic() + ", uid=" + getUid() + ", data=" + getData() + ", tpslInfo=" + getTpslInfo() + ")";
    }
}
