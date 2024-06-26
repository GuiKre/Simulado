import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

//     // private String header = "";
//     // private String nomeDoArquivo = "C:\\zGuiws\\DevM\\Simulado\\PessoasComEnderecos.csv";

     public static void main(String[] args) throws FileNotFoundException, IOException {

//         String pessoasCsv = "C:\\zGuiws\\DevM\\SimuladoPessoas.csv";
//         String enderecosCsv = "C:\\zGuiws\\DevM\\SimuladoEnderecos.csv";
//         String outputCsv = "C:\\zGuiws\\DevM\\SimuladoPessoasComEndereco.csv";

//         try (
//             BufferedReader pessoasReader = new BufferedReader(new FileReader(pessoasCsv));
//             BufferedReader enderecosReader = new BufferedReader(new FileReader(enderecosCsv));
//             BufferedWriter writer = new BufferedWriter(new FileWriter(outputCsv))
//         ) {
//             Map<String, List<String[]>> enderecosMap = new HashMap<>();

//             String line;
//             String[] pessoasHeaders = null;
//             String[] enderecosHeaders = null;

//             // Ler cabeçalho do arquivo de endereços e dados
//             if ((line = enderecosReader.readLine()) != null) {
//                 enderecosHeaders = line.split(";");
//             }
//             while ((line = enderecosReader.readLine()) != null) {
//                 String[] parts = line.split(";");
//                 String codigo = parts[2]; // Assumindo que o código é a terceira coluna
//                 enderecosMap.computeIfAbsent(codigo, k -> new ArrayList<>()).add(parts);
//             }

//             // Ler cabeçalho do arquivo de pessoas e escrever cabeçalho do arquivo de saída
//             if ((line = pessoasReader.readLine()) != null) {
//                 pessoasHeaders = line.split(";");
//                 writer.write(String.join(";", pessoasHeaders) + ";" + enderecosHeaders[0] + ";" + enderecosHeaders[1]);
//                 writer.newLine();
//             }

//             // Ler dados do arquivo de pessoas e combinar com endereços
//             while ((line = pessoasReader.readLine()) != null) {
//                 String[] pessoaParts = line.split(";");
//                 String codigo = pessoaParts[0]; // Assumindo que o código é a primeira coluna

//                 if (enderecosMap.containsKey(codigo)) {
//                     for (String[] enderecoParts : enderecosMap.get(codigo)) {
//                         writer.write(String.join(";", pessoaParts) + ";" + enderecoParts[0] + ";" + enderecoParts[1]);
//                         writer.newLine();
//                     }
//                 }
//             }

//         } catch (IOException e) {
//             System.out.println("Arquivo não encontrado.");
//         }
//     }
// }
        String arquivo1 = "C:\\zGuiws\\DevM\\Simulado\\Pessoas.csv";
        String arquivo2 = "C:\\zGuiws\\DevM\\Simulado\\Enderecos.csv";
        String arquivoFinal = "C:\\zGuiws\\DevM\\Simulado\\PessoasComEndereco.csv";

        try (
            BufferedReader reader1 = new BufferedReader(new FileReader(arquivo1));
            BufferedReader reader2 = new BufferedReader(new FileReader(arquivo2));
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoFinal));
        ) {
            String line;
            boolean isFirstLine = true;

            while((line = reader1.readLine()) != null) {
                if (!isFirstLine || !line.startsWith("codigo;nome;rua;cidade;codigo")){
                    writer.write(line);
                    writer.newLine();
                }
                isFirstLine = false;
            }

            isFirstLine = true;

            while ((line = reader2.readLine()) != null){
                if (isFirstLine){

                    isFirstLine = false;
                    continue;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Arquivo não encontrado.");
        }
    }
}