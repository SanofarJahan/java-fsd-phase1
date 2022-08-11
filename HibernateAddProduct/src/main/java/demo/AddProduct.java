package demo;

public class AddProduct {
	  private int ProductId;
	  private String PName;
	  private String Category;
	  private String Price;
	  private String Quantity;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	public AddProduct(String pName, String category, String price, String quantity) {
		super();
		PName = pName;
		Category = category;
		Price = price;
		Quantity = quantity;
	}
	  
	}
