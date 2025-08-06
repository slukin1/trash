package com.tencent.qcloud.tuikit.timcommon.component.face;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qcloud.tuicore.util.SPUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class RecentEmojiManager {
    public static final String PREFERENCE_NAME = "recentFace";
    private static final RecentEmojiManager instance = new RecentEmojiManager();

    private RecentEmojiManager() {
    }

    public static RecentEmojiManager getInstance() {
        return instance;
    }

    public Collection getCollection(String str) throws IOException, ClassNotFoundException {
        String string = getString(str);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string.trim())) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(string.getBytes(), 0)));
        Collection collection = (Collection) objectInputStream.readObject();
        objectInputStream.close();
        return collection;
    }

    public String getString(String str) {
        return SPUtils.getInstance(PREFERENCE_NAME).getString(str);
    }

    public RecentEmojiManager putCollection(String str, Collection collection) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(collection);
        String str2 = new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        objectOutputStream.close();
        return putString(str, str2);
    }

    public RecentEmojiManager putString(String str, String str2) {
        SPUtils.getInstance(PREFERENCE_NAME).put(str, str2);
        return this;
    }
}
