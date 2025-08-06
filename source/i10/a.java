package i10;

import com.google.common.primitives.SignedBytes;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.DigitalSignature;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.ExtraDataRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.Zip64EndCentralDirLocator;
import net.lingala.zip4j.model.Zip64EndCentralDirRecord;
import net.lingala.zip4j.model.Zip64ExtendedInfo;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.util.Raw;
import net.lingala.zip4j.util.Zip4jUtil;
import okhttp3.internal.ws.WebSocketProtocol;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public RandomAccessFile f54996a = null;

    /* renamed from: b  reason: collision with root package name */
    public ZipModel f54997b;

    public a(RandomAccessFile randomAccessFile) {
        this.f54996a = randomAccessFile;
    }

    public final byte[] a(byte[] bArr) throws ZipException {
        if (bArr == null) {
            throw new ZipException("input parameter is null, cannot expand to 8 bytes");
        } else if (bArr.length == 4) {
            return new byte[]{bArr[0], bArr[1], bArr[2], bArr[3], 0, 0, 0, 0};
        } else {
            throw new ZipException("invalid byte length, cannot expand to 8 bytes");
        }
    }

    public final AESExtraDataRecord b(ArrayList arrayList) throws ZipException {
        if (arrayList == null) {
            return null;
        }
        int i11 = 0;
        while (i11 < arrayList.size()) {
            ExtraDataRecord extraDataRecord = (ExtraDataRecord) arrayList.get(i11);
            if (extraDataRecord == null || extraDataRecord.b() != 39169) {
                i11++;
            } else if (extraDataRecord.a() != null) {
                AESExtraDataRecord aESExtraDataRecord = new AESExtraDataRecord();
                aESExtraDataRecord.f(39169);
                aESExtraDataRecord.e(extraDataRecord.c());
                byte[] a11 = extraDataRecord.a();
                aESExtraDataRecord.h(Raw.g(a11, 0));
                byte[] bArr = new byte[2];
                System.arraycopy(a11, 2, bArr, 0, 2);
                aESExtraDataRecord.g(new String(bArr));
                aESExtraDataRecord.c(a11[4] & 255);
                aESExtraDataRecord.d(Raw.g(a11, 5));
                return aESExtraDataRecord;
            } else {
                throw new ZipException("corrput AES extra data records");
            }
        }
        return null;
    }

    public ZipModel c(String str) throws ZipException {
        ZipModel zipModel = new ZipModel();
        this.f54997b = zipModel;
        zipModel.l(str);
        this.f54997b.k(k());
        this.f54997b.n(o());
        if (this.f54997b.i()) {
            this.f54997b.o(p());
            if (this.f54997b.f() == null || this.f54997b.f().a() <= 0) {
                this.f54997b.m(false);
            } else {
                this.f54997b.m(true);
            }
        }
        this.f54997b.j(j());
        return this.f54997b;
    }

    public final void d(FileHeader fileHeader) throws ZipException {
        AESExtraDataRecord b11;
        if (fileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (fileHeader.i() != null && fileHeader.i().size() > 0 && (b11 = b(fileHeader.i())) != null) {
            fileHeader.t(b11);
            fileHeader.C(99);
        }
    }

    public final void e(LocalFileHeader localFileHeader) throws ZipException {
        AESExtraDataRecord b11;
        if (localFileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (localFileHeader.f() != null && localFileHeader.f().size() > 0 && (b11 = b(localFileHeader.f())) != null) {
            localFileHeader.n(b11);
            localFileHeader.u(99);
        }
    }

    public final void f(FileHeader fileHeader) throws ZipException {
        if (this.f54996a == null) {
            throw new ZipException("invalid file handler when trying to read extra data record");
        } else if (fileHeader != null) {
            int j11 = fileHeader.j();
            if (j11 > 0) {
                fileHeader.E(l(j11));
            }
        } else {
            throw new ZipException("file header is null");
        }
    }

    public final void g(LocalFileHeader localFileHeader) throws ZipException {
        if (this.f54996a == null) {
            throw new ZipException("invalid file handler when trying to read extra data record");
        } else if (localFileHeader != null) {
            int g11 = localFileHeader.g();
            if (g11 > 0) {
                localFileHeader.v(l(g11));
            }
        } else {
            throw new ZipException("file header is null");
        }
    }

    public final void h(FileHeader fileHeader) throws ZipException {
        Zip64ExtendedInfo q11;
        if (fileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (fileHeader.i() != null && fileHeader.i().size() > 0 && (q11 = q(fileHeader.i(), fileHeader.o(), fileHeader.b(), fileHeader.m(), fileHeader.f())) != null) {
            fileHeader.T(q11);
            if (q11.d() != -1) {
                fileHeader.Q(q11.d());
            }
            if (q11.a() != -1) {
                fileHeader.u(q11.a());
            }
            if (q11.c() != -1) {
                fileHeader.N(q11.c());
            }
            if (q11.b() != -1) {
                fileHeader.A(q11.b());
            }
        }
    }

    public final void i(LocalFileHeader localFileHeader) throws ZipException {
        Zip64ExtendedInfo q11;
        if (localFileHeader == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        } else if (localFileHeader.f() != null && localFileHeader.f().size() > 0 && (q11 = q(localFileHeader.f(), localFileHeader.k(), localFileHeader.b(), -1, -1)) != null) {
            localFileHeader.H(q11);
            if (q11.d() != -1) {
                localFileHeader.F(q11.d());
            }
            if (q11.a() != -1) {
                localFileHeader.o(q11.a());
            }
        }
    }

    public final CentralDirectory j() throws ZipException {
        String str;
        boolean z11;
        if (this.f54996a == null) {
            throw new ZipException("random access file was null", 3);
        } else if (this.f54997b.c() != null) {
            try {
                CentralDirectory centralDirectory = new CentralDirectory();
                ArrayList arrayList = new ArrayList();
                EndCentralDirRecord c11 = this.f54997b.c();
                long b11 = c11.b();
                int c12 = c11.c();
                if (this.f54997b.i()) {
                    b11 = this.f54997b.f().b();
                    c12 = (int) this.f54997b.f().d();
                }
                this.f54996a.seek(b11);
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[2];
                int i11 = 0;
                while (i11 < c12) {
                    FileHeader fileHeader = new FileHeader();
                    m(this.f54996a, bArr);
                    int c13 = Raw.c(bArr, 0);
                    if (((long) c13) == 33639248) {
                        fileHeader.P(c13);
                        m(this.f54996a, bArr2);
                        fileHeader.R(Raw.g(bArr2, 0));
                        m(this.f54996a, bArr2);
                        fileHeader.S(Raw.g(bArr2, 0));
                        m(this.f54996a, bArr2);
                        fileHeader.J((Raw.g(bArr2, 0) & 2048) != 0);
                        byte b12 = bArr2[0];
                        if ((b12 & 1) != 0) {
                            fileHeader.B(true);
                        }
                        fileHeader.K((byte[]) bArr2.clone());
                        fileHeader.y((b12 >> 3) == 1);
                        m(this.f54996a, bArr2);
                        fileHeader.v(Raw.g(bArr2, 0));
                        m(this.f54996a, bArr);
                        fileHeader.M(Raw.c(bArr, 0));
                        m(this.f54996a, bArr);
                        fileHeader.w((long) Raw.c(bArr, 0));
                        fileHeader.x((byte[]) bArr.clone());
                        m(this.f54996a, bArr);
                        fileHeader.u(Raw.e(a(bArr), 0));
                        m(this.f54996a, bArr);
                        fileHeader.Q(Raw.e(a(bArr), 0));
                        m(this.f54996a, bArr2);
                        int g11 = Raw.g(bArr2, 0);
                        fileHeader.I(g11);
                        m(this.f54996a, bArr2);
                        fileHeader.F(Raw.g(bArr2, 0));
                        m(this.f54996a, bArr2);
                        int g12 = Raw.g(bArr2, 0);
                        fileHeader.G(new String(bArr2));
                        m(this.f54996a, bArr2);
                        fileHeader.A(Raw.g(bArr2, 0));
                        m(this.f54996a, bArr2);
                        fileHeader.L((byte[]) bArr2.clone());
                        m(this.f54996a, bArr);
                        fileHeader.D((byte[]) bArr.clone());
                        m(this.f54996a, bArr);
                        fileHeader.N(Raw.e(a(bArr), 0) & 4294967295L);
                        if (g11 > 0) {
                            byte[] bArr3 = new byte[g11];
                            m(this.f54996a, bArr3);
                            if (Zip4jUtil.h(this.f54997b.d())) {
                                str = new String(bArr3, this.f54997b.d());
                            } else {
                                str = Zip4jUtil.e(bArr3, fileHeader.s());
                            }
                            if (str != null) {
                                if (str.indexOf(":" + System.getProperty("file.separator")) >= 0) {
                                    str = str.substring(str.indexOf(":" + System.getProperty("file.separator")) + 2);
                                }
                                fileHeader.H(str);
                                if (!str.endsWith("/")) {
                                    if (!str.endsWith("\\")) {
                                        z11 = false;
                                        fileHeader.z(z11);
                                    }
                                }
                                z11 = true;
                                fileHeader.z(z11);
                            } else {
                                throw new ZipException("fileName is null when reading central directory");
                            }
                        } else {
                            fileHeader.H((String) null);
                        }
                        f(fileHeader);
                        h(fileHeader);
                        d(fileHeader);
                        if (g12 > 0) {
                            byte[] bArr4 = new byte[g12];
                            m(this.f54996a, bArr4);
                            fileHeader.G(new String(bArr4));
                        }
                        arrayList.add(fileHeader);
                        i11++;
                    } else {
                        throw new ZipException("Expected central directory entry not found (#" + (i11 + 1) + ")");
                    }
                }
                centralDirectory.b(arrayList);
                DigitalSignature digitalSignature = new DigitalSignature();
                m(this.f54996a, bArr);
                int c14 = Raw.c(bArr, 0);
                if (((long) c14) != 84233040) {
                    return centralDirectory;
                }
                digitalSignature.a(c14);
                m(this.f54996a, bArr2);
                int g13 = Raw.g(bArr2, 0);
                digitalSignature.c(g13);
                if (g13 > 0) {
                    byte[] bArr5 = new byte[g13];
                    m(this.f54996a, bArr5);
                    digitalSignature.b(new String(bArr5));
                }
                return centralDirectory;
            } catch (IOException e11) {
                throw new ZipException((Throwable) e11);
            }
        } else {
            throw new ZipException("EndCentralRecord was null, maybe a corrupt zip file");
        }
    }

    public final EndCentralDirRecord k() throws ZipException {
        RandomAccessFile randomAccessFile = this.f54996a;
        if (randomAccessFile != null) {
            try {
                byte[] bArr = new byte[4];
                long length = randomAccessFile.length() - 22;
                EndCentralDirRecord endCentralDirRecord = new EndCentralDirRecord();
                int i11 = 0;
                while (true) {
                    long j11 = length - 1;
                    this.f54996a.seek(length);
                    i11++;
                    if (((long) Raw.d(this.f54996a, bArr)) == 101010256) {
                        break;
                    } else if (i11 > 3000) {
                        break;
                    } else {
                        length = j11;
                    }
                }
                if (((long) Raw.c(bArr, 0)) == 101010256) {
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[2];
                    endCentralDirRecord.j(101010256);
                    m(this.f54996a, bArr3);
                    endCentralDirRecord.g(Raw.g(bArr3, 0));
                    m(this.f54996a, bArr3);
                    endCentralDirRecord.h(Raw.g(bArr3, 0));
                    m(this.f54996a, bArr3);
                    endCentralDirRecord.m(Raw.g(bArr3, 0));
                    m(this.f54996a, bArr3);
                    endCentralDirRecord.l(Raw.g(bArr3, 0));
                    m(this.f54996a, bArr2);
                    endCentralDirRecord.k(Raw.c(bArr2, 0));
                    m(this.f54996a, bArr2);
                    endCentralDirRecord.i(Raw.e(a(bArr2), 0));
                    m(this.f54996a, bArr3);
                    int g11 = Raw.g(bArr3, 0);
                    endCentralDirRecord.f(g11);
                    if (g11 > 0) {
                        byte[] bArr4 = new byte[g11];
                        m(this.f54996a, bArr4);
                        endCentralDirRecord.d(new String(bArr4));
                        endCentralDirRecord.e(bArr4);
                    } else {
                        endCentralDirRecord.d((String) null);
                    }
                    if (endCentralDirRecord.a() > 0) {
                        this.f54997b.m(true);
                    } else {
                        this.f54997b.m(false);
                    }
                    return endCentralDirRecord;
                }
                throw new ZipException("zip headers not found. probably not a zip file");
            } catch (IOException e11) {
                throw new ZipException("Probably not a zip file or a corrupted zip file", e11, 4);
            }
        } else {
            throw new ZipException("random access file was null", 3);
        }
    }

    public final ArrayList l(int i11) throws ZipException {
        if (i11 <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i11];
            this.f54996a.read(bArr);
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                ExtraDataRecord extraDataRecord = new ExtraDataRecord();
                extraDataRecord.e((long) Raw.g(bArr, i12));
                int i13 = i12 + 2;
                int g11 = Raw.g(bArr, i13);
                if (g11 + 2 > i11) {
                    g11 = Raw.f(bArr, i13);
                    if (g11 + 2 > i11) {
                        break;
                    }
                }
                extraDataRecord.f(g11);
                int i14 = i13 + 2;
                if (g11 > 0) {
                    byte[] bArr2 = new byte[g11];
                    System.arraycopy(bArr, i14, bArr2, 0, g11);
                    extraDataRecord.d(bArr2);
                }
                i12 = i14 + g11;
                arrayList.add(extraDataRecord);
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (IOException e11) {
            throw new ZipException((Throwable) e11);
        }
    }

    public final byte[] m(RandomAccessFile randomAccessFile, byte[] bArr) throws ZipException {
        try {
            if (randomAccessFile.read(bArr, 0, bArr.length) != -1) {
                return bArr;
            }
            throw new ZipException("unexpected end of file when reading short buff");
        } catch (IOException e11) {
            throw new ZipException("IOException when reading short buff", (Throwable) e11);
        }
    }

    public LocalFileHeader n(FileHeader fileHeader) throws ZipException {
        if (fileHeader == null || this.f54996a == null) {
            throw new ZipException("invalid read parameters for local header");
        }
        long m11 = fileHeader.m();
        if (fileHeader.p() != null && fileHeader.p().c() > 0) {
            m11 = fileHeader.m();
        }
        if (m11 >= 0) {
            try {
                this.f54996a.seek(m11);
                LocalFileHeader localFileHeader = new LocalFileHeader();
                byte[] bArr = new byte[2];
                byte[] bArr2 = new byte[4];
                m(this.f54996a, bArr2);
                int c11 = Raw.c(bArr2, 0);
                if (((long) c11) == 67324752) {
                    localFileHeader.E(c11);
                    m(this.f54996a, bArr);
                    localFileHeader.G(Raw.g(bArr, 0));
                    m(this.f54996a, bArr);
                    localFileHeader.z((Raw.g(bArr, 0) & 2048) != 0);
                    byte b11 = bArr[0];
                    if ((b11 & 1) != 0) {
                        localFileHeader.t(true);
                    }
                    localFileHeader.A(bArr);
                    String binaryString = Integer.toBinaryString(b11);
                    if (binaryString.length() >= 4) {
                        localFileHeader.s(binaryString.charAt(3) == '1');
                    }
                    m(this.f54996a, bArr);
                    localFileHeader.p(Raw.g(bArr, 0));
                    m(this.f54996a, bArr2);
                    localFileHeader.B(Raw.c(bArr2, 0));
                    m(this.f54996a, bArr2);
                    localFileHeader.q((long) Raw.c(bArr2, 0));
                    localFileHeader.r((byte[]) bArr2.clone());
                    m(this.f54996a, bArr2);
                    localFileHeader.o(Raw.e(a(bArr2), 0));
                    m(this.f54996a, bArr2);
                    localFileHeader.F(Raw.e(a(bArr2), 0));
                    m(this.f54996a, bArr);
                    int g11 = Raw.g(bArr, 0);
                    localFileHeader.y(g11);
                    m(this.f54996a, bArr);
                    int g12 = Raw.g(bArr, 0);
                    localFileHeader.w(g12);
                    int i11 = 30;
                    if (g11 > 0) {
                        byte[] bArr3 = new byte[g11];
                        m(this.f54996a, bArr3);
                        String e11 = Zip4jUtil.e(bArr3, localFileHeader.m());
                        if (e11 != null) {
                            if (e11.indexOf(":" + System.getProperty("file.separator")) >= 0) {
                                e11 = e11.substring(e11.indexOf(":" + System.getProperty("file.separator")) + 2);
                            }
                            localFileHeader.x(e11);
                            i11 = 30 + g11;
                        } else {
                            throw new ZipException("file name is null, cannot assign file name to local file header");
                        }
                    } else {
                        localFileHeader.x((String) null);
                    }
                    g(localFileHeader);
                    localFileHeader.C(m11 + ((long) (i11 + g12)));
                    localFileHeader.D(fileHeader.n());
                    i(localFileHeader);
                    e(localFileHeader);
                    if (localFileHeader.l()) {
                        if (localFileHeader.e() != 99) {
                            if ((b11 & SignedBytes.MAX_POWER_OF_TWO) == 64) {
                                localFileHeader.u(1);
                            } else {
                                localFileHeader.u(0);
                            }
                        }
                    }
                    if (localFileHeader.d() <= 0) {
                        localFileHeader.q(fileHeader.d());
                        localFileHeader.r(fileHeader.e());
                    }
                    if (localFileHeader.b() <= 0) {
                        localFileHeader.o(fileHeader.b());
                    }
                    if (localFileHeader.k() <= 0) {
                        localFileHeader.F(fileHeader.o());
                    }
                    return localFileHeader;
                }
                throw new ZipException("invalid local header signature for file: " + fileHeader.k());
            } catch (IOException e12) {
                throw new ZipException((Throwable) e12);
            }
        } else {
            throw new ZipException("invalid local header offset");
        }
    }

    public final Zip64EndCentralDirLocator o() throws ZipException {
        if (this.f54996a != null) {
            try {
                Zip64EndCentralDirLocator zip64EndCentralDirLocator = new Zip64EndCentralDirLocator();
                r();
                byte[] bArr = new byte[4];
                byte[] bArr2 = new byte[8];
                m(this.f54996a, bArr);
                long c11 = (long) Raw.c(bArr, 0);
                if (c11 == 117853008) {
                    this.f54997b.p(true);
                    zip64EndCentralDirLocator.d(c11);
                    m(this.f54996a, bArr);
                    zip64EndCentralDirLocator.b(Raw.c(bArr, 0));
                    m(this.f54996a, bArr2);
                    zip64EndCentralDirLocator.c(Raw.e(bArr2, 0));
                    m(this.f54996a, bArr);
                    zip64EndCentralDirLocator.e(Raw.c(bArr, 0));
                    return zip64EndCentralDirLocator;
                }
                this.f54997b.p(false);
                return null;
            } catch (Exception e11) {
                throw new ZipException((Throwable) e11);
            }
        } else {
            throw new ZipException("invalid file handler when trying to read Zip64EndCentralDirLocator");
        }
    }

    public final Zip64EndCentralDirRecord p() throws ZipException {
        if (this.f54997b.e() != null) {
            long a11 = this.f54997b.e().a();
            if (a11 >= 0) {
                try {
                    this.f54996a.seek(a11);
                    Zip64EndCentralDirRecord zip64EndCentralDirRecord = new Zip64EndCentralDirRecord();
                    byte[] bArr = new byte[2];
                    byte[] bArr2 = new byte[4];
                    byte[] bArr3 = new byte[8];
                    m(this.f54996a, bArr2);
                    long c11 = (long) Raw.c(bArr2, 0);
                    if (c11 == 101075792) {
                        zip64EndCentralDirRecord.i(c11);
                        m(this.f54996a, bArr3);
                        zip64EndCentralDirRecord.k(Raw.e(bArr3, 0));
                        m(this.f54996a, bArr);
                        zip64EndCentralDirRecord.n(Raw.g(bArr, 0));
                        m(this.f54996a, bArr);
                        zip64EndCentralDirRecord.o(Raw.g(bArr, 0));
                        m(this.f54996a, bArr2);
                        zip64EndCentralDirRecord.f(Raw.c(bArr2, 0));
                        m(this.f54996a, bArr2);
                        zip64EndCentralDirRecord.g(Raw.c(bArr2, 0));
                        m(this.f54996a, bArr3);
                        zip64EndCentralDirRecord.m(Raw.e(bArr3, 0));
                        m(this.f54996a, bArr3);
                        zip64EndCentralDirRecord.l(Raw.e(bArr3, 0));
                        m(this.f54996a, bArr3);
                        zip64EndCentralDirRecord.j(Raw.e(bArr3, 0));
                        m(this.f54996a, bArr3);
                        zip64EndCentralDirRecord.h(Raw.e(bArr3, 0));
                        long c12 = zip64EndCentralDirRecord.c() - 44;
                        if (c12 > 0) {
                            byte[] bArr4 = new byte[((int) c12)];
                            m(this.f54996a, bArr4);
                            zip64EndCentralDirRecord.e(bArr4);
                        }
                        return zip64EndCentralDirRecord;
                    }
                    throw new ZipException("invalid signature for zip64 end of central directory record");
                } catch (IOException e11) {
                    throw new ZipException((Throwable) e11);
                }
            } else {
                throw new ZipException("invalid offset for start of end of central directory record");
            }
        } else {
            throw new ZipException("invalid zip64 end of central directory locator");
        }
    }

    public final Zip64ExtendedInfo q(ArrayList arrayList, long j11, long j12, long j13, int i11) throws ZipException {
        boolean z11;
        int i12;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            ExtraDataRecord extraDataRecord = (ExtraDataRecord) arrayList.get(i13);
            if (extraDataRecord != null && extraDataRecord.b() == 1) {
                Zip64ExtendedInfo zip64ExtendedInfo = new Zip64ExtendedInfo();
                byte[] a11 = extraDataRecord.a();
                if (extraDataRecord.c() <= 0) {
                    return null;
                }
                byte[] bArr = new byte[8];
                byte[] bArr2 = new byte[4];
                boolean z12 = true;
                if ((j11 & WebSocketProtocol.PAYLOAD_SHORT_MAX) != WebSocketProtocol.PAYLOAD_SHORT_MAX || extraDataRecord.c() <= 0) {
                    i12 = 0;
                    z11 = false;
                } else {
                    System.arraycopy(a11, 0, bArr, 0, 8);
                    zip64ExtendedInfo.h(Raw.e(bArr, 0));
                    i12 = 8;
                    z11 = true;
                }
                if ((j12 & WebSocketProtocol.PAYLOAD_SHORT_MAX) == WebSocketProtocol.PAYLOAD_SHORT_MAX && i12 < extraDataRecord.c()) {
                    System.arraycopy(a11, i12, bArr, 0, 8);
                    zip64ExtendedInfo.e(Raw.e(bArr, 0));
                    i12 += 8;
                    z11 = true;
                }
                if ((j13 & WebSocketProtocol.PAYLOAD_SHORT_MAX) == WebSocketProtocol.PAYLOAD_SHORT_MAX && i12 < extraDataRecord.c()) {
                    System.arraycopy(a11, i12, bArr, 0, 8);
                    zip64ExtendedInfo.g(Raw.e(bArr, 0));
                    i12 += 8;
                    z11 = true;
                }
                if ((i11 & 65535) != 65535 || i12 >= extraDataRecord.c()) {
                    z12 = z11;
                } else {
                    System.arraycopy(a11, i12, bArr2, 0, 4);
                    zip64ExtendedInfo.f(Raw.c(bArr2, 0));
                }
                if (z12) {
                    return zip64ExtendedInfo;
                }
                return null;
            }
        }
        return null;
    }

    public final void r() throws ZipException {
        try {
            byte[] bArr = new byte[4];
            long length = this.f54996a.length() - 22;
            while (true) {
                long j11 = length - 1;
                this.f54996a.seek(length);
                if (((long) Raw.d(this.f54996a, bArr)) == 101010256) {
                    RandomAccessFile randomAccessFile = this.f54996a;
                    randomAccessFile.seek(((((randomAccessFile.getFilePointer() - 4) - 4) - 8) - 4) - 4);
                    return;
                }
                length = j11;
            }
        } catch (IOException e11) {
            throw new ZipException((Throwable) e11);
        }
    }
}
