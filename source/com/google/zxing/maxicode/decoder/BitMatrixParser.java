package com.google.zxing.maxicode.decoder;

import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code39Reader;
import com.jumio.analytics.MobileEvents;
import com.luck.picture.lib.config.Crop;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import com.youth.banner.config.BannerConfig;
import okhttp3.internal.http.StatusLine;
import org.jmrtd.cbeff.ISO781611;

final class BitMatrixParser {
    private static final int[][] BITNR = {new int[]{121, 120, 127, 126, 133, 132, 139, 138, 145, 144, 151, 150, 157, 156, 163, 162, 169, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 174, 181, 180, 187, 186, 193, 192, 199, 198, -2, -2}, new int[]{123, 122, 129, 128, 135, 134, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 140, 147, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_IGNORE_VIDEO_STREAM_IN_COMMON_AUDIO_FORMATS, 153, 152, 159, ISO781611.SMT_DO_DS, 165, 164, 171, DoubleMath.MAX_FACTORIAL, 177, 176, 183, 182, PsExtractor.PRIVATE_STREAM_1, 188, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 201, 200, 816, -3}, new int[]{125, 124, 131, 130, 137, 136, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_ORIGINAL_VIDEO_INFO_CALLBACK_FROM_SURFACE_LISTENER, 142, 149, Code39Reader.ASTERISK_ENCODING, 155, 154, 161, 160, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 166, 173, 172, 179, 178, 185, 184, 191, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 197, 196, 203, 202, 818, 817}, new int[]{283, 282, 277, 276, 271, 270, 265, 264, 259, 258, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, 252, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 246, 241, 240, 235, 234, 229, 228, 223, 222, 217, 216, 211, 210, 205, 204, 819, -3}, new int[]{MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL, 284, 279, 278, TUIMessageBean.MSG_STATUS_READ, 272, 267, 266, TipsMessageBean.MSG_TYPE_GROUP_KICK, TipsMessageBean.MSG_TYPE_GROUP_QUITE, 255, 254, 249, 248, 243, 242, 237, 236, 231, 230, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 224, 219, 218, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 212, 207, 206, 821, 820}, new int[]{287, 286, 281, 280, TUIMessageBean.MSG_STATUS_REVOKE, TUIMessageBean.MSG_STATUS_DELETE, 269, 268, 263, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 257, 256, 251, 250, 245, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 238, 233, 232, 227, 226, 221, 220, TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS, 214, 209, 208, 822, -3}, new int[]{289, 288, 295, 294, 301, 300, 307, MobileEvents.EVENTTYPE_SDKPARAMETERS, 313, 312, MobileEvents.EVENTTYPE_PERFORMANCE, 318, 325, MTCorePrivatesApi.SDK_VERSION_CODE, 331, 330, 337, 336, 343, 342, 349, 348, 355, 354, 361, 360, 367, 366, 824, 823}, new int[]{291, 290, 297, 296, 303, 302, MobileEvents.EVENTTYPE_NETWORKCALL, StatusLine.HTTP_PERM_REDIRECT, MobileEvents.EVENTTYPE_CV, 314, 321, 320, 327, 326, 333, 332, 339, 338, 345, 344, 351, 350, 357, 356, 363, 362, 369, 368, 825, -3}, new int[]{293, 292, 299, 298, MobileEvents.EVENTTYPE_EXCEPTION, 304, 311, 310, MobileEvents.EVENTTYPE_MISC, MobileEvents.EVENTTYPE_REPORTING, 323, 322, 329, 328, 335, 334, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 340, 347, 346, 353, 352, 359, 358, 365, 364, 371, 370, 827, 826}, new int[]{409, 408, 403, 402, 397, 396, 391, 390, 79, 78, -2, -2, 13, 12, 37, 36, 2, -1, 44, 43, 109, 108, 385, b.f34945b, 379, 378, 373, 372, 828, -3}, new int[]{411, 410, 405, 404, 399, 398, 393, 392, 81, 80, 40, -2, 15, 14, 39, 38, 3, -1, -1, 45, 111, 110, 387, 386, 381, 380, 375, 374, 830, 829}, new int[]{413, 412, TPNativePlayerInitConfig.BOOL_ENABLE_COLOR_MANAGEMENT, TPNativePlayerInitConfig.BOOL_ENABLE_DROPFRAME_BY_REFRESHRATE, 401, 400, 395, 394, 83, 82, 41, -3, -3, -3, -3, -3, 5, 4, 47, 46, 113, 112, 389, 388, 383, 382, 377, 376, 831, -3}, new int[]{415, 414, StatusLine.HTTP_MISDIRECTED_REQUEST, 420, 427, 426, 103, 102, 55, 54, 16, -3, -3, -3, -3, -3, -3, -3, 20, 19, 85, 84, 433, 432, 439, 438, 445, 444, 833, 832}, new int[]{417, 416, 423, 422, 429, 428, 105, 104, 57, 56, -3, -3, -3, -3, -3, -3, -3, -3, 22, 21, 87, 86, 435, 434, PsExtractor.MPEG_PROGRAM_END_CODE, 440, 447, 446, 834, -3}, new int[]{419, 418, 425, 424, 431, 430, 107, 106, 59, 58, -3, -3, -3, -3, -3, -3, -3, -3, -3, 23, 89, 88, 437, 436, PsExtractor.SYSTEM_HEADER_START_CODE, PsExtractor.PACK_START_CODE, 449, 448, 836, 835}, new int[]{481, TXVodDownloadDataSource.QUALITY_480P, 475, 474, 469, 468, 48, -2, 30, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 0, 53, 52, 463, 462, 457, 456, 451, 450, 837, -3}, new int[]{483, 482, 477, 476, 471, 470, 49, -1, -2, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, -2, -1, 465, 464, 459, FacebookRequestErrorClassification.ESC_APP_NOT_INSTALLED, 453, 452, 839, 838}, new int[]{485, 484, 479, 478, 473, 472, 51, 50, 31, -3, -3, -3, -3, -3, -3, -3, -3, -3, -3, 1, -2, 42, 467, 466, 461, 460, 455, 454, 840, -3}, new int[]{487, 486, FacebookRequestErrorClassification.ESC_APP_INACTIVE, 492, 499, 498, 97, 96, 61, 60, -3, -3, -3, -3, -3, -3, -3, -3, -3, 26, 91, 90, 505, 504, 511, 510, 517, 516, 842, 841}, new int[]{489, 488, 495, 494, 501, 500, 99, 98, 63, 62, -3, -3, -3, -3, -3, -3, -3, -3, 28, 27, 93, 92, TPOptionalID.OPTION_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS, 506, 513, 512, 519, 518, 843, -3}, new int[]{491, 490, 497, 496, 503, 502, 101, 100, 65, 64, 17, -3, -3, -3, -3, -3, -3, -3, 18, 29, 95, 94, TPOptionalID.OPTION_ID_GLOBAL_BOOL_ENABLE_MULTI_NETWORK_CARD, TPOptionalID.OPTION_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK, 515, 514, 521, 520, 845, 844}, new int[]{559, 558, 553, 552, 547, 546, 541, TXVodDownloadDataSource.QUALITY_540P, 73, 72, 32, -3, -3, -3, -3, -3, -3, 10, 67, 66, 115, 114, 535, 534, 529, 528, 523, 522, 846, -3}, new int[]{561, 560, 555, 554, 549, 548, 543, 542, 75, 74, -2, -1, 7, 6, 35, 34, 11, -2, 69, 68, 117, 116, 537, 536, 531, 530, 525, 524, 848, 847}, new int[]{563, 562, 557, 556, 551, 550, 545, 544, 77, 76, -2, 33, 9, 8, 25, 24, -1, -2, 71, 70, 119, 118, 539, 538, 533, 532, 527, 526, 849, -3}, new int[]{565, 564, 571, 570, 577, 576, 583, 582, 589, 588, 595, 594, 601, BannerConfig.SCROLL_TIME, 607, 606, 613, 612, 619, 618, 625, 624, 631, 630, 637, 636, 643, 642, 851, 850}, new int[]{567, 566, 573, 572, 579, TPCodecParamers.TP_PROFILE_H264_CONSTRAINED_BASELINE, 585, 584, 591, 590, 597, 596, 603, 602, 609, 608, 615, 614, 621, 620, 627, 626, 633, 632, 639, 638, 645, 644, 852, -3}, new int[]{569, 568, 575, 574, 581, 580, 587, 586, 593, 592, 599, 598, 605, 604, 611, 610, 617, 616, 623, 622, 629, 628, 635, 634, 641, b.f34944a, 647, 646, 854, 853}, new int[]{727, 726, 721, 720, 715, 714, 709, 708, 703, 702, 697, Crop.REQUEST_EDIT_CROP, 691, 690, 685, 684, 679, 678, 673, 672, 667, 666, 661, 660, 655, 654, 649, 648, 855, -3}, new int[]{729, 728, 723, 722, 717, 716, 711, 710, 705, 704, 699, 698, 693, 692, 687, 686, 681, 680, 675, 674, 669, 668, 663, 662, 657, 656, 651, 650, 857, 856}, new int[]{731, 730, 725, 724, 719, 718, 713, 712, 707, 706, 701, 700, 695, 694, 689, 688, 683, 682, 677, 676, 671, 670, 665, 664, 659, 658, 653, 652, 858, -3}, new int[]{733, 732, 739, 738, 745, 744, 751, 750, 757, 756, 763, 762, 769, 768, 775, 774, 781, 780, 787, 786, 793, 792, 799, 798, 805, 804, 811, 810, 860, 859}, new int[]{735, 734, 741, 740, 747, 746, 753, 752, 759, 758, 765, 764, 771, 770, 777, 776, 783, 782, 789, 788, 795, 794, 801, TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE, 807, 806, 813, 812, 861, -3}, new int[]{737, 736, 743, 742, 749, 748, 755, 754, 761, 760, 767, 766, 773, 772, 779, 778, 785, 784, 791, 790, 797, 796, 803, 802, 809, 808, 815, 814, 863, 862}};
    private final BitMatrix bitMatrix;

    public BitMatrixParser(BitMatrix bitMatrix2) {
        this.bitMatrix = bitMatrix2;
    }

    public byte[] readCodewords() {
        byte[] bArr = new byte[144];
        int height = this.bitMatrix.getHeight();
        int width = this.bitMatrix.getWidth();
        for (int i11 = 0; i11 < height; i11++) {
            int[] iArr = BITNR[i11];
            for (int i12 = 0; i12 < width; i12++) {
                int i13 = iArr[i12];
                if (i13 >= 0 && this.bitMatrix.get(i12, i11)) {
                    int i14 = i13 / 6;
                    bArr[i14] = (byte) (((byte) (1 << (5 - (i13 % 6)))) | bArr[i14]);
                }
            }
        }
        return bArr;
    }
}
