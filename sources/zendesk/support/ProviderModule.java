package zendesk.support;

import java.util.Locale;
import zendesk.core.AuthenticationProvider;
import zendesk.core.BlipsProvider;
import zendesk.core.RestServiceProvider;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

class ProviderModule {
    public ProviderStore provideProviderStore(HelpCenterProvider helpCenterProvider, RequestProvider requestProvider, UploadProvider uploadProvider) {
        return new ZendeskProviderStore(helpCenterProvider, requestProvider, uploadProvider);
    }

    public RequestProvider provideRequestProvider(SupportSettingsProvider supportSettingsProvider, AuthenticationProvider authenticationProvider, ZendeskRequestService zendeskRequestService, RequestStorage requestStorage, RequestSessionCache requestSessionCache, ZendeskTracker zendeskTracker, SupportSdkMetadata supportSdkMetadata, SupportBlipsProvider supportBlipsProvider) {
        return new ZendeskRequestProvider(supportSettingsProvider, zendeskRequestService, authenticationProvider, requestStorage, requestSessionCache, zendeskTracker, supportSdkMetadata, supportBlipsProvider);
    }

    public SupportSettingsProvider provideSdkSettingsProvider(SettingsProvider settingsProvider, Locale locale, ZendeskLocaleConverter zendeskLocaleConverter) {
        return new ZendeskSupportSettingsProvider(settingsProvider, zendeskLocaleConverter, locale);
    }

    public SupportBlipsProvider provideSupportBlipsProvider(BlipsProvider blipsProvider) {
        return new ZendeskSupportBlipsProvider(blipsProvider);
    }

    public SupportModule provideSupportModule(RequestProvider requestProvider, UploadProvider uploadProvider, HelpCenterProvider helpCenterProvider, SupportSettingsProvider supportSettingsProvider, RestServiceProvider restServiceProvider, SupportBlipsProvider supportBlipsProvider, ZendeskTracker zendeskTracker, ArticleVoteStorage articleVoteStorage) {
        return new SupportModule(requestProvider, uploadProvider, helpCenterProvider, supportSettingsProvider, supportBlipsProvider, restServiceProvider.getMediaOkHttpClient(), zendeskTracker, articleVoteStorage);
    }

    public UploadProvider provideUploadProvider(ZendeskUploadService zendeskUploadService) {
        return new ZendeskUploadProvider(zendeskUploadService);
    }

    public ZendeskLocaleConverter provideZendeskLocaleConverter() {
        return new ZendeskLocaleConverter();
    }
}
