package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.r;
import okhttp3.Protocol;
import okhttp3.Response;

public final class StatusLine {
    public static final Companion Companion = new Companion((r) null);
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final StatusLine get(Response response) {
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String str) throws IOException {
            Protocol protocol;
            String str2;
            int i11 = 9;
            if (StringsKt__StringsJVMKt.M(str, "HTTP/1.", false, 2, (Object) null)) {
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else if (StringsKt__StringsJVMKt.M(str, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                i11 = 4;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int i12 = i11 + 3;
            if (str.length() >= i12) {
                try {
                    int parseInt = Integer.parseInt(str.substring(i11, i12));
                    if (str.length() <= i12) {
                        str2 = "";
                    } else if (str.charAt(i12) == ' ') {
                        str2 = str.substring(i11 + 4);
                    } else {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    return new StatusLine(protocol, parseInt, str2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
    }

    public StatusLine(Protocol protocol2, int i11, String str) {
        this.protocol = protocol2;
        this.code = i11;
        this.message = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.code);
        sb2.append(' ');
        sb2.append(this.message);
        return sb2.toString();
    }
}
