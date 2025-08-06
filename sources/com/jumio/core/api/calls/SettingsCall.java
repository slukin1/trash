package com.jumio.core.api.calls;

import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import jumio.core.w0;
import kotlin.jvm.internal.r;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SettingsCall extends o2<JSONObject> {

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

    public SettingsCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        if (!apiCallDataModel.getData().containsKey("DATA_AVAILABLE_PLUGIN_NAMES")) {
            throw new IllegalArgumentException("Available Plugin Names are missing".toString());
        }
    }

    public final String getRequest() throws Exception {
        JSONArray jSONArray = new JSONArray();
        for (String put : (String[]) getApiCallDataModel().getData().get("DATA_AVAILABLE_PLUGIN_NAMES")) {
            jSONArray.put(put);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("linkedModules", jSONArray);
        jSONObject.put("deviceDetails", w0.a());
        return jSONObject.toString();
    }

    public final String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-22, ISOFileInfo.FCI_EXT, -25, 65, 43, 57, ISOFileInfo.FCP_BYTE, -73}, -3991709031461092330L);
        return b11 + deobfuscate;
    }

    public final Object parseResponse(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e11) {
            Log.w(getTAG(), "Exception", (Throwable) e11);
            return new JSONObject();
        }
    }
}
