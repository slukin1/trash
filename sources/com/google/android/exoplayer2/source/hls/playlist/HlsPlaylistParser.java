package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String LOG_TAG = "HlsPlaylistParser";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern REGEX_ATTR_DURATION = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern REGEX_BYTERANGE_LENGTH = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern REGEX_BYTERANGE_START = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern REGEX_CAN_BLOCK_RELOAD = compileBooleanAttrPattern("CAN-BLOCK-RELOAD");
    private static final Pattern REGEX_CAN_SKIP_DATE_RANGES = compileBooleanAttrPattern("CAN-SKIP-DATERANGES");
    private static final Pattern REGEX_CAN_SKIP_UNTIL = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern(MessengerShareContentUtility.PREVIEW_DEFAULT);
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern REGEX_GAP = compileBooleanAttrPattern("GAP");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_HOLD_BACK = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_INDEPENDENT = compileBooleanAttrPattern("INDEPENDENT");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_LAST_MSN = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern REGEX_LAST_PART = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_PART_HOLD_BACK = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PART_TARGET_DURATION = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern REGEX_PRECISE = compileBooleanAttrPattern("PRECISE");
    private static final Pattern REGEX_PRELOAD_HINT_TYPE = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern REGEX_SKIPPED_SEGMENTS = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_IFRAME = "#EXT-X-I-FRAMES-ONLY";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_I_FRAME_STREAM_INF = "#EXT-X-I-FRAME-STREAM-INF";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PART = "#EXT-X-PART";
    private static final String TAG_PART_INF = "#EXT-X-PART-INF";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PRELOAD_HINT = "#EXT-X-PRELOAD-HINT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_RENDITION_REPORT = "#EXT-X-RENDITION-REPORT";
    private static final String TAG_SERVER_CONTROL = "#EXT-X-SERVER-CONTROL";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_SKIP = "#EXT-X-SKIP";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_MAP = "MAP";
    private static final String TYPE_PART = "PART";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMasterPlaylist masterPlaylist;
    private final HlsMediaPlaylist previousMediaPlaylist;

    public static final class DeltaUpdateException extends IOException {
    }

    public static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean hasNext() throws IOException {
            String trim;
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = (String) Assertions.checkNotNull(this.extraLines.poll());
                return true;
            }
            do {
                String readLine = this.reader.readLine();
                this.next = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.next = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (hasNext()) {
                String str = this.next;
                this.next = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public HlsPlaylistParser() {
        this(HlsMasterPlaylist.EMPTY, (HlsMediaPlaylist) null);
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int skipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, read);
        for (int i11 = 0; i11 < 7; i11++) {
            if (skipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i11)) {
                return false;
            }
            skipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, skipIgnorableWhitespace));
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 9);
        sb2.append(str);
        sb2.append("=(");
        sb2.append(BOOLEAN_FALSE);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(BOOLEAN_TRUE);
        sb2.append(")");
        return Pattern.compile(sb2.toString());
    }

    private static DrmInitData getPlaylistProtectionSchemes(String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i11 = 0; i11 < schemeDataArr.length; i11++) {
            schemeDataArr2[i11] = schemeDataArr[i11].copyWithData((byte[]) null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    private static String getSegmentEncryptionIV(long j11, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j11);
    }

    private static HlsMasterPlaylist.Variant getVariantWithAudioGroup(ArrayList<HlsMasterPlaylist.Variant> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            HlsMasterPlaylist.Variant variant = arrayList.get(i11);
            if (str.equals(variant.audioGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMasterPlaylist.Variant getVariantWithSubtitleGroup(ArrayList<HlsMasterPlaylist.Variant> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            HlsMasterPlaylist.Variant variant = arrayList.get(i11);
            if (str.equals(variant.subtitleGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static HlsMasterPlaylist.Variant getVariantWithVideoGroup(ArrayList<HlsMasterPlaylist.Variant> arrayList, String str) {
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            HlsMasterPlaylist.Variant variant = arrayList.get(i11);
            if (str.equals(variant.videoGroupId)) {
                return variant;
            }
        }
        return null;
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static DrmInitData.SchemeData parseDrmSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map);
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String parseStringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "video/mp4", Base64.decode(parseStringAttr.substring(parseStringAttr.indexOf(44)), 0));
        } else if (KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            return new DrmInitData.SchemeData(C.WIDEVINE_UUID, "hls", Util.getUtf8Bytes(str));
        } else {
            if (!KEYFORMAT_PLAYREADY.equals(str2) || !"1".equals(parseOptionalStringAttr)) {
                return null;
            }
            String parseStringAttr2 = parseStringAttr(str, REGEX_URI, map);
            byte[] decode = Base64.decode(parseStringAttr2.substring(parseStringAttr2.indexOf(44)), 0);
            UUID uuid = C.PLAYREADY_UUID;
            return new DrmInitData.SchemeData(uuid, "video/mp4", PsshAtomUtil.buildPsshAtom(uuid, decode));
        }
    }

    private static String parseEncryptionScheme(String str) {
        return (METHOD_SAMPLE_AES_CENC.equals(str) || METHOD_SAMPLE_AES_CTR.equals(str)) ? C.CENC_TYPE_cenc : C.CENC_TYPE_cbcs;
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0467, code lost:
        r6 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x04b0, code lost:
        r0 = r0 + 1;
        r31 = r6;
        r32 = r8;
        r33 = r14;
        r15 = r20;
        r8 = r22;
        r6 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist parseMasterPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator r36, java.lang.String r37) throws java.io.IOException {
        /*
            r1 = r37
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r10 = 0
            r13 = 0
        L_0x0036:
            boolean r14 = r36.hasNext()
            java.lang.String r15 = "application/x-mpegURL"
            if (r14 == 0) goto L_0x021b
            java.lang.String r14 = r36.next()
            java.lang.String r9 = "#EXT"
            boolean r9 = r14.startsWith(r9)
            if (r9 == 0) goto L_0x004d
            r8.add(r14)
        L_0x004d:
            java.lang.String r9 = "#EXT-X-I-FRAME-STREAM-INF"
            boolean r9 = r14.startsWith(r9)
            r19 = r10
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x006d
            java.util.regex.Pattern r9 = REGEX_NAME
            java.lang.String r9 = parseStringAttr(r14, r9, r11)
            java.util.regex.Pattern r10 = REGEX_VALUE
            java.lang.String r10 = parseStringAttr(r14, r10, r11)
            r11.put(r9, r10)
            goto L_0x00ce
        L_0x006d:
            java.lang.String r10 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x0087
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r28 = r12
            r10 = 1
            goto L_0x0200
        L_0x0087:
            java.lang.String r10 = "#EXT-X-MEDIA"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x0093
            r3.add(r14)
            goto L_0x00ce
        L_0x0093:
            java.lang.String r10 = "#EXT-X-SESSION-KEY"
            boolean r10 = r14.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.util.regex.Pattern r9 = REGEX_KEYFORMAT
            java.lang.String r10 = "identity"
            java.lang.String r9 = parseOptionalStringAttr(r14, r9, r10, r11)
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData r9 = parseDrmSchemeData(r14, r9, r11)
            if (r9 == 0) goto L_0x00ce
            java.util.regex.Pattern r10 = REGEX_METHOD
            java.lang.String r10 = parseStringAttr(r14, r10, r11)
            java.lang.String r10 = parseEncryptionScheme(r10)
            com.google.android.exoplayer2.drm.DrmInitData r14 = new com.google.android.exoplayer2.drm.DrmInitData
            r15 = 1
            com.google.android.exoplayer2.drm.DrmInitData$SchemeData[] r15 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[r15]
            r16 = 0
            r15[r16] = r9
            r14.<init>((java.lang.String) r10, (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) r15)
            r12.add(r14)
            goto L_0x00ce
        L_0x00c3:
            java.lang.String r10 = "#EXT-X-STREAM-INF"
            boolean r10 = r14.startsWith(r10)
            if (r10 != 0) goto L_0x00e1
            if (r9 == 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r28 = r12
            r10 = r19
            goto L_0x0200
        L_0x00e1:
            java.lang.String r10 = "CLOSED-CAPTIONS=NONE"
            boolean r10 = r14.contains(r10)
            r13 = r13 | r10
            if (r9 == 0) goto L_0x00ef
            r10 = 16384(0x4000, float:2.2959E-41)
            r20 = r13
            goto L_0x00f2
        L_0x00ef:
            r20 = r13
            r10 = 0
        L_0x00f2:
            java.util.regex.Pattern r13 = REGEX_BANDWIDTH
            int r13 = parseIntAttr(r14, r13)
            r28 = r12
            java.util.regex.Pattern r12 = REGEX_AVERAGE_BANDWIDTH
            r29 = r7
            r7 = -1
            int r12 = parseOptionalIntAttr(r14, r12, r7)
            java.util.regex.Pattern r7 = REGEX_CODECS
            java.lang.String r7 = parseOptionalStringAttr(r14, r7, r11)
            r30 = r8
            java.util.regex.Pattern r8 = REGEX_RESOLUTION
            java.lang.String r8 = parseOptionalStringAttr(r14, r8, r11)
            if (r8 == 0) goto L_0x013a
            r31 = r6
            java.lang.String r6 = "x"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.Util.split(r8, r6)
            r8 = 0
            r21 = r6[r8]
            int r8 = java.lang.Integer.parseInt(r21)
            r18 = 1
            r6 = r6[r18]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r8 <= 0) goto L_0x0133
            if (r6 > 0) goto L_0x0130
            goto L_0x0133
        L_0x0130:
            r17 = r8
            goto L_0x0136
        L_0x0133:
            r6 = -1
            r17 = -1
        L_0x0136:
            r8 = r6
            r6 = r17
            goto L_0x013e
        L_0x013a:
            r31 = r6
            r6 = -1
            r8 = -1
        L_0x013e:
            r17 = -1082130432(0xffffffffbf800000, float:-1.0)
            r32 = r5
            java.util.regex.Pattern r5 = REGEX_FRAME_RATE
            java.lang.String r5 = parseOptionalStringAttr(r14, r5, r11)
            if (r5 == 0) goto L_0x014e
            float r17 = java.lang.Float.parseFloat(r5)
        L_0x014e:
            r33 = r4
            r5 = r17
            java.util.regex.Pattern r4 = REGEX_VIDEO
            java.lang.String r4 = parseOptionalStringAttr(r14, r4, r11)
            r34 = r3
            java.util.regex.Pattern r3 = REGEX_AUDIO
            java.lang.String r3 = parseOptionalStringAttr(r14, r3, r11)
            r35 = r0
            java.util.regex.Pattern r0 = REGEX_SUBTITLES
            java.lang.String r0 = parseOptionalStringAttr(r14, r0, r11)
            r17 = r0
            java.util.regex.Pattern r0 = REGEX_CLOSED_CAPTIONS
            java.lang.String r0 = parseOptionalStringAttr(r14, r0, r11)
            if (r9 == 0) goto L_0x017d
            java.util.regex.Pattern r9 = REGEX_URI
            java.lang.String r9 = parseStringAttr(r14, r9, r11)
            android.net.Uri r9 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r1, r9)
            goto L_0x018f
        L_0x017d:
            boolean r9 = r36.hasNext()
            if (r9 == 0) goto L_0x0213
            java.lang.String r9 = r36.next()
            java.lang.String r9 = replaceVariableReferences(r9, r11)
            android.net.Uri r9 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r1, r9)
        L_0x018f:
            com.google.android.exoplayer2.Format$Builder r14 = new com.google.android.exoplayer2.Format$Builder
            r14.<init>()
            int r1 = r2.size()
            com.google.android.exoplayer2.Format$Builder r1 = r14.setId((int) r1)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setContainerMimeType(r15)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setCodecs(r7)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setAverageBitrate(r12)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setPeakBitrate(r13)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setWidth(r6)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setHeight(r8)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setFrameRate(r5)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setRoleFlags(r10)
            com.google.android.exoplayer2.Format r23 = r1.build()
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant r1 = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant
            r21 = r1
            r22 = r9
            r24 = r4
            r25 = r3
            r26 = r17
            r27 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r2.add(r1)
            r1 = r35
            java.lang.Object r5 = r1.get(r9)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 != 0) goto L_0x01e6
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r1.put(r9, r5)
        L_0x01e6:
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo r6 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo
            r21 = r6
            r22 = r12
            r23 = r13
            r24 = r4
            r25 = r3
            r26 = r17
            r27 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r5.add(r6)
            r10 = r19
            r13 = r20
        L_0x0200:
            r0 = r1
            r12 = r28
            r7 = r29
            r8 = r30
            r6 = r31
            r5 = r32
            r4 = r33
            r3 = r34
            r1 = r37
            goto L_0x0036
        L_0x0213:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "#EXT-X-STREAM-INF must be followed by another line"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x021b:
            r1 = r0
            r34 = r3
            r33 = r4
            r32 = r5
            r31 = r6
            r29 = r7
            r30 = r8
            r19 = r10
            r28 = r12
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r4 = 0
        L_0x0237:
            int r5 = r2.size()
            r6 = 0
            if (r4 >= r5) goto L_0x028e
            java.lang.Object r5 = r2.get(r4)
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant r5 = (com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.Variant) r5
            android.net.Uri r7 = r5.url
            boolean r7 = r0.add(r7)
            if (r7 == 0) goto L_0x028b
            com.google.android.exoplayer2.Format r7 = r5.format
            com.google.android.exoplayer2.metadata.Metadata r7 = r7.metadata
            if (r7 != 0) goto L_0x0254
            r7 = 1
            goto L_0x0255
        L_0x0254:
            r7 = 0
        L_0x0255:
            com.google.android.exoplayer2.util.Assertions.checkState(r7)
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r7 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            android.net.Uri r8 = r5.url
            java.lang.Object r8 = r1.get(r8)
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.lang.Object r8 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r8)
            java.util.List r8 = (java.util.List) r8
            r7.<init>(r6, r6, r8)
            com.google.android.exoplayer2.metadata.Metadata r6 = new com.google.android.exoplayer2.metadata.Metadata
            r8 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r9 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r8]
            r8 = 0
            r9[r8] = r7
            r6.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r9)
            com.google.android.exoplayer2.Format r7 = r5.format
            com.google.android.exoplayer2.Format$Builder r7 = r7.buildUpon()
            com.google.android.exoplayer2.Format$Builder r6 = r7.setMetadata(r6)
            com.google.android.exoplayer2.Format r6 = r6.build()
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant r5 = r5.copyWithFormat(r6)
            r3.add(r5)
        L_0x028b:
            int r4 = r4 + 1
            goto L_0x0237
        L_0x028e:
            r1 = r6
            r8 = r1
            r0 = 0
        L_0x0291:
            int r4 = r34.size()
            if (r0 >= r4) goto L_0x04bf
            r4 = r34
            java.lang.Object r5 = r4.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.util.regex.Pattern r7 = REGEX_GROUP_ID
            java.lang.String r7 = parseStringAttr(r5, r7, r11)
            java.util.regex.Pattern r9 = REGEX_NAME
            java.lang.String r9 = parseStringAttr(r5, r9, r11)
            com.google.android.exoplayer2.Format$Builder r10 = new com.google.android.exoplayer2.Format$Builder
            r10.<init>()
            java.lang.String r12 = java.lang.String.valueOf(r7)
            int r12 = r12.length()
            r14 = 1
            int r12 = r12 + r14
            java.lang.String r14 = java.lang.String.valueOf(r9)
            int r14 = r14.length()
            int r12 = r12 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r12)
            r14.append(r7)
            java.lang.String r12 = ":"
            r14.append(r12)
            r14.append(r9)
            java.lang.String r12 = r14.toString()
            com.google.android.exoplayer2.Format$Builder r10 = r10.setId((java.lang.String) r12)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setLabel(r9)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setContainerMimeType(r15)
            int r12 = parseSelectionFlags(r5)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setSelectionFlags(r12)
            int r12 = parseRoleFlags(r5, r11)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setRoleFlags(r12)
            java.util.regex.Pattern r12 = REGEX_LANGUAGE
            java.lang.String r12 = parseOptionalStringAttr(r5, r12, r11)
            com.google.android.exoplayer2.Format$Builder r10 = r10.setLanguage(r12)
            java.util.regex.Pattern r12 = REGEX_URI
            java.lang.String r12 = parseOptionalStringAttr(r5, r12, r11)
            r14 = r37
            if (r12 != 0) goto L_0x0309
            r12 = r6
            goto L_0x030d
        L_0x0309:
            android.net.Uri r12 = com.google.android.exoplayer2.util.UriUtil.resolveToUri(r14, r12)
        L_0x030d:
            com.google.android.exoplayer2.metadata.Metadata r6 = new com.google.android.exoplayer2.metadata.Metadata
            r34 = r4
            r4 = 1
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r14 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r4]
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry r4 = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry
            r20 = r15
            java.util.List r15 = java.util.Collections.emptyList()
            r4.<init>(r7, r9, r15)
            r15 = 0
            r14[r15] = r4
            r6.<init>((com.google.android.exoplayer2.metadata.Metadata.Entry[]) r14)
            java.util.regex.Pattern r4 = REGEX_TYPE
            java.lang.String r4 = parseStringAttr(r5, r4, r11)
            r4.hashCode()
            int r14 = r4.hashCode()
            r15 = 2
            switch(r14) {
                case -959297733: goto L_0x0359;
                case -333210994: goto L_0x034e;
                case 62628790: goto L_0x0343;
                case 81665115: goto L_0x0338;
                default: goto L_0x0336;
            }
        L_0x0336:
            r4 = -1
            goto L_0x0363
        L_0x0338:
            java.lang.String r14 = "VIDEO"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0341
            goto L_0x0336
        L_0x0341:
            r4 = 3
            goto L_0x0363
        L_0x0343:
            java.lang.String r14 = "AUDIO"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x034c
            goto L_0x0336
        L_0x034c:
            r4 = r15
            goto L_0x0363
        L_0x034e:
            java.lang.String r14 = "CLOSED-CAPTIONS"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0357
            goto L_0x0336
        L_0x0357:
            r4 = 1
            goto L_0x0363
        L_0x0359:
            java.lang.String r14 = "SUBTITLES"
            boolean r4 = r4.equals(r14)
            if (r4 != 0) goto L_0x0362
            goto L_0x0336
        L_0x0362:
            r4 = 0
        L_0x0363:
            switch(r4) {
                case 0: goto L_0x046a;
                case 1: goto L_0x0426;
                case 2: goto L_0x03b8;
                case 3: goto L_0x0372;
                default: goto L_0x0366;
            }
        L_0x0366:
            r22 = r8
            r6 = r31
            r8 = r32
            r14 = r33
        L_0x036e:
            r16 = 0
            goto L_0x04b0
        L_0x0372:
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant r4 = getVariantWithVideoGroup(r2, r7)
            if (r4 == 0) goto L_0x039d
            com.google.android.exoplayer2.Format r4 = r4.format
            java.lang.String r5 = r4.codecs
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r5, r15)
            com.google.android.exoplayer2.Format$Builder r14 = r10.setCodecs(r5)
            java.lang.String r5 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(r5)
            com.google.android.exoplayer2.Format$Builder r5 = r14.setSampleMimeType(r5)
            int r14 = r4.width
            com.google.android.exoplayer2.Format$Builder r5 = r5.setWidth(r14)
            int r14 = r4.height
            com.google.android.exoplayer2.Format$Builder r5 = r5.setHeight(r14)
            float r4 = r4.frameRate
            r5.setFrameRate(r4)
        L_0x039d:
            if (r12 != 0) goto L_0x03a0
            goto L_0x0366
        L_0x03a0:
            r10.setMetadata(r6)
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.build()
            r4.<init>(r12, r5, r7, r9)
            r14 = r33
            r14.add(r4)
            r22 = r8
            r6 = r31
            r8 = r32
            goto L_0x036e
        L_0x03b8:
            r14 = r33
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant r4 = getVariantWithAudioGroup(r2, r7)
            if (r4 == 0) goto L_0x03d3
            com.google.android.exoplayer2.Format r15 = r4.format
            java.lang.String r15 = r15.codecs
            r22 = r8
            r8 = 1
            java.lang.String r15 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r15, r8)
            r10.setCodecs(r15)
            java.lang.String r15 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(r15)
            goto L_0x03d6
        L_0x03d3:
            r22 = r8
            r15 = 0
        L_0x03d6:
            java.util.regex.Pattern r8 = REGEX_CHANNELS
            java.lang.String r5 = parseOptionalStringAttr(r5, r8, r11)
            if (r5 == 0) goto L_0x0402
            java.lang.String r8 = "/"
            java.lang.String[] r8 = com.google.android.exoplayer2.util.Util.splitAtFirst(r5, r8)
            r16 = 0
            r8 = r8[r16]
            int r8 = java.lang.Integer.parseInt(r8)
            r10.setChannelCount(r8)
            java.lang.String r8 = "audio/eac3"
            boolean r8 = r8.equals(r15)
            if (r8 == 0) goto L_0x0404
            java.lang.String r8 = "/JOC"
            boolean r5 = r5.endsWith(r8)
            if (r5 == 0) goto L_0x0404
            java.lang.String r15 = "audio/eac3-joc"
            goto L_0x0404
        L_0x0402:
            r16 = 0
        L_0x0404:
            r10.setSampleMimeType(r15)
            if (r12 == 0) goto L_0x041b
            r10.setMetadata(r6)
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.build()
            r4.<init>(r12, r5, r7, r9)
            r8 = r32
            r8.add(r4)
            goto L_0x0467
        L_0x041b:
            r8 = r32
            if (r4 == 0) goto L_0x0467
            com.google.android.exoplayer2.Format r4 = r10.build()
            r22 = r4
            goto L_0x0467
        L_0x0426:
            r22 = r8
            r8 = r32
            r14 = r33
            r16 = 0
            java.util.regex.Pattern r4 = REGEX_INSTREAM_ID
            java.lang.String r4 = parseStringAttr(r5, r4, r11)
            java.lang.String r5 = "CC"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0447
            java.lang.String r4 = r4.substring(r15)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r5 = "application/cea-608"
            goto L_0x0452
        L_0x0447:
            r5 = 7
            java.lang.String r4 = r4.substring(r5)
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.String r5 = "application/cea-708"
        L_0x0452:
            if (r1 != 0) goto L_0x0459
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0459:
            com.google.android.exoplayer2.Format$Builder r5 = r10.setSampleMimeType(r5)
            r5.setAccessibilityChannel(r4)
            com.google.android.exoplayer2.Format r4 = r10.build()
            r1.add(r4)
        L_0x0467:
            r6 = r31
            goto L_0x04b0
        L_0x046a:
            r22 = r8
            r8 = r32
            r14 = r33
            r16 = 0
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant r4 = getVariantWithSubtitleGroup(r2, r7)
            if (r4 == 0) goto L_0x0489
            com.google.android.exoplayer2.Format r4 = r4.format
            java.lang.String r4 = r4.codecs
            r5 = 3
            java.lang.String r4 = com.google.android.exoplayer2.util.Util.getCodecsOfType(r4, r5)
            r10.setCodecs(r4)
            java.lang.String r4 = com.google.android.exoplayer2.util.MimeTypes.getMediaMimeType(r4)
            goto L_0x048a
        L_0x0489:
            r4 = 0
        L_0x048a:
            if (r4 != 0) goto L_0x048f
            java.lang.String r4 = "text/vtt"
        L_0x048f:
            com.google.android.exoplayer2.Format$Builder r4 = r10.setSampleMimeType(r4)
            r4.setMetadata(r6)
            if (r12 == 0) goto L_0x04a7
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition r4 = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Rendition
            com.google.android.exoplayer2.Format r5 = r10.build()
            r4.<init>(r12, r5, r7, r9)
            r6 = r31
            r6.add(r4)
            goto L_0x04b0
        L_0x04a7:
            r6 = r31
            java.lang.String r4 = "HlsPlaylistParser"
            java.lang.String r5 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping"
            com.google.android.exoplayer2.util.Log.w(r4, r5)
        L_0x04b0:
            int r0 = r0 + 1
            r31 = r6
            r32 = r8
            r33 = r14
            r15 = r20
            r8 = r22
            r6 = 0
            goto L_0x0291
        L_0x04bf:
            r22 = r8
            r6 = r31
            r8 = r32
            r14 = r33
            if (r13 == 0) goto L_0x04cf
            java.util.List r0 = java.util.Collections.emptyList()
            r9 = r0
            goto L_0x04d0
        L_0x04cf:
            r9 = r1
        L_0x04d0:
            com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist r13 = new com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist
            r0 = r13
            r1 = r37
            r2 = r30
            r4 = r14
            r5 = r8
            r7 = r29
            r8 = r22
            r10 = r19
            r12 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.parseMasterPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist");
    }

    private static HlsMediaPlaylist parseMediaPlaylist(HlsMasterPlaylist hlsMasterPlaylist, HlsMediaPlaylist hlsMediaPlaylist, LineIterator lineIterator, String str) throws IOException {
        boolean z11;
        ArrayList arrayList;
        String str2;
        ArrayList arrayList2;
        String str3;
        boolean z12;
        String str4;
        String str5;
        String str6;
        HlsMediaPlaylist.Part part;
        long j11;
        HashMap hashMap;
        int i11;
        ArrayList arrayList3;
        long j12;
        long j13;
        boolean z13;
        DrmInitData drmInitData;
        long j14;
        String str7;
        String str8;
        long j15;
        String str9;
        String str10;
        HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        HlsMediaPlaylist hlsMediaPlaylist2 = hlsMediaPlaylist;
        boolean z14 = hlsMasterPlaylist2.hasIndependentSegments;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList6 = new ArrayList();
        HlsMediaPlaylist.ServerControl serverControl = new HlsMediaPlaylist.ServerControl(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        String str11 = "";
        boolean z15 = z14;
        HlsMediaPlaylist.ServerControl serverControl2 = serverControl;
        String str12 = str11;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        long j19 = 0;
        long j21 = 0;
        long j22 = 0;
        long j23 = 0;
        long j24 = 0;
        boolean z16 = false;
        int i12 = 0;
        long j25 = -9223372036854775807L;
        boolean z17 = false;
        int i13 = 0;
        int i14 = 1;
        long j26 = -9223372036854775807L;
        long j27 = -9223372036854775807L;
        boolean z18 = false;
        DrmInitData drmInitData2 = null;
        DrmInitData drmInitData3 = null;
        boolean z19 = false;
        HlsMediaPlaylist.Part part2 = null;
        String str13 = null;
        long j28 = -1;
        String str14 = null;
        String str15 = null;
        int i15 = 0;
        boolean z21 = false;
        HlsMediaPlaylist.Segment segment = null;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList6.add(next);
            }
            if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                String parseStringAttr = parseStringAttr(next, REGEX_PLAYLIST_TYPE, hashMap2);
                if ("VOD".equals(parseStringAttr)) {
                    i12 = 1;
                } else if ("EVENT".equals(parseStringAttr)) {
                    i12 = 2;
                }
            } else if (next.equals(TAG_IFRAME)) {
                z21 = true;
            } else if (next.startsWith(TAG_START)) {
                z16 = parseOptionalBooleanAttribute(next, REGEX_PRECISE, false);
                j25 = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
            } else if (next.startsWith(TAG_SERVER_CONTROL)) {
                serverControl2 = parseServerControl(next);
            } else if (next.startsWith(TAG_PART_INF)) {
                j27 = (long) (parseDoubleAttr(next, REGEX_PART_TARGET_DURATION) * 1000000.0d);
            } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                String parseStringAttr2 = parseStringAttr(next, REGEX_URI, hashMap2);
                String parseOptionalStringAttr = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, hashMap2);
                if (parseOptionalStringAttr != null) {
                    String[] split = Util.split(parseOptionalStringAttr, TIMMentionEditText.TIM_MENTION_TAG);
                    j28 = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j18 = Long.parseLong(split[1]);
                    }
                }
                int i16 = (j28 > -1 ? 1 : (j28 == -1 ? 0 : -1));
                if (i16 == 0) {
                    j18 = 0;
                }
                String str16 = str13;
                String str17 = str14;
                if (str16 == null || str17 != null) {
                    segment = new HlsMediaPlaylist.Segment(parseStringAttr2, j18, j28, str16, str17);
                    if (i16 != 0) {
                        j18 += j28;
                    }
                    str13 = str16;
                    str14 = str17;
                    j28 = -1;
                } else {
                    throw new ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                }
            } else {
                String str18 = str13;
                String str19 = str14;
                boolean z22 = z16;
                if (next.startsWith(TAG_TARGET_DURATION)) {
                    j26 = 1000000 * ((long) parseIntAttr(next, REGEX_TARGET_DURATION));
                } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                    j22 = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                    str14 = str19;
                    z16 = z22;
                    j17 = j22;
                    str13 = str18;
                } else if (next.startsWith(TAG_VERSION)) {
                    i14 = parseIntAttr(next, REGEX_VERSION);
                } else {
                    if (next.startsWith(TAG_DEFINE)) {
                        String parseOptionalStringAttr2 = parseOptionalStringAttr(next, REGEX_IMPORT, hashMap2);
                        if (parseOptionalStringAttr2 != null) {
                            String str20 = hlsMasterPlaylist2.variableDefinitions.get(parseOptionalStringAttr2);
                            if (str20 != null) {
                                hashMap2.put(parseOptionalStringAttr2, str20);
                            }
                        } else {
                            hashMap2.put(parseStringAttr(next, REGEX_NAME, hashMap2), parseStringAttr(next, REGEX_VALUE, hashMap2));
                        }
                        arrayList2 = arrayList6;
                        str2 = str11;
                        str6 = str18;
                        part = part2;
                        str5 = str15;
                        j11 = j22;
                        i11 = i12;
                    } else {
                        if (next.startsWith(TAG_MEDIA_DURATION)) {
                            double parseDoubleAttr = parseDoubleAttr(next, REGEX_MEDIA_DURATION);
                            str4 = str18;
                            str12 = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, str11, hashMap2);
                            hlsMasterPlaylist2 = hlsMasterPlaylist;
                            j23 = (long) (parseDoubleAttr * 1000000.0d);
                            str9 = str19;
                        } else {
                            str4 = str18;
                            if (next.startsWith(TAG_SKIP)) {
                                int parseIntAttr = parseIntAttr(next, REGEX_SKIPPED_SEGMENTS);
                                Assertions.checkState(hlsMediaPlaylist2 != null && arrayList4.isEmpty());
                                int i17 = (int) (j17 - ((HlsMediaPlaylist) Util.castNonNull(hlsMediaPlaylist)).mediaSequence);
                                int i18 = parseIntAttr + i17;
                                if (i17 < 0 || i18 > hlsMediaPlaylist2.segments.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str9 = str19;
                                long j29 = j21;
                                while (i17 < i18) {
                                    HlsMediaPlaylist.Segment segment2 = hlsMediaPlaylist2.segments.get(i17);
                                    ArrayList arrayList7 = arrayList6;
                                    String str21 = str11;
                                    if (j17 != hlsMediaPlaylist2.mediaSequence) {
                                        segment2 = segment2.copyWith(j29, (hlsMediaPlaylist2.discontinuitySequence - i13) + segment2.relativeDiscontinuitySequence);
                                    }
                                    arrayList4.add(segment2);
                                    j29 += segment2.durationUs;
                                    long j30 = segment2.byteRangeLength;
                                    int i19 = i18;
                                    if (j30 != -1) {
                                        j18 = segment2.byteRangeOffset + j30;
                                    }
                                    int i21 = segment2.relativeDiscontinuitySequence;
                                    HlsMediaPlaylist.Segment segment3 = segment2.initializationSegment;
                                    DrmInitData drmInitData4 = segment2.drmInitData;
                                    String str22 = segment2.fullSegmentEncryptionKeyUri;
                                    String str23 = segment2.encryptionIV;
                                    int i22 = i21;
                                    if (str23 == null || !str23.equals(Long.toHexString(j22))) {
                                        str9 = segment2.encryptionIV;
                                    }
                                    j22++;
                                    i17++;
                                    segment = segment3;
                                    str4 = str22;
                                    j19 = j29;
                                    i15 = i22;
                                    i18 = i19;
                                    str11 = str21;
                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                    drmInitData3 = drmInitData4;
                                    arrayList6 = arrayList7;
                                }
                                hlsMasterPlaylist2 = hlsMasterPlaylist;
                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                j21 = j29;
                            } else {
                                arrayList2 = arrayList6;
                                str2 = str11;
                                if (next.startsWith(TAG_KEY)) {
                                    String parseStringAttr3 = parseStringAttr(next, REGEX_METHOD, hashMap2);
                                    String parseOptionalStringAttr3 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, KEYFORMAT_IDENTITY, hashMap2);
                                    if (METHOD_NONE.equals(parseStringAttr3)) {
                                        treeMap.clear();
                                        str10 = null;
                                        drmInitData3 = null;
                                        str3 = null;
                                    } else {
                                        String parseOptionalStringAttr4 = parseOptionalStringAttr(next, REGEX_IV, hashMap2);
                                        if (!KEYFORMAT_IDENTITY.equals(parseOptionalStringAttr3)) {
                                            String str24 = str15;
                                            str15 = str24 == null ? parseEncryptionScheme(parseStringAttr3) : str24;
                                            DrmInitData.SchemeData parseDrmSchemeData = parseDrmSchemeData(next, parseOptionalStringAttr3, hashMap2);
                                            if (parseDrmSchemeData != null) {
                                                treeMap.put(parseOptionalStringAttr3, parseDrmSchemeData);
                                                str3 = parseOptionalStringAttr4;
                                                str10 = null;
                                                drmInitData3 = null;
                                            }
                                        } else if (METHOD_AES_128.equals(parseStringAttr3)) {
                                            str10 = parseStringAttr(next, REGEX_URI, hashMap2);
                                            str3 = parseOptionalStringAttr4;
                                        }
                                        str3 = parseOptionalStringAttr4;
                                        str10 = null;
                                    }
                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                    z12 = z22;
                                    arrayList6 = arrayList2;
                                    str11 = str2;
                                    str13 = str10;
                                } else {
                                    str5 = str15;
                                    if (next.startsWith(TAG_BYTERANGE)) {
                                        String[] split2 = Util.split(parseStringAttr(next, REGEX_BYTERANGE, hashMap2), TIMMentionEditText.TIM_MENTION_TAG);
                                        j28 = Long.parseLong(split2[0]);
                                        if (split2.length > 1) {
                                            j18 = Long.parseLong(split2[1]);
                                        }
                                    } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                                        i13 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        str15 = str5;
                                        str9 = str19;
                                        arrayList6 = arrayList2;
                                        str11 = str2;
                                        z17 = true;
                                    } else if (next.equals(TAG_DISCONTINUITY)) {
                                        i15++;
                                    } else if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                                        if (j16 == 0) {
                                            j16 = C.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + 1))) - j21;
                                        } else {
                                            str6 = str4;
                                            i11 = i12;
                                            part = part2;
                                            j11 = j22;
                                        }
                                    } else if (next.equals(TAG_GAP)) {
                                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        str15 = str5;
                                        str9 = str19;
                                        arrayList6 = arrayList2;
                                        str11 = str2;
                                        z19 = true;
                                    } else if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        str15 = str5;
                                        str9 = str19;
                                        arrayList6 = arrayList2;
                                        str11 = str2;
                                        z15 = true;
                                    } else if (next.equals(TAG_ENDLIST)) {
                                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                                        hlsMediaPlaylist2 = hlsMediaPlaylist;
                                        str15 = str5;
                                        str9 = str19;
                                        arrayList6 = arrayList2;
                                        str11 = str2;
                                        z18 = true;
                                    } else if (next.startsWith(TAG_RENDITION_REPORT)) {
                                        str6 = str4;
                                        long parseOptionalLongAttr = parseOptionalLongAttr(next, REGEX_LAST_MSN, (j17 + ((long) arrayList4.size())) - (arrayList5.isEmpty() ? 1 : 0));
                                        int parseOptionalIntAttr = parseOptionalIntAttr(next, REGEX_LAST_PART, j27 != -9223372036854775807L ? (arrayList5.isEmpty() ? ((HlsMediaPlaylist.Segment) Iterables.getLast(arrayList4)).parts : arrayList5).size() - 1 : -1);
                                        Uri parse = Uri.parse(UriUtil.resolve(str, parseStringAttr(next, REGEX_URI, hashMap2)));
                                        hashMap4.put(parse, new HlsMediaPlaylist.RenditionReport(parse, parseOptionalLongAttr, parseOptionalIntAttr));
                                        i11 = i12;
                                        part = part2;
                                        j11 = j22;
                                    } else {
                                        str6 = str4;
                                        if (next.startsWith(TAG_PRELOAD_HINT)) {
                                            part = part2;
                                            if (part == null && TYPE_PART.equals(parseStringAttr(next, REGEX_PRELOAD_HINT_TYPE, hashMap2))) {
                                                String parseStringAttr4 = parseStringAttr(next, REGEX_URI, hashMap2);
                                                long parseOptionalLongAttr2 = parseOptionalLongAttr(next, REGEX_BYTERANGE_START, -1);
                                                HashMap hashMap5 = hashMap4;
                                                long parseOptionalLongAttr3 = parseOptionalLongAttr(next, REGEX_BYTERANGE_LENGTH, -1);
                                                long j31 = j22;
                                                String segmentEncryptionIV = getSegmentEncryptionIV(j31, str6, str19);
                                                if (drmInitData3 != null || treeMap.isEmpty()) {
                                                    j15 = j31;
                                                } else {
                                                    j15 = j31;
                                                    DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData5 = new DrmInitData(str5, schemeDataArr);
                                                    if (drmInitData2 == null) {
                                                        drmInitData2 = getPlaylistProtectionSchemes(str5, schemeDataArr);
                                                    }
                                                    drmInitData3 = drmInitData5;
                                                }
                                                int i23 = (parseOptionalLongAttr2 > -1 ? 1 : (parseOptionalLongAttr2 == -1 ? 0 : -1));
                                                if (i23 == 0 || parseOptionalLongAttr3 != -1) {
                                                    part = new HlsMediaPlaylist.Part(parseStringAttr4, segment, 0, i15, j19, drmInitData3, str6, segmentEncryptionIV, i23 != 0 ? parseOptionalLongAttr2 : 0, parseOptionalLongAttr3, false, false, true);
                                                }
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                str15 = str5;
                                                str3 = str19;
                                                j22 = j15;
                                                hashMap4 = hashMap5;
                                                z12 = z22;
                                                str11 = str2;
                                                part2 = part;
                                                str13 = str6;
                                                arrayList6 = arrayList2;
                                            } else {
                                                i11 = i12;
                                                hashMap = hashMap4;
                                                arrayList3 = arrayList4;
                                                j11 = j22;
                                                j22 = j11;
                                                str8 = str19;
                                                arrayList4 = arrayList3;
                                                hashMap4 = hashMap;
                                                z12 = z22;
                                                i12 = i11;
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                part2 = part;
                                                str13 = str6;
                                                str7 = str5;
                                                arrayList6 = arrayList2;
                                                str11 = str2;
                                            }
                                        } else {
                                            part = part2;
                                            j11 = j22;
                                            hashMap = hashMap4;
                                            if (next.startsWith(TAG_PART)) {
                                                String segmentEncryptionIV2 = getSegmentEncryptionIV(j11, str6, str19);
                                                String parseStringAttr5 = parseStringAttr(next, REGEX_URI, hashMap2);
                                                ArrayList arrayList8 = arrayList4;
                                                long parseDoubleAttr2 = (long) (parseDoubleAttr(next, REGEX_ATTR_DURATION) * 1000000.0d);
                                                int i24 = i12;
                                                boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(next, REGEX_INDEPENDENT, false) | (z15 && arrayList5.isEmpty());
                                                boolean parseOptionalBooleanAttribute2 = parseOptionalBooleanAttribute(next, REGEX_GAP, false);
                                                String parseOptionalStringAttr5 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, hashMap2);
                                                if (parseOptionalStringAttr5 != null) {
                                                    String[] split3 = Util.split(parseOptionalStringAttr5, TIMMentionEditText.TIM_MENTION_TAG);
                                                    j14 = Long.parseLong(split3[0]);
                                                    if (split3.length > 1) {
                                                        j24 = Long.parseLong(split3[1]);
                                                    }
                                                } else {
                                                    j14 = -1;
                                                }
                                                int i25 = (j14 > -1 ? 1 : (j14 == -1 ? 0 : -1));
                                                if (i25 == 0) {
                                                    j24 = 0;
                                                }
                                                if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                    DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                    DrmInitData drmInitData6 = new DrmInitData(str5, schemeDataArr2);
                                                    if (drmInitData2 == null) {
                                                        drmInitData2 = getPlaylistProtectionSchemes(str5, schemeDataArr2);
                                                    }
                                                    drmInitData3 = drmInitData6;
                                                }
                                                arrayList5.add(new HlsMediaPlaylist.Part(parseStringAttr5, segment, parseDoubleAttr2, i15, j19, drmInitData3, str6, segmentEncryptionIV2, j24, j14, parseOptionalBooleanAttribute2, parseOptionalBooleanAttribute, false));
                                                j19 += parseDoubleAttr2;
                                                if (i25 != 0) {
                                                    j24 += j14;
                                                }
                                                j22 = j11;
                                                hashMap4 = hashMap;
                                                z12 = z22;
                                                arrayList4 = arrayList8;
                                                i12 = i24;
                                                hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                part2 = part;
                                                str13 = str6;
                                                str7 = str5;
                                                str8 = str19;
                                                arrayList6 = arrayList2;
                                                str11 = str2;
                                            } else {
                                                i11 = i12;
                                                ArrayList arrayList9 = arrayList4;
                                                if (!next.startsWith("#")) {
                                                    String segmentEncryptionIV3 = getSegmentEncryptionIV(j11, str6, str19);
                                                    long j32 = j11 + 1;
                                                    String replaceVariableReferences = replaceVariableReferences(next, hashMap2);
                                                    HlsMediaPlaylist.Segment segment4 = (HlsMediaPlaylist.Segment) hashMap3.get(replaceVariableReferences);
                                                    int i26 = (j28 > -1 ? 1 : (j28 == -1 ? 0 : -1));
                                                    if (i26 == 0) {
                                                        j12 = 0;
                                                    } else {
                                                        if (z21 && segment == null && segment4 == null) {
                                                            segment4 = new HlsMediaPlaylist.Segment(replaceVariableReferences, 0, j18, (String) null, (String) null);
                                                            hashMap3.put(replaceVariableReferences, segment4);
                                                        }
                                                        j12 = j18;
                                                    }
                                                    if (drmInitData3 != null || treeMap.isEmpty()) {
                                                        j13 = j32;
                                                        z13 = false;
                                                        drmInitData = drmInitData3;
                                                    } else {
                                                        j13 = j32;
                                                        z13 = false;
                                                        DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        drmInitData = new DrmInitData(str5, schemeDataArr3);
                                                        if (drmInitData2 == null) {
                                                            drmInitData2 = getPlaylistProtectionSchemes(str5, schemeDataArr3);
                                                        }
                                                    }
                                                    ArrayList arrayList10 = arrayList9;
                                                    arrayList10.add(new HlsMediaPlaylist.Segment(replaceVariableReferences, segment != null ? segment : segment4, str12, j23, i15, j21, drmInitData, str6, segmentEncryptionIV3, j12, j28, z19, arrayList5));
                                                    j19 = j21 + j23;
                                                    arrayList5 = new ArrayList();
                                                    if (i26 != 0) {
                                                        j12 += j28;
                                                    }
                                                    j18 = j12;
                                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    drmInitData3 = drmInitData;
                                                    str3 = str19;
                                                    z19 = z13;
                                                    j23 = 0;
                                                    j21 = j19;
                                                    j22 = j13;
                                                    z12 = z22;
                                                    i12 = i11;
                                                    str12 = str2;
                                                    j28 = -1;
                                                    str13 = str6;
                                                    str15 = str5;
                                                    arrayList4 = arrayList10;
                                                    hashMap4 = hashMap;
                                                    arrayList6 = arrayList2;
                                                    str11 = str12;
                                                    part2 = part;
                                                } else {
                                                    arrayList3 = arrayList9;
                                                    j22 = j11;
                                                    str8 = str19;
                                                    arrayList4 = arrayList3;
                                                    hashMap4 = hashMap;
                                                    z12 = z22;
                                                    i12 = i11;
                                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                                    part2 = part;
                                                    str13 = str6;
                                                    str7 = str5;
                                                    arrayList6 = arrayList2;
                                                    str11 = str2;
                                                }
                                            }
                                        }
                                    }
                                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                                    str15 = str5;
                                    str9 = str19;
                                    arrayList6 = arrayList2;
                                    str11 = str2;
                                }
                                hlsMasterPlaylist2 = hlsMasterPlaylist;
                            }
                        }
                        boolean z23 = z22;
                        str13 = str4;
                        z16 = z23;
                    }
                    hashMap = hashMap4;
                    arrayList3 = arrayList4;
                    j22 = j11;
                    str8 = str19;
                    arrayList4 = arrayList3;
                    hashMap4 = hashMap;
                    z12 = z22;
                    i12 = i11;
                    hlsMediaPlaylist2 = hlsMediaPlaylist;
                    part2 = part;
                    str13 = str6;
                    str7 = str5;
                    arrayList6 = arrayList2;
                    str11 = str2;
                    hlsMasterPlaylist2 = hlsMasterPlaylist;
                }
                str14 = str19;
                z16 = z22;
                str13 = str18;
            }
        }
        boolean z24 = z16;
        int i27 = i12;
        ArrayList arrayList11 = arrayList6;
        HlsMediaPlaylist.Part part3 = part2;
        HashMap hashMap6 = hashMap4;
        ArrayList arrayList12 = arrayList4;
        if (part3 != null) {
            arrayList5.add(part3);
        }
        if (j16 != 0) {
            arrayList = arrayList5;
            z11 = true;
        } else {
            arrayList = arrayList5;
            z11 = false;
        }
        return new HlsMediaPlaylist(i27, str, arrayList11, j25, z24, j16, z17, i13, j17, i14, j26, j27, z15, z18, z11, drmInitData2, arrayList12, arrayList, serverControl2, hashMap6);
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? BOOLEAN_TRUE.equals(matcher.group(1)) : z11;
    }

    private static double parseOptionalDoubleAttr(String str, Pattern pattern, double d11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.checkNotNull(matcher.group(1))) : d11;
    }

    private static int parseOptionalIntAttr(String str, Pattern pattern, int i11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))) : i11;
    }

    private static long parseOptionalLongAttr(String str, Pattern pattern, long j11) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(1))) : j11;
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, (String) null, map);
    }

    private static int parseRoleFlags(String str, Map<String, String> map) {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, REGEX_CHARACTERISTICS, map);
        int i11 = 0;
        if (TextUtils.isEmpty(parseOptionalStringAttr)) {
            return 0;
        }
        String[] split = Util.split(parseOptionalStringAttr, Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (Util.contains(split, "public.accessibility.describes-video")) {
            i11 = 512;
        }
        if (Util.contains(split, "public.accessibility.transcribes-spoken-dialog")) {
            i11 |= 4096;
        }
        if (Util.contains(split, "public.accessibility.describes-music-and-sound")) {
            i11 |= 1024;
        }
        return Util.contains(split, "public.easy-to-read") ? i11 | 8192 : i11;
    }

    private static int parseSelectionFlags(String str) {
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false);
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            parseOptionalBooleanAttribute |= true;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? parseOptionalBooleanAttribute | true ? 1 : 0 : parseOptionalBooleanAttribute ? 1 : 0;
    }

    private static HlsMediaPlaylist.ServerControl parseServerControl(String str) {
        String str2 = str;
        double parseOptionalDoubleAttr = parseOptionalDoubleAttr(str2, REGEX_CAN_SKIP_UNTIL, -9.223372036854776E18d);
        long j11 = -9223372036854775807L;
        long j12 = parseOptionalDoubleAttr == -9.223372036854776E18d ? -9223372036854775807L : (long) (parseOptionalDoubleAttr * 1000000.0d);
        boolean parseOptionalBooleanAttribute = parseOptionalBooleanAttribute(str2, REGEX_CAN_SKIP_DATE_RANGES, false);
        double parseOptionalDoubleAttr2 = parseOptionalDoubleAttr(str2, REGEX_HOLD_BACK, -9.223372036854776E18d);
        long j13 = parseOptionalDoubleAttr2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (parseOptionalDoubleAttr2 * 1000000.0d);
        double parseOptionalDoubleAttr3 = parseOptionalDoubleAttr(str2, REGEX_PART_HOLD_BACK, -9.223372036854776E18d);
        if (parseOptionalDoubleAttr3 != -9.223372036854776E18d) {
            j11 = (long) (parseOptionalDoubleAttr3 * 1000000.0d);
        }
        return new HlsMediaPlaylist.ServerControl(j12, parseOptionalBooleanAttribute, j13, j11, parseOptionalBooleanAttribute(str2, REGEX_CAN_BLOCK_RELOAD, false));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String parseOptionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (parseOptionalStringAttr != null) {
            return parseOptionalStringAttr;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb2 = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb2.append("Couldn't match ");
        sb2.append(pattern2);
        sb2.append(" in ");
        sb2.append(str);
        throw new ParserException(sb2.toString());
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z11, int i11) throws IOException {
        while (i11 != -1 && Character.isWhitespace(i11) && (z11 || !Util.isLinebreak(i11))) {
            i11 = bufferedReader.read();
        }
        return i11;
    }

    public HlsPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.masterPlaylist = hlsMasterPlaylist;
        this.previousMediaPlaylist = hlsMediaPlaylist;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String parseOptionalStringAttr(java.lang.String r0, java.util.regex.Pattern r1, java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0016
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L_0x0016:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0023
            if (r2 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            java.lang.String r2 = replaceVariableReferences(r2, r3)
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.parseOptionalStringAttr(java.lang.String, java.util.regex.Pattern, java.lang.String, java.util.Map):java.lang.String");
    }

    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (checkPlaylistHeader(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith(TAG_STREAM_INF)) {
                                if (trim.startsWith(TAG_TARGET_DURATION) || trim.startsWith(TAG_MEDIA_SEQUENCE) || trim.startsWith(TAG_MEDIA_DURATION) || trim.startsWith(TAG_KEY) || trim.startsWith(TAG_BYTERANGE) || trim.equals(TAG_DISCONTINUITY) || trim.equals(TAG_DISCONTINUITY_SEQUENCE)) {
                                    break;
                                } else if (trim.equals(TAG_ENDLIST)) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                HlsMasterPlaylist parseMasterPlaylist = parseMasterPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                                Util.closeQuietly((Closeable) bufferedReader);
                                return parseMasterPlaylist;
                            }
                        }
                    } else {
                        Util.closeQuietly((Closeable) bufferedReader);
                        throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                    }
                }
                arrayDeque.add(trim);
                return parseMediaPlaylist(this.masterPlaylist, this.previousMediaPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
        } finally {
            Util.closeQuietly((Closeable) bufferedReader);
        }
    }
}
