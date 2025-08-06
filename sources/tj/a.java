package tj;

import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Ltj/a;", "", "", "a", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f47897a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static boolean f47898b;

    /* renamed from: c  reason: collision with root package name */
    public static LinkedBlockingQueue<String> f47899c = new LinkedBlockingQueue<>();

    /* renamed from: d  reason: collision with root package name */
    public static Thread f47900d;

    public final void a() {
        f47898b = false;
        Thread thread = f47900d;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
