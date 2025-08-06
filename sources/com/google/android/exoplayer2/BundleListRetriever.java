package com.google.android.exoplayer2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class BundleListRetriever extends Binder {
    private static final int REPLY_BREAK = 2;
    private static final int REPLY_CONTINUE = 1;
    private static final int REPLY_END_OF_LIST = 0;
    private static final int SUGGESTED_MAX_IPC_SIZE = (Util.SDK_INT >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536);
    private final ImmutableList<Bundle> list;

    public BundleListRetriever(List<Bundle> list2) {
        this.list = ImmutableList.copyOf(list2);
    }

    public static ImmutableList<Bundle> getList(IBinder iBinder) {
        int readInt;
        ImmutableList.Builder builder = ImmutableList.builder();
        int i11 = 0;
        int i12 = 1;
        while (i12 != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i11);
                iBinder.transact(1, obtain, obtain2, 0);
                while (true) {
                    readInt = obtain2.readInt();
                    if (readInt != 1) {
                        break;
                    }
                    builder.add((Object) (Bundle) Assertions.checkNotNull(obtain2.readBundle()));
                    i11++;
                }
                obtain2.recycle();
                obtain.recycle();
                i12 = readInt;
            } catch (RemoteException e11) {
                throw new RuntimeException(e11);
            } catch (Throwable th2) {
                obtain2.recycle();
                obtain.recycle();
                throw th2;
            }
        }
        return builder.build();
    }

    public boolean onTransact(int i11, Parcel parcel, Parcel parcel2, int i12) throws RemoteException {
        if (i11 != 1) {
            return super.onTransact(i11, parcel, parcel2, i12);
        }
        int i13 = 0;
        if (parcel2 == null) {
            return false;
        }
        int size = this.list.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < SUGGESTED_MAX_IPC_SIZE) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.list.get(readInt));
            readInt++;
        }
        if (readInt < size) {
            i13 = 2;
        }
        parcel2.writeInt(i13);
        return true;
    }
}
