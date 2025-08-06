package com.sumsub.sentry;

import com.facebook.internal.AnalyticsEvents;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;

@f
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\r\u000eB\u0011\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/sumsub/sentry/SpanStatus;", "", "", "httpStatusCode", "", "matches", "minHttpStatusCode", "I", "maxHttpStatusCode", "<init>", "(Ljava/lang/String;II)V", "(Ljava/lang/String;III)V", "Companion", "a", "b", "OK", "CANCELLED", "INTERNAL_ERROR", "UNKNOWN", "UNKNOWN_ERROR", "INVALID_ARGUMENT", "DEADLINE_EXCEEDED", "NOT_FOUND", "ALREADY_EXISTS", "PERMISSION_DENIED", "RESOURCE_EXHAUSTED", "FAILED_PRECONDITION", "ABORTED", "OUT_OF_RANGE", "UNIMPLEMENTED", "UNAVAILABLE", "DATA_LOSS", "UNAUTHENTICATED", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum SpanStatus {
    OK(200, 299),
    CANCELLED(499),
    INTERNAL_ERROR(500),
    UNKNOWN(500),
    UNKNOWN_ERROR(500),
    INVALID_ARGUMENT(400),
    DEADLINE_EXCEEDED(504),
    NOT_FOUND(404),
    ALREADY_EXISTS(409),
    PERMISSION_DENIED(403),
    RESOURCE_EXHAUSTED(429),
    FAILED_PRECONDITION(400),
    ABORTED(409),
    OUT_OF_RANGE(400),
    UNIMPLEMENTED(501),
    UNAVAILABLE(503),
    DATA_LOSS(500),
    UNAUTHENTICATED(401);
    
    public static final b Companion = null;
    private final int maxHttpStatusCode;
    private final int minHttpStatusCode;

    public static final class a implements d0<SpanStatus> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30239a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30240b = null;

        static {
            f30239a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sentry.SpanStatus", 18);
            enumDescriptor.k(BaseHbgResponse.STATUS_OK, false);
            enumDescriptor.k(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED, false);
            enumDescriptor.k("internal_error", false);
            enumDescriptor.k("unknown", false);
            enumDescriptor.k("unknown_error", false);
            enumDescriptor.k("invalid_argument", false);
            enumDescriptor.k("deadline_exceeded", false);
            enumDescriptor.k("not_found", false);
            enumDescriptor.k("already_exists", false);
            enumDescriptor.k("permission_denied", false);
            enumDescriptor.k("resource_exhausted", false);
            enumDescriptor.k("failed_precondition", false);
            enumDescriptor.k("aborted", false);
            enumDescriptor.k("out_of_range", false);
            enumDescriptor.k("unimplemented", false);
            enumDescriptor.k("unavailable", false);
            enumDescriptor.k("data_loss", false);
            enumDescriptor.k("unauthenticated", false);
            f30240b = enumDescriptor;
        }

        /* renamed from: a */
        public SpanStatus deserialize(c cVar) {
            return SpanStatus.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30240b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, SpanStatus spanStatus) {
            dVar.g(getDescriptor(), spanStatus.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final SpanStatus a(int i11) {
            for (SpanStatus spanStatus : SpanStatus.values()) {
                if (spanStatus.matches(i11)) {
                    return spanStatus;
                }
            }
            return null;
        }

        public final kotlinx.serialization.b<SpanStatus> serializer() {
            return a.f30239a;
        }

        public b() {
        }

        public final SpanStatus a(Integer num, SpanStatus spanStatus) {
            SpanStatus a11 = num != null ? a(num.intValue()) : spanStatus;
            return a11 == null ? spanStatus : a11;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private SpanStatus(int i11) {
        this.minHttpStatusCode = i11;
        this.maxHttpStatusCode = i11;
    }

    /* access modifiers changed from: private */
    public final boolean matches(int i11) {
        return i11 <= this.maxHttpStatusCode && this.minHttpStatusCode <= i11;
    }

    private SpanStatus(int i11, int i12) {
        this.minHttpStatusCode = i11;
        this.maxHttpStatusCode = i12;
    }
}
