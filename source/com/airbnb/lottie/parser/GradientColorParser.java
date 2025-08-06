package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int i11) {
        this.colorPoints = i11;
    }

    private GradientColor addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        int i11 = this.colorPoints * 4;
        if (list.size() <= i11) {
            return gradientColor;
        }
        float[] positions = gradientColor.getPositions();
        int[] colors = gradientColor.getColors();
        int size = (list.size() - i11) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i12 = 0;
        while (i11 < list.size()) {
            if (i11 % 2 == 0) {
                fArr[i12] = list.get(i11).floatValue();
            } else {
                fArr2[i12] = list.get(i11).floatValue();
                i12++;
            }
            i11++;
        }
        float[] mergeUniqueElements = mergeUniqueElements(gradientColor.getPositions(), fArr);
        int length = mergeUniqueElements.length;
        int[] iArr = new int[length];
        for (int i13 = 0; i13 < length; i13++) {
            float f11 = mergeUniqueElements[i13];
            int binarySearch = Arrays.binarySearch(positions, f11);
            int binarySearch2 = Arrays.binarySearch(fArr, f11);
            if (binarySearch < 0 || binarySearch2 > 0) {
                if (binarySearch2 < 0) {
                    binarySearch2 = -(binarySearch2 + 1);
                }
                iArr[i13] = getColorInBetweenColorStops(f11, fArr2[binarySearch2], positions, colors);
            } else {
                iArr[i13] = getColorInBetweenOpacityStops(f11, colors[binarySearch], fArr, fArr2);
            }
        }
        return new GradientColor(mergeUniqueElements, iArr);
    }

    private int getColorInBetweenColorStops(float f11, float f12, float[] fArr, int[] iArr) {
        if (iArr.length < 2 || f11 == fArr[0]) {
            return iArr[0];
        }
        for (int i11 = 1; i11 < fArr.length; i11++) {
            if (fArr[i11] >= f11 || i11 == fArr.length - 1) {
                int i12 = i11 - 1;
                float f13 = (f11 - fArr[i12]) / (fArr[i11] - fArr[i12]);
                int i13 = iArr[i11];
                int i14 = iArr[i12];
                return Color.argb((int) (f12 * 255.0f), MiscUtils.lerp(Color.red(i14), Color.red(i13), f13), MiscUtils.lerp(Color.green(i14), Color.green(i13), f13), MiscUtils.lerp(Color.blue(i14), Color.blue(i13), f13));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    private int getColorInBetweenOpacityStops(float f11, int i11, float[] fArr, float[] fArr2) {
        float f12;
        if (fArr2.length < 2 || f11 <= fArr[0]) {
            return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i11), Color.green(i11), Color.blue(i11));
        }
        for (int i12 = 1; i12 < fArr.length; i12++) {
            int i13 = (fArr[i12] > f11 ? 1 : (fArr[i12] == f11 ? 0 : -1));
            if (i13 >= 0 || i12 == fArr.length - 1) {
                if (i13 <= 0) {
                    f12 = fArr2[i12];
                } else {
                    int i14 = i12 - 1;
                    f12 = MiscUtils.lerp(fArr2[i14], fArr2[i12], (f11 - fArr[i14]) / (fArr[i12] - fArr[i14]));
                }
                return Color.argb((int) (f12 * 255.0f), Color.red(i11), Color.green(i11), Color.blue(i11));
            }
        }
        throw new IllegalArgumentException("Unreachable code.");
    }

    public static float[] mergeUniqueElements(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            float f11 = Float.NaN;
            float f12 = i12 < fArr.length ? fArr[i12] : Float.NaN;
            if (i13 < fArr2.length) {
                f11 = fArr2[i13];
            }
            if (Float.isNaN(f11) || f12 < f11) {
                fArr3[i14] = f12;
                i12++;
            } else if (Float.isNaN(f12) || f11 < f12) {
                fArr3[i14] = f11;
                i13++;
            } else {
                fArr3[i14] = f12;
                i12++;
                i13++;
                i11++;
            }
        }
        if (i11 == 0) {
            return fArr3;
        }
        return Arrays.copyOf(fArr3, length - i11);
    }

    public GradientColor parse(JsonReader jsonReader, float f11) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z11 = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z11) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (arrayList.size() == 4 && ((Float) arrayList.get(0)).floatValue() == 1.0f) {
            arrayList.set(0, Float.valueOf(0.0f));
            arrayList.add(Float.valueOf(1.0f));
            arrayList.add((Float) arrayList.get(1));
            arrayList.add((Float) arrayList.get(2));
            arrayList.add((Float) arrayList.get(3));
            this.colorPoints = 2;
        }
        if (z11) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int i11 = this.colorPoints;
        float[] fArr = new float[i11];
        int[] iArr = new int[i11];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < this.colorPoints * 4; i14++) {
            int i15 = i14 / 4;
            double floatValue = (double) ((Float) arrayList.get(i14)).floatValue();
            int i16 = i14 % 4;
            if (i16 == 0) {
                if (i15 > 0) {
                    float f12 = (float) floatValue;
                    if (fArr[i15 - 1] >= f12) {
                        fArr[i15] = f12 + 0.01f;
                    }
                }
                fArr[i15] = (float) floatValue;
            } else if (i16 == 1) {
                i12 = (int) (floatValue * 255.0d);
            } else if (i16 == 2) {
                i13 = (int) (floatValue * 255.0d);
            } else if (i16 == 3) {
                iArr[i15] = Color.argb(255, i12, i13, (int) (floatValue * 255.0d));
            }
        }
        return addOpacityStopsToGradientIfNeeded(new GradientColor(fArr, iArr), arrayList);
    }
}
