package com.google.common.io;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import okio.Utf8;

@GwtCompatible(emulated = true)
public abstract class BaseEncoding {
    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    public static final class Alphabet {
        public final int bitsPerChar;
        public final int bytesPerChunk;
        /* access modifiers changed from: private */
        public final char[] chars;
        public final int charsPerChunk;
        private final byte[] decodabet;
        public final int mask;
        private final String name;
        private final boolean[] validPadding;

        public Alphabet(String str, char[] cArr) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = log2;
                int min = Math.min(8, Integer.lowestOneBit(log2));
                try {
                    this.charsPerChunk = 8 / min;
                    this.bytesPerChunk = log2 / min;
                    this.mask = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i11 = 0; i11 < cArr.length; i11++) {
                        char c11 = cArr[i11];
                        Preconditions.checkArgument(c11 < 128, "Non-ASCII character: %s", c11);
                        Preconditions.checkArgument(bArr[c11] == -1, "Duplicate character: %s", c11);
                        bArr[c11] = (byte) i11;
                    }
                    this.decodabet = bArr;
                    boolean[] zArr = new boolean[this.charsPerChunk];
                    for (int i12 = 0; i12 < this.bytesPerChunk; i12++) {
                        zArr[IntMath.divide(i12 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                    }
                    this.validPadding = zArr;
                } catch (ArithmeticException e11) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e11);
                }
            } catch (ArithmeticException e12) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e12);
            }
        }

        private boolean hasLowerCase() {
            for (char isLowerCase : this.chars) {
                if (Ascii.isLowerCase(isLowerCase)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char isUpperCase : this.chars) {
                if (Ascii.isUpperCase(isUpperCase)) {
                    return true;
                }
            }
            return false;
        }

        public boolean canDecode(char c11) {
            return c11 <= 127 && this.decodabet[c11] != -1;
        }

        public int decode(char c11) throws DecodingException {
            if (c11 <= 127) {
                byte b11 = this.decodabet[c11];
                if (b11 != -1) {
                    return b11;
                }
                if (c11 <= ' ' || c11 == 127) {
                    throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c11));
                }
                throw new DecodingException("Unrecognized character: " + c11);
            }
            throw new DecodingException("Unrecognized character: 0x" + Integer.toHexString(c11));
        }

        public char encode(int i11) {
            return this.chars[i11];
        }

        public boolean equals(Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        public boolean isValidPaddingStartPosition(int i11) {
            return this.validPadding[i11 % this.charsPerChunk];
        }

        public Alphabet lowerCase() {
            if (!hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i11 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i11 < cArr2.length) {
                    cArr[i11] = Ascii.toLowerCase(cArr2[i11]);
                    i11++;
                } else {
                    return new Alphabet(this.name + ".lowerCase()", cArr);
                }
            }
        }

        public boolean matches(char c11) {
            byte[] bArr = this.decodabet;
            return c11 < bArr.length && bArr[c11] != -1;
        }

        public String toString() {
            return this.name;
        }

        public Alphabet upperCase() {
            if (!hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArr = new char[this.chars.length];
            int i11 = 0;
            while (true) {
                char[] cArr2 = this.chars;
                if (i11 < cArr2.length) {
                    cArr[i11] = Ascii.toUpperCase(cArr2[i11]);
                    i11++;
                } else {
                    return new Alphabet(this.name + ".upperCase()", cArr);
                }
            }
        }
    }

    public static final class Base16Encoding extends StandardBaseEncoding {
        public final char[] encoding;

        public Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 != 1) {
                int i11 = 0;
                int i12 = 0;
                while (i11 < charSequence.length()) {
                    bArr[i12] = (byte) ((this.alphabet.decode(charSequence.charAt(i11)) << 4) | this.alphabet.decode(charSequence.charAt(i11 + 1)));
                    i11 += 2;
                    i12++;
                }
                return i12;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
            for (int i13 = 0; i13 < i12; i13++) {
                byte b11 = bArr[i11 + i13] & 255;
                appendable.append(this.encoding[b11]);
                appendable.append(this.encoding[b11 | 256]);
            }
        }

        public BaseEncoding newInstance(Alphabet alphabet, Character ch2) {
            return new Base16Encoding(alphabet);
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, (Character) null);
            this.encoding = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i11 = 0; i11 < 256; i11++) {
                this.encoding[i11] = alphabet.encode(i11 >>> 4);
                this.encoding[i11 | 256] = alphabet.encode(i11 & 15);
            }
        }
    }

    public static final class Base64Encoding extends StandardBaseEncoding {
        public Base64Encoding(String str, String str2, Character ch2) {
            this(new Alphabet(str, str2.toCharArray()), ch2);
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                int i11 = 0;
                int i12 = 0;
                while (i11 < trimTrailingPadding.length()) {
                    int i13 = i11 + 1;
                    int i14 = i13 + 1;
                    int decode = (this.alphabet.decode(trimTrailingPadding.charAt(i11)) << 18) | (this.alphabet.decode(trimTrailingPadding.charAt(i13)) << 12);
                    int i15 = i12 + 1;
                    bArr[i12] = (byte) (decode >>> 16);
                    if (i14 < trimTrailingPadding.length()) {
                        int i16 = i14 + 1;
                        int decode2 = decode | (this.alphabet.decode(trimTrailingPadding.charAt(i14)) << 6);
                        i12 = i15 + 1;
                        bArr[i15] = (byte) ((decode2 >>> 8) & 255);
                        if (i16 < trimTrailingPadding.length()) {
                            i14 = i16 + 1;
                            i15 = i12 + 1;
                            bArr[i12] = (byte) ((decode2 | this.alphabet.decode(trimTrailingPadding.charAt(i16))) & 255);
                        } else {
                            i11 = i16;
                        }
                    }
                    i12 = i15;
                    i11 = i14;
                }
                return i12;
            }
            throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i13 = i11 + i12;
            Preconditions.checkPositionIndexes(i11, i13, bArr.length);
            while (i12 >= 3) {
                int i14 = i11 + 1;
                int i15 = i14 + 1;
                byte b11 = ((bArr[i11] & 255) << 16) | ((bArr[i14] & 255) << 8) | (bArr[i15] & 255);
                appendable.append(this.alphabet.encode(b11 >>> 18));
                appendable.append(this.alphabet.encode((b11 >>> 12) & 63));
                appendable.append(this.alphabet.encode((b11 >>> 6) & 63));
                appendable.append(this.alphabet.encode(b11 & Utf8.REPLACEMENT_BYTE));
                i12 -= 3;
                i11 = i15 + 1;
            }
            if (i11 < i13) {
                encodeChunkTo(appendable, bArr, i11, i13 - i11);
            }
        }

        public BaseEncoding newInstance(Alphabet alphabet, Character ch2) {
            return new Base64Encoding(alphabet, ch2);
        }

        private Base64Encoding(Alphabet alphabet, Character ch2) {
            super(alphabet, ch2);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }
    }

    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        public DecodingException(Throwable th2) {
            super(th2);
        }
    }

    public static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        public SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i11) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i11;
            Preconditions.checkArgument(i11 > 0, "Cannot add a separator after every %s chars", i11);
        }

        public boolean canDecode(CharSequence charSequence) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < charSequence.length(); i11++) {
                char charAt = charSequence.charAt(i11);
                if (this.separator.indexOf(charAt) < 0) {
                    sb2.append(charAt);
                }
            }
            return this.delegate.canDecode(sb2);
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb2 = new StringBuilder(charSequence.length());
            for (int i11 = 0; i11 < charSequence.length(); i11++) {
                char charAt = charSequence.charAt(i11);
                if (this.separator.indexOf(charAt) < 0) {
                    sb2.append(charAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb2);
        }

        @GwtIncompatible
        public InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(BaseEncoding.ignoringReader(reader, this.separator));
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            this.delegate.encodeTo(BaseEncoding.separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i11, i12);
        }

        @GwtIncompatible
        public OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(BaseEncoding.separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public int maxDecodedSize(int i11) {
            return this.delegate.maxDecodedSize(i11);
        }

        public int maxEncodedSize(int i11) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i11);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }

        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withPadChar(char c11) {
            return this.delegate.withPadChar(c11).withSeparator(this.separator, this.afterEveryChars);
        }

        public BaseEncoding withSeparator(String str, int i11) {
            throw new UnsupportedOperationException("Already have a separator");
        }
    }

    public static class StandardBaseEncoding extends BaseEncoding {
        public final Alphabet alphabet;
        private transient BaseEncoding lowerCase;
        public final Character paddingChar;
        private transient BaseEncoding upperCase;

        public StandardBaseEncoding(String str, String str2, Character ch2) {
            this(new Alphabet(str, str2.toCharArray()), ch2);
        }

        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                return false;
            }
            for (int i11 = 0; i11 < trimTrailingPadding.length(); i11++) {
                if (!this.alphabet.canDecode(trimTrailingPadding.charAt(i11))) {
                    return false;
                }
            }
            return true;
        }

        public int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Alphabet alphabet2;
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                int i11 = 0;
                int i12 = 0;
                while (i11 < trimTrailingPadding.length()) {
                    long j11 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        alphabet2 = this.alphabet;
                        if (i13 >= alphabet2.charsPerChunk) {
                            break;
                        }
                        j11 <<= alphabet2.bitsPerChar;
                        if (i11 + i13 < trimTrailingPadding.length()) {
                            j11 |= (long) this.alphabet.decode(trimTrailingPadding.charAt(i14 + i11));
                            i14++;
                        }
                        i13++;
                    }
                    int i15 = alphabet2.bytesPerChunk;
                    int i16 = (i15 * 8) - (i14 * alphabet2.bitsPerChar);
                    int i17 = (i15 - 1) * 8;
                    while (i17 >= i16) {
                        bArr[i12] = (byte) ((int) ((j11 >>> i17) & 255));
                        i17 -= 8;
                        i12++;
                    }
                    i11 += this.alphabet.charsPerChunk;
                }
                return i12;
            }
            throw new DecodingException("Invalid input length " + trimTrailingPadding.length());
        }

        @GwtIncompatible
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() {
                public int bitBuffer = 0;
                public int bitBufferLength = 0;
                public boolean hitPadding = false;
                public int readChars = 0;

                public void close() throws IOException {
                    reader.close();
                }

                public int read() throws IOException {
                    int i11;
                    while (true) {
                        int read = reader.read();
                        if (read != -1) {
                            this.readChars++;
                            char c11 = (char) read;
                            Character ch2 = StandardBaseEncoding.this.paddingChar;
                            if (ch2 == null || ch2.charValue() != c11) {
                                if (!this.hitPadding) {
                                    int i12 = this.bitBuffer;
                                    Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                                    int i13 = i12 << alphabet.bitsPerChar;
                                    this.bitBuffer = i13;
                                    int decode = alphabet.decode(c11) | i13;
                                    this.bitBuffer = decode;
                                    int i14 = this.bitBufferLength + StandardBaseEncoding.this.alphabet.bitsPerChar;
                                    this.bitBufferLength = i14;
                                    if (i14 >= 8) {
                                        int i15 = i14 - 8;
                                        this.bitBufferLength = i15;
                                        return (decode >> i15) & 255;
                                    }
                                } else {
                                    throw new DecodingException("Expected padding character but found '" + c11 + "' at index " + this.readChars);
                                }
                            } else if (this.hitPadding || ((i11 = this.readChars) != 1 && StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(i11 - 1))) {
                                this.hitPadding = true;
                            }
                        } else if (this.hitPadding || StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                            return -1;
                        } else {
                            throw new DecodingException("Invalid input length " + this.readChars);
                        }
                    }
                    throw new DecodingException("Padding cannot start at index " + this.readChars);
                }

                public int read(byte[] bArr, int i11, int i12) throws IOException {
                    int i13 = i12 + i11;
                    Preconditions.checkPositionIndexes(i11, i13, bArr.length);
                    int i14 = i11;
                    while (i14 < i13) {
                        int read = read();
                        if (read == -1) {
                            int i15 = i14 - i11;
                            if (i15 == 0) {
                                return -1;
                            }
                            return i15;
                        }
                        bArr[i14] = (byte) read;
                        i14++;
                    }
                    return i14 - i11;
                }
            };
        }

        public void encodeChunkTo(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
            int i13 = 0;
            Preconditions.checkArgument(i12 <= this.alphabet.bytesPerChunk);
            long j11 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                j11 = (j11 | ((long) (bArr[i11 + i14] & 255))) << 8;
            }
            int i15 = ((i12 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i13 < i12 * 8) {
                Alphabet alphabet2 = this.alphabet;
                appendable.append(alphabet2.encode(((int) (j11 >>> (i15 - i13))) & alphabet2.mask));
                i13 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i13 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i13 += this.alphabet.bitsPerChar;
                }
            }
        }

        public void encodeTo(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
            int i13 = 0;
            while (i13 < i12) {
                encodeChunkTo(appendable, bArr, i11 + i13, Math.min(this.alphabet.bytesPerChunk, i12 - i13));
                i13 += this.alphabet.bytesPerChunk;
            }
        }

        @GwtIncompatible
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() {
                public int bitBuffer = 0;
                public int bitBufferLength = 0;
                public int writtenChars = 0;

                public void close() throws IOException {
                    int i11 = this.bitBufferLength;
                    if (i11 > 0) {
                        int i12 = this.bitBuffer;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        writer.write(alphabet.encode((i12 << (alphabet.bitsPerChar - i11)) & alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (true) {
                                int i13 = this.writtenChars;
                                StandardBaseEncoding standardBaseEncoding = StandardBaseEncoding.this;
                                if (i13 % standardBaseEncoding.alphabet.charsPerChunk == 0) {
                                    break;
                                }
                                writer.write(standardBaseEncoding.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }

                public void flush() throws IOException {
                    writer.flush();
                }

                public void write(int i11) throws IOException {
                    int i12 = this.bitBuffer << 8;
                    this.bitBuffer = i12;
                    this.bitBuffer = (i11 & 255) | i12;
                    this.bitBufferLength += 8;
                    while (true) {
                        int i13 = this.bitBufferLength;
                        Alphabet alphabet = StandardBaseEncoding.this.alphabet;
                        int i14 = alphabet.bitsPerChar;
                        if (i13 >= i14) {
                            writer.write(alphabet.encode((this.bitBuffer >> (i13 - i14)) & alphabet.mask));
                            this.writtenChars++;
                            this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                        } else {
                            return;
                        }
                    }
                }
            };
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            if (!this.alphabet.equals(standardBaseEncoding.alphabet) || !Objects.equal(this.paddingChar, standardBaseEncoding.paddingChar)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }

        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet lowerCase2 = this.alphabet.lowerCase();
                baseEncoding = lowerCase2 == this.alphabet ? this : newInstance(lowerCase2, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        public int maxDecodedSize(int i11) {
            return (int) (((((long) this.alphabet.bitsPerChar) * ((long) i11)) + 7) / 8);
        }

        public int maxEncodedSize(int i11) {
            Alphabet alphabet2 = this.alphabet;
            return alphabet2.charsPerChunk * IntMath.divide(i11, alphabet2.bytesPerChunk, RoundingMode.CEILING);
        }

        public BaseEncoding newInstance(Alphabet alphabet2, Character ch2) {
            return new StandardBaseEncoding(alphabet2, ch2);
        }

        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, (Character) null);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("BaseEncoding.");
            sb2.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb2.append(".omitPadding()");
                } else {
                    sb2.append(".withPadChar('");
                    sb2.append(this.paddingChar);
                    sb2.append("')");
                }
            }
            return sb2.toString();
        }

        public CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch2 = this.paddingChar;
            if (ch2 == null) {
                return charSequence;
            }
            char charValue = ch2.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet upperCase2 = this.alphabet.upperCase();
                baseEncoding = upperCase2 == this.alphabet ? this : newInstance(upperCase2, this.paddingChar);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = r2.paddingChar;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.io.BaseEncoding withPadChar(char r3) {
            /*
                r2 = this;
                com.google.common.io.BaseEncoding$Alphabet r0 = r2.alphabet
                int r0 = r0.bitsPerChar
                r1 = 8
                int r1 = r1 % r0
                if (r1 == 0) goto L_0x001f
                java.lang.Character r0 = r2.paddingChar
                if (r0 == 0) goto L_0x0014
                char r0 = r0.charValue()
                if (r0 != r3) goto L_0x0014
                goto L_0x001f
            L_0x0014:
                com.google.common.io.BaseEncoding$Alphabet r0 = r2.alphabet
                java.lang.Character r3 = java.lang.Character.valueOf(r3)
                com.google.common.io.BaseEncoding r3 = r2.newInstance(r0, r3)
                return r3
            L_0x001f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.withPadChar(char):com.google.common.io.BaseEncoding");
        }

        public BaseEncoding withSeparator(String str, int i11) {
            boolean z11 = false;
            for (int i12 = 0; i12 < str.length(); i12++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i12)), "Separator (%s) cannot contain alphabet characters", (Object) str);
            }
            Character ch2 = this.paddingChar;
            if (ch2 != null) {
                if (str.indexOf(ch2.charValue()) < 0) {
                    z11 = true;
                }
                Preconditions.checkArgument(z11, "Separator (%s) cannot contain padding character", (Object) str);
            }
            return new SeparatedBaseEncoding(this, str, i11);
        }

        public StandardBaseEncoding(Alphabet alphabet2, Character ch2) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet2);
            Preconditions.checkArgument(ch2 == null || !alphabet2.matches(ch2.charValue()), "Padding character %s was already in alphabet", (Object) ch2);
            this.paddingChar = ch2;
        }
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    private static byte[] extract(byte[] bArr, int i11) {
        if (i11 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        return bArr2;
    }

    @GwtIncompatible
    public static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() {
            public void close() throws IOException {
                reader.close();
            }

            /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            public int read() throws java.io.IOException {
                /*
                    r3 = this;
                L_0x0000:
                    java.io.Reader r0 = r1
                    int r0 = r0.read()
                    r1 = -1
                    if (r0 == r1) goto L_0x0012
                    java.lang.String r1 = r2
                    char r2 = (char) r0
                    int r1 = r1.indexOf(r2)
                    if (r1 >= 0) goto L_0x0000
                L_0x0012:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.AnonymousClass3.read():int");
            }

            public int read(char[] cArr, int i11, int i12) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static Appendable separatingAppendable(Appendable appendable, String str, int i11) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i11 > 0);
        return new Appendable(i11, appendable, str) {
            public int charsUntilSeparator;
            public final /* synthetic */ int val$afterEveryChars;
            public final /* synthetic */ Appendable val$delegate;
            public final /* synthetic */ String val$separator;

            {
                this.val$afterEveryChars = r1;
                this.val$delegate = r2;
                this.val$separator = r3;
                this.charsUntilSeparator = r1;
            }

            public Appendable append(char c11) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    this.val$delegate.append(this.val$separator);
                    this.charsUntilSeparator = this.val$afterEveryChars;
                }
                this.val$delegate.append(c11);
                this.charsUntilSeparator--;
                return this;
            }

            public Appendable append(CharSequence charSequence, int i11, int i12) throws IOException {
                throw new UnsupportedOperationException();
            }

            public Appendable append(CharSequence charSequence) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    @GwtIncompatible
    public static Writer separatingWriter(final Writer writer, String str, int i11) {
        final Appendable separatingAppendable = separatingAppendable(writer, str, i11);
        return new Writer() {
            public void close() throws IOException {
                writer.close();
            }

            public void flush() throws IOException {
                writer.flush();
            }

            public void write(int i11) throws IOException {
                separatingAppendable.append((char) i11);
            }

            public void write(char[] cArr, int i11, int i12) throws IOException {
                throw new UnsupportedOperationException();
            }
        };
    }

    public abstract boolean canDecode(CharSequence charSequence);

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(trimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, trimTrailingPadding));
    }

    public abstract int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException;

    @GwtIncompatible
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() {
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public abstract void encodeTo(Appendable appendable, byte[] bArr, int i11, int i12) throws IOException;

    @GwtIncompatible
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() {
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    @GwtIncompatible
    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    public abstract int maxDecodedSize(int i11);

    public abstract int maxEncodedSize(int i11);

    public abstract BaseEncoding omitPadding();

    public CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c11);

    public abstract BaseEncoding withSeparator(String str, int i11);

    public final String encode(byte[] bArr, int i11, int i12) {
        Preconditions.checkPositionIndexes(i11, i11 + i12, bArr.length);
        StringBuilder sb2 = new StringBuilder(maxEncodedSize(i12));
        try {
            encodeTo(sb2, bArr, i11, i12);
            return sb2.toString();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }
}
