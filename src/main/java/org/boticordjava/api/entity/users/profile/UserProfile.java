package org.boticordjava.api.entity.users.profile;

public class UserProfile {

    private String id;
    private String status;
    private String badge;
    private String shortCode;
    private String site;
    private String vk;
    private String steam;
    private String youtube;
    private String twitch;
    private String git;

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getBadge() {
        return badge;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getSite() {
        return site;
    }

    public String getVk() {
        return vk;
    }

    public String getSteam() {
        return steam;
    }

    public String getYoutube() {
        return youtube;
    }

    public String getTwitch() {
        return twitch;
    }

    public String getGit() {
        return git;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                "\nstatus: " + status +
                "\nbadge: " + badge +
                "\nshortCode " + shortCode +
                "\nsite: " + site +
                "\nvk: " + vk +
                "\nsteam: " + steam +
                "\nyoutube: " + youtube +
                "\ntwitch: " + twitch +
                "\ngit: " + git;
    }
}
