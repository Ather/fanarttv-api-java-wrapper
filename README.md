# fanarttv-api-java-wrapper

Fanart.TV API Wrapper written in Java.

Currently supported [Fanart.TV API](http://docs.fanarttv.apiary.io/) version: `3.0`

## Usage
Dependencies (specified in pom.xml):
* [gson-2.8.1](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.1)
* [httpclient-4.5.3](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.5.3)
* [httpcore-4.4.6](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore/4.4.6)
* [commons-logging-1.2](https://mvnrepository.com/artifact/commons-logging/commons-logging/1.2)
* [commons-codec-1.9](https://mvnrepository.com/artifact/commons-codec/commons-codec/1.9)

It is recommended that you pass your own personal API key to the wrapper,
which can be generated [here](https://fanart.tv/get-an-api-key/) after logging into the website.

## Examples:

```java
try {
  // This uses the default project API Key,
  // But it is recommended to pass your own personal API Key.
  FanartTv fanartTv = new FanartTv();
  Movie movie = fanartTv.movies().get(330459).execute();
  System.out.println(movie.getName());
 } catch (IOException e) {
  e.printStackTrace();
 }
```
```java
 try {
  // You may also pass your own project API key and personal API key.
  // getters and setters exist for the keys though, so you can also modify
  // them yourself if a specific constructor doesn't exist.
  FanartTv fanartTv = new FanartTv(PROJECT_API_KEY, PERSONAL_API_KEY);
  List<LatestTV> tvUpdates = fanartTv.tv().latest().get().execute();
  System.out.println(tvUpdates.get(0).getTotalImages());
 } catch (IOException e) {
  e.printStackTrace();
 }
```
```java
 try {
  FanartTv fanartTv = new FanartTv(PERSONAL_API_KEY);
  List<LatestTV> tvUpdates = fanartTv.tv().latest().get().execute();
  System.out.println(tvUpdates.get(0).getTotalImages());
 } catch (IOException e) {
  e.printStackTrace();
 }
 ```
 
 ## License
 Licensed with Apache 2.0
