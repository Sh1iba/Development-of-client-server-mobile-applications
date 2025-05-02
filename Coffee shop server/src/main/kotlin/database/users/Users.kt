package com.example.database.users

import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Users : Table("users") {
    private val login = varchar("login",25)
    private val password = varchar("password",25)
    private val username = varchar("username",30)
    private val email = varchar("email",50)

    fun insert(userDTO: UserDTO) {
        transaction {
            insert{
                it[login] = userDTO.login
                it[password] = userDTO.password
                it[username] = userDTO.username
                it[email] = userDTO.email ?: ""
            }
        }
    }

    fun fetchUser(login : String) : UserDTO? {
        return try {
            transaction {
                Users.selectAll().adjustWhere {
                    Users.login eq login }.singleOrNull()?.let { row ->
                        UserDTO(
                            login = row[Users.login],
                            password = row[Users.password],
                            username = row[Users.username],
                            email = row[Users.email]
                        )
                }
            }
        } catch (e : Exception){
            null
        }
    }
}