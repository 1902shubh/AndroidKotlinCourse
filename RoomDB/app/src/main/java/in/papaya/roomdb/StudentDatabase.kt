package `in`.papaya.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 2)
@TypeConverters(Convertor::class)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDAO

    companion object {

        val migration_1_2 = object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN isPresent INTEGER NOT NULL DEFAULT(1)")
            }
        }

        @Volatile
        private var INSTANCE: StudentDatabase? = null


        fun getDatabase(context: Context): StudentDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        StudentDatabase::class.java,
                        "studentDB"
                    )
                        .addMigrations(migration_1_2)
                        .build()
                }
            }

            return INSTANCE!!
        }
    }

}