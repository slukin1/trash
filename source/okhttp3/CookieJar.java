package okhttp3;

import java.util.List;

public interface CookieJar {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static final class NoCookies implements CookieJar {
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                return CollectionsKt__CollectionsKt.k();
            }

            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            }
        }

        private Companion() {
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
