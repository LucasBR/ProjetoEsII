/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Clientes {

    public Integer codigo;
    public String Pessoa;
    public String CPF_CNPJ;
    public String NomeCompleto;
    public String TelefoneResidencial;
    public String TelefoneCelular;
    public String TelefoneComercial;
    public String TelefoneComercial_Ramal;
    public String Email;

    public Clientes(Integer nCod, String nCPFCNPJ, String nNome, String nTelR, String nTelC, String nTelCo, String nEmail) {
        this.codigo = nCod;
        this.CPF_CNPJ = nCPFCNPJ;
        this.NomeCompleto = nNome;
        this.TelefoneResidencial = nTelR;
        this.TelefoneCelular = nTelC;
        this.TelefoneComercial = nTelCo;
        this.Email = nEmail;
    }

    public Clientes(String Pessoa, String CPF_CNPJ, String NomeCompleto, String TelefoneResidencial, String TelefoneCelular, String TelefoneComercial, String TelefoneComercial_Ramal, String Email) {
        this.Pessoa = Pessoa;
        this.CPF_CNPJ = CPF_CNPJ;
        this.NomeCompleto = NomeCompleto;
        this.TelefoneResidencial = TelefoneResidencial;
        this.TelefoneCelular = TelefoneCelular;
        this.TelefoneComercial = TelefoneComercial;
        this.TelefoneComercial_Ramal = TelefoneComercial_Ramal;
        this.Email = Email;
    }
    
    

    public String getTelefoneComercial_Ramal() {
        return TelefoneComercial_Ramal;
    }

    public void setTelefoneComercial_Ramal(String TelefoneComercial_Ramal) {
        this.TelefoneComercial_Ramal = TelefoneComercial_Ramal;
    }

    public String getPessoa() {
        return Pessoa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getTelefoneResidencial() {
        return TelefoneResidencial;
    }

    public void setTelefoneResidencial(String TelefoneResidencial) {
        this.TelefoneResidencial = TelefoneResidencial;
    }

    public String getTelefoneCelular() {
        return TelefoneCelular;
    }

    public void setTelefoneCelular(String TelefoneCelular) {
        this.TelefoneCelular = TelefoneCelular;
    }

    public String getTelefoneComercial() {
        return TelefoneComercial;
    }

    public void setTelefoneComercial(String TelefoneComercial) {
        this.TelefoneComercial = TelefoneComercial;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
