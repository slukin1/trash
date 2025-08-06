package n10;

import com.amazonaws.services.s3.model.InstructionFileId;
import j10.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.CRC32;
import m10.c;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public ZipModel f58303a;

    /* renamed from: b  reason: collision with root package name */
    public FileHeader f58304b;

    /* renamed from: c  reason: collision with root package name */
    public int f58305c = 0;

    /* renamed from: d  reason: collision with root package name */
    public LocalFileHeader f58306d;

    /* renamed from: e  reason: collision with root package name */
    public j10.b f58307e;

    /* renamed from: f  reason: collision with root package name */
    public CRC32 f58308f;

    public b(ZipModel zipModel, FileHeader fileHeader) throws ZipException {
        if (zipModel == null || fileHeader == null) {
            throw new ZipException("Invalid parameters passed to StoreUnzip. One or more of the parameters were null");
        }
        this.f58303a = zipModel;
        this.f58304b = fileHeader;
        this.f58308f = new CRC32();
    }

    public final int a(AESExtraDataRecord aESExtraDataRecord) throws ZipException {
        if (aESExtraDataRecord != null) {
            int a11 = aESExtraDataRecord.a();
            if (a11 == 1) {
                return 8;
            }
            if (a11 == 2) {
                return 12;
            }
            if (a11 == 3) {
                return 16;
            }
            throw new ZipException("unable to determine salt length: invalid aes key strength");
        }
        throw new ZipException("unable to determine salt length: AESExtraDataRecord is null");
    }

    public void b() throws ZipException {
        FileHeader fileHeader = this.f58304b;
        if (fileHeader == null) {
            return;
        }
        if (fileHeader.g() == 99) {
            j10.b bVar = this.f58307e;
            if (bVar != null && (bVar instanceof a)) {
                byte[] c11 = ((a) bVar).c();
                byte[] f11 = ((a) this.f58307e).f();
                byte[] bArr = new byte[10];
                if (f11 != null) {
                    System.arraycopy(c11, 0, bArr, 0, 10);
                    if (!Arrays.equals(bArr, f11)) {
                        throw new ZipException("invalid CRC (MAC) for file: " + this.f58304b.k());
                    }
                    return;
                }
                throw new ZipException("CRC (MAC) check failed for " + this.f58304b.k());
            }
        } else if ((this.f58308f.getValue() & 4294967295L) != this.f58304b.d()) {
            String str = "invalid CRC for file: " + this.f58304b.k();
            if (this.f58306d.l() && this.f58306d.e() == 0) {
                str = str + " - Wrong Password?";
            }
            throw new ZipException(str);
        }
    }

    public final boolean c() throws ZipException {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = d();
            if (randomAccessFile == null) {
                randomAccessFile = new RandomAccessFile(new File(this.f58303a.g()), "r");
            }
            LocalFileHeader n11 = new i10.a(randomAccessFile).n(this.f58304b);
            this.f58306d = n11;
            if (n11 == null) {
                throw new ZipException("error reading local file header. Is this a valid zip file?");
            } else if (n11.c() != this.f58304b.c()) {
                try {
                    randomAccessFile.close();
                } catch (IOException | Exception unused) {
                }
                return false;
            } else {
                try {
                    randomAccessFile.close();
                } catch (IOException | Exception unused2) {
                }
                return true;
            }
        } catch (FileNotFoundException e11) {
            throw new ZipException((Throwable) e11);
        } catch (Throwable th2) {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException | Exception unused3) {
                }
            }
            throw th2;
        }
    }

    public final RandomAccessFile d() throws ZipException {
        String str;
        if (!this.f58303a.h()) {
            return null;
        }
        int f11 = this.f58304b.f();
        int i11 = f11 + 1;
        this.f58305c = i11;
        String g11 = this.f58303a.g();
        if (f11 == this.f58303a.c().a()) {
            str = this.f58303a.g();
        } else if (f11 >= 9) {
            str = g11.substring(0, g11.lastIndexOf(InstructionFileId.DOT)) + ".z" + i11;
        } else {
            str = g11.substring(0, g11.lastIndexOf(InstructionFileId.DOT)) + ".z0" + i11;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            if (this.f58305c == 1) {
                byte[] bArr = new byte[4];
                randomAccessFile.read(bArr);
                if (((long) Raw.c(bArr, 0)) != 134695760) {
                    throw new ZipException("invalid first part split file signature");
                }
            }
            return randomAccessFile;
        } catch (FileNotFoundException e11) {
            throw new ZipException((Throwable) e11);
        } catch (IOException e12) {
            throw new ZipException((Throwable) e12);
        }
    }

    public final void e(InputStream inputStream, OutputStream outputStream) throws ZipException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e11) {
                if (Zip4jUtil.h(e11.getMessage())) {
                    if (e11.getMessage().indexOf(" - Wrong Password?") >= 0) {
                        throw new ZipException(e11.getMessage());
                    }
                }
                if (outputStream == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th2;
            }
        }
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused2) {
        }
    }

    public final RandomAccessFile f(String str) throws ZipException {
        ZipModel zipModel = this.f58303a;
        if (zipModel == null || !Zip4jUtil.h(zipModel.g())) {
            throw new ZipException("input parameter is null in getFilePointer");
        }
        try {
            if (this.f58303a.h()) {
                return d();
            }
            return new RandomAccessFile(new File(this.f58303a.g()), str);
        } catch (FileNotFoundException e11) {
            throw new ZipException((Throwable) e11);
        } catch (Exception e12) {
            throw new ZipException((Throwable) e12);
        }
    }

    public final byte[] g(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] bArr = new byte[2];
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e11) {
            throw new ZipException((Throwable) e11);
        }
    }

    public final byte[] h(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.f58306d.a() == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[a(this.f58306d.a())];
            randomAccessFile.seek(this.f58306d.i());
            randomAccessFile.read(bArr);
            return bArr;
        } catch (IOException e11) {
            throw new ZipException((Throwable) e11);
        }
    }

    public j10.b i() {
        return this.f58307e;
    }

    public FileHeader j() {
        return this.f58304b;
    }

    public c k() throws ZipException {
        long j11;
        if (this.f58304b != null) {
            RandomAccessFile randomAccessFile = null;
            try {
                RandomAccessFile f11 = f("r");
                if (c()) {
                    q(f11);
                    long b11 = this.f58306d.b();
                    long i11 = this.f58306d.i();
                    if (this.f58306d.l()) {
                        if (this.f58306d.e() == 99) {
                            j10.b bVar = this.f58307e;
                            if (bVar instanceof a) {
                                b11 -= (long) ((((a) bVar).e() + ((a) this.f58307e).d()) + 10);
                                j11 = (long) (((a) this.f58307e).e() + ((a) this.f58307e).d());
                            } else {
                                throw new ZipException("invalid decryptor when trying to calculate compressed size for AES encrypted file: " + this.f58304b.k());
                            }
                        } else if (this.f58306d.e() == 0) {
                            j11 = 12;
                            b11 -= 12;
                        }
                        i11 += j11;
                    }
                    long j12 = b11;
                    long j13 = i11;
                    int c11 = this.f58304b.c();
                    if (this.f58304b.g() == 99) {
                        if (this.f58304b.a() != null) {
                            c11 = this.f58304b.a().b();
                        } else {
                            throw new ZipException("AESExtraDataRecord does not exist for AES encrypted file: " + this.f58304b.k());
                        }
                    }
                    f11.seek(j13);
                    if (c11 == 0) {
                        return new c(new m10.b(f11, j13, j12, this));
                    }
                    if (c11 == 8) {
                        return new c(new m10.a(f11, j13, j12, this));
                    }
                    throw new ZipException("compression type not supported");
                }
                throw new ZipException("local header and file header do not match");
            } catch (ZipException e11) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused) {
                    }
                }
                throw e11;
            } catch (Exception e12) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw new ZipException((Throwable) e12);
            }
        } else {
            throw new ZipException("file header is null, cannot get inputstream");
        }
    }

    public LocalFileHeader l() {
        return this.f58306d;
    }

    public final String m(String str, String str2) throws ZipException {
        if (!Zip4jUtil.h(str2)) {
            str2 = this.f58304b.k();
        }
        return str + System.getProperty("file.separator") + str2;
    }

    public final FileOutputStream n(String str, String str2) throws ZipException {
        if (Zip4jUtil.h(str)) {
            try {
                File file = new File(m(str, str2));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                return new FileOutputStream(file);
            } catch (FileNotFoundException e11) {
                throw new ZipException((Throwable) e11);
            }
        } else {
            throw new ZipException("invalid output path");
        }
    }

    public final byte[] o(RandomAccessFile randomAccessFile) throws ZipException {
        try {
            byte[] bArr = new byte[12];
            randomAccessFile.seek(this.f58306d.i());
            randomAccessFile.read(bArr, 0, 12);
            return bArr;
        } catch (IOException e11) {
            throw new ZipException((Throwable) e11);
        } catch (Exception e12) {
            throw new ZipException((Throwable) e12);
        }
    }

    public ZipModel p() {
        return this.f58303a;
    }

    public final void q(RandomAccessFile randomAccessFile) throws ZipException {
        if (this.f58306d != null) {
            try {
                r(randomAccessFile);
            } catch (ZipException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new ZipException((Throwable) e12);
            }
        } else {
            throw new ZipException("local file header is null, cannot initialize input stream");
        }
    }

    public final void r(RandomAccessFile randomAccessFile) throws ZipException {
        LocalFileHeader localFileHeader = this.f58306d;
        if (localFileHeader == null) {
            throw new ZipException("local file header is null, cannot init decrypter");
        } else if (!localFileHeader.l()) {
        } else {
            if (this.f58306d.e() == 0) {
                this.f58307e = new j10.c(this.f58304b, o(randomAccessFile));
            } else if (this.f58306d.e() == 99) {
                this.f58307e = new a(this.f58306d, h(randomAccessFile), g(randomAccessFile));
            } else {
                throw new ZipException("unsupported encryption method");
            }
        }
    }

    public RandomAccessFile s() throws IOException, FileNotFoundException {
        String str;
        String g11 = this.f58303a.g();
        if (this.f58305c == this.f58303a.c().a()) {
            str = this.f58303a.g();
        } else if (this.f58305c >= 9) {
            str = g11.substring(0, g11.lastIndexOf(InstructionFileId.DOT)) + ".z" + (this.f58305c + 1);
        } else {
            str = g11.substring(0, g11.lastIndexOf(InstructionFileId.DOT)) + ".z0" + (this.f58305c + 1);
        }
        this.f58305c++;
        try {
            if (Zip4jUtil.b(str)) {
                return new RandomAccessFile(str, "r");
            }
            throw new IOException("zip split file does not exist: " + str);
        } catch (ZipException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: m10.c} */
    /* JADX WARNING: type inference failed for: r9v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r1v10, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r9v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(net.lingala.zip4j.progress.ProgressMonitor r8, java.lang.String r9, java.lang.String r10, net.lingala.zip4j.model.UnzipParameters r11) throws net.lingala.zip4j.exception.ZipException {
        /*
            r7 = this;
            net.lingala.zip4j.model.ZipModel r0 = r7.f58303a
            if (r0 == 0) goto L_0x0074
            net.lingala.zip4j.model.FileHeader r0 = r7.f58304b
            if (r0 == 0) goto L_0x0074
            boolean r0 = net.lingala.zip4j.util.Zip4jUtil.h(r9)
            if (r0 == 0) goto L_0x0074
            r0 = 4096(0x1000, float:5.74E-42)
            r1 = 0
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0067, Exception -> 0x005f, all -> 0x005c }
            m10.c r2 = r7.k()     // Catch:{ IOException -> 0x0067, Exception -> 0x005f, all -> 0x005c }
            java.io.FileOutputStream r1 = r7.n(r9, r10)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
        L_0x001b:
            int r3 = r2.read(r0)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            r4 = -1
            if (r3 == r4) goto L_0x003b
            r4 = 0
            r1.write(r0, r4, r3)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            long r5 = (long) r3     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            r8.k(r5)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            boolean r3 = r8.d()     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            if (r3 == 0) goto L_0x001b
            r9 = 3
            r8.h(r9)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            r8.i(r4)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            r7.e(r2, r1)
            return
        L_0x003b:
            r7.e(r2, r1)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            net.lingala.zip4j.model.FileHeader r8 = r7.f58304b     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            java.lang.String r9 = r7.m(r9, r10)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            net.lingala.zip4j.unzip.UnzipUtil.a(r8, r0, r11)     // Catch:{ IOException -> 0x0058, Exception -> 0x0054, all -> 0x0050 }
            r7.e(r2, r1)
            return
        L_0x0050:
            r8 = move-exception
            r9 = r1
            r1 = r2
            goto L_0x0070
        L_0x0054:
            r8 = move-exception
            r9 = r1
            r1 = r2
            goto L_0x0061
        L_0x0058:
            r8 = move-exception
            r9 = r1
            r1 = r2
            goto L_0x0069
        L_0x005c:
            r8 = move-exception
            r9 = r1
            goto L_0x0070
        L_0x005f:
            r8 = move-exception
            r9 = r1
        L_0x0061:
            net.lingala.zip4j.exception.ZipException r10 = new net.lingala.zip4j.exception.ZipException     // Catch:{ all -> 0x006f }
            r10.<init>((java.lang.Throwable) r8)     // Catch:{ all -> 0x006f }
            throw r10     // Catch:{ all -> 0x006f }
        L_0x0067:
            r8 = move-exception
            r9 = r1
        L_0x0069:
            net.lingala.zip4j.exception.ZipException r10 = new net.lingala.zip4j.exception.ZipException     // Catch:{ all -> 0x006f }
            r10.<init>((java.lang.Throwable) r8)     // Catch:{ all -> 0x006f }
            throw r10     // Catch:{ all -> 0x006f }
        L_0x006f:
            r8 = move-exception
        L_0x0070:
            r7.e(r1, r9)
            throw r8
        L_0x0074:
            net.lingala.zip4j.exception.ZipException r8 = new net.lingala.zip4j.exception.ZipException
            java.lang.String r9 = "Invalid parameters passed during unzipping file. One or more of the parameters were null"
            r8.<init>((java.lang.String) r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n10.b.t(net.lingala.zip4j.progress.ProgressMonitor, java.lang.String, java.lang.String, net.lingala.zip4j.model.UnzipParameters):void");
    }

    public void u(int i11) {
        this.f58308f.update(i11);
    }

    public void v(byte[] bArr, int i11, int i12) {
        if (bArr != null) {
            this.f58308f.update(bArr, i11, i12);
        }
    }
}
