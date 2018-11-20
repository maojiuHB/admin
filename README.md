
# 视网科技后台模版

## 开发

    ./mvnw spring-boot:run -P dev

## 开发组件启动

    docker-compose -f src/main/docker/mysql.yml up -d
    docker-compose -f src/main/docker/mysql.yml down

## docker image 构建
    ./mvnw package -Pprod jib:dockerBuild

## 开发记录

#### 20181020 171403 (limy)
* 集成
