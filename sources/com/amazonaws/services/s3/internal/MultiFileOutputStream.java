package com.amazonaws.services.s3.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.OnFileDelete;
import com.amazonaws.services.s3.UploadObjectObserver;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class MultiFileOutputStream extends OutputStream implements OnFileDelete {

    /* renamed from: b  reason: collision with root package name */
    public final File f15152b = new File(System.getProperty("java.io.tmpdir"));

    /* renamed from: c  reason: collision with root package name */
    public final String f15153c = (g() + InstructionFileId.DOT + UUID.randomUUID());

    /* renamed from: d  reason: collision with root package name */
    public int f15154d;

    /* renamed from: e  reason: collision with root package name */
    public long f15155e = CacheDataSink.DEFAULT_FRAGMENT_SIZE;

    /* renamed from: f  reason: collision with root package name */
    public long f15156f = Long.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public UploadObjectObserver f15157g;

    /* renamed from: h  reason: collision with root package name */
    public int f15158h;

    /* renamed from: i  reason: collision with root package name */
    public long f15159i;

    /* renamed from: j  reason: collision with root package name */
    public FileOutputStream f15160j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f15161k;

    /* renamed from: l  reason: collision with root package name */
    public Semaphore f15162l;

    public static String g() {
        return new SimpleDateFormat("yyMMdd-hhmmss").format(new Date());
    }

    public void a(FileDeletionEvent fileDeletionEvent) {
        Semaphore semaphore = this.f15162l;
        if (semaphore != null) {
            semaphore.release();
        }
    }

    public final void b() {
        Semaphore semaphore = this.f15162l;
        if (semaphore != null && this.f15156f != Long.MAX_VALUE) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e11) {
                throw new AbortedException((Throwable) e11);
            }
        }
    }

    public void close() throws IOException {
        if (!this.f15161k) {
            this.f15161k = true;
            FileOutputStream fileOutputStream = this.f15160j;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                File f11 = f(this.f15154d);
                if (f11.length() != 0) {
                    this.f15157g.c(new PartCreationEvent(f(this.f15154d), this.f15154d, true, this));
                } else if (!f11.delete()) {
                    Log b11 = LogFactory.b(getClass());
                    b11.h("Ignoring failure to delete empty file " + f11);
                }
            }
        }
    }

    public final FileOutputStream e() throws IOException {
        if (!this.f15161k) {
            FileOutputStream fileOutputStream = this.f15160j;
            if (fileOutputStream == null || ((long) this.f15158h) >= this.f15155e) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    this.f15157g.c(new PartCreationEvent(f(this.f15154d), this.f15154d, false, this));
                }
                this.f15158h = 0;
                this.f15154d++;
                b();
                File f11 = f(this.f15154d);
                f11.deleteOnExit();
                this.f15160j = new FileOutputStream(f11);
            }
            return this.f15160j;
        }
        throw new IOException("Output stream is already closed");
    }

    public File f(int i11) {
        File file = this.f15152b;
        return new File(file, this.f15153c + InstructionFileId.DOT + i11);
    }

    public void flush() throws IOException {
        FileOutputStream fileOutputStream = this.f15160j;
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
    }

    public void write(int i11) throws IOException {
        e().write(i11);
        this.f15158h++;
        this.f15159i++;
    }

    public void write(byte[] bArr) throws IOException {
        if (bArr.length != 0) {
            e().write(bArr);
            this.f15158h += bArr.length;
            this.f15159i += (long) bArr.length;
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (bArr.length != 0) {
            e().write(bArr, i11, i12);
            this.f15158h += i12;
            this.f15159i += (long) i12;
        }
    }
}
