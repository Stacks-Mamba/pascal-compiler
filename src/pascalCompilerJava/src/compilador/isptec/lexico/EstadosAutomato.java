/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.lexico;

/**
 *
 * @author hairt
 */
public enum EstadosAutomato {
      NAO_ALFANUMERICO, NUM_INTEIRO, NUM_REAL_DECIMAL, NUM_REAL_EXP,
    IDENTIFICADOR, STRING, ERRO ,COMENTARIO;
}
