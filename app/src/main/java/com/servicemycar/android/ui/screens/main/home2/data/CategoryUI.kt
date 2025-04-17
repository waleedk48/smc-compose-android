package com.servicemycar.android.ui.screens.main.home2.data

import com.servicemycar.android.R
import com.servicemycar.android.models.ServiceModel

data class CategoryUI(
    val iconRes:Int,
    val title:String,
)




 val staticCategories = listOf(
     CategoryUI(
         title = "Services",
         iconRes = R.drawable.car_service
     ),
     CategoryUI(
         title = "Mobile",
        iconRes = R.drawable.repair_truck
     ),
     CategoryUI(
         title =  "Roadside",
         iconRes = R.drawable.rsa
     ),
     CategoryUI(
         title =  "Contracts",
        iconRes = R.drawable.contracts
     ),
     CategoryUI(
         title =  "Repairs",
         iconRes = R.drawable.repairs
     ),
//     CategoryUI(
//         title =  "Subs",
//         iconRes = R.drawable.subscription
//     ),

 )

val staticServices = listOf(
    ServiceModel(id = "1", name = "Basic Service", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
    ServiceModel(id = "2", name = "Full Service", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
    ServiceModel(id = "3", name = "Major Service", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
    ServiceModel(id = "3", name = "Major Service", imgUrl = "https://static.vecteezy.com/system/resources/previews/048/736/708/non_2x/car-repair-icon-png.png"),
    ServiceModel(id = "3", name = "Air Filters", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
    ServiceModel(id = "3", name = "Spark Plugs", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
    ServiceModel(id = "3", name = "Tyres Service", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
    ServiceModel(id = "3", name = "Major Service", imgUrl = "https://png.pngtree.com/png-vector/20220526/ourmid/pngtree-car-service-illustration-repair-auto-png-image_4724953.png"),
)