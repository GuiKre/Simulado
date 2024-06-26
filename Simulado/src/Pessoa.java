public class Pessoa {

    private int codigo;
    private String nome;
    private String rua;
    private String cidade;

    public Pessoa(String cidade, int codigo, String nome, String rua) {
        this.cidade = cidade;
        this.codigo = codigo;
        this.nome = nome;
        this.rua = rua;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pessoa{");
        sb.append("codigo=").append(codigo);
        sb.append(", nome=").append(nome);
        sb.append(", rua=").append(rua);
        sb.append(", cidade=").append(cidade);
        sb.append('}');
        return sb.toString();
    }

    public String toCSV() {
        return codigo + ";" + nome + ";" + rua + ";" + cidade;
    }

}
