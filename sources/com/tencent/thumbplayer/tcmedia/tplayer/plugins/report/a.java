package com.tencent.thumbplayer.tcmedia.tplayer.plugins.report;

import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class a implements com.tencent.thumbplayer.tcmedia.tplayer.plugins.a {
    public void a() {
    }

    public void a(int i11, int i12, int i13, String str, Object obj) {
        String str2;
        switch (i11) {
            case 101:
                str2 = "create player adapter";
                break;
            case 102:
                str2 = "start prepare";
                break;
            case 103:
                str2 = "on prepared";
                break;
            case 104:
                str2 = "start play";
                break;
            case 106:
                str2 = "on paused";
                break;
            case 107:
                str2 = "on stoped";
                break;
            case 108:
                str2 = "on error:".concat(String.valueOf(i12));
                break;
            case 109:
                str2 = "start seek";
                break;
            case 110:
                str2 = "seek complete";
                break;
            case 111:
                str2 = "on play complete";
                break;
            case 112:
                TPLogUtil.d("TPLogPlugin", "on release");
                return;
            case 113:
                str2 = "on reset";
                break;
            default:
                return;
        }
        TPLogUtil.d("TPLogPlugin", str2);
    }

    public void b() {
    }
}
