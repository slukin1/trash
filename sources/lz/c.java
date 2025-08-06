package lz;

import com.zendesk.service.ZendeskCallback;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class c<E, F> implements Callback<E> {

    /* renamed from: c  reason: collision with root package name */
    public static final b f58078c = new a();

    /* renamed from: a  reason: collision with root package name */
    public final ZendeskCallback<F> f58079a;

    /* renamed from: b  reason: collision with root package name */
    public final b<E, F> f58080b;

    public static final class a<E> implements b<E, E> {
        public E extract(E e11) {
            return e11;
        }
    }

    public interface b<E, F> {
        F extract(E e11);
    }

    public c(ZendeskCallback<F> zendeskCallback, b<E, F> bVar) {
        this.f58079a = zendeskCallback;
        this.f58080b = bVar;
    }

    public void onFailure(Call<E> call, Throwable th2) {
        ZendeskCallback<F> zendeskCallback = this.f58079a;
        if (zendeskCallback != null) {
            zendeskCallback.onError(b.d(th2));
        }
    }

    public void onResponse(Call<E> call, Response<E> response) {
        if (this.f58079a == null) {
            return;
        }
        if (response.isSuccessful()) {
            this.f58079a.onSuccess(this.f58080b.extract(response.body()));
        } else {
            this.f58079a.onError(b.c(response));
        }
    }

    public c(ZendeskCallback<F> zendeskCallback) {
        this(zendeskCallback, f58078c);
    }
}
