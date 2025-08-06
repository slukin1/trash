package com.tencent.thumbplayer.tcmedia.b;

class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f48989a = "base_video";

    /* renamed from: b  reason: collision with root package name */
    private static int f48990b;

    /* renamed from: c  reason: collision with root package name */
    private static int f48991c;

    /* renamed from: d  reason: collision with root package name */
    private static int f48992d;

    public static int a(int i11) {
        if (i11 == 1) {
            int i12 = f48992d;
            f48992d = i12 + 1;
            return i12;
        } else if (i11 == 2) {
            int i13 = f48990b;
            f48990b = i13 + 1;
            return i13;
        } else if (i11 != 3) {
            return -1;
        } else {
            int i14 = f48991c;
            f48991c = i14 + 1;
            return i14;
        }
    }
}
