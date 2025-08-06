package o3;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface d<T> {

    public interface a<T> {
        void d(T t11);

        void e(Exception exc);
    }

    Class<T> a();

    void b();

    DataSource c();

    void cancel();

    void f(Priority priority, a<? super T> aVar);
}
