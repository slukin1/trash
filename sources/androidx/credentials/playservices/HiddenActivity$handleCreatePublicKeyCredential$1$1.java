package androidx.credentials.playservices;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HiddenActivity$handleCreatePublicKeyCredential$1$1 extends Lambda implements l<PendingIntent, Unit> {
    public final /* synthetic */ int $requestCode;
    public final /* synthetic */ HiddenActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HiddenActivity$handleCreatePublicKeyCredential$1$1(HiddenActivity hiddenActivity, int i11) {
        super(1);
        this.this$0 = hiddenActivity;
        this.$requestCode = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PendingIntent) obj);
        return Unit.f56620a;
    }

    public final void invoke(PendingIntent pendingIntent) {
        try {
            this.this$0.mWaitingForActivityResult = true;
            this.this$0.startIntentSenderForResult(pendingIntent.getIntentSender(), this.$requestCode, (Intent) null, 0, 0, 0, (Bundle) null);
        } catch (IntentSender.SendIntentException e11) {
            HiddenActivity hiddenActivity = this.this$0;
            ResultReceiver access$getResultReceiver$p = hiddenActivity.resultReceiver;
            String name = CreateCredentialUnknownException.class.getName();
            hiddenActivity.setupFailure(access$getResultReceiver$p, name, "During public key credential, found IntentSender failure on public key creation: " + e11.getMessage());
        }
    }
}
