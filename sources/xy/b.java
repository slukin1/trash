package xy;

import android.util.Log;
import com.tekartik.sqflite.dev.Debug;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f40664a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Object> f40665b;

    public b(String str, List<Object> list) {
        this.f40664a = str;
        this.f40665b = list == null ? new ArrayList<>() : list;
    }

    public static Map<String, Object> a(Map<Object, Object> map) {
        Object obj;
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            if (value instanceof Map) {
                obj = a((Map) value);
            } else {
                obj = j(value);
            }
            hashMap.put(j(next.getKey()), obj);
        }
        return hashMap;
    }

    public static String j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            ArrayList arrayList = new ArrayList();
            for (byte valueOf : (byte[]) obj) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList.toString();
        } else if (obj instanceof Map) {
            return a((Map) obj).toString();
        } else {
            return obj.toString();
        }
    }

    public static Object k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (Debug.f40454c) {
            Log.d("Sqflite", "arg " + obj.getClass().getCanonicalName() + " " + j(obj));
        }
        if (obj instanceof List) {
            List list = (List) obj;
            byte[] bArr = new byte[list.size()];
            for (int i11 = 0; i11 < list.size(); i11++) {
                bArr[i11] = (byte) ((Integer) list.get(i11)).intValue();
            }
            obj = bArr;
        }
        if (Debug.f40454c) {
            Log.d("Sqflite", "arg " + obj.getClass().getCanonicalName() + " " + j(obj));
        }
        return obj;
    }

    public String[] b() {
        return c(this.f40665b);
    }

    public final String[] c(List<Object> list) {
        return (String[]) h(list).toArray(new String[0]);
    }

    public List<Object> d() {
        return this.f40665b;
    }

    public String e() {
        return this.f40664a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f40664a;
        if (str != null) {
            if (!str.equals(bVar.f40664a)) {
                return false;
            }
        } else if (bVar.f40664a != null) {
            return false;
        }
        if (this.f40665b.size() != bVar.f40665b.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f40665b.size(); i11++) {
            if (!(this.f40665b.get(i11) instanceof byte[]) || !(bVar.f40665b.get(i11) instanceof byte[])) {
                if (!this.f40665b.get(i11).equals(bVar.f40665b.get(i11))) {
                    return false;
                }
            } else if (!Arrays.equals((byte[]) this.f40665b.get(i11), (byte[]) bVar.f40665b.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public Object[] f() {
        return g(this.f40665b);
    }

    public final Object[] g(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object k11 : list) {
                arrayList.add(k(k11));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    public final List<String> h(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Object j11 : list) {
                arrayList.add(j(j11));
            }
        }
        return arrayList;
    }

    public int hashCode() {
        String str = this.f40664a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public b i() {
        if (this.f40665b.size() == 0) {
            return this;
        }
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int length = this.f40664a.length();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            char charAt = this.f40664a.charAt(i13);
            if (charAt == '?') {
                int i14 = i13 + 1;
                if (i14 < length && Character.isDigit(this.f40664a.charAt(i14))) {
                    return this;
                }
                i11++;
                if (i12 >= this.f40665b.size()) {
                    return this;
                }
                int i15 = i12 + 1;
                Object obj = this.f40665b.get(i12);
                if ((obj instanceof Integer) || (obj instanceof Long)) {
                    sb2.append(obj.toString());
                    i12 = i15;
                } else {
                    arrayList.add(obj);
                    i12 = i15;
                }
            }
            sb2.append(charAt);
        }
        if (i11 != this.f40665b.size()) {
            return this;
        }
        return new b(sb2.toString(), arrayList);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f40664a);
        List<Object> list = this.f40665b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + h(this.f40665b);
        }
        sb2.append(str);
        return sb2.toString();
    }
}
