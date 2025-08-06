package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.TelParsedResult;
import pro.huobi.R;

public final class TelResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_dial, R.string.button_add_contact};

    public TelResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public CharSequence getDisplayContents() {
        return ResultHandler.formatPhone(getResult().getDisplayResult().replace("\r", ""));
    }

    public int getDisplayTitle() {
        return R.string.result_tel;
    }

    public void handleButtonPress(int i11) {
        TelParsedResult telParsedResult = (TelParsedResult) getResult();
        if (i11 == 0) {
            dialPhoneFromUri(telParsedResult.getTelURI());
            getActivity().finish();
        } else if (i11 == 1) {
            addPhoneOnlyContact(new String[]{telParsedResult.getNumber()}, (String[]) null);
        }
    }
}
