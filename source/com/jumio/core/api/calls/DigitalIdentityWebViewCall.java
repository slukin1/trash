package com.jumio.core.api.calls;

import com.google.common.base.Ascii;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import java.util.Map;
import jumio.core.g;
import jumio.core.h;
import jumio.core.o2;
import kotlin.jvm.internal.r;
import net.sf.scuba.smartcards.ISO7816;

public final class DigitalIdentityWebViewCall extends o2<DigitalIdentityWebContentResult> {

    /* renamed from: i  reason: collision with root package name */
    public final String f39062i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, String> f39063j;

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

    public DigitalIdentityWebViewCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
        if (!apiCallDataModel.getData().containsKey("DATA_JWT")) {
            throw new IllegalArgumentException("JWT is missing in passed data".toString());
        } else if (apiCallDataModel.getData().containsKey("DATA_DI_SUBTYPE")) {
            String a11 = g.a();
            String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-7, -71, -2, ISO7816.INS_UNBLOCK_CHV, Ascii.DEL, 99, 82, -83, Byte.MIN_VALUE, ISO7816.INS_MSE, ISO7816.INS_DECREASE_STAMPED, -15, -81, ISO7816.INS_READ_BINARY2, -15, 35, -70, -101, -45, 118, 102, -113, -20, Framer.EXIT_FRAME_PREFIX}, -19653549658805721L);
            this.f39062i = a11 + deobfuscate;
            Map<String, String> y11 = MapsKt__MapsKt.y(super.getHeaders());
            y11.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            y11.put("Accept", "text/html");
            this.f39063j = y11;
        } else {
            throw new IllegalArgumentException("Digital ID subtype is missing in passed data".toString());
        }
    }

    /* renamed from: a */
    public final DigitalIdentityWebContentResult parseResponse(String str) {
        String host = getApiCallSettings().getHost();
        String str2 = this.f39062i;
        return new DigitalIdentityWebContentResult(host + str2, str);
    }

    public final Map<String, String> getHeaders() {
        return this.f39063j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getRequest() {
        /*
            r6 = this;
            com.jumio.core.models.ApiCallDataModel r0 = r6.getApiCallDataModel()
            java.util.HashMap r0 = r0.getData()
            java.lang.String r1 = "DATA_JWT"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            com.jumio.core.models.ApiCallDataModel r1 = r6.getApiCallDataModel()
            java.util.HashMap r1 = r1.getData()
            java.lang.String r2 = "DATA_DI_SUBTYPE"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toUpperCase(r2)
            com.jumio.core.models.ApiCallDataModel r2 = r6.getApiCallDataModel()
            java.util.HashMap r2 = r2.getData()
            java.lang.String r3 = "DATA_LOCALE"
            java.lang.Object r2 = r2.get(r3)
            boolean r3 = r2 instanceof java.lang.String
            r4 = 0
            if (r3 == 0) goto L_0x003c
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x003d
        L_0x003c:
            r2 = r4
        L_0x003d:
            if (r2 != 0) goto L_0x0041
            java.lang.String r2 = "en-US"
        L_0x0041:
            com.jumio.core.models.ApiCallDataModel r3 = r6.getApiCallDataModel()
            java.util.HashMap r3 = r3.getData()
            java.lang.String r5 = "DATA_DARK_MODE"
            java.lang.Object r3 = r3.get(r5)
            boolean r5 = r3 instanceof java.lang.Boolean
            if (r5 == 0) goto L_0x0056
            r4 = r3
            java.lang.Boolean r4 = (java.lang.Boolean) r4
        L_0x0056:
            if (r4 == 0) goto L_0x005d
            boolean r3 = r4.booleanValue()
            goto L_0x005e
        L_0x005d:
            r3 = 0
        L_0x005e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "jwt="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = "&di-subtype="
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = "&locale="
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = "&darkmode="
            r4.append(r0)
            r4.append(r3)
            java.lang.String r0 = r4.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.calls.DigitalIdentityWebViewCall.getRequest():java.lang.String");
    }

    public final String getUri() {
        return this.f39062i;
    }
}
