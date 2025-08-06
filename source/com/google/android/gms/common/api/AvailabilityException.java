package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final ArrayMap<ApiKey<?>, ConnectionResult> zaa;

    public AvailabilityException(ArrayMap<ApiKey<?>, ConnectionResult> arrayMap) {
        this.zaa = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        boolean z11 = this.zaa.get(apiKey) != null;
        String zab = apiKey.zab();
        StringBuilder sb2 = new StringBuilder(String.valueOf(zab).length() + 58);
        sb2.append("The given API (");
        sb2.append(zab);
        sb2.append(") was not part of the availability request.");
        Preconditions.checkArgument(z11, sb2.toString());
        return (ConnectionResult) Preconditions.checkNotNull(this.zaa.get(apiKey));
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z11 = true;
        for (ApiKey next : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull(this.zaa.get(next));
            z11 &= !connectionResult.isSuccess();
            String zab = next.zab();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb2 = new StringBuilder(String.valueOf(zab).length() + 2 + valueOf.length());
            sb2.append(zab);
            sb2.append(l.f34627b);
            sb2.append(valueOf);
            arrayList.add(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        if (z11) {
            sb3.append("None of the queried APIs are available. ");
        } else {
            sb3.append("Some of the queried APIs are unavailable. ");
        }
        sb3.append(TextUtils.join("; ", arrayList));
        return sb3.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        boolean z11 = this.zaa.get(apiKey) != null;
        String zab = apiKey.zab();
        StringBuilder sb2 = new StringBuilder(String.valueOf(zab).length() + 58);
        sb2.append("The given API (");
        sb2.append(zab);
        sb2.append(") was not part of the availability request.");
        Preconditions.checkArgument(z11, sb2.toString());
        return (ConnectionResult) Preconditions.checkNotNull(this.zaa.get(apiKey));
    }
}
