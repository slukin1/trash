package com.google.android.gms.internal.measurement;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

final class zzmk {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzmi zzmi, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzmi, sb2, 0);
        return sb2.toString();
    }

    public static void zzb(StringBuilder sb2, int i11, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb2, i11, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb2, i11, str, zzb2);
            }
        } else {
            sb2.append(10);
            zzc(i11, sb2);
            if (!str.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Character.toLowerCase(str.charAt(0)));
                for (int i12 = 1; i12 < str.length(); i12++) {
                    char charAt = str.charAt(i12);
                    if (Character.isUpperCase(charAt)) {
                        sb3.append("_");
                    }
                    sb3.append(Character.toLowerCase(charAt));
                }
                str = sb3.toString();
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzni.zza(new zzjx(((String) obj).getBytes(zzlj.zzb))));
                sb2.append('\"');
            } else if (obj instanceof zzka) {
                sb2.append(": \"");
                sb2.append(zzni.zza((zzka) obj));
                sb2.append('\"');
            } else if (obj instanceof zzlb) {
                sb2.append(" {");
                zzd((zzlb) obj, sb2, i11 + 2);
                sb2.append("\n");
                zzc(i11, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i13 = i11 + 2;
                zzb(sb2, i13, "key", entry.getKey());
                zzb(sb2, i13, "value", entry.getValue());
                sb2.append("\n");
                zzc(i11, sb2);
                sb2.append("}");
            } else {
                sb2.append(l.f34627b);
                sb2.append(obj);
            }
        }
    }

    private static void zzc(int i11, StringBuilder sb2) {
        while (i11 > 0) {
            int i12 = 80;
            if (i11 <= 80) {
                i12 = i11;
            }
            sb2.append(zza, 0, i12);
            i11 -= i12;
        }
    }

    private static void zzd(zzmi zzmi, StringBuilder sb2, int i11) {
        int i12;
        boolean z11;
        Method method;
        Method method2;
        zzmi zzmi2 = zzmi;
        StringBuilder sb3 = sb2;
        int i13 = i11;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzmi.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i14 = 0;
        while (true) {
            i12 = 3;
            if (i14 >= length) {
                break;
            }
            Method method3 = declaredMethods[i14];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i14++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i12);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb3, i13, substring.substring(0, substring.length() - 4), zzlb.zzbK(method2, zzmi2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb3, i13, substring.substring(0, substring.length() - 3), zzlb.zzbK(method, zzmi2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzbK = zzlb.zzbK(method4, zzmi2, new Object[0]);
                    if (method5 == null) {
                        if (zzbK instanceof Boolean) {
                            if (!((Boolean) zzbK).booleanValue()) {
                            }
                        } else if (zzbK instanceof Integer) {
                            if (((Integer) zzbK).intValue() == 0) {
                            }
                        } else if (zzbK instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzbK).floatValue()) == 0) {
                            }
                        } else if (!(zzbK instanceof Double)) {
                            if (zzbK instanceof String) {
                                z11 = zzbK.equals("");
                            } else if (zzbK instanceof zzka) {
                                z11 = zzbK.equals(zzka.zzb);
                            } else if (zzbK instanceof zzmi) {
                                if (zzbK == ((zzmi) zzbK).zzbV()) {
                                }
                            } else if ((zzbK instanceof Enum) && ((Enum) zzbK).ordinal() == 0) {
                            }
                            if (z11) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzbK).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzlb.zzbK(method5, zzmi2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb3, i13, substring, zzbK);
                }
            }
            i12 = 3;
        }
        if (!(zzmi2 instanceof zzky)) {
            zznl zznl = ((zzlb) zzmi2).zzc;
            if (zznl != null) {
                zznl.zzi(sb3, i13);
                return;
            }
            return;
        }
        zzky zzky = (zzky) zzmi2;
        throw null;
    }
}
