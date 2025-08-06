package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;

public class WXMusicObject implements WXMediaMessage.IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXMusicObject";
    public String musicDataUrl;
    public String musicLowBandDataUrl;
    public String musicLowBandUrl;
    public String musicUrl;

    public boolean checkArgs() {
        String str;
        String str2;
        String str3 = this.musicUrl;
        if ((str3 == null || str3.length() == 0) && ((str2 = this.musicLowBandUrl) == null || str2.length() == 0)) {
            str = "both arguments are null";
        } else {
            String str4 = this.musicUrl;
            if (str4 == null || str4.length() <= LENGTH_LIMIT) {
                String str5 = this.musicLowBandUrl;
                if (str5 == null || str5.length() <= LENGTH_LIMIT) {
                    return true;
                }
                str = "checkArgs fail, musicLowBandUrl is too long";
            } else {
                str = "checkArgs fail, musicUrl is too long";
            }
        }
        a.a(TAG, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
        bundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
        bundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
        bundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle bundle) {
        this.musicUrl = bundle.getString("_wxmusicobject_musicUrl");
        this.musicLowBandUrl = bundle.getString("_wxmusicobject_musicLowBandUrl");
        this.musicDataUrl = bundle.getString("_wxmusicobject_musicDataUrl");
        this.musicLowBandDataUrl = bundle.getString("_wxmusicobject_musicLowBandDataUrl");
    }
}
