/**
 * lincl
 * 2016年8月15日 下午4:37:09
 * 
 */
package com.lezic.tiana.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.tiana.web.BaseController;

/**
 * @author lincl
 * 
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello,Restful API";
    }
}
