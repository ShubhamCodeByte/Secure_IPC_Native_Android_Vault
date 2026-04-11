package com.vault;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class VaultService extends Service {

    // 1. Tell Java to load the 'vault' library we built in C++
    static {
        System.loadLibrary("vault");
    }

    // 2. Declare the native function (The "Native" keyword is key)
    public native boolean checkPinNative(String pin);

    private final IVaultInterface.Stub mBinder = new IVaultInterface.Stub() {
        @Override
        public boolean checkPin(String pin) throws RemoteException {
            // 3. Now we call the C++ layer instead of Java!
            return checkPinNative(pin);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}