package com.tencent.qcloud.tuikit.tuichat.util;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.rxjava3.RxDataStore;
import com.google.gson.Gson;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.b;
import j00.g;
import p00.a;

public class DataStoreUtil {
    /* access modifiers changed from: private */
    public static final String TAG = "DataStoreUtil";
    private static DataStoreUtil instance;
    private RxDataStore<Preferences> dataStore = null;

    public class DisponseHandler {
        public b disposable;

        public DisponseHandler() {
        }
    }

    public interface GetResult<T> {
        void onFail();

        void onSuccess(T t11);
    }

    private DataStoreUtil() {
    }

    public static DataStoreUtil getInstance() {
        if (instance == null) {
            instance = new DataStoreUtil();
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$getValue$0(Preferences.a aVar, Preferences preferences) throws Throwable {
        return (String) preferences.b(aVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$getValueAsync$1(Preferences.a aVar, Preferences preferences) throws Throwable {
        return (String) preferences.b(aVar);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Single lambda$putValue$2(Object obj, Preferences.a aVar, Preferences preferences) throws Throwable {
        MutablePreferences c11 = preferences.c();
        c11.j(aVar, new Gson().toJson(obj));
        return Single.c(c11);
    }

    public <T> T getValue(String str, Class<T> cls) {
        if (this.dataStore == null) {
            TUIChatLog.e(TAG, "dataStore is null");
            return null;
        }
        Preferences.a<String> f11 = androidx.datastore.preferences.core.b.f(str);
        return new Gson().fromJson((String) this.dataStore.c().d(new a(f11)).a(), cls);
    }

    public <T> void getValueAsync(String str, final GetResult<T> getResult, Class<T> cls) {
        if (this.dataStore == null) {
            TUIChatLog.e(TAG, "dataStore is null");
            getResult.onFail();
            return;
        }
        final Flowable<R> d11 = this.dataStore.c().d(new b(androidx.datastore.preferences.core.b.f(str)));
        final DisponseHandler disponseHandler = new DisponseHandler();
        final Class<T> cls2 = cls;
        final GetResult<T> getResult2 = getResult;
        final DisponseHandler disponseHandler2 = disponseHandler;
        disponseHandler.disposable = d11.k(a.a()).e(g00.b.c()).g(new g<String>() {
            public void accept(String str) throws Throwable {
                getResult2.onSuccess(new Gson().fromJson((String) d11.a(), cls2));
                b bVar = disponseHandler2.disposable;
                if (bVar != null && !bVar.isDisposed()) {
                    disponseHandler2.disposable.dispose();
                }
            }
        }, new g<Throwable>() {
            public void accept(Throwable th2) throws Throwable {
                String access$000 = DataStoreUtil.TAG;
                TUIChatLog.e(access$000, "dataStore throwable = " + th2);
                getResult.onFail();
                b bVar = disponseHandler.disposable;
                if (bVar != null && !bVar.isDisposed()) {
                    disponseHandler.disposable.dispose();
                }
            }
        });
    }

    public <T> void putValue(String str, T t11) {
        if (this.dataStore == null) {
            TUIChatLog.e(TAG, "dataStore is null");
            return;
        }
        this.dataStore.d(new c(t11, androidx.datastore.preferences.core.b.f(str))).d();
    }

    public void setDataStore(RxDataStore<Preferences> rxDataStore) {
        this.dataStore = rxDataStore;
    }
}
