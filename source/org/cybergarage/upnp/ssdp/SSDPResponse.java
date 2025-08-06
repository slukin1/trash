package org.cybergarage.upnp.ssdp;

import com.google.common.net.HttpHeaders;
import com.jumio.commons.log.LogUtils;
import org.cybergarage.http.HTTPResponse;

public class SSDPResponse extends HTTPResponse {
    public SSDPResponse() {
        j0("1.1");
    }

    public String k0() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m0());
        stringBuffer.append(r());
        stringBuffer.append(LogUtils.NEW_LINE);
        return stringBuffer.toString();
    }

    public void q0(int i11) {
        e0(HttpHeaders.CACHE_CONTROL, "max-age=" + Integer.toString(i11));
    }

    public void r0(String str) {
        e0(HttpHeaders.LOCATION, str);
    }

    public void s0(String str) {
        e0("MYNAME", str);
    }

    public void t0(String str) {
        e0("ST", str);
    }

    public void u0(String str) {
        e0("USN", str);
    }
}
