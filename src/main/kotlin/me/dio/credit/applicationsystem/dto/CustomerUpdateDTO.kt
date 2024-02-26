package me.dio.credit.applicationsystem.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.applicationsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDTO(
    @field:NotEmpty(message = "Invalid Input") val firstName: String,
    @field:NotEmpty(message = "Invalid Input") val lastName: String,
    @field:NotNull(message = "Invalid Input") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid Input") val zipCode: String,
    @field:NotEmpty(message = "Invalid Input") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }
}
