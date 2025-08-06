package com.sumsub.sns.core;

import androidx.annotation.Keep;
import com.sumsub.sns.core.data.listener.SNSActionResultHandler;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.data.listener.SNSErrorHandler;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.listener.SNSInstructionsViewHandler;
import com.sumsub.sns.core.data.listener.SNSStateChangedHandler;
import com.sumsub.sns.core.data.listener.SNSUrlHandler;
import com.sumsub.sns.core.data.listener.TokenExpirationHandler;
import com.sumsub.sns.core.data.model.SNSDocumentDefinition;
import com.sumsub.sns.core.data.model.SNSInitConfig;
import com.sumsub.sns.core.data.model.SNSSDKState;
import com.sumsub.sns.core.data.model.SNSSupportItem;
import com.sumsub.sns.core.theme.SNSJsonCustomization;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

@a
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010X\u001a\u00020.H&J\u0010\u0010Y\u001a\u00020'2\u0006\u0010X\u001a\u00020.H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u0004\u0018\u00010#X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0012\u0010)\u001a\u00020*X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R \u00101\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u000203\u0018\u000102X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R \u00106\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u000102X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u0004\u0018\u00010=X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R \u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010AX¦\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010G\u001a\u0004\u0018\u00010HX¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\u0004\u0018\u00010LX¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0012\u0010O\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\bP\u00100R\u0012\u0010Q\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0012\u0010T\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u00100ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006ZÀ\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/MobileSdk;", "", "actionResultHandler", "Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "getActionResultHandler", "()Lcom/sumsub/sns/core/data/listener/SNSActionResultHandler;", "autoCloseOnApproveTimeout", "", "getAutoCloseOnApproveTimeout", "()Ljava/lang/Integer;", "conf", "Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "getConf", "()Lcom/sumsub/sns/core/data/model/SNSInitConfig;", "countryPicker", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "getCountryPicker", "()Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "customization", "Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "getCustomization", "()Lcom/sumsub/sns/core/theme/SNSJsonCustomization;", "errorHandler", "Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "getErrorHandler", "()Lcom/sumsub/sns/core/data/listener/SNSErrorHandler;", "eventHandler", "Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "getEventHandler", "()Lcom/sumsub/sns/core/data/listener/SNSEventHandler;", "iconHandler", "Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "getIconHandler", "()Lcom/sumsub/sns/core/data/listener/SNSIconHandler;", "instructionsViewHandler", "Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "getInstructionsViewHandler", "()Lcom/sumsub/sns/core/data/listener/SNSInstructionsViewHandler;", "isDebug", "", "()Z", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "preferredDocumentsDefinitions", "", "Lcom/sumsub/sns/core/data/model/SNSDocumentDefinition;", "getPreferredDocumentsDefinitions", "()Ljava/util/Map;", "settings", "getSettings", "state", "Lcom/sumsub/sns/core/data/model/SNSSDKState;", "getState", "()Lcom/sumsub/sns/core/data/model/SNSSDKState;", "stateChangedHandler", "Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "getStateChangedHandler", "()Lcom/sumsub/sns/core/data/listener/SNSStateChangedHandler;", "supportItems", "", "Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "getSupportItems", "()Ljava/util/List;", "setSupportItems", "(Ljava/util/List;)V", "tokenExpirationHandler", "Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "getTokenExpirationHandler", "()Lcom/sumsub/sns/core/data/listener/TokenExpirationHandler;", "urlHandler", "Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "getUrlHandler", "()Lcom/sumsub/sns/core/data/listener/SNSUrlHandler;", "version", "getVersion", "versionCode", "getVersionCode", "()I", "versionName", "getVersionName", "getPluggedModule", "Lcom/sumsub/sns/core/SNSModule;", "className", "isModuleAvailable", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public interface MobileSdk {
    SNSActionResultHandler getActionResultHandler();

    Integer getAutoCloseOnApproveTimeout();

    SNSInitConfig getConf();

    SNSCountryPicker getCountryPicker();

    SNSJsonCustomization getCustomization();

    SNSErrorHandler getErrorHandler();

    SNSEventHandler getEventHandler();

    SNSIconHandler getIconHandler();

    SNSInstructionsViewHandler getInstructionsViewHandler();

    Locale getLocale();

    String getPackageName();

    SNSModule getPluggedModule(String str);

    Map<String, SNSDocumentDefinition> getPreferredDocumentsDefinitions();

    Map<String, String> getSettings();

    SNSSDKState getState();

    SNSStateChangedHandler getStateChangedHandler();

    List<SNSSupportItem> getSupportItems();

    TokenExpirationHandler getTokenExpirationHandler();

    SNSUrlHandler getUrlHandler();

    String getVersion();

    int getVersionCode();

    String getVersionName();

    boolean isDebug();

    boolean isModuleAvailable(String str);

    void setSupportItems(List<SNSSupportItem> list);
}
