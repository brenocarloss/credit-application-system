package me.dio.credit.applicationsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.applicationsystem.entity.Address
import me.dio.credit.applicationsystem.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO (
    @field:NotEmpty(message = "Invalid Input") val firstName: String,
    @field:NotEmpty(message = "Invalid Input")val lastName: String,
    @field:NotEmpty(message = "Invalid Input")
    @field:CPF(message = "this invalid CPF") val cpf: String,
    @field:NotNull val income: BigDecimal,
    @field:NotEmpty(message = "Invalid Input")val email: String,
    @field:NotEmpty(message = "Invalid Input")val password: String,
    @field:NotEmpty(message = "Invalid Input")val zipCode: String,
    @field:NotEmpty(message = "Invalid Input")val street: String
){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address (
            zipCode = this.zipCode,
            street = this.street
        )
    )
}

