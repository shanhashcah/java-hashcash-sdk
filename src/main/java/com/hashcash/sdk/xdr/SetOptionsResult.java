// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union SetOptionsResult switch (SetOptionsResultCode code)
//  {
//  case SET_OPTIONS_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class SetOptionsResult implements XdrElement {
  public SetOptionsResult () {}
  SetOptionsResultCode code;
  public SetOptionsResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(SetOptionsResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private SetOptionsResultCode discriminant;

    public Builder discriminant(SetOptionsResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public SetOptionsResult build() {
      SetOptionsResult val = new SetOptionsResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SetOptionsResult encodedSetOptionsResult) throws IOException {
  //Xdrgen::AST::Identifier
  //SetOptionsResultCode
  stream.writeInt(encodedSetOptionsResult.getDiscriminant().getValue());
  switch (encodedSetOptionsResult.getDiscriminant()) {
  case SET_OPTIONS_SUCCESS:
  break;
  default:
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static SetOptionsResult decode(XdrDataInputStream stream) throws IOException {
  SetOptionsResult decodedSetOptionsResult = new SetOptionsResult();
  SetOptionsResultCode discriminant = SetOptionsResultCode.decode(stream);
  decodedSetOptionsResult.setDiscriminant(discriminant);
  switch (decodedSetOptionsResult.getDiscriminant()) {
  case SET_OPTIONS_SUCCESS:
  break;
  default:
  break;
  }
    return decodedSetOptionsResult;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.code);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SetOptionsResult)) {
      return false;
    }

    SetOptionsResult other = (SetOptionsResult) object;
    return Objects.equal(this.code, other.code);
  }
}
