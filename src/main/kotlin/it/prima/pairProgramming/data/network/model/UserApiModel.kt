package it.prima.pairProgramming.data.network.model


internal data class UserApiModel(
    val id: Int,
    val name: String,
    val surname: String,
    val nickname: String
) {
    companion object Mock {
        val users = listOf(
            UserApiModel(id = 1, name = "Mario", surname = "Rossi", nickname = "mRossi"),
            UserApiModel(id = 2, name = "Mario", surname = "Bianchi", nickname = "mBianci"),
            UserApiModel(id = 2, name = "Mario", surname = "Esposito", nickname = "mEsposito"),
        )
    }
}