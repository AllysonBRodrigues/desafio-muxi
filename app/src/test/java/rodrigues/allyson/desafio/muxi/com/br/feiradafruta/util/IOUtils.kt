package rodrigues.allyson.desafio.muxi.com.br.feiradafruta.util

import okio.Okio
import java.io.IOException
import java.nio.charset.Charset

//
// Created by Allyson Rodrigues on 17/01/18.

/*
 * Copyright (C) 2018 Infoglobo All rights reserved.
 *
 * Mobile  Division, Infoglobo.
 *
 * This software and its documentation are confidential and proprietary
 * information of InfoGlobo  No part of the software and
 * documents may be copied, reproduced, transmitted, translated, or reduced to
 * any electronic medium or machine-readable form without the prior written
 * consent of Infoglobo.
 *
 * Infoglobo makes no representations with respect to the contents,
 * and assumes no responsibility for any errors that might appear in the
 * software and documents. This publication and the contents hereof are subject
 * to change without notice.
 */
object IOUtils {

    @Throws(IOException::class)
    fun readStringFromResourcePath(path: String): String {
        val input = IOUtils::class.java.classLoader.getResourceAsStream(path)
        val bufferedSource = Okio.buffer(Okio.source(input))
        return bufferedSource.readString(Charset.defaultCharset())
    }


}