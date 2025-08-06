package com.hbg.lib.network.uc.core.bean;

import java.io.Serializable;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class UcNetworkInfo implements Serializable {
    private Interceptor.Chain chain;
    private Request request;
    private Response response;
    private String responseStr;

    public boolean canEqual(Object obj) {
        return obj instanceof UcNetworkInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UcNetworkInfo)) {
            return false;
        }
        UcNetworkInfo ucNetworkInfo = (UcNetworkInfo) obj;
        if (!ucNetworkInfo.canEqual(this)) {
            return false;
        }
        Request request2 = getRequest();
        Request request3 = ucNetworkInfo.getRequest();
        if (request2 != null ? !request2.equals(request3) : request3 != null) {
            return false;
        }
        Response response2 = getResponse();
        Response response3 = ucNetworkInfo.getResponse();
        if (response2 != null ? !response2.equals(response3) : response3 != null) {
            return false;
        }
        Interceptor.Chain chain2 = getChain();
        Interceptor.Chain chain3 = ucNetworkInfo.getChain();
        if (chain2 != null ? !chain2.equals(chain3) : chain3 != null) {
            return false;
        }
        String responseStr2 = getResponseStr();
        String responseStr3 = ucNetworkInfo.getResponseStr();
        return responseStr2 != null ? responseStr2.equals(responseStr3) : responseStr3 == null;
    }

    public Interceptor.Chain getChain() {
        return this.chain;
    }

    public Request getRequest() {
        return this.request;
    }

    public Response getResponse() {
        return this.response;
    }

    public String getResponseStr() {
        return this.responseStr;
    }

    public int hashCode() {
        Request request2 = getRequest();
        int i11 = 43;
        int hashCode = request2 == null ? 43 : request2.hashCode();
        Response response2 = getResponse();
        int hashCode2 = ((hashCode + 59) * 59) + (response2 == null ? 43 : response2.hashCode());
        Interceptor.Chain chain2 = getChain();
        int hashCode3 = (hashCode2 * 59) + (chain2 == null ? 43 : chain2.hashCode());
        String responseStr2 = getResponseStr();
        int i12 = hashCode3 * 59;
        if (responseStr2 != null) {
            i11 = responseStr2.hashCode();
        }
        return i12 + i11;
    }

    public void setChain(Interceptor.Chain chain2) {
        this.chain = chain2;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public void setResponse(Response response2) {
        this.response = response2;
    }

    public void setResponseStr(String str) {
        this.responseStr = str;
    }

    public String toString() {
        return "UcNetworkInfo(request=" + getRequest() + ", response=" + getResponse() + ", chain=" + getChain() + ", responseStr=" + getResponseStr() + ")";
    }
}
