package com.sumsub.sns.internal.core.data.model;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;

@f
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\b\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/ReviewAnswerType;", "", "", "value", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "Green", "Red", "Unknown", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum ReviewAnswerType {
    Green("GREEN"),
    Red("RED"),
    Unknown(GrsBaseInfo.CountryCodeSource.UNKNOWN);
    
    public static final b Companion = null;
    /* access modifiers changed from: private */
    public final String value;

    public static final class a implements d0<ReviewAnswerType> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32369a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32370b = null;

        static {
            f32369a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.ReviewAnswerType", 3);
            enumDescriptor.k("GREEN", false);
            enumDescriptor.k("RED", false);
            enumDescriptor.k(GrsBaseInfo.CountryCodeSource.UNKNOWN, false);
            f32370b = enumDescriptor;
        }

        /* renamed from: a */
        public ReviewAnswerType deserialize(c cVar) {
            return ReviewAnswerType.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32370b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, ReviewAnswerType reviewAnswerType) {
            dVar.g(getDescriptor(), reviewAnswerType.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final ReviewAnswerType a(String str) {
            ReviewAnswerType reviewAnswerType;
            ReviewAnswerType[] values = ReviewAnswerType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    reviewAnswerType = null;
                    break;
                }
                reviewAnswerType = values[i11];
                if (x.b(reviewAnswerType.value, str)) {
                    break;
                }
                i11++;
            }
            return reviewAnswerType == null ? ReviewAnswerType.Unknown : reviewAnswerType;
        }

        public final kotlinx.serialization.b<ReviewAnswerType> serializer() {
            return a.f32369a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private ReviewAnswerType(String str) {
        this.value = str;
    }
}
