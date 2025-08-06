package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.util.Util;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        public TextInformationFrame[] newArray(int i11) {
            return new TextInformationFrame[i11];
        }
    };
    public final String description;
    public final String value;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (!Util.areEqual(this.f65946id, textInformationFrame.f65946id) || !Util.areEqual(this.description, textInformationFrame.description) || !Util.areEqual(this.value, textInformationFrame.value)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f65946id.hashCode()) * 31;
        String str = this.description;
        int i11 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.f65946id;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c11 = 0;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c11 = 3;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c11 = 4;
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c11 = 5;
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c11 = 6;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c11 = 7;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c11 = 8;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c11 = 9;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c11 = 10;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c11 = 11;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 6:
                builder.setAlbumTitle(this.value);
                return;
            case 1:
            case 8:
                builder.setArtist(this.value);
                return;
            case 2:
            case 9:
                builder.setAlbumArtist(this.value);
                return;
            case 3:
            case 10:
                String[] split = Util.split(this.value, "/");
                builder.setTrackNumber(Integer.valueOf(Integer.parseInt(split[0]))).setTotalTrackCount(split.length > 1 ? Integer.valueOf(Integer.parseInt(split[1])) : null);
                return;
            case 4:
            case 7:
                builder.setTitle(this.value);
                return;
            case 5:
            case 11:
                try {
                    builder.setYear(Integer.valueOf(Integer.parseInt(this.value)));
                    return;
                } catch (NumberFormatException unused) {
                }
            default:
                return;
        }
    }

    public String toString() {
        String str = this.f65946id;
        String str2 = this.description;
        String str3 = this.value;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb2.append(str);
        sb2.append(": description=");
        sb2.append(str2);
        sb2.append(": value=");
        sb2.append(str3);
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f65946id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }

    public TextInformationFrame(Parcel parcel) {
        super((String) Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.value = (String) Util.castNonNull(parcel.readString());
    }
}
