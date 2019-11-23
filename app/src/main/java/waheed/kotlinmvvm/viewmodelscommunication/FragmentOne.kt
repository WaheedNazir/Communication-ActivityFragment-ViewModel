package waheed.kotlinmvvm.viewmodelscommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_two.view.*

class FragmentOne : Fragment() {

    companion object {
        fun newInstance() = FragmentOne()
    }

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_one, container, false)


        /**
         *  create view model with activity context
         */
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(SharedViewModel::class.java)
        }

        viewModel.data().observe(this, Observer {
            if (!it.isBlank())
                rootView.message.text = it
        })

        rootView.post_button.setOnClickListener {
            val input = rootView.input_one.text.toString()
            if (!input.isBlank()) {
                viewModel.updateData(input)
            } else {
                ToastUtil.show(context, "Please enter message to post")
            }
        }

        return rootView
    }


}
