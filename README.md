# URL shortener

## Challenge

Your challenge will be to implement a service that allows you to shorten long URLs to make them more compact and easier to read.
to share.

## Example

Your service receives a call to shorten a URL.

**[POST]** `{{host}}/shorten-url`

```json
{
 "url": "https://www.google.com/"
}
```

And returns a JSON with the shortened URL:

```
HTTP/1.1 200 OK
```

```json
{
 "url": "https://xxx.com/DXB6V"
}
```

## Requirements

- The URL shortener takes a long URL as an initial parameter.
- The shortening will consist of a minimum of 05 and a maximum of 10 characters.
- Only letters and numbers are allowed in shortening.
- The shortened URL will be saved in the database with an expiration date (you can choose the desired duration).
- When receiving a call to the shortened URL `https://xxx.com/DXB6V`, you must redirect to the
  Original URL saved in the database. If the URL is not found in the database, return the code
  status `HTTP 404 (Not Found)`.


# Application installation

First, clone the repository:
```
git clone https://github.com/daniellimadev/URLShortener.git
```
Once done, access the project:
```
cd URLShortener
```
Access the folder:
```
cd docker
```
To start the application with a database in Docker, run the command below:
```
docker-compose up -d
```
You need to compile the code and download the project dependencies:
```
mvn clean package
```
Once this step is complete, let's start the application:
```
mvn spring-boot:run
```

# Application setup with docker

## Prerequisite

Before running the application, you must ensure that the following dependencies are correctly installed:

```
Java 21
Docker
Maven
```

# To test the Endpoints follow the parameters below:

To save:

POST: http://localhost:8080/urlShortener

No parameters in JSON

```
{
    "urlOriginal" : "https://www.google.com/"
}
```

The POST return:
```
{
    "id": 1,
    "fullUrl": "https://www.google.com/",
    "urlShortened": "http://localhost:8080/r/8207q",
    "urlCreatedIn": "2024-07-19T09:57:04.3760857"
}
```

Example to get the shortened URL, just get the `"urlShortened"` parameter: `"http://localhost:8080/r/8207q"`

<h3>Author</h3>

<a href="https://www.linkedin.com/in/danielpereiralima/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/96916005?v=4" width="100px;" alt=""/>

Made by Daniel Pereira Lima 👋🏽 Contact!

[![Linkedin Badge](https://img.shields.io/badge/-Daniel-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/danielpereiralima/)](https://www.linkedin.com/in/danielpereiralima/)