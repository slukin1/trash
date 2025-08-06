package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.support.springfox.SwaggerJsonSerializer;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import d2.d;
import h2.b;
import h2.f;
import h2.g;
import h2.h;
import h2.k;
import h2.o;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Clob;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.xml.datatype.XMLGregorianCalendar;

public class SerializeConfig {

    /* renamed from: g  reason: collision with root package name */
    public static final SerializeConfig f14295g = new SerializeConfig();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f14296h = false;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f14297i = false;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f14298j = false;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f14299k = false;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f14300l = false;

    /* renamed from: a  reason: collision with root package name */
    public boolean f14301a;

    /* renamed from: b  reason: collision with root package name */
    public ASMSerializerFactory f14302b;

    /* renamed from: c  reason: collision with root package name */
    public String f14303c;

    /* renamed from: d  reason: collision with root package name */
    public PropertyNamingStrategy f14304d;

    /* renamed from: e  reason: collision with root package name */
    public final IdentityHashMap<Type, k> f14305e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f14306f;

    public SerializeConfig() {
        this(1024);
    }

    public static SerializeConfig d() {
        return f14295g;
    }

    public final h a(o oVar) throws Exception {
        h z11 = this.f14302b.z(oVar);
        int i11 = 0;
        while (true) {
            f[] fVarArr = z11.f15921k;
            if (i11 >= fVarArr.length) {
                return z11;
            }
            Class<?> cls = fVarArr[i11].f15904b.f15966f;
            if (cls.isEnum() && !(e(cls) instanceof EnumSerializer)) {
                z11.f14315i = false;
            }
            i11++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x0102 A[SYNTHETIC, Splitter:B:84:0x0102] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h2.k b(h2.o r14) {
        /*
            r13 = this;
            d2.d r0 = r14.f15930d
            r1 = 0
            if (r0 == 0) goto L_0x003c
            java.lang.Class r2 = r0.serializer()
            java.lang.Class<java.lang.Void> r3 = java.lang.Void.class
            if (r2 == r3) goto L_0x0018
            java.lang.Object r2 = r2.newInstance()     // Catch:{ all -> 0x0018 }
            boolean r3 = r2 instanceof h2.k     // Catch:{ all -> 0x0018 }
            if (r3 == 0) goto L_0x0018
            h2.k r2 = (h2.k) r2     // Catch:{ all -> 0x0018 }
            return r2
        L_0x0018:
            boolean r2 = r0.asm()
            if (r2 != 0) goto L_0x0020
            r13.f14301a = r1
        L_0x0020:
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r0.serialzeFeatures()
            int r2 = r0.length
            r3 = r1
        L_0x0026:
            if (r3 >= r2) goto L_0x003c
            r4 = r0[r3]
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r5 == r4) goto L_0x003a
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r5 == r4) goto L_0x003a
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r5 != r4) goto L_0x0037
            goto L_0x003a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x003a:
            r13.f14301a = r1
        L_0x003c:
            java.lang.Class<?> r0 = r14.f15927a
            int r2 = r0.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)
            if (r2 != 0) goto L_0x004e
            h2.h r0 = new h2.h
            r0.<init>((h2.o) r14)
            return r0
        L_0x004e:
            boolean r2 = r13.f14301a
            r3 = 1
            if (r2 == 0) goto L_0x0059
            boolean r2 = r13.f14306f
            if (r2 != 0) goto L_0x0059
            r2 = r3
            goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            if (r2 == 0) goto L_0x0066
            com.alibaba.fastjson.serializer.ASMSerializerFactory r4 = r13.f14302b
            com.alibaba.fastjson.util.ASMClassLoader r4 = r4.f14234a
            boolean r4 = r4.c(r0)
            if (r4 != 0) goto L_0x006e
        L_0x0066:
            java.lang.Class<java.io.Serializable> r4 = java.io.Serializable.class
            if (r0 == r4) goto L_0x006e
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            if (r0 != r4) goto L_0x006f
        L_0x006e:
            r2 = r1
        L_0x006f:
            if (r2 == 0) goto L_0x007c
            java.lang.String r4 = r0.getSimpleName()
            boolean r4 = com.alibaba.fastjson.util.ASMUtils.a(r4)
            if (r4 != 0) goto L_0x007c
            r2 = r1
        L_0x007c:
            if (r2 == 0) goto L_0x00ff
            i2.a[] r4 = r14.f15931e
            int r5 = r4.length
            r6 = r1
        L_0x0082:
            if (r6 >= r5) goto L_0x00ff
            r7 = r4[r6]
            java.lang.reflect.Field r8 = r7.f15964d
            if (r8 == 0) goto L_0x0098
            java.lang.Class r8 = r8.getType()
            java.lang.Class<?> r9 = r7.f15966f
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0098
            goto L_0x0100
        L_0x0098:
            java.lang.reflect.Method r8 = r7.f15963c
            if (r8 == 0) goto L_0x00a9
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<?> r10 = r7.f15966f
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00a9
            goto L_0x0100
        L_0x00a9:
            d2.b r7 = r7.e()
            if (r7 != 0) goto L_0x00b0
            goto L_0x00fc
        L_0x00b0:
            java.lang.String r9 = r7.name()
            boolean r9 = com.alibaba.fastjson.util.ASMUtils.a(r9)
            if (r9 == 0) goto L_0x0100
            java.lang.String r9 = r7.format()
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0100
            boolean r9 = r7.jsonDirect()
            if (r9 != 0) goto L_0x0100
            java.lang.Class r9 = r7.serializeUsing()
            java.lang.Class<java.lang.Void> r10 = java.lang.Void.class
            if (r9 != r10) goto L_0x0100
            boolean r9 = r7.unwrapped()
            if (r9 == 0) goto L_0x00d9
            goto L_0x0100
        L_0x00d9:
            com.alibaba.fastjson.serializer.SerializerFeature[] r7 = r7.serialzeFeatures()
            int r9 = r7.length
            r10 = r1
        L_0x00df:
            if (r10 >= r9) goto L_0x00f4
            r11 = r7[r10]
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringValueAsString
            if (r12 == r11) goto L_0x00f3
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString
            if (r12 == r11) goto L_0x00f3
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue
            if (r12 != r11) goto L_0x00f0
            goto L_0x00f3
        L_0x00f0:
            int r10 = r10 + 1
            goto L_0x00df
        L_0x00f3:
            r2 = r1
        L_0x00f4:
            boolean r7 = com.alibaba.fastjson.util.TypeUtils.O(r8)
            if (r7 == 0) goto L_0x00fc
            r1 = r3
            goto L_0x0100
        L_0x00fc:
            int r6 = r6 + 1
            goto L_0x0082
        L_0x00ff:
            r1 = r2
        L_0x0100:
            if (r1 == 0) goto L_0x0121
            h2.h r0 = r13.a(r14)     // Catch:{ ClassCastException | ClassFormatError | ClassNotFoundException -> 0x0121, all -> 0x0109 }
            if (r0 == 0) goto L_0x0121
            return r0
        L_0x0109:
            r14 = move-exception
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "create asm serializer error, class "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0, r14)
            throw r1
        L_0x0121:
            h2.h r0 = new h2.h
            r0.<init>((h2.o) r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeConfig.b(h2.o):h2.k");
    }

    public final k c(Class<?> cls) {
        o c11 = TypeUtils.c(cls, (Map<String, String>) null, this.f14304d, this.f14306f);
        if (c11.f15931e.length != 0 || !Iterable.class.isAssignableFrom(cls)) {
            return b(c11);
        }
        return MiscCodec.f14289a;
    }

    public k e(Class<?> cls) {
        return f(cls, true);
    }

    public final k f(Class<?> cls, boolean z11) {
        ClassLoader classLoader;
        Class<b> cls2 = b.class;
        k b11 = this.f14305e.b(cls);
        if (b11 == null) {
            try {
                for (b next : ServiceLoader.a(cls2, Thread.currentThread().getContextClassLoader())) {
                    if (next instanceof b) {
                        b bVar = next;
                        for (Type g11 : bVar.a()) {
                            g(g11, bVar);
                        }
                    }
                }
            } catch (ClassCastException unused) {
            }
            b11 = this.f14305e.b(cls);
        }
        if (b11 == null && (classLoader = JSON.class.getClassLoader()) != Thread.currentThread().getContextClassLoader()) {
            try {
                for (b next2 : ServiceLoader.a(cls2, classLoader)) {
                    if (next2 instanceof b) {
                        b bVar2 = next2;
                        for (Type g12 : bVar2.a()) {
                            g(g12, bVar2);
                        }
                    }
                }
            } catch (ClassCastException unused2) {
            }
            b11 = this.f14305e.b(cls);
        }
        if (b11 != null) {
            return b11;
        }
        String name = cls.getName();
        if (Map.class.isAssignableFrom(cls)) {
            g(cls, MapSerializer.f14288j);
        } else if (List.class.isAssignableFrom(cls)) {
            g(cls, ListSerializer.f14286a);
        } else if (Collection.class.isAssignableFrom(cls)) {
            g(cls, CollectionCodec.f14264a);
        } else if (Date.class.isAssignableFrom(cls)) {
            g(cls, DateCodec.f14265a);
        } else if (a.class.isAssignableFrom(cls)) {
            g(cls, JSONAwareSerializer.f14274a);
        } else if (g.class.isAssignableFrom(cls)) {
            g(cls, JSONSerializableSerializer.f14275a);
        } else if (c.class.isAssignableFrom(cls)) {
            g(cls, MiscCodec.f14289a);
        } else if (cls.isEnum() || (cls.getSuperclass() != null && cls.getSuperclass().isEnum())) {
            d dVar = (d) cls.getAnnotation(d.class);
            if (dVar == null || !dVar.serializeEnumAsJavaBean()) {
                g(cls, EnumSerializer.f14268a);
            } else {
                g(cls, c(cls));
            }
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            g(cls, new h2.a(componentType, e(componentType)));
        } else if (Throwable.class.isAssignableFrom(cls)) {
            o b12 = TypeUtils.b(cls, (Map<String, String>) null, this.f14304d);
            b12.f15933g |= SerializerFeature.WriteClassName.mask;
            g(cls, new h(b12));
        } else if (TimeZone.class.isAssignableFrom(cls) || Map.Entry.class.isAssignableFrom(cls)) {
            g(cls, MiscCodec.f14289a);
        } else if (Appendable.class.isAssignableFrom(cls)) {
            g(cls, AppendableSerializer.f14251a);
        } else if (Charset.class.isAssignableFrom(cls)) {
            g(cls, ToStringSerializer.f14337a);
        } else if (Enumeration.class.isAssignableFrom(cls)) {
            g(cls, EnumerationSerializer.f14269a);
        } else if (Calendar.class.isAssignableFrom(cls) || XMLGregorianCalendar.class.isAssignableFrom(cls)) {
            g(cls, CalendarCodec.f14260b);
        } else if (Clob.class.isAssignableFrom(cls)) {
            g(cls, ClobSeriliazer.f14263a);
        } else if (TypeUtils.T(cls)) {
            g(cls, ToStringSerializer.f14337a);
        } else if (Iterator.class.isAssignableFrom(cls)) {
            g(cls, MiscCodec.f14289a);
        } else if (!name.startsWith("java.awt.") || !AwtCodec.k(cls)) {
            if (!f14297i && (name.startsWith("java.time.") || name.startsWith("java.util.Optional") || name.equals("java.util.concurrent.atomic.LongAdder") || name.equals("java.util.concurrent.atomic.DoubleAdder"))) {
                try {
                    Class<?> cls3 = Class.forName("java.time.LocalDateTime");
                    Jdk8DateCodec jdk8DateCodec = Jdk8DateCodec.f14197a;
                    g(cls3, jdk8DateCodec);
                    g(Class.forName("java.time.LocalDate"), jdk8DateCodec);
                    g(Class.forName("java.time.LocalTime"), jdk8DateCodec);
                    g(Class.forName("java.time.ZonedDateTime"), jdk8DateCodec);
                    g(Class.forName("java.time.OffsetDateTime"), jdk8DateCodec);
                    g(Class.forName("java.time.OffsetTime"), jdk8DateCodec);
                    g(Class.forName("java.time.ZoneOffset"), jdk8DateCodec);
                    g(Class.forName("java.time.ZoneRegion"), jdk8DateCodec);
                    g(Class.forName("java.time.Period"), jdk8DateCodec);
                    g(Class.forName("java.time.Duration"), jdk8DateCodec);
                    g(Class.forName("java.time.Instant"), jdk8DateCodec);
                    g(Class.forName("java.util.Optional"), OptionalCodec.f14219a);
                    g(Class.forName("java.util.OptionalDouble"), OptionalCodec.f14219a);
                    g(Class.forName("java.util.OptionalInt"), OptionalCodec.f14219a);
                    g(Class.forName("java.util.OptionalLong"), OptionalCodec.f14219a);
                    Class<?> cls4 = Class.forName("java.util.concurrent.atomic.LongAdder");
                    AdderSerializer adderSerializer = AdderSerializer.f14246a;
                    g(cls4, adderSerializer);
                    g(Class.forName("java.util.concurrent.atomic.DoubleAdder"), adderSerializer);
                    k b13 = this.f14305e.b(cls);
                    if (b13 != null) {
                        return b13;
                    }
                } catch (Throwable unused3) {
                    f14297i = true;
                }
            }
            if (!f14298j && name.startsWith("oracle.sql.")) {
                try {
                    Class<?> cls5 = Class.forName("oracle.sql.DATE");
                    DateCodec dateCodec = DateCodec.f14265a;
                    g(cls5, dateCodec);
                    g(Class.forName("oracle.sql.TIMESTAMP"), dateCodec);
                    k b14 = this.f14305e.b(cls);
                    if (b14 != null) {
                        return b14;
                    }
                } catch (Throwable unused4) {
                    f14298j = true;
                }
            }
            if (!f14299k && name.equals("springfox.documentation.spring.web.json.Json")) {
                try {
                    g(Class.forName("springfox.documentation.spring.web.json.Json"), SwaggerJsonSerializer.f14379a);
                    k b15 = this.f14305e.b(cls);
                    if (b15 != null) {
                        return b15;
                    }
                } catch (ClassNotFoundException unused5) {
                    f14299k = true;
                }
            }
            if (!f14300l && name.startsWith("com.google.common.collect.")) {
                try {
                    g(Class.forName("com.google.common.collect.HashMultimap"), GuavaCodec.f14272a);
                    g(Class.forName("com.google.common.collect.LinkedListMultimap"), GuavaCodec.f14272a);
                    g(Class.forName("com.google.common.collect.ArrayListMultimap"), GuavaCodec.f14272a);
                    g(Class.forName("com.google.common.collect.TreeMultimap"), GuavaCodec.f14272a);
                    k b16 = this.f14305e.b(cls);
                    if (b16 != null) {
                        return b16;
                    }
                } catch (ClassNotFoundException unused6) {
                    f14300l = true;
                }
            }
            if (name.equals("net.sf.json.JSONNull")) {
                try {
                    g(Class.forName("net.sf.json.JSONNull"), MiscCodec.f14289a);
                } catch (ClassNotFoundException unused7) {
                }
                k b17 = this.f14305e.b(cls);
                if (b17 != null) {
                    return b17;
                }
            }
            Class[] interfaces = cls.getInterfaces();
            if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
                return AnnotationSerializer.f14250a;
            }
            if (TypeUtils.U(cls)) {
                k e11 = e(cls.getSuperclass());
                g(cls, e11);
                return e11;
            } else if (z11) {
                g(cls, c(cls));
            }
        } else {
            if (!f14296h) {
                try {
                    Class<?> cls6 = Class.forName("java.awt.Color");
                    AwtCodec awtCodec = AwtCodec.f14253a;
                    g(cls6, awtCodec);
                    g(Class.forName("java.awt.Font"), awtCodec);
                    g(Class.forName("java.awt.Point"), awtCodec);
                    g(Class.forName("java.awt.Rectangle"), awtCodec);
                } catch (Throwable unused8) {
                    f14296h = true;
                }
            }
            return AwtCodec.f14253a;
        }
        return this.f14305e.b(cls);
    }

    public boolean g(Type type, k kVar) {
        return this.f14305e.c(type, kVar);
    }

    public SerializeConfig(int i11) {
        this(i11, false);
    }

    public SerializeConfig(int i11, boolean z11) {
        this.f14301a = !ASMUtils.f14383b;
        this.f14303c = JSON.DEFAULT_TYPE_KEY;
        this.f14306f = z11;
        this.f14305e = new IdentityHashMap<>(1024);
        try {
            if (this.f14301a) {
                this.f14302b = new ASMSerializerFactory();
            }
        } catch (Throwable unused) {
            this.f14301a = false;
        }
        g(Boolean.class, BooleanCodec.f14259a);
        g(Character.class, CharacterCodec.f14262a);
        g(Byte.class, IntegerCodec.f14273a);
        g(Short.class, IntegerCodec.f14273a);
        g(Integer.class, IntegerCodec.f14273a);
        g(Long.class, LongCodec.f14287a);
        g(Float.class, FloatCodec.f14270b);
        g(Double.class, DoubleSerializer.f14266b);
        g(BigDecimal.class, BigDecimalCodec.f14257a);
        g(BigInteger.class, BigIntegerCodec.f14258a);
        g(String.class, StringCodec.f14336a);
        g(byte[].class, PrimitiveArraySerializer.f14293a);
        g(short[].class, PrimitiveArraySerializer.f14293a);
        g(int[].class, PrimitiveArraySerializer.f14293a);
        g(long[].class, PrimitiveArraySerializer.f14293a);
        g(float[].class, PrimitiveArraySerializer.f14293a);
        g(double[].class, PrimitiveArraySerializer.f14293a);
        g(boolean[].class, PrimitiveArraySerializer.f14293a);
        g(char[].class, PrimitiveArraySerializer.f14293a);
        g(Object[].class, ObjectArrayCodec.f14292a);
        MiscCodec miscCodec = MiscCodec.f14289a;
        g(Class.class, miscCodec);
        g(SimpleDateFormat.class, miscCodec);
        g(Currency.class, new MiscCodec());
        g(TimeZone.class, miscCodec);
        g(InetAddress.class, miscCodec);
        g(Inet4Address.class, miscCodec);
        g(Inet6Address.class, miscCodec);
        g(InetSocketAddress.class, miscCodec);
        g(File.class, miscCodec);
        AppendableSerializer appendableSerializer = AppendableSerializer.f14251a;
        g(Appendable.class, appendableSerializer);
        g(StringBuffer.class, appendableSerializer);
        g(StringBuilder.class, appendableSerializer);
        ToStringSerializer toStringSerializer = ToStringSerializer.f14337a;
        g(Charset.class, toStringSerializer);
        g(Pattern.class, toStringSerializer);
        g(Locale.class, toStringSerializer);
        g(URI.class, toStringSerializer);
        g(URL.class, toStringSerializer);
        g(UUID.class, toStringSerializer);
        AtomicCodec atomicCodec = AtomicCodec.f14252a;
        g(AtomicBoolean.class, atomicCodec);
        g(AtomicInteger.class, atomicCodec);
        g(AtomicLong.class, atomicCodec);
        ReferenceCodec referenceCodec = ReferenceCodec.f14294a;
        g(AtomicReference.class, referenceCodec);
        g(AtomicIntegerArray.class, atomicCodec);
        g(AtomicLongArray.class, atomicCodec);
        g(WeakReference.class, referenceCodec);
        g(SoftReference.class, referenceCodec);
    }
}
