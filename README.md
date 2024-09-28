<img width="560" src="https://cdn.boticord.top/internal/github/boticord-java.svg" alt="boticord-java">

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
<version>v5.3</version>
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

### WebSocket

```java
public class Main {
    static class Comment extends ListenerAdapter {
        @Override
        public void onCommentEvent(@NotNull NotificationData event) {
            System.out.println("event: " + event.getType());
        }
    }

    public static void main(String[] args) {
        BoticordWebSocket boticordWebSocket = new BoticordWebSocket("token");
        boticordWebSocket.addListener(new Comment());
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
