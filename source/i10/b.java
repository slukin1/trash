package i10;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import n10.a;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.Zip4jUtil;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f54998a;

    /* renamed from: b  reason: collision with root package name */
    public int f54999b;

    /* renamed from: c  reason: collision with root package name */
    public ZipModel f55000c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55001d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressMonitor f55002e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55003f;

    /* renamed from: g  reason: collision with root package name */
    public String f55004g;

    public b(File file) throws ZipException {
        if (file != null) {
            this.f54998a = file.getPath();
            this.f54999b = 2;
            this.f55002e = new ProgressMonitor();
            this.f55003f = false;
            return;
        }
        throw new ZipException("Input zip file parameter is not null", 1);
    }

    public void a(String str) throws ZipException {
        b(str, (UnzipParameters) null);
    }

    public void b(String str, UnzipParameters unzipParameters) throws ZipException {
        if (!Zip4jUtil.h(str)) {
            throw new ZipException("output path is null or invalid");
        } else if (Zip4jUtil.d(str)) {
            if (this.f55000c == null) {
                e();
            }
            if (this.f55000c == null) {
                throw new ZipException("Internal error occurred when extracting zip file");
            } else if (this.f55002e.c() != 1) {
                new a(this.f55000c).d(unzipParameters, str, this.f55002e, this.f55003f);
            } else {
                throw new ZipException("invalid operation - Zip4j is in busy state");
            }
        } else {
            throw new ZipException("invalid output path");
        }
    }

    public List c() throws ZipException {
        e();
        ZipModel zipModel = this.f55000c;
        if (zipModel == null || zipModel.b() == null) {
            return null;
        }
        return this.f55000c.b().a();
    }

    public boolean d() throws ZipException {
        if (this.f55000c == null) {
            e();
            if (this.f55000c == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.f55000c.b() == null || this.f55000c.b().a() == null) {
            throw new ZipException("invalid zip file");
        }
        ArrayList a11 = this.f55000c.b().a();
        int i11 = 0;
        while (true) {
            if (i11 < a11.size()) {
                FileHeader fileHeader = (FileHeader) a11.get(i11);
                if (fileHeader != null && fileHeader.r()) {
                    this.f55001d = true;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        return this.f55001d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0054 A[SYNTHETIC, Splitter:B:28:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() throws net.lingala.zip4j.exception.ZipException {
        /*
            r5 = this;
            java.lang.String r0 = r5.f54998a
            boolean r0 = net.lingala.zip4j.util.Zip4jUtil.b(r0)
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = r5.f54998a
            boolean r0 = net.lingala.zip4j.util.Zip4jUtil.c(r0)
            if (r0 == 0) goto L_0x0060
            int r0 = r5.f54999b
            r1 = 2
            if (r0 != r1) goto L_0x0058
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0047, all -> 0x0042 }
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0047, all -> 0x0042 }
            java.lang.String r3 = r5.f54998a     // Catch:{ FileNotFoundException -> 0x0047, all -> 0x0042 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0047, all -> 0x0042 }
            java.lang.String r3 = "r"
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x0047, all -> 0x0042 }
            net.lingala.zip4j.model.ZipModel r0 = r5.f55000c     // Catch:{ FileNotFoundException -> 0x0040 }
            if (r0 != 0) goto L_0x003c
            i10.a r0 = new i10.a     // Catch:{ FileNotFoundException -> 0x0040 }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0040 }
            java.lang.String r2 = r5.f55004g     // Catch:{ FileNotFoundException -> 0x0040 }
            net.lingala.zip4j.model.ZipModel r0 = r0.c(r2)     // Catch:{ FileNotFoundException -> 0x0040 }
            r5.f55000c = r0     // Catch:{ FileNotFoundException -> 0x0040 }
            if (r0 == 0) goto L_0x003c
            java.lang.String r2 = r5.f54998a     // Catch:{ FileNotFoundException -> 0x0040 }
            r0.q(r2)     // Catch:{ FileNotFoundException -> 0x0040 }
        L_0x003c:
            r1.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            return
        L_0x0040:
            r0 = move-exception
            goto L_0x004b
        L_0x0042:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0052
        L_0x0047:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x004b:
            net.lingala.zip4j.exception.ZipException r2 = new net.lingala.zip4j.exception.ZipException     // Catch:{ all -> 0x0051 }
            r2.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0051 }
            throw r2     // Catch:{ all -> 0x0051 }
        L_0x0051:
            r0 = move-exception
        L_0x0052:
            if (r1 == 0) goto L_0x0057
            r1.close()     // Catch:{ IOException -> 0x0057 }
        L_0x0057:
            throw r0
        L_0x0058:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "Invalid mode"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0060:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "no read access for the input zip file"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0068:
            net.lingala.zip4j.exception.ZipException r0 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r1 = "zip file does not exist"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i10.b.e():void");
    }

    public void f(String str) throws ZipException {
        if (!Zip4jUtil.h(str)) {
            throw new ZipException("null or empty charset name");
        } else if (Zip4jUtil.i(str)) {
            this.f55004g = str;
        } else {
            throw new ZipException("unsupported charset: " + str);
        }
    }

    public void g(char[] cArr) throws ZipException {
        if (this.f55000c == null) {
            e();
            if (this.f55000c == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.f55000c.b() == null || this.f55000c.b().a() == null) {
            throw new ZipException("invalid zip file");
        }
        for (int i11 = 0; i11 < this.f55000c.b().a().size(); i11++) {
            if (this.f55000c.b().a().get(i11) != null && ((FileHeader) this.f55000c.b().a().get(i11)).r()) {
                ((FileHeader) this.f55000c.b().a().get(i11)).O(cArr);
            }
        }
    }
}
