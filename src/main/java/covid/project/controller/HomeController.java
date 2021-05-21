package covid.project.controller;

import covid.project.model.Booking;
import covid.project.model.BookingDate;
import covid.project.model.Client;
import covid.project.model.ClientInfo;
import covid.project.service.*;
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
    @Autowired
    ClientInfoServiceInter clientInfoServiceInter;
    @Autowired
    ClientServiceInter clientServiceInter;
    @Autowired
    BookingDateServiceInter bookingDateServiceInter;

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

    @GetMapping("/clientInfoPage")
    public String HomeInfo(Model model){
        List<ClientInfo> clientInfoList = clientInfoServiceInter.fetchAll();
        model.addAttribute("clientInfoTable", clientInfoList);
        return "clientInfoPage";
    }

    @GetMapping("/clientPage")
    public String HomeClient(Model model){
        List<Client> clientList = clientServiceInter.fetchAll();
        model.addAttribute("clientTable", clientList);
        List<Booking> bookingList = bookingServiceInter.fetchAll();
        model.addAttribute("bookingsTable", bookingList);
        List<BookingDate> bookingDateList = bookingDateServiceInter.fetchAll();
        model.addAttribute("bookingDatesTable", bookingDateList);
        List<ClientInfo> clientInfoList = clientInfoServiceInter.fetchAll();
        model.addAttribute("clientInfosTable", clientInfoList);
        return "clientPage";
    }


}