package com.adjust.sdk.network;

import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrlStrategy {
    private static final String BASE_URL_IO = "https://app.adjust.io";
    private static final String GDPR_URL_IO = "https://gdpr.adjust.io";
    private static final String PURCHASE_VERIFICATION_URL_IO = "https://ssrv.adjust.io";
    private static final String SUBSCRIPTION_URL_IO = "https://subscription.adjust.io";
    public final List<String> baseUrlChoicesList = baseUrlChoices();
    private final String baseUrlOverwrite;
    public int choiceIndex = 0;
    public final List<String> gdprUrlChoicesList = gdprUrlChoices();
    private final String gdprUrlOverwrite;
    public final List<String> purchaseVerificationUrlChoicesList = purchaseVerificationUrlChoices();
    private final String purchaseVerificationUrlOverwrite;
    public int startingChoiceIndex = 0;
    public final List<String> subscriptionUrlChoicesList = subscriptionUrlChoices();
    private final String subscriptionUrlOverwrite;
    private final List<String> urlStrategyDomains;
    private final boolean useSubdomains;
    public boolean wasLastAttemptSuccess = false;
    public boolean wasLastAttemptWithOverwrittenUrl = false;

    public UrlStrategy(String str, String str2, String str3, String str4, List<String> list, boolean z11) {
        this.urlStrategyDomains = list;
        this.useSubdomains = z11;
        this.baseUrlOverwrite = str;
        this.gdprUrlOverwrite = str2;
        this.subscriptionUrlOverwrite = str3;
        this.purchaseVerificationUrlOverwrite = str4;
    }

    private List<String> baseUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(new String[]{Constants.BASE_URL, BASE_URL_IO});
        }
        if (this.useSubdomains) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.BASE_URL_FORMAT, new Object[]{str}));
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : this.urlStrategyDomains) {
            arrayList2.add(String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, new Object[]{str2}));
        }
        return arrayList2;
    }

    private List<String> gdprUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(new String[]{Constants.GDPR_URL, GDPR_URL_IO});
        }
        ArrayList arrayList = new ArrayList();
        if (this.useSubdomains) {
            for (String str : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.GDPR_URL_FORMAT, new Object[]{str}));
            }
        } else {
            for (String str2 : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, new Object[]{str2}));
            }
        }
        return arrayList;
    }

    private List<String> purchaseVerificationUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(new String[]{Constants.PURCHASE_VERIFICATION_URL, PURCHASE_VERIFICATION_URL_IO});
        }
        ArrayList arrayList = new ArrayList();
        if (this.useSubdomains) {
            for (String str : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.PURCHASE_VERIFICATION_URL_FORMAT, new Object[]{str}));
            }
        } else {
            for (String str2 : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, new Object[]{str2}));
            }
        }
        return arrayList;
    }

    private List<String> subscriptionUrlChoices() {
        List<String> list = this.urlStrategyDomains;
        if (list == null || list.isEmpty()) {
            return Arrays.asList(new String[]{Constants.SUBSCRIPTION_URL, SUBSCRIPTION_URL_IO});
        }
        ArrayList arrayList = new ArrayList();
        if (this.useSubdomains) {
            for (String str : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.SUBSCRIPTION_URL_FORMAT, new Object[]{str}));
            }
        } else {
            for (String str2 : this.urlStrategyDomains) {
                arrayList.add(String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, new Object[]{str2}));
            }
        }
        return arrayList;
    }

    public void resetAfterSuccess() {
        this.startingChoiceIndex = this.choiceIndex;
        this.wasLastAttemptSuccess = true;
    }

    public boolean shouldRetryAfterFailure(ActivityKind activityKind) {
        this.wasLastAttemptSuccess = false;
        if (this.wasLastAttemptWithOverwrittenUrl) {
            return false;
        }
        int size = (this.choiceIndex + 1) % (activityKind == ActivityKind.GDPR ? this.gdprUrlChoicesList : activityKind == ActivityKind.SUBSCRIPTION ? this.subscriptionUrlChoicesList : activityKind == ActivityKind.PURCHASE_VERIFICATION ? this.purchaseVerificationUrlChoicesList : this.baseUrlChoicesList).size();
        this.choiceIndex = size;
        return size != this.startingChoiceIndex;
    }

    public String targetUrlByActivityKind(ActivityKind activityKind) {
        List<String> list;
        if (activityKind == ActivityKind.GDPR) {
            String str = this.gdprUrlOverwrite;
            if (str != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.gdprUrlChoicesList;
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            String str2 = this.subscriptionUrlOverwrite;
            if (str2 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str2;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.subscriptionUrlChoicesList;
        } else if (activityKind == ActivityKind.PURCHASE_VERIFICATION) {
            String str3 = this.purchaseVerificationUrlOverwrite;
            if (str3 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str3;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.purchaseVerificationUrlChoicesList;
        } else {
            String str4 = this.baseUrlOverwrite;
            if (str4 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str4;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.baseUrlChoicesList;
        }
        return list.get(this.choiceIndex);
    }
}
