package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

public class ClientSettings {

    /* renamed from: a  reason: collision with root package name */
    private String f37917a;

    /* renamed from: b  reason: collision with root package name */
    private String f37918b;

    /* renamed from: c  reason: collision with root package name */
    private List<Scope> f37919c;

    /* renamed from: d  reason: collision with root package name */
    private String f37920d;

    /* renamed from: e  reason: collision with root package name */
    private List<String> f37921e;

    /* renamed from: f  reason: collision with root package name */
    private String f37922f;

    /* renamed from: g  reason: collision with root package name */
    private SubAppInfo f37923g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<Activity> f37924h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37925i;

    /* renamed from: j  reason: collision with root package name */
    private String f37926j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37927k;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.f37917a = str;
        this.f37918b = str2;
        this.f37919c = list;
        this.f37920d = str3;
        this.f37921e = list2;
    }

    public List<String> getApiName() {
        return this.f37921e;
    }

    public String getAppID() {
        return this.f37920d;
    }

    public String getClientClassName() {
        return this.f37918b;
    }

    public String getClientPackageName() {
        return this.f37917a;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.f37924h;
        if (weakReference == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public String getCpID() {
        return this.f37922f;
    }

    public String getInnerHmsPkg() {
        return this.f37926j;
    }

    public List<Scope> getScopes() {
        return this.f37919c;
    }

    public SubAppInfo getSubAppID() {
        return this.f37923g;
    }

    public boolean isHasActivity() {
        return this.f37925i;
    }

    public boolean isUseInnerHms() {
        return this.f37927k;
    }

    public void setApiName(List<String> list) {
        this.f37921e = list;
    }

    public void setAppID(String str) {
        this.f37920d = str;
    }

    public void setClientClassName(String str) {
        this.f37918b = str;
    }

    public void setClientPackageName(String str) {
        this.f37917a = str;
    }

    public void setCpActivity(Activity activity) {
        this.f37924h = new WeakReference<>(activity);
        this.f37925i = true;
    }

    public void setCpID(String str) {
        this.f37922f = str;
    }

    public void setInnerHmsPkg(String str) {
        this.f37926j = str;
    }

    public void setScopes(List<Scope> list) {
        this.f37919c = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.f37923g = subAppInfo;
    }

    public void setUseInnerHms(boolean z11) {
        this.f37927k = z11;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        this.f37923g = subAppInfo;
    }
}
