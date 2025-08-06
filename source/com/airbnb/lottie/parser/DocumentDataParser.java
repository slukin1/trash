package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.secure.android.common.ssl.util.f;
import e7.s;
import java.io.IOException;

public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser INSTANCE = new DocumentDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("t", f.f38658a, s.f70071a, "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private DocumentDataParser() {
    }

    public DocumentData parse(JsonReader jsonReader, float f11) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        boolean z11 = true;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    f12 = (float) jsonReader.nextDouble();
                    break;
                case 3:
                    int nextInt = jsonReader.nextInt();
                    justification2 = DocumentData.Justification.CENTER;
                    if (nextInt <= justification2.ordinal() && nextInt >= 0) {
                        justification2 = DocumentData.Justification.values()[nextInt];
                        break;
                    }
                case 4:
                    i11 = jsonReader.nextInt();
                    break;
                case 5:
                    f13 = (float) jsonReader.nextDouble();
                    break;
                case 6:
                    f14 = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    i12 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 8:
                    i13 = JsonUtils.jsonToColor(jsonReader);
                    break;
                case 9:
                    f15 = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    z11 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        JsonReader jsonReader2 = jsonReader;
        jsonReader.endObject();
        return new DocumentData(str, str2, f12, justification2, i11, f13, f14, i12, i13, f15, z11);
    }
}
