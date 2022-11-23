package com.cashback.test.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;
@Entity(tableName = "offers")
public class OfferModel implements Serializable {

  @SerializedName("promotionDetailsId")
  @Expose
  @PrimaryKey
  private Integer promotionDetailsId;

  @SerializedName("promotionId")
  @Expose
  @ColumnInfo(name = "promotionId")
  private Integer promotionId;
  @SerializedName("productId")
  @Expose
  @ColumnInfo(name = "productId")
  private Integer productId;
  @SerializedName("promotionDescription")
  @Expose
  @ColumnInfo(name = "promotionDescription")
  private String promotionDescription;
  @SerializedName("promotionStatus")
  @Expose
  @ColumnInfo(name = "promotionStatus")
  private String promotionStatus;
  @SerializedName("promotionClaimLimit")
  @Expose
  @ColumnInfo(name = "promotionClaimLimit")
  private Integer promotionClaimLimit;
  @SerializedName("productCashBack")
  @Expose
  @ColumnInfo(name = "productCashBack")
  private Integer productCashBack;
  @SerializedName("promotionDetailsRanking")
  @Expose
  @ColumnInfo(name = "promotionDetailsRanking")
  private Integer promotionDetailsRanking;
  @SerializedName("productImage")
  @Expose
  @ColumnInfo(name = "productImage")
  private String productImage;
  @SerializedName("offerStartDate")
  @Expose
  @ColumnInfo(name = "offerStartDate")
  private String offerStartDate;
  @SerializedName("offerEndDate")
  @Expose
  @ColumnInfo(name = "offerEndDate")
  private String offerEndDate;
  @SerializedName("productBarcode")
  @Expose
  @ColumnInfo(name = "productBarcode")
  private Long productBarcode;
  @SerializedName("productName")
  @Expose
  @ColumnInfo(name = "productName")
  private String productName;
  @SerializedName("productSize")
  @Expose
  @ColumnInfo(name = "productSize")
  private String productSize;
  @SerializedName("promotion_details_retailer_commission")
  @Expose
  @ColumnInfo(name = "promotion_details_retailer_commission")
  private Double promotionDetailsRetailerCommission;
  @SerializedName("promotionDetailsHotDealsIndicator")
  @Expose
  @ColumnInfo(name = "promotionDetailsHotDealsIndicator")
  private String promotionDetailsHotDealsIndicator;
  private final static long serialVersionUID = -1052993392936288130L;

  public Integer getPromotionDetailsId() { return promotionDetailsId; }

  public void setPromotionDetailsId(Integer promotionDetailsId) {
    this.promotionDetailsId = promotionDetailsId;
  }

  public Integer getPromotionId() { return promotionId; }

  public void setPromotionId(Integer promotionId) {
    this.promotionId = promotionId;
  }

  public Integer getProductId() { return productId; }

  public void setProductId(Integer productId) { this.productId = productId; }

  public String getPromotionDescription() { return promotionDescription; }

  public void setPromotionDescription(String promotionDescription) {
    this.promotionDescription = promotionDescription;
  }

  public String getPromotionStatus() { return promotionStatus; }

  public void setPromotionStatus(String promotionStatus) {
    this.promotionStatus = promotionStatus;
  }

  public Integer getPromotionClaimLimit() { return promotionClaimLimit; }

  public void setPromotionClaimLimit(Integer promotionClaimLimit) {
    this.promotionClaimLimit = promotionClaimLimit;
  }

  public Integer getProductCashBack() { return productCashBack; }

  public void setProductCashBack(Integer productCashBack) {
    this.productCashBack = productCashBack;
  }

  public Integer getPromotionDetailsRanking() {
    return promotionDetailsRanking;
  }

  public void setPromotionDetailsRanking(Integer promotionDetailsRanking) {
    this.promotionDetailsRanking = promotionDetailsRanking;
  }

  public String getProductImage() { return productImage; }

  public void setProductImage(String productImage) {
    this.productImage = productImage;
  }

  public String getOfferStartDate() { return offerStartDate; }

  public void setOfferStartDate(String offerStartDate) {
    this.offerStartDate = offerStartDate;
  }

  public String getOfferEndDate() { return offerEndDate; }

  public void setOfferEndDate(String offerEndDate) {
    this.offerEndDate = offerEndDate;
  }

  public Long getProductBarcode() { return productBarcode; }

  public void setProductBarcode(Long productBarcode) {
    this.productBarcode = productBarcode;
  }

  public String getProductName() { return productName; }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductSize() { return productSize; }

  public void setProductSize(String productSize) {
    this.productSize = productSize;
  }

  public Double getPromotionDetailsRetailerCommission() {
    return promotionDetailsRetailerCommission;
  }

  public void setPromotionDetailsRetailerCommission(
      Double promotionDetailsRetailerCommission) {
    this.promotionDetailsRetailerCommission =
        promotionDetailsRetailerCommission;
  }

  public String getPromotionDetailsHotDealsIndicator() {
    return promotionDetailsHotDealsIndicator;
  }

  public void setPromotionDetailsHotDealsIndicator(
      String promotionDetailsHotDealsIndicator) {
    this.promotionDetailsHotDealsIndicator = promotionDetailsHotDealsIndicator;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(OfferModel.class.getName())
        .append('@')
        .append(Integer.toHexString(System.identityHashCode(this)))
        .append('[');
    sb.append("promotionDetailsId");
    sb.append('=');
    sb.append(((this.promotionDetailsId == null) ? "<null>"
                                                 : this.promotionDetailsId));
    sb.append(',');
    sb.append("promotionId");
    sb.append('=');
    sb.append(((this.promotionId == null) ? "<null>" : this.promotionId));
    sb.append(',');
    sb.append("productId");
    sb.append('=');
    sb.append(((this.productId == null) ? "<null>" : this.productId));
    sb.append(',');
    sb.append("promotionDescription");
    sb.append('=');
    sb.append(((this.promotionDescription == null)
                   ? "<null>"
                   : this.promotionDescription));
    sb.append(',');
    sb.append("promotionStatus");
    sb.append('=');
    sb.append(
        ((this.promotionStatus == null) ? "<null>" : this.promotionStatus));
    sb.append(',');
    sb.append("promotionClaimLimit");
    sb.append('=');
    sb.append(((this.promotionClaimLimit == null) ? "<null>"
                                                  : this.promotionClaimLimit));
    sb.append(',');
    sb.append("productCashBack");
    sb.append('=');
    sb.append(
        ((this.productCashBack == null) ? "<null>" : this.productCashBack));
    sb.append(',');
    sb.append("promotionDetailsRanking");
    sb.append('=');
    sb.append(((this.promotionDetailsRanking == null)
                   ? "<null>"
                   : this.promotionDetailsRanking));
    sb.append(',');
    sb.append("productImage");
    sb.append('=');
    sb.append(((this.productImage == null) ? "<null>" : this.productImage));
    sb.append(',');
    sb.append("offerStartDate");
    sb.append('=');
    sb.append(((this.offerStartDate == null) ? "<null>" : this.offerStartDate));
    sb.append(',');
    sb.append("offerEndDate");
    sb.append('=');
    sb.append(((this.offerEndDate == null) ? "<null>" : this.offerEndDate));
    sb.append(',');
    sb.append("productBarcode");
    sb.append('=');
    sb.append(((this.productBarcode == null) ? "<null>" : this.productBarcode));
    sb.append(',');
    sb.append("productName");
    sb.append('=');
    sb.append(((this.productName == null) ? "<null>" : this.productName));
    sb.append(',');
    sb.append("productSize");
    sb.append('=');
    sb.append(((this.productSize == null) ? "<null>" : this.productSize));
    sb.append(',');
    sb.append("promotionDetailsRetailerCommission");
    sb.append('=');
    sb.append(((this.promotionDetailsRetailerCommission == null)
                   ? "<null>"
                   : this.promotionDetailsRetailerCommission));
    sb.append(',');
    sb.append("promotionDetailsHotDealsIndicator");
    sb.append('=');
    sb.append(((this.promotionDetailsHotDealsIndicator == null)
                   ? "<null>"
                   : this.promotionDetailsHotDealsIndicator));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.promotionDetailsRanking == null)
                                   ? 0
                                   : this.promotionDetailsRanking.hashCode()));
    result =
        ((result * 31) +
         ((this.offerStartDate == null) ? 0 : this.offerStartDate.hashCode()));
    result = ((result * 31) + ((this.promotionDetailsId == null)
                                   ? 0
                                   : this.promotionDetailsId.hashCode()));
    result = ((result * 31) +
              ((this.promotionDetailsHotDealsIndicator == null)
                   ? 0
                   : this.promotionDetailsHotDealsIndicator.hashCode()));
    result = ((result * 31) +
              ((this.productId == null) ? 0 : this.productId.hashCode()));
    result = ((result * 31) +
              ((this.productSize == null) ? 0 : this.productSize.hashCode()));
    result = ((result * 31) + ((this.promotionClaimLimit == null)
                                   ? 0
                                   : this.promotionClaimLimit.hashCode()));
    result = ((result * 31) +
              ((this.promotionId == null) ? 0 : this.promotionId.hashCode()));
    result = ((result * 31) +
              ((this.productName == null) ? 0 : this.productName.hashCode()));
    result = ((result * 31) + ((this.promotionStatus == null)
                                   ? 0
                                   : this.promotionStatus.hashCode()));
    result = ((result * 31) + ((this.productCashBack == null)
                                   ? 0
                                   : this.productCashBack.hashCode()));
    result = ((result * 31) + ((this.promotionDescription == null)
                                   ? 0
                                   : this.promotionDescription.hashCode()));
    result = ((result * 31) +
              ((this.productImage == null) ? 0 : this.productImage.hashCode()));
    result =
        ((result * 31) +
         ((this.productBarcode == null) ? 0 : this.productBarcode.hashCode()));
    result = ((result * 31) +
              ((this.offerEndDate == null) ? 0 : this.offerEndDate.hashCode()));
    result = ((result * 31) +
              ((this.promotionDetailsRetailerCommission == null)
                   ? 0
                   : this.promotionDetailsRetailerCommission.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof OfferModel) == false) {
      return false;
    }
    OfferModel rhs = ((OfferModel)other);
    return (
        (((((((((((((((Objects.equals(this.promotionDetailsRanking,
                                      rhs.promotionDetailsRanking)) &&
                      (Objects.equals(this.offerStartDate,
                                      rhs.offerStartDate))) &&
                     (Objects.equals(this.promotionDetailsId,
                                     rhs.promotionDetailsId))) &&
                    (Objects.equals(this.promotionDetailsHotDealsIndicator,
                                    rhs.promotionDetailsHotDealsIndicator))) &&
                   (Objects.equals(this.productId, rhs.productId))) &&
                  (Objects.equals(this.productSize, rhs.productSize))) &&
                 (Objects.equals(this.promotionClaimLimit,
                                 rhs.promotionClaimLimit))) &&
                (Objects.equals(this.promotionId, rhs.promotionId))) &&
               (Objects.equals(this.productName, rhs.productName))) &&
              (Objects.equals(this.promotionStatus, rhs.promotionStatus))) &&
             (Objects.equals(this.productCashBack, rhs.productCashBack))) &&
            (Objects.equals(this.promotionDescription,
                            rhs.promotionDescription))) &&
           (Objects.equals(this.productImage, rhs.productImage))) &&
          (Objects.equals(this.productBarcode, rhs.productBarcode))) &&
         (Objects.equals(this.offerEndDate, rhs.offerEndDate))) &&
        (Objects.equals(this.promotionDetailsRetailerCommission,
                        rhs.promotionDetailsRetailerCommission)));
  }
}
