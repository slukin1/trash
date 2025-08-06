package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i11, int i12, int i13) {
        boolean z11;
        float f11;
        float f12;
        int i14;
        int i15;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i16 = i11;
        int i17 = i12;
        int i18 = i13;
        if (i18 <= 4) {
            try {
                Result decode = this.delegate.decode(binaryBitmap2, map);
                Iterator<Result> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().getText().equals(decode.getText())) {
                            z11 = true;
                            break;
                        }
                    } else {
                        z11 = false;
                        break;
                    }
                }
                if (!z11) {
                    list.add(translateResultPoints(decode, i16, i17));
                } else {
                    List<Result> list2 = list;
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f13 = (float) width;
                    float f14 = 0.0f;
                    float f15 = (float) height;
                    float f16 = 0.0f;
                    for (ResultPoint resultPoint : resultPoints) {
                        if (resultPoint != null) {
                            float x11 = resultPoint.getX();
                            float y11 = resultPoint.getY();
                            if (x11 < f13) {
                                f13 = x11;
                            }
                            if (y11 < f15) {
                                f15 = y11;
                            }
                            if (x11 > f16) {
                                f16 = x11;
                            }
                            if (y11 > f14) {
                                f14 = y11;
                            }
                        }
                    }
                    if (f13 > 100.0f) {
                        f11 = f16;
                        f12 = f15;
                        i15 = height;
                        i14 = width;
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, (int) f13, height), map, list, i11, i12, i18 + 1);
                    } else {
                        f11 = f16;
                        f12 = f15;
                        i15 = height;
                        i14 = width;
                    }
                    if (f12 > 100.0f) {
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, i14, (int) f12), map, list, i11, i12, i18 + 1);
                    }
                    float f17 = f11;
                    if (f17 < ((float) (i14 - 100))) {
                        int i19 = (int) f17;
                        doDecodeMultiple(binaryBitmap2.crop(i19, 0, i14 - i19, i15), map, list, i16 + i19, i12, i18 + 1);
                    }
                    if (f14 < ((float) (i15 - 100))) {
                        int i21 = (int) f14;
                        doDecodeMultiple(binaryBitmap2.crop(0, i21, i14, i15 - i21), map, list, i11, i17 + i21, i18 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    private static Result translateResultPoints(Result result, int i11, int i12) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i13 = 0; i13 < resultPoints.length; i13++) {
            ResultPoint resultPoint = resultPoints[i13];
            if (resultPoint != null) {
                resultPointArr[i13] = new ResultPoint(resultPoint.getX() + ((float) i11), resultPoint.getY() + ((float) i12));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
