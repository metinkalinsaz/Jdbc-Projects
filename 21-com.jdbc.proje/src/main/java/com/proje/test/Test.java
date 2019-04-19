package com.proje.test;

import com.proje.model.UserProduct;
import com.proje.service.BrandService;
import com.proje.service.CategoryService;
import com.proje.service.ProductService;
import com.proje.service.UserProductService;
import com.proje.service.UserService;
import com.proje.service.impl.BrandServiceImpl;
import com.proje.service.impl.CategoryServiceImpl;
import com.proje.service.impl.ProductServiceImpl;
import com.proje.service.impl.UserProductServiceImpl;
import com.proje.service.impl.UserServiceImpl;
/**
 * @author MetinKalinsaz
 */
public class Test {

	public static void main(String[] args) {
		BrandService brandService = new BrandServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		ProductService productService = new ProductServiceImpl();
		UserService userService = new UserServiceImpl();
		UserProductService userProductService = new UserProductServiceImpl();

		// buray� controler gibi �ny�z gibi d���n�yoruz

//		-------------------------------------------------	
		// BRAND T�M L�STES�N� �EKT�K
//			List<Brand> brands=brandService.findBrands();
//			for (Brand brand : brands) {
//				System.out.println("BrandId: " +brand.getBrandId()+" BrandName: " +brand.getBrandName());
//				
		// ---------------------------------------------------
//			}
//			//id ile bran bulma
//			Brand brand=brandService.findBrandById(3);
//			System.out.println("Id'si :"+brand.getBrandId()+" olan Brand'mizin  "+"BrandName:  "+brand.getBrandName());

//		------------------------------------------------
		// T�m categorileri getirdik
//			List<Category> categories=categoryService.findCategories();
//			for (Category category : categories) {
//				System.out.println("categoryId: "+category.getCategoryId()+" CategoryName: "+category.getCategoryName());
//			}
//			
		// Id ile category bulduk
//			Category category=categoryService.findCategoryById(2);
//			System.out.println("CategoryId: "+category.getCategoryId()+" CategoryName: "+category.getCategoryName());
//			

		// T�m product listesi left jo�n brand+category listesini getirdik
		// birle�tirerek....
//			List<Product> products=productService.findProducts();
//			for (Product product : products) {
//				System.out.println("id: "+product.getProductId()+" -mevcut:  "+product.getAvaible()+" -�cret:  "+product.getUnitPrice()+" -ekleme tarihi :  "
//			+product.getAddDate()+" -G�ncellenme tarihi:  "+product.getUpdateDate()+" -Kategori t�r�:  "+product.getCategoryId()+" -Marka t�r�:  "+product.getBrandId());
//			}
//			
		// id ile product arama ve join querymizin birle�tirilmi� detayl� aramas�...
//			Product product=productService.findProductById(2);
//			System.out.println("id: "+product.getProductId()+" -mevcut:  "+product.getAvaible()+" -�cret:  "+product.getUnitPrice()+" -ekleme tarihi :  "
//					+product.getAddDate()+" -G�ncellenme tarihi:  "+product.getUpdateDate()+" -Kategori t�r�:  "+product.getCategoryId()+" -Marka t�r�:  "+product.getBrandId());
//			

		// User t�m ki�i listesini getirdik
//			List<Usermy> usermies=userService.findUsers();
//			for (Usermy usermy : usermies) {
//				
//				System.out.println("id: "+usermy.getUsersId()+" ad� : "+usermy.getFirstName()+" soyad� :"+usermy.getLastName()+" dogum tar�h�: "+usermy.getBirthOfDate()+"username: "+usermy.getUserName());
//			}
//			

		// id ile user bulma
//			Usermy usermy=userService.findUserById(100);
//			System.out.println("id: "+usermy.getUsersId()+" ad� : "+usermy.getFirstName()+" soyad� :"+usermy.getLastName()+" dogum tar�h�: "+usermy.getBirthOfDate()+"username: "+usermy.getUserName());
//			System.out.println(usermy.getFirstName());

//			List<Product> products=productService.findProducts();

//			List<UserProduct> userProducts=userProductService.findUserProductById(1);
//			for (UserProduct userProduct : userProducts) {
//		
//				System.out.println("user�d: "+userProduct.getUserId());
//	}
//			

		// user ekleme i�lemi
//		Usermy usermy=new Usermy(104, "ahmet", "serkan", new Date(new java.util.Date().getTime()), "as");
//		userService.saveUser(usermy);
//			

		// product ekleme i�lemi
//	Product product=new Product(6, "casper", 3000, 2,new Date ( new java.util.Date().getTime()), null, null, null);
//	Category category=categoryService.findCategoryById(2);
//	product.setCategoryId(category);
//		Brand brand=brandService.findBrandById(5);
//		product.setBrandId(brand);	
//		productService.saveProduct(product);
//		
		// ili�kiyi kurduk
//		userProductService.saveUserProduct(104, 5);

		// Product product=productService.findProductById(2);

		// 5 tabloyuda birle�tirdik
//		UserProduct userProduct = userProductService.findUserProductById();
//		System.out.println("user�d: " + userProduct.getUserId() + " product�d: " + userProduct.getProductId());

	}

}
