package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapePathParser {
    public static JsonReader.Options NAMES = JsonReader.Options.of("nm", "ind", "ks", "hd");

    private ShapePathParser() {
    }

    public static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        int i11 = 0;
        String str = null;
        AnimatableShapeValue animatableShapeValue = null;
        boolean z11 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                i11 = jsonReader.nextInt();
            } else if (selectName == 2) {
                animatableShapeValue = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
            } else if (selectName != 3) {
                jsonReader.skipValue();
            } else {
                z11 = jsonReader.nextBoolean();
            }
        }
        return new ShapePath(str, i11, animatableShapeValue, z11);
    }
}
