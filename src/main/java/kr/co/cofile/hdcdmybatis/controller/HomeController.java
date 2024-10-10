package kr.co.cofile.hdcdmybatis.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Slf4j
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Locale locale, Model model) {
        log.info("The client locale is {}.", locale);

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatedDate = now.format(formatter);

        model.addAttribute("serverDate", formatedDate);

        return "home";
    }
}
