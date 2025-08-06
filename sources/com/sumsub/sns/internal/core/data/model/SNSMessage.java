package com.sumsub.sns.internal.core.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.UserDataStore;
import com.iproov.sdk.bridge.OptionsBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;
import kotlinx.serialization.internal.x0;

public abstract class SNSMessage {

    @kotlinx.serialization.f
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 \u00162\u00020\u0001:\n\b\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010B'\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000b¨\u0006 "}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "getType$annotations", "()V", "type", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "c", "d", "e", "Type", "UserVisibilityState", "f", "g", "h", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static class ClientMessage extends SNSMessage {
        public static final c Companion = new c((r) null);

        /* renamed from: a  reason: collision with root package name */
        public final Type f32375a;

        @kotlinx.serialization.f
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "USER_VISIBILITY_STATE", "SCREENSHOT_MADE", "COULD_NOT_MAKE_SCREENSHOT", "VERIFY_MOBILE_PHONE_TAN_SUCCESS", "CANCEL_VERIFY_MOBILE_PHONE_TAN", "VERIFY_MOBILE_PHONE_TAN_REQUESTED", "VERIFY_MOBILE_PHONE_TAN_RETRY_CODE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public enum Type {
            USER_VISIBILITY_STATE("userVisibilityState"),
            SCREENSHOT_MADE("screenshotMade"),
            COULD_NOT_MAKE_SCREENSHOT("couldNotMakeScreenshot"),
            VERIFY_MOBILE_PHONE_TAN_SUCCESS("verifyMobilePhoneTanSuccess"),
            CANCEL_VERIFY_MOBILE_PHONE_TAN("cancelVerifyMobilePhoneTan"),
            VERIFY_MOBILE_PHONE_TAN_REQUESTED("verifyMobilePhoneTanRequested"),
            VERIFY_MOBILE_PHONE_TAN_RETRY_CODE("verifyMobilePhoneTanRetryCode");
            
            public static final b Companion = null;
            private final String value;

            public static final class a implements d0<Type> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32376a = null;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32377b = null;

                static {
                    f32376a = new a();
                    EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.Type", 7);
                    enumDescriptor.k("userVisibilityState", false);
                    enumDescriptor.k("screenshotMade", false);
                    enumDescriptor.k("couldNotMakeScreenshot", false);
                    enumDescriptor.k("verifyMobilePhoneTanSuccess", false);
                    enumDescriptor.k("cancelVerifyMobilePhoneTan", false);
                    enumDescriptor.k("verifyMobilePhoneTanRequested", false);
                    enumDescriptor.k("verifyMobilePhoneTanRetryCode", false);
                    f32377b = enumDescriptor;
                }

                /* renamed from: a */
                public Type deserialize(kotlinx.serialization.encoding.c cVar) {
                    return Type.values()[cVar.s(getDescriptor())];
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{v1.f57779a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32377b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, Type type) {
                    dVar.g(getDescriptor(), type.ordinal());
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<Type> serializer() {
                    return a.f32376a;
                }

                public b() {
                }
            }

            /* access modifiers changed from: public */
            static {
                Companion = new b((r) null);
            }

            private Type(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0004\b\n\f\u001bB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012B3\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0011\u0010\u0019J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u0010\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$c;", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$c;", "c", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$c;", "getPayload$annotations", "()V", "payload", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$c;)V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "Visibility", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class UserVisibilityState extends ClientMessage {
            public static final b Companion = new b((r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32378b;

            @kotlinx.serialization.f
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$Visibility;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "VISIBLE", "HIDDEN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public enum Visibility {
                VISIBLE("visible"),
                HIDDEN("hidden");
                
                public static final b Companion = null;
                private final String value;

                public static final class a implements d0<Visibility> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32379a = null;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32380b = null;

                    static {
                        f32379a = new a();
                        EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.UserVisibilityState.Visibility", 2);
                        enumDescriptor.k("visible", false);
                        enumDescriptor.k("hidden", false);
                        f32380b = enumDescriptor;
                    }

                    /* renamed from: a */
                    public Visibility deserialize(kotlinx.serialization.encoding.c cVar) {
                        return Visibility.values()[cVar.s(getDescriptor())];
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{v1.f57779a};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32380b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, Visibility visibility) {
                        dVar.g(getDescriptor(), visibility.ordinal());
                    }
                }

                public static final class b {
                    public /* synthetic */ b(r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<Visibility> serializer() {
                        return a.f32379a;
                    }

                    public b() {
                    }
                }

                /* access modifiers changed from: public */
                static {
                    Companion = new b((r) null);
                }

                private Visibility(String str) {
                    this.value = str;
                }

                public final String getValue() {
                    return this.value;
                }
            }

            public static final class a implements d0<UserVisibilityState> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32381a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32382b;

                static {
                    a aVar = new a();
                    f32381a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.UserVisibilityState", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", false);
                    f32382b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public UserVisibilityState deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32376a, null);
                        obj = b11.p(descriptor, 1, c.a.f32384a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32376a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.p(descriptor, 1, c.a.f32384a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new UserVisibilityState(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a, c.a.f32384a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32382b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, UserVisibilityState userVisibilityState) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    UserVisibilityState.a(userVisibilityState, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final UserVisibilityState a() {
                    return new UserVisibilityState(new c(Visibility.HIDDEN.getValue()));
                }

                public final UserVisibilityState b() {
                    return new UserVisibilityState(new c(Visibility.VISIBLE.getValue()));
                }

                public final kotlinx.serialization.b<UserVisibilityState> serializer() {
                    return a.f32381a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\b\u0012B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017B'\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0016\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\b\u001a\u00020\tHÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$UserVisibilityState$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "visibilityState", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getVisibilityState$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32383a;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32384a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32385b;

                    static {
                        a aVar = new a();
                        f32384a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.UserVisibilityState.Payload", aVar, 1);
                        pluginGeneratedSerialDescriptor.k("visibilityState", false);
                        f32385b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        String str;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        int i11 = 1;
                        if (b11.k()) {
                            str = b11.i(descriptor, 0);
                        } else {
                            str = null;
                            int i12 = 0;
                            while (i11 != 0) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    i11 = 0;
                                } else if (w11 == 0) {
                                    str = b11.i(descriptor, 0);
                                    i12 |= 1;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, str, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{v1.f57779a};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32385b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32384a;
                    }

                    public b() {
                    }
                }

                public /* synthetic */ c(int i11, String str, q1 q1Var) {
                    if (1 != (i11 & 1)) {
                        h1.a(i11, 1, a.f32384a.getDescriptor());
                    }
                    this.f32383a = str;
                }

                public static /* synthetic */ void c() {
                }

                public final String a() {
                    return this.f32383a;
                }

                public final String b() {
                    return this.f32383a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof c) && x.b(this.f32383a, ((c) obj).f32383a);
                }

                public int hashCode() {
                    return this.f32383a.hashCode();
                }

                public String toString() {
                    return "Payload(visibilityState=" + this.f32383a + ')';
                }

                public c(String str) {
                    this.f32383a = str;
                }

                public final c a(String str) {
                    return new c(str);
                }

                public static /* synthetic */ c a(c cVar, String str, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32383a;
                    }
                    return cVar.a(str);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    bVar.p(fVar, 0, cVar.f32383a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ UserVisibilityState(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (3 != (i11 & 3)) {
                    h1.a(i11, 3, a.f32381a.getDescriptor());
                }
                this.f32378b = cVar;
            }

            public static final void a(UserVisibilityState userVisibilityState, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ClientMessage.a(userVisibilityState, bVar, fVar);
                bVar.F(fVar, 1, c.a.f32384a, userVisibilityState.f32378b);
            }

            public static /* synthetic */ void d() {
            }

            public final c c() {
                return this.f32378b;
            }

            public UserVisibilityState(c cVar) {
                super(Type.USER_VISIBILITY_STATE);
                this.f32378b = cVar;
            }
        }

        public static final class a implements d0<ClientMessage> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32386a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32387b;

            static {
                a aVar = new a();
                f32386a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage", aVar, 1);
                pluginGeneratedSerialDescriptor.k("type", false);
                f32387b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public ClientMessage deserialize(kotlinx.serialization.encoding.c cVar) {
                Object obj;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                int i11 = 1;
                if (b11.k()) {
                    obj = b11.p(descriptor, 0, Type.a.f32376a, null);
                } else {
                    obj = null;
                    int i12 = 0;
                    while (i11 != 0) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            i11 = 0;
                        } else if (w11 == 0) {
                            obj = b11.p(descriptor, 0, Type.a.f32376a, obj);
                            i12 |= 1;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    i11 = i12;
                }
                b11.c(descriptor);
                return new ClientMessage(i11, (Type) obj, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                return new kotlinx.serialization.b[]{Type.a.f32376a};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32387b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(kotlinx.serialization.encoding.d dVar, ClientMessage clientMessage) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                ClientMessage.a(clientMessage, b11, descriptor);
                b11.c(descriptor);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$b;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class b extends ClientMessage {
            public static final C0332b Companion = new C0332b((r) null);

            public static final class a implements d0<b> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32388a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32389b;

                static {
                    a aVar = new a();
                    f32388a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.CancelVerifyMobilePhoneTan", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32389b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public b deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32376a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32376a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new b(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32389b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, b bVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    b.a(bVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            /* renamed from: com.sumsub.sns.internal.core.data.model.SNSMessage$ClientMessage$b$b  reason: collision with other inner class name */
            public static final class C0332b {
                public /* synthetic */ C0332b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<b> serializer() {
                    return a.f32388a;
                }

                public C0332b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ b(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32388a.getDescriptor());
                }
            }

            public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
                ClientMessage.a(bVar, bVar2, fVar);
            }

            public b() {
                super(Type.CANCEL_VERIFY_MOBILE_PHONE_TAN);
            }
        }

        public static final class c {
            public /* synthetic */ c(r rVar) {
                this();
            }

            public final kotlinx.serialization.b<ClientMessage> serializer() {
                return a.f32386a;
            }

            public c() {
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$d;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class d extends ClientMessage {
            public static final b Companion = new b((r) null);

            public static final class a implements d0<d> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32390a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32391b;

                static {
                    a aVar = new a();
                    f32390a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.CouldNotMakeScreenshot", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32391b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public d deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32376a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32376a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new d(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32391b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, d dVar2) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    d.a(dVar2, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<d> serializer() {
                    return a.f32390a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ d(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32390a.getDescriptor());
                }
            }

            public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ClientMessage.a(dVar, bVar, fVar);
            }

            public d() {
                super(Type.COULD_NOT_MAKE_SCREENSHOT);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0003\b\u0014\nB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001a\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R \u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e$c;", "getPayload$annotations", "()V", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class e extends ClientMessage {
            public static final b Companion = new b((r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32392b;

            public static final class a implements d0<e> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32393a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32394b;

                static {
                    a aVar = new a();
                    f32393a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.ScreenshotMade", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", false);
                    f32394b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public e deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32376a, null);
                        obj = b11.p(descriptor, 1, c.a.f32396a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32376a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.p(descriptor, 1, c.a.f32396a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new e(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a, c.a.f32396a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32394b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, e eVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    e.a(eVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<e> serializer() {
                    return a.f32393a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\b\u0012B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B'\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0016\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$e$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "name", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getName$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32395a;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32396a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32397b;

                    static {
                        a aVar = new a();
                        f32396a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.ScreenshotMade.Payload", aVar, 1);
                        pluginGeneratedSerialDescriptor.k("imageId", true);
                        f32397b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        Object obj;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        int i11 = 1;
                        if (b11.k()) {
                            obj = b11.j(descriptor, 0, v1.f57779a, null);
                        } else {
                            obj = null;
                            int i12 = 0;
                            while (i11 != 0) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    i11 = 0;
                                } else if (w11 == 0) {
                                    obj = b11.j(descriptor, 0, v1.f57779a, obj);
                                    i12 |= 1;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (String) obj, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32397b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32396a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((String) null, 1, (r) null);
                }

                public static /* synthetic */ void c() {
                }

                public final String a() {
                    return this.f32395a;
                }

                public final String b() {
                    return this.f32395a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof c) && x.b(this.f32395a, ((c) obj).f32395a);
                }

                public int hashCode() {
                    String str = this.f32395a;
                    if (str == null) {
                        return 0;
                    }
                    return str.hashCode();
                }

                public String toString() {
                    return "Payload(name=" + this.f32395a + ')';
                }

                public /* synthetic */ c(int i11, String str, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32396a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32395a = null;
                    } else {
                        this.f32395a = str;
                    }
                }

                public final c a(String str) {
                    return new c(str);
                }

                public c(String str) {
                    this.f32395a = str;
                }

                public static /* synthetic */ c a(c cVar, String str, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32395a;
                    }
                    return cVar.a(str);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    if (bVar.q(fVar, 0) || cVar.f32395a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32395a);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, int i11, r rVar) {
                    this((i11 & 1) != 0 ? null : str);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ e(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (3 != (i11 & 3)) {
                    h1.a(i11, 3, a.f32393a.getDescriptor());
                }
                this.f32392b = cVar;
            }

            public static /* synthetic */ void e() {
            }

            public final e a(c cVar) {
                return new e(cVar);
            }

            public final c c() {
                return this.f32392b;
            }

            public final c d() {
                return this.f32392b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && x.b(this.f32392b, ((e) obj).f32392b);
            }

            public int hashCode() {
                return this.f32392b.hashCode();
            }

            public String toString() {
                return "ScreenshotMade(payload=" + this.f32392b + ')';
            }

            public e(c cVar) {
                super(Type.SCREENSHOT_MADE);
                this.f32392b = cVar;
            }

            public static /* synthetic */ e a(e eVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = eVar.f32392b;
                }
                return eVar.a(cVar);
            }

            public static final void a(e eVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ClientMessage.a(eVar, bVar, fVar);
                bVar.F(fVar, 1, c.a.f32396a, eVar.f32392b);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$f;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class f extends ClientMessage {
            public static final b Companion = new b((r) null);

            public static final class a implements d0<f> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32398a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32399b;

                static {
                    a aVar = new a();
                    f32398a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.VerifyMobilePhoneTanRequested", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32399b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public f deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32376a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32376a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new f(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32399b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, f fVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    f.a(fVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<f> serializer() {
                    return a.f32398a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ f(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32398a.getDescriptor());
                }
            }

            public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
                ClientMessage.a(fVar, bVar, fVar2);
            }

            public f() {
                super(Type.VERIFY_MOBILE_PHONE_TAN_REQUESTED);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$g;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class g extends ClientMessage {
            public static final b Companion = new b((r) null);

            public static final class a implements d0<g> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32400a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32401b;

                static {
                    a aVar = new a();
                    f32400a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.VerifyMobilePhoneTanRetryCode", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32401b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public g deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32376a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32376a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new g(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32401b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, g gVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    g.a(gVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<g> serializer() {
                    return a.f32400a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ g(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32400a.getDescriptor());
                }
            }

            public static final void a(g gVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ClientMessage.a(gVar, bVar, fVar);
            }

            public g() {
                super(Type.VERIFY_MOBILE_PHONE_TAN_RETRY_CODE);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$h;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ClientMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class h extends ClientMessage {
            public static final b Companion = new b((r) null);

            public static final class a implements d0<h> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32402a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32403b;

                static {
                    a aVar = new a();
                    f32402a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ClientMessage.VerifyMobilePhoneTanSuccess", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32403b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public h deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32376a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32376a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new h(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32376a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32403b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, h hVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    h.a(hVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<h> serializer() {
                    return a.f32402a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ h(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32402a.getDescriptor());
                }
            }

            public static final void a(h hVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ClientMessage.a(hVar, bVar, fVar);
            }

            public h() {
                super(Type.VERIFY_MOBILE_PHONE_TAN_SUCCESS);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ClientMessage(int i11, Type type, q1 q1Var) {
            super((r) null);
            if (1 != (i11 & 1)) {
                h1.a(i11, 1, a.f32386a.getDescriptor());
            }
            this.f32375a = type;
        }

        public static final void a(ClientMessage clientMessage, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            bVar.F(fVar, 0, Type.a.f32376a, clientMessage.f32375a);
        }

        public static /* synthetic */ void b() {
        }

        public ClientMessage(Type type) {
            super((r) null);
            this.f32375a = type;
        }

        public final Type a() {
            return this.f32375a;
        }
    }

    @kotlinx.serialization.f
    @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0017\u0018\u0000 \u00162\u00020\u0001:\u0016\b\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010B'\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R \u0010\u000e\u001a\u00020\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000b¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "getType$annotations", "()V", "type", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "ScreenShotPayload", "p", "Type", "q", "r", "s", "t", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public static class ServerMessage extends SNSMessage {
        public static final j Companion = new j((kotlin.jvm.internal.r) null);

        /* renamed from: a  reason: collision with root package name */
        public final Type f32404a;

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 32\u00020\u0001:\u0003\b\n4BC\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b-\u0010.BW\b\u0017\u0012\u0006\u0010/\u001a\u00020\u0014\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b-\u00102J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003JE\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0013\u001a\u00020\tHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0014HÖ\u0001R*\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\u001f\u0012\u0004\b#\u0010$\u001a\u0004\b \u0010!\"\u0004\b\f\u0010\"R*\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\n\u0010\u001f\u0012\u0004\b&\u0010$\u001a\u0004\b%\u0010!\"\u0004\b\u000b\u0010\"R*\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u000b\u0010\u001f\u0012\u0004\b(\u0010$\u001a\u0004\b'\u0010!\"\u0004\b\b\u0010\"R*\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\f\u0010\u001f\u0012\u0004\b*\u0010$\u001a\u0004\b)\u0010!\"\u0004\b\n\u0010\"R*\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\r\u0010\u001f\u0012\u0004\b,\u0010$\u001a\u0004\b+\u0010!\"\u0004\b\r\u0010\"¨\u00065"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "Landroid/os/Parcelable;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "d", "e", "type", "idDocSubType", "country", "idDocSetType", "variant", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "Ljava/lang/String;", "l", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getType$annotations", "()V", "j", "getIdDocSubType$annotations", "f", "getCountry$annotations", "h", "getIdDocSetType$annotations", "n", "getVariant$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "Variant", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class ScreenShotPayload implements Parcelable {
            public static final Parcelable.Creator<ScreenShotPayload> CREATOR = new c();
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: a  reason: collision with root package name */
            public String f32405a;

            /* renamed from: b  reason: collision with root package name */
            public String f32406b;

            /* renamed from: c  reason: collision with root package name */
            public String f32407c;

            /* renamed from: d  reason: collision with root package name */
            public String f32408d;

            /* renamed from: e  reason: collision with root package name */
            public String f32409e;

            @kotlinx.serialization.f
            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload$Variant;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "SCREENSHOT", "UPLOAD", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public enum Variant {
                SCREENSHOT("SCREENSHOT"),
                UPLOAD("UPLOAD");
                
                public static final b Companion = null;
                private final String value;

                public static final class a implements d0<Variant> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32410a = null;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32411b = null;

                    static {
                        f32410a = new a();
                        EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ScreenShotPayload.Variant", 2);
                        enumDescriptor.k("SCREENSHOT", false);
                        enumDescriptor.k("UPLOAD", false);
                        f32411b = enumDescriptor;
                    }

                    /* renamed from: a */
                    public Variant deserialize(kotlinx.serialization.encoding.c cVar) {
                        return Variant.values()[cVar.s(getDescriptor())];
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{v1.f57779a};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32411b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, Variant variant) {
                        dVar.g(getDescriptor(), variant.ordinal());
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<Variant> serializer() {
                        return a.f32410a;
                    }

                    public b() {
                    }
                }

                /* access modifiers changed from: public */
                static {
                    Companion = new b((kotlin.jvm.internal.r) null);
                }

                private Variant(String str) {
                    this.value = str;
                }

                public final String getValue() {
                    return this.value;
                }
            }

            public static final class a implements d0<ScreenShotPayload> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32412a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32413b;

                static {
                    a aVar = new a();
                    f32412a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ScreenShotPayload", aVar, 5);
                    pluginGeneratedSerialDescriptor.k("type", true);
                    pluginGeneratedSerialDescriptor.k("idDocSubType", true);
                    pluginGeneratedSerialDescriptor.k(UserDataStore.COUNTRY, true);
                    pluginGeneratedSerialDescriptor.k("idDocSetType", true);
                    pluginGeneratedSerialDescriptor.k("variant", true);
                    f32413b = pluginGeneratedSerialDescriptor;
                }

                /* JADX WARNING: Multi-variable type inference failed */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ScreenShotPayload deserialize(kotlinx.serialization.encoding.c r17) {
                    /*
                        r16 = this;
                        kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                        r1 = r17
                        kotlinx.serialization.encoding.a r1 = r1.b(r0)
                        boolean r2 = r1.k()
                        r3 = 3
                        r4 = 4
                        r5 = 2
                        r6 = 0
                        r7 = 0
                        r8 = 1
                        if (r2 == 0) goto L_0x0032
                        kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r6 = r1.j(r0, r6, r2, r7)
                        java.lang.Object r8 = r1.j(r0, r8, r2, r7)
                        java.lang.Object r5 = r1.j(r0, r5, r2, r7)
                        java.lang.Object r3 = r1.j(r0, r3, r2, r7)
                        java.lang.Object r2 = r1.j(r0, r4, r2, r7)
                        r4 = 31
                        r10 = r5
                        r5 = r4
                        goto L_0x0085
                    L_0x0032:
                        r2 = r6
                        r9 = r7
                        r10 = r9
                        r11 = r10
                        r12 = r11
                        r13 = r8
                    L_0x0038:
                        if (r13 == 0) goto L_0x0080
                        int r14 = r1.w(r0)
                        r15 = -1
                        if (r14 == r15) goto L_0x007e
                        if (r14 == 0) goto L_0x0075
                        if (r14 == r8) goto L_0x006c
                        if (r14 == r5) goto L_0x0063
                        if (r14 == r3) goto L_0x005a
                        if (r14 != r4) goto L_0x0054
                        kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r12 = r1.j(r0, r4, r14, r12)
                        r2 = r2 | 16
                        goto L_0x0038
                    L_0x0054:
                        kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                        r0.<init>((int) r14)
                        throw r0
                    L_0x005a:
                        kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r11 = r1.j(r0, r3, r14, r11)
                        r2 = r2 | 8
                        goto L_0x0038
                    L_0x0063:
                        kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r10 = r1.j(r0, r5, r14, r10)
                        r2 = r2 | 4
                        goto L_0x0038
                    L_0x006c:
                        kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r9 = r1.j(r0, r8, r14, r9)
                        r2 = r2 | 2
                        goto L_0x0038
                    L_0x0075:
                        kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                        java.lang.Object r7 = r1.j(r0, r6, r14, r7)
                        r2 = r2 | 1
                        goto L_0x0038
                    L_0x007e:
                        r13 = r6
                        goto L_0x0038
                    L_0x0080:
                        r5 = r2
                        r6 = r7
                        r8 = r9
                        r3 = r11
                        r2 = r12
                    L_0x0085:
                        r1.c(r0)
                        com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$ScreenShotPayload r0 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$ScreenShotPayload
                        java.lang.String r6 = (java.lang.String) r6
                        r7 = r8
                        java.lang.String r7 = (java.lang.String) r7
                        r8 = r10
                        java.lang.String r8 = (java.lang.String) r8
                        r9 = r3
                        java.lang.String r9 = (java.lang.String) r9
                        r10 = r2
                        java.lang.String r10 = (java.lang.String) r10
                        r11 = 0
                        r4 = r0
                        r4.<init>((int) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (kotlinx.serialization.internal.q1) r11)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ScreenShotPayload.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$ScreenShotPayload");
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    v1 v1Var = v1.f57779a;
                    return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32413b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, ScreenShotPayload screenShotPayload) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    ScreenShotPayload.a(screenShotPayload, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<ScreenShotPayload> serializer() {
                    return a.f32412a;
                }

                public b() {
                }
            }

            public static final class c implements Parcelable.Creator<ScreenShotPayload> {
                /* renamed from: a */
                public final ScreenShotPayload createFromParcel(Parcel parcel) {
                    return new ScreenShotPayload(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                }

                /* renamed from: a */
                public final ScreenShotPayload[] newArray(int i11) {
                    return new ScreenShotPayload[i11];
                }
            }

            public ScreenShotPayload() {
                this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (kotlin.jvm.internal.r) null);
            }

            public static /* synthetic */ void g() {
            }

            public static /* synthetic */ void i() {
            }

            public static /* synthetic */ void k() {
            }

            public static /* synthetic */ void m() {
            }

            public static /* synthetic */ void o() {
            }

            public final String a() {
                return this.f32405a;
            }

            public final String b() {
                return this.f32406b;
            }

            public final String c() {
                return this.f32407c;
            }

            public final String d() {
                return this.f32408d;
            }

            public int describeContents() {
                return 0;
            }

            public final String e() {
                return this.f32409e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ScreenShotPayload)) {
                    return false;
                }
                ScreenShotPayload screenShotPayload = (ScreenShotPayload) obj;
                return x.b(this.f32405a, screenShotPayload.f32405a) && x.b(this.f32406b, screenShotPayload.f32406b) && x.b(this.f32407c, screenShotPayload.f32407c) && x.b(this.f32408d, screenShotPayload.f32408d) && x.b(this.f32409e, screenShotPayload.f32409e);
            }

            public final String f() {
                return this.f32407c;
            }

            public final String h() {
                return this.f32408d;
            }

            public int hashCode() {
                String str = this.f32405a;
                int i11 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f32406b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f32407c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f32408d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.f32409e;
                if (str5 != null) {
                    i11 = str5.hashCode();
                }
                return hashCode4 + i11;
            }

            public final String j() {
                return this.f32406b;
            }

            public final String l() {
                return this.f32405a;
            }

            public final String n() {
                return this.f32409e;
            }

            public String toString() {
                return "ScreenShotPayload(type=" + this.f32405a + ", idDocSubType=" + this.f32406b + ", country=" + this.f32407c + ", idDocSetType=" + this.f32408d + ", variant=" + this.f32409e + ')';
            }

            public void writeToParcel(Parcel parcel, int i11) {
                parcel.writeString(this.f32405a);
                parcel.writeString(this.f32406b);
                parcel.writeString(this.f32407c);
                parcel.writeString(this.f32408d);
                parcel.writeString(this.f32409e);
            }

            public /* synthetic */ ScreenShotPayload(int i11, String str, String str2, String str3, String str4, String str5, q1 q1Var) {
                if ((i11 & 0) != 0) {
                    h1.a(i11, 0, a.f32412a.getDescriptor());
                }
                if ((i11 & 1) == 0) {
                    this.f32405a = "";
                } else {
                    this.f32405a = str;
                }
                if ((i11 & 2) == 0) {
                    this.f32406b = "";
                } else {
                    this.f32406b = str2;
                }
                if ((i11 & 4) == 0) {
                    this.f32407c = "";
                } else {
                    this.f32407c = str3;
                }
                if ((i11 & 8) == 0) {
                    this.f32408d = "";
                } else {
                    this.f32408d = str4;
                }
                if ((i11 & 16) == 0) {
                    this.f32409e = "";
                } else {
                    this.f32409e = str5;
                }
            }

            public final ScreenShotPayload a(String str, String str2, String str3, String str4, String str5) {
                return new ScreenShotPayload(str, str2, str3, str4, str5);
            }

            public final void b(String str) {
                this.f32408d = str;
            }

            public final void c(String str) {
                this.f32406b = str;
            }

            public final void d(String str) {
                this.f32405a = str;
            }

            public final void e(String str) {
                this.f32409e = str;
            }

            public ScreenShotPayload(String str, String str2, String str3, String str4, String str5) {
                this.f32405a = str;
                this.f32406b = str2;
                this.f32407c = str3;
                this.f32408d = str4;
                this.f32409e = str5;
            }

            public static /* synthetic */ ScreenShotPayload a(ScreenShotPayload screenShotPayload, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = screenShotPayload.f32405a;
                }
                if ((i11 & 2) != 0) {
                    str2 = screenShotPayload.f32406b;
                }
                String str6 = str2;
                if ((i11 & 4) != 0) {
                    str3 = screenShotPayload.f32407c;
                }
                String str7 = str3;
                if ((i11 & 8) != 0) {
                    str4 = screenShotPayload.f32408d;
                }
                String str8 = str4;
                if ((i11 & 16) != 0) {
                    str5 = screenShotPayload.f32409e;
                }
                return screenShotPayload.a(str, str6, str7, str8, str5);
            }

            public static final void a(ScreenShotPayload screenShotPayload, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                boolean z11 = false;
                if (bVar.q(fVar, 0) || !x.b(screenShotPayload.f32405a, "")) {
                    bVar.y(fVar, 0, v1.f57779a, screenShotPayload.f32405a);
                }
                if (bVar.q(fVar, 1) || !x.b(screenShotPayload.f32406b, "")) {
                    bVar.y(fVar, 1, v1.f57779a, screenShotPayload.f32406b);
                }
                if (bVar.q(fVar, 2) || !x.b(screenShotPayload.f32407c, "")) {
                    bVar.y(fVar, 2, v1.f57779a, screenShotPayload.f32407c);
                }
                if (bVar.q(fVar, 3) || !x.b(screenShotPayload.f32408d, "")) {
                    bVar.y(fVar, 3, v1.f57779a, screenShotPayload.f32408d);
                }
                if (bVar.q(fVar, 4) || !x.b(screenShotPayload.f32409e, "")) {
                    z11 = true;
                }
                if (z11) {
                    bVar.y(fVar, 4, v1.f57779a, screenShotPayload.f32409e);
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ ScreenShotPayload(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.r r11) {
                /*
                    r4 = this;
                    r11 = r10 & 1
                    java.lang.String r0 = ""
                    if (r11 == 0) goto L_0x0008
                    r11 = r0
                    goto L_0x0009
                L_0x0008:
                    r11 = r5
                L_0x0009:
                    r5 = r10 & 2
                    if (r5 == 0) goto L_0x000f
                    r1 = r0
                    goto L_0x0010
                L_0x000f:
                    r1 = r6
                L_0x0010:
                    r5 = r10 & 4
                    if (r5 == 0) goto L_0x0016
                    r2 = r0
                    goto L_0x0017
                L_0x0016:
                    r2 = r7
                L_0x0017:
                    r5 = r10 & 8
                    if (r5 == 0) goto L_0x001d
                    r3 = r0
                    goto L_0x001e
                L_0x001d:
                    r3 = r8
                L_0x001e:
                    r5 = r10 & 16
                    if (r5 == 0) goto L_0x0024
                    r10 = r0
                    goto L_0x0025
                L_0x0024:
                    r10 = r9
                L_0x0025:
                    r5 = r4
                    r6 = r11
                    r7 = r1
                    r8 = r2
                    r9 = r3
                    r5.<init>(r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ScreenShotPayload.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
            }

            public final void a(String str) {
                this.f32407c = str;
            }
        }

        @kotlinx.serialization.f
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "b", "MODERATOR_NAME", "COMPLETED", "READY_FOR_SCREENSHOT", "MAKE_SCREENSHOT", "CANCEL_SCREENSHOT", "UPDATE_REQUIRED_ID_DOCS", "STEP_CHANGE", "VERIFY_MOBILE_PHONE_TAN", "CANCEL_VERIFY_MOBILE_PHONE_TAN", "APPLICANT_STATUS_CHANGE", "APPLICANT_ACTION_STATUS_CHANGE", "APPLICANT_LEVEL_CHANGE", "ADDED_ID_DOC", "WELCOME", "APPLICANT_IMAGE_REVIEWED", "APPLICANT_QUEUE_STATUS", "UNKNOWN", "EMPTY", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public enum Type {
            MODERATOR_NAME("moderatorName"),
            COMPLETED("completed"),
            READY_FOR_SCREENSHOT("readyForScreenshot"),
            MAKE_SCREENSHOT("makeScreenshot"),
            CANCEL_SCREENSHOT("cancelScreenshot"),
            UPDATE_REQUIRED_ID_DOCS("updateRequiredIdDocs"),
            STEP_CHANGE("stepChange"),
            VERIFY_MOBILE_PHONE_TAN("verifyMobilePhoneTan"),
            CANCEL_VERIFY_MOBILE_PHONE_TAN("cancelVerifyMobilePhoneTan"),
            APPLICANT_STATUS_CHANGE("applicantStatusChange"),
            APPLICANT_ACTION_STATUS_CHANGE("applicantActionStatusChange"),
            APPLICANT_LEVEL_CHANGE("applicantLevelChange"),
            ADDED_ID_DOC("addedIdDoc"),
            WELCOME("welcome"),
            APPLICANT_IMAGE_REVIEWED("applicantImageReviewed"),
            APPLICANT_QUEUE_STATUS("applicantQueueStatus"),
            UNKNOWN("unknown"),
            EMPTY(OptionsBridge.EMPTY_VALUE);
            
            public static final b Companion = null;
            private final String type;

            public static final class a implements d0<Type> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32414a = null;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32415b = null;

                static {
                    f32414a = new a();
                    EnumDescriptor enumDescriptor = new EnumDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.Type", 18);
                    enumDescriptor.k("moderatorName", false);
                    enumDescriptor.k("completed", false);
                    enumDescriptor.k("readyForScreenshot", false);
                    enumDescriptor.k("makeScreenshot", false);
                    enumDescriptor.k("cancelScreenshot", false);
                    enumDescriptor.k("updateRequiredIdDocs", false);
                    enumDescriptor.k("stepChange", false);
                    enumDescriptor.k("verifyMobilePhoneTan", false);
                    enumDescriptor.k("cancelVerifyMobilePhoneTan", false);
                    enumDescriptor.k("applicantStatusChange", false);
                    enumDescriptor.k("applicantActionStatusChange", false);
                    enumDescriptor.k("applicantLevelChange", false);
                    enumDescriptor.k("addedIdDoc", false);
                    enumDescriptor.k("welcome", false);
                    enumDescriptor.k("applicantImageReviewed", false);
                    enumDescriptor.k("applicantQueueStatus", false);
                    enumDescriptor.k("unknown", false);
                    enumDescriptor.k(OptionsBridge.EMPTY_VALUE, false);
                    f32415b = enumDescriptor;
                }

                /* renamed from: a */
                public Type deserialize(kotlinx.serialization.encoding.c cVar) {
                    return Type.values()[cVar.s(getDescriptor())];
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{v1.f57779a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32415b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, Type type) {
                    dVar.g(getDescriptor(), type.ordinal());
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<Type> serializer() {
                    return a.f32414a;
                }

                public b() {
                }
            }

            /* access modifiers changed from: public */
            static {
                Companion = new b((kotlin.jvm.internal.r) null);
            }

            private Type(String str) {
                this.type = str;
            }

            public final String getType() {
                return this.type;
            }
        }

        public static final class a implements d0<ServerMessage> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f32416a;

            /* renamed from: b  reason: collision with root package name */
            public static final /* synthetic */ kotlinx.serialization.descriptors.f f32417b;

            static {
                a aVar = new a();
                f32416a = aVar;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage", aVar, 1);
                pluginGeneratedSerialDescriptor.k("type", false);
                f32417b = pluginGeneratedSerialDescriptor;
            }

            /* renamed from: a */
            public ServerMessage deserialize(kotlinx.serialization.encoding.c cVar) {
                Object obj;
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                int i11 = 1;
                if (b11.k()) {
                    obj = b11.p(descriptor, 0, Type.a.f32414a, null);
                } else {
                    obj = null;
                    int i12 = 0;
                    while (i11 != 0) {
                        int w11 = b11.w(descriptor);
                        if (w11 == -1) {
                            i11 = 0;
                        } else if (w11 == 0) {
                            obj = b11.p(descriptor, 0, Type.a.f32414a, obj);
                            i12 |= 1;
                        } else {
                            throw new UnknownFieldException(w11);
                        }
                    }
                    i11 = i12;
                }
                b11.c(descriptor);
                return new ServerMessage(i11, (Type) obj, (q1) null);
            }

            public kotlinx.serialization.b<?>[] childSerializers() {
                return new kotlinx.serialization.b[]{Type.a.f32414a};
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32417b;
            }

            public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                return d0.a.a(this);
            }

            /* renamed from: a */
            public void serialize(kotlinx.serialization.encoding.d dVar, ServerMessage serverMessage) {
                kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                ServerMessage.a(serverMessage, b11, descriptor);
                b11.c(descriptor);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class b extends ServerMessage {
            public static final C0333b Companion = new C0333b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32418b;

            public static final class a implements d0<b> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32419a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32420b;

                static {
                    a aVar = new a();
                    f32419a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.AddedIdDoc", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32420b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public b deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32423a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32423a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new b(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32423a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32420b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, b bVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    b.a(bVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            /* renamed from: com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$b$b  reason: collision with other inner class name */
            public static final class C0333b {
                public /* synthetic */ C0333b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<b> serializer() {
                    return a.f32419a;
                }

                public C0333b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\nB\u001f\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001a\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$b$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "imageId", "sessionId", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getImageId$annotations", "()V", "e", "getSessionId$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final C0334b Companion = new C0334b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32421a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32422b;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32423a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32424b;

                    static {
                        a aVar = new a();
                        f32423a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.AddedIdDoc.Payload", aVar, 2);
                        pluginGeneratedSerialDescriptor.k("imageId", true);
                        pluginGeneratedSerialDescriptor.k("sessionId", true);
                        f32424b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        int i11;
                        Object obj;
                        Object obj2;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        if (b11.k()) {
                            v1 v1Var = v1.f57779a;
                            obj = b11.j(descriptor, 0, v1Var, null);
                            obj2 = b11.j(descriptor, 1, v1Var, null);
                            i11 = 3;
                        } else {
                            obj2 = null;
                            Object obj3 = null;
                            int i12 = 0;
                            boolean z11 = true;
                            while (z11) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    z11 = false;
                                } else if (w11 == 0) {
                                    obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                                    i12 |= 1;
                                } else if (w11 == 1) {
                                    obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                                    i12 |= 2;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            obj = obj3;
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (String) obj, (String) obj2, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32424b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                /* renamed from: com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$b$c$b  reason: collision with other inner class name */
                public static final class C0334b {
                    public /* synthetic */ C0334b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32423a;
                    }

                    public C0334b() {
                    }
                }

                public c() {
                    this((String) null, (String) null, 3, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void d() {
                }

                public static /* synthetic */ void f() {
                }

                public final String a() {
                    return this.f32421a;
                }

                public final String b() {
                    return this.f32422b;
                }

                public final String c() {
                    return this.f32421a;
                }

                public final String e() {
                    return this.f32422b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof c)) {
                        return false;
                    }
                    c cVar = (c) obj;
                    return x.b(this.f32421a, cVar.f32421a) && x.b(this.f32422b, cVar.f32422b);
                }

                public int hashCode() {
                    String str = this.f32421a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f32422b;
                    if (str2 != null) {
                        i11 = str2.hashCode();
                    }
                    return hashCode + i11;
                }

                public String toString() {
                    return "Payload(imageId=" + this.f32421a + ", sessionId=" + this.f32422b + ')';
                }

                public /* synthetic */ c(int i11, String str, String str2, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32423a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32421a = null;
                    } else {
                        this.f32421a = str;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32422b = null;
                    } else {
                        this.f32422b = str2;
                    }
                }

                public final c a(String str, String str2) {
                    return new c(str, str2);
                }

                public c(String str, String str2) {
                    this.f32421a = str;
                    this.f32422b = str2;
                }

                public static /* synthetic */ c a(c cVar, String str, String str2, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32421a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = cVar.f32422b;
                    }
                    return cVar.a(str, str2);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32421a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32421a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32422b != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 1, v1.f57779a, cVar.f32422b);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, String str2, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
                }
            }

            public b() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final b a(c cVar) {
                return new b(cVar);
            }

            public final c c() {
                return this.f32418b;
            }

            public final c d() {
                return this.f32418b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && x.b(this.f32418b, ((b) obj).f32418b);
            }

            public int hashCode() {
                c cVar = this.f32418b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "AddedIdDoc(payload=" + this.f32418b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ b(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32419a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32418b = null;
                } else {
                    this.f32418b = cVar;
                }
            }

            public static /* synthetic */ b a(b bVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = bVar.f32418b;
                }
                return bVar.a(cVar);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ b(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(bVar, bVar2, fVar);
                if (bVar2.q(fVar, 1) || bVar.f32418b != null) {
                    bVar2.y(fVar, 1, c.a.f32423a, bVar.f32418b);
                }
            }

            public b(c cVar) {
                super(Type.ADDED_ID_DOC);
                this.f32418b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class c extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final C0335c f32425b;

            public static final class a implements d0<c> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32426a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32427b;

                static {
                    a aVar = new a();
                    f32426a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantActionStatusChange", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32427b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public c deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, C0335c.a.f32431a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, C0335c.a.f32431a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new c(i11, (Type) obj2, (C0335c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(C0335c.a.f32431a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32427b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    c.a(cVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<c> serializer() {
                    return a.f32426a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0002\b\nB+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001fB?\b\u0017\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001e\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001c\u0010\u0017¨\u0006%"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$c$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "sessionId", "status", "newToken", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "getSessionId$annotations", "()V", "h", "getStatus$annotations", "d", "getNewToken$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$c$c  reason: collision with other inner class name */
            public static final class C0335c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32428a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32429b;

                /* renamed from: c  reason: collision with root package name */
                public final String f32430c;

                /* renamed from: com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$c$c$a */
                public static final class a implements d0<C0335c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32431a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32432b;

                    static {
                        a aVar = new a();
                        f32431a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantActionStatusChange.Payload", aVar, 3);
                        pluginGeneratedSerialDescriptor.k("sessionId", true);
                        pluginGeneratedSerialDescriptor.k("status", true);
                        pluginGeneratedSerialDescriptor.k("newToken", true);
                        f32432b = pluginGeneratedSerialDescriptor;
                    }

                    /* JADX WARNING: Multi-variable type inference failed */
                    /* renamed from: a */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.c.C0335c deserialize(kotlinx.serialization.encoding.c r12) {
                        /*
                            r11 = this;
                            kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
                            kotlinx.serialization.encoding.a r12 = r12.b(r0)
                            boolean r1 = r12.k()
                            r2 = 0
                            r3 = 2
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0023
                            kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r4 = r12.j(r0, r4, r1, r2)
                            java.lang.Object r5 = r12.j(r0, r5, r1, r2)
                            java.lang.Object r1 = r12.j(r0, r3, r1, r2)
                            r2 = 7
                            r3 = r2
                            goto L_0x005e
                        L_0x0023:
                            r1 = r2
                            r6 = r1
                            r7 = r6
                            r2 = r4
                            r8 = r5
                        L_0x0028:
                            if (r8 == 0) goto L_0x005a
                            int r9 = r12.w(r0)
                            r10 = -1
                            if (r9 == r10) goto L_0x0058
                            if (r9 == 0) goto L_0x004f
                            if (r9 == r5) goto L_0x0046
                            if (r9 != r3) goto L_0x0040
                            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r7 = r12.j(r0, r3, r9, r7)
                            r2 = r2 | 4
                            goto L_0x0028
                        L_0x0040:
                            kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
                            r12.<init>((int) r9)
                            throw r12
                        L_0x0046:
                            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r6 = r12.j(r0, r5, r9, r6)
                            r2 = r2 | 2
                            goto L_0x0028
                        L_0x004f:
                            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r1 = r12.j(r0, r4, r9, r1)
                            r2 = r2 | 1
                            goto L_0x0028
                        L_0x0058:
                            r8 = r4
                            goto L_0x0028
                        L_0x005a:
                            r4 = r1
                            r3 = r2
                            r5 = r6
                            r1 = r7
                        L_0x005e:
                            r12.c(r0)
                            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$c$c r12 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$c$c
                            java.lang.String r4 = (java.lang.String) r4
                            java.lang.String r5 = (java.lang.String) r5
                            r6 = r1
                            java.lang.String r6 = (java.lang.String) r6
                            r7 = 0
                            r2 = r12
                            r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (kotlinx.serialization.internal.q1) r7)
                            return r12
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.c.C0335c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$c$c");
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32432b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, C0335c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        C0335c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                /* renamed from: com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$c$c$b */
                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<C0335c> serializer() {
                        return a.f32431a;
                    }

                    public b() {
                    }
                }

                public C0335c() {
                    this((String) null, (String) null, (String) null, 7, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void e() {
                }

                public static /* synthetic */ void g() {
                }

                public static /* synthetic */ void i() {
                }

                public final String a() {
                    return this.f32428a;
                }

                public final String b() {
                    return this.f32429b;
                }

                public final String c() {
                    return this.f32430c;
                }

                public final String d() {
                    return this.f32430c;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0335c)) {
                        return false;
                    }
                    C0335c cVar = (C0335c) obj;
                    return x.b(this.f32428a, cVar.f32428a) && x.b(this.f32429b, cVar.f32429b) && x.b(this.f32430c, cVar.f32430c);
                }

                public final String f() {
                    return this.f32428a;
                }

                public final String h() {
                    return this.f32429b;
                }

                public int hashCode() {
                    String str = this.f32428a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f32429b;
                    int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.f32430c;
                    if (str3 != null) {
                        i11 = str3.hashCode();
                    }
                    return hashCode2 + i11;
                }

                public String toString() {
                    return "Payload(sessionId=" + this.f32428a + ", status=" + this.f32429b + ", newToken=" + this.f32430c + ')';
                }

                public /* synthetic */ C0335c(int i11, String str, String str2, String str3, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32431a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32428a = null;
                    } else {
                        this.f32428a = str;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32429b = null;
                    } else {
                        this.f32429b = str2;
                    }
                    if ((i11 & 4) == 0) {
                        this.f32430c = null;
                    } else {
                        this.f32430c = str3;
                    }
                }

                public final C0335c a(String str, String str2, String str3) {
                    return new C0335c(str, str2, str3);
                }

                public C0335c(String str, String str2, String str3) {
                    this.f32428a = str;
                    this.f32429b = str2;
                    this.f32430c = str3;
                }

                public static /* synthetic */ C0335c a(C0335c cVar, String str, String str2, String str3, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32428a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = cVar.f32429b;
                    }
                    if ((i11 & 4) != 0) {
                        str3 = cVar.f32430c;
                    }
                    return cVar.a(str, str2, str3);
                }

                public static final void a(C0335c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32428a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32428a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32429b != null) {
                        bVar.y(fVar, 1, v1.f57779a, cVar.f32429b);
                    }
                    if (bVar.q(fVar, 2) || cVar.f32430c != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 2, v1.f57779a, cVar.f32430c);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ C0335c(String str, String str2, String str3, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
                }
            }

            public c() {
                this((C0335c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final c a(C0335c cVar) {
                return new c(cVar);
            }

            public final C0335c c() {
                return this.f32425b;
            }

            public final C0335c d() {
                return this.f32425b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && x.b(this.f32425b, ((c) obj).f32425b);
            }

            public int hashCode() {
                C0335c cVar = this.f32425b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "ApplicantActionStatusChange(payload=" + this.f32425b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ c(int i11, Type type, C0335c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32426a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32425b = null;
                } else {
                    this.f32425b = cVar;
                }
            }

            public static /* synthetic */ c a(c cVar, C0335c cVar2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar2 = cVar.f32425b;
                }
                return cVar.a(cVar2);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ c(C0335c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(cVar, bVar, fVar);
                if (bVar.q(fVar, 1) || cVar.f32425b != null) {
                    bVar.y(fVar, 1, C0335c.a.f32431a, cVar.f32425b);
                }
            }

            public c(C0335c cVar) {
                super(Type.APPLICANT_ACTION_STATUS_CHANGE);
                this.f32425b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class d extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32433b;

            public static final class a implements d0<d> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32434a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32435b;

                static {
                    a aVar = new a();
                    f32434a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantImageReviewed", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32435b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public d deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32438a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32438a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new d(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32438a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32435b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, d dVar2) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    d.a(dVar2, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<d> serializer() {
                    return a.f32434a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\nB\u001f\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001a\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$d$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "newToken", "sessionId", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getNewToken$annotations", "()V", "e", "getSessionId$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32436a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32437b;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32438a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32439b;

                    static {
                        a aVar = new a();
                        f32438a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantImageReviewed.Payload", aVar, 2);
                        pluginGeneratedSerialDescriptor.k("newToken", true);
                        pluginGeneratedSerialDescriptor.k("sessionId", true);
                        f32439b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        int i11;
                        Object obj;
                        Object obj2;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        if (b11.k()) {
                            v1 v1Var = v1.f57779a;
                            obj = b11.j(descriptor, 0, v1Var, null);
                            obj2 = b11.j(descriptor, 1, v1Var, null);
                            i11 = 3;
                        } else {
                            obj2 = null;
                            Object obj3 = null;
                            int i12 = 0;
                            boolean z11 = true;
                            while (z11) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    z11 = false;
                                } else if (w11 == 0) {
                                    obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                                    i12 |= 1;
                                } else if (w11 == 1) {
                                    obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                                    i12 |= 2;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            obj = obj3;
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (String) obj, (String) obj2, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32439b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32438a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((String) null, (String) null, 3, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void d() {
                }

                public static /* synthetic */ void f() {
                }

                public final String a() {
                    return this.f32436a;
                }

                public final String b() {
                    return this.f32437b;
                }

                public final String c() {
                    return this.f32436a;
                }

                public final String e() {
                    return this.f32437b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof c)) {
                        return false;
                    }
                    c cVar = (c) obj;
                    return x.b(this.f32436a, cVar.f32436a) && x.b(this.f32437b, cVar.f32437b);
                }

                public int hashCode() {
                    String str = this.f32436a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f32437b;
                    if (str2 != null) {
                        i11 = str2.hashCode();
                    }
                    return hashCode + i11;
                }

                public String toString() {
                    return "Payload(newToken=" + this.f32436a + ", sessionId=" + this.f32437b + ')';
                }

                public /* synthetic */ c(int i11, String str, String str2, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32438a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32436a = null;
                    } else {
                        this.f32436a = str;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32437b = null;
                    } else {
                        this.f32437b = str2;
                    }
                }

                public final c a(String str, String str2) {
                    return new c(str, str2);
                }

                public c(String str, String str2) {
                    this.f32436a = str;
                    this.f32437b = str2;
                }

                public static /* synthetic */ c a(c cVar, String str, String str2, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32436a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = cVar.f32437b;
                    }
                    return cVar.a(str, str2);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32436a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32436a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32437b != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 1, v1.f57779a, cVar.f32437b);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, String str2, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2);
                }
            }

            public d() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final d a(c cVar) {
                return new d(cVar);
            }

            public final c c() {
                return this.f32433b;
            }

            public final c d() {
                return this.f32433b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && x.b(this.f32433b, ((d) obj).f32433b);
            }

            public int hashCode() {
                c cVar = this.f32433b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "ApplicantImageReviewed(payload=" + this.f32433b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ d(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32434a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32433b = null;
                } else {
                    this.f32433b = cVar;
                }
            }

            public static /* synthetic */ d a(d dVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = dVar.f32433b;
                }
                return dVar.a(cVar);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ d(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(d dVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(dVar, bVar, fVar);
                if (bVar.q(fVar, 1) || dVar.f32433b != null) {
                    bVar.y(fVar, 1, c.a.f32438a, dVar.f32433b);
                }
            }

            public d(c cVar) {
                super(Type.APPLICANT_IMAGE_REVIEWED);
                this.f32433b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class e extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32440b;

            public static final class a implements d0<e> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32441a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32442b;

                static {
                    a aVar = new a();
                    f32441a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantLevelChange", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32442b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public e deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32445a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32445a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new e(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32445a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32442b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, e eVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    e.a(eVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<e> serializer() {
                    return a.f32441a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\nB\u001d\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001a\u0010\u001bB3\b\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001a\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$e$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "levelName", "newToken", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "getLevelName$annotations", "()V", "e", "getNewToken$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32443a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32444b;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32445a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32446b;

                    static {
                        a aVar = new a();
                        f32445a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantLevelChange.Payload", aVar, 2);
                        pluginGeneratedSerialDescriptor.k("levelName", true);
                        pluginGeneratedSerialDescriptor.k("newToken", false);
                        f32446b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        int i11;
                        Object obj;
                        Object obj2;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        if (b11.k()) {
                            v1 v1Var = v1.f57779a;
                            obj = b11.j(descriptor, 0, v1Var, null);
                            obj2 = b11.j(descriptor, 1, v1Var, null);
                            i11 = 3;
                        } else {
                            obj2 = null;
                            Object obj3 = null;
                            int i12 = 0;
                            boolean z11 = true;
                            while (z11) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    z11 = false;
                                } else if (w11 == 0) {
                                    obj3 = b11.j(descriptor, 0, v1.f57779a, obj3);
                                    i12 |= 1;
                                } else if (w11 == 1) {
                                    obj2 = b11.j(descriptor, 1, v1.f57779a, obj2);
                                    i12 |= 2;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            obj = obj3;
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (String) obj, (String) obj2, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32446b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32445a;
                    }

                    public b() {
                    }
                }

                public /* synthetic */ c(int i11, String str, String str2, q1 q1Var) {
                    if (2 != (i11 & 2)) {
                        h1.a(i11, 2, a.f32445a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32443a = null;
                    } else {
                        this.f32443a = str;
                    }
                    this.f32444b = str2;
                }

                public static /* synthetic */ void d() {
                }

                public static /* synthetic */ void f() {
                }

                public final String a() {
                    return this.f32443a;
                }

                public final String b() {
                    return this.f32444b;
                }

                public final String c() {
                    return this.f32443a;
                }

                public final String e() {
                    return this.f32444b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof c)) {
                        return false;
                    }
                    c cVar = (c) obj;
                    return x.b(this.f32443a, cVar.f32443a) && x.b(this.f32444b, cVar.f32444b);
                }

                public int hashCode() {
                    String str = this.f32443a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f32444b;
                    if (str2 != null) {
                        i11 = str2.hashCode();
                    }
                    return hashCode + i11;
                }

                public String toString() {
                    return "Payload(levelName=" + this.f32443a + ", newToken=" + this.f32444b + ')';
                }

                public c(String str, String str2) {
                    this.f32443a = str;
                    this.f32444b = str2;
                }

                public final c a(String str, String str2) {
                    return new c(str, str2);
                }

                public static /* synthetic */ c a(c cVar, String str, String str2, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32443a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = cVar.f32444b;
                    }
                    return cVar.a(str, str2);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    if (bVar.q(fVar, 0) || cVar.f32443a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32443a);
                    }
                    bVar.y(fVar, 1, v1.f57779a, cVar.f32444b);
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, String str2, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str, str2);
                }
            }

            public e() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final e a(c cVar) {
                return new e(cVar);
            }

            public final c c() {
                return this.f32440b;
            }

            public final c d() {
                return this.f32440b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof e) && x.b(this.f32440b, ((e) obj).f32440b);
            }

            public int hashCode() {
                c cVar = this.f32440b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "ApplicantLevelChange(payload=" + this.f32440b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ e(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32441a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32440b = null;
                } else {
                    this.f32440b = cVar;
                }
            }

            public static /* synthetic */ e a(e eVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = eVar.f32440b;
                }
                return eVar.a(cVar);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ e(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(e eVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(eVar, bVar, fVar);
                if (bVar.q(fVar, 1) || eVar.f32440b != null) {
                    bVar.y(fVar, 1, c.a.f32445a, eVar.f32440b);
                }
            }

            public e(c cVar) {
                super(Type.APPLICANT_LEVEL_CHANGE);
                this.f32440b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class f extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32447b;

            public static final class a implements d0<f> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32448a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32449b;

                static {
                    a aVar = new a();
                    f32448a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantQueueStatus", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32449b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public f deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32452a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32452a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new f(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32452a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32449b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, f fVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    f.a(fVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<f> serializer() {
                    return a.f32448a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\b\u000bB\u001f\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dB3\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0011\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001c\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\b\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0016\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0017\u0010\nR\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0016\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001a\u0010\n¨\u0006#"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "()Ljava/lang/Long;", "b", "waitTimeSec", "queuePlace", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$f$c;", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Long;", "e", "getWaitTimeSec$annotations", "()V", "c", "getQueuePlace$annotations", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Long;Ljava/lang/Long;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final Long f32450a;

                /* renamed from: b  reason: collision with root package name */
                public final Long f32451b;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32452a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32453b;

                    static {
                        a aVar = new a();
                        f32452a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantQueueStatus.Payload", aVar, 2);
                        pluginGeneratedSerialDescriptor.k("waitTimeSec", true);
                        pluginGeneratedSerialDescriptor.k("queuePlace", true);
                        f32453b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        int i11;
                        Object obj;
                        Object obj2;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        if (b11.k()) {
                            x0 x0Var = x0.f57786a;
                            obj = b11.j(descriptor, 0, x0Var, null);
                            obj2 = b11.j(descriptor, 1, x0Var, null);
                            i11 = 3;
                        } else {
                            obj2 = null;
                            Object obj3 = null;
                            int i12 = 0;
                            boolean z11 = true;
                            while (z11) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    z11 = false;
                                } else if (w11 == 0) {
                                    obj3 = b11.j(descriptor, 0, x0.f57786a, obj3);
                                    i12 |= 1;
                                } else if (w11 == 1) {
                                    obj2 = b11.j(descriptor, 1, x0.f57786a, obj2);
                                    i12 |= 2;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            obj = obj3;
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (Long) obj, (Long) obj2, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        x0 x0Var = x0.f57786a;
                        return new kotlinx.serialization.b[]{h10.a.u(x0Var), h10.a.u(x0Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32453b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32452a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((Long) null, (Long) null, 3, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void d() {
                }

                public static /* synthetic */ void f() {
                }

                public final Long a() {
                    return this.f32450a;
                }

                public final Long b() {
                    return this.f32451b;
                }

                public final Long c() {
                    return this.f32451b;
                }

                public final Long e() {
                    return this.f32450a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof c)) {
                        return false;
                    }
                    c cVar = (c) obj;
                    return x.b(this.f32450a, cVar.f32450a) && x.b(this.f32451b, cVar.f32451b);
                }

                public int hashCode() {
                    Long l11 = this.f32450a;
                    int i11 = 0;
                    int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
                    Long l12 = this.f32451b;
                    if (l12 != null) {
                        i11 = l12.hashCode();
                    }
                    return hashCode + i11;
                }

                public String toString() {
                    return "Payload(waitTimeSec=" + this.f32450a + ", queuePlace=" + this.f32451b + ')';
                }

                public /* synthetic */ c(int i11, Long l11, Long l12, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32452a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32450a = null;
                    } else {
                        this.f32450a = l11;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32451b = null;
                    } else {
                        this.f32451b = l12;
                    }
                }

                public final c a(Long l11, Long l12) {
                    return new c(l11, l12);
                }

                public c(Long l11, Long l12) {
                    this.f32450a = l11;
                    this.f32451b = l12;
                }

                public static /* synthetic */ c a(c cVar, Long l11, Long l12, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        l11 = cVar.f32450a;
                    }
                    if ((i11 & 2) != 0) {
                        l12 = cVar.f32451b;
                    }
                    return cVar.a(l11, l12);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32450a != null) {
                        bVar.y(fVar, 0, x0.f57786a, cVar.f32450a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32451b != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 1, x0.f57786a, cVar.f32451b);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(Long l11, Long l12, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : l11, (i11 & 2) != 0 ? null : l12);
                }
            }

            public f() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final f a(c cVar) {
                return new f(cVar);
            }

            public final c c() {
                return this.f32447b;
            }

            public final c d() {
                return this.f32447b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof f) && x.b(this.f32447b, ((f) obj).f32447b);
            }

            public int hashCode() {
                c cVar = this.f32447b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "ApplicantQueueStatus(payload=" + this.f32447b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ f(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32448a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32447b = null;
                } else {
                    this.f32447b = cVar;
                }
            }

            public static /* synthetic */ f a(f fVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = fVar.f32447b;
                }
                return fVar.a(cVar);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ f(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
                ServerMessage.a(fVar, bVar, fVar2);
                if (bVar.q(fVar2, 1) || fVar.f32447b != null) {
                    bVar.y(fVar2, 1, c.a.f32452a, fVar.f32447b);
                }
            }

            public f(c cVar) {
                super(Type.APPLICANT_QUEUE_STATUS);
                this.f32447b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class g extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32454b;

            public static final class a implements d0<g> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32455a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32456b;

                static {
                    a aVar = new a();
                    f32455a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantStatusChange", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32456b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public g deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32460a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32460a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new g(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32460a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32456b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, g gVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    g.a(gVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<g> serializer() {
                    return a.f32455a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0002\b\nB+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001fB?\b\u0017\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001e\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000f\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0015\u0012\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0017R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001c\u0010\u0017¨\u0006%"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$g$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "sessionId", "status", "newToken", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "getSessionId$annotations", "()V", "h", "getStatus$annotations", "d", "getNewToken$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32457a;

                /* renamed from: b  reason: collision with root package name */
                public final String f32458b;

                /* renamed from: c  reason: collision with root package name */
                public final String f32459c;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32460a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32461b;

                    static {
                        a aVar = new a();
                        f32460a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ApplicantStatusChange.Payload", aVar, 3);
                        pluginGeneratedSerialDescriptor.k("sessionId", true);
                        pluginGeneratedSerialDescriptor.k("status", true);
                        pluginGeneratedSerialDescriptor.k("newToken", true);
                        f32461b = pluginGeneratedSerialDescriptor;
                    }

                    /* JADX WARNING: Multi-variable type inference failed */
                    /* renamed from: a */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.g.c deserialize(kotlinx.serialization.encoding.c r12) {
                        /*
                            r11 = this;
                            kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
                            kotlinx.serialization.encoding.a r12 = r12.b(r0)
                            boolean r1 = r12.k()
                            r2 = 0
                            r3 = 2
                            r4 = 0
                            r5 = 1
                            if (r1 == 0) goto L_0x0023
                            kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r4 = r12.j(r0, r4, r1, r2)
                            java.lang.Object r5 = r12.j(r0, r5, r1, r2)
                            java.lang.Object r1 = r12.j(r0, r3, r1, r2)
                            r2 = 7
                            r3 = r2
                            goto L_0x005e
                        L_0x0023:
                            r1 = r2
                            r6 = r1
                            r7 = r6
                            r2 = r4
                            r8 = r5
                        L_0x0028:
                            if (r8 == 0) goto L_0x005a
                            int r9 = r12.w(r0)
                            r10 = -1
                            if (r9 == r10) goto L_0x0058
                            if (r9 == 0) goto L_0x004f
                            if (r9 == r5) goto L_0x0046
                            if (r9 != r3) goto L_0x0040
                            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r7 = r12.j(r0, r3, r9, r7)
                            r2 = r2 | 4
                            goto L_0x0028
                        L_0x0040:
                            kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
                            r12.<init>((int) r9)
                            throw r12
                        L_0x0046:
                            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r6 = r12.j(r0, r5, r9, r6)
                            r2 = r2 | 2
                            goto L_0x0028
                        L_0x004f:
                            kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                            java.lang.Object r1 = r12.j(r0, r4, r9, r1)
                            r2 = r2 | 1
                            goto L_0x0028
                        L_0x0058:
                            r8 = r4
                            goto L_0x0028
                        L_0x005a:
                            r4 = r1
                            r3 = r2
                            r5 = r6
                            r1 = r7
                        L_0x005e:
                            r12.c(r0)
                            com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$g$c r12 = new com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$g$c
                            java.lang.String r4 = (java.lang.String) r4
                            java.lang.String r5 = (java.lang.String) r5
                            r6 = r1
                            java.lang.String r6 = (java.lang.String) r6
                            r7 = 0
                            r2 = r12
                            r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (kotlinx.serialization.internal.q1) r7)
                            return r12
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.g.c.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.SNSMessage$ServerMessage$g$c");
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        v1 v1Var = v1.f57779a;
                        return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32461b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32460a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((String) null, (String) null, (String) null, 7, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void e() {
                }

                public static /* synthetic */ void g() {
                }

                public static /* synthetic */ void i() {
                }

                public final String a() {
                    return this.f32457a;
                }

                public final String b() {
                    return this.f32458b;
                }

                public final String c() {
                    return this.f32459c;
                }

                public final String d() {
                    return this.f32459c;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof c)) {
                        return false;
                    }
                    c cVar = (c) obj;
                    return x.b(this.f32457a, cVar.f32457a) && x.b(this.f32458b, cVar.f32458b) && x.b(this.f32459c, cVar.f32459c);
                }

                public final String f() {
                    return this.f32457a;
                }

                public final String h() {
                    return this.f32458b;
                }

                public int hashCode() {
                    String str = this.f32457a;
                    int i11 = 0;
                    int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                    String str2 = this.f32458b;
                    int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                    String str3 = this.f32459c;
                    if (str3 != null) {
                        i11 = str3.hashCode();
                    }
                    return hashCode2 + i11;
                }

                public String toString() {
                    return "Payload(sessionId=" + this.f32457a + ", status=" + this.f32458b + ", newToken=" + this.f32459c + ')';
                }

                public /* synthetic */ c(int i11, String str, String str2, String str3, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32460a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32457a = null;
                    } else {
                        this.f32457a = str;
                    }
                    if ((i11 & 2) == 0) {
                        this.f32458b = null;
                    } else {
                        this.f32458b = str2;
                    }
                    if ((i11 & 4) == 0) {
                        this.f32459c = null;
                    } else {
                        this.f32459c = str3;
                    }
                }

                public final c a(String str, String str2, String str3) {
                    return new c(str, str2, str3);
                }

                public c(String str, String str2, String str3) {
                    this.f32457a = str;
                    this.f32458b = str2;
                    this.f32459c = str3;
                }

                public static /* synthetic */ c a(c cVar, String str, String str2, String str3, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32457a;
                    }
                    if ((i11 & 2) != 0) {
                        str2 = cVar.f32458b;
                    }
                    if ((i11 & 4) != 0) {
                        str3 = cVar.f32459c;
                    }
                    return cVar.a(str, str2, str3);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    boolean z11 = false;
                    if (bVar.q(fVar, 0) || cVar.f32457a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32457a);
                    }
                    if (bVar.q(fVar, 1) || cVar.f32458b != null) {
                        bVar.y(fVar, 1, v1.f57779a, cVar.f32458b);
                    }
                    if (bVar.q(fVar, 2) || cVar.f32459c != null) {
                        z11 = true;
                    }
                    if (z11) {
                        bVar.y(fVar, 2, v1.f57779a, cVar.f32459c);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, String str2, String str3, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
                }
            }

            public g() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final g a(c cVar) {
                return new g(cVar);
            }

            public final c c() {
                return this.f32454b;
            }

            public final c d() {
                return this.f32454b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof g) && x.b(this.f32454b, ((g) obj).f32454b);
            }

            public int hashCode() {
                c cVar = this.f32454b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "ApplicantStatusChange(payload=" + this.f32454b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ g(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32455a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32454b = null;
                } else {
                    this.f32454b = cVar;
                }
            }

            public static /* synthetic */ g a(g gVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = gVar.f32454b;
                }
                return gVar.a(cVar);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ g(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(g gVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(gVar, bVar, fVar);
                if (bVar.q(fVar, 1) || gVar.f32454b != null) {
                    bVar.y(fVar, 1, c.a.f32460a, gVar.f32454b);
                }
            }

            public g(c cVar) {
                super(Type.APPLICANT_STATUS_CHANGE);
                this.f32454b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$h;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class h extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            public static final class a implements d0<h> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32462a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32463b;

                static {
                    a aVar = new a();
                    f32462a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.CancelScreenshot", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32463b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public h deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32414a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32414a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new h(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32463b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, h hVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    h.a(hVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<h> serializer() {
                    return a.f32462a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ h(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32462a.getDescriptor());
                }
            }

            public static final void a(h hVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(hVar, bVar, fVar);
            }

            public h() {
                super(Type.CANCEL_SCREENSHOT);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$i;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class i extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            public static final class a implements d0<i> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32464a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32465b;

                static {
                    a aVar = new a();
                    f32464a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.CancelVerifyMobilePhoneTan", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32465b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public i deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32414a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32414a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new i(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32465b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, i iVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    i.a(iVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<i> serializer() {
                    return a.f32464a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ i(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32464a.getDescriptor());
                }
            }

            public static final void a(i iVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(iVar, bVar, fVar);
            }

            public i() {
                super(Type.CANCEL_VERIFY_MOBILE_PHONE_TAN);
            }
        }

        public static final class j {
            public /* synthetic */ j(kotlin.jvm.internal.r rVar) {
                this();
            }

            public final ServerMessage a(kotlinx.serialization.json.a aVar, String str) {
                ServerMessage fVar;
                try {
                    if (StringsKt__StringsJVMKt.z(str)) {
                        return new l();
                    }
                    kotlinx.serialization.modules.d a11 = aVar.a();
                    kotlin.reflect.p n11 = Reflection.n(v.class);
                    MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                    v vVar = (v) aVar.c(kotlinx.serialization.h.d(a11, n11), str);
                    String c11 = vVar.c();
                    if (x.b(c11, Type.CANCEL_VERIFY_MOBILE_PHONE_TAN.getType())) {
                        return new i();
                    }
                    if (x.b(c11, Type.VERIFY_MOBILE_PHONE_TAN.getType())) {
                        return new s();
                    }
                    if (x.b(c11, Type.STEP_CHANGE.getType())) {
                        kotlinx.serialization.json.g a12 = vVar.a();
                        fVar = new p(a12 != null ? (p.c) aVar.d(p.c.Companion.serializer(), a12) : null);
                    } else if (x.b(c11, Type.COMPLETED.getType())) {
                        kotlinx.serialization.json.g a13 = vVar.a();
                        fVar = new k(a13 != null ? (k.c) aVar.d(k.c.Companion.serializer(), a13) : null);
                    } else if (x.b(c11, Type.MODERATOR_NAME.getType())) {
                        kotlinx.serialization.json.g a14 = vVar.a();
                        if (a14 != null) {
                            n.c cVar = (n.c) aVar.d(n.c.Companion.serializer(), a14);
                            if (cVar != null) {
                                fVar = new n(cVar);
                            }
                        }
                        return new q(vVar.c());
                    } else if (x.b(c11, Type.READY_FOR_SCREENSHOT.getType())) {
                        kotlinx.serialization.json.g a15 = vVar.a();
                        fVar = new o(a15 != null ? (ScreenShotPayload) aVar.d(ScreenShotPayload.Companion.serializer(), a15) : null);
                    } else if (x.b(c11, Type.MAKE_SCREENSHOT.getType())) {
                        kotlinx.serialization.json.g a16 = vVar.a();
                        fVar = new m(a16 != null ? (ScreenShotPayload) aVar.d(ScreenShotPayload.Companion.serializer(), a16) : null);
                    } else if (x.b(c11, Type.CANCEL_SCREENSHOT.getType())) {
                        return new h();
                    } else {
                        if (x.b(c11, Type.UPDATE_REQUIRED_ID_DOCS.getType())) {
                            return new r();
                        }
                        if (x.b(c11, Type.APPLICANT_LEVEL_CHANGE.getType())) {
                            kotlinx.serialization.json.g a17 = vVar.a();
                            fVar = new e(a17 != null ? (e.c) aVar.d(e.c.Companion.serializer(), a17) : null);
                        } else if (x.b(c11, Type.APPLICANT_STATUS_CHANGE.getType())) {
                            kotlinx.serialization.json.g a18 = vVar.a();
                            fVar = new g(a18 != null ? (g.c) aVar.d(g.c.Companion.serializer(), a18) : null);
                        } else if (x.b(c11, Type.APPLICANT_ACTION_STATUS_CHANGE.getType())) {
                            kotlinx.serialization.json.g a19 = vVar.a();
                            fVar = new c(a19 != null ? (c.C0335c) aVar.d(c.C0335c.Companion.serializer(), a19) : null);
                        } else if (x.b(c11, Type.WELCOME.getType())) {
                            return new t();
                        } else {
                            if (x.b(c11, Type.ADDED_ID_DOC.getType())) {
                                kotlinx.serialization.json.g a21 = vVar.a();
                                fVar = new b(a21 != null ? (b.c) aVar.d(b.c.Companion.serializer(), a21) : null);
                            } else if (x.b(c11, Type.APPLICANT_IMAGE_REVIEWED.getType())) {
                                kotlinx.serialization.json.g a22 = vVar.a();
                                fVar = new d(a22 != null ? (d.c) aVar.d(d.c.Companion.serializer(), a22) : null);
                            } else if (x.b(c11, Type.APPLICANT_QUEUE_STATUS.getType())) {
                                kotlinx.serialization.json.g a23 = vVar.a();
                                fVar = new f(a23 != null ? (f.c) aVar.d(f.c.Companion.serializer(), a23) : null);
                            } else {
                                com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                                String a24 = com.sumsub.sns.internal.log.c.a(this);
                                com.sumsub.log.logger.a.d(aVar2, a24, "unknown message: " + str, (Throwable) null, 4, (Object) null);
                                return new q(vVar.c());
                            }
                        }
                    }
                    return fVar;
                } catch (Exception e11) {
                    com.sumsub.sns.internal.log.a aVar3 = com.sumsub.sns.internal.log.a.f34862a;
                    String a25 = com.sumsub.sns.internal.log.c.a(this);
                    com.sumsub.sns.internal.log.b.b(aVar3, a25, "Can't parse server message=" + str, e11);
                    return new q((String) null);
                }
            }

            public final kotlinx.serialization.b<ServerMessage> serializer() {
                return a.f32416a;
            }

            public j() {
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0003\b\n\fB\u0013\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010B1\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u000f\u0010\u0017J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;", "c", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;", "payload", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;)V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class k extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32466b;

            public static final class a implements d0<k> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32467a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32468b;

                static {
                    a aVar = new a();
                    f32467a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.Completed", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32468b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public k deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32470a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32470a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new k(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32470a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32468b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, k kVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    k.a(kVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<k> serializer() {
                    return a.f32467a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0002\b\u0014B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018B'\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0017\u0010\u001cJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\b\u0010\nJ\u001c\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0014\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "()Ljava/lang/Boolean;", "applicantCompleted", "(Ljava/lang/Boolean;)Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$k$c;", "", "toString", "", "hashCode", "other", "equals", "Ljava/lang/Boolean;", "b", "getApplicantCompleted$annotations", "()V", "<init>", "(Ljava/lang/Boolean;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final Boolean f32469a;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32470a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32471b;

                    static {
                        a aVar = new a();
                        f32470a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.Completed.Payload", aVar, 1);
                        pluginGeneratedSerialDescriptor.k("applicantCompleted", true);
                        f32471b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        Object obj;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        int i11 = 1;
                        if (b11.k()) {
                            obj = b11.j(descriptor, 0, kotlinx.serialization.internal.h.f57720a, null);
                        } else {
                            obj = null;
                            int i12 = 0;
                            while (i11 != 0) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    i11 = 0;
                                } else if (w11 == 0) {
                                    obj = b11.j(descriptor, 0, kotlinx.serialization.internal.h.f57720a, obj);
                                    i12 |= 1;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (Boolean) obj, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{h10.a.u(kotlinx.serialization.internal.h.f57720a)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32471b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32470a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((Boolean) null, 1, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void c() {
                }

                public final Boolean a() {
                    return this.f32469a;
                }

                public final Boolean b() {
                    return this.f32469a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof c) && x.b(this.f32469a, ((c) obj).f32469a);
                }

                public int hashCode() {
                    Boolean bool = this.f32469a;
                    if (bool == null) {
                        return 0;
                    }
                    return bool.hashCode();
                }

                public String toString() {
                    return "Payload(applicantCompleted=" + this.f32469a + ')';
                }

                public /* synthetic */ c(int i11, Boolean bool, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32470a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32469a = null;
                    } else {
                        this.f32469a = bool;
                    }
                }

                public final c a(Boolean bool) {
                    return new c(bool);
                }

                public c(Boolean bool) {
                    this.f32469a = bool;
                }

                public static /* synthetic */ c a(c cVar, Boolean bool, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        bool = cVar.f32469a;
                    }
                    return cVar.a(bool);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    if (bVar.q(fVar, 0) || cVar.f32469a != null) {
                        bVar.y(fVar, 0, kotlinx.serialization.internal.h.f57720a, cVar.f32469a);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(Boolean bool, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : bool);
                }
            }

            public k() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public static final void a(k kVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(kVar, bVar, fVar);
                if (bVar.q(fVar, 1) || kVar.f32466b != null) {
                    bVar.y(fVar, 1, c.a.f32470a, kVar.f32466b);
                }
            }

            public final c c() {
                return this.f32466b;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ k(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32467a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32466b = null;
                } else {
                    this.f32466b = cVar;
                }
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ k(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public k(c cVar) {
                super(Type.COMPLETED);
                this.f32466b = cVar;
            }
        }

        public static final class l extends ServerMessage {
            public l() {
                super(Type.EMPTY);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\u0014B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$m;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class m extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final ScreenShotPayload f32472b;

            public static final class a implements d0<m> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32473a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32474b;

                static {
                    a aVar = new a();
                    f32473a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.MakeScreenshot", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32474b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public m deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, ScreenShotPayload.a.f32412a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, ScreenShotPayload.a.f32412a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new m(i11, (Type) obj2, (ScreenShotPayload) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(ScreenShotPayload.a.f32412a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32474b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, m mVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    m.a(mVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<m> serializer() {
                    return a.f32473a;
                }

                public b() {
                }
            }

            public m() {
                this((ScreenShotPayload) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final m a(ScreenShotPayload screenShotPayload) {
                return new m(screenShotPayload);
            }

            public final ScreenShotPayload c() {
                return this.f32472b;
            }

            public final ScreenShotPayload d() {
                return this.f32472b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof m) && x.b(this.f32472b, ((m) obj).f32472b);
            }

            public int hashCode() {
                ScreenShotPayload screenShotPayload = this.f32472b;
                if (screenShotPayload == null) {
                    return 0;
                }
                return screenShotPayload.hashCode();
            }

            public String toString() {
                return "MakeScreenshot(payload=" + this.f32472b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ m(int i11, Type type, ScreenShotPayload screenShotPayload, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32473a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32472b = null;
                } else {
                    this.f32472b = screenShotPayload;
                }
            }

            public static /* synthetic */ m a(m mVar, ScreenShotPayload screenShotPayload, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    screenShotPayload = mVar.f32472b;
                }
                return mVar.a(screenShotPayload);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ m(ScreenShotPayload screenShotPayload, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : screenShotPayload);
            }

            public static final void a(m mVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(mVar, bVar, fVar);
                if (bVar.q(fVar, 1) || mVar.f32472b != null) {
                    bVar.y(fVar, 1, ScreenShotPayload.a.f32412a, mVar.f32472b);
                }
            }

            public m(ScreenShotPayload screenShotPayload) {
                super(Type.MAKE_SCREENSHOT);
                this.f32472b = screenShotPayload;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0017\u0010\u000b\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class n extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32475b;

            public static final class a implements d0<n> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32476a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32477b;

                static {
                    a aVar = new a();
                    f32476a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ModeratorName", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", false);
                    f32477b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public n deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.p(descriptor, 1, c.a.f32479a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.p(descriptor, 1, c.a.f32479a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new n(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, c.a.f32479a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32477b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, n nVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    n.a(nVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<n> serializer() {
                    return a.f32476a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\b\u0012B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B'\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0016\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$n$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "name", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getName$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32478a;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32479a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32480b;

                    static {
                        a aVar = new a();
                        f32479a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ModeratorName.Payload", aVar, 1);
                        pluginGeneratedSerialDescriptor.k("name", true);
                        f32480b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        Object obj;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        int i11 = 1;
                        if (b11.k()) {
                            obj = b11.j(descriptor, 0, v1.f57779a, null);
                        } else {
                            obj = null;
                            int i12 = 0;
                            while (i11 != 0) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    i11 = 0;
                                } else if (w11 == 0) {
                                    obj = b11.j(descriptor, 0, v1.f57779a, obj);
                                    i12 |= 1;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (String) obj, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32480b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32479a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((String) null, 1, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void c() {
                }

                public final String a() {
                    return this.f32478a;
                }

                public final String b() {
                    return this.f32478a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof c) && x.b(this.f32478a, ((c) obj).f32478a);
                }

                public int hashCode() {
                    String str = this.f32478a;
                    if (str == null) {
                        return 0;
                    }
                    return str.hashCode();
                }

                public String toString() {
                    return "Payload(name=" + this.f32478a + ')';
                }

                public /* synthetic */ c(int i11, String str, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32479a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32478a = null;
                    } else {
                        this.f32478a = str;
                    }
                }

                public final c a(String str) {
                    return new c(str);
                }

                public c(String str) {
                    this.f32478a = str;
                }

                public static /* synthetic */ c a(c cVar, String str, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32478a;
                    }
                    return cVar.a(str);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    if (bVar.q(fVar, 0) || cVar.f32478a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32478a);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ n(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (3 != (i11 & 3)) {
                    h1.a(i11, 3, a.f32476a.getDescriptor());
                }
                this.f32475b = cVar;
            }

            public final n a(c cVar) {
                return new n(cVar);
            }

            public final c c() {
                return this.f32475b;
            }

            public final c d() {
                return this.f32475b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof n) && x.b(this.f32475b, ((n) obj).f32475b);
            }

            public int hashCode() {
                return this.f32475b.hashCode();
            }

            public String toString() {
                return "ModeratorName(payload=" + this.f32475b + ')';
            }

            public n(c cVar) {
                super(Type.MODERATOR_NAME);
                this.f32475b = cVar;
            }

            public static /* synthetic */ n a(n nVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = nVar.f32475b;
                }
                return nVar.a(cVar);
            }

            public static final void a(n nVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(nVar, bVar, fVar);
                bVar.F(fVar, 1, c.a.f32479a, nVar.f32475b);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0002\b\u0014B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$o;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$ScreenShotPayload;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class o extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final ScreenShotPayload f32481b;

            public static final class a implements d0<o> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32482a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32483b;

                static {
                    a aVar = new a();
                    f32482a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.ReadyForScreenshot", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32483b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public o deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, ScreenShotPayload.a.f32412a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, ScreenShotPayload.a.f32412a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new o(i11, (Type) obj2, (ScreenShotPayload) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(ScreenShotPayload.a.f32412a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32483b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, o oVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    o.a(oVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<o> serializer() {
                    return a.f32482a;
                }

                public b() {
                }
            }

            public o() {
                this((ScreenShotPayload) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final o a(ScreenShotPayload screenShotPayload) {
                return new o(screenShotPayload);
            }

            public final ScreenShotPayload c() {
                return this.f32481b;
            }

            public final ScreenShotPayload d() {
                return this.f32481b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof o) && x.b(this.f32481b, ((o) obj).f32481b);
            }

            public int hashCode() {
                ScreenShotPayload screenShotPayload = this.f32481b;
                if (screenShotPayload == null) {
                    return 0;
                }
                return screenShotPayload.hashCode();
            }

            public String toString() {
                return "ReadyForScreenshot(payload=" + this.f32481b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ o(int i11, Type type, ScreenShotPayload screenShotPayload, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32482a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32481b = null;
                } else {
                    this.f32481b = screenShotPayload;
                }
            }

            public static /* synthetic */ o a(o oVar, ScreenShotPayload screenShotPayload, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    screenShotPayload = oVar.f32481b;
                }
                return oVar.a(screenShotPayload);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ o(ScreenShotPayload screenShotPayload, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : screenShotPayload);
            }

            public static final void a(o oVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(oVar, bVar, fVar);
                if (bVar.q(fVar, 1) || oVar.f32481b != null) {
                    bVar.y(fVar, 1, ScreenShotPayload.a.f32412a, oVar.f32481b);
                }
            }

            public o(ScreenShotPayload screenShotPayload) {
                super(Type.READY_FOR_SCREENSHOT);
                this.f32481b = screenShotPayload;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000  2\u00020\u0001:\u0003\b\u0014\nB\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0018\u0010\u0019B1\b\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0018\u0010\u001fJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p$c;", "c", "payload", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p$c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p$c;", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p$c;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p$c;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class p extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final c f32484b;

            public static final class a implements d0<p> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32485a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32486b;

                static {
                    a aVar = new a();
                    f32485a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.StepChange", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("payload", true);
                    f32486b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public p deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, c.a.f32488a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, c.a.f32488a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new p(i11, (Type) obj2, (c) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(c.a.f32488a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32486b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, p pVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    p.a(pVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<p> serializer() {
                    return a.f32485a;
                }

                public b() {
                }
            }

            @kotlinx.serialization.f
            @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\b\u0012B\u0013\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B'\b\u0017\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0016\u0010\u001bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u000b\u001a\u00020\tHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$p$c;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "idDocSetType", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "getIdDocSetType$annotations", "()V", "<init>", "(Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
            public static final class c {
                public static final b Companion = new b((kotlin.jvm.internal.r) null);

                /* renamed from: a  reason: collision with root package name */
                public final String f32487a;

                public static final class a implements d0<c> {

                    /* renamed from: a  reason: collision with root package name */
                    public static final a f32488a;

                    /* renamed from: b  reason: collision with root package name */
                    public static final /* synthetic */ kotlinx.serialization.descriptors.f f32489b;

                    static {
                        a aVar = new a();
                        f32488a = aVar;
                        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.StepChange.Payload", aVar, 1);
                        pluginGeneratedSerialDescriptor.k("idDocSetType", true);
                        f32489b = pluginGeneratedSerialDescriptor;
                    }

                    /* renamed from: a */
                    public c deserialize(kotlinx.serialization.encoding.c cVar) {
                        Object obj;
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                        int i11 = 1;
                        if (b11.k()) {
                            obj = b11.j(descriptor, 0, v1.f57779a, null);
                        } else {
                            obj = null;
                            int i12 = 0;
                            while (i11 != 0) {
                                int w11 = b11.w(descriptor);
                                if (w11 == -1) {
                                    i11 = 0;
                                } else if (w11 == 0) {
                                    obj = b11.j(descriptor, 0, v1.f57779a, obj);
                                    i12 |= 1;
                                } else {
                                    throw new UnknownFieldException(w11);
                                }
                            }
                            i11 = i12;
                        }
                        b11.c(descriptor);
                        return new c(i11, (String) obj, (q1) null);
                    }

                    public kotlinx.serialization.b<?>[] childSerializers() {
                        return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a)};
                    }

                    public kotlinx.serialization.descriptors.f getDescriptor() {
                        return f32489b;
                    }

                    public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                        return d0.a.a(this);
                    }

                    /* renamed from: a */
                    public void serialize(kotlinx.serialization.encoding.d dVar, c cVar) {
                        kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                        kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                        c.a(cVar, b11, descriptor);
                        b11.c(descriptor);
                    }
                }

                public static final class b {
                    public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                        this();
                    }

                    public final kotlinx.serialization.b<c> serializer() {
                        return a.f32488a;
                    }

                    public b() {
                    }
                }

                public c() {
                    this((String) null, 1, (kotlin.jvm.internal.r) null);
                }

                public static /* synthetic */ void c() {
                }

                public final String a() {
                    return this.f32487a;
                }

                public final String b() {
                    return this.f32487a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof c) && x.b(this.f32487a, ((c) obj).f32487a);
                }

                public int hashCode() {
                    String str = this.f32487a;
                    if (str == null) {
                        return 0;
                    }
                    return str.hashCode();
                }

                public String toString() {
                    return "Payload(idDocSetType=" + this.f32487a + ')';
                }

                public /* synthetic */ c(int i11, String str, q1 q1Var) {
                    if ((i11 & 0) != 0) {
                        h1.a(i11, 0, a.f32488a.getDescriptor());
                    }
                    if ((i11 & 1) == 0) {
                        this.f32487a = null;
                    } else {
                        this.f32487a = str;
                    }
                }

                public final c a(String str) {
                    return new c(str);
                }

                public c(String str) {
                    this.f32487a = str;
                }

                public static /* synthetic */ c a(c cVar, String str, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        str = cVar.f32487a;
                    }
                    return cVar.a(str);
                }

                public static final void a(c cVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                    if (bVar.q(fVar, 0) || cVar.f32487a != null) {
                        bVar.y(fVar, 0, v1.f57779a, cVar.f32487a);
                    }
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ c(String str, int i11, kotlin.jvm.internal.r rVar) {
                    this((i11 & 1) != 0 ? null : str);
                }
            }

            public p() {
                this((c) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final p a(c cVar) {
                return new p(cVar);
            }

            public final c c() {
                return this.f32484b;
            }

            public final c d() {
                return this.f32484b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof p) && x.b(this.f32484b, ((p) obj).f32484b);
            }

            public int hashCode() {
                c cVar = this.f32484b;
                if (cVar == null) {
                    return 0;
                }
                return cVar.hashCode();
            }

            public String toString() {
                return "StepChange(payload=" + this.f32484b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ p(int i11, Type type, c cVar, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32485a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32484b = null;
                } else {
                    this.f32484b = cVar;
                }
            }

            public static /* synthetic */ p a(p pVar, c cVar, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    cVar = pVar.f32484b;
                }
                return pVar.a(cVar);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ p(c cVar, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : cVar);
            }

            public static final void a(p pVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(pVar, bVar, fVar);
                if (bVar.q(fVar, 1) || pVar.f32484b != null) {
                    bVar.y(fVar, 1, c.a.f32488a, pVar.f32484b);
                }
            }

            public p(c cVar) {
                super(Type.STEP_CHANGE);
                this.f32484b = cVar;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\b\u0013B\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018B1\b\u0017\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0017\u0010\u001eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\f\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006 "}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$q;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "c", "messageType", "toString", "", "hashCode", "", "other", "", "equals", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class q extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            /* renamed from: b  reason: collision with root package name */
            public final String f32490b;

            public static final class a implements d0<q> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32491a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32492b;

                static {
                    a aVar = new a();
                    f32491a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.Unknown", aVar, 2);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    pluginGeneratedSerialDescriptor.k("messageType", true);
                    f32492b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public q deserialize(kotlinx.serialization.encoding.c cVar) {
                    int i11;
                    Object obj;
                    Object obj2;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    if (b11.k()) {
                        obj2 = b11.p(descriptor, 0, Type.a.f32414a, null);
                        obj = b11.j(descriptor, 1, v1.f57779a, null);
                        i11 = 3;
                    } else {
                        obj2 = null;
                        Object obj3 = null;
                        int i12 = 0;
                        boolean z11 = true;
                        while (z11) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                z11 = false;
                            } else if (w11 == 0) {
                                obj2 = b11.p(descriptor, 0, Type.a.f32414a, obj2);
                                i12 |= 1;
                            } else if (w11 == 1) {
                                obj3 = b11.j(descriptor, 1, v1.f57779a, obj3);
                                i12 |= 2;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        obj = obj3;
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new q(i11, (Type) obj2, (String) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a, h10.a.u(v1.f57779a)};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32492b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, q qVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    q.a(qVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<q> serializer() {
                    return a.f32491a;
                }

                public b() {
                }
            }

            public q() {
                this((String) null, 1, (kotlin.jvm.internal.r) null);
            }

            public final q a(String str) {
                return new q(str);
            }

            public final String c() {
                return this.f32490b;
            }

            public final String d() {
                return this.f32490b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof q) && x.b(this.f32490b, ((q) obj).f32490b);
            }

            public int hashCode() {
                String str = this.f32490b;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Unknown(messageType=" + this.f32490b + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ q(int i11, Type type, String str, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32491a.getDescriptor());
                }
                if ((i11 & 2) == 0) {
                    this.f32490b = null;
                } else {
                    this.f32490b = str;
                }
            }

            public static /* synthetic */ q a(q qVar, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = qVar.f32490b;
                }
                return qVar.a(str);
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ q(String str, int i11, kotlin.jvm.internal.r rVar) {
                this((i11 & 1) != 0 ? null : str);
            }

            public static final void a(q qVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(qVar, bVar, fVar);
                if (bVar.q(fVar, 1) || qVar.f32490b != null) {
                    bVar.y(fVar, 1, v1.f57779a, qVar.f32490b);
                }
            }

            public q(String str) {
                super(Type.UNKNOWN);
                this.f32490b = str;
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$r;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class r extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            public static final class a implements d0<r> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32493a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32494b;

                static {
                    a aVar = new a();
                    f32493a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.UpdateRequiredIdDocs", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32494b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public r deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32414a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32414a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new r(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32494b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, r rVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    r.a(rVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<r> serializer() {
                    return a.f32493a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ r(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32493a.getDescriptor());
                }
            }

            public static final void a(r rVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(rVar, bVar, fVar);
            }

            public r() {
                super(Type.UPDATE_REQUIRED_ID_DOCS);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$s;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class s extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            public static final class a implements d0<s> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32495a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32496b;

                static {
                    a aVar = new a();
                    f32495a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.VerifyMobilePhoneTan", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32496b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public s deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32414a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32414a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new s(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32496b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, s sVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    s.a(sVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<s> serializer() {
                    return a.f32495a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ s(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32495a.getDescriptor());
                }
            }

            public static final void a(s sVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(sVar, bVar, fVar);
            }

            public s() {
                super(Type.VERIFY_MOBILE_PHONE_TAN);
            }
        }

        @kotlinx.serialization.f
        @Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\b\u0013B\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\t\u0010\u0011J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001¨\u0006\u0014"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$t;", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage;", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "<init>", "()V", "", "seen1", "Lcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;", "type", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/SNSMessage$ServerMessage$Type;Lkotlinx/serialization/internal/q1;)V", "Companion", "b", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
        public static final class t extends ServerMessage {
            public static final b Companion = new b((kotlin.jvm.internal.r) null);

            public static final class a implements d0<t> {

                /* renamed from: a  reason: collision with root package name */
                public static final a f32497a;

                /* renamed from: b  reason: collision with root package name */
                public static final /* synthetic */ kotlinx.serialization.descriptors.f f32498b;

                static {
                    a aVar = new a();
                    f32497a = aVar;
                    PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.SNSMessage.ServerMessage.Welcome", aVar, 1);
                    pluginGeneratedSerialDescriptor.k("type", false);
                    f32498b = pluginGeneratedSerialDescriptor;
                }

                /* renamed from: a */
                public t deserialize(kotlinx.serialization.encoding.c cVar) {
                    Object obj;
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.a b11 = cVar.b(descriptor);
                    int i11 = 1;
                    if (b11.k()) {
                        obj = b11.p(descriptor, 0, Type.a.f32414a, null);
                    } else {
                        obj = null;
                        int i12 = 0;
                        while (i11 != 0) {
                            int w11 = b11.w(descriptor);
                            if (w11 == -1) {
                                i11 = 0;
                            } else if (w11 == 0) {
                                obj = b11.p(descriptor, 0, Type.a.f32414a, obj);
                                i12 |= 1;
                            } else {
                                throw new UnknownFieldException(w11);
                            }
                        }
                        i11 = i12;
                    }
                    b11.c(descriptor);
                    return new t(i11, (Type) obj, (q1) null);
                }

                public kotlinx.serialization.b<?>[] childSerializers() {
                    return new kotlinx.serialization.b[]{Type.a.f32414a};
                }

                public kotlinx.serialization.descriptors.f getDescriptor() {
                    return f32498b;
                }

                public kotlinx.serialization.b<?>[] typeParametersSerializers() {
                    return d0.a.a(this);
                }

                /* renamed from: a */
                public void serialize(kotlinx.serialization.encoding.d dVar, t tVar) {
                    kotlinx.serialization.descriptors.f descriptor = getDescriptor();
                    kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
                    t.a(tVar, b11, descriptor);
                    b11.c(descriptor);
                }
            }

            public static final class b {
                public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
                    this();
                }

                public final kotlinx.serialization.b<t> serializer() {
                    return a.f32497a;
                }

                public b() {
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public /* synthetic */ t(int i11, Type type, q1 q1Var) {
                super(i11, type, q1Var);
                if (1 != (i11 & 1)) {
                    h1.a(i11, 1, a.f32497a.getDescriptor());
                }
            }

            public static final void a(t tVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
                ServerMessage.a(tVar, bVar, fVar);
            }

            public t() {
                super(Type.WELCOME);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ServerMessage(int i11, Type type, q1 q1Var) {
            super((kotlin.jvm.internal.r) null);
            if (1 != (i11 & 1)) {
                h1.a(i11, 1, a.f32416a.getDescriptor());
            }
            this.f32404a = type;
        }

        public static final void a(ServerMessage serverMessage, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
            bVar.F(fVar, 0, Type.a.f32414a, serverMessage.f32404a);
        }

        public static /* synthetic */ void b() {
        }

        public ServerMessage(Type type) {
            super((kotlin.jvm.internal.r) null);
            this.f32404a = type;
        }

        public final Type a() {
            return this.f32404a;
        }
    }

    public /* synthetic */ SNSMessage(r rVar) {
        this();
    }

    public SNSMessage() {
    }
}
