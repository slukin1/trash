package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.result.EmailAddressParsedResult;
import com.google.zxing.client.result.ParsedResult;
import pro.huobi.R;

public final class EmailAddressResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_email, R.string.button_add_contact};

    public EmailAddressResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public int getDisplayTitle() {
        return R.string.result_email_address;
    }

    public void handleButtonPress(int i11) {
        EmailAddressParsedResult emailAddressParsedResult = (EmailAddressParsedResult) getResult();
        if (i11 == 0) {
            sendEmail(emailAddressParsedResult.getTos(), emailAddressParsedResult.getCCs(), emailAddressParsedResult.getBCCs(), emailAddressParsedResult.getSubject(), emailAddressParsedResult.getBody());
        } else if (i11 == 1) {
            addEmailOnlyContact(emailAddressParsedResult.getTos(), (String[]) null);
        }
    }
}
