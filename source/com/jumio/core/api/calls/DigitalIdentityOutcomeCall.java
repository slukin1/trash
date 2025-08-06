package com.jumio.core.api.calls;

import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import java.util.Map;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import kotlin.jvm.internal.r;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.json.JSONObject;

public final class DigitalIdentityOutcomeCall extends o2<JSONObject> {

    /* renamed from: i  reason: collision with root package name */
    public final String f39058i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, String> f39059j;

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

    public DigitalIdentityOutcomeCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        if (apiCallDataModel.getData().containsKey("DATA_JWT")) {
            String a11 = g.a();
            String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-31, 17, ISOFileInfo.DATA_BYTES2, 107, ISOFileInfo.A5, 2, 110, 28, -119, 1, ISOFileInfo.SECURITY_ATTR_EXP, Framer.ENTER_FRAME_PREFIX, 35, 22, ISO7816.INS_READ_RECORD2, 29, ISO7816.INS_READ_BINARY, ISO7816.INS_READ_RECORD_STAMPED, -49, 113, -113, -83, -119, -12}, 7759624741207660194L);
            this.f39058i = a11 + deobfuscate;
            Map<String, String> y11 = MapsKt__MapsKt.y(super.getHeaders());
            y11.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            this.f39059j = y11;
            return;
        }
        throw new IllegalArgumentException("JWT is missing in passed data".toString());
    }

    public final Map<String, String> getHeaders() {
        return this.f39059j;
    }

    public final String getRequest() {
        return "jwt=" + ((String) getApiCallDataModel().getData().get("DATA_JWT"));
    }

    public final String getUri() {
        return this.f39058i;
    }

    public final Object parseResponse(String str) {
        return new JSONObject(str);
    }
}
