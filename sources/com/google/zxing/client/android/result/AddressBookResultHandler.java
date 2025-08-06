package com.google.zxing.client.android.result;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import pro.huobi.R;

public final class AddressBookResultHandler extends ResultHandler {
    private static final int[] BUTTON_TEXTS = {R.string.button_add_contact, R.string.button_show_map, R.string.button_dial, R.string.button_email};
    private static final DateFormat[] DATE_FORMATS;
    private int buttonCount;
    private final boolean[] fields;

    static {
        Locale locale = Locale.ENGLISH;
        DateFormat[] dateFormatArr = {new SimpleDateFormat("yyyyMMdd", locale), new SimpleDateFormat("yyyyMMdd'T'HHmmss", locale), new SimpleDateFormat("yyyy-MM-dd", locale), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", locale)};
        DATE_FORMATS = dateFormatArr;
        for (DateFormat lenient : dateFormatArr) {
            lenient.setLenient(false);
        }
    }

    public AddressBookResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) parsedResult;
        String[] addresses = addressBookParsedResult.getAddresses();
        String[] phoneNumbers = addressBookParsedResult.getPhoneNumbers();
        String[] emails = addressBookParsedResult.getEmails();
        boolean[] zArr = new boolean[4];
        this.fields = zArr;
        zArr[0] = true;
        zArr[1] = addresses != null && addresses.length > 0 && addresses[0] != null && !addresses[0].isEmpty();
        zArr[2] = phoneNumbers != null && phoneNumbers.length > 0;
        zArr[3] = emails != null && emails.length > 0;
        this.buttonCount = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            if (this.fields[i11]) {
                this.buttonCount++;
            }
        }
    }

    private int mapIndexToAction(int i11) {
        if (i11 < this.buttonCount) {
            int i12 = -1;
            for (int i13 = 0; i13 < 4; i13++) {
                if (this.fields[i13]) {
                    i12++;
                }
                if (i12 == i11) {
                    return i13;
                }
            }
        }
        return -1;
    }

    private static long parseDate(String str) {
        DateFormat[] dateFormatArr = DATE_FORMATS;
        int i11 = 0;
        while (i11 < dateFormatArr.length) {
            try {
                return dateFormatArr[i11].parse(str).getTime();
            } catch (ParseException unused) {
                i11++;
            }
        }
        return -1;
    }

    public int getButtonCount() {
        return this.buttonCount;
    }

    public int getButtonText(int i11) {
        return BUTTON_TEXTS[mapIndexToAction(i11)];
    }

    public CharSequence getDisplayContents() {
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) getResult();
        StringBuilder sb2 = new StringBuilder(100);
        ParsedResult.maybeAppend(addressBookParsedResult.getNames(), sb2);
        int length = sb2.length();
        String pronunciation = addressBookParsedResult.getPronunciation();
        if (pronunciation != null && !pronunciation.isEmpty()) {
            sb2.append("\n(");
            sb2.append(pronunciation);
            sb2.append(')');
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getTitle(), sb2);
        ParsedResult.maybeAppend(addressBookParsedResult.getOrg(), sb2);
        ParsedResult.maybeAppend(addressBookParsedResult.getAddresses(), sb2);
        String[] phoneNumbers = addressBookParsedResult.getPhoneNumbers();
        if (phoneNumbers != null) {
            for (String str : phoneNumbers) {
                if (str != null) {
                    ParsedResult.maybeAppend(ResultHandler.formatPhone(str), sb2);
                }
            }
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getEmails(), sb2);
        ParsedResult.maybeAppend(addressBookParsedResult.getURLs(), sb2);
        String birthday = addressBookParsedResult.getBirthday();
        if (birthday != null && !birthday.isEmpty()) {
            long parseDate = parseDate(birthday);
            if (parseDate >= 0) {
                ParsedResult.maybeAppend(DateFormat.getDateInstance(2).format(Long.valueOf(parseDate)), sb2);
            }
        }
        ParsedResult.maybeAppend(addressBookParsedResult.getNote(), sb2);
        if (length <= 0) {
            return sb2.toString();
        }
        SpannableString spannableString = new SpannableString(sb2.toString());
        spannableString.setSpan(new StyleSpan(1), 0, length, 0);
        return spannableString;
    }

    public int getDisplayTitle() {
        return R.string.result_address_book;
    }

    public void handleButtonPress(int i11) {
        AddressBookParsedResult addressBookParsedResult = (AddressBookParsedResult) getResult();
        String[] addresses = addressBookParsedResult.getAddresses();
        String str = (addresses == null || addresses.length < 1) ? null : addresses[0];
        String[] addressTypes = addressBookParsedResult.getAddressTypes();
        String str2 = (addressTypes == null || addressTypes.length < 1) ? null : addressTypes[0];
        int mapIndexToAction = mapIndexToAction(i11);
        if (mapIndexToAction == 0) {
            addContact(addressBookParsedResult.getNames(), addressBookParsedResult.getNicknames(), addressBookParsedResult.getPronunciation(), addressBookParsedResult.getPhoneNumbers(), addressBookParsedResult.getPhoneTypes(), addressBookParsedResult.getEmails(), addressBookParsedResult.getEmailTypes(), addressBookParsedResult.getNote(), addressBookParsedResult.getInstantMessenger(), str, str2, addressBookParsedResult.getOrg(), addressBookParsedResult.getTitle(), addressBookParsedResult.getURLs(), addressBookParsedResult.getBirthday(), addressBookParsedResult.getGeo());
        } else if (mapIndexToAction == 1) {
            searchMap(str);
        } else if (mapIndexToAction == 2) {
            dialPhone(addressBookParsedResult.getPhoneNumbers()[0]);
        } else if (mapIndexToAction == 3) {
            sendEmail(addressBookParsedResult.getEmails(), (String[]) null, (String[]) null, (String) null, (String) null);
        }
    }
}
