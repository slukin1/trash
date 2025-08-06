package com.huobi.woodpecker.model;

import android.text.TextUtils;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.woodpecker.model.base.IRecord;
import com.sumsub.sentry.n0;
import org.json.JSONException;
import org.json.JSONObject;

public class ApiData implements IRecord {
    private int code;
    private long dns;
    private String dnsip = "";
    private String dnsserver;
    private int dnsst = 0;
    private long fbt;
    private String host;
    private String isRequestNode;
    private String method;
    private String msg;
    private String path;
    private String protocol;
    private long rct;
    private String realnt;
    private long reqLength;
    private double reqsp;
    private long resLength;
    private String rescode;
    private ApiResHeader resheader;
    private double ressp;
    private String schema;
    private String sessionId;
    private long ssl;
    private long tcp;
    private long time;
    private String tls;
    private String trace;
    private long ttfb;

    public int getCode() {
        return this.code;
    }

    public long getDns() {
        return this.dns;
    }

    public String getDnsip() {
        return this.dnsip;
    }

    public String getDnsserver() {
        return this.dnsserver;
    }

    public int getDnsst() {
        return this.dnsst;
    }

    public long getFbt() {
        return this.fbt;
    }

    public String getHost() {
        return this.host;
    }

    public String getIsRequestNode() {
        return this.isRequestNode;
    }

    public String getMethod() {
        return this.method;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getPath() {
        return this.path;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public long getRct() {
        return this.rct;
    }

    public String getRealnt() {
        return this.realnt;
    }

    public long getReqLength() {
        return this.reqLength;
    }

    public double getReqsp() {
        return this.reqsp;
    }

    public long getResLength() {
        return this.resLength;
    }

    public String getRescode() {
        return this.rescode;
    }

    public ApiResHeader getResheader() {
        return this.resheader;
    }

    public double getRessp() {
        return this.ressp;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public long getSsl() {
        return this.ssl;
    }

    public long getTcp() {
        return this.tcp;
    }

    public long getTime() {
        return this.time;
    }

    public String getTls() {
        return this.tls;
    }

    public String getTrace() {
        return this.trace;
    }

    public long getTtfb() {
        return this.ttfb;
    }

    public boolean isRedirection() {
        int i11 = this.code;
        return (i11 < 300 || i11 >= 400 || i11 == 304 || i11 == 305 || i11 == 306) ? false : true;
    }

    public boolean isSucceed() {
        int i11 = this.code;
        return i11 >= 200 && i11 < 300;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setDns(long j11) {
        this.dns = j11;
    }

    public void setDnsip(String str) {
        this.dnsip = str;
    }

    public void setDnsserver(String str) {
        this.dnsserver = str;
    }

    public void setDnsst(int i11) {
        this.dnsst = i11;
    }

    public void setFbt(long j11) {
        this.fbt = j11;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setIsRequestNode(String str) {
        this.isRequestNode = str;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setRct(long j11) {
        this.rct = j11;
    }

    public void setRealnt(String str) {
        this.realnt = str;
    }

    public void setReqLength(long j11) {
        this.reqLength = j11;
    }

    public void setReqsp(double d11) {
        this.reqsp = d11;
    }

    public void setResLength(long j11) {
        this.resLength = j11;
    }

    public void setRescode(String str) {
        this.rescode = str;
    }

    public void setResheader(ApiResHeader apiResHeader) {
        this.resheader = apiResHeader;
    }

    public void setRessp(double d11) {
        this.ressp = d11;
    }

    public void setSchema(String str) {
        this.schema = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSsl(long j11) {
        this.ssl = j11;
    }

    public void setTcp(long j11) {
        this.tcp = j11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public void setTls(String str) {
        this.tls = str;
    }

    public void setTrace(String str) {
        this.trace = str;
    }

    public void setTtfb(long j11) {
        this.ttfb = j11;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(n0.f30437i, this.trace);
            if (!TextUtils.isEmpty(this.isRequestNode)) {
                jSONObject.put("isRequestNode", this.isRequestNode);
            }
            if (!TextUtils.isEmpty(this.sessionId)) {
                jSONObject.put("sessionId", this.sessionId);
            }
            jSONObject.put("method", this.method);
            jSONObject.put(VulcanInfo.HOST, this.host);
            jSONObject.put("path", this.path);
            jSONObject.put("schema", this.schema);
            jSONObject.put("code", this.code);
            jSONObject.put("dnsst", this.dnsst);
            jSONObject.put("dnsip", this.dnsip);
            jSONObject.put("dns", this.dns);
            jSONObject.put("tcp", this.tcp);
            jSONObject.put("ssl", this.ssl);
            jSONObject.put("ttfb", this.ttfb);
            jSONObject.put("fbt", this.fbt);
            jSONObject.put("rct", this.rct);
            jSONObject.put(CrashHianalyticsData.TIME, this.time);
            jSONObject.put("reqsp", this.reqsp);
            jSONObject.put("reqLength", this.reqLength);
            jSONObject.put("ressp", this.ressp);
            jSONObject.put("resLength", this.resLength);
            jSONObject.put("realnt", this.realnt);
            jSONObject.put("dnsserver", this.dnsserver);
            jSONObject.put(MTCoreConstants.Protocol.KEY_PROTOCOL, this.protocol);
            jSONObject.put("tls", this.tls);
            if (!TextUtils.isEmpty(this.msg)) {
                jSONObject.put(RemoteMessageConst.MessageBody.MSG, this.msg);
            }
            if (!TextUtils.isEmpty(this.rescode)) {
                jSONObject.put("rescode", this.rescode);
            }
            ApiResHeader apiResHeader = this.resheader;
            if (apiResHeader != null) {
                jSONObject.put("resheader", apiResHeader.b());
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public String toString() {
        return toJsonString();
    }
}
