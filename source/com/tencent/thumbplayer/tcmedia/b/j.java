package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class j extends d implements ITPMediaDRMAsset {

    /* renamed from: a  reason: collision with root package name */
    private String f49003a;
    @TPCommonEnum.TP_DRM_TYPE

    /* renamed from: b  reason: collision with root package name */
    private int f49004b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f49005c;

    /* renamed from: d  reason: collision with root package name */
    private String f49006d = "";

    public j(@TPCommonEnum.TP_DRM_TYPE int i11, String str) {
        this.f49003a = str;
        this.f49004b = i11;
        this.f49005c = new HashMap();
    }

    public Map<String, String> getDrmAllProperties() {
        return this.f49005c;
    }

    public String getDrmPlayUrl() {
        return this.f49003a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r1.f49005c.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDrmProperty(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.f49005c
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000b
            goto L_0x0017
        L_0x000b:
            java.util.Map<java.lang.String, java.lang.String> r0 = r1.f49005c
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0016
            return r3
        L_0x0016:
            return r2
        L_0x0017:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.b.j.getDrmProperty(java.lang.String, java.lang.String):java.lang.String");
    }

    @TPCommonEnum.TP_DRM_TYPE
    public int getDrmType() {
        return this.f49004b;
    }

    public int getMediaType() {
        return 0;
    }

    public String getOfflineKeySetId() {
        return this.f49006d;
    }

    public String getUrl() {
        try {
            return i.a((ITPMediaDRMAsset) this);
        } catch (IOException e11) {
            TPLogUtil.e("TPMediaDRMAsset", (Throwable) e11);
            return "";
        }
    }

    public void setDrmPlayUrl(String str) {
        this.f49003a = str;
    }

    public void setDrmProperty(String str, String str2) {
        this.f49005c.put(str, str2);
    }

    public void setDrmType(@TPCommonEnum.TP_DRM_TYPE int i11) {
        this.f49004b = i11;
    }

    public void setOfflineKeySetId(String str) {
        this.f49006d = str;
    }
}
