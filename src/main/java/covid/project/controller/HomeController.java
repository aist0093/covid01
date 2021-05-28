package covid.project.controller;

import ch.qos.logback.classic.Logger;
import covid.project.model.*;
import covid.project.security.IAuthenticationFacade;
import covid.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.print.Book;
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
    @Autowired
    ClientPageServiceInter clientPageServiceInter;
    @Autowired
    private IAuthenticationFacade authenticationFacade;
    @Autowired
    UserServiceInter userServiceInter;

    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/loginPage")
    public String LoginPage(){
        return "loginPage";
    }

    @GetMapping("/whateverPage")
    public String whateverPage(){
        return "whateverPage";
    }
    @PostMapping("/createAppointment")
    public String createApt(@RequestParam String aptType, @RequestParam String aptDate, @RequestParam String aptTime ){
        BookingDate bookingDate = new BookingDate(-1, aptDate, aptTime);
        bookingDateServiceInter.FindBookingByTime(bookingDate);
        Booking booking = new Booking(-1, userServiceInter.getClientID(), aptType, false, bookingDate.getDateID());
        bookingServiceInter.addBooking(booking, bookingDate);
        System.out.println(aptType);
        return "whateverPage";
    }

    @GetMapping("/adminPage")
    public String Home(Model model){
        List<Booking> bookingList = bookingServiceInter.fetchAll();
        model.addAttribute("bookingsTable", bookingList);
        List<Client> clientList = clientServiceInter.fetchAll();
        model.addAttribute("clientsTable", clientList);
        List<BookingDate> bookingDateList = bookingDateServiceInter.fetchAll();
        model.addAttribute("bookingDatesTable", bookingDateList);
        return "adminPage";

    }

    @GetMapping("/secPage")
    public String HomeInfo(Model model){
        List<Client> clientList = clientServiceInter.fetchAll();
        model.addAttribute("clientsTable", clientList);
        List<Booking> bookingList = bookingServiceInter.fetchAll();
        model.addAttribute("bookingsTable", bookingList);
        List<BookingDate> bookingDateList = bookingDateServiceInter.fetchAll();
        model.addAttribute("bookingDatesTable", bookingDateList);
        return "secPage";
    }

    @GetMapping("/clientPage")
    public String HomeClient(Model model){
        List<ClientPage> clientPageList = clientPageServiceInter.fetchAll();
        model.addAttribute("clientPageList", clientPageList);
        return "clientPage";
    }
    @GetMapping("/singleClientPage")
    public String HomeSingleClient(Model model){
        List<ClientPage> clientPageList = clientPageServiceInter.fetchAll();
        model.addAttribute("clientPageList", clientPageList);
        model.addAttribute("myUsername", authenticationFacade.getAuthentication().getName());
        return "singleClientPage";
    }

    @GetMapping("/usersPage")
    public String UsersPage(Model model){
        List<User> usersPageList = userServiceInter.fetchAll();
        model.addAttribute("usersPageList", usersPageList);
        model.addAttribute("myUsername", authenticationFacade.getAuthentication().getName());
        return "usersPage";
    }
    @GetMapping("/allUsers")
    public String AllUserz(Model model){
        List<User> usersPageList = userServiceInter.fetchAll();
        model.addAttribute("usersPageList", usersPageList);
        return "allUsers";
    }


}
