package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MktRuleBean implements Serializable {
    public MktRuleTXBean button;
    public String cancelText;
    public String content;
    public String continueText;
    public int continueTrade;
    public int eventId;
    public String image;
    public Object link;
    public int mktCode;
    public List<MktRulePageBean> pageList;
    public String subtitle;
    public List<String> tag;
    public String title;
    public int type;
    public String video;

    public boolean canEqual(Object obj) {
        return obj instanceof MktRuleBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MktRuleBean)) {
            return false;
        }
        MktRuleBean mktRuleBean = (MktRuleBean) obj;
        if (!mktRuleBean.canEqual(this) || getMktCode() != mktRuleBean.getMktCode()) {
            return false;
        }
        String continueText2 = getContinueText();
        String continueText3 = mktRuleBean.getContinueText();
        if (continueText2 != null ? !continueText2.equals(continueText3) : continueText3 != null) {
            return false;
        }
        String cancelText2 = getCancelText();
        String cancelText3 = mktRuleBean.getCancelText();
        if (cancelText2 != null ? !cancelText2.equals(cancelText3) : cancelText3 != null) {
            return false;
        }
        if (getContinueTrade() != mktRuleBean.getContinueTrade()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = mktRuleBean.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        String subtitle2 = getSubtitle();
        String subtitle3 = mktRuleBean.getSubtitle();
        if (subtitle2 != null ? !subtitle2.equals(subtitle3) : subtitle3 != null) {
            return false;
        }
        if (getType() != mktRuleBean.getType()) {
            return false;
        }
        String content2 = getContent();
        String content3 = mktRuleBean.getContent();
        if (content2 != null ? !content2.equals(content3) : content3 != null) {
            return false;
        }
        List<MktRulePageBean> pageList2 = getPageList();
        List<MktRulePageBean> pageList3 = mktRuleBean.getPageList();
        if (pageList2 != null ? !pageList2.equals(pageList3) : pageList3 != null) {
            return false;
        }
        List<MktRuleTXBean> link2 = getLink();
        List<MktRuleTXBean> link3 = mktRuleBean.getLink();
        if (link2 != null ? !link2.equals(link3) : link3 != null) {
            return false;
        }
        MktRuleTXBean button2 = getButton();
        MktRuleTXBean button3 = mktRuleBean.getButton();
        if (button2 != null ? !button2.equals(button3) : button3 != null) {
            return false;
        }
        String video2 = getVideo();
        String video3 = mktRuleBean.getVideo();
        if (video2 != null ? !video2.equals(video3) : video3 != null) {
            return false;
        }
        if (getEventId() != mktRuleBean.getEventId()) {
            return false;
        }
        String image2 = getImage();
        String image3 = mktRuleBean.getImage();
        if (image2 != null ? !image2.equals(image3) : image3 != null) {
            return false;
        }
        List<String> tag2 = getTag();
        List<String> tag3 = mktRuleBean.getTag();
        return tag2 != null ? tag2.equals(tag3) : tag3 == null;
    }

    public MktRuleTXBean getButton() {
        return this.button;
    }

    public String getCancelText() {
        return this.cancelText;
    }

    public String getContent() {
        return this.content;
    }

    public String getContinueText() {
        return this.continueText;
    }

    public int getContinueTrade() {
        return this.continueTrade;
    }

    public int getEventId() {
        return this.eventId;
    }

    public String getImage() {
        return this.image;
    }

    public List<MktRuleTXBean> getLink() {
        try {
            Object obj = this.link;
            if (obj instanceof Collection) {
                ArrayList arrayList = new ArrayList();
                for (Map mapToObject : (List) obj) {
                    arrayList.add((MktRuleTXBean) mapToObject(mapToObject, MktRuleTXBean.class));
                }
                return arrayList;
            } else if (!(obj instanceof Map)) {
                return new ArrayList();
            } else {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add((MktRuleTXBean) mapToObject((Map) obj, MktRuleTXBean.class));
                return arrayList2;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            return new ArrayList();
        }
    }

    public int getMktCode() {
        return this.mktCode;
    }

    public List<MktRulePageBean> getPageList() {
        return this.pageList;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public List<String> getTag() {
        return this.tag;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getVideo() {
        return this.video;
    }

    public int hashCode() {
        String continueText2 = getContinueText();
        int i11 = 43;
        int mktCode2 = ((getMktCode() + 59) * 59) + (continueText2 == null ? 43 : continueText2.hashCode());
        String cancelText2 = getCancelText();
        int hashCode = (((mktCode2 * 59) + (cancelText2 == null ? 43 : cancelText2.hashCode())) * 59) + getContinueTrade();
        String title2 = getTitle();
        int hashCode2 = (hashCode * 59) + (title2 == null ? 43 : title2.hashCode());
        String subtitle2 = getSubtitle();
        int hashCode3 = (((hashCode2 * 59) + (subtitle2 == null ? 43 : subtitle2.hashCode())) * 59) + getType();
        String content2 = getContent();
        int hashCode4 = (hashCode3 * 59) + (content2 == null ? 43 : content2.hashCode());
        List<MktRulePageBean> pageList2 = getPageList();
        int hashCode5 = (hashCode4 * 59) + (pageList2 == null ? 43 : pageList2.hashCode());
        List<MktRuleTXBean> link2 = getLink();
        int hashCode6 = (hashCode5 * 59) + (link2 == null ? 43 : link2.hashCode());
        MktRuleTXBean button2 = getButton();
        int hashCode7 = (hashCode6 * 59) + (button2 == null ? 43 : button2.hashCode());
        String video2 = getVideo();
        int hashCode8 = (((hashCode7 * 59) + (video2 == null ? 43 : video2.hashCode())) * 59) + getEventId();
        String image2 = getImage();
        int hashCode9 = (hashCode8 * 59) + (image2 == null ? 43 : image2.hashCode());
        List<String> tag2 = getTag();
        int i12 = hashCode9 * 59;
        if (tag2 != null) {
            i11 = tag2.hashCode();
        }
        return i12 + i11;
    }

    public Object mapToObject(Map<String, Object> map, Class<?> cls) throws Exception {
        if (map == null) {
            return null;
        }
        Object newInstance = cls.newInstance();
        for (Field field : newInstance.getClass().getDeclaredFields()) {
            int modifiers = field.getModifiers();
            if (!Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers)) {
                field.setAccessible(true);
                field.set(newInstance, map.get(field.getName()));
            }
        }
        return newInstance;
    }

    public void setButton(MktRuleTXBean mktRuleTXBean) {
        this.button = mktRuleTXBean;
    }

    public void setCancelText(String str) {
        this.cancelText = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContinueText(String str) {
        this.continueText = str;
    }

    public void setContinueTrade(int i11) {
        this.continueTrade = i11;
    }

    public void setEventId(int i11) {
        this.eventId = i11;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setLink(Object obj) {
        this.link = obj;
    }

    public void setMktCode(int i11) {
        this.mktCode = i11;
    }

    public void setPageList(List<MktRulePageBean> list) {
        this.pageList = list;
    }

    public void setSubtitle(String str) {
        this.subtitle = str;
    }

    public void setTag(List<String> list) {
        this.tag = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public String toString() {
        return "MktRuleBean(mktCode=" + getMktCode() + ", continueText=" + getContinueText() + ", cancelText=" + getCancelText() + ", continueTrade=" + getContinueTrade() + ", title=" + getTitle() + ", subtitle=" + getSubtitle() + ", type=" + getType() + ", content=" + getContent() + ", pageList=" + getPageList() + ", link=" + getLink() + ", button=" + getButton() + ", video=" + getVideo() + ", eventId=" + getEventId() + ", image=" + getImage() + ", tag=" + getTag() + ")";
    }
}
