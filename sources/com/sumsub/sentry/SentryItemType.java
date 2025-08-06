package com.sumsub.sentry;

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
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sentry/SentryItemType;", "", "", "itemType", "Ljava/lang/String;", "getItemType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "Event", "Unknown", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum SentryItemType {
    Event("event"),
    Unknown("__unknown__");
    
    public static final b Companion = null;
    private final String itemType;

    public static final class a implements d0<SentryItemType> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30235a = null;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30236b = null;

        static {
            f30235a = new a();
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sentry.SentryItemType", 2);
            enumDescriptor.k("event", false);
            enumDescriptor.k("__unknown__", false);
            f30236b = enumDescriptor;
        }

        /* renamed from: a */
        public SentryItemType deserialize(c cVar) {
            return SentryItemType.values()[cVar.s(getDescriptor())];
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{v1.f57779a};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30236b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, SentryItemType sentryItemType) {
            dVar.g(getDescriptor(), sentryItemType.ordinal());
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final SentryItemType a(Object obj) {
            if (obj instanceof z) {
                return SentryItemType.Event;
            }
            return SentryItemType.Unknown;
        }

        public final kotlinx.serialization.b<SentryItemType> serializer() {
            return a.f30235a;
        }

        public b() {
        }

        public final SentryItemType a(String str) {
            for (SentryItemType sentryItemType : SentryItemType.values()) {
                if (x.b(sentryItemType.getItemType(), str)) {
                    return sentryItemType;
                }
            }
            return SentryItemType.Unknown;
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new b((r) null);
    }

    private SentryItemType(String str) {
        this.itemType = str;
    }

    public final String getItemType() {
        return this.itemType;
    }
}
