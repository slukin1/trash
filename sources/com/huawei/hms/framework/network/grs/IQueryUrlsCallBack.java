package com.huawei.hms.framework.network.grs;

import java.util.Map;

public interface IQueryUrlsCallBack {
    void onCallBackFail(int i11);

    void onCallBackSuccess(Map<String, String> map);
}
