package org.bouncycastle.pqc.crypto.newhope;

import com.tencent.android.tpush.common.Constants;

class Reduce {
    public static final int QInv = 12287;
    public static final int RLog = 18;
    public static final int RMask = 262143;

    public static short barrett(short s11) {
        short s12 = s11 & Constants.PROTOCOL_NONE;
        return (short) (s12 - (((s12 * 5) >>> 16) * Params.Q));
    }

    public static short montgomery(int i11) {
        return (short) (((((i11 * QInv) & RMask) * Params.Q) + i11) >>> 18);
    }
}
