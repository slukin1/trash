package zendesk.belvedere;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public class MediaResult implements Parcelable, Comparable<MediaResult> {
    public static final Parcelable.Creator<MediaResult> CREATOR = new a();
    public static final long UNKNOWN_VALUE = -1;
    private final File file;
    private final long height;
    private final String mimeType;
    private final String name;
    private final Uri originalUri;
    private final long size;
    private final Uri uri;
    private final long width;

    public static class a implements Parcelable.Creator<MediaResult> {
        /* renamed from: a */
        public MediaResult createFromParcel(Parcel parcel) {
            return new MediaResult(parcel, (a) null);
        }

        /* renamed from: b */
        public MediaResult[] newArray(int i11) {
            return new MediaResult[i11];
        }
    }

    public /* synthetic */ MediaResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static MediaResult empty() {
        return new MediaResult((File) null, (Uri) null, (Uri) null, (String) null, (String) null, -1, -1, -1);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MediaResult mediaResult = (MediaResult) obj;
            if (this.size == mediaResult.size && this.width == mediaResult.width && this.height == mediaResult.height) {
                File file2 = this.file;
                if (file2 == null ? mediaResult.file != null : !file2.equals(mediaResult.file)) {
                    return false;
                }
                Uri uri2 = this.uri;
                if (uri2 == null ? mediaResult.uri != null : !uri2.equals(mediaResult.uri)) {
                    return false;
                }
                Uri uri3 = this.originalUri;
                if (uri3 == null ? mediaResult.originalUri != null : !uri3.equals(mediaResult.originalUri)) {
                    return false;
                }
                String str = this.name;
                if (str == null ? mediaResult.name != null : !str.equals(mediaResult.name)) {
                    return false;
                }
                String str2 = this.mimeType;
                String str3 = mediaResult.mimeType;
                if (str2 != null) {
                    return str2.equals(str3);
                }
                if (str3 == null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public File getFile() {
        return this.file;
    }

    public long getHeight() {
        return this.height;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public Uri getOriginalUri() {
        return this.originalUri;
    }

    public long getSize() {
        return this.size;
    }

    public Uri getUri() {
        return this.uri;
    }

    public long getWidth() {
        return this.width;
    }

    public int hashCode() {
        File file2 = this.file;
        int i11 = 0;
        int hashCode = (file2 != null ? file2.hashCode() : 0) * 31;
        Uri uri2 = this.uri;
        int hashCode2 = (hashCode + (uri2 != null ? uri2.hashCode() : 0)) * 31;
        Uri uri3 = this.originalUri;
        int hashCode3 = (hashCode2 + (uri3 != null ? uri3.hashCode() : 0)) * 31;
        String str = this.name;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mimeType;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        long j11 = this.size;
        long j12 = this.width;
        long j13 = this.height;
        return ((((((hashCode4 + i11) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)));
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeSerializable(this.file);
        parcel.writeParcelable(this.uri, i11);
        parcel.writeString(this.name);
        parcel.writeString(this.mimeType);
        parcel.writeParcelable(this.originalUri, i11);
        parcel.writeLong(this.size);
        parcel.writeLong(this.width);
        parcel.writeLong(this.height);
    }

    public MediaResult(File file2, Uri uri2, Uri uri3, String str, String str2, long j11, long j12, long j13) {
        this.file = file2;
        this.uri = uri2;
        this.originalUri = uri3;
        this.mimeType = str2;
        this.name = str;
        this.size = j11;
        this.width = j12;
        this.height = j13;
    }

    public int compareTo(MediaResult mediaResult) {
        return this.originalUri.compareTo(mediaResult.getOriginalUri());
    }

    private MediaResult(Parcel parcel) {
        this.file = (File) parcel.readSerializable();
        this.uri = (Uri) parcel.readParcelable(MediaResult.class.getClassLoader());
        this.name = parcel.readString();
        this.mimeType = parcel.readString();
        this.originalUri = (Uri) parcel.readParcelable(MediaResult.class.getClassLoader());
        this.size = parcel.readLong();
        this.width = parcel.readLong();
        this.height = parcel.readLong();
    }
}
