package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.result.GeoParsedResult;
import com.google.zxing.client.result.ParsedResult;
import pro.huobi.R;

public final class GeoResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_show_map, R.string.button_get_directions};

    public GeoResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public int getDisplayTitle() {
        return R.string.result_geo;
    }

    public void handleButtonPress(int i11) {
        GeoParsedResult geoParsedResult = (GeoParsedResult) getResult();
        if (i11 == 0) {
            openMap(geoParsedResult.getGeoURI());
        } else if (i11 == 1) {
            getDirections(geoParsedResult.getLatitude(), geoParsedResult.getLongitude());
        }
    }
}
