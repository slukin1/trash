package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.content.Context;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentIdentity;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.UUID;

public class PersistentDistinctId extends PersistentIdentity<String> {
    public PersistentDistinctId(final Context context) {
        super(DbParams.PersistentName.DISTINCT_ID, new PersistentIdentity.PersistentSerializer<String>() {
            public String load(String str) {
                return str;
            }

            public String create() {
                String androidID = SensorsDataUtils.getAndroidID(context);
                if (SensorsDataUtils.isValidAndroidId(androidID)) {
                    return androidID;
                }
                return UUID.randomUUID().toString();
            }

            public String save(String str) {
                return str == null ? create() : str;
            }
        });
    }
}
