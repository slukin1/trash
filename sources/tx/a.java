package tx;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

public interface a {
    void a(String str, View view);

    void b(String str, View view, FailReason failReason);

    void c(String str, View view, Bitmap bitmap);

    void d(String str, View view);
}
