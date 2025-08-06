package com.mob.tools.utils;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.C0891r;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.MobPersistence;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class SharePrefrenceHelper implements PublicMemberKeeper {
    public static final String SP_CACHE_FOLDER = C0891r.b("003[gbcjee");

    /* renamed from: a  reason: collision with root package name */
    private Context f28149a;

    /* renamed from: b  reason: collision with root package name */
    private volatile MobPersistence f28150b;

    public SharePrefrenceHelper(Context context) {
        if (context != null) {
            this.f28149a = context.getApplicationContext();
        }
    }

    /* access modifiers changed from: private */
    public boolean b(String str) {
        try {
            return Pattern.matches("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$", str);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return false;
        }
    }

    public static boolean isMobSpFileExist(Context context, String str, int i11) {
        return a.a(context, str + "_" + i11);
    }

    public static boolean isMpfFileExist(Context context, String str, int i11) {
        return MobPersistence.a(context, str + "_" + i11);
    }

    public void clear() {
        if (this.f28150b != null) {
            try {
                this.f28150b.a();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public Object get(String str) {
        return get(str, (Object) null);
    }

    @Deprecated
    public HashMap<String, Object> getAll() {
        if (this.f28150b != null) {
            try {
                return this.f28150b.b();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return new HashMap<>();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBooleanThrowable(String str) throws MobPersistence.NoValidDataException {
        return getBooleanThrowable(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDoubleThrowable(String str) throws MobPersistence.NoValidDataException {
        return getDoubleThrowable(str, 0.0d);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getIntThrowable(String str) throws MobPersistence.NoValidDataException {
        return getIntThrowable(str, 0);
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public long getLongThrowable(String str) throws MobPersistence.NoValidDataException {
        return getLongThrowable(str, 0);
    }

    @Deprecated
    public Object getObj(String str, Object obj) {
        return get(str, obj);
    }

    public <T extends Parcelable> T getParcel(String str, Class<T> cls) {
        return getParcel(str, cls, (Parcelable) null);
    }

    public <T extends Parcelable> T[] getParcelArray(String str, Class<T> cls) {
        return getParcelArray(str, cls, (T[]) null);
    }

    public <T extends Parcelable> T[] getParcelArrayThrowable(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return getParcelArrayThrowable(str, cls, (T[]) null);
    }

    public <T extends Parcelable> List<T> getParcelList(String str, Class<T> cls) {
        return getParcelList(str, cls, (List) null);
    }

    public <T extends Parcelable> List<T> getParcelListThrowable(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return getParcelListThrowable(str, cls, (List) null);
    }

    public <T extends Parcelable> Map<String, T> getParcelMap(String str, Class<T> cls) {
        return getParcelMap(str, cls, (Map) null);
    }

    public <T extends Parcelable> Map<String, T> getParcelMapThrowable(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return getParcelMapThrowable(str, cls, (Map) null);
    }

    public <T extends Parcelable> T getParcelThrowable(String str, Class<T> cls) throws MobPersistence.NoValidDataException {
        return (Parcelable) getParcelThrowable(str, cls, (Object) null);
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public String getStringThrowable(String str) throws MobPersistence.NoValidDataException {
        return getStringThrowable(str, "");
    }

    public Object getThrowable(String str) throws MobPersistence.NoValidDataException {
        return getThrowable(str, (Object) null);
    }

    public void open(String str) {
        open(str, 0);
    }

    public void put(String str, Object obj) {
        put(str, obj, 0);
    }

    @Deprecated
    public void putAll(HashMap<String, Object> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry next : hashMap.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
        }
    }

    public void putBoolean(String str, Boolean bool) {
        putBoolean(str, bool, 0);
    }

    public void putDouble(String str, Double d11) {
        putDouble(str, d11, 0);
    }

    public void putInt(String str, Integer num) {
        putInt(str, num, 0);
    }

    public void putLong(String str, Long l11) {
        putLong(str, l11, 0);
    }

    @Deprecated
    public void putObj(String str, Object obj) {
        if (obj == null && this.f28150b != null) {
            remove(str);
        } else if (this.f28150b != null) {
            put(str, obj);
        }
    }

    public void putParcel(String str, Parcelable parcelable) {
        putParcel(str, parcelable, 0);
    }

    public <T extends Parcelable> void putParcelArray(String str, T[] tArr) {
        putParcelArray(str, tArr, 0);
    }

    public <T extends Parcelable> void putParcelList(String str, List<T> list) {
        putParcelList(str, list, 0);
    }

    public <T extends Parcelable> void putParcelMap(String str, Map<String, T> map) {
        putParcelMap(str, map, 0);
    }

    public void putString(String str, String str2) {
        putString(str, str2, 0);
    }

    public void remove(String str) {
        if (this.f28150b != null) {
            try {
                this.f28150b.a(str);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public Object get(String str, Object obj) {
        try {
            return getThrowable(str, obj);
        } catch (MobPersistence.NoValidDataException unused) {
            return obj;
        }
    }

    public boolean getBoolean(String str, boolean z11) {
        try {
            return getBooleanThrowable(str, z11);
        } catch (MobPersistence.NoValidDataException unused) {
            return z11;
        }
    }

    public boolean getBooleanThrowable(String str, boolean z11) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                Object a11 = this.f28150b.a(new MobPersistence.e(str));
                if (a11 == null) {
                    return z11;
                }
                if (a11 instanceof Boolean) {
                    return ((Boolean) a11).booleanValue();
                }
                return ((Number) a11).byteValue() == 1;
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return z11;
    }

    public double getDouble(String str, double d11) {
        try {
            return getDoubleThrowable(str, d11);
        } catch (MobPersistence.NoValidDataException unused) {
            return d11;
        }
    }

    public double getDoubleThrowable(String str, double d11) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                Double d12 = (Double) this.f28150b.a(new MobPersistence.e(str));
                return d12 == null ? d11 : d12.doubleValue();
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return d11;
    }

    public int getInt(String str, int i11) {
        try {
            return getIntThrowable(str, i11);
        } catch (MobPersistence.NoValidDataException unused) {
            return i11;
        }
    }

    public int getIntThrowable(String str, int i11) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                Integer num = (Integer) this.f28150b.a(new MobPersistence.e(str));
                return num == null ? i11 : num.intValue();
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return i11;
    }

    public long getLong(String str, long j11) {
        try {
            return getLongThrowable(str, j11);
        } catch (MobPersistence.NoValidDataException unused) {
            return j11;
        }
    }

    public long getLongThrowable(String str, long j11) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                Long l11 = (Long) this.f28150b.a(new MobPersistence.e(str));
                return l11 == null ? j11 : l11.longValue();
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return j11;
    }

    public <T extends Parcelable> T getParcel(String str, Class<T> cls, T t11) {
        try {
            return (Parcelable) getParcelThrowable(str, cls, t11);
        } catch (MobPersistence.NoValidDataException unused) {
            return t11;
        }
    }

    public <T extends Parcelable> T[] getParcelArray(String str, Class<T> cls, T[] tArr) {
        try {
            return getParcelArrayThrowable(str, cls, tArr);
        } catch (MobPersistence.NoValidDataException unused) {
            return tArr;
        }
    }

    public <T extends Parcelable> T[] getParcelArrayThrowable(String str, final Class<T> cls, final T[] tArr) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                T[] tArr2 = (Parcelable[]) this.f28150b.a(new MobPersistence.e<T[]>(str) {
                    /* renamed from: b */
                    public T[] a(Object obj) {
                        if (obj == null) {
                            return tArr;
                        }
                        HashMap[] hashMapArr = (HashMap[]) obj;
                        T[] tArr = (Parcelable[]) Array.newInstance(cls, hashMapArr.length);
                        for (int i11 = 0; i11 < tArr.length; i11++) {
                            tArr[i11] = MobPersistence.b.a((HashMap<Byte, Object>) hashMapArr[i11]).a(null);
                        }
                        return tArr;
                    }
                });
                return tArr2 != null ? tArr2 : tArr;
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return tArr;
    }

    public <T extends Parcelable> List<T> getParcelList(String str, Class<T> cls, List<T> list) {
        try {
            return getParcelListThrowable(str, cls, list);
        } catch (MobPersistence.NoValidDataException unused) {
            return list;
        }
    }

    public <T extends Parcelable> List<T> getParcelListThrowable(String str, Class<T> cls, final List<T> list) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                List<T> list2 = (List) this.f28150b.a(new MobPersistence.e<List<T>>(str) {
                    /* renamed from: b */
                    public List<T> a(Object obj) {
                        List<T> list;
                        if (obj == null) {
                            return list;
                        }
                        List<HashMap> list2 = (List) obj;
                        if (list2 instanceof ArrayList) {
                            list = new ArrayList<>();
                        } else if (list2 instanceof LinkedList) {
                            list = new LinkedList<>();
                        } else {
                            list = new ArrayList<>();
                        }
                        for (HashMap a11 : list2) {
                            list.add(MobPersistence.b.a((HashMap<Byte, Object>) a11).a(null));
                        }
                        return list;
                    }
                });
                return list2 != null ? list2 : list;
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return list;
    }

    public <T extends Parcelable> Map<String, T> getParcelMap(String str, Class<T> cls, Map<String, T> map) {
        try {
            return getParcelMapThrowable(str, cls, map);
        } catch (MobPersistence.NoValidDataException unused) {
            return map;
        }
    }

    public <T extends Parcelable> Map<String, T> getParcelMapThrowable(String str, Class<T> cls, final Map<String, T> map) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                Map<String, T> map2 = (Map) this.f28150b.a(new MobPersistence.e<Map<String, T>>(str) {
                    /* renamed from: b */
                    public Map<String, T> a(Object obj) {
                        Map<String, T> map;
                        if (obj == null) {
                            return map;
                        }
                        Map map2 = (Map) obj;
                        if (map2 instanceof HashMap) {
                            map = new HashMap<>();
                        } else if (map2 instanceof Hashtable) {
                            map = new Hashtable<>();
                        } else if (map2 instanceof TreeMap) {
                            map = new TreeMap<>();
                        } else {
                            map = new HashMap<>();
                        }
                        for (Map.Entry entry : map2.entrySet()) {
                            map.put(entry.getKey(), MobPersistence.b.a((HashMap<Byte, Object>) (HashMap) entry.getValue()).a(null));
                        }
                        return map;
                    }
                });
                return map2 != null ? map2 : map;
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return map;
    }

    public <T> T getParcelThrowable(String str, Class<T> cls, final T t11) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                T a11 = this.f28150b.a(new MobPersistence.e<T>(str) {
                    public T a(Object obj) {
                        if (obj != null) {
                            return MobPersistence.b.a((HashMap<Byte, Object>) (HashMap) obj).a((Parcelable) t11);
                        }
                        return t11;
                    }
                });
                return a11 != null ? a11 : t11;
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return t11;
    }

    public String getString(String str, String str2) {
        try {
            return getStringThrowable(str, str2);
        } catch (MobPersistence.NoValidDataException unused) {
            return str2;
        }
    }

    public String getStringThrowable(String str, String str2) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                String str3 = (String) this.f28150b.a(new MobPersistence.e(str));
                return TextUtils.isEmpty(str3) ? str2 : str3;
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return str2;
    }

    public Object getThrowable(String str, final Object obj) throws MobPersistence.NoValidDataException {
        if (this.f28150b != null) {
            try {
                Object a11 = this.f28150b.a(new MobPersistence.e<Object>(str) {
                    public Object a(Object obj) {
                        if (obj == null) {
                            return obj;
                        }
                        if (!(obj instanceof String) || !SharePrefrenceHelper.this.b((String) obj)) {
                            return obj;
                        }
                        try {
                            return SharePrefrenceHelper.this.a(Base64.decode((String) obj, 2));
                        } catch (Throwable th2) {
                            NLog instance = MobLog.getInstance();
                            instance.d("Expected exc: " + th2.getMessage(), new Object[0]);
                            return obj;
                        }
                    }
                });
                if (a11 == null) {
                    return obj;
                }
                if (!(a11 instanceof String) || !b((String) a11)) {
                    return a11;
                }
                try {
                    return a(Base64.decode((String) a11, 2));
                } catch (Throwable th2) {
                    NLog instance = MobLog.getInstance();
                    instance.d("Expected exc: " + th2.getMessage(), new Object[0]);
                    return a11;
                }
            } catch (MobPersistence.NoValidDataException e11) {
                throw e11;
            } catch (Throwable th3) {
                MobLog.getInstance().d(th3);
            }
        }
        return obj;
    }

    public void open(String str, int i11) {
        open(str, i11, (String) null);
    }

    public void put(String str, Object obj, long j11) {
        if (this.f28150b != null) {
            try {
                this.f28150b.a(new MobPersistence.j(str, obj, j11));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public void putBoolean(String str, Boolean bool, long j11) {
        if (this.f28150b != null && bool != null) {
            try {
                this.f28150b.a(new MobPersistence.j(str, Byte.valueOf((byte) (bool.booleanValue() ? 1 : 0)), j11));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public void putDouble(String str, Double d11, long j11) {
        if (this.f28150b != null && d11 != null) {
            try {
                this.f28150b.a(new MobPersistence.j(str, d11, j11));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public void putInt(String str, Integer num, long j11) {
        if (this.f28150b != null && num != null) {
            try {
                this.f28150b.a(new MobPersistence.j(str, num, j11));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public void putLong(String str, Long l11, long j11) {
        if (this.f28150b != null && l11 != null) {
            try {
                this.f28150b.a(new MobPersistence.j(str, l11, j11));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public void putParcel(String str, Parcelable parcelable, long j11) {
        if (this.f28150b != null) {
            try {
                this.f28150b.a((MobPersistence.j) new MobPersistence.j(str, parcelable, j11) {
                    public Object c() {
                        Object b11 = b();
                        if (b11 != null) {
                            return new MobPersistence.b((Parcelable) b11).b();
                        }
                        return null;
                    }
                });
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public <T extends Parcelable> void putParcelArray(String str, T[] tArr, long j11) {
        if (this.f28150b != null && tArr != null && tArr.length > 0) {
            try {
                this.f28150b.a((MobPersistence.j) new MobPersistence.j(str, tArr, j11) {
                    public Object c() {
                        Object b11 = b();
                        if (b11 == null) {
                            return null;
                        }
                        Parcelable[] parcelableArr = (Parcelable[]) b11;
                        int length = parcelableArr.length;
                        HashMap[] hashMapArr = new HashMap[length];
                        for (int i11 = 0; i11 < length; i11++) {
                            hashMapArr[i11] = new MobPersistence.b(parcelableArr[i11]).b();
                        }
                        return hashMapArr;
                    }
                });
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public <T extends Parcelable> void putParcelList(String str, List<T> list, long j11) {
        if (this.f28150b != null && list != null && !list.isEmpty()) {
            this.f28150b.a((MobPersistence.j) new MobPersistence.j(str, list, j11) {
                public Object c() {
                    List list;
                    Object b11 = b();
                    if (b11 == null) {
                        return null;
                    }
                    if (b11 instanceof ArrayList) {
                        list = new ArrayList();
                    } else if (b11 instanceof LinkedList) {
                        list = new LinkedList();
                    } else {
                        list = new ArrayList();
                    }
                    for (Parcelable bVar : (List) b11) {
                        list.add(new MobPersistence.b(bVar).b());
                    }
                    return list;
                }
            });
        }
    }

    public <T extends Parcelable> void putParcelMap(String str, Map<String, T> map, long j11) {
        if (this.f28150b != null && map != null && !map.isEmpty()) {
            try {
                this.f28150b.a((MobPersistence.j) new MobPersistence.j(str, map, j11) {
                    public Object c() {
                        Map map;
                        Object b11 = b();
                        if (b11 == null) {
                            return null;
                        }
                        if (b11 instanceof HashMap) {
                            map = new HashMap();
                        } else if (b11 instanceof Hashtable) {
                            map = new Hashtable();
                        } else if (b11 instanceof TreeMap) {
                            map = new TreeMap();
                        } else {
                            map = new HashMap();
                        }
                        for (Map.Entry entry : ((Map) b11).entrySet()) {
                            map.put(entry.getKey(), new MobPersistence.b((Parcelable) entry.getValue()).b());
                        }
                        return map;
                    }
                });
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public void putString(String str, String str2, long j11) {
        if (this.f28150b != null) {
            try {
                this.f28150b.a(new MobPersistence.j(str, str2, j11));
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
    }

    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        private static File f28166c;

        /* renamed from: a  reason: collision with root package name */
        private File f28167a;

        /* renamed from: b  reason: collision with root package name */
        private HashMap<String, Object> f28168b = new HashMap<>();

        public a(Context context, String str) {
            if (context != null) {
                try {
                    File file = new File(a(context), str);
                    this.f28167a = file;
                    if (!file.getParentFile().exists()) {
                        this.f28167a.getParentFile().mkdirs();
                    }
                    if (!this.f28167a.exists()) {
                        this.f28167a.createNewFile();
                    }
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    return;
                }
            }
            b();
        }

        private static synchronized File a(Context context) {
            File file;
            synchronized (a.class) {
                if (f28166c == null) {
                    f28166c = new File(context.getFilesDir(), SharePrefrenceHelper.SP_CACHE_FOLDER);
                }
                file = f28166c;
            }
            return file;
        }

        /* JADX INFO: finally extract failed */
        private void b() {
            BufferedReader bufferedReader;
            InputStreamReader inputStreamReader;
            FileInputStream fileInputStream;
            Throwable th2;
            synchronized (this.f28168b) {
                File file = this.f28167a;
                if (file != null && file.exists()) {
                    try {
                        fileInputStream = new FileInputStream(this.f28167a);
                        try {
                            inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                        } catch (Throwable th3) {
                            bufferedReader = null;
                            th2 = th3;
                            inputStreamReader = null;
                            try {
                                MobLog.getInstance().w(th2);
                                v.a(bufferedReader, inputStreamReader, fileInputStream);
                            } catch (Throwable th4) {
                                v.a(bufferedReader, inputStreamReader, fileInputStream);
                                throw th4;
                            }
                        }
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                StringBuilder sb2 = new StringBuilder();
                                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                                    if (sb2.length() > 0) {
                                        sb2.append("\n");
                                    }
                                    sb2.append(readLine);
                                }
                                this.f28168b = HashonHelper.fromJson(sb2.toString());
                                v.a(bufferedReader, inputStreamReader, fileInputStream);
                            } catch (Throwable th5) {
                                th2 = th5;
                                MobLog.getInstance().w(th2);
                                v.a(bufferedReader, inputStreamReader, fileInputStream);
                            }
                        } catch (Throwable th6) {
                            Throwable th7 = th6;
                            bufferedReader = null;
                            th2 = th7;
                            MobLog.getInstance().w(th2);
                            v.a(bufferedReader, inputStreamReader, fileInputStream);
                        }
                    } catch (Throwable th8) {
                        inputStreamReader = null;
                        bufferedReader = null;
                        th2 = th8;
                        fileInputStream = null;
                        MobLog.getInstance().w(th2);
                        v.a(bufferedReader, inputStreamReader, fileInputStream);
                    }
                }
            }
        }

        public static synchronized boolean a(Context context, String str) {
            synchronized (a.class) {
                if (new File(a(context), str).exists()) {
                    return true;
                }
                return false;
            }
        }

        public HashMap<String, Object> a() {
            HashMap<String, Object> hashMap;
            synchronized (this.f28168b) {
                hashMap = new HashMap<>();
                hashMap.putAll(this.f28168b);
            }
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    public Object a(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th2;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    Object readObject = objectInputStream.readObject();
                    v.a(objectInputStream, byteArrayInputStream);
                    return readObject;
                } catch (Throwable th3) {
                    th2 = th3;
                    v.a(objectInputStream, byteArrayInputStream);
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                objectInputStream = null;
                v.a(objectInputStream, byteArrayInputStream);
                throw th2;
            }
        } catch (Throwable th5) {
            byteArrayInputStream = null;
            th2 = th5;
            objectInputStream = null;
            v.a(objectInputStream, byteArrayInputStream);
            throw th2;
        }
    }

    public void open(String str, int i11, String str2) {
        String str3 = str + "_" + i11;
        this.f28150b = new MobPersistence(this.f28149a, str3, str2);
        a(str3);
    }

    private void a(String str) {
        HashMap<String, Object> hashMap;
        if (!getBoolean("k_m_sp_cpt_dn") && a.a(this.f28149a, str)) {
            MobLog.getInstance().d("[MPF][" + str + "]Compat acquire", new Object[0]);
            a aVar = new a(this.f28149a, str);
            Integer num = null;
            if (this.f28150b != null) {
                hashMap = aVar.a();
                if (hashMap != null && !hashMap.isEmpty()) {
                    putAll(hashMap);
                }
                putBoolean("k_m_sp_cpt_dn", Boolean.TRUE);
            } else {
                hashMap = null;
            }
            NLog instance = MobLog.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[MPF][");
            sb2.append(str);
            sb2.append("]Compat done, mv: ");
            if (hashMap != null) {
                num = Integer.valueOf(hashMap.size());
            }
            sb2.append(num);
            instance.d(sb2.toString(), new Object[0]);
        }
    }
}
