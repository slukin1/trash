package okio;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    public SocketAsyncTimeout(Socket socket2) {
        this.socket = socket2;
    }

    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(OptionsBridge.TIMEOUT_KEY);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    public void timedOut() {
        try {
            this.socket.close();
        } catch (Exception e11) {
            Logger access$getLogger$p = Okio__JvmOkioKt.logger;
            Level level = Level.WARNING;
            access$getLogger$p.log(level, "Failed to close timed out socket " + this.socket, e11);
        } catch (AssertionError e12) {
            if (Okio.isAndroidGetsocknameError(e12)) {
                Logger access$getLogger$p2 = Okio__JvmOkioKt.logger;
                Level level2 = Level.WARNING;
                access$getLogger$p2.log(level2, "Failed to close timed out socket " + this.socket, e12);
                return;
            }
            throw e12;
        }
    }
}
