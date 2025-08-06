package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

@GwtCompatible
@Beta
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() {
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        public char[] escape(char c11) {
            return null;
        }
    };

    @Beta
    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        /* access modifiers changed from: private */
        public String unsafeReplacement;

        @CanIgnoreReturnValue
        public Builder addEscape(char c11, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c11), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) {
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                public char[] escapeUnsafe(char c11) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c11, char c12) {
            this.safeMin = c11;
            this.safeMax = c12;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(String str) {
            this.unsafeReplacement = str;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = 0;
            this.safeMax = 65535;
            this.unsafeReplacement = null;
        }
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static String computeReplacement(CharEscaper charEscaper, char c11) {
        return stringOrNull(charEscaper.escape(c11));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() {
            public char[] escape(int i11) {
                if (i11 < 65536) {
                    return charEscaper.escape((char) i11);
                }
                char[] cArr = new char[2];
                Character.toChars(i11, cArr, 0);
                char[] escape = charEscaper.escape(cArr[0]);
                char[] escape2 = charEscaper.escape(cArr[1]);
                if (escape == null && escape2 == null) {
                    return null;
                }
                int length = escape != null ? escape.length : 1;
                char[] cArr2 = new char[((escape2 != null ? escape2.length : 1) + length)];
                if (escape != null) {
                    for (int i12 = 0; i12 < escape.length; i12++) {
                        cArr2[i12] = escape[i12];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (escape2 != null) {
                    for (int i13 = 0; i13 < escape2.length; i13++) {
                        cArr2[length + i13] = escape2[i13];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i11) {
        return stringOrNull(unicodeEscaper.escape(i11));
    }
}
