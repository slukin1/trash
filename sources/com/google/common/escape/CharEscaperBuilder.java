package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;

@GwtCompatible
@Beta
public final class CharEscaperBuilder {
    private final Map<Character, String> map = new HashMap();
    private int max = -1;

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscape(char c11, String str) {
        this.map.put(Character.valueOf(c11), Preconditions.checkNotNull(str));
        if (c11 > this.max) {
            this.max = c11;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public CharEscaperBuilder addEscapes(char[] cArr, String str) {
        Preconditions.checkNotNull(str);
        for (char addEscape : cArr) {
            addEscape(addEscape, str);
        }
        return this;
    }

    public char[][] toArray() {
        char[][] cArr = new char[(this.max + 1)][];
        for (Map.Entry next : this.map.entrySet()) {
            cArr[((Character) next.getKey()).charValue()] = ((String) next.getValue()).toCharArray();
        }
        return cArr;
    }

    public Escaper toEscaper() {
        return new CharArrayDecorator(toArray());
    }

    public static class CharArrayDecorator extends CharEscaper {
        private final int replaceLength;
        private final char[][] replacements;

        public CharArrayDecorator(char[][] cArr) {
            this.replacements = cArr;
            this.replaceLength = cArr.length;
        }

        public String escape(String str) {
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                char charAt = str.charAt(i11);
                char[][] cArr = this.replacements;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return escapeSlow(str, i11);
                }
            }
            return str;
        }

        public char[] escape(char c11) {
            if (c11 < this.replaceLength) {
                return this.replacements[c11];
            }
            return null;
        }
    }
}
