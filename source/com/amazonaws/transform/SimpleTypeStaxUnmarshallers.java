package com.amazonaws.transform;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

public class SimpleTypeStaxUnmarshallers {

    /* renamed from: a  reason: collision with root package name */
    public static Log f15520a = LogFactory.b(SimpleTypeStaxUnmarshallers.class);

    public static class BigDecimalStaxUnmarshaller implements Unmarshaller<BigDecimal, StaxUnmarshallerContext> {
        /* renamed from: b */
        public BigDecimal a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return new BigDecimal(d11);
        }
    }

    public static class BigIntegerStaxUnmarshaller implements Unmarshaller<BigInteger, StaxUnmarshallerContext> {
        /* renamed from: b */
        public BigInteger a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return new BigInteger(d11);
        }
    }

    public static class BooleanStaxUnmarshaller implements Unmarshaller<Boolean, StaxUnmarshallerContext> {
        /* renamed from: b */
        public Boolean a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(d11));
        }
    }

    public static class ByteBufferStaxUnmarshaller implements Unmarshaller<ByteBuffer, StaxUnmarshallerContext> {
        /* renamed from: b */
        public ByteBuffer a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(staxUnmarshallerContext.d()));
        }
    }

    public static class ByteStaxUnmarshaller implements Unmarshaller<Byte, StaxUnmarshallerContext> {
        /* renamed from: b */
        public Byte a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return Byte.valueOf(d11);
        }
    }

    public static class DateStaxUnmarshaller implements Unmarshaller<Date, StaxUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static DateStaxUnmarshaller f15521a;

        public static DateStaxUnmarshaller b() {
            if (f15521a == null) {
                f15521a = new DateStaxUnmarshaller();
            }
            return f15521a;
        }

        /* renamed from: c */
        public Date a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            try {
                return DateUtils.h(d11);
            } catch (Exception e11) {
                Log a11 = SimpleTypeStaxUnmarshallers.f15520a;
                a11.f("Unable to parse date '" + d11 + "':  " + e11.getMessage(), e11);
                return null;
            }
        }
    }

    public static class DoubleStaxUnmarshaller implements Unmarshaller<Double, StaxUnmarshallerContext> {
        /* renamed from: b */
        public Double a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(d11));
        }
    }

    public static class FloatStaxUnmarshaller implements Unmarshaller<Float, StaxUnmarshallerContext> {
        /* renamed from: b */
        public Float a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return Float.valueOf(d11);
        }
    }

    public static class IntegerStaxUnmarshaller implements Unmarshaller<Integer, StaxUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static IntegerStaxUnmarshaller f15522a;

        public static IntegerStaxUnmarshaller b() {
            if (f15522a == null) {
                f15522a = new IntegerStaxUnmarshaller();
            }
            return f15522a;
        }

        /* renamed from: c */
        public Integer a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(d11));
        }
    }

    public static class LongStaxUnmarshaller implements Unmarshaller<Long, StaxUnmarshallerContext> {
        /* renamed from: b */
        public Long a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String d11 = staxUnmarshallerContext.d();
            if (d11 == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(d11));
        }
    }

    public static class StringStaxUnmarshaller implements Unmarshaller<String, StaxUnmarshallerContext> {

        /* renamed from: a  reason: collision with root package name */
        public static StringStaxUnmarshaller f15523a;

        public static StringStaxUnmarshaller b() {
            if (f15523a == null) {
                f15523a = new StringStaxUnmarshaller();
            }
            return f15523a;
        }

        /* renamed from: c */
        public String a(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return staxUnmarshallerContext.d();
        }
    }
}
