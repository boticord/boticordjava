package org.boticordjava.api.entity.servers;

import java.util.ArrayList;
import java.util.List;

public class ServerShortLinks {

    List<String> list;

    public List<String> getList() {
        return list;
    }

    public ServerShortLinks(List<String> list) {
        this.list = new ArrayList<>(list);
    }
}
