package br.com.mobile.enums;

public enum PageEnum {

	LOGAR("logar"),
	INICIAL("inicial"),
	PESQUISA("pesquisa"),
	CONTINUAR("continuar");
	
    private String descricao;
	 
    PageEnum(String descricao) {
        this.descricao = descricao;
    }
 
    public String get() {
        return descricao;
    }

}
