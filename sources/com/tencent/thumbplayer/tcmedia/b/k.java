package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaRTCAsset;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.io.IOException;

public class k extends d implements ITPMediaRTCAsset {

    /* renamed from: a  reason: collision with root package name */
    private String f49007a;

    /* renamed from: b  reason: collision with root package name */
    private String f49008b;

    /* renamed from: c  reason: collision with root package name */
    private int f49009c = 0;

    public k(String str, String str2) {
        this.f49007a = str;
        this.f49008b = str2;
    }

    public k(String str, String str2, int i11) {
        this.f49007a = str;
        this.f49008b = str2;
        this.f49009c = i11;
    }

    public int getMediaType() {
        return 0;
    }

    public int getRtcSdpExchangeType() {
        return this.f49009c;
    }

    public String getRtcServerUrl() {
        return this.f49008b;
    }

    public String getRtcStreamUrl() {
        return this.f49007a;
    }

    public String getUrl() {
        try {
            return i.a((ITPMediaRTCAsset) this);
        } catch (IOException e11) {
            TPLogUtil.e("TPMediaWebrtcAsset", (Throwable) e11);
            return "";
        }
    }
}
