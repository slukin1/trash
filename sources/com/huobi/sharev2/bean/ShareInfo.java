package com.huobi.sharev2.bean;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.huobi.invite.bean.InvitePosterItem;
import d10.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;

@Keep
public class ShareInfo {
    private Bitmap base64Bitmap;
    private float base64BitmapRatio;
    private String base64Image;
    private String buttonId;
    private List<String> channelList = new ArrayList();
    @Deprecated
    private String condition;
    private String copyText;
    private int defaultTab;
    private Map<String, Object> extend = new HashMap();
    private List<String> extendChannelList = new ArrayList();
    private Map<String, Object> extendMap;
    private String floatContent;
    private List<Bitmap> imageBitmaps = new ArrayList();
    @Deprecated
    private int imageStyle;
    private ArrayList<String> imageUrls = new ArrayList<>();
    private String inviteCode;
    private int inviterCodeType;
    private int inviterIdType;
    private int isInvite;
    private String pageId;
    private String parseUrl;
    private List<InvitePosterItem> posterList = new ArrayList();
    private String posterSubtitle;
    private String posterTitle;
    private String qrUrl;
    private l<? super Integer, Unit> shareCallback;
    private String shareContent;
    private String shareText;
    private String shareThumbImage;
    private ShareType shareType = ShareType.SHARE_DEFAULT_NONE;
    private String shareUrl;
    private boolean showNativeQr;
    private boolean showTail;
    private String source = "";
    private Bitmap tailBitmap;
    private String tailImgUrl = "";

    public enum ShareType {
        SHARE_CONTENT,
        SHARE_IMAGE_WITH_BASE64,
        SHARE_IMAGE_WITH_URLS,
        SHARE_IMAGE_WITH_BITMAPS,
        SHARE_DEFAULT_NONE
    }

    public Bitmap getBase64Bitmap() {
        return this.base64Bitmap;
    }

    public float getBase64BitmapRatio() {
        return this.base64BitmapRatio;
    }

    public String getBase64Image() {
        return this.base64Image;
    }

    public String getButtonId() {
        return this.buttonId;
    }

    public List<String> getChannelList() {
        return this.channelList;
    }

    public String getCondition() {
        return this.condition;
    }

    public String getCopyText() {
        return this.copyText;
    }

    public int getDefaultTab() {
        return this.defaultTab;
    }

    public Map<String, Object> getExtend() {
        return this.extend;
    }

    public List<String> getExtendChannelList() {
        return this.extendChannelList;
    }

    public Map<String, Object> getExtendMap() {
        return this.extendMap;
    }

    public String getFloatContent() {
        return this.floatContent;
    }

    public List<Bitmap> getImageBitmaps() {
        return this.imageBitmaps;
    }

    public int getImageStyle() {
        return this.imageStyle;
    }

    public ArrayList<String> getImageUrls() {
        return this.imageUrls;
    }

    public String getInviteCode() {
        return this.inviteCode;
    }

    public int getInviterCodeType() {
        return this.inviterCodeType;
    }

    public int getInviterIdType() {
        return this.inviterIdType;
    }

    public int getIsInvite() {
        return this.isInvite;
    }

    public String getPageId() {
        return this.pageId;
    }

    public String getParseUrl() {
        return this.parseUrl;
    }

    public List<InvitePosterItem> getPosterList() {
        return this.posterList;
    }

    public String getPosterSubtitle() {
        return this.posterSubtitle;
    }

    public String getPosterTitle() {
        return this.posterTitle;
    }

    public String getQrUrl() {
        return this.qrUrl;
    }

    public l<? super Integer, Unit> getShareCallback() {
        return this.shareCallback;
    }

    public String getShareContent() {
        return this.shareContent;
    }

    public String getShareText() {
        return this.shareText;
    }

    public String getShareThumbImage() {
        return this.shareThumbImage;
    }

    public ShareType getShareType() {
        return this.shareType;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String getSource() {
        return this.source;
    }

    public Bitmap getTailBitmap() {
        return this.tailBitmap;
    }

    public String getTailImgUrl() {
        return this.tailImgUrl;
    }

    public boolean isShowNativeQr() {
        return this.showNativeQr;
    }

    @Deprecated
    public boolean isShowTail() {
        return false;
    }

    public void setBase64Bitmap(Bitmap bitmap) {
        this.base64Bitmap = bitmap;
    }

    public void setBase64BitmapRatio(float f11) {
        this.base64BitmapRatio = f11;
    }

    public void setBase64Image(String str) {
        this.base64Image = str;
    }

    public void setButtonId(String str) {
        this.buttonId = str;
    }

    public void setChannelList(List<String> list) {
        if (list != null) {
            this.channelList = list;
        }
    }

    public void setCondition(String str) {
        this.condition = str;
    }

    public void setCopyText(String str) {
        this.copyText = str;
    }

    public void setDefaultTab(int i11) {
        this.defaultTab = i11;
    }

    public void setExtend(Map<String, Object> map) {
        this.extend = map;
    }

    public void setExtendChannelList(List<String> list) {
        this.extendChannelList = list;
    }

    public void setExtendMap(Map<String, Object> map) {
        this.extendMap = map;
    }

    public void setFloatContent(String str) {
        this.floatContent = str;
    }

    public void setImageBitmaps(List<Bitmap> list) {
        this.imageBitmaps = list;
    }

    public void setImageStyle(int i11) {
        this.imageStyle = i11;
    }

    public void setImageUrls(ArrayList<String> arrayList) {
        this.imageUrls = arrayList;
    }

    public void setInviteCode(String str) {
        this.inviteCode = str;
    }

    public void setInviterCodeType(int i11) {
        this.inviterCodeType = i11;
    }

    public void setInviterIdType(int i11) {
        this.inviterIdType = i11;
    }

    public void setIsInvite(int i11) {
        this.isInvite = i11;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public void setParseUrl(String str) {
        this.parseUrl = str;
    }

    public void setPosterList(List<InvitePosterItem> list) {
        this.posterList = list;
    }

    public void setPosterSubtitle(String str) {
        this.posterSubtitle = str;
    }

    public void setPosterTitle(String str) {
        this.posterTitle = str;
    }

    public void setQrUrl(String str) {
        this.qrUrl = str;
    }

    public void setShareCallback(l<? super Integer, Unit> lVar) {
        this.shareCallback = lVar;
    }

    public void setShareContent(String str) {
        this.shareContent = str;
    }

    public void setShareText(String str) {
        this.shareText = str;
    }

    public void setShareThumbImage(String str) {
        this.shareThumbImage = str;
    }

    public void setShareType(ShareType shareType2) {
        this.shareType = shareType2;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setShowNativeQr(boolean z11) {
        this.showNativeQr = z11;
    }

    public void setShowTail(boolean z11) {
        this.showTail = z11;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTailBitmap(Bitmap bitmap) {
        this.tailBitmap = bitmap;
    }

    public void setTailImgUrl(String str) {
        this.tailImgUrl = str;
    }

    public String toString() {
        return "ShareInfo {\n shareType=" + this.shareType + ", \n showNativeQr=" + this.showNativeQr + ", \n condition='" + this.condition + '\'' + ", \n qrUrl='" + this.qrUrl + '\'' + ", \n shareUrl='" + this.shareUrl + '\'' + ", \n extend=" + this.extend + ", \n copyText='" + this.copyText + '\'' + ", \n parseUrl='" + this.parseUrl + '\'' + ", \n shareText='" + this.shareText + '\'' + ", \n shareContent='" + this.shareContent + '\'' + ", \n pageId='" + this.pageId + '\'' + ", \n buttonId='" + this.buttonId + '\'' + ", \n floatContent='" + this.floatContent + '\'' + ", \n base64Image='" + this.base64Image + '\'' + ", \n imageUrls=" + this.imageUrls + ", \n imageBitmaps=" + this.imageBitmaps + ", \n base64Bitmap=" + this.base64Bitmap + ", \n base64BitmapRatio=" + this.base64BitmapRatio + ", \n inviteCode='" + this.inviteCode + '\'' + ", \n posterList=" + this.posterList + ", \n imageStyle=" + this.imageStyle + ", \n posterTitle='" + this.posterTitle + '\'' + ", \n posterSubtitle='" + this.posterSubtitle + '\'' + ", \n channelList=" + this.channelList + '}';
    }
}
