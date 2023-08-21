package catalogue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Formatter;
import java.util.Locale;

/**
 * A collection of products from the CatShop.
 *  used to record the products that are to be/
 *   wished to be purchased.
 * @author  Mike Smith University of Brighton
 * @version 2.2
 *
 */
public class Basket extends ArrayList<Product> implements Serializable {
  private static final long serialVersionUID = 1;
  private int theOrderNum = 0;          // Order number

  private double totalCost = 0.0; // total cosst of products in the basket

  public double getTotalCost() {
    return totalCost;
  }

  private double discount = 0.0;  // discount offered

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public double getDiscount() {
    return (discount);
  }


  /**
   * Constructor for a basket which is
   * used to represent a customer order/ wish list
   */
  public Basket() {
    theOrderNum = 0;
  }

  /**
   * Set the customers unique order number
   * Valid order Numbers 1 .. N
   *
   * @param anOrderNum A unique order number
   */
  public void setOrderNum(int anOrderNum) {
    if (anOrderNum >= 1) {
      theOrderNum = anOrderNum;
    } else {
      throw new IllegalArgumentException("Invalid order number");
    }
  }

  /**
   * Returns the customers unique order number
   *
   * @return the customers order number
   */
  public int getOrderNum() {
    return theOrderNum;
  }

  /**
   * Add a product to the Basket.
   * Product is appended to the end of the existing products
   * in the basket.
   *
   * @param pr A product to be added to the basket
   * @return true if successfully adds the product
   */
  // Will be in the Java doc for Basket
  @Override
  public boolean add(Product pr) {
    boolean added = super.add(pr);// Call add in ArrayList
    if (added) {
      totalCost += pr.getPrice() * pr.getQuantity();
    }
    return added;
  }

  /**
   * Returns a description of the products in the basket suitable for printing.
   *
   * @return a string description of the basket products
   */

  public String getDetails() {
    Locale uk = Locale.UK;
    StringBuilder sb = new StringBuilder(256);
    Formatter fr = new Formatter(sb, uk);
    String csign = (Currency.getInstance(uk)).getSymbol();


    double total = 0.00;
    for (Product pr : this) {
      int number = pr.getQuantity();
      fr.format("%-7s", pr.getProductNum());
      fr.format("%-14.14s ", pr.getDescription());
      fr.format("(%3d) ", number);
      fr.format("%s%7.2f", csign, pr.getPrice() * number);
      fr.format("\n");
      total += pr.getPrice() * number;
    }

    if (theOrderNum != 0) {
      fr.format("Order number: %03d\n", theOrderNum);
    }

    // Calculating total with discount
    double discountedTotal = total - (total * (discount / 100.0));

    fr.format("----------------------------\n");
    fr.format("Total (before discount): %s%7.2f\n", csign, total);
    fr.format("Discount: %7.2f%%\n", discount);
    fr.format("Total (after discount):  %s%7.2f\n", csign, discountedTotal);

    fr.close();
    return sb.toString();
  }
}
