package com.google.zxing.client.android.encode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.BitMatrix;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import pro.huobi.R;

final class QRCodeEncoder {
    private static final int BLACK = -16777216;
    private static final String TAG = "QRCodeEncoder";
    private static final int WHITE = -1;
    private final Context activity;
    private String contents;
    private final int dimension;
    private String displayContents;
    private BarcodeFormat format;
    private String title;
    private final boolean useVCard;

    public QRCodeEncoder(Context context, Intent intent, int i11, boolean z11) throws WriterException {
        this.activity = context;
        this.dimension = i11;
        this.useVCard = z11;
        String action = intent.getAction();
        if (Intents.Encode.ACTION.equals(action)) {
            encodeContentsFromZXingIntent(intent);
        } else if ("android.intent.action.SEND".equals(action)) {
            encodeContentsFromShareIntent(intent);
        }
    }

    private void encodeContentsFromShareIntent(Intent intent) throws WriterException {
        if (intent.hasExtra("android.intent.extra.STREAM")) {
            encodeFromStreamExtra(intent);
        } else {
            encodeFromTextExtras(intent);
        }
    }

    private void encodeContentsFromZXingIntent(Intent intent) {
        String stringExtra = intent.getStringExtra(Intents.Encode.FORMAT);
        this.format = null;
        if (stringExtra != null) {
            try {
                this.format = BarcodeFormat.valueOf(stringExtra);
            } catch (IllegalArgumentException unused) {
            }
        }
        BarcodeFormat barcodeFormat = this.format;
        if (barcodeFormat == null || barcodeFormat == BarcodeFormat.QR_CODE) {
            String stringExtra2 = intent.getStringExtra(Intents.Encode.TYPE);
            if (stringExtra2 != null && !stringExtra2.isEmpty()) {
                this.format = BarcodeFormat.QR_CODE;
                encodeQRCodeContents(intent, stringExtra2);
                return;
            }
            return;
        }
        String stringExtra3 = intent.getStringExtra(Intents.Encode.DATA);
        if (stringExtra3 != null && !stringExtra3.isEmpty()) {
            this.contents = stringExtra3;
            this.displayContents = stringExtra3;
            this.title = this.activity.getString(R.string.contents_text);
        }
    }

    private void encodeFromStreamExtra(Intent intent) throws WriterException {
        InputStream openInputStream;
        this.format = BarcodeFormat.QR_CODE;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Uri uri = (Uri) extras.getParcelable("android.intent.extra.STREAM");
            if (uri != null) {
                try {
                    openInputStream = this.activity.getContentResolver().openInputStream(uri);
                    if (openInputStream != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = openInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        String str = new String(byteArray, 0, byteArray.length, "UTF-8");
                        openInputStream.close();
                        String str2 = TAG;
                        Log.d(str2, "Encoding share intent content:");
                        Log.d(str2, str);
                        ParsedResult parseResult = ResultParser.parseResult(new Result(str, byteArray, (ResultPoint[]) null, BarcodeFormat.QR_CODE));
                        if (parseResult instanceof AddressBookParsedResult) {
                            encodeQRCodeContents((AddressBookParsedResult) parseResult);
                            String str3 = this.contents;
                            if (str3 == null || str3.isEmpty()) {
                                throw new WriterException("No content to encode");
                            }
                            return;
                        }
                        throw new WriterException("Result was not an address");
                    }
                    throw new WriterException("Can't open stream for " + uri);
                } catch (IOException e11) {
                    throw new WriterException((Throwable) e11);
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw new WriterException("No EXTRA_STREAM");
            }
        } else {
            throw new WriterException("No extras");
        }
        throw th;
    }

    private void encodeFromTextExtras(Intent intent) throws WriterException {
        String trim = ContactEncoder.trim(intent.getStringExtra("android.intent.extra.TEXT"));
        if (trim == null && (trim = ContactEncoder.trim(intent.getStringExtra("android.intent.extra.HTML_TEXT"))) == null && (trim = ContactEncoder.trim(intent.getStringExtra("android.intent.extra.SUBJECT"))) == null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("android.intent.extra.EMAIL");
            trim = stringArrayExtra != null ? ContactEncoder.trim(stringArrayExtra[0]) : "?";
        }
        if (trim == null || trim.isEmpty()) {
            throw new WriterException("Empty EXTRA_TEXT");
        }
        this.contents = trim;
        this.format = BarcodeFormat.QR_CODE;
        if (intent.hasExtra("android.intent.extra.SUBJECT")) {
            this.displayContents = intent.getStringExtra("android.intent.extra.SUBJECT");
        } else if (intent.hasExtra("android.intent.extra.TITLE")) {
            this.displayContents = intent.getStringExtra("android.intent.extra.TITLE");
        } else {
            this.displayContents = this.contents;
        }
        this.title = this.activity.getString(R.string.contents_text);
    }

    private void encodeQRCodeContents(Intent intent, String str) {
        List list;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1309271157:
                if (str.equals(Contents.Type.PHONE)) {
                    c11 = 0;
                    break;
                }
                break;
            case -670199783:
                if (str.equals(Contents.Type.CONTACT)) {
                    c11 = 1;
                    break;
                }
                break;
            case 709220992:
                if (str.equals(Contents.Type.SMS)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1349204356:
                if (str.equals(Contents.Type.LOCATION)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1778595596:
                if (str.equals(Contents.Type.TEXT)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1833351709:
                if (str.equals(Contents.Type.EMAIL)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                String trim = ContactEncoder.trim(intent.getStringExtra(Intents.Encode.DATA));
                if (trim != null) {
                    this.contents = "tel:" + trim;
                    this.displayContents = ContactEncoder.formatPhone(trim);
                    this.title = this.activity.getString(R.string.contents_phone);
                    return;
                }
                return;
            case 1:
                Bundle bundleExtra = intent.getBundleExtra(Intents.Encode.DATA);
                if (bundleExtra != null) {
                    String string = bundleExtra.getString("name");
                    String string2 = bundleExtra.getString("company");
                    String string3 = bundleExtra.getString("postal");
                    List<String> allBundleValues = getAllBundleValues(bundleExtra, Contents.PHONE_KEYS);
                    List<String> allBundleValues2 = getAllBundleValues(bundleExtra, Contents.PHONE_TYPE_KEYS);
                    List<String> allBundleValues3 = getAllBundleValues(bundleExtra, Contents.EMAIL_KEYS);
                    String string4 = bundleExtra.getString(Contents.URL_KEY);
                    if (string4 == null) {
                        list = null;
                    } else {
                        list = Collections.singletonList(string4);
                    }
                    String[] encode = (this.useVCard ? new VCardContactEncoder() : new MECARDContactEncoder()).encode(Collections.singletonList(string), string2, Collections.singletonList(string3), allBundleValues, allBundleValues2, allBundleValues3, list, bundleExtra.getString(Contents.NOTE_KEY));
                    if (!encode[1].isEmpty()) {
                        this.contents = encode[0];
                        this.displayContents = encode[1];
                        this.title = this.activity.getString(R.string.contents_contact);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                String trim2 = ContactEncoder.trim(intent.getStringExtra(Intents.Encode.DATA));
                if (trim2 != null) {
                    this.contents = "sms:" + trim2;
                    this.displayContents = ContactEncoder.formatPhone(trim2);
                    this.title = this.activity.getString(R.string.contents_sms);
                    return;
                }
                return;
            case 3:
                Bundle bundleExtra2 = intent.getBundleExtra(Intents.Encode.DATA);
                if (bundleExtra2 != null) {
                    float f11 = bundleExtra2.getFloat("LAT", Float.MAX_VALUE);
                    float f12 = bundleExtra2.getFloat("LONG", Float.MAX_VALUE);
                    if (f11 != Float.MAX_VALUE && f12 != Float.MAX_VALUE) {
                        this.contents = "geo:" + f11 + ',' + f12;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(f11);
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        sb2.append(f12);
                        this.displayContents = sb2.toString();
                        this.title = this.activity.getString(R.string.contents_location);
                        return;
                    }
                    return;
                }
                return;
            case 4:
                String stringExtra = intent.getStringExtra(Intents.Encode.DATA);
                if (stringExtra != null && !stringExtra.isEmpty()) {
                    this.contents = stringExtra;
                    this.displayContents = stringExtra;
                    this.title = this.activity.getString(R.string.contents_text);
                    return;
                }
                return;
            case 5:
                String trim3 = ContactEncoder.trim(intent.getStringExtra(Intents.Encode.DATA));
                if (trim3 != null) {
                    this.contents = "mailto:" + trim3;
                    this.displayContents = trim3;
                    this.title = this.activity.getString(R.string.contents_email);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static List<String> getAllBundleValues(Bundle bundle, String[] strArr) {
        String str;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            Object obj = bundle.get(str2);
            if (obj == null) {
                str = null;
            } else {
                str = obj.toString();
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    private static String guessAppropriateEncoding(CharSequence charSequence) {
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (charSequence.charAt(i11) > 255) {
                return "UTF-8";
            }
        }
        return null;
    }

    private static List<String> toList(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        return Arrays.asList(strArr);
    }

    public Bitmap encodeAsBitmap() throws WriterException {
        EnumMap enumMap;
        String str = this.contents;
        if (str == null) {
            return null;
        }
        String guessAppropriateEncoding = guessAppropriateEncoding(str);
        if (guessAppropriateEncoding != null) {
            EnumMap enumMap2 = new EnumMap(EncodeHintType.class);
            enumMap2.put(EncodeHintType.CHARACTER_SET, guessAppropriateEncoding);
            enumMap = enumMap2;
        } else {
            enumMap = null;
        }
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BarcodeFormat barcodeFormat = this.format;
            int i11 = this.dimension;
            BitMatrix encode = multiFormatWriter.encode(str, barcodeFormat, i11, i11, enumMap);
            int width = encode.getWidth();
            int height = encode.getHeight();
            int[] iArr = new int[(width * height)];
            for (int i12 = 0; i12 < height; i12++) {
                int i13 = i12 * width;
                for (int i14 = 0; i14 < width; i14++) {
                    iArr[i13 + i14] = encode.get(i14, i12) ? -16777216 : -1;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return createBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String getContents() {
        return this.contents;
    }

    public String getDisplayContents() {
        return this.displayContents;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isUseVCard() {
        return this.useVCard;
    }

    private void encodeQRCodeContents(AddressBookParsedResult addressBookParsedResult) {
        String[] encode = (this.useVCard ? new VCardContactEncoder() : new MECARDContactEncoder()).encode(toList(addressBookParsedResult.getNames()), addressBookParsedResult.getOrg(), toList(addressBookParsedResult.getAddresses()), toList(addressBookParsedResult.getPhoneNumbers()), (List<String>) null, toList(addressBookParsedResult.getEmails()), toList(addressBookParsedResult.getURLs()), (String) null);
        if (!encode[1].isEmpty()) {
            this.contents = encode[0];
            this.displayContents = encode[1];
            this.title = this.activity.getString(R.string.contents_contact);
        }
    }
}
