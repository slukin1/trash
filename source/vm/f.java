package vm;

import android.os.Handler;
import android.os.Looper;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class f extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public File f76650a;

    /* renamed from: b  reason: collision with root package name */
    public MediaType f76651b;

    /* renamed from: c  reason: collision with root package name */
    public b f76652c;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public long f76653b;

        /* renamed from: c  reason: collision with root package name */
        public long f76654c;

        public a(long j11, long j12) {
            this.f76653b = j11;
            this.f76654c = j12;
        }

        public void run() {
            f.this.f76652c.onProgressUpdate((int) ((this.f76653b * 100) / this.f76654c));
        }
    }

    public interface b {
        void onProgressUpdate(int i11);
    }

    public f(File file, b bVar) {
        this.f76650a = file;
        this.f76652c = bVar;
    }

    public long contentLength() throws IOException {
        return this.f76650a.length();
    }

    public MediaType contentType() {
        MediaType mediaType = this.f76651b;
        return mediaType == null ? MediaType.parse(SelectMimeType.SYSTEM_IMAGE) : mediaType;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        long length = this.f76650a.length();
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(this.f76650a);
        try {
            Handler handler = new Handler(Looper.getMainLooper());
            long j11 = 0;
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    handler.post(new a(j11, length));
                    j11 += (long) read;
                    bufferedSink.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }
}
