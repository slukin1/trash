package kotlinx.serialization;

import c10.a;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.c;
import kotlinx.serialization.internal.f1;
import kotlinx.serialization.internal.n1;
import kotlinx.serialization.modules.d;
import kotlinx.serialization.modules.e;

public final /* synthetic */ class i {
    public static final b<Object> a(d dVar, GenericArrayType genericArrayType, boolean z11) {
        b<Object> bVar;
        c cVar;
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (genericComponentType instanceof WildcardType) {
            genericComponentType = (Type) ArraysKt___ArraysKt.I(((WildcardType) genericComponentType).getUpperBounds());
        }
        if (z11) {
            bVar = h.c(dVar, genericComponentType);
        } else {
            bVar = h.f(dVar, genericComponentType);
            if (bVar == null) {
                return null;
            }
        }
        if (genericComponentType instanceof ParameterizedType) {
            cVar = a.c((Class) ((ParameterizedType) genericComponentType).getRawType());
        } else if (genericComponentType instanceof c) {
            cVar = (c) genericComponentType;
        } else {
            throw new IllegalStateException("unsupported type in GenericArray: " + Reflection.b(genericComponentType.getClass()));
        }
        return h10.a.a(cVar, bVar);
    }

    public static final Class<?> b(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return b(((ParameterizedType) type).getRawType());
        }
        if (type instanceof WildcardType) {
            return b((Type) ArraysKt___ArraysKt.I(((WildcardType) type).getUpperBounds()));
        }
        if (type instanceof GenericArrayType) {
            return b(((GenericArrayType) type).getGenericComponentType());
        }
        throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + Reflection.b(type.getClass()));
    }

    public static final <T> b<T> c(d dVar, Class<T> cls, List<? extends b<Object>> list) {
        b[] bVarArr = (b[]) list.toArray(new b[0]);
        b<T> c11 = f1.c(cls, (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        if (c11 != null) {
            return c11;
        }
        c<T> c12 = a.c(cls);
        b<T> b11 = n1.b(c12);
        return b11 == null ? dVar.b(c12, list) : b11;
    }

    public static final b<Object> d(Type type) {
        return h.c(e.a(), type);
    }

    public static final b<Object> e(d dVar, Type type) {
        b<Object> f11 = f(dVar, type, true);
        if (f11 != null) {
            return f11;
        }
        f1.m(b(type));
        throw new KotlinNothingValueException();
    }

    public static final b<Object> f(d dVar, Type type, boolean z11) {
        ArrayList<b> arrayList;
        if (type instanceof GenericArrayType) {
            return a(dVar, (GenericArrayType) type, z11);
        }
        if (type instanceof Class) {
            return i(dVar, (Class) type, z11);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class cls = (Class) parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (z11) {
                arrayList = new ArrayList<>(actualTypeArguments.length);
                for (Type c11 : actualTypeArguments) {
                    arrayList.add(h.c(dVar, c11));
                }
            } else {
                arrayList = new ArrayList<>(actualTypeArguments.length);
                for (Type f11 : actualTypeArguments) {
                    b<Object> f12 = h.f(dVar, f11);
                    if (f12 == null) {
                        return null;
                    }
                    arrayList.add(f12);
                }
            }
            if (Set.class.isAssignableFrom(cls)) {
                return h10.a.n((b) arrayList.get(0));
            }
            if (List.class.isAssignableFrom(cls) || Collection.class.isAssignableFrom(cls)) {
                return h10.a.h((b) arrayList.get(0));
            }
            if (Map.class.isAssignableFrom(cls)) {
                return h10.a.k((b) arrayList.get(0), (b) arrayList.get(1));
            }
            if (Map.Entry.class.isAssignableFrom(cls)) {
                return h10.a.j((b) arrayList.get(0), (b) arrayList.get(1));
            }
            if (Pair.class.isAssignableFrom(cls)) {
                return h10.a.m((b) arrayList.get(0), (b) arrayList.get(1));
            }
            if (Triple.class.isAssignableFrom(cls)) {
                return h10.a.p((b) arrayList.get(0), (b) arrayList.get(1), (b) arrayList.get(2));
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
            for (b add : arrayList) {
                arrayList2.add(add);
            }
            return c(dVar, cls, arrayList2);
        } else if (type instanceof WildcardType) {
            return g(dVar, (Type) ArraysKt___ArraysKt.I(((WildcardType) type).getUpperBounds()), false, 2, (Object) null);
        } else {
            throw new IllegalArgumentException("type should be an instance of Class<?>, GenericArrayType, ParametrizedType or WildcardType, but actual argument " + type + " has type " + Reflection.b(type.getClass()));
        }
    }

    public static /* synthetic */ b g(d dVar, Type type, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return f(dVar, type, z11);
    }

    public static final b<Object> h(d dVar, Type type) {
        return f(dVar, type, false);
    }

    public static final b<Object> i(d dVar, Class<?> cls, boolean z11) {
        b<Object> bVar;
        if (!cls.isArray() || cls.getComponentType().isPrimitive()) {
            return c(dVar, cls, CollectionsKt__CollectionsKt.k());
        }
        Class<?> componentType = cls.getComponentType();
        if (z11) {
            bVar = h.c(dVar, componentType);
        } else {
            bVar = h.f(dVar, componentType);
            if (bVar == null) {
                return null;
            }
        }
        return h10.a.a(a.c(componentType), bVar);
    }
}
