package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable, Identifiable {
    public static final long INVALID_ID = -1;
    private static final long serialVersionUID = 4663450696842173958L;
    @SerializedName("contributors_enabled")
    public final boolean contributorsEnabled;
    @SerializedName("created_at")
    public final String createdAt;
    @SerializedName("default_profile")
    public final boolean defaultProfile;
    @SerializedName("default_profile_image")
    public final boolean defaultProfileImage;
    @SerializedName("description")
    public final String description;
    @SerializedName("email")
    public final String email;
    @SerializedName("entities")
    public final UserEntities entities;
    @SerializedName("favourites_count")
    public final int favouritesCount;
    @SerializedName("follow_request_sent")
    public final boolean followRequestSent;
    @SerializedName("followers_count")
    public final int followersCount;
    @SerializedName("friends_count")
    public final int friendsCount;
    @SerializedName("geo_enabled")
    public final boolean geoEnabled;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public final long f51201id;
    @SerializedName("id_str")
    public final String idStr;
    @SerializedName("is_translator")
    public final boolean isTranslator;
    @SerializedName("lang")
    public final String lang;
    @SerializedName("listed_count")
    public final int listedCount;
    @SerializedName("location")
    public final String location;
    @SerializedName("name")
    public final String name;
    @SerializedName("profile_background_color")
    public final String profileBackgroundColor;
    @SerializedName("profile_background_image_url")
    public final String profileBackgroundImageUrl;
    @SerializedName("profile_background_image_url_https")
    public final String profileBackgroundImageUrlHttps;
    @SerializedName("profile_background_tile")
    public final boolean profileBackgroundTile;
    @SerializedName("profile_banner_url")
    public final String profileBannerUrl;
    @SerializedName("profile_image_url")
    public final String profileImageUrl;
    @SerializedName("profile_image_url_https")
    public final String profileImageUrlHttps;
    @SerializedName("profile_link_color")
    public final String profileLinkColor;
    @SerializedName("profile_sidebar_border_color")
    public final String profileSidebarBorderColor;
    @SerializedName("profile_sidebar_fill_color")
    public final String profileSidebarFillColor;
    @SerializedName("profile_text_color")
    public final String profileTextColor;
    @SerializedName("profile_use_background_image")
    public final boolean profileUseBackgroundImage;
    @SerializedName("protected")
    public final boolean protectedUser;
    @SerializedName("screen_name")
    public final String screenName;
    @SerializedName("show_all_inline_media")
    public final boolean showAllInlineMedia;
    @SerializedName("status")
    public final Tweet status;
    @SerializedName("statuses_count")
    public final int statusesCount;
    @SerializedName("time_zone")
    public final String timeZone;
    @SerializedName("url")
    public final String url;
    @SerializedName("utc_offset")
    public final int utcOffset;
    @SerializedName("verified")
    public final boolean verified;
    @SerializedName("withheld_in_countries")
    public final List<String> withheldInCountries;
    @SerializedName("withheld_scope")
    public final String withheldScope;

    public User(boolean z11, String str, boolean z12, boolean z13, String str2, String str3, UserEntities userEntities, int i11, boolean z14, int i12, int i13, boolean z15, long j11, String str4, boolean z16, String str5, int i14, String str6, String str7, String str8, String str9, String str10, boolean z17, String str11, String str12, String str13, String str14, String str15, String str16, String str17, boolean z18, boolean z19, String str18, boolean z21, Tweet tweet, int i15, String str19, String str20, int i16, boolean z22, List<String> list, String str21) {
        this.contributorsEnabled = z11;
        this.createdAt = str;
        this.defaultProfile = z12;
        this.defaultProfileImage = z13;
        this.description = str2;
        this.email = str3;
        this.entities = userEntities;
        this.favouritesCount = i11;
        this.followRequestSent = z14;
        this.followersCount = i12;
        this.friendsCount = i13;
        this.geoEnabled = z15;
        this.f51201id = j11;
        this.idStr = str4;
        this.isTranslator = z16;
        this.lang = str5;
        this.listedCount = i14;
        this.location = str6;
        this.name = str7;
        this.profileBackgroundColor = str8;
        this.profileBackgroundImageUrl = str9;
        this.profileBackgroundImageUrlHttps = str10;
        this.profileBackgroundTile = z17;
        this.profileBannerUrl = str11;
        this.profileImageUrl = str12;
        this.profileImageUrlHttps = str13;
        this.profileLinkColor = str14;
        this.profileSidebarBorderColor = str15;
        this.profileSidebarFillColor = str16;
        this.profileTextColor = str17;
        this.profileUseBackgroundImage = z18;
        this.protectedUser = z19;
        this.screenName = str18;
        this.showAllInlineMedia = z21;
        this.status = tweet;
        this.statusesCount = i15;
        this.timeZone = str19;
        this.url = str20;
        this.utcOffset = i16;
        this.verified = z22;
        this.withheldInCountries = list;
        this.withheldScope = str21;
    }

    public long getId() {
        return this.f51201id;
    }
}
