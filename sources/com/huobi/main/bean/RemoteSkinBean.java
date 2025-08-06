package com.huobi.main.bean;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class RemoteSkinBean implements Serializable {
    private String end_timestamp;
    private RemoteLaunchBean launch;
    private String start_timestamp;
    private RemoteTabBarBean tabbar;

    @Keep
    public static class RemoteLaunchBean implements Serializable {
        private LaunchBean background;

        /* renamed from: cn  reason: collision with root package name */
        private RemoteLaunchBean f77697cn;
        private LaunchBean festival_layer_1;
        private LaunchBean festival_layer_2;
        private LaunchBean logo;
        private RemoteLaunchBean other;

        @Keep
        public static class LaunchBean implements Serializable {
            private String image;
            private String json;

            public String getImage() {
                return this.image;
            }

            public String getJson() {
                return this.json;
            }

            public void setImage(String str) {
                this.image = str;
            }

            public void setJson(String str) {
                this.json = str;
            }
        }

        public LaunchBean getBackground() {
            return this.background;
        }

        public RemoteLaunchBean getCn() {
            return this.f77697cn;
        }

        public LaunchBean getFestival_layer_1() {
            return this.festival_layer_1;
        }

        public LaunchBean getFestival_layer_2() {
            return this.festival_layer_2;
        }

        public LaunchBean getLogo() {
            return this.logo;
        }

        public RemoteLaunchBean getOther() {
            return this.other;
        }

        public void setBackground(LaunchBean launchBean) {
            this.background = launchBean;
        }

        public void setCn(RemoteLaunchBean remoteLaunchBean) {
            this.f77697cn = remoteLaunchBean;
        }

        public void setFestival_layer_1(LaunchBean launchBean) {
            this.festival_layer_1 = launchBean;
        }

        public void setFestival_layer_2(LaunchBean launchBean) {
            this.festival_layer_2 = launchBean;
        }

        public void setLogo(LaunchBean launchBean) {
            this.logo = launchBean;
        }

        public void setOther(RemoteLaunchBean remoteLaunchBean) {
            this.other = remoteLaunchBean;
        }
    }

    @Keep
    public static class RemoteTabBarBean implements Serializable {
        private TabBarBean light;
        private TabBarBean night;

        @Keep
        public static class TabBarBean implements Serializable {
            private TabBarItem account;
            private String background;
            private TabBarItem balance;
            private TabBarItem contract;
            private TabBarItem home;
            private TabBarItem market;
            private TabRocketItem rocket;
            private TabBarItem trade;

            @Keep
            public static class TabBarItem implements Serializable {
                private String icon;
                private String icon_selected;
                private String title_color;
                private String title_color_selected;

                public String getIcon() {
                    return this.icon;
                }

                public String getIcon_selected() {
                    return this.icon_selected;
                }

                public String getTitle_color() {
                    return this.title_color;
                }

                public String getTitle_color_selected() {
                    return this.title_color_selected;
                }

                public void setIcon(String str) {
                    this.icon = str;
                }

                public void setIcon_selected(String str) {
                    this.icon_selected = str;
                }

                public void setTitle_color(String str) {
                    this.title_color = str;
                }

                public void setTitle_color_selected(String str) {
                    this.title_color_selected = str;
                }
            }

            @Keep
            public static class TabRocketItem implements Serializable {
                private String rocket_bg;
                private String rocket_icon;

                public String getRocket_bg() {
                    return this.rocket_bg;
                }

                public String getRocket_icon() {
                    return this.rocket_icon;
                }

                public void setRocket_bg(String str) {
                    this.rocket_bg = str;
                }

                public void setRocket_icon(String str) {
                    this.rocket_icon = str;
                }
            }

            public TabBarItem getAccount() {
                return this.account;
            }

            public String getBackground() {
                return this.background;
            }

            public TabBarItem getBalance() {
                return this.balance;
            }

            public TabBarItem getContract() {
                return this.contract;
            }

            public TabBarItem getHome() {
                return this.home;
            }

            public TabBarItem getMarket() {
                return this.market;
            }

            public TabRocketItem getRocket() {
                return this.rocket;
            }

            public TabBarItem getTrade() {
                return this.trade;
            }

            public void setAccount(TabBarItem tabBarItem) {
                this.account = tabBarItem;
            }

            public void setBackground(String str) {
                this.background = str;
            }

            public void setBalance(TabBarItem tabBarItem) {
                this.balance = tabBarItem;
            }

            public void setContract(TabBarItem tabBarItem) {
                this.contract = tabBarItem;
            }

            public void setHome(TabBarItem tabBarItem) {
                this.home = tabBarItem;
            }

            public void setMarket(TabBarItem tabBarItem) {
                this.market = tabBarItem;
            }

            public void setRocket(TabRocketItem tabRocketItem) {
                this.rocket = tabRocketItem;
            }

            public void setTrade(TabBarItem tabBarItem) {
                this.trade = tabBarItem;
            }
        }

        public TabBarBean getLight() {
            return this.light;
        }

        public TabBarBean getNight() {
            return this.night;
        }

        public void setLight(TabBarBean tabBarBean) {
            this.light = tabBarBean;
        }

        public void setNight(TabBarBean tabBarBean) {
            this.night = tabBarBean;
        }
    }

    public String getEnd_timestamp() {
        return this.end_timestamp;
    }

    public RemoteLaunchBean getLaunch() {
        return this.launch;
    }

    public String getStart_timestamp() {
        return this.start_timestamp;
    }

    public RemoteTabBarBean getTabbar() {
        return this.tabbar;
    }

    public void setEnd_timestamp(String str) {
        this.end_timestamp = str;
    }

    public void setLaunch(RemoteLaunchBean remoteLaunchBean) {
        this.launch = remoteLaunchBean;
    }

    public void setStart_timestamp(String str) {
        this.start_timestamp = str;
    }

    public void setTabbar(RemoteTabBarBean remoteTabBarBean) {
        this.tabbar = remoteTabBarBean;
    }
}
