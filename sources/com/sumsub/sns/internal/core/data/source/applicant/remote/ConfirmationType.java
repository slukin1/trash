package com.sumsub.sns.internal.core.data.source.applicant.remote;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;

@f
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/ConfirmationType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "OTP", "OAUTH", "EID", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum ConfirmationType {
    OTP,
    OAUTH,
    EID;
    
    public static final b Companion = null;

    public static final class a implements d0<ConfirmationType> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33043a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33044b = null;

        static {
            f33043a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.ConfirmationType", 3);
            enumDescriptor.k("otp", false);
            enumDescriptor.k("oAuth", false);
            enumDescriptor.k("eID", false);
            f33044b = enumDescriptor;
        }

        /* renamed from: a */
        public ConfirmationType deserialize(c cVar) {
            return ConfirmationType.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33044b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, ConfirmationType confirmationType) {
            dVar.g(getDescriptor(), confirmationType.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<ConfirmationType> serializer() {
            return a.f33043a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }
}
