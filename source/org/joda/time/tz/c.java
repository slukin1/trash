package org.joda.time.tz;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.DateTimeZone;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final File f25412a;

    /* renamed from: b  reason: collision with root package name */
    public final String f25413b;

    /* renamed from: c  reason: collision with root package name */
    public final ClassLoader f25414c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Object> f25415d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<String> f25416e;

    public c(File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("No file directory provided");
        } else if (!file.exists()) {
            throw new IOException("File directory doesn't exist: " + file);
        } else if (file.isDirectory()) {
            this.f25412a = file;
            this.f25413b = null;
            this.f25414c = null;
            Map<String, Object> d11 = d(e("ZoneInfoMap"));
            this.f25415d = d11;
            this.f25416e = Collections.unmodifiableSortedSet(new TreeSet(d11.keySet()));
        } else {
            throw new IOException("File doesn't refer to a directory: " + file);
        }
    }

    public static Map<String, Object> d(InputStream inputStream) throws IOException {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            f(dataInputStream, concurrentHashMap);
            concurrentHashMap.put(UtcDates.UTC, new SoftReference(DateTimeZone.UTC));
            return concurrentHashMap;
        } finally {
            try {
                dataInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void f(DataInputStream dataInputStream, Map<String, Object> map) throws IOException {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        int i11 = 0;
        for (int i12 = 0; i12 < readUnsignedShort; i12++) {
            strArr[i12] = dataInputStream.readUTF().intern();
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        while (i11 < readUnsignedShort2) {
            try {
                map.put(strArr[dataInputStream.readUnsignedShort()], strArr[dataInputStream.readUnsignedShort()]);
                i11++;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new IOException("Corrupt zone info map");
            }
        }
    }

    public DateTimeZone a(String str) {
        Object obj;
        if (str == null || (obj = this.f25415d.get(str)) == null) {
            return null;
        }
        if (obj instanceof SoftReference) {
            DateTimeZone dateTimeZone = (DateTimeZone) ((SoftReference) obj).get();
            if (dateTimeZone != null) {
                return dateTimeZone;
            }
            return c(str);
        } else if (str.equals(obj)) {
            return c(str);
        } else {
            return a((String) obj);
        }
    }

    public Set<String> b() {
        return this.f25416e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC, Splitter:B:24:0x0032] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.joda.time.DateTimeZone c(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.InputStream r1 = r5.e(r6)     // Catch:{ IOException -> 0x0020, all -> 0x001e }
            org.joda.time.DateTimeZone r2 = org.joda.time.tz.DateTimeZoneBuilder.b(r1, r6)     // Catch:{ IOException -> 0x001c }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.f25415d     // Catch:{ IOException -> 0x001c }
            java.lang.ref.SoftReference r4 = new java.lang.ref.SoftReference     // Catch:{ IOException -> 0x001c }
            r4.<init>(r2)     // Catch:{ IOException -> 0x001c }
            r3.put(r6, r4)     // Catch:{ IOException -> 0x001c }
            if (r1 == 0) goto L_0x0018
            r1.close()     // Catch:{ IOException -> 0x0018 }
        L_0x0018:
            return r2
        L_0x0019:
            r6 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x001c:
            r2 = move-exception
            goto L_0x0022
        L_0x001e:
            r6 = move-exception
            goto L_0x0030
        L_0x0020:
            r2 = move-exception
            r1 = r0
        L_0x0022:
            r5.g(r2)     // Catch:{ all -> 0x0019 }
            java.util.Map<java.lang.String, java.lang.Object> r2 = r5.f25415d     // Catch:{ all -> 0x0019 }
            r2.remove(r6)     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            return r0
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.c.c(java.lang.String):org.joda.time.DateTimeZone");
    }

    public final InputStream e(String str) throws IOException {
        InputStream inputStream;
        if (this.f25412a != null) {
            return new FileInputStream(new File(this.f25412a, str));
        }
        String concat = this.f25413b.concat(str);
        ClassLoader classLoader = this.f25414c;
        if (classLoader != null) {
            inputStream = classLoader.getResourceAsStream(concat);
        } else {
            inputStream = ClassLoader.getSystemResourceAsStream(concat);
        }
        if (inputStream != null) {
            return inputStream;
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Resource not found: \"");
        sb2.append(concat);
        sb2.append("\" ClassLoader: ");
        ClassLoader classLoader2 = this.f25414c;
        sb2.append(classLoader2 != null ? classLoader2.toString() : "system");
        throw new IOException(sb2.toString());
    }

    public void g(Exception exc) {
        exc.printStackTrace();
    }

    public c(String str) throws IOException {
        this(str, (ClassLoader) null, false);
    }

    public c(String str, ClassLoader classLoader, boolean z11) throws IOException {
        if (str != null) {
            if (!str.endsWith("/")) {
                str = str + '/';
            }
            this.f25412a = null;
            this.f25413b = str;
            if (classLoader == null && !z11) {
                classLoader = getClass().getClassLoader();
            }
            this.f25414c = classLoader;
            Map<String, Object> d11 = d(e("ZoneInfoMap"));
            this.f25415d = d11;
            this.f25416e = Collections.unmodifiableSortedSet(new TreeSet(d11.keySet()));
            return;
        }
        throw new IllegalArgumentException("No resource path provided");
    }
}
