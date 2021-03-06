package com.sape.xi2014.listing;

import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Request;

public class ListingService {

  public static ListingService INSTANCE = new ListingService();

  private static final String API_KEY = "3iv3rdx5szjeq3m1vp6idwm9";

  // private static final String API_KEY = "cpb6iite9vw04dg0rusuis9u";

  /**
   * 
   * @param sellerId
   * @return
   * @throws Exception
   */
  public String getSellerReviews(String sellerId) throws Exception {
    String etsyResponse = null;
    String mode = System.getProperty("mode") != null ? System.getProperty("mode") : "esty";
    switch (mode) {
      case "proxy":
        etsyResponse =
            Request
                .Get(
                    "https://openapi.etsy.com/v2/users/".concat(sellerId).concat("/feedback/as-seller?api_key=")
                        .concat(API_KEY)).viaProxy(new HttpHost("localhost", 8888, "http")).execute().returnContent()
                .asString();
        break;
      case "apiary":
        etsyResponse =
            Request.Get("http://sagarprasad.apiary-mock.com/seller-feedback").execute().returnContent().asString();
        break;
      case "esty":
      default:
        etsyResponse =
            Request
                .Get(
                    "https://openapi.etsy.com/v2/users/".concat(sellerId).concat("/feedback/as-seller?api_key=")
                        .concat(API_KEY)).execute().returnContent().asString();
    }

    return etsyResponse;

  }


  /**
   * 
   * @param productID
   * @return
   * @throws Exception
   */
  public String getProductImages(String productID) throws Exception {
    String etsyResponse = null;
    String mode = System.getProperty("mode") != null ? System.getProperty("mode") : "esty";
    switch (mode) {
      case "proxy":
        etsyResponse =
            Request
                .Get(
                    "https://openapi.etsy.com/v2/listings/".concat(productID).concat("/images?&api_key=")
                        .concat(API_KEY)).viaProxy(new HttpHost("localhost", 8888, "http")).execute().returnContent()
                .asString();
        break;
      case "apiary":
        etsyResponse = Request.Get("http://sagarprasad.apiary-mock.com/images").execute().returnContent().asString();
        break;
      case "esty":
      default:
        etsyResponse =
            Request
                .Get(
                    "https://openapi.etsy.com/v2/listings/".concat(productID).concat("/images?&api_key=")
                        .concat(API_KEY)).execute().returnContent().asString();
    }


    return etsyResponse;

  }

}
