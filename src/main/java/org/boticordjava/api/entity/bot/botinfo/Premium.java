package org.boticordjava.api.entity.bot.botinfo;

public class Premium {

    private boolean active;
    private String splashURL;
    private boolean autoFetch;
    private String bannerURL;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getSplashURL() {
        return splashURL;
    }

    public void setSplashURL(String splashURL) {
        this.splashURL = splashURL;
    }

    public boolean isAutoFetch() {
        return autoFetch;
    }

    public void setAutoFetch(boolean autoFetch) {
        this.autoFetch = autoFetch;
    }

    public String getBannerURL() {
        return bannerURL;
    }

    public void setBannerURL(String bannerURL) {
        this.bannerURL = bannerURL;
    }
}