package covid.project.controller;

import covid.project.model.Booking;
import covid.project.model.Client;
import covid.project.model.ClientInfo;
import covid.project.service.BookingServiceInter;
import covid.project.service.ClientInfoServiceInter;
import covid.project.service.ClientServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    BookingServiceInter bookingServiceInter;
    @Autowired
    ClientInfoServiceInter clientInfoServiceInter;
    @Autowired
    ClientServiceInter clientServiceInter;

    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/loginPage")
    public String login(){ return "loginPage"; }

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
        return "clientPage";
    }


}