package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

public class ConnectInfo implements IMessageEntity {
    @Packed

    /* renamed from: a  reason: collision with root package name */
    private List<String> f38485a;
    @Packed

    /* renamed from: b  reason: collision with root package name */
    private List<Scope> f38486b;
    @Packed

    /* renamed from: c  reason: collision with root package name */
    private String f38487c;
    @Packed

    /* renamed from: d  reason: collision with root package name */
    private String f38488d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f38485a;
    }

    public String getFingerprint() {
        return this.f38487c;
    }

    public List<Scope> getScopeList() {
        return this.f38486b;
    }

    public String getSubAppID() {
        return this.f38488d;
    }

    public void setApiNameList(List<String> list) {
        this.f38485a = list;
    }

    public void setFingerprint(String str) {
        this.f38487c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f38486b = list;
    }

    public void setSubAppID(String str) {
        this.f38488d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f38485a = list;
        this.f38486b = list2;
        this.f38487c = str;
        this.f38488d = str2;
    }
}
