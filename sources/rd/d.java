package rd;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f23353a = new d();

    public static final class a extends TypeToken<Map<String, ? extends Object>> {
    }

    public final <T> String a(T t11) {
        return new GsonBuilder().create().toJson((Object) t11);
    }

    public final <T> T b(String str, Class<T> cls) {
        Gson create = new GsonBuilder().create();
        JsonReader jsonReader = new JsonReader(new StringReader(str));
        jsonReader.setLenient(true);
        return create.fromJson(jsonReader, (Type) cls);
    }

    public final <T> List<T> c(String str, Class<T> cls) {
        return (List) new Gson().fromJson(str, TypeToken.getParameterized(ArrayList.class, cls).getType());
    }

    public final Map<String, Object> d(String str) {
        return (Map) new GsonBuilder().create().fromJson(str, new a().getType());
    }
}
