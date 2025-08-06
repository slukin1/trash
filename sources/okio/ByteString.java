package okio;

import com.huochat.community.util.FileTool;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.r;
import kotlin.text.b;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion((r) null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                charset = b.f56908b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i11, i12);
        }

        /* renamed from: -deprecated_decodeBase64  reason: not valid java name */
        public final ByteString m3224deprecated_decodeBase64(String str) {
            return decodeBase64(str);
        }

        /* renamed from: -deprecated_decodeHex  reason: not valid java name */
        public final ByteString m3225deprecated_decodeHex(String str) {
            return decodeHex(str);
        }

        /* renamed from: -deprecated_encodeString  reason: not valid java name */
        public final ByteString m3226deprecated_encodeString(String str, Charset charset) {
            return encodeString(str, charset);
        }

        /* renamed from: -deprecated_encodeUtf8  reason: not valid java name */
        public final ByteString m3227deprecated_encodeUtf8(String str) {
            return encodeUtf8(str);
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m3228deprecated_of(ByteBuffer byteBuffer) {
            return of(byteBuffer);
        }

        /* renamed from: -deprecated_read  reason: not valid java name */
        public final ByteString m3230deprecated_read(InputStream inputStream, int i11) {
            return read(inputStream, i11);
        }

        public final ByteString decodeBase64(String str) {
            byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i11 = 0; i11 < length; i11++) {
                    int i12 = i11 * 2;
                    bArr[i11] = (byte) ((okio.internal.ByteString.decodeHexDigit(str.charAt(i12)) << 4) + okio.internal.ByteString.decodeHexDigit(str.charAt(i12 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        public final ByteString encodeString(String str, Charset charset) {
            return new ByteString(str.getBytes(charset));
        }

        public final ByteString encodeUtf8(String str) {
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(ByteBuffer byteBuffer) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString read(InputStream inputStream, int i11) throws IOException {
            int i12 = 0;
            if (i11 >= 0) {
                byte[] bArr = new byte[i11];
                while (i12 < i11) {
                    int read = inputStream.read(bArr, i12, i11 - i12);
                    if (read != -1) {
                        i12 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i11).toString());
        }

        /* renamed from: -deprecated_of  reason: not valid java name */
        public final ByteString m3229deprecated_of(byte[] bArr, int i11, int i12) {
            return of(bArr, i11, i12);
        }

        public final ByteString of(byte... bArr) {
            return new ByteString(Arrays.copyOf(bArr, bArr.length));
        }

        public final ByteString of(byte[] bArr, int i11, int i12) {
            int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i12);
            SegmentedByteString.checkOffsetAndCount((long) bArr.length, (long) i11, (long) resolveDefaultParameter);
            return new ByteString(ArraysKt___ArraysJvmKt.i(bArr, i11, resolveDefaultParameter + i11));
        }
    }

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i11, byte[] bArr, int i12, int i13, int i14, Object obj) {
        if (obj == null) {
            if ((i14 & 1) != 0) {
                i11 = 0;
            }
            if ((i14 & 4) != 0) {
                i12 = 0;
            }
            byteString.copyInto(i11, bArr, i12, i13);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return byteString.indexOf(byteString2, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(byteString2, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    public static final ByteString of(byte... bArr) {
        return Companion.of(bArr);
    }

    public static final ByteString of(byte[] bArr, int i11, int i12) {
        return Companion.of(bArr, i11, i12);
    }

    public static final ByteString read(InputStream inputStream, int i11) throws IOException {
        return Companion.read(inputStream, i11);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString read = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return byteString.substring(i11, i12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m3222deprecated_getByte(int i11) {
        return getByte(i11);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m3223deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public void copyInto(int i11, byte[] bArr, int i12, int i13) {
        byte[] unused = ArraysKt___ArraysJvmKt.e(getData$okio(), bArr, i12, i11, i13 + i11);
    }

    public ByteString digest$okio(String str) {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(this.data, 0, size());
        return new ByteString(instance.digest());
    }

    public final boolean endsWith(ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i11) {
        return internalGet$okio(i11);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode2 = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode2);
        return hashCode2;
    }

    public String hex() {
        char[] cArr = new char[(getData$okio().length * 2)];
        int i11 = 0;
        for (byte b11 : getData$okio()) {
            int i12 = i11 + 1;
            cArr[i11] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b11 >> 4) & 15];
            i11 = i12 + 1;
            cArr[i12] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b11 & 15];
        }
        return StringsKt__StringsJVMKt.q(cArr);
    }

    public ByteString hmac$okio(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            return new ByteString(instance.doFinal(this.data));
        } catch (InvalidKeyException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public ByteString hmacSha1(ByteString byteString) {
        return hmac$okio("HmacSHA1", byteString);
    }

    public ByteString hmacSha256(ByteString byteString) {
        return hmac$okio("HmacSHA256", byteString);
    }

    public ByteString hmacSha512(ByteString byteString) {
        return hmac$okio("HmacSHA512", byteString);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int indexOf(ByteString byteString, int i11) {
        return indexOf(byteString.internalArray$okio(), i11);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i11) {
        return getData$okio()[i11];
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int lastIndexOf(ByteString byteString, int i11) {
        return lastIndexOf(byteString.internalArray$okio(), i11);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final ByteString md5() {
        return digest$okio(FileTool.HASH_TYPE_MD5);
    }

    public boolean rangeEquals(int i11, ByteString byteString, int i12, int i13) {
        return byteString.rangeEquals(i12, getData$okio(), i11, i13);
    }

    public final void setHashCode$okio(int i11) {
        this.hashCode = i11;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio(McElieceCCA2KeyGenParameterSpec.SHA1);
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    public String string(Charset charset) {
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, (Object) null);
    }

    public final ByteString substring(int i11) {
        return substring$default(this, i11, 0, 2, (Object) null);
    }

    public ByteString substring(int i11, int i12) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i12);
        boolean z11 = true;
        if (i11 >= 0) {
            if (resolveDefaultParameter <= getData$okio().length) {
                if (resolveDefaultParameter - i11 < 0) {
                    z11 = false;
                }
                if (!z11) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i11 == 0 && resolveDefaultParameter == getData$okio().length) {
                    return this;
                } else {
                    return new ByteString(ArraysKt___ArraysJvmKt.i(getData$okio(), i11, resolveDefaultParameter));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public ByteString toAsciiLowercase() {
        int i11 = 0;
        while (i11 < getData$okio().length) {
            byte b11 = getData$okio()[i11];
            if (b11 < 65 || b11 > 90) {
                i11++;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i11] = (byte) (b11 + 32);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b12 = copyOf[i12];
                    if (b12 >= 65 && b12 <= 90) {
                        copyOf[i12] = (byte) (b12 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        int i11 = 0;
        while (i11 < getData$okio().length) {
            byte b11 = getData$okio()[i11];
            if (b11 < 97 || b11 > 122) {
                i11++;
            } else {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i11] = (byte) (b11 + ISO7816.INS_CREATE_FILE);
                for (int i12 = i11 + 1; i12 < copyOf.length; i12++) {
                    byte b12 = copyOf[i12];
                    if (b12 >= 97 && b12 <= 122) {
                        copyOf[i12] = (byte) (b12 + ISO7816.INS_CREATE_FILE);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        return Arrays.copyOf(data$okio, data$okio.length);
    }

    public String toString() {
        ByteString byteString;
        String str;
        boolean z11 = true;
        if (getData$okio().length == 0) {
            str = "[size=0]";
        } else {
            int access$codePointIndexToCharIndex = okio.internal.ByteString.codePointIndexToCharIndex(getData$okio(), 64);
            if (access$codePointIndexToCharIndex != -1) {
                String utf82 = utf8();
                String G = StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(StringsKt__StringsJVMKt.G(utf82.substring(0, access$codePointIndexToCharIndex), "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (access$codePointIndexToCharIndex < utf82.length()) {
                    return "[size=" + getData$okio().length + " text=" + G + "…]";
                }
                return "[text=" + G + ']';
            } else if (getData$okio().length <= 64) {
                str = "[hex=" + hex() + ']';
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(getData$okio().length);
                sb2.append(" hex=");
                int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
                if (resolveDefaultParameter <= getData$okio().length) {
                    if (resolveDefaultParameter + 0 < 0) {
                        z11 = false;
                    }
                    if (z11) {
                        if (resolveDefaultParameter == getData$okio().length) {
                            byteString = this;
                        } else {
                            byteString = new ByteString(ArraysKt___ArraysJvmKt.i(getData$okio(), 0, resolveDefaultParameter));
                        }
                        sb2.append(byteString.hex());
                        sb2.append("…]");
                        return sb2.toString();
                    }
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                }
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
        }
        return str;
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public void write$okio(Buffer buffer, int i11, int i12) {
        okio.internal.ByteString.commonWrite(this, buffer, i11, i12);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            return byteString.indexOf(bArr, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        if (r7 < r8) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        if (r0 < r1) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(okio.ByteString r10) {
        /*
            r9 = this;
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L_0x000e:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x0026
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L_0x0023
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0023:
            if (r7 >= r8) goto L_0x002d
            goto L_0x002b
        L_0x0026:
            if (r0 != r1) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            if (r0 >= r1) goto L_0x002d
        L_0x002b:
            r3 = r5
            goto L_0x002e
        L_0x002d:
            r3 = r6
        L_0x002e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public int indexOf(byte[] bArr, int i11) {
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i11, 0);
        if (max <= length) {
            while (!SegmentedByteString.arrayRangeEquals(getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i11) {
        for (int min = Math.min(SegmentedByteString.resolveDefaultParameter(this, i11), getData$okio().length - bArr.length); -1 < min; min--) {
            if (SegmentedByteString.arrayRangeEquals(getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i11, byte[] bArr, int i12, int i13) {
        return i11 >= 0 && i11 <= getData$okio().length - i13 && i12 >= 0 && i12 <= bArr.length - i13 && SegmentedByteString.arrayRangeEquals(getData$okio(), i11, bArr, i12, i13);
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i11 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return byteString.lastIndexOf(bArr, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }
}
