// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package org.hashcash.sdk.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  enum ManageDataResultCode
//  {
//      // codes considered as "success" for the operation
//      MANAGE_DATA_SUCCESS = 0,
//      // codes considered as "failure" for the operation
//      MANAGE_DATA_NOT_SUPPORTED_YET =
//          -1, // The network hasn't moved to this protocol change yet
//      MANAGE_DATA_NAME_NOT_FOUND =
//          -2, // Trying to remove a Data Entry that isn't there
//      MANAGE_DATA_LOW_RESERVE = -3, // not enough funds to create a new Data Entry
//      MANAGE_DATA_INVALID_NAME = -4 // Name not a valid string
//  };

//  ===========================================================================
public enum ManageDataResultCode  {
  MANAGE_DATA_SUCCESS(0),
  MANAGE_DATA_NOT_SUPPORTED_YET(-1),
  MANAGE_DATA_NAME_NOT_FOUND(-2),
  MANAGE_DATA_LOW_RESERVE(-3),
  MANAGE_DATA_INVALID_NAME(-4),
  ;
  private int mValue;

  ManageDataResultCode(int value) {
      mValue = value;
  }

  public int getValue() {
      return mValue;
  }

  static ManageDataResultCode decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0: return MANAGE_DATA_SUCCESS;
      case -1: return MANAGE_DATA_NOT_SUPPORTED_YET;
      case -2: return MANAGE_DATA_NAME_NOT_FOUND;
      case -3: return MANAGE_DATA_LOW_RESERVE;
      case -4: return MANAGE_DATA_INVALID_NAME;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  static void encode(XdrDataOutputStream stream, ManageDataResultCode value) throws IOException {
    stream.writeInt(value.getValue());
  }
}
