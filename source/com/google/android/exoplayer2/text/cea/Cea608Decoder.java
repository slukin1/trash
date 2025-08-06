package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.base.Ascii;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.sf.scuba.smartcards.ISO7816;

public final class Cea608Decoder extends CeaDecoder {
    private static final int[] BASIC_CHARACTER_SET = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 209, 241, 9632};
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_FLAG = 4;
    private static final int[] COLUMN_INDICES = {0, 4, 8, 12, 16, 20, 24, 28};
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 47;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 32;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_RESUME_TEXT_DISPLAY = 43;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final byte CTRL_TEXT_RESTART = 42;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    public static final long MIN_DATA_CHANNEL_TIMEOUT_MS = 16000;
    private static final int NTSC_CC_CHANNEL_1 = 0;
    private static final int NTSC_CC_CHANNEL_2 = 1;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final boolean[] ODD_PARITY_BYTE_TABLE = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    private static final int[] ROW_INDICES = {11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] SPECIAL_CHARACTER_SET = {174, 176, PsExtractor.PRIVATE_STREAM_1, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 251};
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 199, 200, 202, 203, 235, 206, 207, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 212, 217, 249, 219, 171, 187};
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = {TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, 227, 205, 204, 236, 210, 242, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    /* access modifiers changed from: private */
    public static final int[] STYLE_COLORS = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private static final String TAG = "Cea608Decoder";
    private int captionMode;
    private int captionRowCount;
    private final ParsableByteArray ccData = new ParsableByteArray();
    private final ArrayList<CueBuilder> cueBuilders = new ArrayList<>();
    private List<Cue> cues;
    private int currentChannel = 0;
    private CueBuilder currentCueBuilder = new CueBuilder(0, 4);
    private boolean isCaptionValid;
    private boolean isInCaptionService;
    private long lastCueUpdateUs;
    private List<Cue> lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedChannel;
    private final int selectedField;
    private final long validDataChannelTimeoutUs;

    public static final class CueBuilder {
        private static final int BASE_ROW = 15;
        private static final int SCREEN_CHARWIDTH = 32;
        private int captionMode;
        private int captionRowCount;
        private final StringBuilder captionStringBuilder = new StringBuilder();
        private final List<CueStyle> cueStyles = new ArrayList();
        /* access modifiers changed from: private */
        public int indent;
        private final List<SpannableString> rolledUpCaptions = new ArrayList();
        /* access modifiers changed from: private */
        public int row;
        /* access modifiers changed from: private */
        public int tabOffset;

        public static class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int i11, boolean z11, int i12) {
                this.style = i11;
                this.underline = z11;
                this.start = i12;
            }
        }

        public CueBuilder(int i11, int i12) {
            reset(i11);
            this.captionRowCount = i12;
        }

        private SpannableString buildCurrentLine() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.captionStringBuilder);
            int length = spannableStringBuilder.length();
            int i11 = 0;
            int i12 = 0;
            boolean z11 = false;
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            while (i11 < this.cueStyles.size()) {
                CueStyle cueStyle = this.cueStyles.get(i11);
                boolean z12 = cueStyle.underline;
                int i17 = cueStyle.style;
                if (i17 != 8) {
                    boolean z13 = i17 == 7;
                    if (i17 != 7) {
                        i16 = Cea608Decoder.STYLE_COLORS[i17];
                    }
                    z11 = z13;
                }
                int i18 = cueStyle.start;
                i11++;
                if (i18 != (i11 < this.cueStyles.size() ? this.cueStyles.get(i11).start : length)) {
                    if (i13 != -1 && !z12) {
                        setUnderlineSpan(spannableStringBuilder, i13, i18);
                        i13 = -1;
                    } else if (i13 == -1 && z12) {
                        i13 = i18;
                    }
                    if (i14 != -1 && !z11) {
                        setItalicSpan(spannableStringBuilder, i14, i18);
                        i14 = -1;
                    } else if (i14 == -1 && z11) {
                        i14 = i18;
                    }
                    if (i16 != i15) {
                        setColorSpan(spannableStringBuilder, i12, i18, i15);
                        i15 = i16;
                        i12 = i18;
                    }
                }
            }
            if (!(i13 == -1 || i13 == length)) {
                setUnderlineSpan(spannableStringBuilder, i13, length);
            }
            if (!(i14 == -1 || i14 == length)) {
                setItalicSpan(spannableStringBuilder, i14, length);
            }
            if (i12 != length) {
                setColorSpan(spannableStringBuilder, i12, length, i15);
            }
            return new SpannableString(spannableStringBuilder);
        }

        private static void setColorSpan(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13) {
            if (i13 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i13), i11, i12, 33);
            }
        }

        private static void setItalicSpan(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i11, i12, 33);
        }

        private static void setUnderlineSpan(SpannableStringBuilder spannableStringBuilder, int i11, int i12) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i11, i12, 33);
        }

        public void append(char c11) {
            if (this.captionStringBuilder.length() < 32) {
                this.captionStringBuilder.append(c11);
            }
        }

        public void backspace() {
            int length = this.captionStringBuilder.length();
            if (length > 0) {
                this.captionStringBuilder.delete(length - 1, length);
                int size = this.cueStyles.size() - 1;
                while (size >= 0) {
                    CueStyle cueStyle = this.cueStyles.get(size);
                    int i11 = cueStyle.start;
                    if (i11 == length) {
                        cueStyle.start = i11 - 1;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public Cue build(int i11) {
            float f11;
            int i12 = this.indent + this.tabOffset;
            int i13 = 32 - i12;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i14 = 0; i14 < this.rolledUpCaptions.size(); i14++) {
                spannableStringBuilder.append(Util.truncateAscii(this.rolledUpCaptions.get(i14), i13));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(Util.truncateAscii(buildCurrentLine(), i13));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i13 - spannableStringBuilder.length();
            int i15 = i12 - length;
            if (i11 == Integer.MIN_VALUE) {
                if (this.captionMode != 2 || (Math.abs(i15) >= 3 && length >= 0)) {
                    i11 = (this.captionMode != 2 || i15 <= 0) ? 0 : 2;
                } else {
                    i11 = 1;
                }
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    i12 = 32 - length;
                }
                f11 = ((((float) i12) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f11 = 0.5f;
            }
            int i16 = this.row;
            if (i16 > 7) {
                i16 = (i16 - 15) - 2;
            } else if (this.captionMode == 1) {
                i16 -= this.captionRowCount - 1;
            }
            return new Cue.Builder().setText(spannableStringBuilder).setTextAlignment(Layout.Alignment.ALIGN_NORMAL).setLine((float) i16, 1).setPosition(f11).setPositionAnchor(i11).build();
        }

        public boolean isEmpty() {
            return this.cueStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }

        public void reset(int i11) {
            this.captionMode = i11;
            this.cueStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
        }

        public void rollUp() {
            this.rolledUpCaptions.add(buildCurrentLine());
            this.captionStringBuilder.setLength(0);
            this.cueStyles.clear();
            int min = Math.min(this.captionRowCount, this.row);
            while (this.rolledUpCaptions.size() >= min) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setCaptionMode(int i11) {
            this.captionMode = i11;
        }

        public void setCaptionRowCount(int i11) {
            this.captionRowCount = i11;
        }

        public void setStyle(int i11, boolean z11) {
            this.cueStyles.add(new CueStyle(i11, z11, this.captionStringBuilder.length()));
        }
    }

    public Cea608Decoder(String str, int i11, long j11) {
        this.validDataChannelTimeoutUs = j11 > 0 ? j11 * 1000 : -9223372036854775807L;
        this.packetLength = MimeTypes.APPLICATION_MP4CEA608.equals(str) ? 2 : 3;
        if (i11 == 1) {
            this.selectedChannel = 0;
            this.selectedField = 0;
        } else if (i11 == 2) {
            this.selectedChannel = 1;
            this.selectedField = 0;
        } else if (i11 == 3) {
            this.selectedChannel = 0;
            this.selectedField = 1;
        } else if (i11 != 4) {
            Log.w(TAG, "Invalid channel. Defaulting to CC1.");
            this.selectedChannel = 0;
            this.selectedField = 0;
        } else {
            this.selectedChannel = 1;
            this.selectedField = 1;
        }
        setCaptionMode(0);
        resetCueBuilders();
        this.isInCaptionService = true;
        this.lastCueUpdateUs = -9223372036854775807L;
    }

    private static char getBasicChar(byte b11) {
        return (char) BASIC_CHARACTER_SET[(b11 & Ascii.DEL) + ISO7816.INS_CREATE_FILE];
    }

    private static int getChannel(byte b11) {
        return (b11 >> 3) & 1;
    }

    private List<Cue> getDisplayCues() {
        int size = this.cueBuilders.size();
        ArrayList arrayList = new ArrayList(size);
        int i11 = 2;
        for (int i12 = 0; i12 < size; i12++) {
            Cue build = this.cueBuilders.get(i12).build(Integer.MIN_VALUE);
            arrayList.add(build);
            if (build != null) {
                i11 = Math.min(i11, build.positionAnchor);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i13 = 0; i13 < size; i13++) {
            Cue cue = (Cue) arrayList.get(i13);
            if (cue != null) {
                if (cue.positionAnchor != i11) {
                    cue = (Cue) Assertions.checkNotNull(this.cueBuilders.get(i13).build(i11));
                }
                arrayList2.add(cue);
            }
        }
        return arrayList2;
    }

    private static char getExtendedEsFrChar(byte b11) {
        return (char) SPECIAL_ES_FR_CHARACTER_SET[b11 & Ascii.US];
    }

    private static char getExtendedPtDeChar(byte b11) {
        return (char) SPECIAL_PT_DE_CHARACTER_SET[b11 & Ascii.US];
    }

    private static char getExtendedWestEuropeanChar(byte b11, byte b12) {
        if ((b11 & 1) == 0) {
            return getExtendedEsFrChar(b12);
        }
        return getExtendedPtDeChar(b12);
    }

    private static char getSpecialNorthAmericanChar(byte b11) {
        return (char) SPECIAL_CHARACTER_SET[b11 & 15];
    }

    private void handleMidrowCtrl(byte b11) {
        this.currentCueBuilder.append(' ');
        this.currentCueBuilder.setStyle((b11 >> 1) & 7, (b11 & 1) == 1);
    }

    private void handleMiscCode(byte b11) {
        if (b11 == 32) {
            setCaptionMode(2);
        } else if (b11 != 41) {
            switch (b11) {
                case 37:
                    setCaptionMode(1);
                    setCaptionRowCount(2);
                    return;
                case 38:
                    setCaptionMode(1);
                    setCaptionRowCount(3);
                    return;
                case 39:
                    setCaptionMode(1);
                    setCaptionRowCount(4);
                    return;
                default:
                    int i11 = this.captionMode;
                    if (i11 != 0) {
                        if (b11 != 33) {
                            switch (b11) {
                                case 44:
                                    this.cues = Collections.emptyList();
                                    int i12 = this.captionMode;
                                    if (i12 == 1 || i12 == 3) {
                                        resetCueBuilders();
                                        return;
                                    }
                                    return;
                                case 45:
                                    if (i11 == 1 && !this.currentCueBuilder.isEmpty()) {
                                        this.currentCueBuilder.rollUp();
                                        return;
                                    }
                                    return;
                                case 46:
                                    resetCueBuilders();
                                    return;
                                case 47:
                                    this.cues = getDisplayCues();
                                    resetCueBuilders();
                                    return;
                                default:
                                    return;
                            }
                        } else {
                            this.currentCueBuilder.backspace();
                            return;
                        }
                    } else {
                        return;
                    }
            }
        } else {
            setCaptionMode(3);
        }
    }

    private void handlePreambleAddressCode(byte b11, byte b12) {
        int i11 = ROW_INDICES[b11 & 7];
        boolean z11 = false;
        if ((b12 & 32) != 0) {
            i11++;
        }
        if (i11 != this.currentCueBuilder.row) {
            if (this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cueBuilder = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cueBuilder;
                this.cueBuilders.add(cueBuilder);
            }
            int unused = this.currentCueBuilder.row = i11;
        }
        boolean z12 = (b12 & 16) == 16;
        if ((b12 & 1) == 1) {
            z11 = true;
        }
        int i12 = (b12 >> 1) & 7;
        this.currentCueBuilder.setStyle(z12 ? 8 : i12, z11);
        if (z12) {
            int unused2 = this.currentCueBuilder.indent = COLUMN_INDICES[i12];
        }
    }

    private static boolean isCtrlCode(byte b11) {
        return (b11 & ISO7816.INS_CREATE_FILE) == 0;
    }

    private static boolean isExtendedWestEuropeanChar(byte b11, byte b12) {
        return (b11 & 246) == 18 && (b12 & ISO7816.INS_CREATE_FILE) == 32;
    }

    private static boolean isMidrowCtrlCode(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 32;
    }

    private static boolean isMiscCode(byte b11, byte b12) {
        return (b11 & 246) == 20 && (b12 & 240) == 32;
    }

    private static boolean isPreambleAddressCode(byte b11, byte b12) {
        return (b11 & 240) == 16 && (b12 & ISO7816.INS_GET_RESPONSE) == 64;
    }

    private static boolean isRepeatable(byte b11) {
        return (b11 & 240) == 16;
    }

    private boolean isRepeatedCommand(boolean z11, byte b11, byte b12) {
        if (!z11 || !isRepeatable(b11)) {
            this.repeatableControlSet = false;
        } else if (this.repeatableControlSet && this.repeatableControlCc1 == b11 && this.repeatableControlCc2 == b12) {
            this.repeatableControlSet = false;
            return true;
        } else {
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b11;
            this.repeatableControlCc2 = b12;
        }
        return false;
    }

    private static boolean isServiceSwitchCommand(byte b11) {
        return (b11 & 247) == 20;
    }

    private static boolean isSpecialNorthAmericanChar(byte b11, byte b12) {
        return (b11 & 247) == 17 && (b12 & 240) == 48;
    }

    private static boolean isTabCtrlCode(byte b11, byte b12) {
        return (b11 & 247) == 23 && b12 >= 33 && b12 <= 35;
    }

    private static boolean isXdsControlCode(byte b11) {
        return 1 <= b11 && b11 <= 15;
    }

    private void maybeUpdateIsInCaptionService(byte b11, byte b12) {
        if (isXdsControlCode(b11)) {
            this.isInCaptionService = false;
        } else if (isServiceSwitchCommand(b11)) {
            if (!(b12 == 32 || b12 == 47)) {
                switch (b12) {
                    case 37:
                    case 38:
                    case 39:
                        break;
                    default:
                        switch (b12) {
                            case 41:
                                break;
                            case 42:
                            case 43:
                                this.isInCaptionService = false;
                                return;
                            default:
                                return;
                        }
                }
            }
            this.isInCaptionService = true;
        }
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private void setCaptionMode(int i11) {
        int i12 = this.captionMode;
        if (i12 != i11) {
            this.captionMode = i11;
            if (i11 == 3) {
                for (int i13 = 0; i13 < this.cueBuilders.size(); i13++) {
                    this.cueBuilders.get(i13).setCaptionMode(i11);
                }
                return;
            }
            resetCueBuilders();
            if (i12 == 3 || i11 == 1 || i11 == 0) {
                this.cues = Collections.emptyList();
            }
        }
    }

    private void setCaptionRowCount(int i11) {
        this.captionRowCount = i11;
        this.currentCueBuilder.setCaptionRowCount(i11);
    }

    private boolean shouldClearStuckCaptions() {
        if (this.validDataChannelTimeoutUs == -9223372036854775807L || this.lastCueUpdateUs == -9223372036854775807L || getPositionUs() - this.lastCueUpdateUs < this.validDataChannelTimeoutUs) {
            return false;
        }
        return true;
    }

    private boolean updateAndVerifyCurrentChannel(byte b11) {
        if (isCtrlCode(b11)) {
            this.currentChannel = getChannel(b11);
        }
        return this.currentChannel == this.selectedChannel;
    }

    public Subtitle createSubtitle() {
        List<Cue> list = this.cues;
        this.lastCues = list;
        return new CeaSubtitle((List) Assertions.checkNotNull(list));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0018 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decode(com.google.android.exoplayer2.text.SubtitleInputBuffer r10) {
        /*
            r9 = this;
            java.nio.ByteBuffer r10 = r10.data
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r9.ccData
            byte[] r1 = r10.array()
            int r10 = r10.limit()
            r0.reset(r1, r10)
            r10 = 0
            r0 = 1
            r1 = r10
        L_0x0018:
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r9.ccData
            int r2 = r2.bytesLeft()
            int r3 = r9.packetLength
            if (r2 < r3) goto L_0x00f6
            r2 = 2
            if (r3 != r2) goto L_0x0027
            r2 = -4
            goto L_0x002e
        L_0x0027:
            com.google.android.exoplayer2.util.ParsableByteArray r2 = r9.ccData
            int r2 = r2.readUnsignedByte()
            byte r2 = (byte) r2
        L_0x002e:
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r9.ccData
            int r3 = r3.readUnsignedByte()
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r9.ccData
            int r4 = r4.readUnsignedByte()
            r5 = r2 & 2
            if (r5 == 0) goto L_0x003f
            goto L_0x0018
        L_0x003f:
            r5 = r2 & 1
            int r6 = r9.selectedField
            if (r5 == r6) goto L_0x0046
            goto L_0x0018
        L_0x0046:
            r5 = r3 & 127(0x7f, float:1.78E-43)
            byte r5 = (byte) r5
            r6 = r4 & 127(0x7f, float:1.78E-43)
            byte r6 = (byte) r6
            if (r5 != 0) goto L_0x0051
            if (r6 != 0) goto L_0x0051
            goto L_0x0018
        L_0x0051:
            boolean r7 = r9.isCaptionValid
            r2 = r2 & 4
            r8 = 4
            if (r2 != r8) goto L_0x0064
            boolean[] r2 = ODD_PARITY_BYTE_TABLE
            boolean r3 = r2[r3]
            if (r3 == 0) goto L_0x0064
            boolean r2 = r2[r4]
            if (r2 == 0) goto L_0x0064
            r2 = r0
            goto L_0x0065
        L_0x0064:
            r2 = r10
        L_0x0065:
            r9.isCaptionValid = r2
            boolean r2 = r9.isRepeatedCommand(r2, r5, r6)
            if (r2 == 0) goto L_0x006e
            goto L_0x0018
        L_0x006e:
            boolean r2 = r9.isCaptionValid
            if (r2 != 0) goto L_0x0079
            if (r7 == 0) goto L_0x0018
            r9.resetCueBuilders()
        L_0x0077:
            r1 = r0
            goto L_0x0018
        L_0x0079:
            r9.maybeUpdateIsInCaptionService(r5, r6)
            boolean r2 = r9.isInCaptionService
            if (r2 != 0) goto L_0x0081
            goto L_0x0018
        L_0x0081:
            boolean r2 = r9.updateAndVerifyCurrentChannel(r5)
            if (r2 != 0) goto L_0x0088
            goto L_0x0018
        L_0x0088:
            boolean r1 = isCtrlCode(r5)
            if (r1 == 0) goto L_0x00df
            boolean r1 = isSpecialNorthAmericanChar(r5, r6)
            if (r1 == 0) goto L_0x009e
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r1 = r9.currentCueBuilder
            char r2 = getSpecialNorthAmericanChar(r6)
            r1.append(r2)
            goto L_0x0077
        L_0x009e:
            boolean r1 = isExtendedWestEuropeanChar(r5, r6)
            if (r1 == 0) goto L_0x00b3
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r1 = r9.currentCueBuilder
            r1.backspace()
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r1 = r9.currentCueBuilder
            char r2 = getExtendedWestEuropeanChar(r5, r6)
            r1.append(r2)
            goto L_0x0077
        L_0x00b3:
            boolean r1 = isMidrowCtrlCode(r5, r6)
            if (r1 == 0) goto L_0x00bd
            r9.handleMidrowCtrl(r6)
            goto L_0x0077
        L_0x00bd:
            boolean r1 = isPreambleAddressCode(r5, r6)
            if (r1 == 0) goto L_0x00c7
            r9.handlePreambleAddressCode(r5, r6)
            goto L_0x0077
        L_0x00c7:
            boolean r1 = isTabCtrlCode(r5, r6)
            if (r1 == 0) goto L_0x00d5
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r1 = r9.currentCueBuilder
            int r6 = r6 + -32
            int unused = r1.tabOffset = r6
            goto L_0x0077
        L_0x00d5:
            boolean r1 = isMiscCode(r5, r6)
            if (r1 == 0) goto L_0x0077
            r9.handleMiscCode(r6)
            goto L_0x0077
        L_0x00df:
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r1 = r9.currentCueBuilder
            char r2 = getBasicChar(r5)
            r1.append(r2)
            r1 = r6 & 224(0xe0, float:3.14E-43)
            if (r1 == 0) goto L_0x0077
            com.google.android.exoplayer2.text.cea.Cea608Decoder$CueBuilder r1 = r9.currentCueBuilder
            char r2 = getBasicChar(r6)
            r1.append(r2)
            goto L_0x0077
        L_0x00f6:
            if (r1 == 0) goto L_0x010b
            int r10 = r9.captionMode
            if (r10 == r0) goto L_0x00ff
            r0 = 3
            if (r10 != r0) goto L_0x010b
        L_0x00ff:
            java.util.List r10 = r9.getDisplayCues()
            r9.cues = r10
            long r0 = r9.getPositionUs()
            r9.lastCueUpdateUs = r0
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.cea.Cea608Decoder.decode(com.google.android.exoplayer2.text.SubtitleInputBuffer):void");
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer dequeueInputBuffer() throws SubtitleDecoderException {
        return super.dequeueInputBuffer();
    }

    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        setCaptionMode(0);
        setCaptionRowCount(4);
        resetCueBuilders();
        this.isCaptionValid = false;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = 0;
        this.repeatableControlCc2 = 0;
        this.currentChannel = 0;
        this.isInCaptionService = true;
        this.lastCueUpdateUs = -9223372036854775807L;
    }

    public String getName() {
        return TAG;
    }

    public boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    public /* bridge */ /* synthetic */ void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer) throws SubtitleDecoderException {
        super.queueInputBuffer(subtitleInputBuffer);
    }

    public void release() {
    }

    public /* bridge */ /* synthetic */ void setPositionUs(long j11) {
        super.setPositionUs(j11);
    }

    public SubtitleOutputBuffer dequeueOutputBuffer() throws SubtitleDecoderException {
        SubtitleOutputBuffer availableOutputBuffer;
        SubtitleOutputBuffer dequeueOutputBuffer = super.dequeueOutputBuffer();
        if (dequeueOutputBuffer != null) {
            return dequeueOutputBuffer;
        }
        if (!shouldClearStuckCaptions() || (availableOutputBuffer = getAvailableOutputBuffer()) == null) {
            return null;
        }
        this.cues = Collections.emptyList();
        this.lastCueUpdateUs = -9223372036854775807L;
        SubtitleOutputBuffer subtitleOutputBuffer = availableOutputBuffer;
        subtitleOutputBuffer.setContent(getPositionUs(), createSubtitle(), Long.MAX_VALUE);
        return availableOutputBuffer;
    }
}
