package caily.jiaoye.com.changeromotatool.download

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import caily.jiaoye.com.changeromotatool.dto.OTACard

/**
 * Created by caily on 22/01/2018.
 */
class OTADownloader(otaCard: OTACard, activity: Activity) {

    private val downloadManager: DownloadManager = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    private val downloadUri: Uri = Uri.parse(otaCard.link)

    init {

    }

    private fun registry(downloadManager: DownloadManager, path: String, filename: String, uri: Uri): Long {
        val request = DownloadManager.Request(uri).apply {
            this.setDestinationInExternalPublicDir(path, filename)
            this.setDescription("Change rom OTA")
            this.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            this.setMimeType("application/zip")
            this.setVisibleInDownloadsUi(false)
        }

        return downloadManager.enqueue(request)
    }
}