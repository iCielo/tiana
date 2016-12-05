/**
 * lincl
 * 2016年12月1日 下午3:21:02
 * 
 */
package com.lezic.tiana.app.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lezic.tiana.web.BaseController;

/**
 * 后台主页
 * 
 * @author lincl
 * 
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String listPage(Model model) {
        return "/home/welcome";
    }
}
