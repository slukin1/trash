package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaUrlAsset;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.io.IOException;

public class l extends d implements ITPMediaUrlAsset {

    /* renamed from: a  reason: collision with root package name */
    private String f49010a;

    public l(String str) {
        this.f49010a = str;
    }

    public int getMediaType() {
        return 0;
    }

    public String getStreamUrl() {
        return this.f49010a;
    }

    public String getUrl() {
        try {
            return i.a((ITPMediaUrlAsset) this);
        } catch (IOException e11) {
            TPLogUtil.e("TPMediaUrlAsset", (Throwable) e11);
            return "";
        }
    }

    public void setStreamUrl(String str) {
        this.f49010a = str;
    }
}
