package com.google.zxing.multi.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.multi.qrcode.detector.MultiDetector;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class QRCodeMultiReader extends QRCodeReader implements MultipleBarcodeReader {
    private static final Result[] EMPTY_RESULT_ARRAY = new Result[0];
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];

    public static final class SAComparator implements Serializable, Comparator<Result> {
        private SAComparator() {
        }

        public int compare(Result result, Result result2) {
            Map<ResultMetadataType, Object> resultMetadata = result.getResultMetadata();
            ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
            return Integer.compare(((Integer) resultMetadata.get(resultMetadataType)).intValue(), ((Integer) result2.getResultMetadata().get(resultMetadataType)).intValue());
        }
    }

    private static List<Result> processStructuredAppend(List<Result> list) {
        boolean z11;
        Iterator<Result> it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                    z11 = true;
                    break;
                }
            } else {
                z11 = false;
                break;
            }
        }
        if (!z11) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<Result> arrayList2 = new ArrayList<>();
        for (Result next : list) {
            arrayList.add(next);
            if (next.getResultMetadata().containsKey(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE)) {
                arrayList2.add(next);
            }
        }
        Collections.sort(arrayList2, new SAComparator());
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        int i12 = 0;
        for (Result result : arrayList2) {
            sb2.append(result.getText());
            i11 += result.getRawBytes().length;
            Map<ResultMetadataType, Object> resultMetadata = result.getResultMetadata();
            ResultMetadataType resultMetadataType = ResultMetadataType.BYTE_SEGMENTS;
            if (resultMetadata.containsKey(resultMetadataType)) {
                for (byte[] length : (Iterable) result.getResultMetadata().get(resultMetadataType)) {
                    i12 += length.length;
                }
            }
        }
        byte[] bArr = new byte[i11];
        byte[] bArr2 = new byte[i12];
        int i13 = 0;
        int i14 = 0;
        for (Result result2 : arrayList2) {
            System.arraycopy(result2.getRawBytes(), 0, bArr, i13, result2.getRawBytes().length);
            i13 += result2.getRawBytes().length;
            Map<ResultMetadataType, Object> resultMetadata2 = result2.getResultMetadata();
            ResultMetadataType resultMetadataType2 = ResultMetadataType.BYTE_SEGMENTS;
            if (resultMetadata2.containsKey(resultMetadataType2)) {
                for (byte[] bArr3 : (Iterable) result2.getResultMetadata().get(resultMetadataType2)) {
                    System.arraycopy(bArr3, 0, bArr2, i14, bArr3.length);
                    i14 += bArr3.length;
                }
            }
        }
        Result result3 = new Result(sb2.toString(), bArr, NO_POINTS, BarcodeFormat.QR_CODE);
        if (i12 > 0) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(bArr2);
            result3.putMetadata(ResultMetadataType.BYTE_SEGMENTS, arrayList3);
        }
        arrayList.add(result3);
        return arrayList;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        for (DetectorResult detectorResult : new MultiDetector(binaryBitmap.getBlackMatrix()).detectMulti(map)) {
            try {
                DecoderResult decode = getDecoder().decode(detectorResult.getBits(), map);
                ResultPoint[] points = detectorResult.getPoints();
                if (decode.getOther() instanceof QRCodeDecoderMetaData) {
                    ((QRCodeDecoderMetaData) decode.getOther()).applyMirroredCorrection(points);
                }
                Result result = new Result(decode.getText(), decode.getRawBytes(), points, BarcodeFormat.QR_CODE);
                List<byte[]> byteSegments = decode.getByteSegments();
                if (byteSegments != null) {
                    result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
                }
                String eCLevel = decode.getECLevel();
                if (eCLevel != null) {
                    result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
                }
                if (decode.hasStructuredAppend()) {
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decode.getStructuredAppendSequenceNumber()));
                    result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decode.getStructuredAppendParity()));
                }
                arrayList.add(result);
            } catch (ReaderException unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        List<Result> processStructuredAppend = processStructuredAppend(arrayList);
        return (Result[]) processStructuredAppend.toArray(new Result[processStructuredAppend.size()]);
    }
}
