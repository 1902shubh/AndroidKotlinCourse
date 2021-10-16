package `in`.papaya.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: StudentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = StudentDatabase.getDatabase(this)

        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0, "Shubham Pandey", 20, Date(), 1))
        }

        database.studentDao().getAllStudent().observe(this, {
            Log.d("ROOMDB", "onCreate: $it")
        })

    }
}