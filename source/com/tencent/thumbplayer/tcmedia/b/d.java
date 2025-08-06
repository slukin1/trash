package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetExtraParam;
import java.util.Map;

public class d implements ITPMediaAsset {

    /* renamed from: a  reason: collision with root package name */
    private ITPMediaAssetExtraParam f48981a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f48982b;

    public ITPMediaAssetExtraParam getExtraParam() {
        return this.f48981a;
    }

    public Map<String, String> getHttpHeader() {
        return this.f48982b;
    }

    public int getMediaType() {
        return 0;
    }

    public String getUrl() {
        return "";
    }

    public void setExtraParam(ITPMediaAssetExtraParam iTPMediaAssetExtraParam) {
        this.f48981a = iTPMediaAssetExtraParam;
    }

    public void setHttpHeader(Map<String, String> map) {
        this.f48982b = map;
    }
}
