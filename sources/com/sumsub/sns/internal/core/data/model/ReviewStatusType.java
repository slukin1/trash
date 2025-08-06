package com.sumsub.sns.internal.core.data.model;

import com.huobi.points.entity.PointsPack;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.v1;

@f
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/ReviewStatusType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "Init", "Queued", "Completed", "Pending", "Prechecked", "Unknown", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum ReviewStatusType {
    Init(ZendeskBlipsProvider.ACTION_CORE_INIT),
    Queued("queued"),
    Completed("completed"),
    Pending(PointsPack.STATE_PENDING),
    Prechecked("prechecked"),
    Unknown("unknown");
    
    public static final b Companion = null;
    private final String value;

    public static final class a implements d0<ReviewStatusType> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32373a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32374b = null;

        static {
            f32373a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.ReviewStatusType", 6);
            enumDescriptor.k(ZendeskBlipsProvider.ACTION_CORE_INIT, false);
            enumDescriptor.k("queued", false);
            enumDescriptor.k("completed", false);
            enumDescriptor.k(PointsPack.STATE_PENDING, false);
            enumDescriptor.k("prechecked", false);
            enumDescriptor.k("unknown", false);
            f32374b = enumDescriptor;
        }

        /* renamed from: a */
        public ReviewStatusType deserialize(c cVar) {
            return ReviewStatusType.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32374b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, ReviewStatusType reviewStatusType) {
            dVar.g(getDescriptor(), reviewStatusType.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final ReviewStatusType a(String str) {
            ReviewStatusType reviewStatusType;
            ReviewStatusType[] values = ReviewStatusType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    reviewStatusType = null;
                    break;
                }
                reviewStatusType = values[i11];
                if (x.b(reviewStatusType.getValue(), str)) {
                    break;
                }
                i11++;
            }
            return reviewStatusType == null ? ReviewStatusType.Unknown : reviewStatusType;
        }

        public final kotlinx.serialization.b<ReviewStatusType> serializer() {
            return a.f32373a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private ReviewStatusType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
