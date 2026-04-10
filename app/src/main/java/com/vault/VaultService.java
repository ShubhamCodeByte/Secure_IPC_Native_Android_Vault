package com.vault;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class VaultService extends Service {
  private static final String TAG = "VaultService";

  // This is the implementation of our AIDL contract
  private final IVaultInterface.Stub mBinder = new IVaultInterface.Stub() {
    @Override
    public boolean checkPin(String pin) throws RemoteException {
      Log.d(TAG, "Received PIN check request in isolated process");

      // For Day 3, we use a simple Java check.
      // In Day 5, we will move this logic to C++!
      return "1234".equals(pin);
    }
  };

  @Override
  public IBinder onBind(Intent intent) {
    // When the UI connects, we give them the 'mBinder' bridge
    return mBinder;
  }
}