package zendesk.core;

import aw.a;
import com.zendesk.logger.Logger;
import com.zendesk.util.DigestUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import mz.f;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

class ZendeskDiskLruCache implements BaseStorage {
    private static final int CACHE_INDEX = 0;
    private static final int ITEMS_PER_KEY = 1;
    private static final String LOG_TAG = "DiskLruStorage";
    private static final int VERSION_ONE = 1;
    private final File directory;
    private final long maxSize;
    private final Serializer serializer;
    private a storage;

    public ZendeskDiskLruCache(File file, Serializer serializer2, int i11) {
        this.directory = file;
        long j11 = (long) i11;
        this.maxSize = j11;
        this.storage = openCache(file, j11);
        this.serializer = serializer2;
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String getString(String str, int i11) {
        BufferedSource bufferedSource;
        Source source;
        String str2;
        Source source2 = null;
        try {
            a.e u11 = this.storage.u(key(str));
            if (u11 != null) {
                source = Okio.source(u11.a(i11));
                try {
                    bufferedSource = Okio.buffer(source);
                } catch (IOException e11) {
                    e = e11;
                    bufferedSource = null;
                    try {
                        Logger.k(LOG_TAG, "Unable to read from cache", e, new Object[0]);
                        close(source);
                        close(bufferedSource);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        close(source);
                        close(bufferedSource);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedSource = null;
                    close(source);
                    close(bufferedSource);
                    throw th;
                }
                try {
                    source2 = source;
                    str2 = bufferedSource.readUtf8();
                } catch (IOException e12) {
                    e = e12;
                    Logger.k(LOG_TAG, "Unable to read from cache", e, new Object[0]);
                    close(source);
                    close(bufferedSource);
                    return null;
                }
            } else {
                str2 = null;
                bufferedSource = null;
            }
            close(source2);
            close(bufferedSource);
            return str2;
        } catch (IOException e13) {
            e = e13;
            source = null;
            bufferedSource = null;
            Logger.k(LOG_TAG, "Unable to read from cache", e, new Object[0]);
            close(source);
            close(bufferedSource);
            return null;
        } catch (Throwable th4) {
            bufferedSource = null;
            th = th4;
            source = null;
            close(source);
            close(bufferedSource);
            throw th;
        }
    }

    private String key(String str) {
        return DigestUtils.c(str);
    }

    private String keyMediaType(String str) {
        return key(String.format(Locale.US, "%s_content_type", new Object[]{str}));
    }

    private a openCache(File file, long j11) {
        try {
            return a.x(file, 1, 1, j11);
        } catch (IOException unused) {
            Logger.l(LOG_TAG, "Unable to open cache", new Object[0]);
            return null;
        }
    }

    private void putString(String str, int i11, String str2) {
        try {
            write(str, i11, Okio.source((InputStream) new ByteArrayInputStream(str2.getBytes("UTF-8"))));
        } catch (UnsupportedEncodingException e11) {
            Logger.k(LOG_TAG, "Unable to encode string", e11, new Object[0]);
        }
    }

    private void write(String str, int i11, Source source) {
        Sink sink;
        a.c s11;
        BufferedSink bufferedSink = null;
        try {
            synchronized (this.directory) {
                s11 = this.storage.s(key(str));
            }
            if (s11 != null) {
                sink = Okio.sink(s11.f(i11));
                try {
                    bufferedSink = Okio.buffer(sink);
                    bufferedSink.writeAll(source);
                    bufferedSink.flush();
                    s11.e();
                } catch (IOException e11) {
                    e = e11;
                }
            } else {
                sink = null;
            }
        } catch (IOException e12) {
            e = e12;
            sink = null;
        } catch (Throwable th2) {
            th = th2;
            sink = null;
            close(bufferedSink);
            close(sink);
            close(source);
            throw th;
        }
        close(bufferedSink);
        close(sink);
        close(source);
        try {
            Logger.k(LOG_TAG, "Unable to cache data", e, new Object[0]);
            close(bufferedSink);
            close(sink);
            close(source);
        } catch (Throwable th3) {
            th = th3;
            close(bufferedSink);
            close(sink);
            close(source);
            throw th;
        }
    }

    public void clear() {
        a aVar = this.storage;
        if (aVar != null) {
            try {
                if (aVar.v() == null || !this.storage.v().exists() || !mz.a.j(this.storage.v().listFiles())) {
                    this.storage.close();
                } else {
                    this.storage.p();
                }
            } catch (IOException e11) {
                Logger.b(LOG_TAG, "Error clearing cache. Error: %s", e11.getMessage());
            } catch (Throwable th2) {
                this.storage = openCache(this.directory, this.maxSize);
                throw th2;
            }
            this.storage = openCache(this.directory, this.maxSize);
        }
    }

    public String get(String str) {
        if (this.storage == null) {
            return null;
        }
        return getString(str, 0);
    }

    public void put(String str, String str2) {
        if (this.storage != null && !f.e(str2)) {
            putString(str, 0, str2);
        }
    }

    public void remove(String str) {
    }

    public <E> E get(String str, Class<E> cls) {
        if (this.storage == null) {
            return null;
        }
        if (cls.equals(ResponseBody.class)) {
            try {
                a.e u11 = this.storage.u(key(str));
                if (u11 == null) {
                    return null;
                }
                Source source = Okio.source(u11.a(0));
                long b11 = u11.b(0);
                String string = getString(keyMediaType(str), 0);
                return ResponseBody.create(f.c(string) ? MediaType.parse(string) : null, b11, Okio.buffer(source));
            } catch (IOException e11) {
                Logger.k(LOG_TAG, "Unable to read from cache", e11, new Object[0]);
                return null;
            }
        } else {
            return this.serializer.deserialize(getString(str, 0), cls);
        }
    }

    public void put(String str, Object obj) {
        if (this.storage != null) {
            if (obj instanceof ResponseBody) {
                ResponseBody responseBody = (ResponseBody) obj;
                write(str, 0, responseBody.source());
                putString(keyMediaType(str), 0, responseBody.contentType().toString());
                return;
            }
            String str2 = null;
            if (obj != null) {
                str2 = this.serializer.serialize(obj);
            }
            put(str, str2);
        }
    }

    public ZendeskDiskLruCache(File file, long j11, a aVar, Serializer serializer2) {
        this.directory = file;
        this.maxSize = j11;
        this.storage = aVar;
        this.serializer = serializer2;
    }
}
