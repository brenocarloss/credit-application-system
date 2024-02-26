package me.dio.credit.applicationsystem.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.applicationsystem.entity.Credit
import me.dio.credit.applicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO (
    @field:NotNull(message = "Invalid Input") val crediValue: BigDecimal,
    @field:Future val dayFistOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
){

    fun toEntity(): Credit = Credit(
        creditValue = this.crediValue,
        dayFirstInstallment = this.dayFistOfInstallment,
        numberOfInstallment = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
