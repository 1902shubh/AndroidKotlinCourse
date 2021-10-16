package `in`.papaya.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name: String,
    val age: Int,
    val createdDate: Date,
    val isPresent: Int
)
