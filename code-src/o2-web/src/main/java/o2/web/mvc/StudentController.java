/*
 * Copyright 1999-2010 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package o2.web.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类StudentController.java的实现描述：TODO 类实现描述 
 * @author yangqi 2013-5-12 下午12:19:10
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showStudent(@RequestParam("name")
    String name, Model model) {

        System.out.println("name is " + name);
        model.addAttribute("name", name);
        return "student/show";
    }

}
