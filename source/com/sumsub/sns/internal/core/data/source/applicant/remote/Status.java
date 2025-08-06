package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.huobi.finance.bean.LoanOrderItem;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.v1;

@f
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/Status;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "CREATED", "RETRY", "VERIFIED", "REJECTED", "UNKNOWN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum Status {
    CREATED(LoanOrderItem.CREATED),
    RETRY("retry"),
    VERIFIED("verified"),
    REJECTED("rejected"),
    UNKNOWN("unknown");
    
    public static final b Companion = null;
    private final String value;

    public static final class a implements d0<Status> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33047a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33048b = null;

        static {
            f33047a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.Status", 5);
            enumDescriptor.k(LoanOrderItem.CREATED, false);
            enumDescriptor.k("retry", false);
            enumDescriptor.k("verified", false);
            enumDescriptor.k("rejected", false);
            enumDescriptor.k("unknown", false);
            f33048b = enumDescriptor;
        }

        /* renamed from: a */
        public Status deserialize(c cVar) {
            return Status.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33048b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, Status status) {
            dVar.g(getDescriptor(), status.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.String] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.sumsub.sns.internal.core.data.source.applicant.remote.Status a(java.lang.String r7) {
            /*
                r6 = this;
                com.sumsub.sns.internal.core.data.source.applicant.remote.Status[] r0 = com.sumsub.sns.internal.core.data.source.applicant.remote.Status.values()
                int r1 = r0.length
                r2 = 0
            L_0x0006:
                r3 = 0
                if (r2 >= r1) goto L_0x0022
                r4 = r0[r2]
                java.lang.String r5 = r4.getValue()
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
                com.sumsub.sns.internal.core.data.source.applicant.remote.Status r3 = com.sumsub.sns.internal.core.data.source.applicant.remote.Status.UNKNOWN
            L_0x0026:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.Status.b.a(java.lang.String):com.sumsub.sns.internal.core.data.source.applicant.remote.Status");
        }

        public final kotlinx.serialization.b<Status> serializer() {
            return a.f33047a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private Status(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
