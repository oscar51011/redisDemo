# Redis 研究

撰寫 springboot 整合 redis 服務 POC

注意事項:
- 專案有Lombok，如要使用需要在 IDE 底下安裝 lombok.jar
- 開啟一台 VM 並使用 docker 安裝 redis ( application.properties 要跟著調整 )
- 可以安裝 redisInsight ( redis CLI ) 來測試使用 

Reference:
- [redis](https://redis.io/)
- [docker-redis](https://hub.docker.com/_/redis)
- [spring-data-redis](https://docs.spring.io/spring-data/redis/docs/current/reference/html/#redis:template)