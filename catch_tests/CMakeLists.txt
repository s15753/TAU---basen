cmake_minimum_required(VERSION 3.5)

project(catch2_test LANGUAGES CXX VERSION 0.0.1)
set(CMAKE_CXX_FLAGS "-std=c++17 -Wall -Wextra")
include_directories("${PROJECT_SOURCE_DIR}/src")
file(GLOB_RECURSE lib_SOURCES "src/*.cpp" "src/*/*.cpp")
file(GLOB_RECURSE test_SOURCES "test/*.cpp")
add_library(fibonacci SHARED ${lib_SOURCES})

find_package(Catch2 REQUIRED)

add_executable(catch2_test ${test_SOURCES})
target_link_libraries(catch2_test Catch2::Catch2)

include(CTest)
include(Catch)
catch_discover_tests(catch2_test)
