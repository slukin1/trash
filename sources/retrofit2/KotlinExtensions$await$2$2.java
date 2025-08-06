package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.k;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 1, 15})
public final class KotlinExtensions$await$2$2 implements Callback<T> {
    public final /* synthetic */ k $continuation;

    public KotlinExtensions$await$2$2(k kVar) {
        this.$continuation = kVar;
    }

    public void onFailure(Call<T> call, Throwable th2) {
        k kVar = this.$continuation;
        Result.a aVar = Result.Companion;
        kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(th2)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                if (tag == null) {
                    x.j();
                }
                Method method = ((Invocation) tag).method();
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + method.getDeclaringClass().getName() + '.' + method.getName() + " was null but response body type was declared as non-null");
                k kVar = this.$continuation;
                Result.a aVar = Result.Companion;
                kVar.resumeWith(Result.m3072constructorimpl(kotlin.k.a(kotlinNullPointerException)));
                return;
            }
            k kVar2 = this.$continuation;
            Result.a aVar2 = Result.Companion;
            kVar2.resumeWith(Result.m3072constructorimpl(body));
            return;
        }
        k kVar3 = this.$continuation;
        HttpException httpException = new HttpException(response);
        Result.a aVar3 = Result.Companion;
        kVar3.resumeWith(Result.m3072constructorimpl(kotlin.k.a(httpException)));
    }
}
