package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class LegacyNativeDialogParameters {
    private static Bundle create(ShareVideoContent shareVideoContent, boolean z11) {
        return null;
    }

    public static Bundle create(UUID uuid, ShareContent shareContent, boolean z11) {
        Validate.notNull(shareContent, "shareContent");
        Validate.notNull(uuid, "callId");
        if (shareContent instanceof ShareLinkContent) {
            return create((ShareLinkContent) shareContent, z11);
        }
        if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            return create(sharePhotoContent, ShareInternalUtility.getPhotoUrls(sharePhotoContent, uuid), z11);
        } else if (shareContent instanceof ShareVideoContent) {
            return create((ShareVideoContent) shareContent, z11);
        } else {
            if (!(shareContent instanceof ShareOpenGraphContent)) {
                return null;
            }
            ShareOpenGraphContent shareOpenGraphContent = (ShareOpenGraphContent) shareContent;
            try {
                return create(shareOpenGraphContent, ShareInternalUtility.toJSONObjectForCall(uuid, shareOpenGraphContent), z11);
            } catch (JSONException e11) {
                throw new FacebookException("Unable to create a JSON Object from the provided ShareOpenGraphContent: " + e11.getMessage());
            }
        }
    }

    private static Bundle createBaseParameters(ShareContent shareContent, boolean z11) {
        Bundle bundle = new Bundle();
        Utility.putUri(bundle, ShareConstants.LEGACY_LINK, shareContent.getContentUrl());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_PLACE_TAG, shareContent.getPlaceId());
        Utility.putNonEmptyString(bundle, ShareConstants.LEGACY_REF, shareContent.getRef());
        bundle.putBoolean(ShareConstants.LEGACY_DATA_FAILURES_FATAL, z11);
        List<String> peopleIds = shareContent.getPeopleIds();
        if (!Utility.isNullOrEmpty(peopleIds)) {
            bundle.putStringArrayList(ShareConstants.LEGACY_FRIEND_TAGS, new ArrayList(peopleIds));
        }
        return bundle;
    }

    private static Bundle create(ShareLinkContent shareLinkContent, boolean z11) {
        Bundle createBaseParameters = createBaseParameters(shareLinkContent, z11);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_TITLE, shareLinkContent.getContentTitle());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_DESCRIPTION, shareLinkContent.getContentDescription());
        Utility.putUri(createBaseParameters, ShareConstants.LEGACY_IMAGE, shareLinkContent.getImageUrl());
        return createBaseParameters;
    }

    private static Bundle create(SharePhotoContent sharePhotoContent, List<String> list, boolean z11) {
        Bundle createBaseParameters = createBaseParameters(sharePhotoContent, z11);
        createBaseParameters.putStringArrayList(ShareConstants.LEGACY_PHOTOS, new ArrayList(list));
        return createBaseParameters;
    }

    private static Bundle create(ShareOpenGraphContent shareOpenGraphContent, JSONObject jSONObject, boolean z11) {
        Bundle createBaseParameters = createBaseParameters(shareOpenGraphContent, z11);
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_PREVIEW_PROPERTY_NAME, shareOpenGraphContent.getPreviewPropertyName());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_ACTION_TYPE, shareOpenGraphContent.getAction().getActionType());
        Utility.putNonEmptyString(createBaseParameters, ShareConstants.LEGACY_ACTION, jSONObject.toString());
        return createBaseParameters;
    }
}
