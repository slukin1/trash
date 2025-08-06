package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMessengerActionButton;

@Deprecated
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new Parcelable.Creator<ShareMessengerURLActionButton>() {
        public ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            return new ShareMessengerURLActionButton(parcel);
        }

        public ShareMessengerURLActionButton[] newArray(int i11) {
            return new ShareMessengerURLActionButton[i11];
        }
    };
    private final Uri fallbackUrl;
    private final boolean isMessengerExtensionURL;
    private final boolean shouldHideWebviewShareButton;
    private final Uri url;
    private final WebviewHeightRatio webviewHeightRatio;

    public static final class Builder extends ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder> {
        /* access modifiers changed from: private */
        public Uri fallbackUrl;
        /* access modifiers changed from: private */
        public boolean isMessengerExtensionURL;
        /* access modifiers changed from: private */
        public boolean shouldHideWebviewShareButton;
        /* access modifiers changed from: private */
        public Uri url;
        /* access modifiers changed from: private */
        public WebviewHeightRatio webviewHeightRatio;

        public Builder setFallbackUrl(Uri uri) {
            this.fallbackUrl = uri;
            return this;
        }

        public Builder setIsMessengerExtensionURL(boolean z11) {
            this.isMessengerExtensionURL = z11;
            return this;
        }

        public Builder setShouldHideWebviewShareButton(boolean z11) {
            this.shouldHideWebviewShareButton = z11;
            return this;
        }

        public Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public Builder setWebviewHeightRatio(WebviewHeightRatio webviewHeightRatio2) {
            this.webviewHeightRatio = webviewHeightRatio2;
            return this;
        }

        public ShareMessengerURLActionButton build() {
            return new ShareMessengerURLActionButton(this);
        }

        public Builder readFrom(ShareMessengerURLActionButton shareMessengerURLActionButton) {
            if (shareMessengerURLActionButton == null) {
                return this;
            }
            return setUrl(shareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(shareMessengerURLActionButton.getIsMessengerExtensionURL()).setFallbackUrl(shareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(shareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(shareMessengerURLActionButton.getShouldHideWebviewShareButton());
        }
    }

    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact
    }

    public Uri getFallbackUrl() {
        return this.fallbackUrl;
    }

    public boolean getIsMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    public boolean getShouldHideWebviewShareButton() {
        return this.shouldHideWebviewShareButton;
    }

    public Uri getUrl() {
        return this.url;
    }

    public WebviewHeightRatio getWebviewHeightRatio() {
        return this.webviewHeightRatio;
    }

    private ShareMessengerURLActionButton(Builder builder) {
        super((ShareMessengerActionButton.Builder) builder);
        this.url = builder.url;
        this.isMessengerExtensionURL = builder.isMessengerExtensionURL;
        this.fallbackUrl = builder.fallbackUrl;
        this.webviewHeightRatio = builder.webviewHeightRatio;
        this.shouldHideWebviewShareButton = builder.shouldHideWebviewShareButton;
    }

    public ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        boolean z11 = true;
        this.isMessengerExtensionURL = parcel.readByte() != 0;
        this.fallbackUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio) parcel.readSerializable();
        this.shouldHideWebviewShareButton = parcel.readByte() == 0 ? false : z11;
    }
}
