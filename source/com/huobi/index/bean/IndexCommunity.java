package com.huobi.index.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import java.io.Serializable;
import java.util.List;

public class IndexCommunity implements Serializable {
    @SerializedName("coinTags")
    public List<NewFlashInformationCoinTags> coinTags;
    @SerializedName("commentNum")
    public Integer commentNum;
    @SerializedName("content")
    public String content;
    @SerializedName("createdTime")
    public Long createdTime;
    @SerializedName("focusStatus")
    public Integer focusStatus;
    public String hotComAuditor;
    public int hotComPrasie;
    public String hotComment;
    public List<CommunityFeedInfo.HotComment> hotCommentList;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public Integer f73168id;
    @SerializedName("imageUrl")
    public String imageUrl;
    @SerializedName("imgList")
    public List<CommunityFeedInfo.imgListBean> imgList;
    public int isAlive;
    public boolean isPlaying;
    @SerializedName("isSelf")
    public Integer isSelf;
    @SerializedName("praiseNum")
    public Integer praiseNum;
    @SerializedName("praiseStatus")
    public Integer praiseStatus;
    public int seek;
    @SerializedName("shareFrom")
    public String shareFrom = "";
    @SerializedName("shareLink")
    public String shareLink = "";
    @SerializedName("shareLinkTitle")
    public String shareLinkTitle = "";
    @SerializedName("shared")
    public int shared;
    @SerializedName("showTag")
    public int showTag = 0;
    private List<CommunityFeedInfo.PartContent> specialContent;
    @SerializedName("title")
    public String title;
    public List<CommunityFeedInfo.TopicTag> topic;
    @SerializedName("type")
    public Integer type;
    @SerializedName("ucExtInfo")
    public UcExtInfoDTO ucExtInfo;
    @SerializedName("uidUnique")
    public String uidUnique;
    @SerializedName("userAvatar")
    public String userAvatar;
    @SerializedName("userNickname")
    public String userNickname;
    @SerializedName("videoImage")
    public String videoImage = "";
    @SerializedName("videoUrl")
    public String videoUrl = "";
    @SerializedName("visit")
    public int visit;

    public static class ImgListDTO {
        @SerializedName("height")

        /* renamed from: a  reason: collision with root package name */
        public Integer f73169a;
        @SerializedName("image")

        /* renamed from: b  reason: collision with root package name */
        public String f73170b;
        @SerializedName("thumbImage")

        /* renamed from: c  reason: collision with root package name */
        public String f73171c;
        @SerializedName("width")

        /* renamed from: d  reason: collision with root package name */
        public Integer f73172d;

        public boolean a(Object obj) {
            return obj instanceof ImgListDTO;
        }

        public Integer b() {
            return this.f73169a;
        }

        public String c() {
            return this.f73170b;
        }

        public String d() {
            return this.f73171c;
        }

        public Integer e() {
            return this.f73172d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ImgListDTO)) {
                return false;
            }
            ImgListDTO imgListDTO = (ImgListDTO) obj;
            if (!imgListDTO.a(this)) {
                return false;
            }
            Integer b11 = b();
            Integer b12 = imgListDTO.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = imgListDTO.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String d11 = d();
            String d12 = imgListDTO.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            Integer e11 = e();
            Integer e12 = imgListDTO.e();
            return e11 != null ? e11.equals(e12) : e12 == null;
        }

        public int hashCode() {
            Integer b11 = b();
            int i11 = 43;
            int hashCode = b11 == null ? 43 : b11.hashCode();
            String c11 = c();
            int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
            String d11 = d();
            int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
            Integer e11 = e();
            int i12 = hashCode3 * 59;
            if (e11 != null) {
                i11 = e11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "IndexCommunity.ImgListDTO(height=" + b() + ", image=" + c() + ", thumbImage=" + d() + ", width=" + e() + ")";
        }
    }

    public static class UcExtInfoDTO {
        @SerializedName("frameUrl")

        /* renamed from: a  reason: collision with root package name */
        public String f73173a;
        @SerializedName("headImage")

        /* renamed from: b  reason: collision with root package name */
        public String f73174b;
        @SerializedName("headImageType")

        /* renamed from: c  reason: collision with root package name */
        public String f73175c;
        @SerializedName("nftRarity")

        /* renamed from: d  reason: collision with root package name */
        public String f73176d;
        @SerializedName("nickName")

        /* renamed from: e  reason: collision with root package name */
        public String f73177e;

        public boolean a(Object obj) {
            return obj instanceof UcExtInfoDTO;
        }

        public String b() {
            return this.f73173a;
        }

        public String c() {
            return this.f73174b;
        }

        public String d() {
            return this.f73175c;
        }

        public String e() {
            return this.f73176d;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UcExtInfoDTO)) {
                return false;
            }
            UcExtInfoDTO ucExtInfoDTO = (UcExtInfoDTO) obj;
            if (!ucExtInfoDTO.a(this)) {
                return false;
            }
            String b11 = b();
            String b12 = ucExtInfoDTO.b();
            if (b11 != null ? !b11.equals(b12) : b12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = ucExtInfoDTO.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String d11 = d();
            String d12 = ucExtInfoDTO.d();
            if (d11 != null ? !d11.equals(d12) : d12 != null) {
                return false;
            }
            String e11 = e();
            String e12 = ucExtInfoDTO.e();
            if (e11 != null ? !e11.equals(e12) : e12 != null) {
                return false;
            }
            String f11 = f();
            String f12 = ucExtInfoDTO.f();
            return f11 != null ? f11.equals(f12) : f12 == null;
        }

        public String f() {
            return this.f73177e;
        }

        public int hashCode() {
            String b11 = b();
            int i11 = 43;
            int hashCode = b11 == null ? 43 : b11.hashCode();
            String c11 = c();
            int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
            String d11 = d();
            int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
            String e11 = e();
            int hashCode4 = (hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode());
            String f11 = f();
            int i12 = hashCode4 * 59;
            if (f11 != null) {
                i11 = f11.hashCode();
            }
            return i12 + i11;
        }

        public String toString() {
            return "IndexCommunity.UcExtInfoDTO(frameUrl=" + b() + ", headImage=" + c() + ", headImageType=" + d() + ", nftRarity=" + e() + ", nickName=" + f() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof IndexCommunity;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexCommunity)) {
            return false;
        }
        IndexCommunity indexCommunity = (IndexCommunity) obj;
        if (!indexCommunity.canEqual(this)) {
            return false;
        }
        Integer commentNum2 = getCommentNum();
        Integer commentNum3 = indexCommunity.getCommentNum();
        if (commentNum2 != null ? !commentNum2.equals(commentNum3) : commentNum3 != null) {
            return false;
        }
        String content2 = getContent();
        String content3 = indexCommunity.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        Long createdTime2 = getCreatedTime();
        Long createdTime3 = indexCommunity.getCreatedTime();
        if (createdTime2 != null ? !createdTime2.equals(createdTime3) : createdTime3 != null) {
            return false;
        }
        Integer focusStatus2 = getFocusStatus();
        Integer focusStatus3 = indexCommunity.getFocusStatus();
        if (focusStatus2 != null ? !focusStatus2.equals(focusStatus3) : focusStatus3 != null) {
            return false;
        }
        Integer id2 = getId();
        Integer id3 = indexCommunity.getId();
        if (id2 != null ? !id2.equals(id3) : id3 != null) {
            return false;
        }
        List<CommunityFeedInfo.imgListBean> imgList2 = getImgList();
        List<CommunityFeedInfo.imgListBean> imgList3 = indexCommunity.getImgList();
        if (imgList2 != null ? !imgList2.equals(imgList3) : imgList3 != null) {
            return false;
        }
        Integer isSelf2 = getIsSelf();
        Integer isSelf3 = indexCommunity.getIsSelf();
        if (isSelf2 != null ? !isSelf2.equals(isSelf3) : isSelf3 != null) {
            return false;
        }
        Integer praiseNum2 = getPraiseNum();
        Integer praiseNum3 = indexCommunity.getPraiseNum();
        if (praiseNum2 != null ? !praiseNum2.equals(praiseNum3) : praiseNum3 != null) {
            return false;
        }
        Integer praiseStatus2 = getPraiseStatus();
        Integer praiseStatus3 = indexCommunity.getPraiseStatus();
        if (praiseStatus2 != null ? !praiseStatus2.equals(praiseStatus3) : praiseStatus3 != null) {
            return false;
        }
        String title2 = getTitle();
        String title3 = indexCommunity.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        Integer type2 = getType();
        Integer type3 = indexCommunity.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        UcExtInfoDTO ucExtInfo2 = getUcExtInfo();
        UcExtInfoDTO ucExtInfo3 = indexCommunity.getUcExtInfo();
        if (ucExtInfo2 != null ? !ucExtInfo2.equals(ucExtInfo3) : ucExtInfo3 != null) {
            return false;
        }
        String uidUnique2 = getUidUnique();
        String uidUnique3 = indexCommunity.getUidUnique();
        if (uidUnique2 != null ? !uidUnique2.equals(uidUnique3) : uidUnique3 != null) {
            return false;
        }
        String userAvatar2 = getUserAvatar();
        String userAvatar3 = indexCommunity.getUserAvatar();
        if (userAvatar2 != null ? !userAvatar2.equals(userAvatar3) : userAvatar3 != null) {
            return false;
        }
        String userNickname2 = getUserNickname();
        String userNickname3 = indexCommunity.getUserNickname();
        if (userNickname2 != null ? !userNickname2.equals(userNickname3) : userNickname3 != null) {
            return false;
        }
        if (getVisit() != indexCommunity.getVisit()) {
            return false;
        }
        String imageUrl2 = getImageUrl();
        String imageUrl3 = indexCommunity.getImageUrl();
        if (imageUrl2 != null ? !imageUrl2.equals(imageUrl3) : imageUrl3 != null) {
            return false;
        }
        String shareLink2 = getShareLink();
        String shareLink3 = indexCommunity.getShareLink();
        if (shareLink2 != null ? !shareLink2.equals(shareLink3) : shareLink3 != null) {
            return false;
        }
        String shareLinkTitle2 = getShareLinkTitle();
        String shareLinkTitle3 = indexCommunity.getShareLinkTitle();
        if (shareLinkTitle2 != null ? !shareLinkTitle2.equals(shareLinkTitle3) : shareLinkTitle3 != null) {
            return false;
        }
        String shareFrom2 = getShareFrom();
        String shareFrom3 = indexCommunity.getShareFrom();
        if (shareFrom2 != null ? !shareFrom2.equals(shareFrom3) : shareFrom3 != null) {
            return false;
        }
        if (getShowTag() != indexCommunity.getShowTag()) {
            return false;
        }
        String videoUrl2 = getVideoUrl();
        String videoUrl3 = indexCommunity.getVideoUrl();
        if (videoUrl2 != null ? !videoUrl2.equals(videoUrl3) : videoUrl3 != null) {
            return false;
        }
        String videoImage2 = getVideoImage();
        String videoImage3 = indexCommunity.getVideoImage();
        if (videoImage2 != null ? !videoImage2.equals(videoImage3) : videoImage3 != null) {
            return false;
        }
        if (getShared() != indexCommunity.getShared() || getIsAlive() != indexCommunity.getIsAlive()) {
            return false;
        }
        String hotComment2 = getHotComment();
        String hotComment3 = indexCommunity.getHotComment();
        if (hotComment2 != null ? !hotComment2.equals(hotComment3) : hotComment3 != null) {
            return false;
        }
        String hotComAuditor2 = getHotComAuditor();
        String hotComAuditor3 = indexCommunity.getHotComAuditor();
        if (hotComAuditor2 != null ? !hotComAuditor2.equals(hotComAuditor3) : hotComAuditor3 != null) {
            return false;
        }
        List<CommunityFeedInfo.HotComment> hotCommentList2 = getHotCommentList();
        List<CommunityFeedInfo.HotComment> hotCommentList3 = indexCommunity.getHotCommentList();
        if (hotCommentList2 != null ? !hotCommentList2.equals(hotCommentList3) : hotCommentList3 != null) {
            return false;
        }
        if (getHotComPrasie() != indexCommunity.getHotComPrasie()) {
            return false;
        }
        List<CommunityFeedInfo.PartContent> specialContent2 = getSpecialContent();
        List<CommunityFeedInfo.PartContent> specialContent3 = indexCommunity.getSpecialContent();
        if (specialContent2 != null ? !specialContent2.equals(specialContent3) : specialContent3 != null) {
            return false;
        }
        if (getSeek() != indexCommunity.getSeek() || isPlaying() != indexCommunity.isPlaying()) {
            return false;
        }
        List<CommunityFeedInfo.TopicTag> topic2 = getTopic();
        List<CommunityFeedInfo.TopicTag> topic3 = indexCommunity.getTopic();
        if (topic2 != null ? !topic2.equals(topic3) : topic3 != null) {
            return false;
        }
        List<NewFlashInformationCoinTags> coinTags2 = getCoinTags();
        List<NewFlashInformationCoinTags> coinTags3 = indexCommunity.getCoinTags();
        return coinTags2 != null ? coinTags2.equals(coinTags3) : coinTags3 == null;
    }

    public List<NewFlashInformationCoinTags> getCoinTags() {
        return this.coinTags;
    }

    public Integer getCommentNum() {
        return this.commentNum;
    }

    public String getContent() {
        return this.content;
    }

    public Long getCreatedTime() {
        return this.createdTime;
    }

    public Integer getFocusStatus() {
        return this.focusStatus;
    }

    public String getHotComAuditor() {
        return this.hotComAuditor;
    }

    public int getHotComPrasie() {
        return this.hotComPrasie;
    }

    public String getHotComment() {
        return this.hotComment;
    }

    public List<CommunityFeedInfo.HotComment> getHotCommentList() {
        return this.hotCommentList;
    }

    public Integer getId() {
        return this.f73168id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<CommunityFeedInfo.imgListBean> getImgList() {
        return this.imgList;
    }

    public int getIsAlive() {
        return this.isAlive;
    }

    public Integer getIsSelf() {
        return this.isSelf;
    }

    public Integer getPraiseNum() {
        return this.praiseNum;
    }

    public Integer getPraiseStatus() {
        return this.praiseStatus;
    }

    public int getSeek() {
        return this.seek;
    }

    public String getShareFrom() {
        return this.shareFrom;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public String getShareLinkTitle() {
        return this.shareLinkTitle;
    }

    public int getShared() {
        return this.shared;
    }

    public int getShowTag() {
        return this.showTag;
    }

    public List<CommunityFeedInfo.PartContent> getSpecialContent() {
        return this.specialContent;
    }

    public String getTitle() {
        return this.title;
    }

    public List<CommunityFeedInfo.TopicTag> getTopic() {
        return this.topic;
    }

    public Integer getType() {
        return this.type;
    }

    public UcExtInfoDTO getUcExtInfo() {
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

    public String getVideoImage() {
        return this.videoImage;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public int getVisit() {
        return this.visit;
    }

    public int hashCode() {
        Integer commentNum2 = getCommentNum();
        int i11 = 43;
        int hashCode = commentNum2 == null ? 43 : commentNum2.hashCode();
        String content2 = getContent();
        int hashCode2 = ((hashCode + 59) * 59) + (content2 == null ? 43 : content2.hashCode());
        Long createdTime2 = getCreatedTime();
        int hashCode3 = (hashCode2 * 59) + (createdTime2 == null ? 43 : createdTime2.hashCode());
        Integer focusStatus2 = getFocusStatus();
        int hashCode4 = (hashCode3 * 59) + (focusStatus2 == null ? 43 : focusStatus2.hashCode());
        Integer id2 = getId();
        int hashCode5 = (hashCode4 * 59) + (id2 == null ? 43 : id2.hashCode());
        List<CommunityFeedInfo.imgListBean> imgList2 = getImgList();
        int hashCode6 = (hashCode5 * 59) + (imgList2 == null ? 43 : imgList2.hashCode());
        Integer isSelf2 = getIsSelf();
        int hashCode7 = (hashCode6 * 59) + (isSelf2 == null ? 43 : isSelf2.hashCode());
        Integer praiseNum2 = getPraiseNum();
        int hashCode8 = (hashCode7 * 59) + (praiseNum2 == null ? 43 : praiseNum2.hashCode());
        Integer praiseStatus2 = getPraiseStatus();
        int hashCode9 = (hashCode8 * 59) + (praiseStatus2 == null ? 43 : praiseStatus2.hashCode());
        String title2 = getTitle();
        int hashCode10 = (hashCode9 * 59) + (title2 == null ? 43 : title2.hashCode());
        Integer type2 = getType();
        int hashCode11 = (hashCode10 * 59) + (type2 == null ? 43 : type2.hashCode());
        UcExtInfoDTO ucExtInfo2 = getUcExtInfo();
        int hashCode12 = (hashCode11 * 59) + (ucExtInfo2 == null ? 43 : ucExtInfo2.hashCode());
        String uidUnique2 = getUidUnique();
        int hashCode13 = (hashCode12 * 59) + (uidUnique2 == null ? 43 : uidUnique2.hashCode());
        String userAvatar2 = getUserAvatar();
        int hashCode14 = (hashCode13 * 59) + (userAvatar2 == null ? 43 : userAvatar2.hashCode());
        String userNickname2 = getUserNickname();
        int hashCode15 = (((hashCode14 * 59) + (userNickname2 == null ? 43 : userNickname2.hashCode())) * 59) + getVisit();
        String imageUrl2 = getImageUrl();
        int hashCode16 = (hashCode15 * 59) + (imageUrl2 == null ? 43 : imageUrl2.hashCode());
        String shareLink2 = getShareLink();
        int hashCode17 = (hashCode16 * 59) + (shareLink2 == null ? 43 : shareLink2.hashCode());
        String shareLinkTitle2 = getShareLinkTitle();
        int hashCode18 = (hashCode17 * 59) + (shareLinkTitle2 == null ? 43 : shareLinkTitle2.hashCode());
        String shareFrom2 = getShareFrom();
        int hashCode19 = (((hashCode18 * 59) + (shareFrom2 == null ? 43 : shareFrom2.hashCode())) * 59) + getShowTag();
        String videoUrl2 = getVideoUrl();
        int hashCode20 = (hashCode19 * 59) + (videoUrl2 == null ? 43 : videoUrl2.hashCode());
        String videoImage2 = getVideoImage();
        int hashCode21 = (((((hashCode20 * 59) + (videoImage2 == null ? 43 : videoImage2.hashCode())) * 59) + getShared()) * 59) + getIsAlive();
        String hotComment2 = getHotComment();
        int hashCode22 = (hashCode21 * 59) + (hotComment2 == null ? 43 : hotComment2.hashCode());
        String hotComAuditor2 = getHotComAuditor();
        int hashCode23 = (hashCode22 * 59) + (hotComAuditor2 == null ? 43 : hotComAuditor2.hashCode());
        List<CommunityFeedInfo.HotComment> hotCommentList2 = getHotCommentList();
        int hashCode24 = (((hashCode23 * 59) + (hotCommentList2 == null ? 43 : hotCommentList2.hashCode())) * 59) + getHotComPrasie();
        List<CommunityFeedInfo.PartContent> specialContent2 = getSpecialContent();
        int hashCode25 = (((((hashCode24 * 59) + (specialContent2 == null ? 43 : specialContent2.hashCode())) * 59) + getSeek()) * 59) + (isPlaying() ? 79 : 97);
        List<CommunityFeedInfo.TopicTag> topic2 = getTopic();
        int hashCode26 = (hashCode25 * 59) + (topic2 == null ? 43 : topic2.hashCode());
        List<NewFlashInformationCoinTags> coinTags2 = getCoinTags();
        int i12 = hashCode26 * 59;
        if (coinTags2 != null) {
            i11 = coinTags2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setCoinTags(List<NewFlashInformationCoinTags> list) {
        this.coinTags = list;
    }

    public void setCommentNum(Integer num) {
        this.commentNum = num;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreatedTime(Long l11) {
        this.createdTime = l11;
    }

    public void setFocusStatus(Integer num) {
        this.focusStatus = num;
    }

    public void setHotComAuditor(String str) {
        this.hotComAuditor = str;
    }

    public void setHotComPrasie(int i11) {
        this.hotComPrasie = i11;
    }

    public void setHotComment(String str) {
        this.hotComment = str;
    }

    public void setHotCommentList(List<CommunityFeedInfo.HotComment> list) {
        this.hotCommentList = list;
    }

    public void setId(Integer num) {
        this.f73168id = num;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setImgList(List<CommunityFeedInfo.imgListBean> list) {
        this.imgList = list;
    }

    public void setIsAlive(int i11) {
        this.isAlive = i11;
    }

    public void setIsSelf(Integer num) {
        this.isSelf = num;
    }

    public void setPlaying(boolean z11) {
        this.isPlaying = z11;
    }

    public void setPraiseNum(Integer num) {
        this.praiseNum = num;
    }

    public void setPraiseStatus(Integer num) {
        this.praiseStatus = num;
    }

    public void setSeek(int i11) {
        this.seek = i11;
    }

    public void setShareFrom(String str) {
        this.shareFrom = str;
    }

    public void setShareLink(String str) {
        this.shareLink = str;
    }

    public void setShareLinkTitle(String str) {
        this.shareLinkTitle = str;
    }

    public void setShared(int i11) {
        this.shared = i11;
    }

    public void setShowTag(int i11) {
        this.showTag = i11;
    }

    public void setSpecialContent(List<CommunityFeedInfo.PartContent> list) {
        this.specialContent = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTopic(List<CommunityFeedInfo.TopicTag> list) {
        this.topic = list;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public void setUcExtInfo(UcExtInfoDTO ucExtInfoDTO) {
        this.ucExtInfo = ucExtInfoDTO;
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

    public void setVideoImage(String str) {
        this.videoImage = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setVisit(int i11) {
        this.visit = i11;
    }

    public String toString() {
        return "IndexCommunity(commentNum=" + getCommentNum() + ", content=" + getContent() + ", createdTime=" + getCreatedTime() + ", focusStatus=" + getFocusStatus() + ", id=" + getId() + ", imgList=" + getImgList() + ", isSelf=" + getIsSelf() + ", praiseNum=" + getPraiseNum() + ", praiseStatus=" + getPraiseStatus() + ", title=" + getTitle() + ", type=" + getType() + ", ucExtInfo=" + getUcExtInfo() + ", uidUnique=" + getUidUnique() + ", userAvatar=" + getUserAvatar() + ", userNickname=" + getUserNickname() + ", visit=" + getVisit() + ", imageUrl=" + getImageUrl() + ", shareLink=" + getShareLink() + ", shareLinkTitle=" + getShareLinkTitle() + ", shareFrom=" + getShareFrom() + ", showTag=" + getShowTag() + ", videoUrl=" + getVideoUrl() + ", videoImage=" + getVideoImage() + ", shared=" + getShared() + ", isAlive=" + getIsAlive() + ", hotComment=" + getHotComment() + ", hotComAuditor=" + getHotComAuditor() + ", hotCommentList=" + getHotCommentList() + ", hotComPrasie=" + getHotComPrasie() + ", specialContent=" + getSpecialContent() + ", seek=" + getSeek() + ", isPlaying=" + isPlaying() + ", topic=" + getTopic() + ", coinTags=" + getCoinTags() + ")";
    }
}
