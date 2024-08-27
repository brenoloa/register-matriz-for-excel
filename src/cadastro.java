import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cadastro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int quantidade_pessoas;

        System.out.print("Digite o número de pessoas: >>: ");
        quantidade_pessoas = scan.nextInt();
        scan.nextLine(); //reset

        String[] topo = {"Nome", "Idade", "COD"};
        String[][] pessoas = new String[quantidade_pessoas][topo.length];

        for (int i = 0; i < quantidade_pessoas; i++) {
            for (int j = 0; j < topo.length; j++) {
                System.out.print(topo[j] + ">>: ");
                pessoas[i][j] = scan.nextLine();
            }
        }

       // transf de dados
        try (FileWriter writer = new FileWriter("Cadastro.xlsx")) {
            //TOPO
            for (int j = 0; j < topo.length; j++) {
                writer.write(topo[j] + "\t");
            }
            writer.write("\n");

           // dados
            for (int i = 0; i < quantidade_pessoas; i++) {
                for (int j = 0; j < topo.length; j++) {
                    writer.write(pessoas[i][j] + "\t");
                }
                writer.write("\n");
            }

            System.out.println("concluido!.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    }
}
