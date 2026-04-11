#include <jni.h>
#include <string>
#include <cstring> // For strcmp

extern "C" JNIEXPORT jboolean JNICALL
Java_com_vault_VaultService_checkPinNative(JNIEnv* env, jobject /* this */, jstring pin) {
    // 1. Convert the Java String (jstring) to a C++ string (char*)
    const char* nativePin = env->GetStringUTFChars(pin, 0);
    
    // 2. The "Hardcoded" Secret (In a real app, this would be encrypted)
    const char* secretPin = "1234";
    
    // 3. Compare the strings
    jboolean result = JNI_FALSE;
    if (std::strcmp(nativePin, secretPin) == 0) {
        result = JNI_TRUE;
    }
    
    // 4. CRITICAL: Clean up memory (Java doesn't do this for us in C++)
    env->ReleaseStringUTFChars(pin, nativePin);
    
    return result;
}