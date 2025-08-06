package com.google.zxing.client.android.result;

import androidx.fragment.app.FragmentActivity;
import com.google.zxing.Result;
import com.google.zxing.client.result.ISBNParsedResult;
import com.google.zxing.client.result.ParsedResult;
import pro.huobi.R;

public final class ISBNResultHandler extends ResultHandler {
    private static final int[] buttons = {R.string.button_product_search, R.string.button_book_search, R.string.button_search_book_contents, R.string.button_custom_product_search};

    public ISBNResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult, Result result) {
        super(fragmentActivity, parsedResult, result);
    }

    public int getButtonCount() {
        return hasCustomProductSearch() ? buttons.length : buttons.length - 1;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public int getDisplayTitle() {
        return R.string.result_isbn;
    }

    public void handleButtonPress(int i11) {
        ISBNParsedResult iSBNParsedResult = (ISBNParsedResult) getResult();
        if (i11 == 0) {
            openProductSearch(iSBNParsedResult.getISBN());
        } else if (i11 == 1) {
            openBookSearch(iSBNParsedResult.getISBN());
        } else if (i11 == 3) {
            openURL(fillInCustomSearchURL(iSBNParsedResult.getISBN()));
        }
    }
}
