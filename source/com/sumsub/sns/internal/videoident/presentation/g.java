package com.sumsub.sns.internal.videoident.presentation;

import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;

public interface g {
    void connectToRoom(String str, String str2);

    void disconnect();

    SNSVideoChatState getState();

    void makePhoto();

    void sendMessage(SNSMessage.ClientMessage clientMessage);
}
