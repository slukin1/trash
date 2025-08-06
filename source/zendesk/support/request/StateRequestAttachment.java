package zendesk.support.request;

import android.net.Uri;
import androidx.core.util.c;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.a;
import mz.b;
import mz.d;
import mz.f;
import zendesk.belvedere.MediaResult;
import zendesk.support.Attachment;
import zendesk.support.AttachmentFile;
import zendesk.support.CommentResponse;
import zendesk.support.IdUtil;

class StateRequestAttachment implements Serializable, Comparable<StateRequestAttachment> {
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    private final int height;

    /* renamed from: id  reason: collision with root package name */
    private final long f62983id;
    private final transient File localFile;
    private final String localUri;
    private final String mimeType;
    private final String name;
    private final long size;
    private final String thumbnailUrl;
    private final String token;
    private final String url;
    private final int width;

    public static class Builder {
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public long f62984id;
        /* access modifiers changed from: private */
        public File localFile;
        /* access modifiers changed from: private */
        public String localUri;
        /* access modifiers changed from: private */
        public String mimeType;
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public long size;
        /* access modifiers changed from: private */
        public String thumbnailUrl;
        /* access modifiers changed from: private */
        public String token;
        /* access modifiers changed from: private */
        public String url;
        /* access modifiers changed from: private */
        public int width;

        public StateRequestAttachment build() {
            return new StateRequestAttachment(this);
        }

        public Builder setHeight(int i11) {
            this.height = i11;
            return this;
        }

        public Builder setId(long j11) {
            this.f62984id = j11;
            return this;
        }

        public Builder setLocalFile(File file) {
            this.localFile = file;
            return this;
        }

        public Builder setLocalUri(String str) {
            this.localUri = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setSize(long j11) {
            this.size = j11;
            return this;
        }

        public void setThumbnailUrl(String str) {
            this.thumbnailUrl = str;
        }

        public Builder setToken(String str) {
            this.token = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        public Builder setWidth(int i11) {
            this.width = i11;
            return this;
        }

        private Builder(StateRequestAttachment stateRequestAttachment) {
            this.f62984id = stateRequestAttachment.getId();
            this.localFile = stateRequestAttachment.getLocalFile();
            this.localUri = stateRequestAttachment.getLocalUri();
            this.url = stateRequestAttachment.getUrl();
            this.token = stateRequestAttachment.getToken();
            this.mimeType = stateRequestAttachment.getMimeType();
            this.name = stateRequestAttachment.getName();
            this.size = stateRequestAttachment.getSize();
            this.width = stateRequestAttachment.getWidth();
            this.height = stateRequestAttachment.getHeight();
            this.thumbnailUrl = stateRequestAttachment.getThumbnailUrl();
        }
    }

    public static c<Map<Long, StateRequestAttachment>, StateIdMapper> convert(List<CommentResponse> list, Map<Long, MediaResult> map, StateIdMapper stateIdMapper) {
        ArrayList arrayList = new ArrayList();
        for (CommentResponse attachments : list) {
            arrayList.addAll(attachments.getAttachments());
        }
        return convert((List<Attachment>) arrayList, stateIdMapper, map);
    }

    private static String getMimeTypeForFile(File file) {
        return d.b(b.a(file.getName()));
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.f62983id;
    }

    public File getLocalFile() {
        return this.localFile;
    }

    public String getLocalUri() {
        return this.localUri;
    }

    public String getMimeType() {
        return f.c(this.mimeType) ? this.mimeType : DEFAULT_MIME_TYPE;
    }

    public String getName() {
        return this.name;
    }

    public Uri getParsedLocalUri() {
        return Uri.parse(this.localUri);
    }

    public long getSize() {
        return this.size;
    }

    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public String getToken() {
        return this.token;
    }

    public String getUrl() {
        return this.url;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAvailableLocally() {
        return (this.localUri == null || getParsedLocalUri() == null || this.localFile == null) ? false : true;
    }

    public Builder newBuilder() {
        return new Builder();
    }

    public String toString() {
        return "RequestAttachment{id=" + this.f62983id + ", localUri='" + this.localUri + '\'' + ", localFile=" + this.localFile + ", url='" + this.url + '\'' + ", token='" + this.token + '\'' + ", mimeType='" + this.mimeType + '\'' + ", name='" + this.name + '\'' + ", size='" + this.size + '\'' + ", width='" + this.width + '\'' + ", height='" + this.height + '\'' + '}';
    }

    public StateRequestAttachment(long j11, String str, File file, String str2, String str3, String str4, String str5, long j12, int i11, int i12, String str6) {
        this.f62983id = j11;
        this.localUri = str;
        this.localFile = file;
        this.url = str2;
        this.token = str3;
        this.mimeType = str4;
        this.name = str5;
        this.size = j12;
        this.width = i11;
        this.height = i12;
        this.thumbnailUrl = str6;
    }

    public int compareTo(StateRequestAttachment stateRequestAttachment) {
        return (int) (this.f62983id - stateRequestAttachment.f62983id);
    }

    public static c<Map<Long, StateRequestAttachment>, StateIdMapper> convert(List<Attachment> list, StateIdMapper stateIdMapper, Map<Long, MediaResult> map) {
        long j11;
        File file;
        String str;
        StateIdMapper stateIdMapper2 = stateIdMapper;
        Map<Long, MediaResult> map2 = map;
        HashMap hashMap = new HashMap(list.size());
        for (Attachment next : list) {
            if (next.getId() != null) {
                if (stateIdMapper2.hasLocalId(next.getId())) {
                    j11 = stateIdMapper2.getLocalId(next.getId()).longValue();
                } else {
                    j11 = IdUtil.newLongId();
                    stateIdMapper2.addIdMapping(next.getId(), Long.valueOf(j11));
                }
                long j12 = j11;
                if (map2.containsKey(next.getId())) {
                    MediaResult mediaResult = map2.get(next.getId());
                    File file2 = mediaResult.getFile();
                    str = mediaResult.getUri().toString();
                    file = file2;
                } else {
                    str = null;
                    file = null;
                }
                long j13 = -1;
                long longValue = next.getSize() != null ? next.getSize().longValue() : -1;
                long longValue2 = next.getWidth() != null ? next.getWidth().longValue() : -1;
                if (next.getHeight() != null) {
                    j13 = next.getHeight().longValue();
                }
                hashMap.put(next.getId(), new StateRequestAttachment(j12, str, file, next.getContentUrl(), "", next.getContentType(), next.getFileName(), longValue, (int) longValue2, (int) j13, a.i(next.getThumbnails()) ? next.getThumbnails().get(0).getContentUrl() : ""));
            }
        }
        return c.a(hashMap, stateIdMapper2);
    }

    private StateRequestAttachment(Builder builder) {
        this.localFile = builder.localFile;
        this.localUri = builder.localUri;
        this.mimeType = builder.mimeType;
        this.name = builder.name;
        this.f62983id = builder.f62984id;
        this.url = builder.url;
        this.token = builder.token;
        this.size = builder.size;
        this.width = builder.width;
        this.height = builder.height;
        this.thumbnailUrl = builder.thumbnailUrl;
    }

    public static StateRequestAttachment convert(MediaResult mediaResult) {
        return new StateRequestAttachment(IdUtil.newLongId(), mediaResult.getUri().toString(), mediaResult.getFile(), "", "", mediaResult.getMimeType(), mediaResult.getName(), mediaResult.getSize(), (int) mediaResult.getWidth(), (int) mediaResult.getHeight(), "");
    }

    public static StateRequestAttachment convert(File file) {
        return new StateRequestAttachment(IdUtil.newLongId(), Uri.fromFile(file).toString(), file, "", "", getMimeTypeForFile(file), file.getName(), file.length(), -1, -1, "");
    }

    public static StateRequestAttachment convert(AttachmentFile attachmentFile) {
        return new StateRequestAttachment(IdUtil.newLongId(), Uri.fromFile(attachmentFile.getFile()).toString(), attachmentFile.getFile(), "", "", getMimeTypeForFile(attachmentFile.getFile()), attachmentFile.getFileName(), attachmentFile.getFile().length(), -1, -1, "");
    }

    public static MediaResult convert(StateRequestAttachment stateRequestAttachment) {
        return new MediaResult(stateRequestAttachment.getLocalFile(), stateRequestAttachment.getParsedLocalUri(), stateRequestAttachment.getParsedLocalUri(), stateRequestAttachment.getName(), stateRequestAttachment.getMimeType(), stateRequestAttachment.getSize(), (long) stateRequestAttachment.getWidth(), (long) stateRequestAttachment.getHeight());
    }
}
