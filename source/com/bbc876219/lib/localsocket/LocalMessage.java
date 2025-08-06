package com.bbc876219.lib.localsocket;

import android.net.LocalSocket;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bbc876219.lib.zlog.ZLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;

public final class LocalMessage implements Parcelable {
    public static final Parcelable.Creator<LocalMessage> CREATOR = new a();
    public static final int FLAGS_TO_CLEAR_ON_COPY_FROM = 1;
    public static final int FLAG_ASYNCHRONOUS = 2;
    public static final int FLAG_IN_USE = 1;
    private static final int MAX_POOL_SIZE = 50;
    public static final byte MSG_ACK = 4;
    public static final byte MSG_BODY = 5;
    public static final byte MSG_BODY_TARGET = 3;
    public static final byte MSG_BODY_TOKEN = 4;
    public static final byte MSG_ID = 2;
    public static final byte MSG_SIGNATURE = 6;
    public static final byte MSG_SIZE = 1;
    public static final byte MSG_SYNC = 3;
    public static final byte MSG_TYPE = 0;
    public static final byte MSG_TYPE_ACK = 3;
    public static final byte MSG_TYPE_CLOSE = 6;
    public static final byte MSG_TYPE_HANDSHAKE = 7;
    public static final byte MSG_TYPE_PING = 4;
    public static final byte MSG_TYPE_PONG = 5;
    private static final String TAG = "LocalMessage";
    private static boolean gCheckRecycle = true;
    private static LocalMessage sPool;
    private static int sPoolSize;
    public static final Object sPoolSync = new Object();
    public boolean ack = false;
    public byte[] body;
    public Bundle data;
    public int flags;

    /* renamed from: id  reason: collision with root package name */
    public int f63188id;
    public boolean isUiHander = false;
    public LocalMessage next;
    public String target;
    private long times = 0;
    public String token;
    public byte type = 7;
    public long when;

    public static class a implements Parcelable.Creator<LocalMessage> {
        /* renamed from: a */
        public LocalMessage createFromParcel(Parcel parcel) {
            LocalMessage obtain = LocalMessage.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* renamed from: b */
        public LocalMessage[] newArray(int i11) {
            return new LocalMessage[i11];
        }
    }

    private static byte getCheckCode(byte[] bArr) {
        byte b11 = 0;
        for (byte b12 : bArr) {
            b11 = (byte) (b11 ^ b12);
        }
        return b11;
    }

    public static byte[] makeByteBuffer(LocalMessage localMessage, ByteOrder byteOrder) {
        ByteBuffer allocate = ByteBuffer.allocate(localMessage.calculateTransLenght());
        allocate.order(byteOrder);
        byte b11 = localMessage.type;
        if (b11 == 3) {
            allocate.put(b11);
            allocate.putInt(localMessage.f63188id);
            String str = localMessage.token;
            if (str == null) {
                allocate.putInt(0);
            } else {
                allocate.putInt(str.getBytes().length);
                allocate.put(localMessage.token.getBytes());
            }
        } else if (b11 == 4 || b11 == 5 || b11 == 6 || b11 == 7) {
            allocate.put(b11);
            String str2 = localMessage.token;
            if (str2 == null) {
                allocate.putInt(0);
            } else {
                allocate.putInt(str2.getBytes().length);
                allocate.put(localMessage.token.getBytes());
            }
        }
        return allocate.array();
    }

    public static LocalMessage makeMessage(ByteBuffer byteBuffer) {
        int i11;
        LocalMessage obtain = obtain();
        byte b11 = byteBuffer.get();
        obtain.type = b11;
        if (b11 == 3) {
            obtain.f63188id = byteBuffer.getInt();
            int i12 = byteBuffer.getInt();
            if (i12 > 0) {
                byte[] bArr = new byte[i12];
                byteBuffer.get(bArr);
                obtain.token = new String(bArr);
            }
        } else if ((b11 == 4 || b11 == 5 || b11 == 6 || b11 == 7) && (i11 = byteBuffer.getInt()) > 0) {
            byte[] bArr2 = new byte[i11];
            byteBuffer.get(bArr2);
            obtain.token = new String(bArr2);
        }
        return obtain;
    }

    public static byte[] makeTransByteArray(LocalMessage localMessage, ByteOrder byteOrder) {
        ByteBuffer allocate = ByteBuffer.allocate(localMessage.calculateTransLenght() + 6);
        allocate.order(byteOrder);
        allocate.put((byte) 1);
        byte[] makeByteBuffer = makeByteBuffer(localMessage, byteOrder);
        allocate.putInt(makeByteBuffer.length);
        allocate.put(makeByteBuffer);
        allocate.put(getCheckCode(makeByteBuffer));
        return allocate.array();
    }

    public static LocalMessage obtain() {
        synchronized (sPoolSync) {
            LocalMessage localMessage = sPool;
            if (localMessage == null) {
                return new LocalMessage();
            }
            sPool = localMessage.next;
            localMessage.next = null;
            localMessage.flags = 0;
            sPoolSize--;
            return localMessage;
        }
    }

    public static LocalMessage obtainClose(String str) {
        LocalMessage obtain = obtain();
        obtain.type = 6;
        obtain.token = str;
        obtain.times = System.currentTimeMillis();
        obtain.ack = false;
        obtain.f63188id = 0;
        obtain.target = null;
        obtain.body = null;
        obtain.isUiHander = false;
        obtain.data = null;
        obtain.when = 0;
        return obtain;
    }

    public static LocalMessage obtainHandShake(String str) {
        LocalMessage obtain = obtain();
        obtain.type = 7;
        obtain.token = str;
        obtain.times = System.currentTimeMillis();
        obtain.ack = false;
        obtain.f63188id = 0;
        obtain.target = null;
        obtain.body = null;
        obtain.isUiHander = false;
        obtain.data = null;
        obtain.when = 0;
        return obtain;
    }

    /* access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        this.type = parcel.readByte();
        this.f63188id = parcel.readInt();
        this.ack = parcel.readBoolean();
        this.times = parcel.readLong();
        this.isUiHander = parcel.readBoolean();
        if (parcel.readInt() > 0) {
            this.token = parcel.readString();
        }
        if (parcel.readInt() > 0) {
            this.target = parcel.readString();
        }
        if (parcel.readInt() != 0) {
            parcel.readByteArray(this.body);
        }
        this.when = parcel.readLong();
        this.data = parcel.readBundle();
    }

    public static LocalMessage receiveLocalMessage(ByteBuffer byteBuffer, LocalSocket localSocket, ByteOrder byteOrder) throws IOException {
        ZLog.b(TAG, "receiveLocalMessage() called with: header = [" + byteBuffer + "], socket = [" + localSocket + "], mEndian = [" + Arrays.toString(byteBuffer.array()) + "]");
        LocalMessage obtain = obtain();
        obtain.type = byteBuffer.get();
        int i11 = byteBuffer.getInt();
        ZLog.b(TAG, "receiveLocalMessage() called with: msg.type = [" + obtain.type + "], lenght = [" + i11 + "], mEndian = [" + byteOrder + "]");
        int i12 = i11 + 1;
        ByteBuffer allocate = ByteBuffer.allocate(i12);
        allocate.order(byteOrder);
        allocate.position(0);
        if (localSocket != null) {
            Socket.e(localSocket, allocate.array(), i12);
            LocalMessage makeMessage = makeMessage(allocate);
            ZLog.b(TAG, "receiveLocalMessage() called with: msg = [" + makeMessage + "]");
            return makeMessage;
        }
        ZLog.g(TAG, "'receive' request on closed Socket ");
        throw new ClosedChannelException();
    }

    public static void updateCheckRecycle(int i11) {
        if (i11 < 21) {
            gCheckRecycle = false;
        }
    }

    public int calculateTransLenght() {
        byte b11 = this.type;
        if (b11 != 6 && b11 != 7) {
            return 0;
        }
        int i11 = 4;
        if (!TextUtils.isEmpty(this.token)) {
            i11 = 4 + this.token.getBytes().length;
        }
        return i11 + 1;
    }

    public void copyFrom(LocalMessage localMessage) {
        this.flags = localMessage.flags & -2;
        this.type = localMessage.type;
        this.token = localMessage.token;
        this.times = localMessage.times;
        this.ack = localMessage.ack;
        this.f63188id = localMessage.f63188id;
        this.target = localMessage.target;
        this.body = localMessage.body;
        this.isUiHander = localMessage.isUiHander;
        this.when = 0;
        Bundle bundle = localMessage.data;
        if (bundle != null) {
            this.data = (Bundle) bundle.clone();
        } else {
            this.data = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getData() {
        if (this.data == null) {
            this.data = new Bundle();
        }
        return this.data;
    }

    public boolean isInUse() {
        return (this.flags & 1) == 1;
    }

    public void markInUse() {
        this.flags |= 1;
    }

    public Bundle peekData() {
        return this.data;
    }

    public void recycle() {
        if (!isInUse()) {
            recycleUnchecked();
        } else if (gCheckRecycle) {
            throw new IllegalStateException("This message cannot be recycled because it is still in use.");
        }
    }

    public void recycleUnchecked() {
        this.flags = 1;
        this.type = 7;
        this.token = null;
        this.times = 0;
        this.ack = false;
        this.f63188id = 0;
        this.target = null;
        this.body = null;
        this.isUiHander = false;
        this.data = null;
        this.when = 0;
        this.target = null;
        this.data = null;
        synchronized (sPoolSync) {
            int i11 = sPoolSize;
            if (i11 < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize = i11 + 1;
            }
        }
    }

    public void setData(Bundle bundle) {
        this.data = bundle;
    }

    public String toString() {
        return "Message{times=" + this.times + ", type=" + this.type + ", id=" + this.f63188id + ", ack=" + this.ack + ", target='" + this.target + '\'' + ", token='" + this.token + '\'' + ", isUiHander=" + this.isUiHander + ", body=" + Arrays.toString(this.body) + ", flags=" + this.flags + ", when=" + this.when + ", data=" + this.data + ", next=" + this.next + '}';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByte(this.type);
        parcel.writeInt(this.f63188id);
        parcel.writeBoolean(this.ack);
        parcel.writeLong(this.times);
        parcel.writeBoolean(this.isUiHander);
        String str = this.token;
        if (str == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(str.getBytes().length);
            parcel.writeString(this.token);
        }
        String str2 = this.token;
        if (str2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(str2.getBytes().length);
            parcel.writeString(this.target);
        }
        byte[] bArr = this.body;
        if (bArr != null) {
            try {
                parcel.writeInt(bArr.length);
                parcel.writeByteArray(this.body);
            } catch (ClassCastException unused) {
                throw new RuntimeException("Can't marshal non-Parcelable objects across processes.");
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLong(this.when);
        parcel.writeBundle(this.data);
    }

    public static LocalMessage obtain(LocalMessage localMessage) {
        LocalMessage obtain = obtain();
        obtain.ack = localMessage.ack;
        obtain.f63188id = localMessage.f63188id;
        obtain.token = localMessage.token;
        obtain.isUiHander = localMessage.isUiHander;
        if (localMessage.data != null) {
            obtain.data = new Bundle(localMessage.data);
        }
        obtain.target = localMessage.target;
        return obtain;
    }
}
