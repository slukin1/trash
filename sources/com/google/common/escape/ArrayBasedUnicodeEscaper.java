package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;

@GwtCompatible
@Beta
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    public ArrayBasedUnicodeEscaper(Map<Character, String> map, int i11, int i12, String str) {
        this(ArrayBasedEscaperMap.create(map), i11, i12, str);
    }

    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                return escapeSlow(str, i11);
            }
        }
        return str;
    }

    public abstract char[] escapeUnsafe(int i11);

    public final int nextEscapeIndex(CharSequence charSequence, int i11, int i12) {
        while (i11 < i12) {
            char charAt = charSequence.charAt(i11);
            if ((charAt < this.replacementsLength && this.replacements[charAt] != null) || charAt > this.safeMaxChar || charAt < this.safeMinChar) {
                break;
            }
            i11++;
        }
        return i11;
    }

    public ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i11, int i12, String str) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (i12 < i11) {
            i12 = -1;
            i11 = Integer.MAX_VALUE;
        }
        this.safeMin = i11;
        this.safeMax = i12;
        if (i11 >= 55296) {
            this.safeMinChar = 65535;
            this.safeMaxChar = 0;
            return;
        }
        this.safeMinChar = (char) i11;
        this.safeMaxChar = (char) Math.min(i12, 55295);
    }

    public final char[] escape(int i11) {
        char[] cArr;
        if (i11 < this.replacementsLength && (cArr = this.replacements[i11]) != null) {
            return cArr;
        }
        if (i11 < this.safeMin || i11 > this.safeMax) {
            return escapeUnsafe(i11);
        }
        return null;
    }
}
