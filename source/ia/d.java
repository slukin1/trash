package ia;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public interface d {
    Bitmap decodeRegion(Rect rect, int i11);

    Point init(Context context, Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
