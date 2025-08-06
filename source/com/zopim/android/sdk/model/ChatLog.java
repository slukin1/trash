package com.zopim.android.sdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zendesk.logger.Logger;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ChatLog implements Comparable<ChatLog> {
    private static final String LOG_TAG = "ChatLog";
    @SerializedName("attachment")
    @Expose
    private Attachment attachment;
    @SerializedName("new_comment$string")
    @Expose
    private String comment;
    private Option[] convertedOptions;
    @SerializedName("display_name$string")
    @Expose
    private String displayName;
    @SerializedName("error$string")
    @Expose
    private String error;
    @SerializedName("failed$bool")
    @Expose
    private Boolean failed;
    private File file;
    @SerializedName("file_name$string")
    @Expose
    private String fileName;
    @SerializedName("file_size$int")
    @Expose
    private Integer fileSize;
    @SerializedName("file_type$string")
    @Expose
    private String fileType;
    @SerializedName("msg$string")
    @Expose
    private String message;
    @SerializedName("nick$string")
    @Expose
    private String nick;
    @SerializedName("options$string")
    @Expose
    private String options;
    @SerializedName("new_rating$string")
    @Expose
    private String rawNewRating;
    @SerializedName("rating$string")
    @Expose
    private String rawRating;
    @SerializedName("type$string")
    @Expose
    private String rawType;
    @SerializedName("timestamp$int")
    @Expose
    private Long timestamp;
    private Type type;
    @SerializedName("unverified$bool")
    @Expose
    private Boolean unverified;
    private int uploadProgress;
    @SerializedName("post_url$string")
    @Expose
    private String uploadUrl;
    @SerializedName("visitor_queue$int")
    @Expose
    private Integer visitorQueue;

    /* renamed from: com.zopim.android.sdk.model.ChatLog$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$Nick;
        public static final /* synthetic */ int[] $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0091 */
        static {
            /*
                com.zopim.android.sdk.model.ChatLog$RawType[] r0 = com.zopim.android.sdk.model.ChatLog.RawType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType = r0
                r1 = 1
                com.zopim.android.sdk.model.ChatLog$RawType r2 = com.zopim.android.sdk.model.ChatLog.RawType.CHAT_MSG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.zopim.android.sdk.model.ChatLog$RawType r3 = com.zopim.android.sdk.model.ChatLog.RawType.CHAT_EVENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.zopim.android.sdk.model.ChatLog$RawType r4 = com.zopim.android.sdk.model.ChatLog.RawType.MEMBER_JOIN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.zopim.android.sdk.model.ChatLog$RawType r5 = com.zopim.android.sdk.model.ChatLog.RawType.MEMBER_LEAVE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.zopim.android.sdk.model.ChatLog$RawType r5 = com.zopim.android.sdk.model.ChatLog.RawType.SYSTEM_OFFLINE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.zopim.android.sdk.model.ChatLog$RawType r5 = com.zopim.android.sdk.model.ChatLog.RawType.FILE_UPLOAD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.zopim.android.sdk.model.ChatLog$RawType r5 = com.zopim.android.sdk.model.ChatLog.RawType.CHAT_RATING_REQUEST     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.zopim.android.sdk.model.ChatLog$RawType r5 = com.zopim.android.sdk.model.ChatLog.RawType.CHAT_RATING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r4 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType     // Catch:{ NoSuchFieldError -> 0x006c }
                com.zopim.android.sdk.model.ChatLog$RawType r5 = com.zopim.android.sdk.model.ChatLog.RawType.CHAT_COMMENT     // Catch:{ NoSuchFieldError -> 0x006c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r6 = 9
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                com.zopim.android.sdk.model.ChatLog$Nick[] r4 = com.zopim.android.sdk.model.ChatLog.Nick.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$zopim$android$sdk$model$ChatLog$Nick = r4
                com.zopim.android.sdk.model.ChatLog$Nick r5 = com.zopim.android.sdk.model.ChatLog.Nick.AGENT_SYSTEM     // Catch:{ NoSuchFieldError -> 0x007d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                int[] r1 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Nick     // Catch:{ NoSuchFieldError -> 0x0087 }
                com.zopim.android.sdk.model.ChatLog$Nick r4 = com.zopim.android.sdk.model.ChatLog.Nick.AGENT_TRIGGER     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Nick     // Catch:{ NoSuchFieldError -> 0x0091 }
                com.zopim.android.sdk.model.ChatLog$Nick r1 = com.zopim.android.sdk.model.ChatLog.Nick.AGENT_MSG     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r0 = $SwitchMap$com$zopim$android$sdk$model$ChatLog$Nick     // Catch:{ NoSuchFieldError -> 0x009b }
                com.zopim.android.sdk.model.ChatLog$Nick r1 = com.zopim.android.sdk.model.ChatLog.Nick.VISITOR_MSG     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zopim.android.sdk.model.ChatLog.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Error {
        UPLOAD_SIZE_ERROR("size"),
        UPLOAD_FILE_EXTENSION_ERROR("type"),
        UPLOAD_FAILED_ERROR("upload_request_failed"),
        UNKNOWN("unknown");
        
        public final String error;

        private Error(String str) {
            this.error = str;
        }

        public static Error getType(String str) {
            for (Error error2 : values()) {
                if (error2.getValue().equals(str)) {
                    return error2;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.error;
        }
    }

    public enum Nick {
        AGENT_SYSTEM("agent:system"),
        AGENT_TRIGGER("agent:trigger"),
        AGENT_MSG("agent"),
        VISITOR_MSG("visitor"),
        UNKNOWN("unknown");
        
        public final String nick;

        private Nick(String str) {
            this.nick = str;
        }

        public static Nick getType(String str) {
            if (str == null || str.isEmpty()) {
                return UNKNOWN;
            }
            if ("agent:system".equals(str)) {
                return AGENT_SYSTEM;
            }
            if ("agent:trigger".equals(str)) {
                return AGENT_TRIGGER;
            }
            if (str.contains("agent")) {
                return AGENT_MSG;
            }
            if (str.contains("visitor")) {
                return VISITOR_MSG;
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.nick;
        }
    }

    public static class Option {
        private String label;
        private boolean selected;

        private Option() {
        }

        public String getLabel() {
            return this.label;
        }

        public boolean isSelected() {
            return this.selected;
        }

        public void select() {
            this.selected = true;
        }

        public Option(String str) {
            if (str == null) {
                Logger.l(ChatLog.LOG_TAG, "Option label not assigned", new Object[0]);
                this.label = "";
            }
            this.label = str;
            this.selected = false;
        }
    }

    public enum Rating {
        GOOD("good"),
        BAD("bad"),
        UNRATED("unrated"),
        UNKNOWN("unknown");
        
        public final String rating;

        private Rating(String str) {
            this.rating = str;
        }

        public static Rating getRating(String str) {
            for (Rating rating2 : values()) {
                if (rating2.getValue().equals(str)) {
                    return rating2;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.rating;
        }
    }

    public enum RawType {
        CHAT_MSG("chat.msg"),
        MEMBER_JOIN("chat.memberjoin"),
        MEMBER_LEAVE("chat.memberleave"),
        CHAT_EVENT("chat.event"),
        SYSTEM_OFFLINE("system.offline"),
        FILE_UPLOAD("chat.file.upload"),
        CHAT_RATING_REQUEST("chat.request.rating"),
        CHAT_RATING("chat.rating"),
        CHAT_COMMENT("chat.comment"),
        UNKNOWN("unknown");
        
        public final String type;

        private RawType(String str) {
            this.type = str;
        }

        public static RawType getType(String str) {
            for (RawType rawType : values()) {
                if (rawType.getValue().equals(str)) {
                    return rawType;
                }
            }
            return UNKNOWN;
        }

        public String getValue() {
            return this.type;
        }
    }

    public enum Type {
        CHAT_MSG_AGENT,
        CHAT_MSG_VISITOR,
        CHAT_MSG_TRIGGER,
        CHAT_MSG_SYSTEM,
        MEMBER_LEAVE,
        MEMBER_JOIN,
        SYSTEM_OFFLINE,
        ACCOUNT_OFFLINE,
        VISITOR_ATTACHMENT,
        CHAT_RATING,
        UNKNOWN
    }

    public ChatLog() {
        this.uploadProgress = 0;
    }

    public Attachment getAttachment() {
        return this.attachment;
    }

    public String getComment() {
        return this.comment;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Error getError() {
        return Error.getType(this.error);
    }

    public File getFile() {
        return this.file;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNick() {
        return this.nick;
    }

    public Option[] getOptions() {
        Option[] optionArr = this.convertedOptions;
        if (optionArr != null) {
            return optionArr;
        }
        String str = this.options;
        if (str == null || str.isEmpty()) {
            return new Option[0];
        }
        String[] split = this.options.split("/");
        Option[] optionArr2 = new Option[split.length];
        for (int i11 = 0; i11 < split.length; i11++) {
            optionArr2[i11] = new Option(split[i11]);
        }
        this.convertedOptions = optionArr2;
        return optionArr2;
    }

    public int getProgress() {
        return this.uploadProgress;
    }

    public Rating getRating() {
        if (this.rawRating == null && (Rating.getRating(this.rawNewRating) == Rating.GOOD || Rating.getRating(this.rawNewRating) == Rating.BAD)) {
            return Rating.getRating(this.rawNewRating);
        }
        if (this.rawNewRating == null && (Rating.getRating(this.rawRating) == Rating.GOOD || Rating.getRating(this.rawRating) == Rating.BAD)) {
            return Rating.UNRATED;
        }
        Rating rating = Rating.getRating(this.rawNewRating);
        Rating rating2 = Rating.GOOD;
        if ((rating == rating2 || Rating.getRating(this.rawNewRating) == Rating.BAD) && ((Rating.getRating(this.rawRating) == rating2 || Rating.getRating(this.rawRating) == Rating.BAD) && Rating.getRating(this.rawRating) != Rating.getRating(this.rawNewRating))) {
            return Rating.getRating(this.rawNewRating);
        }
        return Rating.UNRATED;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public Type getType() {
        Type type2 = this.type;
        if (type2 != null) {
            return type2;
        }
        switch (AnonymousClass1.$SwitchMap$com$zopim$android$sdk$model$ChatLog$RawType[RawType.getType(this.rawType).ordinal()]) {
            case 1:
                int i11 = AnonymousClass1.$SwitchMap$com$zopim$android$sdk$model$ChatLog$Nick[Nick.getType(this.nick).ordinal()];
                if (i11 == 1) {
                    return Type.CHAT_MSG_SYSTEM;
                }
                if (i11 == 2) {
                    return Type.CHAT_MSG_TRIGGER;
                }
                if (i11 == 3) {
                    return Type.CHAT_MSG_AGENT;
                }
                if (i11 != 4) {
                    return Type.UNKNOWN;
                }
                return Type.CHAT_MSG_VISITOR;
            case 2:
                return Type.CHAT_MSG_SYSTEM;
            case 3:
                return Type.MEMBER_JOIN;
            case 4:
                return Type.MEMBER_LEAVE;
            case 5:
                return Type.SYSTEM_OFFLINE;
            case 6:
                return Type.VISITOR_ATTACHMENT;
            case 7:
            case 8:
            case 9:
                return Type.CHAT_RATING;
            default:
                return Type.UNKNOWN;
        }
    }

    public URL getUploadUrl() {
        if (this.uploadUrl != null) {
            try {
                return new URL(this.uploadUrl);
            } catch (MalformedURLException e11) {
                Logger.k(LOG_TAG, "Can not retrieve url. ", e11, new Object[0]);
            }
        }
        return null;
    }

    public Integer getVisitorQueue() {
        return this.visitorQueue;
    }

    public Boolean isFailed() {
        return this.failed;
    }

    public Boolean isUnverified() {
        return this.unverified;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public void setError(Error error2) {
        this.error = error2.getValue();
    }

    public void setFailed(boolean z11) {
        this.failed = Boolean.valueOf(z11);
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public void setOptions(String str) {
        this.options = str;
    }

    public void setProgress(int i11) {
        if (i11 < 0 || i11 > 100) {
            Logger.g(LOG_TAG, "Supplied progress must be in range 0 - 100. Progress will not be updated.", new Object[0]);
        } else if (i11 < this.uploadProgress) {
            Logger.g(LOG_TAG, "Supplied progress must not be less then current progress. Progress will not be updated.", new Object[0]);
        } else {
            this.uploadProgress = i11;
        }
    }

    public void setRawNewRating(String str) {
        this.rawNewRating = str;
    }

    public void setRawRating(String str) {
        this.rawRating = str;
    }

    public String toString() {
        return "type:" + this.rawType + ", name:" + this.displayName + ", msg:" + this.message + ", time:" + this.timestamp + ", url:" + this.uploadUrl;
    }

    public int compareTo(ChatLog chatLog) {
        if (chatLog == null) {
            Logger.l(LOG_TAG, "Passed parameter must not be null. Can not compare. Declaring them as same.", new Object[0]);
            return 0;
        } else if (this.timestamp == null || chatLog.getTimestamp() == null) {
            Logger.l(LOG_TAG, "Error comparing chat logs. Timestamp was null. Declaring them as same.", new Object[0]);
            return 0;
        } else {
            try {
                return this.timestamp.compareTo(chatLog.getTimestamp());
            } catch (NullPointerException e11) {
                Logger.k(LOG_TAG, "Error comparing chat logs. Timestamp was not initialized. Declaring them as same.", e11, new Object[0]);
                return 0;
            }
        }
    }

    public ChatLog(String str, Type type2, String str2) {
        this.uploadProgress = 0;
        this.timestamp = Long.valueOf(System.currentTimeMillis());
        this.displayName = str;
        this.message = str2;
        this.unverified = Boolean.TRUE;
        this.failed = Boolean.FALSE;
        this.type = type2;
    }
}
