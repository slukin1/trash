package com.sumsub.sns.core.data.listener;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import kotlin.Metadata;

@a
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001\fJ@\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "", "onVerificationStep", "Landroid/view/View;", "context", "Landroid/content/Context;", "verificationStep", "", "idDocumentType", "scene", "position", "countryCode", "Position", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SNSInstructionsViewHandler {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler$Position;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FULLSCREEN", "BOTTOMSHEET", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Position {
        FULLSCREEN("fullScreen"),
        BOTTOMSHEET("bottomSheet");
        
        private final String value;

        private Position(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    View onVerificationStep(Context context, String str, String str2, String str3, String str4, String str5);
}
