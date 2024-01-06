package org.boticordjava.api.entity.bot.stats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BotStats {

    private Integer members;
    private Integer guilds;
    private Integer shards;
}