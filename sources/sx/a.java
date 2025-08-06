package sx;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public interface a {
    ViewScaleType a();

    boolean b(Bitmap bitmap);

    View c();

    boolean d(Drawable drawable);

    boolean e();

    int getHeight();

    int getId();

    int getWidth();
}
