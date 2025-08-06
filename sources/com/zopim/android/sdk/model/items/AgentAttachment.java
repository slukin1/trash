package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;
import java.io.File;
import java.net.URL;

public class AgentAttachment extends AgentItem<AgentAttachment> {
    private File attachmentFile;
    private String attachmentName;
    private Long attachmentSize;
    private URL attachmentUrl;

    public AgentAttachment() {
        super.setType(RowItem.Type.AGENT_ATTACHMENT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentAttachment) || !super.equals(obj)) {
            return false;
        }
        AgentAttachment agentAttachment = (AgentAttachment) obj;
        URL url = this.attachmentUrl;
        if (url == null ? agentAttachment.attachmentUrl != null : !url.equals(agentAttachment.attachmentUrl)) {
            return false;
        }
        Long l11 = this.attachmentSize;
        if (l11 == null ? agentAttachment.attachmentSize != null : !l11.equals(agentAttachment.attachmentSize)) {
            return false;
        }
        String str = this.attachmentName;
        if (str == null ? agentAttachment.attachmentName != null : !str.equals(agentAttachment.attachmentName)) {
            return false;
        }
        File file = this.attachmentFile;
        File file2 = agentAttachment.attachmentFile;
        if (file != null) {
            return file.equals(file2);
        }
        if (file2 == null) {
            return true;
        }
        return false;
    }

    public File getAttachmentFile() {
        return this.attachmentFile;
    }

    public String getAttachmentName() {
        return this.attachmentName;
    }

    public Long getAttachmentSize() {
        return this.attachmentSize;
    }

    public URL getAttachmentUrl() {
        return this.attachmentUrl;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        URL url = this.attachmentUrl;
        int i11 = 0;
        int hashCode2 = (hashCode + (url != null ? url.hashCode() : 0)) * 31;
        Long l11 = this.attachmentSize;
        int hashCode3 = (hashCode2 + (l11 != null ? l11.hashCode() : 0)) * 31;
        String str = this.attachmentName;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        File file = this.attachmentFile;
        if (file != null) {
            i11 = file.hashCode();
        }
        return hashCode4 + i11;
    }

    public void setAttachmentFile(File file) {
        this.attachmentFile = file;
    }

    public void setAttachmentName(String str) {
        this.attachmentName = str;
    }

    public void setAttachmentSize(Long l11) {
        this.attachmentSize = l11;
    }

    public void setAttachmentUrl(URL url) {
        this.attachmentUrl = url;
    }

    public String toString() {
        return "attachFile:" + this.attachmentFile + " attachUrl:" + this.attachmentUrl + " attachName:" + this.attachmentName + " attachSize:" + this.attachmentSize + super.toString();
    }

    public void update(AgentAttachment agentAttachment) {
        super.update(agentAttachment);
        this.attachmentUrl = agentAttachment.attachmentUrl;
        this.attachmentSize = agentAttachment.attachmentSize;
        this.attachmentName = agentAttachment.attachmentName;
        this.attachmentFile = agentAttachment.attachmentFile;
    }
}
