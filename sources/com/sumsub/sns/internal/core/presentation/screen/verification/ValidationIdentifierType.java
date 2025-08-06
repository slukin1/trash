package com.sumsub.sns.internal.core.presentation.screen.verification;

import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/internal/core/presentation/screen/verification/ValidationIdentifierType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "EMAIL", "PHONE", "UNKNOWN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum ValidationIdentifierType {
    EMAIL("email"),
    PHONE(PlaceFields.PHONE),
    UNKNOWN("unknown");
    
    public static final a Companion = null;
    private final String type;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType a(java.lang.String r7) {
            /*
                r6 = this;
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType[] r0 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.values()
                int r1 = r0.length
                r2 = 0
            L_0x0006:
                r3 = 0
                if (r2 >= r1) goto L_0x0022
                r4 = r0[r2]
                java.lang.String r5 = r4.getType()
                if (r7 == 0) goto L_0x0017
                java.util.Locale r3 = java.util.Locale.ROOT
                java.lang.String r3 = r7.toLowerCase(r3)
            L_0x0017:
                boolean r3 = kotlin.jvm.internal.x.b(r5, r3)
                if (r3 == 0) goto L_0x001f
                r3 = r4
                goto L_0x0022
            L_0x001f:
                int r2 = r2 + 1
                goto L_0x0006
            L_0x0022:
                if (r3 != 0) goto L_0x0026
                com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType r3 = com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.UNKNOWN
            L_0x0026:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType.a.a(java.lang.String):com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType");
        }

        public a() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new a((r) null);
    }

    private ValidationIdentifierType(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
