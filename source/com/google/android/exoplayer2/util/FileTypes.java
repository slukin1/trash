package com.google.android.exoplayer2.util;

import android.net.Uri;
import com.luck.picture.lib.config.PictureMimeType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

public final class FileTypes {
    public static final int AC3 = 0;
    public static final int AC4 = 1;
    public static final int ADTS = 2;
    public static final int AMR = 3;
    private static final String EXTENSION_AAC = ".aac";
    private static final String EXTENSION_AC3 = ".ac3";
    private static final String EXTENSION_AC4 = ".ac4";
    private static final String EXTENSION_ADTS = ".adts";
    private static final String EXTENSION_AMR = ".amr";
    private static final String EXTENSION_EC3 = ".ec3";
    private static final String EXTENSION_FLAC = ".flac";
    private static final String EXTENSION_FLV = ".flv";
    private static final String EXTENSION_JPEG = ".jpeg";
    private static final String EXTENSION_JPG = ".jpg";
    private static final String EXTENSION_M2P = ".m2p";
    private static final String EXTENSION_MP3 = ".mp3";
    private static final String EXTENSION_MP4 = ".mp4";
    private static final String EXTENSION_MPEG = ".mpeg";
    private static final String EXTENSION_MPG = ".mpg";
    private static final String EXTENSION_OPUS = ".opus";
    private static final String EXTENSION_PREFIX_CMF = ".cmf";
    private static final String EXTENSION_PREFIX_M4 = ".m4";
    private static final String EXTENSION_PREFIX_MK = ".mk";
    private static final String EXTENSION_PREFIX_MP4 = ".mp4";
    private static final String EXTENSION_PREFIX_OG = ".og";
    private static final String EXTENSION_PREFIX_TS = ".ts";
    private static final String EXTENSION_PS = ".ps";
    private static final String EXTENSION_TS = ".ts";
    private static final String EXTENSION_VTT = ".vtt";
    private static final String EXTENSION_WAV = ".wav";
    private static final String EXTENSION_WAVE = ".wave";
    private static final String EXTENSION_WEBM = ".webm";
    private static final String EXTENSION_WEBVTT = ".webvtt";
    public static final int FLAC = 4;
    public static final int FLV = 5;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final int JPEG = 14;
    public static final int MATROSKA = 6;
    public static final int MP3 = 7;
    public static final int MP4 = 8;
    public static final int OGG = 9;
    public static final int PS = 10;
    public static final int TS = 11;
    public static final int UNKNOWN = -1;
    public static final int WAV = 12;
    public static final int WEBVTT = 13;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private FileTypes() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int inferFileTypeFromMimeType(java.lang.String r17) {
        /*
            r0 = -1
            if (r17 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = com.google.android.exoplayer2.util.MimeTypes.normalizeMimeType(r17)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = 14
            r4 = 13
            r5 = 12
            r6 = 11
            r7 = 10
            r8 = 9
            r9 = 8
            r10 = 7
            r11 = 6
            r12 = 5
            r13 = 4
            r14 = 3
            r15 = 1
            r16 = 0
            switch(r2) {
                case -2123537834: goto L_0x0156;
                case -1662384011: goto L_0x0149;
                case -1662384007: goto L_0x013c;
                case -1662095187: goto L_0x012f;
                case -1606874997: goto L_0x0123;
                case -1487394660: goto L_0x0117;
                case -1248337486: goto L_0x010b;
                case -1004728940: goto L_0x00fe;
                case -387023398: goto L_0x00f1;
                case -43467528: goto L_0x00e4;
                case 13915911: goto L_0x00d6;
                case 187078296: goto L_0x00c9;
                case 187078297: goto L_0x00bc;
                case 187078669: goto L_0x00af;
                case 187090232: goto L_0x00a2;
                case 187091926: goto L_0x0095;
                case 187099443: goto L_0x0088;
                case 1331848029: goto L_0x007a;
                case 1503095341: goto L_0x006d;
                case 1504578661: goto L_0x0060;
                case 1504619009: goto L_0x0053;
                case 1504831518: goto L_0x0046;
                case 1505118770: goto L_0x0039;
                case 2039520277: goto L_0x002b;
                default: goto L_0x0028;
            }
        L_0x0028:
            r1 = r0
            goto L_0x0162
        L_0x002b:
            java.lang.String r2 = "video/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0035
            goto L_0x0028
        L_0x0035:
            r1 = 23
            goto L_0x0162
        L_0x0039:
            java.lang.String r2 = "audio/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0042
            goto L_0x0028
        L_0x0042:
            r1 = 22
            goto L_0x0162
        L_0x0046:
            java.lang.String r2 = "audio/mpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x004f
            goto L_0x0028
        L_0x004f:
            r1 = 21
            goto L_0x0162
        L_0x0053:
            java.lang.String r2 = "audio/flac"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x005c
            goto L_0x0028
        L_0x005c:
            r1 = 20
            goto L_0x0162
        L_0x0060:
            java.lang.String r2 = "audio/eac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0069
            goto L_0x0028
        L_0x0069:
            r1 = 19
            goto L_0x0162
        L_0x006d:
            java.lang.String r2 = "audio/3gpp"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0076
            goto L_0x0028
        L_0x0076:
            r1 = 18
            goto L_0x0162
        L_0x007a:
            java.lang.String r2 = "video/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0084
            goto L_0x0028
        L_0x0084:
            r1 = 17
            goto L_0x0162
        L_0x0088:
            java.lang.String r2 = "audio/wav"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0091
            goto L_0x0028
        L_0x0091:
            r1 = 16
            goto L_0x0162
        L_0x0095:
            java.lang.String r2 = "audio/ogg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x009e
            goto L_0x0028
        L_0x009e:
            r1 = 15
            goto L_0x0162
        L_0x00a2:
            java.lang.String r2 = "audio/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ac
            goto L_0x0028
        L_0x00ac:
            r1 = r3
            goto L_0x0162
        L_0x00af:
            java.lang.String r2 = "audio/amr"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b9
            goto L_0x0028
        L_0x00b9:
            r1 = r4
            goto L_0x0162
        L_0x00bc:
            java.lang.String r2 = "audio/ac4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00c6
            goto L_0x0028
        L_0x00c6:
            r1 = r5
            goto L_0x0162
        L_0x00c9:
            java.lang.String r2 = "audio/ac3"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d3
            goto L_0x0028
        L_0x00d3:
            r1 = r6
            goto L_0x0162
        L_0x00d6:
            java.lang.String r2 = "video/x-flv"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00e1
            goto L_0x0028
        L_0x00e1:
            r1 = r7
            goto L_0x0162
        L_0x00e4:
            java.lang.String r2 = "application/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00ee
            goto L_0x0028
        L_0x00ee:
            r1 = r8
            goto L_0x0162
        L_0x00f1:
            java.lang.String r2 = "audio/x-matroska"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00fb
            goto L_0x0028
        L_0x00fb:
            r1 = r9
            goto L_0x0162
        L_0x00fe:
            java.lang.String r2 = "text/vtt"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0109
            goto L_0x0028
        L_0x0109:
            r1 = r10
            goto L_0x0162
        L_0x010b:
            java.lang.String r2 = "application/mp4"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0115
            goto L_0x0028
        L_0x0115:
            r1 = r11
            goto L_0x0162
        L_0x0117:
            java.lang.String r2 = "image/jpeg"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0121
            goto L_0x0028
        L_0x0121:
            r1 = r12
            goto L_0x0162
        L_0x0123:
            java.lang.String r2 = "audio/amr-wb"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012d
            goto L_0x0028
        L_0x012d:
            r1 = r13
            goto L_0x0162
        L_0x012f:
            java.lang.String r2 = "video/webm"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x013a
            goto L_0x0028
        L_0x013a:
            r1 = r14
            goto L_0x0162
        L_0x013c:
            java.lang.String r2 = "video/mp2t"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0147
            goto L_0x0028
        L_0x0147:
            r1 = 2
            goto L_0x0162
        L_0x0149:
            java.lang.String r2 = "video/mp2p"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0154
            goto L_0x0028
        L_0x0154:
            r1 = r15
            goto L_0x0162
        L_0x0156:
            java.lang.String r2 = "audio/eac3-joc"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0160
            goto L_0x0028
        L_0x0160:
            r1 = r16
        L_0x0162:
            switch(r1) {
                case 0: goto L_0x0173;
                case 1: goto L_0x0172;
                case 2: goto L_0x0171;
                case 3: goto L_0x0170;
                case 4: goto L_0x016f;
                case 5: goto L_0x016e;
                case 6: goto L_0x016d;
                case 7: goto L_0x016c;
                case 8: goto L_0x0170;
                case 9: goto L_0x0170;
                case 10: goto L_0x016b;
                case 11: goto L_0x0173;
                case 12: goto L_0x016a;
                case 13: goto L_0x016f;
                case 14: goto L_0x016d;
                case 15: goto L_0x0169;
                case 16: goto L_0x0168;
                case 17: goto L_0x016d;
                case 18: goto L_0x016f;
                case 19: goto L_0x0173;
                case 20: goto L_0x0167;
                case 21: goto L_0x0166;
                case 22: goto L_0x0170;
                case 23: goto L_0x0170;
                default: goto L_0x0165;
            }
        L_0x0165:
            return r0
        L_0x0166:
            return r10
        L_0x0167:
            return r13
        L_0x0168:
            return r5
        L_0x0169:
            return r8
        L_0x016a:
            return r15
        L_0x016b:
            return r12
        L_0x016c:
            return r4
        L_0x016d:
            return r9
        L_0x016e:
            return r3
        L_0x016f:
            return r14
        L_0x0170:
            return r11
        L_0x0171:
            return r6
        L_0x0172:
            return r7
        L_0x0173:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.FileTypes.inferFileTypeFromMimeType(java.lang.String):int");
    }

    public static int inferFileTypeFromResponseHeaders(Map<String, List<String>> map) {
        List list = map.get("Content-Type");
        return inferFileTypeFromMimeType((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    public static int inferFileTypeFromUri(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC3) || lastPathSegment.endsWith(EXTENSION_EC3)) {
            return 0;
        }
        if (lastPathSegment.endsWith(EXTENSION_AC4)) {
            return 1;
        }
        if (lastPathSegment.endsWith(EXTENSION_ADTS) || lastPathSegment.endsWith(EXTENSION_AAC)) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLAC)) {
            return 4;
        }
        if (lastPathSegment.endsWith(EXTENSION_FLV)) {
            return 5;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_MK, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_WEBM)) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(PictureMimeType.MP4) || lastPathSegment.startsWith(EXTENSION_PREFIX_M4, lastPathSegment.length() - 4) || lastPathSegment.startsWith(PictureMimeType.MP4, lastPathSegment.length() - 5) || lastPathSegment.startsWith(EXTENSION_PREFIX_CMF, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(EXTENSION_PREFIX_OG, lastPathSegment.length() - 4) || lastPathSegment.endsWith(EXTENSION_OPUS)) {
            return 9;
        }
        if (lastPathSegment.endsWith(EXTENSION_PS) || lastPathSegment.endsWith(EXTENSION_MPEG) || lastPathSegment.endsWith(EXTENSION_MPG) || lastPathSegment.endsWith(EXTENSION_M2P)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(EXTENSION_WAVE)) {
            return 12;
        }
        if (lastPathSegment.endsWith(EXTENSION_VTT) || lastPathSegment.endsWith(EXTENSION_WEBVTT)) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        return -1;
    }
}
