# Weather and news connector

API which aggregates data from News API and OpenWeatherMap.

## Built with

- Java
- Spring Boot
- Maven

## Getting started

### Prerequisites

- Java installed (17 or later)
- Maven installed
- API key for [News API](https://newsapi.org/).
- API key for [OpenWeatherMap](https://openweathermap.org/).


### Installation

1. Clone the repository

```
git clone https://github.com/bgx160/news-weather-connector.git
cd news-weather-connector
```

2. Create .env-file to project root

```
NEWS_API_KEY= <your-news-api-key>
WEATHER_API_KEY=<your-open-weather-map-api-key>
```

3. Run the application using the following command (tested with windows):

- For Unix-based systems (Linux, macOS):
  `./mvnw spring-boot:run`

- For Windows:
  `mvnw spring-boot:run`

4. Application should now run on localhost port 8080

## API Endpoints

### `/aggregated`

- **Method**: `GET`
- **Description**: Retrieves both weather data and news articles for a specified city.
- **Parameters**:
    - `city` (String, required) - The name of the city to retrieve data for.
- **Example response**:

```
{
  "weather": {
    "city": "Helsinki",
    "temp": 4.9,
    "feelsLike": 0.85,
    "description": "broken clouds"
  },
  "news": [
    {
      "title": "Netflix closes AAA game studio before it ever released a game",
      "author": "Ash Parrish",
      "url": "https://www.theverge.com/2024/10/22/24276700/netflix-gaming-studio-closure-blue"
    },
    {
      "title": "2 German pilots killed when WWII-era airplane crashes after takeoff in southern Finland",
      "author": "Associated Press",
      "url": "https://www.yahoo.com/news/2-german-pilots-killed-wwii-132820538.html"
    },
    ...
  ]
}
```

### `/news`

- **Method**: `GET`
- **Description**: Retrieves news articles related to a specified keyword.
- **Parameters**:
    - `keyword` (String, required) - The search keyword for news articles.
- **Example response**:

```
[
  {
    "title": "C Drops, Java (and Rust) Climb in Popularity - as Coders Seek Easy, Secure Languages",
    "author": "EditorDavid",
    "url": "https://developers.slashdot.org/story/24/10/13/0150243/c-drops-java-and-rust-climb-in-popularity---as-coders-seek-easy-secure-languages"
  },
  {
    "title": "Eclipse Steady – Java Code Analysis",
    "author": "eclipse",
    "url": "https://github.com/eclipse/steady"
  },
  ...
]
```

### `/weather`

- **Method**: `GET`
- **Description**: Retrieves current weather data for a specified city.
- **Parameters**:
- `city` (String, required) - The name of the city for which weather data is retrieved.
- **Example response**:

```
{
  "city": "Helsinki",
  "temp": 4.96,
  "feelsLike": 1.12,
  "description": "broken clouds"
}
```



