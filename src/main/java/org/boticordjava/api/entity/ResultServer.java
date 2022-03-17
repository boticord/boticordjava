package org.boticordjava.api.entity;

//TODO доделать
public class ResultServer {

    private String serverID;
    private int up;
    private boolean updated;
    private int bumps;
    private boolean boost;
    private boolean upSuccessfully;
    private long timeToNextUpInMs;
    //:white_check_mark: Серверу было успешно добавлено **2 UP**!\n\nℹ️Вы также можете оставить отзыв о сервере!\n> https://myservers.me/s/boticord
    private String message;

    public String getServerID() {
        return serverID;
    }

    public int getUp() {
        return up;
    }

    public boolean isUpdated() {
        return updated;
    }

    public int getBumps() {
        return bumps;
    }

    public boolean isBoost() {
        return boost;
    }

    public boolean isUpSuccessfully() {
        return upSuccessfully;
    }

    public long getTimeToNextUpInMs() {
        return timeToNextUpInMs;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ResultServer{" +
                "serverID='" + serverID + '\'' +
                ", up=" + up +
                ", updated=" + updated +
                ", bumps=" + bumps +
                ", boost=" + boost +
                ", upSuccessfully=" + upSuccessfully +
                ", timeToNextUpInMs=" + timeToNextUpInMs +
                ", message='" + message + '\'' +
                '}';
    }
}
