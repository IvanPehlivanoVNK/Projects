import requests

cityName = input("Enter city name: ")

url_for_lat_lon = f"https://geocoding-api.open-meteo.com/v1/search?name={cityName}&count=1&language=en&format=json"

def getCityLatLon():
    response = requests.get(url_for_lat_lon)

    if response.status_code == 200:
        data_for_City = response.json()
        return data_for_City
    else:
        print(response.status_code)

def getWeather():
    response = requests.get(url_for_weather)
    if response.status_code == 200:
        data_for_Weather = response.json()
        return data_for_Weather
    else:
        print(response.status_code)


city_info = getCityLatLon()
latitude = city_info["results"][0]["latitude"]
longitude = city_info["results"][0]["longitude"]
url_for_weather = f"https://api.open-meteo.com/v1/forecast?latitude={latitude}&longitude={longitude}&current=temperature_2m"

weather_info = getWeather()
print(weather_info["current"]["temperature_2m"])


















