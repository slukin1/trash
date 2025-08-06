package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
    private final BitMatrix mappingBitMatrix;
    private final BitMatrix readMappingMatrix;
    private final Version version;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 8 || height > 144 || (height & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.version = readVersion(bitMatrix);
        BitMatrix extractDataRegion = extractDataRegion(bitMatrix);
        this.mappingBitMatrix = extractDataRegion;
        this.readMappingMatrix = new BitMatrix(extractDataRegion.getWidth(), extractDataRegion.getHeight());
    }

    private BitMatrix extractDataRegion(BitMatrix bitMatrix) {
        int symbolSizeRows = this.version.getSymbolSizeRows();
        int symbolSizeColumns = this.version.getSymbolSizeColumns();
        if (bitMatrix.getHeight() == symbolSizeRows) {
            int dataRegionSizeRows = this.version.getDataRegionSizeRows();
            int dataRegionSizeColumns = this.version.getDataRegionSizeColumns();
            int i11 = symbolSizeRows / dataRegionSizeRows;
            int i12 = symbolSizeColumns / dataRegionSizeColumns;
            BitMatrix bitMatrix2 = new BitMatrix(i12 * dataRegionSizeColumns, i11 * dataRegionSizeRows);
            for (int i13 = 0; i13 < i11; i13++) {
                int i14 = i13 * dataRegionSizeRows;
                for (int i15 = 0; i15 < i12; i15++) {
                    int i16 = i15 * dataRegionSizeColumns;
                    for (int i17 = 0; i17 < dataRegionSizeRows; i17++) {
                        int i18 = ((dataRegionSizeRows + 2) * i13) + 1 + i17;
                        int i19 = i14 + i17;
                        for (int i21 = 0; i21 < dataRegionSizeColumns; i21++) {
                            if (bitMatrix.get(((dataRegionSizeColumns + 2) * i15) + 1 + i21, i18)) {
                                bitMatrix2.set(i16 + i21, i19);
                            }
                        }
                        BitMatrix bitMatrix3 = bitMatrix;
                    }
                    BitMatrix bitMatrix4 = bitMatrix;
                }
                BitMatrix bitMatrix5 = bitMatrix;
            }
            return bitMatrix2;
        }
        throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
    }

    private int readCorner1(int i11, int i12) {
        int i13 = i11 - 1;
        int i14 = (readModule(i13, 0, i11, i12) ? 1 : 0) << true;
        if (readModule(i13, 1, i11, i12)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(i13, 2, i11, i12)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (readModule(0, i12 - 2, i11, i12)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i12 - 1;
        if (readModule(0, i18, i11, i12)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (readModule(1, i18, i11, i12)) {
            i19 |= 1;
        }
        int i21 = i19 << 1;
        if (readModule(2, i18, i11, i12)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return readModule(3, i18, i11, i12) ? i22 | 1 : i22;
    }

    private int readCorner2(int i11, int i12) {
        int i13 = (readModule(i11 + -3, 0, i11, i12) ? 1 : 0) << true;
        if (readModule(i11 - 2, 0, i11, i12)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(i11 - 1, 0, i11, i12)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(0, i12 - 4, i11, i12)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (readModule(0, i12 - 3, i11, i12)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        if (readModule(0, i12 - 2, i11, i12)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        int i19 = i12 - 1;
        if (readModule(0, i19, i11, i12)) {
            i18 |= 1;
        }
        int i21 = i18 << 1;
        return readModule(1, i19, i11, i12) ? i21 | 1 : i21;
    }

    private int readCorner3(int i11, int i12) {
        int i13 = i11 - 1;
        int i14 = (readModule(i13, 0, i11, i12) ? 1 : 0) << true;
        int i15 = i12 - 1;
        if (readModule(i13, i15, i11, i12)) {
            i14 |= 1;
        }
        int i16 = i14 << 1;
        int i17 = i12 - 3;
        if (readModule(0, i17, i11, i12)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i12 - 2;
        if (readModule(0, i19, i11, i12)) {
            i18 |= 1;
        }
        int i21 = i18 << 1;
        if (readModule(0, i15, i11, i12)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (readModule(1, i17, i11, i12)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (readModule(1, i19, i11, i12)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return readModule(1, i15, i11, i12) ? i24 | 1 : i24;
    }

    private int readCorner4(int i11, int i12) {
        int i13 = (readModule(i11 + -3, 0, i11, i12) ? 1 : 0) << true;
        if (readModule(i11 - 2, 0, i11, i12)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (readModule(i11 - 1, 0, i11, i12)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (readModule(0, i12 - 2, i11, i12)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i12 - 1;
        if (readModule(0, i17, i11, i12)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (readModule(1, i17, i11, i12)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (readModule(2, i17, i11, i12)) {
            i19 |= 1;
        }
        int i21 = i19 << 1;
        return readModule(3, i17, i11, i12) ? i21 | 1 : i21;
    }

    private boolean readModule(int i11, int i12, int i13, int i14) {
        if (i11 < 0) {
            i11 += i13;
            i12 += 4 - ((i13 + 4) & 7);
        }
        if (i12 < 0) {
            i12 += i14;
            i11 += 4 - ((i14 + 4) & 7);
        }
        this.readMappingMatrix.set(i12, i11);
        return this.mappingBitMatrix.get(i12, i11);
    }

    private int readUtah(int i11, int i12, int i13, int i14) {
        int i15 = i11 - 2;
        int i16 = i12 - 2;
        int i17 = (readModule(i15, i16, i13, i14) ? 1 : 0) << true;
        int i18 = i12 - 1;
        if (readModule(i15, i18, i13, i14)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        int i21 = i11 - 1;
        if (readModule(i21, i16, i13, i14)) {
            i19 |= 1;
        }
        int i22 = i19 << 1;
        if (readModule(i21, i18, i13, i14)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (readModule(i21, i12, i13, i14)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        if (readModule(i11, i16, i13, i14)) {
            i24 |= 1;
        }
        int i25 = i24 << 1;
        if (readModule(i11, i18, i13, i14)) {
            i25 |= 1;
        }
        int i26 = i25 << 1;
        return readModule(i11, i12, i13, i14) ? i26 | 1 : i26;
    }

    private static Version readVersion(BitMatrix bitMatrix) throws FormatException {
        return Version.getVersionForDimensions(bitMatrix.getHeight(), bitMatrix.getWidth());
    }

    public Version getVersion() {
        return this.version;
    }

    public byte[] readCodewords() throws FormatException {
        byte[] bArr = new byte[this.version.getTotalCodewords()];
        int height = this.mappingBitMatrix.getHeight();
        int width = this.mappingBitMatrix.getWidth();
        int i11 = 0;
        int i12 = 4;
        boolean z11 = false;
        int i13 = 0;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (true) {
            if (i12 == height && i11 == 0 && !z11) {
                bArr[i13] = (byte) readCorner1(height, width);
                i12 -= 2;
                i11 += 2;
                i13++;
                z11 = true;
            } else {
                int i14 = height - 2;
                if (i12 == i14 && i11 == 0 && (width & 3) != 0 && !z12) {
                    bArr[i13] = (byte) readCorner2(height, width);
                    i12 -= 2;
                    i11 += 2;
                    i13++;
                    z12 = true;
                } else if (i12 == height + 4 && i11 == 2 && (width & 7) == 0 && !z13) {
                    bArr[i13] = (byte) readCorner3(height, width);
                    i12 -= 2;
                    i11 += 2;
                    i13++;
                    z13 = true;
                } else if (i12 == i14 && i11 == 0 && (width & 7) == 4 && !z14) {
                    bArr[i13] = (byte) readCorner4(height, width);
                    i12 -= 2;
                    i11 += 2;
                    i13++;
                    z14 = true;
                } else {
                    do {
                        if (i12 < height && i11 >= 0 && !this.readMappingMatrix.get(i11, i12)) {
                            bArr[i13] = (byte) readUtah(i12, i11, height, width);
                            i13++;
                        }
                        i12 -= 2;
                        i11 += 2;
                        if (i12 < 0) {
                            break;
                        }
                    } while (i11 < width);
                    int i15 = i12 + 1;
                    int i16 = i11 + 3;
                    do {
                        if (i15 >= 0 && i16 < width && !this.readMappingMatrix.get(i16, i15)) {
                            bArr[i13] = (byte) readUtah(i15, i16, height, width);
                            i13++;
                        }
                        i15 += 2;
                        i16 -= 2;
                        if (i15 >= height) {
                            break;
                        }
                    } while (i16 >= 0);
                    i12 = i15 + 3;
                    i11 = i16 + 1;
                }
            }
            if (i12 >= height && i11 >= width) {
                break;
            }
        }
        if (i13 == this.version.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }
}
