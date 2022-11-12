package peaksoft.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/all")
    public String getAllStudents() {
        return "allStudents";
    }

    @GetMapping("/hr_info")
    public String getInfoForHr() {
        return "view_hr";
    }

    @GetMapping("/manager_info")
    public String getInfoForManager() {
        return "manager";
    }
}
