/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RefreshController.Refresh;

import java.text.DecimalFormat;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @
 */
@Controller
public class RefreshController {
 @RequestMapping("/home")
    public String Homepage(Model model, HttpServletRequest param) {
        String input = param.getParameter("input");
        String suhu = param.getParameter("suhu");
        //String kel = param.getParameter("kel");
        //String operator = param.getParameter("operator");
        double hasil;
        
        switch (suhu) {
            case "kelvin":
                hasil = Double.parseDouble(input) + 273.15;
                break;
            case "fahrenheit":
               hasil = Double.parseDouble(input) * 1.8 + 32;
               break;
            default:
                hasil = 0;
        }
DecimalFormat df = new DecimalFormat("#.##");        

       model.addAttribute("suhu", suhu);
       model.addAttribute("hasil", df.format(hasil));
        return "data";
    }   
}
