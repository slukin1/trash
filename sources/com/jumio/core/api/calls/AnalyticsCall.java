package com.jumio.core.api.calls;

import com.jumio.analytics.AnalyticsEvent;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import jumio.core.x1;
import kotlin.jvm.internal.r;
import net.sf.scuba.smartcards.ISO7816;
import org.json.JSONArray;
import org.json.JSONObject;

public class AnalyticsCall extends o2<Void> {

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    static {
        new Companion((r) null);
    }

    public AnalyticsCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        if (!apiCallDataModel.getData().containsKey("DATA_EVENTS")) {
            throw new IllegalArgumentException("Events are missing".toString());
        } else if (!apiCallDataModel.getData().containsKey("DATA_SERVER_TIME")) {
            throw new IllegalArgumentException("Servertime is missing".toString());
        } else if (!apiCallDataModel.getData().containsKey("DATA_START_ELAPSED_MILLIS")) {
            throw new IllegalArgumentException("StartTime is missing".toString());
        }
    }

    public final String getRequest() throws Exception {
        if (!((ArrayList) getApiCallDataModel().getData().get("DATA_EVENTS")).isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator it2 = ((ArrayList) getApiCallDataModel().getData().get("DATA_EVENTS")).iterator();
            while (it2.hasNext()) {
                AnalyticsEvent analyticsEvent = (AnalyticsEvent) it2.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventType", analyticsEvent.getEventType());
                jSONObject2.put("timestamp", (analyticsEvent.getEventElapsedMillis() - ((Long) getApiCallDataModel().getData().get("DATA_START_ELAPSED_MILLIS")).longValue()) + ((Long) getApiCallDataModel().getData().get("DATA_SERVER_TIME")).longValue());
                x1<?> payload = analyticsEvent.getPayload();
                payload.getClass();
                JSONObject jSONObject3 = new JSONObject();
                T t11 = payload.f56344a;
                if (t11 instanceof Map) {
                    t11 = new JSONObject((Map) payload.f56344a);
                }
                jSONObject3.put("value", t11);
                MetaInfo metaInfo = payload.f56345b;
                if (!(metaInfo == null || metaInfo.size() == 0)) {
                    jSONObject3.put("metainfo", new JSONObject(metaInfo));
                }
                jSONObject2.put("payload", jSONObject3);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put(DbParams.TABLE_EVENTS, jSONArray);
            return jSONObject.toString();
        }
        throw new IllegalArgumentException("event list cannot be empty!".toString());
    }

    public String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{105, ISO7816.INS_PUT_DATA, -1, -84, -47, 102, -78, 95, 38, -120, -105, ISO7816.INS_PSO, -87, 9}, 7332388328695791698L);
        return b11 + deobfuscate;
    }

    public final Object parseResponse(String str) {
        return null;
    }

    public final void responseReceived(int i11, long j11) {
    }
}
