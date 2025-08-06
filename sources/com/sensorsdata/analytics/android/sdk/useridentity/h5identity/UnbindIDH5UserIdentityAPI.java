package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;
import java.util.Iterator;

public class UnbindIDH5UserIdentityAPI extends H5UserIdentityAPI {
    private final UserIdentityAPI mUserIdentityApi;

    public UnbindIDH5UserIdentityAPI(UserIdentityAPI userIdentityAPI) {
        this.mUserIdentityApi = userIdentityAPI;
    }

    public boolean updateIdentities() {
        try {
            Iterator<String> keys = this.mIdentityJson.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.mUserIdentityApi.getIdentitiesInstance().remove(next, this.mIdentityJson.optString(next));
            }
            this.mEventObject.put(Identities.IDENTITIES_KEY, this.mIdentityJson);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        return super.updateIdentities();
    }
}
