package com.google.zxing.qrcode.decoder;

import com.google.zxing.qrcode.decoder.Version;

final class DataBlock {
    private final byte[] codewords;
    private final int numDataCodewords;

    private DataBlock(int i11, byte[] bArr) {
        this.numDataCodewords = i11;
        this.codewords = bArr;
    }

    public static DataBlock[] getDataBlocks(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length == version.getTotalCodewords()) {
            Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
            Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
            int i11 = 0;
            for (Version.ECB count : eCBlocks) {
                i11 += count.getCount();
            }
            DataBlock[] dataBlockArr = new DataBlock[i11];
            int i12 = 0;
            for (Version.ECB ecb : eCBlocks) {
                int i13 = 0;
                while (i13 < ecb.getCount()) {
                    int dataCodewords = ecb.getDataCodewords();
                    dataBlockArr[i12] = new DataBlock(dataCodewords, new byte[(eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords)]);
                    i13++;
                    i12++;
                }
            }
            int length = dataBlockArr[0].codewords.length;
            int i14 = i11 - 1;
            while (i14 >= 0 && dataBlockArr[i14].codewords.length != length) {
                i14--;
            }
            int i15 = i14 + 1;
            int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
            int i16 = 0;
            for (int i17 = 0; i17 < eCCodewordsPerBlock; i17++) {
                int i18 = 0;
                while (i18 < i12) {
                    dataBlockArr[i18].codewords[i17] = bArr[i16];
                    i18++;
                    i16++;
                }
            }
            int i19 = i15;
            while (i19 < i12) {
                dataBlockArr[i19].codewords[eCCodewordsPerBlock] = bArr[i16];
                i19++;
                i16++;
            }
            int length2 = dataBlockArr[0].codewords.length;
            while (eCCodewordsPerBlock < length2) {
                int i21 = 0;
                while (i21 < i12) {
                    dataBlockArr[i21].codewords[i21 < i15 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i16];
                    i21++;
                    i16++;
                }
                eCCodewordsPerBlock++;
            }
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
