package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class PDF417ScanningDecoder {
    private static final int CODEWORD_SKEW_SIZE = 2;
    private static final int MAX_EC_CODEWORDS = 512;
    private static final int MAX_ERRORS = 3;
    private static final ErrorCorrection errorCorrection = new ErrorCorrection();

    private PDF417ScanningDecoder() {
    }

    private static BoundingBox adjustBoundingBox(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] rowHeights;
        if (detectionResultRowIndicatorColumn == null || (rowHeights = detectionResultRowIndicatorColumn.getRowHeights()) == null) {
            return null;
        }
        int max = getMax(rowHeights);
        int i11 = 0;
        int i12 = 0;
        for (int i13 : rowHeights) {
            i12 += max - i13;
            if (i13 > 0) {
                break;
            }
        }
        Codeword[] codewords = detectionResultRowIndicatorColumn.getCodewords();
        int i14 = 0;
        while (i12 > 0 && codewords[i14] == null) {
            i12--;
            i14++;
        }
        for (int length = rowHeights.length - 1; length >= 0; length--) {
            i11 += max - rowHeights[length];
            if (rowHeights[length] > 0) {
                break;
            }
        }
        int length2 = codewords.length - 1;
        while (i11 > 0 && codewords[length2] == null) {
            i11--;
            length2--;
        }
        return detectionResultRowIndicatorColumn.getBoundingBox().addMissingRows(i12, i11, detectionResultRowIndicatorColumn.isLeft());
    }

    private static void adjustCodewordCount(DetectionResult detectionResult, BarcodeValue[][] barcodeValueArr) throws NotFoundException {
        BarcodeValue barcodeValue = barcodeValueArr[0][1];
        int[] value = barcodeValue.getValue();
        int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * detectionResult.getBarcodeRowCount()) - getNumberOfECCodeWords(detectionResult.getBarcodeECLevel());
        if (value.length == 0) {
            if (barcodeColumnCount <= 0 || barcodeColumnCount > 928) {
                throw NotFoundException.getNotFoundInstance();
            }
            barcodeValue.setValue(barcodeColumnCount);
        } else if (value[0] != barcodeColumnCount) {
            barcodeValue.setValue(barcodeColumnCount);
        }
    }

    private static int adjustCodewordStartColumn(BitMatrix bitMatrix, int i11, int i12, boolean z11, int i13, int i14) {
        int i15 = z11 ? -1 : 1;
        int i16 = i13;
        for (int i17 = 0; i17 < 2; i17++) {
            while (true) {
                if (!z11) {
                    if (i16 >= i12) {
                        continue;
                        break;
                    }
                } else if (i16 < i11) {
                    continue;
                    break;
                }
                if (z11 != bitMatrix.get(i16, i14)) {
                    continue;
                    break;
                } else if (Math.abs(i13 - i16) > 2) {
                    return i13;
                } else {
                    i16 += i15;
                }
            }
            i15 = -i15;
            z11 = !z11;
        }
        return i16;
    }

    private static boolean checkCodewordSkew(int i11, int i12, int i13) {
        return i12 + -2 <= i11 && i11 <= i13 + 2;
    }

    private static int correctErrors(int[] iArr, int[] iArr2, int i11) throws ChecksumException {
        if ((iArr2 == null || iArr2.length <= (i11 / 2) + 3) && i11 >= 0 && i11 <= 512) {
            return errorCorrection.decode(iArr, i11, iArr2);
        }
        throw ChecksumException.getChecksumInstance();
    }

    private static BarcodeValue[][] createBarcodeMatrix(DetectionResult detectionResult) {
        int rowNumber;
        int barcodeRowCount = detectionResult.getBarcodeRowCount();
        int[] iArr = new int[2];
        iArr[1] = detectionResult.getBarcodeColumnCount() + 2;
        iArr[0] = barcodeRowCount;
        BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance(BarcodeValue.class, iArr);
        for (int i11 = 0; i11 < barcodeValueArr.length; i11++) {
            for (int i12 = 0; i12 < barcodeValueArr[i11].length; i12++) {
                barcodeValueArr[i11][i12] = new BarcodeValue();
            }
        }
        int i13 = 0;
        for (DetectionResultColumn detectionResultColumn : detectionResult.getDetectionResultColumns()) {
            if (detectionResultColumn != null) {
                for (Codeword codeword : detectionResultColumn.getCodewords()) {
                    if (codeword != null && (rowNumber = codeword.getRowNumber()) >= 0 && rowNumber < barcodeValueArr.length) {
                        barcodeValueArr[rowNumber][i13].setValue(codeword.getValue());
                    }
                }
            }
            i13++;
        }
        return barcodeValueArr;
    }

    private static DecoderResult createDecoderResult(DetectionResult detectionResult) throws FormatException, ChecksumException, NotFoundException {
        BarcodeValue[][] createBarcodeMatrix = createBarcodeMatrix(detectionResult);
        adjustCodewordCount(detectionResult, createBarcodeMatrix);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[(detectionResult.getBarcodeRowCount() * detectionResult.getBarcodeColumnCount())];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i11 = 0; i11 < detectionResult.getBarcodeRowCount(); i11++) {
            int i12 = 0;
            while (i12 < detectionResult.getBarcodeColumnCount()) {
                int i13 = i12 + 1;
                int[] value = createBarcodeMatrix[i11][i13].getValue();
                int barcodeColumnCount = (detectionResult.getBarcodeColumnCount() * i11) + i12;
                if (value.length == 0) {
                    arrayList.add(Integer.valueOf(barcodeColumnCount));
                } else if (value.length == 1) {
                    iArr[barcodeColumnCount] = value[0];
                } else {
                    arrayList3.add(Integer.valueOf(barcodeColumnCount));
                    arrayList2.add(value);
                }
                i12 = i13;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i14 = 0; i14 < size; i14++) {
            iArr2[i14] = (int[]) arrayList2.get(i14);
        }
        return createDecoderResultFromAmbiguousValues(detectionResult.getBarcodeECLevel(), iArr, PDF417Common.toIntArray(arrayList), PDF417Common.toIntArray(arrayList3), iArr2);
    }

    private static DecoderResult createDecoderResultFromAmbiguousValues(int i11, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws FormatException, ChecksumException {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i12 = 100;
        while (true) {
            int i13 = i12 - 1;
            if (i12 > 0) {
                for (int i14 = 0; i14 < length; i14++) {
                    iArr[iArr3[i14]] = iArr4[i14][iArr5[i14]];
                }
                try {
                    return decodeCodewords(iArr, i11, iArr2);
                } catch (ChecksumException unused) {
                    if (length != 0) {
                        int i15 = 0;
                        while (true) {
                            if (i15 >= length) {
                                break;
                            } else if (iArr5[i15] < iArr4[i15].length - 1) {
                                iArr5[i15] = iArr5[i15] + 1;
                                break;
                            } else {
                                iArr5[i15] = 0;
                                if (i15 != length - 1) {
                                    i15++;
                                } else {
                                    throw ChecksumException.getChecksumInstance();
                                }
                            }
                        }
                        i12 = i13;
                    } else {
                        throw ChecksumException.getChecksumInstance();
                    }
                }
            } else {
                throw ChecksumException.getChecksumInstance();
            }
        }
    }

    public static DecoderResult decode(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i11, int i12) throws NotFoundException, FormatException, ChecksumException {
        DetectionResultColumn detectionResultColumn;
        int i13;
        int i14;
        int i15;
        int i16;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = null;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2 = null;
        DetectionResult detectionResult = null;
        int i17 = 0;
        BoundingBox boundingBox = new BoundingBox(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
        while (true) {
            if (i17 >= 2) {
                break;
            }
            if (resultPoint != null) {
                detectionResultRowIndicatorColumn = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint, true, i11, i12);
            }
            if (resultPoint3 != null) {
                detectionResultRowIndicatorColumn2 = getRowIndicatorColumn(bitMatrix, boundingBox, resultPoint3, false, i11, i12);
            }
            detectionResult = merge(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2);
            if (detectionResult == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i17 != 0 || detectionResult.getBoundingBox() == null || (detectionResult.getBoundingBox().getMinY() >= boundingBox.getMinY() && detectionResult.getBoundingBox().getMaxY() <= boundingBox.getMaxY())) {
                detectionResult.setBoundingBox(boundingBox);
            } else {
                boundingBox = detectionResult.getBoundingBox();
                i17++;
            }
        }
        detectionResult.setBoundingBox(boundingBox);
        int barcodeColumnCount = detectionResult.getBarcodeColumnCount() + 1;
        detectionResult.setDetectionResultColumn(0, detectionResultRowIndicatorColumn);
        detectionResult.setDetectionResultColumn(barcodeColumnCount, detectionResultRowIndicatorColumn2);
        boolean z11 = detectionResultRowIndicatorColumn != null;
        int i18 = i11;
        int i19 = i12;
        for (int i21 = 1; i21 <= barcodeColumnCount; i21++) {
            int i22 = z11 ? i21 : barcodeColumnCount - i21;
            if (detectionResult.getDetectionResultColumn(i22) == null) {
                if (i22 == 0 || i22 == barcodeColumnCount) {
                    detectionResultColumn = new DetectionResultRowIndicatorColumn(boundingBox, i22 == 0);
                } else {
                    detectionResultColumn = new DetectionResultColumn(boundingBox);
                }
                detectionResult.setDetectionResultColumn(i22, detectionResultColumn);
                int i23 = -1;
                int minY = boundingBox.getMinY();
                int i24 = -1;
                while (minY <= boundingBox.getMaxY()) {
                    int startColumn = getStartColumn(detectionResult, i22, minY, z11);
                    if (startColumn >= 0 && startColumn <= boundingBox.getMaxX()) {
                        i16 = startColumn;
                    } else if (i24 != i23) {
                        i16 = i24;
                    } else {
                        i15 = i24;
                        i14 = minY;
                        i13 = i23;
                        i24 = i15;
                        minY = i14 + 1;
                        i23 = i13;
                    }
                    i15 = i24;
                    int i25 = minY;
                    i13 = i23;
                    Codeword detectCodeword = detectCodeword(bitMatrix, boundingBox.getMinX(), boundingBox.getMaxX(), z11, i16, i25, i18, i19);
                    i14 = i25;
                    if (detectCodeword != null) {
                        detectionResultColumn.setCodeword(i14, detectCodeword);
                        i18 = Math.min(i18, detectCodeword.getWidth());
                        i19 = Math.max(i19, detectCodeword.getWidth());
                        i24 = i16;
                        minY = i14 + 1;
                        i23 = i13;
                    }
                    i24 = i15;
                    minY = i14 + 1;
                    i23 = i13;
                }
            }
        }
        return createDecoderResult(detectionResult);
    }

    private static DecoderResult decodeCodewords(int[] iArr, int i11, int[] iArr2) throws FormatException, ChecksumException {
        if (iArr.length != 0) {
            int i12 = 1 << (i11 + 1);
            int correctErrors = correctErrors(iArr, iArr2, i12);
            verifyCodewordCount(iArr, i12);
            DecoderResult decode = DecodedBitStreamParser.decode(iArr, String.valueOf(i11));
            decode.setErrorsCorrected(Integer.valueOf(correctErrors));
            decode.setErasures(Integer.valueOf(iArr2.length));
            return decode;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(r7);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.zxing.pdf417.decoder.Codeword detectCodeword(com.google.zxing.common.BitMatrix r7, int r8, int r9, boolean r10, int r11, int r12, int r13, int r14) {
        /*
            int r11 = adjustCodewordStartColumn(r7, r8, r9, r10, r11, r12)
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            int[] r7 = getModuleBitCount(r0, r1, r2, r3, r4, r5)
            r8 = 0
            if (r7 != 0) goto L_0x0012
            return r8
        L_0x0012:
            int r9 = com.google.zxing.common.detector.MathUtils.sum(r7)
            if (r10 == 0) goto L_0x001b
            int r10 = r11 + r9
            goto L_0x0039
        L_0x001b:
            r10 = 0
        L_0x001c:
            int r12 = r7.length
            int r12 = r12 / 2
            if (r10 >= r12) goto L_0x0034
            r12 = r7[r10]
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r0 = r7[r0]
            r7[r10] = r0
            int r0 = r7.length
            int r0 = r0 + -1
            int r0 = r0 - r10
            r7[r0] = r12
            int r10 = r10 + 1
            goto L_0x001c
        L_0x0034:
            int r10 = r11 - r9
            r6 = r11
            r11 = r10
            r10 = r6
        L_0x0039:
            boolean r9 = checkCodewordSkew(r9, r13, r14)
            if (r9 != 0) goto L_0x0040
            return r8
        L_0x0040:
            int r7 = com.google.zxing.pdf417.decoder.PDF417CodewordDecoder.getDecodedValue(r7)
            int r9 = com.google.zxing.pdf417.PDF417Common.getCodeword(r7)
            r12 = -1
            if (r9 != r12) goto L_0x004c
            return r8
        L_0x004c:
            com.google.zxing.pdf417.decoder.Codeword r8 = new com.google.zxing.pdf417.decoder.Codeword
            int r7 = getCodewordBucketNumber((int) r7)
            r8.<init>(r11, r10, r7, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.detectCodeword(com.google.zxing.common.BitMatrix, int, int, boolean, int, int, int, int):com.google.zxing.pdf417.decoder.Codeword");
    }

    private static BarcodeMetadata getBarcodeMetadata(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) {
        BarcodeMetadata barcodeMetadata;
        BarcodeMetadata barcodeMetadata2;
        if (detectionResultRowIndicatorColumn == null || (barcodeMetadata = detectionResultRowIndicatorColumn.getBarcodeMetadata()) == null) {
            if (detectionResultRowIndicatorColumn2 == null) {
                return null;
            }
            return detectionResultRowIndicatorColumn2.getBarcodeMetadata();
        } else if (detectionResultRowIndicatorColumn2 == null || (barcodeMetadata2 = detectionResultRowIndicatorColumn2.getBarcodeMetadata()) == null || barcodeMetadata.getColumnCount() == barcodeMetadata2.getColumnCount() || barcodeMetadata.getErrorCorrectionLevel() == barcodeMetadata2.getErrorCorrectionLevel() || barcodeMetadata.getRowCount() == barcodeMetadata2.getRowCount()) {
            return barcodeMetadata;
        } else {
            return null;
        }
    }

    private static int[] getBitCountForCodeword(int i11) {
        int[] iArr = new int[8];
        int i12 = 0;
        int i13 = 7;
        while (true) {
            int i14 = i11 & 1;
            if (i14 != i12) {
                i13--;
                if (i13 < 0) {
                    return iArr;
                }
                i12 = i14;
            }
            iArr[i13] = iArr[i13] + 1;
            i11 >>= 1;
        }
    }

    private static int getCodewordBucketNumber(int i11) {
        return getCodewordBucketNumber(getBitCountForCodeword(i11));
    }

    private static int getMax(int[] iArr) {
        int i11 = -1;
        for (int max : iArr) {
            i11 = Math.max(i11, max);
        }
        return i11;
    }

    private static int[] getModuleBitCount(BitMatrix bitMatrix, int i11, int i12, boolean z11, int i13, int i14) {
        int[] iArr = new int[8];
        int i15 = z11 ? 1 : -1;
        int i16 = 0;
        boolean z12 = z11;
        while (true) {
            if (!z11) {
                if (i13 < i11) {
                    break;
                }
            } else if (i13 >= i12) {
                break;
            }
            if (i16 >= 8) {
                break;
            } else if (bitMatrix.get(i13, i14) == z12) {
                iArr[i16] = iArr[i16] + 1;
                i13 += i15;
            } else {
                i16++;
                z12 = !z12;
            }
        }
        if (i16 != 8) {
            if (z11) {
                i11 = i12;
            }
            if (!(i13 == i11 && i16 == 7)) {
                return null;
            }
        }
        return iArr;
    }

    private static int getNumberOfECCodeWords(int i11) {
        return 2 << i11;
    }

    private static DetectionResultRowIndicatorColumn getRowIndicatorColumn(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z11, int i11, int i12) {
        int i13;
        boolean z12 = z11;
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z12);
        int i14 = 0;
        while (i14 < 2) {
            int i15 = i14 == 0 ? 1 : -1;
            int x11 = (int) resultPoint.getX();
            int y11 = (int) resultPoint.getY();
            while (y11 <= boundingBox.getMaxY() && y11 >= boundingBox.getMinY()) {
                Codeword detectCodeword = detectCodeword(bitMatrix, 0, bitMatrix.getWidth(), z11, x11, y11, i11, i12);
                if (detectCodeword != null) {
                    detectionResultRowIndicatorColumn.setCodeword(y11, detectCodeword);
                    if (z12) {
                        i13 = detectCodeword.getStartX();
                    } else {
                        i13 = detectCodeword.getEndX();
                    }
                    x11 = i13;
                }
                y11 += i15;
            }
            i14++;
        }
        return detectionResultRowIndicatorColumn;
    }

    private static int getStartColumn(DetectionResult detectionResult, int i11, int i12, boolean z11) {
        int i13 = z11 ? 1 : -1;
        Codeword codeword = null;
        int i14 = i11 - i13;
        if (isValidBarcodeColumn(detectionResult, i14)) {
            codeword = detectionResult.getDetectionResultColumn(i14).getCodeword(i12);
        }
        if (codeword != null) {
            return z11 ? codeword.getEndX() : codeword.getStartX();
        }
        Codeword codewordNearby = detectionResult.getDetectionResultColumn(i11).getCodewordNearby(i12);
        if (codewordNearby != null) {
            return z11 ? codewordNearby.getStartX() : codewordNearby.getEndX();
        }
        if (isValidBarcodeColumn(detectionResult, i14)) {
            codewordNearby = detectionResult.getDetectionResultColumn(i14).getCodewordNearby(i12);
        }
        if (codewordNearby != null) {
            return z11 ? codewordNearby.getEndX() : codewordNearby.getStartX();
        }
        int i15 = 0;
        while (true) {
            i11 -= i13;
            if (isValidBarcodeColumn(detectionResult, i11)) {
                for (Codeword codeword2 : detectionResult.getDetectionResultColumn(i11).getCodewords()) {
                    if (codeword2 != null) {
                        return (z11 ? codeword2.getEndX() : codeword2.getStartX()) + (i13 * i15 * (codeword2.getEndX() - codeword2.getStartX()));
                    }
                }
                i15++;
            } else {
                BoundingBox boundingBox = detectionResult.getBoundingBox();
                return z11 ? boundingBox.getMinX() : boundingBox.getMaxX();
            }
        }
    }

    private static boolean isValidBarcodeColumn(DetectionResult detectionResult, int i11) {
        return i11 >= 0 && i11 <= detectionResult.getBarcodeColumnCount() + 1;
    }

    private static DetectionResult merge(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn, DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2) throws NotFoundException {
        BarcodeMetadata barcodeMetadata;
        if ((detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumn2 == null) || (barcodeMetadata = getBarcodeMetadata(detectionResultRowIndicatorColumn, detectionResultRowIndicatorColumn2)) == null) {
            return null;
        }
        return new DetectionResult(barcodeMetadata, BoundingBox.merge(adjustBoundingBox(detectionResultRowIndicatorColumn), adjustBoundingBox(detectionResultRowIndicatorColumn2)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        r9.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0070, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toString(com.google.zxing.pdf417.decoder.BarcodeValue[][] r9) {
        /*
            java.util.Formatter r0 = new java.util.Formatter
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x0007:
            int r3 = r9.length     // Catch:{ all -> 0x0065 }
            if (r2 >= r3) goto L_0x005d
            java.lang.String r3 = "Row %2d: "
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x0065 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0065 }
            r5[r1] = r6     // Catch:{ all -> 0x0065 }
            r0.format(r3, r5)     // Catch:{ all -> 0x0065 }
            r3 = r1
        L_0x0019:
            r5 = r9[r2]     // Catch:{ all -> 0x0065 }
            int r5 = r5.length     // Catch:{ all -> 0x0065 }
            if (r3 >= r5) goto L_0x0053
            r5 = r9[r2]     // Catch:{ all -> 0x0065 }
            r5 = r5[r3]     // Catch:{ all -> 0x0065 }
            int[] r6 = r5.getValue()     // Catch:{ all -> 0x0065 }
            int r6 = r6.length     // Catch:{ all -> 0x0065 }
            if (r6 != 0) goto L_0x0030
            java.lang.String r5 = "        "
            r6 = 0
            r0.format(r5, r6)     // Catch:{ all -> 0x0065 }
            goto L_0x0050
        L_0x0030:
            java.lang.String r6 = "%4d(%2d)"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0065 }
            int[] r8 = r5.getValue()     // Catch:{ all -> 0x0065 }
            r8 = r8[r1]     // Catch:{ all -> 0x0065 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0065 }
            r7[r1] = r8     // Catch:{ all -> 0x0065 }
            int[] r8 = r5.getValue()     // Catch:{ all -> 0x0065 }
            r8 = r8[r1]     // Catch:{ all -> 0x0065 }
            java.lang.Integer r5 = r5.getConfidence(r8)     // Catch:{ all -> 0x0065 }
            r7[r4] = r5     // Catch:{ all -> 0x0065 }
            r0.format(r6, r7)     // Catch:{ all -> 0x0065 }
        L_0x0050:
            int r3 = r3 + 1
            goto L_0x0019
        L_0x0053:
            java.lang.String r3 = "%n"
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x0065 }
            r0.format(r3, r4)     // Catch:{ all -> 0x0065 }
            int r2 = r2 + 1
            goto L_0x0007
        L_0x005d:
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0065 }
            r0.close()
            return r9
        L_0x0065:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r1 = move-exception
            r0.close()     // Catch:{ all -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r0 = move-exception
            r9.addSuppressed(r0)
        L_0x0070:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.PDF417ScanningDecoder.toString(com.google.zxing.pdf417.decoder.BarcodeValue[][]):java.lang.String");
    }

    private static void verifyCodewordCount(int[] iArr, int i11) throws FormatException {
        if (iArr.length >= 4) {
            int i12 = iArr[0];
            if (i12 > iArr.length) {
                throw FormatException.getFormatInstance();
            } else if (i12 != 0) {
            } else {
                if (i11 < iArr.length) {
                    iArr[0] = iArr.length - i11;
                    return;
                }
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int getCodewordBucketNumber(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }
}
