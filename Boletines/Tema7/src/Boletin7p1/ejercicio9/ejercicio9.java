package Boletin7p1.ejercicio9;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejercicio9 {

    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\adrik\\IdeaProjects\\Programacion\\Boletines\\Tema7\\src\\Boletin7p1\\ejercicio9\\matriculas.txt");
        File destinatario = new File("C:\\Users\\adrik\\IdeaProjects\\Programacion\\Boletines\\Tema7\\src\\Boletin7p1\\ejercicio9\\matriculascorrectas.txt");
        if (!destinatario.exists()){
            try{
                destinatario.createNewFile();
            }catch (IOException e){
                System.out.println("Se ha producido un error: " + e.getMessage());
            }

        }

        Pattern p = Pattern.compile("\"^\\p{L}+\\s(\\d{4})-([a-z&&[^aeiou]]{3})$\"gm");

        try (
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destinatario))
        )
        {;
            String l;
            br.readLine();
            while ((l = br.readLine()) != null){
                Matcher m = p.matcher(l);
                if (m.find()){
                    bw.write(m.group(1));
                    bw.write("\n");
                }
            }
        }catch (IOException e){
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

    }
}
