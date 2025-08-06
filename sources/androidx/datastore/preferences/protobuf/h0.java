package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class h0 {
    public static final String a(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (Character.isUpperCase(charAt)) {
                sb2.append("_");
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    public static boolean b(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof f0) {
                if (obj == ((f0) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum)) {
                return false;
            } else {
                if (((Enum) obj).ordinal() == 0) {
                    return true;
                }
                return false;
            }
        }
    }

    public static final void c(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj instanceof List) {
            for (Object c11 : (List) obj) {
                c(sb2, i11, str, c11);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry c12 : ((Map) obj).entrySet()) {
                c(sb2, i11, str, c12);
            }
        } else {
            sb2.append(10);
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                sb2.append(' ');
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(x0.c((String) obj));
                sb2.append('\"');
            } else if (obj instanceof ByteString) {
                sb2.append(": \"");
                sb2.append(x0.a((ByteString) obj));
                sb2.append('\"');
            } else if (obj instanceof GeneratedMessageLite) {
                sb2.append(" {");
                d((GeneratedMessageLite) obj, sb2, i11 + 2);
                sb2.append("\n");
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i14 = i11 + 2;
                c(sb2, i14, "key", entry.getKey());
                c(sb2, i14, "value", entry.getValue());
                sb2.append("\n");
                while (i12 < i11) {
                    sb2.append(' ');
                    i12++;
                }
                sb2.append("}");
            } else {
                sb2.append(l.f34627b);
                sb2.append(obj.toString());
            }
        }
    }

    public static void d(f0 f0Var, StringBuilder sb2, int i11) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : f0Var.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String replaceFirst = str.replaceFirst("get", "");
            boolean z11 = true;
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList") && !replaceFirst.equals("List")) {
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    c(sb2, i11, a(str2), GeneratedMessageLite.s(method2, f0Var, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                String str3 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    c(sb2, i11, a(str3), GeneratedMessageLite.s(method3, f0Var, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str4 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                Method method4 = (Method) hashMap.get("get" + replaceFirst);
                Method method5 = (Method) hashMap.get("has" + replaceFirst);
                if (method4 != null) {
                    Object s11 = GeneratedMessageLite.s(method4, f0Var, new Object[0]);
                    if (method5 != null) {
                        z11 = ((Boolean) GeneratedMessageLite.s(method5, f0Var, new Object[0])).booleanValue();
                    } else if (b(s11)) {
                        z11 = false;
                    }
                    if (z11) {
                        c(sb2, i11, a(str4), s11);
                    }
                }
            }
        }
        if (f0Var instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.c, Object>> s12 = ((GeneratedMessageLite.ExtendableMessage) f0Var).extensions.s();
            while (s12.hasNext()) {
                Map.Entry next = s12.next();
                c(sb2, i11, "[" + ((GeneratedMessageLite.c) next.getKey()).getNumber() + "]", next.getValue());
            }
        }
        z0 z0Var = ((GeneratedMessageLite) f0Var).unknownFields;
        if (z0Var != null) {
            z0Var.m(sb2, i11);
        }
    }

    public static String e(f0 f0Var, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        d(f0Var, sb2, 0);
        return sb2.toString();
    }
}
