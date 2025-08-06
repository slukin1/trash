package com.sumsub.sns.core.data.model;

import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import com.sumsub.sns.internal.core.data.serializer.b;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.f;

@a
@f(with = b.class)
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/data/model/FlowActionType;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Companion", "FaceEnrollment", "Other", "Lcom/sumsub/sns/core/data/model/FlowActionType$FaceEnrollment;", "Lcom/sumsub/sns/core/data/model/FlowActionType$Other;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class FlowActionType {
    public static final Companion Companion = new Companion((r) null);
    private final String value;

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/data/model/FlowActionType$Companion;", "", "", "value", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "get", "Lkotlinx/serialization/b;", "serializer", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final FlowActionType get(String str) {
            FaceEnrollment faceEnrollment = FaceEnrollment.INSTANCE;
            if (x.b(str, faceEnrollment.getValue())) {
                return faceEnrollment;
            }
            if (str == null) {
                str = "";
            }
            return new Other(str);
        }

        public final kotlinx.serialization.b<FlowActionType> serializer() {
            return b.f32958a;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/sumsub/sns/core/data/model/FlowActionType$FaceEnrollment;", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class FaceEnrollment extends FlowActionType {
        public static final FaceEnrollment INSTANCE = new FaceEnrollment();

        private FaceEnrollment() {
            super("faceEnrollment", (r) null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/data/model/FlowActionType$Other;", "Lcom/sumsub/sns/core/data/model/FlowActionType;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Other extends FlowActionType {
        private final String value;

        public Other(String str) {
            super(str, (r) null);
            this.value = str;
        }

        public static /* synthetic */ Other copy$default(Other other, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = other.getValue();
            }
            return other.copy(str);
        }

        public final String component1() {
            return getValue();
        }

        public final Other copy(String str) {
            return new Other(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Other) && x.b(getValue(), ((Other) obj).getValue());
        }

        public String getValue() {
            return this.value;
        }

        public int hashCode() {
            return getValue().hashCode();
        }

        public String toString() {
            return "Other(value=" + getValue() + ')';
        }
    }

    public /* synthetic */ FlowActionType(String str, r rVar) {
        this(str);
    }

    public String getValue() {
        return this.value;
    }

    private FlowActionType(String str) {
        this.value = str;
    }
}
