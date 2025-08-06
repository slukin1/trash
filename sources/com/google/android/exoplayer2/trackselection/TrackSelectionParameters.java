package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Locale;

public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new Parcelable.Creator<TrackSelectionParameters>() {
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        public TrackSelectionParameters[] newArray(int i11) {
            return new TrackSelectionParameters[i11];
        }
    };
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    public final ImmutableList<String> preferredAudioLanguages;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
    }

    public TrackSelectionParameters(ImmutableList<String> immutableList, int i11, ImmutableList<String> immutableList2, int i12, boolean z11, int i13) {
        this.preferredAudioLanguages = immutableList;
        this.preferredAudioRoleFlags = i11;
        this.preferredTextLanguages = immutableList2;
        this.preferredTextRoleFlags = i12;
        this.selectUndeterminedTextLanguage = z11;
        this.disabledTextTrackSelectionFlags = i13;
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == trackSelectionParameters.disabledTextTrackSelectionFlags) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.preferredAudioLanguages.hashCode() + 31) * 31) + this.preferredAudioRoleFlags) * 31) + this.preferredTextLanguages.hashCode()) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeList(this.preferredAudioLanguages);
        parcel.writeInt(this.preferredAudioRoleFlags);
        parcel.writeList(this.preferredTextLanguages);
        parcel.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
    }

    public static class Builder {
        public int disabledTextTrackSelectionFlags;
        public ImmutableList<String> preferredAudioLanguages;
        public int preferredAudioRoleFlags;
        public ImmutableList<String> preferredTextLanguages;
        public int preferredTextRoleFlags;
        public boolean selectUndeterminedTextLanguage;

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
        }

        private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context context) {
            CaptioningManager captioningManager;
            if ((Util.SDK_INT >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
                this.preferredTextRoleFlags = SPHINCS256Config.CRYPTO_SECRETKEYBYTES;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.preferredTextLanguages = ImmutableList.of(Util.getLocaleLanguageTag(locale));
                }
            }
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.preferredAudioLanguages, this.preferredAudioRoleFlags, this.preferredTextLanguages, this.preferredTextRoleFlags, this.selectUndeterminedTextLanguage, this.disabledTextTrackSelectionFlags);
        }

        public Builder setDisabledTextTrackSelectionFlags(int i11) {
            this.disabledTextTrackSelectionFlags = i11;
            return this;
        }

        public Builder setPreferredAudioLanguage(String str) {
            if (str == null) {
                return setPreferredAudioLanguages(new String[0]);
            }
            return setPreferredAudioLanguages(str);
        }

        public Builder setPreferredAudioLanguages(String... strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String checkNotNull : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((Object) Util.normalizeLanguageCode((String) Assertions.checkNotNull(checkNotNull)));
            }
            this.preferredAudioLanguages = builder.build();
            return this;
        }

        public Builder setPreferredAudioRoleFlags(int i11) {
            this.preferredAudioRoleFlags = i11;
            return this;
        }

        public Builder setPreferredTextLanguage(String str) {
            if (str == null) {
                return setPreferredTextLanguages(new String[0]);
            }
            return setPreferredTextLanguages(str);
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            if (Util.SDK_INT >= 19) {
                setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
            }
            return this;
        }

        public Builder setPreferredTextLanguages(String... strArr) {
            ImmutableList.Builder builder = ImmutableList.builder();
            for (String checkNotNull : (String[]) Assertions.checkNotNull(strArr)) {
                builder.add((Object) Util.normalizeLanguageCode((String) Assertions.checkNotNull(checkNotNull)));
            }
            this.preferredTextLanguages = builder.build();
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i11) {
            this.preferredTextRoleFlags = i11;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z11) {
            this.selectUndeterminedTextLanguage = z11;
            return this;
        }

        @Deprecated
        public Builder() {
            this.preferredAudioLanguages = ImmutableList.of();
            this.preferredAudioRoleFlags = 0;
            this.preferredTextLanguages = ImmutableList.of();
            this.preferredTextRoleFlags = 0;
            this.selectUndeterminedTextLanguage = false;
            this.disabledTextTrackSelectionFlags = 0;
        }

        public Builder(TrackSelectionParameters trackSelectionParameters) {
            this.preferredAudioLanguages = trackSelectionParameters.preferredAudioLanguages;
            this.preferredAudioRoleFlags = trackSelectionParameters.preferredAudioRoleFlags;
            this.preferredTextLanguages = trackSelectionParameters.preferredTextLanguages;
            this.preferredTextRoleFlags = trackSelectionParameters.preferredTextRoleFlags;
            this.selectUndeterminedTextLanguage = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = trackSelectionParameters.disabledTextTrackSelectionFlags;
        }
    }

    public TrackSelectionParameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, (ClassLoader) null);
        this.preferredAudioLanguages = ImmutableList.copyOf(arrayList);
        this.preferredAudioRoleFlags = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, (ClassLoader) null);
        this.preferredTextLanguages = ImmutableList.copyOf(arrayList2);
        this.preferredTextRoleFlags = parcel.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
        this.disabledTextTrackSelectionFlags = parcel.readInt();
    }
}
