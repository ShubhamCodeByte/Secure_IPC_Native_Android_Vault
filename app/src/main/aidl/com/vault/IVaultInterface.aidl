package com.vault;

interface IVaultInterface {
    /**
     * Sends the PIN to the isolated process for validation.
     * The UI never sees the validation logic.
     */
    boolean checkPin(String pin);
}