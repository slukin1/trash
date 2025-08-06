package com.jumio.core.api.calls;

import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.IproovValidateModel;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import org.json.JSONObject;

public final class IproovValidateCall extends o2<IproovValidateModel> {
    public IproovValidateCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
    }

    public String getRequest() throws Exception {
        if (getApiCallSettings().getDataManager().has(IproovTokenModel.class)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", ((IproovTokenModel) getApiCallSettings().getDataManager().get(IproovTokenModel.class)).getToken());
            return jSONObject.toString();
        }
        throw new IllegalStateException("iproovTokenModel not available!".toString());
    }

    public String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-9, 107, Framer.STDOUT_FRAME_PREFIX, 115, 56, -102, 106, 58, 60, 73, -119, 118, 2, -52, -23}, -115293174980108824L);
        return b11 + deobfuscate;
    }

    public IproovValidateModel parseResponse(String str) {
        if (str.length() == 0) {
            return null;
        }
        try {
            IproovValidateModel fromString = IproovValidateModel.Companion.fromString(str);
            getApiCallSettings().getDataManager().put(IproovValidateModel.class, fromString);
            return fromString;
        } catch (Exception e11) {
            Log.w(getTAG(), "Exception", (Throwable) e11);
            return null;
        }
    }
}
