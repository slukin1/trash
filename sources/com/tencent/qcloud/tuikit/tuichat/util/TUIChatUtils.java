package com.tencent.qcloud.tuikit.tuichat.util;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.timcommon.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.timcommon.util.ImageUtil;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TUIChatUtils {
    public static final String SPLIT_TEXT = "split_result";
    public static final String SPLIT_TEXT_FOR_TRANSLATION = "split_translation";
    public static final String SPLIT_TEXT_INDEX_FOR_TRANSLATION = "split_translation_index";

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, String str, int i11, String str2) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(str, i11, ErrorMessageConverter.convertIMError(i11, str2));
        }
    }

    public static void callbackOnProgress(IUIKitCallback iUIKitCallback, Object obj) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onProgress(obj);
        }
    }

    public static <T> void callbackOnSuccess(IUIKitCallback<T> iUIKitCallback, T t11) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onSuccess(t11);
        }
    }

    public static String getConversationIdByUserId(String str, boolean z11) {
        String str2 = z11 ? "group_" : "c2c_";
        return str2 + str;
    }

    public static String getGroupIDFromTopicID(String str) {
        return str.substring(0, str.indexOf("@TOPIC#_"));
    }

    public static String getOriginImagePath(TUIMessageBean tUIMessageBean) {
        V2TIMMessage v2TIMMessage;
        V2TIMImageElem imageElem;
        String str = null;
        if (tUIMessageBean == null || (v2TIMMessage = tUIMessageBean.getV2TIMMessage()) == null || (imageElem = v2TIMMessage.getImageElem()) == null) {
            return null;
        }
        String localImagePath = ChatMessageParser.getLocalImagePath(tUIMessageBean);
        if (localImagePath != null) {
            return localImagePath;
        }
        Iterator<V2TIMImageElem.V2TIMImage> it2 = imageElem.getImageList().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            V2TIMImageElem.V2TIMImage next = it2.next();
            if (next.getType() == 0) {
                str = next.getUUID();
                break;
            }
        }
        String generateImagePath = ImageUtil.generateImagePath(str, 0);
        return new File(generateImagePath).exists() ? generateImagePath : localImagePath;
    }

    public static long getServerTime() {
        return V2TIMManager.getInstance().getServerTime();
    }

    public static boolean isC2CChat(int i11) {
        return i11 == 1;
    }

    public static boolean isCommunityGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("@TGS#_");
    }

    public static boolean isGroupChat(int i11) {
        return i11 == 2;
    }

    public static boolean isTopicGroup(String str) {
        if (!isCommunityGroup(str)) {
            return false;
        }
        return str.contains("@TOPIC#_");
    }

    public static List<String> splitByKeyList(List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        if (list == null || list.isEmpty()) {
            arrayList.add(str);
            return arrayList;
        }
        int i11 = 0;
        for (String next : list) {
            int indexOf = str.indexOf(next, i11);
            if (indexOf >= 0) {
                if (i11 < indexOf) {
                    arrayList.add(str.substring(i11, indexOf));
                }
                arrayList.add(next);
                i11 = indexOf + next.length();
            }
        }
        if (i11 < str.length()) {
            arrayList.add(str.substring(i11));
        }
        return arrayList;
    }

    public static HashMap<String, List<String>> splitTextByEmojiAndAtUsers(String str, List<String> list) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, List<String>> hashMap = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (list != null && list.size() > 0) {
            for (String str4 : list) {
                arrayList2.add(TIMMentionEditText.TIM_MENTION_TAG + str4);
            }
        }
        List<String> splitByKeyList = splitByKeyList(arrayList2, str);
        ArrayList arrayList3 = new ArrayList();
        int i11 = 0;
        for (int i12 = 0; i12 < splitByKeyList.size(); i12++) {
            String str5 = splitByKeyList.get(i12);
            if (arrayList2.size() > 0) {
                str2 = (String) arrayList2.get(0);
            } else {
                str2 = "";
            }
            if (TextUtils.isEmpty(str2) || !str5.equals(str2)) {
                List<String> findEmojiKeyListFromText = FaceManager.findEmojiKeyListFromText(str5);
                if (findEmojiKeyListFromText == null || findEmojiKeyListFromText.size() <= 0) {
                    if (!TextUtils.isEmpty(str5.trim())) {
                        arrayList3.add(String.valueOf(i11));
                    }
                    arrayList.add(str5);
                } else {
                    List<String> splitByKeyList2 = splitByKeyList(findEmojiKeyListFromText, str5);
                    for (int i13 = 0; i13 < splitByKeyList2.size(); i13++) {
                        String str6 = splitByKeyList2.get(i13);
                        arrayList.add(str6);
                        if (findEmojiKeyListFromText.size() > 0) {
                            str3 = findEmojiKeyListFromText.get(0);
                        } else {
                            str3 = "";
                        }
                        if (TextUtils.isEmpty(str3) || !str6.equals(str3)) {
                            arrayList3.add(String.valueOf(i11));
                        } else {
                            findEmojiKeyListFromText.remove(0);
                        }
                        i11++;
                    }
                }
            } else {
                arrayList.add(str5);
                arrayList2.remove(0);
            }
            i11++;
        }
        ArrayList arrayList4 = new ArrayList();
        for (int i14 = 0; i14 < arrayList3.size(); i14++) {
            arrayList4.add((String) arrayList.get(Integer.valueOf((String) arrayList3.get(i14)).intValue()));
        }
        hashMap.put(SPLIT_TEXT, arrayList);
        hashMap.put(SPLIT_TEXT_FOR_TRANSLATION, arrayList4);
        hashMap.put(SPLIT_TEXT_INDEX_FOR_TRANSLATION, arrayList3);
        return hashMap;
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i11, String str, T t11) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError(i11, ErrorMessageConverter.convertIMError(i11, str), t11);
        }
    }

    public static <T> void callbackOnError(IUIKitCallback<T> iUIKitCallback, int i11, String str) {
        if (iUIKitCallback != null) {
            iUIKitCallback.onError((String) null, i11, ErrorMessageConverter.convertIMError(i11, str));
        }
    }
}
