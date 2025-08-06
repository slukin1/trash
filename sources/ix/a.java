package ix;

import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import vx.b;

public interface a {
    boolean a(String str, InputStream inputStream, b.a aVar) throws IOException;

    boolean b(String str, Bitmap bitmap) throws IOException;

    File get(String str);
}
