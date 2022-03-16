# boticordjava
An API wrapper for BotiCord API written in Java by (@megoru)

### Add to MAVEN
https://jitpack.io/#megoRU/boticordjava

```
<repositories>
 <repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
 </repository>
</repositories>

<dependency>
	<groupId>com.github.megoRU</groupId>
	<artifactId>boticordjava</artifactId>
	<version>e5e609fae4</version>
</dependency>

```

## Examples

**Get All Comments by bot ID**

```
BotiCordAPI api = new BotiCordAPIAPIImpl("YOUR_TOKEN", "BOT_ID");

Comments[] comments = api.getBotComments();

for (int i = 0; i < comments.length; i++) {
System.out.println(comments[i].getText());
System.out.println(comments[i].getUserId());
}
```

**Update Stats**

```
BotiCordAPI api = new BotiCordAPIAPIImpl("YOUR_TOKEN", "BOT_ID");

int servers = ...; // the server count
int shards = ...; // shards count
int users = ...; // the amount of users

api.setStats(servers, shards, users);
```

##Links

* [BotiCord](https://boticord.top/)
* [Support](https://boticord.top/discord)
