package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.a;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.c;
import androidx.datastore.preferences.protobuf.f0;
import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.u;
import com.huawei.agconnect.config.impl.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public z0 unknownFields = z0.e();

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements g0 {
        public q<c> extensions = q.h();

        public q<c> C() {
            if (this.extensions.o()) {
                this.extensions = this.extensions.clone();
            }
            return this.extensions;
        }

        public /* bridge */ /* synthetic */ f0 getDefaultInstanceForType() {
            return GeneratedMessageLite.super.getDefaultInstanceForType();
        }

        public /* bridge */ /* synthetic */ f0.a newBuilderForType() {
            return GeneratedMessageLite.super.newBuilderForType();
        }

        public /* bridge */ /* synthetic */ f0.a toBuilder() {
            return GeneratedMessageLite.super.toBuilder();
        }
    }

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final byte[] asBytes;
        private final Class<?> messageClass;
        private final String messageClassName;

        public SerializedForm(f0 f0Var) {
            Class<?> cls = f0Var.getClass();
            this.messageClass = cls;
            this.messageClassName = cls.getName();
            this.asBytes = f0Var.toByteArray();
        }

        public static SerializedForm of(f0 f0Var) {
            return new SerializedForm(f0Var);
        }

        @Deprecated
        private Object readResolveFallback() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField("defaultInstance");
                declaredField.setAccessible(true);
                return ((f0) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e11);
            } catch (NoSuchFieldException e12) {
                throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e12);
            } catch (SecurityException e13) {
                throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e13);
            } catch (IllegalAccessException e14) {
                throw new RuntimeException("Unable to call parsePartialFrom", e14);
            } catch (InvalidProtocolBufferException e15) {
                throw new RuntimeException("Unable to understand proto buffer", e15);
            }
        }

        private Class<?> resolveMessageClass() throws ClassNotFoundException {
            Class<?> cls = this.messageClass;
            return cls != null ? cls : Class.forName(this.messageClassName);
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                Field declaredField = resolveMessageClass().getDeclaredField(Utils.DEFAULT_NAME);
                declaredField.setAccessible(true);
                return ((f0) declaredField.get((Object) null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e11);
            } catch (NoSuchFieldException unused) {
                return readResolveFallback();
            } catch (SecurityException e12) {
                throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e12);
            } catch (IllegalAccessException e13) {
                throw new RuntimeException("Unable to call parsePartialFrom", e13);
            } catch (InvalidProtocolBufferException e14) {
                throw new RuntimeException("Unable to understand proto buffer", e14);
            }
        }
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public final MessageType f9004b;

        /* renamed from: c  reason: collision with root package name */
        public MessageType f9005c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f9006d = false;

        public a(MessageType messagetype) {
            this.f9004b = messagetype;
            this.f9005c = (GeneratedMessageLite) messagetype.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* renamed from: n */
        public final MessageType build() {
            MessageType o11 = buildPartial();
            if (o11.isInitialized()) {
                return o11;
            }
            throw AbstractMessageLite.Builder.m(o11);
        }

        /* renamed from: o */
        public MessageType buildPartial() {
            if (this.f9006d) {
                return this.f9005c;
            }
            this.f9005c.u();
            this.f9006d = true;
            return this.f9005c;
        }

        /* renamed from: p */
        public BuilderType e() {
            BuilderType w11 = getDefaultInstanceForType().newBuilderForType();
            w11.u(buildPartial());
            return w11;
        }

        public void q() {
            if (this.f9006d) {
                MessageType messagetype = (GeneratedMessageLite) this.f9005c.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                x(messagetype, this.f9005c);
                this.f9005c = messagetype;
                this.f9006d = false;
            }
        }

        /* renamed from: r */
        public MessageType getDefaultInstanceForType() {
            return this.f9004b;
        }

        /* renamed from: s */
        public BuilderType g(MessageType messagetype) {
            return u(messagetype);
        }

        /* renamed from: t */
        public BuilderType i(g gVar, l lVar) throws IOException {
            q();
            try {
                p0.a().e(this.f9005c).b(this.f9005c, h.h(gVar), lVar);
                return this;
            } catch (RuntimeException e11) {
                if (e11.getCause() instanceof IOException) {
                    throw ((IOException) e11.getCause());
                }
                throw e11;
            }
        }

        public BuilderType u(MessageType messagetype) {
            q();
            x(this.f9005c, messagetype);
            return this;
        }

        /* renamed from: v */
        public BuilderType l(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            return w(bArr, i11, i12, l.b());
        }

        public BuilderType w(byte[] bArr, int i11, int i12, l lVar) throws InvalidProtocolBufferException {
            q();
            try {
                p0.a().e(this.f9005c).c(this.f9005c, bArr, i11, i11 + i12, new c.b(lVar));
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } catch (IOException e12) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e12);
            }
        }

        public final void x(MessageType messagetype, MessageType messagetype2) {
            p0.a().e(messagetype).mergeFrom(messagetype, messagetype2);
        }
    }

    public static class b<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: b  reason: collision with root package name */
        public final T f9007b;

        public b(T t11) {
            this.f9007b = t11;
        }

        /* renamed from: g */
        public T a(g gVar, l lVar) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.z(this.f9007b, gVar, lVar);
        }
    }

    public static final class c implements q.b<c> {

        /* renamed from: b  reason: collision with root package name */
        public final u.d<?> f9008b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9009c;

        /* renamed from: d  reason: collision with root package name */
        public final WireFormat.FieldType f9010d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f9011e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f9012f;

        /* renamed from: a */
        public int compareTo(c cVar) {
            return this.f9009c - cVar.f9009c;
        }

        public u.d<?> b() {
            return this.f9008b;
        }

        public f0.a d(f0.a aVar, f0 f0Var) {
            return ((a) aVar).u((GeneratedMessageLite) f0Var);
        }

        public WireFormat.JavaType getLiteJavaType() {
            return this.f9010d.getJavaType();
        }

        public WireFormat.FieldType getLiteType() {
            return this.f9010d;
        }

        public int getNumber() {
            return this.f9009c;
        }

        public boolean isPacked() {
            return this.f9012f;
        }

        public boolean isRepeated() {
            return this.f9011e;
        }
    }

    public static class d<ContainingType extends f0, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final f0 f9013a;

        /* renamed from: b  reason: collision with root package name */
        public final c f9014b;

        public WireFormat.FieldType a() {
            return this.f9014b.getLiteType();
        }

        public f0 b() {
            return this.f9013a;
        }

        public int c() {
            return this.f9014b.getNumber();
        }

        public boolean d() {
            return this.f9014b.f9011e;
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> void A(Class<T> cls, T t11) {
        defaultInstanceMap.put(cls, t11);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T k(T t11) throws InvalidProtocolBufferException {
        if (t11 == null || t11.isInitialized()) {
            return t11;
        }
        throw t11.g().asInvalidProtocolBufferException().setUnfinishedMessage(t11);
    }

    public static <E> u.i<E> p() {
        return q0.c();
    }

    public static <T extends GeneratedMessageLite<?, ?>> T q(Class<T> cls) {
        T t11 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
        if (t11 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t11 = (GeneratedMessageLite) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e11) {
                throw new IllegalStateException("Class initialization cannot fail.", e11);
            }
        }
        if (t11 == null) {
            t11 = ((GeneratedMessageLite) c1.j(cls)).getDefaultInstanceForType();
            if (t11 != null) {
                defaultInstanceMap.put(cls, t11);
            } else {
                throw new IllegalStateException();
            }
        }
        return t11;
    }

    static Object s(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e11);
        } catch (InvocationTargetException e12) {
            Throwable cause = e12.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean t(T t11, boolean z11) {
        byte byteValue = ((Byte) t11.m(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean isInitialized = p0.a().e(t11).isInitialized(t11);
        if (z11) {
            t11.n(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, isInitialized ? t11 : null);
        }
        return isInitialized;
    }

    public static <E> u.i<E> v(u.i<E> iVar) {
        int size = iVar.size();
        return iVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static Object x(f0 f0Var, String str, Object[] objArr) {
        return new r0(f0Var, str, objArr);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T y(T t11, InputStream inputStream) throws InvalidProtocolBufferException {
        return k(z(t11, g.f(inputStream), l.b()));
    }

    public static <T extends GeneratedMessageLite<T, ?>> T z(T t11, g gVar, l lVar) throws InvalidProtocolBufferException {
        T t12 = (GeneratedMessageLite) t11.m(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            t0 e11 = p0.a().e(t12);
            e11.b(t12, h.h(gVar), lVar);
            e11.makeImmutable(t12);
            return t12;
        } catch (IOException e12) {
            if (e12.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e12.getCause());
            }
            throw new InvalidProtocolBufferException(e12.getMessage()).setUnfinishedMessage(t12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e13.getCause());
            }
            throw e13;
        }
    }

    /* renamed from: B */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (a) m(MethodToInvoke.NEW_BUILDER);
        buildertype.u(this);
        return buildertype;
    }

    public void b(CodedOutputStream codedOutputStream) throws IOException {
        p0.a().e(this).a(this, i.g(codedOutputStream));
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.memoizedSerializedSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return p0.a().e(this).equals(this, (GeneratedMessageLite) obj);
    }

    public final n0<MessageType> getParserForType() {
        return (n0) m(MethodToInvoke.GET_PARSER);
    }

    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = p0.a().e(this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: package-private */
    public void h(int i11) {
        this.memoizedSerializedSize = i11;
    }

    public int hashCode() {
        int i11 = this.memoizedHashCode;
        if (i11 != 0) {
            return i11;
        }
        int hashCode = p0.a().e(this).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public final boolean isInitialized() {
        return t(this, true);
    }

    /* access modifiers changed from: package-private */
    public Object j() throws Exception {
        return m(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType l() {
        return (a) m(MethodToInvoke.NEW_BUILDER);
    }

    public Object m(MethodToInvoke methodToInvoke) {
        return o(methodToInvoke, (Object) null, (Object) null);
    }

    public Object n(MethodToInvoke methodToInvoke, Object obj) {
        return o(methodToInvoke, obj, (Object) null);
    }

    public abstract Object o(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    /* renamed from: r */
    public final MessageType getDefaultInstanceForType() {
        return (GeneratedMessageLite) m(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    public String toString() {
        return h0.e(this, super.toString());
    }

    public void u() {
        p0.a().e(this).makeImmutable(this);
    }

    /* renamed from: w */
    public final BuilderType newBuilderForType() {
        return (a) m(MethodToInvoke.NEW_BUILDER);
    }
}
