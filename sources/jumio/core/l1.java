package jumio.core;

import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import net.sf.scuba.smartcards.ISO7816;
import org.json.JSONObject;

public final class l1 extends o2<JSONObject> {
    public l1(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        super(hVar, apiCallDataModel);
    }

    public final String getRequest() throws Exception {
        return "";
    }

    public final String getUri() {
        String b11 = g.b();
        String deobfuscate = StringDeobfuscator.deobfuscate(new byte[]{-93, ISO7816.INS_UPDATE_BINARY, 35, ISO7816.INS_GET_DATA, -66, Byte.MIN_VALUE, ISO7816.INS_LOAD_KEY_FILE, 22}, 3486798841543688390L);
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
