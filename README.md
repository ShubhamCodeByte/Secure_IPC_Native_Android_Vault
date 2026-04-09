# Secure IPC Native Android Vault 🛡️

An Android application that demonstrates system-level security architecture by simulating how the Android OS protects sensitive data (like Keystore) using isolated native layers and Inter-Process Communication (IPC).

## 📖 Overview
In standard Android applications, processing sensitive credentials inside the Java/Kotlin lifecycle leaves them vulnerable to JVM memory-scraping and runtime hooking. This project solves that by offloading cryptographic validation to a secure native environment. 

By utilizing **AIDL** (Android Interface Definition Language) and **JNI** (Java Native Interface), this app routes user input through a background daemon service and down into a C++ compiled layer, mimicking the hardware-backed isolation found in modern OS architectures.

## 🏗️ Architecture Flow

The system is broken down into four distinct boundaries:

1. **Client App (Java UI):** Captures the user's PIN but performs no validation.
2. **IPC Bridge (AIDL):** Securely transmits the PIN across process boundaries to a background daemon.
3. **Framework Service (Java Service):** Acts as the system-level daemon, receiving the IPC request and bridging it to native memory.
4. **Simulated Hardware Layer (C++ / JNI):** The only layer that knows the "Master PIN". It performs a secure string comparison in native memory and returns a simple boolean result, ensuring the actual secret never touches the Dalvik/ART virtual machine.

```text
[ User Input ] -> [ MainActivity (Java) ]
                             │
                             ▼  (AIDL IPC)
                             │
                  [ KeystoreService (Java) ]
                             │
                             ▼  (JNI Bridge)
                             │
                  [ native-lib (C++) ] -> Validates against hardcoded secret
