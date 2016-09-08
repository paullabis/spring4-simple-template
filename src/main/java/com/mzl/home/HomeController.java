package com.mzl.home;

import com.mzl.service.CategoryService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
  @Autowired
  private CategoryService categoryService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
    categoryService.getCategoryList(); // default data init
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
