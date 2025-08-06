package org.bouncycastle.crypto.modes.gcm;

import java.util.ArrayList;
import java.util.List;

public class Tables1kGCMExponentiator implements GCMExponentiator {
    private List lookupPowX2;

    private long[] getPowX2(int i11) {
        int size = this.lookupPowX2.size() - 1;
        if (size < i11) {
            long[] jArr = (long[]) this.lookupPowX2.get(size);
            while (true) {
                long[] jArr2 = new long[2];
                GCMUtil.square(jArr, jArr2);
                this.lookupPowX2.add(jArr2);
                size++;
                if (size >= i11) {
                    break;
                }
                jArr = jArr2;
            }
        }
        return (long[]) this.lookupPowX2.get(i11);
    }

    public void exponentiateX(long j11, byte[] bArr) {
        long[] oneAsLongs = GCMUtil.oneAsLongs();
        int i11 = 0;
        while (j11 > 0) {
            if ((1 & j11) != 0) {
                GCMUtil.multiply(oneAsLongs, getPowX2(i11));
            }
            i11++;
            j11 >>>= 1;
        }
        GCMUtil.asBytes(oneAsLongs, bArr);
    }

    public void init(byte[] bArr) {
        long[] asLongs = GCMUtil.asLongs(bArr);
        List list = this.lookupPowX2;
        if (list == null || 0 == GCMUtil.areEqual(asLongs, (long[]) list.get(0))) {
            ArrayList arrayList = new ArrayList(8);
            this.lookupPowX2 = arrayList;
            arrayList.add(asLongs);
        }
    }
}
