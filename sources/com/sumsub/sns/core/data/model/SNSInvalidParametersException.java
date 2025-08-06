package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import java.util.List;
import kotlin.Metadata;

@a
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSInvalidParametersException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "messages", "", "", "(Ljava/util/List;)V", "getMessages", "()Ljava/util/List;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSInvalidParametersException extends Exception {
    private final List<String> messages;

    public SNSInvalidParametersException(List<String> list) {
        this.messages = list;
    }

    public final List<String> getMessages() {
        return this.messages;
    }
}
