/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador.isptec.semantico;

/**
 *
 * @author stacks
 */

/*Classe que representa um símbolo terminal ou não terminal*/

public abstract class Symbol {
    
    protected final String name;
    
    public Symbol(String name){
        
        this.name = name;
    }
    
    
    @Override
    public String toString(){
        return this.name;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o){
      if(o.getClass()==this.getClass()){
          Symbol aux = (Symbol) o;
          return this.name.equals(aux.toString());
      }   
      return false;
    }
}
