package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.imsdk.v2.V2TIMSoundElem;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;

public class SoundReplyQuoteBean extends TUIReplyQuoteBean {
    private String dataPath;
    private V2TIMSoundElem soundElem;

    public int getDuring() {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        if (v2TIMSoundElem != null) {
            return v2TIMSoundElem.getDuration();
        }
        return 0;
    }

    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof SoundMessageBean) {
            this.dataPath = ((SoundMessageBean) tUIMessageBean).getDataPath();
            this.soundElem = tUIMessageBean.getV2TIMMessage().getSoundElem();
        }
    }
}
