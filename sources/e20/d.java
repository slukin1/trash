package e20;

import java.net.Socket;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPServer;

public class d extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public HTTPServer f54271b;

    /* renamed from: c  reason: collision with root package name */
    public Socket f54272c;

    public d(HTTPServer hTTPServer, Socket socket) {
        super("Cyber.HTTPServerThread");
        this.f54271b = hTTPServer;
        this.f54272c = socket;
    }

    public void run() {
        e eVar = new e(this.f54272c);
        if (eVar.f()) {
            HTTPRequest hTTPRequest = new HTTPRequest();
            hTTPRequest.O0(eVar);
            while (hTTPRequest.G0()) {
                this.f54271b.h(hTTPRequest);
                if (!hTTPRequest.v0()) {
                    break;
                }
            }
            eVar.a();
        }
    }
}
