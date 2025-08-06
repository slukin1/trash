package com.amazonaws.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class SimpleTypeJsonUnmarshallers {

    /* renamed from: com.amazonaws.transform.SimpleTypeJsonUnmarshallers$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15513a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.amazonaws.transform.TimestampFormat[] r0 = com.amazonaws.transform.TimestampFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15513a = r0
                com.amazonaws.transform.TimestampFormat r1 = com.amazonaws.transform.TimestampFormat.ISO_8601     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15513a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazonaws.transform.TimestampFormat r1 = com.amazonaws.transform.TimestampFormat.RFC_822     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f15513a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazonaws.transform.TimestampFormat r1 = com.amazonaws.transform.TimestampFormat.UNIX_TIMESTAMP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.transform.SimpleTypeJsonUnmarshallers.AnonymousClass1.<clinit>():void");
        }
    }

    public static class BigDecimalJsonUnmarshaller implements Unmarshaller<BigDecimal, JsonUnmarshallerContext> {
        /* renamed from: b */
        public BigDecimal a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return new BigDecimal(g11);
        }
    }

    public static class BigIntegerJsonUnmarshaller implements Unmarshaller<BigInteger, JsonUnmarshallerContext> {
        /* renamed from: b */
        public BigInteger a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return new BigInteger(g11);
        }
    }

    public static class BooleanJsonUnmarshaller implements Unmarshaller<Boolean, JsonUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static BooleanJsonUnmarshaller f15514a;

        public static BooleanJsonUnmarshaller b() {
            if (f15514a == null) {
                f15514a = new BooleanJsonUnmarshaller();
            }
            return f15514a;
        }

        /* renamed from: c */
        public Boolean a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(g11));
        }
    }

    public static class ByteBufferJsonUnmarshaller implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static ByteBufferJsonUnmarshaller f15515a;

        public static ByteBufferJsonUnmarshaller b() {
            if (f15515a == null) {
                f15515a = new ByteBufferJsonUnmarshaller();
            }
            return f15515a;
        }

        /* renamed from: c */
        public ByteBuffer a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(jsonUnmarshallerContext.a().g()));
        }
    }

    public static class ByteJsonUnmarshaller implements Unmarshaller<Byte, JsonUnmarshallerContext> {
        /* renamed from: b */
        public Byte a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return Byte.valueOf(g11);
        }
    }

    public static class DateJsonUnmarshaller implements Unmarshaller<Date, JsonUnmarshallerContext> {

        /* renamed from: b  reason: collision with root package name */
        public static DateJsonUnmarshaller f15516b;

        /* renamed from: a  reason: collision with root package name */
        public final TimestampFormat f15517a;

        public DateJsonUnmarshaller(TimestampFormat timestampFormat) {
            this.f15517a = timestampFormat;
        }

        public static DateJsonUnmarshaller b() {
            return c(TimestampFormat.UNIX_TIMESTAMP);
        }

        public static DateJsonUnmarshaller c(TimestampFormat timestampFormat) {
            DateJsonUnmarshaller dateJsonUnmarshaller = f15516b;
            if (dateJsonUnmarshaller == null || !dateJsonUnmarshaller.f15517a.equals(timestampFormat)) {
                f15516b = new DateJsonUnmarshaller(timestampFormat);
            }
            return f15516b;
        }

        /* renamed from: d */
        public Date a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            try {
                int i11 = AnonymousClass1.f15513a[this.f15517a.ordinal()];
                if (i11 == 1) {
                    return DateUtils.h(g11);
                }
                if (i11 != 2) {
                    return new Date(NumberFormat.getInstance(new Locale(TUIThemeManager.LANGUAGE_EN)).parse(g11).longValue() * 1000);
                }
                return DateUtils.i(g11);
            } catch (IllegalArgumentException | ParseException e11) {
                throw new AmazonClientException("Unable to parse date '" + g11 + "':  " + e11.getMessage(), e11);
            }
        }
    }

    public static class DoubleJsonUnmarshaller implements Unmarshaller<Double, JsonUnmarshallerContext> {
        /* renamed from: b */
        public Double a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(g11));
        }
    }

    public static class FloatJsonUnmarshaller implements Unmarshaller<Float, JsonUnmarshallerContext> {
        /* renamed from: b */
        public Float a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return Float.valueOf(g11);
        }
    }

    public static class IntegerJsonUnmarshaller implements Unmarshaller<Integer, JsonUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static IntegerJsonUnmarshaller f15518a;

        public static IntegerJsonUnmarshaller b() {
            if (f15518a == null) {
                f15518a = new IntegerJsonUnmarshaller();
            }
            return f15518a;
        }

        /* renamed from: c */
        public Integer a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(g11));
        }
    }

    public static class LongJsonUnmarshaller implements Unmarshaller<Long, JsonUnmarshallerContext> {
        /* renamed from: b */
        public Long a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            String g11 = jsonUnmarshallerContext.a().g();
            if (g11 == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(g11));
        }
    }

    public static class StringJsonUnmarshaller implements Unmarshaller<String, JsonUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static StringJsonUnmarshaller f15519a;

        public static StringJsonUnmarshaller b() {
            if (f15519a == null) {
                f15519a = new StringJsonUnmarshaller();
            }
            return f15519a;
        }

        /* renamed from: c */
        public String a(JsonUnmarshallerContext jsonUnmarshallerContext) throws Exception {
            return jsonUnmarshallerContext.a().g();
        }
    }
}
