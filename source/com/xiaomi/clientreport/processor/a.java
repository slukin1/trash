package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.bc;
import com.xiaomi.push.bm;
import com.xiaomi.push.h;
import com.xiaomi.push.x;
import com.xiaomi.push.z;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class a implements IEventProcessor {

    /* renamed from: a  reason: collision with root package name */
    public Context f51273a;

    /* renamed from: a  reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f2424a;

    public a(Context context) {
        a(context);
    }

    public void a(Context context) {
        this.f51273a = context;
    }

    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap = this.f2424a;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str : this.f2424a.keySet()) {
                    ArrayList arrayList = this.f2424a.get(str);
                    if (arrayList != null && arrayList.size() > 0) {
                        com.xiaomi.clientreport.data.a[] aVarArr = new com.xiaomi.clientreport.data.a[arrayList.size()];
                        arrayList.toArray(aVarArr);
                        a(aVarArr);
                    }
                }
            }
            this.f2424a.clear();
        }
    }

    public String bytesToString(byte[] bArr) {
        byte[] a11;
        if (bArr != null && bArr.length >= 1) {
            if (!com.xiaomi.clientreport.manager.a.a(this.f51273a).a().isEventEncrypted()) {
                return bc.b(bArr);
            }
            String a12 = bm.a(this.f51273a);
            if (!TextUtils.isEmpty(a12) && (a11 = bm.a(a12)) != null && a11.length > 0) {
                try {
                    return bc.b(Base64.decode(h.a(a11, bArr), 2));
                } catch (InvalidAlgorithmParameterException e11) {
                    b.a((Throwable) e11);
                } catch (NoSuchAlgorithmException e12) {
                    b.a((Throwable) e12);
                } catch (InvalidKeyException e13) {
                    b.a((Throwable) e13);
                } catch (NoSuchPaddingException e14) {
                    b.a((Throwable) e14);
                } catch (BadPaddingException e15) {
                    b.a((Throwable) e15);
                } catch (IllegalBlockSizeException e16) {
                    b.a((Throwable) e16);
                }
            }
        }
        return null;
    }

    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> hashMap) {
        this.f2424a = hashMap;
    }

    public byte[] stringToBytes(String str) {
        byte[] a11;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!com.xiaomi.clientreport.manager.a.a(this.f51273a).a().isEventEncrypted()) {
            return bc.a(str);
        }
        String a12 = bm.a(this.f51273a);
        byte[] a13 = bc.a(str);
        if (!TextUtils.isEmpty(a12) && a13 != null && a13.length > 1 && (a11 = bm.a(a12)) != null) {
            try {
                if (a11.length > 1) {
                    return h.b(a11, Base64.encode(a13, 2));
                }
            } catch (Exception e11) {
                b.a((Throwable) e11);
            }
        }
        return null;
    }

    public static String a(com.xiaomi.clientreport.data.a aVar) {
        return String.valueOf(aVar.production);
    }

    public void a(List<String> list) {
        bm.a(this.f51273a, list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r11 = this;
            android.content.Context r0 = r11.f51273a
            java.lang.String r1 = "event"
            java.lang.String r2 = "eventUploading"
            com.xiaomi.push.bm.a(r0, r1, r2)
            android.content.Context r0 = r11.f51273a
            java.io.File[] r0 = com.xiaomi.push.bm.a((android.content.Context) r0, (java.lang.String) r2)
            if (r0 == 0) goto L_0x0129
            int r1 = r0.length
            if (r1 > 0) goto L_0x0016
            goto L_0x0129
        L_0x0016:
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x001b:
            if (r2 >= r1) goto L_0x0129
            r6 = r0[r2]
            if (r6 != 0) goto L_0x003b
            if (r3 == 0) goto L_0x0031
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0031
            r3.release()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r6)
        L_0x0031:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x010c
        L_0x0036:
            r5.delete()
            goto L_0x010c
        L_0x003b:
            long r7 = r6.length()     // Catch:{ Exception -> 0x00f1 }
            r9 = 5242880(0x500000, double:2.590327E-317)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0094
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1 }
            r7.<init>()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = "eventData read from cache file failed because "
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = r6.getName()     // Catch:{ Exception -> 0x00f1 }
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = " is too big, length "
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            long r8 = r6.length()     // Catch:{ Exception -> 0x00f1 }
            r7.append(r8)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x00f1 }
            com.xiaomi.channel.commonutils.logger.b.d(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r7 = r6.getName()     // Catch:{ Exception -> 0x00f1 }
            android.content.Context r8 = r11.f51273a     // Catch:{ Exception -> 0x00f1 }
            long r9 = r6.length()     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r8 = android.text.format.Formatter.formatFileSize(r8, r9)     // Catch:{ Exception -> 0x00f1 }
            r11.a((java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x00f1 }
            r6.delete()     // Catch:{ Exception -> 0x00f1 }
            if (r3 == 0) goto L_0x008e
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x008e
            r3.release()     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r6)
        L_0x008e:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x010c
            goto L_0x0036
        L_0x0094:
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00f1 }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00f1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f1 }
            r9.<init>()     // Catch:{ Exception -> 0x00f1 }
            r9.append(r7)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r10 = ".lock"
            r9.append(r10)     // Catch:{ Exception -> 0x00f1 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00f1 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00f1 }
            com.xiaomi.push.x.a((java.io.File) r8)     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            java.lang.String r9 = "rw"
            r5.<init>(r8, r9)     // Catch:{ Exception -> 0x00ec, all -> 0x00e9 }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            java.nio.channels.FileLock r3 = r4.lock()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            java.util.List r4 = r11.a((java.lang.String) r7)     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            r11.a((java.util.List<java.lang.String>) r4)     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            r6.delete()     // Catch:{ Exception -> 0x00e6, all -> 0x00e3 }
            if (r3 == 0) goto L_0x00da
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00da
            r3.release()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)
        L_0x00da:
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            r8.delete()
            r4 = r5
            r5 = r8
            goto L_0x010c
        L_0x00e3:
            r0 = move-exception
            r4 = r5
            goto L_0x00ea
        L_0x00e6:
            r6 = move-exception
            r4 = r5
            goto L_0x00ed
        L_0x00e9:
            r0 = move-exception
        L_0x00ea:
            r5 = r8
            goto L_0x0110
        L_0x00ec:
            r6 = move-exception
        L_0x00ed:
            r5 = r8
            goto L_0x00f2
        L_0x00ef:
            r0 = move-exception
            goto L_0x0110
        L_0x00f1:
            r6 = move-exception
        L_0x00f2:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x00ef }
            if (r3 == 0) goto L_0x0105
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0105
            r3.release()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0105
        L_0x0101:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r6)
        L_0x0105:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x010c
            goto L_0x0036
        L_0x010c:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x0110:
            if (r3 == 0) goto L_0x0120
            boolean r1 = r3.isValid()
            if (r1 == 0) goto L_0x0120
            r3.release()     // Catch:{ IOException -> 0x011c }
            goto L_0x0120
        L_0x011c:
            r1 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r1)
        L_0x0120:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x0128
            r5.delete()
        L_0x0128:
            throw r0
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.a.a():void");
    }

    private String b(com.xiaomi.clientreport.data.a aVar) {
        File file = new File(this.f51273a.getFilesDir(), "event");
        String str = file.getAbsolutePath() + File.separator + a(aVar);
        for (int i11 = 0; i11 < 100; i11++) {
            String str2 = str + i11;
            if (bm.a(this.f51273a, str2)) {
                return str2;
            }
        }
        return null;
    }

    private void a(String str, String str2) {
        com.xiaomi.clientreport.manager.a a11 = com.xiaomi.clientreport.manager.a.a(this.f51273a);
        EventClientReport a12 = a11.a((int) TPPlayerMsg.TP_PLAYER_INFO_LONG0_PREPARE_TIMEOUT, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a12.toJsonString());
        a((List<String>) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> a(java.lang.String r9) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 4
            byte[] r2 = new byte[r1]
            byte[] r3 = new byte[r1]
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x007a }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x007a }
            r6.<init>(r9)     // Catch:{ Exception -> 0x007a }
            r5.<init>(r6)     // Catch:{ Exception -> 0x007a }
        L_0x0015:
            int r9 = r5.read(r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r4 = -1
            if (r9 != r4) goto L_0x001d
            goto L_0x006e
        L_0x001d:
            java.lang.String r6 = "eventData read from cache file failed because magicNumber error"
            if (r9 == r1) goto L_0x0025
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            goto L_0x006e
        L_0x0025:
            int r9 = com.xiaomi.push.z.a((byte[]) r2)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r7 = -573785174(0xffffffffddccbbaa, float:-1.84407149E18)
            if (r9 == r7) goto L_0x0032
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            goto L_0x006e
        L_0x0032:
            int r9 = r5.read(r3)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            if (r9 != r4) goto L_0x0039
            goto L_0x006e
        L_0x0039:
            if (r9 == r1) goto L_0x0041
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer error"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            goto L_0x006e
        L_0x0041:
            int r9 = com.xiaomi.push.z.a((byte[]) r3)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            r4 = 1
            if (r9 < r4) goto L_0x0069
            r4 = 4096(0x1000, float:5.74E-42)
            if (r9 <= r4) goto L_0x004d
            goto L_0x0069
        L_0x004d:
            byte[] r4 = new byte[r9]     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            int r6 = r5.read(r4)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            if (r6 == r9) goto L_0x005b
            java.lang.String r9 = "eventData read from cache file failed cause buffer size not equal length"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            goto L_0x006e
        L_0x005b:
            java.lang.String r9 = r8.bytesToString(r4)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            boolean r4 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            if (r4 != 0) goto L_0x0015
            r0.add(r9)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
            goto L_0x0015
        L_0x0069:
            java.lang.String r9 = "eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K"
            com.xiaomi.channel.commonutils.logger.b.d(r9)     // Catch:{ Exception -> 0x0075, all -> 0x0072 }
        L_0x006e:
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            goto L_0x0081
        L_0x0072:
            r9 = move-exception
            r4 = r5
            goto L_0x0082
        L_0x0075:
            r9 = move-exception
            r4 = r5
            goto L_0x007b
        L_0x0078:
            r9 = move-exception
            goto L_0x0082
        L_0x007a:
            r9 = move-exception
        L_0x007b:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r9)     // Catch:{ all -> 0x0078 }
            com.xiaomi.push.x.a((java.io.Closeable) r4)
        L_0x0081:
            return r0
        L_0x0082:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.clientreport.processor.a.a(java.lang.String):java.util.List");
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2322a(com.xiaomi.clientreport.data.a[] aVarArr) {
        if (aVarArr == null || aVarArr.length == 0 || aVarArr[0] == null) {
            b.a("event data write to cache file failed because data null");
            return;
        }
        do {
            aVarArr = a(aVarArr);
            if (aVarArr == null || aVarArr.length <= 0 || aVarArr[0] == null) {
            }
            aVarArr = a(aVarArr);
            return;
        } while (aVarArr[0] == null);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] aVarArr) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        BufferedOutputStream bufferedOutputStream;
        String b11 = b(aVarArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(b11)) {
            return null;
        }
        try {
            File file = new File(b11 + ".lock");
            x.a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(b11), true));
                } catch (Exception e11) {
                    e = e11;
                    bufferedOutputStream = null;
                    try {
                        b.a("event data write to cache file failed cause exception", (Throwable) e);
                        x.a((Closeable) bufferedOutputStream);
                        a(randomAccessFile, fileLock);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        x.a((Closeable) bufferedOutputStream2);
                        a(randomAccessFile, fileLock);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    x.a((Closeable) bufferedOutputStream2);
                    a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                fileLock = null;
                bufferedOutputStream = null;
                b.a("event data write to cache file failed cause exception", (Throwable) e);
                x.a((Closeable) bufferedOutputStream);
                a(randomAccessFile, fileLock);
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileLock = null;
                x.a((Closeable) bufferedOutputStream2);
                a(randomAccessFile, fileLock);
                throw th;
            }
            try {
                int i11 = 0;
                for (com.xiaomi.clientreport.data.a aVar : aVarArr) {
                    if (aVar != null) {
                        byte[] stringToBytes = stringToBytes(aVar.toJsonString());
                        if (stringToBytes != null && stringToBytes.length >= 1) {
                            if (stringToBytes.length <= 4096) {
                                if (!bm.a(this.f51273a, b11)) {
                                    int length = aVarArr.length - i11;
                                    com.xiaomi.clientreport.data.a[] aVarArr2 = new com.xiaomi.clientreport.data.a[length];
                                    System.arraycopy(aVarArr, i11, aVarArr2, 0, length);
                                    x.a((Closeable) bufferedOutputStream);
                                    a(randomAccessFile, fileLock);
                                    return aVarArr2;
                                }
                                bufferedOutputStream.write(z.a(-573785174));
                                bufferedOutputStream.write(z.a(stringToBytes.length));
                                bufferedOutputStream.write(stringToBytes);
                                bufferedOutputStream.flush();
                                i11++;
                            }
                        }
                        b.d("event data throw a invalid item ");
                    }
                }
            } catch (Exception e13) {
                e = e13;
                b.a("event data write to cache file failed cause exception", (Throwable) e);
                x.a((Closeable) bufferedOutputStream);
                a(randomAccessFile, fileLock);
                return null;
            }
        } catch (Exception e14) {
            e = e14;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
            b.a("event data write to cache file failed cause exception", (Throwable) e);
            x.a((Closeable) bufferedOutputStream);
            a(randomAccessFile, fileLock);
            return null;
        } catch (Throwable th5) {
            th = th5;
            fileLock = null;
            randomAccessFile = null;
            x.a((Closeable) bufferedOutputStream2);
            a(randomAccessFile, fileLock);
            throw th;
        }
        x.a((Closeable) bufferedOutputStream);
        a(randomAccessFile, fileLock);
        return null;
    }

    private void a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e11) {
                b.a((Throwable) e11);
            }
        }
        x.a((Closeable) randomAccessFile);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2321a(com.xiaomi.clientreport.data.a aVar) {
        if ((aVar instanceof EventClientReport) && this.f2424a != null) {
            EventClientReport eventClientReport = (EventClientReport) aVar;
            String a11 = a((com.xiaomi.clientreport.data.a) eventClientReport);
            ArrayList arrayList = this.f2424a.get(a11);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(eventClientReport);
            this.f2424a.put(a11, arrayList);
        }
    }
}
