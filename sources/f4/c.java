package f4;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class c extends InputStream {

    /* renamed from: d  reason: collision with root package name */
    public static final Queue<c> f66249d = i.f(0);

    /* renamed from: b  reason: collision with root package name */
    public InputStream f66250b;

    /* renamed from: c  reason: collision with root package name */
    public IOException f66251c;

    public static c b(InputStream inputStream) {
        c poll;
        Queue<c> queue = f66249d;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new c();
        }
        poll.e(inputStream);
        return poll;
    }

    public IOException a() {
        return this.f66251c;
    }

    public int available() throws IOException {
        return this.f66250b.available();
    }

    public void close() throws IOException {
        this.f66250b.close();
    }

    public void e(InputStream inputStream) {
        this.f66250b = inputStream;
    }

    public void mark(int i11) {
        this.f66250b.mark(i11);
    }

    public boolean markSupported() {
        return this.f66250b.markSupported();
    }

    public int read(byte[] bArr) {
        try {
            return this.f66250b.read(bArr);
        } catch (IOException e11) {
            this.f66251c = e11;
            return -1;
        }
    }

    public void release() {
        this.f66251c = null;
        this.f66250b = null;
        Queue<c> queue = f66249d;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public synchronized void reset() throws IOException {
        this.f66250b.reset();
    }

    public long skip(long j11) {
        try {
            return this.f66250b.skip(j11);
        } catch (IOException e11) {
            this.f66251c = e11;
            return 0;
        }
    }

    public int read(byte[] bArr, int i11, int i12) {
        try {
            return this.f66250b.read(bArr, i11, i12);
        } catch (IOException e11) {
            this.f66251c = e11;
            return -1;
        }
    }

    public int read() {
        try {
            return this.f66250b.read();
        } catch (IOException e11) {
            this.f66251c = e11;
            return -1;
        }
    }
}
