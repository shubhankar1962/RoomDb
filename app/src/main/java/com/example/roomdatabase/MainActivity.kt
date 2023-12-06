package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.roomdatabase.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = UserDatabase.getDatabase(this)
        binding.submitBtn.setOnClickListener{
           val fname = binding.fname.text.toString()
            val lname =binding.lname.text.toString()
            val phoneNo = binding.pno.text.toString()

            val user = DataClass(0,fname,lname,phoneNo)
            GlobalScope.launch {
                db.UserDao().insert(user)
            }
        }

        binding.updateBtn.setOnClickListener{
           GlobalScope.launch {
//               val data:List<DataClass> = db.UserDao().getUsers()
//               Log.e("TAG:GETData",data.toString())

               val fname = db.UserDao().getUserByFname("shub")
               Log.e("Fname", fname.fname.toString())
           }
        }

    }
}