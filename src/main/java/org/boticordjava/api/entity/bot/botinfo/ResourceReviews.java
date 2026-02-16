package org.boticordjava.api.entity.bot.botinfo;

import lombok.Getter;
import lombok.Setter;
import org.boticordjava.api.entity.users.profile.UserProfile;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResourceReviews {

    private String id;
    private UserProfile author;
    private String content;
    private LocalDateTime createdDate;
    private String modReply;
    private int rating;
}