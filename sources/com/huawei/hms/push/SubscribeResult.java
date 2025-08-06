package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

public class SubscribeResult extends Result {

    /* renamed from: a  reason: collision with root package name */
    private String f38388a;

    /* renamed from: b  reason: collision with root package name */
    private List<SubscribedItem> f38389b;

    public String getErrorMsg() {
        return this.f38388a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.f38389b;
    }

    public void setErrorMsg(String str) {
        this.f38388a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.f38389b = list;
    }
}
