package com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import java.util.Map;

public interface ITPDownloadProxyAidl extends IInterface {

    public static abstract class Stub extends Binder implements ITPDownloadProxyAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPDownloadProxyAidl";
        public static final int TRANSACTION_checkResourceExist = 25;
        public static final int TRANSACTION_checkResourceStatus = 17;
        public static final int TRANSACTION_clearCache = 24;
        public static final int TRANSACTION_deleteOfflineLicenseKeySetId = 28;
        public static final int TRANSACTION_getClipPlayUrl = 6;
        public static final int TRANSACTION_getNativeInfo = 16;
        public static final int TRANSACTION_getOfflineLicenseKeySetId = 27;
        public static final int TRANSACTION_getPlayErrorCodeStr = 7;
        public static final int TRANSACTION_getPlayUrl = 5;
        public static final int TRANSACTION_getResourceDownloadProgress = 26;
        public static final int TRANSACTION_getResourceSize = 18;
        public static final int TRANSACTION_init = 1;
        public static final int TRANSACTION_pauseDownload = 9;
        public static final int TRANSACTION_pushEvent = 19;
        public static final int TRANSACTION_removeStorageCache = 23;
        public static final int TRANSACTION_resumeDownload = 10;
        public static final int TRANSACTION_setClipInfo = 4;
        public static final int TRANSACTION_setMaxStorageSizeMB = 21;
        public static final int TRANSACTION_setPlayState = 20;
        public static final int TRANSACTION_setUserData = 15;
        public static final int TRANSACTION_startClipPlay = 3;
        public static final int TRANSACTION_startClipPreload = 12;
        public static final int TRANSACTION_startPlay = 2;
        public static final int TRANSACTION_startPreload = 11;
        public static final int TRANSACTION_startTask = 14;
        public static final int TRANSACTION_stopPlay = 8;
        public static final int TRANSACTION_stopPreload = 13;
        public static final int TRANSACTION_updateTaskInfo = 22;

        public static class Proxy implements ITPDownloadProxyAidl {
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public boolean checkResourceExist(String str, String str2, long j11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j11);
                    boolean z11 = false;
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z11 = true;
                    }
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int checkResourceStatus(String str, String str2, int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i11);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int clearCache(String str, String str2, int i11, long j11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i11);
                    obtain.writeLong(j11);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int deleteOfflineLicenseKeySetId(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getClipPlayUrl(int i11, int i12, int i13) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeInt(i13);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public String getNativeInfo(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte[] getOfflineLicenseKeySetId(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createByteArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPlayErrorCodeStr(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getPlayUrl(int i11, int i12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public float getResourceDownloadProgress(String str, String str2, long j11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeLong(j11);
                    this.mRemote.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getResourceSize(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int init(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int pauseDownload(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pushEvent(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int removeStorageCache(String str, long j11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeLong(j11);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int resumeDownload(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setClipInfo(int i11, int i12, String str, TPDownloadParamAidl tPDownloadParamAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    obtain.writeString(str);
                    boolean z11 = true;
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z11 = false;
                    }
                    return z11;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMaxStorageSizeMB(long j11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j11);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPlayState(int i11, int i12) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeInt(i12);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setUserData(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startClipPlay(String str, int i11, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    obtain.writeStrongBinder(iTPPlayListenerAidl != null ? iTPPlayListenerAidl.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startClipPreload(String str, int i11, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i11);
                    obtain.writeStrongBinder(iTPPreLoadListenerAidl != null ? iTPPreLoadListenerAidl.asBinder() : null);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTPPlayListenerAidl != null ? iTPPlayListenerAidl.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (tPDownloadParamAidl != null) {
                        obtain.writeInt(1);
                        tPDownloadParamAidl.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTPPreLoadListenerAidl != null ? iTPPreLoadListenerAidl.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startTask(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopPlay(int i11) throws RemoteException {
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

            public void stopPreload(int i11) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateTaskInfo(int i11, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i11);
                    obtain.writeMap(map);
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPDownloadProxyAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITPDownloadProxyAidl)) {
                return new Proxy(iBinder);
            }
            return (ITPDownloadProxyAidl) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
            if (i11 != 1598968902) {
                TPDownloadParamAidl tPDownloadParamAidl = null;
                switch (i11) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int init = init(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(init);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                        }
                        int startPlay = startPlay(readString, tPDownloadParamAidl, ITPPlayListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startPlay);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startClipPlay = startClipPlay(parcel.readString(), parcel.readInt(), ITPPlayListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startClipPlay);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                        }
                        boolean clipInfo = setClipInfo(readInt, readInt2, readString2, tPDownloadParamAidl);
                        parcel2.writeNoException();
                        parcel2.writeInt(clipInfo ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playUrl = getPlayUrl(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(playUrl);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        String clipPlayUrl = getClipPlayUrl(parcel.readInt(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(clipPlayUrl);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        String playErrorCodeStr = getPlayErrorCodeStr(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(playErrorCodeStr);
                        return true;
                    case 8:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopPlay(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 9:
                        parcel.enforceInterface(DESCRIPTOR);
                        int pauseDownload = pauseDownload(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(pauseDownload);
                        return true;
                    case 10:
                        parcel.enforceInterface(DESCRIPTOR);
                        int resumeDownload = resumeDownload(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(resumeDownload);
                        return true;
                    case 11:
                        parcel.enforceInterface(DESCRIPTOR);
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            tPDownloadParamAidl = TPDownloadParamAidl.CREATOR.createFromParcel(parcel);
                        }
                        int startPreload = startPreload(readString3, tPDownloadParamAidl, ITPPreLoadListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startPreload);
                        return true;
                    case 12:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startClipPreload = startClipPreload(parcel.readString(), parcel.readInt(), ITPPreLoadListenerAidl.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startClipPreload);
                        return true;
                    case 13:
                        parcel.enforceInterface(DESCRIPTOR);
                        stopPreload(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface(DESCRIPTOR);
                        startTask(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface(DESCRIPTOR);
                        setUserData(parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface(DESCRIPTOR);
                        String nativeInfo = getNativeInfo(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeString(nativeInfo);
                        return true;
                    case 17:
                        parcel.enforceInterface(DESCRIPTOR);
                        int checkResourceStatus = checkResourceStatus(parcel.readString(), parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(checkResourceStatus);
                        return true;
                    case 18:
                        parcel.enforceInterface(DESCRIPTOR);
                        long resourceSize = getResourceSize(parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeLong(resourceSize);
                        return true;
                    case 19:
                        parcel.enforceInterface(DESCRIPTOR);
                        pushEvent(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface(DESCRIPTOR);
                        setPlayState(parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface(DESCRIPTOR);
                        setMaxStorageSizeMB(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface(DESCRIPTOR);
                        updateTaskInfo(parcel.readInt(), parcel.readHashMap(getClass().getClassLoader()));
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface(DESCRIPTOR);
                        int removeStorageCache = removeStorageCache(parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(removeStorageCache);
                        return true;
                    case 24:
                        parcel.enforceInterface(DESCRIPTOR);
                        int clearCache = clearCache(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearCache);
                        return true;
                    case 25:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean checkResourceExist = checkResourceExist(parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeInt(checkResourceExist ? 1 : 0);
                        return true;
                    case 26:
                        parcel.enforceInterface(DESCRIPTOR);
                        float resourceDownloadProgress = getResourceDownloadProgress(parcel.readString(), parcel.readString(), parcel.readLong());
                        parcel2.writeNoException();
                        parcel2.writeFloat(resourceDownloadProgress);
                        return true;
                    case 27:
                        parcel.enforceInterface(DESCRIPTOR);
                        byte[] offlineLicenseKeySetId = getOfflineLicenseKeySetId(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeByteArray(offlineLicenseKeySetId);
                        return true;
                    case 28:
                        parcel.enforceInterface(DESCRIPTOR);
                        int deleteOfflineLicenseKeySetId = deleteOfflineLicenseKeySetId(parcel.readString(), parcel.readString(), parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(deleteOfflineLicenseKeySetId);
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

    boolean checkResourceExist(String str, String str2, long j11) throws RemoteException;

    int checkResourceStatus(String str, String str2, int i11) throws RemoteException;

    int clearCache(String str, String str2, int i11, long j11) throws RemoteException;

    int deleteOfflineLicenseKeySetId(String str, String str2, String str3) throws RemoteException;

    String getClipPlayUrl(int i11, int i12, int i13) throws RemoteException;

    String getNativeInfo(int i11) throws RemoteException;

    byte[] getOfflineLicenseKeySetId(String str, String str2, String str3) throws RemoteException;

    String getPlayErrorCodeStr(int i11) throws RemoteException;

    String getPlayUrl(int i11, int i12) throws RemoteException;

    float getResourceDownloadProgress(String str, String str2, long j11) throws RemoteException;

    long getResourceSize(String str, String str2) throws RemoteException;

    int init(String str) throws RemoteException;

    int pauseDownload(int i11) throws RemoteException;

    void pushEvent(int i11) throws RemoteException;

    int removeStorageCache(String str, long j11) throws RemoteException;

    int resumeDownload(int i11) throws RemoteException;

    boolean setClipInfo(int i11, int i12, String str, TPDownloadParamAidl tPDownloadParamAidl) throws RemoteException;

    void setMaxStorageSizeMB(long j11) throws RemoteException;

    void setPlayState(int i11, int i12) throws RemoteException;

    void setUserData(Map map) throws RemoteException;

    int startClipPlay(String str, int i11, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException;

    int startClipPreload(String str, int i11, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException;

    int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPlayListenerAidl iTPPlayListenerAidl) throws RemoteException;

    int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, ITPPreLoadListenerAidl iTPPreLoadListenerAidl) throws RemoteException;

    void startTask(int i11) throws RemoteException;

    void stopPlay(int i11) throws RemoteException;

    void stopPreload(int i11) throws RemoteException;

    void updateTaskInfo(int i11, Map map) throws RemoteException;
}
