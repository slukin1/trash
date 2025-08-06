package c10;

import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.o;
import kotlin.reflect.c;

public final class a {
    public static final <T> Class<T> a(c<T> cVar) {
        return ((o) cVar).e();
    }

    public static final <T> Class<T> b(c<T> cVar) {
        Class<?> e11 = ((o) cVar).e();
        if (!e11.isPrimitive()) {
            return e11;
        }
        String name = e11.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals("double") ? e11 : Double.class;
            case 104431:
                return !name.equals("int") ? e11 : Integer.class;
            case 3039496:
                return !name.equals("byte") ? e11 : Byte.class;
            case 3052374:
                return !name.equals("char") ? e11 : Character.class;
            case 3327612:
                return !name.equals("long") ? e11 : Long.class;
            case 3625364:
                return !name.equals("void") ? e11 : Void.class;
            case 64711720:
                return !name.equals("boolean") ? e11 : Boolean.class;
            case 97526364:
                return !name.equals("float") ? e11 : Float.class;
            case 109413500:
                return !name.equals("short") ? e11 : Short.class;
            default:
                return e11;
        }
    }

    public static final <T> c<T> c(Class<T> cls) {
        return Reflection.b(cls);
    }
}
