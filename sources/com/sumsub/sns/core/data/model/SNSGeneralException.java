package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@a
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSGeneralException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "reason", "(Ljava/lang/String;Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public class SNSGeneralException extends Exception {
    private final String reason;

    public SNSGeneralException() {
        this((String) null, (String) null, 3, (r) null);
    }

    public final String getReason() {
        return this.reason;
    }

    public SNSGeneralException(String str, String str2) {
        super(str);
        this.reason = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSGeneralException(String str, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
    }
}
