
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class Desafio3 {
    public static void main(String[] args) {

        String filePath = "src/resources/faturamento.json";
        try {
            FileReader reader = new FileReader(filePath);
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            reader.close();

            JsonArray faturamentoArray = jsonObject.getAsJsonArray("faturamento");
            double menor = Double.MAX_VALUE;
            double maior = Double.MIN_VALUE;
            double soma = 0.0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentoArray.size(); i++) {
                JsonObject dia = faturamentoArray.get(i).getAsJsonObject();
                double valor = dia.get("valor").getAsDouble();
                if (valor > 0) {
                    if (valor < menor){
                        menor = valor;
                    }
                    if (valor > maior){
                        maior = valor;
                    }
                    soma += valor;
                    diasComFaturamento++;
                }
            }
            double media = soma / diasComFaturamento;
            int diasAcimaDaMedia = 0;
            for (int i = 0; i < faturamentoArray.size(); i++) {
                JsonObject dia = faturamentoArray.get(i).getAsJsonObject();
                double valor = dia.get("valor").getAsDouble();

                if (valor > media) diasAcimaDaMedia++;
            }

            System.out.println("Menor valor de faturamento: " + menor);
            System.out.println("Maior valor de faturamento: " + maior);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}