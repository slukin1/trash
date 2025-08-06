package com.sumsub.sns.internal.core.data.model;

import com.sumsub.sns.internal.core.common.i;
import java.util.Map;
import kotlin.l;

public final class r {
    public static final Map<String, String> a(LogParams logParams) {
        return i.a(MapsKt__MapsKt.l(l.a("errorType", logParams.getErrorType()), l.a("location", logParams.getLocation()), l.a("externalUserId", logParams.getExternalUserId()), l.a("fileName", logParams.getFileName()), l.a("applicantId", logParams.getApplicantId()), l.a("message", logParams.getMessage()), l.a("kind", logParams.getKind()), l.a("stacktrace", logParams.getStacktrace())));
    }
}
