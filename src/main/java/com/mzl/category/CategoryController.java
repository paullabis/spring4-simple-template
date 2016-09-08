package com.mzl.category;

import com.mzl.service.CategoryService;
import com.mzl.support.web.MessageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

  @RequestMapping(value = "category/list", method = RequestMethod.GET)
  public ModelAndView getCategoriesPage() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("categories", categoryService.getCategoryList());
    return mv;
  }

  @RequestMapping(value = "category/info", method = RequestMethod.GET)
  public ModelAndView viewCategory(@RequestParam(value="id") long id) {
    ModelAndView mv = new ModelAndView();
    mv.addObject("category", categoryService.findById(id));
    return mv;
  }

}
