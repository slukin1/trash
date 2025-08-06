package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class MetaDataStore {
    private static final String KEY_USER_ID = "userId";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final FileStore fileStore;

    public MetaDataStore(FileStore fileStore2) {
        this.fileStore = fileStore2;
    }

    private static Map<String, String> jsonToKeysData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, valueOrNull(jSONObject, next));
        }
        return hashMap;
    }

    private String jsonToUserId(String str) throws JSONException {
        return valueOrNull(new JSONObject(str), "userId");
    }

    private static String keysDataToJson(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static void safeDeleteCorruptFile(File file) {
        if (file.exists() && file.delete()) {
            Logger logger = Logger.getLogger();
            logger.i("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String userIdToJson(String str) throws JSONException {
        return new JSONObject(str) {
            public final /* synthetic */ String val$userId;

            {
                this.val$userId = r2;
                put("userId", r2);
            }
        }.toString();
    }

    private static String valueOrNull(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, (String) null);
        }
        return null;
    }

    public File getInternalKeysFileForSession(String str) {
        return this.fileStore.getSessionFile(str, UserMetadata.INTERNAL_KEYDATA_FILENAME);
    }

    public File getKeysFileForSession(String str) {
        return this.fileStore.getSessionFile(str, UserMetadata.KEYDATA_FILENAME);
    }

    public File getUserDataFileForSession(String str) {
        return this.fileStore.getSessionFile(str, UserMetadata.USERDATA_FILENAME);
    }

    public Map<String, String> readKeyData(String str) {
        return readKeyData(str, false);
    }

    public String readUserId(String str) {
        FileInputStream fileInputStream;
        File userDataFileForSession = getUserDataFileForSession(str);
        FileInputStream fileInputStream2 = null;
        if (!userDataFileForSession.exists() || userDataFileForSession.length() == 0) {
            Logger.getLogger().d("No userId set for session " + str);
            safeDeleteCorruptFile(userDataFileForSession);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(userDataFileForSession);
            try {
                String jsonToUserId = jsonToUserId(CommonUtils.streamToString(fileInputStream));
                Logger.getLogger().d("Loaded userId " + jsonToUserId + " for session " + str);
                CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                return jsonToUserId;
            } catch (Exception e11) {
                e = e11;
                try {
                    Logger.getLogger().w("Error deserializing user metadata.", e);
                    safeDeleteCorruptFile(userDataFileForSession);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
            Logger.getLogger().w("Error deserializing user metadata.", e);
            safeDeleteCorruptFile(userDataFileForSession);
            CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
            return null;
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void writeKeyData(String str, Map<String, String> map) {
        writeKeyData(str, map, false);
    }

    public void writeUserData(String str, String str2) {
        File userDataFileForSession = getUserDataFileForSession(str);
        BufferedWriter bufferedWriter = null;
        try {
            String userIdToJson = userIdToJson(str2);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDataFileForSession), UTF_8));
            try {
                bufferedWriter2.write(userIdToJson);
                bufferedWriter2.flush();
                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
            } catch (Exception e11) {
                e = e11;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.getLogger().w("Error serializing user metadata.", e);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            Logger.getLogger().w("Error serializing user metadata.", e);
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
        }
    }

    public Map<String, String> readKeyData(String str, boolean z11) {
        Exception e11;
        FileInputStream fileInputStream;
        File internalKeysFileForSession = z11 ? getInternalKeysFileForSession(str) : getKeysFileForSession(str);
        if (!internalKeysFileForSession.exists() || internalKeysFileForSession.length() == 0) {
            safeDeleteCorruptFile(internalKeysFileForSession);
            return Collections.emptyMap();
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(internalKeysFileForSession);
            try {
                Map<String, String> jsonToKeysData = jsonToKeysData(CommonUtils.streamToString(fileInputStream));
                CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                return jsonToKeysData;
            } catch (Exception e12) {
                e11 = e12;
                try {
                    Logger.getLogger().w("Error deserializing user metadata.", e11);
                    safeDeleteCorruptFile(internalKeysFileForSession);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                    return Collections.emptyMap();
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e13) {
            Exception exc = e13;
            fileInputStream = null;
            e11 = exc;
            Logger.getLogger().w("Error deserializing user metadata.", e11);
            safeDeleteCorruptFile(internalKeysFileForSession);
            CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
            return Collections.emptyMap();
        } catch (Throwable th3) {
            th = th3;
            CommonUtils.closeOrLog(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void writeKeyData(String str, Map<String, String> map, boolean z11) {
        File internalKeysFileForSession = z11 ? getInternalKeysFileForSession(str) : getKeysFileForSession(str);
        BufferedWriter bufferedWriter = null;
        try {
            String keysDataToJson = keysDataToJson(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(internalKeysFileForSession), UTF_8));
            try {
                bufferedWriter2.write(keysDataToJson);
                bufferedWriter2.flush();
                CommonUtils.closeOrLog(bufferedWriter2, "Failed to close key/value metadata file.");
            } catch (Exception e11) {
                e = e11;
                bufferedWriter = bufferedWriter2;
                try {
                    Logger.getLogger().w("Error serializing key/value metadata.", e);
                    safeDeleteCorruptFile(internalKeysFileForSession);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedWriter = bufferedWriter2;
                CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            Logger.getLogger().w("Error serializing key/value metadata.", e);
            safeDeleteCorruptFile(internalKeysFileForSession);
            CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
        }
    }
}
