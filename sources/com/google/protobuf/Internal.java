package com.google.protobuf;

import com.google.android.exoplayer2.C;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM;
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName(C.ASCII_NAME);
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z11);

        boolean getBoolean(int i11);

        BooleanList mutableCopyWithCapacity(int i11);

        boolean setBoolean(int i11, boolean z11);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d11);

        double getDouble(int i11);

        DoubleList mutableCopyWithCapacity(int i11);

        double setDouble(int i11, double d11);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i11);
    }

    public interface EnumVerifier {
        boolean isInRange(int i11);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f11);

        float getFloat(int i11);

        FloatList mutableCopyWithCapacity(int i11);

        float setFloat(int i11, float f11);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i11);

        int getInt(int i11);

        IntList mutableCopyWithCapacity(int i11);

        int setInt(int i11, int i12);
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F f11);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter2) {
            this.fromList = list;
            this.converter = converter2;
        }

        public T get(int i11) {
            return this.converter.convert(this.fromList.get(i11));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long j11);

        long getLong(int i11);

        LongList mutableCopyWithCapacity(int i11);

        long setLong(int i11, long j11);
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        /* access modifiers changed from: private */
        public final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B b11);

            B doForward(A a11);
        }

        public class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;

            public EntryAdapter(Map.Entry<K, RealValue> entry) {
                this.realEntry = entry;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                if (!getKey().equals(((Map.Entry) obj).getKey()) || !getValue().equals(getValue())) {
                    return false;
                }
                return true;
            }

            public K getKey() {
                return this.realEntry.getKey();
            }

            public V getValue() {
                return MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
            }

            public int hashCode() {
                return this.realEntry.hashCode();
            }

            public V setValue(V v11) {
                RealValue value = this.realEntry.setValue(MapAdapter.this.valueConverter.doBackward(v11));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.valueConverter.doForward(value);
            }
        }

        public class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;

            public IteratorAdapter(Iterator<Map.Entry<K, RealValue>> it2) {
                this.realIterator = it2;
            }

            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            public void remove() {
                this.realIterator.remove();
            }

            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.realIterator.next());
            }
        }

        public class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;

            public SetAdapter(Set<Map.Entry<K, RealValue>> set) {
                this.realSet = set;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.realSet.iterator());
            }

            public int size() {
                return this.realSet.size();
            }
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.realMap = map;
            this.valueConverter = converter;
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> enumLiteMap, final T t11) {
            return new Converter<Integer, T>() {
                public Integer doBackward(T t11) {
                    return Integer.valueOf(t11.getNumber());
                }

                public T doForward(Integer num) {
                    T findValueByNumber = EnumLiteMap.this.findValueByNumber(num.intValue());
                    return findValueByNumber == null ? t11 : findValueByNumber;
                }
            };
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this.realMap.entrySet());
        }

        public V get(Object obj) {
            RealValue realvalue = this.realMap.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.valueConverter.doForward(realvalue);
        }

        public V put(K k11, V v11) {
            RealValue put = this.realMap.put(k11, this.valueConverter.doBackward(v11));
            if (put == null) {
                return null;
            }
            return this.valueConverter.doForward(put);
        }
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i11);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
        EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(bArr);
    }

    private Internal() {
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!Arrays.equals(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return ((ByteBuffer) byteBuffer.duplicate().clear()).equals((ByteBuffer) byteBuffer2.duplicate().clear());
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (MessageLite) method.invoke(method, new Object[0]);
        } catch (Exception e11) {
            throw new RuntimeException("Failed to get default instance for " + cls, e11);
        }
    }

    public static int hashBoolean(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int hashCode(List<byte[]> list) {
        int i11 = 1;
        for (byte[] hashCode : list) {
            i11 = (i11 * 31) + hashCode(hashCode);
        }
        return i11;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i11 = 1;
        for (ByteBuffer hashCodeByteBuffer : list) {
            i11 = (i11 * 31) + hashCodeByteBuffer(hashCodeByteBuffer);
        }
        return i11;
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i11 = 1;
        for (EnumLite hashEnum : list) {
            i11 = (i11 * 31) + hashEnum(hashEnum);
        }
        return i11;
    }

    public static int hashLong(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static Object mergeMessage(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    public static int partialHash(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static <T> T checkNotNull(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (!equalsByteBuffer(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash == 0) {
                return 1;
            }
            return partialHash;
        }
        int i11 = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i11 = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i11];
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer byteBuffer2 = (ByteBuffer) duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i11 ? duplicate.remaining() : i11;
            duplicate.get(bArr, 0, remaining);
            capacity = partialHash(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    public static int hashCode(byte[] bArr, int i11, int i12) {
        int partialHash = partialHash(i12, bArr, i11, i12);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }
}
