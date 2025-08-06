package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import de.authada.library.api.CheckFailedReason;
import de.authada.library.api.authentication.Pin;
import de.authada.library.api.pinChanger.PinChangerCallback;
import de.authada.library.api.pinChanger.TPin;

public interface c extends PinChangerCallback {
    void a(CheckFailedReason checkFailedReason, TPin tPin, Pin pin, Integer num);

    void onEidCardCheckFailed(CheckFailedReason checkFailedReason);
}
