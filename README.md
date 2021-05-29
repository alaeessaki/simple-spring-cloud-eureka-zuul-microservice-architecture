# simple spring-cloud microservice application

A simple microservice application with spring cloud, eurika for registry and ZUUL as a proxy server.

## Usage

```
git clone https://github.com/alaeessaki/simple-spring-cloud-eureka-zuul-microservice-architecture.git
```

Open these projects in a workspace.


### Service config

`Service config` is an application that holds all the microservices configuration.  

in the `application.properties` you'll find `spring.cloud.config.server.git.uri=file://${user.home}/cloud-conf`.  This means that all the configuration are in a git folder.

> in my case i used a local git folder, but you can change it to a remote git folder

In the folder you should create for each application a configuration file with the same name of the application specified in `bootstrap.properties`.

for example `company-service.properties` : <br/>

```
yParam=555
me=alae@essaki.net
server.port = 8081
```

### Service register (EUREKA Server) 

Create a configuration file called `eureka-service.properties` in the git configuration folder with the following configuration :

```
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

### Proxy Server (ZUUL)

For the proxy server i used a default port `8080` but you can change it

---

Now you can find EURIKA server in `http://localhost:<port>/` which in my case : `http://localhost:8761/`

And with the use of the zuul proxy, all the microservice with all the zones can be found in : 

`http://localhost:<zuul-port>/<service-name>` <br/>

for example : <br/>

`http://localhost:8080/movie-service/movies`

