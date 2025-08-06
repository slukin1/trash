package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.analytics.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];

    /* renamed from: in  reason: collision with root package name */
    private final Reader f67165in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    public int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i11 = jsonReader.peeked;
                if (i11 == 0) {
                    i11 = jsonReader.doPeek();
                }
                if (i11 == 13) {
                    jsonReader.peeked = 9;
                } else if (i11 == 12) {
                    jsonReader.peeked = 8;
                } else if (i11 == 14) {
                    jsonReader.peeked = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f67165in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i11 = this.pos - 1;
        this.pos = i11;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i11 + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i12 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i12 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i12] == cArr2[i12]) {
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean fillBuffer(int i11) throws IOException {
        int i12;
        int i13;
        char[] cArr = this.buffer;
        int i14 = this.lineStart;
        int i15 = this.pos;
        this.lineStart = i14 - i15;
        int i16 = this.limit;
        if (i16 != i15) {
            int i17 = i16 - i15;
            this.limit = i17;
            System.arraycopy(cArr, i15, cArr, 0, i17);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.f67165in;
            int i18 = this.limit;
            int read = reader.read(cArr, i18, cArr.length - i18);
            if (read == -1) {
                return false;
            }
            i12 = this.limit + read;
            this.limit = i12;
            if (this.lineNumber == 0 && (i13 = this.lineStart) == 0 && i12 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i13 + 1;
                i11++;
                continue;
            }
        } while (i12 < i11);
        return true;
    }

    private boolean isLiteral(char c11) throws IOException {
        if (c11 == 9 || c11 == 10 || c11 == 12 || c11 == 13 || c11 == ' ') {
            return false;
        }
        if (c11 != '#') {
            if (c11 == ',') {
                return false;
            }
            if (!(c11 == '/' || c11 == '=')) {
                if (c11 == '{' || c11 == '}' || c11 == ':') {
                    return false;
                }
                if (c11 != ';') {
                    switch (c11) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z11) throws IOException {
        char[] cArr = this.buffer;
        int i11 = this.pos;
        int i12 = this.limit;
        while (true) {
            if (i11 == i12) {
                this.pos = i11;
                if (fillBuffer(1)) {
                    i11 = this.pos;
                    i12 = this.limit;
                } else if (!z11) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + locationString());
                }
            }
            int i13 = i11 + 1;
            char c11 = cArr[i11];
            if (c11 == 10) {
                this.lineNumber++;
                this.lineStart = i13;
            } else if (!(c11 == ' ' || c11 == 13 || c11 == 9)) {
                if (c11 == '/') {
                    this.pos = i13;
                    if (i13 == i12) {
                        this.pos = i13 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c11;
                        }
                    }
                    checkLenient();
                    int i14 = this.pos;
                    char c12 = cArr[i14];
                    if (c12 == '*') {
                        this.pos = i14 + 1;
                        if (skipTo("*/")) {
                            i11 = this.pos + 2;
                            i12 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c12 != '/') {
                        return c11;
                    } else {
                        this.pos = i14 + 1;
                        skipToEndOfLine();
                        i11 = this.pos;
                        i12 = this.limit;
                    }
                } else if (c11 == '#') {
                    this.pos = i13;
                    checkLenient();
                    skipToEndOfLine();
                    i11 = this.pos;
                    i12 = this.limit;
                } else {
                    this.pos = i13;
                    return c11;
                }
            }
            i11 = i13;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextQuotedValue(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.buffer
            r1 = 0
        L_0x0003:
            int r2 = r9.pos
            int r3 = r9.limit
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004f
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0040
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L_0x0040:
            r1.append(r0, r3, r7)
            char r2 = r9.readEscapeCharacter()
            r1.append(r2)
            int r2 = r9.pos
            int r3 = r9.limit
            goto L_0x0007
        L_0x004f:
            r5 = 10
            if (r2 != r5) goto L_0x005a
            int r2 = r9.lineNumber
            int r2 = r2 + r6
            r9.lineNumber = r2
            r9.lineStart = r7
        L_0x005a:
            r2 = r7
            goto L_0x0009
        L_0x005c:
            if (r1 != 0) goto L_0x006c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.pos = r2
            boolean r2 = r9.fillBuffer(r6)
            if (r2 == 0) goto L_0x007a
            goto L_0x0003
        L_0x007a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.syntaxError(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r0
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.checkLenient()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r1.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i11;
        char c11 = this.buffer[this.pos];
        if (c11 == 't' || c11 == 'T') {
            i11 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c11 == 'f' || c11 == 'F') {
            i11 = 6;
            str2 = d.f31895b;
            str = "FALSE";
        } else if (c11 != 'n' && c11 != 'N') {
            return 0;
        } else {
            i11 = 7;
            str2 = OptionsBridge.NULL_VALUE;
            str = "NULL";
        }
        int length = str2.length();
        for (int i12 = 1; i12 < length; i12++) {
            if (this.pos + i12 >= this.limit && !fillBuffer(i12 + 1)) {
                return 0;
            }
            char c12 = this.buffer[this.pos + i12];
            if (c12 != str2.charAt(i12) && c12 != str.charAt(i12)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i11;
        return i11;
    }

    private int peekNumber() throws IOException {
        char c11;
        char[] cArr = this.buffer;
        int i11 = this.pos;
        int i12 = this.limit;
        int i13 = 0;
        boolean z11 = true;
        int i14 = 0;
        char c12 = 0;
        boolean z12 = false;
        long j11 = 0;
        while (true) {
            if (i11 + i14 == i12) {
                if (i14 == cArr.length) {
                    return i13;
                }
                if (!fillBuffer(i14 + 1)) {
                    break;
                }
                i11 = this.pos;
                i12 = this.limit;
            }
            c11 = cArr[i11 + i14];
            char c13 = 3;
            if (c11 == '+') {
                c13 = 6;
                i13 = 0;
                if (c12 != 5) {
                    return 0;
                }
            } else if (c11 == 'E' || c11 == 'e') {
                i13 = 0;
                if (c12 != 2 && c12 != 4) {
                    return 0;
                }
                c12 = 5;
                i14++;
            } else if (c11 == '-') {
                c13 = 6;
                i13 = 0;
                if (c12 == 0) {
                    c12 = 1;
                    z12 = true;
                    i14++;
                } else if (c12 != 5) {
                    return 0;
                }
            } else if (c11 == '.') {
                i13 = 0;
                if (c12 != 2) {
                    return 0;
                }
            } else if (c11 >= '0' && c11 <= '9') {
                if (c12 == 1 || c12 == 0) {
                    j11 = (long) (-(c11 - '0'));
                    c12 = 2;
                } else if (c12 != 2) {
                    if (c12 == 3) {
                        i13 = 0;
                        c12 = 4;
                    } else if (c12 == 5 || c12 == 6) {
                        i13 = 0;
                        c12 = 7;
                    }
                    i14++;
                } else if (j11 == 0) {
                    return 0;
                } else {
                    long j12 = (10 * j11) - ((long) (c11 - '0'));
                    int i15 = (j11 > -922337203685477580L ? 1 : (j11 == -922337203685477580L ? 0 : -1));
                    z11 &= i15 > 0 || (i15 == 0 && j12 < j11);
                    j11 = j12;
                }
                i13 = 0;
                i14++;
            }
            c12 = c13;
            i14++;
        }
        if (isLiteral(c11)) {
            return 0;
        }
        if (c12 == 2 && z11 && ((j11 != Long.MIN_VALUE || z12) && (j11 != 0 || !z12))) {
            if (!z12) {
                j11 = -j11;
            }
            this.peekedLong = j11;
            this.pos += i14;
            this.peeked = 15;
            return 15;
        } else if (c12 != 2 && c12 != 4 && c12 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i14;
            this.peeked = 16;
            return 16;
        }
    }

    private void push(int i11) {
        int i12 = this.stackSize;
        int[] iArr = this.stack;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[(i12 * 2)];
            int[] iArr3 = new int[(i12 * 2)];
            String[] strArr = new String[(i12 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            System.arraycopy(this.pathIndices, 0, iArr3, 0, this.stackSize);
            System.arraycopy(this.pathNames, 0, strArr, 0, this.stackSize);
            this.stack = iArr2;
            this.pathIndices = iArr3;
            this.pathNames = strArr;
        }
        int[] iArr4 = this.stack;
        int i13 = this.stackSize;
        this.stackSize = i13 + 1;
        iArr4[i13] = i11;
    }

    private char readEscapeCharacter() throws IOException {
        int i11;
        int i12;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i13 = this.pos;
            int i14 = i13 + 1;
            this.pos = i14;
            char c11 = cArr[i13];
            if (c11 == 10) {
                this.lineNumber++;
                this.lineStart = i14;
            } else if (!(c11 == '\"' || c11 == '\'' || c11 == '/' || c11 == '\\')) {
                if (c11 == 'b') {
                    return 8;
                }
                if (c11 == 'f') {
                    return 12;
                }
                if (c11 == 'n') {
                    return 10;
                }
                if (c11 == 'r') {
                    return 13;
                }
                if (c11 == 't') {
                    return 9;
                }
                if (c11 != 'u') {
                    throw syntaxError("Invalid escape sequence");
                } else if (i14 + 4 <= this.limit || fillBuffer(4)) {
                    char c12 = 0;
                    int i15 = this.pos;
                    int i16 = i15 + 4;
                    while (i15 < i16) {
                        char c13 = this.buffer[i15];
                        char c14 = (char) (c12 << 4);
                        if (c13 < '0' || c13 > '9') {
                            if (c13 >= 'a' && c13 <= 'f') {
                                i11 = c13 - 'a';
                            } else if (c13 < 'A' || c13 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                            } else {
                                i11 = c13 - 'A';
                            }
                            i12 = i11 + 10;
                        } else {
                            i12 = c13 - '0';
                        }
                        c12 = (char) (c14 + i12);
                        i15++;
                    }
                    this.pos += 4;
                    return c12;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
            return c11;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c11) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i11 = this.pos;
            int i12 = this.limit;
            while (i11 < i12) {
                int i13 = i11 + 1;
                char c12 = cArr[i11];
                if (c12 == c11) {
                    this.pos = i13;
                    return;
                } else if (c12 == '\\') {
                    this.pos = i13;
                    readEscapeCharacter();
                    i11 = this.pos;
                    i12 = this.limit;
                } else {
                    if (c12 == 10) {
                        this.lineNumber++;
                        this.lineStart = i13;
                    }
                    i11 = i13;
                }
            }
            this.pos = i11;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i11 = 0;
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i12 = this.pos;
            if (cArr[i12] == 10) {
                this.lineNumber++;
                this.lineStart = i12 + 1;
            } else {
                while (i11 < length) {
                    if (this.buffer[this.pos + i11] == str.charAt(i11)) {
                        i11++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c11;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i11 = this.pos;
                int i12 = i11 + 1;
                this.pos = i12;
                c11 = cArr[i11];
                if (c11 == 10) {
                    this.lineNumber++;
                    this.lineStart = i12;
                    return;
                }
            } else {
                return;
            }
        } while (c11 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.checkLenient()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    public void beginArray() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.f67165in.close();
    }

    public int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i11 = this.stackSize;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else if (i12 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace2 == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        } else if (i12 == 3 || i12 == 5) {
            iArr[i11 - 1] = 4;
            if (i12 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 125) {
                    this.peeked = 2;
                    return 2;
                } else {
                    throw syntaxError("Unterminated object");
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i12 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i12 == 4) {
            iArr[i11 - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i13 = this.pos;
                        if (cArr[i13] == '>') {
                            this.pos = i13 + 1;
                        }
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i12 == 6) {
            if (this.lenient) {
                consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i12 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i12 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        this.pos--;
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer[this.pos])) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.peeked = 1;
                    return 1;
                } else if (i12 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i12 == 1 || i12 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        } else {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
    }

    public void endArray() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 4) {
            int i12 = this.stackSize - 1;
            this.stackSize = i12;
            int[] iArr = this.pathIndices;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 2) {
            int i12 = this.stackSize - 1;
            this.stackSize = i12;
            this.pathNames[i12] = null;
            int[] iArr = this.pathIndices;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public String getPath() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(DecodedChar.FNC1);
        int i11 = this.stackSize;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.stack[i12];
            if (i13 == 1 || i13 == 2) {
                sb2.append('[');
                sb2.append(this.pathIndices[i12]);
                sb2.append(']');
            } else if (i13 == 3 || i13 == 4 || i13 == 5) {
                sb2.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i12] != null) {
                    sb2.append(strArr[i12]);
                }
            }
        }
        return sb2.toString();
    }

    public boolean hasNext() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        return (i11 == 2 || i11 == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public boolean nextBoolean() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr[i12] = iArr[i12] + 1;
            return true;
        } else if (i11 == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i13 = this.stackSize - 1;
            iArr2[i13] = iArr2[i13] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public double nextDouble() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr[i12] = iArr[i12] + 1;
            return (double) this.peekedLong;
        }
        if (i11 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i11 == 8 || i11 == 9) {
            this.peekedString = nextQuotedValue(i11 == 8 ? '\'' : '\"');
        } else if (i11 == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i11 != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i13 = this.stackSize - 1;
            iArr2[i13] = iArr2[i13] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 15) {
            long j11 = this.peekedLong;
            int i12 = (int) j11;
            if (j11 == ((long) i12)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i13 = this.stackSize - 1;
                iArr[i13] = iArr[i13] + 1;
                return i12;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i11 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i11 == 8 || i11 == 9 || i11 == 10) {
            if (i11 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i11 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i14 = this.stackSize - 1;
                iArr2[i14] = iArr2[i14] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i15 = (int) parseDouble;
        if (((double) i15) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i16 = this.stackSize - 1;
            iArr3[i16] = iArr3[i16] + 1;
            return i15;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public long nextLong() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr[i12] = iArr[i12] + 1;
            return this.peekedLong;
        }
        if (i11 == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i11 == 8 || i11 == 9 || i11 == 10) {
            if (i11 == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i11 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i13 = this.stackSize - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j11 = (long) parseDouble;
        if (((double) j11) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i14 = this.stackSize - 1;
            iArr3[i14] = iArr3[i14] + 1;
            return j11;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    public String nextName() throws IOException {
        String str;
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 14) {
            str = nextUnquotedValue();
        } else if (i11 == 12) {
            str = nextQuotedValue('\'');
        } else if (i11 == 13) {
            str = nextQuotedValue('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i12 = this.stackSize - 1;
            iArr[i12] = iArr[i12] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public String nextString() throws IOException {
        String str;
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        if (i11 == 10) {
            str = nextUnquotedValue();
        } else if (i11 == 8) {
            str = nextQuotedValue('\'');
        } else if (i11 == 9) {
            str = nextQuotedValue('\"');
        } else if (i11 == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i11 == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i11 == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i12 = this.stackSize - 1;
        iArr[i12] = iArr[i12] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i11 = this.peeked;
        if (i11 == 0) {
            i11 = doPeek();
        }
        switch (i11) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z11) {
        this.lenient = z11;
    }

    public void skipValue() throws IOException {
        int i11 = 0;
        do {
            int i12 = this.peeked;
            if (i12 == 0) {
                i12 = doPeek();
            }
            if (i12 == 3) {
                push(1);
            } else if (i12 == 1) {
                push(3);
            } else {
                if (i12 == 4) {
                    this.stackSize--;
                } else if (i12 == 2) {
                    this.stackSize--;
                } else if (i12 == 14 || i12 == 10) {
                    skipUnquotedValue();
                    this.peeked = 0;
                } else if (i12 == 8 || i12 == 12) {
                    skipQuotedValue('\'');
                    this.peeked = 0;
                } else if (i12 == 9 || i12 == 13) {
                    skipQuotedValue('\"');
                    this.peeked = 0;
                } else {
                    if (i12 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                i11--;
                this.peeked = 0;
            }
            i11++;
            this.peeked = 0;
        } while (i11 != 0);
        int[] iArr = this.pathIndices;
        int i13 = this.stackSize;
        int i14 = i13 - 1;
        iArr[i14] = iArr[i14] + 1;
        this.pathNames[i13 - 1] = OptionsBridge.NULL_VALUE;
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
