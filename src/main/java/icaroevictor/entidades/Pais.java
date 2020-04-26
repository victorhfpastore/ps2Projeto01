package icaroevictor.entidades;

public class Pais {
    private int id;
    private String nome;
    private String continente;
    private long populacao;

    public Pais (){}

    public Pais (String nome, String continente, long populacao){
        this.nome=nome;
        this.continente=continente;
        this.populacao=populacao;
    }

    public String getNome (){return nome;}
    public void setNome (String nome) {this.nome = nome;}

    public String getContinente (){return continente;}
    public void setContinente (String continente) {this.continente = continente;}

    public long getPopulacao (){return populacao;}
    public void setPopulacao(long populacao) {this.populacao = populacao;}

    @Override
    public String toString() {
        return nome +
                " [Continente:" + continente +
                ", população: " + populacao + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

