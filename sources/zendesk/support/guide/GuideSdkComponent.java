package zendesk.support.guide;

interface GuideSdkComponent {
    void inject(GuideSdkDependencyProvider guideSdkDependencyProvider);

    void inject(HelpCenterActivity helpCenterActivity);

    void inject(HelpCenterFragment helpCenterFragment);

    void inject(ViewArticleActivity viewArticleActivity);
}
