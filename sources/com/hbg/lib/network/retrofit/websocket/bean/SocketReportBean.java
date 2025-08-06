package com.hbg.lib.network.retrofit.websocket.bean;

import java.io.Serializable;
import java.util.Map;

public class SocketReportBean implements Serializable {
    public static final String CONNECT_ERROR = "connectError";
    public static final String REQ_REQUEST_ERROR = "reqRequestError";
    public static final String REQ_RESPONSE_ERROR = "reqResponseError";
    public static final String SUB_REQUEST_ERROR = "subRequestError";
    public static final String SUB_RESPONSE_ERROR = "subResponseError";
    private static final long serialVersionUID = -2337250869551846607L;
    private String domain;
    private String errorType;
    private String reqPick;
    private String response;
    private String serverType;
    private String topic;

    public SocketReportBean(String str, String str2, String str3, String str4) {
        this.serverType = str;
        this.topic = str2;
        this.domain = str3;
        this.errorType = str4;
    }

    public void buildParams(Map<String, String> map) {
        if (map != null) {
            map.put("socket_server_type", this.serverType);
            map.put("socket_topic", this.topic);
            map.put("socket_domain", this.domain);
            map.put("socket_error_type", this.errorType);
            map.put("socket_req_pick", this.reqPick);
            map.put("socket_response", this.response);
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SocketReportBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SocketReportBean)) {
            return false;
        }
        SocketReportBean socketReportBean = (SocketReportBean) obj;
        if (!socketReportBean.canEqual(this)) {
            return false;
        }
        String serverType2 = getServerType();
        String serverType3 = socketReportBean.getServerType();
        if (serverType2 != null ? !serverType2.equals(serverType3) : serverType3 != null) {
            return false;
        }
        String topic2 = getTopic();
        String topic3 = socketReportBean.getTopic();
        if (topic2 != null ? !topic2.equals(topic3) : topic3 != null) {
            return false;
        }
        String domain2 = getDomain();
        String domain3 = socketReportBean.getDomain();
        if (domain2 != null ? !domain2.equals(domain3) : domain3 != null) {
            return false;
        }
        String errorType2 = getErrorType();
        String errorType3 = socketReportBean.getErrorType();
        if (errorType2 != null ? !errorType2.equals(errorType3) : errorType3 != null) {
            return false;
        }
        String response2 = getResponse();
        String response3 = socketReportBean.getResponse();
        if (response2 != null ? !response2.equals(response3) : response3 != null) {
            return false;
        }
        String reqPick2 = getReqPick();
        String reqPick3 = socketReportBean.getReqPick();
        return reqPick2 != null ? reqPick2.equals(reqPick3) : reqPick3 == null;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getErrorType() {
        return this.errorType;
    }

    public String getReqPick() {
        return this.reqPick;
    }

    public String getResponse() {
        return this.response;
    }

    public String getServerType() {
        return this.serverType;
    }

    public String getTopic() {
        return this.topic;
    }

    public int hashCode() {
        String serverType2 = getServerType();
        int i11 = 43;
        int hashCode = serverType2 == null ? 43 : serverType2.hashCode();
        String topic2 = getTopic();
        int hashCode2 = ((hashCode + 59) * 59) + (topic2 == null ? 43 : topic2.hashCode());
        String domain2 = getDomain();
        int hashCode3 = (hashCode2 * 59) + (domain2 == null ? 43 : domain2.hashCode());
        String errorType2 = getErrorType();
        int hashCode4 = (hashCode3 * 59) + (errorType2 == null ? 43 : errorType2.hashCode());
        String response2 = getResponse();
        int hashCode5 = (hashCode4 * 59) + (response2 == null ? 43 : response2.hashCode());
        String reqPick2 = getReqPick();
        int i12 = hashCode5 * 59;
        if (reqPick2 != null) {
            i11 = reqPick2.hashCode();
        }
        return i12 + i11;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setErrorType(String str) {
        this.errorType = str;
    }

    public void setReqPick(String str) {
        this.reqPick = str;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public void setServerType(String str) {
        this.serverType = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public String toString() {
        return "SocketReportBean(serverType=" + getServerType() + ", topic=" + getTopic() + ", domain=" + getDomain() + ", errorType=" + getErrorType() + ", response=" + getResponse() + ", reqPick=" + getReqPick() + ")";
    }

    public SocketReportBean(String str, String str2, String str3, String str4, String str5) {
        this.serverType = str;
        this.reqPick = str2;
        this.response = str3;
        this.domain = str4;
        this.errorType = str5;
    }
}
