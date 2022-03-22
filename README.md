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
	<version>v2.8</version>
</dependency>

```

## Examples

### Get All Comments by bot ID

```java
public static void main(String[] args) {

    BotiCordAPI api = new BotiCordAPIImpl("YOUR_TOKEN", "BOT_ID");
    Comments[] comments = api.getBotComments();

    for (int i = 0; i < comments.length; i++) {
    System.out.println(comments[i].getText());
    System.out.println(comments[i].getUserId());
   }
}
```

### Update Stats

```java
public static void main(String[] args) {

    BotiCordAPI api = new BotiCordAPIImpl("YOUR_TOKEN", "BOT_ID");

    int servers = ...; // the server count
    int shards = ...; // shards count
    int users = ...; // the amount of users

    api.setStats(servers, shards, users);
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