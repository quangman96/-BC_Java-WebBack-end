package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/worldclock")
    public String getTimeByTimeZone(ModelMap model, @RequestParam(name ="city", required = false, defaultValue = "city")String city){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locate = TimeZone.getTimeZone(city);

        long local_time = date.getTime() + (local.getRawOffset() - local.getRawOffset());
        date.setTime(local_time);
        model.addAttribute("city",city);
        model.addAttribute("date",date);

        return "index";
    }
}
