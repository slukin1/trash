package com.tencent.thumbplayer.tcmedia.core.thirdparties;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import com.tencent.thumbplayer.tcmedia.core.utils.TPThreadPool;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public class LocalCache {
    private static final int MAX_COUNT = Integer.MAX_VALUE;
    private static final int MAX_SIZE = 50000000;
    public static final int TIME_DAY = 86400;
    public static final int TIME_HOUR = 3600;
    private static Map<String, LocalCache> mInstanceMap = new HashMap();
    private ACacheManager mCache;

    public class ACacheManager {
        /* access modifiers changed from: private */
        public final AtomicInteger cacheCount;
        public File cacheDir;
        /* access modifiers changed from: private */
        public final AtomicLong cacheSize;
        private final int countLimit;
        /* access modifiers changed from: private */
        public final Map<File, Long> lastUsageDates;
        private final long sizeLimit;

        private ACacheManager(File file, long j11, int i11) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j11;
            this.countLimit = i11;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            calculateCacheSizeAndCacheCount();
        }

        private void calculateCacheSizeAndCacheCount() {
            TPThreadPool.getInstance().obtainThreadExecutor().execute(new Runnable() {
                public void run() {
                    File[] listFiles = ACacheManager.this.cacheDir.listFiles();
                    if (listFiles != null) {
                        int i11 = 0;
                        int i12 = 0;
                        for (File file : listFiles) {
                            i11 = (int) (((long) i11) + ACacheManager.this.calculateSize(file));
                            i12++;
                            ACacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                        }
                        ACacheManager.this.cacheSize.set((long) i11);
                        ACacheManager.this.cacheCount.set(i12);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public long calculateSize(File file) {
            if (file == null) {
                return 0;
            }
            return file.length();
        }

        /* access modifiers changed from: private */
        public void clear() {
            this.lastUsageDates.clear();
            this.cacheSize.set(0);
            File[] listFiles = this.cacheDir.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        /* access modifiers changed from: private */
        public File get(String str) {
            File newFile = newFile(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            newFile.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(newFile, valueOf);
            return newFile;
        }

        /* access modifiers changed from: private */
        public File newFile(String str) {
            File file = this.cacheDir;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.hashCode());
            return new File(file, sb2.toString());
        }

        /* access modifiers changed from: private */
        public void put(File file) {
            int i11 = this.cacheCount.get();
            while (i11 + 1 > this.countLimit) {
                this.cacheSize.addAndGet(-removeNext());
                i11 = this.cacheCount.addAndGet(-1);
            }
            this.cacheCount.addAndGet(1);
            long calculateSize = calculateSize(file);
            long j11 = this.cacheSize.get();
            while (j11 + calculateSize > this.sizeLimit) {
                j11 = this.cacheSize.addAndGet(-removeNext());
            }
            this.cacheSize.addAndGet(calculateSize);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(file, valueOf);
        }

        /* access modifiers changed from: private */
        public boolean remove(String str) {
            return get(str).delete();
        }

        private long removeNext() {
            File file;
            if (this.lastUsageDates.isEmpty()) {
                return 0;
            }
            Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                file = null;
                Long l11 = null;
                for (Map.Entry next : entrySet) {
                    if (file == null) {
                        file = (File) next.getKey();
                        l11 = (Long) next.getValue();
                    } else {
                        Long l12 = (Long) next.getValue();
                        if (l12.longValue() < l11.longValue()) {
                            file = (File) next.getKey();
                            l11 = l12;
                        }
                    }
                }
            }
            if (file == null) {
                return 0;
            }
            long calculateSize = calculateSize(file);
            if (file.delete()) {
                this.lastUsageDates.remove(file);
            }
            return calculateSize;
        }
    }

    public static class Utils {
        private static final char mSeparator = ' ';

        private Utils() {
        }

        /* access modifiers changed from: private */
        public static byte[] Bitmap2Bytes(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        /* access modifiers changed from: private */
        public static Bitmap Bytes2Bimap(byte[] bArr) {
            int length = bArr.length;
            return null;
        }

        /* access modifiers changed from: private */
        public static Drawable bitmap2Drawable(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            return new BitmapDrawable(bitmap);
        }

        /* access modifiers changed from: private */
        public static String clearDateInfo(String str) {
            return (str == null || !hasDateInfo(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        /* access modifiers changed from: private */
        public static byte[] clearDateInfo(byte[] bArr) {
            return hasDateInfo(bArr) ? copyOfRange(bArr, indexOf(bArr, ' ') + 1, bArr.length) : bArr;
        }

        private static byte[] copyOfRange(byte[] bArr, int i11, int i12) {
            int i13 = i12 - i11;
            if (i13 >= 0) {
                byte[] bArr2 = new byte[i13];
                System.arraycopy(bArr, i11, bArr2, 0, Math.min(bArr.length - i11, i13));
                return bArr2;
            }
            throw new IllegalArgumentException(i11 + " > " + i12);
        }

        private static String createDateInfo(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            String sb3 = sb2.toString();
            while (sb3.length() < 13) {
                sb3 = "0".concat(sb3);
            }
            return sb3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11 + ' ';
        }

        /* access modifiers changed from: private */
        public static Bitmap drawable2Bitmap(Drawable drawable) {
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        }

        private static String[] getDateInfoFromDate(byte[] bArr) {
            if (!hasDateInfo(bArr)) {
                return null;
            }
            return new String[]{new String(copyOfRange(bArr, 0, 13)), new String(copyOfRange(bArr, 14, indexOf(bArr, ' ')))};
        }

        private static boolean hasDateInfo(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && indexOf(bArr, ' ') > 14;
        }

        private static int indexOf(byte[] bArr, char c11) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                if (bArr[i11] == c11) {
                    return i11;
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        public static boolean isDue(String str) {
            return isDue(str.getBytes());
        }

        /* access modifiers changed from: private */
        public static boolean isDue(byte[] bArr) {
            String[] dateInfoFromDate = getDateInfoFromDate(bArr);
            if (dateInfoFromDate != null && dateInfoFromDate.length == 2) {
                String str = dateInfoFromDate[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(dateInfoFromDate[1]).longValue() * 1000)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static byte[] newByteArrayWithDateInfo(int i11, byte[] bArr) {
            byte[] bytes = createDateInfo(i11).getBytes();
            byte[] bArr2 = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: private */
        public static String newStringWithDateInfo(int i11, String str) {
            return createDateInfo(i11) + str;
        }
    }

    private LocalCache(File file, long j11, int i11) {
        if (file.exists() || file.mkdirs()) {
            this.mCache = new ACacheManager(file, j11, i11);
        } else {
            this.mCache = null;
        }
    }

    public static LocalCache get(Context context) {
        return get(context, "LocalCache");
    }

    public static LocalCache get(Context context, long j11, int i11) {
        return get(new File(context.getCacheDir(), "LocalCache"), j11, i11);
    }

    public static LocalCache get(Context context, String str) {
        return get(new File(context.getCacheDir(), str), 50000000, Integer.MAX_VALUE);
    }

    public static LocalCache get(File file) {
        return get(file, 50000000, Integer.MAX_VALUE);
    }

    public static LocalCache get(File file, long j11, int i11) {
        LocalCache localCache;
        try {
            Map<String, LocalCache> map = mInstanceMap;
            localCache = map.get(file.getAbsoluteFile() + myPid());
        } catch (Exception unused) {
            localCache = null;
        }
        if (localCache != null) {
            return localCache;
        }
        try {
            LocalCache localCache2 = new LocalCache(file, j11, i11);
            try {
                Map<String, LocalCache> map2 = mInstanceMap;
                map2.put(file.getAbsolutePath() + myPid(), localCache2);
            } catch (Throwable unused2) {
            }
            return localCache2;
        } catch (Throwable unused3) {
            return localCache;
        }
    }

    private static String myPid() {
        return "_" + Process.myPid();
    }

    public void clear() {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager != null) {
            aCacheManager.clear();
        }
    }

    public File file(String str) {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager == null) {
            return null;
        }
        File access$100 = aCacheManager.newFile(str);
        if (access$100.exists()) {
            return access$100;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058 A[SYNTHETIC, Splitter:B:37:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0065 A[SYNTHETIC, Splitter:B:45:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getAsBinary(java.lang.String r6) {
        /*
            r5 = this;
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r0 = r5.mCache
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.File r0 = r0.get(r6)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            if (r2 != 0) goto L_0x0011
            return r1
        L_0x0011:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.lang.String r3 = "r"
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            long r3 = r2.length()     // Catch:{ Exception -> 0x004d }
            int r0 = (int) r3     // Catch:{ Exception -> 0x004d }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x004d }
            int r3 = r2.read(r0)     // Catch:{ Exception -> 0x004d }
            if (r3 <= 0) goto L_0x0044
            boolean r3 = com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.Utils.isDue((byte[]) r0)     // Catch:{ Exception -> 0x004d }
            if (r3 != 0) goto L_0x0038
            byte[] r6 = com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.Utils.clearDateInfo((byte[]) r0)     // Catch:{ Exception -> 0x004d }
            r2.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0037:
            return r6
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0040:
            r5.remove(r6)
            return r1
        L_0x0044:
            r2.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004c:
            return r1
        L_0x004d:
            r6 = move-exception
            goto L_0x0053
        L_0x004f:
            r6 = move-exception
            goto L_0x0063
        L_0x0051:
            r6 = move-exception
            r2 = r1
        L_0x0053:
            r6.printStackTrace()     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0060:
            return r1
        L_0x0061:
            r6 = move-exception
            r1 = r2
        L_0x0063:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.getAsBinary(java.lang.String):byte[]");
    }

    public Bitmap getAsBitmap(String str) {
        if (getAsBinary(str) == null) {
            return null;
        }
        return Utils.Bytes2Bimap(getAsBinary(str));
    }

    public Drawable getAsDrawable(String str) {
        if (getAsBinary(str) == null) {
            return null;
        }
        return Utils.bitmap2Drawable(Utils.Bytes2Bimap(getAsBinary(str)));
    }

    public JSONArray getAsJSONArray(String str) {
        try {
            return new JSONArray(getAsString(str));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public JSONObject getAsJSONObject(String str) {
        try {
            return new JSONObject(getAsString(str));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x003d A[SYNTHETIC, Splitter:B:29:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0047 A[SYNTHETIC, Splitter:B:34:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0053 A[SYNTHETIC, Splitter:B:41:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005d A[SYNTHETIC, Splitter:B:46:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAsObject(java.lang.String r5) {
        /*
            r4 = this;
            byte[] r5 = r4.getAsBinary(r5)
            r0 = 0
            if (r5 == 0) goto L_0x0066
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            java.lang.Object r0 = r5.readObject()     // Catch:{ Exception -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001d:
            r5.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0025:
            return r0
        L_0x0026:
            r2 = move-exception
            goto L_0x0038
        L_0x0028:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x0051
        L_0x002d:
            r2 = move-exception
            r5 = r0
            goto L_0x0038
        L_0x0030:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L_0x0051
        L_0x0035:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L_0x0038:
            r2.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0045:
            if (r5 == 0) goto L_0x004f
            r5.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005b:
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0065:
            throw r0
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.getAsObject(java.lang.String):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x005d A[SYNTHETIC, Splitter:B:34:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006a A[SYNTHETIC, Splitter:B:42:0x006a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getAsString(java.lang.String r6) {
        /*
            r5 = this;
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r0 = r5.mCache
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.File r0 = r0.get(r6)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x0011
            return r1
        L_0x0011:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0056, all -> 0x0054 }
            java.lang.String r0 = ""
        L_0x001d:
            java.lang.String r3 = r2.readLine()     // Catch:{ IOException -> 0x0052 }
            if (r3 == 0) goto L_0x0033
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0052 }
            r4.<init>()     // Catch:{ IOException -> 0x0052 }
            r4.append(r0)     // Catch:{ IOException -> 0x0052 }
            r4.append(r3)     // Catch:{ IOException -> 0x0052 }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x0052 }
            goto L_0x001d
        L_0x0033:
            boolean r3 = com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.Utils.isDue((java.lang.String) r0)     // Catch:{ IOException -> 0x0052 }
            if (r3 != 0) goto L_0x0046
            java.lang.String r6 = com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.Utils.clearDateInfo((java.lang.String) r0)     // Catch:{ IOException -> 0x0052 }
            r2.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0045:
            return r6
        L_0x0046:
            r2.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004e:
            r5.remove(r6)
            return r1
        L_0x0052:
            r6 = move-exception
            goto L_0x0058
        L_0x0054:
            r6 = move-exception
            goto L_0x0068
        L_0x0056:
            r6 = move-exception
            r2 = r1
        L_0x0058:
            r6.printStackTrace()     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x0065
            r2.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0065:
            return r1
        L_0x0066:
            r6 = move-exception
            r1 = r2
        L_0x0068:
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0072:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.getAsString(java.lang.String):java.lang.String");
    }

    public void put(String str, Bitmap bitmap) {
        put(str, Utils.Bitmap2Bytes(bitmap));
    }

    public void put(String str, Bitmap bitmap, int i11) {
        put(str, Utils.Bitmap2Bytes(bitmap), i11);
    }

    public void put(String str, Drawable drawable) {
        put(str, Utils.drawable2Bitmap(drawable));
    }

    public void put(String str, Drawable drawable, int i11) {
        put(str, Utils.drawable2Bitmap(drawable), i11);
    }

    public void put(String str, Serializable serializable) {
        put(str, serializable, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0037 A[SYNTHETIC, Splitter:B:26:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0032=Splitter:B:23:0x0032, B:16:0x0027=Splitter:B:16:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r4, java.io.Serializable r5, int r6) {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            r1.<init>()     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            r2.writeObject(r5)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            byte[] r5 = r1.toByteArray()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r0 = -1
            if (r6 == r0) goto L_0x0019
            r3.put((java.lang.String) r4, (byte[]) r5, (int) r6)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            goto L_0x001c
        L_0x0019:
            r3.put((java.lang.String) r4, (byte[]) r5)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
        L_0x001c:
            r2.close()     // Catch:{ all -> 0x001f }
        L_0x001f:
            return
        L_0x0020:
            r4 = move-exception
            r0 = r2
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r0 = r2
            goto L_0x0032
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            r4.printStackTrace()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            return
        L_0x0031:
            r4 = move-exception
        L_0x0032:
            r4.printStackTrace()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            return
        L_0x003c:
            r4 = move-exception
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.put(java.lang.String, java.io.Serializable, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A[SYNTHETIC, Splitter:B:27:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004d A[SYNTHETIC, Splitter:B:35:0x004d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r0 = r4.mCache
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.io.File r5 = r0.newFile(r5)
            r0 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0037 }
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ IOException -> 0x0037 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x0037 }
            r3 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0037 }
            r1.write(r6)     // Catch:{ IOException -> 0x0032, all -> 0x002f }
            r1.flush()     // Catch:{ IOException -> 0x001d }
            goto L_0x0021
        L_0x001d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0021:
            r1.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r6 = move-exception
        L_0x0026:
            r6.printStackTrace()
        L_0x0029:
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r6 = r4.mCache
            r6.put(r5)
            return
        L_0x002f:
            r6 = move-exception
            r0 = r1
            goto L_0x004b
        L_0x0032:
            r6 = move-exception
            r0 = r1
            goto L_0x0038
        L_0x0035:
            r6 = move-exception
            goto L_0x004b
        L_0x0037:
            r6 = move-exception
        L_0x0038:
            r6.printStackTrace()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0029
            r0.flush()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0045:
            r0.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0029
        L_0x0049:
            r6 = move-exception
            goto L_0x0026
        L_0x004b:
            if (r0 == 0) goto L_0x005d
            r0.flush()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0055:
            r0.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005d:
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r0 = r4.mCache
            r0.put(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.put(java.lang.String, java.lang.String):void");
    }

    public void put(String str, String str2, int i11) {
        put(str, Utils.newStringWithDateInfo(i11, str2));
    }

    public void put(String str, JSONArray jSONArray) {
        put(str, jSONArray.toString());
    }

    public void put(String str, JSONArray jSONArray, int i11) {
        put(str, jSONArray.toString(), i11);
    }

    public void put(String str, JSONObject jSONObject) {
        put(str, jSONObject.toString());
    }

    public void put(String str, JSONObject jSONObject, int i11) {
        put(str, jSONObject.toString(), i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[SYNTHETIC, Splitter:B:23:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[SYNTHETIC, Splitter:B:27:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void put(java.lang.String r3, byte[] r4) {
        /*
            r2 = this;
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r0 = r2.mCache
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.io.File r3 = r0.newFile(r3)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002b }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002b }
            r1.write(r4)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            r1.flush()     // Catch:{ IOException -> 0x0019 }
            r1.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r4 = move-exception
        L_0x001a:
            r4.printStackTrace()
        L_0x001d:
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r4 = r2.mCache
            r4.put(r3)
            return
        L_0x0023:
            r4 = move-exception
            r0 = r1
            goto L_0x003a
        L_0x0026:
            r4 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x0029:
            r4 = move-exception
            goto L_0x003a
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            r4.printStackTrace()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x001d
            r0.flush()     // Catch:{ IOException -> 0x0038 }
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x001d
        L_0x0038:
            r4 = move-exception
            goto L_0x001a
        L_0x003a:
            if (r0 == 0) goto L_0x0047
            r0.flush()     // Catch:{ IOException -> 0x0043 }
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0047:
            com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache$ACacheManager r0 = r2.mCache
            r0.put(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.core.thirdparties.LocalCache.put(java.lang.String, byte[]):void");
    }

    public void put(String str, byte[] bArr, int i11) {
        put(str, Utils.newByteArrayWithDateInfo(i11, bArr));
    }

    public boolean remove(String str) {
        ACacheManager aCacheManager = this.mCache;
        if (aCacheManager == null) {
            return false;
        }
        return aCacheManager.remove(str);
    }
}
