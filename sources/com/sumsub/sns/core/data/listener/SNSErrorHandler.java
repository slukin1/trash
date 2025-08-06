package com.sumsub.sns.core.data.listener;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import com.sumsub.sns.core.data.model.SNSException;
import kotlin.Metadata;

@a
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "", "onError", "", "exception", "Lcom/sumsub/sns/core/data/model/SNSException;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public interface SNSErrorHandler {
    void onError(SNSException sNSException);
}
