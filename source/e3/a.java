package e3;

import android.util.Log;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f15676a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f15677b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Logger f15678c;

    public static void a(String str, String str2) {
        Logger logger;
        if (!f15676a) {
            return;
        }
        if (!f15677b || (logger = f15678c) == null) {
            Log.d(str, str2);
            return;
        }
        Level level = Level.INFO;
        logger.log(level, str + l.f34627b + str2);
    }
}
