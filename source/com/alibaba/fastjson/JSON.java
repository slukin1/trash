package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.sumsub.sns.internal.core.analytics.d;
import f2.a;
import f2.b;
import g2.g;
import g2.j;
import g2.m;
import h2.h;
import h2.k;
import h2.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public abstract class JSON implements c, a {
    public static int DEFAULT_GENERATE_FEATURE = 0;
    public static int DEFAULT_PARSER_FEATURE = ((((((((Feature.AutoCloseSource.getMask() | 0) | Feature.InternFieldNames.getMask()) | Feature.UseBigDecimal.getMask()) | Feature.AllowUnQuotedFieldNames.getMask()) | Feature.AllowSingleQuotes.getMask()) | Feature.AllowArbitraryCommas.getMask()) | Feature.SortFeidFastMatch.getMask()) | Feature.IgnoreNotMatch.getMask());
    public static String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String VERSION = "1.2.35";
    private static final ThreadLocal<byte[]> bytesLocal = new ThreadLocal<>();
    private static final ThreadLocal<char[]> charsLocal = new ThreadLocal<>();
    public static Locale defaultLocale = Locale.getDefault();
    public static TimeZone defaultTimeZone = TimeZone.getDefault();
    public static final p[] emptyFilters = new p[0];

    static {
        int mask = 0 | SerializerFeature.QuoteFieldNames.getMask() | SerializerFeature.SkipTransientField.getMask() | SerializerFeature.WriteEnumUsingName.getMask() | SerializerFeature.SortField.getMask();
        String k11 = IOUtils.k("fastjson.serializerFeatures.MapSortField");
        int mask2 = SerializerFeature.MapSortField.getMask();
        if ("true".equals(k11)) {
            mask |= mask2;
        } else if (d.f31895b.equals(k11)) {
            mask &= ~mask2;
        }
        DEFAULT_GENERATE_FEATURE = mask;
    }

    private static byte[] allocateBytes(int i11) {
        ThreadLocal<byte[]> threadLocal = bytesLocal;
        byte[] bArr = threadLocal.get();
        if (bArr != null) {
            return bArr.length < i11 ? new byte[i11] : bArr;
        }
        if (i11 > 65536) {
            return new byte[i11];
        }
        byte[] bArr2 = new byte[65536];
        threadLocal.set(bArr2);
        return bArr2;
    }

    private static char[] allocateChars(int i11) {
        ThreadLocal<char[]> threadLocal = charsLocal;
        char[] cArr = threadLocal.get();
        if (cArr != null) {
            return cArr.length < i11 ? new char[i11] : cArr;
        }
        if (i11 > 65536) {
            return new char[i11];
        }
        char[] cArr2 = new char[65536];
        threadLocal.set(cArr2);
        return cArr2;
    }

    public static <T> void handleResovleTask(a aVar, T t11) {
        aVar.x(t11);
    }

    public static Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static JSONArray parseArray(String str) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        a aVar = new a(str, ParserConfig.m());
        b bVar = aVar.f15701g;
        if (bVar.J() == 8) {
            bVar.nextToken();
        } else if (bVar.J() != 20) {
            jSONArray = new JSONArray();
            aVar.F(jSONArray);
            aVar.x(jSONArray);
        }
        aVar.close();
        return jSONArray;
    }

    public static JSONObject parseObject(String str, Feature... featureArr) {
        return (JSONObject) parse(str, featureArr);
    }

    public static void setDefaultTypeKey(String str) {
        DEFAULT_TYPE_KEY = str;
        ParserConfig.f14180p.f14185c.b(str, 0, str.length(), str.hashCode(), true);
    }

    public static Object toJSON(Object obj) {
        return toJSON(obj, SerializeConfig.f14295g);
    }

    public static byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj) {
        return toJSONString(obj, emptyFilters, new SerializerFeature[0]);
    }

    public static String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.f14295g, (p[]) null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, emptyFilters, (String) null, 0, serializerFeatureArr);
    }

    public static <T> T toJavaObject(JSON json, Class<T> cls) {
        return TypeUtils.d(json, cls, ParserConfig.m());
    }

    public static void writeJSONString(Writer writer, Object obj, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        writeJSONString(writer, obj, serializerFeatureArr);
    }

    public String toString() {
        return toJSONString();
    }

    public static Object parse(String str, int i11) {
        if (str == null) {
            return null;
        }
        a aVar = new a(str, ParserConfig.m(), i11);
        Object z11 = aVar.z();
        aVar.x(z11);
        aVar.close();
        return z11;
    }

    public static JSONObject parseObject(String str) {
        Object parse = parse(str);
        if (parse instanceof JSONObject) {
            return (JSONObject) parse;
        }
        try {
            return (JSONObject) toJSON(parse);
        } catch (RuntimeException e11) {
            throw new JSONException("can not cast to JSONObject.", e11);
        }
    }

    public static Object toJSON(Object obj, ParserConfig parserConfig) {
        return toJSON(obj, SerializeConfig.f14295g);
    }

    public static byte[] toJSONBytes(Object obj, int i11, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.f14295g, i11, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static void writeJSONString(Writer writer, Object obj, int i11, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(writer, i11, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).E(obj);
        } finally {
            serializeWriter.close();
        }
    }

    public <T> T toJavaObject(Class<T> cls) {
        return TypeUtils.d(this, cls, ParserConfig.m());
    }

    public static Object toJSON(Object obj, SerializeConfig serializeConfig) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSON) {
            return obj;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            JSONObject jSONObject = new JSONObject(map.size());
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put(TypeUtils.w(entry.getKey()), toJSON(entry.getValue()));
            }
            return jSONObject;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            for (Object json : collection) {
                jSONArray.add(toJSON(json));
            }
            return jSONArray;
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray(length);
                for (int i11 = 0; i11 < length; i11++) {
                    jSONArray2.add(toJSON(Array.get(obj, i11)));
                }
                return jSONArray2;
            } else if (ParserConfig.n(cls)) {
                return obj;
            } else {
                k e11 = serializeConfig.e(cls);
                if (!(e11 instanceof h)) {
                    return parse(toJSONString(obj));
                }
                h hVar = (h) e11;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (Map.Entry next : hVar.u(obj).entrySet()) {
                        jSONObject2.put((String) next.getKey(), toJSON(next.getValue()));
                    }
                    return jSONObject2;
                } catch (Exception e12) {
                    throw new JSONException("toJSON error", e12);
                }
            }
        }
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, int i11, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i11, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter).E(obj);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public <T> T toJavaObject(Type type) {
        return TypeUtils.f(this, type, ParserConfig.m());
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i11, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i11, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, serializeConfig).E(obj);
            return serializeWriter.p(IOUtils.f14402b);
        } finally {
            serializeWriter.close();
        }
    }

    public <T> T toJavaObject(e eVar) {
        return TypeUtils.f(this, eVar != null ? eVar.a() : null, ParserConfig.m());
    }

    public static Object parse(byte[] bArr, Feature... featureArr) {
        char[] allocateChars = allocateChars(bArr.length);
        int f11 = IOUtils.f(bArr, 0, bArr.length, allocateChars);
        if (f11 < 0) {
            return null;
        }
        return parse(new String(allocateChars, 0, f11), featureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, e<T> eVar, Feature... featureArr) {
        return parseObject(str, eVar.f14176a, ParserConfig.f14180p, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Object obj, int i11, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, IOUtils.f14402b, obj, SerializeConfig.f14295g, (p[]) null, (String) null, i11, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return parseObject(str, (Type) cls, ParserConfig.f14180p, (m) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, p pVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.f14295g, new p[]{pVar}, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializerFeature... serializerFeatureArr) throws IOException {
        return writeJSONString(outputStream, charset, obj, SerializeConfig.f14295g, (p[]) null, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static Object parse(byte[] bArr, int i11, int i12, CharsetDecoder charsetDecoder, Feature... featureArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int i13 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i13 = Feature.config(i13, config, true);
        }
        return parse(bArr, i11, i12, charsetDecoder, i13);
    }

    public static <T> T parseObject(String str, Class<T> cls, m mVar, Feature... featureArr) {
        return parseObject(str, (Type) cls, ParserConfig.f14180p, mVar, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, p[] pVarArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.f14295g, pVarArr, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final int writeJSONString(OutputStream outputStream, Charset charset, Object obj, SerializeConfig serializeConfig, p[] pVarArr, String str, int i11, SerializerFeature... serializerFeatureArr) throws IOException {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i11, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.D(str);
                jSONSerializer.q(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (pVarArr != null) {
                for (p b11 : pVarArr) {
                    jSONSerializer.b(b11);
                }
            }
            jSONSerializer.E(obj);
            return serializeWriter.N(outputStream, charset);
        } finally {
            serializeWriter.close();
        }
    }

    public static <T> List<T> parseArray(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        a aVar = new a(str, ParserConfig.m());
        b bVar = aVar.f15701g;
        int J = bVar.J();
        if (J == 8) {
            bVar.nextToken();
        } else if (J != 20 || !bVar.E()) {
            arrayList = new ArrayList();
            aVar.C(cls, arrayList);
            aVar.x(arrayList);
        }
        aVar.close();
        return arrayList;
    }

    public static <T> T parseObject(String str, Type type, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.f14180p, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, (p) null, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Type type, m mVar, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.f14180p, mVar, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, p pVar, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, new p[]{pVar}, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static <T> T parseObject(String str, Type type, int i11, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature config : featureArr) {
            i11 = Feature.config(i11, config, true);
        }
        a aVar = new a(str, ParserConfig.m(), i11);
        T L = aVar.L(type);
        aVar.x(L);
        aVar.close();
        return L;
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, p[] pVarArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, pVarArr, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, p[] pVarArr, String str, int i11, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i11, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.D(str);
                jSONSerializer.q(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (pVarArr != null) {
                for (p b11 : pVarArr) {
                    jSONSerializer.b(b11);
                }
            }
            jSONSerializer.E(obj);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(byte[] bArr, int i11, int i12, CharsetDecoder charsetDecoder, int i13) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (((double) i12) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i11, i12);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.b(charsetDecoder, wrap, wrap2);
        a aVar = new a(allocateChars, wrap2.position(), ParserConfig.m(), i13);
        Object z11 = aVar.z();
        aVar.x(z11);
        aVar.close();
        return z11;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, Feature... featureArr) {
        return parseObject(str, type, parserConfig, (m) null, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static List<Object> parseArray(String str, Type[] typeArr) {
        List<Object> list = null;
        if (str == null) {
            return null;
        }
        a aVar = new a(str, ParserConfig.m());
        Object[] H = aVar.H(typeArr);
        if (H != null) {
            list = Arrays.asList(H);
        }
        aVar.x(list);
        aVar.close();
        return list;
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i11, Feature... featureArr) {
        return parseObject(str, type, parserConfig, (m) null, i11, featureArr);
    }

    public void writeJSONString(Appendable appendable) {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).E(this);
            appendable.append(serializeWriter.toString());
            serializeWriter.close();
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        } catch (Throwable th2) {
            serializeWriter.close();
            throw th2;
        }
    }

    public static <T> T parseObject(String str, Type type, ParserConfig parserConfig, m mVar, int i11, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        if (featureArr != null) {
            for (Feature feature : featureArr) {
                i11 |= feature.mask;
            }
        }
        a aVar = new a(str, parserConfig, i11);
        if (mVar != null) {
            if (mVar instanceof g2.h) {
                aVar.p().add((g2.h) mVar);
            }
            if (mVar instanceof g) {
                aVar.o().add((g) mVar);
            }
            if (mVar instanceof j) {
                aVar.U((j) mVar);
            }
        }
        T M = aVar.M(type, (Object) null);
        aVar.x(M);
        aVar.close();
        return M;
    }

    public static String toJSONString(Object obj, boolean z11) {
        if (!z11) {
            return toJSONString(obj);
        }
        return toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    public static Object parse(String str, Feature... featureArr) {
        int i11 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i11 = Feature.config(i11, config, true);
        }
        return parse(str, i11);
    }

    public String toJSONString() {
        SerializeWriter serializeWriter = new SerializeWriter();
        try {
            new JSONSerializer(serializeWriter).E(this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        return parseObject(bArr, 0, bArr.length, IOUtils.f14402b, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i11, int i12, Charset charset, Type type, Feature... featureArr) {
        String str;
        if (charset == null) {
            charset = IOUtils.f14402b;
        }
        if (charset == IOUtils.f14402b) {
            char[] allocateChars = allocateChars(bArr.length);
            int f11 = IOUtils.f(bArr, i11, i12, allocateChars);
            if (f11 < 0) {
                return null;
            }
            str = new String(allocateChars, 0, f11);
        } else if (i12 < 0) {
            return null;
        } else {
            str = new String(bArr, i11, i12, charset);
        }
        return parseObject(str, type, featureArr);
    }

    public static <T> T parseObject(byte[] bArr, int i11, int i12, CharsetDecoder charsetDecoder, Type type, Feature... featureArr) {
        charsetDecoder.reset();
        char[] allocateChars = allocateChars((int) (((double) i12) * ((double) charsetDecoder.maxCharsPerByte())));
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i11, i12);
        CharBuffer wrap2 = CharBuffer.wrap(allocateChars);
        IOUtils.b(charsetDecoder, wrap, wrap2);
        return parseObject(allocateChars, wrap2.position(), type, featureArr);
    }

    public static <T> T parseObject(char[] cArr, int i11, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i12 = DEFAULT_PARSER_FEATURE;
        for (Feature config : featureArr) {
            i12 = Feature.config(i12, config, true);
        }
        a aVar = new a(cArr, i11, ParserConfig.m(), i12);
        T L = aVar.L(type);
        aVar.x(L);
        aVar.close();
        return L;
    }

    public static <T> T parseObject(InputStream inputStream, Type type, Feature... featureArr) throws IOException {
        return parseObject(inputStream, IOUtils.f14402b, type, featureArr);
    }

    public static <T> T parseObject(InputStream inputStream, Charset charset, Type type, Feature... featureArr) throws IOException {
        if (charset == null) {
            charset = IOUtils.f14402b;
        }
        Charset charset2 = charset;
        byte[] allocateBytes = allocateBytes(65536);
        int i11 = 0;
        while (true) {
            int read = inputStream.read(allocateBytes, i11, allocateBytes.length - i11);
            if (read == -1) {
                return parseObject(allocateBytes, 0, i11, charset2, type, featureArr);
            }
            i11 += read;
            if (i11 == allocateBytes.length) {
                byte[] bArr = new byte[((allocateBytes.length * 3) / 2)];
                System.arraycopy(allocateBytes, 0, bArr, 0, allocateBytes.length);
                allocateBytes = bArr;
            }
        }
    }

    public static <T> T parseObject(String str, Class<T> cls) {
        return parseObject(str, cls, new Feature[0]);
    }
}
