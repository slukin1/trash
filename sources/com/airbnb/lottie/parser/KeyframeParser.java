package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import c1.b;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import e7.s;
import java.io.IOException;
import java.lang.ref.WeakReference;

class KeyframeParser {
    public static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.of("x", "y");
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float MAX_CP_VALUE = 100.0f;
    public static JsonReader.Options NAMES = JsonReader.Options.of("t", s.f70071a, "e", "o", "i", "h", "to", "ti");
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    private static WeakReference<Interpolator> getInterpolator(int i11) {
        WeakReference<Interpolator> g11;
        synchronized (KeyframeParser.class) {
            g11 = pathInterpolatorCache().g(i11);
        }
        return g11;
    }

    private static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = clamp;
        int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, clamp);
        WeakReference<Interpolator> interpolator2 = getInterpolator(hashFor);
        Interpolator interpolator3 = interpolator2 != null ? (Interpolator) interpolator2.get() : null;
        if (interpolator2 == null || interpolator3 == null) {
            try {
                interpolator = b.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e11) {
                if ("The Path cannot loop back on itself.".equals(e11.getMessage())) {
                    interpolator = b.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    interpolator = new LinearInterpolator();
                }
            }
            interpolator3 = interpolator;
            try {
                putInterpolator(hashFor, new WeakReference(interpolator3));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator3;
    }

    public static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f11, ValueParser<T> valueParser, boolean z11, boolean z12) throws IOException {
        if (z11 && z12) {
            return parseMultiDimensionalKeyframe(lottieComposition, jsonReader, f11, valueParser);
        }
        if (z11) {
            return parseKeyframe(lottieComposition, jsonReader, f11, valueParser);
        }
        return parseStaticValue(jsonReader, f11, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f11, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        T t11;
        Interpolator interpolator2;
        jsonReader.beginObject();
        PointF pointF = null;
        boolean z11 = false;
        T t12 = null;
        T t13 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f12 = 0.0f;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    f12 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t13 = valueParser.parse(jsonReader, f11);
                    break;
                case 2:
                    t12 = valueParser.parse(jsonReader, f11);
                    break;
                case 3:
                    pointF = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z11 = false;
                        break;
                    } else {
                        z11 = true;
                        break;
                    }
                case 6:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f11);
                    break;
                case 7:
                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f11);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z11) {
            interpolator = LINEAR_INTERPOLATOR;
            t11 = t13;
        } else {
            if (pointF == null || pointF4 == null) {
                interpolator2 = LINEAR_INTERPOLATOR;
            } else {
                interpolator2 = interpolatorFor(pointF, pointF4);
            }
            interpolator = interpolator2;
            t11 = t12;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, t13, t11, interpolator, f12, (Float) null);
        keyframe.pathCp1 = pointF2;
        keyframe.pathCp2 = pointF3;
        return keyframe;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x017d, code lost:
        r14 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.value.Keyframe<T> parseMultiDimensionalKeyframe(com.airbnb.lottie.LottieComposition r21, com.airbnb.lottie.parser.moshi.JsonReader r22, float r23, com.airbnb.lottie.parser.ValueParser<T> r24) throws java.io.IOException {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r22.beginObject()
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0016:
            boolean r17 = r22.hasNext()
            if (r17 == 0) goto L_0x01a8
            com.airbnb.lottie.parser.moshi.JsonReader$Options r4 = NAMES
            int r4 = r0.selectName(r4)
            r5 = 1
            switch(r4) {
                case 0: goto L_0x019b;
                case 1: goto L_0x0191;
                case 2: goto L_0x0187;
                case 3: goto L_0x00f3;
                case 4: goto L_0x0044;
                case 5: goto L_0x003a;
                case 6: goto L_0x0035;
                case 7: goto L_0x0030;
                default: goto L_0x0026;
            }
        L_0x0026:
            r19 = r3
            r3 = r14
            r18 = r15
            r22.skipValue()
            goto L_0x01a4
        L_0x0030:
            android.graphics.PointF r3 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r22, r23)
            goto L_0x0016
        L_0x0035:
            android.graphics.PointF r15 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r22, r23)
            goto L_0x0016
        L_0x003a:
            int r4 = r22.nextInt()
            if (r4 != r5) goto L_0x0042
            r6 = r5
            goto L_0x0016
        L_0x0042:
            r6 = 0
            goto L_0x0016
        L_0x0044:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x00e8
            r22.beginObject()
            r4 = 0
            r5 = 0
            r12 = 0
            r13 = 0
        L_0x0053:
            boolean r18 = r22.hasNext()
            if (r18 == 0) goto L_0x00d2
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Options r15 = INTERPOLATOR_NAMES
            int r15 = r0.selectName(r15)
            if (r15 == 0) goto L_0x00a5
            r19 = r3
            r3 = 1
            if (r15 == r3) goto L_0x0070
            r22.skipValue()
        L_0x006b:
            r15 = r18
            r3 = r19
            goto L_0x0053
        L_0x0070:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r3 = r22.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r3 != r5) goto L_0x0081
            r3 = r14
            double r13 = r22.nextDouble()
            float r13 = (float) r13
            r14 = r3
            r5 = r13
            goto L_0x006b
        L_0x0081:
            r3 = r14
            r22.beginArray()
            double r13 = r22.nextDouble()
            float r13 = (float) r13
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.peek()
            if (r14 != r5) goto L_0x0096
            double r14 = r22.nextDouble()
            float r5 = (float) r14
            goto L_0x0097
        L_0x0096:
            r5 = r13
        L_0x0097:
            r22.endArray()
            r14 = r3
            r15 = r18
            r3 = r19
            r20 = r13
            r13 = r5
            r5 = r20
            goto L_0x0053
        L_0x00a5:
            r19 = r3
            r3 = r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r12 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r12) goto L_0x00b8
            double r14 = r22.nextDouble()
            float r12 = (float) r14
            r14 = r3
            r4 = r12
            goto L_0x006b
        L_0x00b8:
            r22.beginArray()
            double r14 = r22.nextDouble()
            float r4 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.peek()
            if (r14 != r12) goto L_0x00cc
            double r14 = r22.nextDouble()
            float r12 = (float) r14
            goto L_0x00cd
        L_0x00cc:
            r12 = r4
        L_0x00cd:
            r22.endArray()
            r14 = r3
            goto L_0x006b
        L_0x00d2:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r12, r13)
            r22.endObject()
            r13 = r4
            r12 = r14
            goto L_0x017d
        L_0x00e8:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r8 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r22, r23)
            goto L_0x01a4
        L_0x00f3:
            r19 = r3
            r3 = r14
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x017f
            r22.beginObject()
            r4 = 0
            r5 = 0
            r9 = 0
            r11 = 0
        L_0x0107:
            boolean r14 = r22.hasNext()
            if (r14 == 0) goto L_0x016c
            com.airbnb.lottie.parser.moshi.JsonReader$Options r14 = INTERPOLATOR_NAMES
            int r14 = r0.selectName(r14)
            if (r14 == 0) goto L_0x0144
            r15 = 1
            if (r14 == r15) goto L_0x011c
            r22.skipValue()
            goto L_0x0107
        L_0x011c:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = r22.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r11 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r5 != r11) goto L_0x012b
            double r14 = r22.nextDouble()
            float r11 = (float) r14
            r5 = r11
            goto L_0x0107
        L_0x012b:
            r22.beginArray()
            double r14 = r22.nextDouble()
            float r5 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.peek()
            if (r14 != r11) goto L_0x013f
            double r14 = r22.nextDouble()
            float r11 = (float) r14
            goto L_0x0140
        L_0x013f:
            r11 = r5
        L_0x0140:
            r22.endArray()
            goto L_0x0107
        L_0x0144:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r22.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r9 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r9) goto L_0x0153
            double r14 = r22.nextDouble()
            float r9 = (float) r14
            r4 = r9
            goto L_0x0107
        L_0x0153:
            r22.beginArray()
            double r14 = r22.nextDouble()
            float r4 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = r22.peek()
            if (r14 != r9) goto L_0x0167
            double r14 = r22.nextDouble()
            float r9 = (float) r14
            goto L_0x0168
        L_0x0167:
            r9 = r4
        L_0x0168:
            r22.endArray()
            goto L_0x0107
        L_0x016c:
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r9, r11)
            r22.endObject()
            r11 = r4
            r9 = r14
            r15 = r18
        L_0x017d:
            r14 = r3
            goto L_0x01a4
        L_0x017f:
            android.graphics.PointF r7 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r22, r23)
            r14 = r3
            r15 = r18
            goto L_0x01a4
        L_0x0187:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r16 = r2.parse(r0, r1)
            goto L_0x01a4
        L_0x0191:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r10 = r2.parse(r0, r1)
            goto L_0x01a4
        L_0x019b:
            r19 = r3
            r18 = r15
            double r3 = r22.nextDouble()
            float r14 = (float) r3
        L_0x01a4:
            r3 = r19
            goto L_0x0016
        L_0x01a8:
            r19 = r3
            r3 = r14
            r18 = r15
            r22.endObject()
            if (r6 == 0) goto L_0x01b8
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r11 = r10
        L_0x01b5:
            r12 = 0
            r13 = 0
            goto L_0x01dc
        L_0x01b8:
            if (r7 == 0) goto L_0x01c1
            if (r8 == 0) goto L_0x01c1
            android.view.animation.Interpolator r0 = interpolatorFor(r7, r8)
            goto L_0x01d9
        L_0x01c1:
            if (r9 == 0) goto L_0x01d7
            if (r11 == 0) goto L_0x01d7
            if (r12 == 0) goto L_0x01d7
            if (r13 == 0) goto L_0x01d7
            android.view.animation.Interpolator r0 = interpolatorFor(r9, r12)
            android.view.animation.Interpolator r1 = interpolatorFor(r11, r13)
            r12 = r0
            r13 = r1
            r11 = r16
            r0 = 0
            goto L_0x01dc
        L_0x01d7:
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
        L_0x01d9:
            r11 = r16
            goto L_0x01b5
        L_0x01dc:
            if (r12 == 0) goto L_0x01ed
            if (r13 == 0) goto L_0x01ed
            com.airbnb.lottie.value.Keyframe r0 = new com.airbnb.lottie.value.Keyframe
            r15 = 0
            r8 = r0
            r9 = r21
            r14 = r3
            r5 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x01fb
        L_0x01ed:
            r5 = r18
            com.airbnb.lottie.value.Keyframe r1 = new com.airbnb.lottie.value.Keyframe
            r14 = 0
            r8 = r1
            r9 = r21
            r12 = r0
            r13 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0 = r1
        L_0x01fb:
            r0.pathCp1 = r5
            r3 = r19
            r0.pathCp2 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.parseMultiDimensionalKeyframe(com.airbnb.lottie.LottieComposition, com.airbnb.lottie.parser.moshi.JsonReader, float, com.airbnb.lottie.parser.ValueParser):com.airbnb.lottie.value.Keyframe");
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f11, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f11));
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static void putInterpolator(int i11, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.m(i11, weakReference);
        }
    }
}
