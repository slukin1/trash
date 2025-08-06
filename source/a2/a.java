package a2;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Class<? extends IRouteGroup>> f3479a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, RouteMeta> f3480b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Map<Class, IProvider> f3481c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static Map<String, RouteMeta> f3482d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static Map<Integer, Class<? extends IInterceptor>> f3483e = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");

    /* renamed from: f  reason: collision with root package name */
    public static List<IInterceptor> f3484f = new ArrayList();
}
