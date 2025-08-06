package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = new ShapeDataParser();
    private static final JsonReader.Options NAMES = JsonReader.Options.of("c", f.f34662a, "i", "o");

    private ShapeDataParser() {
    }

    public ShapeData parse(JsonReader jsonReader, float f11) throws IOException {
        if (jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z11 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                z11 = jsonReader.nextBoolean();
            } else if (selectName == 1) {
                list = JsonUtils.jsonToPoints(jsonReader, f11);
            } else if (selectName == 2) {
                list2 = JsonUtils.jsonToPoints(jsonReader, f11);
            } else if (selectName != 3) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                list3 = JsonUtils.jsonToPoints(jsonReader, f11);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonReader.Token.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i11 = 1; i11 < size; i11++) {
                PointF pointF2 = list.get(i11);
                int i12 = i11 - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i12), list3.get(i12)), MiscUtils.addPoints(pointF2, list2.get(i11)), pointF2));
            }
            if (z11) {
                PointF pointF3 = list.get(0);
                int i13 = size - 1;
                arrayList.add(new CubicCurveData(MiscUtils.addPoints(list.get(i13), list3.get(i13)), MiscUtils.addPoints(pointF3, list2.get(0)), pointF3));
            }
            return new ShapeData(pointF, z11, arrayList);
        }
    }
}
