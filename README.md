# mimicFlickr

##Run app
start app

```
mvn spring-boot:run
```


upload data

```
curl -X PUT -H "Content-Type: application/json" --data @testBase64.json http://localhost:8080/photo/list
```


view over web interface - <http://localhost:8080/>


##Information
json format

```
[
{"name":"", "description":"", "base64":""}
,{"name":"", "description":"", "base64":""}
...
]
```
