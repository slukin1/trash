package com.tencent.thumbplayer.tcmedia.c;

import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;

public class j implements b {

    /* renamed from: a  reason: collision with root package name */
    private ITPDownloadProxy f49108a;

    public j(ITPDownloadProxy iTPDownloadProxy) {
        this.f49108a = iTPDownloadProxy;
    }

    public ITPDownloadProxy a() {
        return this.f49108a;
    }

    public void a(int i11) {
        this.f49108a.pushEvent(i11);
    }
}
