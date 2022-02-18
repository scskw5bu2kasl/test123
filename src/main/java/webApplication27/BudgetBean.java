package webApplication27;

import java.io.*;

public class BudgetBean implements Serializable {

  private String orgCd;
  private String pdcCd;
  private String yosanYm;
  private String amount;

  public BudgetBean() {
    orgCd = "";
    pdcCd = "";
    yosanYm = "";
    amount = "0";
  }

  public String getOrgCd() {
    return orgCd;
  }

  public void setOrgCd(String orgCd) {
    this.orgCd = orgCd;
  }

  public String getPdcCd() {
    return pdcCd;
  }

  public void setPdcCd(String pdcCd) {
    this.pdcCd = pdcCd;
  }

  public String getYosanYm() {
    return yosanYm;
  }

  public void setYosanYm(String yosanYm) {
    this.yosanYm = yosanYm;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }
}
