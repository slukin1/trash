package com.tencent.qcloud.tuikit.tuichat.config;

import com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.NoticeLayoutConfig;

public class TUIChatConfigs {
    private static TUIChatConfigs sConfigs;
    private GeneralConfig generalConfig;
    private NoticeLayoutConfig noticeLayoutConfig;

    private TUIChatConfigs() {
    }

    public static TUIChatConfigs getConfigs() {
        if (sConfigs == null) {
            sConfigs = new TUIChatConfigs();
        }
        return sConfigs;
    }

    public GeneralConfig getGeneralConfig() {
        if (this.generalConfig == null) {
            this.generalConfig = new GeneralConfig();
        }
        return this.generalConfig;
    }

    public NoticeLayoutConfig getNoticeLayoutConfig() {
        if (this.noticeLayoutConfig == null) {
            this.noticeLayoutConfig = new NoticeLayoutConfig();
        }
        return this.noticeLayoutConfig;
    }

    public TUIChatConfigs setGeneralConfig(GeneralConfig generalConfig2) {
        this.generalConfig = generalConfig2;
        return this;
    }
}
