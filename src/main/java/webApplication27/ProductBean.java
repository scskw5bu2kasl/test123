package webApplication27;

import java.io.*;

public class ProductBean implements Serializable {

  private String productCd;
  private String productNm;
  private String productClass;
  private String modelNum;
  private String tanka;

  /** Creates a new instance of UserBean */
  public ProductBean() {
    productCd = "";
    productNm = "";
    productClass = "";
    modelNum = "";
    tanka = "0";
  }

  public String getProductCd() {
    return productCd;
  }

  public void setProductCd(String productCd) {
    this.productCd = productCd;
  }

  public String getProductNm() {
    return productNm;
  }

  public void setProductNm(String productNm) {
    this.productNm = productNm;
  }

  public String getProductClass() {
    return productClass;
  }

  public void setProductClass(String productClass) {
    this.productClass = productClass;
  }

  public String getModelNum() {
    return modelNum;
  }

  public void setModelNum(String modelNum) {
    this.modelNum = modelNum;
  }

  public String getTanka() {
    return tanka;
  }

  public void setTanka(String tanka) {
    this.tanka = tanka;
  }
}
