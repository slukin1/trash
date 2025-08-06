package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float moduleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i11 = topLeftOnBit[1];
        int i12 = bottomRightOnBit[1];
        int i13 = topLeftOnBit[0];
        int i14 = bottomRightOnBit[0];
        if (i13 >= i14 || i11 >= i12) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i15 = i12 - i11;
        if (i15 == i14 - i13 || (i14 = i13 + i15) < bitMatrix.getWidth()) {
            int round = Math.round(((float) ((i14 - i13) + 1)) / moduleSize);
            int round2 = Math.round(((float) (i15 + 1)) / moduleSize);
            if (round <= 0 || round2 <= 0) {
                throw NotFoundException.getNotFoundInstance();
            } else if (round2 == round) {
                int i16 = (int) (moduleSize / 2.0f);
                int i17 = i11 + i16;
                int i18 = i13 + i16;
                int i19 = (((int) (((float) (round - 1)) * moduleSize)) + i18) - i14;
                if (i19 > 0) {
                    if (i19 <= i16) {
                        i18 -= i19;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                int i21 = (((int) (((float) (round2 - 1)) * moduleSize)) + i17) - i12;
                if (i21 > 0) {
                    if (i21 <= i16) {
                        i17 -= i21;
                    } else {
                        throw NotFoundException.getNotFoundInstance();
                    }
                }
                BitMatrix bitMatrix2 = new BitMatrix(round, round2);
                for (int i22 = 0; i22 < round2; i22++) {
                    int i23 = ((int) (((float) i22) * moduleSize)) + i17;
                    for (int i24 = 0; i24 < round; i24++) {
                        if (bitMatrix.get(((int) (((float) i24) * moduleSize)) + i18, i23)) {
                            bitMatrix2.set(i24, i22);
                        }
                    }
                }
                return bitMatrix2;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static float moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i11 = iArr[0];
        boolean z11 = true;
        int i12 = iArr[1];
        int i13 = 0;
        while (i11 < width && i12 < height) {
            if (z11 != bitMatrix.get(i11, i12)) {
                i13++;
                if (i13 == 5) {
                    break;
                }
                z11 = !z11;
            }
            i11++;
            i12++;
        }
        if (i11 != width && i12 != height) {
            return ((float) (i11 - iArr[0])) / 7.0f;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, ChecksumException, FormatException {
        return decode(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public final Decoder getDecoder() {
        return this.decoder;
    }

    public void reset() {
    }

    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        ResultPoint[] resultPointArr;
        DecoderResult decoderResult;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            DecoderResult decode = this.decoder.decode(detect.getBits(), map);
            resultPointArr = detect.getPoints();
            decoderResult = decode;
        } else {
            decoderResult = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()), map);
            resultPointArr = NO_POINTS;
        }
        if (decoderResult.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decoderResult.getOther()).applyMirroredCorrection(resultPointArr);
        }
        Result result = new Result(decoderResult.getText(), decoderResult.getRawBytes(), resultPointArr, BarcodeFormat.QR_CODE);
        List<byte[]> byteSegments = decoderResult.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResult.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResult.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResult.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResult.getStructuredAppendParity()));
        }
        return result;
    }
}
