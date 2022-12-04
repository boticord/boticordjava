<div align="center ">

<p></p>
    <a href="https://boticord.top"><img src="https://megoru.ru/boticordapi2.png"  alt="boticord.js"/></a>
<p>
    <a href="https://discord.gg/hkHjW8a"><img src="https://img.shields.io/discord/722424773233213460?color=7289da&label=Discord&logo=discord&logoColor=white" alt="Online"></a>
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
<version>v4.0</version>
</dependency>

```

## Examples

### Get All Comments by bot ID

```java
public class Main {
    public static void main(String[] args) {
        BotiCordAPI api = new BotiCordAPI.Builder()
                .tokenEnum(TokenEnum.BOT)
                .token("319bbc0e-0743-4d9c-872b-e547d5e8fd0d")
                .build();

        try {
            Comments[] comments = api.getBotComments("808277484524011531");

            for (int i = 0; i < comments.length; i++) {
                System.out.println(comments[i].getText());
            }
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
                .tokenEnum(TokenEnum.BOT)
                .token("319bbc0e-0743-4d9c-872b-e547d5e8fd0d")
                .build();

        try {
            Result result = api.setStats(500, 1, 2000);
            System.out.println(result);
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
4. [okhttp](https://github.com/square/okhttp)

## Links

* [BotiCord](https://boticord.top)
* [Support](https://boticord.top/discord)