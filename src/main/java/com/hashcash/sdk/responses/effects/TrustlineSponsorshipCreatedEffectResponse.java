package com.hashcash.sdk.responses.effects;

import com.google.gson.annotations.SerializedName;
import com.hashcash.sdk.Asset;

/**
 * Represents trustline_sponsorship_created effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see com.hashcash.sdk.requests.EffectsRequestBuilder
 * @see com.hashcash.sdk.Server#effects()
 */
public class TrustlineSponsorshipCreatedEffectResponse extends EffectResponse {
  @SerializedName("asset")
  private final String assetString;
  @SerializedName("sponsor")
  protected final String sponsor;

  public TrustlineSponsorshipCreatedEffectResponse(String assetString, String sponsor) {
    this.assetString = assetString;
    this.sponsor = sponsor;
  }

  public String getAssetString() {
    return assetString;
  }

  public Asset getAsset() {
    return Asset.create(assetString);
  }

  public String getSponsor() {
    return sponsor;
  }
}
