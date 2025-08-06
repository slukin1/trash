package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import pro.huobi.R;

public final class TextResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_web_search, R.string.button_share_by_email, R.string.button_share_by_sms, R.string.button_custom_product_search};

    public TextResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult, Result result) {
        super(fragmentActivity, parsedResult, result);
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public int getDisplayTitle() {
        return R.string.result_text;
    }

    public void handleButtonPress(int i11) {
        String displayResult = getResult().getDisplayResult();
        if (i11 == 0) {
            webSearch(displayResult);
        } else if (i11 == 1) {
            shareByEmail(displayResult);
        } else if (i11 == 2) {
            shareBySMS(displayResult);
        } else if (i11 == 3) {
            openURL(fillInCustomSearchURL(displayResult));
        }
    }
}
