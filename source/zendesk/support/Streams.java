package zendesk.support;

import com.google.gson.Gson;
import com.zendesk.logger.Logger;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public class Streams {

    public interface Use<R, P extends Closeable> {
        R use(P p11) throws Exception;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static <T> T fromJson(final Gson gson, Source source, final Type type) {
        return use(toReader(source), new Use<T, Reader>() {
            public T use(Reader reader) throws Exception {
                return Gson.this.fromJson(reader, type);
            }
        });
    }

    public static void toJson(final Gson gson, Sink sink, final Object obj) {
        use(toWriter(sink), new Use<Void, Writer>() {
            public Void use(Writer writer) throws Exception {
                Gson.this.toJson(obj, (Appendable) writer);
                return null;
            }
        });
    }

    public static Reader toReader(Source source) {
        if (source instanceof BufferedSource) {
            return new InputStreamReader(((BufferedSource) source).inputStream());
        }
        return new InputStreamReader(Okio.buffer(source).inputStream());
    }

    public static Writer toWriter(Sink sink) {
        if (sink instanceof BufferedSink) {
            return new OutputStreamWriter(((BufferedSink) sink).outputStream());
        }
        return new OutputStreamWriter(Okio.buffer(sink).outputStream());
    }

    public static <R, P extends Closeable> R use(P p11, Use<R, P> use) {
        if (p11 == null) {
            return null;
        }
        try {
            return use.use(p11);
        } catch (Exception e11) {
            Logger.f("Streams", "Error using stream", e11, new Object[0]);
            return null;
        } finally {
            closeQuietly(p11);
        }
    }
}
