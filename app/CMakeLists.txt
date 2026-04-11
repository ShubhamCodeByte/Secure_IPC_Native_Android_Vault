cmake_minimum_required(VERSION 3.22.1)

# Defines the name of our library
project("vault")

# Tells CMake to create a library called 'vault' from our C++ file
# add_library(vault SHARED native-lib.cpp)   this was creationg the issue as the location of the c++ file is in different space 

add_library(vault SHARED src/main/cpp/native-lib.cpp)


# Links the standard Android logging library so we can see C++ logs
find_library(log-lib log)
target_link_libraries(vault ${log-lib})