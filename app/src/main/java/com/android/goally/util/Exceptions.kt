package com.android.goally.util

import java.io.IOException

class ApiException(errorCode: Int, message: String) : IOException(message)

class NoInternetException(message: String) : IOException(message)