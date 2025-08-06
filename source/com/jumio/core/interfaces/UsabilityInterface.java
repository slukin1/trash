package com.jumio.core.interfaces;

import com.jumio.core.models.ApiCallDataModel;

public interface UsabilityInterface {
    String getMultipartNameForUsabilityResultKey(ApiCallDataModel<?> apiCallDataModel);

    boolean getShouldEnableUsability();
}
