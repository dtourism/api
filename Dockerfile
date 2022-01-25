#导入需要使用的镜像
FROM openjdk:8-jdk-alpine

# 维护者信息
MAINTAINER foxcat fayfoxcat@gmail.com

# 用于为镜像添加元数据：使用LABEL指定元数据时，一条LABEL指定可以指定一或多条元数据，指定多条元数据时不同元数据之间通过空格分隔。
# 推荐将所有的元数据通过一条LABEL指令指定，以免生成过多的中间镜像。
LABEL version="1.0" description="后端服务器" by="faycat"

# 指定运行容器时的用户名或 UID，后续的 RUN 也会使用指定用户。使用USER指定用户时，可以使用用户名、UID或GID，或是两者的组合。
# 当服务不需要管理员权限时，可以通过该命令指定运行用户。并且可以在之前创建所需要的用户，Dockerfile中其后的命令RUN、CMD、ENTRYPOINT都将使用该用户。
# 镜像构建完成后，通过docker run运行容器时，可以通过-u参数来覆盖所指定的用户。
USER fayfox

# 用于指定持久化目录：一个卷可以存在于一个或多个容器的指定目录，该目录可以绕过联合文件系统，并具有以下功能：卷可以容器间共享和重用、
# 容器并不一定要和其它容器共享卷、修改卷后会立即生效、对卷的修改不会对镜像产生影响、卷会一直存在，直到没有任何容器在使用它
VOLUME ["/tmp"]

# 构建镜像时执行的命令
RUN jps -l

# 用于指定传递给构建运行时的变量
ARG JAR_FILE

# 用于设置镜像触发器：当所构建的镜像被用做其它镜像的基础镜像，该镜像中的触发器将会被钥触发
# ONBUILD

# 设置环境变量
#ENV

# 功能类似ADD，但是是不会自动解压文件，也不能访问网络资源
# COPY

# 将本地文件添加到容器中：tar类型文件会自动解压(网络压缩资源不会被解压)，可以访问网络资源，类似wget
ADD /target/api.jar /home/app/back/app.jar

# 构建镜像时执行的命令:例如解压nginx、mysql等
# RUN指令创建的中间镜像会被缓存，并会在下次构建中使用。如果不想使用这些缓存镜像，可以在构建时指定--no-cache参数
# RUN

# 工作目录:通过WORKDIR设置工作目录后，Dockerfile中其后的命令RUN、CMD、ENTRYPOINT、ADD、COPY等命令都会在该目录下执行。
# 在使用docker run运行容器时，可以通过-w参数覆盖构建时所设置的工作目录.
WORKDIR /home/app/back/

# 指定于外界交互的端口
# EXPOSE 8888

# 构建容器后调用，也就是在容器启动时才进行调用。
# CMD不同于RUN，CMD用于指定在容器启动时所要执行的命令，而RUN用于指定镜像构建时所要执行的命令。
# CMD

# 配置容器，使其可执行化。配合CMD可省去"application"，只使用参数。ENTRYPOINT与CMD非常类似，
# 不同的是通过docker run执行的命令不会覆盖ENTRYPOINT，而docker run命令中指定的任何参数，都会被当做参数再次传递给ENTRYPOINT。
# Dockerfile中只允许有一个ENTRYPOINT命令， 多指定时会覆盖前面的设置，而只执行最后的ENTRYPOINT指令
ENTRYPOINT ["nohup","java", "-jar", "/app.jar","&"]