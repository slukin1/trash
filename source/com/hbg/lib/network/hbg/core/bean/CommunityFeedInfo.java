package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.core.bean.NewFeed;
import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommunityFeedInfo implements Serializable {
    private static final long serialVersionUID = 5975309384022989615L;
    public ArrayList<NewFeed.CardIndexItem> cardIndexList;
    private int joinNum;
    @SerializedName("data")
    private List<ListBean> list;
    public ArrayList<LiveDetailBean> liveInfoList;
    public ArrayList<NewFlashInformation> newsflashList;
    private List<Recommend> recommend;
    private List<Topic> topic;
    private CommonPkData vote;

    public static class FocusBean implements Serializable {
        private static final long serialVersionUID = 6347557842559070383L;
        private String avatarType;
        private String focusNickName;
        private String focusNum;
        private int focusStatus;
        private String frameUrl;
        private String intro;
        private int isAlive;
        private String recom_base_info;
        private String recommendWord;
        private String uidUnique;
        private String userAvatar;
        private String userNickname;

        public String getAvatarType() {
            return this.avatarType;
        }

        public String getFocusNickName() {
            return this.focusNickName;
        }

        public String getFocusNum() {
            return this.focusNum;
        }

        public int getFocusStatus() {
            return this.focusStatus;
        }

        public String getFrameUrl() {
            return this.frameUrl;
        }

        public String getIntro() {
            return this.intro;
        }

        public int getIsAlive() {
            return this.isAlive;
        }

        public String getRecom_base_info() {
            return this.recom_base_info;
        }

        public String getRecommendWord() {
            return this.recommendWord;
        }

        public String getUidUnique() {
            return this.uidUnique;
        }

        public String getUserAvatar() {
            return this.userAvatar;
        }

        public String getUserNickname() {
            return this.userNickname;
        }

        public void setAvatarType(String str) {
            this.avatarType = str;
        }

        public void setFocusNickName(String str) {
            this.focusNickName = str;
        }

        public void setFocusNum(String str) {
            this.focusNum = str;
        }

        public void setFocusStatus(int i11) {
            this.focusStatus = i11;
        }

        public void setFrameUrl(String str) {
            this.frameUrl = str;
        }

        public void setIntro(String str) {
            this.intro = str;
        }

        public void setIsAlive(int i11) {
            this.isAlive = i11;
        }

        public void setRecom_base_info(String str) {
            this.recom_base_info = str;
        }

        public void setRecommendWord(String str) {
            this.recommendWord = str;
        }

        public void setUidUnique(String str) {
            this.uidUnique = str;
        }

        public void setUserAvatar(String str) {
            this.userAvatar = str;
        }

        public void setUserNickname(String str) {
            this.userNickname = str;
        }
    }

    public static class HotComment implements Serializable {
        public String hotComAuditor;
        public String hotComPrasie;
        public String hotComUid;
        public String hotComment;
    }

    public static class InterestTag implements Serializable {
        private static final long serialVersionUID = 5594599156194092497L;
        public boolean isSel = false;
        public String recom_base_info;
        public String tagName;
    }

    public static class ListBean implements Serializable {
        private static final long serialVersionUID = -2882627498888705475L;
        public String airdropIcon;
        private AttitudeInfo attitudeInfo;
        private List<NewFlashInformationCoinTags> coinTags;
        private int commentNum;
        private String content;
        private String contentText;
        private Long createdTime;
        public String extend;
        private List<FocusBean> focusList;
        private int focusStatus;
        private String hotComAuditor;
        private int hotComPrasie;
        private String hotComUid;
        private String hotComment;
        private List<HotComment> hotCommentList;

        /* renamed from: id  reason: collision with root package name */
        private int f70231id;
        public String imageUrl;
        private ArrayList<imgListBean> imgList;
        private long interactiveTime;
        private int interactiveType;
        private List<InterestTag> interestTags;
        private int isAlive;
        private int isSelf;
        private int isShowEventTag;
        private boolean isTrans;
        private int itemType;
        private String oldContent;
        private String oldTitle;
        private ParentDynamic parentDynamic;
        private int praiseNum;
        private int praiseStatus;
        private String recom_base_info;
        private String recommendWord;
        private int seek;
        private String shareFrom;
        private String shareFromAvatar;
        private String shareFromLink;
        private String shareImage;
        private String shareLink;
        private String shareLinkTitle;
        private int shareNum;
        private int shareType;
        public int shared;
        private int showTag;
        private List<PartContent> specialContent;
        private int textType;
        private String title;
        private int top;
        private List<TopicTag> topic;
        private int type;
        private PersonalCenterInfo.UcExtInfo ucExtInfo;
        private String uidUnique;
        private String userAvatar;
        private String userNickname;
        private int videoHeight;
        private String videoImage;
        private String videoUrl;
        private int videoWidth;
        public int visit;
        private CommonPkData vote;

        public static class AttitudeInfo implements Serializable {
            public int attitudeCount;
            public List<Attitude> list;
            public int userAttitudeType;

            public static class Attitude implements Serializable {
                public int attitudeTypeCount;
                public String bakSelectedUrl;
                public String bakUnselectedNightUrl;
                public String bakUnselectedUrl;
                public String selectedUrl;
                public int type;
                public String unselectedNightUrl;
                public String unselectedUrl;
            }
        }

        public static class ParentDynamic implements Serializable {
            private static final long serialVersionUID = 6848071754140389928L;
            private int commentNum;
            private String content;
            private Long createdTime;
            private int focusStatus;

            /* renamed from: id  reason: collision with root package name */
            private int f70232id;
            private ArrayList<imgListBean> imgList;
            private int isAlive;
            private int isSelf;
            private ParentDynamic parentDynamic;
            private int praiseNum;
            private int praiseStatus;
            private int seek;
            private List<PartContent> specialContent;
            private int status;
            private String title;
            private int top;
            private List<TopicTag> topic;
            private int type;
            private PersonalCenterInfo.UcExtInfo ucExtInfo;
            private String uidUnique;
            private String userAvatar;
            private String userNickname;
            private int videoHeight;
            private String videoImage;
            private String videoUrl;
            private int videoWidth;

            public int getCommentNum() {
                return this.commentNum;
            }

            public String getContent() {
                return this.content;
            }

            public Long getCreatedTime() {
                return this.createdTime;
            }

            public int getFocusStatus() {
                return this.focusStatus;
            }

            public int getId() {
                return this.f70232id;
            }

            public ArrayList<imgListBean> getImgList() {
                return this.imgList;
            }

            public int getIsAlive() {
                return this.isAlive;
            }

            public int getIsSelf() {
                return this.isSelf;
            }

            public ParentDynamic getParentDynamic() {
                return this.parentDynamic;
            }

            public int getPraiseNum() {
                return this.praiseNum;
            }

            public int getPraiseStatus() {
                return this.praiseStatus;
            }

            public int getSeek() {
                return this.seek;
            }

            public List<PartContent> getSpecialContent() {
                return this.specialContent;
            }

            public int getStatus() {
                return this.status;
            }

            public String getTitle() {
                return this.title;
            }

            public int getTop() {
                return this.top;
            }

            public List<TopicTag> getTopic() {
                return this.topic;
            }

            public int getType() {
                return this.type;
            }

            public PersonalCenterInfo.UcExtInfo getUcExtInfo() {
                return this.ucExtInfo;
            }

            public String getUidUnique() {
                return this.uidUnique;
            }

            public String getUserAvatar() {
                return this.userAvatar;
            }

            public String getUserNickname() {
                return this.userNickname;
            }

            public int getVideoHeight() {
                return this.videoHeight;
            }

            public String getVideoImage() {
                return this.videoImage;
            }

            public String getVideoUrl() {
                return this.videoUrl;
            }

            public int getVideoWidth() {
                return this.videoWidth;
            }

            public void setCommentNum(int i11) {
                this.commentNum = i11;
            }

            public void setContent(String str) {
                this.content = str;
            }

            public void setCreatedTime(Long l11) {
                this.createdTime = l11;
            }

            public void setFocusStatus(int i11) {
                this.focusStatus = i11;
            }

            public void setId(int i11) {
                this.f70232id = i11;
            }

            public void setImgList(ArrayList<imgListBean> arrayList) {
                this.imgList = arrayList;
            }

            public void setIsAlive(int i11) {
                this.isAlive = i11;
            }

            public void setIsSelf(int i11) {
                this.isSelf = i11;
            }

            public void setParentDynamic(ParentDynamic parentDynamic2) {
                this.parentDynamic = parentDynamic2;
            }

            public void setPraiseNum(int i11) {
                this.praiseNum = i11;
            }

            public void setPraiseStatus(int i11) {
                this.praiseStatus = i11;
            }

            public void setSeek(int i11) {
                this.seek = i11;
            }

            public void setSpecialContent(List<PartContent> list) {
                this.specialContent = list;
            }

            public void setStatus(int i11) {
                this.status = i11;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setTop(int i11) {
                this.top = i11;
            }

            public void setTopic(List<TopicTag> list) {
                this.topic = list;
            }

            public void setType(int i11) {
                this.type = i11;
            }

            public void setUcExtInfo(PersonalCenterInfo.UcExtInfo ucExtInfo2) {
                this.ucExtInfo = ucExtInfo2;
            }

            public void setUidUnique(String str) {
                this.uidUnique = str;
            }

            public void setUserAvatar(String str) {
                this.userAvatar = str;
            }

            public void setUserNickname(String str) {
                this.userNickname = str;
            }

            public void setVideoHeight(int i11) {
                this.videoHeight = i11;
            }

            public void setVideoImage(String str) {
                this.videoImage = str;
            }

            public void setVideoUrl(String str) {
                this.videoUrl = str;
            }

            public void setVideoWidth(int i11) {
                this.videoWidth = i11;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ListBean) || ((ListBean) obj).f70231id != this.f70231id) {
                return super.equals(obj);
            }
            return true;
        }

        public String getAirdropIcon() {
            return this.airdropIcon;
        }

        public AttitudeInfo getAttitudeInfo() {
            return this.attitudeInfo;
        }

        public List<NewFlashInformationCoinTags> getCoinTags() {
            return this.coinTags;
        }

        public int getCommentNum() {
            return this.commentNum;
        }

        public String getContent() {
            return this.content;
        }

        public String getContentText() {
            return this.contentText;
        }

        public Long getCreatedTime() {
            return this.createdTime;
        }

        public String getExtend() {
            return this.extend;
        }

        public List<FocusBean> getFocusList() {
            return this.focusList;
        }

        public int getFocusStatus() {
            return this.focusStatus;
        }

        public String getHotComAuditor() {
            return this.hotComAuditor;
        }

        public int getHotComPrasie() {
            return this.hotComPrasie;
        }

        public String getHotComUid() {
            return this.hotComUid;
        }

        public String getHotComment() {
            return this.hotComment;
        }

        public List<HotComment> getHotCommentList() {
            return this.hotCommentList;
        }

        public int getId() {
            return this.f70231id;
        }

        public ArrayList<imgListBean> getImgList() {
            return this.imgList;
        }

        public long getInteractiveTime() {
            return this.interactiveTime;
        }

        public int getInteractiveType() {
            return this.interactiveType;
        }

        public List<InterestTag> getInterestTags() {
            return this.interestTags;
        }

        public int getIsAlive() {
            return this.isAlive;
        }

        public int getIsSelf() {
            return this.isSelf;
        }

        public int getIsShowEventTag() {
            return this.isShowEventTag;
        }

        public int getItemType() {
            return this.itemType;
        }

        public String getOldContent() {
            return this.oldContent;
        }

        public String getOldTitle() {
            return this.oldTitle;
        }

        public ParentDynamic getParentDynamic() {
            return this.parentDynamic;
        }

        public int getPraiseNum() {
            return this.praiseNum;
        }

        public int getPraiseStatus() {
            return this.praiseStatus;
        }

        public String getRecom_base_info() {
            return this.recom_base_info;
        }

        public String getRecommendWord() {
            return this.recommendWord;
        }

        public int getSeek() {
            return this.seek;
        }

        public String getShareFrom() {
            return this.shareFrom;
        }

        public String getShareFromAvatar() {
            return this.shareFromAvatar;
        }

        public String getShareFromLink() {
            return this.shareFromLink;
        }

        public String getShareImage() {
            return this.shareImage;
        }

        public String getShareLink() {
            return this.shareLink;
        }

        public String getShareLinkTitle() {
            return this.shareLinkTitle;
        }

        public int getShareNum() {
            return this.shareNum;
        }

        public int getShareType() {
            return this.shareType;
        }

        public int getShowTag() {
            return this.showTag;
        }

        public List<PartContent> getSpecialContent() {
            return this.specialContent;
        }

        public int getTextType() {
            return this.textType;
        }

        public String getTitle() {
            return this.title;
        }

        public int getTop() {
            return this.top;
        }

        public List<TopicTag> getTopic() {
            return this.topic;
        }

        public int getType() {
            return this.type;
        }

        public PersonalCenterInfo.UcExtInfo getUcExtInfo() {
            return this.ucExtInfo;
        }

        public String getUidUnique() {
            return this.uidUnique;
        }

        public String getUserAvatar() {
            return this.userAvatar;
        }

        public String getUserNickname() {
            return this.userNickname;
        }

        public int getVideoHeight() {
            return this.videoHeight;
        }

        public String getVideoImage() {
            return this.videoImage;
        }

        public String getVideoUrl() {
            return this.videoUrl;
        }

        public int getVideoWidth() {
            return this.videoWidth;
        }

        public CommonPkData getVote() {
            return this.vote;
        }

        public boolean isTrans() {
            return this.isTrans;
        }

        public void setAirdropIcon(String str) {
            this.airdropIcon = str;
        }

        public void setAttitudeInfo(AttitudeInfo attitudeInfo2) {
            this.attitudeInfo = attitudeInfo2;
        }

        public void setCoinTags(List<NewFlashInformationCoinTags> list) {
            this.coinTags = list;
        }

        public void setCommentNum(int i11) {
            this.commentNum = i11;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setContentText(String str) {
            this.contentText = str;
        }

        public void setCreatedTime(Long l11) {
            this.createdTime = l11;
        }

        public void setExtend(String str) {
            this.extend = str;
        }

        public void setFocusList(List<FocusBean> list) {
            this.focusList = list;
        }

        public void setFocusStatus(int i11) {
            this.focusStatus = i11;
        }

        public void setHotComAuditor(String str) {
            this.hotComAuditor = str;
        }

        public void setHotComPrasie(int i11) {
            this.hotComPrasie = i11;
        }

        public void setHotComUid(String str) {
            this.hotComUid = str;
        }

        public void setHotComment(String str) {
            this.hotComment = str;
        }

        public void setHotCommentList(List<HotComment> list) {
            this.hotCommentList = list;
        }

        public void setId(int i11) {
            this.f70231id = i11;
        }

        public void setImgList(ArrayList<imgListBean> arrayList) {
            this.imgList = arrayList;
        }

        public void setInteractiveTime(long j11) {
            this.interactiveTime = j11;
        }

        public void setInteractiveType(int i11) {
            this.interactiveType = i11;
        }

        public void setInterestTags(List<InterestTag> list) {
            this.interestTags = list;
        }

        public void setIsAlive(int i11) {
            this.isAlive = i11;
        }

        public void setIsSelf(int i11) {
            this.isSelf = i11;
        }

        public void setIsShowEventTag(int i11) {
            this.isShowEventTag = i11;
        }

        public void setItemType(int i11) {
            this.itemType = i11;
        }

        public void setOldContent(String str) {
            this.oldContent = str;
        }

        public void setOldTitle(String str) {
            this.oldTitle = str;
        }

        public void setParentDynamic(ParentDynamic parentDynamic2) {
            this.parentDynamic = parentDynamic2;
        }

        public void setPraiseNum(int i11) {
            this.praiseNum = i11;
        }

        public void setPraiseStatus(int i11) {
            this.praiseStatus = i11;
        }

        public void setRecom_base_info(String str) {
            this.recom_base_info = str;
        }

        public void setRecommendWord(String str) {
            this.recommendWord = str;
        }

        public void setSeek(int i11) {
            this.seek = i11;
        }

        public void setShareFrom(String str) {
            this.shareFrom = str;
        }

        public void setShareFromAvatar(String str) {
            this.shareFromAvatar = str;
        }

        public void setShareFromLink(String str) {
            this.shareFromLink = str;
        }

        public void setShareImage(String str) {
            this.shareImage = str;
        }

        public void setShareLink(String str) {
            this.shareLink = str;
        }

        public void setShareLinkTitle(String str) {
            this.shareLinkTitle = str;
        }

        public void setShareNum(int i11) {
            this.shareNum = i11;
        }

        public void setShareType(int i11) {
            this.shareType = i11;
        }

        public void setShowTag(int i11) {
            this.showTag = i11;
        }

        public void setSpecialContent(List<PartContent> list) {
            this.specialContent = list;
        }

        public void setTextType(int i11) {
            this.textType = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTop(int i11) {
            this.top = i11;
        }

        public void setTopic(List<TopicTag> list) {
            this.topic = list;
        }

        public void setTrans(boolean z11) {
            this.isTrans = z11;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setUcExtInfo(PersonalCenterInfo.UcExtInfo ucExtInfo2) {
            this.ucExtInfo = ucExtInfo2;
        }

        public void setUidUnique(String str) {
            this.uidUnique = str;
        }

        public void setUserAvatar(String str) {
            this.userAvatar = str;
        }

        public void setUserNickname(String str) {
            this.userNickname = str;
        }

        public void setVideoHeight(int i11) {
            this.videoHeight = i11;
        }

        public void setVideoImage(String str) {
            this.videoImage = str;
        }

        public void setVideoUrl(String str) {
            this.videoUrl = str;
        }

        public void setVideoWidth(int i11) {
            this.videoWidth = i11;
        }

        public void setVote(CommonPkData commonPkData) {
            this.vote = commonPkData;
        }
    }

    public static class PartContent implements Serializable {
        private static final long serialVersionUID = -6779266976205480792L;
        private String text;
        private String url;

        public String getText() {
            return this.text;
        }

        public String getUrl() {
            return this.url;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static class Recommend implements Serializable {
        private static final long serialVersionUID = -5471109092685571087L;
        private int focusStatus;
        private int isAlive;
        private String tagName;
        private String uidUnique;
        private String userAvatar;
        private String userNickname;

        public int getFocusStatus() {
            return this.focusStatus;
        }

        public int getIsAlive() {
            return this.isAlive;
        }

        public String getTagName() {
            return this.tagName;
        }

        public String getUidUnique() {
            return this.uidUnique;
        }

        public String getUserAvatar() {
            return this.userAvatar;
        }

        public String getUserNickname() {
            return this.userNickname;
        }

        public void setFocusStatus(int i11) {
            this.focusStatus = i11;
        }

        public void setIsAlive(int i11) {
            this.isAlive = i11;
        }

        public void setTagName(String str) {
            this.tagName = str;
        }

        public void setUidUnique(String str) {
            this.uidUnique = str;
        }

        public void setUserAvatar(String str) {
            this.userAvatar = str;
        }

        public void setUserNickname(String str) {
            this.userNickname = str;
        }
    }

    public static class RecommendLiveBean implements Serializable {
        public ArrayList<LiveDetailBean> lives;
    }

    public static class Topic implements Serializable {
        private static final long serialVersionUID = -700835949028829627L;
        private long createdTime;
        private int identification;
        private int isTop;
        private int joinNums;
        private int refined;
        private String specialIde;
        private String title;
        private int topicId;
        private int type;
        private String url;

        public long getCreatedTime() {
            return this.createdTime;
        }

        public int getIdentification() {
            return this.identification;
        }

        public int getIsTop() {
            return this.isTop;
        }

        public int getJoinNums() {
            return this.joinNums;
        }

        public int getRefined() {
            return this.refined;
        }

        public String getSpecialIde() {
            return this.specialIde;
        }

        public String getTitle() {
            return this.title;
        }

        public int getTopicId() {
            return this.topicId;
        }

        public int getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public void setCreatedTime(long j11) {
            this.createdTime = j11;
        }

        public void setIdentification(int i11) {
            this.identification = i11;
        }

        public void setIsTop(int i11) {
            this.isTop = i11;
        }

        public void setJoinNums(int i11) {
            this.joinNums = i11;
        }

        public void setRefined(int i11) {
            this.refined = i11;
        }

        public void setSpecialIde(String str) {
            this.specialIde = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTopicId(int i11) {
            this.topicId = i11;
        }

        public void setType(int i11) {
            this.type = i11;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public static class TopicListBean implements Serializable {
        private static final long serialVersionUID = -1935081255074451479L;
        private int from;
        private boolean hasVote;
        private List<Topic> topic;

        public int getFrom() {
            return this.from;
        }

        public List<Topic> getTopic() {
            return this.topic;
        }

        public boolean isHasVote() {
            return this.hasVote;
        }

        public void setFrom(int i11) {
            this.from = i11;
        }

        public void setHasVote(boolean z11) {
            this.hasVote = z11;
        }

        public void setTopic(List<Topic> list) {
            this.topic = list;
        }
    }

    public static class TopicTag implements Serializable {
        private static final long serialVersionUID = -700835949028829627L;
        private int identification;
        private int refined;
        private String title;
        private int topicId;

        public int getIdentification() {
            return this.identification;
        }

        public int getRefined() {
            return this.refined;
        }

        public String getTitle() {
            return this.title;
        }

        public int getTopicId() {
            return this.topicId;
        }

        public void setIdentification(int i11) {
            this.identification = i11;
        }

        public void setRefined(int i11) {
            this.refined = i11;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setTopicId(int i11) {
            this.topicId = i11;
        }
    }

    public static class imgListBean implements Serializable {
        private static final long serialVersionUID = -3218864950253241838L;
        private int height;
        private String image;
        private String thumbImage;
        private int width;

        public int getHeight() {
            return this.height;
        }

        public String getImage() {
            return this.image;
        }

        public String getThumbImage() {
            return this.thumbImage;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int i11) {
            this.height = i11;
        }

        public void setImage(String str) {
            this.image = str;
        }

        public void setThumbImage(String str) {
            this.thumbImage = str;
        }

        public void setWidth(int i11) {
            this.width = i11;
        }
    }

    public int getJoinNum() {
        return this.joinNum;
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public List<Recommend> getRecommend() {
        return this.recommend;
    }

    public List<Topic> getTopic() {
        return this.topic;
    }

    public CommonPkData getVote() {
        return this.vote;
    }

    public void setJoinNum(int i11) {
        this.joinNum = i11;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public void setRecommend(List<Recommend> list2) {
        this.recommend = list2;
    }

    public void setTopic(List<Topic> list2) {
        this.topic = list2;
    }

    public void setVote(CommonPkData commonPkData) {
        this.vote = commonPkData;
    }
}
