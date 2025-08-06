package mx;

import android.graphics.Bitmap;
import java.util.Collection;

public interface a {
    boolean a(String str, Bitmap bitmap);

    Bitmap get(String str);

    Collection<String> keys();

    Bitmap remove(String str);
}
