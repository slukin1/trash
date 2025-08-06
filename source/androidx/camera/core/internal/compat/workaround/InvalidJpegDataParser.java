package androidx.camera.core.internal.compat.workaround;

import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;

public class InvalidJpegDataParser {
    private final boolean mHasQuirk;

    public InvalidJpegDataParser() {
        this.mHasQuirk = DeviceQuirks.get(LargeJpegImageQuirk.class) != null;
    }

    public int getValidDataLength(byte[] bArr) {
        if (!this.mHasQuirk) {
            return bArr.length;
        }
        int i11 = 2;
        while (i11 + 4 <= bArr.length && bArr[i11] == -1) {
            int i12 = i11 + 2;
            byte b11 = ((bArr[i12] & 255) << 8) | (bArr[i11 + 3] & 255);
            if (bArr[i11] == -1 && bArr[i11 + 1] == -38) {
                while (true) {
                    int i13 = i12 + 2;
                    if (i13 > bArr.length) {
                        return bArr.length;
                    }
                    if (bArr[i12] == -1 && bArr[i12 + 1] == -39) {
                        return i13;
                    }
                    i12++;
                }
            } else {
                i11 += b11 + 2;
            }
        }
        return bArr.length;
    }
}
