package waheed.kotlinmvvm.viewmodelscommunication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerOne, FragmentOne.newInstance())
                .commitNow()
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerTwo, FragmentTwo.newInstance())
                .commitNow()
        }


        /**
         *  create view model with activity context
         */
        viewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        viewModel.data().observe(this, Observer {
                Toast.makeText(this, "From Activity $it", Toast.LENGTH_SHORT).show()
        })
    }

}
