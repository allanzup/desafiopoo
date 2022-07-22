package src.desafioFinal.Pagamento


import src.desafioFinal.Menu.MenuPrincipal

class Pagamento(val carrinho: MenuPrincipal) {

    fun escolherPagamento():Boolean {
        while (true) {
            carrinho.mostrarTotal()
            println("---------------- Sincity Ifood-----------------       ")
            println("> Menu principal > Carrinho > Pagamento")
            println("------- Escolha as opções abaixo do menu -------------")
            println("Escolha a forma de pagamento")
            println("1- para pagamento em dinheiro")
            println("2- para pagamento com cartão")
            println("3- para pagamento com ticket refeição")
            println("4- Voltar")
            val opcao = lerNumero()
            if (opcao==null){continue}
            when (opcao) {
                1 -> {
                    val pago = pagarEmDinheiro()
                    if (pago) return true
                }
                2, 3 -> {
                    pagarComCartao()
                    return true
                }

                4 -> {
                    return false
                }
                else -> println("opção Invalida tente novamente")
            }

        }


    }

    private fun pagarComCartao() {
        println("Pagamento efetuado com sucesso! Bom apetite!!!")
    }

    private fun pagarEmDinheiro():Boolean {
        val valorFinal = carrinho.getvalortotal()
        println("digite o valor do pagamento")
        val dinheiro = lerNumero()
        if (dinheiro==null){return false}
        if (dinheiro < 0) {
            println("valor invalido, tente novamente!!!")
            return false
        }
        if (dinheiro < valorFinal) {
            println("valor insuficiente, tente novamente")
            return false
        }
        if (dinheiro > valorFinal) {
            val troco = dinheiro - valorFinal
            println("seu troco é de R$ $troco")
        }
        println("Pagamento efetuado com sucesso! Bom apetite!!!")
        return true
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