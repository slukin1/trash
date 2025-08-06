package androidx.credentials.playservices;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HiddenActivity$handleCreatePassword$1$1 extends Lambda implements l<SavePasswordResult, Unit> {
    public final /* synthetic */ int $requestCode;
    public final /* synthetic */ HiddenActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HiddenActivity$handleCreatePassword$1$1(HiddenActivity hiddenActivity, int i11) {
        super(1);
        this.this$0 = hiddenActivity;
        this.$requestCode = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SavePasswordResult) obj);
        return Unit.f56620a;
    }

    public final void invoke(SavePasswordResult savePasswordResult) {
        try {
            this.this$0.mWaitingForActivityResult = true;
            this.this$0.startIntentSenderForResult(savePasswordResult.getPendingIntent().getIntentSender(), this.$requestCode, (Intent) null, 0, 0, 0, (Bundle) null);
        } catch (IntentSender.SendIntentException e11) {
            HiddenActivity hiddenActivity = this.this$0;
            ResultReceiver access$getResultReceiver$p = hiddenActivity.resultReceiver;
            String name = CreateCredentialUnknownException.class.getName();
            hiddenActivity.setupFailure(access$getResultReceiver$p, name, "During save password, found UI intent sender failure: " + e11.getMessage());
        }
    }
}
