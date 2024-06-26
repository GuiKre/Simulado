import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        String pessoasFilePath = "Pessoas.csv";
        String enderecosFilePath = "Enderecos.csv";
        String pessoasComEnderecoFilePath = "PessoasComEndereco.csv";

        List<String[]> pessoasRecords = CSVReader.readCSV(pessoasFilePath);
        List<String[]> enderecosRecords = CSVReader.readCSV(enderecosFilePath);

        Map<Integer, List<Pessoa>> pessoaMap = new HashMap<>();

        // Lê os registros de pessoas e coloca no mapa
        for (String[] record : pessoasRecords) {
            if (record[0].equals("codigo")) continue; // Pula o cabeçalho
            int codigo = Integer.parseInt(record[0]);
            String nome = record[1];
            pessoaMap.putIfAbsent(codigo, new ArrayList<>());
            pessoaMap.get(codigo).add(new Pessoa(codigo, nome, "", ""));
        }

        // Lê os registros de endereços e associa às pessoas
        List<Pessoa> pessoasComEndereco = new ArrayList<>();
        for (String[] record : enderecosRecords) {
            if (record[0].equals("rua")) continue; // Pula o cabeçalho
            String rua = record[0];
            String cidade = record[1];
            int codigo = Integer.parseInt(record[2]);

            List<Pessoa> pessoas = pessoaMap.get(codigo);
            if (pessoas != null) {
                for (Pessoa pessoa : pessoas) {
                    pessoasComEndereco.add(new Pessoa(pessoa.getCodigo(), pessoa.getNome(), rua, cidade));
                }
            }
        }

        // Cria os registros para escrever no arquivo de saída
        List<String> outputRecords = new ArrayList<>();
        outputRecords.add("codigo;nome;rua;cidade");
        for (Pessoa pessoa : pessoasComEndereco) {
            outputRecords.add(pessoa.toCSV());
        }

        // Escreve o arquivo de saída
        CSVWriter.writeCSV(pessoasComEnderecoFilePath, outputRecords);

        System.out.println("Arquivo " + pessoasComEnderecoFilePath + " gerado com sucesso!");
    }
}
// VERSIONAMENTO DE CÓDIGO 
// 1. Criar a pasta do projeto
// 2. Adicionar os arquivos
// 3. Criar o repositorio no GitHub
// 4. Abrir a pasta e executar os comandos:
// git init
// git add .  <----- todos os arquivos
// git commit -m "mensagem"

// git branch -M main
// git remote add origin (URL do servidor)
// **git config --global user.name "nome de usuario"
// **git config --global user.email "email"
// git push -u origin main

// ALTERAÇÃO DO CÓDIGO
// 1. Alterar arquivos
// 2. Abrir a pasta e executar os comandos:
// git add .
// git commit -m "nova mensagem"
// git push

// ABRIR O REPOSITÓRIO EM OUTRO PC
// git clone (URL do repositório)

// ATUALIZAR OS ARQUIVOS
// git pull