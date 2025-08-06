package com.alibaba.verificationsdk.ui;

import java.util.Map;

public interface IActivityCallback {
    void onNotifyBackPressed();

    void onResult(int i11, Map<String, String> map);
}
