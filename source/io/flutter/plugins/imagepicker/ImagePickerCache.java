package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import io.flutter.plugin.common.MethodCall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ImagePickerCache {
    private static final String FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY = "flutter_image_picker_image_path";
    private static final String MAP_KEY_ERROR_CODE = "errorCode";
    private static final String MAP_KEY_ERROR_MESSAGE = "errorMessage";
    public static final String MAP_KEY_IMAGE_QUALITY = "imageQuality";
    public static final String MAP_KEY_MAX_HEIGHT = "maxHeight";
    public static final String MAP_KEY_MAX_WIDTH = "maxWidth";
    public static final String MAP_KEY_PATH = "path";
    public static final String MAP_KEY_PATH_LIST = "pathList";
    private static final String MAP_KEY_TYPE = "type";
    public static final String SHARED_PREFERENCES_NAME = "flutter_image_picker_shared_preference";
    private static final String SHARED_PREFERENCE_ERROR_CODE_KEY = "flutter_image_picker_error_code";
    private static final String SHARED_PREFERENCE_ERROR_MESSAGE_KEY = "flutter_image_picker_error_message";
    private static final String SHARED_PREFERENCE_IMAGE_QUALITY_KEY = "flutter_image_picker_image_quality";
    private static final String SHARED_PREFERENCE_MAX_HEIGHT_KEY = "flutter_image_picker_max_height";
    private static final String SHARED_PREFERENCE_MAX_WIDTH_KEY = "flutter_image_picker_max_width";
    private static final String SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY = "flutter_image_picker_pending_image_uri";
    private static final String SHARED_PREFERENCE_TYPE_KEY = "flutter_image_picker_type";
    private SharedPreferences prefs;

    public ImagePickerCache(Context context) {
        this.prefs = context.getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    private void setMaxDimension(Double d11, Double d12, int i11) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (d11 != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, Double.doubleToRawLongBits(d11.doubleValue()));
        }
        if (d12 != null) {
            edit.putLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, Double.doubleToRawLongBits(d12.doubleValue()));
        }
        if (i11 <= -1 || i11 >= 101) {
            edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100);
        } else {
            edit.putInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, i11);
        }
        edit.apply();
    }

    private void setType(String str) {
        this.prefs.edit().putString(SHARED_PREFERENCE_TYPE_KEY, str).apply();
    }

    public void clear() {
        this.prefs.edit().clear().apply();
    }

    public Map<String, Object> getCacheMap() {
        boolean z11;
        Set<String> stringSet;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        boolean z12 = true;
        if (!this.prefs.contains(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY) || (stringSet = this.prefs.getStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, (Set) null)) == null) {
            z11 = false;
        } else {
            arrayList.addAll(stringSet);
            hashMap.put(MAP_KEY_PATH_LIST, arrayList);
            z11 = true;
        }
        if (this.prefs.contains(SHARED_PREFERENCE_ERROR_CODE_KEY)) {
            hashMap.put("errorCode", this.prefs.getString(SHARED_PREFERENCE_ERROR_CODE_KEY, ""));
            if (this.prefs.contains(SHARED_PREFERENCE_ERROR_MESSAGE_KEY)) {
                hashMap.put("errorMessage", this.prefs.getString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, ""));
            }
        } else {
            z12 = z11;
        }
        if (z12) {
            if (this.prefs.contains(SHARED_PREFERENCE_TYPE_KEY)) {
                hashMap.put("type", this.prefs.getString(SHARED_PREFERENCE_TYPE_KEY, ""));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_WIDTH_KEY)) {
                hashMap.put(MAP_KEY_MAX_WIDTH, Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_WIDTH_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_MAX_HEIGHT_KEY)) {
                hashMap.put(MAP_KEY_MAX_HEIGHT, Double.valueOf(Double.longBitsToDouble(this.prefs.getLong(SHARED_PREFERENCE_MAX_HEIGHT_KEY, 0))));
            }
            if (this.prefs.contains(SHARED_PREFERENCE_IMAGE_QUALITY_KEY)) {
                hashMap.put(MAP_KEY_IMAGE_QUALITY, Integer.valueOf(this.prefs.getInt(SHARED_PREFERENCE_IMAGE_QUALITY_KEY, 100)));
            } else {
                hashMap.put(MAP_KEY_IMAGE_QUALITY, 100);
            }
        }
        return hashMap;
    }

    public String retrievePendingCameraMediaUriPath() {
        return this.prefs.getString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, "");
    }

    public void saveDimensionWithMethodCall(MethodCall methodCall) {
        int i11;
        Double d11 = (Double) methodCall.argument(MAP_KEY_MAX_WIDTH);
        Double d12 = (Double) methodCall.argument(MAP_KEY_MAX_HEIGHT);
        if (methodCall.argument(MAP_KEY_IMAGE_QUALITY) == null) {
            i11 = 100;
        } else {
            i11 = ((Integer) methodCall.argument(MAP_KEY_IMAGE_QUALITY)).intValue();
        }
        setMaxDimension(d11, d12, i11);
    }

    public void savePendingCameraMediaUriPath(Uri uri) {
        this.prefs.edit().putString(SHARED_PREFERENCE_PENDING_IMAGE_URI_PATH_KEY, uri.getPath()).apply();
    }

    public void saveResult(ArrayList<String> arrayList, String str, String str2) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        SharedPreferences.Editor edit = this.prefs.edit();
        if (arrayList != null) {
            edit.putStringSet(FLUTTER_IMAGE_PICKER_IMAGE_PATH_KEY, hashSet);
        }
        if (str != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_CODE_KEY, str);
        }
        if (str2 != null) {
            edit.putString(SHARED_PREFERENCE_ERROR_MESSAGE_KEY, str2);
        }
        edit.apply();
    }

    public void saveTypeWithMethodCallName(String str) {
        if (str.equals(ImagePickerPlugin.METHOD_CALL_IMAGE) || str.equals(ImagePickerPlugin.METHOD_CALL_MULTI_IMAGE)) {
            setType("image");
        } else if (str.equals(ImagePickerPlugin.METHOD_CALL_VIDEO)) {
            setType("video");
        }
    }
}
