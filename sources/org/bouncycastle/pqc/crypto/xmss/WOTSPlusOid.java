package org.bouncycastle.pqc.crypto.xmss;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class WOTSPlusOid implements XMSSOid {
    private static final Map<String, WOTSPlusOid> oidLookupTable;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(createKey("SHA-256", 32, 16, 67), new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(createKey("SHA-512", 64, 16, 131), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(createKey("SHAKE256", 64, 16, 131), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap(hashMap);
    }

    private WOTSPlusOid(int i11, String str) {
        this.oid = i11;
        this.stringRepresentation = str;
    }

    private static String createKey(String str, int i11, int i12, int i13) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i12 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i13;
    }

    public static WOTSPlusOid lookup(String str, int i11, int i12, int i13) {
        Objects.requireNonNull(str, "algorithmName == null");
        return oidLookupTable.get(createKey(str, i11, i12, i13));
    }

    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
