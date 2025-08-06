package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix bitMatrix;
    private boolean mirror;
    private FormatInformation parsedFormatInfo;
    private Version parsedVersion;

    public BitMatrixParser(BitMatrix bitMatrix2) throws FormatException {
        int height = bitMatrix2.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.bitMatrix = bitMatrix2;
    }

    private int copyBit(int i11, int i12, int i13) {
        return this.mirror ? this.bitMatrix.get(i12, i11) : this.bitMatrix.get(i11, i12) ? (i13 << 1) | 1 : i13 << 1;
    }

    public void mirror() {
        int i11 = 0;
        while (i11 < this.bitMatrix.getWidth()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.bitMatrix.getHeight(); i13++) {
                if (this.bitMatrix.get(i11, i13) != this.bitMatrix.get(i13, i11)) {
                    this.bitMatrix.flip(i13, i11);
                    this.bitMatrix.flip(i11, i13);
                }
            }
            i11 = i12;
        }
    }

    public byte[] readCodewords() throws FormatException {
        FormatInformation readFormatInformation = readFormatInformation();
        Version readVersion = readVersion();
        DataMask dataMask = DataMask.values()[readFormatInformation.getDataMask()];
        int height = this.bitMatrix.getHeight();
        dataMask.unmaskBitMatrix(this.bitMatrix, height);
        BitMatrix buildFunctionPattern = readVersion.buildFunctionPattern();
        byte[] bArr = new byte[readVersion.getTotalCodewords()];
        int i11 = height - 1;
        boolean z11 = true;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == 6) {
                i12--;
            }
            for (int i16 = 0; i16 < height; i16++) {
                int i17 = z11 ? i11 - i16 : i16;
                for (int i18 = 0; i18 < 2; i18++) {
                    int i19 = i12 - i18;
                    if (!buildFunctionPattern.get(i19, i17)) {
                        i14++;
                        i15 <<= 1;
                        if (this.bitMatrix.get(i19, i17)) {
                            i15 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i13] = (byte) i15;
                            i13++;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                }
            }
            z11 = !z11;
            i12 -= 2;
        }
        if (i13 == readVersion.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public FormatInformation readFormatInformation() throws FormatException {
        FormatInformation formatInformation = this.parsedFormatInfo;
        if (formatInformation != null) {
            return formatInformation;
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 6; i13++) {
            i12 = copyBit(i13, 8, i12);
        }
        int copyBit = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, i12)));
        for (int i14 = 5; i14 >= 0; i14--) {
            copyBit = copyBit(8, i14, copyBit);
        }
        int height = this.bitMatrix.getHeight();
        int i15 = height - 7;
        for (int i16 = height - 1; i16 >= i15; i16--) {
            i11 = copyBit(8, i16, i11);
        }
        for (int i17 = height - 8; i17 < height; i17++) {
            i11 = copyBit(i17, 8, i11);
        }
        FormatInformation decodeFormatInformation = FormatInformation.decodeFormatInformation(copyBit, i11);
        this.parsedFormatInfo = decodeFormatInformation;
        if (decodeFormatInformation != null) {
            return decodeFormatInformation;
        }
        throw FormatException.getFormatInstance();
    }

    public Version readVersion() throws FormatException {
        Version version = this.parsedVersion;
        if (version != null) {
            return version;
        }
        int height = this.bitMatrix.getHeight();
        int i11 = (height - 17) / 4;
        if (i11 <= 6) {
            return Version.getVersionForNumber(i11);
        }
        int i12 = height - 11;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 5; i15 >= 0; i15--) {
            for (int i16 = height - 9; i16 >= i12; i16--) {
                i14 = copyBit(i16, i15, i14);
            }
        }
        Version decodeVersionInformation = Version.decodeVersionInformation(i14);
        if (decodeVersionInformation == null || decodeVersionInformation.getDimensionForVersion() != height) {
            for (int i17 = 5; i17 >= 0; i17--) {
                for (int i18 = height - 9; i18 >= i12; i18--) {
                    i13 = copyBit(i17, i18, i13);
                }
            }
            Version decodeVersionInformation2 = Version.decodeVersionInformation(i13);
            if (decodeVersionInformation2 == null || decodeVersionInformation2.getDimensionForVersion() != height) {
                throw FormatException.getFormatInstance();
            }
            this.parsedVersion = decodeVersionInformation2;
            return decodeVersionInformation2;
        }
        this.parsedVersion = decodeVersionInformation;
        return decodeVersionInformation;
    }

    public void remask() {
        if (this.parsedFormatInfo != null) {
            DataMask.values()[this.parsedFormatInfo.getDataMask()].unmaskBitMatrix(this.bitMatrix, this.bitMatrix.getHeight());
        }
    }

    public void setMirror(boolean z11) {
        this.parsedVersion = null;
        this.parsedFormatInfo = null;
        this.mirror = z11;
    }
}
