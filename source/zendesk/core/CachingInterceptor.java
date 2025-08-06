package zendesk.core;

import com.zendesk.logger.Logger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

class CachingInterceptor implements Interceptor {
    private static final String LOG_TAG = "CachingInterceptor";
    private final BaseStorage cache;
    private final Map<String, Lock> locks = new HashMap();

    public CachingInterceptor(BaseStorage baseStorage) {
        this.cache = baseStorage;
    }

    private Response createResponse(int i11, Request request, ResponseBody responseBody) {
        Response.Builder builder = new Response.Builder();
        if (responseBody != null) {
            builder.body(responseBody);
        } else {
            Logger.l(LOG_TAG, "Response body is null", new Object[0]);
        }
        return builder.code(i11).message(request.method()).request(request).protocol(Protocol.HTTP_1_1).build();
    }

    private Response loadData(String str, Interceptor.Chain chain) throws IOException {
        int i11;
        ResponseBody responseBody;
        ResponseBody responseBody2 = (ResponseBody) this.cache.get(str, ResponseBody.class);
        if (responseBody2 == null) {
            Logger.b(LOG_TAG, "Response not cached, loading it from the network. | %s", str);
            Response proceed = chain.proceed(chain.request());
            if (proceed.isSuccessful()) {
                MediaType contentType = proceed.body().contentType();
                byte[] bytes = proceed.body().bytes();
                this.cache.put(str, (Object) ResponseBody.create(contentType, bytes));
                responseBody = ResponseBody.create(contentType, bytes);
            } else {
                Logger.b(LOG_TAG, "Unable to load data from network. | %s", str);
                responseBody = proceed.body();
            }
            responseBody2 = responseBody;
            i11 = proceed.code();
        } else {
            i11 = 200;
        }
        return createResponse(i11, chain.request(), responseBody2);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Lock lock;
        String httpUrl = chain.request().url().toString();
        synchronized (this.locks) {
            if (this.locks.containsKey(httpUrl)) {
                lock = this.locks.get(httpUrl);
            } else {
                lock = new ReentrantLock();
                this.locks.put(httpUrl, lock);
            }
        }
        try {
            lock.lock();
            return loadData(httpUrl, chain);
        } finally {
            lock.unlock();
        }
    }
}
