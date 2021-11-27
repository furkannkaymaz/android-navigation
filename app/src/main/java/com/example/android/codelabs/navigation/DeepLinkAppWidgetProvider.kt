/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Bundle
import android.widget.RemoteViews
import androidx.navigation.NavDeepLinkBuilder


class DeepLinkAppWidgetProvider : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        val remoteViews = RemoteViews(
            context.packageName,
            R.layout.deep_link_appwidget
        )

        val args = Bundle()
        args.putString("myarg", "From Widget")

        val pendingIntent = NavDeepLinkBuilder(context)
            .setGraph(R.navigation.mobile_navigation)
            .setDestination(R.id.deeplink_dest) // (R.id.deeplink_dest bu mutlaka mobile_navigation içinde olmadı menu xml'leriindeki gibi menu idleri menu sekmesindeki
            .setArguments(args)
            .createPendingIntent()

        // widget üzerinden yöneldnrime burası

        // graph içindendeki ve yönlendirme yapılan yerdeki menu.xml gibi idler aynı olmak zorunda yoksa çalışmaz Seetigns burada örnek yukarıdan tıklanıp gidilmesi için aynı olmadı

        // burası asıl yönlendirilmenin yapıldığı yer

        remoteViews.setOnClickPendingIntent(R.id.deep_link_button, pendingIntent)

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }
}
