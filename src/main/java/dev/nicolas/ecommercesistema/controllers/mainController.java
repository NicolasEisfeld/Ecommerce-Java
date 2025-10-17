package dev.nicolas.ecommercesistema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/administrativo")
    public String acessarPrincipal() {
        return "administrativo/index";
    }

}
