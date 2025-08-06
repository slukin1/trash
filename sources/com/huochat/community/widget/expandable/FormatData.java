package com.huochat.community.widget.expandable;

import java.util.List;

public class FormatData {
    private String formatedContent;
    private List<PositionData> positionDatas;

    public String getFormatedContent() {
        return this.formatedContent;
    }

    public List<PositionData> getPositionDatas() {
        return this.positionDatas;
    }

    public void setFormatedContent(String str) {
        this.formatedContent = str;
    }

    public void setPositionDatas(List<PositionData> list) {
        this.positionDatas = list;
    }

    public static class PositionData {
        private int end;
        private String selfAim;
        private String selfContent;
        private int start;
        private LinkType type;
        private String url;

        public PositionData(int i11, int i12, String str, LinkType linkType) {
            this.start = i11;
            this.end = i12;
            this.url = str;
            this.type = linkType;
        }

        public int getEnd() {
            return this.end;
        }

        public String getSelfAim() {
            return this.selfAim;
        }

        public String getSelfContent() {
            return this.selfContent;
        }

        public int getStart() {
            return this.start;
        }

        public LinkType getType() {
            return this.type;
        }

        public String getUrl() {
            return this.url;
        }

        public void setEnd(int i11) {
            this.end = i11;
        }

        public void setSelfAim(String str) {
            this.selfAim = str;
        }

        public void setSelfContent(String str) {
            this.selfContent = str;
        }

        public void setStart(int i11) {
            this.start = i11;
        }

        public void setType(LinkType linkType) {
            this.type = linkType;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public PositionData(int i11, int i12, String str, String str2, LinkType linkType) {
            this.start = i11;
            this.end = i12;
            this.selfAim = str;
            this.selfContent = str2;
            this.type = linkType;
        }
    }
}
