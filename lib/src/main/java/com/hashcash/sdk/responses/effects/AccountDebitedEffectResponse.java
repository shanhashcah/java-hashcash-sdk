package com.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;

import static com.hashcash.sdk.Asset.create;

/**
 * Represents account_debited effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class AccountDebitedEffectResponse extends EffectResponse {
  @SerializedName("amount")
  protected final String amount;
  @SerializedName("asset_type")
  protected final String assetType;
  @SerializedName("asset_code")
  protected final String assetCode;
  @SerializedName("asset_issuer")
  protected final String assetIssuer;

  AccountDebitedEffectResponse(String amount, String assetType, String assetCode, String assetIssuer) {
    this.amount = amount;
    this.assetType = assetType;
    this.assetCode = assetCode;
    this.assetIssuer = assetIssuer;
  }

  public String getAmount() {
    return amount;
  }

  public Asset getAsset() {
    return create(assetType, assetCode, assetIssuer);
  }
}
