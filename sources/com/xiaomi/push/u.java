package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f52616a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a  reason: collision with other field name */
    private Context f3447a;

    /* renamed from: a  reason: collision with other field name */
    private RandomAccessFile f3448a;

    /* renamed from: a  reason: collision with other field name */
    private String f3449a;

    /* renamed from: a  reason: collision with other field name */
    private FileLock f3450a;

    private u(Context context) {
        this.f3447a = context;
    }

    /* JADX INFO: finally extract failed */
    public static u a(Context context, File file) {
        b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = f52616a;
        if (set.add(str)) {
            u uVar = new u(context);
            uVar.f3449a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                uVar.f3448a = randomAccessFile;
                uVar.f3450a = randomAccessFile.getChannel().lock();
                b.c("Locked: " + str + " :" + uVar.f3450a);
                if (uVar.f3450a == null) {
                    RandomAccessFile randomAccessFile2 = uVar.f3448a;
                    if (randomAccessFile2 != null) {
                        x.a((Closeable) randomAccessFile2);
                    }
                    set.remove(uVar.f3449a);
                }
                return uVar;
            } catch (Throwable th2) {
                if (uVar.f3450a == null) {
                    RandomAccessFile randomAccessFile3 = uVar.f3448a;
                    if (randomAccessFile3 != null) {
                        x.a((Closeable) randomAccessFile3);
                    }
                    f52616a.remove(uVar.f3449a);
                }
                throw th2;
            }
        } else {
            throw new IOException("abtain lock failure");
        }
    }

    public void a() {
        b.c("unLock: " + this.f3450a);
        FileLock fileLock = this.f3450a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f3450a.release();
            } catch (IOException unused) {
            }
            this.f3450a = null;
        }
        RandomAccessFile randomAccessFile = this.f3448a;
        if (randomAccessFile != null) {
            x.a((Closeable) randomAccessFile);
        }
        f52616a.remove(this.f3449a);
    }
}
