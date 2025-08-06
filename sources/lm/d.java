package lm;

import com.huobi.kalle.Response;
import java.lang.reflect.Type;

public interface d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f76249a = new a();

    public class a implements d {
        public <S, F> h<S, F> a(Type type, Type type2, Response response, boolean z11) throws Exception {
            return h.d().g(response.b()).j(response.e()).i(z11).k(type == String.class ? response.a().string() : null).f();
        }
    }

    <S, F> h<S, F> a(Type type, Type type2, Response response, boolean z11) throws Exception;
}
