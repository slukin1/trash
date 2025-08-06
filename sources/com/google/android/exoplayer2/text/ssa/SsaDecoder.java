package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final float DEFAULT_MARGIN = 0.05f;
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue:";
    public static final String FORMAT_LINE_PREFIX = "Format:";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public static final String STYLE_LINE_PREFIX = "Style:";
    private static final String TAG = "SsaDecoder";
    private final SsaDialogueFormat dialogueFormatFromInitializationData;
    private final boolean haveInitializationData;
    private float screenHeight;
    private float screenWidth;
    private Map<String, SsaStyle> styles;

    public SsaDecoder() {
        this((List<byte[]>) null);
    }

    private static int addCuePlacerholderByTime(long j11, List<Long> list, List<List<Cue>> list2) {
        int i11;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i11 = 0;
                break;
            } else if (list.get(size).longValue() == j11) {
                return size;
            } else {
                if (list.get(size).longValue() < j11) {
                    i11 = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i11, Long.valueOf(j11));
        if (i11 != 0) {
            arrayList = new ArrayList(list2.get(i11 - 1));
        }
        list2.add(i11, arrayList);
        return i11;
    }

    private static float computeDefaultLineOrPosition(int i11) {
        if (i11 == 0) {
            return DEFAULT_MARGIN;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static Cue createCue(String str, SsaStyle ssaStyle, SsaStyle.Overrides overrides, float f11, float f12) {
        SpannableString spannableString = new SpannableString(str);
        Cue.Builder text = new Cue.Builder().setText(spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.primaryColor != null) {
                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.primaryColor.intValue()), 0, spannableString.length(), 33);
            }
            float f13 = ssaStyle.fontSize;
            if (!(f13 == -3.4028235E38f || f12 == -3.4028235E38f)) {
                text.setTextSize(f13 / f12, 1);
            }
            boolean z11 = ssaStyle.bold;
            if (z11 && ssaStyle.italic) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z11) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ssaStyle.italic) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.underline) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.strikeout) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i11 = overrides.alignment;
        if (i11 == -1) {
            i11 = ssaStyle != null ? ssaStyle.alignment : -1;
        }
        text.setTextAlignment(toTextAlignment(i11)).setPositionAnchor(toPositionAnchor(i11)).setLineAnchor(toLineAnchor(i11));
        PointF pointF = overrides.position;
        if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
            text.setPosition(computeDefaultLineOrPosition(text.getPositionAnchor()));
            text.setLine(computeDefaultLineOrPosition(text.getLineAnchor()), 0);
        } else {
            text.setPosition(pointF.x / f11);
            text.setLine(overrides.position.y / f12, 0);
        }
        return text.build();
    }

    private void parseDialogueLine(String str, SsaDialogueFormat ssaDialogueFormat, List<List<Cue>> list, List<Long> list2) {
        int i11;
        Assertions.checkArgument(str.startsWith(DIALOGUE_LINE_PREFIX));
        String[] split = str.substring(9).split(Constants.ACCEPT_TIME_SEPARATOR_SP, ssaDialogueFormat.length);
        if (split.length != ssaDialogueFormat.length) {
            Log.w(TAG, str.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(str) : new String("Skipping dialogue line with fewer columns than format: "));
            return;
        }
        long parseTimecodeUs = parseTimecodeUs(split[ssaDialogueFormat.startTimeIndex]);
        if (parseTimecodeUs == -9223372036854775807L) {
            Log.w(TAG, str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new String("Skipping invalid timing: "));
            return;
        }
        long parseTimecodeUs2 = parseTimecodeUs(split[ssaDialogueFormat.endTimeIndex]);
        if (parseTimecodeUs2 == -9223372036854775807L) {
            Log.w(TAG, str.length() != 0 ? "Skipping invalid timing: ".concat(str) : new String("Skipping invalid timing: "));
            return;
        }
        Map<String, SsaStyle> map = this.styles;
        SsaStyle ssaStyle = (map == null || (i11 = ssaDialogueFormat.styleIndex) == -1) ? null : map.get(split[i11].trim());
        String str2 = split[ssaDialogueFormat.textIndex];
        Cue createCue = createCue(SsaStyle.Overrides.stripStyleOverrides(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), ssaStyle, SsaStyle.Overrides.parseFromDialogue(str2), this.screenWidth, this.screenHeight);
        int addCuePlacerholderByTime = addCuePlacerholderByTime(parseTimecodeUs2, list2, list);
        for (int addCuePlacerholderByTime2 = addCuePlacerholderByTime(parseTimecodeUs, list2, list); addCuePlacerholderByTime2 < addCuePlacerholderByTime; addCuePlacerholderByTime2++) {
            list.get(addCuePlacerholderByTime2).add(createCue);
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<List<Cue>> list, List<Long> list2) {
        SsaDialogueFormat ssaDialogueFormat = this.haveInitializationData ? this.dialogueFormatFromInitializationData : null;
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.startsWith(FORMAT_LINE_PREFIX)) {
                ssaDialogueFormat = SsaDialogueFormat.fromFormatLine(readLine);
            } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                if (ssaDialogueFormat == null) {
                    Log.w(TAG, readLine.length() != 0 ? "Skipping dialogue line before complete format: ".concat(readLine) : new String("Skipping dialogue line before complete format: "));
                } else {
                    parseDialogueLine(readLine, ssaDialogueFormat, list, list2);
                }
            }
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(readLine)) {
                parseScriptInfo(parsableByteArray);
            } else if ("[V4+ Styles]".equalsIgnoreCase(readLine)) {
                this.styles = parseStyles(parsableByteArray);
            } else if ("[V4 Styles]".equalsIgnoreCase(readLine)) {
                Log.i(TAG, "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(readLine)) {
                return;
            }
        }
    }

    private void parseScriptInfo(ParsableByteArray parsableByteArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (parsableByteArray.bytesLeft() == 0 || parsableByteArray.peekUnsignedByte() != 91) {
                String[] split = readLine.split(":");
                if (split.length == 2) {
                    String lowerCase = Ascii.toLowerCase(split[0].trim());
                    lowerCase.hashCode();
                    if (lowerCase.equals("playresx")) {
                        this.screenWidth = Float.parseFloat(split[1].trim());
                    } else if (lowerCase.equals("playresy")) {
                        try {
                            this.screenHeight = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static Map<String, SsaStyle> parseStyles(ParsableByteArray parsableByteArray) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.Format format = null;
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null || (parsableByteArray.bytesLeft() != 0 && parsableByteArray.peekUnsignedByte() == 91)) {
                return linkedHashMap;
            }
            if (readLine.startsWith(FORMAT_LINE_PREFIX)) {
                format = SsaStyle.Format.fromFormatLine(readLine);
            } else if (readLine.startsWith(STYLE_LINE_PREFIX)) {
                if (format == null) {
                    Log.w(TAG, readLine.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(readLine) : new String("Skipping 'Style:' line before 'Format:' line: "));
                } else {
                    SsaStyle fromStyleLine = SsaStyle.fromStyleLine(readLine, format);
                    if (fromStyleLine != null) {
                        linkedHashMap.put(fromStyleLine.name, fromStyleLine);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) Util.castNonNull(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.castNonNull(matcher.group(4))) * 10000);
    }

    private static int toLineAnchor(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                StringBuilder sb2 = new StringBuilder(30);
                sb2.append("Unknown alignment: ");
                sb2.append(i11);
                Log.w(TAG, sb2.toString());
                return Integer.MIN_VALUE;
        }
    }

    private static int toPositionAnchor(int i11) {
        switch (i11) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                StringBuilder sb2 = new StringBuilder(30);
                sb2.append("Unknown alignment: ");
                sb2.append(i11);
                Log.w(TAG, sb2.toString());
                return Integer.MIN_VALUE;
        }
    }

    private static Layout.Alignment toTextAlignment(int i11) {
        switch (i11) {
            case -1:
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                StringBuilder sb2 = new StringBuilder(30);
                sb2.append("Unknown alignment: ");
                sb2.append(i11);
                Log.w(TAG, sb2.toString());
                return null;
        }
    }

    public Subtitle decode(byte[] bArr, int i11, boolean z11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i11);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, arrayList2);
        return new SsaSubtitle(arrayList, arrayList2);
    }

    public SsaDecoder(List<byte[]> list) {
        super(TAG);
        this.screenWidth = -3.4028235E38f;
        this.screenHeight = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.haveInitializationData = false;
            this.dialogueFormatFromInitializationData = null;
            return;
        }
        this.haveInitializationData = true;
        String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
        Assertions.checkArgument(fromUtf8Bytes.startsWith(FORMAT_LINE_PREFIX));
        this.dialogueFormatFromInitializationData = (SsaDialogueFormat) Assertions.checkNotNull(SsaDialogueFormat.fromFormatLine(fromUtf8Bytes));
        parseHeader(new ParsableByteArray(list.get(1)));
    }
}
