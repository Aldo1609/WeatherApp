document.addEventListener("DOMContentLoaded", () => {
    const fetchWeatherButton = document.getElementById("fetchWeather");
    const weatherDataElement = document.getElementById("weatherData");
    const cityInput = document.getElementById("cityInput");

    fetchWeatherButton.addEventListener("click", () => {
        const city = cityInput.value;
        const apiUrl = `/app/weather?city=${encodeURIComponent(city)}`;

        fetch(apiUrl)
            .then((response) => response.json())
            .then((data) => {
                const weatherDescription = data.weather[0].description;
                const temperature = (data.main.temp - 273.15).toFixed(2);
                const humidity = data.main.humidity + "%";

                const weatherInfo = `Weather in ${city}: ${weatherDescription}<br>Temperature: ${temperature}°C<br>Humidity: ${humidity}`;

                weatherDataElement.innerHTML = weatherInfo;
            })
            .catch((error) => {
                console.error("Error fetching weather data:", error);
                weatherDataElement.innerHTML = "Error fetching weather data.";
            });
    });
});
