package u1;

import android.os.Trace;

public final class c {
    public static void a(String str, int i11) {
        Trace.beginAsyncSection(str, i11);
    }

    public static void b(String str, int i11) {
        Trace.endAsyncSection(str, i11);
    }
}
