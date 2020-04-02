package com.apache.model;

public class AccountInfo {

  private String nome;
  private String cpf;
  private String status;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "AccountInfo{" +
        "nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", status='" + status + '\'' +
        '}';
  }
}
