package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.observer.MTObservable;
import com.engagelab.privates.common.observer.MTObserver;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.common.utils.SM4Util;
import com.engagelab.privates.common.utils.SystemUtil;
import com.engagelab.privates.core.api.Address;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentMap<MTProtocol, String> f64952a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public Selector f64953b;

    /* renamed from: c  reason: collision with root package name */
    public SocketChannel f64954c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f64955d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64956e;

    public final boolean a(Context context, String str, int i11) {
        try {
            if (!SystemUtil.isNetworkConnecting(context)) {
                MTCommonLog.e("TcpClient", "can't connect, network is disConnected");
                return false;
            }
            MTCommonLog.d("TcpClient", "tcp connect " + str + ":" + i11);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i11);
            SocketChannel open = SocketChannel.open();
            this.f64954c = open;
            open.configureBlocking(false);
            Selector open2 = Selector.open();
            this.f64953b = open2;
            this.f64954c.register(open2, 8);
            this.f64954c.connect(inetSocketAddress);
            this.f64953b.select();
            Set<SelectionKey> selectedKeys = this.f64953b.selectedKeys();
            if (selectedKeys == null) {
                MTCommonLog.d("TcpClient", "selectionKeys is null");
                return false;
            } else if (selectedKeys.isEmpty()) {
                MTCommonLog.d("TcpClient", "selectionKeys is empty");
                return false;
            } else {
                SelectionKey next = selectedKeys.iterator().next();
                if (next != null) {
                    if (next.isConnectable()) {
                        if (!next.isConnectable()) {
                            MTCommonLog.d("TcpClient", "selectionKey is disConnected");
                            return false;
                        }
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        if (!socketChannel.isConnectionPending()) {
                            MTCommonLog.d("TcpClient", "finish connect");
                            return false;
                        }
                        socketChannel.finishConnect();
                        socketChannel.register(this.f64953b, 1);
                        MTCommonLog.d("TcpClient", "tcp connect success");
                        this.f64955d = true;
                        return true;
                    }
                }
                MTCommonLog.d("TcpClient", "selectionKey is null");
                return false;
            }
        } catch (Throwable th2) {
            MTCommonLog.w("TcpClient", "tcp connect failed " + th2.getMessage());
            a(context);
            return false;
        }
    }

    public final boolean b(Context context) {
        MTProtocol threadName = new MTProtocol().setRid(MTCoreGlobal.getRid()).setCommand(1).setVersion(23).setBody(h.d(context)).setThreadName("ENGAGELAB-PRIVATES-CONNECT");
        if (threadName == null) {
            MTCommonLog.w("TcpClient", "login failed, send request failed");
            return false;
        }
        MTCommonLog.d("TcpClient", "send " + threadName.toString());
        b(context, a(context, threadName));
        MTProtocol a11 = a(context, d(context));
        if (a11 == null) {
            MTCommonLog.w("TcpClient", "login failed, receive response failed");
            return false;
        }
        MTCommonLog.d("TcpClient", "receive " + a11.toString());
        if (h.a(context, a11.getBody()) == 0) {
            a.a().a(context);
            MTCommonPrivatesApi.sendMessageToMainProcess(context, 2001, (Bundle) null);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.ON_TCP_CONNECTED, (Bundle) null);
            return true;
        }
        MTCommonPrivatesApi.sendMessageToMainProcess(context, 2002, (Bundle) null);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.ON_TCP_DISCONNECTED, (Bundle) null);
        return false;
    }

    public final Set<String> c(Context context) {
        Set<String> k11 = g.k(context);
        Address address = MTCoreGlobal.getAddress();
        int defaultPort = address.getDefaultPort();
        if (defaultPort <= 0) {
            return k11;
        }
        String defaultHost = address.getDefaultHost();
        if (!TextUtils.isEmpty(defaultHost)) {
            k11.add(defaultHost + ":" + defaultPort);
        }
        String defaultIp = address.getDefaultIp();
        if (!TextUtils.isEmpty(defaultIp)) {
            k11.add(defaultIp + ":" + defaultPort);
        }
        return k11;
    }

    public byte[] d(Context context) {
        try {
            if (!this.f64955d) {
                MTCommonLog.d("TcpClient", "tcp is not connecting");
                return null;
            }
            this.f64953b.select();
            if (!this.f64953b.isOpen()) {
                MTCommonLog.d("TcpClient", "selector is closed");
                return null;
            }
            Set<SelectionKey> selectedKeys = this.f64953b.selectedKeys();
            if (selectedKeys == null) {
                MTCommonLog.w("TcpClient", "selectionKeys is null");
                a(context);
                return null;
            } else if (selectedKeys.isEmpty()) {
                MTCommonLog.w("TcpClient", "selectionKeys is empty");
                a(context);
                return null;
            } else {
                Iterator<SelectionKey> it2 = selectedKeys.iterator();
                if (!it2.hasNext()) {
                    MTCommonLog.w("TcpClient", "selectionKeys hasn't next");
                    a(context);
                    return null;
                }
                SelectionKey next = it2.next();
                if (next == null) {
                    MTCommonLog.w("TcpClient", "selectionKey is null");
                    a(context);
                    return null;
                } else if (!next.isReadable()) {
                    MTCommonLog.w("TcpClient", "selectionKey is disReadable");
                    a(context);
                    return null;
                } else {
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    if (!socketChannel.isConnected()) {
                        MTCommonLog.w("TcpClient", "socketChannel is disConnected");
                        a(context);
                        return null;
                    }
                    if (this.f64955d) {
                        ByteBuffer allocate = ByteBuffer.allocate(2);
                        int read = socketChannel.read(allocate);
                        if (read < 0) {
                            MTCommonLog.w("TcpClient", "read ahead length = " + read);
                            a(context);
                            return null;
                        }
                        byte[] array = allocate.array();
                        int i11 = ByteBuffer.wrap(array).getShort() & 16383;
                        if (i11 == 0) {
                            MTCommonLog.w("TcpClient", "read total length = " + i11);
                            a(context);
                            return null;
                        }
                        ByteBuffer allocate2 = ByteBuffer.allocate(i11 - 2);
                        int read2 = socketChannel.read(allocate2);
                        if (read2 == 0) {
                            MTCommonLog.w("TcpClient", "read content length = " + read2);
                            a(context);
                            return null;
                        }
                        byte[] array2 = allocate2.array();
                        byte[] bArr = new byte[i11];
                        System.arraycopy(array, 0, bArr, 0, array.length);
                        System.arraycopy(array2, 0, bArr, array.length, array2.length);
                        return bArr;
                    }
                    return null;
                }
            }
        } catch (IOException e11) {
            MTCommonLog.w("TcpClient", "receive IOException " + e11.getMessage());
            a(context);
        } catch (Throwable th2) {
            MTCommonLog.w("TcpClient", "receive failed " + th2.getMessage());
            a(context);
        }
    }

    public final void e(Context context) {
        byte[] d11;
        MTCommonLog.d("TcpClient", "receiving......");
        while (this.f64955d && (d11 = d(context)) != null) {
            MTProtocol a11 = a(context, d11);
            if (a11 == null) {
                MTCommonLog.d("TcpClient", "parseResponse failed");
            } else {
                b(context, a11);
            }
        }
    }

    public final boolean f(Context context) {
        long m11 = g.m(context);
        String g11 = g.g(context);
        String d11 = g.d(context);
        MTCommonLog.d("TcpClient", "register uid:" + m11 + ",rid:" + g11 + ",password:" + d11);
        if (m11 > 0 && !TextUtils.isEmpty(g11) && !TextUtils.isEmpty(d11)) {
            return true;
        }
        MTProtocol threadName = new MTProtocol().setRid(MTCoreGlobal.getRid()).setCommand(0).setVersion(19).setBody(h.e(context)).setThreadName("ENGAGELAB-PRIVATES-CONNECT");
        if (threadName == null) {
            MTCommonLog.w("TcpClient", "register failed, send request failed");
            return false;
        }
        MTCommonLog.d("TcpClient", "send " + threadName.toString());
        b(context, a(context, threadName));
        MTProtocol a11 = a(context, d(context));
        if (a11 == null) {
            MTCommonLog.w("TcpClient", "register failed, receive response failed");
            return false;
        }
        MTCommonLog.d("TcpClient", "receive " + a11.toString());
        if (h.b(context, a11.getBody()) == 0) {
            a.a().b(context);
            return true;
        }
        MTCommonPrivatesApi.sendMessageToMainProcess(context, 2002, (Bundle) null);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.ON_TCP_DISCONNECTED, (Bundle) null);
        return false;
    }

    public void g(Context context) {
        this.f64956e = true;
        if (this.f64955d) {
            MTCommonLog.d("TcpClient", "can't connect, isTcpConnecting");
            return;
        }
        this.f64955d = true;
        Set<String> c11 = c(context);
        if (c11.isEmpty()) {
            MTCommonLog.w("TcpClient", "there are no tcp connect address");
            a(context);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(c11);
        int connectRetryCount = MTCoreGlobal.getConnectRetryCount();
        for (int i11 = 0; i11 < connectRetryCount; i11++) {
            MTCommonLog.d("TcpClient", "connect retry count is " + i11);
            for (String str : arrayList) {
                if (!g.a(context)) {
                    MTCommonLog.d("TcpClient", "can't connect ,connect state is false");
                    return;
                } else if (!this.f64956e) {
                    MTCommonLog.d("TcpClient", "can't connect ,tcp state is false");
                    return;
                } else {
                    String[] split = str.split(":");
                    String str2 = split[split.length - 1];
                    if (!a(context, str.substring(0, (str.length() - str2.length()) - 1), Integer.parseInt(str2))) {
                        a(context);
                    } else if (!f(context)) {
                        a(context);
                    } else if (!b(context)) {
                        a(context);
                    } else {
                        e(context);
                    }
                }
            }
        }
    }

    public void h(Context context) {
        this.f64956e = false;
        a(context);
        MTCommonPrivatesApi.sendMessageToMainProcess(context, 2002, (Bundle) null);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.ON_TCP_DISCONNECTED, (Bundle) null);
    }

    public final void b(Context context, byte[] bArr) {
        try {
            if (!this.f64955d) {
                MTCommonLog.d("TcpClient", "can't send, tcp is not connected");
                return;
            }
            SocketChannel socketChannel = this.f64954c;
            if (socketChannel != null && socketChannel.isConnected()) {
                this.f64954c.write(ByteBuffer.wrap(bArr));
            }
        } catch (IOException e11) {
            MTCommonLog.w("TcpClient", "send IOException " + e11.getMessage());
            a(context);
        } catch (NotYetConnectedException e12) {
            MTCommonLog.w("TcpClient", "send NotYetConnectedException " + e12.getMessage());
            a(context);
        } catch (Throwable th2) {
            MTCommonLog.w("TcpClient", "send throwable " + th2.getMessage());
            a(context);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            try {
                MTCommonLog.d("TcpClient", "can't send, bundle is null");
            } catch (Throwable th2) {
                MTCommonLog.w("TcpClient", "send failed " + th2.getMessage());
                a(context);
            }
        } else if (bundle.containsKey("data")) {
            if (this.f64955d) {
                if (SystemUtil.isNetworkConnecting(context)) {
                    b(context, bundle.getByteArray("data"));
                    return;
                }
            }
            MTCommonLog.d("TcpClient", "can't send data, tcp is not connected");
            a(context);
        } else {
            bundle.setClassLoader(MTProtocol.class.getClassLoader());
            MTProtocol mTProtocol = (MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL);
            if (!SystemUtil.isNetworkConnecting(context)) {
                MTCommonLog.d("TcpClient", "can't send command:" + mTProtocol.getCommand() + ", network is disConnected");
                a(context);
                MTCommonPrivatesApi.sendMessageDelayed(context, mTProtocol.getThreadName(), mTProtocol.getCommand(), bundle, 0);
            } else if (!this.f64955d) {
                MTCommonLog.d("TcpClient", "can't send command:" + mTProtocol.getCommand() + ", tcp is disConnected");
                a(context);
                MTCommonPrivatesApi.sendMessageDelayed(context, mTProtocol.getThreadName(), mTProtocol.getCommand(), bundle, 0);
            } else {
                if (mTProtocol.getRid() == 0) {
                    mTProtocol.setRid(MTCoreGlobal.getRid());
                }
                MTCommonLog.d("TcpClient", "send " + mTProtocol.toString());
                String threadName = mTProtocol.getThreadName();
                byte[] a11 = a(context, mTProtocol);
                if (a11 != null) {
                    b(context, a11);
                    if (!TextUtils.isEmpty(threadName)) {
                        this.f64952a.put(mTProtocol, threadName);
                        MTCommonPrivatesApi.sendMessageDelayed(context, threadName, mTProtocol.getCommand(), bundle, 10000);
                    }
                }
            }
        }
    }

    public final void b(Context context, MTProtocol mTProtocol) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, mTProtocol);
        Iterator it2 = this.f64952a.keySet().iterator();
        while (it2.hasNext()) {
            MTProtocol mTProtocol2 = (MTProtocol) it2.next();
            if (mTProtocol2.getRid() == mTProtocol.getRid()) {
                String str = (String) this.f64952a.get(mTProtocol2);
                mTProtocol.setThreadName(str);
                MTCommonLog.d("TcpClient", "receive " + mTProtocol.toString());
                it2.remove();
                MTCommonPrivatesApi.removeMessages(context, str, mTProtocol2.getCommand());
                MTCommonPrivatesApi.sendMessage(context, str, mTProtocol.getCommand(), bundle);
                return;
            }
        }
        Iterator<MTObserver> it3 = MTObservable.getInstance().observeQueue.iterator();
        while (it3.hasNext()) {
            MTObserver next = it3.next();
            if (next.isSupport(mTProtocol.getCommand())) {
                String str2 = next.getThreadName()[0];
                mTProtocol.setThreadName(str2);
                MTCommonLog.d("TcpClient", "receive " + mTProtocol.toString());
                MTCommonPrivatesApi.sendMessage(context, str2, mTProtocol.getCommand(), bundle);
            }
        }
    }

    public final void a(Context context) {
        MTCommonLog.d("TcpClient", "tcp disconnect");
        this.f64955d = false;
        MTCommonPrivatesApi.removeMessages(context, "ENGAGELAB-PRIVATES-CORE", MTCoreConstants.RemoteWhat.START_HEARTBEAT);
        try {
            Selector selector = this.f64953b;
            if (selector != null && selector.isOpen()) {
                this.f64953b.close();
                this.f64953b = null;
            }
            SocketChannel socketChannel = this.f64954c;
            if (socketChannel != null && socketChannel.isConnected()) {
                this.f64954c.finishConnect();
                this.f64954c.close();
                this.f64954c = null;
            }
        } catch (Throwable th2) {
            MTCommonLog.w("TcpClient", "disconnect failed " + th2.getMessage());
        }
    }

    public boolean a() {
        return this.f64955d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8 A[Catch:{ all -> 0x015b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(android.content.Context r20, com.engagelab.privates.core.api.MTProtocol r21) {
        /*
            r19 = this;
            java.lang.String r0 = "TcpClient"
            int r1 = r21.getCommand()     // Catch:{ all -> 0x015b }
            int r2 = r21.getVersion()     // Catch:{ all -> 0x015b }
            long r3 = com.engagelab.privates.common.g.m(r20)     // Catch:{ all -> 0x015b }
            int r5 = com.engagelab.privates.common.g.h(r20)     // Catch:{ all -> 0x015b }
            long r6 = r21.getRid()     // Catch:{ all -> 0x015b }
            int r8 = com.engagelab.privates.common.global.MTGlobal.getEncryptType()     // Catch:{ all -> 0x015b }
            r9 = 2
            r10 = 1
            if (r8 == r10) goto L_0x0024
            if (r8 == r9) goto L_0x0024
            r12 = 24
            r13 = 0
            goto L_0x0027
        L_0x0024:
            r12 = 27
            r13 = r10
        L_0x0027:
            com.engagelab.privates.core.api.Outputer r14 = new com.engagelab.privates.core.api.Outputer     // Catch:{ all -> 0x015b }
            r14.<init>(r12)     // Catch:{ all -> 0x015b }
            if (r13 == 0) goto L_0x0036
            r14.writeU8(r12)     // Catch:{ all -> 0x015b }
            r14.writeU8(r13)     // Catch:{ all -> 0x015b }
            r15 = r10
            goto L_0x0037
        L_0x0036:
            r15 = 0
        L_0x0037:
            r9 = r1 ^ 90
            r14.writeU8(r9)     // Catch:{ all -> 0x015b }
            r9 = r2 ^ 90
            r14.writeU8(r9)     // Catch:{ all -> 0x015b }
            r16 = 6510615555426900570(0x5a5a5a5a5a5a5a5a, double:1.7838867517321418E127)
            long r10 = r3 ^ r16
            r14.writeU64(r10)     // Catch:{ all -> 0x015b }
            long r10 = (long) r5     // Catch:{ all -> 0x015b }
            r14.writeU32(r10)     // Catch:{ all -> 0x015b }
            long r10 = r6 ^ r16
            r14.writeU64(r10)     // Catch:{ all -> 0x015b }
            r5 = 0
            r14.writeU16(r5)     // Catch:{ all -> 0x015b }
            r5 = 1
            if (r13 != r5) goto L_0x005e
            r14.writeU8(r8)     // Catch:{ all -> 0x015b }
        L_0x005e:
            byte[] r5 = r14.toByteArray()     // Catch:{ all -> 0x015b }
            byte[] r10 = r21.getBody()     // Catch:{ all -> 0x015b }
            long r16 = com.engagelab.privates.common.g.m(r20)     // Catch:{ all -> 0x015b }
            java.lang.String r11 = com.engagelab.privates.common.utils.AESUtil.getMd5AesKey(r16)     // Catch:{ all -> 0x015b }
            if (r8 == 0) goto L_0x008d
            r14 = 16
            r9 = 1
            if (r8 == r9) goto L_0x0083
            r9 = 2
            if (r8 == r9) goto L_0x0079
            goto L_0x0092
        L_0x0079:
            r9 = 0
            java.lang.String r14 = r11.substring(r9, r14)     // Catch:{ all -> 0x015b }
            byte[] r10 = com.engagelab.privates.common.utils.SM4Util.encryptBytes(r10, r11, r14)     // Catch:{ all -> 0x015b }
            goto L_0x0092
        L_0x0083:
            r9 = 0
            java.lang.String r14 = r11.substring(r9, r14)     // Catch:{ all -> 0x015b }
            byte[] r9 = com.engagelab.privates.common.utils.AESUtil.encryptBytes(r10, r11, r14)     // Catch:{ all -> 0x015b }
            goto L_0x0091
        L_0x008d:
            byte[] r9 = com.engagelab.privates.common.utils.AESUtil.encryptBytes(r10, r11)     // Catch:{ all -> 0x015b }
        L_0x0091:
            r10 = r9
        L_0x0092:
            int r11 = r10.length     // Catch:{ all -> 0x015b }
            int r14 = r12 + 2
            int r9 = r14 + r11
            r16 = r10
            r21 = r14
            r10 = 2
            byte[] r14 = new byte[r10]     // Catch:{ all -> 0x015b }
            int r10 = r9 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10     // Catch:{ all -> 0x015b }
            r17 = 0
            r14[r17] = r10     // Catch:{ all -> 0x015b }
            r10 = r9 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10     // Catch:{ all -> 0x015b }
            r18 = 1
            r14[r18] = r10     // Catch:{ all -> 0x015b }
            r10 = r9
            byte r9 = r14[r17]     // Catch:{ all -> 0x015b }
            r9 = r9 | 128(0x80, float:1.794E-43)
            byte r9 = (byte) r9     // Catch:{ all -> 0x015b }
            r14[r17] = r9     // Catch:{ all -> 0x015b }
            if (r15 == 0) goto L_0x00bf
            byte r9 = r14[r17]     // Catch:{ all -> 0x015b }
            r9 = r9 | 64
            byte r9 = (byte) r9     // Catch:{ all -> 0x015b }
            r14[r17] = r9     // Catch:{ all -> 0x015b }
        L_0x00bf:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            r9.<init>()     // Catch:{ all -> 0x015b }
            r17 = r5
            java.lang.String r5 = "send ahead length:2, encryption:"
            r9.append(r5)     // Catch:{ all -> 0x015b }
            r5 = 1
            r9.append(r5)     // Catch:{ all -> 0x015b }
            java.lang.String r5 = ", expand:"
            r9.append(r5)     // Catch:{ all -> 0x015b }
            r9.append(r15)     // Catch:{ all -> 0x015b }
            java.lang.String r5 = ", totalLength:"
            r9.append(r5)     // Catch:{ all -> 0x015b }
            r9.append(r10)     // Catch:{ all -> 0x015b }
            java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x015b }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r5)     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            r5.<init>()     // Catch:{ all -> 0x015b }
            java.lang.String r9 = "send head  length:"
            r5.append(r9)     // Catch:{ all -> 0x015b }
            r5.append(r12)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = ", headVersion:"
            r5.append(r9)     // Catch:{ all -> 0x015b }
            r5.append(r13)     // Catch:{ all -> 0x015b }
            java.lang.String r9 = ", command:"
            r5.append(r9)     // Catch:{ all -> 0x015b }
            r5.append(r1)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = ", version:"
            r5.append(r1)     // Catch:{ all -> 0x015b }
            r5.append(r2)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = ", uid:"
            r5.append(r1)     // Catch:{ all -> 0x015b }
            r5.append(r3)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = ", rid:"
            r5.append(r1)     // Catch:{ all -> 0x015b }
            r5.append(r6)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = ", crc16:"
            r5.append(r1)     // Catch:{ all -> 0x015b }
            r1 = 0
            r5.append(r1)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = ", encrypt:"
            r5.append(r1)     // Catch:{ all -> 0x015b }
            r5.append(r8)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x015b }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r1)     // Catch:{ all -> 0x015b }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            r1.<init>()     // Catch:{ all -> 0x015b }
            java.lang.String r2 = "send body  length:"
            r1.append(r2)     // Catch:{ all -> 0x015b }
            r1.append(r11)     // Catch:{ all -> 0x015b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x015b }
            com.engagelab.privates.common.log.MTCommonLog.d(r0, r1)     // Catch:{ all -> 0x015b }
            byte[] r0 = new byte[r10]     // Catch:{ all -> 0x015b }
            r1 = 2
            r2 = 0
            java.lang.System.arraycopy(r14, r2, r0, r2, r1)     // Catch:{ all -> 0x015b }
            r3 = r17
            java.lang.System.arraycopy(r3, r2, r0, r1, r12)     // Catch:{ all -> 0x015b }
            r12 = r21
            r10 = r16
            java.lang.System.arraycopy(r10, r2, r0, r12, r11)     // Catch:{ all -> 0x015b }
            return r0
        L_0x015b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.engagelab.privates.common.d.a(android.content.Context, com.engagelab.privates.core.api.MTProtocol):byte[]");
    }

    public final MTProtocol a(Context context, byte[] bArr) {
        byte b11;
        byte[] bArr2;
        byte[] bArr3 = bArr;
        if (bArr3 == null) {
            return null;
        }
        try {
            MTProtocol mTProtocol = new MTProtocol();
            byte[] bArr4 = new byte[2];
            System.arraycopy(bArr3, 0, bArr4, 0, 2);
            short s11 = ByteBuffer.wrap(bArr4).getShort();
            int i11 = (s11 >>> 14) & 1;
            byte b12 = s11 & 16383;
            MTCommonLog.d("TcpClient", "receive ahead length:2, encryption:" + ((s11 >>> 15) & 1) + ", expand:" + i11 + ", totalLength:" + b12);
            int i12 = b12 + -2;
            byte[] bArr5 = new byte[i12];
            System.arraycopy(bArr3, 2, bArr5, 0, i12);
            ByteBuffer wrap = ByteBuffer.wrap(bArr5);
            byte b13 = 20;
            if (i11 == 1) {
                b13 = wrap.get();
                b11 = wrap.get();
            } else {
                b11 = 0;
            }
            byte b14 = wrap.get() ^ 90;
            byte b15 = wrap.get() ^ 90;
            long j11 = wrap.getLong() ^ 6510615555426900570L;
            byte b16 = b12;
            long j12 = wrap.getLong() ^ 6510615555426900570L;
            try {
                short s12 = wrap.getShort();
                byte b17 = (i11 == 1 && b11 == 1) ? wrap.get() : 0;
                mTProtocol.setCommand(b14);
                mTProtocol.setVersion(b15);
                mTProtocol.setRid(j12);
                MTCommonLog.d("TcpClient", "receive head  length:" + b13 + ", headVersion:" + b11 + ", command:" + b14 + ", version:" + b15 + ", uid:" + j11 + ", rid:" + j12 + ", crc16:" + s12 + ", encrypt:" + b17);
                int i13 = (b16 - b13) - 2;
                byte[] bArr6 = new byte[i13];
                System.arraycopy(bArr5, b13, bArr6, 0, i13);
                String md5AesKey = AESUtil.getMd5AesKey(g.m(context));
                if (b17 == 0) {
                    bArr2 = AESUtil.decryptBytes(bArr6, md5AesKey);
                } else if (b17 == 1) {
                    bArr2 = AESUtil.decryptBytes(bArr6, md5AesKey, md5AesKey.substring(0, 16));
                } else if (b17 != 2) {
                    mTProtocol.setBody(bArr6);
                    MTCommonLog.d("TcpClient", "receive body  length:" + i13 + ", decryptBodyLength:" + bArr6.length);
                    return mTProtocol;
                } else {
                    bArr2 = SM4Util.decryptBytes(bArr6, md5AesKey);
                }
                bArr6 = bArr2;
                mTProtocol.setBody(bArr6);
                MTCommonLog.d("TcpClient", "receive body  length:" + i13 + ", decryptBodyLength:" + bArr6.length);
                return mTProtocol;
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
