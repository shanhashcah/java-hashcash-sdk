// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package com.hashcash.sdk.xdr;


import java.io.IOException;


// === xdr source ============================================================

//  enum EndSponsoringFutureReservesResultCode
//  {
//      // codes considered as "success" for the operation
//      END_SPONSORING_FUTURE_RESERVES_SUCCESS = 0,
//  
//      // codes considered as "failure" for the operation
//      END_SPONSORING_FUTURE_RESERVES_NOT_SPONSORED = -1
//  };

//  ===========================================================================
public enum EndSponsoringFutureReservesResultCode implements XdrElement {
  END_SPONSORING_FUTURE_RESERVES_SUCCESS(0),
  END_SPONSORING_FUTURE_RESERVES_NOT_SPONSORED(-1),
  ;
  private int mValue;

  EndSponsoringFutureReservesResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  public static EndSponsoringFutureReservesResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return END_SPONSORING_FUTURE_RESERVES_SUCCESS;
      case -1: return END_SPONSORING_FUTURE_RESERVES_NOT_SPONSORED;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, EndSponsoringFutureReservesResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
}
