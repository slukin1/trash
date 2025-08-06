package cn.sharesdk.framework.authorize;

import android.content.Intent;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public SSOAuthorizeActivity f13417a;

    /* renamed from: b  reason: collision with root package name */
    public int f13418b;

    /* renamed from: c  reason: collision with root package name */
    public SSOListener f13419c;

    public c(SSOAuthorizeActivity sSOAuthorizeActivity) {
        this.f13417a = sSOAuthorizeActivity;
        this.f13419c = sSOAuthorizeActivity.getHelper().getSSOListener();
    }

    public abstract void a();

    public void a(int i11) {
        this.f13418b = i11;
    }

    public void a(int i11, int i12, Intent intent) {
    }

    public void a(Intent intent) {
    }
}
