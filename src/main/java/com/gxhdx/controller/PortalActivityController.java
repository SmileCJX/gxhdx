package com.gxhdx.controller;

import com.gxhdx.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/3/15/015.
 */
@Controller
@RequestMapping("/portal")
public class PortalActivityController {

    @Autowired
    private ActivityTypeService activityTypeService;

//    @RequestMapping(value = "/activitytype/list", method = RequestMethod.GET)
//    public String index(Model model) {
//        return "portal/list-activity";
//    }
//
//    @RequestMapping(value = "/activitytype/list",method = RequestMethod.POST)
//    public String list(Model model){
//        model.addAttribute("activitytypes",activityTypeService.findAll());
//        return "portal/default/list-activity";
//    }
}
