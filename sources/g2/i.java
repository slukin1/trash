package g2;

import com.alibaba.fastjson.JSONException;
import i2.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public final a f15808a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f15809b;

    public i(Class<?> cls, a aVar) {
        this.f15809b = cls;
        this.f15808a = aVar;
    }

    public int a() {
        return 0;
    }

    public abstract void b(f2.a aVar, Object obj, Type type, Map<String, Object> map);

    public void c(Object obj, int i11) {
        e(obj, Integer.valueOf(i11));
    }

    public void d(Object obj, long j11) {
        e(obj, Long.valueOf(j11));
    }

    public void e(Object obj, Object obj2) {
        if (obj2 != null || !this.f15808a.f15966f.isPrimitive()) {
            try {
                a aVar = this.f15808a;
                Method method = aVar.f15963c;
                if (method == null) {
                    Field field = aVar.f15964d;
                    if (aVar.f15969i) {
                        Class<?> cls = aVar.f15966f;
                        if (cls == AtomicInteger.class) {
                            AtomicInteger atomicInteger = (AtomicInteger) field.get(obj);
                            if (atomicInteger != null) {
                                atomicInteger.set(((AtomicInteger) obj2).get());
                            }
                        } else if (cls == AtomicLong.class) {
                            AtomicLong atomicLong = (AtomicLong) field.get(obj);
                            if (atomicLong != null) {
                                atomicLong.set(((AtomicLong) obj2).get());
                            }
                        } else if (cls == AtomicBoolean.class) {
                            AtomicBoolean atomicBoolean = (AtomicBoolean) field.get(obj);
                            if (atomicBoolean != null) {
                                atomicBoolean.set(((AtomicBoolean) obj2).get());
                            }
                        } else if (Map.class.isAssignableFrom(cls)) {
                            Map map = (Map) field.get(obj);
                            if (map != null) {
                                map.putAll((Map) obj2);
                            }
                        } else {
                            Collection collection = (Collection) field.get(obj);
                            if (collection != null && obj2 != null) {
                                collection.clear();
                                collection.addAll((Collection) obj2);
                            }
                        }
                    } else if (field != null) {
                        field.set(obj, obj2);
                    }
                } else if (aVar.f15969i) {
                    Class<?> cls2 = aVar.f15966f;
                    if (cls2 == AtomicInteger.class) {
                        AtomicInteger atomicInteger2 = (AtomicInteger) method.invoke(obj, new Object[0]);
                        if (atomicInteger2 != null) {
                            atomicInteger2.set(((AtomicInteger) obj2).get());
                        }
                    } else if (cls2 == AtomicLong.class) {
                        AtomicLong atomicLong2 = (AtomicLong) method.invoke(obj, new Object[0]);
                        if (atomicLong2 != null) {
                            atomicLong2.set(((AtomicLong) obj2).get());
                        }
                    } else if (cls2 == AtomicBoolean.class) {
                        AtomicBoolean atomicBoolean2 = (AtomicBoolean) method.invoke(obj, new Object[0]);
                        if (atomicBoolean2 != null) {
                            atomicBoolean2.set(((AtomicBoolean) obj2).get());
                        }
                    } else if (Map.class.isAssignableFrom(method.getReturnType())) {
                        Map map2 = (Map) method.invoke(obj, new Object[0]);
                        if (map2 != null) {
                            map2.putAll((Map) obj2);
                        }
                    } else {
                        Collection collection2 = (Collection) method.invoke(obj, new Object[0]);
                        if (collection2 != null && obj2 != null) {
                            collection2.clear();
                            collection2.addAll((Collection) obj2);
                        }
                    }
                } else {
                    method.invoke(obj, new Object[]{obj2});
                }
            } catch (Exception e11) {
                throw new JSONException("set property error, " + this.f15808a.f15962b, e11);
            }
        }
    }

    public void f(Object obj, String str) {
        e(obj, str);
    }

    public void g(Object obj, boolean z11) {
        e(obj, Boolean.valueOf(z11));
    }
}
