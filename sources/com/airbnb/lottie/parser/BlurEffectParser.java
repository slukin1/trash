package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import java.io.IOException;

class BlurEffectParser {
    private static final JsonReader.Options BLUR_EFFECT_NAMES = JsonReader.Options.of("ef");
    private static final JsonReader.Options INNER_BLUR_EFFECT_NAMES = JsonReader.Options.of("ty", f.f34662a);

    private static BlurEffect maybeParseInnerEffect(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        BlurEffect blurEffect = null;
        while (true) {
            boolean z11 = false;
            while (true) {
                if (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(INNER_BLUR_EFFECT_NAMES);
                    if (selectName != 0) {
                        if (selectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else if (z11) {
                            blurEffect = new BlurEffect(AnimatableValueParser.parseFloat(jsonReader, lottieComposition));
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (jsonReader.nextInt() == 0) {
                        z11 = true;
                    }
                } else {
                    jsonReader.endObject();
                    return blurEffect;
                }
            }
        }
    }

    public static BlurEffect parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        BlurEffect blurEffect = null;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(BLUR_EFFECT_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    BlurEffect maybeParseInnerEffect = maybeParseInnerEffect(jsonReader, lottieComposition);
                    if (maybeParseInnerEffect != null) {
                        blurEffect = maybeParseInnerEffect;
                    }
                }
                jsonReader.endArray();
            }
        }
        return blurEffect;
    }
}
