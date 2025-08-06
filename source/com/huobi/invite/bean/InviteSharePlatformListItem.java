package com.huobi.invite.bean;

import com.huobi.social.share.HBShareHelper;
import java.io.Serializable;

public class InviteSharePlatformListItem implements Serializable {
    public a callback;
    public int imgResId;
    public String title;
    public HBShareHelper.HbPlatform type;

    public interface a {
        void i0(HBShareHelper.HbPlatform hbPlatform);
    }

    public InviteSharePlatformListItem(HBShareHelper.HbPlatform hbPlatform, int i11, String str, a aVar) {
        this.type = hbPlatform;
        this.imgResId = i11;
        this.title = str;
        this.callback = aVar;
    }
}
