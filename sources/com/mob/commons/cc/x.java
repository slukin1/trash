package com.mob.commons.cc;

import com.mob.commons.l;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class x {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<Object> f27156a;

        /* renamed from: b  reason: collision with root package name */
        public DataInputStream f27157b;

        /* renamed from: c  reason: collision with root package name */
        public int f27158c;

        public void a() throws Throwable {
            this.f27157b.readShort();
        }

        public <T> T b() throws Throwable {
            return this.f27156a.get(this.f27157b.readShort());
        }

        public int c() {
            return this.f27158c;
        }

        private a(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i11) {
            this.f27156a = arrayList;
            this.f27157b = dataInputStream;
            this.f27158c = i11;
        }

        public void a(y yVar) throws Throwable {
            yVar.f27167b = (String) this.f27156a.get(this.f27157b.readShort());
            yVar.f27168c = this.f27157b.readShort();
        }
    }

    public static class b extends a {
        public void a() throws Throwable {
            this.f27157b.readInt();
        }

        public <T> T b() throws Throwable {
            return this.f27156a.get(this.f27157b.readInt());
        }

        private b(ArrayList<Object> arrayList, DataInputStream dataInputStream, int i11) {
            super(arrayList, dataInputStream, i11);
        }

        public void a(y yVar) throws Throwable {
            yVar.f27167b = (String) this.f27156a.get(this.f27157b.readInt());
            yVar.f27168c = this.f27157b.readInt();
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private d f27159a;

        public c a(Object obj) {
            this.f27159a.a(obj);
            return this;
        }

        private c(Object obj) {
            this.f27159a = new d(obj);
        }

        public d a(String str, Object obj) {
            return this.f27159a.a(str, obj);
        }

        public d a(String str, Class<?> cls) {
            return this.f27159a.a(str, cls);
        }

        public void a() throws Throwable {
            this.f27159a.a();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<Object> f27160a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Object> f27161b;

        /* renamed from: c  reason: collision with root package name */
        private HashMap<String, Object> f27162c;

        /* renamed from: d  reason: collision with root package name */
        private HashMap<String, Object> f27163d;

        /* renamed from: e  reason: collision with root package name */
        private String f27164e;

        /* renamed from: f  reason: collision with root package name */
        private HashMap<Class<?>, Class<? extends t<?>>> f27165f;

        private d(Object obj) {
            ArrayList<Object> arrayList = new ArrayList<>();
            this.f27160a = arrayList;
            arrayList.add(obj);
            this.f27161b = new ArrayList<>();
            this.f27162c = new HashMap<>();
            this.f27163d = new HashMap<>();
            this.f27165f = new HashMap<>();
            this.f27162c.put("t_map", this.f27163d);
        }

        /* access modifiers changed from: private */
        public void a(Object obj) {
            this.f27160a.add(obj);
        }

        public d a(String str, Object obj) {
            this.f27162c.put(str, obj);
            return this;
        }

        public d a(String str, Class<?> cls) {
            w.f27153a.put(str, cls);
            return this;
        }

        public d a(String str) {
            this.f27164e = str;
            return this;
        }

        public <T> d a(Class<T> cls, Class<? extends t<T>> cls2) {
            this.f27165f.put(cls, cls2);
            return this;
        }

        public void a() throws Throwable {
            byte[] bArr;
            InputStream inputStream;
            ArrayList arrayList = new ArrayList();
            String str = this.f27164e;
            if (str != null) {
                bArr = str.getBytes("UTF-8");
                System.arraycopy(bArr, 0, new byte[16], 0, Math.min(bArr.length, 16));
            } else {
                bArr = null;
            }
            try {
                u uVar = new u();
                Iterator<Object> it2 = this.f27160a.iterator();
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof String) {
                        inputStream = new FileInputStream((String) next);
                    } else if (next instanceof byte[]) {
                        inputStream = new ByteArrayInputStream((byte[]) next);
                    } else {
                        throw new ClassCastException("program is not string or byte array");
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    a(inputStream, arrayList, uVar);
                    this.f27163d.put("l_t", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
                for (Map.Entry next2 : this.f27165f.entrySet()) {
                    uVar.a((Class) next2.getKey(), (Class) next2.getValue());
                }
                new w(arrayList, this.f27161b).a(this.f27162c, uVar);
            } catch (Throwable th2) {
                th = th2;
                if (bArr != null) {
                    String cls = th.getMessage() == null ? th.getClass().toString() : th.getMessage();
                    if (th instanceof v) {
                        th = th.getCause();
                    }
                    throw new v(a(bArr, cls + " " + a(th)), th);
                }
                throw th;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[Catch:{ all -> 0x004c, all -> 0x0052 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0042 A[SYNTHETIC, Splitter:B:29:0x0042] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String a(java.lang.Throwable r5) {
            /*
                r4 = this;
                java.lang.String r0 = ""
                if (r5 != 0) goto L_0x0005
                return r0
            L_0x0005:
                r1 = 0
                r2 = r5
            L_0x0007:
                if (r2 == 0) goto L_0x0013
                boolean r3 = r2 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x0031 }
                if (r3 == 0) goto L_0x000e
                return r0
            L_0x000e:
                java.lang.Throwable r2 = r2.getCause()     // Catch:{ all -> 0x0031 }
                goto L_0x0007
            L_0x0013:
                java.io.StringWriter r0 = new java.io.StringWriter     // Catch:{ all -> 0x0031 }
                r0.<init>()     // Catch:{ all -> 0x0031 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x002e }
                r1.<init>(r0)     // Catch:{ all -> 0x002e }
                r5.printStackTrace(r1)     // Catch:{ all -> 0x002e }
                r1.flush()     // Catch:{ all -> 0x002e }
                r1.close()     // Catch:{ all -> 0x002e }
                java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x002e }
                r0.close()     // Catch:{ all -> 0x002d }
            L_0x002d:
                return r5
            L_0x002e:
                r5 = move-exception
                r1 = r0
                goto L_0x0032
            L_0x0031:
                r5 = move-exception
            L_0x0032:
                boolean r0 = r5 instanceof java.lang.OutOfMemoryError     // Catch:{ all -> 0x004c }
                if (r0 == 0) goto L_0x0042
                java.lang.String r5 = "023(glMhk'gn<kfe2gjhefl^fehWgn7k+flfk_gTglkhfmfmfh"
                java.lang.String r5 = com.mob.commons.l.a((java.lang.String) r5)     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x0041
                r1.close()     // Catch:{ all -> 0x0041 }
            L_0x0041:
                return r5
            L_0x0042:
                java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x004b
                r1.close()     // Catch:{ all -> 0x004b }
            L_0x004b:
                return r5
            L_0x004c:
                r5 = move-exception
                if (r1 == 0) goto L_0x0052
                r1.close()     // Catch:{ all -> 0x0052 }
            L_0x0052:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.x.d.a(java.lang.Throwable):java.lang.String");
        }

        private String a(byte[] bArr, String str) {
            Cipher cipher;
            if (bArr == null) {
                return str;
            }
            try {
                byte[] bytes = str.getBytes("UTF-8");
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003+hfikgn"));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(l.a("003Uhfikgn"));
                sb2.append(l.a("003n@ikgf"));
                sb2.append(l.a("008EhlVnHinkegfgnkmin"));
                sb2.append(l.a("006f)fefefk0g6gl"));
                Provider provider = Security.getProvider(l.a("002+hlgf"));
                if (provider != null) {
                    cipher = Cipher.getInstance(sb2.toString(), provider);
                } else {
                    cipher = Cipher.getInstance(sb2.toString(), l.a("002Qhlgf"));
                }
                cipher.init(1, secretKeySpec);
                byte[] bArr2 = new byte[cipher.getOutputSize(bytes.length)];
                cipher.doFinal(bArr2, cipher.update(bytes, 0, bytes.length, bArr2, 0));
                return new BigInteger(1, bArr2).toString(16);
            } catch (Throwable unused) {
                return "";
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:102:0x01c3 */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x01d7 A[Catch:{ all -> 0x00de, all -> 0x01df }] */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x01ec A[SYNTHETIC, Splitter:B:120:0x01ec] */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x01f0 A[Catch:{ all -> 0x01f3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[Catch:{ all -> 0x00de, all -> 0x01df }, LOOP:0: B:21:0x0041->B:22:0x0043, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0058 A[Catch:{ all -> 0x00de, all -> 0x01df }, LOOP:1: B:24:0x0056->B:25:0x0058, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x006d A[Catch:{ all -> 0x00de, all -> 0x01df }, LOOP:2: B:27:0x006b->B:28:0x006d, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[Catch:{ all -> 0x00de, all -> 0x01df }, LOOP:3: B:30:0x0080->B:31:0x0082, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0097 A[Catch:{ all -> 0x00de, all -> 0x01df }, LOOP:4: B:33:0x0095->B:34:0x0097, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab A[Catch:{ all -> 0x00de, all -> 0x01df }] */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x00e4 A[Catch:{ all -> 0x00de, all -> 0x01df }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00ea A[Catch:{ all -> 0x00de, all -> 0x01df }] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x00ee A[Catch:{ all -> 0x00de, all -> 0x01df }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0103 A[Catch:{ all -> 0x00de, all -> 0x01df }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x01a4 A[Catch:{ all -> 0x019b, all -> 0x01c3 }] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01aa A[Catch:{ all -> 0x019b, all -> 0x01c3 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(java.io.InputStream r16, java.util.ArrayList<com.mob.commons.cc.y> r17, com.mob.commons.cc.u r18) throws java.lang.Throwable {
            /*
                r15 = this;
                r1 = r15
                int r0 = r16.read()
                r2 = 70
                if (r0 == r2) goto L_0x000d
                r16.close()
                return
            L_0x000d:
                r2 = 0
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01e7 }
                int r0 = r16.read()     // Catch:{ all -> 0x01e7 }
                r5 = 2
                r6 = 1
                if (r0 == r6) goto L_0x0020
                if (r0 != r5) goto L_0x001d
                goto L_0x0020
            L_0x001d:
                r6 = r16
                goto L_0x0027
            L_0x0020:
                java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x01e7 }
                r7 = r16
                r6.<init>(r7)     // Catch:{ all -> 0x01e5 }
            L_0x0027:
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ all -> 0x01e2 }
                r8 = 4096(0x1000, float:5.74E-42)
                r7.<init>(r6, r8)     // Catch:{ all -> 0x01e2 }
                java.io.DataInputStream r6 = new java.io.DataInputStream     // Catch:{ all -> 0x01e5 }
                r6.<init>(r7)     // Catch:{ all -> 0x01e5 }
                java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x01df }
                r8.<init>()     // Catch:{ all -> 0x01df }
                r8.add(r2)     // Catch:{ all -> 0x01df }
                int r9 = r6.readInt()     // Catch:{ all -> 0x01df }
                r10 = 0
                r11 = r10
            L_0x0041:
                if (r11 >= r9) goto L_0x0051
                int r12 = r6.readInt()     // Catch:{ all -> 0x01df }
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x01df }
                r8.add(r12)     // Catch:{ all -> 0x01df }
                int r11 = r11 + 1
                goto L_0x0041
            L_0x0051:
                int r9 = r6.readInt()     // Catch:{ all -> 0x01df }
                r11 = r10
            L_0x0056:
                if (r11 >= r9) goto L_0x0066
                long r12 = r6.readLong()     // Catch:{ all -> 0x01df }
                java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x01df }
                r8.add(r12)     // Catch:{ all -> 0x01df }
                int r11 = r11 + 1
                goto L_0x0056
            L_0x0066:
                int r9 = r6.readInt()     // Catch:{ all -> 0x01df }
                r11 = r10
            L_0x006b:
                if (r11 >= r9) goto L_0x007b
                float r12 = r6.readFloat()     // Catch:{ all -> 0x01df }
                java.lang.Float r12 = java.lang.Float.valueOf(r12)     // Catch:{ all -> 0x01df }
                r8.add(r12)     // Catch:{ all -> 0x01df }
                int r11 = r11 + 1
                goto L_0x006b
            L_0x007b:
                int r9 = r6.readInt()     // Catch:{ all -> 0x01df }
                r11 = r10
            L_0x0080:
                if (r11 >= r9) goto L_0x0090
                double r12 = r6.readDouble()     // Catch:{ all -> 0x01df }
                java.lang.Double r12 = java.lang.Double.valueOf(r12)     // Catch:{ all -> 0x01df }
                r8.add(r12)     // Catch:{ all -> 0x01df }
                int r11 = r11 + 1
                goto L_0x0080
            L_0x0090:
                int r9 = r6.readInt()     // Catch:{ all -> 0x01df }
                r11 = r10
            L_0x0095:
                if (r11 >= r9) goto L_0x00a5
                boolean r12 = r6.readBoolean()     // Catch:{ all -> 0x01df }
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x01df }
                r8.add(r12)     // Catch:{ all -> 0x01df }
                int r11 = r11 + 1
                goto L_0x0095
            L_0x00a5:
                int r9 = r6.readInt()     // Catch:{ all -> 0x01df }
                if (r0 != r5) goto L_0x00ee
                int r11 = r6.readInt()     // Catch:{ all -> 0x01df }
                byte[] r11 = new byte[r11]     // Catch:{ all -> 0x01df }
                r6.readFully(r11)     // Catch:{ all -> 0x01df }
                java.io.ByteArrayInputStream r12 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x00e0 }
                r12.<init>(r11)     // Catch:{ all -> 0x00e0 }
                java.util.zip.GZIPInputStream r11 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x00de }
                r11.<init>(r12)     // Catch:{ all -> 0x00de }
                java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00de }
                r14 = 2048(0x800, float:2.87E-42)
                r13.<init>(r11, r14)     // Catch:{ all -> 0x00de }
                java.io.DataInputStream r11 = new java.io.DataInputStream     // Catch:{ all -> 0x00de }
                r11.<init>(r13)     // Catch:{ all -> 0x00de }
                r13 = r10
            L_0x00cb:
                if (r13 >= r9) goto L_0x00da
                java.lang.String r14 = r11.readUTF()     // Catch:{ all -> 0x00d7 }
                r8.add(r14)     // Catch:{ all -> 0x00d7 }
                int r13 = r13 + 1
                goto L_0x00cb
            L_0x00d7:
                r0 = move-exception
                r2 = r11
                goto L_0x00e2
            L_0x00da:
                r11.close()     // Catch:{ all -> 0x01df }
                goto L_0x00fb
            L_0x00de:
                r0 = move-exception
                goto L_0x00e2
            L_0x00e0:
                r0 = move-exception
                r12 = r2
            L_0x00e2:
                if (r2 != 0) goto L_0x00ea
                if (r12 == 0) goto L_0x00ed
                r12.close()     // Catch:{ all -> 0x01df }
                goto L_0x00ed
            L_0x00ea:
                r2.close()     // Catch:{ all -> 0x01df }
            L_0x00ed:
                throw r0     // Catch:{ all -> 0x01df }
            L_0x00ee:
                r11 = r10
            L_0x00ef:
                if (r11 >= r9) goto L_0x00fb
                java.lang.String r12 = r6.readUTF()     // Catch:{ all -> 0x01df }
                r8.add(r12)     // Catch:{ all -> 0x01df }
                int r11 = r11 + 1
                goto L_0x00ef
            L_0x00fb:
                byte r9 = r6.readByte()     // Catch:{ all -> 0x01df }
                r11 = 15
                if (r9 != r11) goto L_0x01d7
                long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01df }
                java.util.HashMap<java.lang.String, java.lang.Object> r9 = r1.f27163d     // Catch:{ all -> 0x01df }
                java.lang.String r13 = "lc_t"
                long r3 = r11 - r3
                java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x01df }
                r9.put(r13, r3)     // Catch:{ all -> 0x01df }
                boolean r3 = r6.readBoolean()     // Catch:{ all -> 0x01df }
                if (r3 == 0) goto L_0x0124
                com.mob.commons.cc.x$b r3 = new com.mob.commons.cc.x$b     // Catch:{ all -> 0x01df }
                int r4 = r17.size()     // Catch:{ all -> 0x01df }
                r3.<init>(r8, r6, r4)     // Catch:{ all -> 0x01df }
                goto L_0x012d
            L_0x0124:
                com.mob.commons.cc.x$a r3 = new com.mob.commons.cc.x$a     // Catch:{ all -> 0x01df }
                int r4 = r17.size()     // Catch:{ all -> 0x01df }
                r3.<init>(r8, r6, r4)     // Catch:{ all -> 0x01df }
            L_0x012d:
                int r4 = r6.readInt()     // Catch:{ all -> 0x01df }
                boolean r8 = r6.readBoolean()     // Catch:{ all -> 0x01df }
                byte r9 = r6.readByte()     // Catch:{ all -> 0x01df }
                r13 = 25
                if (r9 != r13) goto L_0x01cf
            L_0x013d:
                if (r10 >= r4) goto L_0x015a
                com.mob.commons.cc.y r9 = new com.mob.commons.cc.y     // Catch:{ all -> 0x01df }
                r9.<init>()     // Catch:{ all -> 0x01df }
                byte r13 = r6.readByte()     // Catch:{ all -> 0x01df }
                r9.f27166a = r13     // Catch:{ all -> 0x01df }
                if (r8 == 0) goto L_0x014f
                r3.a(r9)     // Catch:{ all -> 0x01df }
            L_0x014f:
                r9.a((com.mob.commons.cc.x.a) r3)     // Catch:{ all -> 0x01df }
                r13 = r17
                r13.add(r9)     // Catch:{ all -> 0x01df }
                int r10 = r10 + 1
                goto L_0x013d
            L_0x015a:
                byte r3 = r6.readByte()     // Catch:{ all -> 0x01df }
                r4 = 39
                if (r3 != r4) goto L_0x01c7
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01df }
                java.util.HashMap<java.lang.String, java.lang.Object> r8 = r1.f27163d     // Catch:{ all -> 0x01df }
                java.lang.String r9 = "lcmd_t"
                long r10 = r3 - r11
                java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x01df }
                r8.put(r9, r10)     // Catch:{ all -> 0x01df }
                int r7 = r6.readInt()     // Catch:{ all -> 0x01c3 }
                byte[] r7 = new byte[r7]     // Catch:{ all -> 0x01c3 }
                r6.readFully(r7)     // Catch:{ all -> 0x01c3 }
                if (r0 != r5) goto L_0x01ae
                java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x01a0 }
                r5.<init>(r7)     // Catch:{ all -> 0x01a0 }
                java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x019e }
                r0.<init>(r5)     // Catch:{ all -> 0x019e }
                java.io.DataInputStream r7 = new java.io.DataInputStream     // Catch:{ all -> 0x019e }
                r7.<init>(r0)     // Catch:{ all -> 0x019e }
                int r0 = r7.readInt()     // Catch:{ all -> 0x019b }
                byte[] r0 = new byte[r0]     // Catch:{ all -> 0x019b }
                r7.readFully(r0)     // Catch:{ all -> 0x019b }
                r7.close()     // Catch:{ all -> 0x01c3 }
                r7 = r0
                goto L_0x01ae
            L_0x019b:
                r0 = move-exception
                r2 = r7
                goto L_0x01a2
            L_0x019e:
                r0 = move-exception
                goto L_0x01a2
            L_0x01a0:
                r0 = move-exception
                r5 = r2
            L_0x01a2:
                if (r2 != 0) goto L_0x01aa
                if (r5 == 0) goto L_0x01ad
                r5.close()     // Catch:{ all -> 0x01c3 }
                goto L_0x01ad
            L_0x01aa:
                r2.close()     // Catch:{ all -> 0x01c3 }
            L_0x01ad:
                throw r0     // Catch:{ all -> 0x01c3 }
            L_0x01ae:
                r0 = r18
                r0.a((byte[]) r7)     // Catch:{ all -> 0x01c3 }
                java.util.HashMap<java.lang.String, java.lang.Object> r0 = r1.f27163d     // Catch:{ all -> 0x01c3 }
                java.lang.String r2 = "mreg_t"
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01c3 }
                long r7 = r7 - r3
                java.lang.Long r3 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x01c3 }
                r0.put(r2, r3)     // Catch:{ all -> 0x01c3 }
            L_0x01c3:
                r6.close()     // Catch:{ all -> 0x01c6 }
            L_0x01c6:
                return
            L_0x01c7:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x01df }
                java.lang.String r2 = "data has offset in pos 3"
                r0.<init>(r2)     // Catch:{ all -> 0x01df }
                throw r0     // Catch:{ all -> 0x01df }
            L_0x01cf:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x01df }
                java.lang.String r2 = "data has offset in pos 2"
                r0.<init>(r2)     // Catch:{ all -> 0x01df }
                throw r0     // Catch:{ all -> 0x01df }
            L_0x01d7:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x01df }
                java.lang.String r2 = "data has offset in pos 1"
                r0.<init>(r2)     // Catch:{ all -> 0x01df }
                throw r0     // Catch:{ all -> 0x01df }
            L_0x01df:
                r0 = move-exception
                r2 = r6
                goto L_0x01ea
            L_0x01e2:
                r0 = move-exception
                r7 = r6
                goto L_0x01ea
            L_0x01e5:
                r0 = move-exception
                goto L_0x01ea
            L_0x01e7:
                r0 = move-exception
                r7 = r16
            L_0x01ea:
                if (r2 == 0) goto L_0x01f0
                r2.close()     // Catch:{ all -> 0x01f3 }
                goto L_0x01f3
            L_0x01f0:
                r7.close()     // Catch:{ all -> 0x01f3 }
            L_0x01f3:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.cc.x.d.a(java.io.InputStream, java.util.ArrayList, com.mob.commons.cc.u):void");
        }
    }

    private x() {
    }

    public static int a() {
        return 70;
    }

    public static c a(String... strArr) {
        return a((Object[]) strArr);
    }

    public static c a(byte[]... bArr) {
        return a((Object[]) bArr);
    }

    private static c a(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        c cVar = new c(objArr[0]);
        for (int i11 = 1; i11 < objArr.length; i11++) {
            cVar.a(objArr[i11]);
        }
        return cVar;
    }
}
