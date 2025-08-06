package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

public interface PushObserver {
    public static final PushObserver CANCEL = new Companion.PushObserverCancel();
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static final class PushObserverCancel implements PushObserver {
            public boolean onData(int i11, BufferedSource bufferedSource, int i12, boolean z11) throws IOException {
                bufferedSource.skip((long) i12);
                return true;
            }

            public boolean onHeaders(int i11, List<Header> list, boolean z11) {
                return true;
            }

            public boolean onRequest(int i11, List<Header> list) {
                return true;
            }

            public void onReset(int i11, ErrorCode errorCode) {
            }
        }

        private Companion() {
        }
    }

    boolean onData(int i11, BufferedSource bufferedSource, int i12, boolean z11) throws IOException;

    boolean onHeaders(int i11, List<Header> list, boolean z11);

    boolean onRequest(int i11, List<Header> list);

    void onReset(int i11, ErrorCode errorCode);
}
