package com.huobi.engineutils.bean;

import java.io.Serializable;
import java.util.List;

public class JsAssetLevelData implements Serializable {
    private List<LongAssetLevelData> longLevelDataList;
    private List<ShortAssetLevelData> shortLevelDataList;

    public void setLongLevelDataList(List<LongAssetLevelData> list) {
        this.longLevelDataList = list;
    }

    public void setShortLevelDataList(List<ShortAssetLevelData> list) {
        this.shortLevelDataList = list;
    }
}
