package com.sensorsdata.analytics.android.sdk.useridentity.h5identity;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.useridentity.Identities;
import com.sensorsdata.analytics.android.sdk.useridentity.UserIdentityAPI;

public class CommonUserIdentityAPI extends H5UserIdentityAPI {
    public UserIdentityAPI mUserIdentityAPI;

    public CommonUserIdentityAPI(UserIdentityAPI userIdentityAPI) {
        this.mUserIdentityAPI = userIdentityAPI;
    }

    public boolean updateIdentities() {
        try {
            mergeIdentities(this.mUserIdentityAPI.getIdentitiesInstance().getIdentities(Identities.State.DEFAULT));
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
        this.mUserIdentityAPI.trackH5Notify(this.mEventObject);
        return true;
    }
}
