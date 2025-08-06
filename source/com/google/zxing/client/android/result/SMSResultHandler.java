package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.SMSParsedResult;
import pro.huobi.R;

public final class SMSResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_sms, R.string.button_mms};

    public SMSResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public CharSequence getDisplayContents() {
        SMSParsedResult sMSParsedResult = (SMSParsedResult) getResult();
        String[] numbers = sMSParsedResult.getNumbers();
        String[] strArr = new String[numbers.length];
        for (int i11 = 0; i11 < numbers.length; i11++) {
            strArr[i11] = ResultHandler.formatPhone(numbers[i11]);
        }
        StringBuilder sb2 = new StringBuilder(50);
        ParsedResult.maybeAppend(strArr, sb2);
        ParsedResult.maybeAppend(sMSParsedResult.getSubject(), sb2);
        ParsedResult.maybeAppend(sMSParsedResult.getBody(), sb2);
        return sb2.toString();
    }

    public int getDisplayTitle() {
        return R.string.result_sms;
    }

    public void handleButtonPress(int i11) {
        SMSParsedResult sMSParsedResult = (SMSParsedResult) getResult();
        String str = sMSParsedResult.getNumbers()[0];
        if (i11 == 0) {
            sendSMS(str, sMSParsedResult.getBody());
        } else if (i11 == 1) {
            sendMMS(str, sMSParsedResult.getSubject(), sMSParsedResult.getBody());
        }
    }
}
