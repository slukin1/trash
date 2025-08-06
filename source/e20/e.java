package e20;

import com.jumio.commons.log.LogUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPResponse;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public Socket f54273a = null;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f54274b = null;

    /* renamed from: c  reason: collision with root package name */
    public OutputStream f54275c = null;

    public e(Socket socket) {
        j(socket);
        f();
    }

    public boolean a() {
        try {
            InputStream inputStream = this.f54274b;
            if (inputStream != null) {
                inputStream.close();
            }
            OutputStream outputStream = this.f54275c;
            if (outputStream != null) {
                outputStream.close();
            }
            e().close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public InputStream b() {
        return this.f54274b;
    }

    public String c() {
        return e().getLocalAddress().getHostAddress();
    }

    public final OutputStream d() {
        return this.f54275c;
    }

    public Socket e() {
        return this.f54273a;
    }

    public boolean f() {
        Socket e11 = e();
        try {
            this.f54274b = e11.getInputStream();
            this.f54275c = e11.getOutputStream();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void finalize() {
        a();
    }

    public boolean g(HTTPResponse hTTPResponse, long j11, long j12, boolean z11) {
        if (hTTPResponse.B()) {
            return h(hTTPResponse, hTTPResponse.g(), j11, j12, z11);
        }
        return i(hTTPResponse, hTTPResponse.f(), j11, j12, z11);
    }

    public final boolean h(HTTPResponse hTTPResponse, InputStream inputStream, long j11, long j12, boolean z11) {
        HTTPResponse hTTPResponse2 = hTTPResponse;
        InputStream inputStream2 = inputStream;
        long j13 = j12;
        hTTPResponse2.b0(Calendar.getInstance());
        OutputStream d11 = d();
        try {
            hTTPResponse2.Y(j13);
            d11.write(hTTPResponse.k0().getBytes());
            d11.write(LogUtils.NEW_LINE.getBytes());
            if (z11) {
                d11.flush();
                return true;
            }
            boolean H = hTTPResponse.H();
            long j14 = 0;
            if (0 < j11) {
                inputStream.skip(j11);
            }
            int b11 = HTTP.b();
            byte[] bArr = new byte[b11];
            long j15 = (long) b11;
            int read = inputStream2.read(bArr, 0, (int) (j15 < j13 ? j15 : j13));
            while (true) {
                if (read <= 0) {
                    break;
                } else if (j14 >= j13) {
                    break;
                } else {
                    if (H) {
                        d11.write(Long.toHexString((long) read).getBytes());
                        d11.write(LogUtils.NEW_LINE.getBytes());
                    }
                    d11.write(bArr, 0, read);
                    if (H) {
                        d11.write(LogUtils.NEW_LINE.getBytes());
                    }
                    j14 += (long) read;
                    long j16 = j13 - j14;
                    if (j15 < j16) {
                        j16 = j15;
                    }
                    read = inputStream2.read(bArr, 0, (int) j16);
                }
            }
            if (H) {
                d11.write("0".getBytes());
                d11.write(LogUtils.NEW_LINE.getBytes());
            }
            d11.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean i(HTTPResponse hTTPResponse, byte[] bArr, long j11, long j12, boolean z11) {
        hTTPResponse.b0(Calendar.getInstance());
        OutputStream d11 = d();
        try {
            hTTPResponse.Y(j12);
            d11.write(hTTPResponse.k0().getBytes());
            d11.write(LogUtils.NEW_LINE.getBytes());
            if (z11) {
                d11.flush();
                return true;
            }
            boolean H = hTTPResponse.H();
            if (H) {
                d11.write(Long.toHexString(j12).getBytes());
                d11.write(LogUtils.NEW_LINE.getBytes());
            }
            d11.write(bArr, (int) j11, (int) j12);
            if (H) {
                d11.write(LogUtils.NEW_LINE.getBytes());
                d11.write("0".getBytes());
                d11.write(LogUtils.NEW_LINE.getBytes());
            }
            d11.flush();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void j(Socket socket) {
        this.f54273a = socket;
    }
}
