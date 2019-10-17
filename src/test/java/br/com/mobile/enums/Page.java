package br.com.mobile.enums;

public enum Page {

	LOGAR("logar"),
	INICIAL("inicial"),
	PESQUISA("pesquisa"),
	CONTINUAR("continuar");
	
    private String descricao;
	 
    Page(String descricao) {
        this.descricao = descricao;
    }
 
    public String get() {
        return descricao;
    }

}
