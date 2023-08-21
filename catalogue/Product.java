package catalogue;

import java.io.Serializable;

/**
 * Used to hold the following information about
 * a product: Product number, Description, Price and
 * Stock level.
 * @author  Mike Smith University of Brighton
 * @version 2.0
 */

public class Product implements Serializable
{
  private static final long serialVersionUID = 20092506;
  private String ProductNum;       // Product number
  private String Description;      // Description of product
  private double Price;            // Price of product
  private int    Quantity;         // Quantity involved

  private String Reviews;



  /**
   * Construct a product details
   * @param ProductNum Product number
   * @param Description Description of product
   * @param Price The price of the product
   * @param Quantity The Quantity of the product involved
   */
  public Product( String ProductNum, String Description,
                  double Price, int Quantity, String Review )
  {
    this.ProductNum  = ProductNum;     // Product number
    this.Description = Description;    // Description of product
    this.Price       = Price;          // Price of product
    this.Quantity    = Quantity;       // Quantity involved
    this.Reviews      = Review;         // Reviews
  }
  
  public String getProductNum()  {
    return ProductNum; }
  public String getDescription() {
    return Description; }
  public double getPrice()       {
    return Price; }
  public int    getQuantity()    {
    return Quantity; }
  public String getReviews()      {
    return Reviews;
  }



  public void setProductNum ( int productNum ){
    this.ProductNum = String.valueOf(productNum);
  }

  public void setQuantity( int Quantity )
  { 
    this.Quantity = Quantity;
  }

  public void setDescription(String description) {
    Description = description;
  }

  public void setPrice(double Price)
  {
    this.Price = Price;
  }

  public void setReview( String Review ) {
    this.Reviews = Review; }
  }


