package cn.sharesdk.framework.utils;

import java.io.IOException;

public abstract class l implements Escaper {

    public static final class a extends ThreadLocal<char[]> {
        private a() {
        }

        /* renamed from: a */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static final int b(CharSequence charSequence, int i11, int i12) {
        if (i11 < i12) {
            char charAt = charSequence.charAt(i11);
            int i13 = i11 + 1;
            if (charAt < 55296 || charAt > 57343) {
                return charAt;
            }
            if (charAt > 56319) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected low surrogate character '");
                sb2.append(charAt);
                sb2.append("' with value ");
                sb2.append(charAt);
                sb2.append(" at index ");
                sb2.append(i13 - 1);
                throw new IllegalArgumentException(sb2.toString());
            } else if (i13 == i12) {
                return -charAt;
            } else {
                char charAt2 = charSequence.charAt(i13);
                if (Character.isLowSurrogate(charAt2)) {
                    return Character.toCodePoint(charAt, charAt2);
                }
                throw new IllegalArgumentException("Expected low surrogate but got char '" + charAt2 + "' with value " + charAt2 + " at index " + i13);
            }
        } else {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
    }

    public int a(CharSequence charSequence, int i11, int i12) {
        while (i11 < i12) {
            int b11 = b(charSequence, i11, i12);
            if (b11 < 0 || a(b11) != null) {
                break;
            }
            i11 += Character.isSupplementaryCodePoint(b11) ? 2 : 1;
        }
        return i11;
    }

    public abstract char[] a(int i11);

    public String escape(String str) {
        int length = str.length();
        int a11 = a((CharSequence) str, 0, length);
        return a11 == length ? str : a(str, a11);
    }

    public final String a(String str, int i11) {
        int length = str.length();
        char[] cArr = (char[]) new a().get();
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            int b11 = b(str, i11, length);
            if (b11 >= 0) {
                char[] a11 = a(b11);
                if (a11 != null) {
                    int i14 = i11 - i12;
                    int i15 = i13 + i14;
                    int length2 = a11.length + i15;
                    if (cArr.length < length2) {
                        cArr = a(cArr, i13, length2 + (length - i11) + 32);
                    }
                    if (i14 > 0) {
                        str.getChars(i12, i11, cArr, i13);
                        i13 = i15;
                    }
                    if (a11.length > 0) {
                        System.arraycopy(a11, 0, cArr, i13, a11.length);
                        i13 += a11.length;
                    }
                }
                i12 = (Character.isSupplementaryCodePoint(b11) ? 2 : 1) + i11;
                i11 = a((CharSequence) str, i12, length);
            } else {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
        }
        int i16 = length - i12;
        if (i16 > 0) {
            int i17 = i16 + i13;
            if (cArr.length < i17) {
                cArr = a(cArr, i13, i17);
            }
            str.getChars(i12, length, cArr, i13);
            i13 = i17;
        }
        return new String(cArr, 0, i13);
    }

    public Appendable escape(final Appendable appendable) {
        e.a(appendable);
        return new Appendable() {

            /* renamed from: a  reason: collision with root package name */
            public int f13534a = -1;

            /* renamed from: b  reason: collision with root package name */
            public char[] f13535b = new char[2];

            private void a(char[] cArr, int i11) throws IOException {
                for (int i12 = 0; i12 < i11; i12++) {
                    appendable.append(cArr[i12]);
                }
            }

            public Appendable append(CharSequence charSequence) throws IOException {
                return append(charSequence, 0, charSequence.length());
            }

            public Appendable append(CharSequence charSequence, int i11, int i12) throws IOException {
                int i13;
                if (i11 < i12) {
                    if (this.f13534a != -1) {
                        char charAt = charSequence.charAt(i11);
                        int i14 = i11 + 1;
                        if (Character.isLowSurrogate(charAt)) {
                            char[] a11 = l.this.a(Character.toCodePoint((char) this.f13534a, charAt));
                            if (a11 != null) {
                                a(a11, a11.length);
                                i11 = i14;
                            } else {
                                appendable.append((char) this.f13534a);
                            }
                            this.f13534a = -1;
                            i13 = i11;
                            i11 = i14;
                        } else {
                            throw new IllegalArgumentException("Expected low surrogate character but got " + charAt);
                        }
                    } else {
                        i13 = i11;
                    }
                    while (true) {
                        int a12 = l.this.a(charSequence, i11, i12);
                        if (a12 > i13) {
                            appendable.append(charSequence, i13, a12);
                        }
                        if (a12 == i12) {
                            break;
                        }
                        int b11 = l.b(charSequence, a12, i12);
                        if (b11 < 0) {
                            this.f13534a = -b11;
                            break;
                        }
                        char[] a13 = l.this.a(b11);
                        if (a13 != null) {
                            a(a13, a13.length);
                        } else {
                            a(this.f13535b, Character.toChars(b11, this.f13535b, 0));
                        }
                        i13 = (Character.isSupplementaryCodePoint(b11) ? 2 : 1) + a12;
                        i11 = i13;
                    }
                }
                return this;
            }

            public Appendable append(char c11) throws IOException {
                if (this.f13534a != -1) {
                    if (Character.isLowSurrogate(c11)) {
                        char[] a11 = l.this.a(Character.toCodePoint((char) this.f13534a, c11));
                        if (a11 != null) {
                            a(a11, a11.length);
                        } else {
                            appendable.append((char) this.f13534a);
                            appendable.append(c11);
                        }
                        this.f13534a = -1;
                    } else {
                        throw new IllegalArgumentException("Expected low surrogate character but got '" + c11 + "' with value " + c11);
                    }
                } else if (Character.isHighSurrogate(c11)) {
                    this.f13534a = c11;
                } else if (!Character.isLowSurrogate(c11)) {
                    char[] a12 = l.this.a(c11);
                    if (a12 != null) {
                        a(a12, a12.length);
                    } else {
                        appendable.append(c11);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected low surrogate character '" + c11 + "' with value " + c11);
                }
                return this;
            }
        };
    }

    private static final char[] a(char[] cArr, int i11, int i12) {
        char[] cArr2 = new char[i12];
        if (i11 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i11);
        }
        return cArr2;
    }
}
