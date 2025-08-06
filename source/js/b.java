package js;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class b implements SharedPreferences, SharedPreferences.Editor {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f84410g = false;

    /* renamed from: h  reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f84411h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public static MMKV f84412i = null;

    /* renamed from: j  reason: collision with root package name */
    public static volatile boolean f84413j = true;

    /* renamed from: k  reason: collision with root package name */
    public static Application f84414k;

    /* renamed from: a  reason: collision with root package name */
    public final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> f84415a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final MMKV f84416b;

    /* renamed from: c  reason: collision with root package name */
    public final String f84417c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f84418d = new HashSet();

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, Object> f84419e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f84420f;

    public static class a implements MMKVHandler {
        public void mmkvLog(MMKVLogLevel mMKVLogLevel, String str, int i11, String str2, String str3) {
            int i12 = C0873b.f84421a[mMKVLogLevel.ordinal()];
            if (i12 == 1) {
                PrintStream printStream = System.out;
                printStream.println("MmkvSharedPrefs.d: " + str2 + " " + str3);
            } else if (i12 == 2) {
                PrintStream printStream2 = System.out;
                printStream2.println("MmkvSharedPrefs.i: " + str2 + " " + str3);
            } else if (i12 == 3) {
                PrintStream printStream3 = System.out;
                printStream3.println("MmkvSharedPrefs.w: " + str2 + " " + str3);
            } else if (i12 == 4) {
                PrintStream printStream4 = System.err;
                printStream4.println("MmkvSharedPrefs.e: " + str2 + " " + str3);
            }
        }

        public MMKVRecoverStrategic onMMKVCRCCheckFail(String str) {
            Log.d("MmkvSharedPrefs", "onMMKVCRCCheckFail() called with: mmapID = [" + str + "]");
            return MMKVRecoverStrategic.OnErrorDiscard;
        }

        public MMKVRecoverStrategic onMMKVFileLengthError(String str) {
            Log.d("MmkvSharedPrefs", "onMMKVFileLengthError() called with: mmapID = [" + str + "]");
            return MMKVRecoverStrategic.OnErrorDiscard;
        }

        public boolean wantLogRedirecting() {
            return b.f84410g;
        }
    }

    /* renamed from: js.b$b  reason: collision with other inner class name */
    public static /* synthetic */ class C0873b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f84421a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.tencent.mmkv.MMKVLogLevel[] r0 = com.tencent.mmkv.MMKVLogLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f84421a = r0
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelDebug     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f84421a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelInfo     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f84421a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelWarning     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f84421a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelError     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f84421a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.tencent.mmkv.MMKVLogLevel r1 = com.tencent.mmkv.MMKVLogLevel.LevelNone     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: js.b.C0873b.<clinit>():void");
        }
    }

    public b(String str) {
        HashMap hashMap = new HashMap();
        this.f84419e = hashMap;
        this.f84420f = false;
        synchronized (str.intern()) {
            this.f84417c = str;
            if (f84412i == null) {
                f84412i = MMKV.mmkvWithID("huobi_all_keys", 2, a("5Sl#^JVKLzvbiJgt"));
                if (f84410g) {
                    Log.d("MmkvSharedPrefs", "KwaiSharedPrefs() called with: name = [" + Arrays.toString(f84412i.allKeys()) + "]");
                }
            }
            File file = new File(MMKV.getRootDir(), str);
            boolean z11 = true;
            if (file.exists()) {
                File file2 = new File(f84414k.getFilesDir().getPath() + "/mmkv", str + ".xml");
                if (!file2.exists() || file2.lastModified() <= file.lastModified()) {
                    z11 = false;
                } else {
                    this.f84418d.clear();
                    hashMap.clear();
                    f84412i.edit().putBoolean(str + "_exists", false).putStringSet(str, this.f84418d).apply();
                }
            }
            this.f84416b = MMKV.mmkvWithID(str, 2, a("5Sl#^JVKLzvbiJgt"));
            if (z11) {
                if (f84410g) {
                    Log.d("MmkvSharedPrefs", "import data from " + str + ".xml");
                }
                j(str);
            } else {
                g(str, false);
            }
            f84411h.put(str, this);
        }
    }

    public static b b(String str) {
        return f84411h.get(str);
    }

    public static SharedPreferences c(Application application, String str) {
        if (!i() && application != null) {
            e(application);
        }
        if (!f84413j || !i()) {
            return null;
        }
        if (d(str)) {
            if (f84410g) {
                Log.d("MmkvSharedPrefs", str + ".getSharedPreferences() called Form cache with: name = [" + str + "]\n");
            }
            return b(str);
        }
        if (f84410g) {
            Log.d("MmkvSharedPrefs", str + ".getSharedPreferences() called Form create with: name = [" + str + "]\n");
        }
        if (!TextUtils.isEmpty(MMKV.getRootDir())) {
            return new b(str);
        }
        return null;
    }

    public static boolean d(String str) {
        return f84411h.containsKey(str);
    }

    public static void e(Application application) {
        f(application, false);
    }

    public static void f(Application application, boolean z11) {
        f84414k = application;
        f84410g = z11;
        try {
            h(application);
        } catch (UnsatisfiedLinkError e11) {
            boolean z12 = f84410g;
            if (!z12) {
                if (z12) {
                    Log.e("MmkvSharedPrefs", "static initializer() called fail", e11);
                }
                f84413j = false;
                return;
            }
            throw new RuntimeException(e11);
        }
    }

    public static void h(Application application) {
        if (MMKV.getRootDir() == null) {
            if (f84410g) {
                Log.d("MmkvSharedPrefs", "initMMKV() called");
            }
            MMKV.initialize((Context) application);
            MMKV.registerHandler(new a());
            MMKV.disableProcessModeChecker();
        } else if (f84410g) {
            Log.d("MmkvSharedPrefs", "initMMKV() Already initialized");
        }
    }

    public static boolean i() {
        return f84414k != null;
    }

    public String a(String str) {
        return "";
    }

    @Deprecated
    public void apply() {
    }

    public SharedPreferences.Editor clear() {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".clear() called");
        }
        synchronized (this.f84417c.intern()) {
            this.f84420f = false;
            this.f84419e.clear();
            for (String remove : this.f84418d) {
                this.f84416b.edit().remove(remove);
            }
            this.f84418d.clear();
        }
        return this;
    }

    @Deprecated
    public boolean commit() {
        return true;
    }

    public boolean contains(String str) {
        return this.f84416b.contains(str);
    }

    public SharedPreferences.Editor edit() {
        return this;
    }

    public final void g(String str, boolean z11) {
        synchronized (str.intern()) {
            long currentTimeMillis = System.currentTimeMillis();
            Set<String> stringSet = f84412i.getStringSet(str, new HashSet());
            this.f84418d = stringSet;
            if (z11) {
                for (String next : stringSet) {
                    char charAt = next.charAt(0);
                    if (charAt == 'b') {
                        this.f84419e.put(next.substring(1), Boolean.valueOf(this.f84416b.getBoolean(next.substring(1), false)));
                    } else if (charAt == 'f') {
                        this.f84419e.put(next.substring(1), Float.valueOf(this.f84416b.getFloat(next.substring(1), 0.0f)));
                    } else if (charAt == 'l') {
                        this.f84419e.put(next.substring(1), Long.valueOf(this.f84416b.getLong(next.substring(1), 0)));
                    } else if (charAt == 's') {
                        this.f84419e.put(next.substring(1), this.f84416b.getString(next.substring(1), (String) null));
                    } else if (charAt == 'h') {
                        this.f84419e.put(next.substring(1), this.f84416b.getStringSet(next.substring(1), new HashSet()));
                    } else if (charAt == 'i') {
                        this.f84419e.put(next.substring(1), Integer.valueOf(this.f84416b.getInt(next.substring(1), 0)));
                    }
                }
            }
            if (f84410g) {
                Log.d("MmkvSharedPrefs", str + ".initKeysAndMap() called with: keys = [" + this.f84418d + "] loadMap:[" + z11 + "] cost:[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
            }
        }
    }

    public Map<String, ?> getAll() {
        synchronized (this.f84417c.intern()) {
            if (this.f84419e.isEmpty() && !this.f84418d.isEmpty()) {
                g(this.f84417c, true);
                this.f84420f = true;
            }
            if (f84410g) {
                Log.d("MmkvSharedPrefs", this.f84417c + ".getAll() called, map=" + this.f84419e);
            }
        }
        return this.f84419e;
    }

    public boolean getBoolean(String str, boolean z11) {
        return this.f84416b.getBoolean(str, z11);
    }

    public float getFloat(String str, float f11) {
        return this.f84416b.getFloat(str, f11);
    }

    public int getInt(String str, int i11) {
        return this.f84416b.getInt(str, i11);
    }

    public long getLong(String str, long j11) {
        return this.f84416b.getLong(str, j11);
    }

    public String getString(String str, String str2) {
        return this.f84416b.getString(str, str2);
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return this.f84416b.getStringSet(str, set);
    }

    public final void j(String str) {
        synchronized (str.intern()) {
            long currentTimeMillis = System.currentTimeMillis();
            Map<String, ?> all = f84414k.getBaseContext().getSharedPreferences(str, 0).getAll();
            for (String next : all.keySet()) {
                Object obj = all.get(next);
                if (obj instanceof String) {
                    putString(next, (String) obj);
                } else if (obj instanceof Integer) {
                    putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    putLong(next, ((Long) obj).longValue());
                } else if (obj instanceof Boolean) {
                    putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    putFloat(next, ((Float) obj).floatValue());
                } else if (obj instanceof Set) {
                    putStringSet(next, (Set) obj);
                }
            }
            apply();
            SharedPreferences.Editor putStringSet = f84412i.edit().putStringSet(str, this.f84418d);
            putStringSet.putBoolean(str + "_exists", true).apply();
            if (f84410g) {
                Log.d("MmkvSharedPrefs", str + ".migrateSharedPrefs() called with: keys = [" + this.f84418d + "] , cost:[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
            }
        }
    }

    public SharedPreferences.Editor putBoolean(String str, boolean z11) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".putBoolean() called with: key = [" + str + "], value = [" + z11 + "]");
        }
        synchronized (this.f84417c.intern()) {
            Set<String> set = this.f84418d;
            set.add('b' + str);
            if (this.f84420f) {
                this.f84419e.put(str, Boolean.valueOf(z11));
            }
            this.f84416b.edit().putBoolean(str, z11);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public SharedPreferences.Editor putFloat(String str, float f11) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".putFloat() called with: key = [" + str + "], value = [" + f11 + "]");
        }
        synchronized (this.f84417c.intern()) {
            Set<String> set = this.f84418d;
            set.add('f' + str);
            if (this.f84420f) {
                this.f84419e.put(str, Float.valueOf(f11));
            }
            this.f84416b.edit().putFloat(str, f11);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public SharedPreferences.Editor putInt(String str, int i11) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".putInt() called with: key = [" + str + "], value = [" + i11 + "]");
        }
        synchronized (this.f84417c.intern()) {
            Set<String> set = this.f84418d;
            set.add('i' + str);
            if (this.f84420f) {
                this.f84419e.put(str, Integer.valueOf(i11));
            }
            this.f84416b.edit().putInt(str, i11);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public SharedPreferences.Editor putLong(String str, long j11) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".putLong() called with: key = [" + str + "], value = [" + j11 + "]");
        }
        synchronized (this.f84417c.intern()) {
            Set<String> set = this.f84418d;
            set.add('l' + str);
            if (this.f84420f) {
                this.f84419e.put(str, Long.valueOf(j11));
            }
            this.f84416b.edit().putLong(str, j11);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public SharedPreferences.Editor putString(String str, String str2) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".putString() called with: key = [" + str + "], value = [" + str2 + "]");
        }
        synchronized (this.f84417c.intern()) {
            Set<String> set = this.f84418d;
            set.add('s' + str);
            if (this.f84420f) {
                this.f84419e.put(str, str2);
            }
            this.f84416b.edit().putString(str, str2);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", this.f84417c + ".putStringSet() called with: key = [" + str + "], values = [" + set + "]");
        }
        synchronized (this.f84417c.intern()) {
            Set<String> set2 = this.f84418d;
            set2.add('h' + str);
            if (this.f84420f) {
                this.f84419e.put(str, set);
            }
            this.f84416b.edit().putStringSet(str, set);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", String.format("registerOnSharedPreferenceChangeListener(%s.) called with: listener = [%s]\n%s", new Object[]{this.f84417c, onSharedPreferenceChangeListener, ""}));
        }
        this.f84415a.put(onSharedPreferenceChangeListener, this);
    }

    public SharedPreferences.Editor remove(String str) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", ".remove() called with: key = [" + str + "]");
        }
        synchronized (this.f84417c.intern()) {
            String str2 = "";
            for (String next : this.f84418d) {
                if (next.substring(1).equals(str)) {
                    str2 = next;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f84418d.remove(str2);
            }
            this.f84419e.remove(str);
            this.f84416b.edit().remove(str);
            if (!this.f84415a.isEmpty()) {
                for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChanged : this.f84415a.keySet()) {
                    onSharedPreferenceChanged.onSharedPreferenceChanged(this, str);
                }
            }
        }
        return this;
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (f84410g) {
            Log.d("MmkvSharedPrefs", String.format("unregisterOnSharedPreferenceChangeListener(%s.) called with: listener = [%s]\n%s", new Object[]{this.f84417c, onSharedPreferenceChangeListener, ""}));
        }
        this.f84415a.remove(onSharedPreferenceChangeListener);
    }
}
