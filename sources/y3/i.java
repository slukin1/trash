package y3;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.bitmap_recycle.b;
import com.bumptech.glide.load.engine.r;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import n3.e;

public class i implements e<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    public final List<ImageHeaderParser> f66715a;

    /* renamed from: b  reason: collision with root package name */
    public final e<ByteBuffer, c> f66716b;

    /* renamed from: c  reason: collision with root package name */
    public final b f66717c;

    public i(List<ImageHeaderParser> list, e<ByteBuffer, c> eVar, b bVar) {
        this.f66715a = list;
        this.f66716b = eVar;
        this.f66717c = bVar;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e11) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e11);
            return null;
        }
    }

    /* renamed from: c */
    public r<c> b(InputStream inputStream, int i11, int i12, Options options) throws IOException {
        byte[] e11 = e(inputStream);
        if (e11 == null) {
            return null;
        }
        return this.f66716b.b(ByteBuffer.wrap(e11), i11, i12, options);
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) throws IOException {
        return !((Boolean) options.a(h.f66714b)).booleanValue() && a.e(this.f66715a, inputStream, this.f66717c) == ImageHeaderParser.ImageType.GIF;
    }
}
