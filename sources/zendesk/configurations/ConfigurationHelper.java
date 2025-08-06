package zendesk.configurations;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConfigurationHelper {

    /* renamed from: a  reason: collision with root package name */
    public static String f62929a = "ZENDESK_CONFIGURATION";

    /* renamed from: b  reason: collision with root package name */
    public static ConfigurationHelper f62930b = new ConfigurationHelper();

    public static ConfigurationHelper h() {
        return f62930b;
    }

    public List<Configuration> a(List<Configuration> list, Configuration configuration) {
        ArrayList arrayList = new ArrayList(list);
        if (e(list, configuration.getClass()) == null) {
            arrayList.add(configuration);
        }
        return arrayList;
    }

    public void b(Bundle bundle, Configuration configuration) {
        bundle.putSerializable(f62929a, configuration);
    }

    public void c(Intent intent, Configuration configuration) {
        intent.putExtra(f62929a, configuration);
    }

    public void d(Map<String, Object> map, Configuration configuration) {
        map.put(f62929a, configuration);
    }

    public <E extends Configuration> E e(List<Configuration> list, Class<E> cls) {
        Iterator<Configuration> it2 = list.iterator();
        while (it2.hasNext()) {
            E e11 = (Configuration) it2.next();
            if (cls.isInstance(e11)) {
                return e11;
            }
        }
        return null;
    }

    public <E extends Configuration> E f(Bundle bundle, Class<E> cls) {
        if (bundle == null || !bundle.containsKey(f62929a)) {
            return null;
        }
        E serializable = bundle.getSerializable(f62929a);
        if (cls.isInstance(serializable)) {
            return (Configuration) serializable;
        }
        return null;
    }

    public <E extends Configuration> E g(Map<String, Object> map, Class<E> cls) {
        if (map == null || !map.containsKey(f62929a)) {
            return null;
        }
        E e11 = map.get(f62929a);
        if (cls.isInstance(e11)) {
            return (Configuration) e11;
        }
        return null;
    }
}
