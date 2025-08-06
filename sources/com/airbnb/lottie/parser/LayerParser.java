package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import cn.sharesdk.framework.InnerShareParams;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LayerParser {
    private static final JsonReader.Options EFFECTS_NAMES = JsonReader.Options.of("ty", "nm");
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", TtmlNode.TAG_TT, "masksProperties", "shapes", "t", "ef", InnerShareParams.SUBREDDIT, UserDataStore.STATE, "w", "h", "ip", "op", "tm", "cl", "hd");
    private static final JsonReader.Options TEXT_NAMES = JsonReader.Options.of(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, "a");

    /* renamed from: com.airbnb.lottie.parser.LayerParser$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA_INVERTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.LayerParser.AnonymousClass1.<clinit>():void");
        }
    }

    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        AnimatableTransform animatableTransform = r4;
        AnimatableTransform animatableTransform2 = new AnimatableTransform();
        return new Layer(emptyList, lottieComposition, "__container", -1, layerType, -1, (String) null, emptyList2, animatableTransform, 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), (AnimatableTextFrame) null, (AnimatableTextProperties) null, Collections.emptyList(), Layer.MatteType.NONE, (AnimatableFloatValue) null, false, (BlurEffect) null, (DropShadowEffect) null);
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f11;
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.beginObject();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        float f12 = 1.0f;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z11 = false;
        Layer.LayerType layerType = null;
        String str = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame animatableTextFrame = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        BlurEffect blurEffect = null;
        DropShadowEffect dropShadowEffect = null;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        long j11 = -1;
        long j12 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    str3 = jsonReader.nextString();
                    break;
                case 1:
                    j12 = (long) jsonReader.nextInt();
                    break;
                case 2:
                    str = jsonReader.nextString();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (nextInt >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[nextInt];
                        break;
                    }
                case 4:
                    j11 = (long) jsonReader.nextInt();
                    break;
                case 5:
                    i11 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    break;
                case 6:
                    i12 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    break;
                case 7:
                    i13 = Color.parseColor(jsonReader.nextString());
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    break;
                case 9:
                    int nextInt2 = jsonReader.nextInt();
                    if (nextInt2 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[nextInt2];
                        int i16 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$layer$Layer$MatteType[matteType2.ordinal()];
                        if (i16 == 1) {
                            lottieComposition2.addWarning("Unsupported matte type: Luma");
                        } else if (i16 == 2) {
                            lottieComposition2.addWarning("Unsupported matte type: Luma Inverted");
                        }
                        lottieComposition2.incrementMatteOrMaskCount(1);
                        break;
                    } else {
                        lottieComposition2.addWarning("Unsupported matte type: " + nextInt2);
                        break;
                    }
                case 10:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList3.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    lottieComposition2.incrementMatteOrMaskCount(arrayList3.size());
                    jsonReader.endArray();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel parse = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (parse != null) {
                            arrayList4.add(parse);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 12:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader2.selectName(TEXT_NAMES);
                        if (selectName == 0) {
                            animatableTextFrame = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        } else if (selectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 13:
                    jsonReader.beginArray();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            int selectName2 = jsonReader2.selectName(EFFECTS_NAMES);
                            if (selectName2 == 0) {
                                int nextInt3 = jsonReader.nextInt();
                                if (nextInt3 == 29) {
                                    blurEffect = BlurEffectParser.parse(jsonReader, lottieComposition);
                                } else if (nextInt3 == 25) {
                                    dropShadowEffect = new DropShadowEffectParser().parse(jsonReader2, lottieComposition2);
                                }
                            } else if (selectName2 != 1) {
                                jsonReader.skipName();
                                jsonReader.skipValue();
                            } else {
                                arrayList5.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition2.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f12 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    f14 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    i14 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    break;
                case 17:
                    i15 = (int) (((float) jsonReader.nextInt()) * Utils.dpScale());
                    break;
                case 18:
                    f13 = (float) jsonReader.nextDouble();
                    break;
                case 19:
                    f15 = (float) jsonReader.nextDouble();
                    break;
                case 20:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, false);
                    break;
                case 21:
                    str2 = jsonReader.nextString();
                    break;
                case 22:
                    z11 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList6 = new ArrayList();
        if (f13 > 0.0f) {
            Keyframe keyframe = r0;
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            Keyframe keyframe2 = new Keyframe(lottieComposition, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f13));
            arrayList2.add(keyframe);
            f11 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f11 = 0.0f;
        }
        if (f15 <= f11) {
            f15 = lottieComposition.getEndFrame();
        }
        LottieComposition lottieComposition3 = lottieComposition;
        arrayList2.add(new Keyframe(lottieComposition3, valueOf, valueOf, (Interpolator) null, f13, Float.valueOf(f15)));
        arrayList2.add(new Keyframe(lottieComposition3, valueOf2, valueOf2, (Interpolator) null, f15, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            lottieComposition2.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, lottieComposition, str3, j12, layerType, j11, str, arrayList, animatableTransform, i11, i12, i13, f12, f14, i14, i15, animatableTextFrame, animatableTextProperties, arrayList2, matteType2, animatableFloatValue, z11, blurEffect, dropShadowEffect);
    }
}
