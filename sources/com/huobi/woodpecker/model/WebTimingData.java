package com.huobi.woodpecker.model;

import com.huobi.woodpecker.model.base.IRecord;
import java.io.Serializable;
import kv.e;
import org.json.JSONException;
import org.json.JSONObject;

public class WebTimingData implements IRecord, Serializable {
    public long dns;
    public int errorCode = 0;
    public String errorMsg;
    public long ete;
    public long fbt;
    public long fcp;
    public long fpt;
    public boolean isFirst;

    /* renamed from: op  reason: collision with root package name */
    public String f21146op;
    public long pdrt;
    public long plt;
    public long ppt;
    public long rct;
    public long rdt;
    public long ssl;
    public long tcp;
    public long ttfb;
    public String url;

    public WebTimingData() {
    }

    public long getDns() {
        return this.dns;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getFbt() {
        return this.fbt;
    }

    public long getFcp() {
        return this.fcp;
    }

    public long getFpt() {
        return this.fpt;
    }

    public long getPdrt() {
        return this.pdrt;
    }

    public long getPlt() {
        return this.plt;
    }

    public long getPpt() {
        return this.ppt;
    }

    public long getRct() {
        return this.rct;
    }

    public long getRdt() {
        return this.rdt;
    }

    public long getSsl() {
        return this.ssl;
    }

    public long getTcp() {
        return this.tcp;
    }

    public long getTtfb() {
        return this.ttfb;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setDns(long j11) {
        this.dns = j11;
    }

    public void setErrorCode(int i11) {
        this.errorCode = i11;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setFbt(long j11) {
        this.fbt = j11;
    }

    public void setFcp(long j11) {
        this.fcp = j11;
    }

    public void setFirst(boolean z11) {
        this.isFirst = z11;
    }

    public void setFpt(long j11) {
        this.fpt = j11;
    }

    public void setPdrt(long j11) {
        this.pdrt = j11;
    }

    public void setPlt(long j11) {
        this.plt = j11;
    }

    public void setPpt(long j11) {
        this.ppt = j11;
    }

    public void setRct(long j11) {
        this.rct = j11;
    }

    public void setRdt(long j11) {
        this.rdt = j11;
    }

    public void setSsl(long j11) {
        this.ssl = j11;
    }

    public void setTcp(long j11) {
        this.tcp = j11;
    }

    public void setTtfb(long j11) {
        this.ttfb = j11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.url);
            jSONObject.put("isFirst", this.isFirst);
            jSONObject.put("dns", this.dns);
            jSONObject.put("tcp", this.tcp);
            jSONObject.put("ssl", this.ssl);
            jSONObject.put("ttfb", this.ttfb);
            jSONObject.put("rct", this.rct);
            jSONObject.put("rdt", this.rdt);
            jSONObject.put("ppt", this.ppt);
            jSONObject.put("fpt", this.fpt);
            jSONObject.put("fbt", this.fbt);
            jSONObject.put("pdrt", this.pdrt);
            jSONObject.put("plt", this.plt);
            jSONObject.put("fcp", this.fcp);
            jSONObject.put("ete", this.ete);
            jSONObject.put("errorCode", this.errorCode);
            jSONObject.put("errorMsg", this.errorMsg);
            jSONObject.put("op", this.f21146op);
        } catch (JSONException e11) {
            e.g("WoodPeckerJSObject", "toJsonObject: JSONException", e11);
        }
        return jSONObject;
    }

    public String toJsonString() {
        return toJsonObject().toString();
    }

    public WebTimingData(String str, int i11, String str2) {
        this.url = str;
        this.errorCode = i11;
        this.errorMsg = str2;
    }

    public WebTimingData(String str, boolean z11, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, long j22, long j23, long j24) {
        this.url = str;
        this.isFirst = z11;
        this.dns = j11;
        this.tcp = j12;
        this.ssl = j13;
        this.ttfb = j14;
        this.rct = j15;
        this.rdt = j16;
        this.ppt = j17;
        this.fpt = j18;
        this.fbt = j19;
        this.pdrt = j21;
        this.plt = j22;
        this.fcp = j23;
        this.ete = j24;
    }
}
