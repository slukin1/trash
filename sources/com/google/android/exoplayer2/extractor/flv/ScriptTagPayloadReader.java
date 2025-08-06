package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ScriptTagPayloadReader extends TagPayloadReader {
    private static final int AMF_TYPE_BOOLEAN = 1;
    private static final int AMF_TYPE_DATE = 11;
    private static final int AMF_TYPE_ECMA_ARRAY = 8;
    private static final int AMF_TYPE_END_MARKER = 9;
    private static final int AMF_TYPE_NUMBER = 0;
    private static final int AMF_TYPE_OBJECT = 3;
    private static final int AMF_TYPE_STRICT_ARRAY = 10;
    private static final int AMF_TYPE_STRING = 2;
    private static final String KEY_DURATION = "duration";
    private static final String KEY_FILE_POSITIONS = "filepositions";
    private static final String KEY_KEY_FRAMES = "keyframes";
    private static final String KEY_TIMES = "times";
    private static final String NAME_METADATA = "onMetaData";
    private long durationUs = -9223372036854775807L;
    private long[] keyFrameTagPositions = new long[0];
    private long[] keyFrameTimesUs = new long[0];

    public ScriptTagPayloadReader() {
        super(new DummyTrackOutput());
    }

    private static Boolean readAmfBoolean(ParsableByteArray parsableByteArray) {
        boolean z11 = true;
        if (parsableByteArray.readUnsignedByte() != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    private static Object readAmfData(ParsableByteArray parsableByteArray, int i11) {
        if (i11 == 0) {
            return readAmfDouble(parsableByteArray);
        }
        if (i11 == 1) {
            return readAmfBoolean(parsableByteArray);
        }
        if (i11 == 2) {
            return readAmfString(parsableByteArray);
        }
        if (i11 == 3) {
            return readAmfObject(parsableByteArray);
        }
        if (i11 == 8) {
            return readAmfEcmaArray(parsableByteArray);
        }
        if (i11 == 10) {
            return readAmfStrictArray(parsableByteArray);
        }
        if (i11 != 11) {
            return null;
        }
        return readAmfDate(parsableByteArray);
    }

    private static Date readAmfDate(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) readAmfDouble(parsableByteArray).doubleValue());
        parsableByteArray.skipBytes(2);
        return date;
    }

    private static Double readAmfDouble(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong()));
    }

    private static HashMap<String, Object> readAmfEcmaArray(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        HashMap<String, Object> hashMap = new HashMap<>(readUnsignedIntToInt);
        for (int i11 = 0; i11 < readUnsignedIntToInt; i11++) {
            String readAmfString = readAmfString(parsableByteArray);
            Object readAmfData = readAmfData(parsableByteArray, readAmfType(parsableByteArray));
            if (readAmfData != null) {
                hashMap.put(readAmfString, readAmfData);
            }
        }
        return hashMap;
    }

    private static HashMap<String, Object> readAmfObject(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String readAmfString = readAmfString(parsableByteArray);
            int readAmfType = readAmfType(parsableByteArray);
            if (readAmfType == 9) {
                return hashMap;
            }
            Object readAmfData = readAmfData(parsableByteArray, readAmfType);
            if (readAmfData != null) {
                hashMap.put(readAmfString, readAmfData);
            }
        }
    }

    private static ArrayList<Object> readAmfStrictArray(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        ArrayList<Object> arrayList = new ArrayList<>(readUnsignedIntToInt);
        for (int i11 = 0; i11 < readUnsignedIntToInt; i11++) {
            Object readAmfData = readAmfData(parsableByteArray, readAmfType(parsableByteArray));
            if (readAmfData != null) {
                arrayList.add(readAmfData);
            }
        }
        return arrayList;
    }

    private static String readAmfString(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return new String(parsableByteArray.getData(), position, readUnsignedShort);
    }

    private static int readAmfType(ParsableByteArray parsableByteArray) {
        return parsableByteArray.readUnsignedByte();
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public long[] getKeyFrameTagPositions() {
        return this.keyFrameTagPositions;
    }

    public long[] getKeyFrameTimesUs() {
        return this.keyFrameTimesUs;
    }

    public boolean parseHeader(ParsableByteArray parsableByteArray) {
        return true;
    }

    public boolean parsePayload(ParsableByteArray parsableByteArray, long j11) {
        if (readAmfType(parsableByteArray) != 2 || !NAME_METADATA.equals(readAmfString(parsableByteArray)) || readAmfType(parsableByteArray) != 8) {
            return false;
        }
        HashMap<String, Object> readAmfEcmaArray = readAmfEcmaArray(parsableByteArray);
        Object obj = readAmfEcmaArray.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.durationUs = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = readAmfEcmaArray.get(KEY_KEY_FRAMES);
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get(KEY_FILE_POSITIONS);
            Object obj4 = map.get(KEY_TIMES);
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.keyFrameTimesUs = new long[size];
                this.keyFrameTagPositions = new long[size];
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    Object obj5 = list.get(i11);
                    Object obj6 = list2.get(i11);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.keyFrameTimesUs = new long[0];
                        this.keyFrameTagPositions = new long[0];
                    } else {
                        this.keyFrameTimesUs[i11] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.keyFrameTagPositions[i11] = ((Double) obj5).longValue();
                        i11++;
                    }
                }
                this.keyFrameTimesUs = new long[0];
                this.keyFrameTagPositions = new long[0];
            }
        }
        return false;
    }

    public void seek() {
    }
}
