package jumio.core;

import com.google.common.base.Ascii;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.models.ApiCallDataModel;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;

public final class k2 extends AnalyticsCall {
    public k2(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
    }

    public final String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{78, -100, Ascii.US, -124, -58, 18, -45, 0, ISO7816.INS_UPDATE_BINARY, -18, 55, 32, -45, Utf8.REPLACEMENT_BYTE}, -8890451435662554744L);
        return b11 + deobfuscate;
    }
}
