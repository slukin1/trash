package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        public SpliceInsertCommand[] newArray(int i11) {
            return new SpliceInsertCommand[i11];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.componentSplicePts);
            parcel.writeLong(this.componentSplicePlaybackPositionUs);
        }

        private ComponentSplice(int i11, long j11, long j12) {
            this.componentTag = i11;
            this.componentSplicePts = j11;
            this.componentSplicePlaybackPositionUs = j12;
        }
    }

    public static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j11, TimestampAdjuster timestampAdjuster) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        long j12;
        boolean z12;
        List list;
        long j13;
        boolean z13;
        boolean z14;
        long j14;
        boolean z15;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        boolean z16 = (parsableByteArray.readUnsignedByte() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (!z16) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            boolean z17 = (readUnsignedByte & 128) != 0;
            boolean z18 = (readUnsignedByte & 64) != 0;
            boolean z19 = (readUnsignedByte & 32) != 0;
            boolean z21 = (readUnsignedByte & 16) != 0;
            long parseSpliceTime = (!z18 || z21) ? -9223372036854775807L : TimeSignalCommand.parseSpliceTime(parsableByteArray, j11);
            if (!z18) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                ArrayList arrayList = new ArrayList(readUnsignedByte2);
                for (int i14 = 0; i14 < readUnsignedByte2; i14++) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    long parseSpliceTime2 = !z21 ? TimeSignalCommand.parseSpliceTime(parsableByteArray, j11) : -9223372036854775807L;
                    arrayList.add(new ComponentSplice(readUnsignedByte3, parseSpliceTime2, timestampAdjuster2.adjustTsTimestamp(parseSpliceTime2)));
                }
                emptyList = arrayList;
            }
            if (z19) {
                long readUnsignedByte4 = (long) parsableByteArray.readUnsignedByte();
                boolean z22 = (128 & readUnsignedByte4) != 0;
                j14 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                z15 = z22;
            } else {
                z15 = false;
                j14 = -9223372036854775807L;
            }
            i13 = parsableByteArray.readUnsignedShort();
            z11 = z18;
            i12 = parsableByteArray.readUnsignedByte();
            i11 = parsableByteArray.readUnsignedByte();
            list = emptyList;
            long j15 = parseSpliceTime;
            z12 = z15;
            j12 = j14;
            z13 = z21;
            z14 = z17;
            j13 = j15;
        } else {
            list = emptyList;
            z14 = false;
            z13 = false;
            j13 = -9223372036854775807L;
            z12 = false;
            j12 = -9223372036854775807L;
            i13 = 0;
            i12 = 0;
            i11 = 0;
            z11 = false;
        }
        return new SpliceInsertCommand(readUnsignedInt, z16, z14, z11, z13, j13, timestampAdjuster2.adjustTsTimestamp(j13), list, z12, j12, i13, i12, i11);
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.componentSpliceList.get(i12).writeToParcel(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }

    private SpliceInsertCommand(long j11, boolean z11, boolean z12, boolean z13, boolean z14, long j12, long j13, List<ComponentSplice> list, boolean z15, long j14, int i11, int i12, int i13) {
        this.spliceEventId = j11;
        this.spliceEventCancelIndicator = z11;
        this.outOfNetworkIndicator = z12;
        this.programSpliceFlag = z13;
        this.spliceImmediateFlag = z14;
        this.programSplicePts = j12;
        this.programSplicePlaybackPositionUs = j13;
        this.componentSpliceList = Collections.unmodifiableList(list);
        this.autoReturn = z15;
        this.breakDurationUs = j14;
        this.uniqueProgramId = i11;
        this.availNum = i12;
        this.availsExpected = i13;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        boolean z11 = false;
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add(ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = Collections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1 ? true : z11;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }
}
