package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class MatroskaExtractor implements Extractor {
    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_ADD_ID_TYPE_DVCC = 1685480259;
    private static final int BLOCK_ADD_ID_TYPE_DVVC = 1685485123;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_FLOAT = "A_PCM/FLOAT/IEEE";
    private static final String CODEC_ID_PCM_INT_BIG = "A_PCM/INT/BIG";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY = a.f65893a;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 859189832;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_ADDITIONAL = 165;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADDITION_MAPPING = 16868;
    private static final int ID_BLOCK_ADD_ID = 238;
    private static final int ID_BLOCK_ADD_ID_EXTRA_DATA = 16877;
    private static final int ID_BLOCK_ADD_ID_TYPE = 16871;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_BLOCK_MORE = 166;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 21998;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_NAME = 21358;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    /* access modifiers changed from: private */
    public static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {ISO7816.INS_REHABILITATE_CHV, 105, 97, 108, ISOFileInfo.FCI_BYTE, 103, 117, 101, 58, 32, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, ISO7816.INS_UNBLOCK_CHV, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, ISO7816.INS_UNBLOCK_CHV};
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final byte[] SUBRIP_PREFIX = {Framer.STDOUT_FRAME_PREFIX, 10, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, ISO7816.INS_UNBLOCK_CHV, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 58, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, ISO7816.INS_UNBLOCK_CHV, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, ISO7816.INS_DECREASE, 10};
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    /* access modifiers changed from: private */
    public static final Map<String, Integer> TRACK_NAME_TO_ROTATION_DEGREES;
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    /* access modifiers changed from: private */
    public static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
    private final ParsableByteArray blockAdditionalData;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public void binaryElement(int i11, int i12, ExtractorInput extractorInput) throws IOException {
            MatroskaExtractor.this.binaryElement(i11, i12, extractorInput);
        }

        public void endMasterElement(int i11) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i11);
        }

        public void floatElement(int i11, double d11) throws ParserException {
            MatroskaExtractor.this.floatElement(i11, d11);
        }

        public int getElementType(int i11) {
            return MatroskaExtractor.this.getElementType(i11);
        }

        public void integerElement(int i11, long j11) throws ParserException {
            MatroskaExtractor.this.integerElement(i11, j11);
        }

        public boolean isLevel1Element(int i11) {
            return MatroskaExtractor.this.isLevel1Element(i11);
        }

        public void startMasterElement(int i11, long j11, long j12) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i11, j11, j12);
        }

        public void stringElement(int i11, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i11, str);
        }
    }

    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        /* access modifiers changed from: private */
        public int blockAddIdType;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public byte[] dolbyVisionConfigBytes;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        /* access modifiers changed from: private */
        public String language;
        public int maxBlockAdditionId;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionType = -1;
            this.projectionPoseYaw = 0.0f;
            this.projectionPosePitch = 0.0f;
            this.projectionPoseRoll = 0.0f;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0;
            this.seekPreRollNs = 0;
            this.flagDefault = true;
            this.language = "eng";
        }

        /* access modifiers changed from: private */
        @EnsuresNonNull({"output"})
        public void assertOutputInitialized() {
            Assertions.checkNotNull(this.output);
        }

        @EnsuresNonNull({"codecPrivate"})
        private byte[] getCodecPrivate(String str) throws ParserException {
            byte[] bArr = this.codecPrivate;
            if (bArr != null) {
                return bArr;
            }
            String valueOf = String.valueOf(str);
            throw new ParserException(valueOf.length() != 0 ? "Missing CodecPrivate for codec ".concat(valueOf) : new String("Missing CodecPrivate for codec "));
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX == -1.0f || this.primaryRChromaticityY == -1.0f || this.primaryGChromaticityX == -1.0f || this.primaryGChromaticityY == -1.0f || this.primaryBChromaticityX == -1.0f || this.primaryBChromaticityY == -1.0f || this.whitePointChromaticityX == -1.0f || this.whitePointChromaticityY == -1.0f || this.maxMasteringLuminance == -1.0f || this.minMasteringLuminance == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.primaryRChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryRChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryGChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryGChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryBChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.primaryBChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.whitePointChromaticityX * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.whitePointChromaticityY * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.maxMasteringLuminance + 0.5f)));
            order.putShort((short) ((int) (this.minMasteringLuminance + 0.5f)));
            order.putShort((short) this.maxContentLuminance);
            order.putShort((short) this.maxFrameAverageLuminance);
            return bArr;
        }

        private static Pair<String, List<byte[]>> parseFourCcPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                long readLittleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
                if (readLittleEndianUnsignedInt == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_DIVX, (Object) null);
                }
                if (readLittleEndianUnsignedInt == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, (Object) null);
                }
                if (readLittleEndianUnsignedInt == 826496599) {
                    byte[] data = parsableByteArray.getData();
                    for (int position = parsableByteArray.getPosition() + 20; position < data.length - 4; position++) {
                        if (data[position] == 0 && data[position + 1] == 0 && data[position + 2] == 1 && data[position + 3] == 15) {
                            return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(data, position, data.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                Log.w(MatroskaExtractor.TAG, "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>(MimeTypes.VIDEO_UNKNOWN, (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() && parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                    return true;
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            try {
                if (bArr[0] == 2) {
                    int i11 = 0;
                    int i12 = 1;
                    while ((bArr[i12] & 255) == 255) {
                        i11 += 255;
                        i12++;
                    }
                    int i13 = i12 + 1;
                    int i14 = i11 + (bArr[i12] & 255);
                    int i15 = 0;
                    while ((bArr[i13] & 255) == 255) {
                        i15 += 255;
                        i13++;
                    }
                    int i16 = i13 + 1;
                    int i17 = i15 + (bArr[i13] & 255);
                    if (bArr[i16] == 1) {
                        byte[] bArr2 = new byte[i14];
                        System.arraycopy(bArr, i16, bArr2, 0, i14);
                        int i18 = i16 + i14;
                        if (bArr[i18] == 3) {
                            int i19 = i18 + i17;
                            if (bArr[i19] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i19)];
                                System.arraycopy(bArr, i19, bArr3, 0, bArr.length - i19);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x029f, code lost:
            r16 = com.google.android.exoplayer2.util.MimeTypes.AUDIO_UNKNOWN;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x02a3, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x0319, code lost:
            r1 = null;
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x031c, code lost:
            r7 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x031d, code lost:
            r15 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x037f, code lost:
            r7 = -1;
            r15 = -1;
            r19 = r3;
            r3 = r1;
            r1 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x03b7, code lost:
            r3 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:144:0x03c4, code lost:
            r1 = null;
            r3 = null;
            r7 = -1;
            r15 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x03dc, code lost:
            r3 = null;
            r7 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0457, code lost:
            r4 = r0.dolbyVisionConfigBytes;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x0459, code lost:
            if (r4 == null) goto L_0x046b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x045b, code lost:
            r4 = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(new com.google.android.exoplayer2.util.ParsableByteArray(r4));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x0464, code lost:
            if (r4 == null) goto L_0x046b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x0466, code lost:
            r3 = r4.codecs;
            r16 = "video/dolby-vision";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x046b, code lost:
            r4 = r16;
            r5 = r0.flagDefault | 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x0472, code lost:
            if (r0.flagForced == false) goto L_0x0476;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x0474, code lost:
            r6 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0476, code lost:
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x0477, code lost:
            r5 = r5 | r6;
            r6 = new com.google.android.exoplayer2.Format.Builder();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:173:0x0481, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.isAudio(r4) == false) goto L_0x0495;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x0483, code lost:
            r6.setChannelCount(r0.channelCount).setSampleRate(r0.sampleRate).setPcmEncoding(r7);
            r8 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0499, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.isVideo(r4) == false) goto L_0x0571;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x049d, code lost:
            if (r0.displayUnit != 0) goto L_0x04b1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x049f, code lost:
            r2 = r0.displayWidth;
            r7 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:180:0x04a2, code lost:
            if (r2 != -1) goto L_0x04a6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x04a4, code lost:
            r2 = r0.width;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x04a6, code lost:
            r0.displayWidth = r2;
            r2 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:183:0x04aa, code lost:
            if (r2 != -1) goto L_0x04ae;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x04ac, code lost:
            r2 = r0.height;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x04ae, code lost:
            r0.displayHeight = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:186:0x04b1, code lost:
            r7 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x04b2, code lost:
            r2 = -1.0f;
            r8 = r0.displayWidth;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x04b6, code lost:
            if (r8 == r7) goto L_0x04c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x04b8, code lost:
            r10 = r0.displayHeight;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:190:0x04ba, code lost:
            if (r10 == r7) goto L_0x04c5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x04bc, code lost:
            r2 = ((float) (r0.height * r8)) / ((float) (r0.width * r10));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x04c7, code lost:
            if (r0.hasColorInfo == false) goto L_0x04d9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:194:0x04c9, code lost:
            r10 = new com.google.android.exoplayer2.video.ColorInfo(r0.colorSpace, r0.colorRange, r0.colorTransfer, getHdrStaticInfo());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x04d9, code lost:
            r10 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x04dd, code lost:
            if (r0.name == null) goto L_0x04fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:199:0x04e9, code lost:
            if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.access$600().containsKey(r0.name) == false) goto L_0x04fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x04eb, code lost:
            r7 = ((java.lang.Integer) com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.access$600().get(r0.name)).intValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:202:0x04fd, code lost:
            if (r0.projectionType != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:204:0x0506, code lost:
            if (java.lang.Float.compare(r0.projectionPoseYaw, 0.0f) != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:206:0x050e, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, 0.0f) != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x0516, code lost:
            if (java.lang.Float.compare(r0.projectionPoseRoll, 0.0f) != 0) goto L_0x0519;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x0521, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, 90.0f) != 0) goto L_0x0526;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x0523, code lost:
            r9 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x052e, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, -180.0f) == 0) goto L_0x0548;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x0538, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, 180.0f) != 0) goto L_0x053b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x0543, code lost:
            if (java.lang.Float.compare(r0.projectionPosePitch, -90.0f) != 0) goto L_0x054b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x0545, code lost:
            r9 = 270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:219:0x0548, code lost:
            r9 = 180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x054b, code lost:
            r9 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:221:0x054c, code lost:
            r6.setWidth(r0.width).setHeight(r0.height).setPixelWidthHeightRatio(r2).setRotationDegrees(r9).setProjectionData(r0.projectionData).setStereoMode(r0.stereoMode).setColorInfo(r10);
            r8 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:223:0x0575, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_SUBRIP.equals(r4) != false) goto L_0x059a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:225:0x057b, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.TEXT_SSA.equals(r4) != false) goto L_0x059a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x0581, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_VOBSUB.equals(r4) != false) goto L_0x059a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x0589, code lost:
            if (r18.equals(r4) != false) goto L_0x059a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:231:0x058f, code lost:
            if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_DVBSUBS.equals(r4) == false) goto L_0x0592;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:233:0x0599, code lost:
            throw new com.google.android.exoplayer2.ParserException("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x059c, code lost:
            if (r0.name == null) goto L_0x05af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:237:0x05a8, code lost:
            if (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.access$600().containsKey(r0.name) != false) goto L_0x05af;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:238:0x05aa, code lost:
            r6.setLabel(r0.name);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:239:0x05af, code lost:
            r1 = r6.setId(r22).setSampleMimeType(r4).setMaxInputSize(r15).setLanguage(r0.language).setSelectionFlags(r5).setInitializationData(r1).setCodecs(r3).setDrmInitData(r0.drmInitData).build();
            r2 = r21.track(r0.number, r8);
            r0.output = r2;
            r2.format(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:240:0x05e6, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.checkerframework.checker.nullness.qual.RequiresNonNull({"codecId"})
        @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"this.output"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput r21, int r22) throws com.google.android.exoplayer2.ParserException {
            /*
                r20 = this;
                r0 = r20
                java.lang.String r1 = r0.codecId
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 16
                r6 = 8
                r7 = 4
                r8 = 3
                r9 = 0
                switch(r2) {
                    case -2095576542: goto L_0x01b1;
                    case -2095575984: goto L_0x01a5;
                    case -1985379776: goto L_0x0199;
                    case -1784763192: goto L_0x018d;
                    case -1730367663: goto L_0x0181;
                    case -1482641358: goto L_0x0175;
                    case -1482641357: goto L_0x0169;
                    case -1373388978: goto L_0x015d;
                    case -933872740: goto L_0x0150;
                    case -538363189: goto L_0x0142;
                    case -538363109: goto L_0x0134;
                    case -425012669: goto L_0x0126;
                    case -356037306: goto L_0x0118;
                    case 62923557: goto L_0x010a;
                    case 62923603: goto L_0x00fc;
                    case 62927045: goto L_0x00ee;
                    case 82318131: goto L_0x00e1;
                    case 82338133: goto L_0x00d3;
                    case 82338134: goto L_0x00c5;
                    case 99146302: goto L_0x00b7;
                    case 444813526: goto L_0x00a9;
                    case 542569478: goto L_0x009b;
                    case 635596514: goto L_0x008d;
                    case 725948237: goto L_0x0080;
                    case 725957860: goto L_0x0073;
                    case 738597099: goto L_0x0066;
                    case 855502857: goto L_0x0059;
                    case 1422270023: goto L_0x004c;
                    case 1809237540: goto L_0x003f;
                    case 1950749482: goto L_0x0032;
                    case 1950789798: goto L_0x0025;
                    case 1951062397: goto L_0x0018;
                    default: goto L_0x0015;
                }
            L_0x0015:
                r1 = -1
                goto L_0x01bc
            L_0x0018:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0021
                goto L_0x0015
            L_0x0021:
                r1 = 31
                goto L_0x01bc
            L_0x0025:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002e
                goto L_0x0015
            L_0x002e:
                r1 = 30
                goto L_0x01bc
            L_0x0032:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x003b
                goto L_0x0015
            L_0x003b:
                r1 = 29
                goto L_0x01bc
            L_0x003f:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0048
                goto L_0x0015
            L_0x0048:
                r1 = 28
                goto L_0x01bc
            L_0x004c:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0055
                goto L_0x0015
            L_0x0055:
                r1 = 27
                goto L_0x01bc
            L_0x0059:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0062
                goto L_0x0015
            L_0x0062:
                r1 = 26
                goto L_0x01bc
            L_0x0066:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x006f
                goto L_0x0015
            L_0x006f:
                r1 = 25
                goto L_0x01bc
            L_0x0073:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x007c
                goto L_0x0015
            L_0x007c:
                r1 = 24
                goto L_0x01bc
            L_0x0080:
                java.lang.String r2 = "A_PCM/INT/BIG"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0089
                goto L_0x0015
            L_0x0089:
                r1 = 23
                goto L_0x01bc
            L_0x008d:
                java.lang.String r2 = "A_PCM/FLOAT/IEEE"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0097
                goto L_0x0015
            L_0x0097:
                r1 = 22
                goto L_0x01bc
            L_0x009b:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a5
                goto L_0x0015
            L_0x00a5:
                r1 = 21
                goto L_0x01bc
            L_0x00a9:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b3
                goto L_0x0015
            L_0x00b3:
                r1 = 20
                goto L_0x01bc
            L_0x00b7:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00c1
                goto L_0x0015
            L_0x00c1:
                r1 = 19
                goto L_0x01bc
            L_0x00c5:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00cf
                goto L_0x0015
            L_0x00cf:
                r1 = 18
                goto L_0x01bc
            L_0x00d3:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00dd
                goto L_0x0015
            L_0x00dd:
                r1 = 17
                goto L_0x01bc
            L_0x00e1:
                java.lang.String r2 = "V_AV1"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00eb
                goto L_0x0015
            L_0x00eb:
                r1 = r3
                goto L_0x01bc
            L_0x00ee:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00f8
                goto L_0x0015
            L_0x00f8:
                r1 = 15
                goto L_0x01bc
            L_0x00fc:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0106
                goto L_0x0015
            L_0x0106:
                r1 = 14
                goto L_0x01bc
            L_0x010a:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0114
                goto L_0x0015
            L_0x0114:
                r1 = 13
                goto L_0x01bc
            L_0x0118:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0122
                goto L_0x0015
            L_0x0122:
                r1 = 12
                goto L_0x01bc
            L_0x0126:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0130
                goto L_0x0015
            L_0x0130:
                r1 = 11
                goto L_0x01bc
            L_0x0134:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x013e
                goto L_0x0015
            L_0x013e:
                r1 = 10
                goto L_0x01bc
            L_0x0142:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x014c
                goto L_0x0015
            L_0x014c:
                r1 = 9
                goto L_0x01bc
            L_0x0150:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x015a
                goto L_0x0015
            L_0x015a:
                r1 = r6
                goto L_0x01bc
            L_0x015d:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0167
                goto L_0x0015
            L_0x0167:
                r1 = 7
                goto L_0x01bc
            L_0x0169:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0173
                goto L_0x0015
            L_0x0173:
                r1 = 6
                goto L_0x01bc
            L_0x0175:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x017f
                goto L_0x0015
            L_0x017f:
                r1 = 5
                goto L_0x01bc
            L_0x0181:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x018b
                goto L_0x0015
            L_0x018b:
                r1 = r7
                goto L_0x01bc
            L_0x018d:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0197
                goto L_0x0015
            L_0x0197:
                r1 = r8
                goto L_0x01bc
            L_0x0199:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01a3
                goto L_0x0015
            L_0x01a3:
                r1 = 2
                goto L_0x01bc
            L_0x01a5:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01af
                goto L_0x0015
            L_0x01af:
                r1 = 1
                goto L_0x01bc
            L_0x01b1:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01bb
                goto L_0x0015
            L_0x01bb:
                r1 = r9
            L_0x01bc:
                java.lang.String r2 = "application/dvbsubs"
                java.lang.String r11 = "application/pgs"
                java.lang.String r12 = "application/vobsub"
                java.lang.String r13 = "text/x-ssa"
                java.lang.String r14 = "application/x-subrip"
                java.lang.String r4 = ". Setting mimeType to "
                java.lang.String r16 = "audio/raw"
                r17 = 0
                java.lang.String r5 = "MatroskaExtractor"
                java.lang.String r15 = "audio/x-unknown"
                switch(r1) {
                    case 0: goto L_0x0445;
                    case 1: goto L_0x0445;
                    case 2: goto L_0x03ee;
                    case 3: goto L_0x03e1;
                    case 4: goto L_0x03cc;
                    case 5: goto L_0x03c0;
                    case 6: goto L_0x03bb;
                    case 7: goto L_0x039c;
                    case 8: goto L_0x0388;
                    case 9: goto L_0x0445;
                    case 10: goto L_0x0363;
                    case 11: goto L_0x0354;
                    case 12: goto L_0x034f;
                    case 13: goto L_0x0330;
                    case 14: goto L_0x032b;
                    case 15: goto L_0x0326;
                    case 16: goto L_0x0320;
                    case 17: goto L_0x0314;
                    case 18: goto L_0x030e;
                    case 19: goto L_0x0306;
                    case 20: goto L_0x0300;
                    case 21: goto L_0x0326;
                    case 22: goto L_0x02d6;
                    case 23: goto L_0x02a8;
                    case 24: goto L_0x0273;
                    case 25: goto L_0x025f;
                    case 26: goto L_0x0241;
                    case 27: goto L_0x023b;
                    case 28: goto L_0x0234;
                    case 29: goto L_0x022e;
                    case 30: goto L_0x021e;
                    case 31: goto L_0x01dc;
                    default: goto L_0x01d4;
                }
            L_0x01d4:
                com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01dc:
                r15 = 5760(0x1680, float:8.071E-42)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r8)
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r6)
                java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r3 = r3.order(r4)
                r18 = r11
                long r10 = r0.codecDelayNs
                java.nio.ByteBuffer r3 = r3.putLong(r10)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r6)
                java.nio.ByteBuffer r3 = r3.order(r4)
                long r4 = r0.seekPreRollNs
                java.nio.ByteBuffer r3 = r3.putLong(r4)
                byte[] r3 = r3.array()
                r1.add(r3)
                java.lang.String r16 = "audio/opus"
                goto L_0x03dc
            L_0x021e:
                r18 = r11
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r16 = "audio/flac"
                goto L_0x03b7
            L_0x022e:
                r18 = r11
                java.lang.String r16 = "audio/eac3"
                goto L_0x0319
            L_0x0234:
                r18 = r11
                java.lang.String r16 = "video/mpeg2"
                goto L_0x0319
            L_0x023b:
                r18 = r11
                r16 = r14
                goto L_0x0319
            L_0x0241:
                r18 = r11
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.HevcConfig r1 = com.google.android.exoplayer2.video.HevcConfig.parse(r1)
                java.util.List<byte[]> r3 = r1.initializationData
                int r4 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r4
                java.lang.String r1 = r1.codecs
                java.lang.String r16 = "video/hevc"
                goto L_0x037f
            L_0x025f:
                r18 = r11
                byte[] r1 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.SSA_DIALOGUE_FORMAT
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1, r3)
                r16 = r13
                goto L_0x03b7
            L_0x0273:
                r18 = r11
                int r1 = r0.audioBitDepth
                int r7 = com.google.android.exoplayer2.util.Util.getPcmEncoding(r1)
                if (r7 != 0) goto L_0x02a3
                int r1 = r0.audioBitDepth
                int r3 = r15.length()
                int r3 = r3 + 74
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r3)
                java.lang.String r3 = "Unsupported little endian PCM bit depth: "
                r6.append(r3)
                r6.append(r1)
                r6.append(r4)
                r6.append(r15)
                java.lang.String r1 = r6.toString()
                com.google.android.exoplayer2.util.Log.w(r5, r1)
            L_0x029f:
                r16 = r15
                goto L_0x0319
            L_0x02a3:
                r1 = r17
                r3 = r1
                goto L_0x031d
            L_0x02a8:
                r18 = r11
                int r1 = r0.audioBitDepth
                if (r1 != r6) goto L_0x02b0
                r7 = r8
                goto L_0x02a3
            L_0x02b0:
                if (r1 != r3) goto L_0x02b5
                r7 = 268435456(0x10000000, float:2.5243549E-29)
                goto L_0x02a3
            L_0x02b5:
                int r3 = r15.length()
                int r3 = r3 + 71
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r3)
                java.lang.String r3 = "Unsupported big endian PCM bit depth: "
                r6.append(r3)
                r6.append(r1)
                r6.append(r4)
                r6.append(r15)
                java.lang.String r1 = r6.toString()
                com.google.android.exoplayer2.util.Log.w(r5, r1)
                goto L_0x029f
            L_0x02d6:
                r18 = r11
                int r1 = r0.audioBitDepth
                r3 = 32
                if (r1 != r3) goto L_0x02df
                goto L_0x02a3
            L_0x02df:
                int r3 = r15.length()
                int r3 = r3 + 75
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r3)
                java.lang.String r3 = "Unsupported floating point PCM bit depth: "
                r6.append(r3)
                r6.append(r1)
                r6.append(r4)
                r6.append(r15)
                java.lang.String r1 = r6.toString()
                com.google.android.exoplayer2.util.Log.w(r5, r1)
                goto L_0x029f
            L_0x0300:
                r18 = r11
                java.lang.String r16 = "video/x-unknown"
                goto L_0x0319
            L_0x0306:
                r18 = r11
                r1 = r17
                r3 = r1
                r16 = r18
                goto L_0x031c
            L_0x030e:
                r18 = r11
                java.lang.String r16 = "video/x-vnd.on2.vp9"
                goto L_0x0319
            L_0x0314:
                r18 = r11
                java.lang.String r16 = "video/x-vnd.on2.vp8"
            L_0x0319:
                r1 = r17
                r3 = r1
            L_0x031c:
                r7 = -1
            L_0x031d:
                r15 = -1
                goto L_0x0457
            L_0x0320:
                r18 = r11
                java.lang.String r16 = "video/av01"
                goto L_0x0319
            L_0x0326:
                r18 = r11
                java.lang.String r16 = "audio/vnd.dts"
                goto L_0x0319
            L_0x032b:
                r18 = r11
                java.lang.String r16 = "audio/ac3"
                goto L_0x0319
            L_0x0330:
                r18 = r11
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                java.util.List r1 = java.util.Collections.singletonList(r1)
                byte[] r3 = r0.codecPrivate
                com.google.android.exoplayer2.audio.AacUtil$Config r3 = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(r3)
                int r4 = r3.sampleRateHz
                r0.sampleRate = r4
                int r4 = r3.channelCount
                r0.channelCount = r4
                java.lang.String r3 = r3.codecs
                java.lang.String r16 = "audio/mp4a-latm"
                goto L_0x031c
            L_0x034f:
                r18 = r11
                java.lang.String r16 = "audio/vnd.dts.hd"
                goto L_0x0319
            L_0x0354:
                r18 = r11
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1)
                r16 = r12
                goto L_0x03b7
            L_0x0363:
                r18 = r11
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                com.google.android.exoplayer2.video.AvcConfig r1 = com.google.android.exoplayer2.video.AvcConfig.parse(r1)
                java.util.List<byte[]> r3 = r1.initializationData
                int r4 = r1.nalUnitLengthFieldLength
                r0.nalUnitLengthFieldLength = r4
                java.lang.String r1 = r1.codecs
                java.lang.String r16 = "video/avc"
            L_0x037f:
                r7 = -1
                r15 = -1
                r19 = r3
                r3 = r1
                r1 = r19
                goto L_0x0457
            L_0x0388:
                r18 = r11
                byte[] r1 = new byte[r7]
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                java.lang.System.arraycopy(r3, r9, r1, r9, r7)
                com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r1)
                r16 = r2
                goto L_0x03b7
            L_0x039c:
                r18 = r11
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                android.util.Pair r1 = parseFourCcPrivate(r1)
                java.lang.Object r3 = r1.first
                r16 = r3
                java.lang.String r16 = (java.lang.String) r16
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
            L_0x03b7:
                r3 = r17
                goto L_0x031c
            L_0x03bb:
                r18 = r11
                java.lang.String r16 = "audio/mpeg"
                goto L_0x03c4
            L_0x03c0:
                r18 = r11
                java.lang.String r16 = "audio/mpeg-L2"
            L_0x03c4:
                r1 = r17
                r3 = r1
                r7 = -1
                r15 = 4096(0x1000, float:5.74E-42)
                goto L_0x0457
            L_0x03cc:
                r18 = r11
                r15 = 8192(0x2000, float:1.14794E-41)
                java.lang.String r1 = r0.codecId
                byte[] r1 = r0.getCodecPrivate(r1)
                java.util.List r1 = parseVorbisCodecPrivate(r1)
                java.lang.String r16 = "audio/vorbis"
            L_0x03dc:
                r3 = r17
                r7 = -1
                goto L_0x0457
            L_0x03e1:
                r18 = r11
                com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker r1 = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$TrueHdSampleRechunker
                r1.<init>()
                r0.trueHdSampleRechunker = r1
                java.lang.String r16 = "audio/true-hd"
                goto L_0x0319
            L_0x03ee:
                r18 = r11
                com.google.android.exoplayer2.util.ParsableByteArray r1 = new com.google.android.exoplayer2.util.ParsableByteArray
                java.lang.String r3 = r0.codecId
                byte[] r3 = r0.getCodecPrivate(r3)
                r1.<init>((byte[]) r3)
                boolean r1 = parseMsAcmCodecPrivate(r1)
                if (r1 == 0) goto L_0x042d
                int r1 = r0.audioBitDepth
                int r7 = com.google.android.exoplayer2.util.Util.getPcmEncoding(r1)
                if (r7 != 0) goto L_0x02a3
                int r1 = r0.audioBitDepth
                int r3 = r15.length()
                int r3 = r3 + 60
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>(r3)
                java.lang.String r3 = "Unsupported PCM bit depth: "
                r6.append(r3)
                r6.append(r1)
                r6.append(r4)
                r6.append(r15)
                java.lang.String r1 = r6.toString()
                com.google.android.exoplayer2.util.Log.w(r5, r1)
                goto L_0x029f
            L_0x042d:
                java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                int r3 = r15.length()
                if (r3 == 0) goto L_0x043a
                java.lang.String r1 = r1.concat(r15)
                goto L_0x0440
            L_0x043a:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
                r1 = r3
            L_0x0440:
                com.google.android.exoplayer2.util.Log.w(r5, r1)
                goto L_0x029f
            L_0x0445:
                r18 = r11
                byte[] r1 = r0.codecPrivate
                if (r1 != 0) goto L_0x044e
                r1 = r17
                goto L_0x0452
            L_0x044e:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x0452:
                java.lang.String r16 = "video/mp4v-es"
                goto L_0x03b7
            L_0x0457:
                byte[] r4 = r0.dolbyVisionConfigBytes
                if (r4 == 0) goto L_0x046b
                com.google.android.exoplayer2.util.ParsableByteArray r5 = new com.google.android.exoplayer2.util.ParsableByteArray
                r5.<init>((byte[]) r4)
                com.google.android.exoplayer2.video.DolbyVisionConfig r4 = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(r5)
                if (r4 == 0) goto L_0x046b
                java.lang.String r3 = r4.codecs
                java.lang.String r16 = "video/dolby-vision"
            L_0x046b:
                r4 = r16
                boolean r5 = r0.flagDefault
                r5 = r5 | r9
                boolean r6 = r0.flagForced
                if (r6 == 0) goto L_0x0476
                r6 = 2
                goto L_0x0477
            L_0x0476:
                r6 = r9
            L_0x0477:
                r5 = r5 | r6
                com.google.android.exoplayer2.Format$Builder r6 = new com.google.android.exoplayer2.Format$Builder
                r6.<init>()
                boolean r10 = com.google.android.exoplayer2.util.MimeTypes.isAudio(r4)
                if (r10 == 0) goto L_0x0495
                int r2 = r0.channelCount
                com.google.android.exoplayer2.Format$Builder r2 = r6.setChannelCount(r2)
                int r8 = r0.sampleRate
                com.google.android.exoplayer2.Format$Builder r2 = r2.setSampleRate(r8)
                r2.setPcmEncoding(r7)
                r8 = 1
                goto L_0x059a
            L_0x0495:
                boolean r7 = com.google.android.exoplayer2.util.MimeTypes.isVideo(r4)
                if (r7 == 0) goto L_0x0571
                int r2 = r0.displayUnit
                if (r2 != 0) goto L_0x04b1
                int r2 = r0.displayWidth
                r7 = -1
                if (r2 != r7) goto L_0x04a6
                int r2 = r0.width
            L_0x04a6:
                r0.displayWidth = r2
                int r2 = r0.displayHeight
                if (r2 != r7) goto L_0x04ae
                int r2 = r0.height
            L_0x04ae:
                r0.displayHeight = r2
                goto L_0x04b2
            L_0x04b1:
                r7 = -1
            L_0x04b2:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r8 = r0.displayWidth
                if (r8 == r7) goto L_0x04c5
                int r10 = r0.displayHeight
                if (r10 == r7) goto L_0x04c5
                int r2 = r0.height
                int r2 = r2 * r8
                float r2 = (float) r2
                int r8 = r0.width
                int r8 = r8 * r10
                float r8 = (float) r8
                float r2 = r2 / r8
            L_0x04c5:
                boolean r8 = r0.hasColorInfo
                if (r8 == 0) goto L_0x04d9
                byte[] r8 = r20.getHdrStaticInfo()
                com.google.android.exoplayer2.video.ColorInfo r10 = new com.google.android.exoplayer2.video.ColorInfo
                int r11 = r0.colorSpace
                int r12 = r0.colorRange
                int r13 = r0.colorTransfer
                r10.<init>(r11, r12, r13, r8)
                goto L_0x04db
            L_0x04d9:
                r10 = r17
            L_0x04db:
                java.lang.String r8 = r0.name
                if (r8 == 0) goto L_0x04fb
                java.util.Map r8 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES
                java.lang.String r11 = r0.name
                boolean r8 = r8.containsKey(r11)
                if (r8 == 0) goto L_0x04fb
                java.util.Map r7 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES
                java.lang.String r8 = r0.name
                java.lang.Object r7 = r7.get(r8)
                java.lang.Integer r7 = (java.lang.Integer) r7
                int r7 = r7.intValue()
            L_0x04fb:
                int r8 = r0.projectionType
                if (r8 != 0) goto L_0x054b
                float r8 = r0.projectionPoseYaw
                r11 = 0
                int r8 = java.lang.Float.compare(r8, r11)
                if (r8 != 0) goto L_0x054b
                float r8 = r0.projectionPosePitch
                int r8 = java.lang.Float.compare(r8, r11)
                if (r8 != 0) goto L_0x054b
                float r8 = r0.projectionPoseRoll
                int r8 = java.lang.Float.compare(r8, r11)
                if (r8 != 0) goto L_0x0519
                goto L_0x054c
            L_0x0519:
                float r8 = r0.projectionPosePitch
                r9 = 1119092736(0x42b40000, float:90.0)
                int r8 = java.lang.Float.compare(r8, r9)
                if (r8 != 0) goto L_0x0526
                r9 = 90
                goto L_0x054c
            L_0x0526:
                float r8 = r0.projectionPosePitch
                r9 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r8 = java.lang.Float.compare(r8, r9)
                if (r8 == 0) goto L_0x0548
                float r8 = r0.projectionPosePitch
                r9 = 1127481344(0x43340000, float:180.0)
                int r8 = java.lang.Float.compare(r8, r9)
                if (r8 != 0) goto L_0x053b
                goto L_0x0548
            L_0x053b:
                float r8 = r0.projectionPosePitch
                r9 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r8 = java.lang.Float.compare(r8, r9)
                if (r8 != 0) goto L_0x054b
                r9 = 270(0x10e, float:3.78E-43)
                goto L_0x054c
            L_0x0548:
                r9 = 180(0xb4, float:2.52E-43)
                goto L_0x054c
            L_0x054b:
                r9 = r7
            L_0x054c:
                int r7 = r0.width
                com.google.android.exoplayer2.Format$Builder r7 = r6.setWidth(r7)
                int r8 = r0.height
                com.google.android.exoplayer2.Format$Builder r7 = r7.setHeight(r8)
                com.google.android.exoplayer2.Format$Builder r2 = r7.setPixelWidthHeightRatio(r2)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setRotationDegrees(r9)
                byte[] r7 = r0.projectionData
                com.google.android.exoplayer2.Format$Builder r2 = r2.setProjectionData(r7)
                int r7 = r0.stereoMode
                com.google.android.exoplayer2.Format$Builder r2 = r2.setStereoMode(r7)
                r2.setColorInfo(r10)
                r8 = 2
                goto L_0x059a
            L_0x0571:
                boolean r7 = r14.equals(r4)
                if (r7 != 0) goto L_0x059a
                boolean r7 = r13.equals(r4)
                if (r7 != 0) goto L_0x059a
                boolean r7 = r12.equals(r4)
                if (r7 != 0) goto L_0x059a
                r7 = r18
                boolean r7 = r7.equals(r4)
                if (r7 != 0) goto L_0x059a
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x0592
                goto L_0x059a
            L_0x0592:
                com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x059a:
                java.lang.String r2 = r0.name
                if (r2 == 0) goto L_0x05af
                java.util.Map r2 = com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.TRACK_NAME_TO_ROTATION_DEGREES
                java.lang.String r7 = r0.name
                boolean r2 = r2.containsKey(r7)
                if (r2 != 0) goto L_0x05af
                java.lang.String r2 = r0.name
                r6.setLabel(r2)
            L_0x05af:
                r2 = r22
                com.google.android.exoplayer2.Format$Builder r2 = r6.setId((int) r2)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setSampleMimeType(r4)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setMaxInputSize(r15)
                java.lang.String r4 = r0.language
                com.google.android.exoplayer2.Format$Builder r2 = r2.setLanguage(r4)
                com.google.android.exoplayer2.Format$Builder r2 = r2.setSelectionFlags(r5)
                com.google.android.exoplayer2.Format$Builder r1 = r2.setInitializationData(r1)
                com.google.android.exoplayer2.Format$Builder r1 = r1.setCodecs(r3)
                com.google.android.exoplayer2.drm.DrmInitData r2 = r0.drmInitData
                com.google.android.exoplayer2.Format$Builder r1 = r1.setDrmInitData(r2)
                com.google.android.exoplayer2.Format r1 = r1.build()
                int r2 = r0.number
                r3 = r21
                com.google.android.exoplayer2.extractor.TrackOutput r2 = r3.track(r2, r8)
                r0.output = r2
                r2.format(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track.initializeOutput(com.google.android.exoplayer2.extractor.ExtractorOutput, int):void");
        }

        @RequiresNonNull({"output"})
        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.outputPendingSampleMetadata(this);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker2 = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker2 != null) {
                trueHdSampleRechunker2.reset();
            }
        }
    }

    public static final class TrueHdSampleRechunker {
        private int chunkFlags;
        private int chunkOffset;
        private int chunkSampleCount;
        private int chunkSize;
        private long chunkTimeUs;
        private boolean foundSyncframe;
        private final byte[] syncframePrefix = new byte[10];

        @RequiresNonNull({"#1.output"})
        public void outputPendingSampleMetadata(Track track) {
            if (this.chunkSampleCount > 0) {
                track.output.sampleMetadata(this.chunkTimeUs, this.chunkFlags, this.chunkSize, this.chunkOffset, track.cryptoData);
                this.chunkSampleCount = 0;
            }
        }

        public void reset() {
            this.foundSyncframe = false;
            this.chunkSampleCount = 0;
        }

        @RequiresNonNull({"#1.output"})
        public void sampleMetadata(Track track, long j11, int i11, int i12, int i13) {
            if (this.foundSyncframe) {
                int i14 = this.chunkSampleCount;
                int i15 = i14 + 1;
                this.chunkSampleCount = i15;
                if (i14 == 0) {
                    this.chunkTimeUs = j11;
                    this.chunkFlags = i11;
                    this.chunkSize = 0;
                }
                this.chunkSize += i12;
                this.chunkOffset = i13;
                if (i15 >= 16) {
                    outputPendingSampleMetadata(track);
                }
            }
        }

        public void startSample(ExtractorInput extractorInput) throws IOException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 10);
                extractorInput.resetPeekPosition();
                if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) != 0) {
                    this.foundSyncframe = true;
                }
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("htc_video_rotA-000", 0);
        hashMap.put("htc_video_rotA-090", 90);
        hashMap.put("htc_video_rotA-180", 180);
        hashMap.put("htc_video_rotA-270", 270);
        TRACK_NAME_TO_ROTATION_DEGREES = Collections.unmodifiableMap(hashMap);
    }

    public MatroskaExtractor() {
        this(0);
    }

    @EnsuresNonNull({"cueTimesUs", "cueClusterPositions"})
    private void assertInCues(int i11) throws ParserException {
        if (this.cueTimesUs == null || this.cueClusterPositions == null) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Element ");
            sb2.append(i11);
            sb2.append(" must be in a Cues");
            throw new ParserException(sb2.toString());
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private void assertInTrackEntry(int i11) throws ParserException {
        if (this.currentTrack == null) {
            StringBuilder sb2 = new StringBuilder(43);
            sb2.append("Element ");
            sb2.append(i11);
            sb2.append(" must be in a TrackEntry");
            throw new ParserException(sb2.toString());
        }
    }

    @EnsuresNonNull({"extractorOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.extractorOutput);
    }

    private SeekMap buildSeekMap(LongArray longArray, LongArray longArray2) {
        int i11;
        if (this.segmentContentPosition == -1 || this.durationUs == -9223372036854775807L || longArray == null || longArray.size() == 0 || longArray2 == null || longArray2.size() != longArray.size()) {
            return new SeekMap.Unseekable(this.durationUs);
        }
        int size = longArray.size();
        int[] iArr = new int[size];
        long[] jArr = new long[size];
        long[] jArr2 = new long[size];
        long[] jArr3 = new long[size];
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            jArr3[i13] = longArray.get(i13);
            jArr[i13] = this.segmentContentPosition + longArray2.get(i13);
        }
        while (true) {
            i11 = size - 1;
            if (i12 >= i11) {
                break;
            }
            int i14 = i12 + 1;
            iArr[i12] = (int) (jArr[i14] - jArr[i12]);
            jArr2[i12] = jArr3[i14] - jArr3[i12];
            i12 = i14;
        }
        iArr[i11] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i11]);
        jArr2[i11] = this.durationUs - jArr3[i11];
        long j11 = jArr2[i11];
        if (j11 <= 0) {
            StringBuilder sb2 = new StringBuilder(72);
            sb2.append("Discarding last cue point with unexpected duration: ");
            sb2.append(j11);
            Log.w(TAG, sb2.toString());
            iArr = Arrays.copyOf(iArr, i11);
            jArr = Arrays.copyOf(jArr, i11);
            jArr2 = Arrays.copyOf(jArr2, i11);
            jArr3 = Arrays.copyOf(jArr3, i11);
        }
        return new ChunkIndex(iArr, jArr, jArr2, jArr3);
    }

    @RequiresNonNull({"#1.output"})
    private void commitSampleToOutput(Track track, long j11, int i11, int i12, int i13) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, j11, i11, i12, i13);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId) || CODEC_ID_ASS.equals(track.codecId)) {
                if (this.blockSampleCount > 1) {
                    Log.w(TAG, "Skipping subtitle sample in laced block.");
                } else {
                    long j12 = this.blockDurationUs;
                    if (j12 == -9223372036854775807L) {
                        Log.w(TAG, "Skipping subtitle sample with no duration.");
                    } else {
                        setSubtitleEndTime(track.codecId, j12, this.subtitleSample.getData());
                        int position = this.subtitleSample.getPosition();
                        while (true) {
                            if (position >= this.subtitleSample.limit()) {
                                break;
                            } else if (this.subtitleSample.getData()[position] == 0) {
                                this.subtitleSample.setLimit(position);
                                break;
                            } else {
                                position++;
                            }
                        }
                        TrackOutput trackOutput = track.output;
                        ParsableByteArray parsableByteArray = this.subtitleSample;
                        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
                        i12 += this.subtitleSample.limit();
                    }
                }
            }
            if ((268435456 & i11) != 0) {
                if (this.blockSampleCount > 1) {
                    i11 &= -268435457;
                } else {
                    int limit = this.blockAdditionalData.limit();
                    track.output.sampleData(this.blockAdditionalData, limit, 2);
                    i12 += limit;
                }
            }
            track.output.sampleMetadata(j11, i11, i12, i13, track.cryptoData);
        }
        this.haveOutputSample = true;
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i11) {
        if (iArr == null) {
            return new int[i11];
        }
        if (iArr.length >= i11) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i11)];
    }

    private int finishWriteSampleData() {
        int i11 = this.sampleBytesWritten;
        resetWriteSampleData();
        return i11;
    }

    private static byte[] formatSubtitleTimecode(long j11, String str, long j12) {
        Assertions.checkArgument(j11 != -9223372036854775807L);
        int i11 = (int) (j11 / 3600000000L);
        long j13 = j11 - (((long) (i11 * 3600)) * 1000000);
        int i12 = (int) (j13 / 60000000);
        long j14 = j13 - (((long) (i12 * 60)) * 1000000);
        int i13 = (int) (j14 / 1000000);
        return Util.getUtf8Bytes(String.format(Locale.US, str, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf((int) ((j14 - (((long) i13) * 1000000)) / j12))}));
    }

    private Track getCurrentTrack(int i11) throws ParserException {
        assertInTrackEntry(i11);
        return this.currentTrack;
    }

    private static boolean isCodecSupported(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals(CODEC_ID_MPEG4_AP)) {
                    c11 = 0;
                    break;
                }
                break;
            case -2095575984:
                if (str.equals(CODEC_ID_MPEG4_SP)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1985379776:
                if (str.equals(CODEC_ID_ACM)) {
                    c11 = 2;
                    break;
                }
                break;
            case -1784763192:
                if (str.equals(CODEC_ID_TRUEHD)) {
                    c11 = 3;
                    break;
                }
                break;
            case -1730367663:
                if (str.equals(CODEC_ID_VORBIS)) {
                    c11 = 4;
                    break;
                }
                break;
            case -1482641358:
                if (str.equals(CODEC_ID_MP2)) {
                    c11 = 5;
                    break;
                }
                break;
            case -1482641357:
                if (str.equals(CODEC_ID_MP3)) {
                    c11 = 6;
                    break;
                }
                break;
            case -1373388978:
                if (str.equals(CODEC_ID_FOURCC)) {
                    c11 = 7;
                    break;
                }
                break;
            case -933872740:
                if (str.equals(CODEC_ID_DVBSUB)) {
                    c11 = 8;
                    break;
                }
                break;
            case -538363189:
                if (str.equals(CODEC_ID_MPEG4_ASP)) {
                    c11 = 9;
                    break;
                }
                break;
            case -538363109:
                if (str.equals(CODEC_ID_H264)) {
                    c11 = 10;
                    break;
                }
                break;
            case -425012669:
                if (str.equals(CODEC_ID_VOBSUB)) {
                    c11 = 11;
                    break;
                }
                break;
            case -356037306:
                if (str.equals(CODEC_ID_DTS_LOSSLESS)) {
                    c11 = 12;
                    break;
                }
                break;
            case 62923557:
                if (str.equals(CODEC_ID_AAC)) {
                    c11 = 13;
                    break;
                }
                break;
            case 62923603:
                if (str.equals(CODEC_ID_AC3)) {
                    c11 = 14;
                    break;
                }
                break;
            case 62927045:
                if (str.equals(CODEC_ID_DTS)) {
                    c11 = 15;
                    break;
                }
                break;
            case 82318131:
                if (str.equals(CODEC_ID_AV1)) {
                    c11 = 16;
                    break;
                }
                break;
            case 82338133:
                if (str.equals(CODEC_ID_VP8)) {
                    c11 = 17;
                    break;
                }
                break;
            case 82338134:
                if (str.equals(CODEC_ID_VP9)) {
                    c11 = 18;
                    break;
                }
                break;
            case 99146302:
                if (str.equals(CODEC_ID_PGS)) {
                    c11 = 19;
                    break;
                }
                break;
            case 444813526:
                if (str.equals(CODEC_ID_THEORA)) {
                    c11 = 20;
                    break;
                }
                break;
            case 542569478:
                if (str.equals(CODEC_ID_DTS_EXPRESS)) {
                    c11 = 21;
                    break;
                }
                break;
            case 635596514:
                if (str.equals(CODEC_ID_PCM_FLOAT)) {
                    c11 = 22;
                    break;
                }
                break;
            case 725948237:
                if (str.equals(CODEC_ID_PCM_INT_BIG)) {
                    c11 = 23;
                    break;
                }
                break;
            case 725957860:
                if (str.equals(CODEC_ID_PCM_INT_LIT)) {
                    c11 = 24;
                    break;
                }
                break;
            case 738597099:
                if (str.equals(CODEC_ID_ASS)) {
                    c11 = 25;
                    break;
                }
                break;
            case 855502857:
                if (str.equals(CODEC_ID_H265)) {
                    c11 = 26;
                    break;
                }
                break;
            case 1422270023:
                if (str.equals(CODEC_ID_SUBRIP)) {
                    c11 = 27;
                    break;
                }
                break;
            case 1809237540:
                if (str.equals(CODEC_ID_MPEG2)) {
                    c11 = 28;
                    break;
                }
                break;
            case 1950749482:
                if (str.equals(CODEC_ID_E_AC3)) {
                    c11 = 29;
                    break;
                }
                break;
            case 1950789798:
                if (str.equals(CODEC_ID_FLAC)) {
                    c11 = 30;
                    break;
                }
                break;
            case 1951062397:
                if (str.equals(CODEC_ID_OPUS)) {
                    c11 = 31;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j11) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j11;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j12 = this.seekPositionAfterBuildingCues;
            if (j12 != -1) {
                positionHolder.position = j12;
                this.seekPositionAfterBuildingCues = -1;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i11) throws IOException {
        if (this.scratch.limit() < i11) {
            if (this.scratch.capacity() < i11) {
                ParsableByteArray parsableByteArray = this.scratch;
                parsableByteArray.ensureCapacity(Math.max(parsableByteArray.capacity() * 2, i11));
            }
            extractorInput.readFully(this.scratch.getData(), this.scratch.limit(), i11 - this.scratch.limit());
            this.scratch.setLimit(i11);
        }
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset(0);
    }

    private long scaleTimecodeToUs(long j11) throws ParserException {
        long j12 = this.timecodeScale;
        if (j12 != -9223372036854775807L) {
            return Util.scaleLargeTimestamp(j11, j12, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void setSubtitleEndTime(String str, long j11, byte[] bArr) {
        int i11;
        byte[] bArr2;
        str.hashCode();
        if (str.equals(CODEC_ID_ASS)) {
            bArr2 = formatSubtitleTimecode(j11, SSA_TIMECODE_FORMAT, 10000);
            i11 = 21;
        } else if (str.equals(CODEC_ID_SUBRIP)) {
            bArr2 = formatSubtitleTimecode(j11, SUBRIP_TIMECODE_FORMAT, 1000);
            i11 = 19;
        } else {
            throw new IllegalArgumentException();
        }
        System.arraycopy(bArr2, 0, bArr, i11, bArr2.length);
    }

    @RequiresNonNull({"#2.output"})
    private int writeSampleData(ExtractorInput extractorInput, Track track, int i11) throws IOException {
        int i12;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i11);
            return finishWriteSampleData();
        } else if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i11);
            return finishWriteSampleData();
        } else {
            TrackOutput trackOutput = track.output;
            boolean z11 = true;
            if (!this.sampleEncodingHandled) {
                if (track.hasContentEncryption) {
                    this.blockFlags &= -1073741825;
                    int i13 = 128;
                    if (!this.sampleSignalByteRead) {
                        extractorInput.readFully(this.scratch.getData(), 0, 1);
                        this.sampleBytesRead++;
                        if ((this.scratch.getData()[0] & 128) != 128) {
                            this.sampleSignalByte = this.scratch.getData()[0];
                            this.sampleSignalByteRead = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    byte b11 = this.sampleSignalByte;
                    if ((b11 & 1) == 1) {
                        boolean z12 = (b11 & 2) == 2;
                        this.blockFlags |= 1073741824;
                        if (!this.sampleInitializationVectorRead) {
                            extractorInput.readFully(this.encryptionInitializationVector.getData(), 0, 8);
                            this.sampleBytesRead += 8;
                            this.sampleInitializationVectorRead = true;
                            byte[] data = this.scratch.getData();
                            if (!z12) {
                                i13 = 0;
                            }
                            data[0] = (byte) (i13 | 8);
                            this.scratch.setPosition(0);
                            trackOutput.sampleData(this.scratch, 1, 1);
                            this.sampleBytesWritten++;
                            this.encryptionInitializationVector.setPosition(0);
                            trackOutput.sampleData(this.encryptionInitializationVector, 8, 1);
                            this.sampleBytesWritten += 8;
                        }
                        if (z12) {
                            if (!this.samplePartitionCountRead) {
                                extractorInput.readFully(this.scratch.getData(), 0, 1);
                                this.sampleBytesRead++;
                                this.scratch.setPosition(0);
                                this.samplePartitionCount = this.scratch.readUnsignedByte();
                                this.samplePartitionCountRead = true;
                            }
                            int i14 = this.samplePartitionCount * 4;
                            this.scratch.reset(i14);
                            extractorInput.readFully(this.scratch.getData(), 0, i14);
                            this.sampleBytesRead += i14;
                            short s11 = (short) ((this.samplePartitionCount / 2) + 1);
                            int i15 = (s11 * 6) + 2;
                            ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                            if (byteBuffer == null || byteBuffer.capacity() < i15) {
                                this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i15);
                            }
                            this.encryptionSubsampleDataBuffer.position(0);
                            this.encryptionSubsampleDataBuffer.putShort(s11);
                            int i16 = 0;
                            int i17 = 0;
                            while (true) {
                                i12 = this.samplePartitionCount;
                                if (i16 >= i12) {
                                    break;
                                }
                                int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                                if (i16 % 2 == 0) {
                                    this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i17));
                                } else {
                                    this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i17);
                                }
                                i16++;
                                i17 = readUnsignedIntToInt;
                            }
                            int i18 = (i11 - this.sampleBytesRead) - i17;
                            if (i12 % 2 == 1) {
                                this.encryptionSubsampleDataBuffer.putInt(i18);
                            } else {
                                this.encryptionSubsampleDataBuffer.putShort((short) i18);
                                this.encryptionSubsampleDataBuffer.putInt(0);
                            }
                            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i15);
                            trackOutput.sampleData(this.encryptionSubsampleData, i15, 1);
                            this.sampleBytesWritten += i15;
                        }
                    }
                } else {
                    byte[] bArr = track.sampleStrippedBytes;
                    if (bArr != null) {
                        this.sampleStrippedBytes.reset(bArr, bArr.length);
                    }
                }
                if (track.maxBlockAdditionId > 0) {
                    this.blockFlags |= 268435456;
                    this.blockAdditionalData.reset(0);
                    this.scratch.reset(4);
                    this.scratch.getData()[0] = (byte) ((i11 >> 24) & 255);
                    this.scratch.getData()[1] = (byte) ((i11 >> 16) & 255);
                    this.scratch.getData()[2] = (byte) ((i11 >> 8) & 255);
                    this.scratch.getData()[3] = (byte) (i11 & 255);
                    trackOutput.sampleData(this.scratch, 4, 2);
                    this.sampleBytesWritten += 4;
                }
                this.sampleEncodingHandled = true;
            }
            int limit = i11 + this.sampleStrippedBytes.limit();
            if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
                if (track.trueHdSampleRechunker != null) {
                    if (this.sampleStrippedBytes.limit() != 0) {
                        z11 = false;
                    }
                    Assertions.checkState(z11);
                    track.trueHdSampleRechunker.startSample(extractorInput);
                }
                while (true) {
                    int i19 = this.sampleBytesRead;
                    if (i19 >= limit) {
                        break;
                    }
                    int writeToOutput = writeToOutput(extractorInput, trackOutput, limit - i19);
                    this.sampleBytesRead += writeToOutput;
                    this.sampleBytesWritten += writeToOutput;
                }
            } else {
                byte[] data2 = this.nalLength.getData();
                data2[0] = 0;
                data2[1] = 0;
                data2[2] = 0;
                int i21 = track.nalUnitLengthFieldLength;
                int i22 = 4 - i21;
                while (this.sampleBytesRead < limit) {
                    int i23 = this.sampleCurrentNalBytesRemaining;
                    if (i23 == 0) {
                        writeToTarget(extractorInput, data2, i22, i21);
                        this.sampleBytesRead += i21;
                        this.nalLength.setPosition(0);
                        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                    } else {
                        int writeToOutput2 = writeToOutput(extractorInput, trackOutput, i23);
                        this.sampleBytesRead += writeToOutput2;
                        this.sampleBytesWritten += writeToOutput2;
                        this.sampleCurrentNalBytesRemaining -= writeToOutput2;
                    }
                }
            }
            if (CODEC_ID_VORBIS.equals(track.codecId)) {
                this.vorbisNumPageSamples.setPosition(0);
                trackOutput.sampleData(this.vorbisNumPageSamples, 4);
                this.sampleBytesWritten += 4;
            }
            return finishWriteSampleData();
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i11) throws IOException {
        int length = bArr.length + i11;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.reset(Arrays.copyOf(bArr, length + i11));
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.getData(), 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.getData(), bArr.length, i11);
        this.subtitleSample.setPosition(0);
        this.subtitleSample.setLimit(length);
    }

    private int writeToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i11) throws IOException {
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft <= 0) {
            return trackOutput.sampleData((DataReader) extractorInput, i11, false);
        }
        int min = Math.min(i11, bytesLeft);
        trackOutput.sampleData(this.sampleStrippedBytes, min);
        return min;
    }

    private void writeToTarget(ExtractorInput extractorInput, byte[] bArr, int i11, int i12) throws IOException {
        int min = Math.min(i12, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i11 + min, i12 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i11, min);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0231, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void binaryElement(int r22, int r23, com.google.android.exoplayer2.extractor.ExtractorInput r24) throws java.io.IOException {
        /*
            r21 = this;
            r7 = r21
            r0 = r22
            r1 = r23
            r8 = r24
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 163(0xa3, float:2.28E-43)
            r4 = 2
            r9 = 0
            r10 = 1
            if (r0 == r2) goto L_0x00c7
            if (r0 == r3) goto L_0x00c7
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00b1
            r2 = 16877(0x41ed, float:2.365E-41)
            if (r0 == r2) goto L_0x00a8
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x009a
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x0088
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0064
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0056
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x003d
            r21.assertInTrackEntry(r22)
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r0 = r7.currentTrack
            byte[] r2 = new byte[r1]
            r0.projectionData = r2
            r8.readFully(r2, r9, r1)
            goto L_0x02e2
        L_0x003d:
            com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
            r2 = 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected id: "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x0056:
            r21.assertInTrackEntry(r22)
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r0 = r7.currentTrack
            byte[] r2 = new byte[r1]
            r0.codecPrivate = r2
            r8.readFully(r2, r9, r1)
            goto L_0x02e2
        L_0x0064:
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r7.seekEntryIdBytes
            byte[] r0 = r0.getData()
            java.util.Arrays.fill(r0, r9)
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r7.seekEntryIdBytes
            byte[] r0 = r0.getData()
            int r2 = 4 - r1
            r8.readFully(r0, r2, r1)
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r7.seekEntryIdBytes
            r0.setPosition(r9)
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r7.seekEntryIdBytes
            long r0 = r0.readUnsignedInt()
            int r0 = (int) r0
            r7.seekEntryId = r0
            goto L_0x02e2
        L_0x0088:
            byte[] r2 = new byte[r1]
            r8.readFully(r2, r9, r1)
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r0 = r21.getCurrentTrack(r22)
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData r1 = new com.google.android.exoplayer2.extractor.TrackOutput$CryptoData
            r1.<init>(r10, r2, r9, r9)
            r0.cryptoData = r1
            goto L_0x02e2
        L_0x009a:
            r21.assertInTrackEntry(r22)
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r0 = r7.currentTrack
            byte[] r2 = new byte[r1]
            r0.sampleStrippedBytes = r2
            r8.readFully(r2, r9, r1)
            goto L_0x02e2
        L_0x00a8:
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r0 = r21.getCurrentTrack(r22)
            r7.handleBlockAddIDExtraData(r0, r8, r1)
            goto L_0x02e2
        L_0x00b1:
            int r0 = r7.blockState
            if (r0 == r4) goto L_0x00b6
            return
        L_0x00b6:
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track> r0 = r7.tracks
            int r2 = r7.blockTrackNumber
            java.lang.Object r0 = r0.get(r2)
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r0 = (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track) r0
            int r2 = r7.blockAdditionalId
            r7.handleBlockAdditionalData(r0, r2, r8, r1)
            goto L_0x02e2
        L_0x00c7:
            int r2 = r7.blockState
            r5 = 8
            if (r2 != 0) goto L_0x00ec
            com.google.android.exoplayer2.extractor.mkv.VarintReader r2 = r7.varintReader
            long r11 = r2.readUnsignedVarint(r8, r9, r10, r5)
            int r2 = (int) r11
            r7.blockTrackNumber = r2
            com.google.android.exoplayer2.extractor.mkv.VarintReader r2 = r7.varintReader
            int r2 = r2.getLastLength()
            r7.blockTrackNumberLength = r2
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.blockDurationUs = r11
            r7.blockState = r10
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r7.scratch
            r2.reset((int) r9)
        L_0x00ec:
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track> r2 = r7.tracks
            int r6 = r7.blockTrackNumber
            java.lang.Object r2 = r2.get(r6)
            r11 = r2
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor$Track r11 = (com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track) r11
            if (r11 != 0) goto L_0x0103
            int r0 = r7.blockTrackNumberLength
            int r0 = r1 - r0
            r8.skipFully(r0)
            r7.blockState = r9
            return
        L_0x0103:
            r11.assertOutputInitialized()
            int r2 = r7.blockState
            if (r2 != r10) goto L_0x029e
            r2 = 3
            r7.readScratch(r8, r2)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r7.scratch
            byte[] r6 = r6.getData()
            byte r6 = r6[r4]
            r6 = r6 & 6
            int r6 = r6 >> r10
            r12 = 255(0xff, float:3.57E-43)
            if (r6 != 0) goto L_0x012f
            r7.blockSampleCount = r10
            int[] r6 = r7.blockSampleSizes
            int[] r6 = ensureArrayCapacity(r6, r10)
            r7.blockSampleSizes = r6
            int r13 = r7.blockTrackNumberLength
            int r1 = r1 - r13
            int r1 = r1 - r2
            r6[r9] = r1
            goto L_0x0244
        L_0x012f:
            r13 = 4
            r7.readScratch(r8, r13)
            com.google.android.exoplayer2.util.ParsableByteArray r14 = r7.scratch
            byte[] r14 = r14.getData()
            byte r14 = r14[r2]
            r14 = r14 & r12
            int r14 = r14 + r10
            r7.blockSampleCount = r14
            int[] r15 = r7.blockSampleSizes
            int[] r14 = ensureArrayCapacity(r15, r14)
            r7.blockSampleSizes = r14
            if (r6 != r4) goto L_0x0155
            int r2 = r7.blockTrackNumberLength
            int r1 = r1 - r2
            int r1 = r1 - r13
            int r2 = r7.blockSampleCount
            int r1 = r1 / r2
            java.util.Arrays.fill(r14, r9, r2, r1)
            goto L_0x0244
        L_0x0155:
            if (r6 != r10) goto L_0x018e
            r2 = r9
            r6 = r2
        L_0x0159:
            int r14 = r7.blockSampleCount
            int r15 = r14 + -1
            if (r2 >= r15) goto L_0x0182
            int[] r14 = r7.blockSampleSizes
            r14[r2] = r9
        L_0x0163:
            int r13 = r13 + r10
            r7.readScratch(r8, r13)
            com.google.android.exoplayer2.util.ParsableByteArray r14 = r7.scratch
            byte[] r14 = r14.getData()
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r7.blockSampleSizes
            r16 = r15[r2]
            int r16 = r16 + r14
            r15[r2] = r16
            if (r14 == r12) goto L_0x0163
            r14 = r15[r2]
            int r6 = r6 + r14
            int r2 = r2 + 1
            goto L_0x0159
        L_0x0182:
            int[] r2 = r7.blockSampleSizes
            int r14 = r14 - r10
            int r15 = r7.blockTrackNumberLength
            int r1 = r1 - r15
            int r1 = r1 - r13
            int r1 = r1 - r6
            r2[r14] = r1
            goto L_0x0244
        L_0x018e:
            if (r6 != r2) goto L_0x0285
            r2 = r9
            r6 = r2
        L_0x0192:
            int r14 = r7.blockSampleCount
            int r15 = r14 + -1
            if (r2 >= r15) goto L_0x023a
            int[] r14 = r7.blockSampleSizes
            r14[r2] = r9
            int r13 = r13 + 1
            r7.readScratch(r8, r13)
            com.google.android.exoplayer2.util.ParsableByteArray r14 = r7.scratch
            byte[] r14 = r14.getData()
            int r15 = r13 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0232
            r16 = 0
            r14 = r9
        L_0x01b0:
            if (r14 >= r5) goto L_0x0203
            int r18 = 7 - r14
            int r3 = r10 << r18
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r7.scratch
            byte[] r4 = r4.getData()
            byte r4 = r4[r15]
            r4 = r4 & r3
            if (r4 == 0) goto L_0x01fd
            int r13 = r13 + r14
            r7.readScratch(r8, r13)
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r7.scratch
            byte[] r4 = r4.getData()
            int r16 = r15 + 1
            byte r4 = r4[r15]
            r4 = r4 & r12
            int r3 = ~r3
            r3 = r3 & r4
            long r3 = (long) r3
            r19 = r3
            r3 = r16
        L_0x01d7:
            r16 = r19
            if (r3 >= r13) goto L_0x01ef
            long r15 = r16 << r5
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r7.scratch
            byte[] r4 = r4.getData()
            int r17 = r3 + 1
            byte r3 = r4[r3]
            r3 = r3 & r12
            long r3 = (long) r3
            long r3 = r3 | r15
            r19 = r3
            r3 = r17
            goto L_0x01d7
        L_0x01ef:
            if (r2 <= 0) goto L_0x0203
            int r14 = r14 * 7
            int r14 = r14 + 6
            r3 = 1
            long r14 = r3 << r14
            long r14 = r14 - r3
            long r16 = r16 - r14
            goto L_0x0203
        L_0x01fd:
            int r14 = r14 + 1
            r3 = 163(0xa3, float:2.28E-43)
            r4 = 2
            goto L_0x01b0
        L_0x0203:
            r3 = r16
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r14 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r14 < 0) goto L_0x022a
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r14 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x022a
            int r3 = (int) r3
            int[] r4 = r7.blockSampleSizes
            if (r2 != 0) goto L_0x0219
            goto L_0x021e
        L_0x0219:
            int r14 = r2 + -1
            r14 = r4[r14]
            int r3 = r3 + r14
        L_0x021e:
            r4[r2] = r3
            r3 = r4[r2]
            int r6 = r6 + r3
            int r2 = r2 + 1
            r3 = 163(0xa3, float:2.28E-43)
            r4 = 2
            goto L_0x0192
        L_0x022a:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "EBML lacing sample size out of range."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0232:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "No valid varint length mask found"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x023a:
            int[] r2 = r7.blockSampleSizes
            int r14 = r14 - r10
            int r3 = r7.blockTrackNumberLength
            int r1 = r1 - r3
            int r1 = r1 - r13
            int r1 = r1 - r6
            r2[r14] = r1
        L_0x0244:
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r7.scratch
            byte[] r1 = r1.getData()
            byte r1 = r1[r9]
            int r1 = r1 << r5
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r7.scratch
            byte[] r2 = r2.getData()
            byte r2 = r2[r10]
            r2 = r2 & r12
            r1 = r1 | r2
            long r2 = r7.clusterTimecodeUs
            long r4 = (long) r1
            long r4 = r7.scaleTimecodeToUs(r4)
            long r2 = r2 + r4
            r7.blockTimeUs = r2
            int r1 = r11.type
            r2 = 2
            if (r1 == r2) goto L_0x027a
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x0278
            com.google.android.exoplayer2.util.ParsableByteArray r1 = r7.scratch
            byte[] r1 = r1.getData()
            byte r1 = r1[r2]
            r2 = 128(0x80, float:1.794E-43)
            r1 = r1 & r2
            if (r1 != r2) goto L_0x0278
            goto L_0x027a
        L_0x0278:
            r1 = r9
            goto L_0x027b
        L_0x027a:
            r1 = r10
        L_0x027b:
            r7.blockFlags = r1
            r1 = 2
            r7.blockState = r1
            r7.blockSampleIndex = r9
            r1 = 163(0xa3, float:2.28E-43)
            goto L_0x029f
        L_0x0285:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            r1 = 36
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Unexpected lacing value: "
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = r2.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x029e:
            r1 = r3
        L_0x029f:
            if (r0 != r1) goto L_0x02cc
        L_0x02a1:
            int r0 = r7.blockSampleIndex
            int r1 = r7.blockSampleCount
            if (r0 >= r1) goto L_0x02c9
            int[] r1 = r7.blockSampleSizes
            r0 = r1[r0]
            int r5 = r7.writeSampleData(r8, r11, r0)
            long r0 = r7.blockTimeUs
            int r2 = r7.blockSampleIndex
            int r3 = r11.defaultSampleDurationNs
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.blockFlags
            r6 = 0
            r0 = r21
            r1 = r11
            r0.commitSampleToOutput(r1, r2, r4, r5, r6)
            int r0 = r7.blockSampleIndex
            int r0 = r0 + r10
            r7.blockSampleIndex = r0
            goto L_0x02a1
        L_0x02c9:
            r7.blockState = r9
            goto L_0x02e2
        L_0x02cc:
            int r0 = r7.blockSampleIndex
            int r1 = r7.blockSampleCount
            if (r0 >= r1) goto L_0x02e2
            int[] r1 = r7.blockSampleSizes
            r2 = r1[r0]
            int r2 = r7.writeSampleData(r8, r11, r2)
            r1[r0] = r2
            int r0 = r7.blockSampleIndex
            int r0 = r0 + r10
            r7.blockSampleIndex = r0
            goto L_0x02cc
        L_0x02e2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.binaryElement(int, int, com.google.android.exoplayer2.extractor.ExtractorInput):void");
    }

    public void endMasterElement(int i11) throws ParserException {
        assertInitialized();
        if (i11 != 160) {
            if (i11 == ID_TRACK_ENTRY) {
                Track track = (Track) Assertions.checkStateNotNull(this.currentTrack);
                String str = track.codecId;
                if (str != null) {
                    if (isCodecSupported(str)) {
                        track.initializeOutput(this.extractorOutput, track.number);
                        this.tracks.put(track.number, track);
                    }
                    this.currentTrack = null;
                    return;
                }
                throw new ParserException("CodecId is missing in TrackEntry element");
            } else if (i11 == ID_SEEK) {
                int i12 = this.seekEntryId;
                if (i12 != -1) {
                    long j11 = this.seekEntryPosition;
                    if (j11 != -1) {
                        if (i12 == ID_CUES) {
                            this.cuesContentPosition = j11;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i11 == ID_CONTENT_ENCODING) {
                assertInTrackEntry(i11);
                Track track2 = this.currentTrack;
                if (!track2.hasContentEncryption) {
                    return;
                }
                if (track2.cryptoData != null) {
                    track2.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, MimeTypes.VIDEO_WEBM, this.currentTrack.cryptoData.encryptionKey));
                    return;
                }
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            } else if (i11 == ID_CONTENT_ENCODINGS) {
                assertInTrackEntry(i11);
                Track track3 = this.currentTrack;
                if (track3.hasContentEncryption && track3.sampleStrippedBytes != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (i11 == 357149030) {
                if (this.timecodeScale == -9223372036854775807L) {
                    this.timecodeScale = 1000000;
                }
                long j12 = this.durationTimecode;
                if (j12 != -9223372036854775807L) {
                    this.durationUs = scaleTimecodeToUs(j12);
                }
            } else if (i11 != ID_TRACKS) {
                if (i11 == ID_CUES) {
                    if (!this.sentSeekMap) {
                        this.extractorOutput.seekMap(buildSeekMap(this.cueTimesUs, this.cueClusterPositions));
                        this.sentSeekMap = true;
                    }
                    this.cueTimesUs = null;
                    this.cueClusterPositions = null;
                }
            } else if (this.tracks.size() != 0) {
                this.extractorOutput.endTracks();
            } else {
                throw new ParserException("No valid tracks were found");
            }
        } else if (this.blockState == 2) {
            int i13 = 0;
            for (int i14 = 0; i14 < this.blockSampleCount; i14++) {
                i13 += this.blockSampleSizes[i14];
            }
            Track track4 = this.tracks.get(this.blockTrackNumber);
            track4.assertOutputInitialized();
            for (int i15 = 0; i15 < this.blockSampleCount; i15++) {
                long j13 = ((long) ((track4.defaultSampleDurationNs * i15) / 1000)) + this.blockTimeUs;
                int i16 = this.blockFlags;
                if (i15 == 0 && !this.blockHasReferenceBlock) {
                    i16 |= 1;
                }
                int i17 = this.blockSampleSizes[i15];
                i13 -= i17;
                commitSampleToOutput(track4, j13, i16, i17, i13);
            }
            this.blockState = 0;
        }
    }

    public void floatElement(int i11, double d11) throws ParserException {
        if (i11 == 181) {
            getCurrentTrack(i11).sampleRate = (int) d11;
        } else if (i11 != ID_DURATION) {
            switch (i11) {
                case ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
                    getCurrentTrack(i11).primaryRChromaticityX = (float) d11;
                    return;
                case ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
                    getCurrentTrack(i11).primaryRChromaticityY = (float) d11;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
                    getCurrentTrack(i11).primaryGChromaticityX = (float) d11;
                    return;
                case ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
                    getCurrentTrack(i11).primaryGChromaticityY = (float) d11;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
                    getCurrentTrack(i11).primaryBChromaticityX = (float) d11;
                    return;
                case ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
                    getCurrentTrack(i11).primaryBChromaticityY = (float) d11;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
                    getCurrentTrack(i11).whitePointChromaticityX = (float) d11;
                    return;
                case ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
                    getCurrentTrack(i11).whitePointChromaticityY = (float) d11;
                    return;
                case ID_LUMNINANCE_MAX /*21977*/:
                    getCurrentTrack(i11).maxMasteringLuminance = (float) d11;
                    return;
                case ID_LUMNINANCE_MIN /*21978*/:
                    getCurrentTrack(i11).minMasteringLuminance = (float) d11;
                    return;
                default:
                    switch (i11) {
                        case ID_PROJECTION_POSE_YAW /*30323*/:
                            getCurrentTrack(i11).projectionPoseYaw = (float) d11;
                            return;
                        case ID_PROJECTION_POSE_PITCH /*30324*/:
                            getCurrentTrack(i11).projectionPosePitch = (float) d11;
                            return;
                        case ID_PROJECTION_POSE_ROLL /*30325*/:
                            getCurrentTrack(i11).projectionPoseRoll = (float) d11;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.durationTimecode = (long) d11;
        }
    }

    public int getElementType(int i11) {
        switch (i11) {
            case 131:
            case 136:
            case ID_BLOCK_DURATION /*155*/:
            case ID_CHANNELS /*159*/:
            case ID_PIXEL_WIDTH /*176*/:
            case ID_CUE_TIME /*179*/:
            case ID_PIXEL_HEIGHT /*186*/:
            case 215:
            case ID_TIME_CODE /*231*/:
            case ID_BLOCK_ADD_ID /*238*/:
            case ID_CUE_CLUSTER_POSITION /*241*/:
            case 251:
            case ID_BLOCK_ADD_ID_TYPE /*16871*/:
            case ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
            case ID_DOC_TYPE_READ_VERSION /*17029*/:
            case ID_EBML_READ_VERSION /*17143*/:
            case ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
            case ID_CONTENT_ENCODING_ORDER /*20529*/:
            case ID_CONTENT_ENCODING_SCOPE /*20530*/:
            case ID_SEEK_POSITION /*21420*/:
            case ID_STEREO_MODE /*21432*/:
            case ID_DISPLAY_WIDTH /*21680*/:
            case ID_DISPLAY_UNIT /*21682*/:
            case ID_DISPLAY_HEIGHT /*21690*/:
            case ID_FLAG_FORCED /*21930*/:
            case ID_COLOUR_RANGE /*21945*/:
            case ID_COLOUR_TRANSFER /*21946*/:
            case ID_COLOUR_PRIMARIES /*21947*/:
            case ID_MAX_CLL /*21948*/:
            case ID_MAX_FALL /*21949*/:
            case ID_MAX_BLOCK_ADDITION_ID /*21998*/:
            case ID_CODEC_DELAY /*22186*/:
            case ID_SEEK_PRE_ROLL /*22203*/:
            case ID_AUDIO_BIT_DEPTH /*25188*/:
            case ID_PROJECTION_TYPE /*30321*/:
            case ID_DEFAULT_DURATION /*2352003*/:
            case ID_TIMECODE_SCALE /*2807729*/:
                return 2;
            case 134:
            case 17026:
            case ID_NAME /*21358*/:
            case ID_LANGUAGE /*2274716*/:
                return 3;
            case 160:
            case 166:
            case ID_TRACK_ENTRY /*174*/:
            case 183:
            case ID_CUE_POINT /*187*/:
            case 224:
            case 225:
            case ID_BLOCK_ADDITION_MAPPING /*16868*/:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS /*18407*/:
            case ID_SEEK /*19899*/:
            case ID_CONTENT_COMPRESSION /*20532*/:
            case ID_CONTENT_ENCRYPTION /*20533*/:
            case ID_COLOUR /*21936*/:
            case ID_MASTERING_METADATA /*21968*/:
            case ID_CONTENT_ENCODING /*25152*/:
            case ID_CONTENT_ENCODINGS /*28032*/:
            case ID_BLOCK_ADDITIONS /*30113*/:
            case ID_PROJECTION /*30320*/:
            case ID_SEEK_HEAD /*290298740*/:
            case 357149030:
            case ID_TRACKS /*374648427*/:
            case ID_SEGMENT /*408125543*/:
            case ID_EBML /*440786851*/:
            case ID_CUES /*475249515*/:
            case ID_CLUSTER /*524531317*/:
                return 1;
            case ID_BLOCK /*161*/:
            case ID_SIMPLE_BLOCK /*163*/:
            case ID_BLOCK_ADDITIONAL /*165*/:
            case ID_BLOCK_ADD_ID_EXTRA_DATA /*16877*/:
            case ID_CONTENT_COMPRESSION_SETTINGS /*16981*/:
            case ID_CONTENT_ENCRYPTION_KEY_ID /*18402*/:
            case ID_SEEK_ID /*21419*/:
            case ID_CODEC_PRIVATE /*25506*/:
            case ID_PROJECTION_PRIVATE /*30322*/:
                return 4;
            case 181:
            case ID_DURATION /*17545*/:
            case ID_PRIMARY_R_CHROMATICITY_X /*21969*/:
            case ID_PRIMARY_R_CHROMATICITY_Y /*21970*/:
            case ID_PRIMARY_G_CHROMATICITY_X /*21971*/:
            case ID_PRIMARY_G_CHROMATICITY_Y /*21972*/:
            case ID_PRIMARY_B_CHROMATICITY_X /*21973*/:
            case ID_PRIMARY_B_CHROMATICITY_Y /*21974*/:
            case ID_WHITE_POINT_CHROMATICITY_X /*21975*/:
            case ID_WHITE_POINT_CHROMATICITY_Y /*21976*/:
            case ID_LUMNINANCE_MAX /*21977*/:
            case ID_LUMNINANCE_MIN /*21978*/:
            case ID_PROJECTION_POSE_YAW /*30323*/:
            case ID_PROJECTION_POSE_PITCH /*30324*/:
            case ID_PROJECTION_POSE_ROLL /*30325*/:
                return 5;
            default:
                return 0;
        }
    }

    public void handleBlockAddIDExtraData(Track track, ExtractorInput extractorInput, int i11) throws IOException {
        if (track.blockAddIdType == 1685485123 || track.blockAddIdType == 1685480259) {
            byte[] bArr = new byte[i11];
            track.dolbyVisionConfigBytes = bArr;
            extractorInput.readFully(bArr, 0, i11);
            return;
        }
        extractorInput.skipFully(i11);
    }

    public void handleBlockAdditionalData(Track track, int i11, ExtractorInput extractorInput, int i12) throws IOException {
        if (i11 != 4 || !CODEC_ID_VP9.equals(track.codecId)) {
            extractorInput.skipFully(i12);
            return;
        }
        this.blockAdditionalData.reset(i12);
        extractorInput.readFully(this.blockAdditionalData.getData(), 0, i12);
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public void integerElement(int i11, long j11) throws ParserException {
        if (i11 != ID_CONTENT_ENCODING_ORDER) {
            if (i11 != ID_CONTENT_ENCODING_SCOPE) {
                boolean z11 = false;
                switch (i11) {
                    case 131:
                        getCurrentTrack(i11).type = (int) j11;
                        return;
                    case 136:
                        Track currentTrack2 = getCurrentTrack(i11);
                        if (j11 == 1) {
                            z11 = true;
                        }
                        currentTrack2.flagDefault = z11;
                        return;
                    case ID_BLOCK_DURATION /*155*/:
                        this.blockDurationUs = scaleTimecodeToUs(j11);
                        return;
                    case ID_CHANNELS /*159*/:
                        getCurrentTrack(i11).channelCount = (int) j11;
                        return;
                    case ID_PIXEL_WIDTH /*176*/:
                        getCurrentTrack(i11).width = (int) j11;
                        return;
                    case ID_CUE_TIME /*179*/:
                        assertInCues(i11);
                        this.cueTimesUs.add(scaleTimecodeToUs(j11));
                        return;
                    case ID_PIXEL_HEIGHT /*186*/:
                        getCurrentTrack(i11).height = (int) j11;
                        return;
                    case 215:
                        getCurrentTrack(i11).number = (int) j11;
                        return;
                    case ID_TIME_CODE /*231*/:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j11);
                        return;
                    case ID_BLOCK_ADD_ID /*238*/:
                        this.blockAdditionalId = (int) j11;
                        return;
                    case ID_CUE_CLUSTER_POSITION /*241*/:
                        if (!this.seenClusterPositionForCurrentCuePoint) {
                            assertInCues(i11);
                            this.cueClusterPositions.add(j11);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        return;
                    case 251:
                        this.blockHasReferenceBlock = true;
                        return;
                    case ID_BLOCK_ADD_ID_TYPE /*16871*/:
                        int unused = getCurrentTrack(i11).blockAddIdType = (int) j11;
                        return;
                    case ID_CONTENT_COMPRESSION_ALGORITHM /*16980*/:
                        if (j11 != 3) {
                            StringBuilder sb2 = new StringBuilder(50);
                            sb2.append("ContentCompAlgo ");
                            sb2.append(j11);
                            sb2.append(" not supported");
                            throw new ParserException(sb2.toString());
                        }
                        return;
                    case ID_DOC_TYPE_READ_VERSION /*17029*/:
                        if (j11 < 1 || j11 > 2) {
                            StringBuilder sb3 = new StringBuilder(53);
                            sb3.append("DocTypeReadVersion ");
                            sb3.append(j11);
                            sb3.append(" not supported");
                            throw new ParserException(sb3.toString());
                        }
                        return;
                    case ID_EBML_READ_VERSION /*17143*/:
                        if (j11 != 1) {
                            StringBuilder sb4 = new StringBuilder(50);
                            sb4.append("EBMLReadVersion ");
                            sb4.append(j11);
                            sb4.append(" not supported");
                            throw new ParserException(sb4.toString());
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_ALGORITHM /*18401*/:
                        if (j11 != 5) {
                            StringBuilder sb5 = new StringBuilder(49);
                            sb5.append("ContentEncAlgo ");
                            sb5.append(j11);
                            sb5.append(" not supported");
                            throw new ParserException(sb5.toString());
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /*18408*/:
                        if (j11 != 1) {
                            StringBuilder sb6 = new StringBuilder(56);
                            sb6.append("AESSettingsCipherMode ");
                            sb6.append(j11);
                            sb6.append(" not supported");
                            throw new ParserException(sb6.toString());
                        }
                        return;
                    case ID_SEEK_POSITION /*21420*/:
                        this.seekEntryPosition = j11 + this.segmentContentPosition;
                        return;
                    case ID_STEREO_MODE /*21432*/:
                        int i12 = (int) j11;
                        assertInTrackEntry(i11);
                        if (i12 == 0) {
                            this.currentTrack.stereoMode = 0;
                            return;
                        } else if (i12 == 1) {
                            this.currentTrack.stereoMode = 2;
                            return;
                        } else if (i12 == 3) {
                            this.currentTrack.stereoMode = 1;
                            return;
                        } else if (i12 == 15) {
                            this.currentTrack.stereoMode = 3;
                            return;
                        } else {
                            return;
                        }
                    case ID_DISPLAY_WIDTH /*21680*/:
                        getCurrentTrack(i11).displayWidth = (int) j11;
                        return;
                    case ID_DISPLAY_UNIT /*21682*/:
                        getCurrentTrack(i11).displayUnit = (int) j11;
                        return;
                    case ID_DISPLAY_HEIGHT /*21690*/:
                        getCurrentTrack(i11).displayHeight = (int) j11;
                        return;
                    case ID_FLAG_FORCED /*21930*/:
                        Track currentTrack3 = getCurrentTrack(i11);
                        if (j11 == 1) {
                            z11 = true;
                        }
                        currentTrack3.flagForced = z11;
                        return;
                    case ID_MAX_BLOCK_ADDITION_ID /*21998*/:
                        getCurrentTrack(i11).maxBlockAdditionId = (int) j11;
                        return;
                    case ID_CODEC_DELAY /*22186*/:
                        getCurrentTrack(i11).codecDelayNs = j11;
                        return;
                    case ID_SEEK_PRE_ROLL /*22203*/:
                        getCurrentTrack(i11).seekPreRollNs = j11;
                        return;
                    case ID_AUDIO_BIT_DEPTH /*25188*/:
                        getCurrentTrack(i11).audioBitDepth = (int) j11;
                        return;
                    case ID_PROJECTION_TYPE /*30321*/:
                        assertInTrackEntry(i11);
                        int i13 = (int) j11;
                        if (i13 == 0) {
                            this.currentTrack.projectionType = 0;
                            return;
                        } else if (i13 == 1) {
                            this.currentTrack.projectionType = 1;
                            return;
                        } else if (i13 == 2) {
                            this.currentTrack.projectionType = 2;
                            return;
                        } else if (i13 == 3) {
                            this.currentTrack.projectionType = 3;
                            return;
                        } else {
                            return;
                        }
                    case ID_DEFAULT_DURATION /*2352003*/:
                        getCurrentTrack(i11).defaultSampleDurationNs = (int) j11;
                        return;
                    case ID_TIMECODE_SCALE /*2807729*/:
                        this.timecodeScale = j11;
                        return;
                    default:
                        switch (i11) {
                            case ID_COLOUR_RANGE /*21945*/:
                                assertInTrackEntry(i11);
                                int i14 = (int) j11;
                                if (i14 == 1) {
                                    this.currentTrack.colorRange = 2;
                                    return;
                                } else if (i14 == 2) {
                                    this.currentTrack.colorRange = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_COLOUR_TRANSFER /*21946*/:
                                assertInTrackEntry(i11);
                                int i15 = (int) j11;
                                if (i15 != 1) {
                                    if (i15 == 16) {
                                        this.currentTrack.colorTransfer = 6;
                                        return;
                                    } else if (i15 == 18) {
                                        this.currentTrack.colorTransfer = 7;
                                        return;
                                    } else if (!(i15 == 6 || i15 == 7)) {
                                        return;
                                    }
                                }
                                this.currentTrack.colorTransfer = 3;
                                return;
                            case ID_COLOUR_PRIMARIES /*21947*/:
                                assertInTrackEntry(i11);
                                Track track = this.currentTrack;
                                track.hasColorInfo = true;
                                int i16 = (int) j11;
                                if (i16 == 1) {
                                    track.colorSpace = 1;
                                    return;
                                } else if (i16 == 9) {
                                    track.colorSpace = 6;
                                    return;
                                } else if (i16 == 4 || i16 == 5 || i16 == 6 || i16 == 7) {
                                    track.colorSpace = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case ID_MAX_CLL /*21948*/:
                                getCurrentTrack(i11).maxContentLuminance = (int) j11;
                                return;
                            case ID_MAX_FALL /*21949*/:
                                getCurrentTrack(i11).maxFrameAverageLuminance = (int) j11;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j11 != 1) {
                StringBuilder sb7 = new StringBuilder(55);
                sb7.append("ContentEncodingScope ");
                sb7.append(j11);
                sb7.append(" not supported");
                throw new ParserException(sb7.toString());
            }
        } else if (j11 != 0) {
            StringBuilder sb8 = new StringBuilder(55);
            sb8.append("ContentEncodingOrder ");
            sb8.append(j11);
            sb8.append(" not supported");
            throw new ParserException(sb8.toString());
        }
    }

    public boolean isLevel1Element(int i11) {
        return i11 == 357149030 || i11 == ID_CLUSTER || i11 == ID_CUES || i11 == ID_TRACKS;
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        this.haveOutputSample = false;
        boolean z11 = true;
        while (z11 && !this.haveOutputSample) {
            z11 = this.reader.read(extractorInput);
            if (z11 && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z11) {
            return 0;
        }
        for (int i11 = 0; i11 < this.tracks.size(); i11++) {
            Track valueAt = this.tracks.valueAt(i11);
            valueAt.assertOutputInitialized();
            valueAt.outputPendingSampleMetadata();
        }
        return -1;
    }

    public final void release() {
    }

    public void seek(long j11, long j12) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetWriteSampleData();
        for (int i11 = 0; i11 < this.tracks.size(); i11++) {
            this.tracks.valueAt(i11).reset();
        }
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException {
        return new Sniffer().sniff(extractorInput);
    }

    public void startMasterElement(int i11, long j11, long j12) throws ParserException {
        assertInitialized();
        if (i11 == 160) {
            this.blockHasReferenceBlock = false;
        } else if (i11 == ID_TRACK_ENTRY) {
            this.currentTrack = new Track();
        } else if (i11 == ID_CUE_POINT) {
            this.seenClusterPositionForCurrentCuePoint = false;
        } else if (i11 == ID_SEEK) {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1;
        } else if (i11 == ID_CONTENT_ENCRYPTION) {
            getCurrentTrack(i11).hasContentEncryption = true;
        } else if (i11 == ID_MASTERING_METADATA) {
            getCurrentTrack(i11).hasColorInfo = true;
        } else if (i11 == ID_SEGMENT) {
            long j13 = this.segmentContentPosition;
            if (j13 == -1 || j13 == j11) {
                this.segmentContentPosition = j11;
                this.segmentContentSize = j12;
                return;
            }
            throw new ParserException("Multiple Segment elements not supported");
        } else if (i11 == ID_CUES) {
            this.cueTimesUs = new LongArray();
            this.cueClusterPositions = new LongArray();
        } else if (i11 != ID_CLUSTER || this.sentSeekMap) {
        } else {
            if (!this.seekForCuesEnabled || this.cuesContentPosition == -1) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                this.sentSeekMap = true;
                return;
            }
            this.seekForCues = true;
        }
    }

    public void stringElement(int i11, String str) throws ParserException {
        if (i11 == 134) {
            getCurrentTrack(i11).codecId = str;
        } else if (i11 != 17026) {
            if (i11 == ID_NAME) {
                getCurrentTrack(i11).name = str;
            } else if (i11 == ID_LANGUAGE) {
                String unused = getCurrentTrack(i11).language = str;
            }
        } else if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
            sb2.append("DocType ");
            sb2.append(str);
            sb2.append(" not supported");
            throw new ParserException(sb2.toString());
        }
    }

    public MatroskaExtractor(int i11) {
        this(new DefaultEbmlReader(), i11);
    }

    public MatroskaExtractor(EbmlReader ebmlReader, int i11) {
        this.segmentContentPosition = -1;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1;
        this.seekPositionAfterBuildingCues = -1;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlProcessor());
        this.seekForCuesEnabled = (i11 & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.blockAdditionalData = new ParsableByteArray();
        this.blockSampleSizes = new int[1];
    }
}
