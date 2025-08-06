package com.tencent.rtmp.downloader.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.liteav.txcvodplayer.b.d;
import com.tencent.rtmp.TXPlayerDrmBuilder;
import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;

public class c extends TXVodDownloadMediaInfo implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new c[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static final String f48647a = c.class.getName();

    public c() {
    }

    public final void a(a aVar) {
        this.dataSource = aVar;
    }

    public final void b(int i11) {
        this.playableDuration = i11;
    }

    public final void c(int i11) {
        this.tid = i11;
    }

    public final void d(int i11) {
        this.downloadState = i11;
    }

    public int describeContents() {
        return 0;
    }

    public final void e(int i11) {
        this.speed = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.dataSource, 0);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.size);
        parcel.writeInt(this.downloadSize);
        parcel.writeInt(this.segments);
        parcel.writeInt(this.downloadSegments);
        parcel.writeString(this.playPath);
        parcel.writeString(this.url);
        if (this.dataSource == null) {
            parcel.writeString(this.userName);
        }
        parcel.writeInt(this.downloadState);
        parcel.writeInt(this.playableDuration);
        parcel.writeLong(this.preferredResolution);
        TXPlayerDrmBuilder tXPlayerDrmBuilder = this.drmBuilder;
        parcel.writeString(tXPlayerDrmBuilder != null ? tXPlayerDrmBuilder.getKeyLicenseUrl() : "");
        parcel.writeInt(this.speed);
        parcel.writeLong(this.totalSize);
        parcel.writeLong(this.playableSize);
    }

    public c(Parcel parcel) {
        int i11;
        int i12;
        this.dataSource = (a) parcel.readParcelable(a.class.getClassLoader());
        this.duration = parcel.readInt();
        this.size = parcel.readInt();
        this.downloadSize = parcel.readInt();
        this.segments = parcel.readInt();
        this.downloadSegments = parcel.readInt();
        this.playPath = parcel.readString();
        this.url = parcel.readString();
        if (this.dataSource == null) {
            this.userName = parcel.readString();
        }
        this.downloadState = parcel.readInt();
        this.playableDuration = parcel.readInt();
        long readLong = parcel.readLong();
        this.preferredResolution = readLong;
        if (readLong <= 0) {
            this.preferredResolution = -1;
        }
        String readString = parcel.readString();
        if (!TextUtils.isEmpty(readString)) {
            this.drmBuilder = new TXPlayerDrmBuilder(readString, this.url);
        }
        this.speed = parcel.readInt();
        this.totalSize = parcel.readLong();
        long readLong2 = parcel.readLong();
        this.playableSize = readLong2;
        if (this.totalSize <= 0 && (i12 = this.size) > 0) {
            this.totalSize = (long) i12;
        }
        if (readLong2 <= 0 && (i11 = this.downloadSize) > 0) {
            this.playableSize = (long) i11;
        }
    }

    public final void a(int i11) {
        this.duration = i11;
    }

    public final void b(long j11) {
        this.playableSize = j11;
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.userName = str;
        }
    }

    public final void a(long j11) {
        this.totalSize = j11;
    }

    public final void b(String str) {
        this.url = str;
    }

    public final void a(String str) {
        this.playPath = str;
    }

    public final void c(long j11) {
        if (j11 > 0) {
            this.preferredResolution = j11;
        }
    }

    public final void a(TXPlayerDrmBuilder tXPlayerDrmBuilder) {
        this.drmBuilder = tXPlayerDrmBuilder;
    }

    public final void a(d dVar) {
        this.netApi = dVar;
    }

    public final void a(float f11) {
        this.progress = f11;
    }

    public final void a() {
        this.isResourceBroken = true;
    }
}
