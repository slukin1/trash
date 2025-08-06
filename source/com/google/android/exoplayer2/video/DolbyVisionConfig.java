package com.google.android.exoplayer2.video;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class DolbyVisionConfig {
    public final String codecs;
    public final int level;
    public final int profile;

    private DolbyVisionConfig(int i11, int i12, String str) {
        this.profile = i11;
        this.level = i12;
        this.codecs = str;
    }

    public static DolbyVisionConfig parse(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i11 = readUnsignedByte >> 1;
        int readUnsignedByte2 = ((parsableByteArray.readUnsignedByte() >> 3) & 31) | ((readUnsignedByte & 1) << 5);
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else if (i11 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        String str2 = readUnsignedByte2 < 10 ? ".0" : InstructionFileId.DOT;
        StringBuilder sb2 = new StringBuilder(str.length() + 24 + str2.length());
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(str2);
        sb2.append(readUnsignedByte2);
        return new DolbyVisionConfig(i11, readUnsignedByte2, sb2.toString());
    }
}
