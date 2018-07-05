# Importer

Easily import data from permissions or economy plugins using the Importer API.

<br />

Maven repository and dependency:
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io/</url>
</repository>
```
```xml
<dependency>
  <groupId>com.github.bys1</groupId>
  <artifactId>importer</artifactId>
  <version>1.0</version>
  <scope>provided</scope>
</dependency>
```

<br />

**ImporterCallback** <br />
The Importer API works with callbacks. The ImporterCallback is used to retrieve all data.
To create an ImporterCallback object, create a class extending ImporterCallback that implements the method `onCall`.
The ImporterCallback constructor has a constructor with the boolean `async`. This is used to determine whether the `onCall` method should be run on the main thread or on an asynchronous thread. If you construct the ImporterCallback without any arguments, `async` will default to `false` which means that the `onCall` method will be invoked on the main thread.
Example:
```java
final ImporterCallback<String> callback = new ImporterCallback<String>() {
  protected final void onCall(String result) {
    // ...
  }
}
```

As of Importer v1.1, all methods using `ImporterCallback<T>` will now also accept a `Consumer<T>`. The methods accepting the `Consumer<T>` are implemented as `default` methods in the `PermissionsImporter` and `EconomyImporter` interfaces and will first invoke `ImporterCallback#fromConsumer` to get an `ImporterCallback` and then pass that to the original Importer method. The use of a `Consumer<T>` will allow you to use lambda expressions and method references.
Note: all Consumers will be called on the Bukkit main thread. If you need the callback to be run asynchronously, you will need to use an ImporterCallback and pass `true` to the `async` parameter in the constructor.

<br />

**PermissionsImporter** <br />
The PermissionsImporter (*eu.taigacraft.importer.permissions*) can import data from permission plugins.
<br />
Get a PermissionsImporter instance:
```java
final PermissionsImporter importer = PermissionsImporter.get();
```
<br />
If you own a permissions plugin, you can register your own PermissionsImporter to Importer. Create a class that implements PermissionsImporter and register it using the following method:

```java
// plugin is the class that extends JavaPlugin
// importer is the class that implements PermissionsImporter
// Be aware of ClassNotFoundErrors when the Importer plugin isn't loaded!
if (plugin.getServer().getPluginManager().getPlugin("Importer") != null) {
  PermissionsImporter.register(plugin, importer);
}
```
*Note that it might be useful to add a softdepend to Importer in your plugin.yml file.*
<br />
<br />
PermissionsImporter methods:

```java
public void getRank(OfflinePlayer player, ImporterCallback<String> callback);
```
```java
public void getRanks(OfflinePlayer player, ImporterCallback<List<String>> callback);
```
```java
public void getPrefix(OfflinePlayer player, ImporterCallback<String> callback);
```
```java
public void getPrefix(OfflinePlayer player, String worldname, ImporterCallback<String> callback);
```
```java
public void getPrefix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback);
```
```java
public void getSuffix(OfflinePlayer player, ImporterCallback<String> callback);
```
```java
public void getSuffix(OfflinePlayer player, String worldname, ImporterCallback<String> callback);
```
```java
public void getSuffix(OfflinePlayer player, String worldname, String ladder, ImporterCallback<String> callback);
```
```java
public void hasPermission(OfflinePlayer player, String permission, ImporterCallback<Boolean> callback);
```
```java
public void hasPermission(OfflinePlayer player, String permission, String worldname, ImporterCallback<Boolean> callback);
```

**EconomyImporter**
The EconomyImporter (*eu.taigacraft.importer.economy*) can import data from economy plugins.
<br />
Get an EconomyImporter instance:
```java
final EconomyImporter importer = EconomyImporter.get();
```
<br />
If you own an economy plugin, you can register your own EconomyImporter to Importer. Create a class that implements EconomyImporter and register it using the following method:

```java
// plugin is the class that extends JavaPlugin
// importer is the class that implements EconomyImporter
// Be aware of ClassNotFoundErrors when the Importer plugin isn't loaded!
if (plugin.getServer().getPluginManager().getPlugin("Importer") != null) {
  EconomyImporter.register(plugin, importer);
}
```
*Note that it might be useful to add a softdepend to Importer in your plugin.yml file.*
<br />
<br />
PermissionsImporter methods:

```java
public void getBalance(OfflinePlayer player, ImporterCallback<Double> callback);
```
