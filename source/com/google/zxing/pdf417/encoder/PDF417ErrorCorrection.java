package com.google.zxing.pdf417.encoder;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.WriterException;
import com.google.zxing.oned.Code39Reader;
import com.google.zxing.pdf417.PDF417Common;
import com.jumio.analytics.MobileEvents;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import com.youth.banner.config.BannerConfig;
import okhttp3.internal.http.StatusLine;
import org.jmrtd.cbeff.ISO781611;

final class PDF417ErrorCorrection {
    private static final int[][] EC_COEFFICIENTS = {new int[]{27, 917}, new int[]{522, 568, 723, 809}, new int[]{237, StatusLine.HTTP_PERM_REDIRECT, 436, 284, 646, 653, 428, 379}, new int[]{TUIMessageBean.MSG_STATUS_DELETE, 562, 232, 755, 599, 524, 801, 132, 295, 116, PsExtractor.PACK_START_CODE, 428, 295, 42, 176, 65}, new int[]{361, 575, 922, 525, 176, 586, b.f34944a, 321, 536, 742, 677, 742, 687, 284, 193, 517, TUIMessageBean.MSG_STATUS_READ, 494, 263, 147, 593, TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE, 571, 320, 803, 133, 231, 390, 685, 330, 63, 410}, new int[]{539, 422, 6, 93, 862, 771, 453, 106, 610, 287, 107, 505, 733, 877, 381, 612, 723, 476, 462, 172, 430, 609, 858, 822, 543, 376, 511, 400, 672, 762, 283, 184, 440, 35, 519, 31, 460, 594, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 535, 517, 352, 605, ISO781611.SMT_DO_DS, 651, 201, 488, 502, 648, 733, 717, 83, 404, 97, 280, 771, 840, 629, 4, 381, 843, 623, 264, 543}, new int[]{521, 310, 864, 547, 858, 580, 296, 379, 53, 779, 897, 444, 400, 925, 749, 415, 822, 93, 217, 208, PDF417Common.MAX_CODEWORDS_IN_BARCODE, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 583, 620, 246, Code39Reader.ASTERISK_ENCODING, 447, 631, 292, 908, 490, 704, 516, 258, 457, 907, 594, 723, 674, 292, 272, 96, 684, 432, 686, 606, 860, 569, 193, 219, 129, 186, 236, 287, 192, 775, 278, 173, 40, 379, 712, 463, 646, 776, 171, 491, 297, 763, 156, 732, 95, 270, 447, 90, TPOptionalID.OPTION_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS, 48, 228, 821, 808, 898, 784, 663, 627, 378, 382, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 380, 602, 754, 336, 89, 614, 87, 432, 670, 616, 157, 374, 242, 726, BannerConfig.SCROLL_TIME, 269, 375, 898, 845, 454, 354, 130, 814, 587, 804, 34, 211, 330, 539, 297, 827, 865, 37, 517, 834, MobileEvents.EVENTTYPE_CV, 550, 86, 801, 4, 108, 539}, new int[]{524, 894, 75, 766, 882, 857, 74, 204, 82, 586, 708, 250, 905, 786, 138, 720, 858, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 311, 913, TUIMessageBean.MSG_STATUS_REVOKE, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 375, 850, 438, 733, TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT, 280, 201, 280, 828, 757, 710, 814, 919, 89, 68, 569, 11, 204, 796, 605, TXVodDownloadDataSource.QUALITY_540P, 913, 801, 700, 799, 137, 439, 418, 592, 668, 353, 859, 370, 694, 325, 240, 216, 257, 284, 549, 209, 884, MobileEvents.EVENTTYPE_CV, 70, 329, 793, 490, TUIMessageBean.MSG_STATUS_DELETE, 877, 162, 749, 812, 684, 461, 334, 376, 849, 521, 307, 291, 803, 712, 19, 358, 399, 908, 103, 511, 51, 8, 517, HideBottomViewOnScrollBehavior.ENTER_ANIMATION_DURATION, 289, 470, 637, 731, 66, 255, 917, 269, 463, 830, 730, 433, 848, 585, 136, 538, 906, 90, 2, 290, 743, 199, 655, 903, 329, 49, 802, 580, 355, 588, 188, 462, 10, 134, 628, 320, 479, 130, 739, 71, 263, 318, 374, 601, 192, 605, 142, 673, 687, 234, 722, b.f34945b, 177, 752, 607, b.f34944a, 455, 193, 689, 707, 805, 641, 48, 60, 732, 621, 895, 544, TipsMessageBean.MSG_TYPE_GROUP_KICK, 852, 655, MobileEvents.EVENTTYPE_NETWORKCALL, 697, 755, 756, 60, 231, 773, 434, StatusLine.HTTP_MISDIRECTED_REQUEST, 726, 528, 503, 118, 49, 795, 32, 144, 500, 238, 836, 394, 280, 566, MobileEvents.EVENTTYPE_PERFORMANCE, 9, 647, 550, 73, 914, 342, 126, 32, 681, 331, 792, 620, 60, 609, PsExtractor.MPEG_PROGRAM_END_CODE, 180, 791, 893, 754, 605, 383, 228, 749, 760, TPNativePlayerInitConfig.BOOL_ENABLE_MEDIA_CODEC_REUSE, 54, 297, 134, 54, 834, 299, 922, 191, 910, 532, 609, 829, PsExtractor.PRIVATE_STREAM_1, 20, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 29, 872, 449, 83, 402, 41, 656, 505, 579, 481, 173, 404, 251, 688, 95, 497, 555, 642, 543, 307, 159, 924, 558, 648, 55, 497, 10}, new int[]{352, 77, 373, 504, 35, 599, 428, 207, 409, 574, 118, 498, MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL, 380, 350, 492, 197, 265, 920, 155, 914, 299, 229, 643, 294, 871, MobileEvents.EVENTTYPE_SDKPARAMETERS, 88, 87, 193, 352, 781, 846, 75, 327, 520, 435, 543, 203, 666, 249, 346, 781, 621, b.f34944a, 268, 794, 534, 539, 781, 408, 390, 644, 102, 476, 499, 290, 632, 545, 37, 858, 916, 552, 41, 542, 289, 122, 272, 383, TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE, 485, 98, 752, 472, 761, 107, 784, 860, 658, 741, 290, 204, 681, TPNativePlayerInitConfig.BOOL_ENABLE_COLOR_MANAGEMENT, 855, 85, 99, 62, 482, 180, 20, 297, 451, 593, 913, 142, 808, 684, 287, 536, 561, 76, 653, 899, 729, 567, 744, 390, 513, 192, 516, 258, 240, 518, 794, 395, 768, 848, 51, 610, b.f34945b, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 826, 328, 596, 786, 303, 570, 381, 415, 641, 156, 237, 151, 429, 531, 207, 676, 710, 89, HashUtils.SECURE_HASH_ALGORITHM_KECCAK_128_RATE, 304, 402, 40, 708, 575, 162, 864, 229, 65, 861, 841, 512, 164, 477, 221, 92, 358, 785, 288, 357, 850, 836, 827, 736, 707, 94, 8, 494, 114, 521, 2, 499, 851, 543, 152, 729, 771, 95, 248, 361, TPCodecParamers.TP_PROFILE_H264_CONSTRAINED_BASELINE, 323, 856, 797, 289, 51, 684, 466, 533, 820, 669, 45, 902, 452, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 342, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 173, 35, 463, 651, 51, 699, 591, 452, TPCodecParamers.TP_PROFILE_H264_CONSTRAINED_BASELINE, 37, 124, 298, 332, 552, 43, 427, 119, 662, 777, 475, 850, 764, 364, TPCodecParamers.TP_PROFILE_H264_CONSTRAINED_BASELINE, 911, 283, 711, 472, 420, 245, 288, 594, 394, 511, 327, 589, 777, 699, 688, 43, 408, 842, 383, 721, 521, 560, 644, 714, 559, 62, 145, 873, 663, 713, 159, 672, 729, 624, 59, 193, 417, ISO781611.SMT_DO_DS, 209, 563, 564, 343, 693, 109, 608, 563, 365, 181, 772, 677, 310, 248, 353, 708, 410, 579, 870, 617, 841, 632, 860, 289, 536, 35, 777, 618, 586, 424, 833, 77, 597, 346, 269, 757, 632, 695, 751, 331, TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS, 184, 45, 787, 680, 18, 66, TPNativePlayerInitConfig.BOOL_ENABLE_COLOR_MANAGEMENT, 369, 54, 492, 228, 613, 830, 922, 437, 519, 644, 905, 789, 420, MobileEvents.EVENTTYPE_EXCEPTION, PsExtractor.MPEG_PROGRAM_END_CODE, 207, 300, 892, 827, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 537, 381, 662, 513, 56, 252, FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS, 242, 797, 838, 837, 720, 224, 307, 631, 61, 87, 560, 310, 756, 665, 397, 808, 851, MobileEvents.EVENTTYPE_NETWORKCALL, 473, 795, 378, 31, 647, 915, 459, 806, 590, 731, 425, 216, 548, 249, 321, 881, 699, 535, 673, 782, 210, 815, 905, 303, 843, 922, 281, 73, 469, 791, 660, 162, 498, StatusLine.HTTP_PERM_REDIRECT, 155, 422, 907, 817, 187, 62, 16, 425, 535, 336, 286, 437, 375, TUIMessageBean.MSG_STATUS_READ, 610, 296, 183, 923, 116, 667, 751, 353, 62, 366, 691, 379, 687, 842, 37, 357, 720, 742, 330, 5, 39, 923, 311, 424, 242, 749, 321, 54, 669, MobileEvents.EVENTTYPE_REPORTING, 342, 299, 534, 105, 667, 488, b.f34944a, 672, 576, TXVodDownloadDataSource.QUALITY_540P, MobileEvents.EVENTTYPE_REPORTING, 486, 721, 610, 46, 656, 447, 171, 616, 464, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 531, 297, 321, 762, 752, 533, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 134, 14, 381, 433, 717, 45, 111, 20, 596, 284, 736, 138, 646, 411, 877, 669, TPOptionalID.OPTION_ID_BEFORE_QUEUE_INT_SPECIAL_SEI_TYPES_CALLBACK, 919, 45, 780, TPNativePlayerInitConfig.BOOL_ENABLE_COLOR_MANAGEMENT, 164, 332, 899, 165, 726, BannerConfig.SCROLL_TIME, 325, 498, 655, 357, 752, 768, 223, 849, 647, 63, 310, 863, 251, 366, 304, 282, 738, 675, 410, 389, TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE, 31, 121, 303, 263}};

    private PDF417ErrorCorrection() {
    }

    public static String generateErrorCorrection(CharSequence charSequence, int i11) {
        int errorCorrectionCodewordCount = getErrorCorrectionCodewordCount(i11);
        char[] cArr = new char[errorCorrectionCodewordCount];
        int length = charSequence.length();
        for (int i12 = 0; i12 < length; i12++) {
            int i13 = errorCorrectionCodewordCount - 1;
            int charAt = (charSequence.charAt(i12) + cArr[i13]) % PDF417Common.NUMBER_OF_CODEWORDS;
            while (i13 > 0) {
                cArr[i13] = (char) ((cArr[i13 - 1] + (929 - ((EC_COEFFICIENTS[i11][i13] * charAt) % PDF417Common.NUMBER_OF_CODEWORDS))) % PDF417Common.NUMBER_OF_CODEWORDS);
                i13--;
            }
            cArr[0] = (char) ((929 - ((charAt * EC_COEFFICIENTS[i11][0]) % PDF417Common.NUMBER_OF_CODEWORDS)) % PDF417Common.NUMBER_OF_CODEWORDS);
        }
        StringBuilder sb2 = new StringBuilder(errorCorrectionCodewordCount);
        for (int i14 = errorCorrectionCodewordCount - 1; i14 >= 0; i14--) {
            if (cArr[i14] != 0) {
                cArr[i14] = (char) (929 - cArr[i14]);
            }
            sb2.append(cArr[i14]);
        }
        return sb2.toString();
    }

    public static int getErrorCorrectionCodewordCount(int i11) {
        if (i11 >= 0 && i11 <= 8) {
            return 1 << (i11 + 1);
        }
        throw new IllegalArgumentException("Error correction level must be between 0 and 8!");
    }

    public static int getRecommendedMinimumErrorCorrectionLevel(int i11) throws WriterException {
        if (i11 <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (i11 <= 40) {
            return 2;
        } else {
            if (i11 <= 160) {
                return 3;
            }
            if (i11 <= 320) {
                return 4;
            }
            if (i11 <= 863) {
                return 5;
            }
            throw new WriterException("No recommendation possible");
        }
    }
}
