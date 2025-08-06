package com.mob.tools.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mob.commons.a.l;
import com.mob.commons.o;
import com.mob.commons.p;
import com.mob.commons.v;
import com.mob.commons.z;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.EverythingKeeper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MobPersistence {

    /* renamed from: h  reason: collision with root package name */
    private static final int f28055h = Process.myPid();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f28056a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f28057b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, j> f28058c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantReadWriteLock f28059d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final ReentrantReadWriteLock.WriteLock f28060e;

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f28061f;

    /* renamed from: g  reason: collision with root package name */
    private final f f28062g;

    public static final class KVEntry<T> implements EverythingKeeper, Serializable {
        private static final long serialVersionUID = -1538971823189206429L;
        private String key;
        private T value;

        public KVEntry(String str, T t11) {
            this.key = str;
            this.value = t11;
        }

        public String getKey() {
            return this.key;
        }

        public T getValue() {
            return this.value;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setValue(T t11) {
            this.value = t11;
        }
    }

    public static class NoValidDataException extends Exception {
        public NoValidDataException() {
            this(l.a("019>fheljgeeTeh+ejedjged+eje^jgfgelehYf$ed"));
        }

        public NoValidDataException(String str) {
            super(str);
        }
    }

    public static final class SerializableParcel<T extends Parcelable> implements EverythingKeeper, Serializable {
        private static final long serialVersionUID = -2769878423373647357L;
        private Class<T> clazz;
        private byte[] data;

        public SerializableParcel(Parcelable parcelable) {
            this.clazz = parcelable.getClass();
            this.data = parcelable2Byte(parcelable);
        }

        private T byte2Parcelable(byte[] bArr, Class<T> cls, T t11) {
            if (!(bArr == null || bArr.length == 0)) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    return (Parcelable) ((Parcelable.Creator) cls.getDeclaredField(l.a("007=fehkhjgegdhihk")).get((Object) null)).createFromParcel(obtain);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            return t11;
        }

        private byte[] parcelable2Byte(Parcelable parcelable) {
            if (parcelable == null) {
                return new byte[0];
            }
            Parcel obtain = Parcel.obtain();
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        }

        private void setClazz(Class cls) {
            this.clazz = cls;
        }

        private void setData(byte[] bArr) {
            this.data = bArr;
        }

        public Class getClazz() {
            return this.clazz;
        }

        public byte[] getData() {
            return this.data;
        }

        public T getParcel(T t11) {
            return byte2Parcelable(this.data, this.clazz, t11);
        }
    }

    public static final class a<T> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f28065a;

        /* renamed from: b  reason: collision with root package name */
        private T f28066b;

        public a(String str, T t11) {
            this.f28065a = str;
            this.f28066b = t11;
        }

        public HashMap<Byte, Object> b() {
            HashMap<Byte, Object> hashMap = new HashMap<>();
            hashMap.put((byte) 0, this.f28065a);
            hashMap.put((byte) 1, this.f28066b);
            return hashMap;
        }

        public T a() {
            return this.f28066b;
        }

        public static <T> a<T> a(HashMap<Byte, Object> hashMap) {
            if (hashMap != null) {
                return new a<>((String) hashMap.get((byte) 0), hashMap.get((byte) 1));
            }
            return null;
        }
    }

    public static final class b<T extends Parcelable> {

        /* renamed from: a  reason: collision with root package name */
        private Class<T> f28067a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f28068b;

        public b(Parcelable parcelable) {
            this.f28067a = parcelable.getClass();
            this.f28068b = b(parcelable);
        }

        public Class a() {
            return this.f28067a;
        }

        public HashMap<Byte, Object> b() {
            HashMap<Byte, Object> hashMap = new HashMap<>();
            hashMap.put((byte) 0, this.f28067a);
            hashMap.put((byte) 1, this.f28068b);
            return hashMap;
        }

        public T a(T t11) {
            return a(this.f28068b, this.f28067a, t11);
        }

        public static <T extends Parcelable> b<T> a(HashMap<Byte, Object> hashMap) {
            if (hashMap != null) {
                return new b<>((Class) hashMap.get((byte) 0), (byte[]) hashMap.get((byte) 1));
            }
            return null;
        }

        public b(Class<T> cls, byte[] bArr) {
            this.f28067a = cls;
            this.f28068b = bArr;
        }

        private byte[] b(Parcelable parcelable) {
            if (parcelable == null) {
                return new byte[0];
            }
            Parcel obtain = Parcel.obtain();
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        }

        private T a(byte[] bArr, Class<T> cls, T t11) {
            if (!(bArr == null || bArr.length == 0)) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    return (Parcelable) ((Parcelable.Creator) cls.getDeclaredField(l.a("0072fehkhjgegdhihk")).get((Object) null)).createFromParcel(obtain);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
            return t11;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private long f28069a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Object f28070b;

        private c(long j11, Object obj) {
            this.f28069a = j11;
            this.f28070b = obj;
        }

        /* access modifiers changed from: private */
        public boolean a() {
            long j11 = this.f28069a;
            if (j11 != 0 && j11 <= System.currentTimeMillis()) {
                return true;
            }
            return false;
        }
    }

    public class d implements Runnable {
        private d() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:65:0x013b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x013c, code lost:
            com.mob.tools.utils.MobPersistence.a(r0, com.mob.tools.utils.MobPersistence.i.a(com.mob.tools.utils.MobPersistence.c(r7.f28071a)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x014a, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            com.mob.tools.utils.MobPersistence.d(r7.f28071a).schedule(r7, 3000, java.util.concurrent.TimeUnit.MILLISECONDS);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0157, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0158, code lost:
            com.mob.tools.utils.MobPersistence.a(r0, com.mob.tools.utils.MobPersistence.i.a(com.mob.tools.utils.MobPersistence.c(r7.f28071a)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0165, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:51:0x00fb, B:61:0x0122] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2 A[Catch:{ all -> 0x00d3, all -> 0x00ec }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                r0 = 3000(0xbb8, double:1.482E-320)
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0121 }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.f28060e     // Catch:{ all -> 0x0121 }
                r2.lock()     // Catch:{ all -> 0x0121 }
                r2 = 0
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0060 }
                java.util.Map r3 = r3.f28058c     // Catch:{ all -> 0x0060 }
                boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0060 }
                if (r3 != 0) goto L_0x0047
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0060 }
                com.mob.tools.utils.MobPersistence r4 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0060 }
                java.util.Map r4 = r4.f28058c     // Catch:{ all -> 0x0060 }
                java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x0060 }
                r3.<init>(r4)     // Catch:{ all -> 0x0060 }
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0045 }
                java.util.Map r2 = r2.f28058c     // Catch:{ all -> 0x0045 }
                r2.clear()     // Catch:{ all -> 0x0045 }
                boolean r2 = r3.isEmpty()     // Catch:{ all -> 0x0045 }
                if (r2 != 0) goto L_0x0043
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0045 }
                com.mob.tools.utils.MobPersistence$i r2 = r2.f28056a     // Catch:{ all -> 0x0045 }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.b()     // Catch:{ all -> 0x0045 }
                r2.lock()     // Catch:{ all -> 0x0045 }
            L_0x0043:
                r2 = r3
                goto L_0x0047
            L_0x0045:
                r2 = move-exception
                goto L_0x0064
            L_0x0047:
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0051 }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.f28060e     // Catch:{ all -> 0x0051 }
                r3.unlock()     // Catch:{ all -> 0x0051 }
                goto L_0x008a
            L_0x0051:
                r3 = move-exception
                com.mob.tools.utils.MobPersistence r4 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence$i r4 = r4.f28056a     // Catch:{ all -> 0x0121 }
                java.lang.String r4 = r4.f28088j     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0121 }
                goto L_0x008a
            L_0x0060:
                r3 = move-exception
                r6 = r3
                r3 = r2
                r2 = r6
            L_0x0064:
                com.mob.tools.utils.MobPersistence r4 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0107 }
                com.mob.tools.utils.MobPersistence$i r4 = r4.f28056a     // Catch:{ all -> 0x0107 }
                java.lang.String r4 = r4.f28088j     // Catch:{ all -> 0x0107 }
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0107 }
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x007b }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.f28060e     // Catch:{ all -> 0x007b }
                r2.unlock()     // Catch:{ all -> 0x007b }
                goto L_0x0089
            L_0x007b:
                r2 = move-exception
                com.mob.tools.utils.MobPersistence r4 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence$i r4 = r4.f28056a     // Catch:{ all -> 0x0121 }
                java.lang.String r4 = r4.f28088j     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r2, (java.lang.String) r4)     // Catch:{ all -> 0x0121 }
            L_0x0089:
                r2 = r3
            L_0x008a:
                if (r2 == 0) goto L_0x00fb
                boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0121 }
                if (r3 != 0) goto L_0x00fb
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x00ec }
                com.mob.tools.utils.MobPersistence$i r3 = r3.f28056a     // Catch:{ all -> 0x00ec }
                java.util.List r2 = r3.a((java.util.List<com.mob.tools.utils.MobPersistence.j>) r2)     // Catch:{ all -> 0x00ec }
                boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x00ec }
                if (r3 != 0) goto L_0x00de
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x00ec }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.f28060e     // Catch:{ all -> 0x00ec }
                r3.lock()     // Catch:{ all -> 0x00ec }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00d3 }
            L_0x00af:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00d3 }
                if (r3 == 0) goto L_0x00c9
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00d3 }
                com.mob.tools.utils.MobPersistence$j r3 = (com.mob.tools.utils.MobPersistence.j) r3     // Catch:{ all -> 0x00d3 }
                com.mob.tools.utils.MobPersistence r4 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x00d3 }
                java.util.Map r4 = r4.f28058c     // Catch:{ all -> 0x00d3 }
                java.lang.String r5 = r3.f28116a     // Catch:{ all -> 0x00d3 }
                r4.put(r5, r3)     // Catch:{ all -> 0x00d3 }
                goto L_0x00af
            L_0x00c9:
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x00ec }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.f28060e     // Catch:{ all -> 0x00ec }
                r2.unlock()     // Catch:{ all -> 0x00ec }
                goto L_0x00de
            L_0x00d3:
                r2 = move-exception
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x00ec }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.f28060e     // Catch:{ all -> 0x00ec }
                r3.unlock()     // Catch:{ all -> 0x00ec }
                throw r2     // Catch:{ all -> 0x00ec }
            L_0x00de:
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence$i r2 = r2.f28056a     // Catch:{ all -> 0x0121 }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.b()     // Catch:{ all -> 0x0121 }
                r2.unlock()     // Catch:{ all -> 0x0121 }
                goto L_0x00fb
            L_0x00ec:
                r2 = move-exception
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence$i r3 = r3.f28056a     // Catch:{ all -> 0x0121 }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.b()     // Catch:{ all -> 0x0121 }
                r3.unlock()     // Catch:{ all -> 0x0121 }
                throw r2     // Catch:{ all -> 0x0121 }
            L_0x00fb:
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x013b }
                java.util.concurrent.ScheduledExecutorService r2 = r2.f28057b     // Catch:{ all -> 0x013b }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x013b }
                r2.schedule(r7, r0, r3)     // Catch:{ all -> 0x013b }
                goto L_0x0149
            L_0x0107:
                r2 = move-exception
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0112 }
                java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r3 = r3.f28060e     // Catch:{ all -> 0x0112 }
                r3.unlock()     // Catch:{ all -> 0x0112 }
                goto L_0x0120
            L_0x0112:
                r3 = move-exception
                com.mob.tools.utils.MobPersistence r4 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence$i r4 = r4.f28056a     // Catch:{ all -> 0x0121 }
                java.lang.String r4 = r4.f28088j     // Catch:{ all -> 0x0121 }
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0121 }
            L_0x0120:
                throw r2     // Catch:{ all -> 0x0121 }
            L_0x0121:
                r2 = move-exception
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x014a }
                com.mob.tools.utils.MobPersistence$i r3 = r3.f28056a     // Catch:{ all -> 0x014a }
                java.lang.String r3 = r3.f28088j     // Catch:{ all -> 0x014a }
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r2, (java.lang.String) r3)     // Catch:{ all -> 0x014a }
                com.mob.tools.utils.MobPersistence r2 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x013b }
                java.util.concurrent.ScheduledExecutorService r2 = r2.f28057b     // Catch:{ all -> 0x013b }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x013b }
                r2.schedule(r7, r0, r3)     // Catch:{ all -> 0x013b }
                goto L_0x0149
            L_0x013b:
                r0 = move-exception
                com.mob.tools.utils.MobPersistence r1 = com.mob.tools.utils.MobPersistence.this
                com.mob.tools.utils.MobPersistence$i r1 = r1.f28056a
                java.lang.String r1 = r1.f28088j
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r0, (java.lang.String) r1)
            L_0x0149:
                return
            L_0x014a:
                r2 = move-exception
                com.mob.tools.utils.MobPersistence r3 = com.mob.tools.utils.MobPersistence.this     // Catch:{ all -> 0x0157 }
                java.util.concurrent.ScheduledExecutorService r3 = r3.f28057b     // Catch:{ all -> 0x0157 }
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0157 }
                r3.schedule(r7, r0, r4)     // Catch:{ all -> 0x0157 }
                goto L_0x0165
            L_0x0157:
                r0 = move-exception
                com.mob.tools.utils.MobPersistence r1 = com.mob.tools.utils.MobPersistence.this
                com.mob.tools.utils.MobPersistence$i r1 = r1.f28056a
                java.lang.String r1 = r1.f28088j
                com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r0, (java.lang.String) r1)
            L_0x0165:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.MobPersistence.d.run():void");
        }
    }

    public static class e<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f28072a;

        public e(String str) {
            this.f28072a = str;
        }

        public T a(Object obj) {
            return obj;
        }

        public String a() {
            return this.f28072a;
        }
    }

    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f28073a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f28074b;

        private static Object b(byte[] bArr) throws Throwable {
            ObjectInputStream objectInputStream;
            ByteArrayInputStream byteArrayInputStream;
            Throwable th2;
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

        private f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f28074b = false;
                return;
            }
            this.f28074b = true;
            try {
                this.f28073a = str.getBytes("utf-8");
            } catch (Throwable unused) {
            }
        }

        /* access modifiers changed from: private */
        public Object a(byte[] bArr, Object obj) {
            try {
                return a(bArr);
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                return obj;
            }
        }

        private Object a(byte[] bArr) throws Throwable {
            if (bArr == null || bArr.length == 0) {
                return null;
            }
            if (!this.f28074b) {
                return b(bArr);
            }
            if (bArr.length % 16 != 0) {
                return b(bArr);
            }
            try {
                return b(Data.paddingDecode(this.f28073a, bArr));
            } catch (Throwable unused) {
                MobPersistence.d("decode fail ", "ENCIPER");
                return b(bArr);
            }
        }

        /* access modifiers changed from: private */
        public byte[] a(Object obj) throws Throwable {
            ByteArrayOutputStream byteArrayOutputStream;
            ObjectOutputStream objectOutputStream;
            if (obj == null) {
                return new byte[0];
            }
            ObjectOutputStream objectOutputStream2 = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    v.a(objectOutputStream2, byteArrayOutputStream);
                    throw th;
                }
                try {
                    objectOutputStream.writeObject(obj);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (this.f28074b) {
                        byte[] AES128Encode = Data.AES128Encode(this.f28073a, byteArray);
                        v.a(objectOutputStream, byteArrayOutputStream);
                        return AES128Encode;
                    }
                    v.a(objectOutputStream, byteArrayOutputStream);
                    return byteArray;
                } catch (Throwable th3) {
                    th = th3;
                    objectOutputStream2 = objectOutputStream;
                    v.a(objectOutputStream2, byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                v.a(objectOutputStream2, byteArrayOutputStream);
                throw th;
            }
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f28075a;

        public g(byte[] bArr) {
            this.f28075a = bArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || g.class != obj.getClass()) {
                return false;
            }
            return Arrays.equals(this.f28075a, ((g) obj).f28075a);
        }

        public int hashCode() {
            return Arrays.hashCode(this.f28075a);
        }
    }

    public static final class h {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f28076a;

        /* renamed from: b  reason: collision with root package name */
        private volatile LinkedHashMap<g, c> f28077b;

        private h(int i11) {
            this.f28076a = i11;
            this.f28077b = new LinkedHashMap<g, c>(i11, 0.75f, true) {
                public boolean removeEldestEntry(Map.Entry<g, c> entry) {
                    return size() > h.this.f28076a;
                }
            };
        }

        /* access modifiers changed from: private */
        public void b(g gVar) {
            this.f28077b.remove(gVar);
        }

        /* access modifiers changed from: private */
        public c a(g gVar) {
            return this.f28077b.get(gVar);
        }

        /* access modifiers changed from: private */
        public void a(g gVar, c cVar) {
            this.f28077b.put(gVar, cVar);
        }

        /* access modifiers changed from: private */
        public void a() {
            this.f28077b.clear();
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        private final ReentrantReadWriteLock f28079a;

        /* renamed from: b  reason: collision with root package name */
        private final ReentrantReadWriteLock.WriteLock f28080b;

        /* renamed from: c  reason: collision with root package name */
        private final ReentrantReadWriteLock.ReadLock f28081c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public File f28082d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public volatile RandomAccessFile f28083e;

        /* renamed from: f  reason: collision with root package name */
        private volatile long f28084f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public volatile LinkedList<a> f28085g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public volatile HashMap<g, a> f28086h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public final Context f28087i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final String f28088j;

        /* renamed from: k  reason: collision with root package name */
        private final File f28089k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public final f f28090l;
        /* access modifiers changed from: private */

        /* renamed from: m  reason: collision with root package name */
        public final h f28091m = new h(60);

        public static class a implements Comparable<a> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f28109a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public byte f28110b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public byte[] f28111c;
            /* access modifiers changed from: private */

            /* renamed from: d  reason: collision with root package name */
            public long f28112d;
            /* access modifiers changed from: private */

            /* renamed from: e  reason: collision with root package name */
            public long f28113e;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public long f28114f;
            /* access modifiers changed from: private */

            /* renamed from: g  reason: collision with root package name */
            public long f28115g;

            public a(int i11) {
                this.f28109a = i11;
                this.f28115g = (((long) i11) * 41) + 1024;
            }

            public boolean e() {
                if (d() != 0 && d() <= System.currentTimeMillis()) {
                    return true;
                }
                return false;
            }

            public void f() {
                this.f28110b = 1;
                this.f28111c = null;
                this.f28114f = -1;
                this.f28112d = 0;
                this.f28113e = 0;
            }

            public long b() {
                return this.f28112d;
            }

            public long c() {
                return this.f28113e;
            }

            public long d() {
                return this.f28114f;
            }

            /* access modifiers changed from: private */
            public void b(long j11) {
                this.f28113e = j11;
            }

            /* access modifiers changed from: private */
            public void c(long j11) {
                this.f28114f = j11;
            }

            public long a() {
                return this.f28115g;
            }

            /* access modifiers changed from: private */
            public void a(byte b11) {
                this.f28110b = b11;
            }

            /* access modifiers changed from: private */
            public void a(byte[] bArr) {
                this.f28111c = bArr;
            }

            /* access modifiers changed from: private */
            public void a(long j11) {
                this.f28112d = j11;
            }

            public void a(byte b11, byte[] bArr, long j11, long j12) {
                this.f28110b = b11;
                this.f28111c = bArr;
                this.f28113e = j11;
                this.f28114f = j12;
            }

            /* renamed from: a */
            public int compareTo(a aVar) {
                return Long.compare(b(), aVar.b());
            }
        }

        public i(Context context, String str, f fVar) {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            this.f28079a = reentrantReadWriteLock;
            this.f28080b = reentrantReadWriteLock.writeLock();
            this.f28081c = reentrantReadWriteLock.readLock();
            this.f28087i = context;
            this.f28088j = str;
            this.f28089k = p.a(p.f27295h + str);
            this.f28090l = fVar;
            f();
        }

        /* access modifiers changed from: private */
        public void k() throws Throwable {
            if (new Random().nextInt(10) < 1) {
                g();
            }
            this.f28084f = System.currentTimeMillis();
            this.f28083e.seek(0);
            this.f28083e.writeLong(this.f28084f);
        }

        private long l() throws Throwable {
            this.f28083e.seek(0);
            return this.f28083e.readLong();
        }

        private long d(long j11) throws Throwable {
            try {
                this.f28083e.seek(j11 + 33);
                return this.f28083e.readLong();
            } catch (Throwable th2) {
                MobPersistence.b(th2, a());
                return 0;
            }
        }

        private void f() {
            this.f28080b.lock();
            try {
                p.a(this.f28089k.getAbsolutePath(), true, com.sumsub.sns.internal.ml.autocapture.a.f34923p, 50, new o() {
                    public boolean a(FileLocker fileLocker) {
                        try {
                            if (i.this.f28087i == null) {
                                return false;
                            }
                            File unused = i.this.f28082d = new File(MobPersistence.a(i.this.f28087i), i.this.f28088j);
                            if (!i.this.f28082d.getParentFile().exists()) {
                                i.this.f28082d.getParentFile().mkdirs();
                            }
                            if (i.this.f28082d.exists() && i.this.f28082d.length() < 43008) {
                                MobPersistence.c("Del dirty, size: " + i.this.f28082d.length() + ", min: " + 43008, i.this.f28088j);
                                i.this.f28082d.delete();
                            }
                            if (!i.this.f28082d.exists()) {
                                i.this.f28082d.createNewFile();
                                RandomAccessFile unused2 = i.this.f28083e = new RandomAccessFile(i.this.f28082d, l.a("002?ekgh"));
                                i.this.b(1024);
                                return false;
                            }
                            RandomAccessFile unused3 = i.this.f28083e = new RandomAccessFile(i.this.f28082d, l.a("002'ekgh"));
                            boolean unused4 = i.this.i();
                            MobPersistence.d("ava sz " + i.this.f28085g.size() + " useds " + i.this.f28086h.size(), i.this.f28088j);
                            return false;
                        } catch (Throwable th2) {
                            MobPersistence.b(th2, i.this.f28088j);
                            return false;
                        }
                    }
                });
            } finally {
                this.f28080b.unlock();
            }
        }

        private void g() throws Throwable {
            long c11;
            MobPersistence.d(" [trim] try ", this.f28088j);
            long size = (((long) (this.f28086h.size() + this.f28085g.size())) * 41) + 1024;
            long length = this.f28083e.length();
            double d11 = 0.0d;
            for (a c12 : this.f28086h.values()) {
                d11 += (double) c12.c();
            }
            long j11 = length - size;
            if (d11 / ((double) j11) <= 0.5d) {
                Iterator<a> it2 = h().iterator();
                long j12 = size;
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next.e()) {
                        e(next);
                    } else {
                        if (next.b() == j12) {
                            c11 = next.c();
                        } else if (next.b() > j12) {
                            a(next, j12);
                            c11 = next.c();
                        }
                        j12 += c11;
                    }
                }
                this.f28083e.setLength(j12);
                MobPersistence.d(" [trim] real over  before dataBlockSize " + j11 + " cur " + (j12 - size), this.f28088j);
            }
        }

        private ArrayList<a> h() {
            ArrayList<a> arrayList = new ArrayList<>(this.f28086h.values());
            Collections.sort(arrayList);
            return arrayList;
        }

        /* access modifiers changed from: private */
        public boolean i() throws Throwable {
            boolean[] zArr = {false};
            long l11 = l();
            if (l11 != this.f28084f) {
                this.f28080b.lock();
                try {
                    this.f28091m.a();
                    this.f28084f = l11;
                    this.f28085g = new LinkedList<>();
                    this.f28086h = new HashMap<>();
                    int c11 = c();
                    for (int i11 = 0; i11 < c11; i11++) {
                        a aVar = new a(i11);
                        if (b(aVar) == 1) {
                            this.f28085g.add(aVar);
                        } else {
                            a(aVar);
                            this.f28086h.put(new g(aVar.f28111c), aVar);
                        }
                    }
                    MobPersistence.d("update lstt " + this.f28084f + " a " + this.f28085g.size() + " u " + this.f28086h.size(), this.f28088j);
                    zArr[0] = true;
                } finally {
                    this.f28080b.unlock();
                }
            }
            return zArr[0];
        }

        private void j() throws Throwable {
            int c11 = c();
            int i11 = c11 + 1024;
            MobPersistence.d("[exp] old " + c11 + " new " + i11, this.f28088j);
            long j11 = (((long) i11) * 41) + 1024;
            if ((((long) (this.f28086h.size() + this.f28085g.size())) * 41) + 1024 < j11) {
                Iterator<a> it2 = h().iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next.b() < j11) {
                        long b11 = next.b() + next.c();
                        if (next.e()) {
                            e(next);
                        } else {
                            a(next, this.f28083e.length());
                        }
                        if (b11 >= j11) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            this.f28083e.seek(j11);
            for (int i12 = c11 - 1; i12 < i11; i12++) {
                a aVar = new a(i12);
                this.f28085g.add(aVar);
                a(aVar.f28115g, (byte) 1);
            }
            MobPersistence.d("[exp] ovr", this.f28088j);
            a(i11);
        }

        public List<byte[]> e() {
            this.f28080b.lock();
            final ArrayList arrayList = new ArrayList();
            try {
                p.a(this.f28089k.getAbsolutePath(), true, com.sumsub.sns.internal.ml.autocapture.a.f34923p, 50, new o() {
                    public boolean a(FileLocker fileLocker) {
                        try {
                            boolean unused = i.this.i();
                            if (i.this.f28086h == null) {
                                return false;
                            }
                            for (a c11 : i.this.f28086h.values()) {
                                arrayList.add(i.this.f(c11));
                            }
                            return false;
                        } catch (Throwable th2) {
                            MobPersistence.b(th2, i.this.a());
                            return false;
                        }
                    }
                });
                return arrayList;
            } finally {
                this.f28080b.unlock();
            }
        }

        private long c(long j11) throws Throwable {
            try {
                this.f28083e.seek(j11 + 25);
                return this.f28083e.readLong();
            } catch (Throwable th2) {
                MobPersistence.b(th2, a());
                return -1;
            }
        }

        public ReentrantReadWriteLock.WriteLock b() {
            return this.f28080b;
        }

        private long b(long j11) throws Throwable {
            try {
                this.f28083e.seek(j11 + 17);
                return this.f28083e.readLong();
            } catch (Throwable th2) {
                MobPersistence.b(th2, a());
                return -1;
            }
        }

        /* JADX INFO: finally extract failed */
        public boolean d() {
            this.f28080b.lock();
            final boolean[] zArr = new boolean[1];
            try {
                p.a(this.f28089k.getAbsolutePath(), true, com.sumsub.sns.internal.ml.autocapture.a.f34923p, 50, new o() {
                    public boolean a(FileLocker fileLocker) {
                        try {
                            for (a aVar : i.this.f28086h.values()) {
                                i.this.f28083e.seek(aVar.a());
                                i.this.f28083e.writeByte(1);
                                aVar.f();
                            }
                            i.this.f28085g.addAll(i.this.f28086h.values());
                            i.this.f28086h.clear();
                            i.this.f28083e.setLength((((long) i.this.f28085g.size()) * 41) + 1024);
                            zArr[0] = true;
                            i.this.k();
                            MobPersistence.d("Clear done, new size: ", i.this.f28088j);
                        } catch (Throwable th2) {
                            MobPersistence.b(th2, i.this.f28088j);
                        }
                        return false;
                    }
                });
                this.f28080b.unlock();
                return zArr[0];
            } catch (Throwable th2) {
                this.f28080b.unlock();
                throw th2;
            }
        }

        /* access modifiers changed from: private */
        public byte[] f(a aVar) throws Throwable {
            this.f28083e.seek(aVar.b());
            byte[] bArr = new byte[((int) aVar.f28113e)];
            this.f28083e.readFully(bArr);
            return bArr;
        }

        public int c() {
            try {
                this.f28083e.seek(8);
                return this.f28083e.readInt();
            } catch (Throwable th2) {
                MobPersistence.b(th2, this.f28088j);
                return 0;
            }
        }

        private void e(a aVar) throws Throwable {
            this.f28086h.remove(new g(aVar.f28111c));
            this.f28083e.seek(aVar.a());
            this.f28083e.writeByte(1);
            this.f28085g.add(aVar);
            aVar.f();
        }

        /* access modifiers changed from: private */
        public void b(int i11) throws Throwable {
            this.f28085g = new LinkedList<>();
            this.f28086h = new HashMap<>();
            a(0, i11);
            a(i11);
            this.f28084f = System.currentTimeMillis();
            this.f28083e.seek(0);
            this.f28083e.writeLong(this.f28084f);
            MobPersistence.d("new a " + this.f28085g.size() + " u " + this.f28086h.size(), this.f28088j);
        }

        private void c(int i11) {
            if (i11 >= 0) {
                int c11 = c();
                if (i11 >= c11) {
                    throw new IndexOutOfBoundsException(b(i11, c11));
                }
                return;
            }
            throw new IllegalArgumentException("index : " + i11);
        }

        public String a() {
            return this.f28088j;
        }

        public void a(a aVar) {
            try {
                c(aVar.f28109a);
                this.f28083e.seek(aVar.a());
                aVar.a(this.f28083e.readByte());
                aVar.a(a(aVar.f28115g));
                aVar.a(b(aVar.f28115g));
                aVar.b(c(aVar.f28115g));
                aVar.c(d(aVar.f28115g));
            } catch (Throwable th2) {
                MobPersistence.b(th2, this.f28088j);
            }
        }

        /* access modifiers changed from: private */
        public void d(a aVar) throws Throwable {
            this.f28080b.lock();
            try {
                e(aVar);
                k();
            } finally {
                this.f28080b.unlock();
            }
        }

        /* access modifiers changed from: private */
        public boolean c(a aVar) {
            try {
                byte[] bArr = new byte[41];
                bArr[0] = 0;
                System.arraycopy(aVar.f28111c, 0, bArr, 1, 16);
                a(aVar.f28112d, bArr, 17);
                a(aVar.f28113e, bArr, 25);
                a(aVar.f28114f, bArr, 33);
                this.f28083e.seek(aVar.f28115g);
                this.f28083e.write(bArr);
                return true;
            } catch (Throwable th2) {
                MobPersistence.b(th2, this.f28088j);
                return false;
            }
        }

        public byte b(a aVar) throws Throwable {
            try {
                this.f28083e.seek(aVar.f28115g);
                return this.f28083e.readByte();
            } catch (Throwable th2) {
                MobPersistence.b(th2, this.f28088j);
                return 0;
            }
        }

        private byte[] a(long j11) throws Throwable {
            byte[] bArr = new byte[16];
            this.f28083e.seek(j11 + 1);
            this.f28083e.read(bArr, 0, 16);
            return bArr;
        }

        private String b(int i11, int i12) {
            return "Index: " + i11 + ", Size: " + i12;
        }

        private void a(a aVar, long j11) throws Throwable {
            byte[] bArr = new byte[((int) aVar.f28113e)];
            this.f28083e.seek(aVar.f28112d);
            this.f28083e.readFully(bArr);
            this.f28083e.seek(j11);
            this.f28083e.write(bArr);
            this.f28083e.seek(aVar.f28115g + 17);
            this.f28083e.writeLong(j11);
            aVar.a(j11);
            this.f28086h.put(new g(aVar.f28111c), aVar);
        }

        /* access modifiers changed from: private */
        public boolean b(g gVar) {
            try {
                i();
                a aVar = this.f28086h.get(gVar);
                if (aVar != null) {
                    d(aVar);
                }
                this.f28091m.b(gVar);
                return true;
            } catch (Throwable th2) {
                MobPersistence.b(th2, a());
                return false;
            }
        }

        public void a(int i11) {
            if (i11 > 0) {
                try {
                    this.f28083e.seek(8);
                    this.f28083e.writeInt(i11);
                } catch (Throwable th2) {
                    MobPersistence.b(th2, this.f28088j);
                }
            } else {
                throw new IllegalArgumentException("indexNum : " + i11);
            }
        }

        private void a(int i11, int i12) {
            while (i11 < i12) {
                a aVar = new a(i11);
                this.f28085g.add(aVar);
                a(aVar.f28115g, (byte) 1);
                i11++;
            }
        }

        public void a(long j11, byte b11) {
            try {
                this.f28083e.seek(j11);
                this.f28083e.writeByte(b11);
            } catch (Throwable unused) {
            }
        }

        /* access modifiers changed from: private */
        public void a(a aVar, j jVar) throws Throwable {
            FileOutputStream fileOutputStream;
            byte[] a11 = this.f28090l.a((Object) new a(jVar.a(), jVar.c()).b());
            long length = this.f28083e.length();
            BufferedOutputStream bufferedOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(this.f28083e.getFD());
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                    try {
                        this.f28083e.seek(length);
                        bufferedOutputStream2.write(a11);
                        bufferedOutputStream2.flush();
                        v.a(bufferedOutputStream2, fileOutputStream);
                        aVar.a((byte) 0, jVar.f28119d, (long) a11.length, jVar.f28118c);
                        long unused = aVar.f28112d = length;
                        c(aVar);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        v.a(bufferedOutputStream, fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    v.a(bufferedOutputStream, fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                v.a(bufferedOutputStream, fileOutputStream);
                throw th;
            }
        }

        /* access modifiers changed from: private */
        public a a(g gVar) throws Throwable {
            a aVar = this.f28086h.get(gVar);
            if (aVar != null) {
                return aVar;
            }
            if (this.f28085g.isEmpty()) {
                j();
            }
            a removeFirst = this.f28085g.removeFirst();
            removeFirst.a((byte) 0);
            this.f28086h.put(gVar, removeFirst);
            return removeFirst;
        }

        /* access modifiers changed from: private */
        public List<j> a(final List<j> list) {
            this.f28080b.lock();
            final ArrayList arrayList = new ArrayList();
            try {
                p.a(this.f28089k.getAbsolutePath(), true, 2000, 50, new o() {
                    /* JADX WARNING: Removed duplicated region for block: B:31:0x0126 A[Catch:{ all -> 0x017e, all -> 0x0205 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:38:0x014d A[Catch:{ all -> 0x017e, all -> 0x0205 }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean a(com.mob.tools.utils.FileLocker r23) {
                        /*
                            r22 = this;
                            r1 = r22
                            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r0 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            boolean unused = r0.i()     // Catch:{ all -> 0x0205 }
                            java.util.List r0 = r10     // Catch:{ all -> 0x0205 }
                            int r0 = r0.size()     // Catch:{ all -> 0x0205 }
                            r5 = 1
                            if (r0 <= r5) goto L_0x018b
                            java.util.LinkedList r6 = new java.util.LinkedList     // Catch:{ all -> 0x0205 }
                            r6.<init>()     // Catch:{ all -> 0x0205 }
                            java.util.List r0 = r10     // Catch:{ all -> 0x0205 }
                            int r0 = r0.size()     // Catch:{ all -> 0x0205 }
                            byte[][] r7 = new byte[r0][]     // Catch:{ all -> 0x0205 }
                            java.util.List r8 = r10     // Catch:{ all -> 0x0205 }
                            int r8 = r8.size()     // Catch:{ all -> 0x0205 }
                            r9 = 0
                        L_0x0028:
                            r10 = 0
                            if (r9 >= r8) goto L_0x009b
                            java.util.List r11 = r10     // Catch:{ all -> 0x0205 }
                            java.lang.Object r11 = r11.get(r9)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$j r11 = (com.mob.tools.utils.MobPersistence.j) r11     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$g r12 = new com.mob.tools.utils.MobPersistence$g     // Catch:{ all -> 0x0205 }
                            byte[] r13 = r11.f28119d     // Catch:{ all -> 0x0205 }
                            r12.<init>(r13)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$a r13 = new com.mob.tools.utils.MobPersistence$a     // Catch:{ all -> 0x0205 }
                            java.lang.String r14 = r11.a()     // Catch:{ all -> 0x0205 }
                            java.lang.Object r15 = r11.c()     // Catch:{ all -> 0x0205 }
                            r13.<init>(r14, r15)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r14 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$f r14 = r14.f28090l     // Catch:{ all -> 0x0205 }
                            java.util.HashMap r13 = r13.b()     // Catch:{ all -> 0x0205 }
                            byte[] r13 = r14.a((java.lang.Object) r13)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r14 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i$a r12 = r14.a((com.mob.tools.utils.MobPersistence.g) r12)     // Catch:{ all -> 0x0205 }
                            r16 = 0
                            byte[] r17 = r11.f28119d     // Catch:{ all -> 0x0205 }
                            int r14 = r13.length     // Catch:{ all -> 0x0205 }
                            long r14 = (long) r14     // Catch:{ all -> 0x0205 }
                            long r20 = r11.f28118c     // Catch:{ all -> 0x0205 }
                            r18 = r14
                            r15 = r12
                            r15.a(r16, r17, r18, r20)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r14 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$h r14 = r14.f28091m     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$g r15 = new com.mob.tools.utils.MobPersistence$g     // Catch:{ all -> 0x0205 }
                            byte[] r5 = r11.f()     // Catch:{ all -> 0x0205 }
                            r15.<init>(r5)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$c r5 = new com.mob.tools.utils.MobPersistence$c     // Catch:{ all -> 0x0205 }
                            r17 = r3
                            long r2 = r11.f28118c     // Catch:{ all -> 0x0205 }
                            java.lang.Object r4 = r11.f28117b     // Catch:{ all -> 0x0205 }
                            r5.<init>(r2, r4)     // Catch:{ all -> 0x0205 }
                            r14.a((com.mob.tools.utils.MobPersistence.g) r15, (com.mob.tools.utils.MobPersistence.c) r5)     // Catch:{ all -> 0x0205 }
                            r6.add(r12)     // Catch:{ all -> 0x0205 }
                            r7[r9] = r13     // Catch:{ all -> 0x0205 }
                            int r9 = r9 + 1
                            r3 = r17
                            r5 = 1
                            goto L_0x0028
                        L_0x009b:
                            r17 = r3
                            com.mob.tools.utils.MobPersistence$i r2 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            java.io.RandomAccessFile r2 = r2.f28083e     // Catch:{ all -> 0x0205 }
                            long r2 = r2.length()     // Catch:{ all -> 0x0205 }
                            r4 = 2
                            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x00f1 }
                            com.mob.tools.utils.MobPersistence$i r9 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x00f1 }
                            java.io.RandomAccessFile r9 = r9.f28083e     // Catch:{ all -> 0x00f1 }
                            java.io.FileDescriptor r9 = r9.getFD()     // Catch:{ all -> 0x00f1 }
                            r5.<init>(r9)     // Catch:{ all -> 0x00f1 }
                            java.io.BufferedOutputStream r9 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00ef }
                            r9.<init>(r5)     // Catch:{ all -> 0x00ef }
                            com.mob.tools.utils.MobPersistence$i r10 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x00ec }
                            java.io.RandomAccessFile r10 = r10.f28083e     // Catch:{ all -> 0x00ec }
                            com.mob.tools.utils.MobPersistence$i r11 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x00ec }
                            java.io.RandomAccessFile r11 = r11.f28083e     // Catch:{ all -> 0x00ec }
                            long r11 = r11.length()     // Catch:{ all -> 0x00ec }
                            r10.seek(r11)     // Catch:{ all -> 0x00ec }
                            r10 = 0
                        L_0x00d0:
                            if (r10 >= r0) goto L_0x00dc
                            r11 = r7[r10]     // Catch:{ all -> 0x00ec }
                            int r12 = r11.length     // Catch:{ all -> 0x00ec }
                            r13 = 0
                            r9.write(r11, r13, r12)     // Catch:{ all -> 0x00ec }
                            int r10 = r10 + 1
                            goto L_0x00d0
                        L_0x00dc:
                            r9.flush()     // Catch:{ all -> 0x00ec }
                            java.io.Closeable[] r0 = new java.io.Closeable[r4]     // Catch:{ all -> 0x0205 }
                            r4 = 0
                            r0[r4] = r9     // Catch:{ all -> 0x0205 }
                            r4 = 1
                            r0[r4] = r5     // Catch:{ all -> 0x0205 }
                            com.mob.commons.v.a((java.io.Closeable[]) r0)     // Catch:{ all -> 0x0205 }
                            r5 = 1
                            goto L_0x014b
                        L_0x00ec:
                            r0 = move-exception
                            r10 = r9
                            goto L_0x00f3
                        L_0x00ef:
                            r0 = move-exception
                            goto L_0x00f3
                        L_0x00f1:
                            r0 = move-exception
                            r5 = r10
                        L_0x00f3:
                            com.mob.tools.utils.MobPersistence$i r9 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x017e }
                            java.lang.String r9 = r9.f28088j     // Catch:{ all -> 0x017e }
                            com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r0, (java.lang.String) r9)     // Catch:{ all -> 0x017e }
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x017e }
                            r0.<init>()     // Catch:{ all -> 0x017e }
                            java.lang.String r9 = "sta err sz "
                            r0.append(r9)     // Catch:{ all -> 0x017e }
                            java.util.List r9 = r10     // Catch:{ all -> 0x017e }
                            int r9 = r9.size()     // Catch:{ all -> 0x017e }
                            r0.append(r9)     // Catch:{ all -> 0x017e }
                            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x017e }
                            com.mob.tools.utils.MobPersistence$i r9 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x017e }
                            java.lang.String r9 = r9.f28088j     // Catch:{ all -> 0x017e }
                            com.mob.tools.utils.MobPersistence.c(r0, r9)     // Catch:{ all -> 0x017e }
                            java.util.Iterator r0 = r6.iterator()     // Catch:{ all -> 0x017e }
                        L_0x0120:
                            boolean r9 = r0.hasNext()     // Catch:{ all -> 0x017e }
                            if (r9 == 0) goto L_0x0138
                            java.lang.Object r9 = r0.next()     // Catch:{ all -> 0x017e }
                            com.mob.tools.utils.MobPersistence$i$a r9 = (com.mob.tools.utils.MobPersistence.i.a) r9     // Catch:{ all -> 0x017e }
                            byte r11 = r9.f28110b     // Catch:{ all -> 0x017e }
                            if (r11 != 0) goto L_0x0120
                            com.mob.tools.utils.MobPersistence$i r11 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x017e }
                            r11.d((com.mob.tools.utils.MobPersistence.i.a) r9)     // Catch:{ all -> 0x017e }
                            goto L_0x0120
                        L_0x0138:
                            java.util.List r0 = r0     // Catch:{ all -> 0x017e }
                            java.util.List r9 = r10     // Catch:{ all -> 0x017e }
                            r0.addAll(r9)     // Catch:{ all -> 0x017e }
                            java.io.Closeable[] r0 = new java.io.Closeable[r4]     // Catch:{ all -> 0x0205 }
                            r4 = 0
                            r0[r4] = r10     // Catch:{ all -> 0x0205 }
                            r4 = 1
                            r0[r4] = r5     // Catch:{ all -> 0x0205 }
                            com.mob.commons.v.a((java.io.Closeable[]) r0)     // Catch:{ all -> 0x0205 }
                            r5 = 0
                        L_0x014b:
                            if (r5 == 0) goto L_0x017a
                            r0 = 0
                        L_0x014e:
                            if (r0 >= r8) goto L_0x017a
                            java.lang.Object r4 = r6.get(r0)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i$a r4 = (com.mob.tools.utils.MobPersistence.i.a) r4     // Catch:{ all -> 0x0205 }
                            long unused = r4.f28112d = r2     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r5 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            boolean r5 = r5.c((com.mob.tools.utils.MobPersistence.i.a) r4)     // Catch:{ all -> 0x0205 }
                            if (r5 == 0) goto L_0x0167
                            r4 = r7[r0]     // Catch:{ all -> 0x0205 }
                            int r4 = r4.length     // Catch:{ all -> 0x0205 }
                            long r4 = (long) r4     // Catch:{ all -> 0x0205 }
                            long r2 = r2 + r4
                            goto L_0x0177
                        L_0x0167:
                            com.mob.tools.utils.MobPersistence$i r5 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            r5.d((com.mob.tools.utils.MobPersistence.i.a) r4)     // Catch:{ all -> 0x0205 }
                            java.util.List r4 = r0     // Catch:{ all -> 0x0205 }
                            java.util.List r5 = r10     // Catch:{ all -> 0x0205 }
                            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0205 }
                            r4.add(r5)     // Catch:{ all -> 0x0205 }
                        L_0x0177:
                            int r0 = r0 + 1
                            goto L_0x014e
                        L_0x017a:
                            r6.clear()     // Catch:{ all -> 0x0205 }
                            goto L_0x01d1
                        L_0x017e:
                            r0 = move-exception
                            java.io.Closeable[] r2 = new java.io.Closeable[r4]     // Catch:{ all -> 0x0205 }
                            r3 = 0
                            r2[r3] = r10     // Catch:{ all -> 0x0205 }
                            r3 = 1
                            r2[r3] = r5     // Catch:{ all -> 0x0205 }
                            com.mob.commons.v.a((java.io.Closeable[]) r2)     // Catch:{ all -> 0x0205 }
                            throw r0     // Catch:{ all -> 0x0205 }
                        L_0x018b:
                            r17 = r3
                            java.util.List r0 = r10     // Catch:{ all -> 0x0205 }
                            r2 = 0
                            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0205 }
                            r2 = r0
                            com.mob.tools.utils.MobPersistence$j r2 = (com.mob.tools.utils.MobPersistence.j) r2     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$g r0 = new com.mob.tools.utils.MobPersistence$g     // Catch:{ all -> 0x0205 }
                            byte[] r3 = r2.f28119d     // Catch:{ all -> 0x0205 }
                            r0.<init>(r3)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r3 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i$a r3 = r3.a((com.mob.tools.utils.MobPersistence.g) r0)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r0 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x01ac }
                            r0.a((com.mob.tools.utils.MobPersistence.i.a) r3, (com.mob.tools.utils.MobPersistence.j) r2)     // Catch:{ all -> 0x01ac }
                            goto L_0x01d1
                        L_0x01ac:
                            r0 = move-exception
                            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0205 }
                            r4.<init>()     // Catch:{ all -> 0x0205 }
                            java.lang.String r5 = "set fail "
                            r4.append(r5)     // Catch:{ all -> 0x0205 }
                            r4.append(r0)     // Catch:{ all -> 0x0205 }
                            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r4 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            java.lang.String r4 = r4.f28088j     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence.d(r0, r4)     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r0 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            r0.d((com.mob.tools.utils.MobPersistence.i.a) r3)     // Catch:{ all -> 0x0205 }
                            java.util.List r0 = r0     // Catch:{ all -> 0x0205 }
                            r0.add(r2)     // Catch:{ all -> 0x0205 }
                        L_0x01d1:
                            com.mob.tools.utils.MobPersistence$i r0 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            r0.k()     // Catch:{ all -> 0x0205 }
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0205 }
                            r0.<init>()     // Catch:{ all -> 0x0205 }
                            java.lang.String r2 = " all cost "
                            r0.append(r2)     // Catch:{ all -> 0x0205 }
                            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0205 }
                            long r2 = r2 - r17
                            r0.append(r2)     // Catch:{ all -> 0x0205 }
                            java.lang.String r2 = " size "
                            r0.append(r2)     // Catch:{ all -> 0x0205 }
                            java.util.List r2 = r10     // Catch:{ all -> 0x0205 }
                            int r2 = r2.size()     // Catch:{ all -> 0x0205 }
                            r0.append(r2)     // Catch:{ all -> 0x0205 }
                            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence$i r2 = com.mob.tools.utils.MobPersistence.i.this     // Catch:{ all -> 0x0205 }
                            java.lang.String r2 = r2.f28088j     // Catch:{ all -> 0x0205 }
                            com.mob.tools.utils.MobPersistence.d(r0, r2)     // Catch:{ all -> 0x0205 }
                            goto L_0x020f
                        L_0x0205:
                            r0 = move-exception
                            com.mob.tools.utils.MobPersistence$i r2 = com.mob.tools.utils.MobPersistence.i.this
                            java.lang.String r2 = r2.f28088j
                            com.mob.tools.utils.MobPersistence.b((java.lang.Throwable) r0, (java.lang.String) r2)
                        L_0x020f:
                            r2 = 0
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.MobPersistence.i.AnonymousClass2.a(com.mob.tools.utils.FileLocker):boolean");
                    }
                });
                return arrayList;
            } finally {
                this.f28080b.unlock();
            }
        }

        private void a(long j11, byte[] bArr, int i11) {
            for (int i12 = i11 + 7; i12 >= i11; i12--) {
                bArr[i12] = (byte) ((int) (255 & j11));
                j11 >>= 8;
            }
        }

        /* JADX INFO: finally extract failed */
        public <T> T a(g gVar, e<T> eVar) throws Throwable {
            a aVar;
            byte[][] bArr = new byte[1][];
            long[] jArr = new long[1];
            int[] iArr = new int[1];
            T[] tArr = new Object[1];
            this.f28080b.lock();
            try {
                final g gVar2 = gVar;
                final int[] iArr2 = iArr;
                final T[] tArr2 = tArr;
                final long[] jArr2 = jArr;
                final byte[][] bArr2 = bArr;
                p.a(this.f28089k.getAbsolutePath(), true, com.sumsub.sns.internal.ml.autocapture.a.f34923p, 50, new o() {
                    public boolean a(FileLocker fileLocker) {
                        c a11;
                        try {
                            if (!(i.this.i() || (a11 = i.this.f28091m.a(gVar2)) == null || a11.f28070b == null)) {
                                if (a11.a()) {
                                    i.this.a(gVar2, false);
                                    iArr2[0] = 2;
                                } else {
                                    iArr2[0] = 4;
                                    tArr2[0] = a11.f28070b;
                                }
                            }
                            a aVar = (a) i.this.f28086h.get(gVar2);
                            if (aVar == null) {
                                iArr2[0] = 1;
                            } else if (aVar.e()) {
                                i.this.d(aVar);
                                iArr2[0] = 2;
                            } else {
                                jArr2[0] = aVar.f28114f;
                                bArr2[0] = i.this.f(aVar);
                                iArr2[0] = 3;
                            }
                        } catch (Throwable th2) {
                            MobPersistence.b(th2, i.this.f28088j);
                        }
                        return false;
                    }
                });
                this.f28080b.unlock();
                if (iArr[0] == 4) {
                    return tArr[0];
                }
                if (iArr[0] == 3) {
                    Object a11 = this.f28090l.a(bArr[0], (Object) null);
                    if (a11 instanceof KVEntry) {
                        KVEntry kVEntry = (KVEntry) a11;
                        aVar = new a(kVEntry.getKey(), kVEntry.getValue());
                    } else {
                        aVar = a.a((HashMap<Byte, Object>) (HashMap) a11);
                    }
                    if (aVar != null) {
                        T a12 = eVar.a(aVar.a());
                        this.f28091m.a(gVar, new c(Long.valueOf(jArr[0]).longValue(), a12));
                        return a12;
                    }
                    throw new NoValidDataException();
                }
                throw new NoValidDataException();
            } catch (Throwable th2) {
                this.f28080b.unlock();
                throw th2;
            }
        }

        public boolean a(final g gVar, boolean z11) {
            this.f28080b.lock();
            final boolean[] zArr = new boolean[1];
            if (z11) {
                try {
                    p.a(this.f28089k.getAbsolutePath(), true, com.sumsub.sns.internal.ml.autocapture.a.f34923p, 50, new o() {
                        public boolean a(FileLocker fileLocker) {
                            zArr[0] = i.this.b(gVar);
                            return false;
                        }
                    });
                } catch (Throwable th2) {
                    this.f28080b.unlock();
                    throw th2;
                }
            } else {
                zArr[0] = b(gVar);
            }
            this.f28080b.unlock();
            return zArr[0];
        }
    }

    public static class j {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f28116a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Object f28117b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f28118c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f28119d;

        public j(String str, Object obj, long j11) {
            this.f28116a = str;
            this.f28117b = obj;
            this.f28118c = j11;
        }

        /* access modifiers changed from: private */
        public byte[] f() {
            return this.f28119d;
        }

        public Object b() {
            return this.f28117b;
        }

        public Object c() {
            return this.f28117b;
        }

        public long d() {
            return this.f28118c;
        }

        public boolean e() {
            if (d() != 0 && d() <= System.currentTimeMillis()) {
                return true;
            }
            return false;
        }

        public String a() {
            return this.f28116a;
        }

        /* access modifiers changed from: private */
        public void a(byte[] bArr) {
            this.f28119d = bArr;
        }
    }

    public MobPersistence(Context context, final String str, String str2) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f28059d = reentrantReadWriteLock;
        this.f28060e = reentrantReadWriteLock.writeLock();
        this.f28061f = reentrantReadWriteLock.readLock();
        f fVar = new f(str2);
        this.f28062g = fVar;
        this.f28056a = new i(context, str, fVar);
        if (str != null && str.startsWith(InstructionFileId.DOT) && str.length() > 1) {
            str = str.substring(1);
        }
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, z.f27383b + "MP-" + str);
            }
        });
        this.f28057b = newSingleThreadScheduledExecutor;
        newSingleThreadScheduledExecutor.schedule(new d(), 3000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: private */
    public static void c(String str, String str2) {
        a(str, true, str2);
    }

    /* access modifiers changed from: private */
    public static void d(String str, String str2) {
        a(str, false, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b1 A[Catch:{ all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00db A[Catch:{ all -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011a A[Catch:{ all -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0168 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.HashMap<java.lang.String, java.lang.Object> b() {
        /*
            r12 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r12.f28061f
            r1.lock()
            java.util.Map<java.lang.String, com.mob.tools.utils.MobPersistence$j> r1 = r12.f28058c     // Catch:{ all -> 0x0046 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x0040
            java.util.Map<java.lang.String, com.mob.tools.utils.MobPersistence$j> r1 = r12.f28058c     // Catch:{ all -> 0x0046 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x0046 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0046 }
        L_0x001c:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0046 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0046 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0046 }
            com.mob.tools.utils.MobPersistence$j r2 = (com.mob.tools.utils.MobPersistence.j) r2     // Catch:{ all -> 0x0046 }
            boolean r3 = r2.e()     // Catch:{ all -> 0x0046 }
            if (r3 != 0) goto L_0x001c
            java.lang.String r3 = r2.a()     // Catch:{ all -> 0x0046 }
            java.lang.Object r2 = r2.b()     // Catch:{ all -> 0x0046 }
            r0.put(r3, r2)     // Catch:{ all -> 0x0046 }
            goto L_0x001c
        L_0x0040:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r12.f28061f
            r1.unlock()
            goto L_0x0051
        L_0x0046:
            r1 = move-exception
            com.mob.tools.utils.MobPersistence$i r2 = r12.f28056a     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = r2.f28088j     // Catch:{ all -> 0x0196 }
            b((java.lang.Throwable) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0196 }
            goto L_0x0040
        L_0x0051:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            com.mob.tools.utils.MobPersistence$i r3 = r12.f28056a
            java.util.List r3 = r3.e()
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x0171
            java.util.Iterator r3 = r3.iterator()
        L_0x006b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0171
            java.lang.Object r4 = r3.next()
            byte[] r4 = (byte[]) r4
            com.mob.tools.utils.MobPersistence$f r5 = r12.f28062g
            r6 = 0
            java.lang.Object r4 = r5.a((byte[]) r4, (java.lang.Object) r6)
            boolean r5 = r4 instanceof com.mob.tools.utils.MobPersistence.KVEntry
            if (r5 == 0) goto L_0x0092
            com.mob.tools.utils.MobPersistence$KVEntry r4 = (com.mob.tools.utils.MobPersistence.KVEntry) r4
            com.mob.tools.utils.MobPersistence$a r5 = new com.mob.tools.utils.MobPersistence$a
            java.lang.String r7 = r4.getKey()
            java.lang.Object r4 = r4.getValue()
            r5.<init>(r7, r4)
            goto L_0x0098
        L_0x0092:
            java.util.HashMap r4 = (java.util.HashMap) r4
            com.mob.tools.utils.MobPersistence$a r5 = com.mob.tools.utils.MobPersistence.a.a((java.util.HashMap<java.lang.Byte, java.lang.Object>) r4)
        L_0x0098:
            java.lang.Object r4 = r5.a()
            if (r4 == 0) goto L_0x00a6
            r7 = r4
            com.mob.tools.utils.MobPersistence$b r7 = (com.mob.tools.utils.MobPersistence.b) r7     // Catch:{ all -> 0x00a6 }
            android.os.Parcelable r7 = r7.a(r6)     // Catch:{ all -> 0x00a6 }
            goto L_0x00a7
        L_0x00a6:
            r7 = r6
        L_0x00a7:
            if (r4 == 0) goto L_0x00ce
            if (r7 != 0) goto L_0x00ce
            r8 = r4
            com.mob.tools.utils.MobPersistence$b[] r8 = (com.mob.tools.utils.MobPersistence.b[]) r8     // Catch:{ all -> 0x00ce }
            int r9 = r8.length     // Catch:{ all -> 0x00ce }
            if (r9 <= 0) goto L_0x00ce
            r9 = 0
            r10 = r8[r9]     // Catch:{ all -> 0x00ce }
            java.lang.Class r10 = r10.a()     // Catch:{ all -> 0x00ce }
            int r11 = r8.length     // Catch:{ all -> 0x00ce }
            java.lang.Object r10 = java.lang.reflect.Array.newInstance(r10, r11)     // Catch:{ all -> 0x00ce }
            android.os.Parcelable[] r10 = (android.os.Parcelable[]) r10     // Catch:{ all -> 0x00ce }
        L_0x00bf:
            int r11 = r10.length     // Catch:{ all -> 0x00ce }
            if (r9 >= r11) goto L_0x00cd
            r11 = r8[r9]     // Catch:{ all -> 0x00ce }
            android.os.Parcelable r11 = r11.a(r6)     // Catch:{ all -> 0x00ce }
            r10[r9] = r11     // Catch:{ all -> 0x00ce }
            int r9 = r9 + 1
            goto L_0x00bf
        L_0x00cd:
            r7 = r10
        L_0x00ce:
            if (r4 == 0) goto L_0x010d
            if (r7 != 0) goto L_0x010d
            r8 = r4
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x010d }
            boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x010d }
            if (r9 != 0) goto L_0x010d
            boolean r9 = r8 instanceof java.util.ArrayList     // Catch:{ all -> 0x010d }
            if (r9 == 0) goto L_0x00e5
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x010d }
            r9.<init>()     // Catch:{ all -> 0x010d }
            goto L_0x00f4
        L_0x00e5:
            boolean r9 = r8 instanceof java.util.LinkedList     // Catch:{ all -> 0x010d }
            if (r9 == 0) goto L_0x00ef
            java.util.LinkedList r9 = new java.util.LinkedList     // Catch:{ all -> 0x010d }
            r9.<init>()     // Catch:{ all -> 0x010d }
            goto L_0x00f4
        L_0x00ef:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x010d }
            r9.<init>()     // Catch:{ all -> 0x010d }
        L_0x00f4:
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x010d }
        L_0x00f8:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x010d }
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x010d }
            com.mob.tools.utils.MobPersistence$b r10 = (com.mob.tools.utils.MobPersistence.b) r10     // Catch:{ all -> 0x010d }
            android.os.Parcelable r10 = r10.a(r6)     // Catch:{ all -> 0x010d }
            r9.add(r10)     // Catch:{ all -> 0x010d }
            goto L_0x00f8
        L_0x010c:
            r7 = r9
        L_0x010d:
            if (r4 == 0) goto L_0x0164
            if (r7 != 0) goto L_0x0164
            r8 = r4
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ all -> 0x0164 }
            boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x0164 }
            if (r9 != 0) goto L_0x0164
            boolean r9 = r8 instanceof java.util.HashMap     // Catch:{ all -> 0x0164 }
            if (r9 == 0) goto L_0x0124
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x0164 }
            r9.<init>()     // Catch:{ all -> 0x0164 }
            goto L_0x013d
        L_0x0124:
            boolean r9 = r8 instanceof java.util.Hashtable     // Catch:{ all -> 0x0164 }
            if (r9 == 0) goto L_0x012e
            java.util.Hashtable r9 = new java.util.Hashtable     // Catch:{ all -> 0x0164 }
            r9.<init>()     // Catch:{ all -> 0x0164 }
            goto L_0x013d
        L_0x012e:
            boolean r9 = r8 instanceof java.util.TreeMap     // Catch:{ all -> 0x0164 }
            if (r9 == 0) goto L_0x0138
            java.util.TreeMap r9 = new java.util.TreeMap     // Catch:{ all -> 0x0164 }
            r9.<init>()     // Catch:{ all -> 0x0164 }
            goto L_0x013d
        L_0x0138:
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x0164 }
            r9.<init>()     // Catch:{ all -> 0x0164 }
        L_0x013d:
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x0164 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0164 }
        L_0x0145:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x0164 }
            if (r10 == 0) goto L_0x0163
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x0164 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0164 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ all -> 0x0164 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0164 }
            com.mob.tools.utils.MobPersistence$b r10 = (com.mob.tools.utils.MobPersistence.b) r10     // Catch:{ all -> 0x0164 }
            android.os.Parcelable r10 = r10.a(r6)     // Catch:{ all -> 0x0164 }
            r9.put(r11, r10)     // Catch:{ all -> 0x0164 }
            goto L_0x0145
        L_0x0163:
            r7 = r9
        L_0x0164:
            if (r7 != 0) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r4 = r7
        L_0x0168:
            java.lang.String r5 = r5.f28065a
            r2.put(r5, r4)
            goto L_0x006b
        L_0x0171:
            r1.putAll(r2)
            r1.putAll(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "GetA done: "
            r0.append(r2)
            int r2 = r1.size()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mob.tools.utils.MobPersistence$i r2 = r12.f28056a
            java.lang.String r2 = r2.f28088j
            d(r0, r2)
            return r1
        L_0x0196:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r12.f28061f
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.MobPersistence.b():java.util.HashMap");
    }

    public static synchronized boolean a(Context context, String str) {
        boolean z11;
        synchronized (MobPersistence.class) {
            File file = new File(a(context), str);
            z11 = file.exists() && file.length() > 0;
        }
        return z11;
    }

    public static synchronized File a(Context context) {
        File file;
        synchronized (MobPersistence.class) {
            file = new File(context.getFilesDir(), l.a("0077idelgghmQg)ekgj"));
        }
        return file;
    }

    public void a(j jVar) {
        if (jVar != null) {
            String a11 = jVar.a();
            long d11 = jVar.d();
            if (TextUtils.isEmpty(a11) || d11 < 0) {
                throw new IllegalArgumentException("Key: " + a11 + ", expAt: " + d11);
            }
            jVar.a(Data.rawMD5(a11));
            this.f28060e.lock();
            try {
                this.f28058c.put(a11, jVar);
            } catch (Throwable th2) {
                this.f28060e.unlock();
                throw th2;
            }
            this.f28060e.unlock();
            return;
        }
        throw new IllegalArgumentException("dataEntry is null");
    }

    public boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            byte[] rawMD5 = Data.rawMD5(str);
            boolean[] zArr = {false};
            String[] strArr = {com.huawei.secure.android.common.ssl.util.f.f38658a};
            this.f28060e.lock();
            try {
                if (!this.f28058c.isEmpty() && this.f28058c.containsKey(str)) {
                    this.f28058c.remove(str);
                    zArr[0] = true;
                    strArr[0] = "m";
                }
            } catch (Throwable th2) {
                this.f28060e.unlock();
                throw th2;
            }
            this.f28060e.unlock();
            zArr[0] = this.f28056a.a(new g(rawMD5), true);
            d("rmv: " + str + ", from: " + strArr[0] + ", succ is " + zArr[0], this.f28056a.f28088j);
            return zArr[0];
        }
        throw new IllegalArgumentException("Key: " + str);
    }

    public boolean a() {
        d("cln", this.f28056a.f28088j);
        this.f28060e.lock();
        try {
            if (!this.f28058c.isEmpty()) {
                this.f28058c.clear();
            }
        } catch (Throwable th2) {
            this.f28060e.unlock();
            throw th2;
        }
        this.f28060e.unlock();
        return this.f28056a.d();
    }

    public <T> T a(e<T> eVar) throws NoValidDataException {
        if (eVar != null) {
            String a11 = eVar.a();
            if (!TextUtils.isEmpty(a11)) {
                this.f28061f.lock();
                try {
                    if (!this.f28058c.isEmpty() && this.f28058c.containsKey(a11)) {
                        j jVar = this.f28058c.get(a11);
                        if (!jVar.e()) {
                            T b11 = jVar.b();
                            this.f28061f.unlock();
                            return b11;
                        }
                        this.f28058c.remove(a11);
                        d("Get done, exp-m: " + a11, this.f28056a.f28088j);
                        throw new NoValidDataException();
                    }
                } catch (NoValidDataException e11) {
                    throw e11;
                } catch (Throwable th2) {
                    this.f28061f.unlock();
                    throw th2;
                }
                this.f28061f.unlock();
                try {
                    return this.f28056a.a(new g(Data.rawMD5(a11)), eVar);
                } catch (Throwable unused) {
                    throw new NoValidDataException();
                }
            } else {
                throw new IllegalArgumentException("Key: " + a11);
            }
        } else {
            throw new IllegalArgumentException("deserializer is null");
        }
    }

    /* access modifiers changed from: private */
    public static void b(Throwable th2, String str) {
        a(th2, true, str);
    }

    private static void a(Throwable th2, boolean z11, String str) {
        if (z11) {
            String str2 = "[MPF][" + f28055h + "]";
            if (str != null) {
                str2 = str2 + "[" + str + "]";
            }
            MobLog.getInstance().d(th2, str2, new Object[0]);
        }
    }

    private static void a(String str, boolean z11, String str2) {
        if (z11) {
            String str3 = "[MPF][" + f28055h + "]";
            if (str2 != null) {
                str3 = str3 + "[" + str2 + "]";
            }
            MobLog.getInstance().d(str3 + str, new Object[0]);
        }
    }
}
