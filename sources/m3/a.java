package m3;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import f4.b;
import f4.h;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import o3.d;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class a implements d<InputStream>, Callback {

    /* renamed from: b  reason: collision with root package name */
    public final Call.Factory f66500b;

    /* renamed from: c  reason: collision with root package name */
    public final s3.a f66501c;

    /* renamed from: d  reason: collision with root package name */
    public InputStream f66502d;

    /* renamed from: e  reason: collision with root package name */
    public ResponseBody f66503e;

    /* renamed from: f  reason: collision with root package name */
    public d.a<? super InputStream> f66504f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Call f66505g;

    public a(Call.Factory factory, s3.a aVar) {
        this.f66500b = factory;
        this.f66501c = aVar;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        try {
            InputStream inputStream = this.f66502d;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.f66503e;
        if (responseBody != null) {
            responseBody.close();
        }
        this.f66504f = null;
    }

    public DataSource c() {
        return DataSource.REMOTE;
    }

    public void cancel() {
        Call call = this.f66505g;
        if (call != null) {
            call.cancel();
        }
    }

    public void f(Priority priority, d.a<? super InputStream> aVar) {
        Request.Builder url = new Request.Builder().url(this.f66501c.f());
        for (Map.Entry next : this.f66501c.c().entrySet()) {
            url.addHeader((String) next.getKey(), (String) next.getValue());
        }
        Request build = url.build();
        this.f66504f = aVar;
        this.f66505g = this.f66500b.newCall(build);
        this.f66505g.enqueue(this);
    }

    public void onFailure(Call call, IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f66504f.e(iOException);
    }

    public void onResponse(Call call, Response response) {
        this.f66503e = response.body();
        if (response.isSuccessful()) {
            InputStream b11 = b.b(this.f66503e.byteStream(), ((ResponseBody) h.d(this.f66503e)).contentLength());
            this.f66502d = b11;
            this.f66504f.d(b11);
            return;
        }
        this.f66504f.e(new HttpException(response.message(), response.code()));
    }
}
