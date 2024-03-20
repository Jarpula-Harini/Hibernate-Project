package com.shopping.Main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Id;

import com.shopping.service.UserService;
import com.shopping.serviceimpl.CategoryServiceImpl;
import com.shopping.serviceimpl.UserServiceImpl;
import com.shopping.entity.Category;
import com.shopping.entity.OrderDetail;
import com.shopping.entity.Orders;
import com.shopping.entity.Product;
import com.shopping.entity.Review;
import com.shopping.entity.User;
import com.shopping.service.CategoryService;
import com.shopping.service.ProductService;
import com.shopping.service.ReviewService;
import com.shopping.service.OrdersService;
import com.shopping.service.OrderDetailService;
import com.shopping.serviceimpl.OrdersServiceImpl;
import com.shopping.serviceimpl.ProductServiceImpl;
import com.shopping.serviceimpl.ReviewServiceImpl;
import com.shopping.serviceimpl.OrderDetailServiceImpl;

public class AllOperation {

	static UserService userService = new UserServiceImpl();
	static CategoryService categoryService = new CategoryServiceImpl();
	static OrdersService ordersService = new OrdersServiceImpl();
	static ProductService productService = new ProductServiceImpl();
	static ReviewService reviewService = new ReviewServiceImpl();
	static OrderDetailService orderDetailService = new OrderDetailServiceImpl();

	static Scanner scanner = new Scanner(System.in);

	// User Inputs
	public static User userInputs() {
// User(String userId, String userName, String passWord,String address, int phoneNumber,char status)
		System.out.println("Enter UserId :");
		scanner.nextLine();
		String userId = scanner.nextLine();

		System.out.println("Enter UserName :");
		String userName = scanner.nextLine();

		System.out.println("Enter PassWord :");
		String passWord = scanner.nextLine();

		System.out.println("Enter Address :");
		String address = scanner.nextLine();

		System.out.println("Enter phoneNumber :");
		int phoneNumber = scanner.nextInt();

		return new User(userId, userName, passWord, address, phoneNumber, 'A');

	}

	// Product Inputs
	public static Product productInputs() {
// Product(String productId, String productName, String description, double productPrice, String productInStock,char status, Category category)
		System.out.println("Enter ProductId :");
		scanner.nextLine();
		String productId = scanner.nextLine();

		System.out.println("Enter ProductName :");
		String productName = scanner.nextLine();

		System.out.println("Enter Description :");
		String description = scanner.nextLine();

		System.out.println("Enter price :");
		double price = scanner.nextDouble();

		System.out.println("Enter productInStock :");
		scanner.nextLine();
		String productInStock = scanner.nextLine();

		System.out.println("Enter CategoryId :");
		// scanner.nextLine();
		String categoryId = scanner.nextLine();
		Category category = categoryService.getCategoryById(categoryId);

		return new Product(productId, productName, description, price, productInStock, 'A', category);

	}

	// Orders Inputs
	public static Orders ordersInputs() {

		System.out.println("Enter OrderId :");
		scanner.nextLine();
		String orderId = scanner.nextLine();

		System.out.println("Enter OrderDate format(YYYY-MM-DD) :");
		LocalDate orderDate = LocalDate.now();

		scanner.nextLine();
		System.out.println("Enter totalAmount :");
		double totalAmount = scanner.nextDouble();

		System.out.println("Enter ShippingAddress :");
		scanner.nextLine();
		String shippingAddress = scanner.nextLine();

		System.out.println("Enter PaymentMethod :");
		String paymentMethod = scanner.nextLine();

		System.out.println("Enter OrderStatus :");
		String orderStatus = scanner.nextLine();

		System.out.println("Enter UserId :");
		String userId = scanner.next();
		User user = userService.getUserById(userId);
		// scanner.nextLine();
		// Orders(String orderId, LocalDate orderDate, double totalAmount, String
		// shippingAddress, String paymentMethod,String orderStatus, char status, User
		// user)

		return new Orders(orderId, orderDate, totalAmount, shippingAddress, paymentMethod, orderStatus, 'A', user);

	}

	// Review Inputs
	public static Review reviewInputs() {

		System.out.println("Enter ReviewId :");
		scanner.nextLine();
		String reviewId = scanner.nextLine();

		System.out.println("Enter Rating :");
		double rating = scanner.nextDouble();

		System.out.println("Enter Comments :");
		scanner.nextLine();
		String comments = scanner.nextLine();

		System.out.println("Enter UserId :");
		String userId = scanner.nextLine();
		// scanner.nextLine();

		User user1 = userService.getUserById(userId);

		return new Review(reviewId, rating, comments, 'A', user1);

	}

	// Category Inputs
	public static Category categoryInputs() {

		System.out.println("Enter categoryId :");
		scanner.nextLine();
		String categoryId = scanner.nextLine();

		System.out.println("Enter categoryName :");
		String categoryName = scanner.nextLine();

		// Category(String categoryId, String categoryName,char status)
		return new Category(categoryId, categoryName, 'A');

	}

	// OrderDetail Inputs
	public static OrderDetail orderDetailInputs() {

		System.out.println("Enter orderDetailId :");
		int orderDetailId = scanner.nextInt();

		System.out.println("Enter productId :");
		scanner.nextLine();
		String productId = scanner.nextLine();
		Product product = productService.getProductById(productId);

		// Product product = productService.getProductByName(productName);

		System.out.println("Enter quantity of Products :");
		int quantity = scanner.nextInt();

		System.out.println("Enter OrderId");
		scanner.nextLine();
		String orderId = scanner.nextLine();
		Orders orders = ordersService.getOrderById(orderId);

		// (int orderDetailId, Product product, Order order, int quantity, char status)

		return new OrderDetail(orderDetailId, product, orders, quantity, 'A');

	}

	public static void userOperations() {

		while (true) {
			System.out.println(
					" Welcome To User Details\n 1.Create User Details\n 2.Get UserById\n 3.Get All Users\n 4.Update User Data\n 5.Delete User Data\n 6.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				User user = userInputs();

				boolean createUser = userService.createUser(user);
				System.out.println("User Data has been created successfully");
				break;

			case 2:
				System.out.println("Enter User DetailBy GetId :");
				String id = scanner.next();

				User user2 = userService.getUserById(id);
				System.out.println("User details With Id : " + id + " " + user2);
				break;

			case 3:

				List<User> users = userService.getAllUsers();

				for (User user1 : users) {
					System.out.println(user1);
				}
				System.out.println("All User records Retrieve sucessfully");
				break;

			case 4:

				System.out.println("Enter the User Id To Update The Information");
				scanner.nextLine();

				String userId = scanner.nextLine();

				System.out.println("Enter New UserName :");
				String newUserName = scanner.nextLine();

				System.out.println("Enter New PassWord :");
				String newPassWord = scanner.nextLine();

				System.out.println("Enter New Address :");
				String newAddress = scanner.nextLine();

				System.out.println("Enter New phoneNumber :");
				int newPhoneNumber = scanner.nextInt();

				User user4 = new User(userId, newUserName, newPassWord, newAddress, newPhoneNumber, 'A');

				boolean updatedInfo = userService.updateUser(userId, user4);
				System.out.println("User Data Updated successfully");

				break;

			case 5:
				System.out.println("Enter User Id To delete the Data");
				String usrId = scanner.next();

				boolean message = userService.deleteUser(usrId);
				System.out.println("Record Deleted sucessfully");

				break;
			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}

			}
		}
	}

	public static void categoryOperations() {

		while (true) {
			System.out.println(
					"Welcome To Category Details\n 1.Create Category Details\n 2.Get All Category Data\n 3.Update Category Data\n 4.Delete Category Data\n 5.Get Category By Id\n 6.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				Category category = categoryInputs();
				boolean createCategory = categoryService.createCategory(category);
				System.out.println("Category Data has been created successfully");
				break;

			case 2:

				List<Category> category1 = categoryService.getAllCategory();

				for (Category category2 : category1) {
					System.out.println(category2);
				}
				System.out.println("All Category records Retrieve sucessfully");
				break;

			case 3:

				System.out.println("Enter the category Id to Update the information");
				scanner.nextLine();
				String categoryId = scanner.nextLine();

				System.out.println("Enter  new categoryName :");
				String newCategoryName = scanner.nextLine();

				Category category2 = new Category(categoryId, newCategoryName, 'A');

				boolean updatedInfo = categoryService.updateCategory(categoryId, category2);
				System.out.println("Category Data Updated successfully");

				break;

			case 4:
				System.out.println("Enter Category Id to delete the information");
				scanner.nextLine();
				String id = scanner.nextLine();

				boolean message = categoryService.deleteCategory(id);
				System.out.println("Record Deleted sucessfully ");

				break;
			case 5:
				System.out.println("Enter The Category ById");
				scanner.nextLine();
				String categoryId1 = scanner.nextLine();

				Category category3 = categoryService.getCategoryById(categoryId1);
				System.out.println("Category Details With id : " + categoryId1 + "" + category3);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			}
		}
	}

	public static void ordersOperations() {

		while (true) {
			System.out.println(
					"Welcome To Order Details\n 1.Create Order Details\n 2.Update Order Data\n 3.Get All Orders\n 4.Delete Order Data\n 5.Get OrdersBy Id\n 6.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:
				Orders orders = ordersInputs();
				boolean createOrder = ordersService.createOrder(orders);
				System.out.println("Order data has been created successfully");
				break;
			case 2:
				System.out.println("Enter Order Id to Update the Information");
				scanner.nextLine();
				String orderId = scanner.nextLine();

				System.out.println("Enter New OrderDate Format(YYYY-MM-DD) :");
				LocalDate newOrderDate = LocalDate.now();
				scanner.nextLine();
				System.out.println("Enter New TotalAmount :");
				double newTotalAmount = scanner.nextDouble();

				System.out.println("Enter New ShippingAddress :");
				scanner.nextLine();
				String newShippingAddress = scanner.nextLine();

				System.out.println("Enter New PaymentMethod :");
				String newPaymentMethod = scanner.nextLine();
				// scanner.nextLine();
				System.out.println("Enter New OrderStatus :");
				String newOrderStatus = scanner.nextLine();

				System.out.println("Enter New UserId :");
				String userId = scanner.nextLine();
				User user = userService.getUserById(userId);

				Orders orders2 = new Orders(orderId, newOrderDate, newTotalAmount, newShippingAddress, newPaymentMethod,
						newOrderStatus, 'A', user);

				boolean updatedInfo = ordersService.updateOrder(orderId, orders2);
				System.out.println("Order Data Updated successfully");

				break;

			case 3:
				List<Orders> order11 = ordersService.getAllOrders();

				for (Orders order2 : order11) {
					System.out.println(order2);
				}
				System.out.println("All Orders Records get sucessfully ");
				break;

			case 4:
				System.out.println("Enter Order Id to delete the information");
				scanner.nextLine();
				String id = scanner.next();

				boolean message = ordersService.deleteOrder(id);
				System.out.println("Record deleted successfully");

				break;
			case 5:
				System.out.println("Enter Orders Id To Get The data  :");
				scanner.nextLine();
				String ordrId = scanner.nextLine();

				Orders orders3 = ordersService.getOrderById(ordrId);
				System.out.println("Orders Details With id :" + ordrId + "" + orders3);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}
			}
		}
	}

	public static void productOperations() {

		while (true) {
			System.out.println(
					"Welcome To Product Details\n 1.Create Product Details\n 2.Get All Product Data\n 3.Update Product Data\n 4.Delete Product Data\n 5.Get Product ById\n 6.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				Product product = productInputs();
				boolean createProduct = productService.createProduct(product);
				System.out.println("Product Data has been created successfully");

			case 2:

				List<Product> products = productService.getAllProducts();

				for (Product product1 : products) {
					System.out.println(product1);
				}
				System.out.println("Get All Products Records");
				break;

			case 3:
				// scanner.nextLine();
				System.out.println("Enter  Product Id To Update the information");
				scanner.nextLine();
				String productId = scanner.next();

				System.out.println("Enter New ProductName :");
				scanner.nextLine();
				String newProductName = scanner.nextLine();

				System.out.println("Enter New Description :");
				String newDescription = scanner.nextLine();

				System.out.println("Enter New price :");
				double newPrice = scanner.nextDouble();

				System.out.println("Enter New ProductInStock :");
				scanner.nextLine();
				String newProductInStock = scanner.nextLine();

				System.out.println("Enter New CategoryId :");
				scanner.nextLine();
				String newCategoryId = scanner.nextLine();
				Category category = categoryService.getCategoryById(newCategoryId);

				Product product1 = new Product(productId, newProductName, newDescription, newPrice, newProductInStock,
						'A', category);

				boolean updatedInfo = productService.updateProduct(productId, product1);
				System.out.println("Product Data Updated successfully");

				break;

			case 4:
				System.out.println("Enter Product Id to delete the information");
				scanner.nextLine();
				String id = scanner.nextLine();

				boolean message = productService.deleteProduct(id);
				System.out.println("Product Record Deleted Successfully");

				break;

			case 5:
				System.out.println("Enter GetProductBy Id :");
				scanner.nextLine();
				String produtId = scanner.nextLine();

				Product product2 = productService.getProductById(produtId);
				System.out.println("Product Details With id :" + produtId + "" + product2);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}

			}
		}
	}

	public static void reviewOperations() {

		while (true) {
			System.out.println(
					"Welcome To Review Details\n 1.Create Review Details\n 2.Get All Review Data\n 3.Update Review Data\n 4.Delete Review Data\n 5.Get DataBy ReviewId\n 6.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				Review review = reviewInputs();
				boolean createUser = reviewService.createReview(review);
				System.out.println("User Data has been created successfully");

			case 2:

				List<Review> reviews = reviewService.getAllReviews();

				for (Review review1 : reviews) {
					System.out.println(review1);
				}
				System.out.println("Get all Review Records successfully");
				break;

			case 3:
				// scanner.nextLine();
				System.out.println("Enter Review Id To Update the Information");
				scanner.nextLine();
				String reviewId = scanner.nextLine();

				System.out.println("Enter New Rating :");
				double newRating = scanner.nextDouble();

				System.out.println("Enter New Comments :");
				scanner.nextLine();
				String newComments = scanner.nextLine();

				System.out.println("Enter UserId :");
				String newUserId = scanner.nextLine();
				// scanner.nextLine();

				User user1 = userService.getUserById(newUserId);

				Review review1 = new Review(reviewId, newRating, newComments, 'A', user1);

				boolean updatedInfo = reviewService.updateReview(reviewId, review1);
				System.out.println("Review Data Updated successfully");

				break;

			case 4:
				System.out.println("Enter Review Id to delete the Information");
				String id = scanner.next();

				boolean message = reviewService.deleteReview(id);
				System.out.println("Record Deleted Successfully");

				break;

			case 5:
				System.out.println("Enter Review ById :");
				scanner.nextLine();
				String reviwId = scanner.nextLine();

				Review review2 = reviewService.getReviewById(reviwId);
				System.out.println("Review Details With id :" + reviwId + "" + review2);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}

			}
		}
	}

	public static void orderDetailOperations() {

		while (true) {
			System.out.println(
					"Welcome To OrderDetail-Details\n  1.Create OrderDetail Details\n  2.Get All OrderDetail Data\n  3.Update OrderDetail Data\n  4.Delete OrderDetail Data\n  5.Get OrderDetail ById \n  6.Go Back to the Main menu");

			int input = scanner.nextInt();
			switch (input) {

			case 1:

				OrderDetail orderDetail = orderDetailInputs();
				boolean createOrderDetail = orderDetailService.createOrderDetail(orderDetail);
				System.out.println("OrderDetail Data has been created successfully");
				break;

			case 2:

				List<OrderDetail> OrderDetail1 = orderDetailService.getAllOrderDetail();

				for (OrderDetail OrderDetail : OrderDetail1) {
					System.out.println(OrderDetail);
				}
				System.out.println("Get all OrderDetail Records");
				break;

			case 3:

				System.out.println("Enter OrderDetail Id To Update the information");
				String orderDetailId = scanner.next();

				System.out.println("Enter  New ProductName :");
				scanner.nextLine();
				String newProductName = scanner.nextLine();
				// Product product = productService.getProductByName(productName);
				System.out.println("Enter New Quantity :");
				int newQuantity = scanner.nextInt();

				System.out.println("Enter OrderId ");
				Orders orders = ordersService.getOrderById("1");

				System.out.println("Enter ProductId ");
				Product product = productService.getProductById("1");

				OrderDetail orderDetail2 = new OrderDetail(input, product, orders, newQuantity, 'A');

				boolean updatedInfo = orderDetailService.updateOrderDetail(input, orderDetail2);
				System.out.println("OrderDetail Data Updated successfully");

				break;

			case 4:
				System.out.println("Enter OrderDetail Id to delete the information");
				int id = scanner.nextInt();

				boolean message = orderDetailService.deleteOrderDetail(id);
				System.out.println("Record Deleted Sucessfully");

				break;
			case 5:
				System.out.println("Enter OrderDetail Id :");
				int orderDetilId = scanner.nextInt();

				OrderDetail orderDetail3 = orderDetailService.getOrderDetailById(orderDetilId);
				System.out.println("Review Details With id :" + orderDetilId + "" + orderDetail3);
				break;

			case 6:
				System.out.println("Do you want to go back to the main menu? (yes/no)");
				String choice = scanner.next();
				if (choice.equalsIgnoreCase("yes")) {
					return;
				}

			}
		}
	}

}