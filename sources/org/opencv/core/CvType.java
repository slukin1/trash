package org.opencv.core;

import a.a;

public final class CvType {
    public static final int CV_16S = 3;
    public static final int CV_16SC1 = CV_16SC(1);
    public static final int CV_16SC2 = CV_16SC(2);
    public static final int CV_16SC3 = CV_16SC(3);
    public static final int CV_16SC4 = CV_16SC(4);
    public static final int CV_16U = 2;
    public static final int CV_16UC1 = CV_16UC(1);
    public static final int CV_16UC2 = CV_16UC(2);
    public static final int CV_16UC3 = CV_16UC(3);
    public static final int CV_16UC4 = CV_16UC(4);
    public static final int CV_32F = 5;
    public static final int CV_32FC1 = CV_32FC(1);
    public static final int CV_32FC2 = CV_32FC(2);
    public static final int CV_32FC3 = CV_32FC(3);
    public static final int CV_32FC4 = CV_32FC(4);
    public static final int CV_32S = 4;
    public static final int CV_32SC1 = CV_32SC(1);
    public static final int CV_32SC2 = CV_32SC(2);
    public static final int CV_32SC3 = CV_32SC(3);
    public static final int CV_32SC4 = CV_32SC(4);
    public static final int CV_64F = 6;
    public static final int CV_64FC1 = CV_64FC(1);
    public static final int CV_64FC2 = CV_64FC(2);
    public static final int CV_64FC3 = CV_64FC(3);
    public static final int CV_64FC4 = CV_64FC(4);
    public static final int CV_8S = 1;
    public static final int CV_8SC1 = CV_8SC(1);
    public static final int CV_8SC2 = CV_8SC(2);
    public static final int CV_8SC3 = CV_8SC(3);
    public static final int CV_8SC4 = CV_8SC(4);
    public static final int CV_8U = 0;
    public static final int CV_8UC1 = CV_8UC(1);
    public static final int CV_8UC2 = CV_8UC(2);
    public static final int CV_8UC3 = CV_8UC(3);
    public static final int CV_8UC4 = CV_8UC(4);
    private static final int CV_CN_MAX = 512;
    private static final int CV_CN_SHIFT = 3;
    private static final int CV_DEPTH_MAX = 8;
    public static final int CV_USRTYPE1 = 7;

    public static final int CV_16SC(int i11) {
        return makeType(3, i11);
    }

    public static final int CV_16UC(int i11) {
        return makeType(2, i11);
    }

    public static final int CV_32FC(int i11) {
        return makeType(5, i11);
    }

    public static final int CV_32SC(int i11) {
        return makeType(4, i11);
    }

    public static final int CV_64FC(int i11) {
        return makeType(6, i11);
    }

    public static final int CV_8SC(int i11) {
        return makeType(1, i11);
    }

    public static final int CV_8UC(int i11) {
        return makeType(0, i11);
    }

    public static final int ELEM_SIZE(int i11) {
        switch (depth(i11)) {
            case 0:
            case 1:
                return channels(i11);
            case 2:
            case 3:
                return channels(i11) * 2;
            case 4:
            case 5:
                return channels(i11) * 4;
            case 6:
                return channels(i11) * 8;
            default:
                throw new UnsupportedOperationException(a.b("Unsupported CvType value: ", i11));
        }
    }

    public static final int channels(int i11) {
        return (i11 >> 3) + 1;
    }

    public static final int depth(int i11) {
        return i11 & 7;
    }

    public static final boolean isInteger(int i11) {
        return depth(i11) < 5;
    }

    public static final int makeType(int i11, int i12) {
        if (i12 <= 0 || i12 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        } else if (i11 >= 0 && i11 < 8) {
            return (i11 & 7) + ((i12 - 1) << 3);
        } else {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
    }

    public static final String typeToString(int i11) {
        String str;
        switch (depth(i11)) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_USRTYPE1";
                break;
            default:
                throw new UnsupportedOperationException(a.b("Unsupported CvType value: ", i11));
        }
        int channels = channels(i11);
        if (channels <= 4) {
            return str + "C" + channels;
        }
        return str + "C(" + channels + ")";
    }
}
