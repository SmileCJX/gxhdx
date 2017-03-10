package com.gxhdx.controller;

import com.gxhdx.entity.MessageBoard;
import com.gxhdx.entity.Permission;
import com.gxhdx.service.MessageBoardService;
import com.gxhdx.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private PermissionService permissionService;

	@Autowired
	private MessageBoardService messageBoardService;

	@RequestMapping("")
	public String admin(Model model) {
		Permission menu = permissionService.getMenu();
		model.addAttribute("menu", menu);
		return "admin/admin";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		//倒序找到最新的几条数据
		Integer count = messageBoardService.findAll().size();
		List<MessageBoard> messageBoardList = messageBoardService.findAll().subList(count-5,count);
		Collections.reverse(messageBoardList);

		model.addAttribute("messageboards",messageBoardList);
		return "admin/index";
	}

	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
}