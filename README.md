# Telemetry Server

This project gives applications a simple and easy way to record telemetry data to a central easy-to-access location.  It is simple to set up and great for a single application, or a collection of applications.  Applications can call the API services to insert key-value pairs of data into a database.

> This project is currently a work-in-progress, see #Todo below for details
> 

## Setup

Before this project can be used, some setup is required.
- Set up a remote SQL database.
- Once you have a remote database configured, update the `application.properties` file with the database info.
- Deploy the project to a cloud of your choice.

## How to Use

Once you have deployed the project, your applications will be able to use it to save telemetry data.  To allow app to use the telemetry server, first register manually with a username and password.  Once you have registered, configure your application to login, then it will be able to make calls to save telemetry.

- Register as a user by manually calling the `register` service using Postman, a cURL command, or a different tool of your choice, providing a username and password.
- Have your application login by calling the `login` service providing your username and password, and save the token that is returned in the response.
- Your application can now call the `entry` service as many times as needed with an app specific id, a key, and a value.  Be sure to put the token from the login service call in the header of any calls to the entry service, or they will fail.

## API Endpoints

* POST `/register` Registers a new user with the provided username and password
* POST`/login` Returns a token from the username and password, for authenticating the `/entry` service 
* POST `/entry`  Adds a new entry in the database with the provided app id, key, value, and optional correlation id


## Database Tables

### Entry Table

The entry table has columns for an app id, a name, a value, and a correlation id.  The entry id and created date are automatically added.  

| id | app_id | name | value | correlation_id | created_date |
| ----------- | ----------- | ----------- |  ----------- |  ----------- | ----------- |
| 1 | myDesktopApp | numberOfTimesOpened | 1 | user123 | 2022-06-01 16:42:26.865000 |

### User Table

The user table has columns for the username, password, and role for each user.  User id and creation date are automatically added.

| id | username | password | role | created_date |
| ----------- | ----------- | ----------- |  ----------- |  ----------- |
| 1 | myUsername | mySecretPassword | user | 2022-06-01 16:31:12.723000 |

## Entries
An entry consists of an app ID, a name, a value, and an optional correlation ID.  Created and last modified dates are automatically added to each entry.  See examples below.

* `app_id` A unique identifier for the application sending telemetry
* `name` A unique key to identify the value
* `value` The value to save
* `correlation_id` A unique string to associate entries together.  Optional

| *app_id | *name | *value | correlation_id |
| ----------- | ----------- |  ----------- |  ----------- |
| myDesktopApp | numberOfTimesOpened | 1 | user123
`*` = Required, otherwise optional

### Entry formatted as JSON request body:
```json
{
  "app_id": "myDesktopApp",
  "name": "numberOfTimesOpened",
  "value": 1,
  "correlation_id": "user123"
}
```

## Security

Logging in generates a JWT token that must be passed with every call of the `entry` service.  The token expires by default every seven days, and can be renewed by calling the `login` service again.  To customize the expiration time of the token, modify the `EXPIRATION_TIME` constant in `src/main/java/com.telemetryServer.config.filter.AuthenticationConfigConstants`

## Examples
Some examples of use to record:
- When a user completes all levels of a game
- When a user changes their configuration settings
- How often a user opens your app

Telemetry data can also be associated together using the correlation id, which is set by your application, so it is fully customizable:
- All telemetry data from a single session
- All telemetry data from a certain user


## Todo

There are still some things that need to be done!

- Unit tests
- Documentation.  Add in-depth documentation for the API using Swagger, and also add notes for querying entries with a third-party database querying tool.

