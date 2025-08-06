package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    public final String codecs;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    private AvcConfig(List<byte[]> list, int i11, int i12, int i13, float f11, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i11;
        this.width = i12;
        this.height = i13;
        this.pixelWidthAspectRatio = f11;
        this.codecs = str;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.getData(), position, readUnsignedShort);
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        String str;
        float f11;
        int i11;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i12 = 0; i12 < readUnsignedByte2; i12++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                for (int i13 = 0; i13 < readUnsignedByte3; i13++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                int i14 = -1;
                if (readUnsignedByte2 > 0) {
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i15 = parseSpsNalUnit.width;
                    int i16 = parseSpsNalUnit.height;
                    float f12 = parseSpsNalUnit.pixelWidthAspectRatio;
                    str = CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc);
                    i14 = i15;
                    i11 = i16;
                    f11 = f12;
                } else {
                    f11 = 1.0f;
                    str = null;
                    i11 = -1;
                }
                return new AvcConfig(arrayList, readUnsignedByte, i14, i11, f11, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw new ParserException("Error parsing AVC config", e11);
        }
    }
}
