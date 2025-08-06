package com.bbc876219.lib.localsocket;

import android.net.LocalSocket;
import com.bbc876219.lib.zlog.ZLog;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;

public class Socket {

    /* renamed from: a  reason: collision with root package name */
    public LocalSocket f63194a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f63195b;

    /* renamed from: c  reason: collision with root package name */
    public ByteOrder f63196c;

    public static void e(LocalSocket localSocket, byte[] bArr, int i11) throws IOException {
        InputStream inputStream = localSocket.getInputStream();
        int i12 = 0;
        while (i12 != i11) {
            int read = inputStream.read(bArr, i12, i11 - i12);
            if (read >= 0) {
                i12 += read;
            } else {
                throw new IOException("I/O failure while receiving SDK controller data from socket.");
            }
        }
        ZLog.b("LoaclSocket", "receive() called with: data = [" + Arrays.toString(bArr) + "]");
    }

    public boolean a() {
        LocalSocket localSocket;
        synchronized (this) {
            localSocket = this.f63194a;
            this.f63194a = null;
        }
        if (localSocket == null) {
            return false;
        }
        try {
            localSocket.shutdownInput();
            localSocket.shutdownOutput();
            localSocket.close();
            ZLog.b("LoaclSocket", "Socket is closed for " + this.f63195b);
            return true;
        } catch (IOException e11) {
            ZLog.c("LoaclSocket", "Exception " + e11 + " while closing Socket for " + this.f63195b);
            return false;
        }
    }

    public String b() {
        return this.f63195b;
    }

    public ByteOrder c() {
        return this.f63196c;
    }

    public LocalSocket d() {
        return this.f63194a;
    }

    public void f(byte[] bArr) throws IOException {
        g(bArr, bArr.length);
    }

    public void g(byte[] bArr, int i11) throws IOException {
        LocalSocket localSocket = this.f63194a;
        if (localSocket != null) {
            e(localSocket, bArr, i11);
            return;
        }
        ZLog.g("LoaclSocket", "'receive' request on closed Socket " + this.f63195b);
        throw new ClosedChannelException();
    }

    public void h(byte[] bArr) throws IOException {
        LocalSocket localSocket = this.f63194a;
        if (localSocket != null) {
            ZLog.b("LoaclSocket", "send() called with: data = [" + Arrays.toString(bArr) + "]");
            localSocket.getOutputStream().write(bArr);
            return;
        }
        ZLog.g("LoaclSocket", "'send' request on closed Socket " + this.f63195b);
        throw new ClosedChannelException();
    }

    public void i(LocalMessage localMessage) {
        ZLog.b("LoaclSocket", "sendMessage() called with: msg = [" + localMessage + "]");
        try {
            h(LocalMessage.makeTransByteArray(localMessage, c()));
        } catch (IOException e11) {
            ZLog.d("LoaclSocket", "sendMessage: ", e11);
        }
    }
}
