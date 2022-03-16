package org.boticordjava.api.entity.servers;

import java.util.List;

public class ServerInfo {

    private String id;
    private String shortCode;
    private String status;
    private List<String> links;
    private Bot bot;
    private ServerInformation information;

    public String getId() {
        return id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getLinks() {
        return links;
    }

    public Bot getBot() {
        return bot;
    }

    public ServerInformation getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "id='" + id + '\'' +
                ", shortCode='" + shortCode + '\'' +
                ", status='" + status + '\'' +
                ", links=" + links +
                ", bot=" + bot.toString() +
                ", information=" + information.toString() +
                '}';
    }
}
