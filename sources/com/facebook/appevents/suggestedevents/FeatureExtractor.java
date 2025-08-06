package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class FeatureExtractor {
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo = null;
    private static boolean initialized = false;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    public static float[] getDenseFeatures(JSONObject jSONObject, String str) {
        if (!initialized) {
            return null;
        }
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        try {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject("view").toString());
            String optString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
            JSONArray jSONArray = new JSONArray();
            pruneTree(jSONObject2, jSONArray);
            sum(fArr, parseFeatures(jSONObject2));
            JSONObject interactedNode = getInteractedNode(jSONObject2);
            if (interactedNode == null) {
                return null;
            }
            sum(fArr, nonparseFeatures(interactedNode, jSONArray, optString, jSONObject2.toString(), lowerCase));
            return fArr;
        } catch (JSONException unused) {
        }
    }

    private static JSONObject getInteractedNode(JSONObject jSONObject) {
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray == null) {
                return null;
            }
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                JSONObject interactedNode = getInteractedNode(optJSONArray.getJSONObject(i11));
                if (interactedNode != null) {
                    return interactedNode;
                }
            }
            return null;
        } catch (JSONException unused) {
        }
    }

    public static String getTextFeature(String str, String str2, String str3) {
        return (str3 + " | " + str2 + ", " + str).toLowerCase();
    }

    public static void initialize(File file) {
        try {
            rules = new JSONObject();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            rules = new JSONObject(new String(bArr, "UTF-8"));
            HashMap hashMap = new HashMap();
            languageInfo = hashMap;
            hashMap.put(ViewHierarchyConstants.ENGLISH, "1");
            languageInfo.put(ViewHierarchyConstants.GERMAN, "2");
            languageInfo.put(ViewHierarchyConstants.SPANISH, "3");
            languageInfo.put(ViewHierarchyConstants.JAPANESE, "4");
            HashMap hashMap2 = new HashMap();
            eventInfo = hashMap2;
            hashMap2.put(ViewHierarchyConstants.VIEW_CONTENT, "0");
            eventInfo.put(ViewHierarchyConstants.SEARCH, "1");
            eventInfo.put(ViewHierarchyConstants.ADD_TO_CART, "2");
            eventInfo.put(ViewHierarchyConstants.ADD_TO_WISHLIST, "3");
            eventInfo.put(ViewHierarchyConstants.INITIATE_CHECKOUT, "4");
            eventInfo.put(ViewHierarchyConstants.ADD_PAYMENT_INFO, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
            eventInfo.put(ViewHierarchyConstants.PURCHASE, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
            eventInfo.put(ViewHierarchyConstants.LEAD, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP);
            eventInfo.put(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8");
            HashMap hashMap3 = new HashMap();
            textTypeInfo = hashMap3;
            hashMap3.put(ViewHierarchyConstants.BUTTON_TEXT, "1");
            textTypeInfo.put(ViewHierarchyConstants.PAGE_TITLE, "2");
            textTypeInfo.put(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, "3");
            textTypeInfo.put(ViewHierarchyConstants.BUTTON_ID, "4");
            initialized = true;
        } catch (Exception unused) {
        }
    }

    private static boolean isButton(JSONObject jSONObject) {
        return (jSONObject.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 32) > 0;
    }

    public static boolean isInitialized() {
        return initialized;
    }

    private static boolean matchIndicators(String[] strArr, String[] strArr2) {
        for (String str : strArr) {
            for (String contains : strArr2) {
                if (contains.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        float[] fArr = new float[30];
        float f11 = 0.0f;
        Arrays.fill(fArr, 0.0f);
        int length = jSONArray.length();
        int i11 = 0;
        fArr[3] = (float) (length > 1 ? length - 1 : 0);
        while (i11 < jSONArray.length()) {
            try {
                if (isButton(jSONArray.getJSONObject(i11))) {
                    fArr[9] = fArr[9] + 1.0f;
                }
                i11++;
            } catch (JSONException unused) {
            }
        }
        fArr[13] = -1.0f;
        fArr[14] = -1.0f;
        String str4 = str + '|' + str3;
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        updateHintAndTextRecursively(jSONObject, sb2, sb3);
        String sb4 = sb2.toString();
        String sb5 = sb3.toString();
        fArr[15] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, sb5) ? 1.0f : 0.0f;
        fArr[16] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : 0.0f;
        fArr[17] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, sb4) ? 1.0f : 0.0f;
        fArr[18] = str2.contains("password") ? 1.0f : 0.0f;
        fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str2) ? 1.0f : 0.0f;
        fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str2) ? 1.0f : 0.0f;
        fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str2) ? 1.0f : 0.0f;
        fArr[22] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, sb5) ? 1.0f : 0.0f;
        fArr[24] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str4) ? 1.0f : 0.0f;
        fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb5) ? 1.0f : 0.0f;
        fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str4) ? 1.0f : 0.0f;
        fArr[28] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, sb5) ? 1.0f : 0.0f;
        if (regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str4)) {
            f11 = 1.0f;
        }
        fArr[29] = f11;
        return fArr;
    }

    private static float[] parseFeatures(JSONObject jSONObject) {
        float[] fArr = new float[30];
        Arrays.fill(fArr, 0.0f);
        String lowerCase = jSONObject.optString("text").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint").toLowerCase();
        String lowerCase3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY).toLowerCase();
        int optInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
        String[] strArr = {lowerCase, lowerCase2};
        if (matchIndicators(new String[]{"$", "amount", FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
            fArr[0] = (float) (((double) fArr[0]) + 1.0d);
        }
        if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
            fArr[1] = (float) (((double) fArr[1]) + 1.0d);
        }
        if (matchIndicators(new String[]{"tel", PlaceFields.PHONE}, strArr)) {
            fArr[2] = (float) (((double) fArr[2]) + 1.0d);
        }
        if (matchIndicators(new String[]{FirebaseAnalytics.Event.SEARCH}, strArr)) {
            fArr[4] = (float) (((double) fArr[4]) + 1.0d);
        }
        if (optInt >= 0) {
            fArr[5] = (float) (((double) fArr[5]) + 1.0d);
        }
        if (optInt == 3 || optInt == 2) {
            fArr[6] = (float) (((double) fArr[6]) + 1.0d);
        }
        if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
            fArr[7] = (float) (((double) fArr[7]) + 1.0d);
        }
        if (lowerCase3.contains("checkbox")) {
            fArr[8] = (float) (((double) fArr[8]) + 1.0d);
        }
        if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
            fArr[10] = (float) (((double) fArr[10]) + 1.0d);
        }
        if (lowerCase3.contains(MTCommonConstants.Network.KEY_RADIO) && lowerCase3.contains("button")) {
            fArr[12] = (float) (((double) fArr[12]) + 1.0d);
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = optJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                sum(fArr, parseFeatures(optJSONArray.getJSONObject(i11)));
            }
        } catch (JSONException unused) {
        }
        return fArr;
    }

    private static boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z11;
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int i11 = 0;
            while (true) {
                if (i11 >= optJSONArray.length()) {
                    z11 = false;
                    break;
                } else if (optJSONArray.getJSONObject(i11).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            boolean z12 = z11;
            JSONArray jSONArray2 = new JSONArray();
            if (z11) {
                for (int i12 = 0; i12 < optJSONArray.length(); i12++) {
                    jSONArray.put(optJSONArray.getJSONObject(i12));
                }
            } else {
                for (int i13 = 0; i13 < optJSONArray.length(); i13++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i13);
                    if (pruneTree(jSONObject2, jSONArray)) {
                        jSONArray2.put(jSONObject2);
                        z12 = true;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, jSONArray2);
            }
            return z12;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static boolean regexMatched(String str, String str2, String str3, String str4) {
        return regexMatched(rules.optJSONObject("rulesForLanguage").optJSONObject(languageInfo.get(str)).optJSONObject("rulesForEvent").optJSONObject(eventInfo.get(str2)).optJSONObject("positiveRules").optString(textTypeInfo.get(str3)), str4);
    }

    private static void sum(float[] fArr, float[] fArr2) {
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = fArr[i11] + fArr2[i11];
        }
    }

    private static void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb2, StringBuilder sb3) {
        String lowerCase = jSONObject.optString("text", "").toLowerCase();
        String lowerCase2 = jSONObject.optString("hint", "").toLowerCase();
        if (!lowerCase.isEmpty()) {
            sb2.append(lowerCase);
            sb2.append(" ");
        }
        if (!lowerCase2.isEmpty()) {
            sb3.append(lowerCase2);
            sb3.append(" ");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
        if (optJSONArray != null) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                updateHintAndTextRecursively(jSONObject, sb2, sb3);
            }
        }
    }

    private static boolean regexMatched(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }
}
