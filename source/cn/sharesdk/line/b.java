package cn.sharesdk.line;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Platform f13609a;

    /* renamed from: b  reason: collision with root package name */
    private Platform.ShareParams f13610b;

    /* renamed from: c  reason: collision with root package name */
    private PlatformActionListener f13611c;

    public b(Platform platform) {
        this.f13609a = platform;
    }

    public void a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.f13610b = shareParams;
        this.f13611c = platformActionListener;
    }

    public Platform a() {
        return this.f13609a;
    }
}
