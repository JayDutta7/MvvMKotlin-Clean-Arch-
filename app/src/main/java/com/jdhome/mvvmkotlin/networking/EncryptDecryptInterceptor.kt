package com.jdhome.mvvmkotlin.networking

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import timber.log.Timber
import java.nio.charset.Charset
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec


class EncryptDecryptInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /* companion object {
         private const val CIPHER_NAME = "AES/CBC/PKCS5PADDING"
         private const val CIPHER_KEY_LEN = 16 //128 bits
         private const val CHARSET_NAME = "ISO-8859-1"
         private const val ALGORITHM = "AES"
     }

     override fun intercept(chain: Interceptor.Chain): Response = chain
         .run {
             proceed(request())
         }
         .let { response ->
             return@let if (response.isSuccessful) {
                 val body = response.body()!!

                 val contentType = body.contentType()
                 val charset = contentType?.charset() ?: Charset.defaultCharset()
                 val buffer = body.source().apply { request(Long.MAX_VALUE) }.buffer()
                 val bodyContent = buffer.clone().readString(charset)

                 response.newBuilder()
                     .body(ResponseBody.create(contentType, bodyContent.let(::decryptBody)))
                     .build()
             } else
                 response
         }

     private fun decryptBody(content: String): String {
         //decryption
         return content
     }

     private fun decryptBody(data: String): String? {
         var keYY =""


         try {

             when {
                 keYY.length < CIPHER_KEY_LEN -> {
                     val numPad = CIPHER_KEY_LEN - keYY.length

                     for (i in 0 until numPad) {
                         keYY += "0" //0 pad to len 16 bytes
                     }

                 }
                 keYY.length > CIPHER_KEY_LEN -> keYY =
                     keYY.substring(0, CIPHER_KEY_LEN) //truncate to 16 bytes
                 else -> Timber.e("""${keYY.length}""")
             }

             val parts = data.split(":".toRegex()).dropLastWhile {
                 it.isEmpty()
                 }.toTypedArray()

             val iv = IvParameterSpec(Base64.decode(parts[1], Base64.DEFAULT))
             val skeySpec = SecretKeySpec(keYY.toByteArray(charset(CHARSET_NAME)), ALGORITHM)

             val cipher = Cipher.getInstance(CIPHER_NAME)
             cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv)

             val decodedEncryptedData = Base64.decode(parts[0], Base64.DEFAULT)

             val original = cipher.doFinal(decodedEncryptedData)

             return String(original)

         } catch (ex: Exception) {
             ex.printStackTrace()
         }

         return data
     }

     fun encryptedBody(data: String): String? {

         var key = ""
         try {
             when {
                 key.length < CIPHER_KEY_LEN -> {
                     val numPad = CIPHER_KEY_LEN - key.length

                     for (i in 0 until numPad) {
                         key += "0" //0 pad to len 16 bytes
                     }

                 }
                 key.length > CIPHER_KEY_LEN -> key =
                     key.substring(0, CIPHER_KEY_LEN) //truncate to 16 bytes
             }


             val initVector = IvParameterSpec(CHARSET_NAME.toByteArray())
             val skeySpec = SecretKeySpec(CHARSET_NAME.toByteArray(), ALGORITHM)

             val cipher = Cipher.getInstance(CIPHER_NAME)
             cipher.init(Cipher.ENCRYPT_MODE, skeySpec, initVector)

             val encryptedData = cipher.doFinal(data.toByteArray())

             val base64EncryptedData = Base64.encodeToString(encryptedData, Base64.DEFAULT)
             val base64IV = Base64.encodeToString(CHARSET_NAME.toByteArray(), Base64.DEFAULT)

             return "$base64EncryptedData:$base64IV"

         } catch (ex: Exception) {
             ex.printStackTrace()
         }


         return null
     }



 */}