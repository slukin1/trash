package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class H5UserIdentityAPI {
    public JSONObject mEventObject;
    public JSONObject mIdentityJson;

    public void init(JSONObject jSONObject, JSONObject jSONObject2) {
        this.mIdentityJson = jSONObject;
        this.mEventObject = jSONObject2;
    }

    public void mergeIdentities(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        if (!(jSONObject == null || (jSONObject2 = this.mIdentityJson) == null)) {
            SensorsDataUtils.mergeJSONObject(jSONObject, jSONObject2);
        }
        if (this.mIdentityJson == null && jSONObject != null) {
            this.mIdentityJson = new JSONObject(jSONObject.toString());
        }
        this.mEventObject.put(Identities.IDENTITIES_KEY, this.mIdentityJson);
    }

    public boolean process(JSONObject jSONObject, JSONObject jSONObject2) {
        init(jSONObject, jSONObject2);
        return updateIdentities();
    }

    public boolean updateIdentities() {
        return true;
    }
}
