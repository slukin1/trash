package g30;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import zendesk.belvedere.BelvedereUi;
import zendesk.belvedere.ImageStream;
import zendesk.classic.messaging.components.DateProvider;

public abstract class h {
    public static ImageStream a(AppCompatActivity appCompatActivity) {
        return BelvedereUi.c(appCompatActivity);
    }

    public static DateProvider b() {
        return new DateProvider();
    }

    public static Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    public static boolean d(zendesk.classic.messaging.h hVar) {
        return hVar.f().isMultilineResponseOptionsEnabled();
    }
}
