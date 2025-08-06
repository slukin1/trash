package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    public final String codecs;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    private HevcConfig(List<byte[]> list, int i11, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i11;
        this.codecs = str;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        List list;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        try {
            parsableByteArray2.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i11 = 0;
            for (int i12 = 0; i12 < readUnsignedByte2; i12++) {
                parsableByteArray2.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i13 = 0; i13 < readUnsignedShort; i13++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i11 += readUnsignedShort2 + 4;
                    parsableByteArray2.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray2.setPosition(position);
            byte[] bArr = new byte[i11];
            int i14 = 0;
            String str = null;
            for (int i15 = 0; i15 < readUnsignedByte2; i15++) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 127;
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                for (int i16 = 0; i16 < readUnsignedShort3; i16++) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    System.arraycopy(bArr2, 0, bArr, i14, bArr2.length);
                    int length = i14 + bArr2.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    if (readUnsignedByte3 == 33 && i16 == 0) {
                        str = CodecSpecificDataUtil.buildHevcCodecStringFromSps(new ParsableNalUnitBitArray(bArr, length, length + readUnsignedShort4));
                    }
                    i14 = length + readUnsignedShort4;
                    parsableByteArray2.skipBytes(readUnsignedShort4);
                }
            }
            if (i11 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new HevcConfig(list, readUnsignedByte + 1, str);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw new ParserException("Error parsing HEVC config", e11);
        }
    }
}
