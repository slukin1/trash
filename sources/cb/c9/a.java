package c9;

import android.content.Context;
import android.text.TextUtils;
import c9.b;
import com.hbg.lib.network.retrofit.util.SPUtil;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class a<L extends b> {
    private static final String CACHE_FILE_NAME = "network";
    private static final int DEFAULT_CONNECTION_TIME_OUT_SECONDS = 15;
    public Context mContext;
    private L mListener;
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private String mTag;

    private Retrofit createRetrofit(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "www.huobi.com";
        }
        return new Retrofit.Builder().client(getOkHttpClient()).baseUrl(str).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(d.a()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        if (getListener() != null) {
            getListener().buildOkHttpClient(builder);
        }
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
        if (getListener() != null) {
            getListener().buildSocketOkHttpClient(builder);
        }
    }

    public OkHttpClient.Builder createOkHttpClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(15, timeUnit).readTimeout(15, timeUnit).writeTimeout(15, timeUnit).retryOnConnectionFailure(false);
        b2.a.d().a("/debug/mock_manager").navigation();
        if (!c.b().f70561b.isEmpty()) {
            for (Interceptor addInterceptor : c.b().f70561b) {
                builder.addInterceptor(addInterceptor);
            }
        }
        return builder;
    }

    public OkHttpClient.Builder createSocketOkHttpClientBuilder() {
        OkHttpClient.Builder createOkHttpClientBuilder = createOkHttpClientBuilder();
        buildSocketOkHttpClient(createOkHttpClientBuilder);
        return createOkHttpClientBuilder;
    }

    public <T> T doRequest(Class<T> cls) {
        Retrofit retrofit = this.mRetrofit;
        if (retrofit == null) {
            this.mRetrofit = createRetrofit(getHost());
        } else {
            String host = retrofit.baseUrl().host();
            String host2 = getHost();
            if (host2 != null && !host2.equals(host)) {
                this.mRetrofit = createRetrofit(host2);
            }
        }
        return this.mRetrofit.create(cls);
    }

    public String getCacheFileName() {
        return "network";
    }

    public String getHost() {
        if (getListener() == null) {
            return null;
        }
        return getListener().getHost();
    }

    public L getListener() {
        return this.mListener;
    }

    public OkHttpClient getOkHttpClient() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mOkHttpClient == null) {
            OkHttpClient.Builder createOkHttpClientBuilder = createOkHttpClientBuilder();
            buildOkHttpClient(createOkHttpClientBuilder);
            this.mOkHttpClient = createOkHttpClientBuilder.build();
        }
        return this.mOkHttpClient;
    }

    public String getTag() {
        return this.mTag;
    }

    public void init(String str, Context context, L l11) {
        SPUtil.k(context);
        this.mTag = str;
        this.mContext = context;
        this.mListener = l11;
        this.mRetrofit = null;
    }
}
