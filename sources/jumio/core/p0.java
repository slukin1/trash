package jumio.core;

import d10.l;
import java.util.ArrayList;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p0 {
    public static ArrayList a(JSONObject jSONObject, String str, l lVar) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null || !x.b(optJSONObject.optString("predefinedType"), "DEFINED")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = optJSONObject.getJSONArray("values");
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object invoke = lVar.invoke(jSONArray.getString(i11));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }
}
