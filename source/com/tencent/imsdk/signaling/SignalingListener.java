package com.tencent.imsdk.signaling;

import java.util.List;

public abstract class SignalingListener {
    public void onInvitationCancelled(String str, String str2, String str3) {
    }

    public void onInvitationModified(String str, String str2) {
    }

    public void onInvitationTimeout(String str, List<String> list) {
    }

    public void onInviteeAccepted(String str, String str2, String str3) {
    }

    public void onInviteeRejected(String str, String str2, String str3) {
    }

    public void onReceiveNewInvitation(String str, String str2, String str3, List<String> list, String str4) {
    }
}
