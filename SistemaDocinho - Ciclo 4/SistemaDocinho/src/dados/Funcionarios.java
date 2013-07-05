/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author Lucas
 */
public class Funcionarios 
{
    String Login;
    String Senha;
    String Nome;
    String CPF;
    String Telefone;
    String Email;


    public Funcionarios(String Login, String Senha, String Nome, String CPF, String Telefone, String Email) {
        this.Login = Login;
        this.Senha = setSenha();
        this.Nome = Nome;
        this.CPF = CPF;
        this.Telefone = Telefone;
        this.Email = setEmail();
    }
    
 private String setSenha()
 {
     String senha;
     senha = "docinho123";
     return senha;
 }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    private String setEmail() {
        String email;
        email = getNome()+"@docinho.com.br";
        return email;
    }
}