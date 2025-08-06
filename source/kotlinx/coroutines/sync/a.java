package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.coroutines.c;

public interface a {

    /* renamed from: kotlinx.coroutines.sync.a$a  reason: collision with other inner class name */
    public static final class C0668a {
        public static /* synthetic */ Object a(a aVar, Object obj, c cVar, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 1) != 0) {
                    obj = null;
                }
                return aVar.d(obj, cVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }

        public static /* synthetic */ boolean b(a aVar, Object obj, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 1) != 0) {
                    obj = null;
                }
                return aVar.a(obj);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }

        public static /* synthetic */ void c(a aVar, Object obj, int i11, Object obj2) {
            if (obj2 == null) {
                if ((i11 & 1) != 0) {
                    obj = null;
                }
                aVar.e(obj);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
    }

    boolean a(Object obj);

    boolean b();

    Object d(Object obj, c<? super Unit> cVar);

    void e(Object obj);
}
