package com.LuanaPinCruz.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var expressao = ""
    var reset = false
    var erro = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lblNumeros = findViewById<TextView>(R.id.lblNumeros)
        val buttonVirgula = findViewById<Button>(R.id.buttonVirgula)
        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val buttonSoma = findViewById<Button>(R.id.buttonSoma)
        val buttonSubtracao = findViewById<Button>(R.id.buttonSubtracao)
        val buttonMultiplicacao = findViewById<Button>(R.id.buttonMultiplicacao)
        val buttonDivisao = findViewById<Button>(R.id.buttonDivisao)
        val buttonIgual = findViewById<Button>(R.id.buttonIgual)
        val buttonApagar = findViewById<Button>(R.id.buttonApagar)

        // números
        fun adicionarNumeros(n: String) {
            lblNumeros.text = lblNumeros.text.toString() + n
        }

        fun resetar(){
            if (reset){
                lblNumeros.text = ""
                reset = false
            }
        }

        button0.setOnClickListener { resetar(); adicionarNumeros("0") }
        button1.setOnClickListener { resetar(); adicionarNumeros("1") }
        button2.setOnClickListener { resetar(); adicionarNumeros("2") }
        button3.setOnClickListener { resetar(); adicionarNumeros("3") }
        button4.setOnClickListener { resetar(); adicionarNumeros("4") }
        button5.setOnClickListener { resetar(); adicionarNumeros("5") }
        button6.setOnClickListener { resetar(); adicionarNumeros("6") }
        button7.setOnClickListener { resetar(); adicionarNumeros("7") }
        button8.setOnClickListener { resetar(); adicionarNumeros("8") }
        button9.setOnClickListener { resetar(); adicionarNumeros("9") }

        // vírgula (ponto)
        buttonVirgula.setOnClickListener{
            val texto = lblNumeros.text.toString()
            var temVirgula = false

            for (c in texto){
                if (c == '.'){
                    temVirgula = true
                }
            }

            if (texto.isEmpty()){
                temVirgula = true
            }

            if (!temVirgula){
                lblNumeros.text = texto + '.'
            }
        }

        // operador
        fun adicionarOperador(op: String) {
            val texto = lblNumeros.text.toString()
            if (texto != "") {
                expressao += texto + op
                lblNumeros.text = ""
            }
        }

        buttonSoma.setOnClickListener { adicionarOperador("+") }
        buttonSubtracao.setOnClickListener { adicionarOperador("-") }
        buttonMultiplicacao.setOnClickListener { adicionarOperador("*") }
        buttonDivisao.setOnClickListener { adicionarOperador("/") }

        // apagar
        buttonApagar.setOnClickListener {
            lblNumeros.text = ""
            expressao = ""
        }

        // igual
        buttonIgual.setOnClickListener {
            reset = true

            if (lblNumeros.text.toString() != "") {
                expressao += lblNumeros.text.toString()
            }

            var texto = expressao

            if (texto != "") {

                // MULT E DIV
                var i = 0
                while (i < texto.length) {

                    if (texto[i] == '*' || texto[i] == '/') {

                        var inicio = i - 1
                        while (inicio >= 0 &&
                            texto[inicio] != '+' &&
                            texto[inicio] != '-' &&
                            texto[inicio] != '*' &&
                            texto[inicio] != '/') {
                            inicio--
                        }
                        inicio++

                        var fim = i + 1
                        while (fim < texto.length &&
                            texto[fim] != '+' &&
                            texto[fim] != '-' &&
                            texto[fim] != '*' &&
                            texto[fim] != '/') {
                            fim++
                        }

                        val num1 = texto.substring(inicio, i).toDouble()
                        val num2 = texto.substring(i + 1, fim).toDouble()

                        val parcial = if (texto[i] == '*') {
                            num1 * num2
                        } else {
                            if (num2 == 0.0) {
                                erro = true
                                break
                            } else {
                                num1 / num2
                            }
                        }

                        val resultado = if (parcial % 1.0 == 0.0) {
                            parcial.toInt().toString()
                        } else {
                            parcial.toString()
                        }

                        texto = texto.substring(0, inicio) +
                                resultado +
                                texto.substring(fim)

                        i = -1
                    }

                    i++
                }

                if (erro) {
                    lblNumeros.text = "Erro"
                    expressao = ""
                    erro = false
                    return@setOnClickListener
                }

                // SOMA E SUB
                i = 0
                while (i < texto.length) {

                    if (texto[i] == '+' || texto[i] == '-') {

                        var inicio = i - 1
                        while (inicio >= 0 &&
                            texto[inicio] != '+' &&
                            texto[inicio] != '-' &&
                            texto[inicio] != '*' &&
                            texto[inicio] != '/') {
                            inicio--
                        }
                        inicio++

                        var fim = i + 1
                        while (fim < texto.length &&
                            texto[fim] != '+' &&
                            texto[fim] != '-' &&
                            texto[fim] != '*' &&
                            texto[fim] != '/') {
                            fim++
                        }

                        val num1 = texto.substring(inicio, i).toDouble()
                        val num2 = texto.substring(i + 1, fim).toDouble()

                        val parcial = if (texto[i] == '+') {
                            num1 + num2
                        } else {
                            num1 - num2
                        }

                        val resultado = if (parcial % 1.0 == 0.0) {
                            parcial.toInt().toString()
                        } else {
                            parcial.toString()
                        }

                        texto = texto.substring(0, inicio) +
                                resultado +
                                texto.substring(fim)

                        i = -1
                    }

                    i++
                }

                lblNumeros.text = texto
                expressao = ""
            }
        }
    }
}