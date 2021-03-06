// Copyright 2018 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.firebase.storage.network;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.internal.StorageReferenceUri;
import java.util.Collections;
import java.util.Map;

/** A network request that returns bytes of a gcs object. */
public class GetNetworkRequest extends NetworkRequest {
  @SuppressWarnings("unused")
  private static final String TAG = "GetNetworkRequest";

  public GetNetworkRequest(
      @NonNull StorageReferenceUri storageReferenceUri, @NonNull FirebaseApp app, long startByte) {
    super(storageReferenceUri, app);
    if (startByte != 0) {
      super.setCustomHeader("Range", "bytes=" + startByte + "-");
    }
  }

  @Override
  @NonNull
  protected String getAction() {
    return GET;
  }

  @Override
  @NonNull
  protected Map<String, String> getQueryParameters() {
    return Collections.singletonMap("alt", "media");
  }
}
