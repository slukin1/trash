package bh;

import com.huobi.bugsdk.FirebaseHelper;
import com.huobi.pandoraBox.crashKiller.CrashKiller;
import com.huobi.pandoraBox.crashKiller.b;
import com.huobi.pandoraBox.crashKiller.c;
import i6.k;

public final class i {

    public class a implements c {
        public boolean a(Throwable th2) {
            return true;
        }

        public /* synthetic */ void b() {
            b.a(this);
        }

        public void c(boolean z11, Thread thread, Throwable th2) {
            k.j("crash", th2);
            FirebaseHelper.e(th2);
            th2.printStackTrace();
        }
    }

    public static void a() {
        CrashKiller.d(new a());
    }
}
