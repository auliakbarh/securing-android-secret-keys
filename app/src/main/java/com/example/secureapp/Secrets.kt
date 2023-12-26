package com.example.secureapp

class Secrets {

    // Method calls will be added by gradle task hideSecret
    // Example : external fun getWellHiddenSecret(packageName: String): String

    companion object {
        init {
            System.loadLibrary("secrets")
        }
    }

    external fun getAPI_KEY(packageName: String): String

    external fun getBASE_URL(packageName: String): String
}