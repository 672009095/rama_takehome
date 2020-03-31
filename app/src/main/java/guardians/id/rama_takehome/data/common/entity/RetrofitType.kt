package guardians.id.rama_takehome.data.common.entity

enum class RetrofitType (val value: String){
    DEFAULT("RETROFIT_DEFAULT"), // this retrofit type if not use TOKEN or header
    USE_TOKEN("RETROFIT_USE_TOKEN") // this retrofit type if use token
}