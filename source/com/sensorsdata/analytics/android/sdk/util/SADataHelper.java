package com.sensorsdata.analytics.android.sdk.util;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SADataHelper {
    private static final Pattern KEY_PATTERN = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$|^user_tag.*|^user_group.*)[a-zA-Z_$][a-zA-Z\\d_$]*)$", 2);
    private static final int MAX_LENGTH_100 = 100;
    public static final int MAX_LENGTH_1024 = 1024;
    private static final String TAG = "SA.SADataHelper";

    public static void addTimeProperty(JSONObject jSONObject) {
        if (!jSONObject.has("$time")) {
            try {
                jSONObject.put("$time", new Date(System.currentTimeMillis()));
            } catch (JSONException e11) {
                SALog.printStackTrace(e11);
            }
        }
    }

    public static JSONObject appendLibMethodAutoTrack(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("$lib_method", "autoTrack");
        } catch (JSONException e11) {
            SALog.printStackTrace(e11);
        }
        return jSONObject;
    }

    public static void assertDistinctId(String str) throws InvalidDataException {
        if (TextUtils.isEmpty(str)) {
            throw new InvalidDataException("Id is empty or null");
        } else if (str.length() > 1024) {
            SALog.i(TAG, str + "'s length is longer than " + 1024);
        }
    }

    public static void assertEventName(String str) {
        if (TextUtils.isEmpty(str)) {
            SALog.i(TAG, "EventName is empty or null");
        } else if (str.length() > 100) {
            SALog.i(TAG, str + "'s length is longer than " + 100);
        } else if (!KEY_PATTERN.matcher(str).matches()) {
            SALog.i(TAG, str + " is invalid");
        }
    }

    public static void assertItemId(String str) {
        if (str == null) {
            SALog.i(TAG, "ItemId is empty or null");
        } else if (str.length() > 1024) {
            SALog.i(TAG, str + "'s length is longer than " + 1024);
        }
    }

    public static boolean assertPropertyKey(String str) {
        if (TextUtils.isEmpty(str)) {
            SALog.i(TAG, "Property key is empty or null");
            return false;
        } else if (!KEY_PATTERN.matcher(str).matches()) {
            SALog.i(TAG, str + " is invalid");
            return false;
        } else if (str.length() <= 100) {
            return true;
        } else {
            SALog.i(TAG, str + "'s length is longer than " + 100);
            return true;
        }
    }

    public static void assertPropertyTypes(JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (!assertPropertyKey(next)) {
                        keys.remove();
                    } else {
                        Object obj = jSONObject.get(next);
                        if (obj == JSONObject.NULL) {
                            SALog.i(TAG, "Property value is empty or null");
                            keys.remove();
                        } else {
                            int i11 = 0;
                            if (obj instanceof List) {
                                List list = (List) obj;
                                int size = list.size();
                                JSONArray jSONArray = new JSONArray();
                                for (int i12 = 0; i12 < size; i12++) {
                                    jSONArray.put(list.get(i12));
                                }
                                jSONObject.put(next, jSONArray);
                                obj = jSONArray;
                            }
                            if (!(obj instanceof CharSequence)) {
                                if (!(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean)) {
                                    if (!(obj instanceof Date)) {
                                        throw new InvalidDataException("The property value must be an instance of CharSequence/Number/Boolean/JSONArray/Date/List<String>. [key='" + next + "', value='" + obj.toString() + "', class='" + obj.getClass().getCanonicalName() + "']");
                                    }
                                }
                            }
                            if (obj instanceof JSONArray) {
                                JSONArray jSONArray2 = (JSONArray) obj;
                                int length = jSONArray2.length();
                                while (i11 < length) {
                                    if (jSONArray2.get(i11) instanceof CharSequence) {
                                        i11++;
                                    } else {
                                        throw new InvalidDataException("The array property value must be an instance of List<String> or JSONArray only contains String. [key='" + next + "', value='" + obj.toString() + "']");
                                    }
                                }
                                continue;
                            } else if ((obj instanceof String) && ((String) obj).length() > 1024) {
                                SALog.i(TAG, obj + " length is longer than " + 1024);
                            }
                        }
                    }
                } catch (JSONException unused) {
                    throw new InvalidDataException("Unexpected property key. [key='" + next + "']");
                } catch (Error e11) {
                    SALog.i(TAG, (Throwable) e11);
                }
            }
        }
    }

    public static String assertPropertyValue(String str) {
        if (str == null) {
            SALog.i(TAG, "Property value is empty or null");
            return str;
        }
        if (str.length() > 1024) {
            SALog.i(TAG, str + "'s length is longer than " + 1024);
        }
        return str;
    }
}
