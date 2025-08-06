package kotlinx.coroutines.channels;

import com.huobi.view.indexlist.EntityWrapper;
import kotlinx.coroutines.internal.d0;

public interface d<E> extends m<E>, ReceiveChannel<E> {

    /* renamed from: s0  reason: collision with root package name */
    public static final a f57045s0 = a.f57046a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f57046a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final int f57047b = d0.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, EntityWrapper.TYPE_TITLE);

        public final int a() {
            return f57047b;
        }
    }
}
