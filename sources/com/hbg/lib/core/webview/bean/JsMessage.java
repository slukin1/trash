package com.hbg.lib.core.webview.bean;

import com.huobi.utils.GsonHelper;
import java.io.Serializable;

public class JsMessage<T> implements Serializable {
    private static final long serialVersionUID = -880089669721093238L;
    private String action;
    private String callback;
    private int code;
    private T data;
    private String msg;

    public String getAction() {
        return this.action;
    }

    public String getCallback() {
        return this.callback;
    }

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setCallback(String str) {
        this.callback = str;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setData(T t11) {
        this.data = t11;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return GsonHelper.a().toJson((Object) this);
    }

    public JsMessage clone() {
        JsMessage jsMessage = new JsMessage();
        jsMessage.msg = this.msg;
        jsMessage.code = this.code;
        jsMessage.action = this.action;
        jsMessage.callback = this.callback;
        jsMessage.data = this.data;
        return jsMessage;
    }
}
