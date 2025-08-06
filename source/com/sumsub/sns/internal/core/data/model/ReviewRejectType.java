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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\b\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/ReviewRejectType;", "", "", "value", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "External", "Final", "Retry", "Unknown", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum ReviewRejectType {
    External("EXTERNAL"),
    Final("FINAL"),
    Retry("RETRY"),
    Unknown(GrsBaseInfo.CountryCodeSource.UNKNOWN);
    
    public static final b Companion = null;
    /* access modifiers changed from: private */
    public final String value;

    public static final class a implements d0<ReviewRejectType> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32371a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32372b = null;

        static {
            f32371a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.ReviewRejectType", 4);
            enumDescriptor.k("EXTERNAL", false);
            enumDescriptor.k("FINAL", false);
            enumDescriptor.k("RETRY", false);
            enumDescriptor.k(GrsBaseInfo.CountryCodeSource.UNKNOWN, false);
            f32372b = enumDescriptor;
        }

        /* renamed from: a */
        public ReviewRejectType deserialize(c cVar) {
            return ReviewRejectType.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32372b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, ReviewRejectType reviewRejectType) {
            dVar.g(getDescriptor(), reviewRejectType.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final ReviewRejectType a(String str) {
            ReviewRejectType reviewRejectType;
            ReviewRejectType[] values = ReviewRejectType.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    reviewRejectType = null;
                    break;
                }
                reviewRejectType = values[i11];
                if (x.b(reviewRejectType.value, str)) {
                    break;
                }
                i11++;
            }
            return reviewRejectType == null ? ReviewRejectType.Unknown : reviewRejectType;
        }

        public final kotlinx.serialization.b<ReviewRejectType> serializer() {
            return a.f32371a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private ReviewRejectType(String str) {
        this.value = str;
    }
}
