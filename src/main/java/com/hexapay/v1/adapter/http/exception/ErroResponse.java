package com.hexapay.v1.adapter.http.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ErroResponse {

    private List<String> mensagens = new ArrayList<>();
    private String erro;
    private int codigo;
    private Date timestamp;
    private String path;

    public ErroResponse() {
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<String> mensagens) {
        this.mensagens = mensagens;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
