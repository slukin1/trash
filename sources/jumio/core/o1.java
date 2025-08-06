package jumio.core;

import com.jumio.core.models.automation.AutomationModel;
import d10.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o1 {
    public static final Enum a(JSONObject jSONObject) {
        Enum[] enumArr;
        AutomationModel.a aVar = AutomationModel.a.NOT_AVAILABLE;
        String optString = jSONObject.optString("decisionType", "");
        int i11 = 0;
        Enum enumR = null;
        if (!(optString.length() > 0)) {
            optString = null;
        }
        if (optString == null || (enumArr = (Enum[]) AutomationModel.a.class.getEnumConstants()) == null) {
            return aVar;
        }
        int length = enumArr.length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            Enum enumR2 = enumArr[i11];
            if (x.b(enumR2.name(), optString)) {
                enumR = enumR2;
                break;
            }
            i11++;
        }
        return enumR == null ? aVar : enumR;
    }

    public static final ArrayList b(JSONArray jSONArray, l lVar) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object obj = jSONArray.get(i11);
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                arrayList.add(lVar.invoke(obj));
            }
        }
        return arrayList;
    }

    public static final void a(JSONObject jSONObject, String str) {
        boolean z11 = true;
        if (StringsKt__StringsJVMKt.z("issuingCountry") ^ true) {
            if (str == null || !(!StringsKt__StringsJVMKt.z(str))) {
                z11 = false;
            }
            if (z11) {
                jSONObject.put("issuingCountry", str);
            }
        }
    }

    public static final <T> void a(JSONArray jSONArray, l<? super T, Unit> lVar) {
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object obj = jSONArray.get(i11);
            if (obj == null) {
                obj = null;
            }
            if (obj != null) {
                lVar.invoke(obj);
            }
        }
    }

    public static Date a(JSONObject jSONObject, String str, String str2) {
        Locale locale = Locale.ENGLISH;
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, locale);
            simpleDateFormat.setTimeZone(timeZone);
            return simpleDateFormat.parse(jSONObject.optString(str));
        } catch (Exception unused) {
            return null;
        }
    }
}
