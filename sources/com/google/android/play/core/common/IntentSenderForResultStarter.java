package com.google.android.play.core.common;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

public interface IntentSenderForResultStarter {
    void startIntentSenderForResult(IntentSender intentSender, int i11, Intent intent, int i12, int i13, int i14, Bundle bundle) throws IntentSender.SendIntentException;
}
