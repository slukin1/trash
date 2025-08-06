package com.huobi.account.bean;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
public class GrayWhiteListBean {
    public String bundleIDAndroid = "pro.huobi";
    public List<String> devices = new ArrayList();
    public int minVersionAndroid = 0;
    public String name;
    public List<String> pathRegulars = new ArrayList();
    public String type = "h5";
    public List<String> uids = new ArrayList();

    public String toString() {
        return "GrayWhiteListBean{name='" + this.name + '\'' + ", type='" + this.type + '\'' + ", minVersion=" + this.minVersionAndroid + ", bunleID='" + this.bundleIDAndroid + '\'' + ", pathRegular=" + this.pathRegulars + ", uids=" + this.uids + ", devices=" + this.devices + '}';
    }
}
