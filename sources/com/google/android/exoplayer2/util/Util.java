package com.google.android.exoplayer2.util;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseLongArray;
import android.view.Display;
import android.view.WindowManager;
import cn.sharesdk.framework.InnerShareParams;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.places.model.PlaceFields;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.math.DoubleMath;
import com.google.zxing.oned.Code39Reader;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.jmrtd.cbeff.ISO781611;

public final class Util {
    private static final int[] CRC32_BYTES_MSBF = {0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};
    private static final int[] CRC8_BYTES_MSBF = {0, 7, 14, 9, 28, 27, 18, 21, 56, 63, 54, 49, 36, 35, 42, 45, 112, 119, 126, 121, 108, 107, 98, 101, 72, 79, 70, 65, 84, 83, 90, 93, 224, 231, 238, 233, 252, 251, 242, 245, 216, 223, 214, 209, 196, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, 202, 205, 144, 151, ISO781611.SMT_DO_DS, 153, 140, 139, 130, 133, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 166, 161, 180, 179, 186, PsExtractor.PRIVATE_STREAM_1, 199, 192, 201, 206, 219, 220, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 210, 255, 248, 241, 246, 227, 228, 237, 234, 183, 176, 185, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 171, 172, 165, 162, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 136, 129, 134, 147, Code39Reader.ASTERISK_ENCODING, 157, 154, 39, 32, 41, 46, 59, 60, 53, 50, 31, 24, 17, 22, 3, 4, 13, 10, 87, 80, 89, 94, 75, 76, 69, 66, 111, 104, 97, 102, 115, 116, 125, 122, 137, 142, 135, 128, 149, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_IGNORE_VIDEO_STREAM_IN_COMMON_AUDIO_FORMATS, 155, 156, 177, 182, 191, 184, 173, DoubleMath.MAX_FACTORIAL, 163, 164, 249, 254, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 240, 229, 226, 235, 236, 193, 198, 207, 200, 221, 218, 211, 212, 105, 110, 103, 96, 117, 114, 123, 124, 81, 86, 95, 88, 77, 74, 67, 68, 25, 30, 23, 16, 5, 2, 11, 12, 33, 38, 47, 40, 61, 58, 51, 52, 78, 73, 64, 71, 82, 85, 92, 91, 118, 113, 120, 127, 106, 109, 100, 99, 62, 57, 48, 55, 34, 37, 44, 43, 6, 1, 8, 15, 26, 29, 20, 19, 174, 169, 160, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 178, 181, 188, 187, 150, 145, 152, 159, 138, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 132, 131, 222, 217, 208, TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 197, 204, 203, 230, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 232, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 250, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 243};
    public static final String DEVICE;
    public static final String DEVICE_DEBUG_INFO;
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final Pattern ESCAPED_CHARACTER_PATTERN = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final String ISM_DASH_FORMAT_EXTENSION = "format=mpd-time-csf";
    private static final String ISM_HLS_FORMAT_EXTENSION = "format=m3u8-aapl";
    private static final Pattern ISM_URL_PATTERN = Pattern.compile(".*\\.isml?(?:/(manifest(.*))?)?");
    public static final String MANUFACTURER;
    public static final String MODEL;
    public static final int SDK_INT;
    private static final String TAG = "Util";
    private static final Pattern XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final String[] additionalIsoLanguageReplacements = {"alb", "sq", "arm", "hy", "baq", "eu", "bur", "my", "tib", "bo", "chi", "zh", "cze", "cs", "dut", "nl", "ger", "de", "gre", "el", "fre", "fr", "geo", "ka", "ice", "is", "mac", "mk", "mao", "mi", "may", "ms", "per", "fa", "rum", "ro", "scc", "hbs-srp", "slo", "sk", "wel", "cy", "id", "ms-ind", "iw", "he", "heb", "he", "ji", "yi", "in", "ms-ind", "ind", "ms-ind", "nb", "no-nob", "nob", "no-nob", "nn", "no-nno", "nno", "no-nno", "tw", "ak-twi", "twi", "ak-twi", "bs", "hbs-bos", "bos", "hbs-bos", "hr", "hbs-hrv", "hrv", "hbs-hrv", InnerShareParams.SUBREDDIT, "hbs-srp", "srp", "hbs-srp", "cmn", "zh-cmn", "hak", "zh-hak", "nan", "zh-nan", "hsn", "zh-hsn"};
    private static final String[] isoLegacyTagReplacements = {"i-lux", "lb", "i-hak", "zh-hak", "i-navajo", "nv", "no-bok", "no-nob", "no-nyn", "no-nno", "zh-guoyu", "zh-cmn", "zh-hakka", "zh-hak", "zh-min-nan", "zh-nan", "zh-xiang", "zh-hsn"};
    private static HashMap<String, String> languageTagReplacementMap;

    static {
        int i11;
        String str = Build.VERSION.CODENAME;
        if ("S".equals(str)) {
            i11 = 31;
        } else {
            i11 = "R".equals(str) ? 30 : Build.VERSION.SDK_INT;
        }
        SDK_INT = i11;
        String str2 = Build.DEVICE;
        DEVICE = str2;
        String str3 = Build.MANUFACTURER;
        MANUFACTURER = str3;
        String str4 = Build.MODEL;
        MODEL = str4;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 17 + String.valueOf(str4).length() + String.valueOf(str3).length());
        sb2.append(str2);
        sb2.append(", ");
        sb2.append(str4);
        sb2.append(", ");
        sb2.append(str3);
        sb2.append(", ");
        sb2.append(i11);
        DEVICE_DEBUG_INFO = sb2.toString();
    }

    private Util() {
    }

    public static long addWithOverflowDefault(long j11, long j12, long j13) {
        long j14 = j11 + j12;
        return ((j11 ^ j14) & (j12 ^ j14)) < 0 ? j13 : j14;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchCeil(int[] r2, int r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Arrays.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x0008
            int r3 = ~r0
            goto L_0x0018
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r2.length
            if (r0 >= r1) goto L_0x0012
            r1 = r2[r0]
            if (r1 != r3) goto L_0x0012
            goto L_0x0008
        L_0x0012:
            if (r4 == 0) goto L_0x0017
            int r3 = r0 + -1
            goto L_0x0018
        L_0x0017:
            r3 = r0
        L_0x0018:
            if (r5 == 0) goto L_0x0021
            int r2 = r2.length
            int r2 = r2 + -1
            int r3 = java.lang.Math.min(r2, r3)
        L_0x0021:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.binarySearchCeil(int[], int, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchFloor(int[] r2, int r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Arrays.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0019
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0013
            r1 = r2[r0]
            if (r1 != r3) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            if (r4 == 0) goto L_0x0018
            int r2 = r0 + 1
            goto L_0x0019
        L_0x0018:
            r2 = r0
        L_0x0019:
            if (r5 == 0) goto L_0x0020
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.binarySearchFloor(int[], int, boolean, boolean):int");
    }

    @EnsuresNonNull({"#1"})
    public static <T> T castNonNull(T t11) {
        return t11;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T[] castNonNullTypeArray(T[] tArr) {
        return tArr;
    }

    public static int ceilDivide(int i11, int i12) {
        return ((i11 + i12) - 1) / i12;
    }

    public static boolean checkCleartextTrafficPermitted(MediaItem... mediaItemArr) {
        if (SDK_INT < 24) {
            return true;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                if (isTrafficRestricted(playbackProperties.uri)) {
                    return false;
                }
                for (int i11 = 0; i11 < mediaItem.playbackProperties.subtitles.size(); i11++) {
                    if (isTrafficRestricted(mediaItem.playbackProperties.subtitles.get(i11).uri)) {
                        return false;
                    }
                }
                continue;
            }
        }
        return true;
    }

    public static void closeQuietly(DataSource dataSource) {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int compareLong(long j11, long j12) {
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 == 0 ? 0 : 1;
    }

    public static int constrainValue(int i11, int i12, int i13) {
        return Math.max(i12, Math.min(i11, i13));
    }

    public static boolean contains(Object[] objArr, Object obj) {
        for (Object areEqual : objArr) {
            if (areEqual(areEqual, obj)) {
                return true;
            }
        }
        return false;
    }

    public static int crc32(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = CRC32_BYTES_MSBF[((i13 >>> 24) ^ (bArr[i11] & 255)) & 255] ^ (i13 << 8);
            i11++;
        }
        return i13;
    }

    public static int crc8(byte[] bArr, int i11, int i12, int i13) {
        while (i11 < i12) {
            i13 = CRC8_BYTES_MSBF[i13 ^ (bArr[i11] & 255)];
            i11++;
        }
        return i13;
    }

    public static Handler createHandler(Looper looper, Handler.Callback callback) {
        return new Handler(looper, callback);
    }

    public static Handler createHandlerForCurrentLooper() {
        return createHandlerForCurrentLooper((Handler.Callback) null);
    }

    public static Handler createHandlerForCurrentOrMainLooper() {
        return createHandlerForCurrentOrMainLooper((Handler.Callback) null);
    }

    private static HashMap<String, String> createIsoLanguageReplacementMap() {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap<String, String> hashMap = new HashMap<>(iSOLanguages.length + additionalIsoLanguageReplacements.length);
        int i11 = 0;
        for (String str : iSOLanguages) {
            try {
                String iSO3Language = new Locale(str).getISO3Language();
                if (!TextUtils.isEmpty(iSO3Language)) {
                    hashMap.put(iSO3Language, str);
                }
            } catch (MissingResourceException unused) {
            }
        }
        while (true) {
            String[] strArr = additionalIsoLanguageReplacements;
            if (i11 >= strArr.length) {
                return hashMap;
            }
            hashMap.put(strArr[i11], strArr[i11 + 1]);
            i11 += 2;
        }
    }

    public static File createTempDirectory(Context context, String str) throws IOException {
        File createTempFile = createTempFile(context, str);
        createTempFile.delete();
        createTempFile.mkdir();
        return createTempFile;
    }

    public static File createTempFile(Context context, String str) throws IOException {
        return File.createTempFile(str, (String) null, (File) Assertions.checkNotNull(context.getCacheDir()));
    }

    public static String escapeFileName(String str) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            if (shouldEscapeCharacter(str.charAt(i13))) {
                i12++;
            }
        }
        if (i12 == 0) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder((i12 * 2) + length);
        while (i12 > 0) {
            int i14 = i11 + 1;
            char charAt = str.charAt(i11);
            if (shouldEscapeCharacter(charAt)) {
                sb2.append('%');
                sb2.append(Integer.toHexString(charAt));
                i12--;
            } else {
                sb2.append(charAt);
            }
            i11 = i14;
        }
        if (i11 < length) {
            sb2.append(str, i11, length);
        }
        return sb2.toString();
    }

    public static Uri fixSmoothStreamingIsmManifestUri(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return uri;
        }
        Matcher matcher = ISM_URL_PATTERN.matcher(Ascii.toLowerCase(path));
        return (!matcher.matches() || matcher.group(1) != null) ? uri : Uri.withAppendedPath(uri, "Manifest");
    }

    public static String formatInvariant(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String fromUtf8Bytes(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    public static String getAdaptiveMimeTypeForContentType(int i11) {
        if (i11 == 0) {
            return MimeTypes.APPLICATION_MPD;
        }
        if (i11 == 1) {
            return MimeTypes.APPLICATION_SS;
        }
        if (i11 != 2) {
            return null;
        }
        return MimeTypes.APPLICATION_M3U8;
    }

    public static int getAudioContentTypeForStreamType(int i11) {
        if (i11 != 0) {
            return (i11 == 1 || i11 == 2 || i11 == 4 || i11 == 5 || i11 == 8) ? 4 : 2;
        }
        return 1;
    }

    public static int getAudioTrackChannelConfig(int i11) {
        switch (i11) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return 1276;
            case 8:
                int i12 = SDK_INT;
                return (i12 < 23 && i12 < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public static int getAudioUsageForStreamType(int i11) {
        if (i11 == 0) {
            return 2;
        }
        if (i11 == 1) {
            return 13;
        }
        if (i11 == 2) {
            return 6;
        }
        int i12 = 4;
        if (i11 != 4) {
            i12 = 5;
            if (i11 != 5) {
                return i11 != 8 ? 1 : 3;
            }
        }
        return i12;
    }

    public static int getBigEndianInt(ByteBuffer byteBuffer, int i11) {
        int i12 = byteBuffer.getInt(i11);
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? i12 : Integer.reverseBytes(i12);
    }

    public static byte[] getBytesFromHexString(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) ((Character.digit(str.charAt(i12), 16) << 4) + Character.digit(str.charAt(i12 + 1), 16));
        }
        return bArr;
    }

    public static int getCodecCountOfType(String str, int i11) {
        int i12 = 0;
        for (String trackTypeOfCodec : splitCodecs(str)) {
            if (i11 == MimeTypes.getTrackTypeOfCodec(trackTypeOfCodec)) {
                i12++;
            }
        }
        return i12;
    }

    public static String getCodecsOfType(String str, int i11) {
        String[] splitCodecs = splitCodecs(str);
        if (splitCodecs.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : splitCodecs) {
            if (i11 == MimeTypes.getTrackTypeOfCodec(str2)) {
                if (sb2.length() > 0) {
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb2.append(str2);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    public static String getCommaDelimitedSimpleClassNames(Object[] objArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < objArr.length; i11++) {
            sb2.append(objArr[i11].getClass().getSimpleName());
            if (i11 < objArr.length - 1) {
                sb2.append(", ");
            }
        }
        return sb2.toString();
    }

    public static String getCountryCode(Context context) {
        TelephonyManager telephonyManager;
        if (!(context == null || (telephonyManager = (TelephonyManager) context.getSystemService(PlaceFields.PHONE)) == null)) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Ascii.toUpperCase(networkCountryIso);
            }
        }
        return Ascii.toUpperCase(Locale.getDefault().getCountry());
    }

    public static Point getCurrentDisplayModeSize(Context context) {
        return getCurrentDisplayModeSize(context, ((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay());
    }

    public static Looper getCurrentOrMainLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper != null ? myLooper : Looper.getMainLooper();
    }

    public static Uri getDataUriForString(String str, String str2) {
        String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(encodeToString).length());
        sb2.append("data:");
        sb2.append(str);
        sb2.append(";base64,");
        sb2.append(encodeToString);
        return Uri.parse(sb2.toString());
    }

    private static void getDisplaySizeV16(Display display, Point point) {
        display.getSize(point);
    }

    private static void getDisplaySizeV17(Display display, Point point) {
        display.getRealSize(point);
    }

    private static void getDisplaySizeV23(Display display, Point point) {
        Display.Mode mode = display.getMode();
        point.x = mode.getPhysicalWidth();
        point.y = mode.getPhysicalHeight();
    }

    public static UUID getDrmUuid(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        lowerCase.hashCode();
        char c11 = 65535;
        switch (lowerCase.hashCode()) {
            case -1860423953:
                if (lowerCase.equals("playready")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1400551171:
                if (lowerCase.equals("widevine")) {
                    c11 = 1;
                    break;
                }
                break;
            case 790309106:
                if (lowerCase.equals("clearkey")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return C.PLAYREADY_UUID;
            case 1:
                return C.WIDEVINE_UUID;
            case 2:
                return C.CLEARKEY_UUID;
            default:
                try {
                    return UUID.fromString(str);
                } catch (RuntimeException unused) {
                    return null;
                }
        }
    }

    public static int getIntegerCodeForString(String str) {
        int length = str.length();
        Assertions.checkArgument(length <= 4);
        char c11 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            c11 = (c11 << 8) | str.charAt(i11);
        }
        return c11;
    }

    public static String getLocaleLanguageTag(Locale locale) {
        return SDK_INT >= 21 ? getLocaleLanguageTagV21(locale) : locale.toString();
    }

    private static String getLocaleLanguageTagV21(Locale locale) {
        return locale.toLanguageTag();
    }

    public static long getMediaDurationForPlayoutDuration(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(((double) j11) * ((double) f11));
    }

    public static long getNowUnixTimeMs(long j11) {
        if (j11 == -9223372036854775807L) {
            return System.currentTimeMillis();
        }
        return j11 + SystemClock.elapsedRealtime();
    }

    public static int getPcmEncoding(int i11) {
        if (i11 == 8) {
            return 3;
        }
        if (i11 == 16) {
            return 2;
        }
        if (i11 == 24) {
            return 536870912;
        }
        if (i11 != 32) {
            return 0;
        }
        return C.ENCODING_PCM_32BIT;
    }

    public static Format getPcmFormat(int i11, int i12, int i13) {
        return new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setChannelCount(i12).setSampleRate(i13).setPcmEncoding(i11).build();
    }

    public static int getPcmFrameSize(int i11, int i12) {
        if (i11 != 2) {
            if (i11 == 3) {
                return i12;
            }
            if (i11 != 4) {
                if (i11 != 268435456) {
                    if (i11 == 536870912) {
                        return i12 * 3;
                    }
                    if (i11 != 805306368) {
                        throw new IllegalArgumentException();
                    }
                }
            }
            return i12 * 4;
        }
        return i12 * 2;
    }

    public static long getPlayoutDurationForMediaDuration(long j11, float f11) {
        return f11 == 1.0f ? j11 : Math.round(((double) j11) / ((double) f11));
    }

    public static int getStreamTypeForAudioUsage(int i11) {
        if (i11 == 13) {
            return 1;
        }
        switch (i11) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    public static String getStringForTime(StringBuilder sb2, Formatter formatter, long j11) {
        if (j11 == -9223372036854775807L) {
            j11 = 0;
        }
        String str = j11 < 0 ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : "";
        long abs = (Math.abs(j11) + 500) / 1000;
        long j12 = abs % 60;
        long j13 = (abs / 60) % 60;
        long j14 = abs / 3600;
        sb2.setLength(0);
        if (j14 > 0) {
            return formatter.format("%s%d:%02d:%02d", new Object[]{str, Long.valueOf(j14), Long.valueOf(j13), Long.valueOf(j12)}).toString();
        }
        return formatter.format("%s%02d:%02d", new Object[]{str, Long.valueOf(j13), Long.valueOf(j12)}).toString();
    }

    public static String[] getSystemLanguageCodes() {
        String[] systemLocales = getSystemLocales();
        for (int i11 = 0; i11 < systemLocales.length; i11++) {
            systemLocales[i11] = normalizeLanguageCode(systemLocales[i11]);
        }
        return systemLocales;
    }

    private static String[] getSystemLocales() {
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (SDK_INT >= 24) {
            return getSystemLocalesV24(configuration);
        }
        return new String[]{getLocaleLanguageTag(configuration.locale)};
    }

    private static String[] getSystemLocalesV24(Configuration configuration) {
        return split(configuration.getLocales().toLanguageTags(), Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e11) {
            String valueOf = String.valueOf(str);
            Log.e(TAG, valueOf.length() != 0 ? "Failed to read system property ".concat(valueOf) : new String("Failed to read system property "), e11);
            return null;
        }
    }

    public static String getTrackTypeString(int i11) {
        if (i11 == 0) {
            return "default";
        }
        if (i11 == 1) {
            return "audio";
        }
        if (i11 == 2) {
            return "video";
        }
        if (i11 == 3) {
            return "text";
        }
        if (i11 == 5) {
            return "metadata";
        }
        if (i11 == 6) {
            return "camera motion";
        }
        if (i11 == 7) {
            return "none";
        }
        if (i11 < 10000) {
            return "?";
        }
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append("custom (");
        sb2.append(i11);
        sb2.append(")");
        return sb2.toString();
    }

    public static String getUserAgent(Context context, String str) {
        String str2;
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "?";
        }
        String str3 = Build.VERSION.RELEASE;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(str2);
        sb2.append(" (Linux;Android ");
        sb2.append(str3);
        sb2.append(") ");
        sb2.append(ExoPlayerLibraryInfo.VERSION_SLASHY);
        return sb2.toString();
    }

    public static byte[] getUtf8Bytes(String str) {
        return str.getBytes(Charsets.UTF_8);
    }

    public static byte[] gzip(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            throw new AssertionError(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static int inferContentType(Uri uri, String str) {
        if (TextUtils.isEmpty(str)) {
            return inferContentType(uri);
        }
        String valueOf = String.valueOf(str);
        return inferContentType(valueOf.length() != 0 ? InstructionFileId.DOT.concat(valueOf) : new String(InstructionFileId.DOT));
    }

    public static int inferContentTypeForUriAndMimeType(Uri uri, String str) {
        if (str == null) {
            return inferContentType(uri);
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -979127466:
                if (str.equals(MimeTypes.APPLICATION_M3U8)) {
                    c11 = 0;
                    break;
                }
                break;
            case -156749520:
                if (str.equals(MimeTypes.APPLICATION_SS)) {
                    c11 = 1;
                    break;
                }
                break;
            case 64194685:
                if (str.equals(MimeTypes.APPLICATION_MPD)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1154777587:
                if (str.equals(MimeTypes.APPLICATION_RTSP)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 2;
            case 1:
                return 1;
            case 2:
                return 0;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    public static boolean inflate(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, Inflater inflater) {
        if (parsableByteArray.bytesLeft() <= 0) {
            return false;
        }
        if (parsableByteArray2.capacity() < parsableByteArray.bytesLeft()) {
            parsableByteArray2.ensureCapacity(parsableByteArray.bytesLeft() * 2);
        }
        if (inflater == null) {
            inflater = new Inflater();
        }
        inflater.setInput(parsableByteArray.getData(), parsableByteArray.getPosition(), parsableByteArray.bytesLeft());
        int i11 = 0;
        while (true) {
            try {
                i11 += inflater.inflate(parsableByteArray2.getData(), i11, parsableByteArray2.capacity() - i11);
                if (inflater.finished()) {
                    parsableByteArray2.setLimit(i11);
                    inflater.reset();
                    return true;
                } else if (inflater.needsDictionary()) {
                    break;
                } else if (inflater.needsInput()) {
                    break;
                } else if (i11 == parsableByteArray2.capacity()) {
                    parsableByteArray2.ensureCapacity(parsableByteArray2.capacity() * 2);
                }
            } catch (DataFormatException unused) {
                return false;
            } finally {
                inflater.reset();
            }
        }
        return false;
    }

    public static boolean isEncodingHighResolutionPcm(int i11) {
        return i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static boolean isEncodingLinearPcm(int i11) {
        return i11 == 3 || i11 == 2 || i11 == 268435456 || i11 == 536870912 || i11 == 805306368 || i11 == 4;
    }

    public static boolean isLinebreak(int i11) {
        return i11 == 10 || i11 == 13;
    }

    public static boolean isLocalFileUri(Uri uri) {
        String scheme = uri.getScheme();
        return TextUtils.isEmpty(scheme) || "file".equals(scheme);
    }

    private static boolean isTrafficRestricted(Uri uri) {
        return "http".equals(uri.getScheme()) && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted((String) Assertions.checkNotNull(uri.getHost()));
    }

    public static boolean isTv(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$newSingleThreadExecutor$0(String str, Runnable runnable) {
        return new Thread(runnable, str);
    }

    public static int linearSearch(int[] iArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            if (iArr[i12] == i11) {
                return i12;
            }
        }
        return -1;
    }

    private static String maybeReplaceLegacyLanguageTags(String str) {
        int i11 = 0;
        while (true) {
            String[] strArr = isoLegacyTagReplacements;
            if (i11 >= strArr.length) {
                return str;
            }
            if (str.startsWith(strArr[i11])) {
                String valueOf = String.valueOf(strArr[i11 + 1]);
                String valueOf2 = String.valueOf(str.substring(strArr[i11].length()));
                return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            }
            i11 += 2;
        }
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, Uri... uriArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (Uri isLocalFileUri : uriArr) {
            if (isLocalFileUri(isLocalFileUri)) {
                return requestExternalStoragePermission(activity);
            }
        }
        return false;
    }

    public static long minValue(SparseLongArray sparseLongArray) {
        if (sparseLongArray.size() != 0) {
            long j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < sparseLongArray.size(); i11++) {
                j11 = Math.min(j11, sparseLongArray.valueAt(i11));
            }
            return j11;
        }
        throw new NoSuchElementException();
    }

    public static <T> void moveItems(List<T> list, int i11, int i12, int i13) {
        ArrayDeque arrayDeque = new ArrayDeque();
        for (int i14 = (i12 - i11) - 1; i14 >= 0; i14--) {
            arrayDeque.addFirst(list.remove(i11 + i14));
        }
        list.addAll(Math.min(i13, list.size()), arrayDeque);
    }

    public static ExecutorService newSingleThreadExecutor(String str) {
        return Executors.newSingleThreadExecutor(new f(str));
    }

    public static String normalizeLanguageCode(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace('_', '-');
        if (!replace.isEmpty() && !replace.equals(C.LANGUAGE_UNDETERMINED)) {
            str = replace;
        }
        String lowerCase = Ascii.toLowerCase(str);
        String str2 = splitAtFirst(lowerCase, Constants.ACCEPT_TIME_SEPARATOR_SERVER)[0];
        if (languageTagReplacementMap == null) {
            languageTagReplacementMap = createIsoLanguageReplacementMap();
        }
        String str3 = languageTagReplacementMap.get(str2);
        if (str3 != null) {
            String valueOf = String.valueOf(lowerCase.substring(str2.length()));
            lowerCase = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
            str2 = str3;
        }
        return ("no".equals(str2) || "i".equals(str2) || "zh".equals(str2)) ? maybeReplaceLegacyLanguageTags(lowerCase) : lowerCase;
    }

    public static <T> T[] nullSafeArrayAppend(T[] tArr, T t11) {
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[tArr.length] = t11;
        return castNonNullTypeArray(copyOf);
    }

    public static <T> T[] nullSafeArrayConcatenation(T[] tArr, T[] tArr2) {
        T[] copyOf = Arrays.copyOf(tArr, tArr.length + tArr2.length);
        System.arraycopy(tArr2, 0, copyOf, tArr.length, tArr2.length);
        return copyOf;
    }

    public static <T> T[] nullSafeArrayCopy(T[] tArr, int i11) {
        Assertions.checkArgument(i11 <= tArr.length);
        return Arrays.copyOf(tArr, i11);
    }

    public static <T> T[] nullSafeArrayCopyOfRange(T[] tArr, int i11, int i12) {
        boolean z11 = true;
        Assertions.checkArgument(i11 >= 0);
        if (i12 > tArr.length) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        return Arrays.copyOfRange(tArr, i11, i12);
    }

    public static <T> void nullSafeListToArray(List<T> list, T[] tArr) {
        Assertions.checkState(list.size() == tArr.length);
        list.toArray(tArr);
    }

    public static long parseXsDateTime(String str) throws ParserException {
        Matcher matcher = XS_DATE_TIME_PATTERN.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw new ParserException(valueOf.length() != 0 ? "Invalid date/time format: ".concat(valueOf) : new String("Invalid date/time format: "));
        }
        int i11 = 0;
        if (matcher.group(9) != null && !matcher.group(9).equalsIgnoreCase("Z")) {
            i11 = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
            if (Constants.ACCEPT_TIME_SEPARATOR_SERVER.equals(matcher.group(11))) {
                i11 *= -1;
            }
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregorianCalendar.clear();
        gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8))) {
            String valueOf2 = String.valueOf(matcher.group(8));
            gregorianCalendar.set(14, new BigDecimal(valueOf2.length() != 0 ? "0.".concat(valueOf2) : new String("0.")).movePointRight(3).intValue());
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        return i11 != 0 ? timeInMillis - ((long) (i11 * 60000)) : timeInMillis;
    }

    public static long parseXsDuration(String str) {
        Matcher matcher = XS_DURATION_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(str) * 3600.0d * 1000.0d);
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(matcher.group(1));
        String group = matcher.group(3);
        double d11 = 0.0d;
        double parseDouble = group != null ? Double.parseDouble(group) * 3.1556908E7d : 0.0d;
        String group2 = matcher.group(5);
        double parseDouble2 = parseDouble + (group2 != null ? Double.parseDouble(group2) * 2629739.0d : 0.0d);
        String group3 = matcher.group(7);
        double parseDouble3 = parseDouble2 + (group3 != null ? Double.parseDouble(group3) * 86400.0d : 0.0d);
        String group4 = matcher.group(10);
        double parseDouble4 = parseDouble3 + (group4 != null ? Double.parseDouble(group4) * 3600.0d : 0.0d);
        String group5 = matcher.group(12);
        double parseDouble5 = parseDouble4 + (group5 != null ? Double.parseDouble(group5) * 60.0d : 0.0d);
        String group6 = matcher.group(14);
        if (group6 != null) {
            d11 = Double.parseDouble(group6);
        }
        long j11 = (long) ((parseDouble5 + d11) * 1000.0d);
        return isEmpty ? -j11 : j11;
    }

    public static boolean postOrRun(Handler handler, Runnable runnable) {
        if (!handler.getLooper().getThread().isAlive()) {
            return false;
        }
        if (handler.getLooper() != Looper.myLooper()) {
            return handler.post(runnable);
        }
        runnable.run();
        return true;
    }

    public static boolean readBoolean(Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static byte[] readExactly(DataSource dataSource, int i11) throws IOException {
        byte[] bArr = new byte[i11];
        int i12 = 0;
        while (i12 < i11) {
            int read = dataSource.read(bArr, i12, i11 - i12);
            if (read != -1) {
                i12 += read;
            } else {
                StringBuilder sb2 = new StringBuilder(56);
                sb2.append("Not enough data could be read: ");
                sb2.append(i12);
                sb2.append(" < ");
                sb2.append(i11);
                throw new IllegalStateException(sb2.toString());
            }
        }
        return bArr;
    }

    public static byte[] readToEnd(DataSource dataSource) throws IOException {
        byte[] bArr = new byte[1024];
        int i11 = 0;
        int i12 = 0;
        while (i11 != -1) {
            if (i12 == bArr.length) {
                bArr = Arrays.copyOf(bArr, bArr.length * 2);
            }
            i11 = dataSource.read(bArr, i12, bArr.length - i12);
            if (i11 != -1) {
                i12 += i11;
            }
        }
        return Arrays.copyOf(bArr, i12);
    }

    public static void recursiveDelete(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File recursiveDelete : listFiles) {
                recursiveDelete(recursiveDelete);
            }
        }
        file.delete();
    }

    public static <T> void removeRange(List<T> list, int i11, int i12) {
        if (i11 < 0 || i12 > list.size() || i11 > i12) {
            throw new IllegalArgumentException();
        } else if (i11 != i12) {
            list.subList(i11, i12).clear();
        }
    }

    private static boolean requestExternalStoragePermission(Activity activity) {
        if (activity.checkSelfPermission(PermissionConfig.READ_EXTERNAL_STORAGE) == 0) {
            return false;
        }
        activity.requestPermissions(new String[]{PermissionConfig.READ_EXTERNAL_STORAGE}, 0);
        return true;
    }

    public static long scaleLargeTimestamp(long j11, long j12, long j13) {
        int i11 = (j13 > j12 ? 1 : (j13 == j12 ? 0 : -1));
        if (i11 >= 0 && j13 % j12 == 0) {
            return j11 / (j13 / j12);
        }
        if (i11 < 0 && j12 % j13 == 0) {
            return j11 * (j12 / j13);
        }
        return (long) (((double) j11) * (((double) j12) / ((double) j13)));
    }

    public static long[] scaleLargeTimestamps(List<Long> list, long j11, long j12) {
        int size = list.size();
        long[] jArr = new long[size];
        int i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
        int i12 = 0;
        if (i11 >= 0 && j12 % j11 == 0) {
            long j13 = j12 / j11;
            while (i12 < size) {
                jArr[i12] = list.get(i12).longValue() / j13;
                i12++;
            }
        } else if (i11 >= 0 || j11 % j12 != 0) {
            double d11 = ((double) j11) / ((double) j12);
            while (i12 < size) {
                jArr[i12] = (long) (((double) list.get(i12).longValue()) * d11);
                i12++;
            }
        } else {
            long j14 = j11 / j12;
            while (i12 < size) {
                jArr[i12] = list.get(i12).longValue() * j14;
                i12++;
            }
        }
        return jArr;
    }

    public static void scaleLargeTimestampsInPlace(long[] jArr, long j11, long j12) {
        int i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
        int i12 = 0;
        if (i11 >= 0 && j12 % j11 == 0) {
            long j13 = j12 / j11;
            while (i12 < jArr.length) {
                jArr[i12] = jArr[i12] / j13;
                i12++;
            }
        } else if (i11 >= 0 || j11 % j12 != 0) {
            double d11 = ((double) j11) / ((double) j12);
            while (i12 < jArr.length) {
                jArr[i12] = (long) (((double) jArr[i12]) * d11);
                i12++;
            }
        } else {
            long j14 = j11 / j12;
            while (i12 < jArr.length) {
                jArr[i12] = jArr[i12] * j14;
                i12++;
            }
        }
    }

    private static boolean shouldEscapeCharacter(char c11) {
        return c11 == '\"' || c11 == '%' || c11 == '*' || c11 == '/' || c11 == ':' || c11 == '<' || c11 == '\\' || c11 == '|' || c11 == '>' || c11 == '?';
    }

    public static void sneakyThrow(Throwable th2) {
        sneakyThrowInternal(th2);
    }

    private static <T extends Throwable> void sneakyThrowInternal(Throwable th2) throws Throwable {
        throw th2;
    }

    public static String[] split(String str, String str2) {
        return str.split(str2, -1);
    }

    public static String[] splitAtFirst(String str, String str2) {
        return str.split(str2, 2);
    }

    public static String[] splitCodecs(String str) {
        if (TextUtils.isEmpty(str)) {
            return new String[0];
        }
        return split(str.trim(), "(\\s*,\\s*)");
    }

    public static ComponentName startForegroundService(Context context, Intent intent) {
        if (SDK_INT >= 26) {
            return context.startForegroundService(intent);
        }
        return context.startService(intent);
    }

    public static long subtractWithOverflowDefault(long j11, long j12, long j13) {
        long j14 = j11 - j12;
        return ((j11 ^ j14) & (j12 ^ j11)) < 0 ? j13 : j14;
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase, String str) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase, "sqlite_master", "tbl_name = ?", new String[]{str}) > 0;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sb2.append(Character.forDigit((bArr[i11] >> 4) & 15, 16));
            sb2.append(Character.forDigit(bArr[i11] & 15, 16));
        }
        return sb2.toString();
    }

    public static long toLong(int i11, int i12) {
        return toUnsignedLong(i12) | (toUnsignedLong(i11) << 32);
    }

    public static long toUnsignedLong(int i11) {
        return ((long) i11) & 4294967295L;
    }

    public static CharSequence truncateAscii(CharSequence charSequence, int i11) {
        return charSequence.length() <= i11 ? charSequence : charSequence.subSequence(0, i11);
    }

    public static String unescapeFileName(String str) {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            if (str.charAt(i13) == '%') {
                i12++;
            }
        }
        if (i12 == 0) {
            return str;
        }
        int i14 = length - (i12 * 2);
        StringBuilder sb2 = new StringBuilder(i14);
        Matcher matcher = ESCAPED_CHARACTER_PATTERN.matcher(str);
        while (i12 > 0 && matcher.find()) {
            sb2.append(str, i11, matcher.start());
            sb2.append((char) Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1)), 16));
            i11 = matcher.end();
            i12--;
        }
        if (i11 < length) {
            sb2.append(str, i11, length);
        }
        if (sb2.length() != i14) {
            return null;
        }
        return sb2.toString();
    }

    public static void writeBoolean(Parcel parcel, boolean z11) {
        parcel.writeInt(z11 ? 1 : 0);
    }

    public static long ceilDivide(long j11, long j12) {
        return ((j11 + j12) - 1) / j12;
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long constrainValue(long j11, long j12, long j13) {
        return Math.max(j12, Math.min(j11, j13));
    }

    public static Handler createHandlerForCurrentLooper(Handler.Callback callback) {
        return createHandler((Looper) Assertions.checkStateNotNull(Looper.myLooper()), callback);
    }

    public static Handler createHandlerForCurrentOrMainLooper(Handler.Callback callback) {
        return createHandler(getCurrentOrMainLooper(), callback);
    }

    public static String fromUtf8Bytes(byte[] bArr, int i11, int i12) {
        return new String(bArr, i11, i12, Charsets.UTF_8);
    }

    public static float constrainValue(float f11, float f12, float f13) {
        return Math.max(f12, Math.min(f11, f13));
    }

    public static Point getCurrentDisplayModeSize(Context context, Display display) {
        String str;
        int i11 = SDK_INT;
        if (i11 <= 29 && display.getDisplayId() == 0 && isTv(context)) {
            if ("Sony".equals(MANUFACTURER) && MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                return new Point(3840, 2160);
            }
            if (i11 < 28) {
                str = getSystemProperty("sys.display-size");
            } else {
                str = getSystemProperty("vendor.display-size");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    String[] split = split(str.trim(), "x");
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            return new Point(parseInt, parseInt2);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                String valueOf = String.valueOf(str);
                Log.e(TAG, valueOf.length() != 0 ? "Invalid display size: ".concat(valueOf) : new String("Invalid display size: "));
            }
        }
        Point point = new Point();
        int i12 = SDK_INT;
        if (i12 >= 23) {
            getDisplaySizeV23(display, point);
        } else if (i12 >= 17) {
            getDisplaySizeV17(display, point);
        } else {
            getDisplaySizeV16(display, point);
        }
        return point;
    }

    public static int linearSearch(long[] jArr, long j11) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            if (jArr[i11] == j11) {
                return i11;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchCeil(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x001a
        L_0x0008:
            int r0 = r0 + 1
            int r1 = r3.length
            if (r0 >= r1) goto L_0x0014
            r1 = r3[r0]
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0014
            goto L_0x0008
        L_0x0014:
            if (r6 == 0) goto L_0x0019
            int r4 = r0 + -1
            goto L_0x001a
        L_0x0019:
            r4 = r0
        L_0x001a:
            if (r7 == 0) goto L_0x0023
            int r3 = r3.length
            int r3 = r3 + -1
            int r4 = java.lang.Math.min(r3, r4)
        L_0x0023:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.binarySearchCeil(long[], long, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int binarySearchFloor(long[] r3, long r4, boolean r6, boolean r7) {
        /*
            int r0 = java.util.Arrays.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r3 = -r0
            goto L_0x001b
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0015
            r1 = r3[r0]
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            if (r6 == 0) goto L_0x001a
            int r3 = r0 + 1
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            if (r7 == 0) goto L_0x0022
            r4 = 0
            int r3 = java.lang.Math.max(r4, r3)
        L_0x0022:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.binarySearchFloor(long[], long, boolean, boolean):int");
    }

    public static int inferContentType(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && Ascii.equalsIgnoreCase("rtsp", scheme)) {
            return 3;
        }
        String path = uri.getPath();
        if (path == null) {
            return 4;
        }
        return inferContentType(path);
    }

    public static boolean maybeRequestReadExternalStoragePermission(Activity activity, MediaItem... mediaItemArr) {
        if (SDK_INT < 23) {
            return false;
        }
        for (MediaItem mediaItem : mediaItemArr) {
            MediaItem.PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                if (isLocalFileUri(playbackProperties.uri)) {
                    return requestExternalStoragePermission(activity);
                }
                for (int i11 = 0; i11 < mediaItem.playbackProperties.subtitles.size(); i11++) {
                    if (isLocalFileUri(mediaItem.playbackProperties.subtitles.get(i11).uri)) {
                        return requestExternalStoragePermission(activity);
                    }
                }
                continue;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<? super T>> int binarySearchCeil(java.util.List<? extends java.lang.Comparable<? super T>> r3, T r4, boolean r5, boolean r6) {
        /*
            int r0 = java.util.Collections.binarySearch(r3, r4)
            if (r0 >= 0) goto L_0x0008
            int r4 = ~r0
            goto L_0x0023
        L_0x0008:
            int r1 = r3.size()
        L_0x000c:
            int r0 = r0 + 1
            if (r0 >= r1) goto L_0x001d
            java.lang.Object r2 = r3.get(r0)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r2.compareTo(r4)
            if (r2 != 0) goto L_0x001d
            goto L_0x000c
        L_0x001d:
            if (r5 == 0) goto L_0x0022
            int r4 = r0 + -1
            goto L_0x0023
        L_0x0022:
            r4 = r0
        L_0x0023:
            if (r6 == 0) goto L_0x002f
            int r3 = r3.size()
            int r3 = r3 + -1
            int r4 = java.lang.Math.min(r3, r4)
        L_0x002f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.binarySearchCeil(java.util.List, java.lang.Comparable, boolean, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends java.lang.Comparable<? super T>> int binarySearchFloor(java.util.List<? extends java.lang.Comparable<? super T>> r2, T r3, boolean r4, boolean r5) {
        /*
            int r0 = java.util.Collections.binarySearch(r2, r3)
            if (r0 >= 0) goto L_0x000a
            int r0 = r0 + 2
            int r2 = -r0
            goto L_0x0021
        L_0x000a:
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x001b
            java.lang.Object r1 = r2.get(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r1 = r1.compareTo(r3)
            if (r1 != 0) goto L_0x001b
            goto L_0x000a
        L_0x001b:
            if (r4 == 0) goto L_0x0020
            int r2 = r0 + 1
            goto L_0x0021
        L_0x0020:
            r2 = r0
        L_0x0021:
            if (r5 == 0) goto L_0x0028
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x0028:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.Util.binarySearchFloor(java.util.List, java.lang.Comparable, boolean, boolean):int");
    }

    public static int inferContentType(String str) {
        String lowerCase = Ascii.toLowerCase(str);
        if (lowerCase.endsWith(".mpd")) {
            return 0;
        }
        if (lowerCase.endsWith(".m3u8")) {
            return 2;
        }
        Matcher matcher = ISM_URL_PATTERN.matcher(lowerCase);
        if (!matcher.matches()) {
            return 4;
        }
        String group = matcher.group(2);
        if (group == null) {
            return 1;
        }
        if (group.contains(ISM_DASH_FORMAT_EXTENSION)) {
            return 0;
        }
        if (group.contains(ISM_HLS_FORMAT_EXTENSION)) {
            return 2;
        }
        return 1;
    }

    public static int binarySearchFloor(LongArray longArray, long j11, boolean z11, boolean z12) {
        int i11;
        int size = longArray.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            if (longArray.get(i13) < j11) {
                i12 = i13 + 1;
            } else {
                size = i13 - 1;
            }
        }
        if (z11 && (i11 = size + 1) < longArray.size() && longArray.get(i11) == j11) {
            return i11;
        }
        if (!z12 || size != -1) {
            return size;
        }
        return 0;
    }
}
