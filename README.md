<img width="560" src="https://cdn.boticord.top/internal/github/boticord-java.svg" alt="boticord-java">

# BotiCordJava

[![JitPack](https://jitpack.io/v/boticord/boticordjava.svg)](https://jitpack.io/#boticord/boticordjava)

Java API wrapper for [BotiCord](https://boticord.top), created by [@megoRU](https://github.com/megoRU).

---

## 📦 Installation (Maven)

Add JitPack repository and dependency:

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
    <version>6.1.3</version>
</dependency>
```

---

## 🚀 Examples

### 📄 Get All Comments by Bot ID

```java
BotiCordAPI api = new BotiCordAPI.Builder()
        .token("your-token")
        .build();

List<UsersCommentSearch> comments = api.searchUserComments("808277484524011531");
comments.forEach(comment -> System.out.println(comment.getContent()));
```

### 📊 Update Stats

```java
BotiCordAPI api = new BotiCordAPI.Builder()
        .token("your-token")
        .build();

BotStats botStats = new BotStats(200, 4, 1);
api.setBotStats("974297735559806986", botStats);
```

### 🔔 WebSocket Notifications

```java
public class CommentListener extends ListenerAdapter {
    @Override
    public void onCommentEvent(@NotNull NotificationData event) {
        System.out.println("Event type: " + event.getType());
    }
}

public class Main {
    public static void main(String[] args) {
        BoticordWebSocket socket = new BoticordWebSocket("your-token");
        socket.addListener(new CommentListener());
    }
}
```

---

## 📚 Dependencies

* [Gson](https://github.com/google/gson)
* [Apache HttpClient](https://github.com/apache/httpcomponents-client)
* [JSON-java](https://github.com/stleary/JSON-java)
* [OkHttp](https://github.com/square/okhttp)

---

## 🔗 Links

* 🌐 [BotiCord](https://boticord.top)
* 💬 [Support Server](https://boticord.top/discord)

---
