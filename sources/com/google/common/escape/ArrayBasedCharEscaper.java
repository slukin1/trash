package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;

@GwtCompatible
@Beta
public abstract class ArrayBasedCharEscaper extends CharEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final char safeMax;
    private final char safeMin;

    public ArrayBasedCharEscaper(Map<Character, String> map, char c11, char c12) {
        this(ArrayBasedEscaperMap.create(map), c11, c12);
    }

    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMax || charAt < this.safeMin) {
                return escapeSlow(str, i11);
            }
        }
        return str;
    }

    public abstract char[] escapeUnsafe(char c11);

    public ArrayBasedCharEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, char c11, char c12) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (c12 < c11) {
            c12 = 0;
            c11 = 65535;
        }
        this.safeMin = c11;
        this.safeMax = c12;
    }

    public final char[] escape(char c11) {
        char[] cArr;
        if (c11 < this.replacementsLength && (cArr = this.replacements[c11]) != null) {
            return cArr;
        }
        if (c11 < this.safeMin || c11 > this.safeMax) {
            return escapeUnsafe(c11);
        }
        return null;
    }
}
