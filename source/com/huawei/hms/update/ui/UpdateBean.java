package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateBean implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f38550a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f38551b;

    /* renamed from: c  reason: collision with root package name */
    private String f38552c;

    /* renamed from: d  reason: collision with root package name */
    private int f38553d;

    /* renamed from: e  reason: collision with root package name */
    private String f38554e;

    /* renamed from: f  reason: collision with root package name */
    private String f38555f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f38556g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f38557h = true;

    private static <T> T a(T t11) {
        return t11;
    }

    public String getClientAppId() {
        return (String) a(this.f38554e);
    }

    public String getClientAppName() {
        return (String) a(this.f38555f);
    }

    public String getClientPackageName() {
        return (String) a(this.f38552c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f38553d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f38551b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f38556g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f38550a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f38557h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f38554e = str;
    }

    public void setClientAppName(String str) {
        this.f38555f = str;
    }

    public void setClientPackageName(String str) {
        this.f38552c = str;
    }

    public void setClientVersionCode(int i11) {
        this.f38553d = i11;
    }

    public void setHmsOrApkUpgrade(boolean z11) {
        this.f38550a = z11;
    }

    public void setNeedConfirm(boolean z11) {
        this.f38557h = z11;
    }

    public void setResolutionInstallHMS(boolean z11) {
        this.f38551b = z11;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f38556g = arrayList;
    }
}
