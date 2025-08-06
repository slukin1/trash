package org.cybergarage.upnp;

import com.xiaomi.mipush.sdk.Constants;
import okhttp3.internal.ws.WebSocketProtocol;
import org.cybergarage.soap.SOAP;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Parser;

public class UPnP {

    /* renamed from: a  reason: collision with root package name */
    public static Parser f59870a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f59871b = 4;

    static {
        f(4);
    }

    public static final String a() {
        long currentTimeMillis = System.currentTimeMillis();
        long currentTimeMillis2 = (long) (((double) System.currentTimeMillis()) * Math.random());
        return String.valueOf(g((int) (currentTimeMillis & WebSocketProtocol.PAYLOAD_SHORT_MAX))) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + g(((int) ((currentTimeMillis >> 32) | 40960)) & 65535) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + g((int) (WebSocketProtocol.PAYLOAD_SHORT_MAX & currentTimeMillis2)) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + g(((int) ((currentTimeMillis2 >> 32) | 57344)) & 65535);
    }

    public static final String b() {
        String property = System.getProperty("os.name");
        String property2 = System.getProperty("os.version");
        return String.valueOf(property) + "/" + property2 + " UPnP/1.0 " + "CyberLinkJava" + "/" + "1.8";
    }

    public static final Parser c() {
        if (f59870a == null) {
            Parser e11 = e();
            f59870a = e11;
            if (e11 != null) {
                SOAP.c(e11);
            } else {
                throw new RuntimeException("No XML parser defined. And unable to laod any. \nTry to invoke UPnP.setXMLParser before UPnP.getXMLParser");
            }
        }
        return f59870a;
    }

    public static final void d() {
    }

    public static Parser e() {
        String[] strArr = {System.getProperty("cyberlink.upnp.xml.parser"), "org.cybergarage.xml.parser.XmlPullParser", "org.cybergarage.xml.parser.JaxpParser", "org.cybergarage.xml.parser.kXML2Parser", "org.cybergarage.xml.parser.XercesParser"};
        for (int i11 = 0; i11 < 5; i11++) {
            if (strArr[i11] != null) {
                try {
                    return (Parser) Class.forName(strArr[i11]).newInstance();
                } catch (Throwable th2) {
                    Debug.e("Unable to load " + strArr[i11] + " as XMLParser due to " + th2);
                }
            }
        }
        return null;
    }

    public static final void f(int i11) {
        f59871b = i11;
    }

    public static final String g(int i11) {
        String num = Integer.toString(i11 & 65535, 16);
        String str = "";
        for (int i12 = 0; i12 < 4 - num.length(); i12++) {
            str = String.valueOf(str) + "0";
        }
        return String.valueOf(str) + num;
    }
}
