/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.vault;
public interface IVaultInterface extends android.os.IInterface
{
  /** Default implementation for IVaultInterface. */
  public static class Default implements com.vault.IVaultInterface
  {
    /**
     * Sends the PIN to the isolated process for validation.
     * The UI never sees the validation logic.
     */
    @Override public boolean checkPin(java.lang.String pin) throws android.os.RemoteException
    {
      return false;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.vault.IVaultInterface
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.vault.IVaultInterface interface,
     * generating a proxy if needed.
     */
    public static com.vault.IVaultInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.vault.IVaultInterface))) {
        return ((com.vault.IVaultInterface)iin);
      }
      return new com.vault.IVaultInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
        data.enforceInterface(descriptor);
      }
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
      }
      switch (code)
      {
        case TRANSACTION_checkPin:
        {
          java.lang.String _arg0;
          _arg0 = data.readString();
          boolean _result = this.checkPin(_arg0);
          reply.writeNoException();
          reply.writeInt(((_result)?(1):(0)));
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements com.vault.IVaultInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
       * Sends the PIN to the isolated process for validation.
       * The UI never sees the validation logic.
       */
      @Override public boolean checkPin(java.lang.String pin) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        boolean _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(pin);
          boolean _status = mRemote.transact(Stub.TRANSACTION_checkPin, _data, _reply, 0);
          _reply.readException();
          _result = (0!=_reply.readInt());
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
    }
    static final int TRANSACTION_checkPin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
  }
  public static final java.lang.String DESCRIPTOR = "com.vault.IVaultInterface";
  /**
   * Sends the PIN to the isolated process for validation.
   * The UI never sees the validation logic.
   */
  public boolean checkPin(java.lang.String pin) throws android.os.RemoteException;
}
