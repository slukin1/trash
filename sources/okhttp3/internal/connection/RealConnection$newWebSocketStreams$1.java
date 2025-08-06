package okhttp3.internal.connection;

import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

public final class RealConnection$newWebSocketStreams$1 extends RealWebSocket.Streams {
    public final /* synthetic */ Exchange $exchange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealConnection$newWebSocketStreams$1(BufferedSource bufferedSource, BufferedSink bufferedSink, Exchange exchange) {
        super(true, bufferedSource, bufferedSink);
        this.$exchange = exchange;
    }

    public void close() {
        this.$exchange.bodyComplete(-1, true, true, null);
    }
}
