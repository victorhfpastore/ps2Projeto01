package icaroevictor.entidades;

public class ContaBancaria {
    private int id;
    private String nome;
    private long saldo;
    private int agencia;

    public ContaBancaria(){

    }

    public ContaBancaria( int id, String nome, long saldo, int agencia){
        this.setId(id);
        this.setNome(nome);
        this.setSaldo(saldo);
        this.setAgencia(agencia);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return
                " ID:" + id +
                        ", NOME:" + nome +
                        ", SALDO: " + saldo +
                        ", AGÊNCIA:" + agencia;
    }
}
