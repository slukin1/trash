package zendesk.support;

import aw.a;
import com.google.gson.Gson;
import com.zendesk.logger.Logger;
import com.zendesk.util.DigestUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import okio.Okio;
import zendesk.support.Streams;

public class SupportUiStorage {
    private static final int CACHE_INDEX = 0;
    private static final String LOG_TAG = "SupportUiStorage";
    public static final String REQUEST_MAPPER = "request_id_mapper";
    /* access modifiers changed from: private */
    public final Gson gson;
    private final a storage;

    public SupportUiStorage(a aVar, Gson gson2) {
        this.storage = aVar;
        this.gson = gson2;
    }

    private static void abortEdit(a.c cVar) {
        Logger.l(LOG_TAG, "Unable to cache data", new Object[0]);
        if (cVar != null) {
            try {
                cVar.a();
            } catch (IOException e11) {
                Logger.k(LOG_TAG, "Unable to abort write", e11, new Object[0]);
            }
        }
    }

    private static String key(String str) {
        return DigestUtils.c(str);
    }

    public <E> E read(String str, final Type type) {
        E use;
        try {
            synchronized (this.storage) {
                use = Streams.use(this.storage.u(key(str)), new Streams.Use<E, a.e>() {
                    public E use(a.e eVar) throws Exception {
                        return SupportUiStorage.this.gson.fromJson(Streams.toReader(Okio.source(eVar.a(0))), type);
                    }
                });
            }
            return use;
        } catch (IOException unused) {
            Logger.l(LOG_TAG, "Unable to read from cache", new Object[0]);
            return null;
        }
    }

    public void write(String str, Object obj) {
        a.c cVar = null;
        try {
            synchronized (this.storage) {
                cVar = this.storage.s(key(str));
            }
            if (cVar != null) {
                Streams.toJson(this.gson, Okio.sink(cVar.f(0)), obj);
                cVar.e();
            }
        } catch (IOException unused) {
            abortEdit(cVar);
        }
    }
}
