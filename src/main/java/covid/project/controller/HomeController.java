package covid.project.controller;

import covid.project.Print.GeneratePdf;
import covid.project.model.*;
import covid.project.security.IAuthenticationFacade;
import covid.project.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
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
    public String Index() {
        return "index";
    }

    @GetMapping("/loginPage")
    public String LoginPage() {
        return "loginPage";
    }

    @GetMapping("/error")
    public String error() {
        return "index";
    }

    @GetMapping("/newBooking")
    public String newBooking() {
        return "newBooking";
    }

    @PostMapping("/createAppointment")
    public String createApt(@RequestParam String aptType, @RequestParam String aptDate, @RequestParam String aptTime) {
        BookingDate bookingDate = new BookingDate(-1, aptDate, aptTime);
        bookingDateServiceInter.FindBookingByTime(bookingDate);
        Booking booking = new Booking(-1, userServiceInter.getClientID(), aptType, false, bookingDate.getDateID());
        bookingServiceInter.addBooking(booking, bookingDate);
        return "redirect:/singleClientPage";
    }

    @GetMapping("/adminPage")
    public String Home(Model model) {
        List<Booking> bookingList = bookingServiceInter.fetchAll();
        model.addAttribute("bookingsTable", bookingList);
        List<Client> clientList = clientServiceInter.fetchAll();
        model.addAttribute("clientsTable", clientList);
        List<BookingDate> bookingDateList = bookingDateServiceInter.fetchAll();
        model.addAttribute("bookingDatesTable", bookingDateList);
        return "adminPage";

    }

    @GetMapping("/secPage")
    public String HomeInfo(Model model) {
        List<Client> clientList = clientServiceInter.fetchAll();
        model.addAttribute("clientsTable", clientList);
        List<Booking> bookingList = bookingServiceInter.fetchAll();
        model.addAttribute("bookingsTable", bookingList);
        List<BookingDate> bookingDateList = bookingDateServiceInter.fetchAll();
        model.addAttribute("bookingDatesTable", bookingDateList);
        return "secPage";
    }

    @GetMapping("/singleClientPage")
    public String HomeSingleClient(Model model) {
        List<ClientPage> clientPageList = clientPageServiceInter.fetchAll();
        model.addAttribute("clientPageList", clientPageList);
        model.addAttribute("myUsername", authenticationFacade.getAuthentication().getName());
        return "singleClientPage";
    }

    @GetMapping("/usersPage")
    public String UsersPage(Model model) {
        List<User> usersPageList = userServiceInter.fetchAll();
        model.addAttribute("usersPageList", usersPageList);
        model.addAttribute("myUsername", authenticationFacade.getAuthentication().getName());
        return "usersPage";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form");
        Booking booking = bookingServiceInter.findBookingById(id);
        mav.addObject("booking", booking);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        bookingServiceInter.delete(id);
        return "redirect:/adminPage";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("booking") Booking booking) {
        bookingServiceInter.updateResult(booking);
        String s = authenticationFacade.getAuthentication().getName();
        if (s.equals("1111111111")) {
            return "redirect:/adminPage";
        } else {
            return "redirect:/secPage";
        }
    }

    @PostMapping("/download-pdf")
    public void downloadPDF(HttpServletResponse response,
                            @RequestParam String fullName,
                            @RequestParam long cpr,
                            @RequestParam String type,
                            @RequestParam boolean result,
                            @RequestParam String date) throws IOException {

        GeneratePdf.generatePDF(fullName, cpr, type, result, date);

        try {
            File certificate = new File("covidPass.pdf");
            if (certificate.exists()) {
                String mimeType = URLConnection.guessContentTypeFromName(certificate.getName());
                if (mimeType == null) {

                    mimeType = "application/octet-stream";
                }

                response.setContentType(mimeType);
                response.setHeader("Content-Disposition", String.format("inline; filename=\"" + certificate.getName() + "\""));
                response.setContentLength((int) certificate.length());

                InputStream inputStream = new BufferedInputStream(new FileInputStream(certificate));
                FileCopyUtils.copy(inputStream, response.getOutputStream());
            }
        } catch (IOException e) {
        }

    }
}
