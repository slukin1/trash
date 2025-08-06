package zz;

import io.noties.markwon.image.destination.ImageDestinationProcessor;
import java.net.MalformedURLException;
import java.net.URL;

public class a extends ImageDestinationProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final URL f60237a;

    public a(String str) {
        this.f60237a = c(str);
    }

    public static URL c(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public String b(String str) {
        if (this.f60237a == null) {
            return str;
        }
        try {
            return new URL(this.f60237a, str).toString();
        } catch (MalformedURLException e11) {
            e11.printStackTrace();
            return str;
        }
    }
}
