package jumio.core;

import cn.sharesdk.framework.InnerShareParams;
import com.facebook.appevents.UserDataStore;
import com.google.common.base.Ascii;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.sdk.result.JumioCredentialResult;
import com.jumio.sdk.result.JumioIDResult;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.x;
import net.sf.scuba.smartcards.ISO7816;
import org.json.JSONObject;

public final class f1 extends o2<HashMap<String, JumioCredentialResult>> {
    public f1(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
    }

    public static String a(String str) {
        if ((str == null || str.length() == 0) || x.b(JSONObject.NULL.toString(), str)) {
            return null;
        }
        return str;
    }

    public final String getRequest() throws Exception {
        return "";
    }

    public final String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{101, -35, -99, -103, ISO7816.INS_READ_RECORD_STAMPED, 101, -119, -9, 114, 4, -53, 7, 35, 94, 39, -23, Ascii.CAN, 5, 82, 40}, 1493473626205255869L);
        return b11 + deobfuscate;
    }

    public final Object parseResponse(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                JumioIDResult jumioIDResult = new JumioIDResult();
                jumioIDResult.setIssuingCountry(a(jSONObject2.optString("issuingCountry")));
                jumioIDResult.setIdType(a(jSONObject2.optString("idType")));
                jumioIDResult.setFirstName(a(jSONObject2.optString("firstName")));
                jumioIDResult.setLastName(a(jSONObject2.optString("lastName")));
                jumioIDResult.setDateOfBirth(a(jSONObject2.optString("dateOfBirth")));
                jumioIDResult.setIssuingDate(a(jSONObject2.optString("issuingDate")));
                jumioIDResult.setExpiryDate(a(jSONObject2.optString("expiryDate")));
                jumioIDResult.setDocumentNumber(a(jSONObject2.optString("documentNumber")));
                jumioIDResult.setPersonalNumber(a(jSONObject2.optString("personalNumber")));
                jumioIDResult.setGender(a(jSONObject2.optString("gender")));
                jumioIDResult.setNationality(a(jSONObject2.optString("nationality")));
                jumioIDResult.setPlaceOfBirth(a(jSONObject2.optString("placeOfBirth")));
                jumioIDResult.setCountry(a(jSONObject2.optString(UserDataStore.COUNTRY)));
                jumioIDResult.setAddress(a(jSONObject2.optString(InnerShareParams.ADDRESS)));
                jumioIDResult.setCity(a(jSONObject2.optString("city")));
                jumioIDResult.setSubdivision(a(jSONObject2.optString("subdivision")));
                jumioIDResult.setPostalCode(a(jSONObject2.optString("postalCode")));
                jumioIDResult.setMrzLine1(a(jSONObject2.optString("mrzLine1")));
                jumioIDResult.setMrzLine2(a(jSONObject2.optString("mrzLine2")));
                jumioIDResult.setMrzLine3(a(jSONObject2.optString("mrzLine3")));
                hashMap.put(next, jumioIDResult);
            }
        } catch (Exception e11) {
            Log.w(getTAG(), "Exception", (Throwable) e11);
        }
        return hashMap;
    }
}
