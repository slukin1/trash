package zendesk.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import aw.a;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.n;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandler;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.SessionStorage;
import zendesk.support.requestlist.RequestInfoDataSource;

class SupportSdkModule {
    private static final int MAX_DISK_CACHE_SIZE = 20971520;

    public ConfigurationHelper configurationHelper() {
        return new ConfigurationHelper();
    }

    public Executor mainThreadExecutor() {
        return new Executor() {
            public Handler handler = new Handler(Looper.getMainLooper());

            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        };
    }

    public n okHttp3Downloader(OkHttpClient okHttpClient) {
        return new n(okHttpClient);
    }

    public Gson provides() {
        return new Gson();
    }

    public List<ActionHandler> providesActionHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DeepLinkToRequestActionHandler());
        return arrayList;
    }

    public Picasso providesPicasso(Context context, n nVar, ExecutorService executorService) {
        return new Picasso.b(context).c(nVar).d(executorService).b(Bitmap.Config.RGB_565).a();
    }

    public a providesRequestDiskLruCache(SessionStorage sessionStorage) {
        try {
            return a.x(new File(sessionStorage.getZendeskDataDir(), "request"), 1, 1, 20971520);
        } catch (IOException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public String providesZendeskUrl(ApplicationConfiguration applicationConfiguration) {
        return applicationConfiguration.getZendeskUrl();
    }

    public RequestInfoDataSource.LocalDataSource requestInfoDataSource(SupportUiStorage supportUiStorage, Executor executor, ExecutorService executorService) {
        return new RequestInfoDataSource.LocalDataSource(new RequestInfoDataSource.Disk(executor, executorService, supportUiStorage, RequestInfoDataSource.LOCAL));
    }

    public SupportUiStorage supportUiStorage(a aVar, Gson gson) {
        return new SupportUiStorage(aVar, gson);
    }
}
