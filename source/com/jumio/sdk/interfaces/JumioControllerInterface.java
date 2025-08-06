package com.jumio.sdk.interfaces;

import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.result.JumioResult;
import java.util.List;

public interface JumioControllerInterface {
    void onError(JumioError jumioError);

    void onFinished(JumioResult jumioResult);

    void onInitialized(List<JumioCredentialInfo> list, List<JumioConsentItem> list2);
}
