package com.tencent.thumbplayer.tcmedia.core.common;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class TPLoadLibFromApk {
    /* access modifiers changed from: private */
    public static Context mContext = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap<>();

    public static class LibraryBrokenHandler implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler mParent;

        public LibraryBrokenHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0027  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void uncaughtException(java.lang.Thread r5, java.lang.Throwable r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof java.lang.UnsatisfiedLinkError
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x0019
                boolean r0 = r6 instanceof java.lang.NoSuchMethodError
                if (r0 == 0) goto L_0x0017
                java.lang.String r0 = r6.getMessage()
                java.lang.String r3 = ".*sig(nature)?[=:].*"
                boolean r0 = r0.matches(r3)
                if (r0 == 0) goto L_0x0017
                goto L_0x0019
            L_0x0017:
                r0 = r2
                goto L_0x001a
            L_0x0019:
                r0 = r1
            L_0x001a:
                if (r0 == 0) goto L_0x0024
                android.content.Context r0 = com.tencent.thumbplayer.tcmedia.core.common.TPLoadLibFromApk.mContext     // Catch:{ Exception -> 0x0024 }
                com.tencent.thumbplayer.tcmedia.core.common.TPLoadLibFromApk.extractAllLibraries(r0)     // Catch:{ Exception -> 0x0024 }
                goto L_0x0025
            L_0x0024:
                r1 = r2
            L_0x0025:
                if (r1 == 0) goto L_0x0032
                java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError
                java.lang.String r1 = "Invalid so detected and recovered."
                r0.<init>(r1)
                java.lang.Throwable r6 = r0.initCause(r6)
            L_0x0032:
                java.lang.Thread$UncaughtExceptionHandler r0 = r4.mParent
                r0.uncaughtException(r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPLoadLibFromApk.LibraryBrokenHandler.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }

    private TPLoadLibFromApk() {
    }

    /* access modifiers changed from: private */
    public static void extractAllLibraries(Context context) {
        if (context != null) {
            List<String> generateAbiList = generateAbiList();
            File dir = context.getDir("recover_lib", 0);
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            try {
                HashSet hashSet = new HashSet();
                Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    String name = zipEntry.getName();
                    if (!TextUtils.isEmpty(name)) {
                        if (name.contains("../")) {
                            throw new Exception("contain ../, throw err");
                        }
                    }
                    Matcher matcher = compile.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        if (!hashSet.contains(group)) {
                            extractLibrary(zipFile, group, generateAbiList, new File(dir, "lib" + group + ".so"));
                            hashSet.add(group);
                        }
                    }
                }
            } finally {
                zipFile.close();
            }
        }
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        if (file.isFile()) {
            return true;
        }
        Iterator<String> it2 = list.iterator();
        if (!it2.hasNext()) {
            return false;
        }
        ZipEntry entry = zipFile.getEntry("lib/" + it2.next() + "/lib" + str + ".so");
        if (entry == null) {
            return false;
        }
        String name = entry.getName();
        if (!TextUtils.isEmpty(name) && name.contains("../")) {
            return false;
        }
        InputStream inputStream = zipFile.getInputStream(entry);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[2048];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 2048);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        file.setReadOnly();
                        return true;
                    } catch (Throwable unused) {
                        return false;
                    }
                }
            } finally {
                inputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static String find(String str, Context context) {
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            ClassLoader classLoader = TPLoadLibFromApk.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception unused) {
        }
        if (str2 != null) {
            return str2;
        }
        File dir = context.getDir("recover_lib", 0);
        File file = new File(dir, "lib" + str + ".so");
        return file.canRead() ? file.getAbsolutePath() : str2;
    }

    private static List<String> generateAbiList() {
        ArrayList arrayList = new ArrayList(3);
        Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
        String str = (String) method.invoke((Object) null, new Object[]{"ro.product.cpu.abi"});
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        String str2 = (String) method.invoke((Object) null, new Object[]{"ro.product.cpu.abi2"});
        if (str2 != null && str2.length() > 0) {
            arrayList.add(str2);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r7 != null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(2, "context is null,load by System.loadLibrary,name= ".concat(r5));
        reflectSystemLoadLibrary(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1.put(r5, new java.lang.ref.WeakReference(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0068, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007a, code lost:
        throw ((java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(r5)).initCause(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x007b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        throw ((java.lang.UnsatisfiedLinkError) new java.lang.UnsatisfiedLinkError("Failed loading library: ".concat(r5)).initCause(r6.getCause()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0092, code lost:
        r0 = r7.getDir("recover_lib", 0);
        r1 = new java.io.File(r0, "lib" + r5 + ".so");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r0 = loadFromRecovery(r5, r6, r7, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b4, code lost:
        if (r0 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b6, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00bb, code lost:
        return loadFromApk(r5, r6, r7, r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean load(java.lang.String r5, java.lang.ClassLoader r6, android.content.Context r7) {
        /*
            r0 = 0
            if (r5 == 0) goto L_0x00c3
            int r1 = r5.length()
            if (r1 == 0) goto L_0x00c3
            if (r6 != 0) goto L_0x000d
            goto L_0x00c3
        L_0x000d:
            mContext = r7
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<java.lang.ClassLoader>> r1 = mLoadedLibs
            monitor-enter(r1)
            r2 = 0
            java.lang.Object r3 = r1.get(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x00c0 }
            if (r3 == 0) goto L_0x0021
            java.lang.Object r2 = r3.get()     // Catch:{ all -> 0x00c0 }
            java.lang.ClassLoader r2 = (java.lang.ClassLoader) r2     // Catch:{ all -> 0x00c0 }
        L_0x0021:
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004b
            if (r2 != r6) goto L_0x0032
            java.lang.String r6 = "callerClassLoader has already load ! name="
            java.lang.String r5 = r6.concat(r5)     // Catch:{ all -> 0x00c0 }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r3, r5)     // Catch:{ all -> 0x00c0 }
            monitor-exit(r1)     // Catch:{ all -> 0x00c0 }
            return r4
        L_0x0032:
            java.lang.UnsatisfiedLinkError r6 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x00c0 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            java.lang.String r0 = "Library '"
            r7.<init>(r0)     // Catch:{ all -> 0x00c0 }
            r7.append(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = "' was loaded by a different ClassLoader."
            r7.append(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x00c0 }
            r6.<init>(r5)     // Catch:{ all -> 0x00c0 }
            throw r6     // Catch:{ all -> 0x00c0 }
        L_0x004b:
            monitor-exit(r1)     // Catch:{ all -> 0x00c0 }
            if (r7 != 0) goto L_0x0092
            java.lang.String r7 = "context is null,load by System.loadLibrary,name= "
            java.lang.String r7 = r7.concat(r5)     // Catch:{ InvocationTargetException -> 0x007b, Exception -> 0x0068 }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r3, r7)     // Catch:{ InvocationTargetException -> 0x007b, Exception -> 0x0068 }
            reflectSystemLoadLibrary(r5, r6)     // Catch:{ InvocationTargetException -> 0x007b, Exception -> 0x0068 }
            monitor-enter(r1)     // Catch:{ InvocationTargetException -> 0x007b, Exception -> 0x0068 }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0065 }
            r7.<init>(r6)     // Catch:{ all -> 0x0065 }
            r1.put(r5, r7)     // Catch:{ all -> 0x0065 }
            monitor-exit(r1)     // Catch:{ all -> 0x0065 }
            return r4
        L_0x0065:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0065 }
            throw r6     // Catch:{ InvocationTargetException -> 0x007b, Exception -> 0x0068 }
        L_0x0068:
            r6 = move-exception
            java.lang.UnsatisfiedLinkError r7 = new java.lang.UnsatisfiedLinkError
            java.lang.String r0 = "Failed loading library: "
            java.lang.String r5 = r0.concat(r5)
            r7.<init>(r5)
            java.lang.Throwable r5 = r7.initCause(r6)
            java.lang.UnsatisfiedLinkError r5 = (java.lang.UnsatisfiedLinkError) r5
            throw r5
        L_0x007b:
            r6 = move-exception
            java.lang.UnsatisfiedLinkError r7 = new java.lang.UnsatisfiedLinkError
            java.lang.String r0 = "Failed loading library: "
            java.lang.String r5 = r0.concat(r5)
            r7.<init>(r5)
            java.lang.Throwable r5 = r6.getCause()
            java.lang.Throwable r5 = r7.initCause(r5)
            java.lang.UnsatisfiedLinkError r5 = (java.lang.UnsatisfiedLinkError) r5
            throw r5
        L_0x0092:
            java.lang.String r1 = "recover_lib"
            java.io.File r0 = r7.getDir(r1, r0)
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "lib"
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r3 = ".so"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r0, r2)
            java.lang.UnsatisfiedLinkError r0 = loadFromRecovery(r5, r6, r7, r1)     // Catch:{ all -> 0x00be }
            if (r0 != 0) goto L_0x00b7
            return r4
        L_0x00b7:
            boolean r5 = loadFromApk(r5, r6, r7, r1, r0)     // Catch:{ all -> 0x00bc }
            return r5
        L_0x00bc:
            r5 = move-exception
            throw r5
        L_0x00be:
            r5 = move-exception
            throw r5
        L_0x00c0:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00c0 }
            throw r5
        L_0x00c3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPLoadLibFromApk.load(java.lang.String, java.lang.ClassLoader, android.content.Context):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b3 A[SYNTHETIC, Splitter:B:45:0x00b3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadFromApk(java.lang.String r4, java.lang.ClassLoader r5, android.content.Context r6, java.io.File r7, java.lang.UnsatisfiedLinkError r8) {
        /*
            r0 = 0
            r1 = 0
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo()     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r6 = r6.sourceDir     // Catch:{ Exception -> 0x00a2 }
            java.util.zip.ZipFile r2 = new java.util.zip.ZipFile     // Catch:{ Exception -> 0x00a2 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00a2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            java.lang.String r3 = "unzip apk,name= "
            r1.<init>(r3)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            r1.append(r4)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            java.lang.String r3 = "apkPath="
            r1.append(r3)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            r1.append(r6)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            java.lang.String r6 = r1.toString()     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            r1 = 2
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r6)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            java.util.List r6 = generateAbiList()     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            boolean r6 = extractLibrary(r2, r4, r6, r7)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            if (r6 == 0) goto L_0x008a
            r2.close()     // Catch:{ IOException -> 0x0089 }
            java.lang.String r6 = "load from unzip apk,name= "
            java.lang.String r0 = java.lang.String.valueOf(r4)     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            java.lang.String r6 = r6.concat(r0)     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r1, r6)     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            java.lang.String r6 = r7.getAbsolutePath()     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            reflectSystemLoad(r6, r5)     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<java.lang.ClassLoader>> r6 = mLoadedLibs     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            monitor-enter(r6)     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0056 }
            r7.<init>(r5)     // Catch:{ all -> 0x0056 }
            r6.put(r4, r7)     // Catch:{ all -> 0x0056 }
            monitor-exit(r6)     // Catch:{ all -> 0x0056 }
            r4 = 1
            return r4
        L_0x0056:
            r5 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0056 }
            throw r5     // Catch:{ InvocationTargetException -> 0x006b, Exception -> 0x0059 }
        L_0x0059:
            r4 = move-exception
            if (r8 != 0) goto L_0x006a
            java.lang.UnsatisfiedLinkError r5 = new java.lang.UnsatisfiedLinkError
            java.lang.String r6 = "Failed recovering native library."
            r5.<init>(r6)
            java.lang.Throwable r4 = r5.initCause(r4)
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4
            throw r4
        L_0x006a:
            throw r8
        L_0x006b:
            r5 = move-exception
            if (r8 != 0) goto L_0x0088
            java.lang.UnsatisfiedLinkError r6 = new java.lang.UnsatisfiedLinkError
            java.lang.String r7 = "Failed recovering native library: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r7.concat(r4)
            r6.<init>(r4)
            java.lang.Throwable r4 = r5.getCause()
            java.lang.Throwable r4 = r6.initCause(r4)
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4
            throw r4
        L_0x0088:
            throw r8
        L_0x0089:
            return r0
        L_0x008a:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            java.lang.String r6 = "Can't find recover library: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            java.lang.String r4 = r6.concat(r4)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            r5.<init>(r4)     // Catch:{ Exception -> 0x009d, all -> 0x009a }
            throw r5     // Catch:{ Exception -> 0x009d, all -> 0x009a }
        L_0x009a:
            r4 = move-exception
            r1 = r2
            goto L_0x00b1
        L_0x009d:
            r4 = move-exception
            r1 = r2
            goto L_0x00a3
        L_0x00a0:
            r4 = move-exception
            goto L_0x00b1
        L_0x00a2:
            r4 = move-exception
        L_0x00a3:
            java.lang.UnsatisfiedLinkError r5 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x00a0 }
            java.lang.String r6 = "Failed recovering native library."
            r5.<init>(r6)     // Catch:{ all -> 0x00a0 }
            java.lang.Throwable r4 = r5.initCause(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4     // Catch:{ all -> 0x00a0 }
            throw r4     // Catch:{ all -> 0x00a0 }
        L_0x00b1:
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ IOException -> 0x00b7 }
            goto L_0x00b8
        L_0x00b7:
            return r0
        L_0x00b8:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPLoadLibFromApk.loadFromApk(java.lang.String, java.lang.ClassLoader, android.content.Context, java.io.File, java.lang.UnsatisfiedLinkError):boolean");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    private static java.lang.UnsatisfiedLinkError loadFromRecovery(java.lang.String r4, java.lang.ClassLoader r5, android.content.Context r6, java.io.File r7) {
        /*
            boolean r6 = r7.isFile()
            r0 = 2
            r1 = 0
            if (r6 == 0) goto L_0x008b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            java.lang.String r2 = "load by recover_lib,name= "
            r6.<init>(r2)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            r6.append(r4)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            java.lang.String r2 = "recoverfile="
            r6.append(r2)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            r6.append(r7)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            java.lang.String r6 = r6.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r0, r6)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            java.lang.String r6 = r7.getAbsolutePath()     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            reflectSystemLoad(r6, r5)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<java.lang.ClassLoader>> r6 = mLoadedLibs     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            monitor-enter(r6)     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0035 }
            r2.<init>(r5)     // Catch:{ all -> 0x0035 }
            r6.put(r4, r2)     // Catch:{ all -> 0x0035 }
            monitor-exit(r6)     // Catch:{ all -> 0x0035 }
            return r1
        L_0x0035:
            r2 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0035 }
            throw r2     // Catch:{ UnsatisfiedLinkError -> 0x0079, InvocationTargetException -> 0x004f, all -> 0x0038 }
        L_0x0038:
            r5 = move-exception
            java.lang.UnsatisfiedLinkError r6 = new java.lang.UnsatisfiedLinkError
            java.lang.String r7 = "Failed recovering native library: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r7.concat(r4)
            r6.<init>(r4)
            java.lang.Throwable r4 = r6.initCause(r5)
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4
            throw r4
        L_0x004f:
            r6 = move-exception
            java.lang.Throwable r2 = r6.getCause()
            boolean r2 = r2 instanceof java.lang.UnsatisfiedLinkError
            if (r2 == 0) goto L_0x005f
            java.lang.Throwable r6 = r6.getCause()
            java.lang.UnsatisfiedLinkError r6 = (java.lang.UnsatisfiedLinkError) r6
            goto L_0x007a
        L_0x005f:
            java.lang.UnsatisfiedLinkError r5 = new java.lang.UnsatisfiedLinkError
            java.lang.String r7 = "Failed recovering native library: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r7.concat(r4)
            r5.<init>(r4)
            java.lang.Throwable r4 = r6.getCause()
            java.lang.Throwable r4 = r5.initCause(r4)
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4
            throw r4
        L_0x0079:
            r6 = move-exception
        L_0x007a:
            java.lang.String r2 = "load by recover_lib failed!,name= "
            java.lang.String r3 = java.lang.String.valueOf(r4)
            java.lang.String r2 = r2.concat(r3)
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r0, r2)
            r7.delete()
            goto L_0x008c
        L_0x008b:
            r6 = r1
        L_0x008c:
            reflectSystemLoadLibrary(r4, r5)     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
            java.lang.String r7 = "load by reflectSystemLoadLibrary,name= "
            java.lang.String r2 = java.lang.String.valueOf(r4)     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
            java.lang.String r7 = r7.concat(r2)     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
            com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog.printLog(r0, r7)     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
            java.util.HashMap<java.lang.String, java.lang.ref.WeakReference<java.lang.ClassLoader>> r7 = mLoadedLibs     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
            monitor-enter(r7)     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x00a9 }
            r0.<init>(r5)     // Catch:{ all -> 0x00a9 }
            r7.put(r4, r0)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r7)     // Catch:{ all -> 0x00a9 }
            return r1
        L_0x00a9:
            r5 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00a9 }
            throw r5     // Catch:{ UnsatisfiedLinkError -> 0x00f0, InvocationTargetException -> 0x00c3, all -> 0x00ac }
        L_0x00ac:
            r5 = move-exception
            java.lang.UnsatisfiedLinkError r6 = new java.lang.UnsatisfiedLinkError
            java.lang.String r7 = "Failed recovering native library: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r7.concat(r4)
            r6.<init>(r4)
            java.lang.Throwable r4 = r6.initCause(r5)
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4
            throw r4
        L_0x00c3:
            r5 = move-exception
            java.lang.Throwable r7 = r5.getCause()
            boolean r7 = r7 instanceof java.lang.UnsatisfiedLinkError
            if (r7 == 0) goto L_0x00d6
            if (r6 != 0) goto L_0x00f4
            java.lang.Throwable r4 = r5.getCause()
            r6 = r4
            java.lang.UnsatisfiedLinkError r6 = (java.lang.UnsatisfiedLinkError) r6
            goto L_0x00f4
        L_0x00d6:
            java.lang.UnsatisfiedLinkError r6 = new java.lang.UnsatisfiedLinkError
            java.lang.String r7 = "Failed recovering native library: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r4 = r7.concat(r4)
            r6.<init>(r4)
            java.lang.Throwable r4 = r5.getCause()
            java.lang.Throwable r4 = r6.initCause(r4)
            java.lang.UnsatisfiedLinkError r4 = (java.lang.UnsatisfiedLinkError) r4
            throw r4
        L_0x00f0:
            r4 = move-exception
            if (r6 != 0) goto L_0x00f4
            r6 = r4
        L_0x00f4:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.common.TPLoadLibFromApk.loadFromRecovery(java.lang.String, java.lang.ClassLoader, android.content.Context, java.io.File):java.lang.UnsatisfiedLinkError");
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static void reflectSystemLoadLibrary(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new LibraryBrokenHandler(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
