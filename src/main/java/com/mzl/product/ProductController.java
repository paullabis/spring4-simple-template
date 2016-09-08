package com.mzl.product;

import com.mzl.account.Account;
import com.mzl.account.AccountService;
import com.mzl.service.ProductService;
import com.mzl.signup.SignupForm;
import com.mzl.support.web.MessageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

  @RequestMapping(value = "product/list", method = RequestMethod.GET)
  public ModelAndView getProductsPage() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("products", productService.getProductList());
    return mv;
  }
}
