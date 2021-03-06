package com.mzl.product;

import com.mzl.account.Account;
import com.mzl.account.AccountService;
import com.mzl.model.Category;
import com.mzl.model.Product;
import com.mzl.service.CategoryService;
import com.mzl.service.ProductService;
import com.mzl.signup.SignupForm;
import com.mzl.support.web.MessageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(value = "product/list", method = RequestMethod.GET)
  public ModelAndView getProductsPage() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("products", productService.getProductList());
    return mv;
  }

  @RequestMapping(value = "product/new")
  public String newProductForm(Model model) {
    model.addAttribute(new ProductForm());
    return "product/new";
  }

  @RequestMapping(value = "product/new", method = RequestMethod.POST)
  public String newProduct(@Valid @ModelAttribute ProductForm productForm, RedirectAttributes ra) {
    Category category = categoryService.findById(productForm.getCategory());
    Product product = productForm.createProduct();
    product.setCategory(category);
    productService.save(product);

    MessageHelper.addSuccessAttribute(ra, "product.create.success");
    return "redirect:/product/list";
  }

  @RequestMapping(value = "product/delete/{id}", method = RequestMethod.GET)
  public String deleteProduct(@PathVariable(value="id") long id, RedirectAttributes ra) {
    productService.delete(id);

    MessageHelper.addSuccessAttribute(ra, "product.delete.success");
    return "redirect:/product/list";
  }

  @RequestMapping(value = "product/update", method = RequestMethod.GET)
  public ModelAndView updateProductForm(
      @Valid @ModelAttribute ProductForm productForm,
      @RequestParam(value="id") long id) {
    Product product = productService.findById(id);
    ModelAndView mv = new ModelAndView();
    mv.addObject("product", product);
    return mv;
  }

  @RequestMapping(value = "product/update", method = RequestMethod.POST)
  public String updateProduct(@Valid @ModelAttribute ProductForm productForm, RedirectAttributes ra) {
    Category category = categoryService.findById(productForm.getCategory());
    Product product = productService.findById(productForm.getId());
    product.setCategory(category);
    product.setName(productForm.getName());
    product.setDescription(productForm.getDescription());
    product.setPrice(productForm.getPrice());
    product.setAvailable(productForm.isAvailable());
    productService.save(product);

    MessageHelper.addSuccessAttribute(ra, "product.update.success");
    return "redirect:/product/list";
  }

}
