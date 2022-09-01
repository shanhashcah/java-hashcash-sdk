// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  struct LiquidityPoolEntry
//  {
//      PoolID liquidityPoolID;
//  
//      union switch (LiquidityPoolType type)
//      {
//      case LIQUIDITY_POOL_CONSTANT_PRODUCT:
//          struct
//          {
//              LiquidityPoolConstantProductParameters params;
//  
//              int64 reserveA;        // amount of A in the pool
//              int64 reserveB;        // amount of B in the pool
//              int64 totalPoolShares; // total number of pool shares issued
//              int64 poolSharesTrustLineCount; // number of trust lines for the
//                                              // associated pool shares
//          } constantProduct;
//      }
//      body;
//  };

//  ===========================================================================
public class LiquidityPoolEntry implements XdrElement {
  public LiquidityPoolEntry () {}
  private PoolID liquidityPoolID;
  public PoolID getLiquidityPoolID() {
    return this.liquidityPoolID;
  }
  public void setLiquidityPoolID(PoolID value) {
    this.liquidityPoolID = value;
  }
  private LiquidityPoolEntryBody body;
  public LiquidityPoolEntryBody getBody() {
    return this.body;
  }
  public void setBody(LiquidityPoolEntryBody value) {
    this.body = value;
  }
  public static void encode(XdrDataOutputStream stream, LiquidityPoolEntry encodedLiquidityPoolEntry) throws IOException{
    PoolID.encode(stream, encodedLiquidityPoolEntry.liquidityPoolID);
    LiquidityPoolEntryBody.encode(stream, encodedLiquidityPoolEntry.body);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static LiquidityPoolEntry decode(XdrDataInputStream stream) throws IOException {
    LiquidityPoolEntry decodedLiquidityPoolEntry = new LiquidityPoolEntry();
    decodedLiquidityPoolEntry.liquidityPoolID = PoolID.decode(stream);
    decodedLiquidityPoolEntry.body = LiquidityPoolEntryBody.decode(stream);
    return decodedLiquidityPoolEntry;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.liquidityPoolID, this.body);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LiquidityPoolEntry)) {
      return false;
    }

    LiquidityPoolEntry other = (LiquidityPoolEntry) object;
    return Objects.equal(this.liquidityPoolID, other.liquidityPoolID) && Objects.equal(this.body, other.body);
  }

  public static final class Builder {
    private PoolID liquidityPoolID;
    private LiquidityPoolEntryBody body;

    public Builder liquidityPoolID(PoolID liquidityPoolID) {
      this.liquidityPoolID = liquidityPoolID;
      return this;
    }

    public Builder body(LiquidityPoolEntryBody body) {
      this.body = body;
      return this;
    }

    public LiquidityPoolEntry build() {
      LiquidityPoolEntry val = new LiquidityPoolEntry();
      val.setLiquidityPoolID(liquidityPoolID);
      val.setBody(body);
      return val;
    }
  }

  public static class LiquidityPoolEntryBody {
    public LiquidityPoolEntryBody () {}
    LiquidityPoolType type;
    public LiquidityPoolType getDiscriminant() {
      return this.type;
    }
    public void setDiscriminant(LiquidityPoolType value) {
      this.type = value;
    }
    private LiquidityPoolEntryConstantProduct constantProduct;
    public LiquidityPoolEntryConstantProduct getConstantProduct() {
      return this.constantProduct;
    }
    public void setConstantProduct(LiquidityPoolEntryConstantProduct value) {
      this.constantProduct = value;
    }

    public static final class Builder {
      private LiquidityPoolType discriminant;
      private LiquidityPoolEntryConstantProduct constantProduct;

      public Builder discriminant(LiquidityPoolType discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder constantProduct(LiquidityPoolEntryConstantProduct constantProduct) {
        this.constantProduct = constantProduct;
        return this;
      }

      public LiquidityPoolEntryBody build() {
        LiquidityPoolEntryBody val = new LiquidityPoolEntryBody();
        val.setDiscriminant(discriminant);
        val.setConstantProduct(constantProduct);
        return val;
      }
    }

    public static void encode(XdrDataOutputStream stream, LiquidityPoolEntryBody encodedLiquidityPoolEntryBody) throws IOException {
    //Xdrgen::AST::Identifier
    //LiquidityPoolType
    stream.writeInt(encodedLiquidityPoolEntryBody.getDiscriminant().getValue());
    switch (encodedLiquidityPoolEntryBody.getDiscriminant()) {
    case LIQUIDITY_POOL_CONSTANT_PRODUCT:
    LiquidityPoolEntryConstantProduct.encode(stream, encodedLiquidityPoolEntryBody.constantProduct);
    break;
    }
    }
    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }
    public static LiquidityPoolEntryBody decode(XdrDataInputStream stream) throws IOException {
    LiquidityPoolEntryBody decodedLiquidityPoolEntryBody = new LiquidityPoolEntryBody();
    LiquidityPoolType discriminant = LiquidityPoolType.decode(stream);
    decodedLiquidityPoolEntryBody.setDiscriminant(discriminant);
    switch (decodedLiquidityPoolEntryBody.getDiscriminant()) {
    case LIQUIDITY_POOL_CONSTANT_PRODUCT:
    decodedLiquidityPoolEntryBody.constantProduct = LiquidityPoolEntryConstantProduct.decode(stream);
    break;
    }
      return decodedLiquidityPoolEntryBody;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.constantProduct, this.type);
    }
    @Override
    public boolean equals(Object object) {
      if (!(object instanceof LiquidityPoolEntryBody)) {
        return false;
      }

      LiquidityPoolEntryBody other = (LiquidityPoolEntryBody) object;
      return Objects.equal(this.constantProduct, other.constantProduct) && Objects.equal(this.type, other.type);
    }

    public static class LiquidityPoolEntryConstantProduct {
      public LiquidityPoolEntryConstantProduct () {}
      private LiquidityPoolConstantProductParameters params;
      public LiquidityPoolConstantProductParameters getParams() {
        return this.params;
      }
      public void setParams(LiquidityPoolConstantProductParameters value) {
        this.params = value;
      }
      private Int64 reserveA;
      public Int64 getReserveA() {
        return this.reserveA;
      }
      public void setReserveA(Int64 value) {
        this.reserveA = value;
      }
      private Int64 reserveB;
      public Int64 getReserveB() {
        return this.reserveB;
      }
      public void setReserveB(Int64 value) {
        this.reserveB = value;
      }
      private Int64 totalPoolShares;
      public Int64 getTotalPoolShares() {
        return this.totalPoolShares;
      }
      public void setTotalPoolShares(Int64 value) {
        this.totalPoolShares = value;
      }
      private Int64 poolSharesTrustLineCount;
      public Int64 getPoolSharesTrustLineCount() {
        return this.poolSharesTrustLineCount;
      }
      public void setPoolSharesTrustLineCount(Int64 value) {
        this.poolSharesTrustLineCount = value;
      }
      public static void encode(XdrDataOutputStream stream, LiquidityPoolEntryConstantProduct encodedLiquidityPoolEntryConstantProduct) throws IOException{
        LiquidityPoolConstantProductParameters.encode(stream, encodedLiquidityPoolEntryConstantProduct.params);
        Int64.encode(stream, encodedLiquidityPoolEntryConstantProduct.reserveA);
        Int64.encode(stream, encodedLiquidityPoolEntryConstantProduct.reserveB);
        Int64.encode(stream, encodedLiquidityPoolEntryConstantProduct.totalPoolShares);
        Int64.encode(stream, encodedLiquidityPoolEntryConstantProduct.poolSharesTrustLineCount);
      }
      public void encode(XdrDataOutputStream stream) throws IOException {
        encode(stream, this);
      }
      public static LiquidityPoolEntryConstantProduct decode(XdrDataInputStream stream) throws IOException {
        LiquidityPoolEntryConstantProduct decodedLiquidityPoolEntryConstantProduct = new LiquidityPoolEntryConstantProduct();
        decodedLiquidityPoolEntryConstantProduct.params = LiquidityPoolConstantProductParameters.decode(stream);
        decodedLiquidityPoolEntryConstantProduct.reserveA = Int64.decode(stream);
        decodedLiquidityPoolEntryConstantProduct.reserveB = Int64.decode(stream);
        decodedLiquidityPoolEntryConstantProduct.totalPoolShares = Int64.decode(stream);
        decodedLiquidityPoolEntryConstantProduct.poolSharesTrustLineCount = Int64.decode(stream);
        return decodedLiquidityPoolEntryConstantProduct;
      }
      @Override
      public int hashCode() {
        return Objects.hashCode(this.params, this.reserveA, this.reserveB, this.totalPoolShares, this.poolSharesTrustLineCount);
      }
      @Override
      public boolean equals(Object object) {
        if (!(object instanceof LiquidityPoolEntryConstantProduct)) {
          return false;
        }

        LiquidityPoolEntryConstantProduct other = (LiquidityPoolEntryConstantProduct) object;
        return Objects.equal(this.params, other.params) && Objects.equal(this.reserveA, other.reserveA) && Objects.equal(this.reserveB, other.reserveB) && Objects.equal(this.totalPoolShares, other.totalPoolShares) && Objects.equal(this.poolSharesTrustLineCount, other.poolSharesTrustLineCount);
      }

      public static final class Builder {
        private LiquidityPoolConstantProductParameters params;
        private Int64 reserveA;
        private Int64 reserveB;
        private Int64 totalPoolShares;
        private Int64 poolSharesTrustLineCount;

        public Builder params(LiquidityPoolConstantProductParameters params) {
          this.params = params;
          return this;
        }

        public Builder reserveA(Int64 reserveA) {
          this.reserveA = reserveA;
          return this;
        }

        public Builder reserveB(Int64 reserveB) {
          this.reserveB = reserveB;
          return this;
        }

        public Builder totalPoolShares(Int64 totalPoolShares) {
          this.totalPoolShares = totalPoolShares;
          return this;
        }

        public Builder poolSharesTrustLineCount(Int64 poolSharesTrustLineCount) {
          this.poolSharesTrustLineCount = poolSharesTrustLineCount;
          return this;
        }

        public LiquidityPoolEntryConstantProduct build() {
          LiquidityPoolEntryConstantProduct val = new LiquidityPoolEntryConstantProduct();
          val.setParams(params);
          val.setReserveA(reserveA);
          val.setReserveB(reserveB);
          val.setTotalPoolShares(totalPoolShares);
          val.setPoolSharesTrustLineCount(poolSharesTrustLineCount);
          return val;
        }
      }

    }
  }
}
