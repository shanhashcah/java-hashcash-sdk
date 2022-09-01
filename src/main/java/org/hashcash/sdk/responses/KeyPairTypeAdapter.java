package org.hashcash.sdk.responses;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import org.hashcash.sdk.KeyPair;

class KeyPairTypeAdapter extends TypeAdapter<KeyPair> {
  @Override
  public void write(JsonWriter out, KeyPair value) throws IOException {
    // Don't need this.
  }

  @Override
  public KeyPair read(JsonReader in) throws IOException {
    return KeyPair.fromAccountId(in.nextString());
  }
}
