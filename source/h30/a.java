package h30;

import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import java.util.Map;
import zendesk.configurations.Configuration;
import zendesk.configurations.ConfigurationHelper;

@Deprecated
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static ConfigurationHelper f60322a = new ConfigurationHelper();

    public static List<Configuration> a(List<Configuration> list, Configuration configuration) {
        return f60322a.a(list, configuration);
    }

    public static void b(Bundle bundle, Configuration configuration) {
        f60322a.b(bundle, configuration);
    }

    public static void c(Intent intent, Configuration configuration) {
        f60322a.c(intent, configuration);
    }

    public static <E extends Configuration> E d(List<Configuration> list, Class<E> cls) {
        return f60322a.e(list, cls);
    }

    public static <E extends Configuration> E e(Bundle bundle, Class<E> cls) {
        return f60322a.f(bundle, cls);
    }

    public static <E extends Configuration> E f(Map<String, Object> map, Class<E> cls) {
        return f60322a.g(map, cls);
    }
}
