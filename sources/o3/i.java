package o3;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import o3.d;

public abstract class i<T> implements d<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Uri f66532b;

    /* renamed from: c  reason: collision with root package name */
    public final ContentResolver f66533c;

    /* renamed from: d  reason: collision with root package name */
    public T f66534d;

    public i(ContentResolver contentResolver, Uri uri) {
        this.f66533c = contentResolver;
        this.f66532b = uri;
    }

    public void b() {
        T t11 = this.f66534d;
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

    public abstract T e(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public final void f(Priority priority, d.a<? super T> aVar) {
        try {
            T e11 = e(this.f66532b, this.f66533c);
            this.f66534d = e11;
            aVar.d(e11);
        } catch (FileNotFoundException e12) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e12);
            }
            aVar.e(e12);
        }
    }
}
