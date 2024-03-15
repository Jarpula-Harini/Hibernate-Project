package com.shopping.Main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.shopping.service.UserService;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.UserServiceImpl;
import com.shopping.entity.Category;
import com.shopping.entity.Order;
import com.shopping.entity.OrderDetail;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.Review;
import com.shopping.entity.User;
import com.shopping.service.CategoryService;
import com.shopping.service.OrderService;
import com.shopping.service.ProductService;
import com.shopping.service.ReviewService;
import com.shopping.service.OrderDetailService;
import com.shopping.serviceimpl.OrderServiceImpl;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.serviceimpl.ReviewServiceImpl;
import com.shopping.serviceimpl.OrderDetailServiceImpl;

public class AllOperation {

	static UserService userService = new UserServiceImpl();
	static CategoryService categoryService = new CategoryServiceImpl();
	static OrderService orderService = new OrderServiceImpl();
	static ProductService productService = new ProductServiceImpl();
	static ReviewService reviewService = new ReviewServiceImpl();
	static OrderDetailService orderDetailService = new OrderDetailServiceImpl();

	static Scanner scanner = new Scanner(System.in);

	public static boolean UserInputs() {
		
		scanner.nextLine();
		System.out.println("Enter UserId");
		String userId = scanner.nextLine();

		System.out.println("Enter User Name");
		String userName = scanner.nextLine();

		System.out.println("Enter PassWord");
		String passWord = scanner.nextLine();

		System.out.println("Enter Address");
		String address = scanner.nextLine();

		System.out.println("Enter phoneNumber");
		int phoneNumber = scanner.nextInt();

		scanner.nextLine();

		//System.out.println("Enter status");
		//char status = (char) scanner.nextInt();

		scanner.nextLine();

		User user =  new User(userId, userName, passWord, address, phoneNumber, 'A');
		
		return userService.createUser(user);
	}

	public static boolean ProductInputs() {
		scanner.nextLine();
		System.out.println("Enter ProductId");
		String ProductId = scanner.nextLine();

		System.out.println("Enter ProductName");
		String ProductName = scanner.nextLine();

		System.out.println("Enter Description");
		String Description = scanner.nextLine();

		System.out.println("Enter price");
		double price = scanner.nextInt();

		System.out.println("Enter productInStock");
		String productInStock = scanner.nextLine();

		System.out.println("Enter CategoryId");
		String categoryId = scanner.nextLine();

		Category category1 = categoryService.getCategoryById(categoryId);

		Product product =  new Product(ProductId, ProductName, Description, price, productInStock, 'A', category1);
		
		return productService.createProduct(product);

	}

	public static boolean OrderInputs() {
		scanner.nextLine();
		System.out.println("Enter orderId");
		String orderId = scanner.nextLine();

		System.out.println("Enter orderDate");
		LocalDate orderDate = LocalDate.now();

		System.out.println("Enter totalAmount");
		double totalAmount = scanner.nextInt();

		System.out.println("Enter shippingAddress");
		String shippingAddress = scanner.nextLine();

		System.out.println("Enter paymentMethod");
		String paymentMethod = scanner.nextLine();

		System.out.println("Enter orderStatus");
		String orderStatus = scanner.nextLine();

		System.out.println("Enter orderDetail");
		String orderDetail = scanner.nextLine();

	//	OrderDetail orderDetail1 = (OrderDetail) orderDetailService.getAllOrderDetail(null);
		Orders order = orderService.

		// scanner.nextLine()
    //Orders(String orderId, LocalDate orderDate, double totalAmount, String shippingAddress, String paymentMethod,String orderStatus, char status, User user)

		Orders order =  new Orders(orderId,orderDate, totalAmount, shippingAddress, paymentMethod, orderStatus, 'A',user);

		return orderService.createOrder(order);
	}

	public static boolean ReviewInputs() {
		scanner.nextLine();
		System.out.println("Enter reviewId");
		String reviewId = scanner.nextLine();

		System.out.println("Enter rating");
		double rating = scanner.nextInt();

		System.out.println("Enter comments");
		String comments = scanner.nextLine();

		System.out.println("Enter userId");
		String userId = scanner.nextLine();

		User user1 = userService.getUserById(userId);

		// scanner.nextLine();

		Review review =  new Review(reviewId, rating, comments, 'A', user1);
		return reviewService.createReview(review);

	}

	public static boolean CategoryInputs() {
		scanner.nextLine();
		System.out.println("Enter categoryId");
		String categoryId = scanner.nextLine();

		System.out.println("Enter categoryName");
		String categoryName = scanner.nextLine();

		//scanner.nextLine();

		// Category(String categoryId, String categoryName,char status)
		Category Category =  new Category(categoryId, categoryName, 'A');
		return categoryService.createCategory(Category);

	}

	public static boolean OrderDetailInputs() {
		scanner.nextLine();
		System.out.println("Enter orderDetailId:");
		int orderDetailId = scanner.nextInt();

		System.out.println("Enter productName:");
		String productName = scanner.nextLine();

		 Product product = productService.getProductByName(productName);

		System.out.println("Enter quantity:");
		int quantity = scanner.nextInt();
		
		System.out.println("Enter ");
		
		OrderDetail orderDetail = orderService.getOrderByProductId()


		//(int orderDetailId, Product product, Order order, int quantity, char status)

		OrderDetail orderDetail = new OrderDetail(orderDetailId, product, quantity, "pending",);
		
		return orderDetailService.createOrderDetail(orderDetail);

	} 

	public static void userOperations() {

		while (true) {
			System.out.println("User Details\n press 1.Add User Details\n press 2.Retrieve All User Data\n"
					+ "press 3.Update User Data\n press 4.Delete User Data\n press 5.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				UserInputs();
				//boolean createUser = userService.createUser(user);
				System.out.println("User Data has been created successfully" );

			case 2:

				List<User> users = userService.getAllUsers();

				for (User user1 : users) {
					System.out.println(user1);
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter the User Id ro Update the information");
				String userId = scanner.next();
				User usr = userService.getUserById(userId);

				if (usr != null) {
					 UserInputs();

					//boolean updatedInfo = userService.updateUser(userId, user1);
					System.out.println("User Data Updated successfully" );
				}

				break;

			case 4:
				System.out.println("Enter User Id to delete the information");
				String id = scanner.next();

				boolean message = userService.deleteUser(id);
				System.out.println(message);

				break;

			}
		}
	}

	public static void categoryOperations() {

		while (true) {
			System.out.println("Category Details\n press 1.Add Category Details\n press 2.Retrieve All Category Data\n"
					+ "press 3.Update Category Data\n press 4.Delete Category Data\n press 5.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				CategoryInputs();
			//	boolean createcategory = categoryService.createCategory(category);
				System.out.println("Category Data has been created successfully" );
				break;

			case 2:

				List<Category> category1 = categoryService.getAllCategory();

				for (Category category2 : category1) {
					System.out.println(category2);
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter the category Id to Update the information");
				String categoryId = scanner.next();
				Category categry = categoryService.getCategoryById(categoryId);

				if (categry != null) {
				 CategoryInputs();

				//	boolean updatedInfo = categoryService.updateCategory(categoryId, category2);
					System.out.println("Category Data Updated successfully");
				}

				break;

			case 4:
				System.out.println("Enter Category Id to delete the information");
				String id = scanner.next();

				boolean message = categoryService.deleteCategory(id);
				System.out.println(message);

				break;

			}
		}
	}
	
	public static void orderOperations() {
		
		while (true) {
			System.out.println("Order Details\n press 1.Add Order Details\n press 2.Retrieve All Order Data\n"
					+ "press 3.Update Order Data\n press 4.Delete Order Data\n press 5.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {
			
			case 1:
			OrderInputs();
				//boolean createOrder = orderService.createOrder(orders);
				System.out.println("Order data has been created successfully");
				
			case 2:
				System.out.println("Enter the Order Id to Update the Information");
				String orderId = scanner.next();
				
				Orders order1 = orderService.getOrderById(orderId);
				
				if(order1 != null) {
				 OrderInputs();
					
					//boolean updatedInfo = orderService.updateOrder(orderId, order2);
					System.out.println("Order Data Updated successfully" );
				}
				break;
				
			case 3:
				List<Orders> order11 = orderService.getAllOrders();

				for (Orders order2 : order11) {
					System.out.println(order2);
				}
				break;
				
			case 4:
				System.out.println("Enter Order Id to delete the information");
				String id = scanner.next();

				boolean message = orderService.deleteOrder(id);
				System.out.println(message);

				break;
				
				}
			}
		}
	
	public static void productOperations() {

		while (true) {
			System.out.println("Product Details\n press 1.Add Product Details\n press 2.Retrieve All Product Data\n"
					+ "press 3.Update Product Data\n press 4.Delete Product Data\n press 5.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				 ProductInputs();
				//boolean createproduct = productService.createProduct(product);
				System.out.println("Product Data has been created successfully");

			case 2:

				List<Product> products = productService.getAllProducts();

				for (Product product1 : products) {
					System.out.println(product1);
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter the Product Id ro Update the information");
				String productId = scanner.next();
				Product produt = productService.getProductById(productId);

				if (produt != null) {
				 ProductInputs();

				//	boolean updatedInfo = productService.updateProduct(productId, product1);
					System.out.println("Product Data Updated successfully" );
				}

				break;

			case 4:
				System.out.println("Enter Product Id to delete the information");
				String id = scanner.next();

				boolean message = productService.deleteProduct(id);
				System.out.println(message);

				break;

			}
		}
	}
	public static void reviewOperations() {

		while (true) {
			System.out.println("Review Details\n press 1.Add Review Details\n press 2.Retrieve All Review Data\n"
					+ "press 3.Update Review Data\n press 4.Delete Review Data\n press 5.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				 ReviewInputs();
			//	boolean createUser = reviewService.createReview(review);
				System.out.println("User Data has been created successfully" );

			case 2:

				List<Review> reviews = reviewService.getAllReviews();

				for (Review review1 : reviews) {
					System.out.println(review1);
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter the Review Id ro Update the information");
				String reviewId = scanner.next();
				Review review1 = reviewService.getReviewById(reviewId);

				if (review1 != null) {
				ReviewInputs();

					//boolean updatedInfo = reviewService.updateReview(reviewId, review1);
					System.out.println("Review Data Updated successfully" );
				}

				break;

			case 4:
				System.out.println("Enter Review Id to delete the information");
				String id = scanner.next();

				boolean message = reviewService.deleteReview(id);
				System.out.println(message);

				break;

			}
		}
	}
	public static void orderDetailOperations() {

		while (true) {
			System.out.println("OrderDetail Details\n press 1.Add OrderDetail Details\n press 2.Retrieve All OrderDetail Data\n"
					+ "press 3.Update OrderDetail Data\n press 4.Delete OrderDetail Data\n press 5.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				 OrderDetailInputs();
				//boolean createOrderDetail = orderDetailService.createOrderDetail(orderDetail);
				System.out.println("OrderDetail Data has been created successfully" );

			case 2:

				List<OrderDetail> OrderDetail1 = orderDetailService.getAllOrderDetail();

				for (OrderDetail OrderDetail : OrderDetail1) {
					System.out.println(OrderDetail);
				}
				break;

			case 3:
				scanner.nextLine();
				System.out.println("Enter the OrderDetail Id ro Update the information");
				String orderDetailId = scanner.next();
				OrderDetail order = orderDetailService.getOrderDetailById(input);

				if (order != null) {
					 OrderDetailInputs();

					//boolean updatedInfo = orderDetailService.updateOrderDetail(input, id);
					System.out.println("OrderDetail Data Updated successfully");
				}

				break;

			case 4:
				System.out.println("Enter OrderDetail Id to delete the information");
				int id = scanner.nextInt();

				boolean message = orderDetailService.deleteOrderDetail(input);
				System.out.println(message);

				break;

			}
		}
	}

	
	
}