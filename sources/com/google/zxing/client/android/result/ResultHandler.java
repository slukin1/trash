package com.google.zxing.client.android.result;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.adjust.sdk.Constants;
import com.google.zxing.Result;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.LocaleManager;
import com.google.zxing.client.android.PreferencesActivity;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ParsedResultType;
import com.google.zxing.client.result.ResultParser;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.tencent.rtmp.TXVodConstants;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Locale;
import pro.huobi.R;

public abstract class ResultHandler {
    private static final String[] ADDRESS_TYPE_STRINGS = {"home", "work"};
    private static final int[] ADDRESS_TYPE_VALUES = {1, 2};
    private static final String[] EMAIL_TYPE_STRINGS = {"home", "work", "mobile"};
    private static final int[] EMAIL_TYPE_VALUES = {1, 2, 4};
    public static final int MAX_BUTTON_COUNT = 4;
    private static final int NO_TYPE = -1;
    private static final String[] PHONE_TYPE_STRINGS = {"home", "work", "mobile", "fax", "pager", FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT};
    private static final int[] PHONE_TYPE_VALUES = {1, 3, 2, 4, 6, 12};
    private static final String TAG = "ResultHandler";
    private final FragmentActivity activity;
    private final String customProductSearch;
    private final Result rawResult;
    private final ParsedResult result;

    public ResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        this(fragmentActivity, parsedResult, (Result) null);
    }

    private static int doToContractType(String str, String[] strArr, int[] iArr) {
        if (str == null) {
            return -1;
        }
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String str2 = strArr[i11];
            if (str.startsWith(str2) || str.startsWith(str2.toUpperCase(Locale.ENGLISH))) {
                return iArr[i11];
            }
        }
        return -1;
    }

    public static String formatPhone(String str) {
        return PhoneNumberUtils.formatNumber(str);
    }

    private String parseCustomSearchURL() {
        String string = PreferenceManager.getDefaultSharedPreferences(this.activity).getString(PreferencesActivity.KEY_CUSTOM_PRODUCT_SEARCH, (String) null);
        if (string == null || !string.trim().isEmpty()) {
            return string;
        }
        return null;
    }

    private static void putExtra(Intent intent, String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra(str, str2);
        }
    }

    private void sendMMSFromUri(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
        if (str2 == null || str2.isEmpty()) {
            putExtra(intent, "subject", this.activity.getString(R.string.msg_default_mms_subject));
        } else {
            putExtra(intent, "subject", str2);
        }
        putExtra(intent, "sms_body", str3);
        intent.putExtra("compose_mode", true);
        launchIntent(intent);
    }

    private void sendSMSFromUri(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str));
        putExtra(intent, "sms_body", str2);
        intent.putExtra("compose_mode", true);
        launchIntent(intent);
    }

    private static int toAddressContractType(String str) {
        return doToContractType(str, ADDRESS_TYPE_STRINGS, ADDRESS_TYPE_VALUES);
    }

    private static int toEmailContractType(String str) {
        return doToContractType(str, EMAIL_TYPE_STRINGS, EMAIL_TYPE_VALUES);
    }

    private static int toPhoneContractType(String str) {
        return doToContractType(str, PHONE_TYPE_STRINGS, PHONE_TYPE_VALUES);
    }

    public final void addContact(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String str4, String str5, String str6, String str7, String[] strArr7, String str8, String[] strArr8) {
        int addressContractType;
        int emailContractType;
        int phoneContractType;
        String[] strArr9 = strArr2;
        String[] strArr10 = strArr3;
        String[] strArr11 = strArr4;
        String[] strArr12 = strArr5;
        String[] strArr13 = strArr6;
        String str9 = str2;
        String[] strArr14 = strArr7;
        String str10 = str8;
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/contact");
        putExtra(intent, "name", strArr != null ? strArr[0] : null);
        putExtra(intent, "phonetic_name", str);
        int min = Math.min(strArr10 != null ? strArr10.length : 0, Contents.PHONE_KEYS.length);
        for (int i11 = 0; i11 < min; i11++) {
            putExtra(intent, Contents.PHONE_KEYS[i11], strArr10[i11]);
            if (strArr11 != null && i11 < strArr11.length && (phoneContractType = toPhoneContractType(strArr11[i11])) >= 0) {
                intent.putExtra(Contents.PHONE_TYPE_KEYS[i11], phoneContractType);
            }
        }
        int min2 = Math.min(strArr12 != null ? strArr12.length : 0, Contents.EMAIL_KEYS.length);
        for (int i12 = 0; i12 < min2; i12++) {
            putExtra(intent, Contents.EMAIL_KEYS[i12], strArr12[i12]);
            if (strArr13 != null && i12 < strArr13.length && (emailContractType = toEmailContractType(strArr13[i12])) >= 0) {
                intent.putExtra(Contents.EMAIL_TYPE_KEYS[i12], emailContractType);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (strArr14 != null) {
            int length = strArr14.length;
            int i13 = 0;
            while (true) {
                if (i13 < length) {
                    String str11 = strArr14[i13];
                    if (str11 != null && !str11.isEmpty()) {
                        ContentValues contentValues = new ContentValues(2);
                        contentValues.put(TXVodConstants.VOD_KEY_MIMETYPE, "vnd.android.cursor.item/website");
                        contentValues.put("data1", str11);
                        arrayList.add(contentValues);
                        break;
                    }
                    i13++;
                } else {
                    break;
                }
            }
        }
        if (str10 != null) {
            ContentValues contentValues2 = new ContentValues(3);
            contentValues2.put(TXVodConstants.VOD_KEY_MIMETYPE, "vnd.android.cursor.item/contact_event");
            contentValues2.put("data2", 3);
            contentValues2.put("data1", str10);
            arrayList.add(contentValues2);
        }
        if (strArr9 != null) {
            int length2 = strArr9.length;
            int i14 = 0;
            while (true) {
                if (i14 < length2) {
                    String str12 = strArr9[i14];
                    if (str12 != null && !str12.isEmpty()) {
                        ContentValues contentValues3 = new ContentValues(3);
                        contentValues3.put(TXVodConstants.VOD_KEY_MIMETYPE, "vnd.android.cursor.item/nickname");
                        contentValues3.put("data2", 1);
                        contentValues3.put("data1", str12);
                        arrayList.add(contentValues3);
                        break;
                    }
                    i14++;
                } else {
                    break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            intent.putParcelableArrayListExtra("data", arrayList);
        }
        StringBuilder sb2 = new StringBuilder();
        if (str9 != null) {
            sb2.append(10);
            sb2.append(str9);
        }
        if (strArr8 != null) {
            sb2.append(10);
            sb2.append(strArr8[0]);
            sb2.append(',');
            sb2.append(strArr8[1]);
        }
        if (sb2.length() > 0) {
            putExtra(intent, "notes", sb2.substring(1));
        }
        putExtra(intent, "im_handle", str3);
        putExtra(intent, "postal", str4);
        if (str5 != null && (addressContractType = toAddressContractType(str5)) >= 0) {
            intent.putExtra("postal_type", addressContractType);
        }
        putExtra(intent, "company", str6);
        putExtra(intent, "job_title", str7);
        launchIntent(intent);
    }

    public final void addEmailOnlyContact(String[] strArr, String[] strArr2) {
        addContact((String[]) null, (String[]) null, (String) null, (String[]) null, (String[]) null, strArr, strArr2, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String[]) null, (String) null, (String[]) null);
    }

    public final void addPhoneOnlyContact(String[] strArr, String[] strArr2) {
        addContact((String[]) null, (String[]) null, (String) null, strArr, strArr2, (String[]) null, (String[]) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String[]) null, (String) null, (String[]) null);
    }

    public boolean areContentsSecure() {
        return false;
    }

    public final void dialPhone(String str) {
        launchIntent(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    public final void dialPhoneFromUri(String str) {
        launchIntent(new Intent("android.intent.action.DIAL", Uri.parse(str)));
    }

    public final String fillInCustomSearchURL(String str) {
        if (this.customProductSearch == null) {
            return str;
        }
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        String str2 = this.customProductSearch;
        Result result2 = this.rawResult;
        if (result2 != null) {
            str2 = str2.replaceFirst("%f(?![0-9a-f])", result2.getBarcodeFormat().toString());
            if (str2.contains("%t")) {
                str2 = str2.replace("%t", ResultParser.parseResult(this.rawResult).getType().toString());
            }
        }
        return str2.replace("%s", str);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public abstract int getButtonCount();

    public abstract int getButtonText(int i11);

    public Integer getDefaultButtonID() {
        return null;
    }

    public final void getDirections(double d11, double d12) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("http://maps.google." + LocaleManager.getCountryTLD(this.activity) + "/maps?f=d&daddr=" + d11 + ',' + d12)));
    }

    public CharSequence getDisplayContents() {
        return this.result.getDisplayResult().replace("\r", "");
    }

    public abstract int getDisplayTitle();

    public final ParsedResult getResult() {
        return this.result;
    }

    public final ParsedResultType getType() {
        return this.result.getType();
    }

    public abstract void handleButtonPress(int i11);

    public final boolean hasCustomProductSearch() {
        return this.customProductSearch != null;
    }

    public final void launchIntent(Intent intent) {
        try {
            rawLaunchIntent(intent);
        } catch (ActivityNotFoundException unused) {
            if (this.activity != null) {
                new DialogUtils.b.d(this.activity).C0(this.activity.getString(R.string.app_name)).R0(this.activity.getString(R.string.msg_intent_failed)).T0(true).P0(this.activity.getString(R.string.button_ok)).q0(false).Q0(a.f67176a).n0(true).j0().show(this.activity.getSupportFragmentManager(), "");
            }
        }
    }

    public final void openBookSearch(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("http://books.google." + LocaleManager.getBookSearchCountryTLD(this.activity) + "/books?vid=isbn" + str)));
    }

    public final void openMap(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public final void openProductSearch(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google." + LocaleManager.getProductSearchCountryTLD(this.activity) + "/m/products?q=" + str + "&source=zxing")));
    }

    public final void openURL(String str) {
        if (str.startsWith("HTTP://")) {
            str = "http" + str.substring(4);
        } else if (str.startsWith("HTTPS://")) {
            str = Constants.SCHEME + str.substring(5);
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        try {
            launchIntent(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w(TAG, "Nothing available to handle " + intent);
        }
    }

    public final void rawLaunchIntent(Intent intent) {
        if (intent != null) {
            intent.addFlags(524288);
            String str = TAG;
            Log.d(str, "Launching intent: " + intent + " with extras: " + intent.getExtras());
            this.activity.startActivity(intent);
        }
    }

    public final void searchMap(String str) {
        launchIntent(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + Uri.encode(str))));
    }

    public final void sendEmail(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        Intent intent = new Intent("android.intent.action.SEND", Uri.parse("mailto:"));
        if (!(strArr == null || strArr.length == 0)) {
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        if (!(strArr2 == null || strArr2.length == 0)) {
            intent.putExtra("android.intent.extra.CC", strArr2);
        }
        if (!(strArr3 == null || strArr3.length == 0)) {
            intent.putExtra("android.intent.extra.BCC", strArr3);
        }
        putExtra(intent, "android.intent.extra.SUBJECT", str);
        putExtra(intent, "android.intent.extra.TEXT", str2);
        intent.setType("text/plain");
        launchIntent(intent);
    }

    public final void sendMMS(String str, String str2, String str3) {
        sendMMSFromUri("mmsto:" + str, str2, str3);
    }

    public final void sendSMS(String str, String str2) {
        sendSMSFromUri("smsto:" + str, str2);
    }

    public final void shareByEmail(String str) {
        sendEmail((String[]) null, (String[]) null, (String[]) null, (String) null, str);
    }

    public final void shareBySMS(String str) {
        sendSMSFromUri("smsto:", str);
    }

    public final void webSearch(String str) {
        Intent intent = new Intent("android.intent.action.WEB_SEARCH");
        intent.putExtra("query", str);
        launchIntent(intent);
    }

    public ResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult, Result result2) {
        this.result = parsedResult;
        this.activity = fragmentActivity;
        this.rawResult = result2;
        this.customProductSearch = parseCustomSearchURL();
    }
}
