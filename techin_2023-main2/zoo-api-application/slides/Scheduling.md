@EnableScheduling

# Schedulling
technique for routine jobs

- annotation: @EnableScheduling
- annotation on method: @Scheduled
- option with fixed delay: `(fixedDelay = 1000)`
- option with fixed rate: `(fixedRate = 1000)`
- option with Cron expression: `(cron = "0 15 10 15 * ?")`. Doc: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/support/CronExpression.html
- parameterized configuration: @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")


### Additional options for parallel execution
- @EnableAsync
- @Async over method name

- option to change rate dynamically during application runtime