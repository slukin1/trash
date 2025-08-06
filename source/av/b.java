package av;

import java.net.HttpCookie;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f19373a = new a();

    public class a implements b {
        public void a(URI uri, HttpCookie httpCookie) {
        }

        public List<HttpCookie> b(URI uri) {
            return Collections.emptyList();
        }
    }

    void a(URI uri, HttpCookie httpCookie);

    List<HttpCookie> b(URI uri);
}
