package com.hashcash.sdk.responses.operations;

import com.google.common.base.Optional;
import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;
import com.hashcash.sdk.responses.MuxedAccount;

import java.math.BigInteger;

import static com.hashcash.sdk.Asset.create;

/**
 * Represents ChangeTrust operation response.
 * @see <a href="https://developers.stellar.org/api/resources/operations/" target="_blank">Operation documentation</a>
 * @see com.hashcash.sdk.requests.OperationsRequestBuilder
 * @see com.hashcash.sdk.Server#operations()
 */
public class ChangeTrustOperationResponse extends OperationResponse {
  @SerializedName("trustor")
  private String trustor;
  @SerializedName("trustor_muxed")
  private String trustorMuxed;
  @SerializedName("trustor_muxed_id")
  private BigInteger trustorMuxedId;
  @SerializedName("trustee")
  private String trustee;
  @SerializedName("asset_type")
  private String assetType;
  @SerializedName("asset_code")
  private String assetCode;
  @SerializedName("asset_issuer")
  private String assetIssuer;
  @SerializedName("limit")
  private String limit;
  @SerializedName("liquidity_pool_id")
  private String liquidityPoolId;

  public Optional<MuxedAccount> getTrustorMuxed() {
    if (this.trustorMuxed == null || this.trustorMuxed.isEmpty()) {
      return Optional.absent();
    }
    return Optional.of(new MuxedAccount(this.trustorMuxed, this.trustor, this.trustorMuxedId));
  }

  public String getTrustor() {
    return trustor;
  }

  public String getTrustee() {
    return trustee;
  }

  public String getLimit() {
    return limit;
  }

  public Asset getAsset() {
    return create(assetType, assetCode, assetIssuer, liquidityPoolId);
  }

}
