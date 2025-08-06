package com.tencent.imsdk.message;

import java.util.ArrayList;
import java.util.List;

public class MergerElement extends MessageBaseElement {
    private List<String> abstractList = new ArrayList();
    private String compatibleText;
    private boolean layerOverLimit = false;
    private List<Message> messageList = new ArrayList();
    private int messageNumber;
    private byte[] relayBuffer;
    private String relayJsonKey;
    private String relayPbKey;
    private String title;

    public MergerElement() {
        setElementType(10);
    }

    public void addAbstract(String str) {
        List<String> list = this.abstractList;
        if (list != null && str != null) {
            list.add(str);
        }
    }

    public List<String> getAbstractList() {
        return this.abstractList;
    }

    public String getCompatibleText() {
        return this.compatibleText;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isLayerOverLimit() {
        return this.layerOverLimit;
    }

    public void setAbstractList(List<String> list) {
        this.abstractList = list;
    }

    public void setCompatibleText(String str) {
        this.compatibleText = str;
    }

    public void setMessageList(List<Message> list) {
        this.messageList = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
