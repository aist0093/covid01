package covid.project.controller;

import covid.project.model.Booking;
import covid.project.service.BookingService;
import covid.project.service.BookingServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    BookingServiceInter bookingServiceInter;

    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/bookingPage")
    public String Home(Model model){
        List<Booking> bookingList = bookingServiceInter.fetchAll();
        model.addAttribute("bookingsTable", bookingList);
        return "bookingPage";
    }


}