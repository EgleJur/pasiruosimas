# Configuration Properties

- annotation: @ConfigurationProperties
- @EnableConfigurationProperties(<class name>.class) in Boot Application config
- automatically binds properties by defined prefix from configuration file (.yaml or .properties)


### Injecting single value
- use @Value annotation. Ex.: ``RoomService``