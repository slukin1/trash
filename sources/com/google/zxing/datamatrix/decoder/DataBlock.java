package com.google.zxing.datamatrix.decoder;

import com.google.zxing.datamatrix.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i11, byte[] bArr) {
        this.numDataCodewords = i11;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version) {
        Version.ECBlocks eCBlocks = version.getECBlocks();
        Version.ECB[] eCBlocks2 = eCBlocks.getECBlocks();
        int i11 = 0;
        for (Version.ECB count : eCBlocks2) {
            i11 += count.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[i11];
        int i12 = 0;
        for (Version.ECB ecb : eCBlocks2) {
            int i13 = 0;
            while (i13 < ecb.getCount()) {
                int dataCodewords = ecb.getDataCodewords();
                dataBlockArr[i12] = new DataBlock(dataCodewords, new byte[(eCBlocks.getECCodewords() + dataCodewords)]);
                i13++;
                i12++;
            }
        }
        int length = dataBlockArr[0].codewords.length - eCBlocks.getECCodewords();
        int i14 = length - 1;
        int i15 = 0;
        for (int i16 = 0; i16 < i14; i16++) {
            int i17 = 0;
            while (i17 < i12) {
                dataBlockArr[i17].codewords[i16] = bArr[i15];
                i17++;
                i15++;
            }
        }
        boolean z11 = version.getVersionNumber() == 24;
        int i18 = z11 ? 8 : i12;
        int i19 = 0;
        while (i19 < i18) {
            dataBlockArr[i19].codewords[i14] = bArr[i15];
            i19++;
            i15++;
        }
        int length2 = dataBlockArr[0].codewords.length;
        while (length < length2) {
            int i21 = 0;
            while (i21 < i12) {
                int i22 = z11 ? (i21 + 8) % i12 : i21;
                dataBlockArr[i22].codewords[(!z11 || i22 <= 7) ? length : length - 1] = bArr[i15];
                i21++;
                i15++;
            }
            length++;
        }
        if (i15 == bArr.length) {
            return dataBlockArr;
        }
        throw new IllegalArgumentException();
    }

    public byte[] getCodewords() {
        return this.codewords;
    }

    public int getNumDataCodewords() {
        return this.numDataCodewords;
    }
}
