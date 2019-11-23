package waheed.kotlinmvvm.viewmodelscommunication

import android.content.Context
import android.widget.Toast

/**
 * Created by Waheed on 23,November,2019
 */

object ToastUtil {

    fun show(context: Context?, message: String) {
        if (context == null) return
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}