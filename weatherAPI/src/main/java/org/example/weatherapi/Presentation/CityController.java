package org.example.weatherapi.Presentation;

import org.example.weatherapi.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CityController
{

    WeatherService weatherService;

    @Autowired
    public CityController( WeatherService weatherService) {
        this.weatherService= weatherService;
    }




    @GetMapping("/xd")
    public String displayWeatherData(Model model){
        model.addAttribute("city",weatherService.getCity());
        return "weatherData";
    }
    @PostMapping("/xd")
    public String savePetProfile(String name,
                                 Model model) {
        weatherService.getCity().setName(name);
        model.addAttribute("cityName", name);;
        weatherService.getTemperatureOfCity();
        return "redirect:/input";

    }
    @GetMapping("/input")
    public String showInput(Model model){
        model.addAttribute("gradus",weatherService.getWeatherx().getCurrent().getTemperature2m());
        return "input";
    }



}
