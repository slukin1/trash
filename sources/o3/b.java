package o3;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import o3.d;

public abstract class b<T> implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final String f66513b;

    /* renamed from: c  reason: collision with root package name */
    public final AssetManager f66514c;

    /* renamed from: d  reason: collision with root package name */
    public T f66515d;

    public b(AssetManager assetManager, String str) {
        this.f66514c = assetManager;
        this.f66513b = str;
    }

    public void b() {
        T t11 = this.f66515d;
        if (t11 != null) {
            try {
                d(t11);
            } catch (IOException unused) {
            }
        }
    }

    public DataSource c() {
        return DataSource.LOCAL;
    }

    public void cancel() {
    }

    public abstract void d(T t11) throws IOException;

    public abstract T e(AssetManager assetManager, String str) throws IOException;

    public void f(Priority priority, d.a<? super T> aVar) {
        try {
            T e11 = e(this.f66514c, this.f66513b);
            this.f66515d = e11;
            aVar.d(e11);
        } catch (IOException e12) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e12);
            }
            aVar.e(e12);
        }
    }
}
