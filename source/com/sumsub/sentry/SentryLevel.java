package com.sumsub.sentry;

import com.alibaba.verificationsdk.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.d0;

@f
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/sumsub/sentry/SentryLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "b", "DEBUG", "INFO", "WARNING", "ERROR", "FATAL", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum SentryLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;
    
    public static final b Companion = null;

    public static final class a implements d0<SentryLevel> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30237a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30238b = null;

        static {
            f30237a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sentry.SentryLevel", 5);
            enumDescriptor.k(BuildConfig.BUILD_TYPE, false);
            enumDescriptor.k("info", false);
            enumDescriptor.k("warning", false);
            enumDescriptor.k("error", false);
            enumDescriptor.k("fatal", false);
            f30238b = enumDescriptor;
        }

        /* renamed from: a */
        public SentryLevel deserialize(c cVar) {
            return SentryLevel.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[0];
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30238b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, SentryLevel sentryLevel) {
            dVar.g(getDescriptor(), sentryLevel.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<SentryLevel> serializer() {
            return a.f30237a;
        }

        public b() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }
}
