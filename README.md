<div align="center ">

<p>
    <a href="https://boticord.top"><img src="https://megoru.ru/images/boticord/boticordapi.png"  alt="boticord.js"/></a>
</p>

</div>

# BotiCordJava

An API wrapper for https://boticord.top/ written in Java by @megoRU

### Maven

https://jitpack.io/#megoRU/boticordjava

```xml

<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
<groupId>com.github.megoRU</groupId>
<artifactId>boticordjava</artifactId>
<version>v5.1</version>
</dependency>

```

## Examples

### Get All Comments by bot ID

```java
public class Main {
    public static void main(String[] args) {
        BotiCordAPI api = new BotiCordAPI.Builder()
                .token("eyJhbGciOiJIUzI1NiIsInR5cCI****.")
                .build();

        try {
            List<UsersCommentSearch> commentBotSearchList = api.searchUserComments("808277484524011531");
            commentBotSearchList.forEach(g -> System.out.println(g.getContent()));
        } catch (UnsuccessfulHttpException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### Update Stats

```java
public class Main {
    public static void main(String[] args) {
        BotiCordAPI api = new BotiCordAPI.Builder()
                .token("eyJhbGciOiJIUzI1NiIsInR5cCI****.")
                .build();

        try {
            BotStats botStats = new BotStats(200, 4, 1);
            api.setBotStats("974297735559806986", botStats);
        } catch (UnsuccessfulHttpException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

### WebHooks

Note: BotiCord supports only `HTTPS` you need proxy `ip:port` to `Apache`/`nginx` with **HTTPS**

```java
public class Main {
    static class Comment extends ListenerAdapter {
        @Override
        public void onCommentEvent(@NotNull CommentAction event) {
            System.out.println(event.getType()); //delete_bot_comment
        }
    }

    static class ServerBumpEvent extends ListenerAdapter {
        @Override
        public void onServerBumpEvent(@NotNull ServerBump event) {
            System.out.println(event.getType()); //new_server_bump
        }
    }

    public static void main(String[] args) {
        WebSocket webSocket = new WebSocket("3fbf63cefsfs2321a", null, 8080);
        webSocket.addListener(new Comment(), new ServerBumpEvent());
    }
}
```

## Dependencies

1. [Gson](https://github.com/google/gson)
2. [Apache HttpClient](https://github.com/apache/httpcomponents-client)
3. [JSON-java](https://github.com/stleary/JSON-java)
4. [OkHttp](https://github.com/square/okhttp)

## Links

* [BotiCord](https://boticord.top)
* [Support](https://boticord.top/discord)
