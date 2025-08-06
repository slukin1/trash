package com.jumio.core.api.calls;

import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.automation.AutomationModel;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import kotlin.jvm.internal.r;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

public final class UsabilityCall extends o2<AutomationModel> {

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

    public UsabilityCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        if (!apiCallDataModel.getData().containsKey("DATA_RESULT_KEY")) {
            throw new IllegalArgumentException("Result Key is missing".toString());
        }
    }

    public final String getRequest() throws Exception {
        return "";
    }

    public final String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-86, 61, 12, -53, 110, -44, -89, 73, 106, -87, ISOFileInfo.AB, 16, 56, -49, -6, ISO7816.INS_UPDATE_RECORD, 108}, -4685996733232977611L);
        return b11 + deobfuscate + ((String) getApiCallDataModel().getData().get("DATA_RESULT_KEY"));
    }

    public final Object parseResponse(String str) {
        return AutomationModel.f39405e.fromString(str);
    }
}
