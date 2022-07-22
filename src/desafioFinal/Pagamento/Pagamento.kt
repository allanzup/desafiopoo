package src.desafioFinal.Pagamento


import src.desafioFinal.Menu.MenuPrincipal
import kotlin.system.exitProcess

class Pagamento(val carrinho: MenuPrincipal) {
    init {
        escolherPagamento()
    }

    fun escolherPagamento() {
        while (true) {
            println("Escolha a forma de pagamento")
            println("digite 1- para pagamento em dinheiro")
            println("digite 2- para pagamento com cartão")
            println("digite 3- para pagamento com ticket refeição")
            println("digite 0- para Sair")
            val opcao = lerNumero()
            if (opcao==null){continue}
            when (opcao) {
                1 -> {
                    pagarEmDinheiro()

                }
                2, 3 -> {
                    pagarComCartao()
                    return
                }

                0 -> {
                    println("pedido cancelado")
                    exitProcess(0)
                }
                else -> println("opção Invalida tente novamente")
            }

        }


    }

    private fun pagarComCartao() {
        println("Pagamento efetuado com sucesso! Bom apetite!!!")
    }

    private fun pagarEmDinheiro() {
        val valorFinal = carrinho.mostrarTotal()
        println("digite o valor do pagamento")
        val dinheiro = lerNumero()
        if (dinheiro==null){return}
        if (dinheiro < 0) {
            println("valor invalido, tente novamente!!!")
            return
        }
        if (dinheiro < valorFinal) {
            println("valor insuficiente, tente novamente")
            return
        }
        if (dinheiro > valorFinal) {
            val troco = dinheiro - valorFinal
            println("seu troco é de R$ $troco")
        }
        println("Pagamento efetuado com sucesso! Bom apetite!!!")
        exitProcess(0)
    }
    fun lerNumero(): Int? {
        var numero: Int?
        try {
            numero = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele")
            numero = null
        }

        return numero

}}