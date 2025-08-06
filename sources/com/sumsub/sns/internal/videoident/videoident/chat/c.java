package com.sumsub.sns.internal.videoident.videoident.chat;

import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatController;
import com.sumsub.sns.internal.videoident.videoident.chat.SNSVideoChatState;
import com.sumsub.sns.internal.videoident.videoident.twilio.CameraCapturerCompat;
import kotlin.jvm.internal.r;

public final class c {
    public static final SNSVideoChatController.CameraId b(CameraCapturerCompat.Source source) {
        if (source == CameraCapturerCompat.Source.BACK_CAMERA) {
            return SNSVideoChatController.CameraId.BACK;
        }
        return SNSVideoChatController.CameraId.FRONT;
    }

    public static final SNSVideoChatState.d a(SNSVideoChatState.d.a aVar, b bVar) {
        return new SNSVideoChatState.d(true, bVar.h(), bVar.g(), false, 8, (r) null);
    }
}
