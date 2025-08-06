package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import net.sf.scuba.smartcards.ISO7816;

@GwtCompatible(emulated = true)
@Beta
public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 < length) {
                char charAt = charSequence.charAt(i11);
                if (charAt >= 2048) {
                    i12 += encodedLengthGeneral(charSequence, i11);
                    break;
                }
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                break;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i12) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
            } else {
                i12 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i11) != charAt) {
                        i11++;
                    } else {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i11));
                    }
                }
            }
            i11++;
        }
        return i12;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i11, int i12) {
        byte b11;
        while (i11 < i12) {
            int i13 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 < 0) {
                if (b12 < -32) {
                    if (i13 != i12 && b12 >= -62) {
                        i11 = i13 + 1;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return false;
                } else if (b12 < -16) {
                    int i14 = i13 + 1;
                    if (i14 < i12 && (b11 = bArr[i13]) <= -65 && ((b12 != -32 || b11 >= -96) && (b12 != -19 || -96 > b11))) {
                        i11 = i14 + 1;
                        if (bArr[i14] > -65) {
                        }
                    }
                    return false;
                } else if (i13 + 2 >= i12) {
                    return false;
                } else {
                    int i15 = i13 + 1;
                    byte b13 = bArr[i13];
                    if (b13 <= -65 && (((b12 << 28) + (b13 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                        int i16 = i15 + 1;
                        if (bArr[i15] <= -65) {
                            i13 = i16 + 1;
                            if (bArr[i16] > -65) {
                            }
                        }
                    }
                    return false;
                }
            }
            i11 = i13;
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i11) {
        return "Unpaired surrogate at index " + i11;
    }

    public static boolean isWellFormed(byte[] bArr, int i11, int i12) {
        int i13 = i12 + i11;
        Preconditions.checkPositionIndexes(i11, i13, bArr.length);
        while (i11 < i13) {
            if (bArr[i11] < 0) {
                return isWellFormedSlowPath(bArr, i11, i13);
            }
            i11++;
        }
        return true;
    }
}
