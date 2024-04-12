package com.example.recyclerview.data

class DataSource {
    //Singleton 생성
    companion object {
        private var INSTANCE: DataSource? = null
        fun getDataSource(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getFlowerList(): List<Flower> {
        return flowerList()
    }

    /* Returns flower given an ID. */
    fun getFlowerForId(id: Long): Flower {
       flowerList().let { flowers ->
            return flowers.first{ it.id == id}
        }
    }
}