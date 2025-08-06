package com.tencent.thumbplayer.tcmedia.b;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetOrderedMap;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class c implements ITPMediaAssetOrderedMap {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f48980a = new StringBuilder();

    public void addKeyValue(String str, String str2) {
        TPLogUtil.i("TPMediaAssetOrderedMap", "addKeyValue key:" + str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
        StringBuilder sb2 = this.f48980a;
        sb2.append(str);
        sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb2.append(str2);
        sb2.append(";");
    }

    public String getKeyValueStr() {
        TPLogUtil.i("TPMediaAssetOrderedMap", "getKeyValueStr " + this.f48980a.toString());
        return this.f48980a.toString();
    }
}
