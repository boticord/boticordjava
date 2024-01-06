package org.boticordjava.api.entity.bot.stats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.boticordjava.api.impl.APIObject;
import org.boticordjava.api.impl.APIRequestData;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BotStats implements APIObject, APIRequestData  {

    private Integer members;
    private Integer guilds;
    private Integer shards;
}