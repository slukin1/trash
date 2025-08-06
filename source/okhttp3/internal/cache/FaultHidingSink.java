package okhttp3.internal.cache;

import d10.l;
import java.io.IOException;
import kotlin.Unit;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;
    private final l<IOException, Unit> onException;

    public FaultHidingSink(Sink sink, l<? super IOException, Unit> lVar) {
        super(sink);
        this.onException = lVar;
    }

    public void close() {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e11) {
                this.hasErrors = true;
                this.onException.invoke(e11);
            }
        }
    }

    public void flush() {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e11) {
                this.hasErrors = true;
                this.onException.invoke(e11);
            }
        }
    }

    public final l<IOException, Unit> getOnException() {
        return this.onException;
    }

    public void write(Buffer buffer, long j11) {
        if (this.hasErrors) {
            buffer.skip(j11);
            return;
        }
        try {
            super.write(buffer, j11);
        } catch (IOException e11) {
            this.hasErrors = true;
            this.onException.invoke(e11);
        }
    }
}
