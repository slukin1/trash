package xw;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static c f26379b = new c(Executors.newCachedThreadPool());

    public c(ExecutorService executorService) {
        super(executorService);
    }

    public static c b() {
        return f26379b;
    }
}
