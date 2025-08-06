package org.bouncycastle.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.AlphabetMapper;

public class BasicAlphabetMapper implements AlphabetMapper {
    private Map<Integer, Character> charMap;
    private Map<Character, Integer> indexMap;

    public BasicAlphabetMapper(String str) {
        this(str.toCharArray());
    }

    public BasicAlphabetMapper(char[] cArr) {
        this.indexMap = new HashMap();
        this.charMap = new HashMap();
        int i11 = 0;
        while (i11 != cArr.length) {
            if (!this.indexMap.containsKey(Character.valueOf(cArr[i11]))) {
                this.indexMap.put(Character.valueOf(cArr[i11]), Integer.valueOf(i11));
                this.charMap.put(Integer.valueOf(i11), Character.valueOf(cArr[i11]));
                i11++;
            } else {
                throw new IllegalArgumentException("duplicate key detected in alphabet: " + cArr[i11]);
            }
        }
    }

    public char[] convertToChars(byte[] bArr) {
        char[] cArr;
        int i11 = 0;
        if (this.charMap.size() <= 256) {
            cArr = new char[bArr.length];
            while (i11 != bArr.length) {
                cArr[i11] = this.charMap.get(Integer.valueOf(bArr[i11] & 255)).charValue();
                i11++;
            }
        } else if ((bArr.length & 1) == 0) {
            cArr = new char[(bArr.length / 2)];
            while (i11 != bArr.length) {
                cArr[i11 / 2] = this.charMap.get(Integer.valueOf(((bArr[i11] << 8) & 65280) | (bArr[i11 + 1] & 255))).charValue();
                i11 += 2;
            }
        } else {
            throw new IllegalArgumentException("two byte radix and input string odd length");
        }
        return cArr;
    }

    public byte[] convertToIndexes(char[] cArr) {
        byte[] bArr;
        int i11 = 0;
        if (this.indexMap.size() <= 256) {
            bArr = new byte[cArr.length];
            while (i11 != cArr.length) {
                bArr[i11] = this.indexMap.get(Character.valueOf(cArr[i11])).byteValue();
                i11++;
            }
        } else {
            bArr = new byte[(cArr.length * 2)];
            while (i11 != cArr.length) {
                int intValue = this.indexMap.get(Character.valueOf(cArr[i11])).intValue();
                int i12 = i11 * 2;
                bArr[i12] = (byte) ((intValue >> 8) & 255);
                bArr[i12 + 1] = (byte) (intValue & 255);
                i11++;
            }
        }
        return bArr;
    }

    public int getRadix() {
        return this.indexMap.size();
    }
}
