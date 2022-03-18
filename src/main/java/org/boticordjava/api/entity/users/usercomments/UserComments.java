package org.boticordjava.api.entity.users.usercomments;

import java.util.List;

public class UserComments {

    List<BotComments> bots;
    List<ServerComments> servers;

    public List<BotComments> getBots() {
        return bots;
    }

    public List<ServerComments> getServers() {
        return servers;
    }
}
