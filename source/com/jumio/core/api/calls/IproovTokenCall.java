package com.jumio.core.api.calls;

import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.IproovTokenModel;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.json.JSONObject;

public final class IproovTokenCall extends o2<IproovTokenModel> {
    public IproovTokenCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
    }

    public String getRequest() throws Exception {
        return "";
    }

    public String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{6, ISO7816.INS_DECREASE_STAMPED, -110, -109, -119, -24, -73, -1, ISOFileInfo.FCP_BYTE, -37, -101, 65}, -2944676074839603816L);
        return b11 + deobfuscate;
    }

    public IproovTokenModel parseResponse(String str) {
        if (str.length() == 0) {
            return null;
        }
        try {
            IproovTokenModel fromJson = IproovTokenModel.Companion.fromJson(new JSONObject(str));
            getApiCallSettings().getDataManager().put(IproovTokenModel.class, fromJson);
            return fromJson;
        } catch (Exception e11) {
            Log.w(getTAG(), "Exception", (Throwable) e11);
            return null;
        }
    }
}
