package com.zopim.android.sdk.api;

import com.zopim.android.sdk.model.VisitorInfo;

public interface ChatApiConfig {
    String getDepartment();

    String[] getTags();

    VisitorInfo getVisitorInfo();
}
