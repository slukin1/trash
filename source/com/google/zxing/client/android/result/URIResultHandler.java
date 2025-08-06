package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.android.LocaleManager;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.URIParsedResult;
import java.util.Locale;
import pro.huobi.R;

public final class URIResultHandler extends ResultHandler {
    private static final String[] SECURE_PROTOCOLS = {"otpauth:"};
    private static final int[] buttons = {R.string.button_open_browser, R.string.button_share_by_email, R.string.button_share_by_sms, R.string.button_search_book_contents};

    public URIResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
    }

    public boolean areContentsSecure() {
        String lowerCase = ((URIParsedResult) getResult()).getURI().toLowerCase(Locale.ENGLISH);
        for (String startsWith : SECURE_PROTOCOLS) {
            if (lowerCase.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public int getButtonCount() {
        if (LocaleManager.isBookSearchUrl(((URIParsedResult) getResult()).getURI())) {
            return buttons.length;
        }
        return buttons.length - 1;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public Integer getDefaultButtonID() {
        return 0;
    }

    public int getDisplayTitle() {
        return R.string.result_uri;
    }

    public void handleButtonPress(int i11) {
        String uri = ((URIParsedResult) getResult()).getURI();
        if (i11 == 0) {
            openURL(uri);
        } else if (i11 == 1) {
            shareByEmail(uri);
        } else if (i11 == 2) {
            shareBySMS(uri);
        }
    }
}
