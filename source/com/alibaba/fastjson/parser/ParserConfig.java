package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.deserializer.JSONPDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec;
import com.alibaba.fastjson.parser.deserializer.MapDeserializer;
import com.alibaba.fastjson.parser.deserializer.NumberDeserializer;
import com.alibaba.fastjson.parser.deserializer.OptionalCodec;
import com.alibaba.fastjson.parser.deserializer.SqlDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.StackTraceElementDeserializer;
import com.alibaba.fastjson.parser.deserializer.TimeDeserializer;
import com.alibaba.fastjson.serializer.AtomicCodec;
import com.alibaba.fastjson.serializer.AwtCodec;
import com.alibaba.fastjson.serializer.BigDecimalCodec;
import com.alibaba.fastjson.serializer.BigIntegerCodec;
import com.alibaba.fastjson.serializer.BooleanCodec;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.CharArrayCodec;
import com.alibaba.fastjson.serializer.CharacterCodec;
import com.alibaba.fastjson.serializer.CollectionCodec;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.FloatCodec;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.MiscCodec;
import com.alibaba.fastjson.serializer.ObjectArrayCodec;
import com.alibaba.fastjson.serializer.ReferenceCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.IdentityHashMap;
import com.alibaba.fastjson.util.ServiceLoader;
import com.alibaba.fastjson.util.TypeUtils;
import com.xiaomi.mipush.sdk.Constants;
import f2.g;
import g2.a;
import g2.c;
import g2.d;
import g2.e;
import g2.i;
import g2.k;
import g2.l;
import g2.n;
import g2.o;
import g2.q;
import i2.b;
import java.io.Closeable;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.sql.DataSource;
import javax.xml.datatype.XMLGregorianCalendar;

public class ParserConfig {

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f14177m = q(IOUtils.k("fastjson.parser.deny"));

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f14178n;

    /* renamed from: o  reason: collision with root package name */
    public static final boolean f14179o = "true".equals(IOUtils.k("fastjson.parser.autoTypeSupport"));

    /* renamed from: p  reason: collision with root package name */
    public static ParserConfig f14180p = new ParserConfig();

    /* renamed from: q  reason: collision with root package name */
    public static boolean f14181q = false;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f14182r = false;

    /* renamed from: a  reason: collision with root package name */
    public final IdentityHashMap<Type, l> f14183a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14184b;

    /* renamed from: c  reason: collision with root package name */
    public final g f14185c;

    /* renamed from: d  reason: collision with root package name */
    public PropertyNamingStrategy f14186d;

    /* renamed from: e  reason: collision with root package name */
    public ClassLoader f14187e;

    /* renamed from: f  reason: collision with root package name */
    public a f14188f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14189g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f14190h;

    /* renamed from: i  reason: collision with root package name */
    public String[] f14191i;

    /* renamed from: j  reason: collision with root package name */
    public int f14192j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f14193k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f14194l;

    static {
        String[] q11 = q(IOUtils.k("fastjson.parser.autoTypeAccept"));
        if (q11 == null) {
            q11 = new String[0];
        }
        f14178n = q11;
    }

    public ParserConfig() {
        this(false);
    }

    public static Field l(String str, Map<String, Field> map) {
        char charAt;
        Field field = map.get(str);
        if (field == null) {
            field = map.get("_" + str);
        }
        if (field == null) {
            field = map.get("m_" + str);
        }
        if (field != null || (charAt = str.charAt(0)) < 'a' || charAt > 'z') {
            return field;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = (char) (charArray[0] - ' ');
        return map.get(new String(charArray));
    }

    public static ParserConfig m() {
        return f14180p;
    }

    public static boolean n(Class<?> cls) {
        return cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class || cls == Timestamp.class || cls.isEnum();
    }

    public static void o(Class<?> cls, Map<String, Field> map) {
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!map.containsKey(name)) {
                map.put(name, field);
            }
        }
        if (cls.getSuperclass() != null && cls.getSuperclass() != Object.class) {
            o(cls.getSuperclass(), map);
        }
    }

    public static String[] q(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public void a(String str) {
        if (str != null && str.length() != 0) {
            String[] strArr = this.f14191i;
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (!str.equals(strArr[i11])) {
                    i11++;
                } else {
                    return;
                }
            }
            String[] strArr2 = this.f14191i;
            int length2 = strArr2.length + 1;
            String[] strArr3 = new String[length2];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            strArr3[length2 - 1] = str;
            this.f14191i = strArr3;
        }
    }

    public void b(String str) {
        if (str != null && str.length() != 0) {
            String[] strArr = this.f14190h;
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                if (!str.equals(strArr[i11])) {
                    i11++;
                } else {
                    return;
                }
            }
            String[] strArr2 = this.f14190h;
            int length2 = strArr2.length + 1;
            String[] strArr3 = new String[length2];
            System.arraycopy(strArr2, 0, strArr3, 0, strArr2.length);
            strArr3[length2 - 1] = str;
            this.f14190h = strArr3;
        }
    }

    public final void c(String[] strArr) {
        if (strArr != null) {
            for (String a11 : strArr) {
                a(a11);
            }
        }
    }

    public final void d(String[] strArr) {
        if (strArr != null) {
            for (String b11 : strArr) {
                b(b11);
            }
        }
    }

    public Class<?> e(String str, Class<?> cls) {
        if (str == null) {
            return null;
        }
        if (str.length() < this.f14192j) {
            String replace = str.replace(DecodedChar.FNC1, '.');
            int i11 = 0;
            if (this.f14189g || cls != null) {
                int i12 = 0;
                while (true) {
                    String[] strArr = this.f14191i;
                    if (i12 >= strArr.length) {
                        int i13 = 0;
                        while (true) {
                            String[] strArr2 = this.f14190h;
                            if (i13 >= strArr2.length) {
                                break;
                            } else if (!replace.startsWith(strArr2[i13]) || TypeUtils.E(str) != null) {
                                i13++;
                            } else {
                                throw new JSONException("autoType is not support. " + str);
                            }
                        }
                    } else if (replace.startsWith(strArr[i12])) {
                        return TypeUtils.X(str, this.f14187e);
                    } else {
                        i12++;
                    }
                }
            }
            Class<?> E = TypeUtils.E(str);
            if (E == null) {
                E = this.f14183a.a(str);
            }
            if (E == null) {
                if (!this.f14189g) {
                    int i14 = 0;
                    while (true) {
                        String[] strArr3 = this.f14190h;
                        if (i14 >= strArr3.length) {
                            while (true) {
                                String[] strArr4 = this.f14191i;
                                if (i11 >= strArr4.length) {
                                    break;
                                } else if (replace.startsWith(strArr4[i11])) {
                                    Class<?> X = TypeUtils.X(str, this.f14187e);
                                    if (cls == null || !cls.isAssignableFrom(X)) {
                                        return X;
                                    }
                                    throw new JSONException("type not match. " + str + " -> " + cls.getName());
                                } else {
                                    i11++;
                                }
                            }
                        } else if (!replace.startsWith(strArr3[i14])) {
                            i14++;
                        } else {
                            throw new JSONException("autoType is not support. " + str);
                        }
                    }
                }
                if (this.f14189g || cls != null) {
                    E = TypeUtils.X(str, this.f14187e);
                }
                if (E != null) {
                    if (ClassLoader.class.isAssignableFrom(E) || DataSource.class.isAssignableFrom(E)) {
                        throw new JSONException("autoType is not support. " + str);
                    } else if (cls != null) {
                        if (cls.isAssignableFrom(E)) {
                            return E;
                        }
                        throw new JSONException("type not match. " + str + " -> " + cls.getName());
                    }
                }
                if (this.f14189g) {
                    return E;
                }
                throw new JSONException("autoType is not support. " + str);
            } else if (cls == null || cls.isAssignableFrom(E)) {
                return E;
            } else {
                throw new JSONException("type not match. " + str + " -> " + cls.getName());
            }
        } else {
            throw new JSONException("autoType is not support. " + str);
        }
    }

    public i f(ParserConfig parserConfig, b bVar, i2.a aVar) {
        Class<?> deserializeUsing;
        Class<?> cls = bVar.f15983a;
        Class<?> cls2 = aVar.f15966f;
        d2.b e11 = aVar.e();
        Class<?> cls3 = null;
        if (!(e11 == null || (deserializeUsing = e11.deserializeUsing()) == Void.class)) {
            cls3 = deserializeUsing;
        }
        if (cls3 == null && (cls2 == List.class || cls2 == ArrayList.class)) {
            return new g2.b(parserConfig, cls, aVar);
        }
        return new d(parserConfig, cls, aVar);
    }

    public l g(Class<?> cls, Type type) {
        d2.b e11;
        a aVar;
        boolean z11 = this.f14184b & (!this.f14193k);
        boolean z12 = false;
        if (z11) {
            d2.d dVar = (d2.d) cls.getAnnotation(d2.d.class);
            if (dVar != null) {
                Class<?> deserializer = dVar.deserializer();
                if (deserializer != Void.class) {
                    try {
                        Object newInstance = deserializer.newInstance();
                        if (newInstance instanceof l) {
                            return (l) newInstance;
                        }
                    } catch (Throwable unused) {
                    }
                }
                z11 = dVar.asm();
            }
            if (z11) {
                Class<?> e12 = b.e(dVar);
                if (e12 == null) {
                    e12 = cls;
                }
                while (true) {
                    if (Modifier.isPublic(e12.getModifiers())) {
                        e12 = e12.getSuperclass();
                        if (e12 != Object.class) {
                            if (e12 == null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                }
            }
        }
        if (cls.getTypeParameters().length != 0) {
            z11 = false;
        }
        if (z11 && (aVar = this.f14188f) != null && aVar.f15792a.c(cls)) {
            z11 = false;
        }
        if (z11) {
            z11 = ASMUtils.a(cls.getSimpleName());
        }
        if (z11) {
            if (cls.isInterface()) {
                z11 = false;
            }
            b b11 = b.b(cls, type, this.f14186d);
            if (z11 && b11.f15990h.length > 200) {
                z11 = false;
            }
            Constructor<?> constructor = b11.f15985c;
            if (z11 && constructor == null && !cls.isInterface()) {
                z11 = false;
            }
            i2.a[] aVarArr = b11.f15990h;
            int length = aVarArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                i2.a aVar2 = aVarArr[i11];
                if (!aVar2.f15969i) {
                    Class<?> cls2 = aVar2.f15966f;
                    if (!Modifier.isPublic(cls2.getModifiers()) || ((cls2.isMemberClass() && !Modifier.isStatic(cls2.getModifiers())) || ((aVar2.k() != null && !ASMUtils.a(aVar2.k().getName())) || (((e11 = aVar2.e()) != null && (!ASMUtils.a(e11.name()) || e11.format().length() != 0 || e11.deserializeUsing() != Void.class || e11.unwrapped())) || (cls2.isEnum() && !(j(cls2) instanceof e)))))) {
                        break;
                    }
                    i11++;
                } else {
                    break;
                }
            }
            z11 = false;
        }
        if (!z11 || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            z12 = z11;
        }
        if (!z12) {
            return new k(this, cls, type);
        }
        b b12 = b.b(cls, type, this.f14186d);
        try {
            return this.f14188f.v(this, b12);
        } catch (NoSuchMethodException unused2) {
            return new k(this, cls, type);
        } catch (JSONException unused3) {
            return new k(this, b12);
        } catch (Exception e13) {
            throw new JSONException("create asm deserializer error, " + cls.getName(), e13);
        }
    }

    public ClassLoader h() {
        return this.f14187e;
    }

    public l i(Class<?> cls, Type type) {
        l lVar;
        l lVar2;
        Class<?> mappingTo;
        l b11 = this.f14183a.b(type);
        if (b11 != null) {
            return b11;
        }
        if (type == null) {
            type = cls;
        }
        l b12 = this.f14183a.b(type);
        if (b12 != null) {
            return b12;
        }
        d2.d dVar = (d2.d) cls.getAnnotation(d2.d.class);
        if (dVar != null && (mappingTo = dVar.mappingTo()) != Void.class) {
            return i(mappingTo, mappingTo);
        }
        if ((type instanceof WildcardType) || (type instanceof TypeVariable) || (type instanceof ParameterizedType)) {
            b12 = this.f14183a.b(cls);
        }
        if (b12 != null) {
            return b12;
        }
        String replace = cls.getName().replace(DecodedChar.FNC1, '.');
        if (replace.startsWith("java.awt.") && AwtCodec.k(cls) && !f14181q) {
            try {
                IdentityHashMap<Type, l> identityHashMap = this.f14183a;
                Class<?> cls2 = Class.forName("java.awt.Point");
                AwtCodec awtCodec = AwtCodec.f14253a;
                identityHashMap.c(cls2, awtCodec);
                this.f14183a.c(Class.forName("java.awt.Font"), awtCodec);
                this.f14183a.c(Class.forName("java.awt.Rectangle"), awtCodec);
                this.f14183a.c(Class.forName("java.awt.Color"), awtCodec);
            } catch (Throwable unused) {
                f14181q = true;
            }
            b12 = AwtCodec.f14253a;
        }
        if (!f14182r) {
            try {
                if (replace.startsWith("java.time.")) {
                    IdentityHashMap<Type, l> identityHashMap2 = this.f14183a;
                    Class<?> cls3 = Class.forName("java.time.LocalDateTime");
                    Jdk8DateCodec jdk8DateCodec = Jdk8DateCodec.f14197a;
                    identityHashMap2.c(cls3, jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.LocalDate"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.LocalTime"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.ZonedDateTime"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.OffsetDateTime"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.OffsetTime"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.ZoneOffset"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.ZoneRegion"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.ZoneId"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.Period"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.Duration"), jdk8DateCodec);
                    this.f14183a.c(Class.forName("java.time.Instant"), jdk8DateCodec);
                    lVar2 = this.f14183a.b(cls);
                } else if (replace.startsWith("java.util.Optional")) {
                    this.f14183a.c(Class.forName("java.util.Optional"), OptionalCodec.f14219a);
                    this.f14183a.c(Class.forName("java.util.OptionalDouble"), OptionalCodec.f14219a);
                    this.f14183a.c(Class.forName("java.util.OptionalInt"), OptionalCodec.f14219a);
                    this.f14183a.c(Class.forName("java.util.OptionalLong"), OptionalCodec.f14219a);
                    lVar2 = this.f14183a.b(cls);
                }
                b12 = lVar2;
            } catch (Throwable unused2) {
                f14182r = true;
            }
        }
        if (replace.equals("java.nio.file.Path")) {
            this.f14183a.c(cls, MiscCodec.f14289a);
        }
        if (cls == Map.Entry.class) {
            this.f14183a.c(cls, MiscCodec.f14289a);
        }
        try {
            for (c next : ServiceLoader.a(c.class, Thread.currentThread().getContextClassLoader())) {
                for (Type c11 : next.a()) {
                    this.f14183a.c(c11, next);
                }
            }
        } catch (Exception unused3) {
        }
        if (b12 == null) {
            b12 = this.f14183a.b(type);
        }
        if (b12 != null) {
            return b12;
        }
        if (cls.isEnum()) {
            lVar = new e(cls);
        } else if (cls.isArray()) {
            lVar = ObjectArrayCodec.f14292a;
        } else if (cls == Set.class || cls == HashSet.class || cls == Collection.class || cls == List.class || cls == ArrayList.class) {
            lVar = CollectionCodec.f14264a;
        } else if (Collection.class.isAssignableFrom(cls)) {
            lVar = CollectionCodec.f14264a;
        } else if (Map.class.isAssignableFrom(cls)) {
            lVar = MapDeserializer.f14217a;
        } else if (Throwable.class.isAssignableFrom(cls)) {
            lVar = new q(this, cls);
        } else if (n.class.isAssignableFrom(cls)) {
            lVar = new o(cls);
        } else {
            lVar = g(cls, type);
        }
        p(type, lVar);
        return lVar;
    }

    public l j(Type type) {
        l b11 = this.f14183a.b(type);
        if (b11 != null) {
            return b11;
        }
        if (type instanceof Class) {
            return i((Class) type, type);
        }
        if (!(type instanceof ParameterizedType)) {
            return JavaObjectDeserializer.f14196a;
        }
        Type rawType = ((ParameterizedType) type).getRawType();
        if (rawType instanceof Class) {
            return i((Class) rawType, type);
        }
        return j(rawType);
    }

    public IdentityHashMap<Type, l> k() {
        return this.f14183a;
    }

    public void p(Type type, l lVar) {
        this.f14183a.c(type, lVar);
    }

    public ParserConfig(boolean z11) {
        this((a) null, (ClassLoader) null, z11);
    }

    public ParserConfig(a aVar, ClassLoader classLoader, boolean z11) {
        this.f14183a = new IdentityHashMap<>();
        boolean z12 = ASMUtils.f14383b;
        this.f14184b = !z12;
        this.f14185c = new g(4096);
        this.f14189g = f14179o;
        this.f14190h = "bsh,com.mchange,com.sun.,java.lang.Thread,java.net.Socket,java.rmi,javax.xml,org.apache.bcel,org.apache.commons.beanutils,org.apache.commons.collections.Transformer,org.apache.commons.collections.functors,org.apache.commons.collections4.comparators,org.apache.commons.fileupload,org.apache.myfaces.context.servlet,org.apache.tomcat,org.apache.wicket.util,org.apache.xalan,org.codehaus.groovy.runtime,org.hibernate,org.jboss,org.mozilla.javascript,org.python.core,org.springframework".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        this.f14191i = f14178n;
        this.f14192j = 256;
        this.f14194l = TypeUtils.f14428a;
        this.f14193k = z11;
        if (aVar == null && !z12) {
            if (classLoader == null) {
                try {
                    aVar = new a(new ASMClassLoader());
                } catch (ExceptionInInitializerError | NoClassDefFoundError | AccessControlException unused) {
                }
            } else {
                aVar = new a(classLoader);
            }
        }
        this.f14188f = aVar;
        if (aVar == null) {
            this.f14184b = false;
        }
        MiscCodec miscCodec = MiscCodec.f14289a;
        this.f14183a.c(SimpleDateFormat.class, miscCodec);
        this.f14183a.c(Timestamp.class, SqlDateDeserializer.f14221c);
        this.f14183a.c(java.sql.Date.class, SqlDateDeserializer.f14220b);
        this.f14183a.c(Time.class, TimeDeserializer.f14224a);
        this.f14183a.c(Date.class, DateCodec.f14265a);
        CalendarCodec calendarCodec = CalendarCodec.f14260b;
        this.f14183a.c(Calendar.class, calendarCodec);
        this.f14183a.c(XMLGregorianCalendar.class, calendarCodec);
        this.f14183a.c(JSONObject.class, MapDeserializer.f14217a);
        CollectionCodec collectionCodec = CollectionCodec.f14264a;
        this.f14183a.c(JSONArray.class, collectionCodec);
        this.f14183a.c(Map.class, MapDeserializer.f14217a);
        this.f14183a.c(HashMap.class, MapDeserializer.f14217a);
        this.f14183a.c(LinkedHashMap.class, MapDeserializer.f14217a);
        this.f14183a.c(TreeMap.class, MapDeserializer.f14217a);
        this.f14183a.c(ConcurrentMap.class, MapDeserializer.f14217a);
        this.f14183a.c(ConcurrentHashMap.class, MapDeserializer.f14217a);
        this.f14183a.c(Collection.class, collectionCodec);
        this.f14183a.c(List.class, collectionCodec);
        this.f14183a.c(ArrayList.class, collectionCodec);
        JavaObjectDeserializer javaObjectDeserializer = JavaObjectDeserializer.f14196a;
        this.f14183a.c(Object.class, javaObjectDeserializer);
        this.f14183a.c(String.class, StringCodec.f14336a);
        this.f14183a.c(StringBuffer.class, StringCodec.f14336a);
        this.f14183a.c(StringBuilder.class, StringCodec.f14336a);
        IdentityHashMap<Type, l> identityHashMap = this.f14183a;
        Class cls = Character.TYPE;
        CharacterCodec characterCodec = CharacterCodec.f14262a;
        identityHashMap.c(cls, characterCodec);
        this.f14183a.c(Character.class, characterCodec);
        IdentityHashMap<Type, l> identityHashMap2 = this.f14183a;
        Class cls2 = Byte.TYPE;
        NumberDeserializer numberDeserializer = NumberDeserializer.f14218a;
        identityHashMap2.c(cls2, numberDeserializer);
        this.f14183a.c(Byte.class, numberDeserializer);
        this.f14183a.c(Short.TYPE, numberDeserializer);
        this.f14183a.c(Short.class, numberDeserializer);
        this.f14183a.c(Integer.TYPE, IntegerCodec.f14273a);
        this.f14183a.c(Integer.class, IntegerCodec.f14273a);
        this.f14183a.c(Long.TYPE, LongCodec.f14287a);
        this.f14183a.c(Long.class, LongCodec.f14287a);
        this.f14183a.c(BigInteger.class, BigIntegerCodec.f14258a);
        this.f14183a.c(BigDecimal.class, BigDecimalCodec.f14257a);
        this.f14183a.c(Float.TYPE, FloatCodec.f14270b);
        this.f14183a.c(Float.class, FloatCodec.f14270b);
        this.f14183a.c(Double.TYPE, numberDeserializer);
        this.f14183a.c(Double.class, numberDeserializer);
        IdentityHashMap<Type, l> identityHashMap3 = this.f14183a;
        Class cls3 = Boolean.TYPE;
        BooleanCodec booleanCodec = BooleanCodec.f14259a;
        identityHashMap3.c(cls3, booleanCodec);
        this.f14183a.c(Boolean.class, booleanCodec);
        this.f14183a.c(Class.class, miscCodec);
        this.f14183a.c(char[].class, new CharArrayCodec());
        this.f14183a.c(AtomicBoolean.class, booleanCodec);
        this.f14183a.c(AtomicInteger.class, IntegerCodec.f14273a);
        this.f14183a.c(AtomicLong.class, LongCodec.f14287a);
        ReferenceCodec referenceCodec = ReferenceCodec.f14294a;
        this.f14183a.c(AtomicReference.class, referenceCodec);
        this.f14183a.c(WeakReference.class, referenceCodec);
        this.f14183a.c(SoftReference.class, referenceCodec);
        this.f14183a.c(UUID.class, miscCodec);
        this.f14183a.c(TimeZone.class, miscCodec);
        this.f14183a.c(Locale.class, miscCodec);
        this.f14183a.c(Currency.class, miscCodec);
        this.f14183a.c(InetAddress.class, miscCodec);
        this.f14183a.c(Inet4Address.class, miscCodec);
        this.f14183a.c(Inet6Address.class, miscCodec);
        this.f14183a.c(InetSocketAddress.class, miscCodec);
        this.f14183a.c(File.class, miscCodec);
        this.f14183a.c(URI.class, miscCodec);
        this.f14183a.c(URL.class, miscCodec);
        this.f14183a.c(Pattern.class, miscCodec);
        this.f14183a.c(Charset.class, miscCodec);
        this.f14183a.c(JSONPath.class, miscCodec);
        this.f14183a.c(Number.class, numberDeserializer);
        AtomicCodec atomicCodec = AtomicCodec.f14252a;
        this.f14183a.c(AtomicIntegerArray.class, atomicCodec);
        this.f14183a.c(AtomicLongArray.class, atomicCodec);
        this.f14183a.c(StackTraceElement.class, StackTraceElementDeserializer.f14223a);
        this.f14183a.c(Serializable.class, javaObjectDeserializer);
        this.f14183a.c(Cloneable.class, javaObjectDeserializer);
        this.f14183a.c(Comparable.class, javaObjectDeserializer);
        this.f14183a.c(Closeable.class, javaObjectDeserializer);
        this.f14183a.c(JSONPObject.class, new JSONPDeserializer());
        d(f14177m);
        c(f14178n);
    }
}
