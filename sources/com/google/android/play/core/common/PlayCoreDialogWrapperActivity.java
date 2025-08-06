package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;

public class PlayCoreDialogWrapperActivity extends Activity {
    private ResultReceiver zza;

    private final void zza() {
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver != null) {
            resultReceiver.send(3, new Bundle());
        }
    }

    public final void onActivityResult(int i11, int i12, Intent intent) {
        ResultReceiver resultReceiver;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 0 && (resultReceiver = this.zza) != null) {
            if (i12 == -1) {
                resultReceiver.send(1, new Bundle());
            } else if (i12 == 0) {
                resultReceiver.send(2, new Bundle());
            }
        }
        finish();
    }

    public final void onCreate(Bundle bundle) {
        Intent intent;
        int intExtra = getIntent().getIntExtra("window_flags", 0);
        if (intExtra != 0) {
            getWindow().getDecorView().setSystemUiVisibility(intExtra);
            intent = new Intent();
            intent.putExtra("window_flags", intExtra);
        } else {
            intent = null;
        }
        Intent intent2 = intent;
        super.onCreate(bundle);
        if (bundle == null) {
            this.zza = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                zza();
                finish();
            }
            try {
                startIntentSenderForResult(((PendingIntent) extras.get("confirmation_intent")).getIntentSender(), 0, intent2, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused) {
                zza();
                finish();
            }
        } else {
            this.zza = (ResultReceiver) bundle.getParcelable("result_receiver");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.zza);
    }
}
