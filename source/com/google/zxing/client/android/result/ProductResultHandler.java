package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.Result;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ProductParsedResult;
import pro.huobi.R;

public final class ProductResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_product_search, R.string.button_web_search, R.string.button_custom_product_search};

    public ProductResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult, Result result) {
        super(fragmentActivity, parsedResult, result);
    }

    private static String getProductIDFromResult(ParsedResult parsedResult) {
        if (parsedResult instanceof ProductParsedResult) {
            return ((ProductParsedResult) parsedResult).getNormalizedProductID();
        }
        if (parsedResult instanceof ExpandedProductParsedResult) {
            return ((ExpandedProductParsedResult) parsedResult).getRawText();
        }
        throw new IllegalArgumentException(parsedResult.getClass().toString());
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public int getDisplayTitle() {
        return R.string.result_product;
    }

    public void handleButtonPress(int i11) {
        String productIDFromResult = getProductIDFromResult(getResult());
        if (i11 == 0) {
            openProductSearch(productIDFromResult);
        } else if (i11 == 1) {
            webSearch(productIDFromResult);
        } else if (i11 == 2) {
            openURL(fillInCustomSearchURL(productIDFromResult));
        }
    }
}
