package m1;

import android.content.res.AssetManager;
import android.location.Location;
import android.media.MediaDataSource;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.camera.core.impl.utils.ExifData;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.jumio.analytics.MobileEvents;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import m1.b;
import net.sf.scuba.smartcards.ISO7816;
import org.jmrtd.lds.CVCAFile;

public class a {
    public static final int[] A = {8};
    public static final byte[] B = {-1, ISO7816.INS_LOAD_KEY_FILE, -1};
    public static final byte[] C = {102, 116, 121, ISO7816.INS_MANAGE_CHANNEL};
    public static final byte[] D = {109, 105, 102, Framer.STDOUT_FRAME_PREFIX};
    public static final byte[] E = {104, 101, 105, 99};
    public static final byte[] F = {79, 76, 89, 77, 80, 0};
    public static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] H = {-119, 80, 78, 71, 13, 10, Ascii.SUB, 10};
    public static final byte[] I = {101, 88, 73, 102};
    public static final byte[] J = {73, 72, ISO7816.INS_REHABILITATE_CHV, 82};
    public static final byte[] K = {73, 69, 78, ISO7816.INS_REHABILITATE_CHV};
    public static final byte[] L = {82, 73, 70, 70};
    public static final byte[] M = {87, 69, CVCAFile.CAR_TAG, 80};
    public static final byte[] N = {69, 88, 73, 70};
    public static final byte[] O = {-99, 1, ISO7816.INS_PSO};
    public static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    public static SimpleDateFormat U;
    public static SimpleDateFormat V;
    public static final String[] W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};
    public static final e[] Z;

    /* renamed from: a0  reason: collision with root package name */
    public static final e[] f16073a0;

    /* renamed from: b0  reason: collision with root package name */
    public static final e[] f16074b0;

    /* renamed from: c0  reason: collision with root package name */
    public static final e[] f16075c0;

    /* renamed from: d0  reason: collision with root package name */
    public static final e[] f16076d0;

    /* renamed from: e0  reason: collision with root package name */
    public static final e f16077e0 = new e("StripOffsets", TUIMessageBean.MSG_STATUS_READ, 3);

    /* renamed from: f0  reason: collision with root package name */
    public static final e[] f16078f0;

    /* renamed from: g0  reason: collision with root package name */
    public static final e[] f16079g0;

    /* renamed from: h0  reason: collision with root package name */
    public static final e[] f16080h0;

    /* renamed from: i0  reason: collision with root package name */
    public static final e[] f16081i0;

    /* renamed from: j0  reason: collision with root package name */
    public static final e[][] f16082j0;

    /* renamed from: k0  reason: collision with root package name */
    public static final e[] f16083k0 = {new e(ExifData.TAG_SUB_IFD_POINTER, 330, 4), new e(ExifData.TAG_EXIF_IFD_POINTER, 34665, 4), new e(ExifData.TAG_GPS_INFO_IFD_POINTER, 34853, 4), new e(ExifData.TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};

    /* renamed from: l0  reason: collision with root package name */
    public static final HashMap<Integer, e>[] f16084l0;

    /* renamed from: m0  reason: collision with root package name */
    public static final HashMap<String, e>[] f16085m0;

    /* renamed from: n0  reason: collision with root package name */
    public static final HashSet<String> f16086n0 = new HashSet<>(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));

    /* renamed from: o0  reason: collision with root package name */
    public static final HashMap<Integer, Integer> f16087o0 = new HashMap<>();

    /* renamed from: p0  reason: collision with root package name */
    public static final Charset f16088p0;

    /* renamed from: q0  reason: collision with root package name */
    public static final byte[] f16089q0;

    /* renamed from: r0  reason: collision with root package name */
    public static final byte[] f16090r0;

    /* renamed from: s0  reason: collision with root package name */
    public static final Pattern f16091s0 = Pattern.compile(".*[1-9].*");

    /* renamed from: t0  reason: collision with root package name */
    public static final Pattern f16092t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: u0  reason: collision with root package name */
    public static final Pattern f16093u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: v  reason: collision with root package name */
    public static final boolean f16094v = Log.isLoggable("ExifInterface", 3);

    /* renamed from: v0  reason: collision with root package name */
    public static final Pattern f16095v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");

    /* renamed from: w  reason: collision with root package name */
    public static final List<Integer> f16096w = Arrays.asList(new Integer[]{1, 6, 3, 8});

    /* renamed from: x  reason: collision with root package name */
    public static final List<Integer> f16097x = Arrays.asList(new Integer[]{2, 7, 4, 5});

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f16098y = {8, 8, 8};

    /* renamed from: z  reason: collision with root package name */
    public static final int[] f16099z = {4};

    /* renamed from: a  reason: collision with root package name */
    public String f16100a;

    /* renamed from: b  reason: collision with root package name */
    public FileDescriptor f16101b;

    /* renamed from: c  reason: collision with root package name */
    public AssetManager.AssetInputStream f16102c;

    /* renamed from: d  reason: collision with root package name */
    public int f16103d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16104e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, d>[] f16105f;

    /* renamed from: g  reason: collision with root package name */
    public Set<Integer> f16106g;

    /* renamed from: h  reason: collision with root package name */
    public ByteOrder f16107h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16108i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16109j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16110k;

    /* renamed from: l  reason: collision with root package name */
    public int f16111l;

    /* renamed from: m  reason: collision with root package name */
    public int f16112m;

    /* renamed from: n  reason: collision with root package name */
    public byte[] f16113n;

    /* renamed from: o  reason: collision with root package name */
    public int f16114o;

    /* renamed from: p  reason: collision with root package name */
    public int f16115p;

    /* renamed from: q  reason: collision with root package name */
    public int f16116q;

    /* renamed from: r  reason: collision with root package name */
    public int f16117r;

    /* renamed from: s  reason: collision with root package name */
    public int f16118s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f16119t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f16120u;

    /* renamed from: m1.a$a  reason: collision with other inner class name */
    public class C0089a extends MediaDataSource {

        /* renamed from: b  reason: collision with root package name */
        public long f16121b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f16122c;

        public C0089a(g gVar) {
            this.f16122c = gVar;
        }

        public void close() throws IOException {
        }

        public long getSize() throws IOException {
            return -1;
        }

        public int readAt(long j11, byte[] bArr, int i11, int i12) throws IOException {
            if (i12 == 0) {
                return 0;
            }
            if (j11 < 0) {
                return -1;
            }
            try {
                long j12 = this.f16121b;
                if (j12 != j11) {
                    if (j12 >= 0 && j11 >= j12 + ((long) this.f16122c.available())) {
                        return -1;
                    }
                    this.f16122c.g(j11);
                    this.f16121b = j11;
                }
                if (i12 > this.f16122c.available()) {
                    i12 = this.f16122c.available();
                }
                int read = this.f16122c.read(bArr, i11, i12);
                if (read >= 0) {
                    this.f16121b += (long) read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f16121b = -1;
            return -1;
        }
    }

    public static class b extends InputStream implements DataInput {

        /* renamed from: f  reason: collision with root package name */
        public static final ByteOrder f16124f = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: g  reason: collision with root package name */
        public static final ByteOrder f16125g = ByteOrder.BIG_ENDIAN;

        /* renamed from: b  reason: collision with root package name */
        public final DataInputStream f16126b;

        /* renamed from: c  reason: collision with root package name */
        public ByteOrder f16127c;

        /* renamed from: d  reason: collision with root package name */
        public int f16128d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f16129e;

        public b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return this.f16128d;
        }

        public int available() throws IOException {
            return this.f16126b.available();
        }

        public long b() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        public void e(ByteOrder byteOrder) {
            this.f16127c = byteOrder;
        }

        public void f(int i11) throws IOException {
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i11 - i12;
                int skip = (int) this.f16126b.skip((long) i13);
                if (skip <= 0) {
                    if (this.f16129e == null) {
                        this.f16129e = new byte[8192];
                    }
                    skip = this.f16126b.read(this.f16129e, 0, Math.min(8192, i13));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i11 + " bytes.");
                    }
                }
                i12 += skip;
            }
            this.f16128d += i12;
        }

        public void mark(int i11) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        public int read() throws IOException {
            this.f16128d++;
            return this.f16126b.read();
        }

        public boolean readBoolean() throws IOException {
            this.f16128d++;
            return this.f16126b.readBoolean();
        }

        public byte readByte() throws IOException {
            this.f16128d++;
            int read = this.f16126b.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        public char readChar() throws IOException {
            this.f16128d += 2;
            return this.f16126b.readChar();
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        public void readFully(byte[] bArr, int i11, int i12) throws IOException {
            this.f16128d += i12;
            this.f16126b.readFully(bArr, i11, i12);
        }

        public int readInt() throws IOException {
            this.f16128d += 4;
            int read = this.f16126b.read();
            int read2 = this.f16126b.read();
            int read3 = this.f16126b.read();
            int read4 = this.f16126b.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f16127c;
                if (byteOrder == f16124f) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f16125g) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f16127c);
            }
            throw new EOFException();
        }

        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        public long readLong() throws IOException {
            this.f16128d += 8;
            int read = this.f16126b.read();
            int read2 = this.f16126b.read();
            int read3 = this.f16126b.read();
            int read4 = this.f16126b.read();
            int read5 = this.f16126b.read();
            int read6 = this.f16126b.read();
            int read7 = this.f16126b.read();
            int read8 = this.f16126b.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f16127c;
                if (byteOrder == f16124f) {
                    return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                }
                int i11 = read2;
                if (byteOrder == f16125g) {
                    return (((long) read) << 56) + (((long) i11) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                }
                throw new IOException("Invalid byte order: " + this.f16127c);
            }
            throw new EOFException();
        }

        public short readShort() throws IOException {
            this.f16128d += 2;
            int read = this.f16126b.read();
            int read2 = this.f16126b.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f16127c;
                if (byteOrder == f16124f) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f16125g) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f16127c);
            }
            throw new EOFException();
        }

        public String readUTF() throws IOException {
            this.f16128d += 2;
            return this.f16126b.readUTF();
        }

        public int readUnsignedByte() throws IOException {
            this.f16128d++;
            return this.f16126b.readUnsignedByte();
        }

        public int readUnsignedShort() throws IOException {
            this.f16128d += 2;
            int read = this.f16126b.read();
            int read2 = this.f16126b.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f16127c;
                if (byteOrder == f16124f) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f16125g) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f16127c);
            }
            throw new EOFException();
        }

        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        public int skipBytes(int i11) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f16127c = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f16126b = dataInputStream;
            dataInputStream.mark(0);
            this.f16128d = 0;
            this.f16127c = byteOrder;
        }

        public int read(byte[] bArr, int i11, int i12) throws IOException {
            int read = this.f16126b.read(bArr, i11, i12);
            this.f16128d += read;
            return read;
        }

        public void readFully(byte[] bArr) throws IOException {
            this.f16128d += bArr.length;
            this.f16126b.readFully(bArr);
        }
    }

    public static class c extends FilterOutputStream {

        /* renamed from: b  reason: collision with root package name */
        public final OutputStream f16130b;

        /* renamed from: c  reason: collision with root package name */
        public ByteOrder f16131c;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f16130b = outputStream;
            this.f16131c = byteOrder;
        }

        public void a(ByteOrder byteOrder) {
            this.f16131c = byteOrder;
        }

        public void b(int i11) throws IOException {
            this.f16130b.write(i11);
        }

        public void e(int i11) throws IOException {
            ByteOrder byteOrder = this.f16131c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f16130b.write((i11 >>> 0) & 255);
                this.f16130b.write((i11 >>> 8) & 255);
                this.f16130b.write((i11 >>> 16) & 255);
                this.f16130b.write((i11 >>> 24) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f16130b.write((i11 >>> 24) & 255);
                this.f16130b.write((i11 >>> 16) & 255);
                this.f16130b.write((i11 >>> 8) & 255);
                this.f16130b.write((i11 >>> 0) & 255);
            }
        }

        public void f(short s11) throws IOException {
            ByteOrder byteOrder = this.f16131c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f16130b.write((s11 >>> 0) & 255);
                this.f16130b.write((s11 >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f16130b.write((s11 >>> 8) & 255);
                this.f16130b.write((s11 >>> 0) & 255);
            }
        }

        public void g(long j11) throws IOException {
            e((int) j11);
        }

        public void j(int i11) throws IOException {
            f((short) i11);
        }

        public void write(byte[] bArr) throws IOException {
            this.f16130b.write(bArr);
        }

        public void write(byte[] bArr, int i11, int i12) throws IOException {
            this.f16130b.write(bArr, i11, i12);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f16132a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16133b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16134c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f16135d;

        public d(int i11, int i12, byte[] bArr) {
            this(i11, i12, -1, bArr);
        }

        public static d a(String str) {
            if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
                byte[] bytes = str.getBytes(a.f16088p0);
                return new d(1, bytes.length, bytes);
            }
            return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double putDouble : dArr) {
                wrap.putDouble(putDouble);
            }
            return new d(12, dArr.length, wrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int putInt : iArr) {
                wrap.putInt(putInt);
            }
            return new d(9, iArr.length, wrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[10] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f16140a);
                wrap.putInt((int) fVar.f16141b);
            }
            return new d(10, fVarArr.length, wrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + 0).getBytes(a.f16088p0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j11, ByteOrder byteOrder) {
            return g(new long[]{j11}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j11 : jArr) {
                wrap.putInt((int) j11);
            }
            return new d(4, jArr.length, wrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[5] * fVarArr.length)]);
            wrap.order(byteOrder);
            for (f fVar : fVarArr) {
                wrap.putInt((int) fVar.f16140a);
                wrap.putInt((int) fVar.f16141b);
            }
            return new d(5, fVarArr.length, wrap.array());
        }

        public static d j(int i11, ByteOrder byteOrder) {
            return k(new int[]{i11}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.X[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i11 : iArr) {
                wrap.putShort((short) i11);
            }
            return new d(3, iArr.length, wrap.array());
        }

        public double l(ByteOrder byteOrder) {
            Object o11 = o(byteOrder);
            if (o11 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (o11 instanceof String) {
                return Double.parseDouble((String) o11);
            } else {
                if (o11 instanceof long[]) {
                    long[] jArr = (long[]) o11;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o11 instanceof int[]) {
                    int[] iArr = (int[]) o11;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o11 instanceof double[]) {
                    double[] dArr = (double[]) o11;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o11 instanceof f[]) {
                    f[] fVarArr = (f[]) o11;
                    if (fVarArr.length == 1) {
                        return fVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int m(ByteOrder byteOrder) {
            Object o11 = o(byteOrder);
            if (o11 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (o11 instanceof String) {
                return Integer.parseInt((String) o11);
            } else {
                if (o11 instanceof long[]) {
                    long[] jArr = (long[]) o11;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (o11 instanceof int[]) {
                    int[] iArr = (int[]) o11;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String n(ByteOrder byteOrder) {
            Object o11 = o(byteOrder);
            if (o11 == null) {
                return null;
            }
            if (o11 instanceof String) {
                return (String) o11;
            }
            StringBuilder sb2 = new StringBuilder();
            int i11 = 0;
            if (o11 instanceof long[]) {
                long[] jArr = (long[]) o11;
                while (i11 < jArr.length) {
                    sb2.append(jArr[i11]);
                    i11++;
                    if (i11 != jArr.length) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                return sb2.toString();
            } else if (o11 instanceof int[]) {
                int[] iArr = (int[]) o11;
                while (i11 < iArr.length) {
                    sb2.append(iArr[i11]);
                    i11++;
                    if (i11 != iArr.length) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                return sb2.toString();
            } else if (o11 instanceof double[]) {
                double[] dArr = (double[]) o11;
                while (i11 < dArr.length) {
                    sb2.append(dArr[i11]);
                    i11++;
                    if (i11 != dArr.length) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                return sb2.toString();
            } else if (!(o11 instanceof f[])) {
                return null;
            } else {
                f[] fVarArr = (f[]) o11;
                while (i11 < fVarArr.length) {
                    sb2.append(fVarArr[i11].f16140a);
                    sb2.append('/');
                    sb2.append(fVarArr[i11].f16141b);
                    i11++;
                    if (i11 != fVarArr.length) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
                return sb2.toString();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:164:0x019f A[SYNTHETIC, Splitter:B:164:0x019f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object o(java.nio.ByteOrder r11) {
            /*
                r10 = this;
                java.lang.String r0 = "IOException occurred while closing InputStream"
                java.lang.String r1 = "ExifInterface"
                r2 = 0
                m1.a$b r3 = new m1.a$b     // Catch:{ IOException -> 0x0189, all -> 0x0187 }
                byte[] r4 = r10.f16135d     // Catch:{ IOException -> 0x0189, all -> 0x0187 }
                r3.<init>((byte[]) r4)     // Catch:{ IOException -> 0x0189, all -> 0x0187 }
                r3.e(r11)     // Catch:{ IOException -> 0x0185 }
                int r11 = r10.f16132a     // Catch:{ IOException -> 0x0185 }
                r4 = 1
                r5 = 0
                switch(r11) {
                    case 1: goto L_0x0148;
                    case 2: goto L_0x00fd;
                    case 3: goto L_0x00e3;
                    case 4: goto L_0x00c9;
                    case 5: goto L_0x00a6;
                    case 6: goto L_0x0148;
                    case 7: goto L_0x00fd;
                    case 8: goto L_0x008c;
                    case 9: goto L_0x0072;
                    case 10: goto L_0x004d;
                    case 11: goto L_0x0032;
                    case 12: goto L_0x0018;
                    default: goto L_0x0016;
                }     // Catch:{ IOException -> 0x0185 }
            L_0x0016:
                goto L_0x017c
            L_0x0018:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x001c:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x0029
                double r6 = r3.readDouble()     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x001c
            L_0x0029:
                r3.close()     // Catch:{ IOException -> 0x002d }
                goto L_0x0031
            L_0x002d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0031:
                return r11
            L_0x0032:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                double[] r11 = new double[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x0036:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x0044
                float r4 = r3.readFloat()     // Catch:{ IOException -> 0x0185 }
                double r6 = (double) r4     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x0036
            L_0x0044:
                r3.close()     // Catch:{ IOException -> 0x0048 }
                goto L_0x004c
            L_0x0048:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x004c:
                return r11
            L_0x004d:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                m1.a$f[] r11 = new m1.a.f[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x0051:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x0069
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0185 }
                long r6 = (long) r4     // Catch:{ IOException -> 0x0185 }
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0185 }
                long r8 = (long) r4     // Catch:{ IOException -> 0x0185 }
                m1.a$f r4 = new m1.a$f     // Catch:{ IOException -> 0x0185 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x0051
            L_0x0069:
                r3.close()     // Catch:{ IOException -> 0x006d }
                goto L_0x0071
            L_0x006d:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0071:
                return r11
            L_0x0072:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x0076:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x0083
                int r4 = r3.readInt()     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x0076
            L_0x0083:
                r3.close()     // Catch:{ IOException -> 0x0087 }
                goto L_0x008b
            L_0x0087:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x008b:
                return r11
            L_0x008c:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x0090:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x009d
                short r4 = r3.readShort()     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x0090
            L_0x009d:
                r3.close()     // Catch:{ IOException -> 0x00a1 }
                goto L_0x00a5
            L_0x00a1:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00a5:
                return r11
            L_0x00a6:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                m1.a$f[] r11 = new m1.a.f[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x00aa:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x00c0
                long r6 = r3.b()     // Catch:{ IOException -> 0x0185 }
                long r8 = r3.b()     // Catch:{ IOException -> 0x0185 }
                m1.a$f r4 = new m1.a$f     // Catch:{ IOException -> 0x0185 }
                r4.<init>(r6, r8)     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x00aa
            L_0x00c0:
                r3.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00c8
            L_0x00c4:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00c8:
                return r11
            L_0x00c9:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                long[] r11 = new long[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x00cd:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x00da
                long r6 = r3.b()     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r6     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x00cd
            L_0x00da:
                r3.close()     // Catch:{ IOException -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00e2:
                return r11
            L_0x00e3:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                int[] r11 = new int[r11]     // Catch:{ IOException -> 0x0185 }
            L_0x00e7:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x00f4
                int r4 = r3.readUnsignedShort()     // Catch:{ IOException -> 0x0185 }
                r11[r5] = r4     // Catch:{ IOException -> 0x0185 }
                int r5 = r5 + 1
                goto L_0x00e7
            L_0x00f4:
                r3.close()     // Catch:{ IOException -> 0x00f8 }
                goto L_0x00fc
            L_0x00f8:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x00fc:
                return r11
            L_0x00fd:
                int r11 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                byte[] r6 = m1.a.Y     // Catch:{ IOException -> 0x0185 }
                int r6 = r6.length     // Catch:{ IOException -> 0x0185 }
                if (r11 < r6) goto L_0x011a
                r11 = r5
            L_0x0105:
                byte[] r6 = m1.a.Y     // Catch:{ IOException -> 0x0185 }
                int r7 = r6.length     // Catch:{ IOException -> 0x0185 }
                if (r11 >= r7) goto L_0x0117
                byte[] r7 = r10.f16135d     // Catch:{ IOException -> 0x0185 }
                byte r7 = r7[r11]     // Catch:{ IOException -> 0x0185 }
                byte r8 = r6[r11]     // Catch:{ IOException -> 0x0185 }
                if (r7 == r8) goto L_0x0114
                r4 = r5
                goto L_0x0117
            L_0x0114:
                int r11 = r11 + 1
                goto L_0x0105
            L_0x0117:
                if (r4 == 0) goto L_0x011a
                int r5 = r6.length     // Catch:{ IOException -> 0x0185 }
            L_0x011a:
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0185 }
                r11.<init>()     // Catch:{ IOException -> 0x0185 }
            L_0x011f:
                int r4 = r10.f16133b     // Catch:{ IOException -> 0x0185 }
                if (r5 >= r4) goto L_0x013b
                byte[] r4 = r10.f16135d     // Catch:{ IOException -> 0x0185 }
                byte r4 = r4[r5]     // Catch:{ IOException -> 0x0185 }
                if (r4 != 0) goto L_0x012a
                goto L_0x013b
            L_0x012a:
                r6 = 32
                if (r4 < r6) goto L_0x0133
                char r4 = (char) r4     // Catch:{ IOException -> 0x0185 }
                r11.append(r4)     // Catch:{ IOException -> 0x0185 }
                goto L_0x0138
            L_0x0133:
                r4 = 63
                r11.append(r4)     // Catch:{ IOException -> 0x0185 }
            L_0x0138:
                int r5 = r5 + 1
                goto L_0x011f
            L_0x013b:
                java.lang.String r11 = r11.toString()     // Catch:{ IOException -> 0x0185 }
                r3.close()     // Catch:{ IOException -> 0x0143 }
                goto L_0x0147
            L_0x0143:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x0147:
                return r11
            L_0x0148:
                byte[] r11 = r10.f16135d     // Catch:{ IOException -> 0x0185 }
                int r6 = r11.length     // Catch:{ IOException -> 0x0185 }
                if (r6 != r4) goto L_0x016c
                byte r6 = r11[r5]     // Catch:{ IOException -> 0x0185 }
                if (r6 < 0) goto L_0x016c
                byte r6 = r11[r5]     // Catch:{ IOException -> 0x0185 }
                if (r6 > r4) goto L_0x016c
                java.lang.String r6 = new java.lang.String     // Catch:{ IOException -> 0x0185 }
                char[] r4 = new char[r4]     // Catch:{ IOException -> 0x0185 }
                byte r11 = r11[r5]     // Catch:{ IOException -> 0x0185 }
                int r11 = r11 + 48
                char r11 = (char) r11     // Catch:{ IOException -> 0x0185 }
                r4[r5] = r11     // Catch:{ IOException -> 0x0185 }
                r6.<init>(r4)     // Catch:{ IOException -> 0x0185 }
                r3.close()     // Catch:{ IOException -> 0x0167 }
                goto L_0x016b
            L_0x0167:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x016b:
                return r6
            L_0x016c:
                java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x0185 }
                java.nio.charset.Charset r5 = m1.a.f16088p0     // Catch:{ IOException -> 0x0185 }
                r4.<init>(r11, r5)     // Catch:{ IOException -> 0x0185 }
                r3.close()     // Catch:{ IOException -> 0x0177 }
                goto L_0x017b
            L_0x0177:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x017b:
                return r4
            L_0x017c:
                r3.close()     // Catch:{ IOException -> 0x0180 }
                goto L_0x0184
            L_0x0180:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x0184:
                return r2
            L_0x0185:
                r11 = move-exception
                goto L_0x018b
            L_0x0187:
                r11 = move-exception
                goto L_0x019d
            L_0x0189:
                r11 = move-exception
                r3 = r2
            L_0x018b:
                java.lang.String r4 = "IOException occurred during reading a value"
                android.util.Log.w(r1, r4, r11)     // Catch:{ all -> 0x019b }
                if (r3 == 0) goto L_0x019a
                r3.close()     // Catch:{ IOException -> 0x0196 }
                goto L_0x019a
            L_0x0196:
                r11 = move-exception
                android.util.Log.e(r1, r0, r11)
            L_0x019a:
                return r2
            L_0x019b:
                r11 = move-exception
                r2 = r3
            L_0x019d:
                if (r2 == 0) goto L_0x01a7
                r2.close()     // Catch:{ IOException -> 0x01a3 }
                goto L_0x01a7
            L_0x01a3:
                r2 = move-exception
                android.util.Log.e(r1, r0, r2)
            L_0x01a7:
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: m1.a.d.o(java.nio.ByteOrder):java.lang.Object");
        }

        public int p() {
            return a.X[this.f16132a] * this.f16133b;
        }

        public String toString() {
            return "(" + a.W[this.f16132a] + ", data length:" + this.f16135d.length + ")";
        }

        public d(int i11, int i12, long j11, byte[] bArr) {
            this.f16132a = i11;
            this.f16133b = i12;
            this.f16134c = j11;
            this.f16135d = bArr;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public final long f16140a;

        /* renamed from: b  reason: collision with root package name */
        public final long f16141b;

        public f(double d11) {
            this((long) (d11 * 10000.0d), 10000);
        }

        public double a() {
            return ((double) this.f16140a) / ((double) this.f16141b);
        }

        public String toString() {
            return this.f16140a + "/" + this.f16141b;
        }

        public f(long j11, long j12) {
            if (j12 == 0) {
                this.f16140a = 0;
                this.f16141b = 1;
                return;
            }
            this.f16140a = j11;
            this.f16141b = j12;
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", TUIMessageBean.MSG_STATUS_READ, 3, 4), new e("Orientation", TUIMessageBean.MSG_STATUS_DELETE, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", MobileEvents.EVENTTYPE_EXCEPTION, 2), new e("DateTime", MobileEvents.EVENTTYPE_SDKPARAMETERS, 2), new e("Artist", MobileEvents.EVENTTYPE_CV, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", MobileEvents.EVENTTYPE_PERFORMANCE, 5), new e(ExifData.TAG_SUB_IFD_POINTER, 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e(ExifData.TAG_EXIF_IFD_POINTER, 34665, 4), new e(ExifData.TAG_GPS_INFO_IFD_POINTER, 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e(ExifData.TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f16073a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        f16074b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        f16075c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", TUIMessageBean.MSG_STATUS_READ, 3, 4), new e("ThumbnailOrientation", TUIMessageBean.MSG_STATUS_DELETE, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", MobileEvents.EVENTTYPE_EXCEPTION, 2), new e("DateTime", MobileEvents.EVENTTYPE_SDKPARAMETERS, 2), new e("Artist", MobileEvents.EVENTTYPE_CV, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", MobileEvents.EVENTTYPE_PERFORMANCE, 5), new e(ExifData.TAG_SUB_IFD_POINTER, 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Xmp", 700, 1), new e("Copyright", 33432, 2), new e(ExifData.TAG_EXIF_IFD_POINTER, 34665, 4), new e(ExifData.TAG_GPS_INFO_IFD_POINTER, 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        f16076d0 = eVarArr5;
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f16078f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4)};
        f16079g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        f16080h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        f16081i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        f16082j0 = eVarArr10;
        f16084l0 = new HashMap[eVarArr10.length];
        f16085m0 = new HashMap[eVarArr10.length];
        Charset forName = Charset.forName(C.ASCII_NAME);
        f16088p0 = forName;
        f16089q0 = "Exif\u0000\u0000".getBytes(forName);
        f16090r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        int i11 = 0;
        while (true) {
            e[][] eVarArr11 = f16082j0;
            if (i11 < eVarArr11.length) {
                f16084l0[i11] = new HashMap<>();
                f16085m0[i11] = new HashMap<>();
                for (e eVar : eVarArr11[i11]) {
                    f16084l0[i11].put(Integer.valueOf(eVar.f16136a), eVar);
                    f16085m0[i11].put(eVar.f16137b, eVar);
                }
                i11++;
            } else {
                HashMap<Integer, Integer> hashMap = f16087o0;
                e[] eVarArr12 = f16083k0;
                hashMap.put(Integer.valueOf(eVarArr12[0].f16136a), 5);
                hashMap.put(Integer.valueOf(eVarArr12[1].f16136a), 1);
                hashMap.put(Integer.valueOf(eVarArr12[2].f16136a), 2);
                hashMap.put(Integer.valueOf(eVarArr12[3].f16136a), 3);
                hashMap.put(Integer.valueOf(eVarArr12[4].f16136a), 7);
                hashMap.put(Integer.valueOf(eVarArr12[5].f16136a), 8);
                return;
            }
        }
    }

    public a(File file) throws IOException {
        e[][] eVarArr = f16082j0;
        this.f16105f = new HashMap[eVarArr.length];
        this.f16106g = new HashSet(eVarArr.length);
        this.f16107h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(file, "file cannot be null");
        B(file.getAbsolutePath());
    }

    public static boolean C(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f16089q0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i11 = 0;
        while (true) {
            byte[] bArr3 = f16089q0;
            if (i11 >= bArr3.length) {
                return true;
            }
            if (bArr2[i11] != bArr3[i11]) {
                return false;
            }
            i11++;
        }
    }

    public static boolean E(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = B;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    public static boolean J(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                b.a.c(fileDescriptor, 0, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                if (f16094v) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
            }
        }
        return false;
    }

    public static boolean L(int i11) {
        return i11 == 4 || i11 == 13 || i11 == 14 || i11 == 3 || i11 == 0;
    }

    public static double c(String str, String str2) {
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP, -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals("S")) {
                if (!str2.equals("W")) {
                    if (!str2.equals(KvStore.N)) {
                        if (!str2.equals("E")) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean g0(int i11) {
        return (i11 == 4 || i11 == 9 || i11 == 13 || i11 == 14) ? false : true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:68|69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        java.lang.Double.parseDouble(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015c, code lost:
        return new android.util.Pair<>(12, -1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0162, code lost:
        return new android.util.Pair<>(2, -1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> y(java.lang.String r12) {
        /*
            java.lang.String r0 = ","
            boolean r1 = r12.contains(r0)
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            if (r1 == 0) goto L_0x00a6
            java.lang.String[] r12 = r12.split(r0, r6)
            r0 = r12[r2]
            android.util.Pair r0 = y(r0)
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 != r4) goto L_0x0029
            return r0
        L_0x0029:
            int r1 = r12.length
            if (r3 >= r1) goto L_0x00a5
            r1 = r12[r3]
            android.util.Pair r1 = y(r1)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x004d
            java.lang.Object r2 = r1.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            java.lang.Object r4 = r0.first
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = r6
            goto L_0x0055
        L_0x004d:
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
        L_0x0055:
            java.lang.Object r4 = r0.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 == r6) goto L_0x0080
            java.lang.Object r4 = r1.first
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.lang.Object r8 = r0.second
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0077
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.lang.Object r4 = r0.second
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0080
        L_0x0077:
            java.lang.Object r1 = r0.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            goto L_0x0081
        L_0x0080:
            r1 = r6
        L_0x0081:
            if (r2 != r6) goto L_0x008b
            if (r1 != r6) goto L_0x008b
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x008b:
            if (r2 != r6) goto L_0x0097
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.<init>(r1, r7)
            goto L_0x00a2
        L_0x0097:
            if (r1 != r6) goto L_0x00a2
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r0.<init>(r1, r7)
        L_0x00a2:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x00a5:
            return r0
        L_0x00a6:
            java.lang.String r0 = "/"
            boolean r1 = r12.contains(r0)
            r8 = 0
            if (r1 == 0) goto L_0x0105
            java.lang.String[] r12 = r12.split(r0, r6)
            int r0 = r12.length
            if (r0 != r4) goto L_0x00ff
            r0 = r12[r2]     // Catch:{ NumberFormatException -> 0x00ff }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
            r12 = r12[r3]     // Catch:{ NumberFormatException -> 0x00ff }
            double r2 = java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x00ff }
            long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r4 = 10
            if (r12 < 0) goto L_0x00f5
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00d0
            goto L_0x00f5
        L_0x00d0:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r12 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r0 = 5
            if (r12 > 0) goto L_0x00eb
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 <= 0) goto L_0x00dd
            goto L_0x00eb
        L_0x00dd:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r1, r0)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00eb:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00f5:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
            return r12
        L_0x00ff:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        L_0x0105:
            long r0 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014e }
            long r1 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r2 = 4
            if (r1 < 0) goto L_0x0130
            long r3 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            r10 = 65535(0xffff, double:3.23786E-319)
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 > 0) goto L_0x0130
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0130:
            long r0 = r0.longValue()     // Catch:{ NumberFormatException -> 0x014e }
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0144
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            r1 = 9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x0144:
            android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x014e }
            r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x014e }
            return r0
        L_0x014e:
            java.lang.Double.parseDouble(r12)     // Catch:{ NumberFormatException -> 0x015d }
            android.util.Pair r12 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x015d }
            r0 = 12
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x015d }
            r12.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x015d }
            return r12
        L_0x015d:
            android.util.Pair r12 = new android.util.Pair
            r12.<init>(r5, r7)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.y(java.lang.String):android.util.Pair");
    }

    public final void A(b bVar, HashMap hashMap) throws IOException {
        b bVar2 = bVar;
        HashMap hashMap2 = hashMap;
        d dVar = (d) hashMap2.get("StripOffsets");
        d dVar2 = (d) hashMap2.get("StripByteCounts");
        if (dVar != null && dVar2 != null) {
            long[] d11 = b.d(dVar.o(this.f16107h));
            long[] d12 = b.d(dVar2.o(this.f16107h));
            if (d11 == null || d11.length == 0) {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            } else if (d12 == null || d12.length == 0) {
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            } else if (d11.length != d12.length) {
                Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j11 = 0;
                for (long j12 : d12) {
                    j11 += j12;
                }
                int i11 = (int) j11;
                byte[] bArr = new byte[i11];
                this.f16110k = true;
                this.f16109j = true;
                this.f16108i = true;
                int i12 = 0;
                int i13 = 0;
                for (int i14 = 0; i14 < d11.length; i14++) {
                    int i15 = (int) d11[i14];
                    int i16 = (int) d12[i14];
                    if (i14 < d11.length - 1 && ((long) (i15 + i16)) != d11[i14 + 1]) {
                        this.f16110k = false;
                    }
                    int i17 = i15 - i12;
                    if (i17 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    long j13 = (long) i17;
                    if (bVar2.skip(j13) != j13) {
                        Log.d("ExifInterface", "Failed to skip " + i17 + " bytes.");
                        return;
                    }
                    int i18 = i12 + i17;
                    byte[] bArr2 = new byte[i16];
                    if (bVar2.read(bArr2) != i16) {
                        Log.d("ExifInterface", "Failed to read " + i16 + " bytes.");
                        return;
                    }
                    i12 = i18 + i16;
                    System.arraycopy(bArr2, 0, bArr, i13, i16);
                    i13 += i16;
                }
                this.f16113n = bArr;
                if (this.f16110k) {
                    this.f16111l = (int) d11[0];
                    this.f16112m = i11;
                }
            }
        }
    }

    public final void B(String str) throws IOException {
        Objects.requireNonNull(str, "filename cannot be null");
        FileInputStream fileInputStream = null;
        this.f16102c = null;
        this.f16100a = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (J(fileInputStream2.getFD())) {
                    this.f16101b = fileInputStream2.getFD();
                } else {
                    this.f16101b = null;
                }
                O(fileInputStream2);
                b.c(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                b.c(fileInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b.c(fileInputStream);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0092 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean D(byte[] r15) throws java.io.IOException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
            m1.a$b r2 = new m1.a$b     // Catch:{ Exception -> 0x008d }
            r2.<init>((byte[]) r15)     // Catch:{ Exception -> 0x008d }
            int r1 = r2.readInt()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r1     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r1 = 4
            byte[] r5 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r2.read(r5)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            byte[] r6 = C     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r5 = java.util.Arrays.equals(r5, r6)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r5 != 0) goto L_0x001e
            r2.close()
            return r0
        L_0x001e:
            r5 = 1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            r8 = 16
            r10 = 8
            if (r7 != 0) goto L_0x0034
            long r3 = r2.readLong()     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x0035
            r2.close()
            return r0
        L_0x0034:
            r8 = r10
        L_0x0035:
            int r7 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r12 = (long) r7     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x003d
            int r15 = r15.length     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            long r3 = (long) r15
        L_0x003d:
            long r3 = r3 - r8
            int r15 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x0046
            r2.close()
            return r0
        L_0x0046:
            byte[] r15 = new byte[r1]     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r7 = 0
            r9 = r0
            r10 = r9
        L_0x004c:
            r11 = 4
            long r11 = r3 / r11
            int r11 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x0081
            int r11 = r2.read(r15)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == r1) goto L_0x005e
            r2.close()
            return r0
        L_0x005e:
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x0063
            goto L_0x007f
        L_0x0063:
            byte[] r11 = D     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            r12 = 1
            if (r11 == 0) goto L_0x006e
            r9 = r12
            goto L_0x0077
        L_0x006e:
            byte[] r11 = E     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            boolean r11 = java.util.Arrays.equals(r15, r11)     // Catch:{ Exception -> 0x0088, all -> 0x0085 }
            if (r11 == 0) goto L_0x0077
            r10 = r12
        L_0x0077:
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            r2.close()
            return r12
        L_0x007f:
            long r7 = r7 + r5
            goto L_0x004c
        L_0x0081:
            r2.close()
            goto L_0x009e
        L_0x0085:
            r15 = move-exception
            r1 = r2
            goto L_0x009f
        L_0x0088:
            r15 = move-exception
            r1 = r2
            goto L_0x008e
        L_0x008b:
            r15 = move-exception
            goto L_0x009f
        L_0x008d:
            r15 = move-exception
        L_0x008e:
            boolean r2 = f16094v     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x0099
            java.lang.String r2 = "ExifInterface"
            java.lang.String r3 = "Exception parsing HEIF file type box."
            android.util.Log.d(r2, r3, r15)     // Catch:{ all -> 0x008b }
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()
        L_0x009e:
            return r0
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()
        L_0x00a4:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.D(byte[]):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean F(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            m1.a$b r2 = new m1.a$b     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x002d, all -> 0x0026 }
            java.nio.ByteOrder r4 = r3.R(r2)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r3.f16107h = r4     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r2.e(r4)     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0024, all -> 0x0021 }
            r1 = 20306(0x4f52, float:2.8455E-41)
            if (r4 == r1) goto L_0x001c
            r1 = 21330(0x5352, float:2.989E-41)
            if (r4 != r1) goto L_0x001d
        L_0x001c:
            r0 = 1
        L_0x001d:
            r2.close()
            return r0
        L_0x0021:
            r4 = move-exception
            r1 = r2
            goto L_0x0027
        L_0x0024:
            r1 = r2
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r1 == 0) goto L_0x002c
            r1.close()
        L_0x002c:
            throw r4
        L_0x002d:
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.F(byte[]):boolean");
    }

    public final boolean G(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    public final boolean H(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i11 = 0; i11 < bytes.length; i11++) {
            if (bArr[i11] != bytes[i11]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean I(byte[] r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            m1.a$b r2 = new m1.a$b     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            r2.<init>((byte[]) r4)     // Catch:{ Exception -> 0x0029, all -> 0x0022 }
            java.nio.ByteOrder r4 = r3.R(r2)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r3.f16107h = r4     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r2.e(r4)     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            short r4 = r2.readShort()     // Catch:{ Exception -> 0x0020, all -> 0x001d }
            r1 = 85
            if (r4 != r1) goto L_0x0019
            r0 = 1
        L_0x0019:
            r2.close()
            return r0
        L_0x001d:
            r4 = move-exception
            r1 = r2
            goto L_0x0023
        L_0x0020:
            r1 = r2
            goto L_0x0029
        L_0x0022:
            r4 = move-exception
        L_0x0023:
            if (r1 == 0) goto L_0x0028
            r1.close()
        L_0x0028:
            throw r4
        L_0x0029:
            if (r1 == 0) goto L_0x002e
            r1.close()
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.I(byte[]):boolean");
    }

    public final boolean K(HashMap hashMap) throws IOException {
        d dVar;
        int m11;
        d dVar2 = (d) hashMap.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.f16107h);
            int[] iArr2 = f16098y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f16103d == 3 && (dVar = (d) hashMap.get("PhotometricInterpretation")) != null && (((m11 = dVar.m(this.f16107h)) == 1 && Arrays.equals(iArr, A)) || (m11 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f16094v) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    public final boolean M(HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get("ImageLength");
        d dVar2 = (d) hashMap.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.f16107h) <= 512 && dVar2.m(this.f16107h) <= 512;
    }

    public final boolean N(byte[] bArr) throws IOException {
        int i11 = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i11 >= bArr2.length) {
                int i12 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i12 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[L.length + i12 + 4] != bArr3[i12]) {
                        return false;
                    }
                    i12++;
                }
            } else if (bArr[i11] != bArr2[i11]) {
                return false;
            } else {
                i11++;
            }
        }
    }

    public final void O(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        int i11 = 0;
        while (i11 < f16082j0.length) {
            try {
                this.f16105f[i11] = new HashMap<>();
                i11++;
            } catch (IOException | UnsupportedOperationException e11) {
                boolean z11 = f16094v;
                if (z11) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e11);
                }
                a();
                if (!z11) {
                    return;
                }
            } catch (Throwable th2) {
                a();
                if (f16094v) {
                    Q();
                }
                throw th2;
            }
        }
        if (!this.f16104e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f16103d = n(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (g0(this.f16103d)) {
            g gVar = new g(inputStream);
            if (this.f16104e) {
                u(gVar);
            } else {
                int i12 = this.f16103d;
                if (i12 == 12) {
                    k(gVar);
                } else if (i12 == 7) {
                    o(gVar);
                } else if (i12 == 10) {
                    t(gVar);
                } else {
                    r(gVar);
                }
            }
            gVar.g((long) this.f16115p);
            f0(gVar);
        } else {
            b bVar = new b(inputStream);
            int i13 = this.f16103d;
            if (i13 == 4) {
                l(bVar, 0, 0);
            } else if (i13 == 13) {
                p(bVar);
            } else if (i13 == 9) {
                q(bVar);
            } else if (i13 == 14) {
                x(bVar);
            }
        }
        a();
        if (!f16094v) {
            return;
        }
        Q();
    }

    public final void P(b bVar) throws IOException {
        ByteOrder R2 = R(bVar);
        this.f16107h = R2;
        bVar.e(R2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i11 = this.f16103d;
        if (i11 == 7 || i11 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i12 = readInt - 8;
                if (i12 > 0) {
                    bVar.f(i12);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    public final void Q() {
        for (int i11 = 0; i11 < this.f16105f.length; i11++) {
            Log.d("ExifInterface", "The size of tag group[" + i11 + "]: " + this.f16105f[i11].size());
            for (Map.Entry next : this.f16105f[i11].entrySet()) {
                d dVar = (d) next.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) next.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.f16107h) + "'");
            }
        }
    }

    public final ByteOrder R(b bVar) throws IOException {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (f16094v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (f16094v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    public final void S(byte[] bArr, int i11) throws IOException {
        g gVar = new g(bArr);
        P(gVar);
        T(gVar, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void T(m1.a.g r30, int r31) throws java.io.IOException {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            java.util.Set<java.lang.Integer> r3 = r0.f16106g
            int r4 = r1.f16128d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            short r3 = r30.readShort()
            boolean r4 = f16094v
            java.lang.String r5 = "ExifInterface"
            if (r4 == 0) goto L_0x002f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "numberOfDirectoryEntry: "
            r4.append(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r5, r4)
        L_0x002f:
            if (r3 > 0) goto L_0x0032
            return
        L_0x0032:
            r4 = 0
            r6 = r4
        L_0x0034:
            r7 = 5
            if (r6 >= r3) goto L_0x0322
            int r12 = r30.readUnsignedShort()
            int r13 = r30.readUnsignedShort()
            int r15 = r30.readInt()
            int r14 = r30.a()
            long r8 = (long) r14
            r18 = 4
            long r8 = r8 + r18
            java.util.HashMap<java.lang.Integer, m1.a$e>[] r14 = f16084l0
            r14 = r14[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            java.lang.Object r11 = r14.get(r11)
            m1.a$e r11 = (m1.a.e) r11
            boolean r14 = f16094v
            r10 = 3
            if (r14 == 0) goto L_0x0090
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.Integer r23 = java.lang.Integer.valueOf(r31)
            r7[r4] = r23
            java.lang.Integer r23 = java.lang.Integer.valueOf(r12)
            r21 = 1
            r7[r21] = r23
            if (r11 == 0) goto L_0x0074
            java.lang.String r4 = r11.f16137b
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            r22 = 2
            r7[r22] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
            r7[r10] = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r20 = 4
            r7[r20] = r4
            java.lang.String r4 = "ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d"
            java.lang.String r4 = java.lang.String.format(r4, r7)
            android.util.Log.d(r5, r4)
        L_0x0090:
            r4 = 7
            if (r11 != 0) goto L_0x00ae
            if (r14 == 0) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Skip the tag entry since tag number is not defined: "
            r7.append(r10)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r5, r7)
        L_0x00a9:
            r10 = r5
            r25 = r6
            goto L_0x012d
        L_0x00ae:
            if (r13 <= 0) goto L_0x0114
            int[] r7 = X
            int r10 = r7.length
            if (r13 < r10) goto L_0x00b6
            goto L_0x0114
        L_0x00b6:
            boolean r10 = r11.a(r13)
            if (r10 != 0) goto L_0x00e1
            if (r14 == 0) goto L_0x00a9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "Skip the tag entry since data format ("
            r7.append(r10)
            java.lang.String[] r10 = W
            r10 = r10[r13]
            r7.append(r10)
            java.lang.String r10 = ") is unexpected for tag: "
            r7.append(r10)
            java.lang.String r10 = r11.f16137b
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.d(r5, r7)
            goto L_0x00a9
        L_0x00e1:
            if (r13 != r4) goto L_0x00e5
            int r13 = r11.f16138c
        L_0x00e5:
            r10 = r5
            long r4 = (long) r15
            r7 = r7[r13]
            r25 = r6
            long r6 = (long) r7
            long r4 = r4 * r6
            r6 = 0
            int r26 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r26 < 0) goto L_0x00fd
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00fb
            goto L_0x00fd
        L_0x00fb:
            r6 = 1
            goto L_0x0130
        L_0x00fd:
            if (r14 == 0) goto L_0x012f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip the tag entry since the number of components is invalid: "
            r6.append(r7)
            r6.append(r15)
            java.lang.String r6 = r6.toString()
            android.util.Log.d(r10, r6)
            goto L_0x012f
        L_0x0114:
            r10 = r5
            r25 = r6
            if (r14 == 0) goto L_0x012d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Skip the tag entry since data format is invalid: "
            r4.append(r5)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r10, r4)
        L_0x012d:
            r4 = 0
        L_0x012f:
            r6 = 0
        L_0x0130:
            if (r6 != 0) goto L_0x013a
            r1.g(r8)
            r26 = r3
            r8 = r10
            goto L_0x0319
        L_0x013a:
            int r6 = (r4 > r18 ? 1 : (r4 == r18 ? 0 : -1))
            java.lang.String r7 = "Compression"
            if (r6 <= 0) goto L_0x01c4
            int r6 = r30.readInt()
            r26 = r3
            if (r14 == 0) goto L_0x015f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r27 = r8
            java.lang.String r8 = "seek to data offset: "
            r3.append(r8)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r10, r3)
            goto L_0x0161
        L_0x015f:
            r27 = r8
        L_0x0161:
            int r3 = r0.f16103d
            r8 = 7
            if (r3 != r8) goto L_0x01bb
            java.lang.String r3 = r11.f16137b
            java.lang.String r8 = "MakerNote"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0173
            r0.f16116q = r6
            goto L_0x01bb
        L_0x0173:
            r3 = 6
            if (r2 != r3) goto L_0x01bb
            java.lang.String r8 = r11.f16137b
            java.lang.String r9 = "ThumbnailImage"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x01bb
            r0.f16117r = r6
            r0.f16118s = r15
            java.nio.ByteOrder r8 = r0.f16107h
            m1.a$d r3 = m1.a.d.j(r3, r8)
            int r8 = r0.f16117r
            long r8 = (long) r8
            r18 = r15
            java.nio.ByteOrder r15 = r0.f16107h
            m1.a$d r8 = m1.a.d.f(r8, r15)
            int r9 = r0.f16118s
            r24 = r10
            long r9 = (long) r9
            java.nio.ByteOrder r15 = r0.f16107h
            m1.a$d r9 = m1.a.d.f(r9, r15)
            java.util.HashMap<java.lang.String, m1.a$d>[] r10 = r0.f16105f
            r15 = 4
            r10 = r10[r15]
            r10.put(r7, r3)
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r15]
            java.lang.String r10 = "JPEGInterchangeFormat"
            r3.put(r10, r8)
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r15]
            java.lang.String r8 = "JPEGInterchangeFormatLength"
            r3.put(r8, r9)
            goto L_0x01bf
        L_0x01bb:
            r24 = r10
            r18 = r15
        L_0x01bf:
            long r8 = (long) r6
            r1.g(r8)
            goto L_0x01cc
        L_0x01c4:
            r26 = r3
            r27 = r8
            r24 = r10
            r18 = r15
        L_0x01cc:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = f16087o0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r12)
            java.lang.Object r3 = r3.get(r6)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r14 == 0) goto L_0x01f9
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "nextIfdType: "
            r6.append(r8)
            r6.append(r3)
            java.lang.String r8 = " byteCount: "
            r6.append(r8)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r8 = r24
            android.util.Log.d(r8, r6)
            goto L_0x01fb
        L_0x01f9:
            r8 = r24
        L_0x01fb:
            r6 = 8
            if (r3 == 0) goto L_0x029f
            r4 = -1
            r7 = 3
            if (r13 == r7) goto L_0x0221
            r7 = 4
            if (r13 == r7) goto L_0x021c
            if (r13 == r6) goto L_0x0217
            r6 = 9
            if (r13 == r6) goto L_0x0212
            r6 = 13
            if (r13 == r6) goto L_0x0212
            goto L_0x0226
        L_0x0212:
            int r4 = r30.readInt()
            goto L_0x0225
        L_0x0217:
            short r4 = r30.readShort()
            goto L_0x0225
        L_0x021c:
            long r4 = r30.b()
            goto L_0x0226
        L_0x0221:
            int r4 = r30.readUnsignedShort()
        L_0x0225:
            long r4 = (long) r4
        L_0x0226:
            if (r14 == 0) goto L_0x0240
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r7 = java.lang.Long.valueOf(r4)
            r9 = 0
            r6[r9] = r7
            java.lang.String r7 = r11.f16137b
            r9 = 1
            r6[r9] = r7
            java.lang.String r7 = "Offset: %d, tagName: %s"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            android.util.Log.d(r8, r6)
        L_0x0240:
            r6 = 0
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0282
            java.util.Set<java.lang.Integer> r6 = r0.f16106g
            int r7 = (int) r4
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x025e
            r1.g(r4)
            int r3 = r3.intValue()
            r0.T(r1, r3)
            goto L_0x0298
        L_0x025e:
            if (r14 == 0) goto L_0x0298
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Skip jump into the IFD since it has already been read: IfdType "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " (at "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = ")"
            r6.append(r3)
            java.lang.String r3 = r6.toString()
            android.util.Log.d(r8, r3)
            goto L_0x0298
        L_0x0282:
            if (r14 == 0) goto L_0x0298
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = "Skip jump into the IFD since its offset is invalid: "
            r3.append(r6)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r8, r3)
        L_0x0298:
            r9 = r27
            r1.g(r9)
            goto L_0x0319
        L_0x029f:
            r9 = r27
            int r3 = r30.a()
            int r12 = r0.f16115p
            int r3 = r3 + r12
            int r4 = (int) r4
            byte[] r4 = new byte[r4]
            r1.readFully(r4)
            m1.a$d r5 = new m1.a$d
            long r14 = (long) r3
            r19 = r14
            r14 = r5
            r3 = r18
            r15 = r13
            r16 = r3
            r17 = r19
            r19 = r4
            r14.<init>(r15, r16, r17, r19)
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r2]
            java.lang.String r4 = r11.f16137b
            r3.put(r4, r5)
            java.lang.String r3 = r11.f16137b
            java.lang.String r4 = "DNGVersion"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x02d6
            r3 = 3
            r0.f16103d = r3
        L_0x02d6:
            java.lang.String r3 = r11.f16137b
            java.lang.String r4 = "Make"
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x02ea
            java.lang.String r3 = r11.f16137b
            java.lang.String r4 = "Model"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x02f8
        L_0x02ea:
            java.nio.ByteOrder r3 = r0.f16107h
            java.lang.String r3 = r5.n(r3)
            java.lang.String r4 = "PENTAX"
            boolean r3 = r3.contains(r4)
            if (r3 != 0) goto L_0x030b
        L_0x02f8:
            java.lang.String r3 = r11.f16137b
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x030d
            java.nio.ByteOrder r3 = r0.f16107h
            int r3 = r5.m(r3)
            r4 = 65535(0xffff, float:9.1834E-41)
            if (r3 != r4) goto L_0x030d
        L_0x030b:
            r0.f16103d = r6
        L_0x030d:
            int r3 = r30.a()
            long r3 = (long) r3
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0319
            r1.g(r9)
        L_0x0319:
            int r6 = r25 + 1
            short r6 = (short) r6
            r5 = r8
            r3 = r26
            r4 = 0
            goto L_0x0034
        L_0x0322:
            r8 = r5
            int r2 = r30.readInt()
            boolean r3 = f16094v
            if (r3 == 0) goto L_0x033e
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            r6 = 0
            r4[r6] = r5
            java.lang.String r5 = "nextIfdOffset: %d"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            android.util.Log.d(r8, r4)
        L_0x033e:
            long r4 = (long) r2
            r9 = 0
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0388
            java.util.Set<java.lang.Integer> r6 = r0.f16106g
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            boolean r6 = r6.contains(r9)
            if (r6 != 0) goto L_0x0371
            r1.g(r4)
            java.util.HashMap<java.lang.String, m1.a$d>[] r2 = r0.f16105f
            r3 = 4
            r2 = r2[r3]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0363
            r0.T(r1, r3)
            goto L_0x039e
        L_0x0363:
            java.util.HashMap<java.lang.String, m1.a$d>[] r2 = r0.f16105f
            r2 = r2[r7]
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x039e
            r0.T(r1, r7)
            goto L_0x039e
        L_0x0371:
            if (r3 == 0) goto L_0x039e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since re-reading an IFD may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r8, r1)
            goto L_0x039e
        L_0x0388:
            if (r3 == 0) goto L_0x039e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Stop reading file since a wrong offset may cause an infinite loop: "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r8, r1)
        L_0x039e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.T(m1.a$g, int):void");
    }

    public final void U(String str) {
        for (int i11 = 0; i11 < f16082j0.length; i11++) {
            this.f16105f[i11].remove(str);
        }
    }

    public final void V(int i11, String str, String str2) {
        if (!this.f16105f[i11].isEmpty() && this.f16105f[i11].get(str) != null) {
            HashMap<String, d>[] hashMapArr = this.f16105f;
            hashMapArr[i11].put(str2, hashMapArr[i11].get(str));
            this.f16105f[i11].remove(str);
        }
    }

    public final void W(g gVar, int i11) throws IOException {
        d dVar = this.f16105f[i11].get("ImageLength");
        d dVar2 = this.f16105f[i11].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = this.f16105f[i11].get("JPEGInterchangeFormat");
            d dVar4 = this.f16105f[i11].get("JPEGInterchangeFormatLength");
            if (dVar3 != null && dVar4 != null) {
                int m11 = dVar3.m(this.f16107h);
                int m12 = dVar3.m(this.f16107h);
                gVar.g((long) m11);
                byte[] bArr = new byte[m12];
                gVar.read(bArr);
                l(new b(bArr), m11, i11);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0167, code lost:
        r2.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00e5, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00e6, code lost:
        r10 = null;
        r1 = r7;
        r7 = r9;
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00eb, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ec, code lost:
        r9 = null;
        r10 = null;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00f0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f1, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0104, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 21) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0106, code lost:
        m1.b.a.c(r14.f16101b, 0, android.system.OsConstants.SEEK_SET);
        r1 = new java.io.FileOutputStream(r14.f16101b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0115, code lost:
        r1 = new java.io.FileOutputStream(r14.f16100a);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:30:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0102 A[Catch:{ Exception -> 0x0130, all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0115 A[Catch:{ Exception -> 0x0130, all -> 0x012e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X() throws java.io.IOException {
        /*
            r14 = this;
            int r0 = r14.f16103d
            boolean r0 = L(r0)
            if (r0 == 0) goto L_0x018c
            java.io.FileDescriptor r0 = r14.f16101b
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = r14.f16100a
            if (r0 == 0) goto L_0x0011
            goto L_0x0019
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes for the current input."
            r0.<init>(r1)
            throw r0
        L_0x0019:
            boolean r0 = r14.f16108i
            if (r0 == 0) goto L_0x002e
            boolean r0 = r14.f16109j
            if (r0 == 0) goto L_0x002e
            boolean r0 = r14.f16110k
            if (r0 == 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
            r0.<init>(r1)
            throw r0
        L_0x002e:
            r0 = 1
            r14.f16119t = r0
            byte[] r1 = r14.v()
            r14.f16113n = r1
            r1 = 0
            java.lang.String r2 = "temp"
            java.lang.String r3 = "tmp"
            java.io.File r2 = java.io.File.createTempFile(r2, r3)     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            java.lang.String r3 = r14.f16100a     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            r4 = 0
            r6 = 21
            if (r3 == 0) goto L_0x0050
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            java.lang.String r7 = r14.f16100a     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            goto L_0x0064
        L_0x0050:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            if (r3 < r6) goto L_0x0063
            java.io.FileDescriptor r3 = r14.f16101b     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            int r7 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            m1.b.a.c(r3, r4, r7)     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            java.io.FileDescriptor r7 = r14.f16101b     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x017a, all -> 0x0177 }
            goto L_0x0064
        L_0x0063:
            r3 = r1
        L_0x0064:
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0173, all -> 0x016f }
            r7.<init>(r2)     // Catch:{ Exception -> 0x0173, all -> 0x016f }
            m1.b.e(r3, r7)     // Catch:{ Exception -> 0x016d, all -> 0x016b }
            m1.b.c(r3)
            m1.b.c(r7)
            r3 = 0
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00f4, all -> 0x00f0 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00f4, all -> 0x00f0 }
            java.lang.String r8 = r14.f16100a     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            if (r8 == 0) goto L_0x0084
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            java.lang.String r9 = r14.f16100a     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            goto L_0x0098
        L_0x0084:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            if (r8 < r6) goto L_0x0097
            java.io.FileDescriptor r8 = r14.f16101b     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            int r9 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            m1.b.a.c(r8, r4, r9)     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            java.io.FileDescriptor r9 = r14.f16101b     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00eb, all -> 0x00f0 }
            goto L_0x0098
        L_0x0097:
            r8 = r1
        L_0x0098:
            java.io.BufferedInputStream r9 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x00e5, all -> 0x00f0 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x00e5, all -> 0x00f0 }
            java.io.BufferedOutputStream r10 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x00df, all -> 0x00db }
            r10.<init>(r8)     // Catch:{ Exception -> 0x00df, all -> 0x00db }
            int r11 = r14.f16103d     // Catch:{ Exception -> 0x00d6 }
            r12 = 4
            if (r11 != r12) goto L_0x00ab
            r14.Y(r9, r10)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00ca
        L_0x00ab:
            r12 = 13
            if (r11 != r12) goto L_0x00b3
            r14.Z(r9, r10)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00ca
        L_0x00b3:
            r12 = 14
            if (r11 != r12) goto L_0x00bb
            r14.a0(r9, r10)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00ca
        L_0x00bb:
            r12 = 3
            if (r11 == r12) goto L_0x00c0
            if (r11 != 0) goto L_0x00ca
        L_0x00c0:
            m1.a$c r11 = new m1.a$c     // Catch:{ Exception -> 0x00d6 }
            java.nio.ByteOrder r12 = java.nio.ByteOrder.BIG_ENDIAN     // Catch:{ Exception -> 0x00d6 }
            r11.<init>(r10, r12)     // Catch:{ Exception -> 0x00d6 }
            r14.k0(r11)     // Catch:{ Exception -> 0x00d6 }
        L_0x00ca:
            m1.b.c(r9)
            m1.b.c(r10)
            r2.delete()
            r14.f16113n = r1
            return
        L_0x00d6:
            r1 = move-exception
            r13 = r7
            r7 = r1
            r1 = r13
            goto L_0x00f9
        L_0x00db:
            r0 = move-exception
            r10 = r1
            goto L_0x015e
        L_0x00df:
            r10 = move-exception
            r13 = r10
            r10 = r1
            r1 = r7
            r7 = r13
            goto L_0x00f9
        L_0x00e5:
            r9 = move-exception
            r10 = r1
            r1 = r7
            r7 = r9
            r9 = r10
            goto L_0x00f9
        L_0x00eb:
            r8 = move-exception
            r9 = r1
            r10 = r9
            r1 = r7
            goto L_0x00f7
        L_0x00f0:
            r0 = move-exception
            r10 = r1
            goto L_0x015f
        L_0x00f4:
            r8 = move-exception
            r9 = r1
            r10 = r9
        L_0x00f7:
            r7 = r8
            r8 = r10
        L_0x00f9:
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0134, all -> 0x0132 }
            java.lang.String r1 = r14.f16100a     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            if (r1 != 0) goto L_0x0115
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            if (r1 < r6) goto L_0x011d
            java.io.FileDescriptor r1 = r14.f16101b     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            int r6 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            m1.b.a.c(r1, r4, r6)     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            java.io.FileDescriptor r4 = r14.f16101b     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            goto L_0x011c
        L_0x0115:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            java.lang.String r4 = r14.f16100a     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0130, all -> 0x012e }
        L_0x011c:
            r8 = r1
        L_0x011d:
            m1.b.e(r11, r8)     // Catch:{ Exception -> 0x0130, all -> 0x012e }
            m1.b.c(r11)     // Catch:{ all -> 0x015d }
            m1.b.c(r8)     // Catch:{ all -> 0x015d }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x015d }
            java.lang.String r1 = "Failed to save new file"
            r0.<init>(r1, r7)     // Catch:{ all -> 0x015d }
            throw r0     // Catch:{ all -> 0x015d }
        L_0x012e:
            r0 = move-exception
            goto L_0x0155
        L_0x0130:
            r1 = move-exception
            goto L_0x0137
        L_0x0132:
            r0 = move-exception
            goto L_0x0156
        L_0x0134:
            r3 = move-exception
            r11 = r1
            r1 = r3
        L_0x0137:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0152 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0152 }
            r4.<init>()     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = "Failed to save new file. Original file is stored in "
            r4.append(r5)     // Catch:{ all -> 0x0152 }
            java.lang.String r5 = r2.getAbsolutePath()     // Catch:{ all -> 0x0152 }
            r4.append(r5)     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0152 }
            r3.<init>(r4, r1)     // Catch:{ all -> 0x0152 }
            throw r3     // Catch:{ all -> 0x0152 }
        L_0x0152:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x0155:
            r1 = r11
        L_0x0156:
            m1.b.c(r1)     // Catch:{ all -> 0x015d }
            m1.b.c(r8)     // Catch:{ all -> 0x015d }
            throw r0     // Catch:{ all -> 0x015d }
        L_0x015d:
            r0 = move-exception
        L_0x015e:
            r1 = r9
        L_0x015f:
            m1.b.c(r1)
            m1.b.c(r10)
            if (r3 != 0) goto L_0x016a
            r2.delete()
        L_0x016a:
            throw r0
        L_0x016b:
            r0 = move-exception
            goto L_0x0171
        L_0x016d:
            r0 = move-exception
            goto L_0x0175
        L_0x016f:
            r0 = move-exception
            r7 = r1
        L_0x0171:
            r1 = r3
            goto L_0x0185
        L_0x0173:
            r0 = move-exception
            r7 = r1
        L_0x0175:
            r1 = r3
            goto L_0x017c
        L_0x0177:
            r0 = move-exception
            r7 = r1
            goto L_0x0185
        L_0x017a:
            r0 = move-exception
            r7 = r1
        L_0x017c:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x0184 }
            java.lang.String r3 = "Failed to copy original file to temp file"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0184 }
            throw r2     // Catch:{ all -> 0x0184 }
        L_0x0184:
            r0 = move-exception
        L_0x0185:
            m1.b.c(r1)
            m1.b.c(r7)
            throw r0
        L_0x018c:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.X():void");
    }

    public final void Y(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f16094v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (bVar.readByte() == -1) {
            cVar.b(-1);
            if (bVar.readByte() == -40) {
                cVar.b(-40);
                d dVar = null;
                if (g("Xmp") != null && this.f16120u) {
                    dVar = this.f16105f[0].remove("Xmp");
                }
                cVar.b(-1);
                cVar.b(-31);
                k0(cVar);
                if (dVar != null) {
                    this.f16105f[0].put("Xmp", dVar);
                }
                byte[] bArr = new byte[4096];
                while (bVar.readByte() == -1) {
                    byte readByte = bVar.readByte();
                    if (readByte == -39 || readByte == -38) {
                        cVar.b(-1);
                        cVar.b(readByte);
                        b.e(bVar, cVar);
                        return;
                    } else if (readByte != -31) {
                        cVar.b(-1);
                        cVar.b(readByte);
                        int readUnsignedShort = bVar.readUnsignedShort();
                        cVar.j(readUnsignedShort);
                        int i11 = readUnsignedShort - 2;
                        if (i11 >= 0) {
                            while (i11 > 0) {
                                int read = bVar.read(bArr, 0, Math.min(i11, 4096));
                                if (read < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read);
                                i11 -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = bVar.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (bVar.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, f16089q0)) {
                                    bVar.f(readUnsignedShort2 - 6);
                                }
                            }
                            cVar.b(-1);
                            cVar.b(readByte);
                            cVar.j(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                cVar.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = bVar.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                cVar.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    public final void Z(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (f16094v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        b bVar = new b(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = H;
        b.f(bVar, cVar, bArr.length);
        int i11 = this.f16115p;
        if (i11 == 0) {
            int readInt = bVar.readInt();
            cVar.e(readInt);
            b.f(bVar, cVar, readInt + 4 + 4);
        } else {
            b.f(bVar, cVar, ((i11 - bArr.length) - 4) - 4);
            bVar.f(bVar.readInt() + 4 + 4);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                k0(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.f16130b).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.e((int) crc32.getValue());
                b.c(byteArrayOutputStream2);
                b.e(bVar, cVar);
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = byteArrayOutputStream2;
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            b.c(byteArrayOutputStream);
            throw th;
        }
    }

    public final void a() {
        String g11 = g("DateTimeOriginal");
        if (g11 != null && g("DateTime") == null) {
            this.f16105f[0].put("DateTime", d.e(g11));
        }
        if (g("ImageWidth") == null) {
            this.f16105f[0].put("ImageWidth", d.f(0, this.f16107h));
        }
        if (g("ImageLength") == null) {
            this.f16105f[0].put("ImageLength", d.f(0, this.f16107h));
        }
        if (g("Orientation") == null) {
            this.f16105f[0].put("Orientation", d.f(0, this.f16107h));
        }
        if (g("LightSource") == null) {
            this.f16105f[1].put("LightSource", d.f(0, this.f16107h));
        }
    }

    public final void a0(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i11;
        int i12;
        int i13;
        int i14;
        InputStream inputStream2 = inputStream;
        OutputStream outputStream2 = outputStream;
        if (f16094v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream2 + ", outputStream: " + outputStream2 + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream2, byteOrder);
        c cVar = new c(outputStream2, byteOrder);
        byte[] bArr = L;
        b.f(bVar, cVar, bArr.length);
        byte[] bArr2 = M;
        bVar.f(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                int i15 = this.f16115p;
                if (i15 != 0) {
                    b.f(bVar, cVar2, ((i15 - ((bArr.length + 4) + bArr2.length)) - 4) - 4);
                    bVar.f(4);
                    bVar.f(bVar.readInt());
                    k0(cVar2);
                } else {
                    byte[] bArr3 = new byte[4];
                    if (bVar.read(bArr3) == 4) {
                        byte[] bArr4 = P;
                        boolean z11 = true;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int readInt = bVar.readInt();
                            byte[] bArr5 = new byte[(readInt % 2 == 1 ? readInt + 1 : readInt)];
                            bVar.read(bArr5);
                            bArr5[0] = (byte) (8 | bArr5[0]);
                            if (((bArr5[0] >> 1) & 1) != 1) {
                                z11 = false;
                            }
                            cVar2.write(bArr4);
                            cVar2.e(readInt);
                            cVar2.write(bArr5);
                            if (z11) {
                                d(bVar, cVar2, S, (byte[]) null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream2.read(bArr6);
                                    if (!Arrays.equals(bArr6, T)) {
                                        break;
                                    }
                                    e(bVar, cVar2, bArr6);
                                }
                                k0(cVar2);
                            } else {
                                d(bVar, cVar2, R, Q);
                                k0(cVar2);
                            }
                        } else {
                            byte[] bArr7 = R;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, Q)) {
                                int readInt2 = bVar.readInt();
                                int i16 = readInt2 % 2 == 1 ? readInt2 + 1 : readInt2;
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    bVar.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (bVar.read(bArr9) != 3 || !Arrays.equals(O, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i14 = bVar.readInt();
                                    i13 = (i14 << 18) >> 18;
                                    i12 = (i14 << 2) >> 18;
                                    i16 -= 10;
                                    i11 = 0;
                                } else if (!Arrays.equals(bArr3, Q)) {
                                    i14 = 0;
                                    i13 = 0;
                                    i12 = 0;
                                    i11 = 0;
                                } else if (bVar.readByte() == 47) {
                                    i14 = bVar.readInt();
                                    i11 = i14 & 8;
                                    i16 -= 5;
                                    i12 = ((i14 << 4) >> 18) + 1;
                                    i13 = ((i14 << 18) >> 18) + 1;
                                } else {
                                    throw new IOException("Encountered error while checking VP8L signature");
                                }
                                cVar2.write(bArr4);
                                cVar2.e(10);
                                byte[] bArr10 = new byte[10];
                                bArr10[0] = (byte) (bArr10[0] | 8);
                                bArr10[0] = (byte) (bArr10[0] | (i11 << 4));
                                int i17 = i13 - 1;
                                int i18 = i12 - 1;
                                bArr10[4] = (byte) i17;
                                bArr10[5] = (byte) (i17 >> 8);
                                bArr10[6] = (byte) (i17 >> 16);
                                bArr10[7] = (byte) i18;
                                bArr10[8] = (byte) (i18 >> 8);
                                bArr10[9] = (byte) (i18 >> 16);
                                cVar2.write(bArr10);
                                cVar2.write(bArr3);
                                cVar2.e(readInt2);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    cVar2.write(bArr8);
                                    cVar2.write(O);
                                    cVar2.e(i14);
                                } else if (Arrays.equals(bArr3, Q)) {
                                    cVar2.write(47);
                                    cVar2.e(i14);
                                }
                                b.f(bVar, cVar2, i16);
                                k0(cVar2);
                            }
                        }
                    } else {
                        throw new IOException("Encountered invalid length while parsing WebP chunk type");
                    }
                }
                b.e(bVar, cVar2);
                int size = byteArrayOutputStream2.size();
                byte[] bArr11 = M;
                cVar.e(size + bArr11.length);
                cVar.write(bArr11);
                byteArrayOutputStream2.writeTo(cVar);
                b.c(byteArrayOutputStream2);
            } catch (Exception e11) {
                e = e11;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th2) {
                    th = th2;
                    b.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = byteArrayOutputStream2;
                b.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            throw new IOException("Failed to save WebP file", e);
        }
    }

    public final String b(double d11) {
        long j11 = (long) d11;
        double d12 = d11 - ((double) j11);
        long j12 = (long) (d12 * 60.0d);
        long round = Math.round((d12 - (((double) j12) / 60.0d)) * 3600.0d * 1.0E7d);
        return j11 + "/1," + j12 + "/1," + round + "/10000000";
    }

    public void b0(double d11) {
        String str = d11 >= 0.0d ? "0" : "1";
        c0("GPSAltitude", new f(Math.abs(d11)).toString());
        c0("GPSAltitudeRef", str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02bd, code lost:
        r15 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c0(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "tag shouldn't be null"
            java.util.Objects.requireNonNull(r1, r3)
            java.lang.String r3 = "DateTime"
            boolean r3 = r3.equals(r1)
            java.lang.String r4 = " : "
            java.lang.String r5 = "Invalid value for "
            java.lang.String r6 = "ExifInterface"
            if (r3 != 0) goto L_0x0029
            java.lang.String r3 = "DateTimeOriginal"
            boolean r3 = r3.equals(r1)
            if (r3 != 0) goto L_0x0029
            java.lang.String r3 = "DateTimeDigitized"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0070
        L_0x0029:
            if (r2 == 0) goto L_0x0070
            java.util.regex.Pattern r3 = f16093u0
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r3 = r3.find()
            java.util.regex.Pattern r7 = f16095v0
            java.util.regex.Matcher r7 = r7.matcher(r2)
            boolean r7 = r7.find()
            int r8 = r19.length()
            r9 = 19
            if (r8 != r9) goto L_0x0057
            if (r3 != 0) goto L_0x004c
            if (r7 != 0) goto L_0x004c
            goto L_0x0057
        L_0x004c:
            if (r7 == 0) goto L_0x0070
            java.lang.String r3 = "-"
            java.lang.String r7 = ":"
            java.lang.String r2 = r2.replaceAll(r3, r7)
            goto L_0x0070
        L_0x0057:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x0070:
            java.lang.String r3 = "ISOSpeedRatings"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0083
            boolean r1 = f16094v
            if (r1 == 0) goto L_0x0081
            java.lang.String r1 = "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY."
            android.util.Log.d(r6, r1)
        L_0x0081:
            java.lang.String r1 = "PhotographicSensitivity"
        L_0x0083:
            r3 = 2
            r7 = 1
            if (r2 == 0) goto L_0x011c
            java.util.HashSet<java.lang.String> r8 = f16086n0
            boolean r8 = r8.contains(r1)
            if (r8 == 0) goto L_0x011c
            java.lang.String r8 = "GPSTimeStamp"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x00f5
            java.util.regex.Pattern r8 = f16092t0
            java.util.regex.Matcher r8 = r8.matcher(r2)
            boolean r9 = r8.find()
            if (r9 != 0) goto L_0x00bc
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x00bc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r8.group(r7)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1,"
            r2.append(r4)
            java.lang.String r5 = r8.group(r3)
            int r5 = java.lang.Integer.parseInt(r5)
            r2.append(r5)
            r2.append(r4)
            r4 = 3
            java.lang.String r4 = r8.group(r4)
            int r4 = java.lang.Integer.parseInt(r4)
            r2.append(r4)
            java.lang.String r4 = "/1"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            goto L_0x011c
        L_0x00f5:
            double r8 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x0103 }
            m1.a$f r10 = new m1.a$f     // Catch:{ NumberFormatException -> 0x0103 }
            r10.<init>(r8)     // Catch:{ NumberFormatException -> 0x0103 }
            java.lang.String r2 = r10.toString()     // Catch:{ NumberFormatException -> 0x0103 }
            goto L_0x011c
        L_0x0103:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r1)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            android.util.Log.w(r6, r1)
            return
        L_0x011c:
            r4 = 0
            r5 = r4
        L_0x011e:
            m1.a$e[][] r8 = f16082j0
            int r8 = r8.length
            if (r5 >= r8) goto L_0x036a
            r8 = 4
            if (r5 != r8) goto L_0x012c
            boolean r8 = r0.f16108i
            if (r8 != 0) goto L_0x012c
            goto L_0x0362
        L_0x012c:
            java.util.HashMap<java.lang.String, m1.a$e>[] r8 = f16085m0
            r8 = r8[r5]
            java.lang.Object r8 = r8.get(r1)
            m1.a$e r8 = (m1.a.e) r8
            if (r8 == 0) goto L_0x0362
            if (r2 != 0) goto L_0x0143
            java.util.HashMap<java.lang.String, m1.a$d>[] r8 = r0.f16105f
            r8 = r8[r5]
            r8.remove(r1)
            goto L_0x0362
        L_0x0143:
            android.util.Pair r9 = y(r2)
            int r10 = r8.f16138c
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r12 = -1
            if (r10 == r11) goto L_0x0213
            int r10 = r8.f16138c
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x0162
            goto L_0x0213
        L_0x0162:
            int r10 = r8.f16139d
            if (r10 == r12) goto L_0x0180
            java.lang.Object r11 = r9.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 == r11) goto L_0x017c
            int r10 = r8.f16139d
            java.lang.Object r11 = r9.second
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r10 != r11) goto L_0x0180
        L_0x017c:
            int r8 = r8.f16139d
            goto L_0x0215
        L_0x0180:
            int r10 = r8.f16138c
            if (r10 == r7) goto L_0x0211
            r11 = 7
            if (r10 == r11) goto L_0x0211
            if (r10 != r3) goto L_0x018b
            goto L_0x0211
        L_0x018b:
            boolean r10 = f16094v
            if (r10 == 0) goto L_0x0362
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Given tag ("
            r10.append(r11)
            r10.append(r1)
            java.lang.String r11 = ") value didn't match with one of expected formats: "
            r10.append(r11)
            java.lang.String[] r11 = W
            int r13 = r8.f16138c
            r13 = r11[r13]
            r10.append(r13)
            int r13 = r8.f16139d
            java.lang.String r14 = ""
            java.lang.String r15 = ", "
            if (r13 != r12) goto L_0x01b4
            r8 = r14
            goto L_0x01c7
        L_0x01b4:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r15)
            int r8 = r8.f16139d
            r8 = r11[r8]
            r13.append(r8)
            java.lang.String r8 = r13.toString()
        L_0x01c7:
            r10.append(r8)
            java.lang.String r8 = " (guess: "
            r10.append(r8)
            java.lang.Object r8 = r9.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r8 = r11[r8]
            r10.append(r8)
            java.lang.Object r8 = r9.second
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r8 != r12) goto L_0x01e7
            goto L_0x0200
        L_0x01e7:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r15)
            java.lang.Object r9 = r9.second
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r9 = r11[r9]
            r8.append(r9)
            java.lang.String r14 = r8.toString()
        L_0x0200:
            r10.append(r14)
            java.lang.String r8 = ")"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            android.util.Log.d(r6, r8)
            goto L_0x0362
        L_0x0211:
            r8 = r10
            goto L_0x0215
        L_0x0213:
            int r8 = r8.f16138c
        L_0x0215:
            java.lang.String r9 = "/"
            java.lang.String r10 = ","
            switch(r8) {
                case 1: goto L_0x0355;
                case 2: goto L_0x0348;
                case 3: goto L_0x0322;
                case 4: goto L_0x02fc;
                case 5: goto L_0x02c0;
                case 6: goto L_0x021c;
                case 7: goto L_0x0348;
                case 8: goto L_0x021c;
                case 9: goto L_0x029a;
                case 10: goto L_0x025c;
                case 11: goto L_0x021c;
                case 12: goto L_0x0237;
                default: goto L_0x021c;
            }
        L_0x021c:
            r15 = r7
            boolean r3 = f16094v
            if (r3 == 0) goto L_0x0363
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Data format isn't one of expected formats: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r6, r3)
            goto L_0x0363
        L_0x0237:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r9 = r8.length
            double[] r9 = new double[r9]
            r10 = r4
        L_0x023f:
            int r11 = r8.length
            if (r10 >= r11) goto L_0x024d
            r11 = r8[r10]
            double r11 = java.lang.Double.parseDouble(r11)
            r9[r10] = r11
            int r10 = r10 + 1
            goto L_0x023f
        L_0x024d:
            java.util.HashMap<java.lang.String, m1.a$d>[] r8 = r0.f16105f
            r8 = r8[r5]
            java.nio.ByteOrder r10 = r0.f16107h
            m1.a$d r9 = m1.a.d.b(r9, r10)
            r8.put(r1, r9)
            goto L_0x0362
        L_0x025c:
            java.lang.String[] r8 = r2.split(r10, r12)
            int r10 = r8.length
            m1.a$f[] r10 = new m1.a.f[r10]
            r11 = r4
        L_0x0264:
            int r13 = r8.length
            if (r11 >= r13) goto L_0x028c
            r13 = r8[r11]
            java.lang.String[] r13 = r13.split(r9, r12)
            m1.a$f r14 = new m1.a$f
            r15 = r13[r4]
            double r3 = java.lang.Double.parseDouble(r15)
            long r3 = (long) r3
            r13 = r13[r7]
            r16 = r8
            double r7 = java.lang.Double.parseDouble(r13)
            long r7 = (long) r7
            r14.<init>(r3, r7)
            r10[r11] = r14
            int r11 = r11 + 1
            r8 = r16
            r3 = 2
            r4 = 0
            r7 = 1
            goto L_0x0264
        L_0x028c:
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            java.nio.ByteOrder r4 = r0.f16107h
            m1.a$d r4 = m1.a.d.d(r10, r4)
            r3.put(r1, r4)
            goto L_0x02bd
        L_0x029a:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x02a2:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02b0
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x02a2
        L_0x02b0:
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f16107h
            m1.a$d r4 = m1.a.d.c(r4, r7)
            r3.put(r1, r4)
        L_0x02bd:
            r15 = 1
            goto L_0x0363
        L_0x02c0:
            java.lang.String[] r3 = r2.split(r10, r12)
            int r4 = r3.length
            m1.a$f[] r4 = new m1.a.f[r4]
            r7 = 0
        L_0x02c8:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x02ec
            r8 = r3[r7]
            java.lang.String[] r8 = r8.split(r9, r12)
            m1.a$f r10 = new m1.a$f
            r11 = 0
            r13 = r8[r11]
            double r13 = java.lang.Double.parseDouble(r13)
            long r13 = (long) r13
            r15 = 1
            r8 = r8[r15]
            double r11 = java.lang.Double.parseDouble(r8)
            long r11 = (long) r11
            r10.<init>(r13, r11)
            r4[r7] = r10
            int r7 = r7 + 1
            r12 = -1
            goto L_0x02c8
        L_0x02ec:
            r15 = 1
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f16107h
            m1.a$d r4 = m1.a.d.i(r4, r7)
            r3.put(r1, r4)
            goto L_0x0363
        L_0x02fc:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            long[] r4 = new long[r4]
            r7 = 0
        L_0x0306:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x0314
            r8 = r3[r7]
            long r8 = java.lang.Long.parseLong(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x0306
        L_0x0314:
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f16107h
            m1.a$d r4 = m1.a.d.g(r4, r7)
            r3.put(r1, r4)
            goto L_0x0363
        L_0x0322:
            r15 = r7
            r3 = r12
            java.lang.String[] r3 = r2.split(r10, r3)
            int r4 = r3.length
            int[] r4 = new int[r4]
            r7 = 0
        L_0x032c:
            int r8 = r3.length
            if (r7 >= r8) goto L_0x033a
            r8 = r3[r7]
            int r8 = java.lang.Integer.parseInt(r8)
            r4[r7] = r8
            int r7 = r7 + 1
            goto L_0x032c
        L_0x033a:
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            java.nio.ByteOrder r7 = r0.f16107h
            m1.a$d r4 = m1.a.d.k(r4, r7)
            r3.put(r1, r4)
            goto L_0x0363
        L_0x0348:
            r15 = r7
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            m1.a$d r4 = m1.a.d.e(r2)
            r3.put(r1, r4)
            goto L_0x0363
        L_0x0355:
            r15 = r7
            java.util.HashMap<java.lang.String, m1.a$d>[] r3 = r0.f16105f
            r3 = r3[r5]
            m1.a$d r4 = m1.a.d.a(r2)
            r3.put(r1, r4)
            goto L_0x0363
        L_0x0362:
            r15 = r7
        L_0x0363:
            int r5 = r5 + 1
            r7 = r15
            r3 = 2
            r4 = 0
            goto L_0x011e
        L_0x036a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.c0(java.lang.String, java.lang.String):void");
    }

    public final void d(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = f16088p0;
                sb2.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = "";
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb2.append(str);
                throw new IOException(sb2.toString());
            }
            e(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    public void d0(Location location) {
        if (location != null) {
            c0("GPSProcessingMethod", location.getProvider());
            e0(location.getLatitude(), location.getLongitude());
            b0(location.getAltitude());
            c0("GPSSpeedRef", "K");
            c0("GPSSpeed", new f((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = U.format(new Date(location.getTime())).split("\\s+", -1);
            c0("GPSDateStamp", split[0]);
            c0("GPSTimeStamp", split[1]);
        }
    }

    public final void e(b bVar, c cVar, byte[] bArr) throws IOException {
        int readInt = bVar.readInt();
        cVar.write(bArr);
        cVar.e(readInt);
        if (readInt % 2 == 1) {
            readInt++;
        }
        b.f(bVar, cVar, readInt);
    }

    public void e0(double d11, double d12) {
        if (d11 < -90.0d || d11 > 90.0d || Double.isNaN(d11)) {
            throw new IllegalArgumentException("Latitude value " + d11 + " is not valid.");
        } else if (d12 < -180.0d || d12 > 180.0d || Double.isNaN(d12)) {
            throw new IllegalArgumentException("Longitude value " + d12 + " is not valid.");
        } else {
            c0("GPSLatitudeRef", d11 >= 0.0d ? KvStore.N : "S");
            c0("GPSLatitude", b(Math.abs(d11)));
            c0("GPSLongitudeRef", d12 >= 0.0d ? "E" : "W");
            c0("GPSLongitude", b(Math.abs(d12)));
        }
    }

    public double f(double d11) {
        double h11 = h("GPSAltitude", -1.0d);
        int i11 = -1;
        int i12 = i("GPSAltitudeRef", -1);
        if (h11 < 0.0d || i12 < 0) {
            return d11;
        }
        if (i12 != 1) {
            i11 = 1;
        }
        return h11 * ((double) i11);
    }

    public final void f0(b bVar) throws IOException {
        HashMap<String, d> hashMap = this.f16105f[4];
        d dVar = hashMap.get("Compression");
        if (dVar != null) {
            int m11 = dVar.m(this.f16107h);
            this.f16114o = m11;
            if (m11 != 1) {
                if (m11 == 6) {
                    z(bVar, hashMap);
                    return;
                } else if (m11 != 7) {
                    return;
                }
            }
            if (K(hashMap)) {
                A(bVar, hashMap);
                return;
            }
            return;
        }
        this.f16114o = 6;
        z(bVar, hashMap);
    }

    public String g(String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d j11 = j(str);
        if (j11 != null) {
            if (!f16086n0.contains(str)) {
                return j11.n(this.f16107h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i11 = j11.f16132a;
                if (i11 == 5 || i11 == 10) {
                    f[] fVarArr = (f[]) j11.o(this.f16107h);
                    if (fVarArr == null || fVarArr.length != 3) {
                        Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                        return null;
                    }
                    return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) fVarArr[0].f16140a) / ((float) fVarArr[0].f16141b))), Integer.valueOf((int) (((float) fVarArr[1].f16140a) / ((float) fVarArr[1].f16141b))), Integer.valueOf((int) (((float) fVarArr[2].f16140a) / ((float) fVarArr[2].f16141b)))});
                }
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + j11.f16132a);
                return null;
            }
            try {
                return Double.toString(j11.l(this.f16107h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double h(String str, double d11) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d j11 = j(str);
        if (j11 == null) {
            return d11;
        }
        try {
            return j11.l(this.f16107h);
        } catch (NumberFormatException unused) {
            return d11;
        }
    }

    public final void h0(int i11, int i12) throws IOException {
        if (!this.f16105f[i11].isEmpty() && !this.f16105f[i12].isEmpty()) {
            d dVar = this.f16105f[i11].get("ImageLength");
            d dVar2 = this.f16105f[i11].get("ImageWidth");
            d dVar3 = this.f16105f[i12].get("ImageLength");
            d dVar4 = this.f16105f[i12].get("ImageWidth");
            if (dVar == null || dVar2 == null) {
                if (f16094v) {
                    Log.d("ExifInterface", "First image does not contain valid size information");
                }
            } else if (dVar3 != null && dVar4 != null) {
                int m11 = dVar.m(this.f16107h);
                int m12 = dVar2.m(this.f16107h);
                int m13 = dVar3.m(this.f16107h);
                int m14 = dVar4.m(this.f16107h);
                if (m11 < m13 && m12 < m14) {
                    HashMap<String, d>[] hashMapArr = this.f16105f;
                    HashMap<String, d> hashMap = hashMapArr[i11];
                    hashMapArr[i11] = hashMapArr[i12];
                    hashMapArr[i12] = hashMap;
                }
            } else if (f16094v) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
            }
        } else if (f16094v) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    public int i(String str, int i11) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d j11 = j(str);
        if (j11 == null) {
            return i11;
        }
        try {
            return j11.m(this.f16107h);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public final void i0(g gVar, int i11) throws IOException {
        d dVar;
        d dVar2;
        d dVar3 = this.f16105f[i11].get("DefaultCropSize");
        d dVar4 = this.f16105f[i11].get("SensorTopBorder");
        d dVar5 = this.f16105f[i11].get("SensorLeftBorder");
        d dVar6 = this.f16105f[i11].get("SensorBottomBorder");
        d dVar7 = this.f16105f[i11].get("SensorRightBorder");
        if (dVar3 != null) {
            if (dVar3.f16132a == 5) {
                f[] fVarArr = (f[]) dVar3.o(this.f16107h);
                if (fVarArr == null || fVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                    return;
                }
                dVar2 = d.h(fVarArr[0], this.f16107h);
                dVar = d.h(fVarArr[1], this.f16107h);
            } else {
                int[] iArr = (int[]) dVar3.o(this.f16107h);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                dVar2 = d.j(iArr[0], this.f16107h);
                dVar = d.j(iArr[1], this.f16107h);
            }
            this.f16105f[i11].put("ImageWidth", dVar2);
            this.f16105f[i11].put("ImageLength", dVar);
        } else if (dVar4 == null || dVar5 == null || dVar6 == null || dVar7 == null) {
            W(gVar, i11);
        } else {
            int m11 = dVar4.m(this.f16107h);
            int m12 = dVar6.m(this.f16107h);
            int m13 = dVar7.m(this.f16107h);
            int m14 = dVar5.m(this.f16107h);
            if (m12 > m11 && m13 > m14) {
                d j11 = d.j(m12 - m11, this.f16107h);
                d j12 = d.j(m13 - m14, this.f16107h);
                this.f16105f[i11].put("ImageLength", j11);
                this.f16105f[i11].put("ImageWidth", j12);
            }
        }
    }

    public final d j(String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(str)) {
            if (f16094v) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i11 = 0; i11 < f16082j0.length; i11++) {
            d dVar = this.f16105f[i11].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    public final void j0() throws IOException {
        h0(0, 5);
        h0(0, 4);
        h0(5, 4);
        d dVar = this.f16105f[1].get("PixelXDimension");
        d dVar2 = this.f16105f[1].get("PixelYDimension");
        if (!(dVar == null || dVar2 == null)) {
            this.f16105f[0].put("ImageWidth", dVar);
            this.f16105f[0].put("ImageLength", dVar2);
        }
        if (this.f16105f[4].isEmpty() && M(this.f16105f[5])) {
            HashMap<String, d>[] hashMapArr = this.f16105f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!M(this.f16105f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        V(0, "ThumbnailOrientation", "Orientation");
        V(0, "ThumbnailImageLength", "ImageLength");
        V(0, "ThumbnailImageWidth", "ImageWidth");
        V(5, "ThumbnailOrientation", "Orientation");
        V(5, "ThumbnailImageLength", "ImageLength");
        V(5, "ThumbnailImageWidth", "ImageWidth");
        V(4, "Orientation", "ThumbnailOrientation");
        V(4, "ImageLength", "ThumbnailImageLength");
        V(4, "ImageWidth", "ThumbnailImageWidth");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0138, code lost:
        r13 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0141, code lost:
        throw new java.lang.UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0142, code lost:
        r1.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0145, code lost:
        throw r13;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x013a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void k(m1.a.g r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = "yes"
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0146
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever
            r1.<init>()
            m1.a$a r2 = new m1.a$a     // Catch:{ RuntimeException -> 0x013a }
            r2.<init>(r13)     // Catch:{ RuntimeException -> 0x013a }
            m1.b.C0090b.a(r1, r2)     // Catch:{ RuntimeException -> 0x013a }
            r2 = 33
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ RuntimeException -> 0x013a }
            r3 = 34
            java.lang.String r3 = r1.extractMetadata(r3)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 26
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            r5 = 17
            java.lang.String r5 = r1.extractMetadata(r5)     // Catch:{ RuntimeException -> 0x013a }
            boolean r4 = r0.equals(r4)     // Catch:{ RuntimeException -> 0x013a }
            r6 = 0
            if (r4 == 0) goto L_0x0047
            r0 = 29
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r0 = 30
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 31
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x0062
        L_0x0047:
            boolean r0 = r0.equals(r5)     // Catch:{ RuntimeException -> 0x013a }
            if (r0 == 0) goto L_0x0060
            r0 = 18
            java.lang.String r6 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r0 = 19
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ RuntimeException -> 0x013a }
            r4 = 24
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x0062
        L_0x0060:
            r0 = r6
            r4 = r0
        L_0x0062:
            r5 = 0
            if (r6 == 0) goto L_0x0078
            java.util.HashMap<java.lang.String, m1.a$d>[] r7 = r12.f16105f     // Catch:{ RuntimeException -> 0x013a }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r8 = "ImageWidth"
            int r9 = java.lang.Integer.parseInt(r6)     // Catch:{ RuntimeException -> 0x013a }
            java.nio.ByteOrder r10 = r12.f16107h     // Catch:{ RuntimeException -> 0x013a }
            m1.a$d r9 = m1.a.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x013a }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013a }
        L_0x0078:
            if (r0 == 0) goto L_0x008d
            java.util.HashMap<java.lang.String, m1.a$d>[] r7 = r12.f16105f     // Catch:{ RuntimeException -> 0x013a }
            r7 = r7[r5]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r8 = "ImageLength"
            int r9 = java.lang.Integer.parseInt(r0)     // Catch:{ RuntimeException -> 0x013a }
            java.nio.ByteOrder r10 = r12.f16107h     // Catch:{ RuntimeException -> 0x013a }
            m1.a$d r9 = m1.a.d.j(r9, r10)     // Catch:{ RuntimeException -> 0x013a }
            r7.put(r8, r9)     // Catch:{ RuntimeException -> 0x013a }
        L_0x008d:
            r7 = 6
            if (r4 == 0) goto L_0x00b7
            r8 = 1
            int r9 = java.lang.Integer.parseInt(r4)     // Catch:{ RuntimeException -> 0x013a }
            r10 = 90
            if (r9 == r10) goto L_0x00a7
            r10 = 180(0xb4, float:2.52E-43)
            if (r9 == r10) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            if (r9 == r10) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r8 = 8
            goto L_0x00a8
        L_0x00a5:
            r8 = 3
            goto L_0x00a8
        L_0x00a7:
            r8 = r7
        L_0x00a8:
            java.util.HashMap<java.lang.String, m1.a$d>[] r9 = r12.f16105f     // Catch:{ RuntimeException -> 0x013a }
            r9 = r9[r5]     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r10 = "Orientation"
            java.nio.ByteOrder r11 = r12.f16107h     // Catch:{ RuntimeException -> 0x013a }
            m1.a$d r8 = m1.a.d.j(r8, r11)     // Catch:{ RuntimeException -> 0x013a }
            r9.put(r10, r8)     // Catch:{ RuntimeException -> 0x013a }
        L_0x00b7:
            if (r2 == 0) goto L_0x010a
            if (r3 == 0) goto L_0x010a
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ RuntimeException -> 0x013a }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ RuntimeException -> 0x013a }
            if (r3 <= r7) goto L_0x0102
            long r8 = (long) r2     // Catch:{ RuntimeException -> 0x013a }
            r13.g(r8)     // Catch:{ RuntimeException -> 0x013a }
            byte[] r8 = new byte[r7]     // Catch:{ RuntimeException -> 0x013a }
            int r9 = r13.read(r8)     // Catch:{ RuntimeException -> 0x013a }
            if (r9 != r7) goto L_0x00fa
            int r2 = r2 + r7
            int r3 = r3 + -6
            byte[] r7 = f16089q0     // Catch:{ RuntimeException -> 0x013a }
            boolean r7 = java.util.Arrays.equals(r8, r7)     // Catch:{ RuntimeException -> 0x013a }
            if (r7 == 0) goto L_0x00f2
            byte[] r7 = new byte[r3]     // Catch:{ RuntimeException -> 0x013a }
            int r13 = r13.read(r7)     // Catch:{ RuntimeException -> 0x013a }
            if (r13 != r3) goto L_0x00ea
            r12.f16115p = r2     // Catch:{ RuntimeException -> 0x013a }
            r12.S(r7, r5)     // Catch:{ RuntimeException -> 0x013a }
            goto L_0x010a
        L_0x00ea:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Can't read exif"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x00f2:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Invalid identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x00fa:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Can't read identifier"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x0102:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = "Invalid exif length"
            r13.<init>(r0)     // Catch:{ RuntimeException -> 0x013a }
            throw r13     // Catch:{ RuntimeException -> 0x013a }
        L_0x010a:
            boolean r13 = f16094v     // Catch:{ RuntimeException -> 0x013a }
            if (r13 == 0) goto L_0x0134
            java.lang.String r13 = "ExifInterface"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x013a }
            r2.<init>()     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r3 = "Heif meta: "
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r6)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = ", rotation "
            r2.append(r0)     // Catch:{ RuntimeException -> 0x013a }
            r2.append(r4)     // Catch:{ RuntimeException -> 0x013a }
            java.lang.String r0 = r2.toString()     // Catch:{ RuntimeException -> 0x013a }
            android.util.Log.d(r13, r0)     // Catch:{ RuntimeException -> 0x013a }
        L_0x0134:
            r1.release()
            return
        L_0x0138:
            r13 = move-exception
            goto L_0x0142
        L_0x013a:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x0138 }
            java.lang.String r0 = "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
            r13.<init>(r0)     // Catch:{ all -> 0x0138 }
            throw r13     // Catch:{ all -> 0x0138 }
        L_0x0142:
            r1.release()
            throw r13
        L_0x0146:
            java.lang.UnsupportedOperationException r13 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "Reading EXIF from HEIF files is supported from SDK 28 and above"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.k(m1.a$g):void");
    }

    public final int k0(c cVar) throws IOException {
        c cVar2 = cVar;
        e[][] eVarArr = f16082j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : f16083k0) {
            U(eVar.f16137b);
        }
        if (this.f16108i) {
            if (this.f16109j) {
                U("StripOffsets");
                U("StripByteCounts");
            } else {
                U("JPEGInterchangeFormat");
                U("JPEGInterchangeFormatLength");
            }
        }
        for (int i11 = 0; i11 < f16082j0.length; i11++) {
            for (Object obj : this.f16105f[i11].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f16105f[i11].remove(entry.getKey());
                }
            }
        }
        if (!this.f16105f[1].isEmpty()) {
            this.f16105f[0].put(f16083k0[1].f16137b, d.f(0, this.f16107h));
        }
        if (!this.f16105f[2].isEmpty()) {
            this.f16105f[0].put(f16083k0[2].f16137b, d.f(0, this.f16107h));
        }
        if (!this.f16105f[3].isEmpty()) {
            this.f16105f[1].put(f16083k0[3].f16137b, d.f(0, this.f16107h));
        }
        if (this.f16108i) {
            if (this.f16109j) {
                this.f16105f[4].put("StripOffsets", d.j(0, this.f16107h));
                this.f16105f[4].put("StripByteCounts", d.j(this.f16112m, this.f16107h));
            } else {
                this.f16105f[4].put("JPEGInterchangeFormat", d.f(0, this.f16107h));
                this.f16105f[4].put("JPEGInterchangeFormatLength", d.f((long) this.f16112m, this.f16107h));
            }
        }
        for (int i12 = 0; i12 < f16082j0.length; i12++) {
            int i13 = 0;
            for (Map.Entry<String, d> value : this.f16105f[i12].entrySet()) {
                int p11 = ((d) value.getValue()).p();
                if (p11 > 4) {
                    i13 += p11;
                }
            }
            iArr2[i12] = iArr2[i12] + i13;
        }
        int i14 = 8;
        for (int i15 = 0; i15 < f16082j0.length; i15++) {
            if (!this.f16105f[i15].isEmpty()) {
                iArr[i15] = i14;
                i14 += (this.f16105f[i15].size() * 12) + 2 + 4 + iArr2[i15];
            }
        }
        if (this.f16108i) {
            if (this.f16109j) {
                this.f16105f[4].put("StripOffsets", d.j(i14, this.f16107h));
            } else {
                this.f16105f[4].put("JPEGInterchangeFormat", d.f((long) i14, this.f16107h));
            }
            this.f16111l = i14;
            i14 += this.f16112m;
        }
        if (this.f16103d == 4) {
            i14 += 8;
        }
        if (f16094v) {
            for (int i16 = 0; i16 < f16082j0.length; i16++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", new Object[]{Integer.valueOf(i16), Integer.valueOf(iArr[i16]), Integer.valueOf(this.f16105f[i16].size()), Integer.valueOf(iArr2[i16]), Integer.valueOf(i14)}));
            }
        }
        if (!this.f16105f[1].isEmpty()) {
            this.f16105f[0].put(f16083k0[1].f16137b, d.f((long) iArr[1], this.f16107h));
        }
        if (!this.f16105f[2].isEmpty()) {
            this.f16105f[0].put(f16083k0[2].f16137b, d.f((long) iArr[2], this.f16107h));
        }
        if (!this.f16105f[3].isEmpty()) {
            this.f16105f[1].put(f16083k0[3].f16137b, d.f((long) iArr[3], this.f16107h));
        }
        int i17 = this.f16103d;
        if (i17 == 4) {
            cVar2.j(i14);
            cVar2.write(f16089q0);
        } else if (i17 == 13) {
            cVar2.e(i14);
            cVar2.write(I);
        } else if (i17 == 14) {
            cVar2.write(N);
            cVar2.e(i14);
        }
        cVar2.f(this.f16107h == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        cVar2.a(this.f16107h);
        cVar2.j(42);
        cVar2.g(8);
        for (int i18 = 0; i18 < f16082j0.length; i18++) {
            if (!this.f16105f[i18].isEmpty()) {
                cVar2.j(this.f16105f[i18].size());
                int size = iArr[i18] + 2 + (this.f16105f[i18].size() * 12) + 4;
                for (Map.Entry next : this.f16105f[i18].entrySet()) {
                    int i19 = f16085m0[i18].get(next.getKey()).f16136a;
                    d dVar = (d) next.getValue();
                    int p12 = dVar.p();
                    cVar2.j(i19);
                    cVar2.j(dVar.f16132a);
                    cVar2.e(dVar.f16133b);
                    if (p12 > 4) {
                        cVar2.g((long) size);
                        size += p12;
                    } else {
                        cVar2.write(dVar.f16135d);
                        if (p12 < 4) {
                            while (p12 < 4) {
                                cVar2.b(0);
                                p12++;
                            }
                        }
                    }
                }
                if (i18 != 0 || this.f16105f[4].isEmpty()) {
                    cVar2.g(0);
                } else {
                    cVar2.g((long) iArr[4]);
                }
                for (Map.Entry<String, d> value2 : this.f16105f[i18].entrySet()) {
                    byte[] bArr = ((d) value2.getValue()).f16135d;
                    if (bArr.length > 4) {
                        cVar2.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f16108i) {
            cVar2.write(w());
        }
        if (this.f16103d == 14 && i14 % 2 == 1) {
            cVar2.b(0);
        }
        cVar2.a(ByteOrder.BIG_ENDIAN);
        return i14;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0184 A[LOOP:0: B:8:0x0038->B:60:0x0184, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(m1.a.b r22, int r23, int r24) throws java.io.IOException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            boolean r3 = f16094v
            java.lang.String r4 = "ExifInterface"
            if (r3 == 0) goto L_0x0020
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "getJpegAttributes starting with: "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r4, r3)
        L_0x0020:
            java.nio.ByteOrder r3 = java.nio.ByteOrder.BIG_ENDIAN
            r1.e(r3)
            byte r3 = r22.readByte()
            java.lang.String r5 = "Invalid marker: "
            r6 = -1
            if (r3 != r6) goto L_0x01d8
            byte r7 = r22.readByte()
            r8 = -40
            if (r7 != r8) goto L_0x01bd
            r3 = 2
            r5 = r3
        L_0x0038:
            byte r7 = r22.readByte()
            if (r7 != r6) goto L_0x01a0
            r7 = 1
            int r5 = r5 + r7
            byte r8 = r22.readByte()
            boolean r9 = f16094v
            if (r9 == 0) goto L_0x0062
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Found JPEG segment indicator: "
            r10.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.d(r4, r10)
        L_0x0062:
            int r5 = r5 + r7
            r10 = -39
            if (r8 == r10) goto L_0x019a
            r10 = -38
            if (r8 != r10) goto L_0x006d
            goto L_0x019a
        L_0x006d:
            int r10 = r22.readUnsignedShort()
            int r10 = r10 - r3
            int r5 = r5 + r3
            if (r9 == 0) goto L_0x009e
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r11 = "JPEG segment: "
            r9.append(r11)
            r11 = r8 & 255(0xff, float:3.57E-43)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r9.append(r11)
            java.lang.String r11 = " (length: "
            r9.append(r11)
            int r11 = r10 + 2
            r9.append(r11)
            java.lang.String r11 = ")"
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            android.util.Log.d(r4, r9)
        L_0x009e:
            java.lang.String r9 = "Invalid length"
            if (r10 < 0) goto L_0x0194
            r11 = -31
            r12 = 0
            if (r8 == r11) goto L_0x0121
            r11 = -2
            if (r8 == r11) goto L_0x00f3
            switch(r8) {
                case -64: goto L_0x00ba;
                case -63: goto L_0x00ba;
                case -62: goto L_0x00ba;
                case -61: goto L_0x00ba;
                default: goto L_0x00ad;
            }
        L_0x00ad:
            switch(r8) {
                case -59: goto L_0x00ba;
                case -58: goto L_0x00ba;
                case -57: goto L_0x00ba;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            switch(r8) {
                case -55: goto L_0x00ba;
                case -54: goto L_0x00ba;
                case -53: goto L_0x00ba;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            switch(r8) {
                case -51: goto L_0x00ba;
                case -50: goto L_0x00ba;
                case -49: goto L_0x00ba;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            r20 = r4
            goto L_0x0182
        L_0x00ba:
            r1.f(r7)
            java.util.HashMap<java.lang.String, m1.a$d>[] r7 = r0.f16105f
            r7 = r7[r2]
            r8 = 4
            if (r2 == r8) goto L_0x00c7
            java.lang.String r11 = "ImageLength"
            goto L_0x00c9
        L_0x00c7:
            java.lang.String r11 = "ThumbnailImageLength"
        L_0x00c9:
            int r12 = r22.readUnsignedShort()
            long r12 = (long) r12
            java.nio.ByteOrder r14 = r0.f16107h
            m1.a$d r12 = m1.a.d.f(r12, r14)
            r7.put(r11, r12)
            java.util.HashMap<java.lang.String, m1.a$d>[] r7 = r0.f16105f
            r7 = r7[r2]
            if (r2 == r8) goto L_0x00e0
            java.lang.String r8 = "ImageWidth"
            goto L_0x00e2
        L_0x00e0:
            java.lang.String r8 = "ThumbnailImageWidth"
        L_0x00e2:
            int r11 = r22.readUnsignedShort()
            long r11 = (long) r11
            java.nio.ByteOrder r13 = r0.f16107h
            m1.a$d r11 = m1.a.d.f(r11, r13)
            r7.put(r8, r11)
            int r10 = r10 + -5
            goto L_0x00b6
        L_0x00f3:
            byte[] r8 = new byte[r10]
            int r11 = r1.read(r8)
            if (r11 != r10) goto L_0x0119
            java.lang.String r10 = "UserComment"
            java.lang.String r11 = r0.g(r10)
            if (r11 != 0) goto L_0x0115
            java.util.HashMap<java.lang.String, m1.a$d>[] r11 = r0.f16105f
            r7 = r11[r7]
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r13 = f16088p0
            r11.<init>(r8, r13)
            m1.a$d r8 = m1.a.d.e(r11)
            r7.put(r10, r8)
        L_0x0115:
            r20 = r4
            goto L_0x0181
        L_0x0119:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Invalid exif"
            r1.<init>(r2)
            throw r1
        L_0x0121:
            byte[] r8 = new byte[r10]
            r1.readFully(r8)
            int r11 = r5 + r10
            byte[] r13 = f16089q0
            boolean r14 = m1.b.g(r8, r13)
            if (r14 == 0) goto L_0x0147
            int r7 = r13.length
            byte[] r7 = java.util.Arrays.copyOfRange(r8, r7, r10)
            int r5 = r23 + r5
            int r8 = r13.length
            int r5 = r5 + r8
            r0.f16115p = r5
            r0.S(r7, r2)
            m1.a$b r5 = new m1.a$b
            r5.<init>((byte[]) r7)
            r0.f0(r5)
            goto L_0x017e
        L_0x0147:
            byte[] r13 = f16090r0
            boolean r14 = m1.b.g(r8, r13)
            if (r14 == 0) goto L_0x017e
            int r14 = r13.length
            int r5 = r5 + r14
            int r13 = r13.length
            byte[] r8 = java.util.Arrays.copyOfRange(r8, r13, r10)
            java.lang.String r10 = "Xmp"
            java.lang.String r13 = r0.g(r10)
            if (r13 != 0) goto L_0x017e
            java.util.HashMap<java.lang.String, m1.a$d>[] r13 = r0.f16105f
            r13 = r13[r12]
            m1.a$d r15 = new m1.a$d
            r16 = 1
            int r14 = r8.length
            r20 = r4
            long r3 = (long) r5
            r5 = r14
            r14 = r15
            r6 = r15
            r15 = r16
            r16 = r5
            r17 = r3
            r19 = r8
            r14.<init>(r15, r16, r17, r19)
            r13.put(r10, r6)
            r0.f16120u = r7
            goto L_0x0180
        L_0x017e:
            r20 = r4
        L_0x0180:
            r5 = r11
        L_0x0181:
            r10 = r12
        L_0x0182:
            if (r10 < 0) goto L_0x018e
            r1.f(r10)
            int r5 = r5 + r10
            r4 = r20
            r3 = 2
            r6 = -1
            goto L_0x0038
        L_0x018e:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x0194:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r9)
            throw r1
        L_0x019a:
            java.nio.ByteOrder r2 = r0.f16107h
            r1.e(r2)
            return
        L_0x01a0:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid marker:"
            r2.append(r3)
            r3 = r7 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01bd:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01d8:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r3 = r3 & 255(0xff, float:3.57E-43)
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.l(m1.a$b, int, int):void");
    }

    public double[] m() {
        String g11 = g("GPSLatitude");
        String g12 = g("GPSLatitudeRef");
        String g13 = g("GPSLongitude");
        String g14 = g("GPSLongitudeRef");
        if (g11 == null || g12 == null || g13 == null || g14 == null) {
            return null;
        }
        try {
            return new double[]{c(g11, g12), c(g13, g14)};
        } catch (IllegalArgumentException unused) {
            Log.w("ExifInterface", "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", new Object[]{g11, g12, g13, g14}));
            return null;
        }
    }

    public final int n(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (E(bArr)) {
            return 4;
        }
        if (H(bArr)) {
            return 9;
        }
        if (D(bArr)) {
            return 12;
        }
        if (F(bArr)) {
            return 7;
        }
        if (I(bArr)) {
            return 10;
        }
        if (G(bArr)) {
            return 13;
        }
        return N(bArr) ? 14 : 0;
    }

    public final void o(g gVar) throws IOException {
        r(gVar);
        d dVar = this.f16105f[1].get("MakerNote");
        if (dVar != null) {
            g gVar2 = new g(dVar.f16135d);
            gVar2.e(this.f16107h);
            byte[] bArr = F;
            byte[] bArr2 = new byte[bArr.length];
            gVar2.readFully(bArr2);
            gVar2.g(0);
            byte[] bArr3 = G;
            byte[] bArr4 = new byte[bArr3.length];
            gVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                gVar2.g(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                gVar2.g(12);
            }
            T(gVar2, 6);
            d dVar2 = this.f16105f[7].get("PreviewImageStart");
            d dVar3 = this.f16105f[7].get("PreviewImageLength");
            if (!(dVar2 == null || dVar3 == null)) {
                this.f16105f[5].put("JPEGInterchangeFormat", dVar2);
                this.f16105f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = this.f16105f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.f16107h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i11 = (iArr[2] - iArr[0]) + 1;
                    int i12 = (iArr[3] - iArr[1]) + 1;
                    if (i11 < i12) {
                        int i13 = i11 + i12;
                        i12 = i13 - i12;
                        i11 = i13 - i12;
                    }
                    d j11 = d.j(i11, this.f16107h);
                    d j12 = d.j(i12, this.f16107h);
                    this.f16105f[0].put("ImageWidth", j11);
                    this.f16105f[0].put("ImageLength", j12);
                }
            }
        }
    }

    public final void p(b bVar) throws IOException {
        if (f16094v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        bVar.f(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i11 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i12 = i11 + 4;
                    if (i12 == 16) {
                        if (!Arrays.equals(bArr2, J)) {
                            throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                        }
                    }
                    if (!Arrays.equals(bArr2, K)) {
                        if (Arrays.equals(bArr2, I)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f16115p = i12;
                                    S(bArr3, 0);
                                    j0();
                                    f0(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + b.a(bArr2));
                        }
                        int i13 = readInt + 4;
                        bVar.f(i13);
                        length = i12 + i13;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void q(b bVar) throws IOException {
        boolean z11 = f16094v;
        if (z11) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.f(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i11 = ByteBuffer.wrap(bArr).getInt();
        int i12 = ByteBuffer.wrap(bArr2).getInt();
        int i13 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i12];
        bVar.f(i11 - bVar.a());
        bVar.read(bArr4);
        l(new b(bArr4), i11, 5);
        bVar.f(i13 - bVar.a());
        bVar.e(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z11) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i14 = 0; i14 < readInt; i14++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == f16077e0.f16136a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                d j11 = d.j(readShort, this.f16107h);
                d j12 = d.j(readShort2, this.f16107h);
                this.f16105f[0].put("ImageLength", j11);
                this.f16105f[0].put("ImageWidth", j12);
                if (f16094v) {
                    Log.d("ExifInterface", "Updated to length: " + readShort + ", width: " + readShort2);
                    return;
                }
                return;
            }
            bVar.f(readUnsignedShort2);
        }
    }

    public final void r(g gVar) throws IOException {
        d dVar;
        P(gVar);
        T(gVar, 0);
        i0(gVar, 0);
        i0(gVar, 5);
        i0(gVar, 4);
        j0();
        if (this.f16103d == 8 && (dVar = this.f16105f[1].get("MakerNote")) != null) {
            g gVar2 = new g(dVar.f16135d);
            gVar2.e(this.f16107h);
            gVar2.f(6);
            T(gVar2, 9);
            d dVar2 = this.f16105f[9].get("ColorSpace");
            if (dVar2 != null) {
                this.f16105f[1].put("ColorSpace", dVar2);
            }
        }
    }

    public int s() {
        switch (i("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    public final void t(g gVar) throws IOException {
        if (f16094v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + gVar);
        }
        r(gVar);
        d dVar = this.f16105f[0].get("JpgFromRaw");
        if (dVar != null) {
            l(new b(dVar.f16135d), (int) dVar.f16134c, 5);
        }
        d dVar2 = this.f16105f[0].get("ISO");
        d dVar3 = this.f16105f[1].get("PhotographicSensitivity");
        if (dVar2 != null && dVar3 == null) {
            this.f16105f[1].put("PhotographicSensitivity", dVar2);
        }
    }

    public final void u(g gVar) throws IOException {
        byte[] bArr = f16089q0;
        gVar.f(bArr.length);
        byte[] bArr2 = new byte[gVar.available()];
        gVar.readFully(bArr2);
        this.f16115p = bArr.length;
        S(bArr2, 0);
    }

    public byte[] v() {
        int i11 = this.f16114o;
        if (i11 == 6 || i11 == 7) {
            return w();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0063 A[SYNTHETIC, Splitter:B:38:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009e A[Catch:{ Exception -> 0x009c }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] w() {
        /*
            r9 = this;
            java.lang.String r0 = "ExifInterface"
            boolean r1 = r9.f16108i
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            byte[] r1 = r9.f16113n
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            android.content.res.AssetManager$AssetInputStream r1 = r9.f16102c     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            if (r1 == 0) goto L_0x002e
            boolean r3 = r1.markSupported()     // Catch:{ Exception -> 0x0029, all -> 0x0025 }
            if (r3 == 0) goto L_0x001c
            r1.reset()     // Catch:{ Exception -> 0x0029, all -> 0x0025 }
        L_0x001a:
            r3 = r2
            goto L_0x0061
        L_0x001c:
            java.lang.String r3 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r0, r3)     // Catch:{ Exception -> 0x0029, all -> 0x0025 }
            m1.b.c(r1)
            return r2
        L_0x0025:
            r0 = move-exception
            r3 = r2
            goto L_0x00ba
        L_0x0029:
            r3 = move-exception
            r4 = r3
            r3 = r2
            goto L_0x00ab
        L_0x002e:
            java.lang.String r1 = r9.f16100a     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            if (r1 == 0) goto L_0x003a
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.lang.String r3 = r9.f16100a     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            goto L_0x001a
        L_0x003a:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3 = 21
            if (r1 < r3) goto L_0x005f
            java.io.FileDescriptor r1 = r9.f16101b     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            java.io.FileDescriptor r1 = m1.b.a.b(r1)     // Catch:{ Exception -> 0x00a7, all -> 0x00a4 }
            r3 = 0
            int r5 = android.system.OsConstants.SEEK_SET     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            m1.b.a.c(r1, r3, r5)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x005a, all -> 0x0056 }
            r8 = r3
            r3 = r1
            r1 = r8
            goto L_0x0061
        L_0x0056:
            r0 = move-exception
            r3 = r1
            goto L_0x00bb
        L_0x005a:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r2
            goto L_0x00ab
        L_0x005f:
            r1 = r2
            r3 = r1
        L_0x0061:
            if (r1 == 0) goto L_0x009e
            int r4 = r9.f16111l     // Catch:{ Exception -> 0x009c }
            int r5 = r9.f16115p     // Catch:{ Exception -> 0x009c }
            int r4 = r4 + r5
            long r4 = (long) r4     // Catch:{ Exception -> 0x009c }
            long r4 = r1.skip(r4)     // Catch:{ Exception -> 0x009c }
            int r6 = r9.f16111l     // Catch:{ Exception -> 0x009c }
            int r7 = r9.f16115p     // Catch:{ Exception -> 0x009c }
            int r6 = r6 + r7
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            java.lang.String r5 = "Corrupted image"
            if (r4 != 0) goto L_0x0096
            int r4 = r9.f16112m     // Catch:{ Exception -> 0x009c }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x009c }
            int r6 = r1.read(r4)     // Catch:{ Exception -> 0x009c }
            int r7 = r9.f16112m     // Catch:{ Exception -> 0x009c }
            if (r6 != r7) goto L_0x0090
            r9.f16113n = r4     // Catch:{ Exception -> 0x009c }
            m1.b.c(r1)
            if (r3 == 0) goto L_0x008f
            m1.b.b(r3)
        L_0x008f:
            return r4
        L_0x0090:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x009c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x009c }
            throw r4     // Catch:{ Exception -> 0x009c }
        L_0x0096:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ Exception -> 0x009c }
            r4.<init>(r5)     // Catch:{ Exception -> 0x009c }
            throw r4     // Catch:{ Exception -> 0x009c }
        L_0x009c:
            r4 = move-exception
            goto L_0x00ab
        L_0x009e:
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException     // Catch:{ Exception -> 0x009c }
            r4.<init>()     // Catch:{ Exception -> 0x009c }
            throw r4     // Catch:{ Exception -> 0x009c }
        L_0x00a4:
            r0 = move-exception
            r3 = r2
            goto L_0x00bb
        L_0x00a7:
            r3 = move-exception
            r1 = r2
            r4 = r3
            r3 = r1
        L_0x00ab:
            java.lang.String r5 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r0, r5, r4)     // Catch:{ all -> 0x00b9 }
            m1.b.c(r1)
            if (r3 == 0) goto L_0x00b8
            m1.b.b(r3)
        L_0x00b8:
            return r2
        L_0x00b9:
            r0 = move-exception
        L_0x00ba:
            r2 = r1
        L_0x00bb:
            m1.b.c(r2)
            if (r3 == 0) goto L_0x00c3
            m1.b.b(r3)
        L_0x00c3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.w():byte[]");
    }

    public final void x(b bVar) throws IOException {
        if (f16094v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.e(ByteOrder.LITTLE_ENDIAN);
        bVar.f(L.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = M;
        bVar.f(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i11 = length + 4 + 4;
                    if (Arrays.equals(N, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f16115p = i11;
                            S(bArr3, 0);
                            f0(new b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i11 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.f(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void z(b bVar, HashMap hashMap) throws IOException {
        d dVar = (d) hashMap.get("JPEGInterchangeFormat");
        d dVar2 = (d) hashMap.get("JPEGInterchangeFormatLength");
        if (dVar != null && dVar2 != null) {
            int m11 = dVar.m(this.f16107h);
            int m12 = dVar2.m(this.f16107h);
            if (this.f16103d == 7) {
                m11 += this.f16116q;
            }
            if (m11 > 0 && m12 > 0) {
                this.f16108i = true;
                if (this.f16100a == null && this.f16102c == null && this.f16101b == null) {
                    byte[] bArr = new byte[m12];
                    bVar.skip((long) m11);
                    bVar.read(bArr);
                    this.f16113n = bArr;
                }
                this.f16111l = m11;
                this.f16112m = m12;
            }
            if (f16094v) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + m11 + ", length: " + m12);
            }
        }
    }

    public static class g extends b {
        public g(byte[] bArr) throws IOException {
            super(bArr);
            this.f16126b.mark(Integer.MAX_VALUE);
        }

        public void g(long j11) throws IOException {
            int i11 = this.f16128d;
            if (((long) i11) > j11) {
                this.f16128d = 0;
                this.f16126b.reset();
            } else {
                j11 -= (long) i11;
            }
            f((int) j11);
        }

        public g(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f16126b.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final int f16136a;

        /* renamed from: b  reason: collision with root package name */
        public final String f16137b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16138c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16139d;

        public e(String str, int i11, int i12) {
            this.f16137b = str;
            this.f16136a = i11;
            this.f16138c = i12;
            this.f16139d = -1;
        }

        public boolean a(int i11) {
            int i12;
            int i13 = this.f16138c;
            if (i13 == 7 || i11 == 7 || i13 == i11 || (i12 = this.f16139d) == i11) {
                return true;
            }
            if ((i13 == 4 || i12 == 4) && i11 == 3) {
                return true;
            }
            if ((i13 == 9 || i12 == 9) && i11 == 8) {
                return true;
            }
            if ((i13 == 12 || i12 == 12) && i11 == 11) {
                return true;
            }
            return false;
        }

        public e(String str, int i11, int i12, int i13) {
            this.f16137b = str;
            this.f16136a = i11;
            this.f16138c = i12;
            this.f16139d = i13;
        }
    }

    public a(String str) throws IOException {
        e[][] eVarArr = f16082j0;
        this.f16105f = new HashMap[eVarArr.length];
        this.f16106g = new HashSet(eVarArr.length);
        this.f16107h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        B(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.io.FileDescriptor r6) throws java.io.IOException {
        /*
            r5 = this;
            r5.<init>()
            m1.a$e[][] r0 = f16082j0
            int r1 = r0.length
            java.util.HashMap[] r1 = new java.util.HashMap[r1]
            r5.f16105f = r1
            java.util.HashSet r1 = new java.util.HashSet
            int r0 = r0.length
            r1.<init>(r0)
            r5.f16106g = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.BIG_ENDIAN
            r5.f16107h = r0
            java.lang.String r0 = "fileDescriptor cannot be null"
            java.util.Objects.requireNonNull(r6, r0)
            r0 = 0
            r5.f16102c = r0
            r5.f16100a = r0
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 < r3) goto L_0x003e
            boolean r2 = J(r6)
            if (r2 == 0) goto L_0x003e
            r5.f16101b = r6
            java.io.FileDescriptor r6 = m1.b.a.b(r6)     // Catch:{ Exception -> 0x0035 }
            r1 = 1
            goto L_0x0040
        L_0x0035:
            r6 = move-exception
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to duplicate file descriptor"
            r0.<init>(r1, r6)
            throw r0
        L_0x003e:
            r5.f16101b = r0
        L_0x0040:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0053 }
            r2.<init>(r6)     // Catch:{ all -> 0x0053 }
            r5.O(r2)     // Catch:{ all -> 0x0051 }
            m1.b.c(r2)
            if (r1 == 0) goto L_0x0050
            m1.b.b(r6)
        L_0x0050:
            return
        L_0x0051:
            r0 = move-exception
            goto L_0x0057
        L_0x0053:
            r2 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x0057:
            m1.b.c(r2)
            if (r1 == 0) goto L_0x005f
            m1.b.b(r6)
        L_0x005f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.<init>(java.io.FileDescriptor):void");
    }

    public a(InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i11) throws IOException {
        e[][] eVarArr = f16082j0;
        this.f16105f = new HashMap[eVarArr.length];
        this.f16106g = new HashSet(eVarArr.length);
        this.f16107h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        this.f16100a = null;
        if (i11 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f16089q0.length);
            if (!C(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f16104e = true;
            this.f16102c = null;
            this.f16101b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f16102c = (AssetManager.AssetInputStream) inputStream;
            this.f16101b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (J(fileInputStream.getFD())) {
                    this.f16102c = null;
                    this.f16101b = fileInputStream.getFD();
                }
            }
            this.f16102c = null;
            this.f16101b = null;
        }
        O(inputStream);
    }
}
