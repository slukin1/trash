package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;

public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent) {
        Validate.notNull(gameRequestContent.getMessage(), "message");
        int i11 = 0;
        if (!((gameRequestContent.getObjectId() != null) ^ (gameRequestContent.getActionType() == GameRequestContent.ActionType.ASKFOR || gameRequestContent.getActionType() == GameRequestContent.ActionType.SEND))) {
            if (gameRequestContent.getRecipients() != null) {
                i11 = 1;
            }
            if (gameRequestContent.getSuggestions() != null) {
                i11++;
            }
            if (gameRequestContent.getFilters() != null) {
                i11++;
            }
            if (i11 > 1) {
                throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
            }
            return;
        }
        throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
    }
}
