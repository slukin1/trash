package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetExtraParam;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetObjectParam;
import java.io.Serializable;
import java.util.HashMap;

public class b implements ITPMediaAssetExtraParam {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Serializable> f48979a = new HashMap<>();

    public int getExtraInt(String str) {
        if (this.f48979a.containsKey(str)) {
            return ((Integer) this.f48979a.get(str)).intValue();
        }
        return -1;
    }

    public ITPMediaAssetObjectParam getExtraObject(String str) {
        if (this.f48979a.get(str) instanceof ITPMediaAssetObjectParam) {
            return (ITPMediaAssetObjectParam) this.f48979a.get(str);
        }
        return null;
    }

    public String getExtraString(String str) {
        return this.f48979a.containsKey(str) ? (String) this.f48979a.get(str) : "";
    }

    public void setExtraInt(String str, int i11) {
        this.f48979a.put(str, Integer.valueOf(i11));
    }

    public void setExtraObject(String str, ITPMediaAssetObjectParam iTPMediaAssetObjectParam) {
        this.f48979a.put(str, iTPMediaAssetObjectParam);
    }

    public void setExtraString(String str, String str2) {
        this.f48979a.put(str, str2);
    }
}
