package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {
	@Autowired
	ProductDao productDao;
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productDao.getProducts(); 
		m.addAttribute("product", products);
		return "index";
	}
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title","add Product");
		return "add_product_form";
	}
	@RequestMapping(value="/handle-product" , method=RequestMethod.POST)
	public RedirectView handleProduc(@ModelAttribute Product product,HttpServletRequest request) {
		RedirectView redirectView=new RedirectView();
		productDao.createProduct(product);
		System.out.println(product);
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId,HttpServletRequest request) {
		this.productDao.deleteProduct(productId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	@RequestMapping(value = "/update/{productId}")
	public String updateForm(@PathVariable("productId") int productId,Model model) {
		Product product =this.productDao.getProduct(productId);
		model.addAttribute("product", product);
		return "update_form";
	}
}
