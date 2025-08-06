package zendesk.classic.messaging.ui;

import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;

public class b0 {
    public static String a(Context context, long j11) {
        if (Build.VERSION.SDK_INT >= 26) {
            j11 = (((j11 * 1000) * 1000) / 1024) / 1024;
        }
        return Formatter.formatFileSize(context, j11);
    }
}
