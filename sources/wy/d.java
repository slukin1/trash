package wy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import wy.b;

public class d {

    /* renamed from: d  reason: collision with root package name */
    public static final Object f40641d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f40642a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public File f40643b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<File, a> f40644c = new HashMap<>();

    public static final class a implements b {

        /* renamed from: g  reason: collision with root package name */
        public static final Object f40645g = new Object();

        /* renamed from: a  reason: collision with root package name */
        public final File f40646a;

        /* renamed from: b  reason: collision with root package name */
        public final File f40647b;

        /* renamed from: c  reason: collision with root package name */
        public final int f40648c;

        /* renamed from: d  reason: collision with root package name */
        public Map f40649d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f40650e = false;

        /* renamed from: f  reason: collision with root package name */
        public WeakHashMap<b.C0550b, Object> f40651f;

        public a(File file, int i11, Map map) {
            this.f40646a = file;
            this.f40647b = d.b(file);
            this.f40648c = i11;
            this.f40649d = map == null ? new HashMap() : map;
            this.f40651f = new WeakHashMap<>();
        }

        public b.a a() {
            return new C0551a();
        }

        public void d(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.f40649d = map;
                }
            }
        }

        public void f(boolean z11) {
            synchronized (this) {
                this.f40650e = z11;
            }
        }

        public boolean g() {
            boolean z11;
            synchronized (this) {
                z11 = this.f40650e;
            }
            return z11;
        }

        public long getLong(String str, long j11) {
            synchronized (this) {
                Long l11 = (Long) this.f40649d.get(str);
                if (l11 != null) {
                    j11 = l11.longValue();
                }
            }
            return j11;
        }

        public String getString(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.f40649d.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        public final boolean h() {
            if (this.f40646a.exists()) {
                if (this.f40647b.exists()) {
                    this.f40646a.delete();
                } else if (!this.f40646a.renameTo(this.f40647b)) {
                    return false;
                }
            }
            try {
                FileOutputStream a11 = a(this.f40646a);
                if (a11 == null) {
                    return false;
                }
                e.g(this.f40649d, a11);
                a11.close();
                this.f40647b.delete();
                return true;
            } catch (Exception unused) {
                if (this.f40646a.exists()) {
                    this.f40646a.delete();
                }
                return false;
            }
        }

        public final FileOutputStream a(File file) {
            FileOutputStream fileOutputStream;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
            return fileOutputStream;
        }

        /* renamed from: wy.d$a$a  reason: collision with other inner class name */
        public final class C0551a implements b.a {

            /* renamed from: a  reason: collision with root package name */
            public final Map<String, Object> f40652a = new HashMap();

            /* renamed from: b  reason: collision with root package name */
            public boolean f40653b = false;

            public C0551a() {
            }

            public b.a a(String str, String str2) {
                synchronized (this) {
                    this.f40652a.put(str, str2);
                }
                return this;
            }

            public b.a b() {
                synchronized (this) {
                    this.f40653b = true;
                }
                return this;
            }

            public boolean commit() {
                boolean z11;
                ArrayList arrayList;
                HashSet<b.C0550b> hashSet;
                boolean e11;
                synchronized (d.f40641d) {
                    z11 = a.this.f40651f.size() > 0;
                    arrayList = null;
                    if (z11) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet<>(a.this.f40651f.keySet());
                    } else {
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.f40653b) {
                            a.this.f40649d.clear();
                            this.f40653b = false;
                        }
                        for (Map.Entry next : this.f40652a.entrySet()) {
                            String str = (String) next.getKey();
                            Object value = next.getValue();
                            if (value == this) {
                                a.this.f40649d.remove(str);
                            } else {
                                a.this.f40649d.put(str, value);
                            }
                            if (z11) {
                                arrayList.add(str);
                            }
                        }
                        this.f40652a.clear();
                    }
                    e11 = a.this.h();
                    if (e11) {
                        a.this.f(true);
                    }
                }
                if (z11) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str2 = (String) arrayList.get(size);
                        for (b.C0550b bVar : hashSet) {
                            if (bVar != null) {
                                bVar.a(a.this, str2);
                            }
                        }
                    }
                }
                return e11;
            }

            public b.a a(String str, long j11) {
                synchronized (this) {
                    this.f40652a.put(str, Long.valueOf(j11));
                }
                return this;
            }
        }
    }

    public d(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.f40643b = new File(str);
    }

    public static File b(File file) {
        return new File(file.getPath() + ".bak");
    }

    public final File a() {
        File file;
        synchronized (this.f40642a) {
            file = this.f40643b;
        }
        return file;
    }

    public final File c(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v23 */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r2v26 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public wy.b e(java.lang.String r6, int r7) {
        /*
            r5 = this;
            java.io.File r6 = r5.g(r6)
            java.lang.Object r0 = f40641d
            monitor-enter(r0)
            java.util.HashMap<java.io.File, wy.d$a> r1 = r5.f40644c     // Catch:{ all -> 0x00b0 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x00b0 }
            wy.d$a r1 = (wy.d.a) r1     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x0019
            boolean r2 = r1.g()     // Catch:{ all -> 0x00b0 }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0019:
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            java.io.File r0 = b(r6)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x002a
            r6.delete()
            r0.renameTo(r6)
        L_0x002a:
            boolean r0 = r6.exists()
            r2 = 0
            if (r0 == 0) goto L_0x008d
            boolean r0 = r6.canRead()
            if (r0 == 0) goto L_0x008d
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ XmlPullParserException -> 0x005c, Exception -> 0x0054 }
            r0.<init>(r6)     // Catch:{ XmlPullParserException -> 0x005c, Exception -> 0x0054 }
            java.util.HashMap r2 = wy.e.c(r0)     // Catch:{ XmlPullParserException -> 0x004e, Exception -> 0x004a, all -> 0x0047 }
            r0.close()     // Catch:{ XmlPullParserException -> 0x004e, Exception -> 0x004a, all -> 0x0047 }
            r0.close()     // Catch:{ all -> 0x008d }
            goto L_0x008d
        L_0x0047:
            r6 = move-exception
            r2 = r0
            goto L_0x007b
        L_0x004a:
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x0055
        L_0x004e:
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x005d
        L_0x0052:
            r6 = move-exception
            goto L_0x007b
        L_0x0054:
            r0 = r2
        L_0x0055:
            if (r2 == 0) goto L_0x005a
            r2.close()     // Catch:{ all -> 0x005a }
        L_0x005a:
            r2 = r0
            goto L_0x008d
        L_0x005c:
            r0 = r2
        L_0x005d:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0081, all -> 0x0074 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x0081, all -> 0x0074 }
            int r2 = r3.available()     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r3.read(r2)     // Catch:{ Exception -> 0x0072, all -> 0x006f }
            r3.close()     // Catch:{ all -> 0x0087 }
            goto L_0x0087
        L_0x006f:
            r6 = move-exception
            r2 = r3
            goto L_0x0075
        L_0x0072:
            r2 = r3
            goto L_0x0081
        L_0x0074:
            r6 = move-exception
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.close()     // Catch:{ all -> 0x007a }
        L_0x007a:
            throw r6     // Catch:{ all -> 0x0052 }
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2.close()     // Catch:{ all -> 0x0080 }
        L_0x0080:
            throw r6
        L_0x0081:
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r3 = r2
        L_0x0087:
            if (r3 == 0) goto L_0x005a
            r3.close()     // Catch:{ all -> 0x005a }
            goto L_0x005a
        L_0x008d:
            java.lang.Object r3 = f40641d
            monitor-enter(r3)
            if (r1 == 0) goto L_0x0096
            r1.d(r2)     // Catch:{ all -> 0x00ad }
            goto L_0x00ab
        L_0x0096:
            java.util.HashMap<java.io.File, wy.d$a> r0 = r5.f40644c     // Catch:{ all -> 0x00ad }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x00ad }
            r1 = r0
            wy.d$a r1 = (wy.d.a) r1     // Catch:{ all -> 0x00ad }
            if (r1 != 0) goto L_0x00ab
            wy.d$a r1 = new wy.d$a     // Catch:{ all -> 0x00ad }
            r1.<init>(r6, r7, r2)     // Catch:{ all -> 0x00ad }
            java.util.HashMap<java.io.File, wy.d$a> r7 = r5.f40644c     // Catch:{ all -> 0x00ad }
            r7.put(r6, r1)     // Catch:{ all -> 0x00ad }
        L_0x00ab:
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            return r1
        L_0x00ad:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            throw r6
        L_0x00b0:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b0 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: wy.d.e(java.lang.String, int):wy.b");
    }

    public final File g(String str) {
        File a11 = a();
        return c(a11, str + ".xml");
    }
}
