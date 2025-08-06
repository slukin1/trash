package com.google.zxing.client.android;

import android.content.Intent;
import android.net.Uri;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.android.Intents;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

final class DecodeFormatManager {
    public static final Set<BarcodeFormat> AZTEC_FORMATS;
    private static final Pattern COMMA_PATTERN = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    public static final Set<BarcodeFormat> DATA_MATRIX_FORMATS;
    private static final Map<String, Set<BarcodeFormat>> FORMATS_FOR_MODE;
    public static final Set<BarcodeFormat> INDUSTRIAL_FORMATS;
    private static final Set<BarcodeFormat> ONE_D_FORMATS;
    public static final Set<BarcodeFormat> PDF417_FORMATS;
    public static final Set<BarcodeFormat> PRODUCT_FORMATS;
    public static final Set<BarcodeFormat> QR_CODE_FORMATS;

    static {
        EnumSet of2 = EnumSet.of(BarcodeFormat.QR_CODE);
        QR_CODE_FORMATS = of2;
        EnumSet of3 = EnumSet.of(BarcodeFormat.DATA_MATRIX);
        DATA_MATRIX_FORMATS = of3;
        EnumSet of4 = EnumSet.of(BarcodeFormat.AZTEC);
        AZTEC_FORMATS = of4;
        EnumSet of5 = EnumSet.of(BarcodeFormat.PDF_417);
        PDF417_FORMATS = of5;
        EnumSet of6 = EnumSet.of(BarcodeFormat.UPC_A, new BarcodeFormat[]{BarcodeFormat.UPC_E, BarcodeFormat.EAN_13, BarcodeFormat.EAN_8, BarcodeFormat.RSS_14, BarcodeFormat.RSS_EXPANDED});
        PRODUCT_FORMATS = of6;
        BarcodeFormat barcodeFormat = BarcodeFormat.CODE_39;
        BarcodeFormat barcodeFormat2 = BarcodeFormat.CODE_93;
        BarcodeFormat barcodeFormat3 = BarcodeFormat.CODE_128;
        INDUSTRIAL_FORMATS = EnumSet.of(barcodeFormat, barcodeFormat2, barcodeFormat3, BarcodeFormat.ITF, BarcodeFormat.CODABAR);
        EnumSet of7 = EnumSet.of(barcodeFormat3);
        ONE_D_FORMATS = of7;
        HashMap hashMap = new HashMap();
        FORMATS_FOR_MODE = hashMap;
        hashMap.put(Intents.Scan.ONE_D_MODE, of7);
        hashMap.put(Intents.Scan.PRODUCT_MODE, of6);
        hashMap.put(Intents.Scan.QR_CODE_MODE, of2);
        hashMap.put(Intents.Scan.DATA_MATRIX_MODE, of3);
        hashMap.put(Intents.Scan.AZTEC_MODE, of4);
        hashMap.put(Intents.Scan.PDF417_MODE, of5);
    }

    private DecodeFormatManager() {
    }

    public static Set<BarcodeFormat> parseDecodeFormats(Intent intent) {
        String stringExtra = intent.getStringExtra(Intents.Scan.FORMATS);
        return parseDecodeFormats(stringExtra != null ? Arrays.asList(COMMA_PATTERN.split(stringExtra)) : null, intent.getStringExtra(Intents.Scan.MODE));
    }

    public static Set<BarcodeFormat> parseDecodeFormats(Uri uri) {
        List<String> queryParameters = uri.getQueryParameters(Intents.Scan.FORMATS);
        if (!(queryParameters == null || queryParameters.size() != 1 || queryParameters.get(0) == null)) {
            queryParameters = Arrays.asList(COMMA_PATTERN.split(queryParameters.get(0)));
        }
        return parseDecodeFormats(queryParameters, uri.getQueryParameter(Intents.Scan.MODE));
    }

    private static Set<BarcodeFormat> parseDecodeFormats(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet<E> noneOf = EnumSet.noneOf(BarcodeFormat.class);
            try {
                for (String valueOf : iterable) {
                    noneOf.add(BarcodeFormat.valueOf(valueOf));
                }
                return noneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return FORMATS_FOR_MODE.get(str);
        }
        return null;
    }
}
