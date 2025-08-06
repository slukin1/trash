package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        public PrivateCommand[] newArray(int i11) {
            return new PrivateCommand[i11];
        }
    };
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    public static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray, int i11, long j11) {
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        int i12 = i11 - 4;
        byte[] bArr = new byte[i12];
        parsableByteArray.readBytes(bArr, 0, i12);
        return new PrivateCommand(readUnsignedInt, bArr, j11);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeByteArray(this.commandBytes);
    }

    private PrivateCommand(long j11, byte[] bArr, long j12) {
        this.ptsAdjustment = j12;
        this.identifier = j11;
        this.commandBytes = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        this.commandBytes = (byte[]) Util.castNonNull(parcel.createByteArray());
    }
}
