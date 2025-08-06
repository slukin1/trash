package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOAuthorizeActivity;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.c;

public abstract class f implements AuthorizeHelper {

    /* renamed from: a  reason: collision with root package name */
    public Platform f13438a;

    /* renamed from: b  reason: collision with root package name */
    private AuthorizeListener f13439b;

    /* renamed from: c  reason: collision with root package name */
    private SSOListener f13440c;

    public f(Platform platform) {
        this.f13438a = platform;
    }

    public void a(SSOListener sSOListener) {
        this.f13440c = sSOListener;
        SSOAuthorizeActivity sSOAuthorizeActivity = new SSOAuthorizeActivity();
        sSOAuthorizeActivity.setSSOListener(sSOListener);
        sSOAuthorizeActivity.show(this);
    }

    public int b() {
        return this.f13438a.getPlatformId();
    }

    public AuthorizeListener getAuthorizeListener() {
        return this.f13439b;
    }

    public Platform getPlatform() {
        return this.f13438a;
    }

    public SSOListener getSSOListener() {
        return this.f13440c;
    }

    public c getSSOProcessor(SSOAuthorizeActivity sSOAuthorizeActivity) {
        return null;
    }

    public void b(AuthorizeListener authorizeListener) {
        this.f13439b = authorizeListener;
        WebAuthorizeActivity webAuthorizeActivity = new WebAuthorizeActivity();
        webAuthorizeActivity.setAuthorizeListener(this.f13439b);
        webAuthorizeActivity.show(this);
    }
}
