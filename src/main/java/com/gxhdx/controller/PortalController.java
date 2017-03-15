package com.gxhdx.controller;

import com.gxhdx.entity.*;
import com.gxhdx.service.*;
import com.gxhdx.support.PageDto;
import com.gxhdx.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PortalController {

	@Autowired
	private SiteInfoService siteInfoService;
	@Autowired
	private FriendshipLinkService friendshipLinkService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SlideImgService slideImgService;
	@Autowired
	private StadiumService stadiumService;
	@Autowired
	private MessageBoardService messageBoardService;
	@Autowired
	private  NewsService newsService;
	@Autowired
	private ActivityTypeService activityTypeService;

	private String template ="";

	@ModelAttribute
	public void loadCategory(Model model, Long categoryId) {
		try {
			SiteInfo siteInfo = siteInfoService.getSiteInfo(null);
			model.addAttribute("categories",
					categoryService.findList(null, null, 1, 15));
			model.addAttribute("siteInfo", siteInfo);
			model.addAttribute("links", friendshipLinkService.findAll());
			template=siteInfo.getSiteTemplate();
			if (StringUtils.isEmpty(template)) {
				template="default";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request) {
		model.addAttribute("category", new Category("首页"));
		model.addAttribute("slideImgs", slideImgService.findList(null,1, 5,true));
//		model.addAttribute("stadiums", stadiumService.findAll());
		model.addAttribute("news",newsService.findList(null,null,null,null,null,null,null,null,null,1,4,true));
//		return "portal/index";
		return "portal/"+template+"/index";
	}

	@RequestMapping("/list")
	public String list(Long categoryId, Integer pageNo, Integer pageSize,
			Model model) {
		if (pageNo == null) {
			pageNo = 1;
		}
		if (pageSize == null) {
			pageSize = 15;
		}
		Category category = categoryService.getCategory(categoryId);
		PageDto<Article> list = articleService.findList(categoryId, null, null,
				null, pageNo, pageSize);
		model.addAttribute("list", list);
		if ("single".equals(category.getListType()) && list.getItems() != null
				&& list.getItems().size() > 0) {
			model.addAttribute("article", list.getItems().get(0));
		}

		if(categoryId == 7){
			PageDto<News> newsPageDto = newsService.findList(null,null,null,null,null,null,null,null,null,pageNo,pageSize,true);
			model.addAttribute("newsList",newsPageDto);
		}
		if(categoryId == 8){
			PageDto<ActivityType> activityTypePageDto = activityTypeService.findList(null,null,null,null,pageNo,pageSize);
			model.addAttribute("activitytypeList",activityTypePageDto);
		}
//		if("messageboard".equals(category.getListType()) && list.getItems() != null
//				&& list.getItems().size()>0 ){
//			model.addAttribute("messageboard",list.getItems().get(0));
//		}
		model.addAttribute("category", category);
		return "portal/"+template+"/"+ category.getListType();
	}

	@RequestMapping("/article")
	public String listCase(Model model, Long id, Long categoryId) {
		model.addAttribute("entity", articleService.getArticle(id));
		model.addAttribute("category", categoryService.getCategory(categoryId));
		return "portal/"+template+"/article-show";
	}

	@ResponseBody
	@RequestMapping(value = "/message/edit", method = RequestMethod.POST)
	public Object edit(MessageBoard entity, Model model) {
		try {
			entity = messageBoardService.saveOrUpdate(entity);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, e);
		}
		return new Result(true, entity);
	}

	@RequestMapping("/news")
	public String newslistCase(Model model, Long id,Long categoryId) {
		model.addAttribute("entity", newsService.getNews(id));
		model.addAttribute("category", categoryService.getCategory(categoryId));
		return "portal/"+template+"/news-show";
	}

}