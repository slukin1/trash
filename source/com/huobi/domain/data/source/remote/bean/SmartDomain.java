package com.huobi.domain.data.source.remote.bean;

import java.io.Serializable;
import java.util.Arrays;

public class SmartDomain implements Serializable {
    private static final long serialVersionUID = 5256682122962867840L;
    public int back_interval = 1200;
    public int err_threshold = 3;
    public String[] err_types = {"TimeoutException", "UnknownHostException", "SSLException"};
    public int req_interval = 300;
    public int request_again = 0;
    public int switch_err = 1;
    public int switch_network = 1;
    public int switch_vpn = 1;
    public int timer_interval = 300;
    public String url;
    public String url_security;

    public boolean canEqual(Object obj) {
        return obj instanceof SmartDomain;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SmartDomain)) {
            return false;
        }
        SmartDomain smartDomain = (SmartDomain) obj;
        if (!smartDomain.canEqual(this)) {
            return false;
        }
        String url2 = getUrl();
        String url3 = smartDomain.getUrl();
        if (url2 != null ? !url2.equals(url3) : url3 != null) {
            return false;
        }
        String url_security2 = getUrl_security();
        String url_security3 = smartDomain.getUrl_security();
        if (url_security2 != null ? url_security2.equals(url_security3) : url_security3 == null) {
            return getReq_interval() == smartDomain.getReq_interval() && getTimer_interval() == smartDomain.getTimer_interval() && getBack_interval() == smartDomain.getBack_interval() && getErr_threshold() == smartDomain.getErr_threshold() && getSwitch_err() == smartDomain.getSwitch_err() && getSwitch_network() == smartDomain.getSwitch_network() && getSwitch_vpn() == smartDomain.getSwitch_vpn() && getRequest_again() == smartDomain.getRequest_again() && Arrays.deepEquals(getErr_types(), smartDomain.getErr_types());
        }
        return false;
    }

    public int getBack_interval() {
        return this.back_interval;
    }

    public int getErr_threshold() {
        return this.err_threshold;
    }

    public String[] getErr_types() {
        return this.err_types;
    }

    public int getReq_interval() {
        return this.req_interval;
    }

    public int getRequest_again() {
        return this.request_again;
    }

    public int getSwitch_err() {
        return this.switch_err;
    }

    public int getSwitch_network() {
        return this.switch_network;
    }

    public int getSwitch_vpn() {
        return this.switch_vpn;
    }

    public int getTimer_interval() {
        return this.timer_interval;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrl_security() {
        return this.url_security;
    }

    public int hashCode() {
        String url2 = getUrl();
        int i11 = 43;
        int hashCode = url2 == null ? 43 : url2.hashCode();
        String url_security2 = getUrl_security();
        int i12 = (hashCode + 59) * 59;
        if (url_security2 != null) {
            i11 = url_security2.hashCode();
        }
        return ((((((((((((((((((i12 + i11) * 59) + getReq_interval()) * 59) + getTimer_interval()) * 59) + getBack_interval()) * 59) + getErr_threshold()) * 59) + getSwitch_err()) * 59) + getSwitch_network()) * 59) + getSwitch_vpn()) * 59) + getRequest_again()) * 59) + Arrays.deepHashCode(getErr_types());
    }

    public void setBack_interval(int i11) {
        this.back_interval = i11;
    }

    public void setErr_threshold(int i11) {
        this.err_threshold = i11;
    }

    public void setErr_types(String[] strArr) {
        this.err_types = strArr;
    }

    public void setReq_interval(int i11) {
        this.req_interval = i11;
    }

    public void setRequest_again(int i11) {
        this.request_again = i11;
    }

    public void setSwitch_err(int i11) {
        this.switch_err = i11;
    }

    public void setSwitch_network(int i11) {
        this.switch_network = i11;
    }

    public void setSwitch_vpn(int i11) {
        this.switch_vpn = i11;
    }

    public void setTimer_interval(int i11) {
        this.timer_interval = i11;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrl_security(String str) {
        this.url_security = str;
    }

    public String toString() {
        return "SmartDomain(url=" + getUrl() + ", url_security=" + getUrl_security() + ", req_interval=" + getReq_interval() + ", timer_interval=" + getTimer_interval() + ", back_interval=" + getBack_interval() + ", err_threshold=" + getErr_threshold() + ", switch_err=" + getSwitch_err() + ", switch_network=" + getSwitch_network() + ", switch_vpn=" + getSwitch_vpn() + ", request_again=" + getRequest_again() + ", err_types=" + Arrays.deepToString(getErr_types()) + ")";
    }
}
