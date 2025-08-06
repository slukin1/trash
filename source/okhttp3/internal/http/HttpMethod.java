package okhttp3.internal.http;

import kotlin.jvm.internal.x;

public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String str) {
        return !x.b(str, "GET") && !x.b(str, "HEAD");
    }

    public static final boolean requiresRequestBody(String str) {
        return x.b(str, "POST") || x.b(str, "PUT") || x.b(str, "PATCH") || x.b(str, "PROPPATCH") || x.b(str, "REPORT");
    }

    public final boolean invalidatesCache(String str) {
        return x.b(str, "POST") || x.b(str, "PATCH") || x.b(str, "PUT") || x.b(str, "DELETE") || x.b(str, "MOVE");
    }

    public final boolean redirectsToGet(String str) {
        return !x.b(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        return x.b(str, "PROPFIND");
    }
}
