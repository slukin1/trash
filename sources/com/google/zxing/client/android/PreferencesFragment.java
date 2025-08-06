package com.google.zxing.client.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import pro.huobi.R;

public final class PreferencesFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    private CheckBoxPreference[] checkBoxPrefs;

    public class CustomSearchURLValidator implements Preference.OnPreferenceChangeListener {
        private CustomSearchURLValidator() {
        }

        private boolean isValid(Object obj) {
            if (obj == null) {
                return true;
            }
            String obj2 = obj.toString();
            if (obj2.isEmpty()) {
                return true;
            }
            try {
                if (new URI(obj2.replaceAll("%[st]", "").replaceAll("%f(?![0-9a-f])", "")).getScheme() != null) {
                    return true;
                }
                return false;
            } catch (URISyntaxException unused) {
                return false;
            }
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (isValid(obj)) {
                return true;
            }
            Activity activity = PreferencesFragment.this.getActivity();
            if (activity instanceof FragmentActivity) {
                FragmentActivity fragmentActivity = (FragmentActivity) activity;
                new DialogUtils.b.d(fragmentActivity).C0(PreferencesFragment.this.getString(R.string.msg_error)).R0(PreferencesFragment.this.getString(R.string.msg_invalid_value)).T0(true).q0(false).P0(PreferencesFragment.this.getString(R.string.button_ok)).Q0(d.f67175a).n0(true).j0().show(fragmentActivity.getSupportFragmentManager(), "");
            }
            return false;
        }
    }

    private void disableLastCheckedPref() {
        ArrayList arrayList = new ArrayList(this.checkBoxPrefs.length);
        for (CheckBoxPreference checkBoxPreference : this.checkBoxPrefs) {
            if (checkBoxPreference.isChecked()) {
                arrayList.add(checkBoxPreference);
            }
        }
        boolean z11 = arrayList.size() <= 1;
        for (CheckBoxPreference checkBoxPreference2 : this.checkBoxPrefs) {
            checkBoxPreference2.setEnabled(!z11 || !arrayList.contains(checkBoxPreference2));
        }
    }

    private static CheckBoxPreference[] findDecodePrefs(PreferenceScreen preferenceScreen, String... strArr) {
        CheckBoxPreference[] checkBoxPreferenceArr = new CheckBoxPreference[strArr.length];
        for (int i11 = 0; i11 < strArr.length; i11++) {
            checkBoxPreferenceArr[i11] = (CheckBoxPreference) preferenceScreen.findPreference(strArr[i11]);
        }
        return checkBoxPreferenceArr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        this.checkBoxPrefs = findDecodePrefs(preferenceScreen, PreferencesActivity.KEY_DECODE_1D_PRODUCT, PreferencesActivity.KEY_DECODE_1D_INDUSTRIAL, PreferencesActivity.KEY_DECODE_QR, PreferencesActivity.KEY_DECODE_DATA_MATRIX, PreferencesActivity.KEY_DECODE_AZTEC, PreferencesActivity.KEY_DECODE_PDF417);
        disableLastCheckedPref();
        ((EditTextPreference) preferenceScreen.findPreference(PreferencesActivity.KEY_CUSTOM_PRODUCT_SEARCH)).setOnPreferenceChangeListener(new CustomSearchURLValidator());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        disableLastCheckedPref();
    }
}
