package ng;

import fi.iki.elonen.NanoHTTPD;
import java.io.InputStream;

public interface a {
    InputStream a(String str);

    NanoHTTPD.Response b(NanoHTTPD.j jVar);

    String c();
}
