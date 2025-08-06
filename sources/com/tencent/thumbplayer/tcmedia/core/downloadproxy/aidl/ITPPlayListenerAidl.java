package com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public interface ITPPlayListenerAidl extends IInterface {

    public static abstract class Stub extends Binder implements ITPPlayListenerAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPlayListenerAidl";
        public static final int TRANSACTION_getAdvRemainTime = 14;
        public static final int TRANSACTION_getContentType = 21;
        public static final int TRANSACTION_getCurrentPlayClipNo = 13;
        public static final int TRANSACTION_getCurrentPlayOffset = 12;
        public static final int TRANSACTION_getCurrentPosition = 11;
        public static final int TRANSACTION_getDataFilePath = 20;
        public static final int TRANSACTION_getDataTotalSize = 19;
        public static final int TRANSACTION_getPlayInfo = 15;
        public static final int TRANSACTION_getPlayerBufferLength = 10;
        public static final int TRANSACTION_onDownloadCdnUrlExpired = 7;
        public static final int TRANSACTION_onDownloadCdnUrlInfoUpdate = 6;
        public static final int TRANSACTION_onDownloadCdnUrlUpdate = 5;
        public static final int TRANSACTION_onDownloadError = 3;
        public static final int TRANSACTION_onDownloadFinish = 2;
        public static final int TRANSACTION_onDownloadProgressUpdate = 1;
        public static final int TRANSACTION_onDownloadProtocolUpdate = 9;
        public static final int TRANSACTION_onDownloadStatusUpdate = 8;
        public static final int TRANSACTION_onPlayCallback = 4;
        public static final int TRANSACTION_onReadData = 17;
        public static final int TRANSACTION_onStartReadData = 16;
        public static final int TRANSACTION_onStopReadData = 18;

        public static class Proxy implements ITPPlayListenerAidl {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public long getAdvRemainTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getContentType(int i11, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getCurrentPlayClipNo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getCurrentPlayOffset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getCurrentPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getDataFilePath(int i11, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getDataTotalSize(int i11, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String getPlayInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getPlayerBufferLength() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadCdnUrlExpired(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadCdnUrlUpdate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadError(int i11, int i12, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadFinish() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeLong(j11);
                    obtain.writeLong(j12);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadProtocolUpdate(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDownloadStatusUpdate(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int onPlayCallback(int i11, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeList(list);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int onReadData(int i11, String str, long j11, long j12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    obtain.writeLong(j11);
                    obtain.writeLong(j12);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int onStartReadData(int i11, String str, long j11, long j12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    obtain.writeLong(j11);
                    obtain.writeLong(j12);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int onStopReadData(int i11, String str, int i12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeString(str);
                    obtain.writeInt(i12);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPPlayListenerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITPPlayListenerAidl)) {
                return new Proxy(iBinder);
            }
            return (ITPPlayListenerAidl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1598968902) {
                switch (i11) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadFinish();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadError(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onPlayCallback = onPlayCallback(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        parcel2.writeInt(onPlayCallback);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadCdnUrlUpdate(parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadCdnUrlInfoUpdate(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadCdnUrlExpired(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadStatusUpdate(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        onDownloadProtocolUpdate(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        long playerBufferLength = getPlayerBufferLength();
                        parcel2.writeNoException();
                        parcel2.writeLong(playerBufferLength);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentPosition = getCurrentPosition();
                        parcel2.writeNoException();
                        parcel2.writeLong(currentPosition);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        long currentPlayOffset = getCurrentPlayOffset();
                        parcel2.writeNoException();
                        parcel2.writeLong(currentPlayOffset);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        int currentPlayClipNo = getCurrentPlayClipNo();
                        parcel2.writeNoException();
                        parcel2.writeInt(currentPlayClipNo);
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        long advRemainTime = getAdvRemainTime();
                        parcel2.writeNoException();
                        parcel2.writeLong(advRemainTime);
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playInfo = getPlayInfo(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(playInfo);
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onStartReadData = onStartReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(onStartReadData);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onReadData = onReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(onReadData);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        int onStopReadData = onStopReadData(parcel.readInt(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(onStopReadData);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        long dataTotalSize = getDataTotalSize(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(dataTotalSize);
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        String dataFilePath = getDataFilePath(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(dataFilePath);
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        String contentType = getContentType(parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeString(contentType);
                        return true;
                    default:
                        return super.onTransact(i11, parcel, parcel2, i12);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    long getAdvRemainTime() throws RemoteException;

    String getContentType(int i11, String str) throws RemoteException;

    int getCurrentPlayClipNo() throws RemoteException;

    long getCurrentPlayOffset() throws RemoteException;

    long getCurrentPosition() throws RemoteException;

    String getDataFilePath(int i11, String str) throws RemoteException;

    long getDataTotalSize(int i11, String str) throws RemoteException;

    String getPlayInfo(String str) throws RemoteException;

    long getPlayerBufferLength() throws RemoteException;

    void onDownloadCdnUrlExpired(Map map) throws RemoteException;

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException;

    void onDownloadCdnUrlUpdate(String str) throws RemoteException;

    void onDownloadError(int i11, int i12, String str) throws RemoteException;

    void onDownloadFinish() throws RemoteException;

    void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) throws RemoteException;

    void onDownloadProtocolUpdate(String str, String str2) throws RemoteException;

    void onDownloadStatusUpdate(int i11) throws RemoteException;

    int onPlayCallback(int i11, List list) throws RemoteException;

    int onReadData(int i11, String str, long j11, long j12) throws RemoteException;

    int onStartReadData(int i11, String str, long j11, long j12) throws RemoteException;

    int onStopReadData(int i11, String str, int i12) throws RemoteException;
}
