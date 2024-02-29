package com.example.segunda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView


class TaskListFragment : Fragment() {


    private val adapter: TaskListAdpater by lazy {

        TaskListAdpater(::openTaskListDetail)
    }

    private val viewModel: TaskListViewModel by lazy {

        TaskListViewModel.create(requireActivity().application)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.activity_task_list_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvTasks: RecyclerView = view.findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter



    }

    override fun onStart() {
        super.onStart()
        listFromDataBase()
    }



    private fun listFromDataBase() { // esse pega todas as listas e atualiza no adapter

        val listObserver = Observer<List<Task>> { listTasks ->
            //obeserver

            if (listTasks.isEmpty()) {


            } else {


            }
            adapter.submitList(listTasks)
        }
        //livedata
        viewModel.taskListLiveData.observe(this, listObserver)

    }
    private fun openTaskListDetail(task: Task) {

        val intent = MainActivity2.start(requireContext(), task)
        requireActivity().startActivity(intent)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         * @return A new instance of fragment TaskListFragment.
         */
        //
        @JvmStatic
        fun newInstance() =
            TaskListFragment()
    }
}