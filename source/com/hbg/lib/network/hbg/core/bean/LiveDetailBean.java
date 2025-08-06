package com.hbg.lib.network.hbg.core.bean;

import com.hbg.lib.network.hbg.core.bean.LivePlayingData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LiveDetailBean extends LiveSquareBaseData {
    public int appointed;
    public int appointedNum;
    public String archiveAlert;
    public int archiveRecover;
    public String archiveShowText;
    public String backgroundUrl;
    public String coverImageUrl;
    public String coverVideoUrl;
    public long currentTime;
    public LiveStream downStreamAddr;
    public int fansNum;
    public long finishTime;
    public String giftActivityId;
    public int giftStatus;
    public ArrayList<GiftUser> giftTopUser;
    public String groupChatInteractive;
    public String groupChatLive;
    public int hasBox;
    public int hasGift;

    /* renamed from: id  reason: collision with root package name */
    public String f70249id;
    public String introduction;
    public List<String> introductionImages;
    public LiveGroup liveGroup;
    public LiveNotification liveNotification;
    public String mediaCoverUrl;
    public String mediaUrl;
    public int messageFromServer;
    public ArrayList<LivePlayingData.FloatMsg> msgList;
    public int needShare;
    public String onlineNum;
    public LivePower power;
    public int praiseNum;
    public int praised;
    public List<LiveSpeaker> presenterList;
    public String proceedRedPotId;
    public String recom_base_info;
    public RecommendTrader recommendTrader;
    public String redPotId;
    public int redPotIdIsExposure;
    public ArrayList<RedPacketBean> redpacketList;
    public int redpacketStatus;
    public int shared;
    public int sharedNum;
    public ArrayList<SisterBean> sisterGroupList;
    public List<LiveSpeaker> speakerList;
    public long startTime;
    public int status;
    public String storageClass;
    public String streamName;
    public String title;
    public LiveStream transDownloadStreamAddr;
    public int type;
    public String useActiveJackpot;

    public class LiveNotification implements Serializable {
        public String avatar;
        public String content;
        public long createTime;
        public int deleted;

        /* renamed from: id  reason: collision with root package name */
        public String f70250id;
        public int jumpType;
        public String jumpUrl;
        public String liveId;
        public String operatorId;
        public int showTime;
        public int status;
        public long updateTime;

        public LiveNotification() {
        }
    }

    public boolean isCanPlay() {
        int i11 = this.status;
        if (1 == i11 || 2 == i11) {
            return true;
        }
        if ("ARCHIVE".equals(this.storageClass) || "DEEP_ARCHIVE".equals(this.storageClass)) {
            return false;
        }
        return true;
    }
}
